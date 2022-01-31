package cooperation.readinjoy;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import anmh;
import anmj;
import anmk;
import anml;
import anmm;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFollowFragment;
import com.tencent.biz.pubaccount.readinjoy.model.SelfInfoModule.BusinessCountInfo;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNotifyDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BitmapUtil;
import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadInJoyHelper
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  public static String a;
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  private static List jdField_a_of_type_JavaUtilList;
  private static Map jdField_a_of_type_JavaUtilMap;
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  protected static boolean a;
  public static final String[] a;
  private static int jdField_b_of_type_Int;
  public static String b;
  private static Map jdField_b_of_type_JavaUtilMap;
  private static boolean jdField_b_of_type_Boolean;
  private static int jdField_c_of_type_Int;
  private static String jdField_c_of_type_JavaLangString;
  private static Map jdField_c_of_type_JavaUtilMap;
  private static boolean jdField_c_of_type_Boolean;
  private static int jdField_d_of_type_Int;
  private static String jdField_d_of_type_JavaLangString;
  private static int jdField_e_of_type_Int;
  private static String jdField_e_of_type_JavaLangString;
  private static int jdField_f_of_type_Int;
  private static String jdField_f_of_type_JavaLangString;
  private static int jdField_g_of_type_Int;
  private static String jdField_g_of_type_JavaLangString;
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
  private static int u;
  private static int v;
  private static int w;
  private static int x;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaLangString = "kandian_new_channel_style";
    jdField_b_of_type_JavaLangString = "_mode_videochannel_";
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "collectbox", "homepage", "messagebox_V3", "messagebox_pendant_V3", "commentpage", "recommend_friends", "accountpage", "topicvideo", "mytopic", "myhistory", "myfollow", "myfans", "mynotify" };
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = -1;
    jdField_d_of_type_Int = -1;
    jdField_e_of_type_Int = -1;
    jdField_a_of_type_Long = -1L;
    jdField_f_of_type_Int = -1;
    jdField_g_of_type_Int = -1;
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
    v = -1;
    w = -1;
    x = -1;
    jdField_g_of_type_JavaLangString = "try_stick_flag";
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    jdField_c_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  }
  
  public static int A(AppRuntime paramAppRuntime)
  {
    if (t > 0) {
      return t;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianFollowCount() failed");
      return 0;
    }
    t = paramAppRuntime.getInt("kandian_user_follow_count", 0);
    return t;
  }
  
  public static void A(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      QLog.d("ReadInJoyHelper", 2, "is_show_weishi_entrance: sp is null");
    }
    do
    {
      return;
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("is_show_weishi_entrance", paramInt);
      a(paramAppRuntime, true);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyHelper", 2, "is_show_weishi_entrance = " + paramInt);
  }
  
  public static void A(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsInterruptedAdConfigLocal() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsInterruptedAdConfigLocal() value=" + paramString);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_INTERRUPTED_AD_LOCAL_CONFIG", paramString);
    a(paramAppRuntime, true);
  }
  
  public static int B(AppRuntime paramAppRuntime)
  {
    if (u > 0) {
      return u;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianFansCount() failed");
      return 0;
    }
    u = paramAppRuntime.getInt("kandian_user_fans_count", 0);
    return u;
  }
  
  public static void B(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals("1"))
      {
        r(paramAppRuntime, true);
        q(paramAppRuntime, false);
      }
    }
    else {
      return;
    }
    if (paramString.equals("2"))
    {
      r(paramAppRuntime, true);
      q(paramAppRuntime, true);
      return;
    }
    q(paramAppRuntime, false);
    r(paramAppRuntime, false);
  }
  
  public static int C(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoChannelCoverStyle() failed");
      return -1;
    }
    return paramAppRuntime.getInt("video_channel_cover_style", 0);
  }
  
  public static void C(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("native_engine_timeout_config", paramString);
    a(paramAppRuntime, true);
  }
  
  public static int D(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getMultiVideoDynamicRecommendStrategy() failed");
      return -1;
    }
    int i1 = paramAppRuntime.getInt("multi_video_dynamic_recommend_strategyid", 0);
    QLog.d("Q.readinjoy.tt_report", 1, "getMultiVideoDynamicRecommendStrategy() result=" + i1);
    return i1;
  }
  
  public static int E(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getMultiVideoDynamicRecommendDurationLimit() failed");
      return -1;
    }
    int i1 = paramAppRuntime.getInt("multi_video_dynamic_recommend_duration_limit", -1);
    QLog.d("Q.readinjoy.tt_report", 1, "getMultiVideoDynamicRecommendDurationLimit() result=" + i1);
    return i1;
  }
  
  public static int F(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getMultiVideoDynamicRecommendOperator() failed");
      return -1;
    }
    int i1 = paramAppRuntime.getInt("multi_video_dynamic_recommend_operator", 0);
    QLog.d("Q.readinjoy.tt_report", 1, "getMultiVideoDynamicRecommendOperator() result=" + i1);
    return i1;
  }
  
  public static int G(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoDynamicRecommendStrategy() failed");
      return -1;
    }
    int i1 = paramAppRuntime.getInt("video_dynamic_recommend_strategyid", -1);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoDynamicRecommendStrategy() result=" + i1);
    return i1;
  }
  
  public static int H(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoDynamicRecommendDurationLimit() failed");
      return -1;
    }
    int i1 = paramAppRuntime.getInt("video_dynamic_recommend_duration_limit", -1);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoDynamicRecommendDurationLimit() result=" + i1);
    return i1;
  }
  
  public static int I(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoDynamicRecommendOperator() failed");
      return -1;
    }
    int i1 = paramAppRuntime.getInt("video_dynamic_recommend_operator", 0);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoDynamicRecommendOperator() result=" + i1);
    return i1;
  }
  
  public static int J(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsShortVideoMaxDrationLimit() failed");
      return 0;
    }
    int i1 = paramAppRuntime.getInt("readinjoy_short_video_max_duration_limit", -1);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoFeedsShortVideoMaxDrationLimit() result=" + i1);
    return i1;
  }
  
  public static int K(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigBadgeSwitch() failed");
      return -1;
    }
    if (x != -1) {
      return x;
    }
    x = paramAppRuntime.getInt("kandian_badge_switch", 0);
    return x;
  }
  
  public static int L(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramAppRuntime.getAccount()) == null)
    {
      i1 = a(paramAppRuntime, true, true).getInt("user_kandian_show_config", -1);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramAppRuntime.getAccount(), Integer.valueOf(i1));
      QLog.d("ReadInJoyHelper", 2, "uin : " + paramAppRuntime.getAccount() + " user kandiantab show config : " + i1);
    }
    paramAppRuntime = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramAppRuntime.getAccount());
    if (paramAppRuntime != null) {}
    for (int i1 = paramAppRuntime.intValue();; i1 = -1) {
      return i1;
    }
  }
  
  public static int M(AppRuntime paramAppRuntime)
  {
    int i1 = 0;
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 1, "VideoFeedsPlayActivity getVideoFeedsUserGuideShowCount() failed");
    }
    int i2;
    do
    {
      return i1;
      i2 = paramAppRuntime.getInt("VIDEO_FEEDS_USER_GUIDE_SHOW_COUNT", 0);
      i1 = i2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity getVideoFeedsUserGuideShowCount = " + i2);
    return i2;
  }
  
  public static float a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getMultiVideoDynamicRecommendDurationPercent() failed");
      return -1.0F;
    }
    float f1 = paramAppRuntime.getFloat("multi_video_dynamic_recommend_duration_rate", -1.0F);
    QLog.d("Q.readinjoy.tt_report", 1, "getMultiVideoDynamicRecommendDurationPercent() result=" + f1);
    return f1;
  }
  
  public static int a()
  {
    SharedPreferences localSharedPreferences = a(ReadInJoyUtils.a(), true, true);
    if (localSharedPreferences == null) {
      return 0;
    }
    return localSharedPreferences.getInt("IdleExitAioRptCntForReport", 0);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i2 = 1280;
    int i1;
    if (paramInt1 <= paramInt2)
    {
      i1 = ReadInJoyConstants.jdField_c_of_type_Int;
      paramInt1 = y(BaseApplicationImpl.getApplication().getRuntime());
      if (paramInt1 <= 0) {
        break label81;
      }
      i1 = paramInt1;
    }
    label81:
    for (;;)
    {
      if (paramInt2 >= 1280) {
        paramInt1 = i2;
      }
      for (;;)
      {
        float f1 = i1 * 1.0F / 640.0F;
        return (int)(paramInt1 * f1);
        paramInt2 = paramInt1;
        break;
        if (paramInt2 >= 960) {
          paramInt1 = 960;
        } else {
          paramInt1 = 640;
        }
      }
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("readinjoy_video_channel_info_config_version" + paramQQAppInterface.getCurrentAccountUin(), -1);
  }
  
  public static int a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getVideoChannelFeedsClickSwitch failed to get sp");
      return 1;
    }
    return paramAppRuntime.getInt("key_video_channel_feeds_click_switch", 0);
  }
  
  public static long a()
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {
      return -1L;
    }
    localObject = a((AppRuntime)localObject, true, true);
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
    return paramQQAppInterface.getLong(paramInt + "_" + "last_exit_channel_time", 0L);
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
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianLocalRedShowDate() failed");
      return -1L;
    }
    if (jdField_a_of_type_Long != -1L) {
      return jdField_a_of_type_Long;
    }
    jdField_a_of_type_Long = paramAppRuntime.getLong("kandian_tabdot_show_date", 0L);
    return jdField_a_of_type_Long;
  }
  
  @Deprecated
  public static SharedPreferences a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    while (paramInt == 2) {
      return null;
    }
    if ((paramInt == 0) && (Build.VERSION.SDK_INT >= 11)) {}
    for (int i1 = 4;; i1 = 0)
    {
      paramQQAppInterface = String.format("readinjoy_%s_%d", new Object[] { paramQQAppInterface.getAccount(), Integer.valueOf(paramInt) });
      return BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface, i1);
    }
  }
  
  public static SharedPreferences a(AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramAppRuntime == null) {
      return null;
    }
    if (paramBoolean1) {
      paramAppRuntime = paramAppRuntime.getAccount();
    }
    for (paramAppRuntime = "readinjoy_sp" + "_" + paramAppRuntime;; paramAppRuntime = "readinjoy_sp")
    {
      int i2 = 0;
      int i1 = i2;
      if (paramBoolean2)
      {
        i1 = i2;
        if (Build.VERSION.SDK_INT >= 11) {
          i1 = 4;
        }
      }
      return BaseApplicationImpl.getApplication().getSharedPreferences(paramAppRuntime, i1);
    }
  }
  
  public static android.util.Pair a()
  {
    SharedPreferences localSharedPreferences = a(ReadInJoyUtils.a(), true, true);
    if (localSharedPreferences == null) {
      return new android.util.Pair(Integer.valueOf(60), Integer.valueOf(60));
    }
    return new android.util.Pair(Integer.valueOf(localSharedPreferences.getInt("kandian_aio_msg_received_duration", 60)), Integer.valueOf(localSharedPreferences.getInt("kandian_aio_msg_send_duration", 60)));
  }
  
  public static LebaViewItem a(QQAppInterface paramQQAppInterface)
  {
    List localList = LebaShowListManager.a().a();
    Object localObject;
    if (localList != null)
    {
      localObject = localList;
      if (!localList.isEmpty()) {}
    }
    else
    {
      LebaShowListManager.a().a(paramQQAppInterface.getApplication().getApplicationContext(), paramQQAppInterface);
      localObject = LebaShowListManager.a().a();
    }
    if (localObject != null)
    {
      paramQQAppInterface = ((List)localObject).iterator();
      while (paramQQAppInterface.hasNext())
      {
        localObject = (LebaViewItem)paramQQAppInterface.next();
        if ((localObject != null) && (((LebaViewItem)localObject).a != null) && (((LebaViewItem)localObject).a.uiResId == 1130L)) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public static com.tencent.util.Pair a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return new com.tencent.util.Pair(Long.valueOf(86400L), Integer.valueOf(5));
    }
    return new com.tencent.util.Pair(Long.valueOf(paramAppRuntime.getLong("kandian_delete_outdate_article_interval", 86400L)), Integer.valueOf(paramAppRuntime.getInt("kandian_delete_outdate_article_feeds_cnt", 5)));
  }
  
  public static ReadInJoyHelper.DefaultSetting a(Node paramNode)
  {
    ReadInJoyHelper.DefaultSetting localDefaultSetting = new ReadInJoyHelper.DefaultSetting();
    if (TextUtils.equals("setting", paramNode.getNodeName()))
    {
      paramNode = paramNode.getFirstChild();
      if (paramNode != null)
      {
        String str2;
        if (paramNode.getNodeType() == 1)
        {
          String str1 = paramNode.getNodeName();
          str2 = paramNode.getFirstChild().getNodeValue();
          if (!TextUtils.equals(str1, "id")) {
            break label99;
          }
        }
        for (;;)
        {
          try
          {
            localDefaultSetting.jdField_a_of_type_Int = Integer.parseInt(str2);
            paramNode = paramNode.getNextSibling();
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            localNumberFormatException1.printStackTrace();
            continue;
          }
          label99:
          if (TextUtils.equals(localNumberFormatException1, "title")) {
            localDefaultSetting.jdField_a_of_type_JavaLangString = str2;
          } else if (TextUtils.equals(localNumberFormatException1, "hidden")) {
            try
            {
              localDefaultSetting.jdField_b_of_type_Int = Integer.parseInt(str2);
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              localNumberFormatException2.printStackTrace();
            }
          }
        }
      }
    }
    return localDefaultSetting;
  }
  
  public static ReadInJoyHelper.OperatingSetting a(Node paramNode)
  {
    ReadInJoyHelper.OperatingSetting localOperatingSetting = new ReadInJoyHelper.OperatingSetting();
    if (TextUtils.equals("setting", paramNode.getNodeName()))
    {
      paramNode = paramNode.getFirstChild();
      if (paramNode != null)
      {
        String str1;
        String str2;
        if (paramNode.getNodeType() == 1)
        {
          str1 = paramNode.getNodeName();
          str2 = paramNode.getFirstChild().getNodeValue();
          if (!TextUtils.equals(str1, "title")) {
            break label88;
          }
          localOperatingSetting.jdField_a_of_type_JavaLangString = str2;
        }
        for (;;)
        {
          paramNode = paramNode.getNextSibling();
          break;
          label88:
          if (TextUtils.equals(str1, "jumpurl")) {
            localOperatingSetting.jdField_b_of_type_JavaLangString = str2;
          }
        }
      }
    }
    return localOperatingSetting;
  }
  
  public static Boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianSelfForbidden() failed");
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(paramAppRuntime.getBoolean("kandian_user_forbidden", false));
  }
  
  public static Integer a(String paramString)
  {
    String str = ReadInJoyUtils.a();
    return (Integer)jdField_a_of_type_JavaUtilMap.get(paramString + "_" + str);
  }
  
  public static Object a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject3 == null)
    {
      QLog.d("ReadInJoyHelper", 1, new Object[] { "app is null, getKDSPValueWithKey, key = ", paramString, ", value is null." });
      localObject2 = localObject1;
      return localObject2;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyHelper", 1, "key is null or empty, can not get value.");
      return null;
    }
    localObject3 = a((AppRuntime)localObject3, true, true);
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      if ((!paramString.equals("local_kd_tab_switch")) && (!paramString.equals("local_kd_tab_has_set")) && (!paramString.equals("remote_kd_tab_switch")) && (!paramString.equals("kd_topic_recommend_card_jump_switch"))) {
        break label168;
      }
      localObject1 = Boolean.valueOf(((SharedPreferences)localObject3).getBoolean(paramString, false));
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyHelper", 2, new Object[] { "getKDSPValueWithKey, key = ", paramString, ", value = ", localObject1 });
      return localObject1;
      label168:
      if ((!paramString.equals("local_kd_tab_type")) && (!paramString.equals("remote_kd_tab_type")) && (!paramString.equals("kd_topic_recommend_card_jump_url")))
      {
        localObject1 = localObject2;
        if (!paramString.equals("debug_kd_tab_type")) {}
      }
      else if ((paramString.equals("local_kd_tab_type")) || (paramString.equals("remote_kd_tab_type")))
      {
        localObject1 = ((SharedPreferences)localObject3).getString(paramString, "1");
      }
      else
      {
        localObject1 = ((SharedPreferences)localObject3).getString(paramString, "0");
      }
    }
  }
  
  public static String a()
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {
      return "0";
    }
    localObject = a((AppRuntime)localObject, true, true);
    if (localObject != null) {
      return ((SharedPreferences)localObject).getString("proteus_offline_bid", "0");
    }
    return "0";
  }
  
  public static String a(int paramInt)
  {
    if (paramInt < 10000) {
      return String.valueOf(paramInt);
    }
    return String.format("%d万", new Object[] { Integer.valueOf((paramInt + 5000) / 10000) });
  }
  
  public static String a(Activity paramActivity)
  {
    int i1 = 0;
    if ((paramActivity instanceof ReadInJoyNewFeedsActivity)) {
      i1 = 1;
    }
    for (;;)
    {
      return "56_last_exit_channel_time" + jdField_b_of_type_JavaLangString + i1;
      if ((paramActivity instanceof SplashActivity)) {
        i1 = 2;
      } else if ((paramActivity instanceof ReadInJoyChannelActivity)) {
        i1 = 3;
      }
    }
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to get sp IndividualPushDate");
      return "";
    }
    return paramAppRuntime.getString("readinjoy_individual_push_date", "");
  }
  
  public static HashMap a(AppRuntime paramAppRuntime)
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_a_of_type_JavaUtilHashMap.putAll(b(paramAppRuntime));
    return jdField_a_of_type_JavaUtilHashMap;
  }
  
  public static List a(AppRuntime paramAppRuntime)
  {
    JSONObject localJSONObject = null;
    if (jdField_a_of_type_JavaUtilList != null) {
      paramAppRuntime = jdField_a_of_type_JavaUtilList;
    }
    for (;;)
    {
      return paramAppRuntime;
      paramAppRuntime = a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "getFansInfoList() failed");
        return null;
      }
      Object localObject = paramAppRuntime.getString("kandian_user_fans_info_list", null);
      paramAppRuntime = localJSONObject;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = new JSONArray((String)localObject);
          int i2 = ((JSONArray)localObject).length();
          paramAppRuntime = localJSONObject;
          if (i2 > 0)
          {
            paramAppRuntime = new ArrayList(i2);
            int i1 = 0;
            while (i1 < i2)
            {
              localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
              SelfInfoModule.BusinessCountInfo localBusinessCountInfo = new SelfInfoModule.BusinessCountInfo();
              localBusinessCountInfo.a(localJSONObject);
              paramAppRuntime.add(localBusinessCountInfo);
              i1 += 1;
            }
            jdField_a_of_type_JavaUtilList = paramAppRuntime;
            return paramAppRuntime;
          }
        }
        catch (JSONException paramAppRuntime)
        {
          QLog.d("ReadInJoyHelper", 1, "getFansInfoList error. " + paramAppRuntime);
        }
      }
    }
    return null;
  }
  
  public static void a()
  {
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = -1;
    jdField_d_of_type_Int = -1;
    jdField_e_of_type_Int = -1;
    jdField_a_of_type_Long = -1L;
    jdField_f_of_type_Int = -1;
    jdField_g_of_type_Int = -1;
    h = -1;
    i = -1;
    k = -1;
    j = -1;
    w = -1;
    x = -1;
    s = -1;
    t = 0;
    u = 0;
    jdField_a_of_type_JavaUtilList = null;
    jdField_e_of_type_JavaLangString = null;
    jdField_f_of_type_JavaLangString = null;
    v = -1;
    n = -1;
  }
  
  public static void a(int paramInt)
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("IdleExitAioRptCntForReport", paramInt);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("kandian_aio_msg_received_duration", paramInt1);
    ((SharedPreferences.Editor)localObject).putInt("kandian_aio_msg_send_duration", paramInt2);
    a((SharedPreferences.Editor)localObject, true);
    QLog.d("ReadInJoyHelper", 2, "update aio msg receive & send duration A : " + paramInt1 + ", B : " + paramInt2);
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
    a(paramQQAppInterface, true);
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("exposed_channel_bg_consumed_" + paramInt, paramBoolean);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void a(long paramLong)
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("sp_key_readinjoy_magic_event_debounce_interval", paramLong);
    a((SharedPreferences.Editor)localObject, true);
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
  
  public static void a(SharedPreferences.Editor paramEditor, boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 9))
    {
      paramEditor.apply();
      return;
    }
    paramEditor.commit();
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
    QLog.d("SPLASH_ConfigServlet", 1, "ReadinjoyFolderMerge config " + jdField_a_of_type_Boolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ReadInJoyUtils.a();
    localReportInfo.mSource = paramInt1;
    localReportInfo.mSourceArticleId = paramLong;
    localReportInfo.mOperation = paramInt2;
    localReportInfo.mOpSource = paramInt3;
    localArrayList.add(localReportInfo);
    new UserOperationModule(paramQQAppInterface, null, null, ReadInJoyMSFService.a(), null).a(localArrayList);
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
    paramQQAppInterface.edit().putLong(paramInt + "_" + "last_exit_channel_time", paramLong).commit();
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
    ReadInJoyUtils.a(7);
    ReadInJoyActivityHelper.a(paramActivity, null, -1L, 7);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i1 = 4;
    try
    {
      int i2 = Integer.valueOf(paramString).intValue();
      i1 = i2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.d("ReadInJoyHelper", 1, "updateReadInJoyFeedsGroupSetting failed " + paramString.toString());
      }
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putInt("config_feeds_group_setting", i1);
      a(paramQQAppInterface, true);
    }
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iload_1
    //   4: putstatic 873	cooperation/readinjoy/ReadInJoyHelper:jdField_b_of_type_Boolean	Z
    //   7: aload_0
    //   8: iconst_1
    //   9: invokestatic 434	cooperation/readinjoy/ReadInJoyHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)Landroid/content/SharedPreferences;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +7 -> 21
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: aload_2
    //   22: invokeinterface 190 1 0
    //   27: astore_2
    //   28: aload_2
    //   29: ldc_w 875
    //   32: iload_1
    //   33: invokeinterface 748 3 0
    //   38: pop
    //   39: aload_2
    //   40: iconst_1
    //   41: invokestatic 201	cooperation/readinjoy/ReadInJoyHelper:a	(Landroid/content/SharedPreferences$Editor;Z)V
    //   44: aload_0
    //   45: iload_1
    //   46: invokestatic 877	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   49: goto -32 -> 17
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramQQAppInterface	QQAppInterface
    //   0	58	1	paramBoolean	boolean
    //   12	28	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	52	finally
    //   21	49	52	finally
  }
  
  public static void a(String paramString)
  {
    Object localObject = ReadInJoyUtils.a();
    if ((localObject == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putStringSet("kd_icon_merge_subscription_white_list", new HashSet(Arrays.asList(paramString.split("\\|"))));
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void a(String paramString, int paramInt)
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("exposed_channel_bg_url_" + paramInt, paramString);
    a((SharedPreferences.Editor)localObject, true);
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
    a(paramString, true);
  }
  
  public static void a(String paramString, Integer paramInteger)
  {
    String str = ReadInJoyUtils.a();
    jdField_a_of_type_JavaUtilMap.put(paramString + "_" + str, paramInteger);
    QLog.d("ReadInJoyHelper", 2, "updateKDTabConfigCache" + paramString + ", value : " + paramInteger + ", account" + str);
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null)
    {
      ReadInJoyBaseAdapter.jdField_e_of_type_Int = 1000;
      QLog.d("ReadInJoyHelper", 1, "app null update feeds group setting:" + ReadInJoyBaseAdapter.jdField_e_of_type_Int);
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i1 = 4;; i1 = 0)
    {
      paramAppRuntime = String.format("readinjoy_%s_%d", new Object[] { paramAppRuntime.getAccount(), Integer.valueOf(1) });
      paramAppRuntime = BaseApplicationImpl.getApplication().getSharedPreferences(paramAppRuntime, i1);
      if (paramAppRuntime == null)
      {
        ReadInJoyBaseAdapter.jdField_e_of_type_Int = 1000;
        QLog.d("ReadInJoyHelper", 1, "sp null update feeds group setting:" + ReadInJoyBaseAdapter.jdField_e_of_type_Int);
        return;
      }
      ReadInJoyBaseAdapter.jdField_e_of_type_Int = paramAppRuntime.getInt("config_feeds_group_setting", 1000);
      QLog.d("ReadInJoyHelper", 1, "update feeds group setting:" + ReadInJoyBaseAdapter.jdField_e_of_type_Int);
      return;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, float paramFloat)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateMultiVideoDynamicRecommendDurationPercent() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateMultiVideoDynamicRecommendDurationPercent() num=" + paramFloat);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putFloat("multi_video_dynamic_recommend_duration_rate", paramFloat);
    a(paramAppRuntime, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateVideoChannelFeedsClickSwitchValue failed to update sp");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("key_video_channel_feeds_click_switch", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, List paramList)
  {
    SharedPreferences localSharedPreferences = a(paramAppRuntime, true, true);
    if (localSharedPreferences == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianFollowAndFansCount() failed");
      return;
    }
    Object localObject = null;
    paramAppRuntime = (AppRuntime)localObject;
    if (paramList != null)
    {
      paramAppRuntime = (AppRuntime)localObject;
      if (paramList.size() > 0)
      {
        paramAppRuntime = new JSONArray();
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramAppRuntime.put(((SelfInfoModule.BusinessCountInfo)((Iterator)localObject).next()).a());
        }
        localObject = paramAppRuntime.toString();
        paramAppRuntime = (AppRuntime)localObject;
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInJoyHelper", 2, "updateKandianFollowAndFansCount followNum:" + paramInt1 + ", userNickName:" + paramInt2 + ", fansInfoList = " + paramList.size());
          paramAppRuntime = (AppRuntime)localObject;
        }
      }
    }
    localObject = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).putInt("kandian_user_follow_count", paramInt1);
    ((SharedPreferences.Editor)localObject).putInt("kandian_user_fans_count", paramInt2);
    if (paramAppRuntime != null) {
      ((SharedPreferences.Editor)localObject).putString("kandian_user_fans_info_list", paramAppRuntime);
    }
    a((SharedPreferences.Editor)localObject, true);
    t = paramInt1;
    u = paramInt2;
    jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public static void a(AppRuntime paramAppRuntime, long paramLong)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianLocalRedShowDate() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putLong("kandian_tabdot_show_date", paramLong);
    a(paramAppRuntime, true);
    jdField_a_of_type_Long = paramLong;
  }
  
  public static void a(AppRuntime paramAppRuntime, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramAppRuntime == null) {}
    do
    {
      return;
      paramAppRuntime = a(paramAppRuntime, true, true);
    } while (paramAppRuntime == null);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putLong("msg_info_pulse_report_x", paramLong1);
    paramAppRuntime.putLong("msg_info_pulse_report_y", paramLong2);
    paramAppRuntime.putLong("msg_info_pulse_report_z", paramLong3);
    a(paramAppRuntime, true);
    QLog.d("ReadInJoyHelper", 2, "update msg info pulse param x : " + paramLong1 + ", y : " + paramLong2 + ", z : " + paramLong3);
  }
  
  public static void a(AppRuntime paramAppRuntime, Context paramContext, ArticleInfo paramArticleInfo)
  {
    Object localObject = a(paramAppRuntime, true, true);
    if (localObject == null) {
      QLog.d("ReadInJoyHelper", 1, "showGuideViews1() failed");
    }
    do
    {
      do
      {
        return;
        if (!((SharedPreferences)localObject).getBoolean("read_in_joy_follow_tab_guide_view" + paramAppRuntime.getAccount(), false)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ReadInJoyHelper", 2, "is already show tab guide views");
      return;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("read_in_joy_follow_tab_guide_view" + paramAppRuntime.getAccount(), true);
      a((SharedPreferences.Editor)localObject, true);
      paramAppRuntime = (FrameLayout)((Activity)paramContext).getWindow().getDecorView();
      localObject = LayoutInflater.from(paramContext).inflate(2130970695, paramAppRuntime, false);
      paramContext = BitmapUtil.a(((Activity)paramContext).findViewById(2131362327));
      ImageView localImageView = (ImageView)((View)localObject).findViewById(2131371630);
      if (paramContext != null) {
        localImageView.setImageBitmap(paramContext);
      }
      ((View)localObject).setOnClickListener(new anmk(paramAppRuntime, (View)localObject));
      paramAppRuntime.addView((View)localObject);
    } while (paramArticleInfo == null);
    PublicAccountReportUtils.a(null, paramArticleInfo.publishUin + "", "0X8009333", "0X8009333", 0, 0, "" + ReadInJoyUtils.e(), "" + ReadInJoyUtils.d(), paramArticleInfo.mChannelID + "", "", false);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    SharedPreferences localSharedPreferences = a(paramAppRuntime, true, true);
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
    a(paramString, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, Object paramObject)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateKDSPWithKeyAndValue failed, sp is null.");
      return;
    }
    if (paramObject == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateKDSPWithKeyAndValue failed, value is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 2, new Object[] { "updateKDSPWithKeyAndValue, key = ", paramString, ", value = ", paramObject });
    }
    paramAppRuntime = paramAppRuntime.edit();
    if ((paramObject instanceof String)) {
      paramAppRuntime.putString(paramString, (String)paramObject);
    }
    for (;;)
    {
      a(paramAppRuntime, true);
      return;
      if (!(paramObject instanceof Boolean)) {
        break;
      }
      paramAppRuntime.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    }
    QLog.d("ReadInJoyHelper", 1, "updateKDSPWithKeyAndValue, now not support this kind of instance.");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowVideoToast");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("readinjoy_social_weburl_" + paramString1, paramString2);
    a(paramAppRuntime, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      QLog.d("Q.readinjoy.tt_report", 1, "updateUserInfo() failed");
    }
    do
    {
      return;
      paramAppRuntime = paramAppRuntime.edit();
      if (!TextUtils.isEmpty(paramString1))
      {
        paramAppRuntime.putString("kandian_user_head_url", paramString1);
        jdField_e_of_type_JavaLangString = paramString1;
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramAppRuntime.putString("kandian_user_nick_name", paramString2);
        jdField_f_of_type_JavaLangString = paramString2;
      }
      if (paramInt != -1)
      {
        paramAppRuntime.putInt("kandian_user_is_vip", paramInt);
        v = paramInt;
      }
      a(paramAppRuntime, true);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyHelper", 2, "updateUserInfo userHeadUrl:" + paramString1 + ", userNickName:" + paramString2 + ", userIsVip = " + paramInt);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp IndividualPushSwitch");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_individual_push_switch", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static void a(boolean paramBoolean)
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("sp_key_readinjoy_magic_switch", paramBoolean);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 2, "isReadinjoyVideoChannel() channelType=" + paramInt);
    }
    return paramInt == 3;
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
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int i2 = arrayOfString.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (TextUtils.equals(arrayOfString[i1], paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("READINJOY_VIDEO_CHANNEL_AUTO_PLAY_NEXT_VIDEO_HINT", true);
    if (bool)
    {
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putBoolean("READINJOY_VIDEO_CHANNEL_AUTO_PLAY_NEXT_VIDEO_HINT", false);
      a(paramAppRuntime, true);
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
      String str = ((JSONObject)localObject).optString("app");
      localObject = ((JSONObject)localObject).optString("ver", null);
      if (!TextUtils.isEmpty(str)) {
        ThreadManager.executeOnSubThread(new anmh(((ArkAppCenter)paramAppRuntime.getManager(120)).a(), str, (String)localObject, paramString));
      }
      paramString = new HashMap();
      if (TextUtils.isEmpty(str)) {
        paramString.put("action", "configOff");
      }
      for (;;)
      {
        StatisticCollector.a(paramAppRuntime.getApplication()).a(null, "actionReadInJoyArkConfig", true, 0L, 0L, paramString, null);
        return true;
        paramString.put("action", "configOn");
        paramString.put("appname", str);
        paramString.put("appver", localObject);
      }
      return false;
    }
    catch (Exception paramAppRuntime)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyHelper", 2, "parse json error ", paramAppRuntime);
      }
    }
  }
  
  public static float b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoDynamicRecommendDurationPercent() failed");
      return -1.0F;
    }
    float f1 = paramAppRuntime.getFloat("video_dynamic_recommend_duration_rate", -1.0F);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoDynamicRecommendDurationPercent() result=" + f1);
    return f1;
  }
  
  public static int b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getVideoChannelAutoPlaySwitchDefaultValue failed to get sp");
      return 1;
    }
    return paramAppRuntime.getInt("video_channel_auto_play_switch", 1);
  }
  
  public static long b()
  {
    SharedPreferences localSharedPreferences = a(ReadInJoyUtils.a(), true, true);
    if (localSharedPreferences == null) {
      return 150000L;
    }
    return localSharedPreferences.getLong("sp_key_readinjoy_magic_event_debounce_interval", 150000L);
  }
  
  public static long b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return 10L;
    }
    return paramAppRuntime.getLong("msg_info_pulse_report_x", 10L);
  }
  
  public static android.util.Pair b()
  {
    SharedPreferences localSharedPreferences = a(ReadInJoyUtils.a(), true, true);
    if (localSharedPreferences == null) {
      return null;
    }
    return new android.util.Pair(Integer.valueOf(localSharedPreferences.getInt("ExitAioIdleReportUinLimitS", -1)), Integer.valueOf(localSharedPreferences.getInt("ExitAioIdleReportUinLimitE", -1)));
  }
  
  public static String b(int paramInt)
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return null;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getString("exposed_channel_bg_url_" + paramInt, null);
  }
  
  public static String b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return "";
    }
    return paramAppRuntime.getString("readinjoy_ark_channel_config", "");
  }
  
  private static HashMap b(AppRuntime paramAppRuntime)
  {
    HashMap localHashMap = new HashMap();
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return localHashMap;
    }
    paramAppRuntime = paramAppRuntime.getString("READINJOY_VIDEO_CHANNEL_LIKE_UNLIKE_SP2", "");
    if (TextUtils.isEmpty(paramAppRuntime)) {
      return localHashMap;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 2, "getLikeUnLikeSP likeUnLikeSp:" + paramAppRuntime);
    }
    paramAppRuntime = paramAppRuntime.split(";");
    if ((paramAppRuntime != null) && (paramAppRuntime.length > 0))
    {
      int i1 = 0;
      while (i1 < paramAppRuntime.length)
      {
        if (!TextUtils.isEmpty(paramAppRuntime[i1])) {
          localHashMap.put(paramAppRuntime[i1], Boolean.valueOf(true));
        }
        i1 += 1;
      }
    }
    return localHashMap;
  }
  
  public static List b(AppRuntime paramAppRuntime)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a(paramAppRuntime, true, true);
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      paramAppRuntime = ((SharedPreferences)localObject).getString("readinjoy_my_tab_setting" + paramAppRuntime.getAccount(), "");
      try
      {
        for (paramAppRuntime = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramAppRuntime.getBytes("utf-8"))).getElementsByTagName("configs").item(0).getFirstChild();; paramAppRuntime = paramAppRuntime.getNextSibling())
        {
          localObject = localArrayList;
          if (paramAppRuntime == null) {
            break;
          }
          if ((paramAppRuntime.getFirstChild() != null) && (TextUtils.equals(paramAppRuntime.getNodeName(), "kandiansettings"))) {
            for (localObject = paramAppRuntime.getFirstChild(); localObject != null; localObject = ((Node)localObject).getNextSibling()) {
              if ((((Node)localObject).getNodeType() == 1) && (TextUtils.equals("defaultsettings", ((Node)localObject).getNodeName()))) {
                for (Node localNode = ((Node)localObject).getFirstChild(); localNode != null; localNode = localNode.getNextSibling()) {
                  if (localNode.getNodeType() == 1) {
                    localArrayList.add(a(localNode));
                  }
                }
              }
            }
          }
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramAppRuntime)
      {
        localObject = localArrayList;
      }
    }
    QLog.d("ReadInJoyHelper", 2, "exception occurs", paramAppRuntime);
    return localArrayList;
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("ExitAioIdleReportUinLimitS", paramInt1);
    ((SharedPreferences.Editor)localObject).putInt("ExitAioIdleReportUinLimitE", paramInt2);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putBoolean("show_interest_label", false);
    a(paramQQAppInterface, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      i1 = Integer.valueOf(paramString).intValue();
      paramQQAppInterface = a(paramQQAppInterface, 1);
      if (paramQQAppInterface == null) {
        return;
      }
    }
    catch (Exception paramString)
    {
      int i1;
      for (;;)
      {
        QLog.w("ReadInJoyHelper", 1, "updateReadInJoyPushMsgSwitch failed: " + paramString.toString());
        i1 = 1;
      }
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putInt("readinjoy_config_push_msg_switch", i1);
      a(paramQQAppInterface, true);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putBoolean("hot_shortvideo_multi_video_support", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static void b(String paramString)
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("proteus_offline_bid", paramString);
    a((SharedPreferences.Editor)localObject, true);
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
    a(paramString, true);
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp IndividualPushDate");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("readinjoy_individual_push_date", ReadInJoyUtils.a.format(Long.valueOf(System.currentTimeMillis())));
    a(paramAppRuntime, true);
  }
  
  public static void b(AppRuntime paramAppRuntime, float paramFloat)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoDynamicRecommendDurationPercent() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoDynamicRecommendDurationPercent() num=" + paramFloat);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putFloat("video_dynamic_recommend_duration_rate", paramFloat);
    a(paramAppRuntime, true);
  }
  
  public static void b(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateVideoChannelAutoPlaySwitchDefaultValue failed to update sp");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_channel_auto_play_switch", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void b(AppRuntime paramAppRuntime, long paramLong)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianDeleteOutDateArticleInterval failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putLong("kandian_delete_outdate_article_interval", paramLong);
    a(paramAppRuntime, true);
  }
  
  public static void b(AppRuntime paramAppRuntime, Context paramContext, ArticleInfo paramArticleInfo)
  {
    Object localObject = a(paramAppRuntime, true, true);
    if (localObject == null) {
      QLog.d("ReadInJoyHelper", 1, "showGuideViews2() failed");
    }
    do
    {
      do
      {
        return;
        if (!((SharedPreferences)localObject).getBoolean("read_in_joy_follow_message_guide_view" + paramAppRuntime.getAccount(), false)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ReadInJoyHelper", 2, "is already show message guide views");
      return;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("read_in_joy_follow_message_guide_view" + paramAppRuntime.getAccount(), true);
      a((SharedPreferences.Editor)localObject, true);
      paramAppRuntime = (FrameLayout)((Activity)paramContext).getWindow().getDecorView();
      localObject = LayoutInflater.from((Activity)paramContext).inflate(2130970696, paramAppRuntime, false);
      if ((paramAppRuntime != null) && (paramAppRuntime.getWidth() > 0) && (paramAppRuntime.getHeight() > 0))
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramAppRuntime.getWidth(), paramAppRuntime.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint1 = new Paint();
        localPaint1.setColor(0);
        localPaint1.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        localPaint1.setFlags(1);
        Paint localPaint2 = new Paint();
        localPaint2.setColor(-2147483648);
        localCanvas.drawRect(new Rect(0, 0, paramAppRuntime.getWidth(), paramAppRuntime.getHeight()), localPaint2);
        localCanvas.drawCircle(paramAppRuntime.getWidth() * 5 / 8, paramAppRuntime.getHeight() - DisplayUtil.a((Activity)paramContext, 27.0F), DisplayUtil.a((Activity)paramContext, 25.0F), localPaint1);
        ((View)localObject).setBackgroundDrawable(new BitmapDrawable(localBitmap));
        ((View)localObject).setOnClickListener(new anml(paramAppRuntime, (View)localObject));
        paramAppRuntime.addView((View)localObject);
      }
    } while (paramArticleInfo == null);
    PublicAccountReportUtils.a(null, paramArticleInfo.publishUin + "", "0X8009333", "0X8009333", 0, 0, "" + ReadInJoyUtils.e(), "" + ReadInJoyUtils.d(), paramArticleInfo.mChannelID + "", "", false);
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString)
  {
    SharedPreferences localSharedPreferences = a(paramAppRuntime, true, true);
    if (localSharedPreferences == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateArkVersion");
      return;
    }
    paramAppRuntime = paramString;
    if (paramString == null) {
      paramAppRuntime = "";
    }
    paramString = localSharedPreferences.edit();
    paramString.putString("readinjoy_ark_version", paramAppRuntime);
    a(paramString, true);
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowVideoToast");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("readinjoy_self_fragment_feedback_" + paramString1, paramString2);
    a(paramAppRuntime, true);
  }
  
  public static void b(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowRecommendReasonInTitle");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_show_recommend_reason_in_title_b", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static void b(boolean paramBoolean)
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("kd_icon_merge_biu_msg", paramBoolean);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static boolean b()
  {
    return QLog.isColorLevel();
  }
  
  public static boolean b(int paramInt)
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return false;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getBoolean("exposed_channel_bg_consumed_" + paramInt, false);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return false;
    }
    if ((a()) && (paramQQAppInterface.getBoolean("kandian_feeds", true))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean b(String paramString)
  {
    Object localObject = ReadInJoyUtils.a();
    if ((localObject == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getStringSet("kd_icon_merge_subscription_white_list", new HashSet()).contains(paramString);
  }
  
  public static boolean b(AppRuntime paramAppRuntime)
  {
    int i2 = 0;
    if (paramAppRuntime == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i1 = 4;; i1 = 0)
    {
      paramAppRuntime = String.format("readinjoy_%s_%d", new Object[] { paramAppRuntime.getAccount(), Integer.valueOf(1) });
      paramAppRuntime = BaseApplicationImpl.getApplication().getSharedPreferences(paramAppRuntime, i1);
      if (paramAppRuntime == null) {
        break;
      }
      boolean bool = paramAppRuntime.getBoolean("config_smart_crop_pic_setting", false);
      if (jdField_a_of_type_Int != -1) {
        if (!bool) {
          break label127;
        }
      }
      label127:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != jdField_a_of_type_Int)
        {
          i1 = i2;
          if (bool) {
            i1 = 1;
          }
          jdField_a_of_type_Int = i1;
          QLog.d("ReadInJoyHelper", 1, "getReadinjoySmartCropSwitch : " + bool);
        }
        return bool;
      }
    }
  }
  
  public static float c(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsShortVideoWidthHeightRatio() failed");
      return 0.0F;
    }
    float f1 = paramAppRuntime.getFloat("readinjoy_short_video_width_height_ratio", -1.0F);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoFeedsShortVideoWidthHeightRatio() result=" + f1);
    return f1;
  }
  
  public static int c(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getVideoChannelAutoPlaySwitchDefaultValueVideoFlow failed to get sp");
      return 1;
    }
    return paramAppRuntime.getInt("video_channel_auto_play_switch_video_flow", 0);
  }
  
  public static long c(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return 10L;
    }
    return paramAppRuntime.getLong("msg_info_pulse_report_y", 10L);
  }
  
  public static String c(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return "";
    }
    return paramAppRuntime.getString("readinjoy_feeds_ark_app_name", "");
  }
  
  public static List c(AppRuntime paramAppRuntime)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a(paramAppRuntime, true, true);
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      paramAppRuntime = ((SharedPreferences)localObject).getString("readinjoy_my_tab_setting" + paramAppRuntime.getAccount(), "");
      try
      {
        for (paramAppRuntime = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramAppRuntime.getBytes("utf-8"))).getElementsByTagName("configs").item(0).getFirstChild();; paramAppRuntime = paramAppRuntime.getNextSibling())
        {
          localObject = localArrayList;
          if (paramAppRuntime == null) {
            break;
          }
          if ((paramAppRuntime.getFirstChild() != null) && (TextUtils.equals(paramAppRuntime.getNodeName(), "kandiansettings"))) {
            for (localObject = paramAppRuntime.getFirstChild(); localObject != null; localObject = ((Node)localObject).getNextSibling()) {
              if ((((Node)localObject).getNodeType() == 1) && (TextUtils.equals("operatingsettings", ((Node)localObject).getNodeName()))) {
                for (Node localNode = ((Node)localObject).getFirstChild(); localNode != null; localNode = localNode.getNextSibling()) {
                  if (localNode.getNodeType() == 1) {
                    localArrayList.add(a(localNode));
                  }
                }
              }
            }
          }
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramAppRuntime)
      {
        localObject = localArrayList;
      }
    }
    QLog.d("ReadInJoyHelper", 2, "exception occurs", paramAppRuntime);
    return localArrayList;
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    jdField_b_of_type_Boolean = c(paramQQAppInterface);
    QLog.d("SPLASH_ConfigServlet", 1, "ReadinjooyStopFunctionSwitch config:" + jdField_b_of_type_Boolean);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putBoolean("config_smart_crop_pic_setting", "1".equals(paramString));
    a(paramQQAppInterface, true);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = a(paramQQAppInterface, true, true);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putBoolean("config_readinjoy_interested_push_switch", paramBoolean);
    a(paramQQAppInterface, true);
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
    a(paramString, true);
  }
  
  public static void c(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {}
    do
    {
      return;
      String str = paramAppRuntime.getString("readinjoy_social_weburl_homepage", "");
      if (!TextUtils.isEmpty(str)) {
        ReadInJoyConstants.jdField_f_of_type_JavaLangString = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_messagebox_V3", "");
      if (!TextUtils.isEmpty(str)) {
        ReadInJoyConstants.jdField_c_of_type_JavaLangString = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_collectbox", "");
      if (!TextUtils.isEmpty(str)) {
        ReadInJoyConstants.n = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_messagebox_pendant_V3", "");
      if (!TextUtils.isEmpty(str)) {
        ReadInJoyConstants.jdField_g_of_type_JavaLangString = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_commentpage", "");
      if (!TextUtils.isEmpty(str)) {
        ReadInJoyConstants.jdField_d_of_type_JavaLangString = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_recommend_friends", "");
      if (!TextUtils.isEmpty(str)) {
        ReadInJoyConstants.jdField_e_of_type_JavaLangString = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_accountpage", "");
      if (!TextUtils.isEmpty(str)) {
        ReadInJoyConstants.i = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_mytopic", "");
      if (!TextUtils.isEmpty(str)) {
        ReadInJoyConstants.m = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_myhistory", "");
      if (!TextUtils.isEmpty(str)) {
        ReadInJoyConstants.l = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_myfollow", "");
      if (!TextUtils.isEmpty(str)) {
        ReadInJoyConstants.p = str;
      }
      str = paramAppRuntime.getString("readinjoy_social_weburl_myfans", "");
      if (!TextUtils.isEmpty(str)) {
        ReadInJoyConstants.q = str;
      }
      paramAppRuntime = paramAppRuntime.getString("readinjoy_social_weburl_mynotify", "");
    } while (TextUtils.isEmpty(paramAppRuntime));
    ReadInJoyConstants.o = paramAppRuntime;
  }
  
  public static void c(AppRuntime paramAppRuntime, float paramFloat)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsShortVideoWidthHeightRatio() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsShortVideoWidthHeightRatio() value=" + paramFloat);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putFloat("readinjoy_short_video_width_height_ratio", paramFloat);
    a(paramAppRuntime, true);
  }
  
  public static void c(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateVideoChannelAutoPlaySwitchDefaultValueVideoFlow failed to update sp");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_channel_auto_play_switch_video_flow", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void c(AppRuntime paramAppRuntime, Context paramContext, ArticleInfo paramArticleInfo)
  {
    Object localObject = a(paramAppRuntime, true, true);
    if (localObject == null) {
      QLog.d("ReadInJoyHelper", 1, "showGuideViews3() failed");
    }
    do
    {
      do
      {
        return;
        if (!((SharedPreferences)localObject).getBoolean("read_in_joy_follow_diandian_guide_view" + paramAppRuntime.getAccount(), false)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ReadInJoyHelper", 2, "is already show diandian guide views");
      return;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("read_in_joy_follow_diandian_guide_view" + paramAppRuntime.getAccount(), true);
      a((SharedPreferences.Editor)localObject, true);
      paramAppRuntime = new ReadInJoyNotifyDialog(paramContext);
      paramAppRuntime.a(new anmm(paramAppRuntime));
      paramAppRuntime.show();
    } while (paramArticleInfo == null);
    PublicAccountReportUtils.a(null, paramArticleInfo.publishUin + "", "0X8009333", "0X8009333", 0, 0, "" + ReadInJoyUtils.e(), "" + ReadInJoyUtils.d(), paramArticleInfo.mChannelID + "", "", false);
  }
  
  public static void c(AppRuntime paramAppRuntime, String paramString)
  {
    SharedPreferences localSharedPreferences = a(paramAppRuntime, true, true);
    if (localSharedPreferences == null) {
      QLog.d("ReadInJoyHelper", 1, "failed to setReadInJoyFeedsArkAppName.");
    }
    do
    {
      return;
      paramAppRuntime = paramString;
      if (paramString == null) {
        paramAppRuntime = "";
      }
      paramString = localSharedPreferences.edit();
      paramString.putString("readinjoy_feeds_ark_app_name", paramAppRuntime);
      a(paramString, true);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyHelper", 2, new Object[] { "update arkAppName: ", paramAppRuntime });
  }
  
  public static void c(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp READINJOY_SIMPLE_SWITCH_FM");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("READINJOY_SIMPLE_SWITCH_FM", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static void c(boolean paramBoolean)
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("kd_icon_merge_interactive_msg", paramBoolean);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static boolean c()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    return false;
  }
  
  public static boolean c(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to get sp IndividualPushSwitch");
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_individual_push_switch", false);
  }
  
  public static int d(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getReadInJoyVideoJumpDefaultValue failed to get sp");
      return 0;
    }
    return paramAppRuntime.getInt("readinjoy_video_jump_default_value", 0);
  }
  
  public static long d(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return 10L;
    }
    return paramAppRuntime.getLong("msg_info_pulse_report_z", 10L);
  }
  
  public static String d(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return "";
    }
    return paramAppRuntime.getString("readinjoy_feeds_ark_app_min_version", "");
  }
  
  public static void d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putBoolean("video_structmsg_play_switch", paramBoolean);
    paramQQAppInterface.commit();
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
    a(paramString, true);
  }
  
  public static void d(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {}
    do
    {
      return;
      String str = paramAppRuntime.getString("readinjoy_self_fragment_feedback_feedsbackName", "");
      if (!TextUtils.isEmpty(str)) {
        ReadInJoyConstants.j = str;
      }
      str = paramAppRuntime.getString("readinjoy_self_fragment_feedback_feedsbackSwitch", "");
      if ((!TextUtils.isEmpty(str)) && (TextUtils.equals(str, "1"))) {
        ReadInJoyConstants.jdField_a_of_type_Boolean = true;
      }
      paramAppRuntime = paramAppRuntime.getString("readinjoy_self_fragment_feedback_feedsbackWebUrl", "");
    } while (TextUtils.isEmpty(paramAppRuntime));
    ReadInJoyConstants.k = paramAppRuntime;
  }
  
  public static void d(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateReadInJoyVideoJumpDefaultValue failed to update sp");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("readinjoy_video_jump_default_value", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void d(AppRuntime paramAppRuntime, Context paramContext, ArticleInfo paramArticleInfo)
  {
    if ((paramContext instanceof ReadInJoyNewFeedsActivity))
    {
      if ((((ReadInJoyNewFeedsActivity)paramContext).a() instanceof ReadInJoyFollowFragment))
      {
        c(paramAppRuntime, paramContext, paramArticleInfo);
        return;
      }
      b(paramAppRuntime, paramContext, paramArticleInfo);
      return;
    }
    if (((Activity)paramContext instanceof PublicFragmentActivity))
    {
      c(paramAppRuntime, paramContext, paramArticleInfo);
      return;
    }
    a(paramAppRuntime, paramContext, paramArticleInfo);
  }
  
  public static void d(AppRuntime paramAppRuntime, String paramString)
  {
    SharedPreferences localSharedPreferences = a(paramAppRuntime, true, true);
    if (localSharedPreferences == null) {
      QLog.d("ReadInJoyHelper", 1, "failed to setReadInJoyFeedsArkAppMinVersion.");
    }
    do
    {
      return;
      paramAppRuntime = paramString;
      if (paramString == null) {
        paramAppRuntime = "";
      }
      paramString = localSharedPreferences.edit();
      paramString.putString("readinjoy_feeds_ark_app_min_version", paramAppRuntime);
      a(paramString, true);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyHelper", 2, new Object[] { "update arkAppMinVersion: ", paramAppRuntime });
  }
  
  public static void d(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp subscribe list push config ");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_subscribe_list_push", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static void d(boolean paramBoolean)
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("proteus_enable", paramBoolean);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static boolean d()
  {
    int i2 = 0;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, new Object[] { "app is null, isShowKandianTabNew, isShowKandian = ", Integer.valueOf(0) });
      return false;
    }
    SharedPreferences localSharedPreferences;
    if (a("local_kd_tab_switch") == null)
    {
      localSharedPreferences = a(localAppRuntime, true, true);
      if (localSharedPreferences == null) {
        break label184;
      }
    }
    label184:
    for (boolean bool = localSharedPreferences.getBoolean("local_kd_tab_switch", false);; bool = false)
    {
      int i1;
      if (bool)
      {
        i1 = 1;
        a("local_kd_tab_switch", Integer.valueOf(i1));
        QLog.d("ReadInJoyHelper", 2, "isShowKandianTabNew cache is null, read from sp, " + localAppRuntime.getAccount());
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          i1 = i2;
          if (bool) {
            i1 = 1;
          }
          QLog.d("ReadInJoyHelper", 2, new Object[] { "isShowKandianTab, isShowKandian = ", Integer.valueOf(i1) });
        }
        return bool;
        i1 = 0;
        break;
        if (a("local_kd_tab_switch").intValue() == 1) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("hot_shortvideo_multi_video_support", true);
  }
  
  public static boolean d(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_show_recommend_reason_in_title_b", false);
  }
  
  public static int e(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "getCUKingCardDlgSwitch failed to get sp");
      return 1;
    }
    return paramAppRuntime.getInt("CUKingCard_dlg_enable_switch", 1);
  }
  
  public static String e(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "checkLastScanTTDate() failed");
      return null;
    }
    return paramAppRuntime.getString("KANDIAN_LAST_SCAN_TT_DATE", "");
  }
  
  public static void e(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putBoolean("shortvideo_play_troop_switch", paramBoolean);
    paramQQAppInterface.commit();
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
    a(paramString, true);
  }
  
  public static void e(AppRuntime paramAppRuntime)
  {
    jdField_c_of_type_Boolean = true;
  }
  
  public static void e(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateCUKingCardDlgSwitch failed to update sp");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("CUKingCard_dlg_enable_switch", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void e(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if ((paramAppRuntime == null) || (paramString == null)) {}
    do
    {
      return;
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putBoolean("readinjoy_ark_app_show_setting", paramString.equals("1"));
      a(paramAppRuntime, true);
      if (ReadInJoyArkUtil.a == null) {
        ReadInJoyArkUtil.a = new AtomicBoolean();
      }
      ReadInJoyArkUtil.a.set(paramString.equals("1"));
    } while (!paramString.equals("1"));
    ReadInJoyArkUtil.a();
  }
  
  public static void e(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowVideoToast");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_show_video_toast", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean e()
  {
    int i2 = 0;
    boolean bool;
    int i1;
    if (f())
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime == null)
      {
        QLog.d("ReadInJoyHelper", 1, new Object[] { "app is null, isShowMainVideoTabNew, isShowMainVideo = ", Integer.valueOf(0) });
        return false;
      }
      if (a("local_kd_tab_type") == null)
      {
        Object localObject = a(localAppRuntime, true, true);
        if (localObject == null) {
          break label212;
        }
        localObject = ((SharedPreferences)localObject).getString("local_kd_tab_type", "1");
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals("0"))) {
          break label212;
        }
        bool = true;
        if (bool)
        {
          i1 = 0;
          label107:
          a("local_kd_tab_type", Integer.valueOf(i1));
          QLog.d("ReadInJoyHelper", 2, "isShowMainVideoTabNew cache is null, read from sp, " + localAppRuntime.getAccount());
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        i1 = i2;
        if (bool) {
          i1 = 1;
        }
        QLog.d("ReadInJoyHelper", 2, new Object[] { "isShowMainVideoTabNew, isShowMainVideo = ", Integer.valueOf(i1) });
      }
      return bool;
      i1 = 1;
      break label107;
      if (a("local_kd_tab_type").intValue() == 0)
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        label212:
        bool = false;
        break;
        bool = false;
      }
    }
  }
  
  public static boolean e(QQAppInterface paramQQAppInterface)
  {
    return true;
  }
  
  public static boolean e(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to get sp ReadInJoy ark app show setting.");
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_ark_app_show_setting", false);
  }
  
  public static int f(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return 0;
    }
    return paramAppRuntime.getInt("readinjoy_video_videoinfo_anim_viewtop", 0);
  }
  
  public static String f(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigBiuFeedsName() failed");
      return null;
    }
    if (!TextUtils.isEmpty(jdField_c_of_type_JavaLangString)) {
      return jdField_c_of_type_JavaLangString;
    }
    jdField_c_of_type_JavaLangString = paramAppRuntime.getString("kandian_biu_feeds_name", "好友Biu的内容");
    return jdField_c_of_type_JavaLangString;
  }
  
  public static void f(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putBoolean("shortvideo_play_nontroop_switch", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static void f(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateInnerVideoInfoShowSwitcher");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("readinjoy_video_videoinfo_anim_viewtop", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void f(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "setLastScanTTDate() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("KANDIAN_LAST_SCAN_TT_DATE", paramString);
    a(paramAppRuntime, true);
  }
  
  public static void f(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateVideoPreDownloadSwitcher");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_video_predownload_switch", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean f()
  {
    int i1 = L(ReadInJoyUtils.a());
    Object localObject;
    if (i1 != -1)
    {
      a(ReadInJoyUtils.a(), "local_kd_tab_has_set", Boolean.valueOf(true));
      localObject = ReadInJoyUtils.a();
      if (i1 != 1) {
        break label92;
      }
    }
    label92:
    for (boolean bool = true;; bool = false)
    {
      a((AppRuntime)localObject, "local_kd_tab_switch", Boolean.valueOf(bool));
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      localObject = a(ReadInJoyUtils.a(), true, true);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).remove("user_kandian_show_config");
        a((SharedPreferences.Editor)localObject, true);
      }
      return d();
    }
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return false;
    }
    if (paramQQAppInterface.getInt("readinjoy_config_push_msg_switch", 1) == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean f(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, false);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to get sp subscribe list push config ");
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_subscribe_list_push", false);
  }
  
  public static int g(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsAdConfigLocal() failed");
      return 60;
    }
    int i1 = paramAppRuntime.getInt("camera_capture_max_duration", 60);
    QLog.d("Q.readinjoy.video", 1, "getCameraCaptureMaxDuration() result=" + i1);
    return i1;
  }
  
  public static String g(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigBiuFeedsWebUrl() failed");
      return null;
    }
    if (!TextUtils.isEmpty(jdField_d_of_type_JavaLangString)) {
      return jdField_d_of_type_JavaLangString;
    }
    jdField_d_of_type_JavaLangString = paramAppRuntime.getString("kandian_biu_feeds_web_url", ReadInJoyConstants.h);
    return jdField_d_of_type_JavaLangString;
  }
  
  public static void g(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateCameraCaptureMaxDuration() failed");
      return;
    }
    QLog.d("Q.readinjoy.video", 1, "updateCameraCaptureMaxDuration() value=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("camera_capture_max_duration", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void g(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
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
    a(paramAppRuntime, true);
    jdField_c_of_type_JavaLangString = paramString;
  }
  
  public static void g(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      QLog.d("Q.readinjoy.video", 1, "failed to update sp KandianVideoSocialSwitch");
    }
    do
    {
      return;
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putBoolean("kandian_video_social_switch", paramBoolean);
      a(paramAppRuntime, true);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "updateKandianVideoSocialSwitch():" + paramBoolean);
  }
  
  public static boolean g()
  {
    return e();
  }
  
  public static boolean g(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("video_structmsg_play_switch", true);
  }
  
  public static boolean g(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_show_video_toast", false);
  }
  
  public static int h(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigRedShowNum() failed");
      return -1;
    }
    if (jdField_c_of_type_Int != -1) {
      return jdField_c_of_type_Int;
    }
    jdField_c_of_type_Int = paramAppRuntime.getInt("kandian_tabdot_show_num", 0);
    return jdField_c_of_type_Int;
  }
  
  public static String h(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsAdConfigFromServer() failed");
      return null;
    }
    paramAppRuntime = paramAppRuntime.getString("video_feeds_ad_config", null);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoFeedsAdConfigFromServer() result=" + paramAppRuntime);
    return paramAppRuntime;
  }
  
  public static void h(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigRedShowNum() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_tabdot_show_num", paramInt);
    a(paramAppRuntime, true);
    jdField_c_of_type_Int = paramInt;
  }
  
  public static void h(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
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
    a(paramAppRuntime, true);
    jdField_d_of_type_JavaLangString = paramString;
  }
  
  public static void h(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    int i1 = 1;
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowVideoToast");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("free_time_refresh_push", paramBoolean);
    a(paramAppRuntime, true);
    if (paramBoolean) {}
    for (;;)
    {
      jdField_b_of_type_Int = i1;
      return;
      i1 = 0;
    }
  }
  
  public static boolean h()
  {
    return (f()) && (!g());
  }
  
  public static boolean h(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("shortvideo_play_troop_switch", true);
  }
  
  public static boolean h(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_video_predownload_switch", true);
  }
  
  public static int i(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigRedThreshold() failed");
      return -1;
    }
    if (jdField_d_of_type_Int != -1) {
      return jdField_d_of_type_Int;
    }
    jdField_d_of_type_Int = paramAppRuntime.getInt("kandian_tabdot_threshold", 0);
    return jdField_d_of_type_Int;
  }
  
  public static String i(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsAdConfigLocal() failed");
      return null;
    }
    paramAppRuntime = paramAppRuntime.getString("video_feeds_ad_local_config", null);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoFeedsAdConfigLocal() result=" + paramAppRuntime);
    return paramAppRuntime;
  }
  
  public static void i(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigRedThreshold() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_tabdot_threshold", paramInt);
    a(paramAppRuntime, true);
    jdField_d_of_type_Int = paramInt;
  }
  
  public static void i(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuWordCount() failed");
      return;
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 <= 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuWordCount() count <= 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuWordCount() parseInt failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_biu_word_count", i1);
    a(paramAppRuntime, true);
    jdField_g_of_type_Int = i1;
  }
  
  public static void i(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "setKanDianReportTTSwitch() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("KANDIAN_REPORT_TT_SWITCH", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean i()
  {
    SharedPreferences localSharedPreferences = a(ReadInJoyUtils.a(), true, true);
    if (localSharedPreferences == null) {
      return false;
    }
    return localSharedPreferences.getBoolean("sp_key_readinjoy_magic_switch", false);
  }
  
  public static boolean i(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("shortvideo_play_nontroop_switch", true);
  }
  
  public static boolean i(AppRuntime paramAppRuntime)
  {
    boolean bool1 = false;
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      QLog.d("Q.readinjoy.video", 1, "failed to update sp KandianVideoSocialSwitchSwitch");
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = paramAppRuntime.getBoolean("kandian_video_social_switch", false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "getKandianVideoSocialSwitch():" + bool2);
    return bool2;
  }
  
  public static int j(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianLocalRedShowNum() failed");
      return -1;
    }
    if (jdField_e_of_type_Int != -1) {
      return jdField_e_of_type_Int;
    }
    jdField_e_of_type_Int = paramAppRuntime.getInt("kandian_tabdot_has_show_num", 0);
    return jdField_e_of_type_Int;
  }
  
  public static String j(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsInterruptedAdfigFromServer() failed");
      return null;
    }
    paramAppRuntime = paramAppRuntime.getString("VIDEO_FEEDS_INTERRUPTED_AD_CONFIG", null);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoFeedsInterruptedAdfigFromServer() result=" + paramAppRuntime);
    return paramAppRuntime;
  }
  
  public static void j(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianLocalRedShowNum() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_tabdot_has_show_num", paramInt);
    a(paramAppRuntime, true);
    jdField_e_of_type_Int = paramInt;
  }
  
  public static void j(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentWordCount() failed");
      return;
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 <= 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentWordCount() count <= 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentWordCount() parseInt failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_comment_word_count", i1);
    a(paramAppRuntime, true);
    h = i1;
  }
  
  public static void j(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianSelfForbidden() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("kandian_user_forbidden", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean j()
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return false;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getBoolean("kd_icon_merge_biu_msg", false);
  }
  
  public static boolean j(AppRuntime paramAppRuntime)
  {
    if (jdField_b_of_type_Int == -1) {
      ThreadManager.post(new anmj(paramAppRuntime), 8, null, true);
    }
    while (jdField_b_of_type_Int == 1) {
      return true;
    }
    return false;
  }
  
  public static int k(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigBiuFeedsSwitch() failed");
      return -1;
    }
    if (jdField_f_of_type_Int != -1) {
      return jdField_f_of_type_Int;
    }
    jdField_f_of_type_Int = paramAppRuntime.getInt("kandian_biu_feeds_switch", 0);
    return jdField_f_of_type_Int;
  }
  
  public static String k(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getVideoFeedsInterruptedAdConfigLocal() failed");
      return null;
    }
    paramAppRuntime = paramAppRuntime.getString("VIDEO_FEEDS_INTERRUPTED_AD_LOCAL_CONFIG", null);
    QLog.d("Q.readinjoy.tt_report", 1, "getVideoFeedsInterruptedAdConfigLocal() result=" + paramAppRuntime);
    return paramAppRuntime;
  }
  
  public static void k(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuFeedsSwitch() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_biu_feeds_switch", paramInt);
    a(paramAppRuntime, true);
    jdField_f_of_type_Int = paramInt;
  }
  
  public static void k(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentGifSwitch() failed");
      return;
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentGifSwitch() gifSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentGifSwitch() parseInt failed");
      return;
    }
    if (i1 > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentGifSwitch() gifSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_comment_gif_switch", i1);
    a(paramAppRuntime, true);
    i = i1;
  }
  
  public static void k(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianMsgStickFlag() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean(jdField_g_of_type_JavaLangString, paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean k()
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return false;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getBoolean("kd_icon_merge_interactive_msg", false);
  }
  
  public static boolean k(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKanDianReportTTSwitch() failed");
      return false;
    }
    return paramAppRuntime.getBoolean("KANDIAN_REPORT_TT_SWITCH", false);
  }
  
  public static int l(AppRuntime paramAppRuntime)
  {
    if (jdField_g_of_type_Int > 0) {
      return jdField_g_of_type_Int;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigBiuWordCount() failed");
      return ReadInJoyConstants.jdField_a_of_type_Int;
    }
    jdField_g_of_type_Int = paramAppRuntime.getInt("kandian_biu_word_count", ReadInJoyConstants.jdField_a_of_type_Int);
    return jdField_g_of_type_Int;
  }
  
  public static String l(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return null;
    }
    return paramAppRuntime.getString("native_engine_timeout_config", null);
  }
  
  public static void l(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianNewChannelStyle() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt(jdField_a_of_type_JavaLangString, paramInt);
    a(paramAppRuntime, true);
    w = paramInt;
  }
  
  public static void l(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUGCGifSwitch() failed");
      return;
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUGCGifSwitch() gifSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUGCGifSwitch() parseInt failed");
      return;
    }
    if (i1 > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUGCGifSwitch() gifSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_ugc_gif_switch", i1);
    a(paramAppRuntime, true);
    j = i1;
  }
  
  public static void l(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateVideoTabFakeReddotErasureByUser() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("videotab_fake_reddot_erasure_by_user", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean l()
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {}
    do
    {
      return true;
      localObject = a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getBoolean("proteus_local_switch", true);
  }
  
  public static boolean l(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getWebRenderConfig() failed");
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("web_native_render", false);
    QLog.d("Q.readinjoy.tt_report", 1, "getWebRenderConfig() result=" + bool);
    return bool;
  }
  
  public static int m(AppRuntime paramAppRuntime)
  {
    if (h > 0) {
      return h;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigCommentWordCount() failed");
      return ReadInJoyConstants.jdField_b_of_type_Int;
    }
    h = paramAppRuntime.getInt("kandian_comment_word_count", ReadInJoyConstants.jdField_b_of_type_Int);
    return h;
  }
  
  public static void m(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoChannelCoverStyle() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_channel_cover_style", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void m(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentZhituSwitch() failed");
      return;
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentZhituSwitch() zhituSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentZhituSwitch() zhituSwitch failed");
      return;
    }
    if (i1 > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentZhituSwitch() zhituSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_comment_zhitu_switch", i1);
    a(paramAppRuntime, true);
    k = i1;
  }
  
  public static void m(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateWebCgiPreloadSwitch() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("kandianWebPreLoadData", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean m(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "getCanLoadStartWebRenderModeConfig() failed");
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("web_native_render_mode_start", false);
    QLog.d("Q.readinjoy.tt_report", 1, "getCanLoadStartWebRenderModeConfig() result=" + bool);
    return bool;
  }
  
  public static int n(AppRuntime paramAppRuntime)
  {
    if ((i == 0) || (i == 1)) {
      return i;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigCommentGifSwitch() failed");
      return 0;
    }
    i = paramAppRuntime.getInt("kandian_comment_gif_switch", 0);
    return i;
  }
  
  public static void n(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateMultiVideoDynamicRecommmendStrategy() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateMultiVideoDynamicRecommmendStrategy() num=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("multi_video_dynamic_recommend_strategyid", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void n(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUgcAtSwitch() failed");
      return;
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUgcAtSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUgcAtSwitch() parseInt failed");
      return;
    }
    if (i1 > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigUgcAtSwitch() atSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_ugc_at_switch", i1);
    a(paramAppRuntime, true);
    l = i1;
  }
  
  public static void n(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("nw_support", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean n(AppRuntime paramAppRuntime)
  {
    Object localObject = Calendar.getInstance();
    int i1 = ((Calendar)localObject).get(1);
    int i2 = ((Calendar)localObject).get(2);
    int i3 = ((Calendar)localObject).get(5);
    localObject = i1 + i2 + i3;
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "checkIsVideoFeedsAdLocalConfigToday() failed");
      return false;
    }
    String str = paramAppRuntime.getString("video_feeds_ad_local_config_data", null);
    QLog.d("Q.readinjoy.tt_report", 1, "checkIsVideoFeedsAdLocalConfigToday localDate = " + str);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str))) {
      return true;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("video_feeds_ad_local_config_data", (String)localObject);
    a(paramAppRuntime, true);
    return false;
  }
  
  public static int o(AppRuntime paramAppRuntime)
  {
    if ((k == 0) || (k == 1)) {
      return k;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigCommentZhituSwitch() failed");
      return 0;
    }
    k = paramAppRuntime.getInt("kandian_comment_zhitu_switch", 0);
    return k;
  }
  
  public static void o(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateMultiVideoDynamicRecommmendDurationLimit() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateMultiVideoDynamicRecommmendDurationLimit() num=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("multi_video_dynamic_recommend_duration_limit", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void o(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuAtSwitch() failed");
      return;
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuAtSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuAtSwitch() parseInt failed");
      return;
    }
    if (i1 > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuAtSwitch() atSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_biu_at_switch", i1);
    a(paramAppRuntime, true);
    m = i1;
  }
  
  public static void o(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("nw_preload", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean o(AppRuntime paramAppRuntime)
  {
    Object localObject = Calendar.getInstance();
    int i1 = ((Calendar)localObject).get(1);
    int i2 = ((Calendar)localObject).get(2);
    int i3 = ((Calendar)localObject).get(5);
    localObject = i1 + i2 + i3;
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "checkIsVideoFeedsInterruptedAdLocalConfigToday() failed");
      return false;
    }
    String str = paramAppRuntime.getString("VIDEO_FEEDS_INTERRUPTED_AD_LOCAL_CONFIG_DATE", null);
    QLog.d("Q.readinjoy.tt_report", 1, "checkIsVideoFeedsInterruptedAdLocalConfigToday localDate = " + str);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str))) {
      return true;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_INTERRUPTED_AD_LOCAL_CONFIG_DATE", (String)localObject);
    a(paramAppRuntime, true);
    return false;
  }
  
  public static int p(AppRuntime paramAppRuntime)
  {
    if ((j == 0) || (j == 1)) {
      return j;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianUGCCommentGifSwitch() failed");
      return 0;
    }
    j = paramAppRuntime.getInt("kandian_ugc_gif_switch", 0);
    return j;
  }
  
  public static void p(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateMultiVideoDynamicRecommendOperator() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateMultiVideoDynamicRecommendOperator() num=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("multi_video_dynamic_recommend_operator", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void p(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuProfileAtSwitch() failed");
      return;
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuProfileAtSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuProfileAtSwitch() parseInt failed");
      return;
    }
    if (i1 > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBiuProfileAtSwitch() atSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_biu_profile_at_switch", i1);
    a(paramAppRuntime, true);
    n = i1;
  }
  
  public static void p(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("exposure_strengthen", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean p(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianMsgStickFlag() failed");
      return false;
    }
    return paramAppRuntime.getBoolean(jdField_g_of_type_JavaLangString, false);
  }
  
  public static int q(AppRuntime paramAppRuntime)
  {
    if ((l == 0) || (l == 1)) {
      return l;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigUgcAtSwitch() failed");
      return 0;
    }
    l = paramAppRuntime.getInt("kandian_ugc_at_switch", 0);
    return l;
  }
  
  public static void q(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoDynamicRecommmendStrategy() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoDynamicRecommmendStrategy() num=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_dynamic_recommend_strategyid", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void q(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateDianDianConfigRightButtonAtSwitch() failed");
      return;
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateDianDianConfigRightButtonAtSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateDianDianConfigRightButtonAtSwitch()parseInt failed");
      return;
    }
    if (i1 > 3)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateDianDianConfigRightButtonAtSwitch() atSwitch > 4");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("diandian_right_button_at_switch", i1);
    a(paramAppRuntime, true);
  }
  
  private static void q(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    QLog.d("ReadInJoyHelper", 2, "updateShowKandianTab show  " + paramBoolean);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateShowKandianTab() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("show_kandian_main_video_sp", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean q(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("kandianWebPreLoadData", false);
  }
  
  public static int r(AppRuntime paramAppRuntime)
  {
    if ((m == 0) || (m == 1)) {
      return m;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigBiuAtSwitch() failed");
      return 0;
    }
    m = paramAppRuntime.getInt("kandian_biu_at_switch", 0);
    return m;
  }
  
  public static void r(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoDynamicRecommmendDurationLimit() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoDynamicRecommmendDurationLimit() num=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_dynamic_recommend_duration_limit", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void r(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "update readinjoy to wx switch failed");
      return;
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateReadInjoyToWxAtSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateDianDianConfigRightButtonAtSwitch()parseInt failed");
      return;
    }
    if (i1 > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, " updateReadInjoyToWxAtSwitch() atSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("readinjoy_share_to_WX_at_switch", i1);
    a(paramAppRuntime, true);
    o = i1;
  }
  
  private static void r(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    int i1 = 0;
    Object localObject = a(paramAppRuntime, true, true);
    QLog.d("ReadInJoyHelper", 2, "updateShowKandianTab show  " + paramBoolean);
    if (localObject == null)
    {
      QLog.d("ReadInJoyHelper", 2, "updateShowKandianTab() failed");
      return;
    }
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    localEditor.putBoolean("show_kandian_in_main_frame_sp", paramBoolean);
    int i2 = ((SharedPreferences)localObject).getInt("kandian_tab_switch_config_received_cnt", 0);
    QLog.d("ReadInJoyHelper", 2, "receiveKandiantTabConfig cnt : " + i2);
    if (paramBoolean)
    {
      i2 += 1;
      localEditor.putInt("kandian_tab_switch_config_received_cnt", i2);
      localObject = jdField_b_of_type_JavaUtilMap;
      paramAppRuntime = paramAppRuntime.getAccount();
      if (i2 == 1) {
        ((Map)localObject).put(paramAppRuntime, Integer.valueOf(i1));
      }
    }
    for (;;)
    {
      a(localEditor, true);
      return;
      i1 = i2;
      break;
      localEditor.remove("kandian_tab_switch_config_received_cnt");
      if (i2 != 1) {
        jdField_b_of_type_JavaUtilMap.put(paramAppRuntime.getAccount(), Integer.valueOf(i2));
      }
    }
  }
  
  public static boolean r(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("nw_support", false);
  }
  
  public static int s(AppRuntime paramAppRuntime)
  {
    if ((n == 0) || (n == 1)) {
      return n;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigBiuProfileAtSwitch() failed");
      return 0;
    }
    n = paramAppRuntime.getInt("kandian_biu_profile_at_switch", 0);
    return n;
  }
  
  public static void s(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoDynamicRecommendOperator() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoDynamicRecommendOperator() num=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("video_dynamic_recommend_operator", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void s(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentBiuSwitch() failed");
      return;
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentBiuSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentBiuSwitch() parseInt failed");
      return;
    }
    if (i1 > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentBiuSwitch() atSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_comment_biu_switch", i1);
    a(paramAppRuntime, true);
    p = i1;
  }
  
  public static boolean s(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("nw_preload", false);
  }
  
  public static int t(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getDianDianConfigRightButtonAtSwitch() failed");
      return 0;
    }
    return paramAppRuntime.getInt("diandian_right_button_at_switch", 0);
  }
  
  public static void t(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateWebRenderConfig() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateWebRenderConfig() value=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramAppRuntime.putBoolean("web_native_render", bool);
      a(paramAppRuntime, true);
      return;
    }
  }
  
  public static void t(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigNativeCommentBiuSwitch() failed");
      return;
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigNativeCommentBiuSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigNativeCommentBiuSwitch() parseInt failed");
      return;
    }
    if (i1 > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigNativeCommentBiuSwitch() atSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_native_comment_biu_switch", i1);
    a(paramAppRuntime, true);
    q = i1;
  }
  
  public static boolean t(AppRuntime paramAppRuntime)
  {
    return jdField_c_of_type_Boolean;
  }
  
  public static int u(AppRuntime paramAppRuntime)
  {
    if ((o == 0) || (o == 1)) {
      return o;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getReadInjoyShareToWxAtSwitch() failed");
      return 0;
    }
    o = paramAppRuntime.getInt("readinjoy_share_to_WX_at_switch", 0);
    return o;
  }
  
  public static void u(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateWebRenderModeConfig() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateWebRenderModeConfig() value=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramAppRuntime.putBoolean("web_native_render_mode_start", bool);
      a(paramAppRuntime, true);
      return;
    }
  }
  
  public static void u(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentAtSwitch() failed");
      return;
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 < 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentAtSwitch() atSwitch < 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentAtSwitch() parseInt failed");
      return;
    }
    if (i1 > 1)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigCommentAtSwitch() atSwitch > 1");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_comment_at_switch", i1);
    a(paramAppRuntime, true);
    r = i1;
  }
  
  public static boolean u(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("exposure_strengthen", true);
  }
  
  public static int v(AppRuntime paramAppRuntime)
  {
    if ((p == 0) || (p == 1)) {
      return p;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigCommentBiuSwitch() failed");
      return 0;
    }
    p = paramAppRuntime.getInt("kandian_comment_biu_switch", 0);
    return p;
  }
  
  public static void v(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsShortVideoMaxDrationLimit() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsShortVideoMaxDrationLimit() value=" + paramInt);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("readinjoy_short_video_max_duration_limit", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void v(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigDefaultBitRate() failed");
      return;
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 <= 0)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigDefaultBitRate() bitrate <= 0");
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigDefaultBitRate() parseInt failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_default_bit_rate", i1);
    a(paramAppRuntime, true);
    s = i1;
  }
  
  public static boolean v(AppRuntime paramAppRuntime)
  {
    boolean bool = true;
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "is_show_weishi_entrance: sp is null");
      return false;
    }
    int i1 = paramAppRuntime.getInt("is_show_weishi_entrance", 0);
    QLog.d("ReadInJoyHelper", 2, "get_is_show_weishi_entrance : " + i1);
    if (i1 == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static int w(AppRuntime paramAppRuntime)
  {
    if ((q == 0) || (q == 1)) {
      return q;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigNativeCommentBiuSwitch() failed");
      return 0;
    }
    q = paramAppRuntime.getInt("kandian_native_comment_biu_switch", 0);
    return q;
  }
  
  public static void w(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianConfigBadgeSwitch() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_badge_switch", paramInt);
    a(paramAppRuntime, true);
    x = paramInt;
  }
  
  public static void w(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsAdConfigFromServer() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsAdConfigFromServer() value=" + paramString);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("video_feeds_ad_config", paramString);
    a(paramAppRuntime, true);
  }
  
  public static int x(AppRuntime paramAppRuntime)
  {
    if ((r == 0) || (r == 1)) {
      return r;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigCommentAtSwitch() failed");
      return 0;
    }
    r = paramAppRuntime.getInt("kandian_comment_at_switch", 0);
    return r;
  }
  
  public static void x(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianDeleteOutDateArticleInterval failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putInt("kandian_delete_outdate_article_feeds_cnt", paramInt);
    a(paramAppRuntime, true);
  }
  
  public static void x(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject = a(paramAppRuntime, true, true);
    if (localObject == null)
    {
      QLog.d("ReadInJoyHelper", 1, "updateVideoFeedsAdConfigFromServer() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsAdConfigFromServer() value=" + paramString);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("readinjoy_my_tab_setting" + paramAppRuntime.getAccount(), paramString);
    a((SharedPreferences.Editor)localObject, true);
  }
  
  public static int y(AppRuntime paramAppRuntime)
  {
    if (s > 0) {
      return s;
    }
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "getKandianConfigDefaultBitRate() failed");
      return ReadInJoyConstants.jdField_c_of_type_Int;
    }
    s = paramAppRuntime.getInt("kandian_default_bit_rate", ReadInJoyConstants.jdField_c_of_type_Int);
    return s;
  }
  
  public static void y(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 1, "VideoFeedsPlayActivity updateVideoFeedsUserGuideShowCount() failed");
    }
    do
    {
      return;
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putInt("VIDEO_FEEDS_USER_GUIDE_SHOW_COUNT", paramInt);
      a(paramAppRuntime, true);
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "updateVideoFeedsUserGuideShowCount newCount = " + paramInt);
  }
  
  public static void y(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsAdConfigLocal() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsAdConfigLocal() value=" + paramString);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("video_feeds_ad_local_config", paramString);
    a(paramAppRuntime, true);
  }
  
  public static int z(AppRuntime paramAppRuntime)
  {
    if (v == -1)
    {
      paramAppRuntime = a(paramAppRuntime, true, true);
      if (paramAppRuntime == null)
      {
        QLog.d("Q.readinjoy.tt_report", 1, "getKandianFollowCount() failed");
        return -1;
      }
      v = paramAppRuntime.getInt("kandian_user_is_vip", -1);
    }
    return v;
  }
  
  public static void z(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 2, "increaseUgcDeliverVideoTipsShowCount: sp is null");
      return;
    }
    SharedPreferences.Editor localEditor = paramAppRuntime.edit();
    paramInt = paramAppRuntime.getInt("ugc_deliver_video_tips_show_count", 0) + paramInt;
    localEditor.putInt("ugc_deliver_video_tips_show_count", paramInt);
    a(localEditor, true);
    QLog.d("ReadInJoyHelper", 2, "increaseUgcDeliverVideoTipsShowCount: success, newCount = " + paramInt);
  }
  
  public static void z(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.video", 1, "updateVideoFeedsInterruptedAsConfigFromServer() failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "updateVideoFeedsInterruptedAsConfigFromServer() value=" + paramString);
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("VIDEO_FEEDS_INTERRUPTED_AD_CONFIG", paramString);
    a(paramAppRuntime, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.readinjoy.ReadInJoyHelper
 * JD-Core Version:    0.7.0.1
 */