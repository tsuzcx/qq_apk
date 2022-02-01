package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver.ScreenshotEventReportListener;
import com.tencent.biz.pubaccount.util.SneakyCallback;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyDataProviderObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyStringUtils;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasConfig;
import com.tencent.mobileqq.kandian.biz.comment.TKDCommentFragmentHelper;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentBubbleViewHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyResetUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelBannerUtil;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.Utils;
import com.tencent.mobileqq.kandian.biz.feedspopup.RIJUGCAccountPopupStep;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoAudioControlUtil;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl.Companion;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.ProteusPreloadManager;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAwesomeCommentView;
import com.tencent.mobileqq.kandian.biz.push.OnMainVideoTabRedChangeListener;
import com.tencent.mobileqq.kandian.biz.push.OnTabRedNumsChangeListenner;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.push.RIJLockScreenPushReport;
import com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotification;
import com.tencent.mobileqq.kandian.biz.push.ReadInJoyTabObserver;
import com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.mobileqq.kandian.biz.push.component.RIJPushComponentExtData;
import com.tencent.mobileqq.kandian.biz.push.component.RIJPushComponentExtDataProcessor;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.xtab.badge.IRIJBadgeInterceptor;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJBadgeInterceptorWrapper;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeInfoExtKt;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeInterceptor;
import com.tencent.mobileqq.kandian.glue.baseconfig.RIJUserInfoAladdinConfig;
import com.tencent.mobileqq.kandian.glue.report.RIJMiniProgrameReporter;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.ReadInJoyGlobalReporter;
import com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl.RIJMsgBoxUtils;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianLockScreenPushAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.config.QQAladdinUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.db.struct.AwesomeCommentInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.Kandian210Msg0xeeInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.Kandian210Msg0xeeInfo.NotifyInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.KandianMsgBoxRedPntInfoUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.KandianOx210MsgInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.KandianOx210MsgInfo.Biu0x210Msg;
import com.tencent.mobileqq.kandian.repo.db.struct.MySelfNormalItemRedPointInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.channelcover.RIJMainChannelUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.InsertArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.push.api.IKanDianMergeManagerCallBack;
import com.tencent.mobileqq.kandian.repo.push.api.MessageObserver;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.kandian.repo.reddot.RIJKanDianRedDotUtils;
import com.tencent.mobileqq.kandian.repo.tab.RIJXTabRedDotInfo;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleUtil;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeShowLevel;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeStore;
import com.tencent.mobileqq.mini.notify.MiniAppNotify.IMiniAppNotifyListener;
import com.tencent.mobileqq.mp.mobileqq_mp.GetMessageConfigurationRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.BiuBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.NotifyBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.StyleSheet;

