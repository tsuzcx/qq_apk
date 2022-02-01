package com.tencent.mobileqq.leba.business.mainbiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
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
import com.tencent.biz.expand.ui.ExpandFriendMainFragment;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QZoneEntryReporterInLeba;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.lightGame.CmGameFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyObserver;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendLabelUtils;
import com.tencent.mobileqq.gamecenter.data.PadFaceManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
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
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyConfigUtil;
import com.tencent.mobileqq.nearby.NearbyEnterUpdateObserver;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.NearbyOfficalReportHelper;
import com.tencent.mobileqq.nearby.report.NearbyReportRunnable;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.onlinestatus.music.OnlineMusicStatusManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
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
  public LebaQZoneFacePlayHelper a;
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new LebaQzoneAndPluginPart.20(this);
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyObserver = new LebaQzoneAndPluginPart.17(this);
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new LebaQzoneAndPluginPart.22(this);
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new LebaQzoneAndPluginPart.18(this);
  public PreloadProcHitSession a;
  NearbyEnterUpdateObserver jdField_a_of_type_ComTencentMobileqqNearbyNearbyEnterUpdateObserver = new LebaQzoneAndPluginPart.19(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new LebaQzoneAndPluginPart.23(this);
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new LebaQzoneAndPluginPart.24(this);
  private QZoneObserver jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver = new LebaQzoneAndPluginPart.21(this);
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
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    while ((paramAppInfo.iNewFlag.get() == 0) || (!TextUtils.equals(paramAppInfo.path.get(), "826"))) {
      return;
    }
    if (!TextUtils.isEmpty(paramAppInfo.icon_url.get())) {}
    for (int i = 1;; i = 2)
    {
      paramAppInfo = BaseApplicationImpl.getApplication().getRuntime();
      ReportController.b(paramAppInfo, "dc00899", "Grp_tribe", "", "dynamic", "Clk_tribe", 0, 0, i + "", "", "", "");
      cmd0xd40.ReqBody localReqBody = new cmd0xd40.ReqBody();
      localReqBody.src.set(1);
      localReqBody.event.set(2);
      localReqBody.redtype.set(i);
      localReqBody.dev.uint32_os.set(2);
      a(ReadInJoyOidbHelper.a("OidbSvc.0xd40_0", 3392, 0, localReqBody.toByteArray()), paramAppInfo);
      return;
    }
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, AppRuntime paramAppRuntime)
  {
    if ((paramToServiceMsg == null) || (!(paramAppRuntime instanceof QQAppInterface))) {
      return;
    }
    paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    ((QQAppInterface)paramAppRuntime).sendToService(paramToServiceMsg);
  }
  
  public static boolean a(QZoneCountInfo paramQZoneCountInfo)
  {
    if (paramQZoneCountInfo == null) {}
    while ((paramQZoneCountInfo.friendList == null) || (paramQZoneCountInfo.friendList.size() <= 0) || (paramQZoneCountInfo.uCount <= 0L)) {
      return false;
    }
    return true;
  }
  
  public static boolean b(QZoneCountInfo paramQZoneCountInfo)
  {
    if (paramQZoneCountInfo == null) {}
    while ((TextUtils.isEmpty(paramQZoneCountInfo.strShowMsg)) || (paramQZoneCountInfo.uCount <= 0L)) {
      return false;
    }
    return true;
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
    Object localObject;
    short s;
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android"))
    {
      paramString = a("vipGameCenter");
      List localList;
      int i;
      if (TextUtils.isEmpty(paramString))
      {
        paramString = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl;
        QLog.d("LebaBusinessPartImpl", 1, "clickAction gamecenter use plugin info url=" + paramString);
        localObject = paramString;
        s = paramShort;
        if (!paramBoolean1) {
          break label364;
        }
        String str = "-1";
        localList = ((RedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(String.valueOf(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)).missions.get();
        localObject = str;
        if (localList == null) {
          break label301;
        }
        localObject = str;
        if (localList.size() <= 0) {
          break label301;
        }
        localObject = "-1";
        i = 0;
        label178:
        if (i >= localList.size()) {
          break label301;
        }
        if (i != 0) {
          break label260;
        }
      }
      label260:
      for (localObject = (String)localList.get(i);; localObject = (String)localObject + "_" + (String)localList.get(i))
      {
        i += 1;
        break label178;
        if (paramString.startsWith("http")) {
          paramShort = 0;
        }
        QLog.d("LebaBusinessPartImpl", 1, "clickAction gamecenter use IndividuationUrl url=" + paramString);
        break;
      }
      label301:
      if (paramShort == 0)
      {
        paramString = paramString + "&missions=" + (String)localObject;
        QLog.i("LebaBusinessPartImpl", 1, "[dealGameCenterUrl] add redPointId :" + paramString);
        s = paramShort;
        localObject = paramString;
      }
    }
    for (;;)
    {
      label364:
      if (paramBoolean2)
      {
        if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId != 0L) {
          break label601;
        }
        if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          paramBoolean3 = true;
        }
      }
      label401:
      label601:
      for (;;)
      {
        ReadinjoySPEventReport.a().b((int)paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, paramBoolean3);
        for (;;)
        {
          paramString = new LebaQzoneAndPluginPart.ClickActionParam();
          paramString.jdField_a_of_type_JavaLangString = ((String)localObject);
          paramString.jdField_a_of_type_Short = s;
          paramString.jdField_b_of_type_Boolean = paramBoolean3;
          paramString.jdField_c_of_type_Boolean = paramBoolean1;
          paramString.d = paramBoolean2;
          paramString.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem = paramLebaViewItem;
          return paramString;
          if (paramShort != 2) {
            break label604;
          }
          paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramQBaseActivity, paramString).b("url");
          paramString = paramString.replace(paramQQAppInterface, paramQQAppInterface + URLEncoder.encode(new StringBuilder().append("&missions=").append((String)localObject).toString()));
          break;
          paramBoolean3 = false;
          break label401;
          ReadinjoySPEventReport.a().b((int)paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, paramBoolean1);
          if ("com.tx.xingqubuluo.android".equals(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName)) {
            paramBoolean3 = paramBoolean1;
          }
          if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 7966L) {
            paramBoolean3 = paramBoolean1;
          }
        }
      }
      label604:
      break;
      localObject = paramString;
      s = paramShort;
    }
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
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android")) {
      paramJumpAction.e("platformId=qq_m");
    }
    do
    {
      return paramJumpAction;
      if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("com.tx.xingqubuluo.android")) {
        return a(paramAppInfo, paramJumpAction, paramQQAppInterface);
      }
      if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("com.read.android"))
      {
        paramJumpAction.a("ChannelID", "100020");
        return paramJumpAction;
      }
    } while (!a(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId));
    return a(paramJumpAction, paramQQAppInterface, paramQBaseActivity);
  }
  
  public JumpAction a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, JumpAction paramJumpAction, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramQQAppInterface.d();
    if (i > 0) {
      localStringBuffer.append("redid=" + i);
    }
    int j = paramQQAppInterface.a();
    if (j > 0) {
      if (localStringBuffer.length() != 0) {
        break label252;
      }
    }
    label252:
    for (paramQQAppInterface = "";; paramQQAppInterface = "&rpnumber=" + j)
    {
      localStringBuffer.append(paramQQAppInterface);
      QLog.i("LebaBusinessPartImpl", 1, "xqbl redid=" + i + ",rpnumber=" + j);
      try
      {
        paramQQAppInterface = new JSONObject(paramAppInfo.buffer.get());
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.optJSONObject("param");
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = paramQQAppInterface.optJSONObject((String)paramAppInfo.missions.get(0));
            if (paramQQAppInterface != null)
            {
              paramAppInfo = paramQQAppInterface.optString("_red_ext_bid");
              paramQQAppInterface = paramQQAppInterface.optString("_red_ext_pid");
              if (!TextUtils.isEmpty(paramAppInfo)) {
                localStringBuffer.append("&bid=").append(paramAppInfo);
              }
              if (!TextUtils.isEmpty(paramQQAppInterface)) {
                localStringBuffer.append("&pid=").append(paramQQAppInterface);
              }
            }
          }
        }
      }
      catch (Exception paramAppInfo)
      {
        for (;;)
        {
          QLog.i("LebaBusinessPartImpl", 1, "handerSpecialWhenJumpScheme", paramAppInfo);
        }
      }
      if (localStringBuffer.length() > 0) {
        paramJumpAction.e(localStringBuffer.toString());
      }
      return paramJumpAction;
    }
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
        localObject1 = ((TroopRedTouchManager)localObject3).a(52);
        if (localObject1 != null) {
          break label236;
        }
        localObject1 = ((TroopRedTouchManager)localObject3).a(35);
      }
    }
    label236:
    for (;;)
    {
      localObject2 = paramJumpAction;
      if (localObject1 != null)
      {
        localObject2 = paramJumpAction;
        if (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() == 37) {
          localObject3 = null;
        }
      }
      try
      {
        localObject2 = new JSONObject(((oidb_0x791.RedDotInfo)localObject1).str_custom_buffer.get().toStringUtf8()).getString("fake_protocol");
        localObject3 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          SLog.d("Leba.qqstory.tag", "tag red dot json parse error , %s", new Object[] { localException.getMessage() });
          continue;
          paramJumpAction = String.valueOf(((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get());
        }
      }
      localObject2 = paramJumpAction;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = JumpParser.a(paramQQAppInterface, paramQBaseActivity, (String)localObject3);
      }
      if (localObject1 == null)
      {
        paramJumpAction = "";
        ((JumpAction)localObject2).a("redid", paramJumpAction);
        ((JumpAction)localObject2).a("lebaVersion", "old");
        return localObject2;
      }
    }
  }
  
  public String a()
  {
    Object localObject2 = IndividuationUrlHelper.a("vipGameCenter");
    Object localObject1 = localObject2;
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        if (((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null) {
          break label91;
        }
      }
    }
    label91:
    for (localObject1 = ((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = JumpParser.a(a(), a(), (String)localObject1);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((JumpAction)localObject3).b("url");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          localObject2 = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393";
        }
      }
      return localObject2;
    }
    try
    {
      localObject1 = URLDecoder.decode((String)localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393";
  }
  
  public String a(String paramString)
  {
    return IndividuationUrlHelper.a(paramString);
  }
  
  public void a(Message paramMessage)
  {
    QQAppInterface localQQAppInterface = a();
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (localQQAppInterface == null) || (paramMessage == null)) {}
    for (;;)
    {
      return;
      EcshopReportHandler localEcshopReportHandler = (EcshopReportHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
      String str1 = String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      try
      {
        paramMessage = (qqshop_code.SRsp)paramMessage.obj;
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
        String str3 = paramMessage.auth_code.get();
        if (str3 == null) {
          return;
        }
        str3 = URLUtil.a(str2, "code", paramMessage.auth_code.get());
        this.jdField_a_of_type_AndroidContentIntent.putExtra("url", str3);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (QLog.isColorLevel()) {
            QLog.i("AuthCode", 2, "newUrl:" + str3);
          }
          a(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          a(str2, localQQAppInterface);
          if (localEcshopReportHandler != null) {
            localEcshopReportHandler.a(134246777, null, "jump", str1, "hascode", 0L, false);
          }
        }
        for (;;)
        {
          return;
          if (localEcshopReportHandler != null) {
            localEcshopReportHandler.a(134246777, null, "not_jump", str1, "", 0L, false);
          }
          this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp = paramMessage;
        }
      }
      catch (Exception paramMessage)
      {
        QLog.e("AuthCode", 1, "authcode resp exception:" + paramMessage);
        return;
      }
      finally
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (localEcshopReportHandler != null) {
            localEcshopReportHandler.a(134246777, null, "jump", str1, "no_code", 0L, false);
          }
          a(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    QQAppInterface localQQAppInterface = a();
    QBaseActivity localQBaseActivity = a();
    if ((localQQAppInterface == null) || (localQBaseActivity == null)) {
      QLog.i("LebaBusinessPartImpl", 1, "initQzone app == null || activity == null");
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131375881);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370322);
      if ((localImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localImageView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
      }
      localImageView.setImageResource(2130845614);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839537);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370323)).setText(2131719716);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375932));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376096));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376437));
      this.d = ((TextView)paramView.findViewById(2131376282));
      this.e = ((TextView)paramView.findViewById(2131376258));
      this.jdField_a_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)paramView.findViewById(2131375883));
      this.jdField_a_of_type_AndroidWidgetImageSwitcher.setFactory(new LebaQzoneAndPluginPart.9(this, localQBaseActivity));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375894));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)paramView.findViewById(2131375884));
      this.jdField_b_of_type_AndroidWidgetImageSwitcher.setFactory(new LebaQzoneAndPluginPart.10(this, localQBaseActivity));
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper = new LebaQZoneFacePlayHelper(this.jdField_a_of_type_AndroidWidgetImageSwitcher, this.jdField_b_of_type_AndroidWidgetImageSwitcher, this.jdField_a_of_type_AndroidWidgetImageView, localQQAppInterface);
    } while (!AppSetting.d);
    AccessibilityUtil.a(this.jdField_a_of_type_AndroidViewView, HardCodeUtil.a(2131719716), Button.class.getName());
  }
  
  public void a(View paramView, LebaViewItem paramLebaViewItem, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    if ((paramLebaViewItem == null) || (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null))
    {
      QLog.i("LebaBusinessPartImpl", 1, "item == null || item.info == null");
      return;
    }
    a(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName, new LebaQzoneAndPluginPart.3(this, paramView, paramLebaViewItem, paramQQAppInterface, paramQBaseActivity), paramQQAppInterface, paramQBaseActivity);
  }
  
  public void a(View paramView, LebaViewItem paramLebaViewItem, LebaClickReportInfo paramLebaClickReportInfo)
  {
    if ((paramLebaViewItem == null) || (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null))
    {
      QLog.i("LebaBusinessPartImpl", 1, "onPluginClick item == null || item.info == null");
      return;
    }
    QQAppInterface localQQAppInterface = a();
    QBaseActivity localQBaseActivity = a();
    if ((localQQAppInterface == null) || (localQBaseActivity == null))
    {
      QLog.i("LebaBusinessPartImpl", 1, "onPluginClick app == null || activity == null");
      return;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        QLog.i("LebaBusinessPartImpl", 1, "onPluginClick item = " + paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.toString());
        a(paramLebaClickReportInfo);
        localObject = (RedTouchManager)localQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
        if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == NowLiveManager.jdField_a_of_type_Int)
        {
          StoryReportor.a("dynamic", "clk_story", 0, ((TroopRedTouchManager)localQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).c(), new String[0]);
          b(paramView, paramLebaViewItem, localQQAppInterface, localQBaseActivity);
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.w("LebaBusinessPartImpl", 1, "onPluginClick", paramView);
        return;
      }
      if (7719L == paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)
      {
        a(localQQAppInterface, localQBaseActivity);
        ((RedTouchManager)localObject).a(100510, 31);
        return;
      }
      if (826L == paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)
      {
        c(paramView, paramLebaViewItem, localQQAppInterface, localQBaseActivity);
        return;
      }
      if (7720L == paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)
      {
        if (paramLebaClickReportInfo.d == -1)
        {
          PublicFragmentActivityForTool.a(localQBaseActivity, ExpandFriendMainFragment.class);
          return;
        }
        ExtendFriendLabelUtils.a(localQBaseActivity, localQQAppInterface, 2);
        ExpandReportUtils.b("2");
        if ((paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null) || (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId <= 0L)) {
          break;
        }
        ((RedTouchManager)localObject).a((int)paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, 31);
        ThreadManager.getUIHandler().post(new LebaQzoneAndPluginPart.4(this, (RedTouchManager)localObject, paramLebaViewItem));
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
    }
  }
  
  public void a(View paramView, boolean paramBoolean, LebaViewItem paramLebaViewItem, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    if ((paramLebaViewItem == null) || (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null))
    {
      QLog.i("LebaBusinessPartImpl", 1, "item == null || item.info == null");
      return;
    }
    String str1 = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl;
    String str2 = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName;
    short s = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.sResSubType;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (paramView != null)
    {
      bool1 = bool3;
      if ((paramView instanceof RedTouch)) {
        bool1 = ((RedTouch)paramView).a();
      }
    }
    paramLebaViewItem = a(paramLebaViewItem, str1, s, bool1, paramBoolean, false, paramQQAppInterface, paramQBaseActivity);
    LebaViewItem localLebaViewItem = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem;
    str1 = paramLebaViewItem.jdField_a_of_type_JavaLangString;
    s = paramLebaViewItem.jdField_a_of_type_Short;
    bool3 = paramLebaViewItem.jdField_c_of_type_Boolean;
    boolean bool4 = paramLebaViewItem.d;
    paramBoolean = paramLebaViewItem.jdField_b_of_type_Boolean;
    if (QLog.isColorLevel()) {
      QLog.d("LebaBusinessPartImpl", 2, "clickAction.name=" + str2 + ",url=" + str1 + ",type=" + s);
    }
    RedTouchManager localRedTouchManager = (RedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId + "");
    a(localAppInfo);
    int k = 0;
    int j = 0;
    int m = 0;
    int i = 0;
    if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId > 0L) {
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
      {
        str1 = MobileReportManager.getStringWithRedAppinfo(str1, localAppInfo);
        if (localAppInfo.type.get() == 0) {
          paramBoolean = true;
        }
        if (!localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("com.tx.gamecenter.android")) {
          break label845;
        }
        paramBoolean |= true;
      }
    }
    label523:
    label559:
    label845:
    for (;;)
    {
      new ArrayList();
      if ((localAppInfo.red_display_info != null) && (localAppInfo.red_display_info.red_type_info != null))
      {
        paramLebaViewItem = localAppInfo.red_display_info.red_type_info.get();
        if ((paramLebaViewItem == null) || (paramLebaViewItem.size() < 2)) {}
      }
      for (i = ((BusinessInfoCheckUpdate.RedTypeInfo)paramLebaViewItem.get(1)).red_type.get();; i = 0)
      {
        k = localAppInfo.num.get();
        paramLebaViewItem = "status=" + i + "&number=" + k + "&path=" + localAppInfo.path.get();
        j = i;
        i = k;
        Object localObject = (GameCenterManagerImp)paramQQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER);
        if (localObject != null) {
          if (((GameCenterManagerImp)localObject).a(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId + "") != -1)
          {
            bool1 = true;
            if (!bool4) {
              break label750;
            }
            localRedTouchManager.b(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId + "");
            bool2 = bool1;
            if (bool1) {
              a();
            }
          }
        }
        for (bool2 = bool1;; bool2 = false)
        {
          bool1 = paramBoolean;
          paramBoolean = bool2;
          for (;;)
          {
            localObject = new LebaQzoneAndPluginPart.ClickActionParam();
            ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_JavaLangString = str1;
            ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_b_of_type_JavaLangString = str2;
            ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_Short = s;
            ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_Boolean = paramBoolean;
            ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_b_of_type_Boolean = bool1;
            ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_c_of_type_JavaLangString = paramLebaViewItem;
            ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_c_of_type_Boolean = bool3;
            ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = localAppInfo;
            ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_Int = j;
            ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_b_of_type_Int = i;
            ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_AndroidViewView = paramView;
            ((LebaQzoneAndPluginPart.ClickActionParam)localObject).d = bool4;
            ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem = localLebaViewItem;
            ((LebaQzoneAndPluginPart.ClickActionParam)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager = localRedTouchManager;
            a((LebaQzoneAndPluginPart.ClickActionParam)localObject, paramQQAppInterface, paramQBaseActivity);
            return;
            paramLebaViewItem = "status=" + -1 + "&number=0" + "&path=" + localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId;
            break;
            bool1 = false;
            break label523;
            label750:
            localRedTouchManager.a((int)localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, 31);
            break label559;
            if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("qzone_feedlist"))
            {
              bool2 = a(false, paramQQAppInterface);
              paramLebaViewItem = null;
              bool1 = paramBoolean;
              i = m;
              j = k;
              paramBoolean = bool2;
            }
            else
            {
              paramLebaViewItem = null;
              bool1 = paramBoolean;
              i = m;
              j = k;
              paramBoolean = bool2;
            }
          }
        }
      }
    }
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
    long l2 = System.currentTimeMillis();
    Object localObject1 = a();
    if ((localObject1 != null) && (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null)) {}
    for (long l1 = ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId;; l1 = 489L)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      localObject1 = localRedTouchManager.a("200010.200011");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a(String.valueOf(l1));
      if ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() != 0)) {}
      for (localObject1 = new SonicParserInfo(((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get(), 0L, 0);; localObject1 = null)
      {
        if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {}
        for (Object localObject2 = new SonicParserInfo(localAppInfo.buffer.get(), localAppInfo.preload_ts.get(), 1002);; localObject2 = null)
        {
          Object localObject3 = ((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).getSonicPreloadDataList((SonicParserInfo)localObject1);
          SparseArray localSparseArray = ((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).getSonicPreloadDataList((SonicParserInfo)localObject2);
          localObject1 = new ArrayList();
          localObject2 = new ArrayList();
          int i;
          if ((localObject3 != null) && (((SparseArray)localObject3).size() > 0))
          {
            i = 0;
            if (i < ((SparseArray)localObject3).size())
            {
              SonicPreloadData localSonicPreloadData = (SonicPreloadData)((SparseArray)localObject3).valueAt(i);
              if (localSonicPreloadData.jdField_a_of_type_Int != 1002) {
                break label482;
              }
              localSonicPreloadData.jdField_a_of_type_JavaLangString = str;
              ((ArrayList)localObject1).add(localSonicPreloadData);
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
            localRedTouchManager.b(String.valueOf("200010.200011"));
          }
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
            if ((paramQQAppInterface.preloadSonicSession((ArrayList)localObject2)) && (localAppInfo != null)) {
              localAppInfo.preload_ts.set(System.currentTimeMillis());
            }
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label540;
            }
            QLog.d("LebaBusinessPartImpl", 2, "preloadForGameCenter cost:" + (System.currentTimeMillis() - l2));
            return;
            label482:
            i += 1;
            break;
            QLog.d("LebaBusinessPartImpl", 1, new Object[] { "preload for gamecenter, gameCenterUrl=", str });
            ((ArrayList)localObject2).add(new SonicPreloadData(0, str, true, 0L, 1));
            paramQQAppInterface.preloadSonicSession((ArrayList)localObject2);
          }
          label540:
          break;
        }
      }
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
    Object localObject3 = (RedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    Object localObject2 = ((RedTouchManager)localObject3).a(String.valueOf(100510));
    ((LocalRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(100510);
    c();
    Object localObject1 = ((RedTouchManager)localObject3).a("100510.100517");
    if (((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.has()) {}
    Object localObject4;
    int i;
    for (localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get();; localObject1 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.i("toplist_rank", 2, "god buffer: " + (String)localObject1);
      }
      if ((!((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.has()) || (!((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.has())) {
        break label1040;
      }
      localObject4 = ((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.get();
      if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
        break label1040;
      }
      localObject4 = ((List)localObject4).iterator();
      for (i = 2; ((Iterator)localObject4).hasNext(); i = 1) {
        if (((BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject4).next()).red_type.get() != 3) {
          break label1037;
        }
      }
    }
    for (;;)
    {
      ((RedTouchManager)localObject3).b("100510.100517");
      localObject3 = (TroopRedTouchHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
      ((TroopRedTouchHandler)localObject3).a(60);
      ((TroopRedTouchHandler)localObject3).a(59);
      localObject3 = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
      if (((TroopRedTouchManager)localObject3).a())
      {
        NearbyOfficalReportHelper.a().a(paramQQAppInterface, "home", "official_push_click");
        if (this.jdField_b_of_type_Int != 0)
        {
          localObject4 = (NearbyCardManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
          localNearbyReportRunnable = new NearbyReportRunnable(paramQQAppInterface, 2);
          localNearbyReportRunnable.a((NearbyCardManager)localObject4);
          localNearbyReportRunnable.a(new String[] { String.valueOf(this.jdField_b_of_type_Int), "" });
          ThreadManagerV2.excute(localNearbyReportRunnable, 16, null, false);
        }
      }
      ((TroopRedTouchManager)localObject3).a(false);
      int j = LebaSpecificRedTouchBiz.jdField_a_of_type_Int;
      a();
      localObject4 = (NearbyCardManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
      NearbyReportRunnable localNearbyReportRunnable = new NearbyReportRunnable(paramQQAppInterface, 1);
      localNearbyReportRunnable.a((NearbyCardManager)localObject4);
      ThreadManagerV2.excute(localNearbyReportRunnable, 16, null, false);
      boolean bool;
      if ((((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.has()) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1))
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("msg0x210.SubMsgType0x6f", 2, "Nearby item is clicked zan rotTouch is display");
        }
        ReportController.a(paramQQAppInterface, "CliOper", "", "", "0X8005247", "0X8005247", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        NearbyProcessMonitor.b(0);
        if (!NearbySPUtil.f(paramQQAppInterface.getAccount()))
        {
          localObject2 = new Intent(paramQBaseActivity, NearbyActivity.class);
          ((Intent)localObject2).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject2).putExtra("FROM_WHERE", 0);
          ((Intent)localObject2).putExtra("RANK_BANNER_PUSH", (String)localObject1);
          ((Intent)localObject2).putExtra("NEARBY_IS_HAS_ICON", i);
          if ((j == 56) || (j == 57)) {
            ((Intent)localObject2).putExtra("nearby_main_init_tab", 1);
          }
          NearbyFakeActivity.a(paramQBaseActivity, (Intent)localObject2);
          if (j != 59) {
            break label880;
          }
          new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("like_clk_red").a();
        }
        for (;;)
        {
          NearbyConfigUtil.a(paramQQAppInterface, j);
          if (bool) {
            ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "new_thing", "clk_red", 0, 0, "", "", "", "");
          }
          ReadinjoySPEventReport.a().a("FuJin", bool);
          return;
          localObject2 = new Intent(paramQBaseActivity, NearbyGuideActivity.class);
          ((Intent)localObject2).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject2).putExtra("FROM_WHERE", 0);
          ((Intent)localObject2).putExtra("RANK_BANNER_PUSH", (String)localObject1);
          ((Intent)localObject2).putExtra("NEARBY_IS_HAS_ICON", i);
          paramQBaseActivity.startActivity((Intent)localObject2);
          break;
          label880:
          if (j == 60)
          {
            paramQBaseActivity = ((TroopRedTouchManager)localObject3).a(60);
            if ((paramQBaseActivity != null) && (paramQBaseActivity.uint64_cmd_uin.get() == 1822701914L)) {
              new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("assist_clk_red").a();
            } else {
              new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("c2c_clk_red").a();
            }
          }
          else if (j == 61)
          {
            new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("paried_clk_red").a();
          }
        }
        bool = false;
      }
      label1037:
      break;
      label1040:
      i = 2;
    }
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
    paramClickActionParam = paramClickActionParam.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager;
    if ((str1 == null) || ("".equals(str1))) {
      a((LebaViewItem)localObject1, localAppInfo, paramQQAppInterface);
    }
    String str2;
    do
    {
      return;
      str2 = (String)LebaConstant.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId));
      if (i != 0) {
        break;
      }
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
        if (str1.contains("red_touch=1")) {
          paramClickActionParam = str1 + "&" + (String)localObject2;
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
    } while (!a((LebaViewItem)localObject1, paramClickActionParam, (Intent)localObject3, bool3, bool2, localAppInfo, paramQQAppInterface, paramQBaseActivity));
    paramQBaseActivity.startActivity((Intent)localObject3);
    while (i != 2)
    {
      a((LebaViewItem)localObject1, localAppInfo, paramQQAppInterface);
      a((LebaViewItem)localObject1, paramQQAppInterface, paramQBaseActivity);
      return;
    }
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
      if ((((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId != 8059L) || (!((IMiniAppService)localObject2).isMiniAppUrl(str1))) {
        break label684;
      }
      ((IMiniAppService)localObject2).startMiniApp(paramQBaseActivity, str1, 2050, null);
    }
    for (;;)
    {
      QQKRPUtil.a(paramQQAppInterface, (LebaViewItem)localObject1, j, k);
      if (this.jdField_a_of_type_JavaUtilSet.contains(((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName)) {
        this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
      }
      a((LebaViewItem)localObject1);
      break;
      label684:
      a(paramClickActionParam);
    }
  }
  
  public void a(LeabOnPauseInfo paramLeabOnPauseInfo)
  {
    paramLeabOnPauseInfo.jdField_a_of_type_Int = b();
  }
  
  public void a(LebaViewItem paramLebaViewItem)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      QLog.i("LebaBusinessPartImpl", 1, "handerQzoneJumpScheme app == null");
    }
    while (!paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("qzone_feedlist")) {
      return;
    }
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
  
  public void a(LebaViewItem paramLebaViewItem, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equalsIgnoreCase("com.tx.gamecenter.android")) {
      StatisticCollector.getInstance(paramQBaseActivity).reportActionCount(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
    }
    if (paramLebaViewItem.jdField_a_of_type_Long == 1047L) {
      OnlineMusicStatusManager.a().jdField_a_of_type_Int = 4;
    }
    a();
    if (!paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("qzone_feedlist")) {
      this.jdField_b_of_type_Boolean = true;
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
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
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
    String str;
    int i;
    if (paramString.equals(paramQBaseActivity.getResources().getString(2131693631)))
    {
      str = paramQBaseActivity.getResources().getString(2131693628);
      paramString = paramQBaseActivity.getResources().getString(2131693633);
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        SharedPreferences localSharedPreferences = paramQBaseActivity.getSharedPreferences("laba_and_qwallet_check_enter", 4);
        if (localSharedPreferences != null)
        {
          paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
          paramQQAppInterface = MD5.a("check_app_exemption__" + paramQQAppInterface + "_" + paramString);
          boolean bool = localSharedPreferences.getBoolean(paramQQAppInterface, false);
          QLog.i("LebaBusinessPartImpl", 1, "checkEnterApp..checkKey:" + paramQQAppInterface + ",hasCheck:" + bool + "，checkName：" + paramString);
          if (!bool)
          {
            a(new LebaQzoneAndPluginPart.2(this, paramQBaseActivity, str, localSharedPreferences, paramQQAppInterface, paramCheckEnterAppListener));
            return;
            if (paramString.equals(paramQBaseActivity.getResources().getString(2131693630)))
            {
              str = paramQBaseActivity.getResources().getString(2131693627);
              paramString = paramQBaseActivity.getResources().getString(2131693632);
              i = 1;
              continue;
            }
            if (!paramString.equals(paramQBaseActivity.getResources().getString(2131693629))) {
              break label323;
            }
            str = paramQBaseActivity.getResources().getString(2131693626);
            i = 1;
            continue;
          }
        }
      }
      paramCheckEnterAppListener.a();
      return;
      label323:
      paramString = null;
      str = null;
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
    ReadinjoySPEventReport.a().c();
    if (this.jdField_a_of_type_Boolean)
    {
      ThreadRegulator.a().b(4);
      this.jdField_a_of_type_Boolean = false;
    }
    QZoneEntryReporterInLeba.a(localQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.c();
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
    if ((paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 3053L) && (paramString.indexOf("fetchCode=1") > -1))
    {
      long l = NetConnInfoCenter.getServerTime();
      if ((this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp != null) && (this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get() > l))
      {
        if (QLog.isColorLevel()) {
          QLog.i("AuthCode", 2, "use cache:" + this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get());
        }
        paramIntent.putExtra("url", URLUtil.a(paramString, "code", this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.auth_code.get()));
        paramQBaseActivity.startActivity(paramIntent);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        a(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl, paramQQAppInterface);
        paramLebaViewItem = (EcshopReportHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
        if (paramLebaViewItem != null) {
          paramLebaViewItem.a(134246777, null, "jump", "use_cache", "hascode", 0L, false);
        }
      }
      for (;;)
      {
        return false;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_a_of_type_AndroidContentIntent = paramIntent;
        a(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl, paramQQAppInterface);
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1134007, 1000L);
      }
    }
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 5647L)
    {
      int i;
      if (!paramString.contains("?"))
      {
        paramString = paramString + "?hasRedDot=" + paramBoolean2;
        if ((!paramBoolean2) || (paramAppInfo == null)) {
          break label526;
        }
        paramQQAppInterface = new StringBuilder();
        paramAppInfo = paramAppInfo.missions.get();
        if (paramAppInfo.size() <= 0) {
          break label429;
        }
        i = 0;
        label320:
        if (i >= paramAppInfo.size()) {
          break label429;
        }
        if (i != paramAppInfo.size() - 1) {
          break label402;
        }
        paramQQAppInterface.append((String)paramAppInfo.get(i));
      }
      for (;;)
      {
        i += 1;
        break label320;
        paramString = paramString + "&hasRedDot=" + paramBoolean2;
        break;
        label402:
        paramQQAppInterface.append((String)paramAppInfo.get(i)).append("_");
      }
      label429:
      paramString = paramString + "&missions=" + paramQQAppInterface.toString();
    }
    label526:
    for (;;)
    {
      paramIntent.putExtra("url", paramString);
      if ("com.cmshow.game.android".equals(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName))
      {
        paramIntent.putExtra("fragment_class", CmGameFragment.class.getCanonicalName());
        paramIntent.putExtra("hide_operation_bar", true);
        paramIntent.putExtra("hide_more_button", true);
        paramIntent.putExtra("portraitOnly", true);
      }
      return true;
    }
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
    int j = 0;
    int i;
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      i = 7;
    }
    do
    {
      do
      {
        return i;
        if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          return 4;
        }
        if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          return 5;
        }
        i = j;
      } while (this.jdField_c_of_type_AndroidWidgetTextView == null);
      i = j;
    } while (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0);
    return 6;
  }
  
  public void b(View paramView, LebaViewItem paramLebaViewItem, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    ThreadManager.post(new LebaQzoneAndPluginPart.5(this, paramView, paramLebaViewItem, paramQQAppInterface, paramQBaseActivity), 8, null, true);
  }
  
  protected void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (RedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    int j;
    if (localObject != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject).a("886.100170");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.type.get() != -1))
      {
        j = 0;
        int i = j;
        if (j == -1)
        {
          localAppInfo = ((RedTouchManager)localObject).a("886.100171");
          i = j;
          if (localAppInfo != null)
          {
            i = j;
            if (localAppInfo.iNewFlag.get() != 0)
            {
              i = j;
              if (localAppInfo.type.get() != -1) {
                i = 1;
              }
            }
          }
        }
        j = i;
        if (i == -1)
        {
          localObject = ((RedTouchManager)localObject).a("886.100172");
          j = i;
          if (localObject != null)
          {
            j = i;
            if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0)
            {
              j = i;
              if (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() != -1) {
                j = 2;
              }
            }
          }
        }
        if (j != -1) {
          ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_nearby", "", "dynamic", "exp_red", 0, 0, j + "", "", "", "");
        }
        if (((TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a()) {
          NearbyOfficalReportHelper.a().a(paramQQAppInterface, "entry", "official_push_exp");
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTroopsActivity", 2, "ReportTroopAndActivityStatics, redDotFrom=" + j);
      }
      return;
      j = -1;
      break;
      j = -1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ReadinjoySPEventReport.a().a(3, paramBoolean);
    LpReportInfo_pf00064.allReport(637, 31, 1);
  }
  
  void c(View paramView, LebaViewItem paramLebaViewItem, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    if (paramLebaViewItem == null) {
      return;
    }
    paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl = LebaConstant.jdField_a_of_type_JavaLangString;
    String str = SharedPreUtils.c(paramQBaseActivity, paramQQAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty(str)) {
      paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl = str.trim();
    }
    if (QLog.isColorLevel()) {
      QLog.i("enterXQBL", 2, "跳转url = " + paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGotoUrl);
    }
    a(paramView, paramLebaViewItem, paramQQAppInterface, paramQBaseActivity);
    f(paramQQAppInterface);
    ReportController.a(paramQQAppInterface, "CliOper", "", "", "0X800484A", "0X800484A", 0, 0, "", "", "", "");
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    Object localObject = a();
    boolean bool2;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      boolean bool1 = false;
      LebaViewItem localLebaViewItem;
      do
      {
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
      } while ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null));
      if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId != NowLiveManager.jdField_a_of_type_Int) {
        break label99;
      }
      bool1 = true;
    }
    label99:
    for (;;)
    {
      break;
      bool2 = false;
      ThreadManager.post(new LebaQzoneAndPluginPart.11(this, bool2, paramQQAppInterface), 5, null, false);
      return;
    }
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
    if ((localQQAppInterface == null) || (localQBaseActivity == null))
    {
      QLog.i("LebaBusinessPartImpl", 1, "updateQZoneRedFlag app == null || activity == null");
      return;
    }
    ThreadManager.post(new LebaQzoneAndPluginPart.8(this, localQQAppInterface, localQBaseActivity), 5, null, false);
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.excute(new LebaQzoneAndPluginPart.13(this, (NearbyCardManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER), paramQQAppInterface), 16, null, false);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.d();
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
    NearbyProcessMonitor.c(0);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1134010);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.b();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.f();
    }
  }
  
  public void j()
  {
    s();
    w();
    Object localObject = a();
    if (localObject == null) {
      QLog.i("LebaBusinessPartImpl", 1, "onLebaTabChangeQzone app == null");
    }
    do
    {
      return;
      localObject = (QZoneManager)((QQAppInterface)localObject).getManager(QQManagerFactory.QZONE_MANAGER);
      com.tencent.mobileqq.servlet.QZoneNotifyServlet.jdField_a_of_type_Boolean = true;
    } while (localObject == null);
    if (QLog.isColorLevel()) {
      QLog.d("LebaBusinessPartImpl", 2, "click leba.test if get qzone unread.");
    }
    ((QZoneManager)localObject).a(3);
  }
  
  public void k()
  {
    Object localObject = a();
    if (localObject == null) {
      QLog.i("LebaBusinessPartImpl", 1, "startWebProcess app == null");
    }
    do
    {
      return;
      localObject = (IWebProcessManagerService)((QQAppInterface)localObject).getRuntimeService(IWebProcessManagerService.class, "");
    } while ((localObject == null) || (!((IWebProcessManagerService)localObject).isNeedPreloadWebProcess()));
    ((IWebProcessManagerService)localObject).startWebProcess(202, null);
  }
  
  public void l()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      QLog.i("LebaBusinessPartImpl", 1, "removeObservers app == null");
      return;
    }
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyObserver);
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
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
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyObserver);
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    localQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler);
    localQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEnterUpdateObserver);
    localQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    localQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.e();
    }
  }
  
  public void o()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      QLog.i("LebaBusinessPartImpl", 1, "onAccountChanged app == null");
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.a(localQQAppInterface);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      t();
    }
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
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (localObject == null) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true)) {}
    do
    {
      return;
      localObject = (EcshopReportHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
      if (QLog.isColorLevel()) {
        QLog.e("AuthCode", 2, "time out jump!");
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a(this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    } while (localObject == null);
    ((EcshopReportHandler)localObject).a(134246777, null, "jump", "time_out", "no_code", 0L, false);
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
    if (localObject == null) {
      QLog.i("LebaBusinessPartImpl", 1, "preloadWebProcess app == null");
    }
    do
    {
      return;
      QLog.i("LebaBusinessPartImpl", 1, "preloadWebProcess");
      localObject = (IWebProcessManagerService)((QQAppInterface)localObject).getRuntimeService(IWebProcessManagerService.class, "");
    } while (localObject == null);
    if (((IWebProcessManagerService)localObject).isNeedPreloadWebProcess()) {
      ((IWebProcessManagerService)localObject).startWebProcess(202, null);
    }
    r();
  }
  
  public void t()
  {
    QQAppInterface localQQAppInterface = a();
    QBaseActivity localQBaseActivity = a();
    if ((localQQAppInterface == null) || (localQBaseActivity == null))
    {
      QLog.i("LebaBusinessPartImpl", 1, "onClickQzone app == null || activity == null");
      return;
    }
    cooperation.qzone.QZoneHelper.sQZoneHCCode = HardCoderManager.a().a(0, 1, 1, 0, 3000, 101, 4L, Process.myTid(), "bootQzone");
    LebaViewItem localLebaViewItem = (LebaViewItem)a().get("qzone_feedlist");
    QLog.d("LebaBusinessPartImpl", 1, "user clicked qzone feed entry.");
    ThreadManager.postImmediately(new LebaQzoneAndPluginPart.7(this, localLebaViewItem, localQQAppInterface, localQBaseActivity), null, true);
    p();
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).preLaunchMiniAppCheckinFromLeba();
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
      ((GameCenterManagerImp)localQQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER)).a().a(((RedTouchManager)localQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a("489"));
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
    List localList = a();
    LebaViewItem localLebaViewItem;
    if (localList != null)
    {
      int i = 0;
      if (i < localList.size())
      {
        localLebaViewItem = (LebaViewItem)localList.get(i);
        if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null)) {}
        while ((TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName)) || (!localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName.equals("m.tx.apphelper.android")))
        {
          i += 1;
          break;
        }
      }
    }
    for (long l = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId;; l = 0L)
    {
      ThreadManager.postImmediately(new LebaQzoneAndPluginPart.16(this, localQQAppInterface, l), null, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart
 * JD-Core Version:    0.7.0.1
 */