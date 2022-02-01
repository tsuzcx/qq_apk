package com.tencent.mobileqq.qqgamepub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListReq;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.flutter.router.PageRouterBuilder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameMsgParser;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService.GameBaseInfo;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.AppSubscribeInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.GetSubscribeInfoReq;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.GetSubscribeInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.GetSubscribeListReq;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.SetSubscribeStatusReq;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.SetSubscribeStatusRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameSubscribeBusEvent;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import com.tencent.mobileqq.qqgamepub.view.QQGameGrayTipsView;
import com.tencent.mobileqq.qqgamepub.view.QQGameSubscribeInfoView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class QQGameSubscribeServiceImpl
  implements IQQGameSubscribeService
{
  public static final String CMD_GET_SUBSCRIBE_INFO = "/v1/97";
  public static final String CMD_GET_SUBSCRIBE_LIST = "/v1/96";
  public static final String CMD_SET_SUBSCRIBE_STATUS = "/v1/95";
  public static final int GAME_INFO_VIEW_HEIGHT_DP = 80;
  private static final String TAG = "QQGamePub_QQGameSubscribeServiceImpl";
  private AppRuntime mApp;
  private final HashMap<String, IQQGameSubscribeService.GameBaseInfo> mGameBaseInfoMap = new HashMap();
  private final WadlTrpcListener mSubscribeListener = new QQGameSubscribeServiceImpl.3(this);
  private final ArrayList<QQGamePubSubscribe.AppSubscribeInfo> mSubscribedList = new ArrayList();
  private final HashSet<String> sCmdSet = new QQGameSubscribeServiceImpl.2(this);
  
  public QQGameSubscribeServiceImpl()
  {
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.mSubscribeListener);
  }
  
  private void handleGetSubscribeInfoRsp(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    paramIntent = new ArrayList();
    if ((paramLong == 0L) && (paramTrpcInovkeRsp != null) && (paramTrpcInovkeRsp.data.get() != null)) {
      try
      {
        QQGamePubSubscribe.GetSubscribeInfoRsp localGetSubscribeInfoRsp = new QQGamePubSubscribe.GetSubscribeInfoRsp();
        localGetSubscribeInfoRsp.mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
        paramIntent.addAll(localGetSubscribeInfoRsp.app_list.get());
        paramTrpcInovkeRsp = new QQGameSubscribeBusEvent(2);
        if ((paramIntent.size() > 0) && (paramIntent.get(0) != null))
        {
          paramTrpcInovkeRsp.subscribeInfo = ((QQGamePubSubscribe.AppSubscribeInfo)paramIntent.get(0));
          SimpleEventBus.getInstance().dispatchEvent(paramTrpcInovkeRsp);
        }
      }
      catch (Exception paramTrpcInovkeRsp)
      {
        QLog.e("QQGamePub_QQGameSubscribeServiceImpl", 1, paramTrpcInovkeRsp, new Object[0]);
      }
    }
    if (QLog.isColorLevel())
    {
      paramTrpcInovkeRsp = new StringBuilder();
      paramTrpcInovkeRsp.append("handleGetSubscribeInfoRsp...cmd:");
      paramTrpcInovkeRsp.append(paramString);
      paramTrpcInovkeRsp.append(",ret:");
      paramTrpcInovkeRsp.append(paramLong);
      paramTrpcInovkeRsp.append(",subscribeInfoList:");
      paramTrpcInovkeRsp.append(paramIntent.size());
      QLog.i("QQGamePub_QQGameSubscribeServiceImpl", 2, paramTrpcInovkeRsp.toString());
    }
  }
  
  /* Error */
  private void handleGetSubscribeListRsp(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    // Byte code:
    //   0: lload_3
    //   1: lconst_0
    //   2: lcmp
    //   3: ifne +146 -> 149
    //   6: aload 5
    //   8: ifnull +141 -> 149
    //   11: aload 5
    //   13: getfield 98	com/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp:data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   16: invokevirtual 104	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   19: ifnull +130 -> 149
    //   22: new 199	com/tencent/mobileqq/qqgamepub/data/QQGamePubSubscribe$GetSubscribeListRsp
    //   25: dup
    //   26: invokespecial 200	com/tencent/mobileqq/qqgamepub/data/QQGamePubSubscribe$GetSubscribeListRsp:<init>	()V
    //   29: astore_1
    //   30: aload_1
    //   31: aload 5
    //   33: getfield 98	com/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp:data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   36: invokevirtual 104	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   39: invokevirtual 113	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   42: invokevirtual 201	com/tencent/mobileqq/qqgamepub/data/QQGamePubSubscribe$GetSubscribeListRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   45: pop
    //   46: aload_0
    //   47: getfield 44	com/tencent/mobileqq/qqgamepub/api/impl/QQGameSubscribeServiceImpl:mSubscribedList	Ljava/util/ArrayList;
    //   50: astore 5
    //   52: aload 5
    //   54: monitorenter
    //   55: aload_0
    //   56: getfield 44	com/tencent/mobileqq/qqgamepub/api/impl/QQGameSubscribeServiceImpl:mSubscribedList	Ljava/util/ArrayList;
    //   59: invokevirtual 204	java/util/ArrayList:clear	()V
    //   62: aload_0
    //   63: getfield 44	com/tencent/mobileqq/qqgamepub/api/impl/QQGameSubscribeServiceImpl:mSubscribedList	Ljava/util/ArrayList;
    //   66: aload_1
    //   67: getfield 207	com/tencent/mobileqq/qqgamepub/data/QQGamePubSubscribe$GetSubscribeListRsp:subscribe_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   70: invokevirtual 126	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   73: invokevirtual 208	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   76: pop
    //   77: invokestatic 156	com/tencent/biz/richframework/eventbus/SimpleEventBus:getInstance	()Lcom/tencent/biz/richframework/eventbus/SimpleEventBus;
    //   80: new 134	com/tencent/mobileqq/qqgamepub/data/QQGameSubscribeBusEvent
    //   83: dup
    //   84: iconst_1
    //   85: invokespecial 137	com/tencent/mobileqq/qqgamepub/data/QQGameSubscribeBusEvent:<init>	(I)V
    //   88: invokevirtual 160	com/tencent/biz/richframework/eventbus/SimpleEventBus:dispatchEvent	(Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;)V
    //   91: aload_0
    //   92: getfield 44	com/tencent/mobileqq/qqgamepub/api/impl/QQGameSubscribeServiceImpl:mSubscribedList	Ljava/util/ArrayList;
    //   95: invokevirtual 209	java/util/ArrayList:size	()I
    //   98: istore 6
    //   100: iload 6
    //   102: istore 7
    //   104: aload 5
    //   106: monitorexit
    //   107: goto +45 -> 152
    //   110: iload 6
    //   112: istore 7
    //   114: aload 5
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    //   119: astore_1
    //   120: goto +15 -> 135
    //   123: astore_1
    //   124: iload 7
    //   126: istore 6
    //   128: goto -18 -> 110
    //   131: astore_1
    //   132: iconst_0
    //   133: istore 6
    //   135: ldc 22
    //   137: iconst_1
    //   138: aload_1
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   146: goto +6 -> 152
    //   149: iconst_0
    //   150: istore 6
    //   152: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +61 -> 216
    //   158: new 172	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   165: astore_1
    //   166: aload_1
    //   167: ldc 211
    //   169: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_1
    //   174: aload_2
    //   175: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_1
    //   180: ldc 181
    //   182: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload_1
    //   187: lload_3
    //   188: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_1
    //   193: ldc 213
    //   195: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_1
    //   200: iload 6
    //   202: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: ldc 22
    //   208: iconst_2
    //   209: aload_1
    //   210: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 197	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: return
    //   217: astore_1
    //   218: iconst_0
    //   219: istore 6
    //   221: goto -111 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	QQGameSubscribeServiceImpl
    //   0	224	1	paramIntent	Intent
    //   0	224	2	paramString	String
    //   0	224	3	paramLong	long
    //   0	224	5	paramTrpcInovkeRsp	TrpcProxy.TrpcInovkeRsp
    //   98	122	6	i	int
    //   102	23	7	j	int
    // Exception table:
    //   from	to	target	type
    //   117	119	119	java/lang/Exception
    //   104	107	123	finally
    //   114	117	123	finally
    //   22	55	131	java/lang/Exception
    //   55	100	217	finally
  }
  
  private void handleSetSubscribeStatusRsp(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    ArrayList localArrayList = new ArrayList();
    long l1 = 0L;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramLong == 0L)
    {
      localObject1 = localObject3;
      if (paramTrpcInovkeRsp != null)
      {
        localObject1 = localObject3;
        if (paramTrpcInovkeRsp.data.get() == null) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new QQGamePubSubscribe.SetSubscribeStatusRsp();
        ((QQGamePubSubscribe.SetSubscribeStatusRsp)localObject1).mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
        localArrayList.addAll(((QQGamePubSubscribe.SetSubscribeStatusRsp)localObject1).app_list.get());
        if ((localArrayList.size() > 0) && (localArrayList.get(0) != null))
        {
          paramTrpcInovkeRsp = (QQGamePubSubscribe.AppSubscribeInfo)localArrayList.get(0);
          try
          {
            updateSubscribedListOnSetStatusRsp(paramTrpcInovkeRsp);
            if (paramIntent == null) {
              break label424;
            }
            i = paramIntent.getIntExtra("qqgame_msg_scene_key", 1);
            j = i;
            long l2 = l1;
            try
            {
              l1 = paramIntent.getLongExtra("set_subscribe_seq_key", 0L);
              if (i != 1) {
                break label430;
              }
              k = 4;
              j = i;
              l2 = l1;
              paramIntent = new QQGameSubscribeBusEvent(k);
              j = i;
              l2 = l1;
              paramIntent.subscribeInfo = paramTrpcInovkeRsp;
              j = i;
              l2 = l1;
              paramIntent.seq = l1;
              j = i;
              l2 = l1;
              SimpleEventBus.getInstance().dispatchEvent(paramIntent);
            }
            catch (Exception localException1)
            {
              paramIntent = paramTrpcInovkeRsp;
              l1 = l2;
              paramTrpcInovkeRsp = localException1;
              continue;
            }
            paramTrpcInovkeRsp = null;
          }
          catch (Exception localException2)
          {
            paramIntent = paramTrpcInovkeRsp;
            paramTrpcInovkeRsp = localException2;
          }
        }
        else
        {
          i = 1;
        }
        paramIntent = paramTrpcInovkeRsp;
      }
      catch (Exception paramTrpcInovkeRsp)
      {
        paramIntent = localObject2;
        int j = 1;
        QLog.e("QQGamePub_QQGameSubscribeServiceImpl", 1, paramTrpcInovkeRsp, new Object[0]);
        i = j;
      }
      Intent localIntent = paramIntent;
      if (QLog.isColorLevel())
      {
        paramTrpcInovkeRsp = new StringBuilder();
        paramTrpcInovkeRsp.append("handleSetSubscribeStatusRsp...cmd:");
        paramTrpcInovkeRsp.append(paramString);
        paramTrpcInovkeRsp.append(",ret:");
        paramTrpcInovkeRsp.append(paramLong);
        paramTrpcInovkeRsp.append(",scene:");
        paramTrpcInovkeRsp.append(i);
        paramTrpcInovkeRsp.append(",seq:");
        paramTrpcInovkeRsp.append(l1);
        QLog.i("QQGamePub_QQGameSubscribeServiceImpl", 2, paramTrpcInovkeRsp.toString());
        localIntent = paramIntent;
      }
      if (localIntent == null)
      {
        paramIntent = new QQGameSubscribeBusEvent(6);
        SimpleEventBus.getInstance().dispatchEvent(paramIntent);
      }
      return;
      label424:
      int i = 1;
      continue;
      label430:
      int k = 3;
    }
  }
  
  private boolean isNeedShowGrayTips(Activity paramActivity, String paramString)
  {
    boolean bool3 = ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isQQGamePubAccount(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool3 = paramActivity.getIntent().getBooleanExtra("key_is_from_game_pub", false);
      boolean bool4 = isGameSinglePage(paramActivity.getIntent());
      bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (!bool4) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void reportSetSubscribe(String paramString, int paramInt1, int paramInt2)
  {
    int i = 1;
    if ((1 == paramInt2) || (2 == paramInt2))
    {
      WadlReportBuilder localWadlReportBuilder1 = new WadlReportBuilder();
      WadlReportBuilder localWadlReportBuilder2 = localWadlReportBuilder1.a("dc00087").h("769").c("208617").b(paramString).d("76901").g("20");
      paramString = "1";
      localWadlReportBuilder2 = localWadlReportBuilder2.e("1").f("160");
      if (1 != paramInt2) {
        paramString = "2";
      }
      paramString = localWadlReportBuilder2.a(3, paramString);
      if (paramInt1 == 1) {
        paramInt1 = i;
      } else {
        paramInt1 = 0;
      }
      paramString.a(paramInt1);
      localWadlReportBuilder1.a();
    }
  }
  
  private void updateSubscribedListOnSetStatusRsp(QQGamePubSubscribe.AppSubscribeInfo paramAppSubscribeInfo)
  {
    if (paramAppSubscribeInfo.appid.get() != 0) {
      synchronized (this.mSubscribedList)
      {
        Iterator localIterator = this.mSubscribedList.iterator();
        while (localIterator.hasNext())
        {
          QQGamePubSubscribe.AppSubscribeInfo localAppSubscribeInfo = (QQGamePubSubscribe.AppSubscribeInfo)localIterator.next();
          if ((localAppSubscribeInfo != null) && (paramAppSubscribeInfo.appid.get() == localAppSubscribeInfo.appid.get())) {
            localIterator.remove();
          }
        }
        if (paramAppSubscribeInfo.subscribe.get() == 1) {
          this.mSubscribedList.add(paramAppSubscribeInfo);
        }
        return;
      }
    }
  }
  
  public void enterSingleGameMsgPage(Context paramContext, String paramString, int paramInt)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramContext, "/base/activity/QQGamePubAccountActivity");
    BaseAIOUtils.a(localActivityURIRequest, new int[] { 1 });
    localActivityURIRequest.extra().putBoolean("open_chatfragment", true);
    ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).initPublicAccountChatPieIntent(localActivityURIRequest);
    localActivityURIRequest.extra().putString("uin", "2747277822");
    localActivityURIRequest.extra().putInt("uintype", 1008);
    localActivityURIRequest.extra().putString("uinname", "");
    localActivityURIRequest.extra().putInt("entrance", 1);
    localActivityURIRequest.extra().putInt("aio_msg_source", 0);
    if (!(paramContext instanceof Activity)) {
      localActivityURIRequest.setFlags(268435456);
    }
    localActivityURIRequest.extra().putInt("qqgame_msg_scene_key", 2);
    localActivityURIRequest.extra().putString("qqgame_msg_page_appid_key", paramString);
    localActivityURIRequest.extra().putInt("qqgame_msg_single_page_from_key", paramInt);
    localActivityURIRequest.extra().putBoolean("game_pub_new_style_key", true);
    QRoute.startUri(localActivityURIRequest, new QQGameSubscribeServiceImpl.1(this, paramContext, paramString, paramInt));
  }
  
  public boolean enterSubscribeManagePage(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    if ((paramActivity != null) && (paramActivity.getIntent().getBooleanExtra("key_is_from_game_pub", false)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("isNightMode", Boolean.valueOf(((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).isInNightMode()));
      localHashMap.put("uniquePagePath", paramString3);
      localHashMap.put("clickTime", Long.valueOf(System.currentTimeMillis()));
      paramString1 = new PageRouterBuilder().b(paramString1).a(paramString2).a(true).b(true).c(true).a(localHashMap).a();
      ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).startQQGameFlutter(paramActivity, paramString1, null);
      return true;
    }
    QLog.e("QQGamePub_QQGameSubscribeServiceImpl", 4, "enterSubscribeManagePage activity is null or is not from game pub");
    return false;
  }
  
  public void filterSingleGameMsgList(Activity paramActivity, List<ChatMessage> paramList)
  {
    if (paramActivity != null)
    {
      if (paramList == null) {
        return;
      }
      if (isGameSinglePage(paramActivity.getIntent()))
      {
        String str = paramActivity.getIntent().getStringExtra("qqgame_msg_page_appid_key");
        paramActivity = new ArrayList();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          ChatMessage localChatMessage = (ChatMessage)localIterator.next();
          QQGameMsgInfo localQQGameMsgInfo = ((IQQGameMsgParser)QRoute.api(IQQGameMsgParser.class)).parseMessageRecord(localChatMessage);
          if ((localQQGameMsgInfo != null) && (!TextUtils.isEmpty(localQQGameMsgInfo.gameAppId)) && (localQQGameMsgInfo.gameAppId.equals(str))) {
            paramActivity.add(localChatMessage);
          }
        }
        paramList.clear();
        paramList.addAll(paramActivity);
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("filterSingleGameMsgList...singleGameMsgSize:");
          paramList.append(paramActivity.size());
          QLog.i("QQGamePub_QQGameSubscribeServiceImpl", 2, paramList.toString());
        }
      }
    }
  }
  
  public View findGameGrayTipsViewInParent(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null) {
      return paramViewGroup.findViewById(2131374421);
    }
    return null;
  }
  
  public List<QQGamePubSubscribe.AppSubscribeInfo> getCachedSubscribeList()
  {
    return this.mSubscribedList;
  }
  
  public View getGameGrayTipsView(Context paramContext)
  {
    return new QQGameGrayTipsView(paramContext);
  }
  
  public IQQGameSubscribeService.GameBaseInfo getGameInfoFromCacheMap(String paramString)
  {
    return (IQQGameSubscribeService.GameBaseInfo)this.mGameBaseInfoMap.get(paramString);
  }
  
  public void getSubscribeInfo(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSubscribeInfo...appId:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QQGamePub_QQGameSubscribeServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isInValidGameAppId(paramString)) {
      return;
    }
    Object localObject = new QQGamePubSubscribe.GetSubscribeInfoReq();
    ((QQGamePubSubscribe.GetSubscribeInfoReq)localObject).appid_list.add(Integer.valueOf(Integer.parseInt(paramString)));
    paramString = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/97", false, ((QQGamePubSubscribe.GetSubscribeInfoReq)localObject).toByteArray());
    localObject = new TrpcProxy.TrpcListReq();
    ((TrpcProxy.TrpcListReq)localObject).list.add(paramString);
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc((TrpcProxy.TrpcListReq)localObject, null);
  }
  
  public void handleGameInfoUiOnRsp(ViewGroup paramViewGroup, String paramString, QQGamePubSubscribe.AppSubscribeInfo paramAppSubscribeInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGameInfoUiOnRsp...rootView:");
      localStringBuilder.append(paramViewGroup);
      localStringBuilder.append(",appId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",subscribeInfo:");
      localStringBuilder.append(paramAppSubscribeInfo);
      localStringBuilder.append(",needAnim:");
      localStringBuilder.append(paramBoolean);
      QLog.i("QQGamePub_QQGameSubscribeServiceImpl", 2, localStringBuilder.toString());
    }
    if ((paramViewGroup != null) && (paramAppSubscribeInfo != null))
    {
      if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isInValidGameAppId(paramString)) {
        return;
      }
      paramViewGroup = (QQGameSubscribeInfoView)paramViewGroup.findViewById(2131374422);
      if (paramViewGroup != null) {
        paramViewGroup.a(paramString, paramAppSubscribeInfo, paramBoolean);
      }
    }
  }
  
  public void handleSubscribeGrayTipsUi(String paramString, ChatMessage paramChatMessage, ViewGroup paramViewGroup, int paramInt)
  {
    try
    {
      Activity localActivity = (Activity)paramViewGroup.getContext();
      if (isNeedShowGrayTips(localActivity, paramString))
      {
        float f;
        if (paramInt == -5008) {
          f = -12.0F;
        }
        for (paramString = localActivity.getResources();; paramString = localActivity.getResources())
        {
          paramInt = UIUtils.a(f, paramString);
          break;
          f = 4.0F;
        }
        if ((paramViewGroup instanceof RelativeLayout))
        {
          QQGameMsgInfo localQQGameMsgInfo = ((IQQGameMsgParser)QRoute.api(IQQGameMsgParser.class)).parseMessageRecord(paramChatMessage);
          paramChatMessage = findGameGrayTipsViewInParent(paramViewGroup);
          if ((localQQGameMsgInfo != null) && (!((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isInValidGameAppId(localQQGameMsgInfo.gameAppId)))
          {
            boolean bool1 = isSubscribed(localQQGameMsgInfo.gameAppId);
            paramString = paramChatMessage;
            if (paramChatMessage == null)
            {
              paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
              paramString = getGameGrayTipsView(localActivity);
              paramChatMessage.addRule(14);
              paramChatMessage.addRule(3, 2131364521);
              paramChatMessage.topMargin = paramInt;
              paramViewGroup.addView(paramString, paramChatMessage);
            }
            boolean bool2 = localActivity.getIntent().getBooleanExtra("game_pub_is_night_mode", false);
            if ((paramString instanceof QQGameGrayTipsView)) {
              ((QQGameGrayTipsView)paramString).a(localQQGameMsgInfo, bool1, bool2);
            }
          }
          else if (paramChatMessage != null)
          {
            paramViewGroup.removeView(paramChatMessage);
            return;
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("QQGamePub_QQGameSubscribeServiceImpl", 1, paramString, new Object[0]);
    }
  }
  
  public boolean isFromAllMsgGameSinglePage(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("qqgame_msg_single_page_from_key", 0);
      bool1 = bool2;
      if (isGameSinglePage(paramIntent))
      {
        bool1 = bool2;
        if (i == 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isGameSinglePage(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("qqgame_msg_scene_key", 0);
      paramIntent = paramIntent.getStringExtra("qqgame_msg_page_appid_key");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isGameSinglePage...singleKey:");
        localStringBuilder.append(i);
        localStringBuilder.append(",appId:");
        localStringBuilder.append(paramIntent);
        QLog.i("QQGamePub_QQGameSubscribeServiceImpl", 2, localStringBuilder.toString());
      }
      bool1 = bool2;
      if (i == 2)
      {
        bool1 = bool2;
        if (!((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isInValidGameAppId(paramIntent)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isSubscribed(String paramString)
  {
    synchronized (this.mSubscribedList)
    {
      Iterator localIterator = this.mSubscribedList.iterator();
      while (localIterator.hasNext())
      {
        QQGamePubSubscribe.AppSubscribeInfo localAppSubscribeInfo = (QQGamePubSubscribe.AppSubscribeInfo)localIterator.next();
        if ((localAppSubscribeInfo != null) && (paramString != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localAppSubscribeInfo.appid.get());
          localStringBuilder.append("");
          if (paramString.equals(localStringBuilder.toString())) {
            return true;
          }
        }
      }
      return false;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate:");
      localStringBuilder.append(paramAppRuntime);
      QLog.i("QQGamePub_QQGameSubscribeServiceImpl", 2, localStringBuilder.toString());
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQGamePub_QQGameSubscribeServiceImpl", 2, "onDestroy");
    }
  }
  
  public void preHandleGameInfoUi(ViewGroup paramViewGroup, String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("preHandleGameInfoUi...rootView:");
      ((StringBuilder)localObject1).append(paramViewGroup);
      ((StringBuilder)localObject1).append(",appId:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("QQGamePub_QQGameSubscribeServiceImpl", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramViewGroup != null)
    {
      if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isInValidGameAppId(paramString)) {
        return;
      }
      View localView = paramViewGroup.findViewById(2131376809);
      Object localObject2 = (QQGameSubscribeInfoView)paramViewGroup.findViewById(2131374422);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new QQGameSubscribeInfoView(paramViewGroup.getContext());
      }
      localObject2 = new RelativeLayout.LayoutParams(-1, UIUtils.a(80.0F, paramViewGroup.getResources()));
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131376636);
      paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localView.setPadding(0, UIUtils.a(80.0F, paramViewGroup.getResources()), 0, 0);
      ((QQGameSubscribeInfoView)localObject1).a(paramString, null, false);
    }
  }
  
  public void putToGameInfoMap(String paramString, IQQGameSubscribeService.GameBaseInfo paramGameBaseInfo)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramGameBaseInfo == null) {
        return;
      }
      this.mGameBaseInfoMap.put(paramString, paramGameBaseInfo);
    }
  }
  
  public long reqSetSubscribeStatus(String paramString, int paramInt1, int paramInt2)
  {
    if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isInValidGameAppId(paramString)) {
      return 0L;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new QQGamePubSubscribe.SetSubscribeStatusReq();
    ((QQGamePubSubscribe.SetSubscribeStatusReq)localObject1).operation.set(paramInt1);
    ((QQGamePubSubscribe.SetSubscribeStatusReq)localObject1).appid_list.add(Integer.valueOf(Integer.parseInt(paramString)));
    Object localObject2 = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/95", false, ((QQGamePubSubscribe.SetSubscribeStatusReq)localObject1).toByteArray());
    localObject1 = new TrpcProxy.TrpcListReq();
    ((TrpcProxy.TrpcListReq)localObject1).list.add((MessageMicro)localObject2);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("qqgame_msg_scene_key", paramInt2);
    ((Bundle)localObject2).putLong("set_subscribe_seq_key", l);
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc((TrpcProxy.TrpcListReq)localObject1, (Bundle)localObject2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setSubscribeStatus...operation:");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(",appId:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",scene:");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(",seq:");
      ((StringBuilder)localObject1).append(l);
      QLog.i("QQGamePub_QQGameSubscribeServiceImpl", 2, ((StringBuilder)localObject1).toString());
    }
    reportSetSubscribe(paramString, paramInt1, paramInt2);
    return l;
  }
  
  public void reqSubscribeList(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSubscribeList...query:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("QQGamePub_QQGameSubscribeServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new QQGamePubSubscribe.GetSubscribeListReq();
    ((QQGamePubSubscribe.GetSubscribeListReq)localObject).query.set(paramInt);
    localObject = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/96", false, ((QQGamePubSubscribe.GetSubscribeListReq)localObject).toByteArray());
    TrpcProxy.TrpcListReq localTrpcListReq = new TrpcProxy.TrpcListReq();
    localTrpcListReq.list.add((MessageMicro)localObject);
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc(localTrpcListReq, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameSubscribeServiceImpl
 * JD-Core Version:    0.7.0.1
 */