public class KandianMergeManager
  implements Manager
{
  public static String f = "PUSH_0X210_ORANGE_KEY";
  private KandianMsgBoxRedPntInfo A;
  private String B = "";
  private volatile Kandian210Msg0xeeInfo C;
  private KandianMergeManager.KandianSetTopInfo D;
  private QQAppInterface E;
  private List<InsertArticleInfo> F = new ArrayList();
  private String G = "";
  private KandianRedDotInfo H = null;
  private Map<Long, String> I = new HashMap();
  private List<IRIJBadgeInterceptor> J;
  private Observer K = new KandianMergeManager.1(this);
  private SimpleEventReceiver<ViolaEvent> L = new KandianMergeManager.2(this);
  private ReadInJoyGlobalReporter M = new ReadInJoyGlobalReporter();
  private MiniAppNotify.IMiniAppNotifyListener N = new KandianMergeManager.9(this);
  private BroadcastReceiver O = new KandianMergeManager.10(this);
  private GameCenterObserver P = new KandianMergeManager.15(this);
  private List<OnTabRedNumsChangeListenner> Q;
  private List<OnMainVideoTabRedChangeListener> R;
  private List<MessageObserver> S;
  private HashMap<String, Boolean> T = new HashMap();
  private AvatarObserver U = new KandianMergeManager.36(this);
  private ScreenshotContentObserver V;
  public long a;
  public long b;
  public String c;
  public int d = -1;
  public boolean e = false;
  private AtomicInteger g;
  private AtomicLong h;
  private String i;
  private ArrayList<Long> j = null;
  private KandianRedDotInfo k = null;
  private AtomicInteger l;
  private AtomicInteger m;
  private AtomicLong n;
  private String o;
  private AtomicInteger p;
  private String q;
  private String r;
  private Long s;
  private AtomicInteger t;
  private KandianRedDotInfo u;
  private KandianOx210MsgInfo.Biu0x210Msg v;
  private KandianOx210MsgInfo w;
  private KandianOx210MsgInfo x;
  private KandianOx210MsgInfo y;
  private int z;
  
  public KandianMergeManager(QQAppInterface paramQQAppInterface)
  {
    QLog.i("KandianMergeManager", 1, "[KandianMergeManager] constructed.");
    this.E = paramQQAppInterface;
    Z();
    ab();
    this.g = new AtomicInteger(0);
    this.h = new AtomicLong(0L);
    this.t = new AtomicInteger(0);
    this.l = new AtomicInteger(0);
    this.n = new AtomicLong(0L);
    this.o = "";
    this.m = new AtomicInteger(-1);
    this.p = new AtomicInteger(-1);
    ReadInJoyResetUtils.b();
    QQAladdinUtils.a();
    ae();
    Utils.b();
    ReadinjoySPEventReport.l();
    if (Aladdin.getConfig(258).getIntegerFromString("load_resources_after_login", 1) == 0)
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        X();
      } else {
        ThreadManager.executeOnSubThread(new KandianMergeManager.3(this));
      }
      QLog.d("KandianMergeManager", 1, "do method[someInitInSubThread] in manager init ");
    }
    paramQQAppInterface.addObserver(this.U);
    paramQQAppInterface.getMessageFacade().addObserver(this.K);
    SimpleEventBus.getInstance().registerReceiver(this.L);
    ThreadManager.executeOnSubThread(new KandianMergeManager.4(this));
    SneakyCallback.c();
    AwesomeCommentInfo.a();
    NativeAwesomeCommentView.setMaxLines(((Integer)RIJSPUtils.b(AwesomeCommentInfo.l, Integer.valueOf(1))).intValue());
    ReadInJoyAtlasConfig.a();
    paramQQAppInterface.registObserver(this.P);
    Y();
    RIJUGCAccountPopupStep.j();
    am();
    a(new RIJXTabBadgeInterceptor(paramQQAppInterface, this));
    PTSHelper.a();
  }
  
  private void X()
  {
    Object localObject = (ReadInJoyLogicManager)this.E.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().b(0, 20, 9223372036854775807L, true);
    ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().b(56, 20, 9223372036854775807L, true);
    ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().b(70, 20, 9223372036854775807L, true);
    ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().b(DailyModeConfigHandler.j(), 20, 9223372036854775807L, true);
    ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().e(0);
    ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().aa();
    ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().v();
    aj();
    localObject = ProteusPreloadManager.a.a();
    ProteusPreloadManager.a.a((List)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preload pts card, rules : ");
    localStringBuilder.append(localObject);
    QLog.d("KandianMergeManager", 1, localStringBuilder.toString());
  }
  
  private void Y()
  {
    ThreadManager.getFileThreadHandler().post(new KandianMergeManager.6(this));
  }
  
  private void Z()
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.7(this));
  }
  
  public static int a(MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    if (paramMessageRecord != null)
    {
      if (paramAppInterface == null) {
        return -1;
      }
      if (((paramMessageRecord.extInt == 3) || (paramMessageRecord.extInt == 4)) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN))) {
        return -1;
      }
      if ((paramMessageRecord.extInt == 1) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN))) {
        return 0;
      }
      if ((paramMessageRecord.extInt == 2) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN))) {
        return 1;
      }
      if (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.NEW_KANDIAN_UIN)) {
        return 0;
      }
      if ((paramMessageRecord.istroop == 1008) && (ServiceAccountFolderManager.a(paramAppInterface, paramMessageRecord.frienduin))) {
        return 1;
      }
    }
    return -1;
  }
  
  private long a(Kandian210Msg0xeeInfo paramKandian210Msg0xeeInfo)
  {
    paramKandian210Msg0xeeInfo = paramKandian210Msg0xeeInfo.notifyInfos.iterator();
    for (long l1 = 0L; paramKandian210Msg0xeeInfo.hasNext(); l1 = ((Kandian210Msg0xeeInfo.NotifyInfo)paramKandian210Msg0xeeInfo.next()).contextId) {}
    return l1;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    Object localObject1 = paramMessageRecord;
    if (paramAppInfo.buffer.has())
    {
      localObject1 = paramAppInfo.buffer.get();
      paramAppInfo = new StringBuilder();
      paramAppInfo.append("handlerRedPntCenterNotify | buffer jsonStr ");
      paramAppInfo.append((String)localObject1);
      QLog.d("KandianMergeManager", 1, paramAppInfo.toString());
      paramAppInfo = paramMessageRecord;
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        paramAppInfo = paramMessageRecord;
        Object localObject2 = ((JSONObject)localObject1).optString("_show_mission");
        paramAppInfo = paramMessageRecord;
        localObject1 = new JSONObject(new JSONObject(((JSONObject)localObject1).optString("param")).optString((String)localObject2)).optString("_red_ext_kd_push_msg_xml");
        paramAppInfo = paramMessageRecord;
        localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes("utf-8"))).getElementsByTagName("msg").item(0);
        localObject1 = paramMessageRecord;
        if (localObject2 != null)
        {
          paramAppInfo = paramMessageRecord;
          localObject2 = ((Node)localObject2).getAttributes();
          localObject1 = paramMessageRecord;
          if (localObject2 != null)
          {
            paramAppInfo = paramMessageRecord;
            if (((NamedNodeMap)localObject2).getNamedItem("articleIds") != null)
            {
              paramAppInfo = paramMessageRecord;
              if (!TextUtils.isEmpty(this.G))
              {
                paramAppInfo = paramMessageRecord;
                if (this.G.equalsIgnoreCase(((NamedNodeMap)localObject2).getNamedItem("articleIds").getNodeValue())) {
                  return paramMessageRecord;
                }
              }
            }
            paramAppInfo = paramMessageRecord;
            paramMessageRecord = a((NamedNodeMap)localObject2);
            paramAppInfo = paramMessageRecord;
            localObject2 = new StringBuilder();
            paramAppInfo = paramMessageRecord;
            ((StringBuilder)localObject2).append("handlerRedPntCenterNotify | parseRedPntInfoAndSave ");
            if (paramMessageRecord == null) {
              break label371;
            }
            localObject1 = "succeed";
            paramAppInfo = paramMessageRecord;
            ((StringBuilder)localObject2).append((String)localObject1);
            paramAppInfo = paramMessageRecord;
            QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject2).toString());
            localObject1 = paramMessageRecord;
            if (paramMessageRecord != null)
            {
              paramAppInfo = paramMessageRecord;
              localObject1 = paramMessageRecord;
              if (this.E != null)
              {
                paramAppInfo = paramMessageRecord;
                this.E.getMessageFacade().a(paramMessageRecord, this.E.getCurrentUin());
                return paramMessageRecord;
              }
            }
          }
        }
      }
      catch (Exception paramMessageRecord)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handlerRedPntCenterNotify JSONException ");
        ((StringBuilder)localObject1).append(paramMessageRecord);
        QLog.e("KandianMergeManager", 1, ((StringBuilder)localObject1).toString());
        localObject1 = paramAppInfo;
      }
      return localObject1;
      label371:
      localObject1 = "failed";
    }
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    if ((!paramBoolean) && ((paramMessageRecord.extInt == 3) || (paramMessageRecord.extInt == 4)) && (TextUtils.equals(paramMessageRecord.msg, paramString1))) {
      return null;
    }
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.msgtype = -1000;
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, long paramLong, String paramString2)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.frienduin = AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN;
    localMessageRecord.senderuin = AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN;
    localMessageRecord.istroop = 7225;
    localMessageRecord.msg = paramString1;
    localMessageRecord.time = paramLong;
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("msg_id", paramString2);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("put msgId error, e=");
      localStringBuilder.append(localJSONException.toString());
      QLog.e("KandianMergeManager", 1, localStringBuilder.toString());
    }
    localMessageRecord.extStr = ((JSONObject)localObject).toString();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createLockScreenInteractMessage, msg=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", msg_id=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("KandianMergeManager", 2, ((StringBuilder)localObject).toString());
    }
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, String paramString2, int paramInt)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.selfuin = this.E.getCurrentUin();
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.selfuin = this.E.getCurrentUin();
    localMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageRecord.senderuin = AppConstants.NEW_KANDIAN_UIN;
    localMessageRecord.istroop = 7220;
    localMessageRecord.extInt = 6;
    if (ReadInJoyHelper.a(this.E))
    {
      localMessageRecord.extLong |= 0x20000000;
      localMessageRecord.extLong |= 0x1;
    }
    else
    {
      localMessageRecord.extLong |= 0x2;
    }
    localMessageRecord.isread = false;
    localMessageRecord.issend = 0;
    localMessageRecord.msg = paramString1;
    localMessageRecord.time = paramLong1;
    try
    {
      boolean bool = TextUtils.isEmpty(localMessageRecord.extStr);
      if (bool)
      {
        paramString1 = new JSONObject();
        paramString1.put(f, paramString2);
        paramString1.put("strategy_id", paramLong2);
        paramString1.put("algorithm_id", paramLong3);
        paramString1.put("article_id", paramLong4);
        paramString1.put("folder_status", paramLong5);
        localMessageRecord.extStr = paramString1.toString();
      }
      else
      {
        paramString1 = new JSONObject(localMessageRecord.extStr);
        paramString1.put(f, paramString2);
        paramString1.put("strategy_id", paramLong2);
        paramString1.put("algorithm_id", paramLong3);
        paramString1.put("article_id", paramLong4);
        paramString1.put("folder_status", paramLong5);
        localMessageRecord.extStr = paramString1.toString();
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      localMessageRecord.extStr = null;
    }
    localMessageRecord.vipBubbleID = -999L;
    RIJKanDianFolderStatus.updateLastKandianMsgRecord(localMessageRecord);
    this.E.getMessageFacade().a(localMessageRecord, this.E.getCurrentUin());
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    boolean bool = ReadInJoyHelper.B();
    localMessageRecord.selfuin = this.E.getCurrentUin();
    localMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageRecord.senderuin = AppConstants.NEW_KANDIAN_UIN;
    localMessageRecord.istroop = 7220;
    localMessageRecord.extInt = 5;
    if (ReadInJoyHelper.a(this.E))
    {
      localMessageRecord.extLong |= 0x20000000;
      localMessageRecord.extLong |= 0x1;
    }
    else
    {
      localMessageRecord.extLong |= 0x2;
    }
    if (paramBoolean2)
    {
      localMessageRecord.extInt = 2;
      bool = ReadInJoyHelper.f(paramString3);
    }
    localMessageRecord.issend = 0;
    localMessageRecord.isread = false;
    localMessageRecord.msg = paramString1;
    localMessageRecord.time = paramLong;
    try
    {
      this.i = paramString3;
      paramBoolean2 = TextUtils.isEmpty(localMessageRecord.extStr);
      if (paramBoolean2)
      {
        paramString1 = new JSONObject();
        paramString1.put(f, paramString2);
        paramString1.put("kdUin", this.i);
        paramString1.put("kdShouldShowMergedAvatar", bool);
        localMessageRecord.extStr = paramString1.toString();
      }
      else
      {
        paramString1 = new JSONObject(localMessageRecord.extStr);
        paramString1.put(f, paramString2);
        paramString1.put("kdUin", this.i);
        paramString1.put("kdShouldShowMergedAvatar", bool);
        localMessageRecord.extStr = paramString1.toString();
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      localMessageRecord.extStr = null;
    }
    if (z())
    {
      localMessageRecord.vipBubbleID = -1000L;
    }
    else
    {
      if (paramBoolean1) {
        paramLong = -999L;
      } else {
        paramLong = -1000L;
      }
      localMessageRecord.vipBubbleID = paramLong;
    }
    if ((localMessageRecord.vipBubbleID == -1000L) && (!paramBoolean1)) {
      localMessageRecord.extStr = null;
    }
    paramString1 = this.E.getMessageFacade();
    RIJKanDianFolderStatus.updateLastKandianMsgRecord(localMessageRecord);
    paramString1.a(localMessageRecord, this.E.getCurrentUin());
    return localMessageRecord;
  }
  
  private void a(long paramLong)
  {
    try
    {
      String str = new RIJTransMergeKanDianReport.ReportR5Builder().addArticleID(paramLong).build();
      PublicAccountReportUtils.a(null, "", "0X8009A8A", "0X8009A8A", 0, 0, "", "", "", str, false);
      QLog.d("KandianMergeManager", 2, new Object[] { "reportAbandonPushRedPoint action = 0X8009A8A, r5 = ", str });
      return;
    }
    catch (JSONException localJSONException)
    {
      label58:
      break label58;
    }
    QLog.d("KandianMergeManager", 1, "reportAbandonPushRedPoint exception.");
  }
  
  private void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    Object localObject = this.S;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MessageObserver)((Iterator)localObject).next()).a(paramMessageRecord, paramInt, paramBundle);
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    paramMessageRecord.senderuin = AppConstants.KANDIAN_MERGE_UIN;
    paramMessageRecord.istroop = 7220;
    paramMessageRecord.msg = paramString1;
    try
    {
      paramMessageRecord.time = Long.parseLong(paramString2);
      paramMessageRecord.createMessageUniseq();
      if (paramInt == 0) {
        paramMessageRecord.extInt = 3;
      } else if (paramInt == 1) {
        paramMessageRecord.extInt = 4;
      } else if (paramInt == 5) {
        paramMessageRecord.extInt = paramInt;
      } else {
        paramMessageRecord.extInt = 0;
      }
      paramMessageRecord.extLong = 0;
      return;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
  }
  
  private void a(KandianOx210MsgInfo paramKandianOx210MsgInfo, long paramLong)
  {
    KandianOx210MsgInfo localKandianOx210MsgInfo = this.y;
    int i1 = 0;
    boolean bool = false;
    if (localKandianOx210MsgInfo != null)
    {
      if (localKandianOx210MsgInfo != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("0x210Msg reached, oldSeq = ");
        localStringBuilder.append(localKandianOx210MsgInfo.e);
        localStringBuilder.append(", newSeq = ");
        localStringBuilder.append(paramKandianOx210MsgInfo.e);
        QLog.d("KandianMergeManager", 1, localStringBuilder.toString());
      }
      if (localKandianOx210MsgInfo.e >= paramKandianOx210MsgInfo.e)
      {
        if (localKandianOx210MsgInfo.e != paramKandianOx210MsgInfo.e) {
          bool = true;
        }
        if (bool) {
          localKandianOx210MsgInfo.a += 1;
        }
        if (QLog.isColorLevel())
        {
          paramKandianOx210MsgInfo = new StringBuilder();
          paramKandianOx210MsgInfo.append("0x210msg delay reach , has a latest msg , no cover! needAddCount : ");
          paramKandianOx210MsgInfo.append(bool);
          QLog.d("KandianMergeManager", 2, paramKandianOx210MsgInfo.toString());
        }
        return;
      }
    }
    if (this.y != null) {
      paramKandianOx210MsgInfo.a += this.y.a;
    }
    this.y = paramKandianOx210MsgInfo;
    localKandianOx210MsgInfo = this.y;
    localKandianOx210MsgInfo.n = paramLong;
    localKandianOx210MsgInfo.a(this.E);
    while (i1 < paramKandianOx210MsgInfo.w.size())
    {
      a((MySelfNormalItemRedPointInfo)paramKandianOx210MsgInfo.w.get(i1));
      i1 += 1;
    }
  }
  
  private void a(IRedTouchManager paramIRedTouchManager, int paramInt, BusinessInfoCheckUpdate.AppInfo paramAppInfo, AladdinConfig paramAladdinConfig)
  {
    int i1 = 0;
    if (paramAladdinConfig.getIntegerFromString("use_new_route", 0) == 0)
    {
      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | use old route, skip parse num push info");
      return;
    }
    if ((paramAppInfo.red_display_info.get() != null) && (((BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get()).red_type_info.get() != null))
    {
      paramAppInfo = (BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get();
      if (paramAppInfo == null) {
        return;
      }
      paramAppInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.tab_display_info.get();
      if (paramAppInfo == null) {
        return;
      }
      paramAppInfo = paramAppInfo.red_content.get();
      paramAladdinConfig = paramIRedTouchManager.getNumRedPathListByAppId(paramInt);
      if (paramAladdinConfig != null)
      {
        if (paramAladdinConfig.isEmpty()) {
          return;
        }
        Object localObject = new ArrayList(paramAladdinConfig);
        int i2 = ((List)localObject).size();
        paramAladdinConfig = new long[i2];
        while (i1 < i2)
        {
          BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((List)localObject).get(i1);
          if (localNumRedPath != null) {
            paramAladdinConfig[i1] = localNumRedPath.uint64_msgid.get();
          }
          i1 += 1;
        }
        paramIRedTouchManager.getNumRedMsgByMsgIdArray(paramAladdinConfig, "kandian_num_red_pnt_buffer", new KandianMergeManager.16(this));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handlerRedPntCenterNotify | numRedPoint num: ");
        ((StringBuilder)localObject).append(paramAppInfo);
        ((StringBuilder)localObject).append(", extraNum : ");
        ((StringBuilder)localObject).append(paramIRedTouchManager.getExtraNumRedTotalNum(paramInt));
        ((StringBuilder)localObject).append(", lastMsgID : ");
        ((StringBuilder)localObject).append(paramAladdinConfig[(paramAladdinConfig.length - 1)]);
        QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void aa()
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.8(this));
  }
  
  private void ab()
  {
    RIJMiniProgrameReporter.a.b();
  }
  
  private void ac()
  {
    RIJMiniProgrameReporter.a.c();
  }
  
  private void ad()
  {
    if (this.E != null) {
      try
      {
        IntentFilter localIntentFilter = new IntentFilter("qqplayer_exit_action");
        this.E.getApplication().getApplicationContext().registerReceiver(this.O, localIntentFilter);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void ae()
  {
    Object localObject1 = ReadInJoyHelper.a(this.E, 1);
    this.G = ((SharedPreferences)localObject1).getString("kandian_red_touch_pnt_article_id", "");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initCache mLastRedTouchInfoArticleId : ");
    ((StringBuilder)localObject2).append(this.G);
    QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject2).toString());
    localObject2 = ((SharedPreferences)localObject1).getString("kandian_push_msg_xml", "");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      try
      {
        localObject2 = StructMsgFactory.a(PkgTools.hexToBytes((String)localObject2));
        boolean bool = TextUtils.isEmpty(((AbsStructMsg)localObject2).mArticleIds);
        if (!bool)
        {
          String[] arrayOfString = ((AbsStructMsg)localObject2).mArticleIds.split("\\|");
          this.j = new ArrayList();
          int i1 = 0;
          while (i1 < arrayOfString.length)
          {
            this.j.add(Long.valueOf(arrayOfString[i1]));
            i1 += 1;
          }
        }
        if (!TextUtils.isEmpty(((AbsStructMsg)localObject2).mMsgActionData)) {
          this.c = ((AbsStructMsg)localObject2).mMsgActionData;
        }
        if (!TextUtils.isEmpty(((AbsStructMsg)localObject2).mAlgorithmIds)) {
          this.a = Long.parseLong(localObject2.mAlgorithmIds.split("\\|")[0]);
        }
        if (!TextUtils.isEmpty(((AbsStructMsg)localObject2).mStrategyIds)) {
          this.b = Long.parseLong(localObject2.mStrategyIds.split("\\|")[0]);
        }
        this.g.set(1);
        l1 = ((SharedPreferences)localObject1).getLong("kandian_push_msg_time", 0L);
        this.h.set(l1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    this.q = "";
    this.r = "";
    this.s = Long.valueOf(-1L);
    long l1 = ((SharedPreferences)localObject1).getLong("subscribe_push_msg_time", 0L);
    if (l1 > 0L)
    {
      this.n.set(l1);
      this.o = ((SharedPreferences)localObject1).getString("subscribe_push_msg_uin", "");
      this.m.set(((SharedPreferences)localObject1).getInt("subscribe_push_msg_status", -1));
      this.p.set(((SharedPreferences)localObject1).getInt("subscribe_push_msg_msgtype", -1));
      if ((this.m.get() != 3) && (this.m.get() != -1)) {
        this.l.set(1);
      }
    }
    this.v = KandianOx210MsgInfo.Biu0x210Msg.a();
    this.w = KandianOx210MsgInfo.c();
    this.x = KandianOx210MsgInfo.d();
    this.y = KandianOx210MsgInfo.f();
    this.A = KandianMsgBoxRedPntInfoUtils.a();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("init msgbox info from sp. ");
    ((StringBuilder)localObject1).append(this.A);
    QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject1).toString());
    this.C = Kandian210Msg0xeeInfo.getKandian210Msg0xeeInfoFromSp(this.E);
    localObject1 = this.x;
    if (localObject1 != null)
    {
      this.s = Long.valueOf(((KandianOx210MsgInfo)localObject1).d);
      if (!TextUtils.isEmpty(this.x.l)) {
        this.q = this.x.l;
      }
    }
    this.D = ((KandianMergeManager.KandianSetTopInfo)RIJSPUtils.a(this.E, "kandian_msgtab_settop", true));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("get from cache : ");
    ((StringBuilder)localObject1).append(this.D);
    QLog.d("KandianMergeManager.SETTOP", 2, ((StringBuilder)localObject1).toString());
    af();
    this.u = KandianRedDotInfo.getRedDotFromDisk("kandian_video_tab_reddot_info", true);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("init mianVideoTabRed : ");
    ((StringBuilder)localObject1).append(this.u);
    QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject1).toString());
    this.k = KandianRedDotInfo.getRedDotFromDisk("kandian_red_pnt_lock_screen", true);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("lock screen push info : ");
    ((StringBuilder)localObject1).append(this.k);
    QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject1).toString());
    ThreadManager.executeOnSubThread(new KandianMergeManager.11(this));
    RIJXTabBadgeStore.a.e();
  }
  
  private void af()
  {
    ThreadManager.post(new KandianMergeManager.13(this), 8, null, false);
  }
  
  private void ag()
  {
    int i1 = this.w.h;
    boolean bool2 = false;
    Object localObject1;
    boolean bool1;
    if (i1 == 1)
    {
      localObject1 = this.w.l;
      localObject2 = this.w.k;
      long l1 = this.w.n;
      if (this.w.j == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject1 = a((String)localObject1, (String)localObject2, l1, bool1, true, String.valueOf(this.w.p));
      this.s = Long.valueOf(this.w.d);
      this.q = this.w.l;
      a((MessageRecord)localObject1, true);
      this.x = this.w;
      this.x.c(this.E);
    }
    else
    {
      localObject1 = null;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("has 0x210 follow msg push , brief : ");
      ((StringBuilder)localObject2).append(this.w.l);
      ((StringBuilder)localObject2).append(", showInFolder : ");
      if (this.w.h == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(", showLockScreen : ");
      bool1 = bool2;
      if (this.w.i == 1) {
        bool1 = true;
      }
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(", redType : ");
      ((StringBuilder)localObject2).append(this.w.j);
      ((StringBuilder)localObject2).append(", msgSeq : ");
      ((StringBuilder)localObject2).append(this.w.e);
      ((StringBuilder)localObject2).append(", orangeWord : ");
      ((StringBuilder)localObject2).append(this.w.k);
      ((StringBuilder)localObject2).append(", msgCount : ");
      ((StringBuilder)localObject2).append(this.w.a);
      QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("BID_TYPE", 2);
    a((MessageRecord)localObject1, KandianOx210MsgInfo.z, (Bundle)localObject2);
  }
  
  private void ah()
  {
    Object localObject = this.Q;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((OnTabRedNumsChangeListenner)((Iterator)localObject).next()).da_();
      }
    }
  }
  
  private void ai()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = Q();
    if (localKandianMsgBoxRedPntInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("messageBarInfo", b(localKandianMsgBoxRedPntInfo));
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onMessageBarInfoDidChangedNotification] e = ");
      localStringBuilder.append(localJSONException);
      QLog.e("KandianMergeManager", 1, localStringBuilder.toString());
    }
    Object localObject = new ViolaEvent("RIJMessageBarInfoDidChangeNotification", localJSONObject);
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onMessageBarInfoDidChangedNotification], result = ");
    ((StringBuilder)localObject).append(localJSONObject);
    QLog.i("KandianMergeManager", 1, ((StringBuilder)localObject).toString());
  }
  
  private void aj()
  {
    try
    {
      this.V = new ScreenshotContentObserver(BaseApplicationImpl.getContext(), 0, 0);
      this.V.a(new ScreenshotContentObserver.ScreenshotEventReportListener());
      return;
    }
    catch (SecurityException localSecurityException)
    {
      QLog.e("KandianMergeManager", 1, localSecurityException, new Object[0]);
    }
  }
  
  private void ak()
  {
    ScreenshotContentObserver localScreenshotContentObserver = this.V;
    if (localScreenshotContentObserver != null)
    {
      localScreenshotContentObserver.a();
      this.V = null;
    }
  }
  
  private void al()
  {
    ArrayList localArrayList = this.j;
    long l1;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      l1 = ((Long)this.j.get(0)).longValue();
    } else {
      l1 = 0L;
    }
    a(l1);
  }
  
  private void am()
  {
    ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)this.E.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localReadInJoyLogicManager != null) {
      localReadInJoyLogicManager.getReadInJoyLogicEngine().K();
    }
  }
  
  private void b(byte[] paramArrayOfByte, long paramLong)
  {
    paramArrayOfByte = KandianOx210MsgInfo.a(paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "process 0x210 follow msg fail!");
      }
      return;
    }
    Object localObject1 = this.w;
    if ((localObject1 != null) && (((KandianOx210MsgInfo)localObject1).e > paramArrayOfByte.e))
    {
      Object localObject2;
      if (paramArrayOfByte.h == 1)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("0x210msgc5 delay reach showFolder, has a latest msg , no cover! + oldMsg.msgSeq");
          ((StringBuilder)localObject2).append(((KandianOx210MsgInfo)localObject1).e);
          ((StringBuilder)localObject2).append("msg.msgSeq:");
          ((StringBuilder)localObject2).append(paramArrayOfByte.e);
          ((StringBuilder)localObject2).append("brief : ");
          ((StringBuilder)localObject2).append(paramArrayOfByte.l);
          QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject2).toString());
        }
        if ((this.x != null) && (paramArrayOfByte.e <= this.x.e))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("no upDate ox210ShowInFolderFollowPushMsg.msgSeq");
            ((StringBuilder)localObject1).append(this.x.e);
            ((StringBuilder)localObject1).append("msg.msgSeq:");
            ((StringBuilder)localObject1).append(paramArrayOfByte.e);
            QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          if ((this.x != null) && (QLog.isColorLevel()))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("upDate ox210ShowInFolderFollowPushMsg.msgSeq");
            ((StringBuilder)localObject1).append(this.x.e);
            ((StringBuilder)localObject1).append("msg.msgSeq:");
            ((StringBuilder)localObject1).append(paramArrayOfByte.e);
            QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = paramArrayOfByte.l;
          localObject2 = paramArrayOfByte.k;
          paramLong = paramArrayOfByte.n;
          int i1 = paramArrayOfByte.j;
          boolean bool2 = false;
          boolean bool1;
          if (i1 == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localObject1 = a((String)localObject1, (String)localObject2, paramLong, bool1, true, String.valueOf(paramArrayOfByte.p));
          a((MessageRecord)localObject1, true);
          this.x = paramArrayOfByte;
          this.x.c(this.E);
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("has 0x210 follow msg push , brief : ");
            paramArrayOfByte.append(this.w.l);
            paramArrayOfByte.append(", showInFolder : ");
            if (this.w.h == 1) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            paramArrayOfByte.append(bool1);
            paramArrayOfByte.append(", showLockScreen : ");
            bool1 = bool2;
            if (this.w.i == 1) {
              bool1 = true;
            }
            paramArrayOfByte.append(bool1);
            paramArrayOfByte.append(", redType : ");
            paramArrayOfByte.append(this.w.j);
            paramArrayOfByte.append(", msgSeq : ");
            paramArrayOfByte.append(this.w.e);
            paramArrayOfByte.append(", orangeWord : ");
            paramArrayOfByte.append(this.w.k);
            paramArrayOfByte.append(", msgCount : ");
            paramArrayOfByte.append(this.w.a);
            QLog.d("KandianMergeManager", 1, paramArrayOfByte.toString());
          }
          a((MessageRecord)localObject1, KandianOx210MsgInfo.z, null);
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("0x210msgc5 delay reach discarded,  + oldMsg.msgSeq");
        ((StringBuilder)localObject2).append(((KandianOx210MsgInfo)localObject1).e);
        ((StringBuilder)localObject2).append("msg.msgSeq:");
        ((StringBuilder)localObject2).append(paramArrayOfByte.e);
        QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0x210msgc5 nomel , msg.msgSeq:");
      ((StringBuilder)localObject1).append(paramArrayOfByte.e);
      QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject1).toString());
    }
    this.w = paramArrayOfByte;
    paramArrayOfByte = this.w;
    paramArrayOfByte.n = paramLong;
    paramArrayOfByte.b(this.E);
    ag();
  }
  
  private void b(byte[] paramArrayOfByte, long paramLong, IKanDianMergeManagerCallBack paramIKanDianMergeManagerCallBack)
  {
    int i1 = KandianOx210MsgInfo.b(paramArrayOfByte);
    if (i1 == KandianOx210MsgInfo.x) {
      return;
    }
    if (i1 == KandianOx210MsgInfo.z)
    {
      a(paramArrayOfByte);
      return;
    }
    KandianOx210MsgInfo localKandianOx210MsgInfo = KandianOx210MsgInfo.a(paramArrayOfByte);
    if (localKandianOx210MsgInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "process 0x210 msg fail!");
      }
      return;
    }
    i1 = KandianOx210MsgInfo.c(paramArrayOfByte);
    if (i1 == KandianOx210MsgInfo.A) {
      return;
    }
    int i2 = KandianOx210MsgInfo.B;
    boolean bool2 = false;
    if ((i1 != i2) && (i1 != KandianOx210MsgInfo.C))
    {
      if (i1 == KandianOx210MsgInfo.D) {
        a(localKandianOx210MsgInfo, paramLong);
      }
    }
    else {
      ReadInJoyLogicEngine.a().b(0, "", 0L);
    }
    boolean bool3 = RIJAppSetting.f(this.E);
    boolean bool4 = RIJPushNotification.a();
    boolean bool1;
    if (!bool3)
    {
      bool1 = bool2;
      if (!bool4) {}
    }
    else
    {
      bool1 = bool2;
      if (localKandianOx210MsgInfo.i == 1)
      {
        bool1 = bool2;
        if (((Boolean)RIJSPUtils.b("sp_msg_box_80a_enable_receive", Boolean.valueOf(true))).booleanValue()) {
          bool1 = true;
        }
      }
    }
    if (bool1)
    {
      paramArrayOfByte = a(localKandianOx210MsgInfo.l, localKandianOx210MsgInfo.n, localKandianOx210MsgInfo.v);
      this.E.getMessageFacade().a(paramArrayOfByte, this.E.getCurrentUin(), false, false, true, false);
      paramIKanDianMergeManagerCallBack.a("handleGetKandian210Message", true, 1, true, false);
      if ((RIJKanDianLockScreenPushAladdinConfig.b() != 1) && (RIJMsgBoxUtils.b() == 2)) {
        i1 = 1;
      } else {
        i1 = 3;
      }
      PublicAccountReportUtils.a("0X80081DC", new RIJTransMergeKanDianReport.ReportR5Builder().addValueSafe("uin", this.E.getCurrentAccountUin()).addValueSafe("load_mode", Integer.valueOf(i1)).addValueSafe("push_type", Integer.valueOf(9)).build());
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("isAppBackground=");
    paramArrayOfByte.append(bool3);
    paramArrayOfByte.append(",needNotificationForeground");
    paramArrayOfByte.append(bool4);
    paramArrayOfByte.append(",showLockScreen=");
    paramArrayOfByte.append(localKandianOx210MsgInfo.i);
    paramArrayOfByte.append(",needShow=");
    paramArrayOfByte.append(bool1);
    QLog.i("KandianMergeManager", 1, paramArrayOfByte.toString());
  }
  
  private boolean c(String paramString)
  {
    boolean bool;
    if (RIJXTabConfigHandler.INSTANCE.isXTabMode()) {
      bool = RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab();
    } else if ((RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()) && (!ReadInJoyChannelViewPagerController.n())) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("KandianMergeManager", 1, new Object[] { "isNeedToBlockPushRedPoint, ret = ", Boolean.valueOf(bool), ", tag = ", paramString });
    return bool;
  }
  
  private boolean l(MessageRecord paramMessageRecord)
  {
    boolean bool;
    if ((!RIJXTabBadgeInfoExtKt.a(paramMessageRecord, this.E)) && (RIJXTabBadgeStore.b(TabChannelCoverInfo.TYPE_CHANNEL_XTAB_FRIEND_CONFIG) != null) && (RIJXTabBadgeShowLevel.a() == 2)) {
      bool = true;
    } else {
      bool = false;
    }
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append("isReceiveNormalRedPointWhenFriendBigRedDot=");
    paramMessageRecord.append(bool);
    QLog.i("KandianMergeManager", 1, paramMessageRecord.toString());
    return bool;
  }
  
  private void m(MessageRecord paramMessageRecord)
  {
    if (RIJPushNotification.a(paramMessageRecord)) {
      ThreadManager.post(new KandianMergeManager.19(this), 8, null, false);
    }
  }
  
  private void n(MessageRecord paramMessageRecord)
  {
    QQMessageFacade localQQMessageFacade = this.E.getMessageFacade();
    MessageRecord localMessageRecord;
    if (localQQMessageFacade != null) {
      localMessageRecord = localQQMessageFacade.r(AppConstants.KANDIAN_MERGE_UIN, 7220);
    } else {
      localMessageRecord = null;
    }
    if ((localMessageRecord != null) && (a(paramMessageRecord, this.E) == 1) && (localMessageRecord.extInt == 2) && (!localMessageRecord.isread))
    {
      if (QLog.isColorLevel())
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("lastMr_info 【");
        ((StringBuilder)localObject1).append("msg: ");
        ((StringBuilder)localObject1).append(ReadInJoyUtils.a(localMessageRecord.msg));
        ((StringBuilder)localObject1).append(", msguid : ");
        ((StringBuilder)localObject1).append(localMessageRecord.msgUid);
        Object localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = localObject2;
        if ((localMessageRecord instanceof MessageForStructing))
        {
          localObject3 = (MessageForStructing)localMessageRecord;
          ((MessageForStructing)localObject3).parse();
          localObject1 = localObject2;
          if (((MessageForStructing)localObject3).structingMsg != null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(", title : ");
            ((StringBuilder)localObject1).append(ReadInJoyUtils.a(((MessageForStructing)localObject3).structingMsg.mMsgBrief));
            ((StringBuilder)localObject1).append(" 】");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("newMr_info 【");
        ((StringBuilder)localObject2).append("msg: ");
        ((StringBuilder)localObject2).append(ReadInJoyUtils.a(paramMessageRecord.msg));
        ((StringBuilder)localObject2).append(", senderUin : ");
        ((StringBuilder)localObject2).append(paramMessageRecord.senderuin);
        ((StringBuilder)localObject2).append(" , msguid : ");
        ((StringBuilder)localObject2).append(paramMessageRecord.msgUid);
        Object localObject3 = ((StringBuilder)localObject2).toString();
        localObject2 = localObject3;
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          paramMessageRecord = (MessageForStructing)paramMessageRecord;
          paramMessageRecord.parse();
          localObject2 = localObject3;
          if (paramMessageRecord.structingMsg != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject3);
            ((StringBuilder)localObject2).append(", title : ");
            ((StringBuilder)localObject2).append(ReadInJoyUtils.a(paramMessageRecord.structingMsg.mMsgBrief));
            ((StringBuilder)localObject2).append(" 】");
            localObject2 = ((StringBuilder)localObject2).toString();
          }
        }
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("subscribe push msg cover ! \n");
        paramMessageRecord.append((String)localObject1);
        paramMessageRecord.append("\n");
        paramMessageRecord.append((String)localObject2);
        QLog.i("KandianMergeManager", 2, paramMessageRecord.toString());
      }
      localQQMessageFacade.a(localMessageRecord, false);
    }
  }
  
  private void o(MessageRecord paramMessageRecord)
  {
    try
    {
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        Object localObject = (MessageForStructing)paramMessageRecord;
        ((MessageForStructing)localObject).parse();
        if (((MessageForStructing)localObject).structingMsg != null)
        {
          JSONObject localJSONObject = new JSONObject(((MessageForStructing)localObject).structingMsg.mMsgActionData);
          localObject = null;
          boolean bool3 = localJSONObject.has("showMergedAvatar");
          boolean bool2 = false;
          boolean bool1 = bool2;
          if (bool3)
          {
            bool1 = bool2;
            if (localJSONObject.getInt("showMergedAvatar") == 1) {
              bool1 = true;
            }
          }
          if (localJSONObject.has("uin")) {
            this.i = localJSONObject.getString("uin");
          }
          if (localJSONObject.has("biuUin"))
          {
            this.i = localJSONObject.getString("biuUin");
            bool1 = ReadInJoyHelper.A();
          }
          if (localJSONObject.has("defaultAvatarUrl")) {
            localObject = localJSONObject.getString("defaultAvatarUrl");
          }
          if (TextUtils.isEmpty(paramMessageRecord.extStr)) {
            localJSONObject = new JSONObject();
          } else {
            localJSONObject = new JSONObject(paramMessageRecord.extStr);
          }
          if (!TextUtils.isEmpty(this.i)) {
            localJSONObject.put("kdUin", this.i);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localJSONObject.put("kdDefaultSourceAvatarUrl", localObject);
          }
          localJSONObject.put("kdShouldShowMergedAvatar", bool1);
          paramMessageRecord.extStr = localJSONObject.toString();
          return;
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
  }
  
  private long p(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      paramMessageRecord.parse();
      if (paramMessageRecord.structingMsg == null)
      {
        QLog.d("KandianMergeManager", 1, "getArticleIDFromMessageRecord : struct msg body is null");
        return 0L;
      }
      if ((paramMessageRecord.time >= this.h.get()) && (!TextUtils.isEmpty(paramMessageRecord.structingMsg.mArticleIds)))
      {
        paramMessageRecord = paramMessageRecord.structingMsg.mArticleIds.split("\\|");
        if (paramMessageRecord.length > 0) {
          try
          {
            if (!TextUtils.isEmpty(paramMessageRecord[0]))
            {
              long l1 = new BigInteger(paramMessageRecord[0]).longValue();
              return l1;
            }
          }
          catch (NumberFormatException paramMessageRecord)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getArticleIDFromMessageRecord has num format error : ");
            localStringBuilder.append(paramMessageRecord);
            QLog.e("KandianMergeManager", 1, localStringBuilder.toString());
          }
        }
      }
    }
    return 0L;
  }
  
  public void A()
  {
    NewIntent localNewIntent = new NewIntent(this.E.getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    localNewIntent.putExtra("cmd", "get_message_configuration");
    mobileqq_mp.GetMessageConfigurationRequest localGetMessageConfigurationRequest = new mobileqq_mp.GetMessageConfigurationRequest();
    localGetMessageConfigurationRequest.uin.set(2171946401L);
    localGetMessageConfigurationRequest.versionInfo.set(((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getVersionInfo());
    localNewIntent.putExtra("data", localGetMessageConfigurationRequest.toByteArray());
    localNewIntent.setObserver(new KandianMergeManager.29(this));
    this.E.startServlet(localNewIntent);
  }
  
  public void B()
  {
    if (this.D != null) {
      ThreadManager.executeOnSubThread(new KandianMergeManager.30(this));
    }
  }
  
  public long C()
  {
    KandianMergeManager.KandianSetTopInfo localKandianSetTopInfo = this.D;
    if (localKandianSetTopInfo != null) {
      return KandianMergeManager.KandianSetTopInfo.access$1200(localKandianSetTopInfo);
    }
    return 0L;
  }
  
  public void D()
  {
    Object localObject = this.E.getMessageFacade().r(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if ((localObject != null) && (!((MessageRecord)localObject).isread))
    {
      RecentUserProxy localRecentUserProxy = this.E.getProxyManager().g();
      RecentUser localRecentUser = localRecentUserProxy.c(AppConstants.KANDIAN_MERGE_UIN, 7220);
      if (localRecentUser == null) {
        return;
      }
      long l1 = System.currentTimeMillis() / 1000L;
      localRecentUser.lastmsgtime = l1;
      this.E.getMessageFacade().a(AppConstants.KANDIAN_MERGE_UIN, 7220, ((MessageRecord)localObject).uniseq, "time", Long.valueOf(l1));
      localRecentUserProxy.b(localRecentUser);
      localObject = this.E.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stickKandianConversation successful! newTime : ");
      ((StringBuilder)localObject).append(l1);
      QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public long E()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = this.A;
    if ((localKandianMsgBoxRedPntInfo != null) && (!localKandianMsgBoxRedPntInfo.isRead)) {
      return this.A.mUin;
    }
    return -1L;
  }
  
  public int F()
  {
    return ReadInJoyLogicEngine.a().B();
  }
  
  public SparseIntArray G()
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    localSparseIntArray.append(0, e(0));
    localSparseIntArray.append(1, e(1));
    localSparseIntArray.append(2, e(2));
    localSparseIntArray.append(3, e(3));
    return localSparseIntArray;
  }
  
  public int H()
  {
    if (P()) {
      return RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount(this.A);
    }
    return 0;
  }
  
  public void I()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      ah();
      return;
    }
    ThreadManager.getUIHandler().post(new KandianMergeManager.33(this));
  }
  
  public void J()
  {
    ThreadManager.getUIHandler().post(new KandianMergeManager.34(this));
  }
  
  public void K()
  {
    KandianRedDotInfo localKandianRedDotInfo = this.u;
    if (localKandianRedDotInfo == null) {
      return;
    }
    localKandianRedDotInfo.removeFromDiskAsync(true);
    this.u = null;
    J();
  }
  
  public KandianRedDotInfo L()
  {
    return this.u;
  }
  
  public boolean M()
  {
    return this.u != null;
  }
  
  public void N()
  {
    ThreadManager.executeOnSubThread(new KandianMergeManager.35(this));
  }
  
  public boolean O()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("SplashActivity");
    if ((BaseActivity.sTopActivity != null) && ((ReadInJoyUtils.b() instanceof QQAppInterface)) && (!FrameHelperActivity.ar))
    {
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      String str = localBaseActivity.getClass().getSimpleName();
      if (localArrayList.contains(str))
      {
        boolean bool2 = "SplashActivity".equals(str);
        boolean bool1 = true;
        if (bool2)
        {
          if (SplashActivity.currentFragment != 1) {
            return false;
          }
          if (((SplashActivity)localBaseActivity).getCurrentTab() == FrameControllerUtil.g) {
            return false;
          }
        }
        if (this.T.get(str) != null) {
          bool1 = ((Boolean)this.T.get(str)).booleanValue();
        }
        return bool1;
      }
    }
    return false;
  }
  
  public boolean P()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = this.A;
    return (localKandianMsgBoxRedPntInfo != null) && (!localKandianMsgBoxRedPntInfo.isRead);
  }
  
  @Nullable
  public KandianMsgBoxRedPntInfo Q()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = this.A;
    if ((localKandianMsgBoxRedPntInfo != null) && (localKandianMsgBoxRedPntInfo.isRead)) {
      return null;
    }
    return this.A;
  }
  
  public int R()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = this.A;
    if ((localKandianMsgBoxRedPntInfo != null) && (!localKandianMsgBoxRedPntInfo.isRead)) {
      return RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount(this.A);
    }
    return 0;
  }
  
  public void S()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = this.A;
    if (localKandianMsgBoxRedPntInfo != null) {
      localKandianMsgBoxRedPntInfo.canDoAnimation = true;
    }
  }
  
  public void T()
  {
    Object localObject = this.A;
    if ((localObject != null) && (!((KandianMsgBoxRedPntInfo)localObject).isRead))
    {
      localObject = this.A;
      ((KandianMsgBoxRedPntInfo)localObject).isRead = true;
      ((KandianMsgBoxRedPntInfo)localObject).asyncWriteToSP();
      I();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clear msg box redPnt info, ");
      ((StringBuilder)localObject).append(this.A);
      QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean U()
  {
    try
    {
      boolean bool = this.F.isEmpty();
      return bool ^ true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<InsertArticleInfo> V()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.F);
      this.F.clear();
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void W()
  {
    try
    {
      boolean bool = d();
      QLog.d("KandianMergeManager", 1, new Object[] { "switch to sub channel, clear kandian red point, hasRedPoint = ", Boolean.valueOf(bool) });
      if (bool)
      {
        al();
        r();
        q();
        I();
      }
      return;
    }
    finally {}
  }
  
  public int a(int paramInt)
  {
    if (!ReadInJoyHelper.a(this.E)) {
      return 0;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return 0;
      }
      return this.l.get();
    }
    return this.g.get();
  }
  
  @VisibleForTesting
  MessageRecord a(MessageRecord paramMessageRecord, int paramInt)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(paramMessageRecord.msgtype);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageRecord.istroop = 7220;
    if (paramInt == 0)
    {
      localMessageRecord.extInt = 1;
      b(localMessageRecord, 0);
    }
    else if (paramInt == 1)
    {
      localMessageRecord.extInt = 2;
    }
    else
    {
      localMessageRecord.extInt = 0;
    }
    if (ReadInJoyHelper.a(this.E))
    {
      localMessageRecord.extLong |= 0x20000000;
      localMessageRecord.extLong |= 0x1;
    }
    else
    {
      localMessageRecord.extLong = (0x2 | localMessageRecord.extLong);
    }
    if (z()) {
      localMessageRecord.vipBubbleID = -1000L;
    } else {
      localMessageRecord.vipBubbleID = -999L;
    }
    o(localMessageRecord);
    return localMessageRecord;
  }
  
  @VisibleForTesting
  MessageRecord a(NamedNodeMap paramNamedNodeMap)
  {
    if (paramNamedNodeMap == null)
    {
      QLog.d("KandianMergeManager", 2, "parseRedPntInfoAndSave redInfoMap null ");
      return null;
    }
    Object localObject = paramNamedNodeMap.getNamedItem("orangeWord");
    String str6 = "";
    if (localObject != null) {
      localObject = paramNamedNodeMap.getNamedItem("orangeWord").getNodeValue();
    } else {
      localObject = "";
    }
    String str1;
    if (paramNamedNodeMap.getNamedItem("brief") != null) {
      str1 = paramNamedNodeMap.getNamedItem("brief").getNodeValue();
    } else {
      str1 = "";
    }
    String str2;
    if (paramNamedNodeMap.getNamedItem("articleIds") != null) {
      str2 = paramNamedNodeMap.getNamedItem("articleIds").getNodeValue();
    } else {
      str2 = "";
    }
    String str3;
    if (paramNamedNodeMap.getNamedItem("algorithmIds") != null) {
      str3 = paramNamedNodeMap.getNamedItem("algorithmIds").getNodeValue();
    } else {
      str3 = "";
    }
    String str4;
    if (paramNamedNodeMap.getNamedItem("strategyIds") != null) {
      str4 = paramNamedNodeMap.getNamedItem("strategyIds").getNodeValue();
    } else {
      str4 = "";
    }
    String str5;
    if (paramNamedNodeMap.getNamedItem("actionData") != null) {
      str5 = paramNamedNodeMap.getNamedItem("actionData").getNodeValue();
    } else {
      str5 = "";
    }
    if (paramNamedNodeMap.getNamedItem("reportEventFolderStatusValue") != null) {
      str6 = paramNamedNodeMap.getNamedItem("reportEventFolderStatusValue").getNodeValue();
    }
    this.G = str2;
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.18(this));
    paramNamedNodeMap = (MessageForStructing)MessageRecordFactory.a(-2011);
    paramNamedNodeMap.msgtype = -2011;
    paramNamedNodeMap.structingMsg = StructMsgFactory.a();
    paramNamedNodeMap.structingMsg.mMsgServiceID = 142;
    paramNamedNodeMap.structingMsg.mMsgBrief = str1;
    paramNamedNodeMap.structingMsg.mOrangeWord = ((String)localObject);
    paramNamedNodeMap.structingMsg.mArticleIds = str2;
    paramNamedNodeMap.structingMsg.mStrategyIds = str4;
    paramNamedNodeMap.structingMsg.mAlgorithmIds = str3;
    paramNamedNodeMap.structingMsg.reportEventFolderStatusValue = str6;
    paramNamedNodeMap.structingMsg.mMsgActionData = str5;
    paramNamedNodeMap.extInt = 1;
    paramNamedNodeMap.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    paramNamedNodeMap.selfuin = this.E.getCurrentUin();
    paramNamedNodeMap.senderuin = AppConstants.NEW_KANDIAN_UIN;
    paramNamedNodeMap.istroop = 7220;
    paramNamedNodeMap.issend = 0;
    paramNamedNodeMap.isread = false;
    paramNamedNodeMap.extLong = 0;
    paramNamedNodeMap.time = NetConnInfoCenter.getServerTime();
    paramNamedNodeMap.createMessageUniseq();
    paramNamedNodeMap.doPrewrite();
    return b(paramNamedNodeMap);
  }
  
  public MessageRecord a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      RIJPushComponentExtDataProcessor localRIJPushComponentExtDataProcessor = new RIJPushComponentExtDataProcessor();
      RIJPushComponentExtData localRIJPushComponentExtData = localRIJPushComponentExtDataProcessor.a(new String(paramArrayOfByte));
      JSONObject localJSONObject = localRIJPushComponentExtDataProcessor.b(new String(localRIJPushComponentExtData.f));
      paramString = localRIJPushComponentExtDataProcessor.a(new String(localRIJPushComponentExtData.f), paramString);
      paramArrayOfByte = (MessageForStructing)MessageRecordFactory.a(-2011);
      paramArrayOfByte.msgtype = -2011;
      paramArrayOfByte.structingMsg = StructMsgFactory.a();
      paramArrayOfByte.structingMsg.mMsgServiceID = 142;
      paramArrayOfByte.structingMsg.mArticleIds = localRIJPushComponentExtData.a;
      paramArrayOfByte.structingMsg.mStrategyIds = localRIJPushComponentExtData.d;
      paramArrayOfByte.structingMsg.mAlgorithmIds = localRIJPushComponentExtData.c;
      paramArrayOfByte.structingMsg.reportEventFolderStatusValue = localRIJPushComponentExtData.b;
      paramArrayOfByte.structingMsg.mMsgActionData = localJSONObject.toString();
      paramArrayOfByte.structingMsg.mExtraData = new String(localRIJPushComponentExtData.f);
      paramArrayOfByte.structingMsg.mMsgBrief = paramString.optString("brief", "");
      paramArrayOfByte.structingMsg.mOrangeWord = paramString.optString("orangeWord", "");
      paramArrayOfByte.selfuin = this.E.getCurrentUin();
      paramArrayOfByte.frienduin = AppConstants.KANDIAN_MERGE_UIN;
      paramArrayOfByte.senderuin = AppConstants.NEW_KANDIAN_UIN;
      paramArrayOfByte.istroop = 7220;
      paramArrayOfByte.extInt = 1;
      paramArrayOfByte.time = NetConnInfoCenter.getServerTime();
      paramArrayOfByte.isread = false;
      paramArrayOfByte.issend = 0;
      if (ReadInJoyHelper.a(this.E))
      {
        paramArrayOfByte.extLong |= 0x20000000;
        paramArrayOfByte.extLong |= 0x1;
      }
      else
      {
        paramArrayOfByte.extLong |= 0x2;
      }
      paramString = new StringBuilder();
      paramString.append("createFakeMsgFrom0x135XmlBuffer fakeMr.structingMsg: ");
      paramString.append(paramArrayOfByte.structingMsg);
      QLog.d("KandianMergeManager", 1, paramString.toString());
      paramArrayOfByte.msg = paramArrayOfByte.structingMsg.mMsgBrief;
      paramArrayOfByte.msgData = paramArrayOfByte.structingMsg.getBytes();
      b(paramArrayOfByte, 0);
      if (RIJLockScreenPushReport.a(paramArrayOfByte))
      {
        paramString = new StringBuilder();
        paramString.append("createFakeMsgFrom0x135XmlBuffer receive daily push ! mr : ");
        paramString.append(paramArrayOfByte);
        QLog.d("KandianMergeManager", 1, paramString.toString());
        ((KandianDailyManager)this.E.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a(paramArrayOfByte);
        return paramArrayOfByte;
      }
      h(paramArrayOfByte);
      paramString = this.E.getMessageFacade();
      RIJKanDianFolderStatus.updateLastKandianMsgRecord(paramArrayOfByte);
      paramString.a(paramArrayOfByte, this.E.getCurrentUin());
      return paramArrayOfByte;
    }
    return null;
  }
  
  public IRIJBadgeInterceptor a(MessageRecord paramMessageRecord)
  {
    Object localObject = this.J;
    if (localObject == null)
    {
      QLog.d("KandianMergeManager", 2, "getBadgeInterceptor --> interceptors is null!");
      return new RIJBadgeInterceptorWrapper(null);
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IRIJBadgeInterceptor localIRIJBadgeInterceptor = (IRIJBadgeInterceptor)((Iterator)localObject).next();
      if (localIRIJBadgeInterceptor.a(paramMessageRecord))
      {
        QLog.d("KandianMergeManager", 2, "getBadgeInterceptor --> found an interceptor!");
        return new RIJBadgeInterceptorWrapper(localIRIJBadgeInterceptor);
      }
    }
    QLog.d("KandianMergeManager", 2, "getBadgeInterceptor --> no interceptor handle!");
    return new RIJBadgeInterceptorWrapper(null);
  }
  
  public String a(Long paramLong)
  {
    if (paramLong.longValue() > 0L) {
      return (String)this.I.get(paramLong);
    }
    return null;
  }
  
  public void a()
  {
    if (Aladdin.getConfig(258).getIntegerFromString("load_resources_after_login", 1) == 1) {
      ThreadManager.executeOnSubThread(new KandianMergeManager.5(this));
    }
    I();
    RIJWebArticleUtil.a.a();
    RIJMainChannelUtil.a.b();
    RIJChannelBannerUtil.a.a();
    RIJFeedsInsertUtil.a.b();
    RIJUserInfoAladdinConfig.a.a();
    VideoAudioControlUtil.a.a();
    TKDCommentFragmentHelper.a();
    RIJCommentBubbleViewHelper.a.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    KandianMergeManager.KandianSetTopInfo localKandianSetTopInfo = KandianMergeManager.KandianSetTopInfo.get(paramInt1, paramInt2);
    RIJSPUtils.a("kandian_msgtab_settop", localKandianSetTopInfo, true);
    this.D = localKandianSetTopInfo;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update kandian push msg setTop info : ");
    localStringBuilder.append(localKandianSetTopInfo);
    QLog.d("KandianMergeManager.SETTOP", 2, localStringBuilder.toString());
  }
  
  public void a(int paramInt, String paramString)
  {
    this.B = paramString;
    if (!this.B.isEmpty()) {
      ReadInJoyLogicEngine.a().b(paramInt, this.B, 0L);
    }
  }
  
  public void a(OnMainVideoTabRedChangeListener paramOnMainVideoTabRedChangeListener)
  {
    if (paramOnMainVideoTabRedChangeListener == null) {
      return;
    }
    if (this.R == null) {
      this.R = new CopyOnWriteArrayList();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add tabRedNumChangeObserver ");
    localStringBuilder.append(paramOnMainVideoTabRedChangeListener.getClass().getSimpleName());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramOnMainVideoTabRedChangeListener);
    QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
    if (!this.R.contains(paramOnMainVideoTabRedChangeListener)) {
      this.R.add(paramOnMainVideoTabRedChangeListener);
    }
  }
  
  public void a(OnTabRedNumsChangeListenner paramOnTabRedNumsChangeListenner)
  {
    if (paramOnTabRedNumsChangeListenner == null) {
      return;
    }
    if (this.Q == null) {
      this.Q = new CopyOnWriteArrayList();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add tabRedNumChangeObserver ");
    localStringBuilder.append(paramOnTabRedNumsChangeListenner.getClass().getSimpleName());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramOnTabRedNumsChangeListenner);
    QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
    if (!this.Q.contains(paramOnTabRedNumsChangeListenner)) {
      this.Q.add(paramOnTabRedNumsChangeListenner);
    }
  }
  
  public void a(ReadInJoyTabObserver paramReadInJoyTabObserver)
  {
    a(paramReadInJoyTabObserver);
    a(paramReadInJoyTabObserver);
    a(paramReadInJoyTabObserver);
    ReadInJoyLogicEngineEventDispatcher.a().a(paramReadInJoyTabObserver);
  }
  
  public void a(IRIJBadgeInterceptor paramIRIJBadgeInterceptor)
  {
    if (this.J == null) {
      this.J = new ArrayList();
    }
    this.J.add(paramIRIJBadgeInterceptor);
  }
  
  public void a(MySelfNormalItemRedPointInfo paramMySelfNormalItemRedPointInfo)
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.37(this, paramMySelfNormalItemRedPointInfo));
  }
  
  public void a(InsertArticleInfo paramInsertArticleInfo)
  {
    if (paramInsertArticleInfo == null) {
      return;
    }
    try
    {
      this.F.add(paramInsertArticleInfo);
      return;
    }
    finally
    {
      paramInsertArticleInfo = finally;
      throw paramInsertArticleInfo;
    }
  }
  
  public void a(KandianRedDotInfo paramKandianRedDotInfo)
  {
    if (paramKandianRedDotInfo == null) {
      return;
    }
    if (this.u != null)
    {
      if (paramKandianRedDotInfo.hasArticleID()) {
        this.u = paramKandianRedDotInfo;
      } else {
        QLog.d("KandianMergeManager", 1, "main video tab fake red drop because of has reddot now!");
      }
    }
    else {
      this.u = paramKandianRedDotInfo;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update mainVideoTab RedDot : ");
    localStringBuilder.append(paramKandianRedDotInfo);
    QLog.d("KandianMergeManager", 1, localStringBuilder.toString());
    J();
    this.u.saveToDiskAsync();
  }
  
  public void a(MessageObserver paramMessageObserver)
  {
    if (paramMessageObserver == null) {
      return;
    }
    try
    {
      if (this.S == null) {
        this.S = new ArrayList();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add MsgObserver ");
      localStringBuilder.append(paramMessageObserver.getClass().getSimpleName());
      localStringBuilder.append(", ");
      localStringBuilder.append(paramMessageObserver);
      QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
      if (!this.S.contains(paramMessageObserver)) {
        this.S.add(paramMessageObserver);
      }
      return;
    }
    finally {}
  }
  
  public void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    String str;
    if ((this.A != null) && (paramKandianMsgBoxRedPntInfo.mSeq <= this.A.mSeq) && (paramKandianMsgBoxRedPntInfo.mPrivateChatSeq <= this.A.mPrivateChatSeq))
    {
      str = this.B;
      if ((str == null) || (str.isEmpty()))
      {
        i1 = 1;
        break label63;
      }
    }
    int i1 = 0;
    label63:
    if ((paramKandianMsgBoxRedPntInfo != null) && (RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount(paramKandianMsgBoxRedPntInfo) > 0) && (i1 == 0))
    {
      if (!paramKandianMsgBoxRedPntInfo.isRead)
      {
        QLog.i("KandianMergeManager", 1, "updateMsgRedPntInfo setXTabRedDotShowLevel low");
        RIJXTabBadgeShowLevel.a(1);
        ThreadManager.getUIHandler().post(new KandianMergeManager.38(this));
      }
      this.A = paramKandianMsgBoxRedPntInfo;
      this.A.asyncWriteToSP();
      this.B = "";
      if (this.A.mNeedShowInFolder)
      {
        paramKandianMsgBoxRedPntInfo = this.A.mSummary;
        str = this.A.mOrangeWord;
        long l1 = this.A.mMsgTime;
        boolean bool;
        if (this.A.mRedType == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramKandianMsgBoxRedPntInfo = a(paramKandianMsgBoxRedPntInfo, str, l1, bool, false, null);
      }
      else
      {
        paramKandianMsgBoxRedPntInfo = null;
      }
      a(paramKandianMsgBoxRedPntInfo, KandianOx210MsgInfo.y, null);
      I();
      ai();
      paramKandianMsgBoxRedPntInfo = new StringBuilder();
      paramKandianMsgBoxRedPntInfo.append("update msgbox redpnt info. ");
      paramKandianMsgBoxRedPntInfo.append(this.A);
      QLog.d("KandianMergeManager", 1, paramKandianMsgBoxRedPntInfo.toString());
      return;
    }
    QLog.d("KandianMergeManager", 1, new Object[] { "new msgbox red info has error, local : ", this.A, "new : ", paramKandianMsgBoxRedPntInfo });
  }
  
  public void a(String paramString)
  {
    try
    {
      if (TextUtils.equals(paramString, this.o))
      {
        p();
        MessageRecord localMessageRecord = this.E.getMessageFacade().r(AppConstants.KANDIAN_MERGE_UIN, 7220);
        if ((localMessageRecord != null) && (localMessageRecord.extInt == 2) && (TextUtils.equals(localMessageRecord.senderuin, paramString)))
        {
          paramString = s();
          if (paramString != null)
          {
            RIJKanDianFolderStatus.updateLastKandianMsgRecord(paramString);
            this.E.getMessageFacade().a(paramString, this.E.getCurrentUin());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        return;
      }
      if (paramInt == 1) {
        return;
      }
      QQMessageFacade localQQMessageFacade = this.E.getMessageFacade();
      if (localQQMessageFacade != null) {
        ThreadManager.post(new KandianMergeManager.14(this, localQQMessageFacade, paramString1, paramString2, paramInt, paramBoolean), 10, null, false);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    RIJAppSetting.a(this.E, paramBoolean ^ true);
  }
  
  public void a(boolean paramBoolean, Class paramClass)
  {
    this.T.put(paramClass.getSimpleName(), Boolean.valueOf(paramBoolean));
    String str = paramClass.getSimpleName();
    if (BaseActivity.sTopActivity != null) {
      paramClass = BaseActivity.sTopActivity.getClass().getSimpleName();
    } else {
      paramClass = "";
    }
    if ((TextUtils.equals(str, paramClass)) && (paramBoolean)) {
      N();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      long l1 = localMsgBody.uint64_seq.get();
      long l2 = this.v.a;
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("biu 0x210Msg reached, oldSeq = ");
      paramArrayOfByte.append(l2);
      paramArrayOfByte.append(", newSeq = ");
      paramArrayOfByte.append(l1);
      QLog.d("KandianMergeManager", 1, paramArrayOfByte.toString());
      if (l2 >= l1)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("KandianMergeManager", 2, "biu 0x210Msg delay reached, no updated!");
        return;
      }
      if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.has()) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.get() != null) && (((submsgtype0xc5.BiuBody)((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.get()).uint64_biu_uin.has()))
      {
        l2 = ((submsgtype0xc5.BiuBody)((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.get()).uint64_biu_uin.get();
        this.v.a = l1;
        this.v.b = l2;
        this.v.c = 0;
        this.v.a(this.E);
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("has biu 0x210 msg push, seq = ");
        paramArrayOfByte.append(l1);
        paramArrayOfByte.append(", uin = ");
        paramArrayOfByte.append(l2);
        QLog.d("KandianMergeManager", 1, paramArrayOfByte.toString());
        a(null, KandianOx210MsgInfo.z, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return;
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    Kandian210Msg0xeeInfo localKandian210Msg0xeeInfo = Kandian210Msg0xeeInfo.decodeFromPbBytes(paramArrayOfByte);
    if (localKandian210Msg0xeeInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "process 0x210 sub 0xee msg fail!");
      }
      return;
    }
    if ((this.C != null) && (localKandian210Msg0xeeInfo.msgSeq < this.C.msgSeq)) {
      return;
    }
    if ((localKandian210Msg0xeeInfo.notifyInfos != null) && (!localKandian210Msg0xeeInfo.notifyInfos.isEmpty()))
    {
      paramArrayOfByte = localKandian210Msg0xeeInfo.notifyInfos;
      boolean bool = false;
      if (!TextUtils.isEmpty(((Kandian210Msg0xeeInfo.NotifyInfo)paramArrayOfByte.get(0)).contextTitle))
      {
        if (c("processMsg0x210Sub0xee"))
        {
          a(a(localKandian210Msg0xeeInfo));
          return;
        }
        Kandian210Msg0xeeInfo.NotifyInfo localNotifyInfo;
        if (localKandian210Msg0xeeInfo.isArticleAppInPush())
        {
          this.a = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).algorithmID;
          this.b = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).strategyID;
          this.c = ReadInJoyStringUtils.a(((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).extCookie, 0);
          localObject = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).orangeWord;
          paramArrayOfByte = (byte[])localObject;
          if (localObject == null) {
            paramArrayOfByte = HardCodeUtil.a(2131903865);
          }
          this.j = new ArrayList();
          localObject = localKandian210Msg0xeeInfo.notifyInfos.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localNotifyInfo = (Kandian210Msg0xeeInfo.NotifyInfo)((Iterator)localObject).next();
            this.j.add(0, Long.valueOf(localNotifyInfo.contextId));
          }
          paramArrayOfByte = a(((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).contextTitle, paramArrayOfByte, paramLong, this.b, this.a, ((Long)this.j.get(0)).longValue(), ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).folderStatus);
          if (paramArrayOfByte != null) {
            g(paramArrayOfByte);
          }
          j(paramArrayOfByte);
        }
        else
        {
          paramArrayOfByte = "KandianMergeManager";
          if (!localKandian210Msg0xeeInfo.isVideoAppInPush()) {
            break label501;
          }
          if (!ReadInJoyHelper.v())
          {
            QLog.d(paramArrayOfByte, 2, "received video app in push , but user is not in video tab, drop it as wife");
            return;
          }
          paramArrayOfByte = new KandianRedDotInfo("kandian_video_tab_reddot_info");
          localObject = (Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0);
          paramArrayOfByte.algorithmID = ((Kandian210Msg0xeeInfo.NotifyInfo)localObject).algorithmID;
          paramArrayOfByte.cookie = Html.fromHtml(((Kandian210Msg0xeeInfo.NotifyInfo)localObject).extCookie).toString();
          localObject = localKandian210Msg0xeeInfo.notifyInfos.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localNotifyInfo = (Kandian210Msg0xeeInfo.NotifyInfo)((Iterator)localObject).next();
            paramArrayOfByte.articleIDList.add(0, Long.valueOf(localNotifyInfo.contextId));
          }
          a(paramArrayOfByte);
          J();
        }
        bool = true;
        break label540;
        label501:
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("received unknow app in push, bid ");
        ((StringBuilder)localObject).append(localKandian210Msg0xeeInfo.bid);
        QLog.d(paramArrayOfByte, 2, ((StringBuilder)localObject).toString());
        label540:
        if (bool)
        {
          this.C = localKandian210Msg0xeeInfo;
          Kandian210Msg0xeeInfo.writeToSpAsync(this.C);
          N();
        }
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("process Msg 210 0xee canHandle : ");
        paramArrayOfByte.append(bool);
        paramArrayOfByte.append("\n InAppPush : ");
        paramArrayOfByte.append(localKandian210Msg0xeeInfo);
        QLog.d("KandianMergeManager", 2, paramArrayOfByte.toString());
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("0x210 sub 0xee msg title empty, just abandon ");
      paramArrayOfByte.append(localKandian210Msg0xeeInfo);
      QLog.d("KandianMergeManager", 2, paramArrayOfByte.toString());
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, IKanDianMergeManagerCallBack paramIKanDianMergeManagerCallBack)
  {
    int i1 = KandianOx210MsgInfo.d(paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("processMsg0x210Sub0xc5, receiveMsg bidType= ");
    localStringBuilder.append(i1);
    QLog.i("KandianMergeManager", 1, localStringBuilder.toString());
    if (i1 == 2)
    {
      b(paramArrayOfByte, paramLong);
      return;
    }
    b(paramArrayOfByte, paramLong, paramIKanDianMergeManagerCallBack);
  }
  
  public boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    try
    {
      l1 = paramMessageRecord.time;
      str2 = paramMessageRecord.senderuin;
      i2 = paramMessageRecord.msgtype;
      str1 = "";
      if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("kandian_replace_subscribe_msg")))
      {
        paramMessageRecord = (ReadInJoyLogicManager)this.E.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
        if (paramMessageRecord != null) {
          paramMessageRecord.getReadInJoyLogicEngine().b(this.E.getLongAccountUin());
        }
        return false;
      }
      if (l1 <= this.n.get()) {
        break label568;
      }
      localObject1 = str1;
      if (paramBoolean) {
        break label597;
      }
      this.q = "";
      this.r = "";
      this.s = Long.valueOf(-1L);
      if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isInterestAccountOrUnSupportMsgType(this.E, str2, paramMessageRecord.msgtype))
      {
        localObject1 = "";
        bool = true;
        break label392;
      }
      if (!(paramMessageRecord instanceof MessageForStructing)) {
        break label366;
      }
      localObject2 = (MessageForStructing)paramMessageRecord;
      ((MessageForStructing)localObject2).parse();
      localObject1 = str1;
      if (((MessageForStructing)localObject2).structingMsg == null) {
        break label597;
      }
      str1 = PkgTools.toHexStr(((MessageForStructing)localObject2).structingMsg.getBytes());
      this.q = ((MessageForStructing)localObject2).structingMsg.mMsgBrief;
      if (TextUtils.isEmpty(((MessageForStructing)localObject2).structingMsg.mInnerUniqIds)) {
        break label285;
      }
      localObject2 = ((MessageForStructing)localObject2).structingMsg.mInnerUniqIds.split("\\|");
      i3 = localObject2.length;
      i1 = 0;
    }
    finally
    {
      for (;;)
      {
        long l1;
        String str2;
        int i2;
        String str1;
        Object localObject1;
        Object localObject2;
        int i3;
        int i1;
        label285:
        label568:
        for (;;)
        {
          label366:
          throw paramMessageRecord;
        }
        label392:
        i1 += 1;
        continue;
        label590:
        i1 += 1;
        continue;
        label597:
        boolean bool = false;
      }
    }
    localObject1 = str1;
    if (i1 < i3)
    {
      localObject1 = localObject2[i1];
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.r = ((String)localObject1);
        localObject1 = str1;
        break label597;
        localObject1 = str1;
        if (TextUtils.isEmpty(((MessageForStructing)localObject2).structingMsg.mArticleIds)) {
          break label597;
        }
        localObject2 = ((MessageForStructing)localObject2).structingMsg.mArticleIds.split("\\|");
        i3 = localObject2.length;
        i1 = 0;
        localObject1 = str1;
        if (i1 >= i3) {
          break label597;
        }
        localObject1 = localObject2[i1];
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label590;
        }
        this.s = Long.valueOf((String)localObject1);
        localObject1 = str1;
        break label597;
        localObject1 = str1;
        if (!QLog.isColorLevel()) {
          break label597;
        }
        QLog.d("KandianMergeManager", 2, "parse subscribe push struct msg fail !");
        localObject1 = str1;
        break label597;
        this.n.set(l1);
        this.l.set(1);
        this.o = str2;
        this.m.set(1);
        this.p.set(i2);
        if ((paramBoolean) || (!ReadInJoyHelper.w())) {
          r();
        }
        ThreadManager.getSubThreadHandler().post(new KandianMergeManager.22(this, l1, str2, 1, (String)localObject1, i2));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("subscribe push, title : ");
        ((StringBuilder)localObject1).append(this.q);
        ((StringBuilder)localObject1).append(", id : ");
        ((StringBuilder)localObject1).append(this.s);
        ((StringBuilder)localObject1).append(", msguid : ");
        ((StringBuilder)localObject1).append(paramMessageRecord.msgUid);
        ((StringBuilder)localObject1).append(", isInterestedAccount : ");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject1).toString());
        return true;
        return false;
      }
    }
  }
  
  public int b()
  {
    return this.z;
  }
  
  public MessageRecord b(MessageRecord paramMessageRecord)
  {
    IRIJBadgeInterceptor localIRIJBadgeInterceptor = a(paramMessageRecord);
    if (localIRIJBadgeInterceptor.b(paramMessageRecord)) {
      return null;
    }
    if (d(paramMessageRecord)) {
      return null;
    }
    if (l(paramMessageRecord)) {
      return null;
    }
    int i1 = localIRIJBadgeInterceptor.c(paramMessageRecord);
    if (i1 == 0)
    {
      if (!f(paramMessageRecord)) {
        return null;
      }
    }
    else if (i1 == -1) {
      return null;
    }
    n(paramMessageRecord);
    i1 = c(paramMessageRecord);
    MessageRecord localMessageRecord = a(paramMessageRecord, i1);
    if (!localIRIJBadgeInterceptor.d(localMessageRecord)) {
      if (i1 == 0)
      {
        j(localMessageRecord);
      }
      else if (i1 == 1)
      {
        k(localMessageRecord);
        I();
      }
    }
    RIJKanDianFolderStatus.updateLastKandianMsgRecord(localMessageRecord);
    m(paramMessageRecord);
    return localMessageRecord;
  }
  
  public MessageRecord b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)MessageRecordFactory.a(-2011);
    localMessageForStructing.istroop = 7220;
    localMessageForStructing.selfuin = this.E.getCurrentUin();
    localMessageForStructing.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageForStructing.senderuin = AppConstants.NEW_KANDIAN_UIN;
    localMessageForStructing.time = RIJMergeKanDianMessage.c(this.E);
    localMessageForStructing.isread = false;
    localMessageForStructing.issend = 0;
    localMessageForStructing.extInt = 1;
    localMessageForStructing.extLong |= 0x20000000;
    localMessageForStructing.extLong |= 0x1;
    localMessageForStructing.structingMsg = StructMsgFactory.a(this.E, localMessageForStructing.istroop, Long.valueOf(localMessageForStructing.senderuin).longValue(), paramString.getBytes(), 0);
    if (localMessageForStructing.structingMsg == null) {
      return null;
    }
    localMessageForStructing.msg = localMessageForStructing.structingMsg.mMsgBrief;
    localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
    b(localMessageForStructing, 1);
    if (!f(localMessageForStructing)) {
      return null;
    }
    paramString = this.E.getMessageFacade();
    RIJKanDianFolderStatus.updateLastKandianMsgRecord(localMessageForStructing);
    paramString.a(localMessageForStructing, this.E.getCurrentUin());
    return localMessageForStructing;
  }
  
  public JSONObject b(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramKandianMsgBoxRedPntInfo == null) {
      return localJSONObject;
    }
    try
    {
      localJSONObject.put("redCount", RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount(paramKandianMsgBoxRedPntInfo));
      localJSONObject.put("iconUrl", paramKandianMsgBoxRedPntInfo.mIconUrl);
      localJSONObject.put("jumpUrl", paramKandianMsgBoxRedPntInfo.mJumpUrl);
      localJSONObject.put("uin", paramKandianMsgBoxRedPntInfo.mUin);
      return localJSONObject;
    }
    catch (JSONException paramKandianMsgBoxRedPntInfo)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getMessageBarInfo] e = ");
      localStringBuilder.append(paramKandianMsgBoxRedPntInfo);
      QLog.e("KandianMergeManager", 1, localStringBuilder.toString());
    }
    return localJSONObject;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("followListLength");
      localStringBuilder.append(paramInt);
      QLog.i("KandianMergeManager", 2, localStringBuilder.toString());
    }
    this.z = paramInt;
    ThreadManager.post(new KandianMergeManager.12(this, paramInt), 8, null, false);
  }
  
  public void b(MessageRecord paramMessageRecord, int paramInt)
  {
    if (paramMessageRecord == null) {
      return;
    }
    try
    {
      boolean bool = TextUtils.isEmpty(paramMessageRecord.extStr);
      if (bool)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("kandian_push_from", paramInt);
        paramMessageRecord.extStr = localJSONObject.toString();
        return;
      }
      JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
      localJSONObject.put("kandian_push_from", paramInt);
      paramMessageRecord.extStr = localJSONObject.toString();
      return;
    }
    catch (JSONException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
  }
  
  public void b(OnMainVideoTabRedChangeListener paramOnMainVideoTabRedChangeListener)
  {
    if (paramOnMainVideoTabRedChangeListener != null)
    {
      Object localObject = this.R;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("remove tabRedNumChangeObserver ");
        ((StringBuilder)localObject).append(paramOnMainVideoTabRedChangeListener.getClass().getSimpleName());
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramOnMainVideoTabRedChangeListener);
        QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject).toString());
        this.R.remove(paramOnMainVideoTabRedChangeListener);
      }
    }
  }
  
  public void b(OnTabRedNumsChangeListenner paramOnTabRedNumsChangeListenner)
  {
    if (paramOnTabRedNumsChangeListenner == null) {
      return;
    }
    Object localObject = this.Q;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("remove tabRedNumChangeObserver ");
      ((StringBuilder)localObject).append(paramOnTabRedNumsChangeListenner.getClass().getSimpleName());
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramOnTabRedNumsChangeListenner);
      QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject).toString());
      this.Q.remove(paramOnTabRedNumsChangeListenner);
    }
  }
  
  public void b(ReadInJoyTabObserver paramReadInJoyTabObserver)
  {
    b(paramReadInJoyTabObserver);
    b(paramReadInJoyTabObserver);
    b(paramReadInJoyTabObserver);
    ReadInJoyLogicEngineEventDispatcher.a().b(paramReadInJoyTabObserver);
  }
  
  public void b(MessageObserver paramMessageObserver)
  {
    if (paramMessageObserver == null) {
      return;
    }
    try
    {
      if ((this.S != null) && (!this.S.isEmpty()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("remove MsgObserver ");
        localStringBuilder.append(paramMessageObserver.getClass().getSimpleName());
        localStringBuilder.append(", ");
        localStringBuilder.append(paramMessageObserver);
        QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
        this.S.remove(paramMessageObserver);
        return;
      }
      return;
    }
    finally {}
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("erasureTabRedWhenSwitchTab from: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", to: ");
      localStringBuilder.append(paramInt2);
      QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
    }
    if ((paramInt1 != 0) && (paramInt2 == 0)) {
      return false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return true;
    }
    if ((paramInt1 != 1) && (paramInt2 == 1))
    {
      if (e(1) > 0) {
        ThreadManager.getSubThreadHandler().post(new KandianMergeManager.31(this));
      }
      f(1);
      return true;
    }
    if ((paramInt1 == 1) && (paramInt2 == 1))
    {
      if (e(1) > 0) {
        ThreadManager.getSubThreadHandler().post(new KandianMergeManager.32(this));
      }
      f(1);
      return true;
    }
    if (paramInt2 == 2)
    {
      f(2);
      return true;
    }
    if ((paramInt2 == 3) && (e(3) > 0)) {}
    return false;
  }
  
  @VisibleForTesting
  int c(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord, this.E);
  }
  
  public void c(int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    if (this.l.get() != 0) {
      p();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean c()
  {
    return this.g.get() > 0;
  }
  
  public void d(int paramInt)
  {
    if (paramInt == 3) {}
    try
    {
      if (this.m.get() == 2)
      {
        p();
        return;
      }
      this.l.set(0);
      this.m.set(paramInt);
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.23(this, paramInt));
      return;
    }
    finally {}
  }
  
  public void d(boolean paramBoolean)
  {
    Object localObject = (IRedTouchManager)this.E.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (paramBoolean)
    {
      localAppInfo = ((IRedTouchManager)localObject).getNumRedPointInfo(7, "1130");
      if (localAppInfo != null) {
        ((IRedTouchManager)localObject).onRedTouchItemClick(localAppInfo, "");
      }
    }
    else
    {
      localAppInfo = ((IRedTouchManager)localObject).getAppInfoByPath("1130");
      if (localAppInfo != null) {
        ((IRedTouchManager)localObject).onRedTouchItemClick(localAppInfo, "");
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportRedPntClick, isNumRedPnt : ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject).toString());
  }
  
  public boolean d()
  {
    if (!ReadInJoyHelper.a(this.E)) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubUnread : ");
    localStringBuilder.append(this.l.get());
    localStringBuilder.append(", SubStatus : ");
    localStringBuilder.append(this.m.get());
    localStringBuilder.append(", mSubTitle : ");
    localStringBuilder.append(RIJAppSetting.b(this.q));
    localStringBuilder.append(", KDUnread : ");
    localStringBuilder.append(this.g.get());
    QLog.d("KandianMergeManager", 1, localStringBuilder.toString());
    if ((this.g.get() <= 0) && ((this.l.get() <= 0) || (this.m.get() != 1)) && ((this.l.get() > 0) || (this.m.get() != 3) || (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isInterestAccount(this.E, this.o)))) {
      return false;
    }
    if ((ReadInJoyHelper.w()) && (this.g.get() <= 0) && (this.s.longValue() <= 0L) && (TextUtils.isEmpty(this.r)))
    {
      QLog.d("KandianMergeManager", 2, "subscribe push has not article id , give up auto refresh! only for kandian tab");
      return false;
    }
    return true;
  }
  
  @VisibleForTesting
  boolean d(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      Object localObject = this.E;
      if (localObject == null) {
        return true;
      }
      if ((a(paramMessageRecord, (AppInterface)localObject) == 0) && (ReadInJoyUtils.a(this.E))) {
        return true;
      }
      if ((RIJPushNotification.a(paramMessageRecord)) && (RIJLockScreenPushReport.a(paramMessageRecord)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("receive daily lock screen red point push ! mr : ");
        ((StringBuilder)localObject).append(paramMessageRecord);
        QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject).toString());
        ((KandianDailyManager)this.E.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a(paramMessageRecord);
        return true;
      }
      return false;
    }
    return true;
  }
  
  public int e(int paramInt)
  {
    int i1 = 1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3)
          {
            i1 = H();
            break label74;
          }
        }
        else if (this.w != null) {
          break label74;
        }
      }
      else
      {
        i1 = this.t.get();
        if (i1 > 0) {
          break label74;
        }
      }
    }
    else
    {
      i1 = this.g.get();
      if (i1 >= 0) {
        break label74;
      }
    }
    i1 = 0;
    label74:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTabRedNums tab: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", nums: ");
      localStringBuilder.append(i1);
      QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
    }
    return i1;
  }
  
  public KandianRedDotInfo e()
  {
    return this.k;
  }
  
  public void e(MessageRecord paramMessageRecord)
  {
    
    if ((paramMessageRecord != null) && (!paramMessageRecord.isread))
    {
      paramMessageRecord.isread = true;
      ThreadManager.post(new KandianMergeManager.21(this, paramMessageRecord), 10, null, false);
    }
  }
  
  public KandianRedDotInfo f()
  {
    return this.H;
  }
  
  public void f(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("erasureTabRed index: ");
    localStringBuilder.append(paramInt);
    localStringBuilder = new StringBuilder(localStringBuilder.toString());
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          if (e(paramInt) <= 0) {
            ReadInJoyLogicEngine.a().P();
          }
          localStringBuilder.append(", subscribe msg successful");
        }
      }
      else {
        this.t.set(0);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
    }
    I();
  }
  
  public boolean f(MessageRecord paramMessageRecord)
  {
    int i1 = a(paramMessageRecord, this.E);
    if (i1 == 0) {
      return h(paramMessageRecord);
    }
    if (i1 == 1) {
      return a(paramMessageRecord, false);
    }
    return false;
  }
  
  public List<Long> g()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = RIJXTabBadgeStore.a;
    localObject = RIJXTabBadgeStore.b(0);
    if ((RIJXTabConfigHandler.INSTANCE.isXTabMode()) && (localObject != null)) {}
    try
    {
      long l1 = Long.parseLong(((RIJXTabRedDotInfo)localObject).getArticleIds());
      long l2 = Long.parseLong(((RIJXTabRedDotInfo)localObject).getAlgorithmIds());
      long l3 = Long.parseLong(((RIJXTabRedDotInfo)localObject).getStrategyIds());
      localArrayList.add(Long.valueOf(l1));
      localArrayList.add(Long.valueOf(l2));
      localArrayList.add(Long.valueOf(l3));
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      label96:
      StringBuilder localStringBuilder;
      break label96;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getKandianArticleIdsWhenRefreshKandian failed --> ");
    localStringBuilder.append(localObject);
    QLog.e("KandianMergeManager", 2, localStringBuilder.toString());
    if (!ReadInJoyHelper.a(this.E)) {
      return localArrayList;
    }
    if (this.g.get() == 0) {
      return localArrayList;
    }
    localObject = this.j;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      localArrayList.addAll(this.j);
    }
    localObject = this.j;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localArrayList.add(Long.valueOf(this.a));
      localArrayList.add(Long.valueOf(this.b));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getKandianArticleIdsWhenRefreshKandian: ");
    ((StringBuilder)localObject).append(localArrayList.toString());
    QLog.i("KandianMergeManager", 1, ((StringBuilder)localObject).toString());
    return localArrayList;
  }
  
  public boolean g(MessageRecord paramMessageRecord)
  {
    try
    {
      AbsStructMsg localAbsStructMsg = StructMsgFactory.b();
      localAbsStructMsg.uin = paramMessageRecord.frienduin;
      localAbsStructMsg.currentAccountUin = paramMessageRecord.selfuin;
      localAbsStructMsg.mMsgBrief = paramMessageRecord.msg;
      localAbsStructMsg.mMsgActionData = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append((Long)localIterator.next());
        localStringBuilder.append("|");
      }
      localAbsStructMsg.mArticleIds = localStringBuilder.toString();
      localAbsStructMsg.mAlgorithmIds = String.valueOf(this.a);
      localAbsStructMsg.mStrategyIds = String.valueOf(this.b);
      long l1 = paramMessageRecord.time;
      paramMessageRecord = PkgTools.toHexStr(localAbsStructMsg.getBytes());
      if (l1 > this.h.get())
      {
        this.h.set(l1);
        this.g.set(1);
        ThreadManager.getSubThreadHandler().post(new KandianMergeManager.25(this, paramMessageRecord, l1));
        if ((this.l.get() > 0) && (this.m.get() != 2)) {
          d(2);
        } else if ((this.l.get() <= 0) && (this.m.get() == 3)) {
          p();
        }
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("0xee push, ids: ");
          paramMessageRecord.append(this.j);
          QLog.d("KandianMergeManager", 2, paramMessageRecord.toString());
        }
        return true;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramMessageRecord;
    }
  }
  
  public String h()
  {
    return this.c;
  }
  
  public boolean h(MessageRecord paramMessageRecord)
  {
    try
    {
      if (c("updateKandianPush2SP"))
      {
        a(p(paramMessageRecord));
        return false;
      }
      if (ReadInJoyLockScreenJumpDelegate.a(paramMessageRecord))
      {
        if (RIJPushNotification.a(paramMessageRecord)) {
          this.H = RIJKanDianRedDotUtils.a(paramMessageRecord, "kandian_red_pnt_lock_screen");
        }
        QLog.i("KandianMergeManager", 1, "updateKandianPush2SP: block lock screen red dot.");
        return true;
      }
      if (!(paramMessageRecord instanceof MessageForStructing)) {
        break label695;
      }
      localObject1 = (MessageForStructing)paramMessageRecord;
      ((MessageForStructing)localObject1).parse();
      if (((MessageForStructing)localObject1).structingMsg == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "kandian push msg : struct msg body is null");
        }
        return false;
      }
      localObject1 = PkgTools.toHexStr(((MessageForStructing)paramMessageRecord).structingMsg.getBytes());
      l1 = paramMessageRecord.time;
      if (paramMessageRecord.time < this.h.get()) {
        break label695;
      }
      if (TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mArticleIds)) {
        break label287;
      }
      localObject2 = ((MessageForStructing)paramMessageRecord).structingMsg.mArticleIds.split("\\|");
      this.j = new ArrayList();
      i1 = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        long l1;
        Object localObject2;
        int i1;
        int i2;
        for (;;)
        {
          label287:
          label695:
          throw paramMessageRecord;
        }
        label710:
        i1 += 1;
      }
    }
    i2 = localObject2.length;
    if (i1 < i2)
    {
      try
      {
        if (TextUtils.isEmpty(localObject2[i1])) {
          break label710;
        }
        BigInteger localBigInteger = new BigInteger(localObject2[i1]);
        this.j.add(Long.valueOf(localBigInteger.longValue()));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse kandian push articleID has num format error : ");
        localStringBuilder.append(localNumberFormatException);
        QLog.e("KandianMergeManager", 1, localStringBuilder.toString());
      }
    }
    else
    {
      this.c = ((MessageForStructing)paramMessageRecord).structingMsg.mMsgActionData;
      if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mAlgorithmIds)) {
        this.a = Long.parseLong(((MessageForStructing)paramMessageRecord).structingMsg.mAlgorithmIds.split("\\|")[0]);
      }
      if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mStrategyIds)) {
        this.b = Long.parseLong(((MessageForStructing)paramMessageRecord).structingMsg.mStrategyIds.split("\\|")[0]);
      }
      this.h.set(paramMessageRecord.time);
      this.g.set(1);
      if ((RIJPushNotification.a(paramMessageRecord)) && (this.j != null))
      {
        this.k = RIJKanDianRedDotUtils.a(paramMessageRecord, "kandian_red_pnt_lock_screen");
        if (this.k != null)
        {
          this.k.saveToDiskAsync();
          if (this.k.hasArticleID())
          {
            localObject2 = this.k.articleIDList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Long localLong = (Long)((Iterator)localObject2).next();
              this.I.put(localLong, this.k.extInfo);
            }
          }
        }
      }
      this.H = RIJKanDianRedDotUtils.a(paramMessageRecord, "kandian_red_pnt_lock_screen");
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.26(this, (String)localObject1, l1));
      if ((this.l.get() > 0) && (this.m.get() != 2)) {
        d(2);
      } else if ((this.l.get() <= 0) && (this.m.get() == 3)) {
        p();
      }
      q();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("kandian push, ids: ");
      ((StringBuilder)localObject1).append(this.j);
      ((StringBuilder)localObject1).append(", msgUid : ");
      ((StringBuilder)localObject1).append(paramMessageRecord.msgUid);
      ((StringBuilder)localObject1).append(", isLockScreenMsg : ");
      ((StringBuilder)localObject1).append(RIJPushNotification.a(paramMessageRecord));
      ((StringBuilder)localObject1).append(", pushContent : ");
      ((StringBuilder)localObject1).append(this.c);
      QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject1).toString());
      return true;
      return false;
    }
  }
  
  public int i(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return -1;
    }
    if (TextUtils.isEmpty(paramMessageRecord.extStr)) {
      return -1;
    }
    try
    {
      paramMessageRecord = new JSONObject(paramMessageRecord.extStr);
      if (paramMessageRecord.has("kandian_push_from"))
      {
        int i1 = Integer.parseInt(paramMessageRecord.getString("kandian_push_from"));
        return i1;
      }
      return -1;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
    return -1;
  }
  
  public Pair<Object, String> i()
  {
    if ((ReadInJoyHelper.a(this.E)) && ((this.l.get() > 0) || (this.m.get() == 3)))
    {
      if ((this.l.get() > 0) && (this.m.get() == 2)) {
        return null;
      }
      d(2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mSubscribePushMsgTitle : ");
      localStringBuilder.append(RIJAppSetting.b(this.q));
      localStringBuilder.append(" mSubscribePushMsgArticleID : ");
      localStringBuilder.append(this.s);
      localStringBuilder.append(" mInnerUniqId : ");
      localStringBuilder.append(this.r);
      localStringBuilder.append(" seedUIN :  ");
      localStringBuilder.append(this.o);
      localStringBuilder.append(", isInterestedAccount : ");
      localStringBuilder.append(((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isInterestAccountOrUnSupportMsgType(this.E, this.o, this.p.get()));
      QLog.d("KandianMergeManager", 1, localStringBuilder.toString());
      if (!TextUtils.isEmpty(this.q))
      {
        if ((TextUtils.isEmpty(this.r)) && (this.s.longValue() == -1L)) {
          return null;
        }
        if (!TextUtils.isEmpty(this.r)) {
          return new Pair(this.r, this.q);
        }
        return new Pair(this.s, this.q);
      }
    }
    return null;
  }
  
  @VisibleForTesting
  void j(MessageRecord paramMessageRecord)
  {
    Object localObject = this.S;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MessageObserver)((Iterator)localObject).next()).a(paramMessageRecord);
      }
    }
  }
  
  public boolean j()
  {
    return ReadInJoyUtils.a(this.E) ^ true;
  }
  
  public void k(MessageRecord paramMessageRecord)
  {
    Object localObject = this.S;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((MessageObserver)((Iterator)localObject).next()).b(paramMessageRecord);
      }
    }
  }
  
  public boolean k()
  {
    return false;
  }
  
  public void l()
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.E.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("1130");
    if (localAppInfo != null) {
      localIRedTouchManager.onRedTouchItemExposure(localAppInfo, "");
    }
    localAppInfo = localIRedTouchManager.getNumRedPointInfo(7, "1130");
    if (localAppInfo != null) {
      localIRedTouchManager.onRedTouchItemExposure(localAppInfo, "");
    }
    QLog.d("KandianMergeManager", 1, "reportRedPntExposure");
  }
  
  @VisibleForTesting
  MessageRecord m()
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.E.getRuntimeService(IRedTouchManager.class, "");
    Object localObject1 = null;
    if (localIRedTouchManager == null)
    {
      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | RedTouchManager is null ");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = localIRedTouchManager.getAppInfoByPath("1130");
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    localObject2 = localIRedTouchManager.getNumRedPointInfo(7, "1130");
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("handlerRedPntCenterNotify | receive a red point push notify, size : ");
    ((StringBuilder)localObject2).append(localArrayList.size());
    QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject2).toString());
    int i1 = 0;
    while (i1 < localArrayList.size())
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localArrayList.get(i1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handlerRedPntCenterNotify | parse redPntInfo type :  ");
      ((StringBuilder)localObject2).append(localAppInfo.type.get());
      QLog.d("KandianMergeManager", 1, ((StringBuilder)localObject2).toString());
      localObject2 = Aladdin.getConfig(186);
      if (localAppInfo.type.get() == 5)
      {
        a(localIRedTouchManager, 1130, localAppInfo, (AladdinConfig)localObject2);
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = localObject1;
        if (localAppInfo.type.get() == 0) {
          localObject2 = a((MessageRecord)localObject1, localAppInfo);
        }
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify end !");
    return localObject1;
  }
  
  public void n()
  {
    if (ReadInJoyHelper.w())
    {
      QLog.d("KandianMergeManager", 2, "cleanKandianMergeSummary : isShowKandianTab give up clean !");
      return;
    }
    if (this.l.get() != 0)
    {
      if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isInterestAccountOrUnSupportMsgType(this.E, this.o, this.p.get()))
      {
        p();
        i1 = 1;
        break label92;
      }
      if (this.m.get() == 2) {
        p();
      } else {
        d(3);
      }
    }
    int i1 = 0;
    label92:
    Object localObject1 = TroopBarAssistantManager.a();
    if (localObject1 != null) {
      ((TroopBarAssistantManager)localObject1).e(this.E);
    }
    if (i1 != 0)
    {
      localObject1 = this.E.getMessageFacade().r(AppConstants.KANDIAN_MERGE_UIN, 7220);
      long l1;
      if (localObject1 != null)
      {
        if (((MessageRecord)localObject1).extInt != 1)
        {
          if (((MessageRecord)localObject1).extInt == 3) {
            return;
          }
          l1 = ((MessageRecord)localObject1).time;
        }
      }
      else {
        l1 = NetConnInfoCenter.getServerTime();
      }
      localObject1 = s();
      if (localObject1 == null)
      {
        localObject1 = this.E.getApp().getResources().getString(2131892963);
      }
      else if ((((MessageRecord)localObject1).extInt == 1) && ((localObject1 instanceof MessageForStructing)))
      {
        localObject2 = (MessageForStructing)localObject1;
        ((MessageForStructing)localObject2).parse();
        if (((MessageForStructing)localObject2).structingMsg == null) {
          localObject1 = ((MessageRecord)localObject1).msg;
        } else {
          localObject1 = ((MessageForStructing)localObject2).structingMsg.mMsgBrief;
        }
      }
      else
      {
        localObject1 = ((MessageRecord)localObject1).msg;
      }
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.E.getApp().getResources().getString(2131892963);
      }
      localObject1 = a((String)localObject2, String.valueOf(l1), 0);
      RIJKanDianFolderStatus.updateLastKandianMsgRecord((MessageRecord)localObject1);
      this.E.getMessageFacade().a((MessageRecord)localObject1, this.E.getCurrentUin());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cleanKandianMergeSummary : last msg is interested account,replace by kandian. ");
        ((StringBuilder)localObject2).append(((MessageRecord)localObject1).msg);
        QLog.d("KandianMergeManager", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void o()
  {
    RIJKanDianFolderStatus.setLastKandianMsgRead();
    MessageRecord localMessageRecord = this.E.getMessageFacade().r(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if ((localMessageRecord != null) && (!localMessageRecord.isread))
    {
      localMessageRecord.isread = true;
      ThreadManager.post(new KandianMergeManager.20(this, localMessageRecord), 10, null, false);
    }
  }
  
  public void onDestroy()
  {
    ReadInJoyHelper.r();
    ak();
    Object localObject = this.E;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.U);
      this.E.unRegistObserver(this.P);
    }
    ReadInJoyDataProviderObserver.getInstance().setReport(null);
    localObject = this.Q;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.S;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    if (this.K != null) {
      this.E.getMessageFacade().deleteObserver(this.K);
    }
    if (this.L != null) {
      SimpleEventBus.getInstance().unRegisterReceiver(this.L);
    }
    SneakyCallback.d();
    aa();
    ac();
    ProteusPreloadManager.a.b();
  }
  
  public void p()
  {
    try
    {
      this.l.set(0);
      this.n.set(0L);
      this.o = "";
      this.m.set(-1);
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.24(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void q()
  {
    try
    {
      this.C = null;
      Kandian210Msg0xeeInfo.removeKandian210Msg0xeeInfoFromSp();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void r()
  {
    try
    {
      this.g.set(0);
      this.h.set(0L);
      if (this.j != null) {
        this.j.clear();
      }
      this.a = 0L;
      this.b = 0L;
      this.c = null;
      if (this.k != null) {
        this.k.removeFromDiskAsync(true);
      }
      this.k = null;
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.27(this));
      return;
    }
    finally {}
  }
  
  public MessageRecord s()
  {
    Object localObject = this.E.getMessageFacade().h(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if (localObject != null)
    {
      int i1 = ((List)localObject).size() - 1;
      while (i1 >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i1);
        if ((localMessageRecord.extInt != 2) && (localMessageRecord.extInt != 4) && (localMessageRecord.isValid) && (!MsgProxyUtils.b(localMessageRecord.msgtype))) {
          break label93;
        }
        i1 -= 1;
      }
    }
    MessageRecord localMessageRecord = null;
    label93:
    localObject = localMessageRecord;
    if (localMessageRecord == null) {
      localObject = this.E.getMessageFacade().a(AppConstants.KANDIAN_MERGE_UIN, 7220, "extInt=1 OR extInt=3");
    }
    return localObject;
  }
  
  public MessageRecord t()
  {
    Object localObject = this.E.getMessageFacade().h(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if (localObject != null)
    {
      int i1 = ((List)localObject).size() - 1;
      while (i1 >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i1);
        if ((localMessageRecord.extInt != 2) && (localMessageRecord.extInt != 4) && (localMessageRecord.extInt != 3) && ((localMessageRecord.extInt != 5) || (w())) && (localMessageRecord.isValid) && (!MsgProxyUtils.b(localMessageRecord.msgtype))) {
          break label119;
        }
        i1 -= 1;
      }
    }
    MessageRecord localMessageRecord = null;
    label119:
    localObject = localMessageRecord;
    if (localMessageRecord == null) {
      localObject = this.E.getMessageFacade().a(AppConstants.KANDIAN_MERGE_UIN, 7220, "extInt=1");
    }
    return localObject;
  }
  
  public void u()
  {
    RIJKanDianFolderStatus.setLastKandianMsgRead();
    ConversationFacade localConversationFacade = this.E.getMessageFacade().a();
    String str;
    int i1;
    if (ReadInJoyHelper.a(this.E))
    {
      str = AppConstants.KANDIAN_MERGE_UIN;
      i1 = 7220;
    }
    else
    {
      str = AppConstants.NEW_KANDIAN_UIN;
      i1 = 1008;
    }
    if ((localConversationFacade != null) && (localConversationFacade.a(str, i1) > 0)) {
      ThreadManager.post(new KandianMergeManager.28(this, str, i1), 8, null, false);
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo v()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean w()
  {
    return false;
  }
  
  public long x()
  {
    KandianOx210MsgInfo localKandianOx210MsgInfo = this.w;
    if (localKandianOx210MsgInfo != null) {
      return localKandianOx210MsgInfo.f;
    }
    return 0L;
  }
  
  public int y()
  {
    KandianOx210MsgInfo localKandianOx210MsgInfo = this.w;
    if (localKandianOx210MsgInfo != null) {
      return localKandianOx210MsgInfo.g;
    }
    return 0;
  }
  
  public boolean z()
  {
    MessageRecord localMessageRecord = this.E.getMessageFacade().r(AppConstants.KANDIAN_MERGE_UIN, 7220);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localMessageRecord != null)
    {
      if (localMessageRecord.isread) {
        return false;
      }
      bool1 = bool2;
      if (localMessageRecord.vipBubbleID == -1000L) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager
 * JD-Core Version:    0.7.0.1
 */