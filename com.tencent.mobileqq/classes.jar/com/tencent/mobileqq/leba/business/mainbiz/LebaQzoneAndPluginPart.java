package com.tencent.mobileqq.leba.business.mainbiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QZoneEntryReporterInLeba;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.gamecenter.data.PadFaceManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.LebaConstant;
import com.tencent.mobileqq.leba.business.BaseLebaMainBiz;
import com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz;
import com.tencent.mobileqq.leba.business.urlreport.LebaRedDotUrlAppendRule;
import com.tencent.mobileqq.leba.business.urlreport.LebaUinUrlAppendRule;
import com.tencent.mobileqq.leba.business.urlreport.LebaVKeyAppendRule;
import com.tencent.mobileqq.leba.entity.LeabOnPauseInfo;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyEnterUpdateObserver;
import com.tencent.mobileqq.nearby.NearbyFakeActivityUtils;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyConfigUtil;
import com.tencent.mobileqq.nearby.api.INearbyProcessMonitor;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.redtouch.INearbyOfficalReportHelper;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.report.INearbyReportRunnable;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineMusicStatusManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.UrlUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.api.ISonicPreloaderService;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.data.SonicParserInfo;
import com.tencent.mobileqq.webview.data.SonicPreloadData;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.QQKRPUtil;
import com.tencent.util.URLUtil;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.oidb.cmd0xd40.DeviceInfo;
import tencent.im.oidb.cmd0xd40.ReqBody;
import tencent.im.oidb.qqshop.qqshop_code.SRsp;

