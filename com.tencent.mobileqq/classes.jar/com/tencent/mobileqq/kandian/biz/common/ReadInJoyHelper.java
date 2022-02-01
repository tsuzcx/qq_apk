package com.tencent.mobileqq.kandian.biz.common;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.video.LikeAnimationInfo;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.daily.ReadInJoyDailySettingModel;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.tab.KandianFrameStatus;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.ModifyInfo;
import tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.ReqBody;
import tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.UserSetting;

public class ReadInJoyHelper
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long = 0L;
  public static String a = "kandian_new_channel_style";
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  protected static boolean a = true;
  public static final String[] a;
  private static int jdField_b_of_type_Int = 0;
  private static long jdField_b_of_type_Long = 0L;
  public static String b = "_mode_videochannel_";
  private static Map<String, Boolean> jdField_b_of_type_JavaUtilMap;
  private static boolean jdField_b_of_type_Boolean = false;
  private static int jdField_c_of_type_Int;
  private static long jdField_c_of_type_Long = -1L;
  private static String jdField_c_of_type_JavaLangString;
  private static boolean jdField_c_of_type_Boolean;
  private static int jdField_d_of_type_Int;
  private static long jdField_d_of_type_Long = -1L;
  private static String jdField_d_of_type_JavaLangString;
  private static int jdField_e_of_type_Int;
  private static String jdField_e_of_type_JavaLangString;
  private static int f;
  private static int g;
  private static int h;
  private static int i;
  private static int j;
  private static int k;
  private static int l;
  private static int m;
  private static int n;
  private static int o;
  private static int p;
  private static int q;
  private static int r;
  private static int s;
  private static int t;
  private static int u = 0;
  private static int v = -1;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "collectbox", "homepage", "messagebox_V3", "messagebox_pendant_V3", "commentpage", "recommend_friends", "accountpage", "topicvideo", "mytopic", "myhistory", "myfollow", "myfans", "mynotify" };
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = -1;
    jdField_d_of_type_Int = -1;
    jdField_a_of_type_Long = -1L;
    jdField_e_of_type_Int = -1;
    jdField_c_of_type_JavaLangString = null;
    jdField_d_of_type_JavaLangString = null;
    f = -1;
    g = -1;
    h = -1;
    i = -1;
    j = -1;
    k = -1;
    l = -1;
    m = -1;
    n = -1;
    o = -1;
    p = -1;
    q = -1;
    r = -1;
    s = -1;
    t = -1;
    jdField_e_of_type_JavaLangString = "try_stick_flag";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_b_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    jdField_b_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    jdField_c_of_type_Boolean = false;
  }
  
  public static int A(AppRuntime paramAppRuntime)
  {
    int i1 = v;
    if (i1 > 0) {
      return i1;
    }
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigAdExposureThreshold() failed");
      return ReadInJoyConstants.jdField_c_of_type_Int;
    }
    v = paramAppRuntime.getInt("key_kandian_ad_exposure_threshold", ReadInJoyConstants.jdField_c_of_type_Int);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getKandianConfigAdExposureThreshold() threshold = ");
    paramAppRuntime.append(v);
    QLog.d("Q.readinjoy.tt_report", 1, paramAppRuntime.toString());
    return v;
  }
  
  public static void A(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "increaseUgcDeliverVideoTipsShowCount: sp is null");
      return;
    }
    SharedPreferences.Editor localEditor = paramAppRuntime.edit();
    paramInt = paramAppRuntime.getInt("ugc_deliver_video_tips_show_count", 0) + paramInt;
    localEditor.putInt("ugc_deliver_video_tips_show_count", paramInt);
    RIJSPUtils.a(localEditor, true);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("increaseUgcDeliverVideoTipsShowCount: success, newCount = ");
    paramAppRuntime.append(paramInt);
    QLog.d("ReadInJoyHelper", 2, paramAppRuntime.toString());
  }
  
  public static void A(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsAdConfigFromServer() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoFeedsAdConfigFromServer() value=");
    localStringBuilder.append(paramString);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("video_feeds_ad_config", paramString);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  private static void A(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateShowKandianTab show  ");
    localStringBuilder.append(paramBoolean);
    QLog.d("ReadInJoyHelper", 2, localStringBuilder.toString());
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateShowKandianTab() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("show_kandian_main_video_sp", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean A()
  {
    boolean bool = ((Boolean)RIJSPUtils.a(d(), Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isUGCAccountCreateComplete() result=");
      localStringBuilder.append(bool);
      QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    }
    return bool;
  }
  
  public static boolean A(AppRuntime paramAppRuntime)
  {
    Object localObject = Calendar.getInstance();
    int i1 = ((Calendar)localObject).get(1);
    int i2 = ((Calendar)localObject).get(2);
    int i3 = ((Calendar)localObject).get(5);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(i2);
    ((StringBuilder)localObject).append(i3);
    localObject = ((StringBuilder)localObject).toString();
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "checkIsVideoFeedsInterruptedAdLocalConfigToday() failed");
      return false;
    }
    String str = paramAppRuntime.getString("VIDEO_FEEDS_SHUNT_BAR_LOCAL_CONFIG_DATE", null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkIsVideoFeedsInterruptedAdLocalConfigToday localDate = ");
    localStringBuilder.append(str);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str))) {
      return true;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_SHUNT_BAR_LOCAL_CONFIG_DATE", (String)localObject);
    RIJSPUtils.a(paramAppRuntime, true);
    return false;
  }
  
  public static void B(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "is_show_weishi_entrance: sp is null");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("is_show_weishi_entrance", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("is_show_weishi_entrance = ");
      paramAppRuntime.append(paramInt);
      QLog.d("ReadInJoyHelper", 2, paramAppRuntime.toString());
    }
  }
  
  public static void B(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject = RIJSPUtils.a(paramAppRuntime, true, true);
    if (localObject == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateVideoFeedsAdConfigFromServer() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoFeedsAdConfigFromServer() value=");
    localStringBuilder.append(paramString);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    localObject = ((SharedPreferences)localObject).edit();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_my_tab_setting");
    localStringBuilder.append(paramAppRuntime.getAccount());
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString);
    RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
  }
  
  private static void B(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    Object localObject2 = RIJSPUtils.a(paramAppRuntime, true, true);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("updateShowKandianTab show  ");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.d("ReadInJoyHelper", 2, ((StringBuilder)localObject1).toString());
    if (localObject2 == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateShowKandianTab() failed");
      return;
    }
    localObject1 = ((SharedPreferences)localObject2).edit();
    ((SharedPreferences.Editor)localObject1).putBoolean("show_kandian_in_main_frame_sp", paramBoolean);
    int i1 = ((SharedPreferences)localObject2).getInt("kandian_tab_switch_config_received_cnt", 0);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("receiveKandiantTabConfig cnt : ");
    ((StringBuilder)localObject2).append(i1);
    QLog.d("ReadInJoyHelper", 2, ((StringBuilder)localObject2).toString());
    if (paramBoolean)
    {
      int i2 = i1 + 1;
      ((SharedPreferences.Editor)localObject1).putInt("kandian_tab_switch_config_received_cnt", i2);
      localObject2 = jdField_a_of_type_JavaUtilMap;
      paramAppRuntime = paramAppRuntime.getAccount();
      i1 = i2;
      if (i2 == 1) {
        i1 = 0;
      }
      ((Map)localObject2).put(paramAppRuntime, Integer.valueOf(i1));
    }
    else
    {
      ((SharedPreferences.Editor)localObject1).remove("kandian_tab_switch_config_received_cnt");
      if (i1 != 1) {
        jdField_a_of_type_JavaUtilMap.put(paramAppRuntime.getAccount(), Integer.valueOf(i1));
      }
    }
    RIJSPUtils.a((SharedPreferences.Editor)localObject1, true);
  }
  
  public static boolean B()
  {
    boolean bool = ((Boolean)RIJSPUtils.a(e(), Boolean.valueOf(true))).booleanValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFirstUGCAccountCreateGuide() result=");
      localStringBuilder.append(bool);
      QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    }
    return bool;
  }
  
  public static boolean B(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianMsgStickFlag() failed");
      return false;
    }
    return paramAppRuntime.getBoolean(jdField_e_of_type_JavaLangString, false);
  }
  
  public static void C(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigAdExposureThreshold() failed");
      return;
    }
    if (paramInt <= 0)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigAdExposureThreshold() threshold <= 0");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("key_kandian_ad_exposure_threshold", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
    v = paramInt;
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("updateKandianConfigAdExposureThreshold() threshold = ");
    paramAppRuntime.append(paramInt);
    QLog.d("Q.readinjoy.tt_report", 1, paramAppRuntime.toString());
  }
  
  public static void C(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsInterruptedAsConfigFromServer() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoFeedsInterruptedAsConfigFromServer() value=");
    localStringBuilder.append(paramString);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_INTERRUPTED_AD_CONFIG_NEW", paramString);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean C()
  {
    boolean bool = ((Boolean)RIJSPUtils.a("rij_comment_recommend_key", Boolean.valueOf(true))).booleanValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCommentRecommendStatus, flag=");
    localStringBuilder.append(bool);
    QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean C(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("kandianWebPreLoadData", false);
  }
  
  public static void D(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsInterruptedAdConfigLocal() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoFeedsInterruptedAdConfigLocal() value=");
    localStringBuilder.append(paramString);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_INTERRUPTED_AD_LOCAL_CONFIG_NEW", paramString);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean D(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("nw_preload", false);
  }
  
  public static void E(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsShuntBarConfigFromServer() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoFeedsShuntBarConfigFromServer() value=");
    localStringBuilder.append(paramString);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_SHUNT_BAR_CONFIG", paramString);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean E(AppRuntime paramAppRuntime)
  {
    return jdField_c_of_type_Boolean;
  }
  
  public static void F(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals("1"))
      {
        B(paramAppRuntime, true);
        A(paramAppRuntime, false);
        return;
      }
      if (paramString.equals("2"))
      {
        B(paramAppRuntime, true);
        A(paramAppRuntime, true);
        return;
      }
      A(paramAppRuntime, false);
      B(paramAppRuntime, false);
    }
  }
  
  public static boolean F(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "is_show_weishi_entrance: sp is null");
      return false;
    }
    int i1 = paramAppRuntime.getInt("is_show_weishi_entrance", 0);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("get_is_show_weishi_entrance : ");
    paramAppRuntime.append(i1);
    QLog.d("ReadInJoyHelper", 2, paramAppRuntime.toString());
    return i1 == 1;
  }
  
  public static void G(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("native_engine_timeout_config", paramString);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean G(AppRuntime paramAppRuntime)
  {
    Object localObject = Calendar.getInstance();
    int i1 = ((Calendar)localObject).get(1);
    int i2 = ((Calendar)localObject).get(2);
    int i3 = ((Calendar)localObject).get(5);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(i2);
    ((StringBuilder)localObject).append(i3);
    localObject = ((StringBuilder)localObject).toString();
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 1, "checkIsVideoFeedsGameAdComBarLocalConfigToday() failed");
      }
      return false;
    }
    String str = paramAppRuntime.getString("VIDEO_FEEDS_GAME_AD_COM_BAR_LOCAL_CONFIG_DATE", null);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkIsVideoFeedsGameAdComBarLocalConfigToday localDate = ");
      localStringBuilder.append(str);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str))) {
      return true;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_GAME_AD_COM_BAR_LOCAL_CONFIG_DATE", (String)localObject);
    RIJSPUtils.a(paramAppRuntime, true);
    return false;
  }
  
  public static void H(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateReadInJoyTabAutoRefreshTimeDuration() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      i1 = i1 * 60 * 1000;
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateReadInJoyTabAutoRefreshTimeDuration() duration < 0");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("ReadInJoy_Tab_Auto_Refresh_Time_Duration", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      jdField_c_of_type_Long = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label78:
      break label78;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateReadInJoyTabAutoRefreshTimeDuration() parseInt failed");
  }
  
  public static boolean H(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("READINJOY_VIOLA_RECOMMEND_REASON", false);
  }
  
  public static void I(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateReadInJoyMessageAutoRefreshTimeDuration() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      i1 = i1 * 60 * 1000;
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateReadInJoyMessageAutoRefreshTimeDuration() duration < 0");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("ReadInJoy_Message_Auto_Refresh_Time_Duration", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      jdField_d_of_type_Long = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label78:
      break label78;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateReadInJoyMessageAutoRefreshTimeDuration() parseInt failed");
  }
  
  public static void J(AppRuntime paramAppRuntime, String paramString)
  {
    int i1;
    try
    {
      i1 = Integer.valueOf(paramString).intValue();
    }
    catch (Exception paramString)
    {
      QLog.e("ReadInJoyHelper", 2, "updateReadInJoyWeiShiJumpTarget: ", paramString);
      i1 = 0;
    }
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateReadInJoyWeiShiJumpTarget: sp == null");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("SP_KEY_WEISHI_JUMP_TARGET", i1);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static float a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoDynamicRecommendDurationPercent() failed");
      return -1.0F;
    }
    float f1 = paramAppRuntime.getFloat("video_dynamic_recommend_duration_rate", -1.0F);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getVideoDynamicRecommendDurationPercent() result=");
    paramAppRuntime.append(f1);
    QLog.d("Q.readinjoy.tt_report", 1, paramAppRuntime.toString());
    return f1;
  }
  
  public static int a()
  {
    return a(Aladdin.getConfig(355).getIntegerFromString("max_word_count", 140));
  }
  
  public static int a(int paramInt)
  {
    int i1 = Aladdin.getConfig(355).getIntegerFromString("ugcprivilege_max_word_count", paramInt);
    if (RIJUserLevelModule.getInstance().getCacheUserLevel(4, false)) {
      return i1;
    }
    return paramInt;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {
      return -1;
    }
    if (paramQQAppInterface.jdField_a_of_type_Byte == 0) {
      return 1;
    }
    return 0;
  }
  
  public static int a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getVideoChannelFeedsClickSwitch failed to get sp");
      return 1;
    }
    return paramAppRuntime.getInt("key_video_channel_feeds_click_switch", 0);
  }
  
  public static int a(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getVideoChannelAutoPlaySwitchDefaultValue failed to get sp");
      return paramInt;
    }
    return paramAppRuntime.getInt("video_channel_auto_play_switch", paramInt);
  }
  
  public static long a()
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject == null) {
      return -1L;
    }
    localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
    if (localObject == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to  getVideoRealTimeLogDebug");
      return -1L;
    }
    return ((SharedPreferences)localObject).getLong("readinjoy_video_real_time_debug_log", -1L);
  }
  
  public static long a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder("last_req_article_time");
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return paramQQAppInterface.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return paramQQAppInterface.getLong("last_exit_kandian_time", 0L);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return 0L;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append("last_exit_channel_time");
    return paramQQAppInterface.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return paramQQAppInterface.getLong(a(paramActivity), 0L);
  }
  
  public static long a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return 10L;
    }
    return paramAppRuntime.getLong("msg_info_pulse_report_x", 10L);
  }
  
  @Deprecated
  public static SharedPreferences a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (paramInt == 2) {
      return null;
    }
    int i1;
    if ((paramInt == 0) && (Build.VERSION.SDK_INT >= 11)) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    paramQQAppInterface = String.format("readinjoy_%s_%d", new Object[] { paramQQAppInterface.getAccount(), Integer.valueOf(paramInt) });
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface, i1);
  }
  
  public static android.util.Pair<Integer, Integer> a()
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), true, true);
    Integer localInteger = Integer.valueOf(60);
    if (localSharedPreferences == null) {
      return new android.util.Pair(localInteger, localInteger);
    }
    return new android.util.Pair(Integer.valueOf(localSharedPreferences.getInt("kandian_aio_msg_received_duration", 60)), Integer.valueOf(localSharedPreferences.getInt("kandian_aio_msg_send_duration", 60)));
  }
  
  public static ReadInJoyHelper.VideoPackSetting a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoComponentConfig() failed");
      return null;
    }
    ReadInJoyHelper.VideoPackSetting localVideoPackSetting = new ReadInJoyHelper.VideoPackSetting();
    paramAppRuntime = paramAppRuntime.getString("sp_video_component_con", "");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 2, new Object[] { "getVideoComponentConfig()", paramAppRuntime });
    }
    if (TextUtils.isEmpty(paramAppRuntime)) {
      return null;
    }
    try
    {
      for (paramAppRuntime = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramAppRuntime.getBytes("utf-8"))).getElementsByTagName("configs").item(0).getFirstChild(); paramAppRuntime != null; paramAppRuntime = paramAppRuntime.getNextSibling()) {
        if ((paramAppRuntime.getFirstChild() != null) && (TextUtils.equals(paramAppRuntime.getNodeName(), "readinjoy_small_video_pack_ui_style"))) {
          for (Node localNode = paramAppRuntime.getFirstChild(); localNode != null; localNode = localNode.getNextSibling()) {
            if (localNode.getNodeType() == 1)
            {
              Object localObject1 = localNode.getNodeName();
              String str = localNode.getFirstChild().getNodeValue();
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("getVideoComponentConfig() result=");
              ((StringBuilder)localObject2).append(str);
              QLog.d("Q.readinjoy.tt_report", 1, ((StringBuilder)localObject2).toString());
              boolean bool = TextUtils.equals((CharSequence)localObject1, "multiple_video");
              if (bool) {
                for (localObject1 = localNode.getFirstChild(); localObject1 != null; localObject1 = ((Node)localObject1).getNextSibling()) {
                  if (((Node)localObject1).getNodeType() == 1)
                  {
                    str = ((Node)localObject1).getNodeName();
                    localObject2 = ((Node)localObject1).getFirstChild().getNodeValue();
                    if (TextUtils.equals("video_width", str)) {
                      localVideoPackSetting.jdField_b_of_type_Int = Integer.parseInt((String)localObject2);
                    } else if (TextUtils.equals("aspect_ratio", str)) {
                      localVideoPackSetting.jdField_b_of_type_Float = Float.parseFloat((String)localObject2);
                    }
                  }
                }
              }
              if (TextUtils.equals((CharSequence)localObject1, "double_video")) {
                for (localObject1 = localNode.getFirstChild(); localObject1 != null; localObject1 = ((Node)localObject1).getNextSibling()) {
                  if (((Node)localObject1).getNodeType() == 1)
                  {
                    str = ((Node)localObject1).getNodeName();
                    localObject2 = ((Node)localObject1).getFirstChild().getNodeValue();
                    if (TextUtils.equals("aspect_ratio", str)) {
                      localVideoPackSetting.jdField_a_of_type_Float = Float.parseFloat((String)localObject2);
                    }
                  }
                }
              }
              if (TextUtils.equals((CharSequence)localObject1, "is_play_button_show"))
              {
                localVideoPackSetting.jdField_a_of_type_Boolean = str.equals("1");
              }
              else if (TextUtils.equals((CharSequence)localObject1, "title_label_number_of_lines"))
              {
                localVideoPackSetting.jdField_a_of_type_Int = Integer.parseInt(str);
              }
              else
              {
                bool = TextUtils.equals((CharSequence)localObject1, "title_hidden");
                if (bool) {
                  localVideoPackSetting.jdField_b_of_type_Boolean = str.equals("0");
                } else if (TextUtils.equals((CharSequence)localObject1, "play_and_comment_hidden")) {
                  localVideoPackSetting.jdField_c_of_type_Boolean = str.equals("0");
                }
              }
            }
          }
        }
      }
      return localVideoPackSetting;
    }
    catch (Exception paramAppRuntime)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyHelper", 2, "getVideoComponentConfig exception occurs", paramAppRuntime);
      }
    }
    return null;
  }
  
  public static LikeAnimationInfo a()
  {
    Object localObject = RIJSPUtils.a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), false, true);
    if (localObject == null) {
      return null;
    }
    LikeAnimationInfo localLikeAnimationInfo = new LikeAnimationInfo();
    int i2 = ((SharedPreferences)localObject).getInt("key_like_icon_length", 0);
    if (i2 > 0)
    {
      String[] arrayOfString = new String[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_like_icon");
        localStringBuilder.append(i1);
        arrayOfString[i1] = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
        i1 += 1;
      }
      localLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString = arrayOfString;
    }
    localLikeAnimationInfo.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("key_like_icon_next_req_interval", 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadLikeAnimationInfo: ");
      ((StringBuilder)localObject).append(localLikeAnimationInfo.toString());
      QLog.d("ReadInJoyHelper", 2, ((StringBuilder)localObject).toString());
    }
    return localLikeAnimationInfo;
  }
  
  public static LebaViewItem a(QQAppInterface paramQQAppInterface)
  {
    ILebaHelperService localILebaHelperService = (ILebaHelperService)paramQQAppInterface.getRuntimeService(ILebaHelperService.class, "");
    if (localILebaHelperService == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getKandianLebaViewItem lebaHelperService == null");
      return null;
    }
    List localList = localILebaHelperService.getLebaMgrList();
    Object localObject;
    if (localList != null)
    {
      localObject = localList;
      if (!localList.isEmpty()) {}
    }
    else
    {
      localILebaHelperService.initLebaHelper();
      localILebaHelperService.reloadLebaItems(paramQQAppInterface);
      localObject = localILebaHelperService.getLebaMgrList();
    }
    if (localObject != null)
    {
      paramQQAppInterface = ((List)localObject).iterator();
      while (paramQQAppInterface.hasNext())
      {
        localObject = (LebaViewItem)paramQQAppInterface.next();
        if ((localObject != null) && (((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null) && (((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 1130L)) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public static com.tencent.util.Pair<Long, Integer> a()
  {
    long l1 = ((Integer)RIJSPUtils.a("weishi_recommend_delete_outdate_article_interval", Integer.valueOf(86400))).intValue();
    int i1 = ((Integer)RIJSPUtils.a("weishi_recommend_delete_outdate_article_feeds_counts", Integer.valueOf(10))).intValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWeishiRecommendDeleteOutdatedArticleParam, time: ");
      localStringBuilder.append(l1);
      localStringBuilder.append(", counts: ");
      localStringBuilder.append(i1);
      QLog.d("ReadInJoyHelper", 2, localStringBuilder.toString());
    }
    return new com.tencent.util.Pair(Long.valueOf(l1), Integer.valueOf(i1));
  }
  
  public static com.tencent.util.Pair<Long, Integer> a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return new com.tencent.util.Pair(Long.valueOf(86400L), Integer.valueOf(5));
    }
    return new com.tencent.util.Pair(Long.valueOf(paramAppRuntime.getLong("kandian_delete_outdate_article_interval", 86400L)), Integer.valueOf(paramAppRuntime.getInt("kandian_delete_outdate_article_feeds_cnt", 5)));
  }
  
  public static String a()
  {
    Object localObject = Aladdin.getConfig(112);
    String str = "";
    if (localObject != null) {
      str = ((AladdinConfig)localObject).getString("readinjoy_video_recommend_entrance_url", "");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getColumnDefaultJumpUrl, url=");
    ((StringBuilder)localObject).append(str);
    QLog.d("ReadInJoyHelper", 1, ((StringBuilder)localObject).toString());
    return str;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt < 10000) {
      return String.valueOf(paramInt);
    }
    return String.format("%d万", new Object[] { Integer.valueOf((paramInt + 5000) / 10000) });
  }
  
  public static String a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    if ((paramLong1 > 0L) && (paramLong1 < 10000L)) {
      return String.valueOf(paramLong1);
    }
    if ((paramLong1 >= 10000L) && (paramLong1 < paramLong2))
    {
      double d1 = paramLong1 * 100L;
      Double.isNaN(d1);
      d1 = new BigDecimal(d1 / 100.0D / 10000.0D).setScale(1, 4).doubleValue();
      double d2 = Math.round(d1);
      Double.isNaN(d2);
      if (d2 - d1 == 0.0D)
      {
        paramString1 = new StringBuilder();
        paramString1.append(String.valueOf(d1));
        paramString1.append(HardCodeUtil.a(2131712881));
        paramString1 = paramString1.toString();
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append(String.valueOf(d1));
        paramString1.append(HardCodeUtil.a(2131712688));
        paramString1 = paramString1.toString();
      }
      return paramString1;
    }
    if (paramLong1 >= paramLong2) {
      return paramString1;
    }
    return paramString2;
  }
  
  public static String a(Activity paramActivity)
  {
    int i1;
    if ((paramActivity instanceof ReadInJoyNewFeedsActivity)) {
      i1 = 1;
    } else if ((paramActivity instanceof SplashActivity)) {
      i1 = 2;
    } else if ((paramActivity instanceof ReadInJoyChannelActivity)) {
      i1 = 3;
    } else {
      i1 = 0;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("56_last_exit_channel_time");
    paramActivity.append(jdField_b_of_type_JavaLangString);
    paramActivity.append(i1);
    return paramActivity.toString();
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "checkLastScanTTDate() failed");
      return null;
    }
    return paramAppRuntime.getString("KANDIAN_LAST_SCAN_TT_DATE", "");
  }
  
  public static JSONArray a(List<String> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return localJSONArray;
      }
      int i2 = paramList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        localJSONArray.put(paramList.get(i1));
        i1 += 1;
      }
    }
    return localJSONArray;
  }
  
  public static void a()
  {
    String str = Aladdin.getConfig(440).getString("button_image_url", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateTopicButtonInXTab value=");
    localStringBuilder.append(str);
    QLog.e("ReadInJoyHelper", 1, localStringBuilder.toString());
    RIJSPUtils.a("x_tab_topic_button", str);
  }
  
  public static void a(int paramInt)
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject == null) {
      return;
    }
    localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("IdleExitAioRptCntForReport", paramInt);
      RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject == null) {
      return;
    }
    localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("kandian_aio_msg_received_duration", paramInt1);
      ((SharedPreferences.Editor)localObject).putInt("kandian_aio_msg_send_duration", paramInt2);
      RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update aio msg receive & send duration lastRecvMsgDuration : ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", lastSendMsgDuration : ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ReadInJoyHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(int paramInt, long paramLong, QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder("last_req_article_time");
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putLong(localStringBuilder.toString(), paramLong);
    RIJSPUtils.a(paramQQAppInterface, true);
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject == null) {
      return;
    }
    localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exposed_channel_bg_consumed_");
      localStringBuilder.append(paramInt);
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean);
      RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
    }
  }
  
  public static void a(long paramLong)
  {
    Object localObject = RIJSPUtils.a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), false, true);
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("key_like_icon_last_fetch_ts", paramLong);
    RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.edit().putLong("last_exit_kandian_time", paramLong).commit();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if ((a(paramActivity)) && (paramActivity.getPackageName().equalsIgnoreCase("com.tencent.qqreadinjoy")))
    {
      paramIntent.setClassName("com.tencent.qqreadinjoy", "com.tencent.qqreadinjoy.ReadInJoyStartActivity");
      paramActivity.startActivityForResult(paramIntent, -1);
    }
    a(null, paramActivity, paramIntent, paramInt, paramOnDismissListener);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface == null)
    {
      jdField_a_of_type_Boolean = true;
      return;
    }
    jdField_a_of_type_Boolean = paramQQAppInterface.getBoolean("readInJoy_subscribeAcc_gray_enable", true);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("ReadinjoyFolderMerge config ");
    paramQQAppInterface.append(jdField_a_of_type_Boolean);
    QLog.d("SPLASH_ConfigServlet", 1, paramQQAppInterface.toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    paramQQAppInterface = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
    localReportInfo.mSource = paramInt1;
    localReportInfo.mSourceArticleId = paramLong;
    localReportInfo.mOperation = paramInt2;
    localReportInfo.mOpSource = paramInt3;
    paramQQAppInterface.add(localReportInfo);
    ((IUserOperationModule)QRoute.api(IUserOperationModule.class)).request0x64eUserOperationReport(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putInt("readinjoy_video_channel_info_channel_id", paramInt1);
    paramQQAppInterface.putString("readinjoy_video_channel_info_channel_name", paramString);
    paramQQAppInterface.putInt("readinjoy_video_channel_info_channel_type", paramInt2);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append("last_exit_channel_time");
    paramQQAppInterface.putLong(localStringBuilder.toString(), paramLong).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, Activity paramActivity)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.edit().putLong(a(paramActivity), paramLong).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent)
  {
    a(paramQQAppInterface, paramActivity, paramIntent, -1, null);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramQQAppInterface = new Intent("notify_main_guide_clear");
    BaseApplication.getContext().sendBroadcast(paramQQAppInterface);
    RIJKanDianFolderStatus.updateMergeKandianFolderStatus(7);
    ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(paramActivity, null, -1L, 7);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i1;
    try
    {
      i1 = Integer.valueOf(paramString).intValue();
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateReadInJoyFeedsGroupSetting failed ");
      localStringBuilder.append(paramString.toString());
      QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
      i1 = 4;
    }
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putInt("config_feeds_group_setting", i1);
    RIJSPUtils.a(paramQQAppInterface, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    try
    {
      jdField_b_of_type_Boolean = paramBoolean;
      paramQQAppInterface = a(paramQQAppInterface, 1);
      if (paramQQAppInterface == null) {
        return;
      }
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putBoolean("stop_readinjoy_function", paramBoolean);
      RIJSPUtils.a(paramQQAppInterface, true);
      ((IRIJAppSetting)QRoute.api(IRIJAppSetting.class)).updateNewKandianDeleteFlag(paramBoolean);
      return;
    }
    finally {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    oidb_cmd0xb86.ReqBody localReqBody = new oidb_cmd0xb86.ReqBody();
    oidb_cmd0xb86.ModifyInfo localModifyInfo = new oidb_cmd0xb86.ModifyInfo();
    oidb_cmd0xb86.UserSetting localUserSetting = new oidb_cmd0xb86.UserSetting();
    localUserSetting.uint32_disable_comment_recommed.set(paramBoolean ^ true);
    localModifyInfo.msg_setting.set(localUserSetting);
    localReqBody.msg_modify_info.set(localModifyInfo);
    ProtoUtils.a(paramQQAppInterface, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0xb86", 2950, 50);
  }
  
  public static void a(LikeAnimationInfo paramLikeAnimationInfo)
  {
    if ((paramLikeAnimationInfo != null) && (paramLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString != null))
    {
      if (paramLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString.length == 0) {
        return;
      }
      Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
      int i1 = 0;
      localObject = RIJSPUtils.a((AppRuntime)localObject, false, true);
      if (localObject == null) {
        return;
      }
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("key_like_icon_length", paramLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString.length);
      while (i1 < paramLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_like_icon");
        localStringBuilder.append(i1);
        ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString[i1]);
        i1 += 1;
      }
      ((SharedPreferences.Editor)localObject).putInt("key_like_icon_next_req_interval", paramLikeAnimationInfo.jdField_a_of_type_Int);
      RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveLikeAnimationInfo: ");
        ((StringBuilder)localObject).append(paramLikeAnimationInfo.toString());
        QLog.d("ReadInJoyHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static void a(VideoPlayManager paramVideoPlayManager, ViolaEvent paramViolaEvent)
  {
    if (paramVideoPlayManager == null) {
      return;
    }
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleVideoEvent,event=");
      ((StringBuilder)localObject).append(paramViolaEvent.eventName);
      ((StringBuilder)localObject).append(" ,data=");
      ((StringBuilder)localObject).append(paramViolaEvent.data);
      QLog.d("ReadInJoyHelper", 1, ((StringBuilder)localObject).toString());
      if (!"PtsVideoPlay".equalsIgnoreCase(paramViolaEvent.eventName)) {
        return;
      }
      localObject = paramVideoPlayManager.a();
      if (localObject == null)
      {
        QLog.d("ReadInJoyHelper", 1, "videoPlayParam is null!");
        return;
      }
      localObject = ((VideoPlayParam)localObject).a;
      if ((localObject != null) && (!TextUtils.isEmpty(((AbsBaseArticleInfo)localObject).innerUniqueID)))
      {
        String str = paramViolaEvent.data.optString("rowkey");
        boolean bool1 = paramViolaEvent.data.optBoolean("video_status");
        boolean bool2 = paramVideoPlayManager.a();
        paramViolaEvent = new StringBuilder();
        paramViolaEvent.append("articleInfo.innerUniqueID=");
        paramViolaEvent.append(((AbsBaseArticleInfo)localObject).innerUniqueID);
        paramViolaEvent.append(" ,currentIsPlaying=");
        paramViolaEvent.append(bool2);
        QLog.d("ReadInJoyHelper", 1, paramViolaEvent.toString());
        if ((!((AbsBaseArticleInfo)localObject).innerUniqueID.equalsIgnoreCase(str)) && (bool1) && (bool2)) {
          paramVideoPlayManager.a();
        }
      }
      else
      {
        QLog.d("ReadInJoyHelper", 1, "articleInfo is null or rowkey is empty!");
        return;
      }
    }
    catch (Exception paramVideoPlayManager)
    {
      paramViolaEvent = new StringBuilder();
      paramViolaEvent.append("parseVideoEvent,msg=");
      paramViolaEvent.append(paramVideoPlayManager);
      QLog.d("ReadInJoyHelper", 1, paramViolaEvent.toString());
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!(paramAbsBaseArticleInfo instanceof BaseArticleInfo)) {
      return;
    }
    if ((!DailyModeConfigHandler.c((int)paramAbsBaseArticleInfo.mChannelID)) && (!RIJShowKanDianTabSp.a(paramAbsBaseArticleInfo.mChannelID))) {
      return;
    }
    if (!ReadInJoyDailySettingModel.a()) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyHelper.5(paramAbsBaseArticleInfo));
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      RIJSPUtils.a("weishi_recommend_delete_outdate_article_interval", Long.valueOf(Long.parseLong(paramString)));
      return;
    }
    catch (Exception localException)
    {
      label21:
      StringBuilder localStringBuilder;
      break label21;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse weishi outdate time error, value from server: ");
      localStringBuilder.append(paramString);
      QLog.d("ReadInJoyHelper", 2, localStringBuilder.toString());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyHelper", 2, "updateWeishiRecommendDeleteOutArticleInterval: time is null");
      }
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject == null) {
      return;
    }
    localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exposed_channel_bg_url_");
      localStringBuilder.append(paramInt);
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString);
      RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = paramString.equals("1");
    paramString = a(paramQQAppInterface, 1);
    if (paramString == null) {
      return;
    }
    paramString = paramString.edit();
    paramString.putBoolean("share_to_news", bool);
    RIJSPUtils.a(paramString, true);
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "ReadInJoyHelper";
    }
    QLog.w(str, 1, paramThrowable.getMessage(), paramThrowable);
  }
  
  public static void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramBoolean)) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("rowkey", paramString1);
        localJSONObject.put("video_status", true);
        SimpleEventBus.getInstance().dispatchEvent(new ViolaEvent(paramString2, localJSONObject));
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("sendEventBus error, msg=");
        localStringBuilder2.append(localException);
        QLog.d("ReadInJoyHelper", 1, localStringBuilder2.toString());
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("sendEventBus,rowkey=");
    localStringBuilder1.append(paramString1);
    localStringBuilder1.append(" ,actionName=");
    localStringBuilder1.append(paramString2);
    localStringBuilder1.append(" isPlaying=");
    localStringBuilder1.append(paramBoolean);
    QLog.d("ReadInJoyHelper", 1, localStringBuilder1.toString());
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null)
    {
      ReadInJoyBaseAdapter.jdField_e_of_type_Int = 1000;
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("app null update feeds group setting:");
      paramAppRuntime.append(ReadInJoyBaseAdapter.jdField_e_of_type_Int);
      QLog.d("ReadInJoyHelper", 1, paramAppRuntime.toString());
      return;
    }
    int i1;
    if (Build.VERSION.SDK_INT >= 11) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    paramAppRuntime = String.format("readinjoy_%s_%d", new Object[] { paramAppRuntime.getAccount(), Integer.valueOf(1) });
    paramAppRuntime = BaseApplicationImpl.getApplication().getSharedPreferences(paramAppRuntime, i1);
    if (paramAppRuntime == null)
    {
      ReadInJoyBaseAdapter.jdField_e_of_type_Int = 1000;
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("sp null update feeds group setting:");
      paramAppRuntime.append(ReadInJoyBaseAdapter.jdField_e_of_type_Int);
      QLog.d("ReadInJoyHelper", 1, paramAppRuntime.toString());
      return;
    }
    ReadInJoyBaseAdapter.jdField_e_of_type_Int = paramAppRuntime.getInt("config_feeds_group_setting", 1000);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("update feeds group setting:");
    paramAppRuntime.append(ReadInJoyBaseAdapter.jdField_e_of_type_Int);
    QLog.d("ReadInJoyHelper", 1, paramAppRuntime.toString());
  }
  
  public static void a(AppRuntime paramAppRuntime, float paramFloat)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoDynamicRecommendDurationPercent() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoDynamicRecommendDurationPercent() num=");
    localStringBuilder.append(paramFloat);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putFloat("video_dynamic_recommend_duration_rate", paramFloat);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateVideoChannelFeedsClickSwitchValue failed to update sp");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("key_video_channel_feeds_click_switch", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, long paramLong)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianDeleteOutDateArticleInterval failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putLong("kandian_delete_outdate_article_interval", paramLong);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime != null)
    {
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putLong("msg_info_pulse_report_x", paramLong1);
      paramAppRuntime.putLong("msg_info_pulse_report_y", paramLong2);
      paramAppRuntime.putLong("msg_info_pulse_report_z", paramLong3);
      RIJSPUtils.a(paramAppRuntime, true);
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("update msg info pulse param x : ");
      paramAppRuntime.append(paramLong1);
      paramAppRuntime.append(", y : ");
      paramAppRuntime.append(paramLong2);
      paramAppRuntime.append(", z : ");
      paramAppRuntime.append(paramLong3);
      QLog.d("ReadInJoyHelper", 2, paramAppRuntime.toString());
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(paramAppRuntime, true, true);
    if (localSharedPreferences == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateArkChannelConfig");
      return;
    }
    paramAppRuntime = paramString;
    if (paramString == null) {
      paramAppRuntime = "";
    }
    paramString = localSharedPreferences.edit();
    paramString.putString("readinjoy_ark_channel_config", paramAppRuntime);
    RIJSPUtils.a(paramString, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowVideoToast");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_social_weburl_");
    localStringBuilder.append(paramString1);
    paramAppRuntime.putString(localStringBuilder.toString(), paramString2);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp IndividualPushSwitch");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_individual_push_switch", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  private static void a(AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    try
    {
      String str = String.valueOf(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement());
      boolean bool = false;
      if (paramJSONObject != null)
      {
        paramJSONObject.put("session_id", jdField_b_of_type_Long);
        paramJSONObject.put("seq", str);
        paramJSONObject.put("codeVersion", "201809071320");
        bool = true;
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("addExtraInfoInJson:  session_id:");
      paramJSONObject.append(jdField_b_of_type_Long);
      paramJSONObject.append("  seq:");
      paramJSONObject.append(str);
      paramJSONObject.append("  codeVersion:");
      paramJSONObject.append("201809071320");
      paramJSONObject.append(" hasAdd:");
      paramJSONObject.append(bool);
      QLog.d("ReadInJoyHelper", 1, paramJSONObject.toString());
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject == null) {
      return;
    }
    localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("kd_icon_merge_biu_msg", paramBoolean);
      RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
    }
  }
  
  public static boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    boolean bool = false;
    localObject = RIJSPUtils.a((AppRuntime)localObject, false, true);
    if (localObject == null) {
      return true;
    }
    long l1 = System.currentTimeMillis();
    long l2 = ((SharedPreferences)localObject).getLong("key_like_icon_last_fetch_ts", 0L);
    if (l1 - l2 > paramInt * 1000) {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedFetchLikeAnimation, cts: ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", lts: ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(", isNeedFetch: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ReadInJoyHelper", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static boolean a(Activity paramActivity, String paramString, int paramInt)
  {
    return ((paramActivity instanceof FastWebActivity)) || ((d(paramString)) && (paramInt == 9));
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localRunningAppProcessInfo.processName != null) && (localRunningAppProcessInfo.processName.endsWith(":readinjoy"))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return false;
    }
    return (RIJAppSetting.f()) && (paramQQAppInterface.getBoolean("kandian_feeds", true));
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleContentUrl))) {
      return d(paramAbsBaseArticleInfo.mArticleContentUrl);
    }
    return false;
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong)
  {
    long l1 = ((Long)RIJSPUtils.a("kandian_comment_limit_number", Long.valueOf(1L))).longValue();
    boolean bool;
    if ((paramAbsBaseArticleInfo != null) && (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) && (paramLong >= 0L) && (paramLong >= l1)) {
      bool = true;
    } else {
      bool = false;
    }
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("shouldShowComment,limitNumber:");
    paramAbsBaseArticleInfo.append(l1);
    paramAbsBaseArticleInfo.append(" ,number:");
    paramAbsBaseArticleInfo.append(paramLong);
    QLog.d("ReadInJoyHelper", 1, paramAbsBaseArticleInfo.toString());
    return bool;
  }
  
  public static boolean a(KandianFrameStatus paramKandianFrameStatus, boolean paramBoolean)
  {
    boolean bool1;
    if (paramKandianFrameStatus.a() != paramBoolean) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = ((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).isXTabMode();
    if (paramKandianFrameStatus.b() != bool2) {
      bool1 = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("needUpdateKandianFrame,currentIsShow=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" isCurrentXTabMode=");
    localStringBuilder.append(bool2);
    localStringBuilder.append(" flag=");
    localStringBuilder.append(bool1);
    localStringBuilder.append("\t KandianFrameStatus=");
    localStringBuilder.append(paramKandianFrameStatus);
    QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int i2 = arrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (TextUtils.equals(arrayOfString[i1], paramString)) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rij_time_interval");
    localStringBuilder.append(paramString);
    return l1 - ((Long)RIJSPUtils.a(localStringBuilder.toString(), Long.valueOf(0L))).longValue() >= paramInt * 24 * 60 * 60 * 1000;
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (StudyModeManager.a()) {
      return false;
    }
    return ((Boolean)RIJSPUtils.a(paramString, Boolean.valueOf(paramBoolean), true)).booleanValue();
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("READINJOY_VIDEO_CHANNEL_AUTO_PLAY_NEXT_VIDEO_HINT", true);
    if (bool)
    {
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putBoolean("READINJOY_VIDEO_CHANNEL_AUTO_PLAY_NEXT_VIDEO_HINT", false);
      RIJSPUtils.a(paramAppRuntime, true);
    }
    return bool;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      a(paramAppRuntime, paramString);
      paramString = ((JSONObject)localObject).optString("app");
      localObject = ((JSONObject)localObject).optString("ver", null);
      HashMap localHashMap = new HashMap();
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        localHashMap.put("action", "configOff");
      }
      else
      {
        localHashMap.put("action", "configOn");
        localHashMap.put("appname", paramString);
        localHashMap.put("appver", localObject);
      }
      StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actionReadInJoyArkConfig", true, 0L, 0L, localHashMap, null);
      return true;
    }
    catch (Exception paramAppRuntime)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyHelper", 2, "parse json error ", paramAppRuntime);
      }
    }
    return false;
  }
  
  public static int b()
  {
    return Aladdin.getConfig(355).getIntegerFromString("insert_link_limit", 0);
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_video_channel_info_config_version");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), -1);
  }
  
  public static int b(AppRuntime paramAppRuntime)
  {
    return a(paramAppRuntime, 1);
  }
  
  public static int b(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getVideoChannelAutoPlaySwitchDefaultValueVideoFlow failed to get sp");
      return paramInt;
    }
    return paramAppRuntime.getInt("video_channel_auto_play_switch_video_flow", paramInt);
  }
  
  public static long b()
  {
    long l1 = ((Long)RIJSPUtils.a("readinjoy_video_ff_probesize", Long.valueOf(0L))).longValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFFProbesize,probesize:");
      localStringBuilder.append(l1);
      QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    }
    return l1;
  }
  
  public static long b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return 10L;
    }
    return paramAppRuntime.getLong("msg_info_pulse_report_y", 10L);
  }
  
  public static android.util.Pair<Integer, Integer> b()
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), true, true);
    if (localSharedPreferences == null) {
      return null;
    }
    return new android.util.Pair(Integer.valueOf(localSharedPreferences.getInt("ExitAioIdleReportUinLimitS", -1)), Integer.valueOf(localSharedPreferences.getInt("ExitAioIdleReportUinLimitE", -1)));
  }
  
  public static com.tencent.util.Pair<Long, Integer> b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return new com.tencent.util.Pair(Long.valueOf(86400L), Integer.valueOf(5));
    }
    return new com.tencent.util.Pair(Long.valueOf(paramAppRuntime.getLong("weishi_delete_outdate_article_interval", 86400L)), Integer.valueOf(paramAppRuntime.getInt("weishi_delete_outdate_article_feeds_cnt", 5)));
  }
  
  public static String b()
  {
    String str = (String)RIJSPUtils.a("readinjoy_viola_page_open_data", "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getViolaPageOpenData result=");
      localStringBuilder.append(str);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    return str;
  }
  
  public static String b(int paramInt)
  {
    if (paramInt < 10000) {
      return String.valueOf(paramInt);
    }
    if (paramInt < 99989500)
    {
      StringBuilder localStringBuilder;
      if (paramInt % 10000 < 500)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt / 10000);
        localStringBuilder.append(HardCodeUtil.a(2131712813));
        return localStringBuilder.toString();
      }
      int i1 = paramInt;
      if (paramInt % 500 == 0) {
        i1 = paramInt + 1;
      }
      if (i1 % 10000 > 9500)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((i1 + 500) / 10000);
        localStringBuilder.append(HardCodeUtil.a(2131712961));
        return localStringBuilder.toString();
      }
      return String.format("%.1f万", new Object[] { Float.valueOf(i1 / 10000.0F) });
    }
    return "9999万";
  }
  
  public static String b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsInterruptedAdfigFromServer() failed");
      return null;
    }
    paramAppRuntime = paramAppRuntime.getString("VIDEO_FEEDS_INTERRUPTED_AD_CONFIG_NEW", null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getVideoFeedsInterruptedAdfigFromServer() result=");
    localStringBuilder.append(paramAppRuntime);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    return paramAppRuntime;
  }
  
  public static void b()
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    int i1 = 0;
    localObject = RIJSPUtils.a((AppRuntime)localObject, false, true);
    if (localObject == null) {
      return;
    }
    int i2 = ((SharedPreferences)localObject).getInt("key_like_icon_length", 0);
    if (i2 > 0)
    {
      localObject = ((SharedPreferences)localObject).edit();
      while (i1 < i2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_like_icon");
        localStringBuilder.append(i1);
        ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString());
        i1 += 1;
      }
      ((SharedPreferences.Editor)localObject).remove("key_like_icon_next_req_interval");
      RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
    }
  }
  
  public static void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateCommentLimitNumber,number:");
    localStringBuilder.append(paramInt);
    QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    if (paramInt < 0) {
      return;
    }
    RIJSPUtils.a("kandian_comment_limit_number", Long.valueOf(paramInt));
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject == null) {
      return;
    }
    localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("ExitAioIdleReportUinLimitS", paramInt1);
      ((SharedPreferences.Editor)localObject).putInt("ExitAioIdleReportUinLimitE", paramInt2);
      RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
    }
  }
  
  public static void b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_daily_child_refresh_channelID");
    localStringBuilder.append(paramLong);
    RIJSPUtils.a(localStringBuilder.toString(), Boolean.valueOf(true));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateDailyChildRefreshCmd cba channelID=");
    localStringBuilder.append(paramLong);
    QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putBoolean("show_interest_label", false);
    RIJSPUtils.a(paramQQAppInterface, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i1;
    try
    {
      i1 = Integer.valueOf(paramString).intValue();
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateReadInJoyPushMsgSwitch failed: ");
      localStringBuilder.append(paramString.toString());
      QLog.w("ReadInJoyHelper", 1, localStringBuilder.toString());
      i1 = 1;
    }
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putInt("readinjoy_config_push_msg_switch", i1);
    RIJSPUtils.a(paramQQAppInterface, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putBoolean("hot_shortvideo_multi_video_support", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      RIJSPUtils.a("weishi_recommend_delete_outdate_article_feeds_counts", Integer.valueOf(Integer.parseInt(paramString)));
      return;
    }
    catch (Exception localException)
    {
      label21:
      StringBuilder localStringBuilder;
      break label21;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse weishi outdate article feeds counts error, value from server: ");
      localStringBuilder.append(paramString);
      QLog.d("ReadInJoyHelper", 2, localStringBuilder.toString());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyHelper", 2, "updateWeishiRecommendDeleteOutArticleFeedsCounts: counts is null");
      }
    }
  }
  
  public static void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = paramString.equals("1");
    paramString = a(paramQQAppInterface, 1);
    if (paramString == null) {
      return;
    }
    paramString = paramString.edit();
    paramString.putBoolean("synchronize_to_qzone", bool);
    RIJSPUtils.a(paramString, true);
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    String str = paramAppRuntime.getString("readinjoy_social_weburl_messagebox_V3", "");
    if (!TextUtils.isEmpty(str)) {
      ReadInJoyConstants.jdField_d_of_type_JavaLangString = str;
    }
    str = paramAppRuntime.getString("readinjoy_social_weburl_collectbox", "");
    if (!TextUtils.isEmpty(str)) {
      ReadInJoyConstants.p = str;
    }
    str = paramAppRuntime.getString("readinjoy_social_weburl_messagebox_pendant_V3", "");
    if (!TextUtils.isEmpty(str)) {
      ReadInJoyConstants.h = str;
    }
    str = paramAppRuntime.getString("readinjoy_social_weburl_commentpage", "");
    if (!TextUtils.isEmpty(str)) {
      ReadInJoyConstants.jdField_e_of_type_JavaLangString = str;
    }
    str = paramAppRuntime.getString("readinjoy_social_weburl_recommend_friends", "");
    if (!TextUtils.isEmpty(str)) {
      ReadInJoyConstants.f = str;
    }
    ReadInJoyConstants.k = ReadInJoyConstants.g;
    str = paramAppRuntime.getString("readinjoy_social_weburl_mytopic", "");
    if (!TextUtils.isEmpty(str)) {
      ReadInJoyConstants.o = str;
    }
    str = paramAppRuntime.getString("readinjoy_social_weburl_myhistory", "");
    if (!TextUtils.isEmpty(str)) {
      ReadInJoyConstants.n = str;
    }
    str = paramAppRuntime.getString("readinjoy_social_weburl_myfollow", "");
    if (!TextUtils.isEmpty(str)) {
      ReadInJoyConstants.r = str;
    }
    str = paramAppRuntime.getString("readinjoy_social_weburl_myfans", "");
    if (!TextUtils.isEmpty(str)) {
      ReadInJoyConstants.s = str;
    }
    paramAppRuntime = paramAppRuntime.getString("readinjoy_social_weburl_mynotify", "");
    if (!TextUtils.isEmpty(paramAppRuntime)) {
      ReadInJoyConstants.q = paramAppRuntime;
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateVideoChannelAutoPlaySwitchDefaultValue failed to update sp");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_channel_auto_play_switch", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void b(AppRuntime paramAppRuntime, long paramLong)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateWeishiDeleteOutdateArticleInterval failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putLong("weishi_delete_outdate_article_interval", paramLong);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime != null)
    {
      if (paramString == null) {
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putBoolean("readinjoy_ark_app_show_setting", paramString.equals("1"));
      RIJSPUtils.a(paramAppRuntime, true);
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowVideoToast");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_self_fragment_feedback_");
    localStringBuilder.append(paramString1);
    paramAppRuntime.putString(localStringBuilder.toString(), paramString2);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void b(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowRecommendReasonInTitle");
      return;
    }
    SharedPreferences.Editor localEditor = paramAppRuntime.edit();
    if (paramBoolean) {
      paramAppRuntime = "1";
    } else {
      paramAppRuntime = "0";
    }
    localEditor.putString("readinjoy_show_recommend_reason_in_title_b", paramAppRuntime);
    RIJSPUtils.a(localEditor, true);
  }
  
  public static void b(boolean paramBoolean)
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject == null) {
      return;
    }
    localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("kd_icon_merge_interactive_msg", paramBoolean);
      RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
    }
  }
  
  public static boolean b()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(260);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("interact_button_style", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b(int paramInt)
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject == null) {
      return false;
    }
    localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exposed_channel_bg_consumed_");
      localStringBuilder.append(paramInt);
      return ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false);
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("video_structmsg_play_switch", true);
  }
  
  public static boolean b(String paramString)
  {
    return true;
  }
  
  public static boolean b(AppRuntime paramAppRuntime)
  {
    return true;
  }
  
  public static boolean b(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject = Calendar.getInstance();
    int i1 = ((Calendar)localObject).get(1);
    int i2 = ((Calendar)localObject).get(2);
    int i3 = ((Calendar)localObject).get(5);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(i2);
    ((StringBuilder)localObject).append(i3);
    localObject = ((StringBuilder)localObject).toString();
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "checkIsVideoFeedsAdLocalConfigToday() failed");
      return false;
    }
    String str = paramAppRuntime.getString(paramString, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkIsVideoFeedsAdLocalConfigToday localDate = ");
    localStringBuilder.append(str);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str))) {
      return true;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString(paramString, (String)localObject);
    RIJSPUtils.a(paramAppRuntime, true);
    return false;
  }
  
  public static int c()
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), true, true);
    if (localSharedPreferences == null) {
      return 0;
    }
    return localSharedPreferences.getInt("IdleExitAioRptCntForReport", 0);
  }
  
  public static int c(AppRuntime paramAppRuntime)
  {
    return b(paramAppRuntime, 0);
  }
  
  public static long c(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return 10L;
    }
    return paramAppRuntime.getLong("msg_info_pulse_report_z", 10L);
  }
  
  public static String c()
  {
    return "0xcba";
  }
  
  public static String c(int paramInt)
  {
    if (paramInt <= 99) {
      return String.valueOf(paramInt);
    }
    return "99+";
  }
  
  public static String c(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsInterruptedAdConfigLocal() failed");
      return null;
    }
    paramAppRuntime = paramAppRuntime.getString("VIDEO_FEEDS_INTERRUPTED_AD_LOCAL_CONFIG_NEW", null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getVideoFeedsInterruptedAdConfigLocal() result=");
    localStringBuilder.append(paramAppRuntime);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    return paramAppRuntime;
  }
  
  public static void c()
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject == null) {
      return;
    }
    localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
    if (localObject == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to  updateVideoRealTimeLogDebug");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("readinjoy_video_real_time_debug_log", System.currentTimeMillis());
    RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTitleNumberLines, lineNumber:");
      localStringBuilder.append(paramInt);
      QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    }
    if (paramInt < 0) {
      return;
    }
    RIJSPUtils.a("twoitem_title_label_number_of_lines", Integer.valueOf(paramInt));
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    jdField_b_of_type_Boolean = false;
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("ReadinjooyStopFunctionSwitch config:");
    paramQQAppInterface.append(jdField_b_of_type_Boolean);
    QLog.d("SPLASH_ConfigServlet", 1, paramQQAppInterface.toString());
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putBoolean("config_smart_crop_pic_setting", "1".equals(paramString));
    RIJSPUtils.a(paramQQAppInterface, true);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = RIJSPUtils.a(paramQQAppInterface, true, true);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putBoolean("config_readinjoy_interested_push_switch", paramBoolean);
    RIJSPUtils.a(paramQQAppInterface, true);
  }
  
  public static void c(String paramString)
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putStringSet("kd_icon_merge_subscription_white_list", new HashSet(Arrays.asList(paramString.split("\\|"))));
        RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
      }
    }
  }
  
  public static void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = "1".equals(paramString);
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramString == null) {
      return;
    }
    paramString = paramString.edit();
    paramString.putBoolean("readInJoy_subscribeAcc_gray_enable", bool);
    RIJSPUtils.a(paramString, true);
  }
  
  public static void c(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    String str = paramAppRuntime.getString("readinjoy_self_fragment_feedback_feedsbackName", "");
    if (!TextUtils.isEmpty(str)) {
      ReadInJoyConstants.l = str;
    }
    str = paramAppRuntime.getString("readinjoy_self_fragment_feedback_feedsbackSwitch", "");
    if ((!TextUtils.isEmpty(str)) && (TextUtils.equals(str, "1"))) {
      ReadInJoyConstants.jdField_a_of_type_Boolean = true;
    }
    paramAppRuntime = paramAppRuntime.getString("readinjoy_self_fragment_feedback_feedsbackWebUrl", "");
    if (!TextUtils.isEmpty(paramAppRuntime)) {
      ReadInJoyConstants.m = paramAppRuntime;
    }
  }
  
  public static void c(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateVideoChannelAutoPlaySwitchDefaultValueVideoFlow failed to update sp");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_channel_auto_play_switch_video_flow", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void c(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "setLastScanTTDate() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("KANDIAN_LAST_SCAN_TT_DATE", paramString);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void c(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp READINJOY_SIMPLE_SWITCH_FM");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("READINJOY_SIMPLE_SWITCH_FM", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void c(boolean paramBoolean)
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject == null) {
      return;
    }
    localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("proteus_enable", paramBoolean);
      RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
    }
  }
  
  public static boolean c()
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime(), true, true);
    if (localSharedPreferences == null)
    {
      QLog.e("ReadInJoyHelper", 1, "failed to get sp isTopicButtonInXTab");
      return false;
    }
    String str = Aladdin.getConfig(440).getString("button_image_url", "");
    return localSharedPreferences.getString("x_tab_topic_button", "").equals(str);
  }
  
  public static boolean c(int paramInt)
  {
    if (paramInt == 125) {
      return true;
    }
    return Aladdin.getConfig(339).getIntegerFromString("videodetail_enter_column_type", 0) == 1;
  }
  
  public static boolean c(String paramString)
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
      if (localObject != null) {
        return ((SharedPreferences)localObject).getStringSet("kd_icon_merge_subscription_white_list", new HashSet()).contains(paramString);
      }
    }
    return false;
  }
  
  public static boolean c(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to get sp IndividualPushSwitch");
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_individual_push_switch", false);
  }
  
  public static boolean c(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime != null)
    {
      if (paramString == null) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyHelper", 2, new Object[] { "updateKandianMyTabPage, value = ", paramString });
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putString("kandian_my_tab_page", paramString);
      RIJSPUtils.a(paramAppRuntime, true);
      return true;
    }
    return false;
  }
  
  public static int d()
  {
    int i1 = ((Integer)RIJSPUtils.a("twoitem_title_label_number_of_lines", Integer.valueOf(2))).intValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTitleNumberLines,limitNumber:");
      localStringBuilder.append(i1);
      QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    }
    return i1;
  }
  
  public static int d(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getReadInJoyVideoJumpDefaultValue failed to get sp");
      return 0;
    }
    return paramAppRuntime.getInt("readinjoy_video_jump_default_value", 0);
  }
  
  public static long d(AppRuntime paramAppRuntime)
  {
    long l1 = jdField_c_of_type_Long;
    if (l1 != -1L) {
      return l1;
    }
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getReadInJoyTabAutoRefreshTimeDuration() failed");
      return 900000L;
    }
    jdField_c_of_type_Long = paramAppRuntime.getInt("ReadInJoy_Tab_Auto_Refresh_Time_Duration", -1);
    l1 = jdField_c_of_type_Long;
    if (l1 != -1L) {
      return l1;
    }
    return 900000L;
  }
  
  private static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append("readinjoy_ugc_account_create_complete");
    return localStringBuilder.toString();
  }
  
  public static String d(int paramInt)
  {
    int i1 = paramInt % 60;
    int i2 = paramInt / 60 % 60;
    paramInt /= 3600;
    if (paramInt > 0) {
      return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i2), Integer.valueOf(i1) });
    }
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) });
  }
  
  public static void d()
  {
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = -1;
    jdField_d_of_type_Int = -1;
    jdField_a_of_type_Long = -1L;
    jdField_e_of_type_Int = -1;
    f = -1;
    g = -1;
    h = -1;
    j = -1;
    i = -1;
    t = -1;
    s = -1;
    n = -1;
    v = -1;
  }
  
  public static void d(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateIsPlayCommentButtonShow, shouldShow:");
      localStringBuilder.append(paramInt);
      QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("is_play_comment_button_show", Integer.valueOf(paramInt));
  }
  
  public static void d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putBoolean("video_structmsg_play_switch", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      int i1 = Integer.parseInt(paramString);
      bool = true;
      if (i1 != 1) {
        break label92;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        continue;
        boolean bool = false;
      }
    }
    RIJSPUtils.a("key_weishi_with_channel_and_discovery", Boolean.valueOf(bool));
    return;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse weishi config error, value from server: ");
      localStringBuilder.append(paramString);
      QLog.d("ReadInJoyHelper", 2, localStringBuilder.toString());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyHelper", 2, "value in null");
      }
    }
  }
  
  public static void d(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = paramString.equals("1");
    paramString = a(paramQQAppInterface, 1);
    if (paramString == null) {
      return;
    }
    paramString = paramString.edit();
    paramString.putBoolean("merge_feeds", bool);
    RIJSPUtils.a(paramString, true);
  }
  
  public static void d(AppRuntime paramAppRuntime)
  {
    jdField_c_of_type_Boolean = true;
  }
  
  public static void d(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateReadInJoyVideoJumpDefaultValue failed to update sp");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("readinjoy_video_jump_default_value", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void d(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuFeedsName() failed");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuFeedsName() name is null");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("kandian_biu_feeds_name", paramString);
    RIJSPUtils.a(paramAppRuntime, true);
    jdField_c_of_type_JavaLangString = paramString;
  }
  
  public static void d(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp subscribe list push config ");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_subscribe_list_push", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void d(boolean paramBoolean)
  {
    if ((paramBoolean) && (!((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).isNowInKanDianTab()))
    {
      u += 1;
    }
    else
    {
      int i1 = u;
      if (i1 > 0) {
        u = i1 - 1;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("inFeeds: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" inFeeds ");
      localStringBuilder.append(u);
      QLog.d("ReadInJoyHelper", 2, localStringBuilder.toString());
    }
  }
  
  public static boolean d()
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime(), true, true);
    if (localSharedPreferences == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to get sp IndividualPushSwitch");
      return false;
    }
    return localSharedPreferences.getInt("video_channel_feeds_type", 1) == 2;
  }
  
  public static boolean d(int paramInt)
  {
    return (paramInt == 124) || (paramInt == 125);
  }
  
  public static boolean d(String paramString)
  {
    try
    {
      localObject = new URL(paramString);
      paramString = ((URL)localObject).getPath();
      localObject = ((URL)localObject).getHost();
      if ("article/wx".equalsIgnoreCase(paramString.replaceFirst("/", "")))
      {
        boolean bool = "kandian.qq.com".equalsIgnoreCase((String)localObject);
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isWxArticle error!  msg=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ReadInJoyHelper", 1, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public static boolean d(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return "1".equals(paramAppRuntime.getString("readinjoy_show_recommend_reason_in_title_b", ""));
  }
  
  public static int e()
  {
    int i1 = ((Integer)RIJSPUtils.a("readinjoy_video_recommend_entrance_direct", Integer.valueOf(3))).intValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getVideoRecommendEntranceDirect result=");
    localStringBuilder.append(i1);
    QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    return i1;
  }
  
  public static int e(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return 0;
    }
    return paramAppRuntime.getInt("readinjoy_video_videoinfo_anim_viewtop", 0);
  }
  
  public static long e(AppRuntime paramAppRuntime)
  {
    long l1 = jdField_d_of_type_Long;
    if (l1 != -1L) {
      return l1;
    }
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getReadInJoyMessageAutoRefreshTimeDuration() failed");
      return 600000L;
    }
    jdField_d_of_type_Long = paramAppRuntime.getInt("ReadInJoy_Message_Auto_Refresh_Time_Duration", -1);
    l1 = jdField_d_of_type_Long;
    if (l1 != -1L) {
      return l1;
    }
    return 600000L;
  }
  
  private static String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append("readinjoy_first_ugc_account_create");
    return localStringBuilder.toString();
  }
  
  public static String e(int paramInt)
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject == null) {
      return null;
    }
    localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exposed_channel_bg_url_");
      localStringBuilder.append(paramInt);
      return ((SharedPreferences)localObject).getString(localStringBuilder.toString(), null);
    }
    return null;
  }
  
  public static void e()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void e(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateViolaPageOpenData value=");
      localStringBuilder.append(paramString);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("readinjoy_viola_page_open_data", paramString);
  }
  
  public static void e(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = paramString.equals("1");
    paramString = a(paramQQAppInterface, 1);
    if (paramString == null) {
      return;
    }
    paramString = paramString.edit();
    paramString.putBoolean("kandian_feeds", bool);
    RIJSPUtils.a(paramString, true);
  }
  
  private static void e(AppRuntime paramAppRuntime)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyHelper.3(paramAppRuntime));
  }
  
  public static void e(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateCUKingCardDlgSwitch failed to update sp");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("CUKingCard_dlg_enable_switch", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void e(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuFeedsWebUrl() failed");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuFeedsWebUrl() url is null");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("kandian_biu_feeds_web_url", paramString);
    RIJSPUtils.a(paramAppRuntime, true);
    jdField_d_of_type_JavaLangString = paramString;
  }
  
  public static void e(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowVideoToast");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_show_video_toast", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updataCachedViolaPageOpenData value=");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("readinjoy_viola_page_open_count", Boolean.valueOf(paramBoolean));
  }
  
  public static boolean e()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(355);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("link_switch", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean e(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to get sp subscribe list push config ");
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_subscribe_list_push", false);
  }
  
  public static int f(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsAdConfigLocal() failed");
      return 60;
    }
    int i1 = paramAppRuntime.getInt("camera_capture_max_duration", 60);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getCameraCaptureMaxDuration() result=");
    paramAppRuntime.append(i1);
    QLog.d("Q.readinjoy.video", 1, paramAppRuntime.toString());
    return i1;
  }
  
  public static void f()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateShowRedPacketShareGuideTime: currentTime=");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("ReadInJoyHelper", 2, localStringBuilder.toString());
    }
    RIJSPUtils.a("READINJOY_RED_PACKET_SHARE_GUIDE", Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    RIJSPUtils.a("readinjoy_daily_refresh_cmd", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateDailyRefreshCmd use0xcba=");
    localStringBuilder.append(paramString);
    QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
  }
  
  public static void f(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateInnerVideoInfoShowSwitcher");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("readinjoy_video_videoinfo_anim_viewtop", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void f(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuWordCount() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 <= 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuWordCount() count <= 0");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kandian_biu_word_count", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      f = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label68:
      break label68;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuWordCount() parseInt failed");
  }
  
  public static void f(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowVideoPreplayToast");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_show_video_preplay_toast", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean f()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(436);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("comment_topic_switch", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean f(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_show_video_toast", false);
  }
  
  public static int g(AppRuntime paramAppRuntime)
  {
    int i1 = f;
    if (i1 > 0) {
      return i1;
    }
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigBiuWordCount() failed");
      return 100;
    }
    f = paramAppRuntime.getInt("kandian_biu_word_count", 100);
    return f;
  }
  
  public static void g()
  {
    Object localObject1 = Calendar.getInstance();
    int i1 = ((Calendar)localObject1).get(1);
    int i2 = ((Calendar)localObject1).get(2);
    int i3 = ((Calendar)localObject1).get(5);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(i1);
    ((StringBuilder)localObject1).append(i2);
    ((StringBuilder)localObject1).append(i3);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = RIJSPUtils.a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), true, true);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 1, "saveFirstNoDifferenceJumpAppToday() failed");
      }
      return;
    }
    String str = ((SharedPreferences)localObject2).getString("readinjoy_first_no_difference_jump_app", null);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveFirstNoDifferenceJumpAppToday localDate = ");
      localStringBuilder.append(str);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    localObject2 = ((SharedPreferences)localObject2).edit();
    ((SharedPreferences.Editor)localObject2).putString("readinjoy_first_no_difference_jump_app", (String)localObject1);
    RIJSPUtils.a((SharedPreferences.Editor)localObject2, true);
  }
  
  public static void g(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rij_time_interval");
    localStringBuilder.append(paramString);
    RIJSPUtils.a(localStringBuilder.toString(), Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void g(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateCameraCaptureMaxDuration() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateCameraCaptureMaxDuration() value=");
    localStringBuilder.append(paramInt);
    QLog.d("Q.readinjoy.video", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    int i1 = paramInt;
    if (paramInt > 60) {
      i1 = 60;
    }
    paramAppRuntime.putInt("camera_capture_max_duration", i1);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void g(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentWordCount() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 <= 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentWordCount() count <= 0");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kandian_comment_word_count", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      g = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label68:
      break label68;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentWordCount() parseInt failed");
  }
  
  public static void g(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateVideoPreOutputFirstFrameSwitch");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_video_preoutput_first_frame_switch", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean g()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(450);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("comment_at_switch", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean g(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_show_video_preplay_toast", false);
  }
  
  public static int h(AppRuntime paramAppRuntime)
  {
    int i1 = h;
    if ((i1 != 0) && (i1 != 1))
    {
      paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigCommentGifSwitch() failed");
        return 0;
      }
      h = paramAppRuntime.getInt("kandian_comment_gif_switch", 0);
      return h;
    }
    return h;
  }
  
  public static void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 1, "updateUGCAccountCreateComplete value = true");
    }
    RIJSPUtils.a(d(), Boolean.valueOf(true));
  }
  
  public static void h(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigRedShowNum() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_tabdot_show_num", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
    jdField_b_of_type_Int = paramInt;
  }
  
  public static void h(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentGifSwitch() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentGifSwitch() gifSwitch < 0");
        return;
      }
      if (i1 > 1)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentGifSwitch() gifSwitch > 1");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kandian_comment_gif_switch", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      h = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label83:
      break label83;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentGifSwitch() parseInt failed");
  }
  
  public static void h(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateVideoPreDownloadSwitcher");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_video_predownload_switch", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean h()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(387);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("android_comment_module_switch", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean h(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_video_preoutput_first_frame_switch", true);
  }
  
  public static int i(AppRuntime paramAppRuntime)
  {
    int i1 = j;
    if ((i1 != 0) && (i1 != 1))
    {
      paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigCommentZhituSwitch() failed");
        return 0;
      }
      j = paramAppRuntime.getInt("kandian_comment_zhitu_switch", 0);
      return j;
    }
    return j;
  }
  
  public static void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 1, "updateFirstUGCAccountCreateGuide value = true");
    }
    RIJSPUtils.a(e(), Boolean.valueOf(false));
  }
  
  public static void i(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigRedThreshold() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_tabdot_threshold", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
    jdField_c_of_type_Int = paramInt;
  }
  
  public static void i(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUGCGifSwitch() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUGCGifSwitch() gifSwitch < 0");
        return;
      }
      if (i1 > 1)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUGCGifSwitch() gifSwitch > 1");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kandian_ugc_gif_switch", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      i = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label83:
      break label83;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUGCGifSwitch() parseInt failed");
  }
  
  public static void i(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateInnerVideoInfoShowSwitcher");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_video_videoinfo_switch", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean i()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(387);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("android_force_switch_on5", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean i(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_video_predownload_switch", true);
  }
  
  public static int j(AppRuntime paramAppRuntime)
  {
    int i1 = l;
    if ((i1 != 0) && (i1 != 1))
    {
      paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigUgcAtSwitch() failed");
        return 0;
      }
      l = paramAppRuntime.getInt("kandian_ugc_at_switch", 0);
      return l;
    }
    return l;
  }
  
  public static void j(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuFeedsSwitch() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_biu_feeds_switch", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
    jdField_e_of_type_Int = paramInt;
  }
  
  public static void j(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentZhituSwitch() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentZhituSwitch() zhituSwitch < 0");
        return;
      }
      if (i1 > 1)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentZhituSwitch() zhituSwitch > 1");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kandian_comment_zhitu_switch", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      j = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label83:
      break label83;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentZhituSwitch() zhituSwitch failed");
  }
  
  public static void j(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateViolaDebugSwitcher");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_viola_debug_switch", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean j()
  {
    boolean bool;
    if (Aladdin.getConfig(394).getIntegerFromString("clear_db_articles", 1) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("studyModeClearDbArticles, flag=");
    localStringBuilder.append(bool);
    QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean j(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_video_videoinfo_switch", false);
  }
  
  public static int k(AppRuntime paramAppRuntime)
  {
    int i1 = m;
    if ((i1 != 0) && (i1 != 1))
    {
      paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigBiuAtSwitch() failed");
        return 0;
      }
      m = paramAppRuntime.getInt("kandian_biu_at_switch", 0);
      return m;
    }
    return m;
  }
  
  public static void k(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianNewChannelStyle() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt(jdField_a_of_type_JavaLangString, paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void k(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKDRedPntPushArticlePreloadSwitch() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKDRedPntPushArticlePreloadSwitch() preloadSwitch < 0");
        return;
      }
      if (i1 > 1)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKDRedPntPushArticlePreloadSwitch() preloadSwitch > 1");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kandian_preload_red_pnt_push_article_switch", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      k = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label83:
      break label83;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateKDRedPntPushArticlePreloadSwitch() preloadSwitch failed");
  }
  
  public static void k(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateViolaDebugSwitcher");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("READINJOY_VIOLA_JS_DEBUG_BUNDLE", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean k()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:806)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean k(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_viola_debug_switch", true);
  }
  
  public static int l(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getDianDianConfigRightButtonAtSwitch() failed");
      return 0;
    }
    return paramAppRuntime.getInt("diandian_right_button_at_switch_new", 0);
  }
  
  public static void l(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoChannelCoverStyle() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_channel_cover_style", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void l(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUgcAtSwitch() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUgcAtSwitch() atSwitch < 0");
        return;
      }
      if (i1 > 1)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUgcAtSwitch() atSwitch > 1");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kandian_ugc_at_switch", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      l = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label83:
      break label83;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUgcAtSwitch() parseInt failed");
  }
  
  public static void l(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateViolaDebugSwitcher");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("READINJOY_VIOLA_JS_LOCAL_BUNDLE", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean l()
  {
    return k();
  }
  
  public static boolean l(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("READINJOY_VIOLA_JS_DEBUG_BUNDLE", false);
  }
  
  public static int m(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKanDianRightButtonAtSwitch() failed");
      return 0;
    }
    return paramAppRuntime.getInt("kandian_right_button_at_switch_new", 0);
  }
  
  public static void m(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoDynamicRecommmendStrategy() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoDynamicRecommmendStrategy() num=");
    localStringBuilder.append(paramInt);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_dynamic_recommend_strategyid", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void m(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuAtSwitch() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuAtSwitch() atSwitch < 0");
        return;
      }
      if (i1 > 1)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuAtSwitch() atSwitch > 1");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kandian_biu_at_switch", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      m = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label83:
      break label83;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuAtSwitch() parseInt failed");
  }
  
  public static void m(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateVideoMessageBoxSwitcher");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_viola_message_box_switch", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean m()
  {
    return (RIJShowKanDianTabSp.c()) && (!l());
  }
  
  public static boolean m(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("READINJOY_VIOLA_JS_LOCAL_BUNDLE", false);
  }
  
  public static int n(AppRuntime paramAppRuntime)
  {
    int i1 = o;
    if ((i1 != 0) && (i1 != 1))
    {
      paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "getReadInjoyShareToWxAtSwitch() failed");
        return 0;
      }
      o = paramAppRuntime.getInt("readinjoy_share_to_WX_at_switch", 0);
      return o;
    }
    return o;
  }
  
  public static void n(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoDynamicRecommmendDurationLimit() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoDynamicRecommmendDurationLimit() num=");
    localStringBuilder.append(paramInt);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_dynamic_recommend_duration_limit", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void n(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuProfileAtSwitch() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuProfileAtSwitch() atSwitch < 0");
        return;
      }
      if (i1 > 1)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuProfileAtSwitch() atSwitch > 1");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kandian_biu_profile_at_switch", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      n = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label83:
      break label83;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuProfileAtSwitch() parseInt failed");
  }
  
  public static void n(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateVideoColumnEntrySwitcher");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_viola_column_entry_switch", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean n()
  {
    boolean bool2 = false;
    Boolean localBoolean = (Boolean)RIJSPUtils.a("sp_key_create_topic_switch", Boolean.valueOf(false));
    boolean bool1 = bool2;
    if (localBoolean != null)
    {
      bool1 = bool2;
      if (localBoolean.booleanValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean n(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_viola_message_box_switch", false);
  }
  
  public static int o(AppRuntime paramAppRuntime)
  {
    int i1 = p;
    if ((i1 != 0) && (i1 != 1))
    {
      paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigCommentBiuSwitch() failed");
        return 0;
      }
      p = paramAppRuntime.getInt("kandian_comment_biu_switch", 0);
      return p;
    }
    return p;
  }
  
  public static void o(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoDynamicRecommendOperator() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoDynamicRecommendOperator() num=");
    localStringBuilder.append(paramInt);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_dynamic_recommend_operator", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void o(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateDianDianConfigRightButtonAtSwitch() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateDianDianConfigRightButtonAtSwitch() atSwitch < 0");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("diandian_right_button_at_switch_new", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label64:
      break label64;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateDianDianConfigRightButtonAtSwitch()parseInt failed");
  }
  
  public static void o(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateVideoColumnEntrySwitcher");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_video_enable_reprint_switch", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean o()
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject == null) {
      return false;
    }
    localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
    if (localObject != null) {
      return ((SharedPreferences)localObject).getBoolean("kd_icon_merge_biu_msg", false);
    }
    return false;
  }
  
  public static boolean o(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_viola_column_entry_switch", false);
  }
  
  public static int p(AppRuntime paramAppRuntime)
  {
    int i1 = s;
    if (i1 > 0) {
      return i1;
    }
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigDefaultBitRate() failed");
      return ReadInJoyConstants.jdField_a_of_type_Int;
    }
    s = paramAppRuntime.getInt("kandian_default_bit_rate", ReadInJoyConstants.jdField_a_of_type_Int);
    return s;
  }
  
  public static void p(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateWebRenderConfig() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateWebRenderConfig() value=");
    localStringBuilder.append(paramInt);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    boolean bool;
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramAppRuntime.putBoolean("web_native_render", bool);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void p(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKanDianConfigRightButtonAtSwitch() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKanDianConfigRightButtonAtSwitch() atSwitch < 0");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kandian_right_button_at_switch_new", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label64:
      break label64;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateKanDianConfigRightButtonAtSwitch()parseInt failed");
  }
  
  public static void p(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateViolaDebugSwitcher");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("qboss_splash_debug_switch", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean p()
  {
    Object localObject = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject == null) {
      return false;
    }
    localObject = RIJSPUtils.a((AppRuntime)localObject, true, true);
    if (localObject != null) {
      return ((SharedPreferences)localObject).getBoolean("kd_icon_merge_interactive_msg", false);
    }
    return false;
  }
  
  public static boolean p(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_video_enable_reprint_switch", false);
  }
  
  public static int q(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoChannelCoverStyle() failed");
      return -1;
    }
    return paramAppRuntime.getInt("video_channel_cover_style", 0);
  }
  
  public static void q(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateWebRenderModeConfig() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateWebRenderModeConfig() value=");
    localStringBuilder.append(paramInt);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    boolean bool;
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramAppRuntime.putBoolean("web_native_render_mode_start", bool);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void q(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateReadinjoyQAsquareAutoTimeval() failed");
      return;
    }
    try
    {
      float f1 = Float.valueOf(paramString).floatValue();
      if (f1 < 0.0F)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateReadinjoyQAsquareAutoTimeval() atSwitch < 0");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putFloat("readinjoy_QA_square_autoTimeval", f1);
      RIJSPUtils.a(paramAppRuntime, true);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label69:
      break label69;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateReadinjoyQAsquareAutoTimeval()parseFloat failed");
  }
  
  public static void q(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "failed to update sp KandianVideoSocialSwitch");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("kandian_video_social_switch", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("updateKandianVideoSocialSwitch():");
      paramAppRuntime.append(paramBoolean);
      QLog.d("Q.readinjoy.video", 2, paramAppRuntime.toString());
    }
  }
  
  public static boolean q()
  {
    long l1 = ((Long)RIJSPUtils.a("READINJOY_RED_PACKET_SHARE_GUIDE", Long.valueOf(0L))).longValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needShowRedPacketShareGuide: lastTime=");
      localStringBuilder.append(l1);
      QLog.d("ReadInJoyHelper", 2, localStringBuilder.toString());
    }
    return System.currentTimeMillis() - l1 > TimeUnit.DAYS.toMillis(1L);
  }
  
  public static boolean q(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("qboss_splash_debug_switch", true);
  }
  
  public static int r(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getGallerySubChannelHidden() failed");
      return -1;
    }
    return paramAppRuntime.getInt("gallery_sub_channel_hidden", 0);
  }
  
  public static void r(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateViolaDynamicConfig() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateViolaDynamicConfig() value=");
    localStringBuilder.append(paramInt);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    boolean bool;
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramAppRuntime.putBoolean("VIOLA_DYNAMIC", bool);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void r(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "update readinjoy to wx switch failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateReadInjoyToWxAtSwitch() atSwitch < 0");
        return;
      }
      if (i1 > 1)
      {
        QLog.d("Q.readinjoy.tt_report", 1, " updateReadInjoyToWxAtSwitch() atSwitch > 1");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("readinjoy_share_to_WX_at_switch", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      o = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label83:
      break label83;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateDianDianConfigRightButtonAtSwitch()parseInt failed");
  }
  
  public static void r(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean r()
  {
    return (u > 0) || (((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).isNowInKanDianTab());
  }
  
  public static boolean r(AppRuntime paramAppRuntime)
  {
    int i1 = jdField_a_of_type_Int;
    if (i1 == -1)
    {
      ThreadManager.post(new ReadInJoyHelper.1(paramAppRuntime), 8, null, true);
      return true;
    }
    return i1 == 1;
  }
  
  public static int s(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getGallerySubChannelWaterFallHidden() failed");
      return -1;
    }
    return paramAppRuntime.getInt("gallery_sub_channel_waterfall_hidden", 0);
  }
  
  public static void s(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateViolaWeishiAdConfig failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateViolaWeishiAdConfig value=");
    localStringBuilder.append(paramInt);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    boolean bool;
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramAppRuntime.putBoolean("VIOLA_DYNAMIC_WEISHI", bool);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void s(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentBiuSwitch() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentBiuSwitch() atSwitch < 0");
        return;
      }
      if (i1 > 1)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentBiuSwitch() atSwitch > 1");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kandian_comment_biu_switch", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      p = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label83:
      break label83;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentBiuSwitch() parseInt failed");
  }
  
  public static void s(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "setKanDianReportTTSwitch() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("KANDIAN_REPORT_TT_SWITCH", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean s()
  {
    int i1 = ((Integer)RIJSPUtils.a("is_play_comment_button_show", Integer.valueOf(1))).intValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPlayCommentButtonShow,shouldShow:");
      localStringBuilder.append(i1);
      QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    }
    return i1 == 1;
  }
  
  public static boolean s(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKanDianReportTTSwitch() failed");
      return false;
    }
    return paramAppRuntime.getBoolean("KANDIAN_REPORT_TT_SWITCH", false);
  }
  
  public static int t(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoDynamicRecommendStrategy() failed");
      return -1;
    }
    int i1 = paramAppRuntime.getInt("video_dynamic_recommend_strategyid", -1);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getVideoDynamicRecommendStrategy() result=");
    paramAppRuntime.append(i1);
    QLog.d("Q.readinjoy.tt_report", 1, paramAppRuntime.toString());
    return i1;
  }
  
  public static void t(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateViolaDiscoverConfig failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateViolaDiscoverConfig value=");
    localStringBuilder.append(paramInt);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    boolean bool;
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramAppRuntime.putBoolean("VIOLA_DYNAMIC_DISCOVER", bool);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void t(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigNativeCommentBiuSwitch() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigNativeCommentBiuSwitch() atSwitch < 0");
        return;
      }
      if (i1 > 1)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigNativeCommentBiuSwitch() atSwitch > 1");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kandian_native_comment_biu_switch", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      q = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label83:
      break label83;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigNativeCommentBiuSwitch() parseInt failed");
  }
  
  public static void t(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsPrePlaySwitch() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoFeedsPrePlaySwitch() value=");
    localStringBuilder.append(paramBoolean);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("VIDEO_FEEDS_PREPLAY_SWITCH", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean t()
  {
    boolean bool = false;
    int i1 = ((Integer)RIJSPUtils.a("readinjoy_video_is_ff_probelist_switch", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFFProbelistSwitch,isFFProbelistSwitch:");
      localStringBuilder.append(i1);
      QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    }
    if (i1 == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean t(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getWebRenderConfig() failed");
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("web_native_render", false);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getWebRenderConfig() result=");
    paramAppRuntime.append(bool);
    QLog.d("Q.readinjoy.tt_report", 1, paramAppRuntime.toString());
    return bool;
  }
  
  public static int u(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoDynamicRecommendDurationLimit() failed");
      return -1;
    }
    int i1 = paramAppRuntime.getInt("video_dynamic_recommend_duration_limit", -1);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getVideoDynamicRecommendDurationLimit() result=");
    paramAppRuntime.append(i1);
    QLog.d("Q.readinjoy.tt_report", 1, paramAppRuntime.toString());
    return i1;
  }
  
  public static void u(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateViolaMessageBoxConfig failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateViolaMessageBoxConfig value=");
    localStringBuilder.append(paramInt);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    boolean bool;
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramAppRuntime.putBoolean("VIOLA_DYNAMIC_MESSAGE_BOX", bool);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void u(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentAtSwitch() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentAtSwitch() atSwitch < 0");
        return;
      }
      if (i1 > 1)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentAtSwitch() atSwitch > 1");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kandian_comment_at_switch", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      r = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label83:
      break label83;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentAtSwitch() parseInt failed");
  }
  
  public static void u(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianMsgStickFlag() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean(jdField_e_of_type_JavaLangString, paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean u()
  {
    boolean bool = false;
    int i1 = ((Integer)RIJSPUtils.a("readinjoy_video_is_download_async_io", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDownloadAsyncIo,isDownloadAsyncIo:");
      localStringBuilder.append(i1);
      QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    }
    if (i1 == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean u(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getCanLoadStartWebRenderModeConfig() failed");
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("web_native_render_mode_start", false);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getCanLoadStartWebRenderModeConfig() result=");
    paramAppRuntime.append(bool);
    QLog.d("Q.readinjoy.tt_report", 1, paramAppRuntime.toString());
    return bool;
  }
  
  public static int v(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoDynamicRecommendOperator() failed");
      return -1;
    }
    int i1 = paramAppRuntime.getInt("video_dynamic_recommend_operator", 0);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getVideoDynamicRecommendOperator() result=");
    paramAppRuntime.append(i1);
    QLog.d("Q.readinjoy.tt_report", 1, paramAppRuntime.toString());
    return i1;
  }
  
  public static void v(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsSoftAdConfigLocal() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoFeedsSoftAdConfigLocal() value=");
    localStringBuilder.append(paramInt);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("VIDEO_FEEDS_SOFT_AD_LOCAL_CONFIG", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void v(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigDefaultBitRate() failed");
      return;
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 <= 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigDefaultBitRate() bitrate <= 0");
        return;
      }
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("kandian_default_bit_rate", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      s = i1;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label68:
      break label68;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigDefaultBitRate() parseInt failed");
  }
  
  public static void v(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateVideoTabFakeReddotErasureByUser() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("videotab_fake_reddot_erasure_by_user", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean v()
  {
    return e() == 6;
  }
  
  public static boolean v(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getViolaDynamicConfig() failed");
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("VIOLA_DYNAMIC", false);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getViolaDynamicConfig() result=");
    paramAppRuntime.append(bool);
    QLog.d("Q.readinjoy.tt_report", 1, paramAppRuntime.toString());
    return bool;
  }
  
  public static int w(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsSoftAdConfigLocal() failed");
      return 0;
    }
    int i1 = paramAppRuntime.getInt("VIDEO_FEEDS_SOFT_AD_LOCAL_CONFIG", 0);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getVideoFeedsSoftAdConfigLocal() result=");
    paramAppRuntime.append(i1);
    QLog.d("Q.readinjoy.tt_report", 1, paramAppRuntime.toString());
    return i1;
  }
  
  public static void w(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBadgeSwitch() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_badge_switch", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
    t = paramInt;
  }
  
  public static void w(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateGallerySubChannelHidden() value");
      localStringBuilder.append(paramString);
      QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("gallery_sub_channel_hidden", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label82:
      break label82;
    }
    QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelHidden() Exception");
    return;
    QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelHidden() failed");
  }
  
  public static void w(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateWebCgiPreloadSwitch() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("kandianWebPreLoadData", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean w()
  {
    Object localObject1 = Calendar.getInstance();
    int i1 = ((Calendar)localObject1).get(1);
    int i2 = ((Calendar)localObject1).get(2);
    int i3 = ((Calendar)localObject1).get(5);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(i1);
    ((StringBuilder)localObject1).append(i2);
    ((StringBuilder)localObject1).append(i3);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = RIJSPUtils.a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), true, true);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 1, "checkIsFirstNoDifferenceJumpAppToday() failed");
      }
      return false;
    }
    localObject2 = ((SharedPreferences)localObject2).getString("readinjoy_first_no_difference_jump_app", null);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkIsVideoFeedsGameAdComBarLocalConfigToday localDate = ");
      localStringBuilder.append((String)localObject2);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      return !((String)localObject1).equals(localObject2);
    }
    return true;
  }
  
  public static boolean w(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getViolaWeishiAdConfig failed");
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("VIOLA_DYNAMIC_WEISHI", false);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getViolaWeishiAdConfig result=");
    paramAppRuntime.append(bool);
    QLog.d("Q.readinjoy.tt_report", 1, paramAppRuntime.toString());
    return bool;
  }
  
  public static int x(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigBadgeSwitch() failed");
      return -1;
    }
    int i1 = t;
    if (i1 != -1) {
      return i1;
    }
    t = paramAppRuntime.getInt("kandian_badge_switch", 0);
    return t;
  }
  
  public static void x(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianDeleteOutDateArticleInterval failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_delete_outdate_article_feeds_cnt", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void x(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateGallerySubChannelWaterFallHidden() value");
      localStringBuilder.append(paramString);
      QLog.d("ReadInJoyHelper", 1, localStringBuilder.toString());
    }
    try
    {
      int i1 = Integer.parseInt(paramString);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("gallery_sub_channel_waterfall_hidden", i1);
      RIJSPUtils.a(paramAppRuntime, true);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      label82:
      break label82;
    }
    QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelWaterFallHidden() Exception");
    return;
    QLog.d("ReadInJoyHelper", 1, "updateGallerySubChannelWaterFallHidden() failed");
  }
  
  public static void x(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("nw_preload", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean x()
  {
    boolean bool2 = false;
    Boolean localBoolean = Boolean.valueOf(false);
    boolean bool1 = bool2;
    if (((Boolean)RIJSPUtils.a("sp_key_channel_list_dynamic_order_switch", localBoolean)).booleanValue())
    {
      bool1 = bool2;
      if (((Boolean)RIJSPUtils.a("sp_key_readinjoy_click_channel_view", localBoolean)).booleanValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean x(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getViolaMessageBoxConfig failed");
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("VIOLA_DYNAMIC_MESSAGE_BOX", true);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getViolaMessageBoxConfig result=");
    paramAppRuntime.append(bool);
    QLog.d("Q.readinjoy.tt_report", 1, paramAppRuntime.toString());
    return bool;
  }
  
  public static int y(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 1, "VideoFeedsPlayActivity getVideoFeedsUserGuideShowCount() failed");
      return 0;
    }
    int i1 = paramAppRuntime.getInt("VIDEO_FEEDS_USER_GUIDE_SHOW_COUNT", 0);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("VideoFeedsPlayActivity getVideoFeedsUserGuideShowCount = ");
      paramAppRuntime.append(i1);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 2, paramAppRuntime.toString());
    }
    return i1;
  }
  
  public static void y(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateWeishiDeleteOutArticleFeedsCnt failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("weishi_delete_outdate_article_feeds_cnt", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void y(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoComponentConfig() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoComponentConfig() value=");
    localStringBuilder.append(paramString);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("sp_video_component_con", paramString);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void y(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("exposure_strengthen", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean y()
  {
    boolean bool2 = false;
    Boolean localBoolean = Boolean.valueOf(false);
    boolean bool1 = bool2;
    if (((Boolean)RIJSPUtils.a("sp_key_channel_list_dynamic_order_switch", localBoolean)).booleanValue())
    {
      bool1 = bool2;
      if (((Boolean)RIJSPUtils.a("sp_key_readinjoy_slide_channel_view", localBoolean)).booleanValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean y(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsPrePlaySwitch() failed");
      return true;
    }
    boolean bool = paramAppRuntime.getBoolean("VIDEO_FEEDS_PREPLAY_SWITCH", true);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getVideoFeedsPrePlaySwitch() result=");
    paramAppRuntime.append(bool);
    QLog.d("Q.readinjoy.tt_report", 1, paramAppRuntime.toString());
    return bool;
  }
  
  public static int z(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateReadInJoyWeiShiJumpTarget: sp == null");
      return 0;
    }
    return paramAppRuntime.getInt("SP_KEY_WEISHI_JUMP_TARGET", 0);
  }
  
  public static void z(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 1, "VideoFeedsPlayActivity updateVideoFeedsUserGuideShowCount() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("VIDEO_FEEDS_USER_GUIDE_SHOW_COUNT", paramInt);
    RIJSPUtils.a(paramAppRuntime, true);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("updateVideoFeedsUserGuideShowCount newCount = ");
      paramAppRuntime.append(paramInt);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 2, paramAppRuntime.toString());
    }
  }
  
  public static void z(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsDiscoverySwitch() failed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoFeedsDiscoverySwitch() value=");
    localStringBuilder.append(paramString);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_DISCOVERY_SWITCH", paramString);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void z(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateViolaDebugSwitcher");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("READINJOY_VIOLA_RECOMMEND_REASON", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static boolean z()
  {
    boolean bool2 = false;
    Boolean localBoolean = Boolean.valueOf(false);
    boolean bool1 = bool2;
    if (((Boolean)RIJSPUtils.a("sp_key_channel_list_dynamic_order_switch", localBoolean)).booleanValue())
    {
      bool1 = bool2;
      if (((Boolean)RIJSPUtils.a("sp_key_readinjoy_click_diversion_card", localBoolean)).booleanValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean z(AppRuntime paramAppRuntime)
  {
    Object localObject = Calendar.getInstance();
    int i1 = ((Calendar)localObject).get(1);
    int i2 = ((Calendar)localObject).get(2);
    int i3 = ((Calendar)localObject).get(5);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(i2);
    ((StringBuilder)localObject).append(i3);
    localObject = ((StringBuilder)localObject).toString();
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "checkIsVideoFeedsInterruptedAdLocalConfigToday() failed");
      return false;
    }
    String str = paramAppRuntime.getString("VIDEO_FEEDS_INTERRUPTED_AD_LOCAL_CONFIG_DATE_NEW", null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkIsVideoFeedsInterruptedAdLocalConfigToday localDate = ");
    localStringBuilder.append(str);
    QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str))) {
      return true;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_INTERRUPTED_AD_LOCAL_CONFIG_DATE_NEW", (String)localObject);
    RIJSPUtils.a(paramAppRuntime, true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper
 * JD-Core Version:    0.7.0.1
 */