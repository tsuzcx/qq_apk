package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivityHelper;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.data.RecentDarenAssistantItem;
import com.tencent.mobileqq.activity.recent.data.RecentInteractAndFollowItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentYanZhiItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.MessageForDarenAssistant;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyFakeActivityUtils;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyProcessMonitor;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.profilecard.IMiniCardManager;
import com.tencent.mobileqq.nearpeople.IChatPushCarrier;
import com.tencent.mobileqq.nearpeople.api.IChatPushCarrierHelper;
import com.tencent.mobileqq.newnearby.INearbyCGIReporter;
import com.tencent.mobileqq.newnearby.INearbyMsgbox;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import tencent.nearby.now.nearby_now_anchor.AnchorStatus;

@RoutePage(desc="盒子类的消息列表，约会、附近的人等盒子消息消息列表都复用这个Activity", path="/nearby/msgbox/list")
public class MsgBoxListActivity
  extends BaseMsgBoxActivity
  implements View.OnClickListener, ActionSheet.OnButtonClickListener
{
  public static final String MSGBOX_CONVERNED_URL = "https://nearby.qq.com/greeting/topic.html?_bid=2623&_wv=1027 ";
  public static final String MSGBOX_NMYMOENT_URL = "https://nearby.qq.com/nearby-index/my_msg.html ";
  public static final String MSGBOX_NOTIFICATION_URL = "https://nearby.qq.com/greeting/notification.html?_bid=2623&_wv=1027";
  public static final String SP_KEY_DATING_CONFIG_TIME = "sp_key_dating_config_time";
  public static final String SP_KEY_NEARBY_CLEAN_UNREAD_TIME = "sp_key_nearby_clean_unread_time";
  public static final int START_FOLLOW_ACTIVITY_REQUEST_CODE = 2;
  public static final int START_INTERACT_ACTIVITY_REQUEST_CODE = 1;
  public static final int START_MOMENT_ACTIVITY_REQUEST_CODE = 3;
  protected static final String TAG = "MsgBoxListActivity";
  IChatPushCarrier chatPushCarrierHelper;
  public boolean isHideNoChatImg;
  protected boolean isThemeDefault;
  protected MsgBoxProtocol.LastFeedObserver lastFeedObserver = new MsgBoxListActivity.9(this);
  private CarrierHelper mCarrierHelper;
  CarrierHelper.EntranceConfig mConfig;
  RecentBaseData mCurItem;
  String mCurR;
  LinearLayout mCustomHeaders;
  Handler mHandler = null;
  private boolean mHasReportDarenItemExp;
  boolean mIsInit = false;
  ActionSheet mMenu;
  private String mYanZhiUrl;
  private IMiniCardManager miniCardManager;
  LBSObserver mlbsObserver = new MsgBoxListActivity.1(this);
  View recommandCarrier;
  private View vSeparator;
  private View vSeparatorLine;
  View viewCarrier;
  
  public static int getNearbyMsgBoxUnReadNum(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = (INearbySPUtil)QRoute.api(INearbySPUtil.class);
    Object localObject2 = paramQQAppInterface.getCurrentAccountUin();
    int k = 0;
    Object localObject3 = Integer.valueOf(0);
    int i2 = ((Integer)((INearbySPUtil)localObject1).getValue((String)localObject2, "key_nearby_msg_box_say_hello_msg_type", localObject3)).intValue();
    int i3 = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramQQAppInterface.getCurrentAccountUin(), "key_nearby_msg_box_comment_zan_msg_type", localObject3)).intValue();
    paramString = paramQQAppInterface.getMessageProxy(1001).b(paramString, 1001);
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getNearbyMsgBoxUnReadNum mainProcess, rawMsgNum=");
      if (paramString == null) {
        i = 0;
      } else {
        i = paramString.size();
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d("nearby.msgbox.tab", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramString != null) && (paramString.size() != 0))
    {
      localObject2 = paramString.iterator();
      localObject1 = "";
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        if ((!TextUtils.isEmpty(((MessageRecord)localObject3).senderuin)) && (((MessageRecord)localObject3).msgtype != -4011))
        {
          if ((localObject3 instanceof MessageForInteractAndFollow))
          {
            localObject4 = (MessageForInteractAndFollow)localObject3;
            if ((((MessageForInteractAndFollow)localObject4).type == 1) || (((MessageForInteractAndFollow)localObject4).type == 2))
            {
              ((Iterator)localObject2).remove();
              continue;
            }
          }
          if ((((MessageRecord)localObject3).senderuin.equals(AppConstants.LBS_SAY_HELLO_LIST_UIN)) || (((MessageRecord)localObject3).senderuin.equals(AppConstants.DATE_SAY_HELLO_LIST_UIN))) {
            localObject1 = ((MessageRecord)localObject3).senderuin;
          }
        }
        else
        {
          ((Iterator)localObject2).remove();
        }
      }
      int j = paramString.size();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("afterFilter msgNum=");
        ((StringBuilder)localObject2).append(j);
        QLog.d("nearby.msgbox.tab", 2, ((StringBuilder)localObject2).toString());
      }
      if (j == 0)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("msgNum=0, cost=");
          paramQQAppInterface.append(System.currentTimeMillis() - l);
          QLog.d("nearby.msgbox.tab", 2, paramQQAppInterface.toString());
        }
        return 0;
      }
      i = 50;
      if (j <= 50) {
        i = j;
      }
      paramString = paramString.subList(0, i);
      localObject3 = new ArrayList();
      localObject2 = new ConcurrentHashMap();
      Object localObject4 = paramString.iterator();
      j = 0;
      int n = 0;
      i = k;
      while (((Iterator)localObject4).hasNext())
      {
        paramString = (MessageRecord)((Iterator)localObject4).next();
        Object localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(paramString.senderuin);
        ((StringBuilder)localObject5).append("_");
        ((StringBuilder)localObject5).append(paramString.msgtype);
        localObject5 = ((StringBuilder)localObject5).toString();
        if (((ConcurrentHashMap)localObject2).containsKey(localObject5))
        {
          paramString = (RecentBaseData)((ConcurrentHashMap)localObject2).get(localObject5);
        }
        else
        {
          if (paramString.senderuin.equals(localObject1)) {
            paramString = new RecentSayHelloBoxItem(paramString);
          } else if ((paramString instanceof MessageForNearbyLiveTip)) {
            paramString = new RecentItemNearbyLiveTipData(paramString);
          } else if ((paramString instanceof MessageForInteractAndFollow)) {
            paramString = new RecentInteractAndFollowItem(paramString);
          } else if ((paramString instanceof MessageForDarenAssistant)) {
            paramString = new RecentDarenAssistantItem(paramString);
          } else {
            paramString = new RecentMsgBoxItem(paramString);
          }
          ((ConcurrentHashMap)localObject2).put(localObject5, paramString);
        }
        paramString.update(paramQQAppInterface, BaseApplication.getContext());
        ((List)localObject3).add(paramString);
        if (paramString.mUnreadFlag != 1)
        {
          m = i;
          k = j;
          if (paramString.mUnreadFlag != 3) {}
        }
        else
        {
          if (!(paramString instanceof RecentSayHelloBoxItem)) {
            break label748;
          }
          if ((paramBoolean) && (i2 == 1))
          {
            k = 1;
            m = i;
          }
          else
          {
            m = i + paramString.mUnreadNum;
            k = j;
          }
        }
        label748:
        do
        {
          i1 = n;
          break label849;
          if (!(paramString instanceof RecentInteractAndFollowItem)) {
            break;
          }
          i1 = ((RecentInteractAndFollowItem)paramString).a();
          m = i;
          k = j;
        } while (i1 <= 0);
        if (paramBoolean)
        {
          k = i1;
          if (i3 == 1)
          {
            i1 = 1;
            m = i;
            k = j;
            break label849;
          }
        }
        else
        {
          k = i1;
          break label835;
          m = i;
          k = j;
          i1 = n;
          if (paramString.mUnreadFlag != 1) {
            break label849;
          }
          k = paramString.mUnreadNum;
        }
        label835:
        int m = i + k;
        int i1 = n;
        k = j;
        label849:
        i = m;
        j = k;
        n = i1;
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("unReadNum=");
        paramQQAppInterface.append(i);
        paramQQAppInterface.append(", timeCost=");
        paramQQAppInterface.append(System.currentTimeMillis() - l);
        QLog.d("nearby.msgbox.tab", 2, paramQQAppInterface.toString());
      }
      ((ConcurrentHashMap)localObject2).clear();
      k = i;
      if (paramBoolean)
      {
        k = i;
        if (i == 0) {
          if (j == 0)
          {
            k = i;
            if (n == 0) {}
          }
          else
          {
            k = -1;
          }
        }
      }
      return k;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("msgNum=0, cost=");
      paramQQAppInterface.append(System.currentTimeMillis() - l);
      QLog.d("nearby.msgbox.tab", 2, paramQQAppInterface.toString());
    }
    return 0;
  }
  
  private void nearbyReport(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramString3 != null) {}
    try
    {
      localJSONObject.put("touin", paramString3);
      localJSONObject.put("opername", "now#nearby#news");
      localJSONObject.put("module", paramString1);
      localJSONObject.put("action", paramString2);
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      localJSONObject.put("fromuin", this.app.getCurrentAccountUin());
      localJSONObject.put("appid", "406");
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static void startMsgBoxListActivity(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent(paramContext, MsgBoxListActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  private void updateBottomBar()
  {
    if (this.mBoxMsgType != 1010)
    {
      Object localObject = this.mConfig;
      if ((localObject != null) && (!StringUtil.isEmpty(((CarrierHelper.EntranceConfig)localObject).iconUrl)) && (!StringUtil.isEmpty(this.mConfig.wording)) && (!StringUtil.isEmpty(this.mConfig.jumpUrl)))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        localObject = URLDrawable.getDrawable(this.mConfig.iconUrl, (URLDrawable.URLDrawableOptions)localObject);
        this.mBottomBarIcon.setImageDrawable((Drawable)localObject);
        this.mBottomBarText.setText(this.mConfig.wording);
      }
    }
  }
  
  private void updateSeparator()
  {
    if (this.mCarrierHelper.a())
    {
      if (this.vSeparator.getVisibility() != 0)
      {
        this.vSeparator.setVisibility(0);
        this.mMsgList.addHeaderView(this.vSeparator);
      }
      if (this.vSeparatorLine.getVisibility() != 0)
      {
        this.vSeparatorLine.setVisibility(0);
        this.mMsgList.addHeaderView(this.vSeparatorLine);
      }
    }
    else
    {
      if (this.vSeparator.getVisibility() != 8)
      {
        this.vSeparator.setVisibility(8);
        this.mMsgList.removeHeaderView(this.vSeparator);
      }
      if (this.vSeparatorLine.getVisibility() != 8)
      {
        this.vSeparatorLine.setVisibility(8);
        this.mMsgList.removeHeaderView(this.vSeparatorLine);
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2) || (paramInt1 == 1) || (paramInt1 == 3)) {
      MsgBoxProtocol.a(this.app, 2, this.lastFeedObserver);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (this.mLoadingView == null)
    {
      QLog.e("MsgBoxListActivity", 1, "MsgBoxListActivity mLoadingView is null finish");
      finish();
      return false;
    }
    this.isThemeDefault = ThemeUtil.isDefaultOrDIYTheme(false);
    if (this.isThemeDefault)
    {
      if (getTitleBarView() != null) {
        if (this.isFromQQNearby) {
          getTitleBarView().setBackgroundColor(-1);
        } else {
          getTitleBarView().setBackgroundDrawable(getResources().getDrawable(2130852229));
        }
      }
      if ((this.centerView != null) && (!this.isFromQQNearby)) {
        this.centerView.setTextColor(-1);
      }
    }
    this.mCustomHeaders = new LinearLayout(this);
    this.mCustomHeaders.setOrientation(1);
    this.chatPushCarrierHelper = ((IChatPushCarrierHelper)QRoute.api(IChatPushCarrierHelper.class)).getChatPushCarrier(this);
    this.mYanZhiUrl = YanZhiHelper.a(this.app);
    Object localObject;
    if (this.mBoxMsgType == 1010)
    {
      setTitle(2131896699);
      this.mMsgBar.setVisibility(8);
    }
    else if ((this.mBoxMsgType != 1001) && (this.mBoxMsgType != 10002))
    {
      if (this.mBoxMsgType == 1009)
      {
        setTitle(2131915857);
        this.mMsgBar.setVisibility(8);
      }
    }
    else
    {
      setTitle(2131890675);
      this.mMsgBar.setVisibility(8);
      localObject = this.app;
      if (this.mBoxMsgType == 1001) {
        paramBundle = "0";
      } else {
        paramBundle = "1";
      }
      ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_msg_list", 0, 0, paramBundle, "", "", "");
    }
    if (this.isFromNearby)
    {
      if (this.isFromQQNearby)
      {
        setTitle("");
        ((INearbyMsgbox)QRoute.api(INearbyMsgbox.class)).initTitleBar(this);
      }
      else
      {
        setTitle(2131892066);
      }
      nearbyReport("overall_page", "view", null);
      this.miniCardManager = ((IMiniCardManager)this.app.getManager(QQManagerFactory.MINI_CARD_MANAGER));
    }
    this.mMsgBar.setOnClickListener(this);
    this.app.addObserver(this.mlbsObserver, true);
    MsgBoxProtocol.a(this.app, 1, this.lastFeedObserver);
    if (this.mBoxMsgType != 1001)
    {
      if (this.mBoxMsgType == 10002) {
        return true;
      }
      paramBundle = this.app;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mBoxMsgType);
      ((StringBuilder)localObject).append("");
      ReportController.b(paramBundle, "dc00899", "grp_lbs", "", "msg_box", "otherType", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.mHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    removeObserver(this.mlbsObserver);
    if (this.mCarrierHelper != null) {
      ThreadManager.post(new MsgBoxListActivity.3(this), 5, null, false);
    }
    localObject = this.chatPushCarrierHelper;
    if (localObject != null) {
      ((IChatPushCarrier)localObject).a();
    }
    ((INearbyProcessMonitor)QRoute.api(INearbyProcessMonitor.class)).reportSessionEnd(1);
    localObject = this.miniCardManager;
    if (localObject != null) {
      ((IMiniCardManager)localObject).a();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    CarrierHelper localCarrierHelper = this.mCarrierHelper;
    if (localCarrierHelper != null)
    {
      localCarrierHelper.a(1, Boolean.valueOf(false));
      this.mCarrierHelper.c();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    AbstractGifImage.resumeAll();
    updateUnreadNumOnTitleBar();
    CarrierHelper localCarrierHelper = this.mCarrierHelper;
    if (localCarrierHelper != null) {
      localCarrierHelper.a(1, Boolean.valueOf(true));
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.mIsInit))
    {
      this.mIsInit = true;
      if (this.mHandler == null)
      {
        MsgBoxListActivity.PreloadCallBack localPreloadCallBack = new MsgBoxListActivity.PreloadCallBack(this.app.getAccount());
        this.mHandler = new WeakReferenceHandler(ThreadManager.getFileThreadLooper(), localPreloadCallBack);
      }
      this.mHandler.sendEmptyMessageDelayed(0, 2000L);
    }
  }
  
  public void expandViewTouchDelegate(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new MsgBoxListActivity.5(this, paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void finish()
  {
    if (((this.mBoxMsgType == 1001) || (this.mBoxMsgType == 10002)) && (!this.mBoxUIN.equals(AppConstants.NEARBY_LBS_HELLO_UIN)))
    {
      this.app.getPreferences().edit().putLong("sp_key_nearby_clean_unread_time", NetConnInfoCenter.getServerTime()).commit();
      this.app.getPreferences().edit().putInt("sp_key_sayhello_box_unread_count", 0).commit();
      this.app.getConversationFacade().a(this.mBoxUIN, this.mBoxMsgType, true);
      this.app.getInterFollowMgr().clearMsgBoxUnreadCount();
    }
    super.finish();
  }
  
  protected List<RecentBaseData> makeRecetBaseData(List<MessageRecord> paramList)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected boolean onBackEvent()
  {
    Intent localIntent;
    if (this.isFromNearby)
    {
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      setResult(-1, localIntent);
      finish();
    }
    else
    {
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", FrameControllerUtil.a);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131431627)
    {
      Object localObject = this.mConfig;
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        if ((this.mBoxMsgType != 1010) && ((this.mBoxMsgType == 1001) || (this.mBoxMsgType == 10002))) {
          if (!((INearbySPUtil)QRoute.api(INearbySPUtil.class)).isNeedNearbyShowGuide(this.app.getAccount()))
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("FROM_WHERE", 1003);
            ((Intent)localObject).putExtra("ENTER_TIME", System.currentTimeMillis());
            NearbyFakeActivityUtils.a(this, (Intent)localObject);
          }
          else
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("FROM_WHERE", 1003);
            ((Intent)localObject).putExtra("ENTER_TIME", System.currentTimeMillis());
            RouteUtils.a(this, (Intent)localObject, "/nearby/guide");
          }
        }
        ((INearbyProcessMonitor)QRoute.api(INearbyProcessMonitor.class)).reportSessionHit(1);
      }
      else if ((((CarrierHelper.EntranceConfig)localObject).jumpUrl != null) && (this.mConfig.jumpUrl.startsWith("mqqapi")))
      {
        localObject = new Intent(this, JumpActivity.class);
        ((Intent)localObject).setAction("android.intent.action.VIEW");
        ((Intent)localObject).setData(Uri.parse(this.mConfig.jumpUrl));
        startActivity((Intent)localObject);
        ((INearbyProcessMonitor)QRoute.api(INearbyProcessMonitor.class)).reportSessionHit(1);
      }
      else
      {
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.mConfig.jumpUrl);
        startActivity((Intent)localObject);
      }
      if (this.mBottomBarText == null) {
        localObject = "";
      } else {
        localObject = this.mBottomBarText.getText().toString();
      }
      if (this.mBoxMsgType == 1010) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005101", "0X8005101", 0, 0, "", "", (String)localObject, "");
      } else if (this.mBoxMsgType == 1001) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005100", "0X8005100", 0, 0, "", "", (String)localObject, "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClick(View paramView, int paramInt) {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    long l1;
    if ((Utils.a(paramString1, getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[6]))) || (Utils.a(paramString1, getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[11]))))
    {
      this.mCurItem = paramRecentBaseData;
      this.mCurR = paramString2;
      if (!(paramRecentBaseData instanceof RecentItemNearbyLiveTipData))
      {
        QLog.w("MsgBoxListActivity", 1, "data instanceof RecentItemNearbyLiveTipData = [false]");
        return;
      }
      paramString1 = new ReportTask(this.app).a("dc00899").b("grp_lbs").c("msg_box").d("unfollow");
      paramRecentBaseData = (RecentItemNearbyLiveTipData)paramRecentBaseData;
      paramString1.e(paramRecentBaseData.bW_()).a();
      if (!NetworkUtil.a(getApplicationContext()))
      {
        QQToast.makeText(getApplicationContext(), 1, 2131892102, 0).show();
        return;
      }
      if (paramRecentBaseData.nearbyLiveTipMsg == null)
      {
        QLog.w("MsgBoxListActivity", 1, "rData.nearbyLiveTipMsg == null");
        if (paramRecentBaseData.mData != null) {
          paramString1 = paramRecentBaseData.mData.senderuin;
        }
      }
      else
      {
        paramString1 = paramRecentBaseData.nearbyLiveTipMsg.senderuin;
      }
      l1 = 0L;
    }
    try
    {
      l2 = Long.valueOf(paramString1).longValue();
      l1 = l2;
    }
    catch (NumberFormatException paramString1)
    {
      long l2;
      label199:
      break label199;
    }
    l2 = l1;
    if (l1 > AppConstants.NOW_LIVE_TIP_UIN_BASE) {
      l2 = l1 - AppConstants.NOW_LIVE_TIP_UIN_BASE;
    }
    this.mRecentAdapter.a(this.mCurItem, this.mCurR);
    if (this.isFromNearby) {
      if (this.mRecentAdapter.getCount() == 0) {
        this.mEmptyTipLayout.setVisibility(0);
      } else {
        this.mEmptyTipLayout.setVisibility(8);
      }
    }
    ((INowShortVideoProtoManager)QRoute.api(INowShortVideoProtoManager.class)).init(this.app).follow(l2, 0L, 0, 16, false, new MsgBoxListActivity.7(this));
  }
  
  public void onRecentBaseDataClick(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    boolean bool = paramRecentBaseData instanceof RecentItemNearbyLiveTipData;
    Object localObject = "1";
    if (bool)
    {
      paramString = (RecentItemNearbyLiveTipData)paramRecentBaseData;
      localObject = paramString.nearbyLiveTipMsg;
      if (localObject != null)
      {
        paramView = JumpParser.a(this.app, this, ((MessageForNearbyLiveTip)localObject).jumpingUrl);
        if (paramView != null)
        {
          paramView.a();
          if (MsgProxyUtils.d(paramString.bW_()))
          {
            this.app.getMessageFacade().a(paramString.mData.senderuin, paramRecentBaseData.getRecentUserType());
            if (MsgProxyUtils.d(((MessageForNearbyLiveTip)localObject).senderuin))
            {
              if (paramString.getUnreadNum() < 1) {
                paramView = "0";
              } else {
                paramView = "1";
              }
              ReportController.b(null, "dc00899", "grp_lbs", "", "msg_box", "assist_click", 0, 0, "", "", "", paramView);
            }
          }
          this.app.getMessageFacade().a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
          this.app.getMessageFacade().a(paramString.bW_(), paramRecentBaseData.getRecentUserType());
        }
        ThreadManagerV2.excute(new MsgBoxListActivity.8(this, (MessageForNearbyLiveTip)localObject, (INearbyCardManager)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 32, null, false);
      }
      ReportController.b(this.app, "dc00899", "grp_lbs", "", "msg_box", "click_live_message", 0, 0, "", "", "", "");
      if (this.isFromNearby) {
        ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportLiveTipListClick(this.app);
      }
      return;
    }
    if ((paramRecentBaseData instanceof RecentInteractAndFollowItem))
    {
      RecentUtil.b(this.app, paramRecentBaseData.getRecentUserUin(), this.mBoxMsgType);
      this.app.getMessageFacade().a(paramRecentBaseData.getRecentUserUin(), this.mBoxMsgType);
      if (MsgProxyUtils.b(paramRecentBaseData.getRecentUserUin()))
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "https://nearby.qq.com/greeting/notification.html?_bid=2623&_wv=1027");
        startActivityForResult(paramView, 1);
        paramView = new StringBuilder();
        paramView.append(((RecentMsgBoxItem)paramRecentBaseData).mFromFlag);
        paramView.append("");
        paramView = paramView.toString();
        new ReportTask(this.app).a("dc00899").b("grp_lbs").c("msg_box").d("clk_update").a(new String[] { "", "", paramView }).a();
        return;
      }
      if (MsgProxyUtils.c(paramRecentBaseData.getRecentUserUin()))
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "https://nearby.qq.com/greeting/topic.html?_bid=2623&_wv=1027 ");
        startActivityForResult(paramView, 2);
        new ReportTask(this.app).a("dc00899").b("grp_lbs").c("msg_box").d("clk_focus").a();
        return;
      }
      if (UinTypeUtil.e(paramRecentBaseData.getRecentUserUin()))
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "https://nearby.qq.com/nearby-index/my_msg.html ");
        startActivityForResult(paramView, 3);
        if (this.isFromNearby) {
          paramView = (View)localObject;
        } else {
          paramView = "0";
        }
        new ReportTask(this.app).a("dc00899").b("grp_lbs").c("msg_box").d("clk_notice").a(new String[] { "", "", paramView }).a();
        if (this.isFromNearby) {
          ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportMomentListClick(this.app);
        }
      }
      return;
    }
    if ((paramRecentBaseData instanceof RecentDarenAssistantItem))
    {
      this.app.getMessageFacade().a(paramRecentBaseData.getRecentUserUin(), this.mBoxMsgType);
      paramView = (RecentDarenAssistantItem)paramRecentBaseData;
      if ((paramView.mData instanceof MessageForDarenAssistant))
      {
        paramView = ((MessageForDarenAssistant)paramView.mData).jumpUrl;
        if (QLog.isColorLevel())
        {
          paramRecentBaseData = new StringBuilder();
          paramRecentBaseData.append("messageForDarenAssistant.jumpUrl=");
          paramRecentBaseData.append(paramView);
          QLog.i("MsgBoxListActivity", 2, paramRecentBaseData.toString());
        }
        paramView = JumpParser.a(this.app, this, paramView);
        if (paramView != null) {
          paramView.a();
        }
      }
      new ReportTask(this.app).a("dc00899").b("grp_lbs").c("vip_tips").d("clk").a();
      return;
    }
    if ((paramRecentBaseData instanceof RecentYanZhiItem))
    {
      this.app.getMessageFacade().a(paramRecentBaseData.getRecentUserUin(), this.mBoxMsgType);
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("url", this.mYanZhiUrl);
      startActivity(paramView);
      return;
    }
    if (this.isFromNearby) {
      nearbyReport("c2c_list", "click", paramRecentBaseData.getRecentUserUin());
    }
    super.onRecentBaseDataClick(paramView, paramRecentBaseData, paramString, paramBoolean);
  }
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString)
  {
    super.onRecentBaseDataDelete(paramRecentBaseData, paramString);
    if (paramRecentBaseData != null)
    {
      SharedPreUtils.b(this.app.getApp(), this.app.getCurrentAccountUin(), paramRecentBaseData.getRecentUserUin(), 1);
      if ((paramRecentBaseData instanceof RecentMsgBoxItem))
      {
        paramString = new StringBuilder();
        paramString.append(((RecentMsgBoxItem)paramRecentBaseData).mFromFlag);
        paramString.append("");
        paramString = paramString.toString();
      }
      else
      {
        paramString = "0";
      }
      if (MsgProxyUtils.b(paramRecentBaseData.getRecentUserUin())) {
        ReportController.b(this.app, "dc00899", "grp_lbs", "", "msg_box", "swipe_update", 0, 0, "", "", paramString, "");
      } else if (MsgProxyUtils.c(paramRecentBaseData.getRecentUserUin())) {
        ReportController.b(this.app, "dc00899", "grp_lbs", "", "msg_box", "swipe_focus", 0, 0, "", "", "", "");
      }
      if (this.isFromNearby)
      {
        this.mUnReadMsgNum = getNearbyMsgBoxUnReadNum(this.app, this.mBoxUIN, false);
        NearbyActivityHelper.a(this.mMsgTabRedTouch, this.mUnReadMsgNum);
      }
    }
  }
  
  protected void onRefreshRecentListData()
  {
    if (this.mRecentListData == null) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList(10);
    ArrayList localArrayList2 = new ArrayList(10);
    Iterator localIterator = this.mRecentListData.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (RecentBaseData)localIterator.next();
      if ((localObject instanceof RecentItemNearbyLiveTipData))
      {
        localObject = (RecentItemNearbyLiveTipData)localObject;
        if ((((RecentItemNearbyLiveTipData)localObject).nearbyLiveTipMsg != null) && (!MessageForNearbyLiveTip.isHuayangTip(((RecentItemNearbyLiveTipData)localObject).nearbyLiveTipMsg.jumpingUrl)) && (((RecentItemNearbyLiveTipData)localObject).nearbyLiveTipMsg.isLiving))
        {
          try
          {
            Long localLong = Long.valueOf(Long.valueOf(Long.parseLong(((RecentItemNearbyLiveTipData)localObject).nearbyLiveTipMsg.senderuin)).longValue() - AppConstants.NOW_LIVE_TIP_UIN_BASE);
            if (!localArrayList1.contains(localLong)) {
              localArrayList1.add(localLong);
            }
            localArrayList2.add(localObject);
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel()) {
            QLog.w("MsgBoxListActivity", 2, localException.toString());
          }
        }
      }
    }
    if (localArrayList1.size() == 0) {
      return;
    }
    MsgBoxProtocol.a(this.app, localArrayList1, null, new MsgBoxListActivity.2(this, localArrayList2));
  }
  
  protected void preProcessMessageList(List<MessageRecord> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    ArrayList localArrayList = new ArrayList(3);
    Object localObject2 = null;
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((!TextUtils.isEmpty(localMessageRecord.senderuin)) && (localMessageRecord.msgtype != -4011))
      {
        if ((this.isFromNearby) && ((localMessageRecord instanceof MessageForInteractAndFollow)))
        {
          localObject3 = (MessageForInteractAndFollow)localMessageRecord;
          if ((((MessageForInteractAndFollow)localObject3).type == 1) || (((MessageForInteractAndFollow)localObject3).type == 2))
          {
            localIterator.remove();
            continue;
          }
        }
        if ((this.isFromNearby) && ((localMessageRecord instanceof MessageForInteractAndFollow)))
        {
          localObject3 = (MessageForInteractAndFollow)localMessageRecord;
          if ((((MessageForInteractAndFollow)localObject3).type == 1) || (((MessageForInteractAndFollow)localObject3).type == 2))
          {
            localIterator.remove();
            continue;
          }
        }
        if (UinTypeUtil.d(localMessageRecord.senderuin))
        {
          localArrayList.add(localMessageRecord);
          localIterator.remove();
        }
        if ((!localMessageRecord.senderuin.equals(AppConstants.LBS_SAY_HELLO_LIST_UIN)) && (!localMessageRecord.senderuin.equals(AppConstants.DATE_SAY_HELLO_LIST_UIN)))
        {
          if (DatingUtil.b(this.app, localMessageRecord.senderuin, localMessageRecord.istroop))
          {
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = new ArrayList();
            }
            localIterator.remove();
            ((List)localObject3).add(localMessageRecord);
            localObject1 = localObject3;
          }
          else if (DatingUtil.a(this.app, localMessageRecord.senderuin, localMessageRecord.istroop))
          {
            localObject3 = localObject2;
            if (localObject2 == null) {
              localObject3 = new ArrayList();
            }
            localIterator.remove();
            ((List)localObject3).add(localMessageRecord);
            localObject2 = localObject3;
          }
        }
        else
        {
          this.mHasOneWayMsg = true;
          this.mOneWayBoxUin = localMessageRecord.senderuin;
          localArrayList.add(localMessageRecord);
          localIterator.remove();
        }
      }
      else
      {
        localIterator.remove();
      }
    }
    Object localObject3 = new ArrayList();
    ((List)localObject3).addAll(localArrayList);
    if ((localObject2 != null) && (!localObject2.isEmpty())) {
      ((List)localObject3).addAll(localObject2);
    }
    if ((localObject1 != null) && (!localObject1.isEmpty())) {
      ((List)localObject3).addAll(localObject1);
    }
    paramList.addAll(0, (Collection)localObject3);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    runOnUiThread(new MsgBoxListActivity.6(this));
  }
  
  protected void updateLivingState(RecentItemNearbyLiveTipData paramRecentItemNearbyLiveTipData, List<nearby_now_anchor.AnchorStatus> paramList)
  {
    long l1 = Long.parseLong(paramRecentItemNearbyLiveTipData.nearbyLiveTipMsg.senderuin);
    long l2 = AppConstants.NOW_LIVE_TIP_UIN_BASE;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (nearby_now_anchor.AnchorStatus)paramList.next();
      if ((((nearby_now_anchor.AnchorStatus)localObject).uint64_uin.get() == l1 - l2) && (((nearby_now_anchor.AnchorStatus)localObject).enum_stat.get() == 2))
      {
        localObject = paramRecentItemNearbyLiveTipData.nearbyLiveTipMsg;
        ((MessageForNearbyLiveTip)localObject).isLiving = false;
        ((MessageForNearbyLiveTip)localObject).msg = ((MessageForNearbyLiveTip)localObject).c2cMsgWording;
        ((MessageForNearbyLiveTip)localObject).prewrite();
        this.app.getMessageFacade().a(((MessageForNearbyLiveTip)localObject).senderuin, ((MessageForNearbyLiveTip)localObject).istroop, ((MessageForNearbyLiveTip)localObject).uniseq, ((MessageForNearbyLiveTip)localObject).msgData);
        paramRecentItemNearbyLiveTipData.a(this.app, BaseApplication.getContext());
        this.mRecentAdapter.a(((MessageForNearbyLiveTip)localObject).senderuin, this.mBoxMsgType);
      }
    }
  }
  
  protected void updateUnreadNumOnTitleBar()
  {
    if (this.isFromNearby) {
      return;
    }
    if ((this.leftView != null) && (this.mLeftBackText != null))
    {
      if (this.mLeftBackText == null) {
        return;
      }
      TextView localTextView;
      if (this.isThemeDefault)
      {
        this.leftView.setVisibility(8);
        this.mLeftBackIcon.setVisibility(0);
        this.mLeftBackText.setVisibility(0);
        localTextView = this.mLeftBackText;
        expandViewTouchDelegate(localTextView, 0, 0, 0, (int)(this.mDensity * 30.0F + 0.5F));
      }
      else
      {
        this.leftView.setVisibility(0);
        this.mLeftBackIcon.setVisibility(8);
        this.mLeftBackText.setVisibility(8);
        localTextView = this.leftView;
      }
      Object localObject = this.app.getMessageFacade();
      if (localObject != null)
      {
        int i = ((QQMessageFacade)localObject).w();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(i);
        localObject = ((StringBuilder)localObject).toString();
        if (!this.isThemeDefault)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(getString(2131917002));
          ((StringBuilder)localObject).append("(");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(")");
          localObject = ((StringBuilder)localObject).toString();
          if (i > 99)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(getString(2131917002));
            ((StringBuilder)localObject).append("(99+)");
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        if (i < 0) {
          localObject = getString(2131917002);
        }
        if ((this.isThemeDefault) && (i <= 0)) {
          localTextView.setVisibility(4);
        }
        localTextView.setText((CharSequence)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity
 * JD-Core Version:    0.7.0.1
 */