public class LebaQzoneAndPluginPart
  extends BaseLebaMainBiz
  implements View.OnClickListener
{
  public static List<String> a;
  public static long b;
  public static List<String> b;
  public static List<String> c;
  public int a;
  public long a;
  public Intent a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new LebaQzoneAndPluginPart.1(this);
  public View a;
  public ImageSwitcher a;
  public ImageView a;
  public TextView a;
  private IPublicAccountObserver.OnCallback jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver$OnCallback = new LebaQzoneAndPluginPart.20(this);
  private IPublicAccountObserver jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver;
  public LebaQZoneFacePlayHelper a;
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new LebaQzoneAndPluginPart.22(this);
  public PreloadProcHitSession a;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new LebaQzoneAndPluginPart.17(this);
  NearbyEnterUpdateObserver jdField_a_of_type_ComTencentMobileqqNearbyNearbyEnterUpdateObserver = new LebaQzoneAndPluginPart.19(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new LebaQzoneAndPluginPart.23(this);
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new LebaQzoneAndPluginPart.24(this);
  private QZoneObserver jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver = new LebaQzoneAndPluginPart.21(this);
  private ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new LebaQzoneAndPluginPart.18(this);
  public MqqWeakReferenceHandler a;
  public Runnable a;
  public Set<String> a;
  public AtomicBoolean a;
  public qqshop_code.SRsp a;
  public boolean a;
  public int b;
  public ImageSwitcher b;
  public TextView b;
  public PreloadProcHitSession b;
  public boolean b;
  public TextView c;
  public boolean c;
  public TextView d;
  public TextView e;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilList = new ArrayList();
    jdField_c_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_JavaUtilList.add("jiankang.qq.com");
    jdField_a_of_type_JavaUtilList.add("guahao.com");
    jdField_a_of_type_JavaUtilList.add("91160.com");
    jdField_b_of_type_JavaUtilList.add("m.gamecenter.qq.com");
    jdField_b_of_type_JavaUtilList.add("web.gamecenter.qq.com");
    jdField_b_of_type_JavaUtilList.add("imgcache.qq.com");
    jdField_b_of_type_JavaUtilList.add("imgcache.gtimg.cn");
    jdField_b_of_type_JavaUtilList.add("youxi.vip.qq.com");
    jdField_c_of_type_JavaUtilList.add("cdn.vip.qq.com");
    jdField_c_of_type_JavaUtilList.add("comic.vip.qq.com");
    jdField_c_of_type_JavaUtilList.add("reader.sh.vip.qq.com");
    jdField_c_of_type_JavaUtilList.add("ac.tc.qq.com");
    jdField_c_of_type_JavaUtilList.add("img-qq.ac.qq.com");
    jdField_b_of_type_Long = 0L;
  }
  
  public LebaQzoneAndPluginPart()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("qzone_leba", "com.tencent.mobileqq:qzone");
    this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("web_leba", "com.tencent.mobileqq:tool");
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_JavaLangRunnable = new LebaQzoneAndPluginPart.14(this);
  }
  
  private String a(LebaViewItem paramLebaViewItem, IRedTouchManager paramIRedTouchManager)
  {
    Object localObject1 = UrlUtils.a(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl, "alertId");
    Object localObject2 = localObject1;
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId > 0L)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId);
      ((StringBuilder)localObject2).append("");
      paramIRedTouchManager = a(paramIRedTouchManager.getAppInfoByPath(((StringBuilder)localObject2).toString()));
      paramLebaViewItem = (LebaViewItem)localObject1;
      if (!TextUtils.isEmpty(paramIRedTouchManager)) {
        if (((String)localObject1).contains("?"))
        {
          paramLebaViewItem = new StringBuilder();
          paramLebaViewItem.append((String)localObject1);
          paramLebaViewItem.append("&alertId=");
          paramLebaViewItem.append(paramIRedTouchManager);
          paramLebaViewItem = paramLebaViewItem.toString();
        }
        else
        {
          paramLebaViewItem = new StringBuilder();
          paramLebaViewItem.append((String)localObject1);
          paramLebaViewItem.append("?alertId=");
          paramLebaViewItem.append(paramIRedTouchManager);
          paramLebaViewItem = paramLebaViewItem.toString();
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handlePluginClickWithStudyRoom: exParams[");
      ((StringBuilder)localObject1).append(paramIRedTouchManager);
      ((StringBuilder)localObject1).append("]");
      QLog.i("LebaBusinessPartImpl", 1, ((StringBuilder)localObject1).toString());
      localObject2 = paramLebaViewItem;
    }
    return localObject2;
  }
  
  private String a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return "";
    }
    try
    {
      if (!paramAppInfo.buffer.has()) {
        return null;
      }
      paramAppInfo = paramAppInfo.buffer.get();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getRedTouchParamsWithStudyRoom: ");
        ((StringBuilder)localObject).append(paramAppInfo);
        QLog.d("LebaBusinessPartImpl", 2, ((StringBuilder)localObject).toString());
      }
      if (TextUtils.isEmpty(paramAppInfo)) {
        return null;
      }
      paramAppInfo = new JSONObject(paramAppInfo);
      Object localObject = paramAppInfo.optString("_show_mission");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramAppInfo = new JSONObject(paramAppInfo.optJSONObject("msg").optJSONObject((String)localObject).optString("src")).optJSONObject("alert").optString("alert_id");
        boolean bool = TextUtils.isEmpty(paramAppInfo);
        if (bool) {
          paramAppInfo = "";
        }
        return paramAppInfo;
      }
    }
    catch (Throwable paramAppInfo)
    {
      QLog.e("LebaBusinessPartImpl", 1, "getRedTouchParamsWithStudyRoom: JSONException ", paramAppInfo);
    }
    return "";
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return;
    }
    if (paramAppInfo.iNewFlag.get() == 0) {
      return;
    }
    if (TextUtils.equals(paramAppInfo.path.get(), "826"))
    {
      int i;
      if (!TextUtils.isEmpty(paramAppInfo.icon_url.get())) {
        i = 1;
      } else {
        i = 2;
      }
      paramAppInfo = BaseApplicationImpl.getApplication().getRuntime();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("");
      ReportController.b(paramAppInfo, "dc00899", "Grp_tribe", "", "dynamic", "Clk_tribe", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
      localObject = new cmd0xd40.ReqBody();
      ((cmd0xd40.ReqBody)localObject).src.set(1);
      ((cmd0xd40.ReqBody)localObject).event.set(2);
      ((cmd0xd40.ReqBody)localObject).redtype.set(i);
      ((cmd0xd40.ReqBody)localObject).dev.uint32_os.set(2);
      a(((IReadInJoyOidbHelper)QRoute.api(IReadInJoyOidbHelper.class)).makeOIDBPkg("OidbSvc.0xd40_0", 3392, 0, ((cmd0xd40.ReqBody)localObject).toByteArray()), paramAppInfo);
      return;
    }
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, AppRuntime paramAppRuntime)
  {
    if (paramToServiceMsg != null)
    {
      if (!(paramAppRuntime instanceof QQAppInterface)) {
        return;
      }
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      ((QQAppInterface)paramAppRuntime).sendToService(paramToServiceMsg);
    }
  }
  
  public static boolean a(QZoneCountInfo paramQZoneCountInfo)
  {
    boolean bool2 = false;
    if (paramQZoneCountInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramQZoneCountInfo.friendList != null)
    {
      bool1 = bool2;
      if (paramQZoneCountInfo.friendList.size() > 0)
      {
        bool1 = bool2;
        if (paramQZoneCountInfo.uCount > 0L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean b(QZoneCountInfo paramQZoneCountInfo)
  {
    boolean bool2 = false;
    if (paramQZoneCountInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramQZoneCountInfo.strShowMsg))
    {
      bool1 = bool2;
      if (paramQZoneCountInfo.uCount > 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public Intent a(Class<?> paramClass, QBaseActivity paramQBaseActivity)
  {
    return new Intent(paramQBaseActivity, paramClass);
  }
  
  public QQAppInterface a()
  {
    AppRuntime localAppRuntime = a();
    if (localAppRuntime != null) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public LebaQzoneAndPluginPart.ClickActionParam a(LebaViewItem paramLebaViewItem, String paramString, short paramShort, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    if ("com.cmshow.game.android".equals(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName)) {
      a(paramQQAppInterface, "cmshow", "Apollo", "clk_tab_game", 0, 0);
    }
    boolean bool2 = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android");
    boolean bool1 = false;
    Object localObject1;
    short s;
    if (bool2)
    {
      paramString = a("vipGameCenter");
      if (TextUtils.isEmpty(paramString))
      {
        paramString = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("clickAction gamecenter use plugin info url=");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("LebaBusinessPartImpl", 1, ((StringBuilder)localObject1).toString());
      }
      else
      {
        if (paramString.startsWith("http")) {
          paramShort = 0;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("clickAction gamecenter use IndividuationUrl url=");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("LebaBusinessPartImpl", 1, ((StringBuilder)localObject1).toString());
      }
      localObject1 = paramString;
      s = paramShort;
      if (paramBoolean1)
      {
        List localList = ((IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)).missions.get();
        if ((localList != null) && (localList.size() > 0))
        {
          localObject1 = "-1";
          int i = 0;
          for (;;)
          {
            localObject2 = localObject1;
            if (i >= localList.size()) {
              break;
            }
            if (i == 0)
            {
              localObject1 = (String)localList.get(i);
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append("_");
              ((StringBuilder)localObject2).append((String)localList.get(i));
              localObject1 = ((StringBuilder)localObject2).toString();
            }
            i += 1;
          }
        }
        Object localObject2 = "-1";
        if (paramShort == 0)
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append(paramString);
          paramQQAppInterface.append("&missions=");
          paramQQAppInterface.append((String)localObject2);
          localObject1 = paramQQAppInterface.toString();
        }
        else
        {
          localObject1 = paramString;
          if (paramShort == 2)
          {
            paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramQBaseActivity, paramString).b("url");
            paramQBaseActivity = new StringBuilder();
            paramQBaseActivity.append(paramQQAppInterface);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("&missions=");
            ((StringBuilder)localObject1).append((String)localObject2);
            paramQBaseActivity.append(URLEncoder.encode(((StringBuilder)localObject1).toString()));
            localObject1 = paramString.replace(paramQQAppInterface, paramQBaseActivity.toString());
          }
        }
        paramString = new StringBuilder();
        paramString.append("[dealGameCenterUrl] add redPointId :");
        paramString.append((String)localObject1);
        QLog.i("LebaBusinessPartImpl", 1, paramString.toString());
        s = paramShort;
      }
    }
    else
    {
      s = paramShort;
      localObject1 = paramString;
    }
    if (paramBoolean2)
    {
      if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 0L)
      {
        paramString = this.jdField_a_of_type_AndroidWidgetTextView;
        paramBoolean3 = bool1;
        if (paramString != null)
        {
          paramBoolean3 = bool1;
          if (paramString.getVisibility() == 0) {
            paramBoolean3 = true;
          }
        }
      }
      ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).onLebaItemClick((int)paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, paramBoolean3);
    }
    else
    {
      ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).onLebaItemClick((int)paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, paramBoolean1);
      if ("com.tx.xingqubuluo.android".equals(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName)) {
        paramBoolean3 = paramBoolean1;
      }
      if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 7966L) {
        paramBoolean3 = paramBoolean1;
      }
    }
    paramString = new LebaQzoneAndPluginPart.ClickActionParam();
    paramString.jdField_a_of_type_JavaLangString = ((String)localObject1);
    paramString.jdField_a_of_type_Short = s;
    paramString.jdField_b_of_type_Boolean = paramBoolean3;
    paramString.jdField_c_of_type_Boolean = paramBoolean1;
    paramString.d = paramBoolean2;
    paramString.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem = paramLebaViewItem;
    return paramString;
  }
  
  public LebaViewItem a()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android"))) {
          return localLebaViewItem;
        }
      }
    }
    return null;
  }
  
  public JumpAction a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    return JumpParser.a(paramQQAppInterface, paramContext, paramString);
  }
  
  public JumpAction a(LebaViewItem paramLebaViewItem, BusinessInfoCheckUpdate.AppInfo paramAppInfo, JumpAction paramJumpAction, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android"))
    {
      paramJumpAction.e("platformId=qq_m");
      return paramJumpAction;
    }
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("com.tx.xingqubuluo.android")) {
      return a(paramAppInfo, paramJumpAction, paramQQAppInterface);
    }
    paramAppInfo = paramJumpAction;
    if (a(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)) {
      paramAppInfo = a(paramJumpAction, paramQQAppInterface, paramQBaseActivity);
    }
    return paramAppInfo;
  }
  
  public JumpAction a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, JumpAction paramJumpAction, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramQQAppInterface.d();
    if (i > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("redid=");
      localStringBuilder.append(i);
      localStringBuffer.append(localStringBuilder.toString());
    }
    int j = paramQQAppInterface.a();
    if (j > 0)
    {
      if (localStringBuffer.length() == 0)
      {
        paramQQAppInterface = "";
      }
      else
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("&rpnumber=");
        paramQQAppInterface.append(j);
        paramQQAppInterface = paramQQAppInterface.toString();
      }
      localStringBuffer.append(paramQQAppInterface);
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("xqbl redid=");
    paramQQAppInterface.append(i);
    paramQQAppInterface.append(",rpnumber=");
    paramQQAppInterface.append(j);
    QLog.i("LebaBusinessPartImpl", 1, paramQQAppInterface.toString());
    try
    {
      paramQQAppInterface = new JSONObject(paramAppInfo.buffer.get()).optJSONObject("param");
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.optJSONObject((String)paramAppInfo.missions.get(0));
        if (paramQQAppInterface != null)
        {
          paramAppInfo = paramQQAppInterface.optString("_red_ext_bid");
          paramQQAppInterface = paramQQAppInterface.optString("_red_ext_pid");
          if (!TextUtils.isEmpty(paramAppInfo))
          {
            localStringBuffer.append("&bid=");
            localStringBuffer.append(paramAppInfo);
          }
          if (!TextUtils.isEmpty(paramQQAppInterface))
          {
            localStringBuffer.append("&pid=");
            localStringBuffer.append(paramQQAppInterface);
          }
        }
      }
    }
    catch (Exception paramAppInfo)
    {
      QLog.i("LebaBusinessPartImpl", 1, "handerSpecialWhenJumpScheme", paramAppInfo);
    }
    if (localStringBuffer.length() > 0) {
      paramJumpAction.e(localStringBuffer.toString());
    }
    return paramJumpAction;
  }
  
  public JumpAction a(JumpAction paramJumpAction, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    Object localObject3 = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    Object localObject2 = ((TroopRedTouchManager)localObject3).a();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (((MsgTabStoryNodeConfigManager)paramQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LebaBusinessPartImpl", 2, "check invisible red point for msgtab");
        }
        localObject2 = ((TroopRedTouchManager)localObject3).a(52);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ((TroopRedTouchManager)localObject3).a(35);
        }
      }
    }
    localObject2 = paramJumpAction;
    JumpAction localJumpAction;
    if (localObject1 != null)
    {
      localObject2 = paramJumpAction;
      if (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() == 37)
      {
        localObject3 = null;
        try
        {
          localObject2 = new JSONObject(((oidb_0x791.RedDotInfo)localObject1).str_custom_buffer.get().toStringUtf8()).getString("fake_protocol");
          localObject3 = localObject2;
        }
        catch (Exception localException)
        {
          SLog.d("Leba.qqstory.tag", "tag red dot json parse error , %s", new Object[] { localException.getMessage() });
        }
        localJumpAction = paramJumpAction;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localJumpAction = JumpParser.a(paramQQAppInterface, paramQBaseActivity, (String)localObject3);
        }
      }
    }
    if (localObject1 == null) {
      paramJumpAction = "";
    } else {
      paramJumpAction = String.valueOf(((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get());
    }
    localJumpAction.a("redid", paramJumpAction);
    localJumpAction.a("lebaVersion", "old");
    return localJumpAction;
  }
  
  public String a()
  {
    Object localObject2 = IndividuationUrlHelper.a("vipGameCenter");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      LebaViewItem localLebaViewItem = a();
      localObject1 = localObject2;
      if (localLebaViewItem != null) {
        if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null) {
          localObject1 = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl;
        } else {
          localObject1 = "";
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = JumpParser.a(a(), a(), (String)localObject1);
      if (localObject2 != null)
      {
        localObject1 = ((JumpAction)localObject2).b("url");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (;;)
        {
          return "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393";
          try
          {
            localObject1 = URLDecoder.decode((String)localObject1);
            return localObject1;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return localException;
  }
  
  public String a(String paramString)
  {
    return IndividuationUrlHelper.a(paramString);
  }
  
  /* Error */
  public void a(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 725	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 741	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   10: ifnull +455 -> 465
    //   13: aload 4
    //   15: ifnull +450 -> 465
    //   18: aload_1
    //   19: ifnonnull +4 -> 23
    //   22: return
    //   23: aload 4
    //   25: getstatic 746	com/tencent/mobileqq/app/BusinessHandlerFactory:EC_SHOP_REPORT_HANDLER	Ljava/lang/String;
    //   28: invokevirtual 750	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   31: checkcast 752	com/tencent/biz/pubaccount/ecshopassit/EcshopReportHandler
    //   34: astore_2
    //   35: invokestatic 758	java/lang/System:currentTimeMillis	()J
    //   38: aload_0
    //   39: getfield 760	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_Long	J
    //   42: lsub
    //   43: invokestatic 496	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   46: astore_3
    //   47: aload_1
    //   48: getfield 766	android/os/Message:obj	Ljava/lang/Object;
    //   51: checkcast 768	tencent/im/oidb/qqshop/qqshop_code$SRsp
    //   54: astore 5
    //   56: aload_0
    //   57: getfield 741	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   60: ldc_w 522
    //   63: invokevirtual 771	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_1
    //   67: aload 5
    //   69: getfield 774	tencent/im/oidb/qqshop/qqshop_code$SRsp:auth_code	Lcom/tencent/mobileqq/pb/PBStringField;
    //   72: invokevirtual 277	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   75: astore 6
    //   77: aload 6
    //   79: ifnonnull +54 -> 133
    //   82: aload_0
    //   83: getfield 121	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   86: invokevirtual 776	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   89: ifne +43 -> 132
    //   92: aload_2
    //   93: ifnull +23 -> 116
    //   96: aload_2
    //   97: ldc_w 777
    //   100: aconst_null
    //   101: ldc_w 779
    //   104: aload_3
    //   105: ldc_w 781
    //   108: lconst_0
    //   109: iconst_0
    //   110: invokevirtual 784	com/tencent/biz/pubaccount/ecshopassit/EcshopReportHandler:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   113: goto +3 -> 116
    //   116: aload_0
    //   117: aload_0
    //   118: getfield 741	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   121: invokevirtual 787	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:a	(Landroid/content/Intent;)V
    //   124: aload_0
    //   125: getfield 121	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   128: iconst_1
    //   129: invokevirtual 789	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   132: return
    //   133: aload_1
    //   134: ldc_w 791
    //   137: aload 5
    //   139: getfield 774	tencent/im/oidb/qqshop/qqshop_code$SRsp:auth_code	Lcom/tencent/mobileqq/pb/PBStringField;
    //   142: invokevirtual 277	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   145: invokestatic 796	com/tencent/util/URLUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 6
    //   150: aload_0
    //   151: getfield 741	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   154: ldc_w 522
    //   157: aload 6
    //   159: invokevirtual 800	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   162: pop
    //   163: aload_0
    //   164: getfield 741	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   167: ldc_w 802
    //   170: invokestatic 758	java/lang/System:currentTimeMillis	()J
    //   173: invokevirtual 805	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   176: pop
    //   177: aload_0
    //   178: getfield 121	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   181: invokevirtual 776	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   184: ifne +94 -> 278
    //   187: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +41 -> 231
    //   193: new 208	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   200: astore 5
    //   202: aload 5
    //   204: ldc_w 807
    //   207: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 5
    //   213: aload 6
    //   215: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: ldc_w 809
    //   222: iconst_2
    //   223: aload 5
    //   225: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 260	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: aload_0
    //   232: aload_0
    //   233: getfield 741	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   236: invokevirtual 787	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:a	(Landroid/content/Intent;)V
    //   239: aload_0
    //   240: getfield 121	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   243: iconst_1
    //   244: invokevirtual 789	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   247: aload_0
    //   248: aload_1
    //   249: aload 4
    //   251: invokevirtual 812	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   254: aload_2
    //   255: ifnull +211 -> 466
    //   258: aload_2
    //   259: ldc_w 777
    //   262: aconst_null
    //   263: ldc_w 779
    //   266: aload_3
    //   267: ldc_w 814
    //   270: lconst_0
    //   271: iconst_0
    //   272: invokevirtual 784	com/tencent/biz/pubaccount/ecshopassit/EcshopReportHandler:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   275: goto +29 -> 304
    //   278: aload_2
    //   279: ifnull +19 -> 298
    //   282: aload_2
    //   283: ldc_w 777
    //   286: aconst_null
    //   287: ldc_w 816
    //   290: aload_3
    //   291: ldc 215
    //   293: lconst_0
    //   294: iconst_0
    //   295: invokevirtual 784	com/tencent/biz/pubaccount/ecshopassit/EcshopReportHandler:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   298: aload_0
    //   299: aload 5
    //   301: putfield 818	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp	Ltencent/im/oidb/qqshop/qqshop_code$SRsp;
    //   304: aload_0
    //   305: getfield 121	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   308: invokevirtual 776	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   311: ifne +103 -> 414
    //   314: aload_2
    //   315: ifnull +83 -> 398
    //   318: goto +63 -> 381
    //   321: astore_1
    //   322: goto +8 -> 330
    //   325: astore_1
    //   326: goto +90 -> 416
    //   329: astore_1
    //   330: new 208	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   337: astore 4
    //   339: aload 4
    //   341: ldc_w 820
    //   344: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 4
    //   350: aload_1
    //   351: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: ldc_w 809
    //   358: iconst_1
    //   359: aload 4
    //   361: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 825	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   367: aload_0
    //   368: getfield 121	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   371: invokevirtual 776	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   374: ifne +40 -> 414
    //   377: aload_2
    //   378: ifnull +20 -> 398
    //   381: aload_2
    //   382: ldc_w 777
    //   385: aconst_null
    //   386: ldc_w 779
    //   389: aload_3
    //   390: ldc_w 781
    //   393: lconst_0
    //   394: iconst_0
    //   395: invokevirtual 784	com/tencent/biz/pubaccount/ecshopassit/EcshopReportHandler:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   398: aload_0
    //   399: aload_0
    //   400: getfield 741	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   403: invokevirtual 787	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:a	(Landroid/content/Intent;)V
    //   406: aload_0
    //   407: getfield 121	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   410: iconst_1
    //   411: invokevirtual 789	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   414: return
    //   415: astore_1
    //   416: aload_0
    //   417: getfield 121	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   420: invokevirtual 776	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   423: ifne +40 -> 463
    //   426: aload_2
    //   427: ifnull +20 -> 447
    //   430: aload_2
    //   431: ldc_w 777
    //   434: aconst_null
    //   435: ldc_w 779
    //   438: aload_3
    //   439: ldc_w 781
    //   442: lconst_0
    //   443: iconst_0
    //   444: invokevirtual 784	com/tencent/biz/pubaccount/ecshopassit/EcshopReportHandler:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   447: aload_0
    //   448: aload_0
    //   449: getfield 741	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   452: invokevirtual 787	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:a	(Landroid/content/Intent;)V
    //   455: aload_0
    //   456: getfield 121	com/tencent/mobileqq/leba/business/mainbiz/LebaQzoneAndPluginPart:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   459: iconst_1
    //   460: invokevirtual 789	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   463: aload_1
    //   464: athrow
    //   465: return
    //   466: goto -162 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	this	LebaQzoneAndPluginPart
    //   0	469	1	paramMessage	android.os.Message
    //   34	397	2	localEcshopReportHandler	EcshopReportHandler
    //   46	393	3	str1	String
    //   4	356	4	localObject1	Object
    //   54	246	5	localObject2	Object
    //   75	139	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   258	275	321	java/lang/Exception
    //   282	298	321	java/lang/Exception
    //   298	304	321	java/lang/Exception
    //   47	77	325	finally
    //   133	231	325	finally
    //   231	254	325	finally
    //   47	77	329	java/lang/Exception
    //   133	231	329	java/lang/Exception
    //   231	254	329	java/lang/Exception
    //   258	275	415	finally
    //   282	298	415	finally
    //   298	304	415	finally
    //   330	367	415	finally
  }
  
  public void a(View paramView)
  {
    QQAppInterface localQQAppInterface = a();
    QBaseActivity localQBaseActivity = a();
    if ((localQQAppInterface != null) && (localQBaseActivity != null))
    {
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131375397);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369990);
      if ((localImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localImageView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
      }
      localImageView.setImageResource(2130845487);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839393);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369991)).setText(2131719439);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375448));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375609));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375948));
      this.d = ((TextView)paramView.findViewById(2131375796));
      this.e = ((TextView)paramView.findViewById(2131375772));
      this.jdField_a_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)paramView.findViewById(2131375399));
      this.jdField_a_of_type_AndroidWidgetImageSwitcher.setFactory(new LebaQzoneAndPluginPart.9(this, localQBaseActivity));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375410));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)paramView.findViewById(2131375400));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setFactory(new LebaQzoneAndPluginPart.10(this, localQBaseActivity));
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper = new LebaQZoneFacePlayHelper(this.jdField_a_of_type_AndroidWidgetImageSwitcher, this.jdField_b_of_type_AndroidWidgetImageSwitcher, this.jdField_a_of_type_AndroidWidgetImageView, localQQAppInterface);
      if (AppSetting.d) {
        AccessibilityUtil.a(this.jdField_a_of_type_AndroidViewView, HardCodeUtil.a(2131719439), Button.class.getName());
      }
      return;
    }
    QLog.i("LebaBusinessPartImpl", 1, "initQzone app == null || activity == null");
  }
  
  public void a(View paramView, LebaViewItem paramLebaViewItem, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    if ((paramLebaViewItem != null) && (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null))
    {
      a(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName, new LebaQzoneAndPluginPart.3(this, paramView, paramLebaViewItem, paramQQAppInterface, paramQBaseActivity), paramQQAppInterface, paramQBaseActivity);
      return;
    }
    QLog.i("LebaBusinessPartImpl", 1, "item == null || item.info == null");
  }
  
  public void a(View paramView, LebaViewItem paramLebaViewItem, LebaClickReportInfo paramLebaClickReportInfo)
  {
    if ((paramLebaViewItem != null) && (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null))
    {
      QQAppInterface localQQAppInterface = a();
      QBaseActivity localQBaseActivity = a();
      if ((localQQAppInterface != null) && (localQBaseActivity != null)) {
        try
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onPluginClick item = ");
          ((StringBuilder)localObject).append(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.toString());
          QLog.i("LebaBusinessPartImpl", 1, ((StringBuilder)localObject).toString());
          a(paramLebaClickReportInfo);
          paramLebaClickReportInfo = (IRedTouchManager)localQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
          if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == NowLiveManager.jdField_a_of_type_Int)
          {
            StoryReportor.a("dynamic", "clk_story", 0, ((TroopRedTouchManager)localQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).c(), new String[0]);
          }
          else
          {
            if (7719L == paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)
            {
              a(localQQAppInterface, localQBaseActivity);
              paramLebaClickReportInfo.reportLevelOneRedInfo(100510, 31);
              return;
            }
            if (826L == paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)
            {
              c(paramView, paramLebaViewItem, localQQAppInterface, localQBaseActivity);
              return;
            }
            if (7720L == paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)
            {
              ((IExpandEntrance)QRoute.api(IExpandEntrance.class)).enterExpand(localQBaseActivity, localQQAppInterface, 2);
              ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick("2");
              if ((paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null) || (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId <= 0L)) {
                return;
              }
              paramLebaClickReportInfo.reportLevelOneRedInfo((int)paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, 31);
              ThreadManager.getUIHandler().post(new LebaQzoneAndPluginPart.4(this, paramLebaClickReportInfo, paramLebaViewItem));
              return;
            }
            if (7759L == paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)
            {
              ConfessConfig localConfessConfig = ((ConfessManager)localQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
              localObject = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
              paramLebaClickReportInfo = (LebaClickReportInfo)localObject;
              if (localConfessConfig != null)
              {
                paramLebaClickReportInfo = (LebaClickReportInfo)localObject;
                if (!TextUtils.isEmpty(localConfessConfig.l)) {
                  paramLebaClickReportInfo = localConfessConfig.l;
                }
              }
              paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl = paramLebaClickReportInfo;
            }
            else if (4030L == paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)
            {
              paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl = a(paramLebaViewItem, paramLebaClickReportInfo);
            }
          }
          b(paramView, paramLebaViewItem, localQQAppInterface, localQBaseActivity);
          return;
        }
        catch (Exception paramView)
        {
          QLog.w("LebaBusinessPartImpl", 1, "onPluginClick", paramView);
          return;
        }
      } else {
        QLog.i("LebaBusinessPartImpl", 1, "onPluginClick app == null || activity == null");
      }
    }
    else
    {
      QLog.i("LebaBusinessPartImpl", 1, "onPluginClick item == null || item.info == null");
      return;
    }
  }
  
  public void a(View paramView, boolean paramBoolean, LebaViewItem paramLebaViewItem, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    if ((paramLebaViewItem != null) && (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null))
    {
      String str1 = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl;
      String str2 = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName;
      short s = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.sResSubType;
      boolean bool1;
      if ((paramView != null) && ((paramView instanceof RedTouch))) {
        bool1 = ((RedTouch)paramView).a();
      } else {
        bool1 = false;
      }
      paramLebaViewItem = a(paramLebaViewItem, str1, s, bool1, paramBoolean, false, paramQQAppInterface, paramQBaseActivity);
      LebaViewItem localLebaViewItem = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem;
      str1 = paramLebaViewItem.jdField_a_of_type_JavaLangString;
      s = paramLebaViewItem.jdField_a_of_type_Short;
      boolean bool2 = paramLebaViewItem.jdField_c_of_type_Boolean;
      boolean bool3 = paramLebaViewItem.d;
      paramBoolean = paramLebaViewItem.jdField_b_of_type_Boolean;
      if (QLog.isColorLevel())
      {
        paramLebaViewItem = new StringBuilder();
        paramLebaViewItem.append("clickAction.name=");
        paramLebaViewItem.append(str2);
        paramLebaViewItem.append(",url=");
        paramLebaViewItem.append(str1);
        paramLebaViewItem.append(",type=");
        paramLebaViewItem.append(s);
        QLog.d("LebaBusinessPartImpl", 2, paramLebaViewItem.toString());
      }
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
      paramLebaViewItem = new StringBuilder();
      paramLebaViewItem.append(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId);
      paramLebaViewItem.append("");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath(paramLebaViewItem.toString());
      a(localAppInfo);
      int j;
      label403:
      int i;
      if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId > 0L)
      {
        if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
        {
          str1 = MobileReportManager.getStringWithRedAppinfo(str1, localAppInfo);
          if (localAppInfo.type.get() == 0) {
            paramBoolean = true;
          }
          bool1 = paramBoolean;
          if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android")) {
            bool1 = paramBoolean | true;
          }
          new ArrayList();
          if ((localAppInfo.red_display_info != null) && (localAppInfo.red_display_info.red_type_info != null))
          {
            paramLebaViewItem = localAppInfo.red_display_info.red_type_info.get();
            if ((paramLebaViewItem != null) && (paramLebaViewItem.size() >= 2))
            {
              j = ((BusinessInfoCheckUpdate.RedTypeInfo)paramLebaViewItem.get(1)).red_type.get();
              break label403;
            }
          }
          j = 0;
          paramBoolean = bool1;
          i = localAppInfo.num.get();
          paramLebaViewItem = new StringBuffer();
          paramLebaViewItem.append("status=");
          paramLebaViewItem.append(j);
          paramLebaViewItem.append("&number=");
          paramLebaViewItem.append(i);
          paramLebaViewItem.append("&path=");
          paramLebaViewItem.append(localAppInfo.path.get());
          paramLebaViewItem = paramLebaViewItem.toString();
        }
        else
        {
          paramLebaViewItem = new StringBuffer();
          paramLebaViewItem.append("status=");
          paramLebaViewItem.append(-1);
          paramLebaViewItem.append("&number=0");
          paramLebaViewItem.append("&path=");
          paramLebaViewItem.append(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId);
          paramLebaViewItem = paramLebaViewItem.toString();
          j = 0;
          i = 0;
        }
        localObject = (GameCenterManagerImp)paramQQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER);
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId);
          localStringBuilder.append("");
          if (((GameCenterManagerImp)localObject).a(localStringBuilder.toString()) != -1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (bool3)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId);
            ((StringBuilder)localObject).append("");
            localIRedTouchManager.onRedTouchItemClick(((StringBuilder)localObject).toString());
          }
          else
          {
            localIRedTouchManager.reportLevelOneRedInfo((int)localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, 31);
          }
          if (bool1) {
            a();
          }
        }
        else
        {
          bool1 = false;
        }
      }
      else
      {
        if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("qzone_feedlist")) {
          bool1 = a(false, paramQQAppInterface);
        } else {
          bool1 = false;
        }
        i = 0;
        j = 0;
        paramLebaViewItem = null;
      }
      Object localObject = new LebaQzoneAndPluginPart.ClickActionParam();
      ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_JavaLangString = str1;
      ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_b_of_type_JavaLangString = str2;
      ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_Short = s;
      ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_Boolean = bool1;
      ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_b_of_type_Boolean = paramBoolean;
      ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_c_of_type_JavaLangString = paramLebaViewItem;
      ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_c_of_type_Boolean = bool2;
      ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = localAppInfo;
      ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_Int = j;
      ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_b_of_type_Int = i;
      ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_AndroidViewView = paramView;
      ((LebaQzoneAndPluginPart.ClickActionParam)localObject).d = bool3;
      ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem = localLebaViewItem;
      ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_ComTencentMobileqqTianshuApiIRedTouchManager = localIRedTouchManager;
      a((LebaQzoneAndPluginPart.ClickActionParam)localObject, paramQQAppInterface, paramQBaseActivity);
      return;
    }
    QLog.i("LebaBusinessPartImpl", 1, "item == null || item.info == null");
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    VipUtils.a(paramAppInterface, paramString1, paramString2, paramString3, paramInt1, paramInt2, new String[0]);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaBusinessPartImpl", 2, "preloadForGameCenter");
    }
    if (!((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).enablePreloadSonic())
    {
      QLog.d("LebaBusinessPartImpl", 1, "preloadForGameCenter, net type not match, abort");
      return;
    }
    String str = a();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("LebaBusinessPartImpl", 1, "preloadForGameCenter, gameCenterUrl null");
      return;
    }
    long l3 = System.currentTimeMillis();
    long l2 = 489L;
    Object localObject1 = a();
    long l1 = l2;
    if (localObject1 != null)
    {
      l1 = l2;
      if (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null) {
        l1 = ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId;
      }
    }
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    localObject1 = localIRedTouchManager.getAppInfoByPath("200010.200011");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath(String.valueOf(l1));
    Object localObject2 = null;
    if ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() != 0)) {
      localObject1 = new SonicParserInfo(((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get(), 0L, 0);
    } else {
      localObject1 = null;
    }
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {
      localObject2 = new SonicParserInfo(localAppInfo.buffer.get(), localAppInfo.preload_ts.get(), 1002);
    }
    Object localObject3 = ((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).getSonicPreloadDataList((SonicParserInfo)localObject1);
    SparseArray localSparseArray = ((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).getSonicPreloadDataList((SonicParserInfo)localObject2);
    localObject1 = new ArrayList();
    localObject2 = new ArrayList();
    if ((localObject3 != null) && (((SparseArray)localObject3).size() > 0))
    {
      int i = 0;
      while (i < ((SparseArray)localObject3).size())
      {
        SonicPreloadData localSonicPreloadData = (SonicPreloadData)((SparseArray)localObject3).valueAt(i);
        if (localSonicPreloadData.jdField_a_of_type_Int == 1002)
        {
          localSonicPreloadData.jdField_a_of_type_JavaLangString = str;
          ((ArrayList)localObject1).add(localSonicPreloadData);
          break;
        }
        i += 1;
      }
    }
    if ((localSparseArray != null) && (localSparseArray.size() > 0))
    {
      localObject3 = (SonicPreloadData)localSparseArray.valueAt(0);
      ((SonicPreloadData)localObject3).jdField_a_of_type_JavaLangString = str;
      ((ArrayList)localObject2).add(localObject3);
    }
    paramQQAppInterface = (IWebProcessManagerService)paramQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
    if (paramQQAppInterface.preloadSonicSession((ArrayList)localObject1)) {
      localIRedTouchManager.onRedTouchItemClick("200010.200011");
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      if ((paramQQAppInterface.preloadSonicSession((ArrayList)localObject2)) && (localAppInfo != null)) {
        localAppInfo.preload_ts.set(System.currentTimeMillis());
      }
    }
    else
    {
      QLog.d("LebaBusinessPartImpl", 1, new Object[] { "preload for gamecenter, gameCenterUrl=", str });
      ((ArrayList)localObject2).add(new SonicPreloadData(0, str, true, 0L, 1));
      paramQQAppInterface.preloadSonicSession((ArrayList)localObject2);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("preloadForGameCenter cost:");
      paramQQAppInterface.append(System.currentTimeMillis() - l3);
      QLog.d("LebaBusinessPartImpl", 2, paramQQAppInterface.toString());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    if (QSecFramework.a().a(1001).booleanValue()) {
      QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(81), Integer.valueOf(1), Integer.valueOf(6), "nearbyClick1", null }, null);
    }
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - jdField_b_of_type_Long);
    if ((l2 >= 0L) && (l2 < 2000L)) {
      return;
    }
    jdField_b_of_type_Long = l1;
    Object localObject3 = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    Object localObject2 = ((IRedTouchManager)localObject3).getAppInfoByPath(String.valueOf(100510));
    ((LocalRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(100510);
    c();
    Object localObject1 = ((IRedTouchManager)localObject3).getAppInfoByPath("100510.100517");
    if (((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.has()) {
      localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get();
    } else {
      localObject1 = "";
    }
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("god buffer: ");
      ((StringBuilder)localObject4).append((String)localObject1);
      QLog.i("toplist_rank", 2, ((StringBuilder)localObject4).toString());
    }
    if ((((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.has()) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.has()))
    {
      localObject4 = ((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.get();
      if ((localObject4 != null) && (((List)localObject4).size() > 0))
      {
        localObject4 = ((List)localObject4).iterator();
        i = 2;
        while (((Iterator)localObject4).hasNext()) {
          if (((BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject4).next()).red_type.get() == 3) {
            i = 1;
          }
        }
        break label337;
      }
    }
    int i = 2;
    label337:
    ((IRedTouchManager)localObject3).onRedTouchItemClick("100510.100517");
    localObject3 = (TroopRedTouchHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
    ((TroopRedTouchHandler)localObject3).a(60);
    ((TroopRedTouchHandler)localObject3).a(59);
    localObject3 = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    if (((TroopRedTouchManager)localObject3).a())
    {
      ((INearbyOfficalReportHelper)QRoute.api(INearbyOfficalReportHelper.class)).reportLebaRedDotEvent(paramQQAppInterface, "home", "official_push_click");
      if (this.jdField_b_of_type_Int != 0)
      {
        localObject4 = (INearbyCardManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
        localINearbyReportRunnable = (INearbyReportRunnable)QRoute.api(INearbyReportRunnable.class);
        localINearbyReportRunnable.init(paramQQAppInterface, 2);
        localINearbyReportRunnable.setCardManager((INearbyCardManager)localObject4);
        localINearbyReportRunnable.setExtraValues(new String[] { String.valueOf(this.jdField_b_of_type_Int), "" });
        ThreadManagerV2.excute((Runnable)localINearbyReportRunnable, 16, null, false);
      }
    }
    ((TroopRedTouchManager)localObject3).a(false);
    int j = LebaSpecificRedTouchBiz.jdField_a_of_type_Int;
    a();
    Object localObject4 = (INearbyCardManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
    INearbyReportRunnable localINearbyReportRunnable = (INearbyReportRunnable)QRoute.api(INearbyReportRunnable.class);
    localINearbyReportRunnable.init(paramQQAppInterface, 1);
    localINearbyReportRunnable.setCardManager((INearbyCardManager)localObject4);
    ThreadManagerV2.excute((Runnable)localINearbyReportRunnable, 16, null, false);
    boolean bool;
    if ((((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.has()) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("msg0x210.SubMsgType0x6f", 2, "Nearby item is clicked zan rotTouch is display");
      }
      ReportController.a(paramQQAppInterface, "CliOper", "", "", "0X8005247", "0X8005247", 0, 0, "", "", "", "");
      bool = true;
    }
    else
    {
      bool = false;
    }
    int k = i;
    i = j;
    if (QLog.isColorLevel()) {
      NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    }
    ((INearbyProcessMonitor)QRoute.api(INearbyProcessMonitor.class)).reportSessionHit(0);
    if (!((INearbySPUtil)QRoute.api(INearbySPUtil.class)).isNeedNearbyShowGuide(paramQQAppInterface.getAccount()))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("ENTER_TIME", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("IS_HAS_REDTOUCH", bool);
      ((Intent)localObject2).putExtra("FROM_WHERE", 0);
      ((Intent)localObject2).putExtra("RANK_BANNER_PUSH", (String)localObject1);
      ((Intent)localObject2).putExtra("NEARBY_IS_HAS_ICON", k);
      j = i;
      if ((j == 56) || (j == 57)) {
        ((Intent)localObject2).putExtra("nearby_main_init_tab", 1);
      }
      NearbyFakeActivityUtils.a(paramQBaseActivity, (Intent)localObject2);
    }
    else
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("ENTER_TIME", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("IS_HAS_REDTOUCH", bool);
      ((Intent)localObject2).putExtra("FROM_WHERE", 0);
      ((Intent)localObject2).putExtra("RANK_BANNER_PUSH", (String)localObject1);
      ((Intent)localObject2).putExtra("NEARBY_IS_HAS_ICON", k);
      RouteUtils.a(paramQBaseActivity.getApplicationContext(), (Intent)localObject2, "/nearby/guide");
    }
    if (i == 59)
    {
      new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("like_clk_red").a();
    }
    else if (i == 60)
    {
      paramQBaseActivity = ((TroopRedTouchManager)localObject3).a(60);
      if ((paramQBaseActivity != null) && (paramQBaseActivity.uint64_cmd_uin.get() == 1822701914L)) {
        new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("assist_clk_red").a();
      } else {
        new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("c2c_clk_red").a();
      }
    }
    else if (i == 61)
    {
      new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("paried_clk_red").a();
    }
    ((INearbyConfigUtil)QRoute.api(INearbyConfigUtil.class)).clearRedDotInNearbyEnter(paramQQAppInterface, i);
    if (bool) {
      ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "new_thing", "clk_red", 0, 0, "", "", "", "");
    }
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).onLebaItemClick("FuJin", bool);
  }
  
  public void a(LebaQzoneAndPluginPart.ClickActionParam paramClickActionParam, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    String str1 = paramClickActionParam.jdField_a_of_type_JavaLangString;
    Object localObject3 = paramClickActionParam.jdField_b_of_type_JavaLangString;
    int i = paramClickActionParam.jdField_a_of_type_Short;
    boolean bool1 = paramClickActionParam.jdField_a_of_type_Boolean;
    boolean bool2 = paramClickActionParam.jdField_b_of_type_Boolean;
    Object localObject2 = paramClickActionParam.jdField_c_of_type_JavaLangString;
    boolean bool3 = paramClickActionParam.jdField_c_of_type_Boolean;
    BusinessInfoCheckUpdate.AppInfo localAppInfo = paramClickActionParam.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
    int j = paramClickActionParam.jdField_a_of_type_Int;
    int k = paramClickActionParam.jdField_b_of_type_Int;
    Object localObject1 = paramClickActionParam.jdField_a_of_type_AndroidViewView;
    boolean bool4 = paramClickActionParam.d;
    localObject1 = paramClickActionParam.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem;
    paramClickActionParam = paramClickActionParam.jdField_a_of_type_ComTencentMobileqqTianshuApiIRedTouchManager;
    if ((str1 != null) && (!"".equals(str1)))
    {
      String str2 = (String)LebaConstant.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId));
      if (i == 0)
      {
        paramClickActionParam = new LebaUinUrlAppendRule(paramQQAppInterface.getCurrentAccountUin()).a(str1);
        paramClickActionParam = new LebaVKeyAppendRule(paramQQAppInterface.getvKeyHexStr()).a(paramClickActionParam);
        str1 = new LebaRedDotUrlAppendRule(bool3, localAppInfo).a(paramClickActionParam);
        localObject3 = a(QQBrowserActivity.class, paramQBaseActivity);
        if (str1.contains("plg_nld=1")) {
          ((Intent)localObject3).putExtra("reportNld", true);
        }
        paramClickActionParam = str1;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ((Intent)localObject3).putExtra("redTouch", (String)localObject2);
          paramClickActionParam = str1;
          if (str1.contains("red_touch=1"))
          {
            paramClickActionParam = new StringBuilder();
            paramClickActionParam.append(str1);
            paramClickActionParam.append("&");
            paramClickActionParam.append((String)localObject2);
            paramClickActionParam = paramClickActionParam.toString();
          }
        }
        this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
        ((Intent)localObject3).putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
        ((Intent)localObject3).putExtra("plugin_start_time", System.nanoTime());
        ((Intent)localObject3).putExtra("click_start_time", System.currentTimeMillis());
        ((Intent)localObject3).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject3).putExtra("is_from_leba", true);
        ((Intent)localObject3).putExtra("leba_resid", ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId);
        ((Intent)localObject3).putExtra("has_red_dot", bool2);
        ((Intent)localObject3).putExtra("url", paramClickActionParam);
        if (!TextUtils.isEmpty(str2)) {
          ((Intent)localObject3).putExtra("big_brother_source_key", str2);
        }
        if (!a((LebaViewItem)localObject1, paramClickActionParam, (Intent)localObject3, bool3, bool2, localAppInfo, paramQQAppInterface, paramQBaseActivity)) {
          return;
        }
        paramQBaseActivity.startActivity((Intent)localObject3);
      }
      else if (i == 2)
      {
        paramClickActionParam = a(paramQQAppInterface, paramQBaseActivity, str1);
        if (paramClickActionParam != null)
        {
          paramClickActionParam = a((LebaViewItem)localObject1, localAppInfo, paramClickActionParam, paramQQAppInterface, paramQBaseActivity);
          paramClickActionParam.a("from_leba", "fromleba");
          paramClickActionParam.a("leba_resid", String.valueOf(((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId));
          paramClickActionParam.a("config_res_plugin_item_name", (String)localObject3);
          paramClickActionParam.a("redtouch_click_timestamp", String.valueOf((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)));
          paramClickActionParam.a(bool1);
          paramClickActionParam.c(((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName);
          paramClickActionParam.f((String)localObject2);
          paramClickActionParam.b(bool2);
          paramClickActionParam.a(localAppInfo);
          if (!TextUtils.isEmpty(str2)) {
            paramClickActionParam.a("download_sourceid", str2);
          }
          localObject2 = (IMiniAppService)QRoute.api(IMiniAppService.class);
          if ((((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 8059L) && (((IMiniAppService)localObject2).isMiniAppUrl(str1))) {
            ((IMiniAppService)localObject2).startMiniApp(paramQBaseActivity, str1, 2050, null);
          } else if (((IMiniAppService)localObject2).isMiniAppUrl(str1)) {
            ((IMiniAppService)localObject2).startMiniApp(paramQBaseActivity, str1, 2079, null);
          } else {
            a(paramClickActionParam);
          }
          paramClickActionParam = (LebaQzoneAndPluginPart.ClickActionParam)localObject1;
          QQKRPUtil.a(paramQQAppInterface, paramClickActionParam, j, k);
          if (this.jdField_a_of_type_JavaUtilSet.contains(paramClickActionParam.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName)) {
            this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
          }
        }
        a((LebaViewItem)localObject1);
      }
      a((LebaViewItem)localObject1, localAppInfo, paramQQAppInterface);
      a((LebaViewItem)localObject1, paramQQAppInterface, paramQBaseActivity);
      return;
    }
    a((LebaViewItem)localObject1, localAppInfo, paramQQAppInterface);
  }
  
  public void a(LeabOnPauseInfo paramLeabOnPauseInfo)
  {
    paramLeabOnPauseInfo.jdField_a_of_type_Int = b();
  }
  
  public void a(LebaViewItem paramLebaViewItem)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QLog.i("LebaBusinessPartImpl", 1, "handerQzoneJumpScheme app == null");
      return;
    }
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("qzone_feedlist"))
    {
      StatisticHitRateCollector.a().b(localQQAppInterface.getCurrentAccountUin());
      StatisticHitRateCollector.a().a(localQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 2, 0, "", "", "", "");
      paramLebaViewItem = (QZoneManagerImp)localQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
      if (paramLebaViewItem != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.unread.", 4, "qq click action and clear active feed unread");
        }
        paramLebaViewItem.a(true);
      }
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Qzone", "Qzone_prestrain", 0, 0, "0", "0", "0", "");
    }
  }
  
  public void a(LebaViewItem paramLebaViewItem, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equalsIgnoreCase("com.tx.gamecenter.android")) {
      StatisticCollector.getInstance(paramQBaseActivity).reportActionCount(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
    }
    if (paramLebaViewItem.jdField_a_of_type_Long == 1047L)
    {
      paramQQAppInterface = (IOnlineMusicStatusManager)((IOnlineStatusManagerService)paramQQAppInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineMusicStatusManager.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(4);
      }
    }
    a();
    if (!paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("qzone_feedlist"))
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
  }
  
  public void a(LebaViewItem paramLebaViewItem, BusinessInfoCheckUpdate.AppInfo paramAppInfo, QQAppInterface paramQQAppInterface)
  {
    if ((paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null) && (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId > 0L))
    {
      ILebaHelperService localILebaHelperService = (ILebaHelperService)paramQQAppInterface.getRuntimeService(ILebaHelperService.class, "");
      String str = String.valueOf(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId);
      if ((paramAppInfo != null) && (localILebaHelperService.isNeedPreloadPlugin(str))) {
        ThreadManager.getFileThreadHandler().post(new LebaQzoneAndPluginPart.15(this, str, paramQQAppInterface, paramAppInfo));
      }
      if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 7759L) {
        ConfessMsgUtil.a(paramQQAppInterface);
      }
    }
  }
  
  public void a(JumpAction paramJumpAction)
  {
    if (paramJumpAction != null) {
      paramJumpAction.a();
    }
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    ((IApolloExtensionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).c(paramString);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, LebaQzoneAndPluginPart.CheckEnterAppListener paramCheckEnterAppListener, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    if (paramCheckEnterAppListener == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          paramCheckEnterAppListener.a();
          return;
        }
        if (paramString.equals(paramQBaseActivity.getResources().getString(2131693584)))
        {
          paramString = paramQBaseActivity.getResources().getString(2131693581);
          localObject1 = paramQBaseActivity.getResources().getString(2131693586);
        }
        else if (paramString.equals(paramQBaseActivity.getResources().getString(2131693583)))
        {
          paramString = paramQBaseActivity.getResources().getString(2131693580);
          localObject1 = paramQBaseActivity.getResources().getString(2131693585);
        }
        else
        {
          if (!paramString.equals(paramQBaseActivity.getResources().getString(2131693582))) {
            break label372;
          }
          localObject1 = paramQBaseActivity.getResources().getString(2131693579);
          i = 1;
          if (i != 0)
          {
            localObject2 = paramQBaseActivity.getSharedPreferences("laba_and_qwallet_check_enter", 4);
            if (localObject2 != null)
            {
              paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("check_app_exemption__");
              localStringBuilder.append(paramQQAppInterface);
              localStringBuilder.append("_");
              localStringBuilder.append(paramString);
              paramQQAppInterface = MD5.a(localStringBuilder.toString());
              boolean bool = ((SharedPreferences)localObject2).getBoolean(paramQQAppInterface, false);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("checkEnterApp..checkKey:");
              localStringBuilder.append(paramQQAppInterface);
              localStringBuilder.append(",hasCheck:");
              localStringBuilder.append(bool);
              localStringBuilder.append("，checkName：");
              localStringBuilder.append(paramString);
              QLog.i("LebaBusinessPartImpl", 1, localStringBuilder.toString());
              if (!bool)
              {
                a(new LebaQzoneAndPluginPart.2(this, paramQBaseActivity, (String)localObject1, (SharedPreferences)localObject2, paramQQAppInterface, paramCheckEnterAppListener));
                return;
              }
            }
          }
          paramCheckEnterAppListener.a();
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("LebaBusinessPartImpl", 1, paramString, new Object[0]);
        paramCheckEnterAppListener.a();
        return;
      }
      Object localObject2 = paramString;
      int i = 1;
      paramString = (String)localObject1;
      Object localObject1 = localObject2;
      continue;
      label372:
      paramString = null;
      localObject1 = paramString;
      i = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QLog.i("LebaBusinessPartImpl", 1, "onResume app == null");
      return;
    }
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).onLebaResume();
    if (this.jdField_a_of_type_Boolean)
    {
      ThreadRegulator.a().b(4);
      this.jdField_a_of_type_Boolean = false;
    }
    QZoneEntryReporterInLeba.a(localQQAppInterface);
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.c();
    }
    c(localQQAppInterface);
    d(localQQAppInterface);
    e(localQQAppInterface);
    d(paramBoolean);
  }
  
  public boolean a(long paramLong)
  {
    return paramLong == NowLiveManager.jdField_a_of_type_Int;
  }
  
  public boolean a(LebaViewItem paramLebaViewItem, String paramString, Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2, BusinessInfoCheckUpdate.AppInfo paramAppInfo, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    long l = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId;
    int i = 0;
    if ((l == 3053L) && (paramString.indexOf("fetchCode=1") > -1))
    {
      l = NetConnInfoCenter.getServerTime();
      paramAppInfo = this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp;
      if ((paramAppInfo != null) && (paramAppInfo.expired_time.get() > l))
      {
        if (QLog.isColorLevel())
        {
          paramAppInfo = new StringBuilder();
          paramAppInfo.append("use cache:");
          paramAppInfo.append(this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get());
          QLog.i("AuthCode", 2, paramAppInfo.toString());
        }
        paramIntent.putExtra("url", URLUtil.a(paramString, "code", this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.auth_code.get()));
        paramQBaseActivity.startActivity(paramIntent);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        a(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl, paramQQAppInterface);
        paramLebaViewItem = (EcshopReportHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
        if (paramLebaViewItem != null)
        {
          paramLebaViewItem.a(134246777, null, "jump", "use_cache", "hascode", 0L, false);
          return false;
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_a_of_type_AndroidContentIntent = paramIntent;
        a(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl, paramQQAppInterface);
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1134007, 1000L);
      }
      return false;
    }
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 5647L)
    {
      if (!paramString.contains("?"))
      {
        paramLebaViewItem = new StringBuilder();
        paramLebaViewItem.append(paramString);
        paramLebaViewItem.append("?hasRedDot=");
        paramLebaViewItem.append(paramBoolean2);
        paramLebaViewItem = paramLebaViewItem.toString();
      }
      else
      {
        paramLebaViewItem = new StringBuilder();
        paramLebaViewItem.append(paramString);
        paramLebaViewItem.append("&hasRedDot=");
        paramLebaViewItem.append(paramBoolean2);
        paramLebaViewItem = paramLebaViewItem.toString();
      }
      paramString = paramLebaViewItem;
      if (paramBoolean2)
      {
        paramString = paramLebaViewItem;
        if (paramAppInfo != null)
        {
          paramString = new StringBuilder();
          paramAppInfo = paramAppInfo.missions.get();
          if (paramAppInfo.size() > 0) {
            while (i < paramAppInfo.size())
            {
              if (i == paramAppInfo.size() - 1)
              {
                paramString.append((String)paramAppInfo.get(i));
              }
              else
              {
                paramString.append((String)paramAppInfo.get(i));
                paramString.append("_");
              }
              i += 1;
            }
          }
          paramAppInfo = new StringBuilder();
          paramAppInfo.append(paramLebaViewItem);
          paramAppInfo.append("&missions=");
          paramAppInfo.append(paramString.toString());
          paramString = paramAppInfo.toString();
        }
      }
      paramIntent.putExtra("url", paramString);
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (QZoneManagerImp)paramQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
    boolean bool = paramBoolean;
    if (paramQQAppInterface != null) {
      if (paramQQAppInterface.a(2) <= 0)
      {
        bool = paramBoolean;
        if (paramQQAppInterface.a(1) <= 0) {}
      }
      else
      {
        bool = true;
      }
    }
    return bool;
  }
  
  public int b()
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (localTextView.getVisibility() == 0))
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if ((localTextView != null) && (localTextView.getVisibility() == 0)) {
        return 7;
      }
    }
    localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (localTextView.getVisibility() == 0)) {
      return 4;
    }
    localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (localTextView.getVisibility() == 0)) {
      return 5;
    }
    localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (localTextView.getVisibility() == 0)) {
      return 6;
    }
    return 0;
  }
  
  public void b(View paramView, LebaViewItem paramLebaViewItem, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    ThreadManager.post(new LebaQzoneAndPluginPart.5(this, paramView, paramLebaViewItem, paramQQAppInterface, paramQBaseActivity), 8, null, true);
  }
  
  protected void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)localObject).getAppInfoByPath("886.100170");
    int i;
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.type.get() != -1)) {
      i = 0;
    } else {
      i = -1;
    }
    int j = i;
    if (i == -1)
    {
      localAppInfo = ((IRedTouchManager)localObject).getAppInfoByPath("886.100171");
      j = i;
      if (localAppInfo != null)
      {
        j = i;
        if (localAppInfo.iNewFlag.get() != 0)
        {
          j = i;
          if (localAppInfo.type.get() != -1) {
            j = 1;
          }
        }
      }
    }
    if (j == -1)
    {
      localObject = ((IRedTouchManager)localObject).getAppInfoByPath("886.100172");
      if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0) && (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() != -1)) {
        j = 2;
      }
    }
    if (j != -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("");
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_nearby", "", "dynamic", "exp_red", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
    }
    if (((TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a()) {
      ((INearbyOfficalReportHelper)QRoute.api(INearbyOfficalReportHelper.class)).reportLebaRedDotEvent(paramQQAppInterface, "entry", "official_push_exp");
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("ReportTroopAndActivityStatics, redDotFrom=");
      paramQQAppInterface.append(j);
      QLog.d("NearbyTroopsActivity", 2, paramQQAppInterface.toString());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    LpReportInfo_pf00064.allReport(637, 31, 1);
  }
  
  void c(View paramView, LebaViewItem paramLebaViewItem, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    if (paramLebaViewItem == null) {
      return;
    }
    paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl = LebaConstant.jdField_a_of_type_JavaLangString;
    Object localObject = SharedPreUtils.c(paramQBaseActivity, paramQQAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl = ((String)localObject).trim();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("跳转url = ");
      ((StringBuilder)localObject).append(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl);
      QLog.i("enterXQBL", 2, ((StringBuilder)localObject).toString());
    }
    a(paramView, paramLebaViewItem, paramQQAppInterface, paramQBaseActivity);
    f(paramQQAppInterface);
    ReportController.a(paramQQAppInterface, "CliOper", "", "", "0X800484A", "0X800484A", 0, 0, "", "", "", "");
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (boolean bool1 = false;; bool1 = true)
      {
        LebaViewItem localLebaViewItem;
        do
        {
          bool2 = bool1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
        } while ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId != NowLiveManager.jdField_a_of_type_Int));
      }
    }
    boolean bool2 = false;
    ThreadManager.post(new LebaQzoneAndPluginPart.11(this, bool2, paramQQAppInterface), 5, null, false);
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.postDelayed(new LebaQzoneAndPluginPart.12(this, paramQQAppInterface), 100L);
  }
  
  public void d(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.jdField_c_of_type_Boolean) && (a() != null))
    {
      this.jdField_c_of_type_Boolean = true;
      ThreadManagerV2.executeOnSubThread(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void e()
  {
    QQAppInterface localQQAppInterface = a();
    QBaseActivity localQBaseActivity = a();
    if ((localQQAppInterface != null) && (localQBaseActivity != null))
    {
      ThreadManager.post(new LebaQzoneAndPluginPart.8(this, localQQAppInterface, localQBaseActivity), 5, null, false);
      return;
    }
    QLog.i("LebaBusinessPartImpl", 1, "updateQZoneRedFlag app == null || activity == null");
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.excute(new LebaQzoneAndPluginPart.13(this, (INearbyCardManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER), paramQQAppInterface), 16, null, false);
  }
  
  public void f()
  {
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.d();
    }
  }
  
  public void f(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    if (localObject != null)
    {
      oidb_0x791.RedDotInfo localRedDotInfo = ((TroopRedTouchManager)localObject).a(1);
      if (localRedDotInfo != null) {
        TroopRedTouchHandler.a(paramQQAppInterface, localRedDotInfo);
      }
      localObject = ((TroopRedTouchManager)localObject).a(6);
      if (localObject != null) {
        TroopRedTouchHandler.a(paramQQAppInterface, (oidb_0x791.RedDotInfo)localObject);
      }
    }
  }
  
  public void g()
  {
    u();
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver = ((IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class));
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.setOnCallback(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver$OnCallback);
  }
  
  public void g(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (QZoneManager)paramQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
    if (paramQQAppInterface != null)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LebaBusinessPartImpl", 2, "getQzoneUnread by tab resume.");
        }
        paramQQAppInterface.a(3);
      }
      paramQQAppInterface.a(false);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    ((INearbyProcessMonitor)QRoute.api(INearbyProcessMonitor.class)).reportSessionEnd(0);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1134010);
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.b();
    }
  }
  
  public void i()
  {
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.f();
    }
  }
  
  public void j()
  {
    s();
    w();
    Object localObject = a();
    if (localObject == null)
    {
      QLog.i("LebaBusinessPartImpl", 1, "onLebaTabChangeQzone app == null");
      return;
    }
    localObject = (QZoneManager)((QQAppInterface)localObject).getManager(QQManagerFactory.QZONE_MANAGER);
    com.tencent.mobileqq.servlet.QZoneNotifyServlet.jdField_a_of_type_Boolean = true;
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LebaBusinessPartImpl", 2, "click leba.test if get qzone unread.");
      }
      ((QZoneManager)localObject).a(3);
    }
  }
  
  public void k()
  {
    Object localObject = a();
    if (localObject == null)
    {
      QLog.i("LebaBusinessPartImpl", 1, "startWebProcess app == null");
      return;
    }
    localObject = (IWebProcessManagerService)((QQAppInterface)localObject).getRuntimeService(IWebProcessManagerService.class, "");
    if ((localObject != null) && (((IWebProcessManagerService)localObject).isNeedPreloadWebProcess())) {
      ((IWebProcessManagerService)localObject).startWebProcess(202, null);
    }
  }
  
  public void l()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QLog.i("LebaBusinessPartImpl", 1, "removeObservers app == null");
      return;
    }
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    localQQAppInterface.setHandler(getClass(), null);
    localQQAppInterface.removeHandler(getClass());
    localQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEnterUpdateObserver);
    localQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    localQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
  }
  
  public void m()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QLog.i("LebaBusinessPartImpl", 1, "addObservers app == null");
      return;
    }
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    localQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler);
    localQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEnterUpdateObserver);
    localQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    localQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
  }
  
  public void n()
  {
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.e();
    }
  }
  
  public void o()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QLog.i("LebaBusinessPartImpl", 1, "onAccountChanged app == null");
      return;
    }
    LebaQZoneFacePlayHelper localLebaQZoneFacePlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper;
    if (localLebaQZoneFacePlayHelper != null) {
      localLebaQZoneFacePlayHelper.a(localQQAppInterface);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131375397) {
      t();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void p()
  {
    LebaClickReportInfo localLebaClickReportInfo = new LebaClickReportInfo();
    localLebaClickReportInfo.jdField_a_of_type_Boolean = a();
    localLebaClickReportInfo.jdField_a_of_type_Long = 10000L;
    localLebaClickReportInfo.jdField_a_of_type_Int = 0;
    localLebaClickReportInfo.jdField_b_of_type_Int = b();
    localLebaClickReportInfo.d = LebaConstant.a(a());
    a(localLebaClickReportInfo);
  }
  
  public void q()
  {
    Object localObject = a();
    if ((this.jdField_a_of_type_AndroidContentIntent != null) && (localObject != null))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true) {
        return;
      }
      localObject = (EcshopReportHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
      if (QLog.isColorLevel()) {
        QLog.e("AuthCode", 2, "time out jump!");
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a(this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      if (localObject != null) {
        ((EcshopReportHandler)localObject).a(134246777, null, "jump", "time_out", "no_code", 0L, false);
      }
    }
  }
  
  public void r()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QLog.i("LebaBusinessPartImpl", 1, "handerQzoneJumpScheme app == null");
      return;
    }
    ThreadManager.executeOnSubThread(new LebaQzoneAndPluginPart.6(this, localQQAppInterface));
  }
  
  public void s()
  {
    Object localObject = a();
    if (localObject == null)
    {
      QLog.i("LebaBusinessPartImpl", 1, "preloadWebProcess app == null");
      return;
    }
    QLog.i("LebaBusinessPartImpl", 1, "preloadWebProcess");
    localObject = (IWebProcessManagerService)((QQAppInterface)localObject).getRuntimeService(IWebProcessManagerService.class, "");
    if (localObject == null) {
      return;
    }
    if (((IWebProcessManagerService)localObject).isNeedPreloadWebProcess()) {
      ((IWebProcessManagerService)localObject).startWebProcess(202, null);
    }
    r();
  }
  
  public void t()
  {
    QQAppInterface localQQAppInterface = a();
    QBaseActivity localQBaseActivity = a();
    if ((localQQAppInterface != null) && (localQBaseActivity != null))
    {
      cooperation.qzone.QZoneHelper.sQZoneHCCode = HardCoderManager.a().a(0, 1, 1, 0, 3000, 101, 4L, Process.myTid(), "bootQzone");
      LebaViewItem localLebaViewItem = (LebaViewItem)a().get("qzone_feedlist");
      QLog.d("LebaBusinessPartImpl", 1, "user clicked qzone feed entry.");
      ThreadManager.postImmediately(new LebaQzoneAndPluginPart.7(this, localLebaViewItem, localQQAppInterface, localQBaseActivity), null, true);
      p();
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).preLaunchMiniAppCheckinFromLeba();
      return;
    }
    QLog.i("LebaBusinessPartImpl", 1, "onClickQzone app == null || activity == null");
  }
  
  public void u()
  {
    this.jdField_a_of_type_JavaUtilSet.add("com.tx.gamecenter.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.android.music");
    this.jdField_a_of_type_JavaUtilSet.add("com.qq.yijianfankui");
    this.jdField_a_of_type_JavaUtilSet.add("com.life.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.citylife.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.tx.android.txnews.new2");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.Health");
    this.jdField_a_of_type_JavaUtilSet.add("com.android.ketang");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.zhibojian");
    this.jdField_a_of_type_JavaUtilSet.add("qzone_feedlist");
  }
  
  public void v()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      ((GameCenterManagerImp)localQQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER)).a().a(((IRedTouchManager)localQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("489"));
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void w()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QLog.i("LebaBusinessPartImpl", 1, "reportApphelper app == null");
      return;
    }
    long l2 = 0L;
    List localList = a();
    long l1 = l2;
    if (localList != null)
    {
      int i = 0;
      for (;;)
      {
        l1 = l2;
        if (i >= localList.size()) {
          break;
        }
        LebaViewItem localLebaViewItem = (LebaViewItem)localList.get(i);
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null) && (!TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName)) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("m.tx.apphelper.android")))
        {
          l1 = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId;
          break;
        }
        i += 1;
      }
    }
    ThreadManager.postImmediately(new LebaQzoneAndPluginPart.16(this, localQQAppInterface, l1), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart
 * JD-Core Version:    0.7.0.1
 */