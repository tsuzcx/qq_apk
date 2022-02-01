import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoySSOHandlerThread;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.1;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.10;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.11;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.15;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.18;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.19;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.2;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.21;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.22;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.23;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.24;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.25;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.3;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.4;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.5;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.6;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.7;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.8;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.SPEventReportSwitch;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.liveroom.LiveRoomProxyActivity;
import cooperation.qzone.util.NetworkState;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicEntranceInfo;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspTraceRecord;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class pay
{
  public static int a;
  public static long a;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static ReadInJoySSOHandlerThread jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread;
  public static ArticleInfo a;
  private static SosoInterface.SosoLbsInfo jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo;
  private static Integer jdField_a_of_type_JavaLangInteger;
  private static Object jdField_a_of_type_JavaLangObject;
  public static String a;
  private static final BigInteger jdField_a_of_type_JavaMathBigInteger = BigInteger.ONE.shiftLeft(64);
  public static SimpleDateFormat a;
  public static HashMap<Integer, oiy> a;
  private static List<Integer> jdField_a_of_type_JavaUtilList;
  private static Map<String, MessageForStructing> jdField_a_of_type_JavaUtilMap;
  private static Queue<Integer> jdField_a_of_type_JavaUtilQueue;
  public static final rdh a;
  public static volatile boolean a;
  public static int b;
  private static long jdField_b_of_type_Long;
  private static Handler jdField_b_of_type_AndroidOsHandler;
  public static String b;
  private static List<Integer> jdField_b_of_type_JavaUtilList;
  public static boolean b;
  public static int c;
  private static long jdField_c_of_type_Long;
  public static String c;
  private static List<Integer> jdField_c_of_type_JavaUtilList;
  public static boolean c;
  public static int d;
  private static long d;
  public static String d;
  public static boolean d;
  public static int e;
  public static String e;
  public static volatile boolean e;
  public static int f;
  private static String f;
  public static boolean f;
  public static int g;
  private static String g;
  public static boolean g;
  private static int jdField_h_of_type_Int;
  private static String jdField_h_of_type_JavaLangString;
  private static boolean jdField_h_of_type_Boolean;
  private static int jdField_i_of_type_Int;
  private static String jdField_i_of_type_JavaLangString;
  private static volatile boolean jdField_i_of_type_Boolean;
  private static int jdField_j_of_type_Int;
  private static String jdField_j_of_type_JavaLangString;
  private static volatile boolean jdField_j_of_type_Boolean;
  private static boolean k;
  private static volatile boolean l;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    jdField_c_of_type_JavaLangString = "0";
    jdField_d_of_type_JavaLangString = "1";
    jdField_e_of_type_JavaLangString = "2";
    jdField_a_of_type_Int = 7;
    jdField_c_of_type_Int = -2;
    jdField_j_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_Long = 300000L;
    jdField_e_of_type_Int = -1;
    jdField_f_of_type_JavaLangString = "";
    jdField_a_of_type_Rdh = new rdh();
    jdField_a_of_type_JavaUtilQueue = new LinkedBlockingQueue(100);
    jdField_f_of_type_Int = -1;
    jdField_j_of_type_Int = 1;
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilList = new ArrayList();
    jdField_c_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(12));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(16));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(17));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(10));
    jdField_b_of_type_JavaUtilList.add(Integer.valueOf(1));
    jdField_b_of_type_JavaUtilList.add(Integer.valueOf(5));
    jdField_b_of_type_JavaUtilList.add(Integer.valueOf(7));
    jdField_b_of_type_JavaUtilList.add(Integer.valueOf(9));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(1));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(2));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(3));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(7));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(8));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(10));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(12));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(16));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(18));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(22));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(25));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(27));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(31));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(34));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(35));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(36));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(37));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(83));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(85));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(86));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(107));
    jdField_c_of_type_JavaUtilList.add(Integer.valueOf(108));
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_h_of_type_JavaLangString = "";
    jdField_i_of_type_JavaLangString = "";
    jdField_g_of_type_Int = 0;
  }
  
  public static boolean A()
  {
    return Aladdin.getConfig(258).getIntegerFromString("tab_change_report_in_subthread", 0) == 1;
  }
  
  public static boolean A(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramBaseArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("ReadInJoyUtils", 1, "isVideoCommentBiu, flag= " + bool1);
      return bool1;
      bool1 = bool2;
      if (paramBaseArticleInfo.mFeedType == 36) {
        if (a(paramBaseArticleInfo))
        {
          bool1 = true;
        }
        else
        {
          bool1 = bool2;
          if (paramBaseArticleInfo.mSocialFeedInfo != null) {
            if ((paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 4) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 5))
            {
              bool1 = bool2;
              if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 6) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  public static boolean B()
  {
    return Aladdin.getConfig(375).getIntegerFromString("aio_kandian_video_preview_autoplay_enable", 1) == 1;
  }
  
  private static boolean B(BaseArticleInfo paramBaseArticleInfo)
  {
    int m;
    if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer != null))
    {
      m = 1;
      if ((!a((ArticleInfo)paramBaseArticleInfo)) && (!pgb.g(paramBaseArticleInfo)) && (!pgb.i((ArticleInfo)paramBaseArticleInfo)) && (!pgb.j((ArticleInfo)paramBaseArticleInfo)) && (!pgb.k((ArticleInfo)paramBaseArticleInfo))) {
        break label83;
      }
    }
    label83:
    for (int n = 1;; n = 0)
    {
      if ((m == 0) || (n == 0)) {
        break label88;
      }
      return true;
      m = 0;
      break;
    }
    label88:
    return false;
  }
  
  private static boolean C(BaseArticleInfo paramBaseArticleInfo)
  {
    return (qxf.a((ArticleInfo)paramBaseArticleInfo) == 3) || (pgb.a((ArticleInfo)paramBaseArticleInfo)) || (pgb.i(paramBaseArticleInfo)) || (pgb.n((ArticleInfo)paramBaseArticleInfo)) || (s(paramBaseArticleInfo)) || (paramBaseArticleInfo.isPGCShortContent()) || (paramBaseArticleInfo.isAccountShown) || (paramBaseArticleInfo.mKdLiveInfo != null);
  }
  
  public static int a()
  {
    if (a() == null) {
      return -1;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    try
    {
      localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((Conversation)localObject1).a().b();
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData))
        {
          localArrayList.add((RecentBaseData)localObject2);
          continue;
          return -1;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      int m = 0;
      while (m < localException.size())
      {
        localObject1 = (RecentBaseData)localException.get(m);
        if (localObject1 != null)
        {
          boolean bool = TextUtils.equals(((RecentUserBaseData)localObject1).getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN);
          if (bool) {
            return m;
          }
        }
        m += 1;
      }
    }
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 3;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  public static int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramInt2 != 0))
    {
      if (paramInt1 + 1 == paramInt2) {
        return 1;
      }
      return 0;
    }
    return -1;
  }
  
  public static int a(Context paramContext)
  {
    int n = NetworkUtil.getSystemNetwork(paramContext);
    int m;
    if (n >= 1)
    {
      m = n;
      if (n <= 4) {}
    }
    else
    {
      m = 5;
    }
    return m;
  }
  
  public static int a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return 0;
    }
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn != null))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn.jdField_a_of_type_Boolean) {
        return 4;
      }
      return 2;
    }
    if (paramArticleInfo.isSuperTopic) {
      return 1;
    }
    return 3;
  }
  
  public static int a(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn == null) || ((!paramBoolean) && (paramArticleInfo.mFeedType != 21) && (paramArticleInfo.mFeedType != 22)) || ((paramBoolean) && (!o(paramArticleInfo)))) {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyUtils", 1, "something is null.");
      }
    }
    do
    {
      return 7;
      if ((paramBoolean) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_Int == 3)) {
        return 75;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_Int == 3) {
        return 74;
      }
      if ((paramBoolean) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_Int == 4)) {
        return 73;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_Int == 4) {
        return 72;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ReadInJoyUtils", 1, "error ugcFeedsSrc = " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_Int);
    return 7;
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    int n = pgb.a((ArticleInfo)paramBaseArticleInfo);
    ozx localozx = new ozx(paramBaseArticleInfo);
    int m = localozx.a(n, 0);
    if (qxf.a((ArticleInfo)paramBaseArticleInfo) == 3) {
      m = localozx.b(n, m);
    }
    for (;;)
    {
      m = localozx.a(paramBaseArticleInfo, m);
      if (paramBaseArticleInfo.isTwoItem) {
        m = 43;
      }
      if (rcv.b(paramBaseArticleInfo)) {
        m = 69;
      }
      n = localozx.d(paramBaseArticleInfo.mFeedType, m);
      m = n;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        m = n;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rex != null) {
          m = localozx.c(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rex.jdField_a_of_type_Int, n);
        }
      }
      return m;
    }
  }
  
  public static int a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return 1;
    }
    String str;
    if (((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg != null)) {
      str = ((MessageForStructing)paramMessageRecord).structingMsg.mExtraData;
    }
    for (;;)
    {
      try
      {
        m = new JSONObject(str).optInt("sceneType", 1);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUtils", 2, "isDailyLockScreen, ret=" + m + ", mr=" + paramMessageRecord);
        }
        return m;
      }
      catch (JSONException localJSONException)
      {
        m = 1;
        continue;
      }
      int m = 1;
    }
  }
  
  public static int a(Long paramLong)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)a();
    if (localQQAppInterface == null) {
      return 0;
    }
    if (!TextUtils.isEmpty(((KandianMergeManager)localQQAppInterface.getManager(162)).a(paramLong))) {}
    for (int m = 1;; m = 0) {
      return m;
    }
  }
  
  private static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int m = new JSONObject(paramString).optInt("jumpType", 0);
        return m;
      }
      catch (JSONException paramString)
      {
        QLog.e("ReadInJoyUtils", 1, "getReportLoadModeFromLockScreenMsg: ", paramString);
      }
    }
    return -1;
  }
  
  public static long a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    if (localAppRuntime == null) {
      return 0L;
    }
    return localAppRuntime.getLongAccountUin();
  }
  
  public static long a(ArticleInfo paramArticleInfo, int paramInt)
  {
    long l2 = 0L;
    long l1;
    if ((pgb.a(paramArticleInfo)) || (paramInt == 77) || (paramInt == 78))
    {
      l1 = l2;
      if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  try
                  {
                    l1 = Long.parseLong(paramArticleInfo.mSubscribeID);
                    return l1;
                  }
                  catch (NumberFormatException paramArticleInfo)
                  {
                    paramArticleInfo.printStackTrace();
                    return 0L;
                  }
                  if ((!pgb.g(paramArticleInfo)) && (paramInt != 72) && (paramInt != 74)) {
                    break;
                  }
                  l1 = l2;
                } while (paramArticleInfo.mSocialFeedInfo == null);
                l1 = l2;
              } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj == null);
              return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long;
              if (paramInt != 76) {
                break;
              }
              l1 = l2;
            } while (paramArticleInfo.mSocialFeedInfo == null);
            l1 = l2;
          } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer == null);
          return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long;
          if ((pgb.f(paramArticleInfo)) || (paramInt == 73)) {
            break;
          }
          l1 = l2;
        } while (paramInt != 75);
        l1 = l2;
      } while (paramArticleInfo.mSocialFeedInfo == null);
      l1 = l2;
    } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer == null);
    return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long;
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    int i5 = 0;
    long l1 = NetConnInfoCenter.getServerTime();
    int m = jdField_a_of_type_Int;
    int n = m - 2;
    if ((paramQQAppInterface == null) || (m <= 0))
    {
      QLog.d("ReadInJoyUtils", 1, "break insert individual push time:" + l1);
      return l1;
    }
    Object localObject1 = new ArrayList();
    Object localObject2;
    int i4;
    int i2;
    try
    {
      localObject2 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject2 != null) {
        break label199;
      }
      QLog.d("ReadInJoyUtils", 1, "conversation frame is null");
      return l1;
    }
    catch (Exception paramQQAppInterface)
    {
      i4 = 0;
      i2 = m;
    }
    label105:
    QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + paramQQAppInterface.toString());
    int i1 = i2;
    m = i4;
    label141:
    if (m != 0)
    {
      m = 0;
      label147:
      i2 = i5;
      if (m >= i1) {}
    }
    for (;;)
    {
      long l2;
      try
      {
        paramQQAppInterface = (RecentBaseData)((List)localObject1).get(m);
        if (paramQQAppInterface != null)
        {
          l2 = ((RecentUserBaseData)paramQQAppInterface).mUser.showUpTime;
          if (l2 <= 0L) {}
        }
        else
        {
          m += 1;
          break label147;
          label199:
          localObject2 = ((Conversation)localObject2).a().b();
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((List)localObject2).iterator();
          Object localObject3;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (!(localObject3 instanceof RecentBaseData)) {
              continue;
            }
            ((List)localObject1).add((RecentBaseData)localObject3);
            continue;
          }
          localObject2 = ((List)localObject1).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (RecentBaseData)((Iterator)localObject2).next();
            if (localObject3 == null) {
              continue;
            }
            localObject3 = (RecentUserBaseData)localObject3;
            if ((((RecentUserBaseData)localObject3).mUser == null) || (((RecentUserBaseData)localObject3).mUser.getType() != 1008) || (!uaw.b(paramQQAppInterface, ((RecentUserBaseData)localObject3).mUser.uin))) {
              continue;
            }
            ((Iterator)localObject2).remove();
            continue;
          }
          i1 = ((List)localObject1).size();
          i2 = m;
          if (m > i1) {
            i2 = i1;
          }
          i3 = 0;
          m = 0;
          if (i3 < i2) {
            i4 = m;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        int i3;
        boolean bool;
        QLog.d("ReadInJoyUtils", 1, "failed to construct individual push time " + paramQQAppInterface.toString());
      }
      try
      {
        paramQQAppInterface = (RecentBaseData)((List)localObject1).get(i3);
        i4 = m;
        if (paramQQAppInterface == null) {
          break label742;
        }
        i4 = m;
        paramQQAppInterface = (RecentUserBaseData)paramQQAppInterface;
        i1 = m;
        i4 = m;
        if (paramQQAppInterface.mUnreadNum > 0) {
          i1 = 1;
        }
        i4 = i1;
        bool = TextUtils.equals(paramQQAppInterface.getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN);
        i4 = i1;
        if (!bool) {
          break label742;
        }
        m = i3;
        n = i1;
        i3 += 1;
        i1 = n;
        n = m;
        m = i1;
      }
      catch (Exception paramQQAppInterface) {}
      i1 = i2;
      break label141;
      i2 = m;
      if (i2 >= n)
      {
        QLog.d("ReadInJoyUtils", 1, "insert individual push time:" + l1);
        return l1;
      }
      for (;;)
      {
        QLog.d("ReadInJoyUtils", 1, "insert individual push time:" + l1);
        return l1;
        m = (int)(Math.random() * (n - i2)) + 1 + i2;
        paramQQAppInterface = (RecentUserBaseData)((List)localObject1).get(m - 1);
        localObject1 = (RecentUserBaseData)((List)localObject1).get(m);
        l2 = Math.max(paramQQAppInterface.mUser.lastmsgtime, paramQQAppInterface.mUser.lastmsgdrafttime);
        long l3 = Math.max(((RecentUserBaseData)localObject1).mUser.lastmsgtime, ((RecentUserBaseData)localObject1).mUser.lastmsgdrafttime);
        double d1 = Math.random();
        l1 = l2 - ((l2 - l3) * d1) - 1L;
        continue;
        QLog.d("ReadInJoyUtils", 1, "construct individual push first " + i1 + " msg no red point");
      }
      break label105;
      label742:
      m = n;
      n = i4;
    }
  }
  
  public static Intent a(Activity paramActivity, ArticleInfo paramArticleInfo, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("banner_activityName", FastWebActivity.class.getName());
    localIntent.putExtra("banner_webViewUrl", paramArticleInfo.mArticleContentUrl);
    localIntent.putExtra("banner_wording", String.format(amtj.a(2131712238), new Object[] { paramArticleInfo.mTitle }));
    paramActivity = paramArticleInfo.mArticleContentUrl;
    if (!TextUtils.isEmpty(paramActivity))
    {
      paramActivity = Uri.parse(paramActivity);
      if (paramActivity.isHierarchical()) {
        localIntent.putExtra("banner_businessCategory", "WebView_" + paramActivity.getHost());
      }
    }
    paramActivity = new Bundle();
    paramActivity.putParcelable("fast_web_article_info", paramArticleInfo);
    paramActivity.putInt("fast_web_banner_from_channel_id", (int)paramArticleInfo.mChannelID);
    paramActivity.putBoolean("fast_web_from_article_recommend", paramBoolean);
    localIntent.putExtra("banner_webview_extra", paramActivity);
    return localIntent;
  }
  
  public static Intent a(Intent paramIntent, ArticleInfo paramArticleInfo, int paramInt1, String paramString1, long paramLong, String paramString2, int paramInt2, int paramInt3)
  {
    if (paramIntent == null) {
      return paramIntent;
    }
    new ArticleInfo();
    ArticleInfo localArticleInfo = paramArticleInfo.clone();
    if (paramArticleInfo.mSocialFeedInfo != null) {
      localArticleInfo.mSocialFeedInfo = paramArticleInfo.mSocialFeedInfo.a();
    }
    if (localArticleInfo.mSocialFeedInfo == null) {
      localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
    }
    if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep == null) {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep = new rep();
    }
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramArticleInfo = new SocializeFeedsInfo.BiuCommentInfo();
    paramArticleInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString1))) {
      paramArticleInfo.jdField_b_of_type_JavaLangString = (": " + paramString1);
    }
    ReadInJoyUserInfoModule.a(paramLong, paramString2);
    paramArticleInfo.jdField_b_of_type_Int = localArticleInfo.mFeedType;
    paramArticleInfo.jdField_c_of_type_Int = paramInt2;
    paramArticleInfo.jdField_b_of_type_JavaLangLong = Long.valueOf(localArticleInfo.mFeedId);
    QLog.d("ReadInJoyUtils", 2, "biuCommentInfo " + paramArticleInfo.toString());
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList.add(paramArticleInfo);
    paramIntent.putExtra("arg_article_info", localArticleInfo);
    paramIntent.putExtra("biu_rowkey", localArticleInfo.innerUniqueID);
    paramIntent.putExtra("feedsType", localArticleInfo.mFeedType);
    paramIntent.putExtra("arg_from_type", paramInt3);
    paramIntent.putExtra("biu_src", paramInt1);
    paramIntent.putExtra("feed_id", localArticleInfo.mFeedId);
    paramIntent.putExtra("feedsType", localArticleInfo.mFeedType);
    QLog.d("ReadInJoyUtils", 2, "readytoJump  biuType: " + paramInt1 + "feed_id : " + localArticleInfo.mFeedId + "feeds_type : " + localArticleInfo.mFeedType + "articleID : " + localArticleInfo.mArticleID);
    return paramIntent;
  }
  
  public static Drawable a(QQAppInterface paramQQAppInterface, Drawable paramDrawable)
  {
    Object localObject2 = null;
    boolean bool = false;
    Object localObject1 = paramQQAppInterface.getMessageFacade();
    if (localObject1 == null) {}
    do
    {
      return paramDrawable;
      localObject1 = ((QQMessageFacade)localObject1).getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
    } while ((localObject1 == null) || (((MessageRecord)localObject1).isread));
    QLog.d("ReadInJoyUtils", 2, "getSpecAggregateAvatarForKandian run !");
    for (;;)
    {
      try
      {
        localResources = BaseApplicationImpl.getApplication().getResources();
        JSONObject localJSONObject = new JSONObject(((MessageRecord)localObject1).extStr);
        if (localJSONObject.has("kdUin"))
        {
          localObject1 = localJSONObject.getString("kdUin");
          QLog.d("ReadInJoyUtils", 2, "got tipUin from kdUin: " + (String)localObject1);
          if (localJSONObject.has("kdDefaultSourceAvatarUrl"))
          {
            localObject2 = localJSONObject.getString("kdDefaultSourceAvatarUrl");
            QLog.d("ReadInJoyUtils", 2, "got defaultAvatarUrl from kdDefaultSourceAvatarUrl: " + (String)localObject2);
          }
          if (localJSONObject.has("kdShouldShowMergedAvatar"))
          {
            bool = localJSONObject.getBoolean("kdShouldShowMergedAvatar");
            QLog.d("ReadInJoyUtils", 2, "got shouldShowMergedAvatar from kdShouldShowMergedAvatar: " + bool);
          }
          if (!bool)
          {
            QLog.d("ReadInJoyUtils", 2, "shouldn't show merged icon, give up");
            return paramDrawable;
          }
        }
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        Resources localResources;
        paramQQAppInterface.printStackTrace();
        QLog.d("ReadInJoyUtils", 2, "get merge icon has error : " + paramQQAppInterface);
        return paramDrawable;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramQQAppInterface = paramQQAppInterface.getFaceBitmapCacheKey(1, "kd_" + (String)localObject1, (byte)3, 0, 100, true);
          localObject2 = (syf)bfuj.a(paramQQAppInterface);
          if (localObject2 != null)
          {
            QLog.d("ReadInJoyUtils", 2, "getMergeIcon From cache ! key : " + paramQQAppInterface + ", tipUin : " + (String)localObject1);
            return localObject2;
          }
          localObject2 = bfvo.a(paramDrawable);
          if (localObject2 == null) {
            break;
          }
          localObject1 = new syf((Bitmap)localObject2, AIOUtils.dp2px(50.0F, localResources), localResources, (String)localObject1, 1);
          bfuj.a(paramQQAppInterface, (Sizeable)localObject1);
          return localObject1;
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        paramQQAppInterface = bfvo.a(paramDrawable);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface = new syf(paramQQAppInterface, (String)localObject2, AIOUtils.dp2px(50.0F, localResources), localResources, 1);
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        QLog.d("ReadInJoyUtils", 2, "get merge icon has error : " + paramQQAppInterface);
        return paramDrawable;
      }
      localObject1 = null;
    }
  }
  
  public static Handler a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread == null)
      {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread = new ReadInJoySSOHandlerThread("kandian_network_thread");
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread.start();
        jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread.getLooper());
      }
      Handler localHandler = jdField_a_of_type_AndroidOsHandler;
      return localHandler;
    }
    finally {}
  }
  
  public static Pair<Integer, Integer> a(Pair<Integer, Integer>[] paramArrayOfPair, int paramInt1, int paramInt2)
  {
    int n = paramArrayOfPair.length;
    double d2 = 1.0D * paramInt2 / paramInt1;
    double d1 = 1.7976931348623157E+308D;
    Pair<Integer, Integer> localPair = null;
    int m = 0;
    double d3;
    double d4;
    if (m < n)
    {
      d3 = 1.0D * ((Integer)paramArrayOfPair[m].second).intValue() / ((Integer)paramArrayOfPair[m].first).intValue();
      d4 = Math.abs(d3 - d2);
      if (d4 < d1)
      {
        d1 = Math.abs(d3 - d2);
        localPair = paramArrayOfPair[m];
      }
    }
    for (;;)
    {
      m += 1;
      break;
      if ((d4 == d1) && (localPair != null))
      {
        int i1 = Math.abs(((Integer)localPair.second).intValue() - paramInt2);
        int i2 = Math.abs(((Integer)localPair.first).intValue() - paramInt1);
        int i3 = Math.abs(((Integer)paramArrayOfPair[m].second).intValue() - paramInt2);
        if (i1 + i2 > Math.abs(((Integer)paramArrayOfPair[m].first).intValue() - paramInt1) + i3)
        {
          d1 = Math.abs(d3 - d2);
          localPair = paramArrayOfPair[m];
          continue;
          return localPair;
        }
      }
    }
  }
  
  public static ReadInJoyUserInfoModule a()
  {
    Object localObject = a();
    if (localObject == null) {
      return null;
    }
    localObject = (pks)((QQAppInterface)localObject).getManager(163);
    if (localObject == null) {
      return null;
    }
    return ((pks)localObject).a().a();
  }
  
  public static ArticleInfo a(String paramString)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    Object localObject5;
    long l1;
    Object localObject6;
    Object localObject2;
    int m;
    for (;;)
    {
      try
      {
        localObject5 = new JSONObject(paramString);
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyUtils", 2, "web json:" + ((JSONObject)localObject5).toString());
        }
        localObject3 = ((JSONObject)localObject5).optString("title");
        localObject1 = ((JSONObject)localObject5).optString("sourceName");
        l2 = 0L;
        l3 = 0L;
        l7 = 0L;
        l11 = 0L;
      }
      catch (Exception paramString)
      {
        Object localObject3;
        long l11;
        long l8;
        long l9;
        long l10;
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyUtils", 2, "Exception error=" + paramString.getMessage());
        }
        return localArticleInfo;
      }
      for (;;)
      {
        try
        {
          paramString = new String(bfuc.decode((String)localObject3, 0));
        }
        catch (Exception localException3)
        {
          Object localObject4;
          paramString = (String)localObject1;
          l6 = l7;
          localObject1 = localObject4;
          break;
          if (n == 4) {
            continue;
          }
          if (n != 5) {
            continue;
          }
          continue;
        }
        try
        {
          localObject3 = new String(bfuc.decode((String)localObject1, 0));
          l6 = l7;
          l5 = l3;
          l4 = l2;
        }
        catch (Exception localException1)
        {
          localObject4 = paramString;
          paramString = (String)localObject1;
          l6 = l7;
          localObject1 = localObject4;
          break;
        }
      }
      try
      {
        localObject1 = ((JSONObject)localObject5).optString("feedsId");
        l1 = l2;
        l6 = l7;
        l5 = l3;
        l4 = l2;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l6 = l7;
          l5 = l3;
          l4 = l2;
          l1 = new BigInteger((String)localObject1).longValue();
        }
        l6 = l7;
        l5 = l3;
        l4 = l1;
        localObject1 = ((JSONObject)localObject5).optString("ariticleId");
        l2 = l3;
        l6 = l7;
        l5 = l3;
        l4 = l1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l6 = l7;
          l5 = l3;
          l4 = l1;
          l2 = new BigInteger((String)localObject1).longValue();
        }
        l6 = l7;
        l5 = l2;
        l4 = l1;
        localObject1 = ((JSONObject)localObject5).optString("originFeedsId");
        l3 = l7;
        l6 = l7;
        l5 = l2;
        l4 = l1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l6 = l7;
          l5 = l2;
          l4 = l1;
          l3 = new BigInteger((String)localObject1).longValue();
        }
        l6 = l3;
        l5 = l2;
        l4 = l1;
        localObject6 = ((JSONObject)localObject5).optString("businessId");
        l7 = l11;
        localObject2 = localObject3;
        l8 = l3;
        l9 = l2;
        l10 = l1;
        localObject1 = paramString;
        l6 = l3;
        l5 = l2;
        l4 = l1;
        if (!TextUtils.isEmpty((CharSequence)localObject6))
        {
          l6 = l3;
          l5 = l2;
          l4 = l1;
          l7 = new BigInteger((String)localObject6).longValue();
          localObject1 = paramString;
          l10 = l1;
          l9 = l2;
          l8 = l3;
          localObject2 = localObject3;
        }
        l1 = ((JSONObject)localObject5).optLong("originFeedsType", 1L);
        paramString = ((JSONObject)localObject5).optString("picurl");
        m = ((JSONObject)localObject5).optInt("duration");
        ((JSONObject)localObject5).optString("callback");
        localObject3 = new String(bfuc.decode(((JSONObject)localObject5).optString("accountDesc"), 0));
        n = ((JSONObject)localObject5).optInt("feedsType", 1);
        localArticleInfo.mArticleID = l9;
        localArticleInfo.mTitle = ((String)localObject1);
        localArticleInfo.mSubscribeName = ((String)localObject2);
        localArticleInfo.mFirstPagePicUrl = paramString;
        localArticleInfo.mVideoDuration = m;
        localArticleInfo.mFeedId = l10;
        localArticleInfo.mFeedType = n;
        localArticleInfo.mSummary = ((String)localObject3);
        localArticleInfo.businessId = l7;
        paramString = ((JSONObject)localObject5).getJSONArray("biuLevelList");
        localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep = new rep();
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaLangLong = Long.valueOf(l8);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong = Long.valueOf(l1);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList = new ArrayList();
        if (paramString == null) {
          break label912;
        }
        m = 0;
        if (m >= paramString.length()) {
          break label912;
        }
        localObject2 = new SocializeFeedsInfo.BiuCommentInfo();
        localObject3 = paramString.getJSONObject(m);
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject3).optLong("uin"));
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).optString("comment");
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_a_of_type_Int = ((JSONObject)localObject3).optInt("biuTime");
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_Int = ((JSONObject)localObject3).optInt("feeds_type", 1);
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_c_of_type_Int = ((JSONObject)localObject3).optInt("op_type");
      }
      catch (Exception localException2)
      {
        localObject1 = paramString;
        paramString = (String)localObject4;
        l3 = l5;
        l2 = l4;
        continue;
      }
      try
      {
        localObject3 = ((JSONObject)localObject3).optString("feedsId");
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject3).longValue());
        }
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangString = new String(bfuc.decode(((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangString, 0));
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_a_of_type_JavaLangString = ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangString;
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
        continue;
      }
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList.add(localObject2);
      m += 1;
      continue;
      ((Exception)localObject2).printStackTrace();
      l7 = l11;
      localObject2 = paramString;
      l8 = l6;
      l9 = l3;
      l10 = l2;
    }
    label912:
    paramString = ((JSONObject)localObject5).optJSONObject("ugcInfo");
    if ((paramString != null) && ((n == 4) || (n == 5) || ((n == 1) && ((l1 == 4L) || (l1 == 5L)))))
    {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj = new rfj();
      n = paramString.optInt("ugcType", 0);
      localObject2 = paramString.optString("ugcComment");
      localObject4 = paramString.optJSONArray("ugcAtLevelList");
      if (localObject4 != null)
      {
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Rep = new rep();
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList = new ArrayList();
        m = 0;
        for (;;)
        {
          if (m >= ((JSONArray)localObject4).length()) {
            break label1247;
          }
          localObject5 = new SocializeFeedsInfo.BiuCommentInfo();
          localObject6 = ((JSONArray)localObject4).getJSONObject(m);
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject6).optLong("uin"));
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString = ((JSONObject)localObject6).optString("comment");
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_Int = ((JSONObject)localObject6).optInt("biuTime");
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_Int = ((JSONObject)localObject6).optInt("feeds_type", 1);
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_c_of_type_Int = ((JSONObject)localObject6).optInt("op_type");
          try
          {
            localObject6 = ((JSONObject)localObject6).optString("feedsId");
            if (!TextUtils.isEmpty((CharSequence)localObject6)) {
              ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject6).longValue());
            }
            ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString = new String(bfuc.decode(((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString, 0));
            ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_JavaLangString = ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString;
          }
          catch (Exception localException5)
          {
            for (;;)
            {
              localException5.printStackTrace();
            }
          }
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList.add(localObject5);
          m += 1;
        }
      }
      label1247:
      localArticleInfo.mTitle = new String(bfuc.decode((String)localObject2, 0));
      localArticleInfo.mSummary = "";
      if ((n != 3) && (n != 2)) {
        break label1582;
      }
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = new rfk();
      paramString = paramString.optJSONArray("ugcPicInfo");
      if ((paramString != null) && (paramString.length() > 0))
      {
        ((rfk)localObject1).jdField_c_of_type_JavaLangString = paramString.getJSONObject(0).optString("ugcPicUrl");
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      }
    }
    for (;;)
    {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Int = n;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_JavaLangString = localArticleInfo.mTitle;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString = "";
      localArticleInfo.mSocialFeedInfo.jdField_c_of_type_JavaLangString = "";
      localArticleInfo.mSocialFeedInfo.jdField_b_of_type_JavaLangString = "";
      return localArticleInfo;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      localObject2 = new rfl();
      paramString = paramString.optJSONObject("ugcVideoInfo");
      if (paramString != null)
      {
        ((rfl)localObject2).jdField_d_of_type_JavaLangString = paramString.optString("ugcVideoCoverUrl");
        ((rfl)localObject2).jdField_a_of_type_Long = paramString.optInt("ugcVideoDuration");
        ((rfl)localObject2).jdField_e_of_type_JavaLangString = ((String)localObject1);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
        continue;
        if (n == 1) {
          localArticleInfo.mFirstPagePicUrl = "";
        }
      }
    }
  }
  
  public static ReadinjoyTabFrame a(Context paramContext)
  {
    try
    {
      if ((paramContext instanceof SplashActivity))
      {
        paramContext = FrameHelperActivity.a((BaseActivity)paramContext);
        if (paramContext == null) {
          return null;
        }
        paramContext = (ReadinjoyTabFrame)paramContext.a(ReadinjoyTabFrame.class);
        return paramContext;
      }
    }
    catch (RuntimeException paramContext)
    {
      QLog.e("ReadInJoyUtils", 1, paramContext, new Object[0]);
    }
    return null;
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static SosoInterface.SosoLbsInfo a()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - jdField_c_of_type_Long > jdField_b_of_type_Long)
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = LbsManagerService.getCachedLbsInfo("readinjoy_anti_cheating");
      jdField_c_of_type_Long = l1;
    }
    return jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo;
  }
  
  public static MessageForStructing a(QQAppInterface paramQQAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)jdField_a_of_type_JavaUtilMap.get(paramQQAppInterface.getCurrentAccountUin());
      jdField_a_of_type_JavaUtilMap.remove(paramQQAppInterface.getCurrentAccountUin());
      return localMessageForStructing;
    }
  }
  
  public static SystemBarCompact a(Activity paramActivity)
  {
    return new SystemBarCompact(paramActivity, true, -1);
  }
  
  public static Object a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramAppRuntime = bkwm.a(paramAppRuntime, true, paramBoolean);
        if (paramAppRuntime != null)
        {
          paramAppRuntime = paramAppRuntime.getString(paramString, "");
          if (!TextUtils.isEmpty(paramAppRuntime))
          {
            paramAppRuntime = new ObjectInputStream(new ByteArrayInputStream(PkgTools.hexToBytes(paramAppRuntime)));
            paramString = paramAppRuntime.readObject();
            paramAppRuntime.close();
            return paramString;
          }
        }
      }
      catch (Exception paramAppRuntime)
      {
        paramAppRuntime.printStackTrace();
      }
    }
    return null;
  }
  
  public static String a()
  {
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.getApplication();
    if (localObject2 != null) {
      localObject1 = ((BaseApplicationImpl)localObject2).getRuntime();
    }
    if (localObject1 == null) {
      localObject1 = "0";
    }
    do
    {
      return localObject1;
      localObject2 = ((AppRuntime)localObject1).getAccount();
      localObject1 = localObject2;
    } while (localObject2 != null);
    return "0";
  }
  
  public static String a(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      ((JSONObject)localObject).put("session_id", jdField_f_of_type_JavaLangString);
      ((JSONObject)localObject).put("failed_reason", paramInt);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, ArticleInfo paramArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = Integer.toString(d());
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", jdField_d_of_type_Int);
        localJSONObject.put("source", str);
        localJSONObject.put("feeds_type", paramInt3);
        localJSONObject.put("kandian_mode", e());
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        localJSONObject.put("rowkey", paramString2);
        localJSONObject.put("pic_number", paramInt1);
        if (paramInt2 > 0) {
          localJSONObject.put("pic_position", "" + paramInt2);
        }
        if (paramArticleInfo != null) {
          localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
        }
      }
      catch (JSONException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyUtils", 2, "transGridImageClickR5 json exception.");
        paramString1.printStackTrace();
        continue;
      }
      return localJSONObject.toString();
      localJSONObject.put("rowkey", "0");
    }
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, String paramString3, ArticleInfo paramArticleInfo)
  {
    localJSONObject = new JSONObject();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = Integer.toString(d());
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", jdField_d_of_type_Int);
        if (TextUtils.isEmpty(paramString3)) {
          continue;
        }
        localJSONObject.put("feeds_source", paramString3);
        localJSONObject.put("feeds_type", paramInt3);
        localJSONObject.put("kandian_mode", e());
        localJSONObject.put("source", str);
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        localJSONObject.put("rowkey", paramString2);
      }
      catch (JSONException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyUtils", 2, "transGridImageClickR5 json exception.");
        paramString1.printStackTrace();
        continue;
        localJSONObject.put("rowkey", "0");
        continue;
      }
      localJSONObject.put("pic_number", paramInt1);
      if (paramInt2 > 0) {
        localJSONObject.put("pic_position", "" + paramInt2);
      }
      if (paramArticleInfo != null)
      {
        localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
        localJSONObject.put("channel_id", paramArticleInfo.mChannelID);
      }
      return localJSONObject.toString();
      localJSONObject.put("feeds_source", "0");
    }
  }
  
  public static String a(long paramLong)
  {
    boolean bool;
    String str;
    int m;
    if (e() == 6)
    {
      bool = true;
      str = jdField_d_of_type_JavaLangString;
      if (paramLong != 1004L) {
        break label93;
      }
      if (!bool) {
        break label79;
      }
      m = bkwm.b(BaseApplicationImpl.getApplication().getRuntime(), 0);
      label38:
      if (m != 0) {
        break label123;
      }
      str = jdField_e_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject = bkwm.a(a(), true, false);
      if (localObject != null) {
        break label149;
      }
      QLog.d("ReadInJoyUtils", 1, "getVideoAutoPlaySetting failed to get sp");
      return str;
      bool = false;
      break;
      label79:
      m = bkwm.a(BaseApplicationImpl.getApplication().getRuntime(), 0);
      break label38;
      label93:
      if (bool)
      {
        m = bkwm.c(BaseApplicationImpl.getApplication().getRuntime());
        break label38;
      }
      m = bkwm.b(BaseApplicationImpl.getApplication().getRuntime());
      break label38;
      label123:
      if (m == 1) {
        str = jdField_d_of_type_JavaLangString;
      } else if (m == 2) {
        str = jdField_c_of_type_JavaLangString;
      }
    }
    label149:
    if (bool) {}
    for (Object localObject = ((SharedPreferences)localObject).getString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_VIDEO_FLOW_SETTING", str);; localObject = ((SharedPreferences)localObject).getString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_SETTING", str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "getVideoAutoPlaySetting(),isVideoFlowEnter = " + bool + ", autoSetting = " + (String)localObject + ",localSettingDefaultValue=" + str + ", remoteSettingDefaultValue=" + m + " channelFrom:" + paramLong);
      }
      return localObject;
    }
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("algorithm_id", paramLong);
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      ((JSONObject)localObject).put("feeds_type", paramInt1);
      ((JSONObject)localObject).put("channel_id", paramInt2);
      ((JSONObject)localObject).put("feeds_channel_entrance", paramInt3);
      ((JSONObject)localObject).put("session_id", jdField_f_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5, ArticleInfo paramArticleInfo)
  {
    try
    {
      paramString1 = a(paramLong, paramInt1, paramInt2, paramBoolean, paramString1, paramString3, paramString4, paramInt5, d(), paramArticleInfo).toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, ArticleInfo paramArticleInfo)
  {
    return a(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramString1, paramString2, paramString3, paramString4, 0, paramArticleInfo);
  }
  
  public static String a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, String paramString4, ArticleInfo paramArticleInfo, long paramLong2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean2, int paramInt9, int paramInt10, int paramInt11)
  {
    paramString2 = a(paramLong1, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramString1, paramString2, paramString3, paramString4, paramArticleInfo);
    for (;;)
    {
      try
      {
        paramString3 = new JSONObject(paramString2);
        paramString3.put("kandian_mode", paramInt7);
        paramString3.put("kandian_mode_new", ofe.a());
        paramString3.put("tab_source", paramInt6);
        if (paramInt11 >= 0) {
          paramString3.put("entry_path", paramInt11);
        }
        if (paramInt5 >= 0) {
          paramString3.put("behavior_type", paramInt5);
        }
        if (paramLong2 > 0L) {
          paramString3.put("stay_duration", paramLong2);
        }
        paramString3.put("video_inserted", paramBoolean2);
        paramString3.put("video_strategyid", paramInt8);
        paramString3.put("proteus_bid", bkwm.a("default_feeds_proteus_offline_bid"));
        paramString3.put("ads_jump", paramInt9);
        paramString3.put("ads_source", paramInt10);
        paramString3.put("star_logo", b(paramArticleInfo));
        if (bgoa.a() == 1)
        {
          paramString1 = "1";
          paramString3.put("simCardType", paramString1);
          if ((pcl.c(paramInt2)) && (paramArticleInfo != null))
          {
            paramLong1 = ((Long)bkwm.a("readinjoy_daily_article_first_exposure_" + paramArticleInfo.mArticleID, Long.valueOf(0L))).longValue();
            if (paramLong1 != 0L) {
              paramString3.put("daily_article_first_timestamp", paramLong1 + "");
            }
          }
          if (paramArticleInfo != null)
          {
            if (!paramArticleInfo.isShowGif) {
              continue;
            }
            paramString3.put("short_content_gif", 1);
          }
          if (paramArticleInfo != null) {
            paramString3.put("account_expose_card", c(paramArticleInfo));
          }
          if (paramArticleInfo != null) {
            paramString3.put("picture_click_jumptype", Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0));
          }
          if ((paramArticleInfo != null) && (paramArticleInfo.mChannelID == 0L) && (g(paramArticleInfo)))
          {
            if (paramArticleInfo.mCommentCount > 100L) {
              break label728;
            }
            if (paramArticleInfo.mVideoCommentCount <= 100) {
              break label692;
            }
            break label728;
            paramString3.put("comment_exposure", paramInt1);
          }
          if (paramArticleInfo != null)
          {
            if ((puf.a() == -1) || (puf.a() == 0)) {
              break label697;
            }
            paramString3.put("mainfeeds_showcase", puf.a());
            paramString3.put("configchannel_name", puf.a());
          }
          if ((paramArticleInfo != null) && (rbt.c(paramArticleInfo))) {
            paramString3.put("jump_src", rbt.a(paramArticleInfo));
          }
          if ((paramArticleInfo != null) && (paramArticleInfo.isPGCShortContent())) {
            paramString3.put("short_content_size", ComponentPGCShortContentBig.jdField_a_of_type_JavaLangString);
          }
          paramString3.put("default_feeds_aladdin_keys", ((String)bkwm.a("default_feeds_aladdin_keys", "")).replace("|", "_"));
          if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo == null) || (!paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo.uint32_is_topic.has())) {
            break label710;
          }
          paramString3.put("istopic", 1);
          paramString1 = paramString3.toString();
          paramString2 = paramString1;
          if (paramArticleInfo == null) {}
        }
      }
      catch (JSONException paramString3)
      {
        paramString1 = paramString2;
        paramString2 = paramString3;
        paramString2.printStackTrace();
        return paramString1;
      }
      try
      {
        paramString2 = new sie(paramString1).c(paramArticleInfo).d(paramArticleInfo).a(paramArticleInfo.videoReportInfo).a(paramArticleInfo, true).a().a();
        return paramString2;
      }
      catch (JSONException paramString2)
      {
        continue;
      }
      paramString1 = "0";
      continue;
      paramString3.put("short_content_gif", 0);
      continue;
      label692:
      paramInt1 = 2;
      continue;
      label697:
      paramString3.put("mainfeeds_showcase", 0);
      continue;
      label710:
      paramString3.put("istopic", 0);
      continue;
      label728:
      paramInt1 = 1;
    }
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, ArticleInfo paramArticleInfo, String paramString3)
  {
    paramString1 = a(paramLong, paramInt1, paramInt2, 0, 0, paramBoolean, paramString1, null, paramString2, null, 0, paramArticleInfo);
    try
    {
      paramString2 = new JSONObject(paramString1);
      paramString2.put("topicid", paramString3);
      paramString2.put("proteus_bid", bkwm.a("default_feeds_proteus_offline_bid"));
      return paramString2.toString();
    }
    catch (JSONException paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  public static String a(Context paramContext)
  {
    e(paramContext);
    return jdField_h_of_type_JavaLangString;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    int m = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("session_id", jdField_f_of_type_JavaLangString);
      if (NetworkUtil.isWifiConnected(paramContext)) {
        m = 0;
      }
      for (;;)
      {
        localJSONObject.put("network", m);
        localJSONObject.put("version", paramString1);
        localJSONObject.put("os", 1);
        localJSONObject.put("uin", paramString2);
        return localJSONObject.toString();
        boolean bool = NetworkUtil.is3Gor4G(paramContext);
        if (!bool) {
          m = 2;
        }
      }
      return "";
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static String a(VideoInfo paramVideoInfo, int paramInt)
  {
    sie localsie = new sie(null, null, null, null);
    localsie.S(ReadinjoyTabFrame.jdField_a_of_type_Int).T(paramInt);
    if (paramVideoInfo != null) {
      if (paramVideoInfo.jdField_h_of_type_Boolean) {
        if (paramVideoInfo.jdField_g_of_type_Boolean)
        {
          paramInt = 3;
          localsie.a("status", Integer.valueOf(paramInt)).i(paramVideoInfo.jdField_g_of_type_JavaLangString).e(paramVideoInfo.jdField_f_of_type_Long).e(paramVideoInfo.jdField_a_of_type_JavaLangString).U(0).a(0);
        }
      }
    }
    for (;;)
    {
      return localsie.a().a();
      paramInt = 2;
      break;
      paramInt = 4;
      break;
      localsie.a("status", Integer.valueOf(1));
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo)
  {
    return a(paramArticleInfo, false);
  }
  
  @NotNull
  private static String a(ArticleInfo paramArticleInfo, int paramInt)
  {
    Object localObject2 = paa.jdField_e_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (((String)localObject2).contains("uin="))
    {
      localObject1 = b(paramArticleInfo, paramInt);
      localObject1 = ((String)localObject2).replace("uin=", "uin=" + bfuc.encodeToString(((String)localObject1).getBytes(), 0).replace('\n', ' ').trim());
    }
    localObject2 = localObject1;
    if (((String)localObject1).contains("&feedstype="))
    {
      if (((!pgb.i(paramArticleInfo)) && (!pgb.k(paramArticleInfo))) || ((paramInt == 2) || (paramInt == 3) || (paramInt == 5) || (paramInt == 7))) {
        localObject2 = ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong);
      }
    }
    else {
      return localObject2;
    }
    return ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mFeedType);
  }
  
  public static String a(ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    if (paramArticleInfo == null)
    {
      QLog.d("ReadInJoyUtils", 1, "transMergeKandianReportR5BaseForFastWeb articleInfo is null.");
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("algorithm_id", paramArticleInfo.mAlgorithmID);
      localJSONObject.put("puin_type", paramString);
      localJSONObject.put("source", a(paramInt));
      localJSONObject.put("kandian_mode", e());
      localJSONObject.put("mp_article_id", paramArticleInfo.mArticleID);
      localJSONObject.put("channel_id", paramInt);
      return localJSONObject.toString();
    }
    catch (JSONException paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
      }
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      a(localJSONObject, paramArticleInfo);
      if (paramBoolean) {}
      for (paramArticleInfo = "1";; paramArticleInfo = "0")
      {
        localJSONObject.put("fast_biu", paramArticleInfo);
        return localJSONObject.toString();
      }
      return "";
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (!d(paramBaseArticleInfo))) {
      paramBaseArticleInfo = null;
    }
    String str;
    do
    {
      return paramBaseArticleInfo;
      if ((paramBaseArticleInfo.mGalleryFeedsInfo == null) || (!paramBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) || (TextUtils.isEmpty(paramBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8()))) {
        break;
      }
      paramBaseArticleInfo = paramBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
      str = tgc.b(paramBaseArticleInfo);
      if (!tgc.b(paramBaseArticleInfo)) {
        break;
      }
      paramBaseArticleInfo = str;
    } while (!TextUtils.isEmpty(str));
    return null;
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    String str;
    if (g(paramString)) {
      str = b(paramString, paramBaseArticleInfo);
    }
    do
    {
      return str;
      str = paramString;
    } while (!h(paramString));
    return c(paramString, paramBaseArticleInfo);
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return jdField_a_of_type_Rdh.jdField_b_of_type_JavaLangString;
  }
  
  public static String a(PBBytesField paramPBBytesField)
  {
    if (a(paramPBBytesField)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.getFile();
    }
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str = paramString;
    int m;
    if (!TextUtils.isEmpty(paramString))
    {
      m = 0;
      n = 0;
      if (m >= paramString.length()) {
        break label144;
      }
      int i1 = paramString.charAt(m);
      if (((97 > i1) || (i1 > 122)) && ((65 > i1) || (i1 > 90)) && ((48 > i1) || (i1 > 57))) {
        break label130;
      }
      n += 1;
      label75:
      if (n <= paramInt) {
        break label137;
      }
    }
    label130:
    label137:
    label144:
    for (int n = 1;; n = 0)
    {
      str = paramString;
      if (n != 0)
      {
        n = m;
        if (m == paramInt) {
          n = m - 1;
        }
        str = paramString.substring(0, n) + "…";
      }
      return str;
      n += 2;
      break label75;
      m += 1;
      break;
    }
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (!bkwm.b(a())) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "smart crop switch is false ! url : " + paramString);
      }
    }
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return paramString;
        } while ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http://qqpublic.qpic.cn")));
        localObject2 = paramString.split("/");
      } while (localObject2.length < 2);
      localObject1 = localObject2[(localObject2.length - 2)].split("_");
    } while (localObject1.length < 1);
    Object localObject3 = localObject1[(localObject1.length - 1)];
    if ("open".equals(localObject3)) {}
    for (Object localObject1 = paa.a;; localObject1 = paa.b)
    {
      localObject1 = a((Pair[])localObject1, paramInt1, paramInt2);
      if (localObject1 == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "the picture size : w : " + paramInt1 + " h : " + paramInt2 + ", select scale : " + ((Pair)localObject1).first + ":" + ((Pair)localObject1).second);
      }
      localObject2 = localObject2[(localObject2.length - 1)];
      return paramString.replace(String.format("_%s/%s", new Object[] { localObject3, localObject2 }), String.format("_%s_%d_%d/%s", new Object[] { localObject3, ((Pair)localObject1).first, ((Pair)localObject1).second, localObject2 }));
      if (!"vsmcut".equals(localObject3)) {
        break;
      }
    }
  }
  
  @Deprecated
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!bkwm.b(a())) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "smart crop switch is false ! url : " + paramString);
      }
    }
    Pair localPair;
    do
    {
      return paramString;
      localPair = a(paa.a, paramInt2, paramInt1);
    } while (localPair == null);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUtils", 2, "the picture size : w : " + paramInt2 + " h : " + paramInt1 + ", select scale : " + localPair.first + ":" + localPair.second + " from : " + paramInt3);
    }
    Object localObject = paramString.split("/");
    localObject = localObject[(localObject.length - 1)];
    return paramString.replace("_open/" + (String)localObject, "_open_" + localPair.first + "_" + localPair.second + "/" + (String)localObject);
  }
  
  public static String a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("algorithm_id", paramLong);
      localJSONObject.put("feeds_friends_interaction", paramInt);
      localJSONObject.put("session_id", jdField_f_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      localJSONObject.put("version", "8.4.8".replace(".", ""));
      localJSONObject.put("rowkey", paramString);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mTopicRecommendFeedsInfo == null) || (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList == null) || (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("feeds_source", ((rgc)paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int);
      localJSONObject.put("feeds_type", "" + a(paramArticleInfo));
      localJSONObject.put("entry_mode", paramString);
      localJSONObject.put("kandian_mode", "" + e());
      localJSONObject.put("tab_source", "" + d());
      localJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
      localJSONObject.put("channel_id", paramArticleInfo.mChannelID);
      localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private static String a(String paramString, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    paramArticleInfo = paramString + b(paramArticleInfo, paramInt1);
    paramString = paramArticleInfo;
    if (paramInt2 >= 0) {
      paramString = paramArticleInfo + "&jumptype=" + paramInt2;
    }
    return paramString;
  }
  
  public static String a(String paramString, ArticleInfo paramArticleInfo, long paramLong)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {
      return "";
    }
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      if (pgb.a(paramArticleInfo)) {
        localJSONObject.put("feeds_source", paramArticleInfo.mSubscribeID);
      }
      for (;;)
      {
        localJSONObject.put("feeds_type", "" + a(paramArticleInfo));
        localJSONObject.put("entry_mode", paramString);
        localJSONObject.put("kandian_mode", "" + e());
        localJSONObject.put("tab_source", "" + d());
        localJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
        localJSONObject.put("channel_id", paramArticleInfo.mChannelID);
        localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
        localJSONObject.put("enter_uin", paramLong);
        return localJSONObject.toString();
        localJSONObject.put("feeds_source", localSocializeFeedsInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long);
      }
      return "";
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String a(String paramString, BaseArticleInfo paramBaseArticleInfo)
  {
    paramString = a(paramString);
    Object localObject2;
    long l2;
    Object localObject1;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localObject2 = paramString.optJSONObject(0);
      if (localObject2 != null)
      {
        String str2 = ((JSONObject)localObject2).optString("vid");
        int i1 = ((JSONObject)localObject2).optInt("duration");
        String str3 = ((JSONObject)localObject2).optString("thirdIcon");
        String str4 = ((JSONObject)localObject2).optString("thirdName");
        String str5 = ((JSONObject)localObject2).optString("thirdAction");
        String str6 = ((JSONObject)localObject2).optString("innerUniqueID");
        String str7 = ((JSONObject)localObject2).optString("width", "0");
        String str8 = ((JSONObject)localObject2).optString("height", "0");
        int n = ((JSONObject)localObject2).optInt("busiType");
        int m = n;
        if (n == 0) {
          m = 1;
        }
        String str9 = ((JSONObject)localObject2).optString("third_uin", "");
        String str10 = ((JSONObject)localObject2).optString("third_uin_name", "");
        paramString = "0";
        String str1 = "";
        l2 = 0L;
        if (!pgb.j(paramBaseArticleInfo)) {
          paramString = String.valueOf(((JSONObject)localObject2).optLong("file_size"));
        }
        paramBaseArticleInfo = str1;
        localObject1 = paramString;
        for (;;)
        {
          try
          {
            JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray("video_info");
            localObject3 = str1;
            l1 = l2;
            localObject2 = paramString;
            if (localJSONArray != null)
            {
              n = 0;
              localObject3 = str1;
              l1 = l2;
              localObject2 = paramString;
              paramBaseArticleInfo = str1;
              localObject1 = paramString;
              if (n < localJSONArray.length())
              {
                paramBaseArticleInfo = str1;
                localObject1 = paramString;
                JSONObject localJSONObject = localJSONArray.optJSONObject(n);
                if (localJSONObject == null) {
                  continue;
                }
                paramBaseArticleInfo = str1;
                localObject1 = paramString;
                int i2 = localJSONObject.optInt("network_type");
                paramBaseArticleInfo = str1;
                localObject1 = paramString;
                l1 = localJSONObject.optLong("file_size");
                if (i2 != 2) {
                  continue;
                }
                paramBaseArticleInfo = str1;
                localObject1 = paramString;
                localObject2 = String.valueOf(l1);
                paramBaseArticleInfo = str1;
                localObject1 = localObject2;
                localObject3 = localJSONObject.optString("url", "");
                paramBaseArticleInfo = (BaseArticleInfo)localObject3;
                localObject1 = localObject2;
                l1 = localJSONObject.optLong("url_expire_time");
              }
            }
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            Object localObject3 = paramBaseArticleInfo;
            long l1 = l2;
            localObject2 = localObject1;
            continue;
          }
          return str2 + ";" + i1 + ";" + str3 + ";" + str4 + ";" + str5 + ";" + str6 + ";" + m + ";" + str7 + ";" + str8 + ";" + str9 + ";" + str10 + ";" + (String)localObject2 + ";" + (String)localObject3 + ";" + l1;
          n += 1;
        }
      }
    }
    return null;
  }
  
  private static String a(String paramString, MessageForStructing paramMessageForStructing)
  {
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData)) {
      paramString = new JSONObject(paramMessageForStructing.structingMsg.mMsgActionData).optString("push_rowkey");
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "", "", false);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1);
      if (paramInt > 0) {
        localJSONObject.put("from", paramInt);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("video_session_id", paramString2);
      }
      paramString2 = localJSONObject.toString();
      return paramString2;
    }
    catch (JSONException paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  public static String a(String paramString1, String paramString2, ArticleInfo paramArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("kandian_mode", e());
      localJSONObject.put("tab_source", d());
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("feeds_type", a(paramArticleInfo));
      localJSONObject.put("topicId", paramString2);
      localJSONObject.put("proteus_bid", bkwm.a("default_feeds_proteus_offline_bid"));
      return localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return Long.toString(System.currentTimeMillis());
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    int n = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("time", System.currentTimeMillis());
      localJSONObject.put("algorithm_id", paramString1);
      localJSONObject.put("session_id", jdField_f_of_type_JavaLangString);
      if (paramBoolean)
      {
        m = 1;
        localJSONObject.put("avatar", m);
        localJSONObject.put("kd_pos", jdField_e_of_type_Int);
        if (!TextUtils.isEmpty(paramString3)) {
          localJSONObject.put("stick", paramString3);
        }
        if (jdField_d_of_type_Int == 6)
        {
          localJSONObject.put("id", paramString2);
          localJSONObject.put("social_uin", paramString4);
        }
        if (!f()) {
          break label231;
        }
        m = 1;
        label143:
        localJSONObject.put("message_status", m);
        if (bkwm.C(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          break label237;
        }
        m = 1;
        label170:
        localJSONObject.put("reddot_style", m);
        if (!bkwm.C(a())) {
          break label243;
        }
      }
      label231:
      label237:
      label243:
      for (int m = n;; m = 0)
      {
        localJSONObject.put("hemera_switch", m);
        localJSONObject.put("kandian_mode_new", ofe.a());
        paramString1 = localJSONObject.toString();
        return paramString1;
        m = 0;
        break;
        m = 0;
        break label143;
        m = 0;
        break label170;
      }
      return "";
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static String a(String paramString, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if (paramJSONObject != null)
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("card_info");
      if (localJSONObject != null)
      {
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            if (!str.equalsIgnoreCase("reportInfo"))
            {
              paramJSONObject = localJSONObject.getString(str);
              localStringBuilder.append("&");
              paramString = paramJSONObject;
              if (paramJSONObject.contains("&")) {
                paramString = URLEncoder.encode(paramJSONObject, "utf-8");
              }
              localStringBuilder.append(str + "=" + paramString);
            }
          }
          catch (Exception paramString) {}
        }
      }
    }
    localStringBuilder.append("&");
    localStringBuilder.append("readinjoyNotDecodeUrl=1");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, rdn paramrdn, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramString;
    if (paramrdn != null)
    {
      localObject = paramString;
      if (paramBaseArticleInfo != null)
      {
        localObject = paramString;
        if (TextUtils.isEmpty(paramrdn.jdField_c_of_type_JavaLangString)) {}
      }
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mqqapi://readinjoy/open?src_type=internal&target=3").append("&channelID=").append(paramBaseArticleInfo.mChannelID).append("&strategyId=").append(paramrdn.jdField_a_of_type_Int).append("&algorithmID=").append(paramrdn.jdField_b_of_type_Long).append("&title=").append(paramrdn.jdField_a_of_type_JavaLangString).append("&firstPagePicUrl=").append(URLEncoder.encode(paramrdn.jdField_c_of_type_JavaLangString, "UTF-8")).append("&articleID=").append(paramrdn.jdField_a_of_type_Long).append("&subscribeName=").append(paramrdn.jdField_f_of_type_JavaLangString).append("&rowKey=").append(paramrdn.jdField_g_of_type_JavaLangString).append("&subscribeID=").append(paramrdn.jdField_e_of_type_JavaLangString).append("&articleContentUrl=").append(URLEncoder.encode(paramString, "UTF-8")).append("&readinjoyNotDecodeUrl=1");
      localObject = ((StringBuilder)localObject).toString();
      QLog.d("ReadInJoyUtils", 1, "getJumpNativeArticleScheme | polymeric articleScheme : " + (String)localObject);
      return localObject;
    }
    catch (UnsupportedEncodingException paramrdn)
    {
      for (;;)
      {
        localObject = paramString;
      }
    }
  }
  
  public static String a(String paramString, String[] paramArrayOfString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfString == null)) {}
    label65:
    for (;;)
    {
      return null;
      int n = paramArrayOfString.length;
      int m = 0;
      for (;;)
      {
        if (m >= n) {
          break label65;
        }
        String str = paramArrayOfString[m];
        if (str.contains(paramString))
        {
          paramString = str.split("=");
          if ((paramString == null) || (paramString.length != 2)) {
            break;
          }
          return paramString[1];
        }
        m += 1;
      }
    }
  }
  
  /* Error */
  public static String a(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 1766	java/io/StringWriter
    //   5: dup
    //   6: invokespecial 1767	java/io/StringWriter:<init>	()V
    //   9: astore_1
    //   10: new 1769	java/io/PrintWriter
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 1772	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   18: astore_3
    //   19: aload_0
    //   20: aload_3
    //   21: invokevirtual 1777	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   24: aload_3
    //   25: invokevirtual 1780	java/io/PrintWriter:flush	()V
    //   28: aload_1
    //   29: invokevirtual 1781	java/io/StringWriter:flush	()V
    //   32: aload_1
    //   33: ifnull +7 -> 40
    //   36: aload_1
    //   37: invokevirtual 1782	java/io/StringWriter:close	()V
    //   40: aload_3
    //   41: ifnull +7 -> 48
    //   44: aload_3
    //   45: invokevirtual 1783	java/io/PrintWriter:close	()V
    //   48: aload_1
    //   49: invokevirtual 1784	java/io/StringWriter:toString	()Ljava/lang/String;
    //   52: areturn
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 1785	java/io/IOException:printStackTrace	()V
    //   58: goto -18 -> 40
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_2
    //   65: ifnull +7 -> 72
    //   68: aload_2
    //   69: invokevirtual 1782	java/io/StringWriter:close	()V
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 1783	java/io/PrintWriter:close	()V
    //   80: aload_0
    //   81: athrow
    //   82: astore_2
    //   83: aload_2
    //   84: invokevirtual 1785	java/io/IOException:printStackTrace	()V
    //   87: goto -15 -> 72
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_3
    //   93: aload_1
    //   94: astore_2
    //   95: aload_3
    //   96: astore_1
    //   97: goto -33 -> 64
    //   100: astore_0
    //   101: aload_1
    //   102: astore_2
    //   103: aload_3
    //   104: astore_1
    //   105: goto -41 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramThrowable	Throwable
    //   9	96	1	localObject1	Object
    //   1	68	2	localObject2	Object
    //   82	2	2	localIOException	IOException
    //   94	9	2	localObject3	Object
    //   18	86	3	localPrintWriter	java.io.PrintWriter
    // Exception table:
    //   from	to	target	type
    //   36	40	53	java/io/IOException
    //   2	10	61	finally
    //   68	72	82	java/io/IOException
    //   10	19	90	finally
    //   19	32	100	finally
  }
  
  public static String a(ArrayList<DislikeInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return "";
    }
    localJSONArray = new JSONArray();
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("type", localDislikeInfo.jdField_a_of_type_Int);
        localJSONObject.put("name", localDislikeInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("tagid", localDislikeInfo.jdField_a_of_type_Long);
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray.toString();
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  private static String a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if ((paramMap != null) && (!paramMap.containsKey(paramString1))) {
      return "&" + paramString1 + "=" + paramString2;
    }
    return "";
  }
  
  public static String a(JSONObject paramJSONObject)
  {
    int m = 1;
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      if (bkwm.C(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
      for (;;)
      {
        localJSONObject.put("reddot_style", m);
        localJSONObject.put("kandian_mode", e());
        localJSONObject.put("kandian_mode_new", ofe.a());
        localJSONObject.put("tab_source", d());
        localJSONObject.put("session_id", jdField_f_of_type_JavaLangString);
        paramJSONObject = localJSONObject.toString();
        return paramJSONObject;
        m = 0;
      }
      return "";
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static String a(articlesummary.ChannelInfo paramChannelInfo)
  {
    if (paramChannelInfo == null) {
      return null;
    }
    return paramChannelInfo.bytes_channel_name.get().toStringUtf8();
  }
  
  public static BigInteger a(long paramLong)
  {
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    if (paramLong >= 0L) {
      return localBigInteger;
    }
    return localBigInteger.add(jdField_a_of_type_JavaMathBigInteger);
  }
  
  public static URL a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    paramBaseArticleInfo = a(paramString);
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.length() > 0))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.optJSONObject(0);
      if (paramBaseArticleInfo != null) {
        try
        {
          paramBaseArticleInfo = uet.a(paramBaseArticleInfo.optString("picture"), 3);
          return paramBaseArticleInfo;
        }
        catch (Exception paramBaseArticleInfo)
        {
          paramBaseArticleInfo.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static URL a(String paramString)
  {
    return a(paramString, true);
  }
  
  public static URL a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!paramBoolean) {
      try
      {
        paramString = new URL(paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        paramString.fillInStackTrace();
        return null;
      }
    }
    return uet.a(paramString, 3);
  }
  
  public static URL a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (b(paramString)) {
      if (!paramBoolean1) {
        break label57;
      }
    }
    label57:
    for (localObject = pai.e();; localObject = pai.a())
    {
      localObject = a(paramString, ((Integer)((Pair)localObject).second).intValue(), ((Integer)((Pair)localObject).first).intValue(), 3);
      return a((String)localObject);
    }
  }
  
  public static List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (jdField_a_of_type_JavaUtilQueue != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilQueue.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Integer)localIterator.next());
      }
    }
    return localArrayList;
  }
  
  public static List<String> a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForStructing))) {}
    do
    {
      do
      {
        return null;
        paramMessageRecord = (MessageForStructing)paramMessageRecord;
        paramMessageRecord.parse();
      } while ((paramMessageRecord.structingMsg == null) || (TextUtils.isEmpty(paramMessageRecord.structingMsg.mArticleIds)));
      paramMessageRecord = paramMessageRecord.structingMsg.mArticleIds.split("\\|");
    } while (paramMessageRecord.length <= 0);
    return Arrays.asList(paramMessageRecord);
  }
  
  public static Properties a(String paramString)
  {
    Properties localProperties = new Properties();
    try
    {
      localProperties.load(new StringReader(paramString));
      return localProperties;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static AppRuntime a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  public static JSONArray a()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Object localObject = (String)bkwm.a("key_study_mode_grade_choose", "");
      QLog.d("ReadInJoyUtils", 1, "getSelectedGrades error! result= " + (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONArray((String)localObject);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyUtils", 1, "getSelectedGrades error! msg= " + localException);
    }
    return localJSONArray;
  }
  
  private static JSONArray a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = (JSONObject)new JSONTokener(paramString).nextValue();
        if ((paramString != null) && (!TextUtils.isEmpty(paramString.toString())))
        {
          paramString = paramString.optJSONArray("videos");
          if (paramString != null)
          {
            int m = paramString.length();
            if (m >= 1) {
              continue;
            }
          }
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static JSONArray a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if (paramJSONArray2 == null) {
      return paramJSONArray1;
    }
    int m = 0;
    for (;;)
    {
      try
      {
        if ((m >= paramJSONArray1.length()) || (m >= paramJSONArray2.length())) {
          break;
        }
        if (((paramJSONArray2.get(m) instanceof JSONObject)) && ((paramJSONArray1.get(m) instanceof JSONObject)))
        {
          JSONObject localJSONObject1 = (JSONObject)paramJSONArray2.get(m);
          JSONObject localJSONObject2 = (JSONObject)paramJSONArray1.get(m);
          Iterator localIterator = localJSONObject1.keys();
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject2.put(str, localJSONObject1.get(str));
            continue;
          }
        }
        m += 1;
      }
      catch (Exception paramJSONArray2)
      {
        QLog.e("ReadInJoyUtils", 2, "setCellArray:remoteArray: ", paramJSONArray2);
        return paramJSONArray1;
      }
    }
  }
  
  public static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("session_id", jdField_f_of_type_JavaLangString);
      localJSONObject.put("kandian_mode_new", ofe.a());
      localJSONObject.put("algorithm_id", jdField_a_of_type_Rdh.jdField_a_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static JSONObject a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt3, int paramInt4, ArticleInfo paramArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (ofe.jdField_a_of_type_JavaLangString == null) {
          ofe.jdField_a_of_type_JavaLangString = "8.4.8".replace(".", "");
        }
        int n = ReadInJoyBaseFragment.a(paramInt2);
        boolean bool = a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo);
        int m = i();
        pbl localpbl = new pbl().a(paramLong).a(e(paramInt2)).a(paramInt1).a().b(paramInt2);
        if (paramBoolean)
        {
          paramInt1 = 2;
          paramString1 = localpbl.c(paramInt1).b(paramString1).c(i()).d(j()).e(jdField_f_of_type_JavaLangString).I(paramInt2).b(paramInt2, paramArticleInfo).g(paramString2).h(paramString3).b(paramArticleInfo, a(paramArticleInfo));
          if (bkwm.C(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
            break label701;
          }
          paramInt1 = 1;
          paramString1 = paramString1.d(paramInt1).a(a(paramArticleInfo)).e(e()).f(ofe.a()).g(paramInt4).h(paramInt3).s(paramArticleInfo);
          if (!bkwm.C(a())) {
            break label706;
          }
          paramInt1 = 1;
          paramString2 = paramString1.j(paramInt1).i(bkwm.a("default_feeds_proteus_offline_bid")).c().k(b(paramArticleInfo)).r(paramArticleInfo).b(pbl.a(paramArticleInfo)).m(ofe.jdField_a_of_type_JavaLangString).n("1").H(paramInt2).a(a(), paramString2, paramArticleInfo).b();
          if (bgoa.a() != 1) {
            break label711;
          }
          paramString1 = "1";
          paramString1 = paramString2.q(paramString1).q(paramArticleInfo).a(paramArticleInfo, g(paramArticleInfo)).p(paramArticleInfo).n(n).o(paramArticleInfo).G(paramInt2);
          if (!o()) {
            break label718;
          }
          paramInt1 = 1;
          paramString2 = paramString1.o(paramInt1).n(paramArticleInfo).s("" + paramArticleInfo.isSuperTop);
          if (TextUtils.isEmpty(paramArticleInfo.mReportCommonData)) {
            break label723;
          }
          paramString1 = paramArticleInfo.mReportCommonData;
          paramString2 = paramString2.B(paramString1);
          if (TextUtils.isEmpty(Build.BRAND)) {
            break label730;
          }
          paramString1 = Build.BRAND;
          paramString2 = paramString2.t(paramString1);
          if (!TextUtils.isEmpty(Build.MODEL))
          {
            paramString1 = Build.MODEL;
            paramString1 = paramString2.u(paramString1).m(paramArticleInfo).t(c(paramArticleInfo)).l(paramArticleInfo).k(paramArticleInfo).a(paramArticleInfo, bool, m).a(paramInt2, paramArticleInfo).F(paramInt2).j(paramArticleInfo).i(paramArticleInfo).h(paramArticleInfo).g(paramArticleInfo);
            if (jdField_c_of_type_Boolean)
            {
              paramInt1 = 1;
              paramString1 = paramString1.z(paramInt1).f(paramArticleInfo).e(paramArticleInfo).c("default_feeds_aladdin_keys", (String)bkwm.a("default_feeds_aladdin_keys", "")).a(paramArticleInfo, a(Long.valueOf(paramArticleInfo.mArticleID))).d(paramArticleInfo);
              if (!paramArticleInfo.hasWalletIcon) {
                continue;
              }
              paramInt1 = 1;
              return paramString1.C(paramInt1).a(paramArticleInfo).b(paramArticleInfo).c(paramArticleInfo).t(paramArticleInfo).a();
            }
          }
          else
          {
            paramString1 = "";
            continue;
          }
          paramInt1 = 0;
          continue;
          paramInt1 = 0;
          continue;
        }
        paramInt1 = 1;
      }
      catch (JSONException paramString1)
      {
        QLog.e("ReadInJoyUtils", 2, "transMergeKandianReportR5WithTime error r5: " + localJSONObject.toString() + " error: " + paramString1.getMessage());
        return localJSONObject;
      }
      continue;
      label701:
      paramInt1 = 0;
      continue;
      label706:
      paramInt1 = 0;
      continue;
      label711:
      paramString1 = "0";
      continue;
      label718:
      paramInt1 = 0;
      continue;
      label723:
      paramString1 = "";
      continue;
      label730:
      paramString1 = "";
    }
  }
  
  public static JSONObject a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("algorithm_id", paramArticleInfo.mAlgorithmID);
        localJSONObject.put("puin_type", paramString);
        localJSONObject.put("feeds_type", a(paramArticleInfo));
        localJSONObject.put("source", a(paramInt));
        localJSONObject.put("is_fans", d(paramArticleInfo));
        localJSONObject.put("kandian_mode", e());
        localJSONObject.put("session_id", jdField_f_of_type_JavaLangString);
        localJSONObject.put("mp_article_id", paramArticleInfo.mArticleID);
        localJSONObject.put("channel_id", paramInt);
        if (NetworkUtil.isWifiConnected(paramContext))
        {
          paramInt = 1;
          localJSONObject.put("network_type", paramInt);
          localJSONObject.put("os", "1");
          localJSONObject.put("version", "8.4.8".replace(".", ""));
          localJSONObject.put("imei", i());
          localJSONObject.put("imsi", j());
          if (a(paramArticleInfo))
          {
            localJSONObject.put("likes", paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int);
            localJSONObject.put("biu", paramArticleInfo.mSocialFeedInfo.jdField_f_of_type_Int);
            return localJSONObject;
          }
          localJSONObject.put("likes", 0);
          localJSONObject.put("biu", 0);
          return localJSONObject;
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return localJSONObject;
      }
      paramInt = 2;
    }
  }
  
  public static JSONObject a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = a(paramContext, paramArticleInfo, paramInt1, paramString);
    try
    {
      paramContext.put("biu_state", paramInt2);
      return paramContext;
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
    return paramContext;
  }
  
  private static JSONObject a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return paramString.optJSONObject(0);
  }
  
  public static JSONObject a(String paramString1, String paramString2, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("hotword", paramString1);
      localJSONObject.put("rowKey", paramString2);
      localJSONObject.put("hotword_number", paramInt);
      localJSONObject.put("jump_type", 0);
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      QLog.e("ReadInJoyUtils", 1, "transMergeKandianPeportR5WithTime, hotword = , rowKey = " + paramString2 + ", hotword_number = " + paramInt + ", jump_type = " + 0);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(rdr paramrdr)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", jdField_d_of_type_Int);
        localJSONObject.put("kandian_mode", String.valueOf(e()));
        localJSONObject.put("tab_source", d());
        m = -1;
        switch (paramrdr.jdField_a_of_type_Int)
        {
        default: 
          localJSONObject.put("use_type", m);
          if (m == 2)
          {
            l1 = paramrdr.jdField_b_of_type_Long;
            localJSONObject.put("type_id", l1);
            localJSONObject.put("algorithm_id", paramrdr.e);
            return localJSONObject;
          }
          long l1 = paramrdr.jdField_f_of_type_Long;
          continue;
          continue;
        }
      }
      catch (JSONException paramrdr)
      {
        paramrdr.printStackTrace();
        return localJSONObject;
      }
      int m = 2;
      continue;
      m = 1;
      continue;
      m = 3;
    }
  }
  
  public static pbg a()
  {
    pbg localpbg = new pbg();
    try
    {
      localpbg.i();
      localpbg.j();
      localpbg.k();
      localpbg.m();
      localpbg.l();
      return localpbg;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localpbg;
  }
  
  public static pbg a(int paramInt1, long paramLong, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    pbg localpbg = new pbg();
    try
    {
      paramString1 = localpbg.a(paramLong).b().c().k(paramInt2).a(paramInt1).l().c(paramString1).j().k().b(paramString2).f(paramInt3).g(paramInt4).h(paramInt5).i(paramInt6).j(paramInt7).d().e().f().g();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return localpbg;
  }
  
  public static pbg a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    localpbg1 = new pbg();
    try
    {
      pbg localpbg2 = localpbg1.b().c().a(paramInt1).e().f().g().h().a(paramString).d(paramInt2).e(paramInt3).a();
      if (paramBoolean) {}
      for (paramString = "1";; paramString = "2")
      {
        localpbg2.a("refresh_way", paramString).i().m();
        if (paramInt4 == -1) {
          break;
        }
        localpbg1.a("pull_image", String.valueOf(paramInt4));
        return localpbg1;
      }
      return localpbg1;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static pbg a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null))
    {
      SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
      Object localObject;
      int m;
      if (pgb.a(paramArticleInfo))
      {
        localObject = paramArticleInfo.mSubscribeID;
        if (localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList == null) {
          break label171;
        }
        m = localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList.size();
        label49:
        if (!TextUtils.isEmpty(localSocializeFeedsInfo.jdField_a_of_type_JavaLangString)) {
          break label176;
        }
      }
      label171:
      label176:
      for (int n = 0;; n = 1)
      {
        int i1 = localSocializeFeedsInfo.jdField_b_of_type_Int;
        int i2 = localSocializeFeedsInfo.jdField_d_of_type_Int;
        int i3 = localSocializeFeedsInfo.jdField_f_of_type_Int;
        return a((int)paramArticleInfo.mChannelID, paramArticleInfo.mAlgorithmID, paramArticleInfo.mFeedType, (String)localObject, paramArticleInfo.innerUniqueID, m + 1, n, i1, i2, i3);
        StringBuilder localStringBuilder = new StringBuilder().append("");
        if (localSocializeFeedsInfo.jdField_a_of_type_Rer != null) {}
        for (localObject = Long.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long);; localObject = "")
        {
          localObject = localObject;
          break;
        }
        m = 0;
        break label49;
      }
    }
    return new pbg();
  }
  
  public static void a()
  {
    n = 0;
    try
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label168;
      }
      localObject = ((QQAppInterface)localObject).getMessageFacade();
      if (localObject == null) {
        break label168;
      }
      localObject = ((QQMessageFacade)localObject).getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
      m = n;
      if (localObject != null)
      {
        m = n;
        if (((MessageRecord)localObject).extInt != 1)
        {
          if (((MessageRecord)localObject).extInt != 3) {
            break label203;
          }
          m = n;
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          boolean bool;
          jdField_d_of_type_Int = Integer.parseInt(((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue);
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "update mergefolder status " + jdField_d_of_type_Int);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "current mergefolder status is " + jdField_d_of_type_Int);
          }
          return;
          if (((MessageRecord)localObject).extInt != 2)
          {
            m = n;
            if (((MessageRecord)localObject).extInt != 4) {
              continue;
            }
            continue;
            if (m == 0)
            {
              jdField_d_of_type_Int = 3;
              continue;
              localException1 = localException1;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ReadInJoyUtils", 2, "obtainMergeKandianFolderStatus except " + localException1.toString());
              continue;
            }
            if (m != 1) {
              continue;
            }
            jdField_d_of_type_Int = 2;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
          int m = 1;
        }
      }
    }
    if ((localObject != null) && (((MessageRecord)localObject).isread))
    {
      jdField_d_of_type_Int = 1;
      if ((localObject != null) && ((localObject instanceof MessageForStructing)))
      {
        localObject = (MessageForStructing)localObject;
        if (((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue != null)
        {
          bool = TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue);
          if (bool) {}
        }
      }
    }
  }
  
  public static void a(float paramFloat, Resources paramResources)
  {
    if ((paramFloat == 0.0F) || (paramResources == null)) {
      return;
    }
    jdField_a_of_type_Int = (int)(paramFloat / paramResources.getDimensionPixelSize(2131298795) + 0.5F);
  }
  
  public static void a(int paramInt)
  {
    jdField_d_of_type_Int = paramInt;
    jdField_a_of_type_Rdh.jdField_a_of_type_Int = jdField_d_of_type_Int;
    SPEventReportSwitch.a(paramInt);
    QLog.d("ReadInJoyUtils", 1, new Object[] { "update fs : ", Integer.valueOf(paramInt) });
  }
  
  public static void a(int paramInt, long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyUtils.24(paramInt, System.currentTimeMillis() - paramLong));
  }
  
  public static void a(int paramInt, long paramLong, sdg paramsdg, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    sie localsie = new sie("", "", "", "").a(paramInt).b(paramLong);
    if (paramsdg != null) {
      localsie.e(paramsdg.jdField_g_of_type_Long).c(paramsdg.jdField_g_of_type_Int);
    }
    if (paramBaseArticleInfo != null) {
      localsie.h(paramBaseArticleInfo.innerUniqueID).E(a(paramBaseArticleInfo));
    }
    if (paramBoolean) {}
    for (paramsdg = "1";; paramsdg = "0")
    {
      odq.a(null, "", "0X8007DBB", "0X8007DBB", 0, 0, paramsdg, "", "", localsie.a().a(), false);
      return;
    }
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mOperation = paramInt1;
      localReportInfo.mSourceArticleId = Long.valueOf(paramString1).longValue();
      localReportInfo.mAlgorithmId = Integer.valueOf(paramString3).intValue();
      localReportInfo.mStrategyId = Integer.valueOf(paramString2).intValue();
      localReportInfo.mUin = a();
      if (TextUtils.isEmpty(paramString4)) {}
      for (long l1 = -1L;; l1 = Long.valueOf(paramString4).longValue())
      {
        localReportInfo.mPuin = l1;
        paramInt1 = paramInt2;
        if (paramInt2 == -1) {
          paramInt1 = jdField_d_of_type_Int;
        }
        localReportInfo.mFolderStatus = paramInt1;
        localArrayList.add(localReportInfo);
        new pwu(null, null, qli.a(), null).b(localArrayList);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("ReadInJoyUtils", 1, "reportRealTimeKandianAction error ", paramString1);
    }
  }
  
  public static void a(int paramInt, List<bjsy> paramList)
  {
    bjsy localbjsy;
    if ((paramInt & 0x1) != 0)
    {
      localbjsy = new bjsy();
      localbjsy.jdField_a_of_type_Int = 0;
      localbjsy.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131717346);
      localbjsy.jdField_b_of_type_Int = 2130842858;
      paramList.add(localbjsy);
    }
    if ((paramInt & 0x2) != 0)
    {
      localbjsy = new bjsy();
      localbjsy.jdField_a_of_type_Int = 1;
      localbjsy.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131717350);
      localbjsy.jdField_b_of_type_Int = 2130842859;
      paramList.add(localbjsy);
    }
  }
  
  public static void a(int paramInt, List<TopicInfo> paramList, String paramString)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TopicInfo localTopicInfo = (TopicInfo)paramList.next();
        if (localTopicInfo != null) {
          a("0X8009817", paramInt, localTopicInfo.a(), paramString);
        }
      }
    }
  }
  
  public static void a(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "0X800A189";; str = "0X800A18A")
    {
      odq.a(null, null, str, str, 0, 0, "", "", "", new sie(null, null, null, null).e(paramLong).a().a(), false);
      return;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    a(paramActivity, null);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return;
    }
    if ((paramArticleInfo.mArticleContentUrl != null) && (paramArticleInfo.mArticleContentUrl.startsWith("mqqapi:")))
    {
      String str = paramArticleInfo.mArticleContentUrl;
      localObject = str;
      if (i(str)) {
        localObject = c(str, paramArticleInfo);
      }
      d(paramActivity, (String)localObject);
      b(paramArticleInfo, paramArticleInfo.mArticleContentUrl);
      return;
    }
    sxd.a("FastWebActivity.show");
    pkm.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    Object localObject = new Intent(paramActivity, FastWebActivity.class);
    ((Intent)localObject).putExtra("fast_web_article_info", paramArticleInfo);
    paramActivity.startActivityForResult((Intent)localObject, 10922);
    QLog.d("ReadInJoyUtils", 1, "startWebFastActivity, rowkey= " + paramArticleInfo.innerUniqueID);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, slt paramslt, int paramInt)
  {
    a(paramActivity, paramArticleInfo, paramslt, paramInt);
    pkm.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramslt.notifyDataSetChanged();
    if (vfx.a(paramArticleInfo))
    {
      paramslt = new Intent(paramActivity, PublicAccountImageCollectionMainActivity.class);
      paramslt.putExtra("source_for_report", 9);
      vfx.a(paramActivity, paramslt, String.valueOf(paramArticleInfo.innerUniqueID));
      return;
    }
    paramInt = paramslt.a();
    long l1 = paramArticleInfo.mRecommendSeq;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (pgb.h(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!pgb.l(paramArticleInfo)) {
        localObject1 = ((rgc)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rga.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString;
      }
    }
    localObject2 = localObject1;
    if (!(paramArticleInfo instanceof AdvertisementInfo)) {
      if (!((String)localObject1).contains("?")) {
        break label229;
      }
    }
    label229:
    for (localObject1 = (String)localObject1 + "&";; localObject1 = (String)localObject1 + "?")
    {
      localObject2 = (String)localObject1 + "from=0";
      if (!d((String)localObject2)) {
        break;
      }
      c(paramActivity, (String)localObject2);
      return;
    }
    localBundle.putString("url", (String)localObject2);
    localBundle.putBoolean("hide_operation_bar", true);
    localBundle.putString("from", String.valueOf(53));
    localBundle.putString("subscribename", paramArticleInfo.mSubscribeName);
    localBundle.putLong("articleid", paramArticleInfo.mArticleID);
    localBundle.putLong("recommendSeq", l1);
    localBundle.putInt("channelid", paramInt);
    localBundle.putInt("strategyid", paramArticleInfo.mStrategyId);
    localBundle.putLong("algorithmid", paramArticleInfo.mAlgorithmID);
    localBundle.putInt("articalChannelId", 9);
    localBundle.putStringArray("insertPluginsArray", new String[] { "pubAccountPreload" });
    localBundle.putBoolean("ip_connect", uex.m);
    l1 = System.currentTimeMillis();
    localBundle.putLong("startOpenPageTime", l1);
    localBundle.putLong("click_time", l1);
    localBundle.putLong("available_memory", DeviceInfoUtil.getSystemAvaialbeMemory());
    localBundle.putBoolean("preload_tool_white_list", h());
    Intent localIntent = new Intent(paramActivity, ReadInJoyArticleDetailActivity.class);
    localObject2 = PreloadManager.a((String)localObject2);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if ((FileUtils.fileExistsAndNotEmpty(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD + (String)localObject1)) && (PreloadManager.a().b((String)localObject1) != null))
    {
      localBundle.putString("read_in_joy_from_cache", (String)localObject1);
      if (!paramslt.a(paramInt, paramArticleInfo.mArticleID))
      {
        paramArticleInfo = PreloadManager.a();
        if ((NetworkState.getNetworkType() != 1) && (NetworkState.getNetworkType() != 4) && (NetworkState.getNetworkType() != 5)) {
          break label662;
        }
        paramslt = paramArticleInfo.a((String)localObject1);
        if ((paramslt != null) && (paramslt.size() > 0))
        {
          ThreadManager.post(new ReadInJoyUtils.23(paramArticleInfo, (uen)paramslt.get(0)), 5, null, false);
          if (paramslt.size() <= 1) {
            break label650;
          }
          localBundle.putString("preload_iamge_url", ((uen)paramslt.get(1)).jdField_a_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      localIntent.putExtras(localBundle);
      paramActivity.startActivityForResult(localIntent, 9991);
      tpo.a.a(paramActivity);
      return;
      label650:
      localBundle.putString("preload_iamge_url", null);
      continue;
      label662:
      paramArticleInfo = paramArticleInfo.a((String)localObject1);
      if ((paramArticleInfo != null) && (paramArticleInfo.size() > 0)) {
        localBundle.putString("preload_iamge_url", ((uen)paramArticleInfo.get(0)).jdField_a_of_type_JavaLangString);
      } else {
        localBundle.putString("preload_iamge_url", null);
      }
    }
  }
  
  public static void a(Activity paramActivity, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    UniteSearchActivity.a(paramActivity, "", 25, 0L, paramHotSearchItem, 0);
    odq.a(null, "CliOper", "", "", "0X80067D3", "0X80067D3", 0, 0, "", "", "", f(), false);
  }
  
  @TargetApi(23)
  public static void a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, SystemBarCompact paramSystemBarCompact)
  {
    if ((paramActivity == null) || (paramSystemBarCompact == null)) {}
    while ((!paramBoolean) || (ImmersiveUtils.isSupporImmersive() != 1)) {
      return;
    }
    paramActivity.getWindow().addFlags(67108864);
    paramSystemBarCompact.init();
    if (ThemeUtil.isNowThemeIsNight(a(), false, null))
    {
      if ((!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme()))
      {
        paramSystemBarCompact.setStatusBarColor(-7829368);
        return;
      }
      paramSystemBarCompact.setStatusBarColor(-7829368);
      paramSystemBarCompact.setStatusBarDarkMode(true);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme()))
    {
      a(paramActivity, true);
      paramSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!SystemUtil.isFlyme())
    {
      paramSystemBarCompact.setStatusBarColor(-2368549);
      return;
    }
    paramSystemBarCompact.setStatusBarColor(-1);
    paramSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, false);
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    a(paramContext, paramInt, paramBoolean, "");
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean, String paramString)
  {
    int m = 2;
    Object localObject1 = (KandianMergeManager)a().getManager(162);
    int n = ((KandianMergeManager)localObject1).d();
    localObject1 = ((KandianMergeManager)localObject1).a();
    String str;
    if ((localObject1 == null) || (TextUtils.isEmpty(((KandianMsgBoxRedPntInfo)localObject1).mJumpUrl)))
    {
      str = paa.jdField_h_of_type_JavaLangString + n + "&message_entry=" + paramInt;
      localObject1 = tgc.a(a()) + "&adtag=1&privateLetters=" + n + "&message_entry=" + paramInt;
      Object localObject2 = localObject1;
      if (paramBoolean)
      {
        n = DisplayUtil.px2dip(paramContext, (float)DeviceInfoUtil.getHeight()) / 3;
        localObject2 = (String)localObject1 + "&v_present_radius=10&v_present=2&v_rij_floating=1&v_present_bar=0&v_nav_immer=1&hideNav=1&v_present_auto_top=0&v_present_top=" + n;
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString)) {
        localObject1 = (String)localObject2 + "&msgId=" + paramString;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "person message box url: " + str);
      }
      if (!Boolean.valueOf(bkwm.u(a())).booleanValue()) {
        break label406;
      }
      paramString = new Bundle();
      if (paramInt != 6) {
        break label396;
      }
      paramInt = m;
    }
    for (;;)
    {
      if (paramInt != -1) {
        paramString.putInt("floating_window_scene", paramInt);
      }
      paramString.putInt("requestCode", 20001);
      tgc.a(paramContext, amtj.a(2131712223), (String)localObject1, paramString);
      return;
      str = ((KandianMsgBoxRedPntInfo)localObject1).mJumpUrl + "&privateLetters=" + n + "&message_entry=" + paramInt;
      localObject1 = tgc.a(a()) + "&adtag=2&privateLetters=" + n + "&message_entry=" + paramInt;
      break;
      label396:
      if (paramInt == 5)
      {
        paramInt = 3;
        continue;
        label406:
        paramString = new Bundle();
        paramString.putInt("requestCode", 20001);
        a(paramContext, str, paramString);
      }
      else
      {
        paramInt = -1;
      }
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mGalleryFeedsInfo != null) && (paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
    {
      paramArticleInfo = Uri.parse(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8()).buildUpon();
      paramArticleInfo.appendQueryParameter("showComment", "1");
      paramArticleInfo = paramArticleInfo.toString();
      d(paramContext, paramArticleInfo);
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyUtils", 2, "jumpToGallery url=" + paramArticleInfo);
      }
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    a(paramContext, paramArticleInfo, paramInt, false, 0, false);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyUtils", 1, "jumpNewSocialSecondPage: " + paramArticleInfo + " type: " + paramInt1 + " shallNotReport: " + paramBoolean + " from: " + paramInt2 + " jumpType: " + paramInt3);
    if ((paramContext == null) || (paramArticleInfo == null)) {
      return;
    }
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    String str = a(a(paramArticleInfo, paramInt1), paramArticleInfo, paramInt1, paramInt3);
    Bundle localBundle = new Bundle();
    rtb localrtb;
    if (rtb.a(paramArticleInfo))
    {
      localrtb = rtb.a();
      if ((paramInt1 != 1) && (paramInt1 != 3)) {
        break label186;
      }
    }
    label186:
    for (boolean bool = true;; bool = false)
    {
      localrtb.a(paramArticleInfo, bool, str);
      QLog.d("ReadInJoyUtils", 1, "jumpNewSocialSecondPage, url:" + str);
      a(paramContext, str, localBundle);
      if (paramBoolean) {
        break;
      }
      a(paramArticleInfo, paramInt1, paramInt2);
      return;
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
    for (int m = 2;; m = 0)
    {
      a(paramContext, paramArticleInfo, paramInt1, paramBoolean1, paramInt2, m);
      return;
    }
  }
  
  @Deprecated
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, slt paramslt, int paramInt)
  {
    if ((paramArticleInfo == null) || (paramslt == null)) {
      return;
    }
    int i1 = paramslt.a();
    int m;
    if (paramArticleInfo.hasChannelInfo())
    {
      m = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label584;
      }
    }
    label584:
    for (int n = 0;; n = 1)
    {
      paramslt = d(paramArticleInfo);
      odq.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), i1, m), false);
      odq.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, m));
      localObject1 = uhv.b(i1);
      odq.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject1, (String)localObject1, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), i1, m, n, NetworkUtil.isWifiConnected(paramContext), paramslt, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, f(paramArticleInfo), paramArticleInfo), false);
      odq.a((String)localObject1, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), i1, m, n, NetworkUtil.isWifiConnected(paramContext), paramslt, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, f(paramArticleInfo), paramArticleInfo));
      paramContext = new ArrayList();
      paramslt = new ReportInfo();
      paramslt.mUin = a();
      paramslt.mSource = 0;
      paramslt.mSourceArticleId = paramArticleInfo.mArticleID;
      paramslt.mChannelId = i1;
      paramslt.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      paramslt.mStrategyId = paramArticleInfo.mStrategyId;
      paramslt.mOperation = 1;
      paramslt.mServerContext = paramArticleInfo.mServerContext;
      paramslt.mReadTimeLength = -1;
      paramslt.mInnerId = paramArticleInfo.innerUniqueID;
      if ((paramArticleInfo != null) && (!rbt.c(paramArticleInfo)) && (!pau.a().a()) && (a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
        paramslt.noDifferenceJump = 1;
      }
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label596;
      }
      localObject1 = new rdy();
      ((rdy)localObject1).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer != null) {
        ((rdy)localObject1).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long;
      }
      ((rdy)localObject1).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((rdy)localObject1).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      Object localObject2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
        break label590;
      }
      ((rdy)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        rer localrer = (rer)((Iterator)localObject2).next();
        if (localrer != null) {
          ((rdy)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrer.jdField_a_of_type_Long));
        }
      }
      m = 0;
      break;
    }
    label590:
    paramslt.mFeedsReportData = ((rdy)localObject1);
    label596:
    Object localObject1 = pau.a().a();
    if (localObject1 != null) {
      paramslt.srtClickInfo = ((oidb_cmd0x64e.SRTClickInfo)localObject1);
    }
    paramContext.add(paramslt);
    pkm.a().a(paramContext);
    pma.a.b(i1, paramArticleInfo);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    a(paramContext, paramArticleInfo, 0, false, 0, paramBoolean);
  }
  
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramContext != null) && (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null)) {}
    try
    {
      oju localoju = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Oju;
      b(localoju, paramBaseArticleInfo);
      a(paramContext, localoju);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    paramString = a(paramBaseArticleInfo, paramString);
    QLog.d("ReadInJoyUtils", 1, "jumpTo |  scheme : " + paramString);
    b(paramBaseArticleInfo, paramString);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      QLog.d("ReadInJoyUtils", 1, "context or scehme null");
    }
    while (prt.a(paramContext, paramString)) {
      return;
    }
    a(paramContext, paramString, null);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, null);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    QLog.d("ReadInJoyUtils", 1, "jumpTo: " + paramString + " extraData: " + paramBundle);
    if ((paramContext == null) || (paramString == null)) {}
    do
    {
      return;
      if (!(paramContext instanceof BasePluginActivity)) {
        break;
      }
      paramContext = ((BasePluginActivity)paramContext).getOutActivity();
    } while (paramContext == null);
    for (;;)
    {
      Object localObject = tgc.b(paramString);
      if ((tgc.b(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        tgc.a(paramContext, null, (String)localObject, paramBundle);
        return;
      }
      if ((paramString.startsWith("http://clientui.3g.qq.com/mqqapi/")) || (paramString.startsWith("http://clientui.3g.qq.com/mqq/")) || (paramString.startsWith("http://qm.qq.com/cgi-bin/")) || (paramString.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard"))) {}
      for (int m = 1;; m = 0)
      {
        if (paramString.startsWith("https://m.gamefeeds.qq.com/live.html?"))
        {
          LiveRoomProxyActivity.open((Activity)paramContext, paramString, "kandian feed click");
          return;
        }
        if ((m == 0) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("url", paramString);
          ((Bundle)localObject).putBoolean("hide_operation_bar", true);
          paramString = new Intent(paramContext, QQBrowserActivity.class);
          paramString.putExtra("big_brother_source_key", f(0));
          paramString.putExtras((Bundle)localObject);
          paramString.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
          if (paramBundle != null)
          {
            paramString.putExtras(paramBundle);
            if ((paramBundle.containsKey("requestCode")) && ((paramContext instanceof Activity)))
            {
              ((Activity)paramContext).startActivityForResult(paramString, paramBundle.getInt("requestCode", -1));
              return;
            }
          }
          paramContext.startActivity(paramString);
          return;
        }
        paramBundle = new Intent(paramContext, JumpActivity.class);
        paramString = Uri.parse(paramString);
        paramBundle.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        paramBundle.putExtra("big_brother_source_key", f(0));
        paramBundle.setData(paramString);
        paramContext.startActivity(paramBundle);
        return;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    ThreadManager.post(new ReadInJoyUtils.6(paramContext, paramString, paramHashMap), 5, null, true);
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(a(paramContext)));
    ThreadManager.post(new ReadInJoyUtils.4(paramHashMap, paramBoolean, paramContext, paramString), 5, null, true);
  }
  
  public static void a(Context paramContext, oju paramoju)
  {
    if ((paramContext != null) && (paramoju != null) && (!TextUtils.isEmpty(paramoju.jdField_c_of_type_JavaLangString)))
    {
      if (1 == paramoju.jdField_b_of_type_Int) {
        d(paramContext, paramoju.jdField_c_of_type_JavaLangString);
      }
      odq.a(null, null, "0X8009BD5", "0X8009BD5", 0, 0, "", "", "", paramoju.a(), false);
    }
  }
  
  private static void a(Intent paramIntent, MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing.structingMsg.mExtraData != null) {
      paramIntent.putExtra("arg_channel_cover_id", Integer.parseInt(new JSONObject(paramMessageForStructing.structingMsg.mExtraData).optString("channel_id", "0")));
    }
  }
  
  public static void a(View paramView)
  {
    if (paramView != null)
    {
      paramView.setBackgroundResource(0);
      if (ThemeUtil.isNowThemeIsNight(a(), false, null)) {
        paramView.setBackgroundColor(Color.parseColor("#888888"));
      }
    }
    else
    {
      return;
    }
    paramView.setBackgroundColor(-1);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramView.getParent() instanceof View)) {
      a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, (View)paramView.getParent());
    }
  }
  
  public static void a(View paramView1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView2)
  {
    paramView2.post(new ReadInJoyUtils.21(paramView1, paramInt1, paramInt2, paramInt3, paramInt4, paramView2));
  }
  
  public static void a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    for (;;)
    {
      return;
      qmf.a(paramArticleInfo);
      try
      {
        Object localObject = new JSONObject(paramArticleInfo.proteusItemsData);
        QLog.d("ReadInJoyUtils", 2, new Object[] { "mArticleInfo.proteusItemsData = ", paramArticleInfo.proteusItemsData });
        localObject = ((JSONObject)localObject).keys();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!"id_super_topic".equals((String)((Iterator)localObject).next()));
        paramArticleInfo.isSuperTopic = true;
        return;
      }
      catch (JSONException paramArticleInfo)
      {
        QLog.d("ReadInJoyUtils", 2, "preParseProteusItemData", paramArticleInfo);
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
    localReportInfo.mChannelId = paramInt;
    localReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
    localReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
    localReportInfo.mOperation = 1;
    localReportInfo.mServerContext = paramArticleInfo.mServerContext;
    localReportInfo.mReadTimeLength = -1;
    localReportInfo.mInnerId = paramArticleInfo.innerUniqueID;
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      rdy localrdy = new rdy();
      localrdy.jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer != null) {
        localrdy.jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long;
      }
      localrdy.jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localrdy.jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
      {
        localrdy.jdField_a_of_type_JavaUtilList = new ArrayList();
        paramArticleInfo = paramArticleInfo.iterator();
        while (paramArticleInfo.hasNext())
        {
          rer localrer = (rer)paramArticleInfo.next();
          if (localrer != null) {
            localrdy.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrer.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = localrdy;
    }
    localArrayList.add(localReportInfo);
    pkm.a().a(localArrayList);
  }
  
  private static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    int m;
    Object localObject1;
    if ((pgb.g(paramArticleInfo)) || (pgb.i(paramArticleInfo)) || (pgb.j(paramArticleInfo)) || (pgb.k(paramArticleInfo)))
    {
      m = 1;
      if ((m != 0) || (a(paramArticleInfo)) || (pgb.a(paramArticleInfo))) {
        localObject1 = "";
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("folder_status", jdField_d_of_type_Int);
        if (paramInt1 != 1) {
          continue;
        }
        ((JSONObject)localObject2).put("feeds_source", paramArticleInfo.mSubscribeID);
        ((JSONObject)localObject2).put("rowkey", paramArticleInfo.innerUniqueID);
        ((JSONObject)localObject2).put("feeds_type", "" + a(paramArticleInfo));
        ((JSONObject)localObject2).put("kandian_mode", "" + e());
        ((JSONObject)localObject2).put("tab_source", "" + d());
        if (paramInt2 > 0) {
          ((JSONObject)localObject2).put("entry_mode", "" + paramInt2);
        }
        ((JSONObject)localObject2).put("channel_id", "" + paramArticleInfo.mChannelID);
        ((JSONObject)localObject2).put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2;
        localJSONException.printStackTrace();
        continue;
        String str = "0X8007B64";
        continue;
        odq.a(null, paramArticleInfo.mSubscribeID, str, str, 0, 0, String.valueOf(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, (String)localObject1, false);
      }
      if (!uhv.a(paramArticleInfo.mChannelID)) {
        continue;
      }
      localObject2 = "0X800935D";
      if (m == 0) {
        continue;
      }
      if (!pgb.o(paramArticleInfo)) {
        odq.a(null, String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long), (String)localObject2, (String)localObject2, 0, 0, String.valueOf(paramArticleInfo.mFeedId), "0", "" + paramArticleInfo.mStrategyId, (String)localObject1, false);
      }
      return;
      m = 0;
      break;
      ((JSONObject)localObject2).put("feeds_source", paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long);
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo)
  {
    for (;;)
    {
      try
      {
        if ((paramBaseArticleInfo.mDislikeInfos == null) || (paramBaseArticleInfo.mDislikeInfos.size() <= 0)) {
          paramBaseArticleInfo.mDislikeInfos = DislikeInfo.a(paramBaseArticleInfo.mDiskLikeInfoString);
        }
        paramBaseArticleInfo.mPictures = a(paramBaseArticleInfo.mJsonPictureList, paramBaseArticleInfo);
        if ((pgb.h(paramBaseArticleInfo)) && (!pgb.l(paramBaseArticleInfo)))
        {
          paramBaseArticleInfo.mSinglePicture = a(((rgc)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rga.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_d_of_type_JavaLangString, true, true);
          if (!TextUtils.isEmpty(paramBaseArticleInfo.mFirstPagePicUrl)) {
            paramBaseArticleInfo.mFirstPagePicUrl = a(paramBaseArticleInfo.mFirstPagePicUrl);
          }
          if (paramBaseArticleInfo.mVideoCoverUrl != null) {
            paramBaseArticleInfo.mVideoCoverUrl = uet.a(paramBaseArticleInfo.mVideoCoverUrl.toString(), 3);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "preParseArticleJsonParam mJsonVideoList = " + paramBaseArticleInfo.mJsonVideoList);
          }
          if (TextUtils.isEmpty(paramBaseArticleInfo.mJsonVideoList)) {
            break label588;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "preParseArticleJsonParam article.mArticleID:" + paramBaseArticleInfo.mArticleID + " article.mTitle:" + paramBaseArticleInfo.mTitle + " article.mSummary:" + paramBaseArticleInfo.mSummary + "mJsonVideoList:" + paramBaseArticleInfo.mJsonVideoList);
          }
          paramBaseArticleInfo.mVideoCoverUrl = a(paramBaseArticleInfo, paramBaseArticleInfo.mJsonVideoList);
          localObject = a(paramBaseArticleInfo.mJsonVideoList, paramBaseArticleInfo);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = ((String)localObject).split(";");
            paramBaseArticleInfo.mVideoVid = localObject[0];
            paramBaseArticleInfo.mVideoDuration = Integer.valueOf(localObject[1]).intValue();
            paramBaseArticleInfo.thirdIcon = localObject[2];
            paramBaseArticleInfo.thirdName = localObject[3];
            paramBaseArticleInfo.thirdAction = localObject[4];
            if ((paramBaseArticleInfo.mFeedType != 3) && (TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID))) {
              paramBaseArticleInfo.innerUniqueID = localObject[5];
            }
            paramBaseArticleInfo.busiType = Integer.valueOf(localObject[6]).intValue();
            paramBaseArticleInfo.mVideoJsonWidth = Integer.valueOf(localObject[7]).intValue();
            paramBaseArticleInfo.mVideoJsonHeight = Integer.valueOf(localObject[8]).intValue();
            paramBaseArticleInfo.thirdUin = localObject[9];
            paramBaseArticleInfo.thirdUinName = localObject[10];
            paramBaseArticleInfo.mXGFileSize = Long.valueOf(localObject[11]).longValue();
            paramBaseArticleInfo.mThirdVideoURL = localObject[12];
            paramBaseArticleInfo.mThirdVideoURLExpireTime = Long.valueOf(localObject[13]).longValue();
          }
          a(paramBaseArticleInfo, paramBaseArticleInfo.mJsonVideoList);
          return;
        }
        if (((paramBaseArticleInfo instanceof ArticleInfo)) && ((pgb.a((ArticleInfo)paramBaseArticleInfo)) || (pgb.f((ArticleInfo)paramBaseArticleInfo))))
        {
          paramBaseArticleInfo.mSinglePicture = a(paramBaseArticleInfo.mFirstPagePicUrl, pgb.g((ArticleInfo)paramBaseArticleInfo), true);
          b(paramBaseArticleInfo);
          c(paramBaseArticleInfo);
          continue;
        }
        if (!b(paramBaseArticleInfo)) {
          break;
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        paramBaseArticleInfo.printStackTrace();
        return;
      }
      if (paramBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get() != 1) {
        break;
      }
      paramBaseArticleInfo.mSinglePicture = b(paramBaseArticleInfo.mFirstPagePicUrl, pgb.g((ArticleInfo)paramBaseArticleInfo), true);
    }
    Object localObject = paramBaseArticleInfo.mFirstPagePicUrl;
    boolean bool2 = paramBaseArticleInfo.mShowBigPicture;
    if (paramBaseArticleInfo.mVideoType == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramBaseArticleInfo.mSinglePicture = a((String)localObject, bool2, bool1);
      break;
      label588:
      if (((paramBaseArticleInfo instanceof ArticleInfo)) && (!pgb.q((ArticleInfo)paramBaseArticleInfo))) {
        paramBaseArticleInfo.busiType = ((rfl)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_f_of_type_Int;
      }
      return;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    odq.a(null, null, "0X800A5AB", "0X800A5AB", 0, 0, "", "", "", new sie(null, null, null, null).V(54).i(paramBaseArticleInfo.getInnerUniqueID()).w(paramInt + 1).a().a(), false);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    paramBaseArticleInfo.setFirstFrameUrl(a(paramString.optString("first_frame")));
  }
  
  public static void a(KandianRedDotInfo paramKandianRedDotInfo)
  {
    if (paramKandianRedDotInfo != null) {}
    try
    {
      if (paramKandianRedDotInfo.hasArticleID())
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("algorithm_id", paramKandianRedDotInfo.algorithmID);
        MessageForStructing localMessageForStructing = (MessageForStructing)paramKandianRedDotInfo.getMessageRecord();
        if ((localMessageForStructing != null) && (localMessageForStructing.structingMsg != null))
        {
          ((JSONObject)localObject).put("rowkey", paramKandianRedDotInfo.getRowkey());
          ((JSONObject)localObject).put("load_mode", a(localMessageForStructing.structingMsg.mExtraData));
          ((JSONObject)localObject).put("push_type", b(localMessageForStructing.structingMsg.mExtraData));
          ((JSONObject)localObject).put("landing_type", a(paramKandianRedDotInfo.getMessageRecord()));
        }
        ((JSONObject)localObject).put("folder_status", paramKandianRedDotInfo.forderStatus);
        ((JSONObject)localObject).put("report_time", NetConnInfoCenter.getServerTimeMillis());
        ((JSONObject)localObject).put("articleID", paramKandianRedDotInfo.articleIDList.get(0));
        odq.a(null, "CliOper", "", "", "0X80081DB", "0X80081DB", 0, 0, "", paramKandianRedDotInfo.articleIDList.get(0) + "", paramKandianRedDotInfo.strategyID + "", ((JSONObject)localObject).toString(), false);
        ple.a(41, Integer.parseInt(paramKandianRedDotInfo.forderStatus), (int)paramKandianRedDotInfo.algorithmID, (int)paramKandianRedDotInfo.strategyID);
        localObject = new ReportInfo();
        ((ReportInfo)localObject).mUin = a();
        ((ReportInfo)localObject).mSourceArticleId = ((Long)paramKandianRedDotInfo.articleIDList.get(0)).longValue();
        ((ReportInfo)localObject).mAlgorithmId = ((int)paramKandianRedDotInfo.algorithmID);
        ((ReportInfo)localObject).mStrategyId = ((int)paramKandianRedDotInfo.strategyID);
        ((ReportInfo)localObject).mOperation = 55;
        ((ReportInfo)localObject).mFolderStatus = Integer.parseInt(paramKandianRedDotInfo.forderStatus);
        paramKandianRedDotInfo = new ArrayList();
        paramKandianRedDotInfo.add(localObject);
        pkm.a().a(paramKandianRedDotInfo);
      }
      return;
    }
    catch (Exception paramKandianRedDotInfo)
    {
      QLog.e("ReadInJoyUtils", 1, paramKandianRedDotInfo, new Object[0]);
    }
  }
  
  private static void a(QQMessageFacade paramQQMessageFacade, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      if (TextUtils.isEmpty(paramMessageRecord.extStr)) {
        break label69;
      }
    }
    label69:
    for (JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);; localJSONObject = new JSONObject())
    {
      localJSONObject.put("sp_last_locksc_kadnian_red_pnt_exposure_time_key", NetConnInfoCenter.getServerTime());
      paramMessageRecord.extStr = localJSONObject.toString();
      paramQQMessageFacade.updateMsgFieldByUniseq(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
      return;
    }
  }
  
  public static void a(QQMessageFacade paramQQMessageFacade, MessageRecord paramMessageRecord, Intent paramIntent)
  {
    Object localObject1 = "";
    String str2 = "0";
    for (;;)
    {
      Object localObject2;
      try
      {
        a(paramQQMessageFacade, paramMessageRecord);
        MessageForStructing localMessageForStructing = new MessageForStructing(paramMessageRecord);
        if (localMessageForStructing.structingMsg == null) {
          localMessageForStructing.parse();
        }
        if (localMessageForStructing.extInt == 1)
        {
          localObject2 = d("", localMessageForStructing);
          str2 = c("0", localMessageForStructing);
          str1 = b("", localMessageForStructing);
          a(paramIntent, localMessageForStructing);
          paramQQMessageFacade = a("", localMessageForStructing);
          localObject1 = localMessageForStructing.structingMsg.reportEventFolderStatusValue;
          paramIntent = (Intent)localObject2;
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("algorithm_id", str1);
          ((JSONObject)localObject2).put("rowkey", paramQQMessageFacade);
          ((JSONObject)localObject2).put("folder_status", localObject1);
          ((JSONObject)localObject2).put("report_time", NetConnInfoCenter.getServerTimeMillis());
          a(paramMessageRecord, localMessageForStructing, (JSONObject)localObject2);
          odq.a(null, "CliOper", "", paramMessageRecord.senderuin, "0X80081DC", "0X80081DC", 0, 0, "", paramIntent, str2, ((JSONObject)localObject2).toString(), false);
          ple.a(40, Integer.parseInt((String)localObject1), Integer.parseInt(str1), Integer.parseInt(str2));
          paramQQMessageFacade = new ReportInfo();
          paramQQMessageFacade.mUin = a();
          paramQQMessageFacade.mSourceArticleId = new BigInteger(paramIntent).longValue();
          paramQQMessageFacade.mAlgorithmId = Integer.parseInt(str1);
          paramQQMessageFacade.mStrategyId = Integer.parseInt(str2);
          paramQQMessageFacade.mOperation = 54;
          paramQQMessageFacade.mFolderStatus = Integer.parseInt((String)localObject1);
          paramMessageRecord = new ArrayList();
          paramMessageRecord.add(paramQQMessageFacade);
          pkm.a().a(paramMessageRecord);
          return;
        }
        if (paramMessageRecord.extInt == 5)
        {
          paramIntent = "0";
          localObject1 = "";
          str1 = "";
          paramQQMessageFacade = "";
          continue;
        }
        localObject2 = "";
      }
      catch (JSONException paramQQMessageFacade)
      {
        QLog.d("ReadInJoyUtils", 1, "reportForLockScreenExposure parse json error");
        return;
      }
      catch (NumberFormatException paramQQMessageFacade)
      {
        QLog.d("ReadInJoyUtils", 1, "reportForLockScreenExposure number format error");
        return;
      }
      String str1 = "";
      paramQQMessageFacade = "";
      paramIntent = (Intent)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity)
  {
    a(paramBaseActivity, -1);
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBaseActivity.getWindow().addFlags(67108864);
      ImmersiveUtils.a(paramBaseActivity.getWindow(), true);
      if (paramBaseActivity.mSystemBarComp == null) {
        paramBaseActivity.mSystemBarComp = new SystemBarCompact(paramBaseActivity, true, -1);
      }
      paramBaseActivity.mSystemBarComp.init();
      if ((Build.VERSION.SDK_INT < 23) || (SystemUtil.isMIUI()) || (SystemUtil.isFlyme())) {
        break label116;
      }
      paramBaseActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      if (ThemeUtil.isInNightMode(paramBaseActivity.app)) {
        paramBaseActivity.mSystemBarComp.setStatusBarColor(1996488704);
      }
    }
    else
    {
      return;
    }
    paramBaseActivity.mSystemBarComp.setStatusBarColor(paramInt);
    return;
    label116:
    if (!SystemUtil.isFlyme())
    {
      paramBaseActivity.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    paramBaseActivity.mSystemBarComp.setStatusBarColor(paramInt);
    paramBaseActivity.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public static void a(BaseActivity paramBaseActivity, View paramView)
  {
    StatisticCollector.getInstance(paramBaseActivity).collectPerformance(a(), "actReadInJoyDDShowPopupMenu", true, 0L, 0L, null, "");
    ArrayList localArrayList = new ArrayList();
    a(bkwm.m(a()), localArrayList);
    if (localArrayList.size() == 0) {
      a(31, localArrayList);
    }
    bjsv.a(paramBaseActivity, localArrayList, new pbb(paramBaseActivity), new pbc(), AIOUtils.dp2px(125.0F, paramBaseActivity.getResources()), false, 2130842839, 2131755031).showAsDropDown(paramView);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new ReadInJoyUtils.1(paramQQAppInterface), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    jdField_e_of_type_Int = -1;
    Object localObject3 = (KandianMergeManager)paramQQAppInterface.getManager(162);
    paramQQAppInterface = "";
    Object localObject1 = "";
    Object localObject2 = "";
    int m;
    if (paramMessageRecord != null)
    {
      if (!paramMessageRecord.isread) {
        break label152;
      }
      m = 1;
    }
    for (;;)
    {
      a(m);
      jdField_a_of_type_Rdh.jdField_a_of_type_Int = m;
      jdField_a_of_type_Rdh.jdField_a_of_type_JavaLangString = ((String)localObject1);
      jdField_a_of_type_Rdh.jdField_b_of_type_JavaLangString = paramQQAppInterface;
      jdField_a_of_type_Rdh.jdField_c_of_type_JavaLangString = ((String)localObject2);
      if ((!TextUtils.isEmpty(paramMessageRecord.extStr)) && (!paramMessageRecord.isread)) {}
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            try
            {
              paramQQAppInterface = new JSONObject(paramMessageRecord.extStr);
              jdField_a_of_type_Rdh.jdField_a_of_type_Long = paramQQAppInterface.optLong("sp_last_kadnian_red_pnt_exposure_time_key", 0L);
              long l1 = paramQQAppInterface.optLong("sp_last_locksc_kadnian_red_pnt_exposure_time_key", -1L);
              if (l1 > 0L) {
                jdField_a_of_type_Rdh.jdField_a_of_type_Long = l1;
              }
            }
            catch (Exception paramQQAppInterface)
            {
              label152:
              Object localObject6;
              Object localObject5;
              MessageForStructing localMessageForStructing;
              Object localObject4;
              paramQQAppInterface.printStackTrace();
              continue;
            }
            jdField_a_of_type_Rdh.jdField_b_of_type_Long = paramMessageRecord.time;
            return;
            if ((paramMessageRecord.extInt != 1) && (paramMessageRecord.extInt != 3)) {
              continue;
            }
            if ((localObject3 != null) && (((KandianMergeManager)localObject3).a(paramMessageRecord) == 1))
            {
              m = 5;
              break;
            }
            localObject6 = paramQQAppInterface;
            localObject5 = localObject1;
            localObject3 = localObject2;
            if ((paramMessageRecord instanceof MessageForStructing))
            {
              localMessageForStructing = (MessageForStructing)paramMessageRecord;
              localMessageForStructing.parse();
              localObject6 = paramQQAppInterface;
              localObject5 = localObject1;
              localObject3 = localObject2;
              if (localMessageForStructing.structingMsg != null)
              {
                if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mStrategyIds)) {
                  paramQQAppInterface = localMessageForStructing.structingMsg.mStrategyIds.split("\\|")[0];
                }
                if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mAlgorithmIds)) {
                  localObject1 = localMessageForStructing.structingMsg.mAlgorithmIds.split("\\|")[0];
                }
                if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mArticleIds)) {
                  localObject2 = localMessageForStructing.structingMsg.mArticleIds.split("\\|")[0];
                }
                localObject6 = paramQQAppInterface;
                localObject5 = localObject1;
                localObject3 = localObject2;
                if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.reportEventFolderStatusValue)) {
                  try
                  {
                    m = Integer.parseInt(localMessageForStructing.structingMsg.reportEventFolderStatusValue);
                  }
                  catch (Exception localException)
                  {
                    localException.printStackTrace();
                    localObject4 = localObject2;
                    localObject5 = localObject1;
                    localObject6 = paramQQAppInterface;
                  }
                }
              }
            }
          }
          m = 3;
          paramQQAppInterface = (QQAppInterface)localObject6;
          localObject1 = localObject5;
          localObject2 = localObject4;
          break;
          if ((paramMessageRecord.extInt == 2) || (paramMessageRecord.extInt == 4))
          {
            m = 2;
            break;
          }
          if (paramMessageRecord.extInt == 5)
          {
            m = 6;
            break;
          }
          if (paramMessageRecord.extInt != 6) {
            break label578;
          }
          localObject5 = paramQQAppInterface;
          localObject4 = localObject1;
          try
          {
            localObject6 = new JSONObject(paramMessageRecord.extStr);
            localObject5 = paramQQAppInterface;
            localObject4 = localObject1;
            m = ((JSONObject)localObject6).getInt("folder_status");
            localObject5 = paramQQAppInterface;
            localObject4 = localObject1;
            paramQQAppInterface = ((JSONObject)localObject6).getString("strategy_id");
            localObject5 = paramQQAppInterface;
            localObject4 = localObject1;
            localObject1 = ((JSONObject)localObject6).getString("algorithm_id");
            localObject5 = paramQQAppInterface;
            localObject4 = localObject1;
            localObject6 = ((JSONObject)localObject6).getString("article_id");
            localObject2 = localObject6;
          }
          catch (Exception paramQQAppInterface)
          {
            paramQQAppInterface.printStackTrace();
            m = 10;
            paramQQAppInterface = (QQAppInterface)localObject5;
            localObject1 = localObject4;
          }
        }
        break;
        jdField_a_of_type_Rdh.jdField_a_of_type_Long = 0L;
      }
      label578:
      m = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (!bkwm.i()) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyUtils.18(paramQQAppInterface));
    ThreadManager.executeOnSubThread(new ReadInJoyUtils.19(paramRedTypeInfo, paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      SettingCloneUtil.writeValue(localMobileQQ, paramQQAppInterface, null, "qqsetting_kandian_key", paramBoolean);
      return;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_Rdh.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  private static void a(MessageRecord paramMessageRecord, MessageForStructing paramMessageForStructing, JSONObject paramJSONObject)
  {
    if (!paramMessageRecord.isread)
    {
      String str = paramMessageRecord.senderuin;
      JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
      paramMessageRecord = str;
      if (localJSONObject.has("kdUin")) {
        paramMessageRecord = localJSONObject.getString("kdUin");
      }
      paramJSONObject.put("feeds_source", paramMessageRecord);
      if (paramMessageForStructing.structingMsg != null)
      {
        paramJSONObject.put("load_mode", a(paramMessageForStructing.structingMsg.mExtraData));
        paramJSONObject.put("push_type", b(paramMessageForStructing.structingMsg.mExtraData));
        paramJSONObject.put("landing_type", a(paramMessageForStructing));
      }
    }
  }
  
  public static void a(String paramString)
  {
    Object localObject = bkwm.a(a(), true, false);
    if (localObject == null)
    {
      QLog.d("ReadInJoyUtils", 1, "updateVideoAutoPlaySetting failed to get sp");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (e() == 6) {
      ((SharedPreferences.Editor)localObject).putString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_VIDEO_FLOW_SETTING", paramString);
    }
    for (;;)
    {
      bkwm.a((SharedPreferences.Editor)localObject, true);
      return;
      ((SharedPreferences.Editor)localObject).putString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_SETTING", paramString);
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    while (!paramString.contains("dailyJumpSrc")) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("dailyJumpSrc", a("dailyJumpSrc", paramString.split("&")));
      localJSONObject.put("jumpSuccess", paramInt1);
      localJSONObject.put("fullScheme", paramString);
      localJSONObject.put("isCancelJump", paramInt2);
      odq.a(null, null, "0X8009CCD", "0X8009CCD", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    String str = "-1";
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1)) {}
      try
      {
        odq.a(null, "", paramString1, paramString1, 0, 0, String.valueOf(paramLong), str, paramString2, "", false);
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("ReadInJoyUtils", 1, "reportSelectedTopic error:" + paramString1.toString());
      }
      str = "1";
      continue;
      str = "2";
      continue;
      str = "3";
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, paramInt, paramString2);
    long l1 = bkwm.a();
    if ((l1 != -1L) && (System.currentTimeMillis() - l1 < 600000L)) {}
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = paramQQAppInterface.getMessageFacade();
      } while (localObject == null);
      localObject = ((QQMessageFacade)localObject).getConversationFacade();
    } while ((localObject == null) || (((abwp)localObject).a(paramString, 1008) <= 0));
    ThreadManager.post(new ReadInJoyUtils.22(paramString, paramQQAppInterface), 8, null, false);
  }
  
  public static void a(String paramString, Object paramObject, boolean paramBoolean)
  {
    if (!(paramObject instanceof Serializable)) {
      throw new RuntimeException("the data obj must implement Serializable interface ! ");
    }
    ThreadManager.executeOnFileThread(new ReadInJoyUtils.11(paramString, paramObject, paramBoolean));
  }
  
  public static void a(String paramString, Runnable paramRunnable, ExecutorService paramExecutorService)
  {
    if ((paramExecutorService == null) || (paramExecutorService.isShutdown()))
    {
      QLog.d("ReadInJoyUtils", 2, new Object[] { paramString, " runInSubThread failed, executorService is null or shutdown." });
      return;
    }
    paramExecutorService.execute(paramRunnable);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("releasetype", paramString2);
      localJSONObject.put("tab_source", paramString1);
      paramString1 = localJSONObject.toString();
      odq.a(null, "", "0X8008C5D", "0X8008C5D", 0, 0, "", "", "", paramString1, false);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        paramString1 = str;
        if (QLog.isColorLevel())
        {
          QLog.e("ReadInJoyUtils", 2, "secondClassDeliverOperationReport:" + paramString2.toString());
          paramString1 = str;
        }
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, pbf parampbf)
  {
    ThreadManager.executeOnNetWorkThread(new ReadInJoyUtils.15(paramString4, paramString3, paramString2, paramString1, parampbf));
  }
  
  public static void a(String paramString, rcn paramrcn, sie paramsie)
  {
    if (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {}
    long l1;
    do
    {
      return;
      l1 = paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
      localObject1 = qks.a(l1);
    } while (localObject1 == null);
    paramsie = new sie(paramsie.a().a());
    Object localObject1 = ((List)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject1).next();
      if ((localArticleInfo != null) && (localArticleInfo.mProteusTemplateBean != null))
      {
        Object localObject2 = localArticleInfo.mProteusTemplateBean.getDataAttribute(null);
        if ((localObject2 != null) && (((Map)localObject2).entrySet() != null))
        {
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while ((localObject2 != null) && (((Iterator)localObject2).hasNext()))
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            paramsie.a((String)localEntry.getKey(), localEntry.getValue().toString());
          }
        }
        QLog.d("ReadInJoyUtils", 1, "reportArticleItemExpose: " + localArticleInfo + "  bean :" + localArticleInfo.mProteusTemplateBean.getDataAttribute(null));
      }
      for (;;)
      {
        odq.a(null, "CliOper", "", paramrcn.jdField_d_of_type_JavaLangString, paramString, paramString, 0, 0, Long.toString(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramrcn.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramrcn.jdField_b_of_type_Int), paramsie.a().a(), false);
        break;
        QLog.d("ReadInJoyUtils", 1, "reportArticleItemExpose: " + localArticleInfo);
      }
    }
    qks.a(l1);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.executeOnFileThread(new ReadInJoyUtils.10(paramBoolean, paramString));
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString, Object paramObject)
  {
    paramStringBuilder.append("\"");
    paramStringBuilder.append(paramString);
    paramStringBuilder.append("\":");
    paramStringBuilder.append("\"");
    paramStringBuilder.append(paramObject);
    paramStringBuilder.append("\"");
  }
  
  public static void a(AppRuntime paramAppRuntime, List<oidb_cmd0x68b.RspTraceRecord> paramList)
  {
    if ((paramAppRuntime == null) || (paramList == null) || (paramList.size() < 1)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x68b.RspTraceRecord localRspTraceRecord = (oidb_cmd0x68b.RspTraceRecord)paramList.next();
      localHashMap.put(localRspTraceRecord.bytes_method.get().toStringUtf8(), String.valueOf(localRspTraceRecord.uint32_cost.get()));
    }
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actKandianRefreshBackEndTrace", true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("LOOP_ERROR_CODE", Integer.toString(paramInt));
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actWebRenderLoopEvent", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("LOOP_STEP", Integer.toString(paramInt));
    localHashMap.put("LOOP_STEP_COST", Long.toString(paramLong));
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actWebRenderLoopEventCost", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramLong < 0L) || (paramLong > 30000L)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt));
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actKandianGetShareJsonSuccAndCost", paramBoolean, paramLong, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt1));
    localHashMap.put("param_OpCode", String.valueOf(paramInt2));
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actKandian0x83eResult", paramBoolean, paramLong, 0L, localHashMap, null);
    QLog.d("ReadInJoyUtils", 1, "reportKandian83eMonitorData| actKandian0x83eResult | retCode ： " + paramInt1 + "| param_OpCode : " + paramInt2);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if ((paramAppRuntime == null) || (paramLong < 0L) || (paramLong > 50000L)) {
      return;
    }
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(a(), "actKandianRefreshSuccAndCost", paramBoolean, paramLong, 0L, paramHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PLUGIN_STEP", paramString);
    localHashMap.put("PLUGIN_CAN_RENDER", Integer.toString(paramInt));
    localHashMap.put("PLUGIN_STEP_COST_FROM_CLICK", Long.toString(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUtils", 2, "reportWebRenderPluginEventCost PLUGIN_STEP : [" + paramString + "];PLUGIN_CAN_RENDER :[" + paramInt + "]; + PLUGIN_STEP_COST_FROM_CLICK : [" + paramLong + " ms];");
    }
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actreportWebRenderPluginEventCost", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return;
    }
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actKanDianViolaData", paramBoolean, -1L, -1L, paramHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramAppRuntime == null) {
      return;
    }
    ThreadManager.post(new ReadInJoyUtils.7(paramJSONObject, paramAppRuntime, paramBoolean), 5, null, true);
  }
  
  public static void a(oju paramoju)
  {
    if (paramoju == null) {
      return;
    }
    odq.a(null, null, "0X8009BD4", "0X8009BD4", 0, 0, "", "", "", paramoju.a(), false);
  }
  
  public static void a(oju paramoju, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramoju != null) && (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      b(paramoju, paramBaseArticleInfo);
      a(paramoju);
    }
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while (!bcoo.a()) {
      return;
    }
    try
    {
      paramJSONObject.put("study_mode_selected_grade", a());
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("ReadInJoyUtils", 1, "addSelectedGrades error! msg= " + paramJSONObject);
    }
  }
  
  public static void a(JSONObject paramJSONObject, ArticleInfo paramArticleInfo)
  {
    for (;;)
    {
      try
      {
        SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
        paramJSONObject.put("folder_status", jdField_d_of_type_Int);
        if (pgb.a(paramArticleInfo))
        {
          paramJSONObject.put("feeds_source", paramArticleInfo.mSubscribeID);
          paramJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
          paramJSONObject.put("feeds_type", "" + a(paramArticleInfo));
          paramJSONObject.put("kandian_mode", "" + e());
          paramJSONObject.put("tab_source", "" + d());
          paramJSONObject.put("channel_id", paramArticleInfo.mChannelID);
          paramJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
          if (paramArticleInfo.isPGCShortContent())
          {
            paramArticleInfo = "1";
            paramJSONObject.put("content_source", paramArticleInfo);
          }
        }
        else
        {
          if ((localSocializeFeedsInfo == null) || (localSocializeFeedsInfo.jdField_a_of_type_Rer == null)) {
            continue;
          }
          paramJSONObject.put("feeds_source", localSocializeFeedsInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long);
          continue;
        }
        paramArticleInfo = "0";
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, oju paramoju)
  {
    if ((paramJSONObject == null) || (paramoju == null)) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramoju.jdField_b_of_type_JavaLangString)) {}
      for (;;)
      {
        QLog.d("ReadInJoyUtils", 1, "bindMedalData : " + paramJSONObject.toString());
        return;
        if ((paramoju.jdField_c_of_type_Int > 0) && (paramoju.jdField_d_of_type_Int > 0))
        {
          paramJSONObject.put("header_medal_jump_url", paramoju.jdField_c_of_type_JavaLangString);
          paramJSONObject.put("header_medal_wh_rate", Double.valueOf(paramoju.jdField_c_of_type_Int).doubleValue() / paramoju.jdField_d_of_type_Int);
          paramJSONObject.put("header_medal_image_url", paramoju.jdField_b_of_type_JavaLangString);
        }
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public static void a(boolean paramBoolean)
  {
    k = paramBoolean;
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int n = 1;
    Object localObject1 = (QQAppInterface)a();
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = ((QQAppInterface)localObject1).getMessageFacade();
      } while (localObject1 == null);
      localObject2 = ((QQMessageFacade)localObject1).getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
    } while (localObject2 == null);
    if ((localObject2 instanceof MessageForStructing))
    {
      localObject1 = (MessageForStructing)localObject2;
      if (((MessageForStructing)localObject1).structingMsg == null) {
        ((MessageForStructing)localObject1).parse();
      }
    }
    for (;;)
    {
      int m;
      if (!paramBoolean)
      {
        m = 1;
        label80:
        if (((MessageRecord)localObject2).isread) {
          break label209;
        }
      }
      for (;;)
      {
        for (;;)
        {
          if ((m | n) == 0) {
            break label212;
          }
          String str = ((MessageRecord)localObject2).senderuin;
          try
          {
            localObject2 = new JSONObject(((MessageRecord)localObject2).extStr);
            if (((JSONObject)localObject2).has("kdUin")) {
              str = ((JSONObject)localObject2).getString("kdUin");
            }
            paramJSONObject.put("feeds_source", str);
            if ((localObject1 == null) || (((MessageForStructing)localObject1).structingMsg == null)) {
              break;
            }
            paramJSONObject.put("load_mode", a(((MessageForStructing)localObject1).structingMsg.mExtraData));
            paramJSONObject.put("push_type", b(((MessageForStructing)localObject1).structingMsg.mExtraData));
            return;
          }
          catch (Exception paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            return;
          }
        }
        m = 0;
        break label80;
        label209:
        n = 0;
      }
      label212:
      break;
      localObject1 = null;
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString1, String paramString2)
  {
    ThreadManagerV2.executeOnSubThread(new ReadInJoyUtils.5(paramBoolean2, paramInt1, paramInt3, paramInt2, paramLong, paramString1, paramBoolean1, paramString2));
  }
  
  public static boolean a()
  {
    return a() instanceof QQAppInterface;
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 9999;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    for (;;)
    {
      return false;
      float f1 = bkwm.b(a());
      if (f1 > 0.0F) {}
      while (paramInt1 / paramInt2 <= f1)
      {
        return true;
        f1 = 0.75F;
      }
    }
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong == 41516L) || (paramLong == 41522L) || (paramLong == 41523L);
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = a();
    if (paramContext == null) {}
    while ((paramContext.isBackgroundPause) || (paramContext.isBackgroundStop)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(Context paramContext, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mProteusTemplateBean == null) {}
    for (String str = "";; str = paramBaseArticleInfo.mProteusTemplateBean.getStyleName()) {
      return a(paramContext, paramBaseArticleInfo, str);
    }
  }
  
  public static boolean a(Context paramContext, BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    boolean bool1 = true;
    if ((paramBaseArticleInfo.mChannelID != 0L) && (!pcl.c((int)paramBaseArticleInfo.mChannelID))) {
      QLog.e("ReadInJoyUtils", 1, "judgeShouldNoDifferenceJumpToApp channelID: " + paramBaseArticleInfo.mChannelID);
    }
    int m;
    label185:
    label200:
    label213:
    label232:
    label360:
    label362:
    do
    {
      for (;;)
      {
        return false;
        AladdinConfig localAladdinConfig = Aladdin.getConfig(199);
        if (localAladdinConfig == null)
        {
          QLog.e("ReadInJoyUtils", 1, "judgeShouldNoDifferenceJumpToApp AladdinConfig is empty.");
          return false;
        }
        boolean bool2 = bkwm.y();
        if (!bool2)
        {
          QLog.e("ReadInJoyUtils", 1, "judgeShouldNoDifferenceJumpToApp is not first no difference jump app today.");
          return false;
        }
        m = pgb.a((ArticleInfo)paramBaseArticleInfo);
        int n;
        int i1;
        boolean bool3;
        if ((paramBaseArticleInfo.mFeedType == 0) && ((m == 1) || (m == 2) || (m == 3) || (m == 4) || (m == 6)))
        {
          n = 1;
          if ((paramBaseArticleInfo.mFeedType != 29) || ((!paramString.equalsIgnoreCase("ReadInjoy_daily_small_img_cell")) && (!paramString.equalsIgnoreCase("ReadInjoy_daily_triple_img_cell")) && (!paramString.equalsIgnoreCase("ReadInjoy_daily_large_img_cell")))) {
            break label333;
          }
          i1 = 1;
          if (localAladdinConfig.getIntegerFromString("no_difference_jump_app_switch", 0) != 1) {
            break label339;
          }
          m = 1;
          if ((n == 0) && (i1 == 0)) {
            break label344;
          }
          n = 1;
          bool3 = TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptText);
          if (paramBaseArticleInfo.isSuperTop != 0) {
            break label350;
          }
          i1 = 1;
          if ((TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl)) || ((!paramBaseArticleInfo.mArticleContentUrl.startsWith("mqqapi")) && (!paramBaseArticleInfo.mArticleContentUrl.contains("target=4")))) {
            break label356;
          }
        }
        for (int i2 = 1;; i2 = 0)
        {
          if ((m == 0) || (!bool2) || (n == 0) || (!bool3) || (i1 == 0) || (i2 != 0)) {
            break label360;
          }
          m = localAladdinConfig.getIntegerFromString("no_difference_jump_app_type", 0);
          paramBaseArticleInfo = localAladdinConfig.getString("no_difference_jump_app_package_name", "");
          if (m != 0) {
            break label362;
          }
          return true;
          n = 0;
          break;
          i1 = 0;
          break label185;
          m = 0;
          break label200;
          n = 0;
          break label213;
          i1 = 0;
          break label232;
        }
      }
      if (m == 1)
      {
        if (!bfwv.a(paramContext, paramBaseArticleInfo)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (m != 2);
    label333:
    label339:
    label344:
    label350:
    label356:
    return bfwv.a(paramContext, paramBaseArticleInfo);
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    return qxf.b(pgb.a(paramArticleInfo));
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    String str = ozp.a(paramArticleInfo);
    if ((!TextUtils.isEmpty(str)) && (paramContext != null))
    {
      if (rbt.a(str)) {
        a(paramContext, paramArticleInfo, str);
      }
      for (;;)
      {
        QLog.d("ReadInJoyUtils", 1, "tryJumpToUgUrl,title=" + paramArticleInfo.mTitle);
        return true;
        rwv.a(BaseApplicationImpl.getApplication(), str);
      }
    }
    return false;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.mVideoCoverUrl == null) || (TextUtils.isEmpty(paramBaseArticleInfo.mVideoVid))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (h(paramBaseArticleInfo1))
    {
      bool1 = bool2;
      if (h(paramBaseArticleInfo2))
      {
        bool1 = bool2;
        if (paramBaseArticleInfo1.mPolymericInfo.jdField_c_of_type_Long == paramBaseArticleInfo2.mPolymericInfo.jdField_c_of_type_Long) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    if (!SettingCloneUtil.readValue(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentUin(), null, "qqsetting_kandian_key", true)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "isDeleteNewKandian, flag = " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.extInt != 5) {
      return a(paramMessageRecord);
    }
    return ((KandianMergeManager)paramQQAppInterface.getManager(162)).e();
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool = true;
    if (paramMessageRecord == null) {
      return false;
    }
    if ((paramMessageRecord.extStr != null) && ((paramMessageRecord.extLong & 0x1) == 1) && (paramMessageRecord.extStr.contains("lockDisplay")) && (paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true"))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "neadForceNotification, ret=" + bool + ", mr=" + paramMessageRecord);
      }
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(PBBytesField paramPBBytesField)
  {
    return (paramPBBytesField != null) && (paramPBBytesField.has()) && (paramPBBytesField.get() != null);
  }
  
  public static boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return (paramAbsStructMsg != null) && (paramAbsStructMsg.mMsgUrl != null) && (paramAbsStructMsg.mMsgUrl.contains("kandianshare.html5.qq.com"));
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (paramString.startsWith("http://qqpublic.qpic.cn"))
      {
        paramString = paramString.split("/");
        bool1 = bool2;
        if (paramString.length >= 2)
        {
          paramString = paramString[(paramString.length - 2)].split("_");
          bool1 = bool2;
          if (paramString.length >= 1)
          {
            paramString = paramString[(paramString.length - 1)];
            if (!TextUtils.equals("open", paramString))
            {
              bool1 = bool2;
              if (!TextUtils.equals("vsmcut", paramString)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString, long paramLong, ArticleInfo paramArticleInfo)
  {
    if (!bkwm.C(a())) {
      return false;
    }
    if (tpr.a.a()) {
      return false;
    }
    if ((paramArticleInfo instanceof AdvertisementInfo)) {
      return false;
    }
    if (paramLong == 1000000L) {
      return false;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = bjnd.a(paramString);
      if ((paramString.containsKey("article_type")) && (!TextUtils.equals("1", (CharSequence)paramString.get("article_type")))) {
        return false;
      }
    }
    return b(paramArticleInfo);
  }
  
  public static boolean a(rfj paramrfj)
  {
    return (paramrfj != null) && (paramrfj.jdField_a_of_type_Rep != null) && (paramrfj.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList != null) && ((paramrfj.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList.size() > 1) || ((paramrfj.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList.size() == 1) && (!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)paramrfj.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString))));
  }
  
  public static int[] a(Activity paramActivity)
  {
    Object localObject = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    int n;
    int m;
    if (Build.VERSION.SDK_INT >= 17)
    {
      ((Display)localObject).getRealSize(localPoint);
      n = localPoint.x;
      m = localPoint.y;
    }
    for (;;)
    {
      return new int[] { n, m };
      if (Build.VERSION.SDK_INT >= 15)
      {
        ((Display)localObject).getSize(localPoint);
        n = localPoint.x;
        m = localPoint.y;
      }
      else
      {
        localObject = new DisplayMetrics();
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        n = ((DisplayMetrics)localObject).widthPixels;
        m = ((DisplayMetrics)localObject).heightPixels;
      }
    }
  }
  
  public static URL[] a(String paramString, BaseArticleInfo paramBaseArticleInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = (JSONObject)new JSONTokener(paramString).nextValue();
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label214;
        }
        JSONArray localJSONArray = paramString.optJSONArray("pictures");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          URL[] arrayOfURL = new URL[localJSONArray.length()];
          paramString = pai.a();
          if (!b(paramBaseArticleInfo)) {
            break label211;
          }
          m = paramBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
          if (m == 2)
          {
            paramString = pai.b();
            break label216;
            if (m < localJSONArray.length())
            {
              paramBaseArticleInfo = localJSONArray.optJSONObject(m).optString("picture");
              if (TextUtils.isEmpty(paramBaseArticleInfo)) {
                break label221;
              }
              if (!b(paramBaseArticleInfo)) {
                break label208;
              }
              paramBaseArticleInfo = a(paramBaseArticleInfo, ((Integer)paramString.second).intValue(), ((Integer)paramString.first).intValue(), 1);
              arrayOfURL[m] = uet.a(paramBaseArticleInfo, 3);
              break label221;
            }
          }
          else
          {
            if (m == 3)
            {
              paramString = pai.d();
              break label216;
            }
            if (m != 1) {
              break label211;
            }
            paramString = pai.c();
            break label216;
          }
          return arrayOfURL;
        }
        else
        {
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      label208:
      continue;
      label211:
      break label216;
      label214:
      return null;
      label216:
      int m = 0;
      continue;
      label221:
      m += 1;
    }
  }
  
  public static int b()
  {
    int m = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    try
    {
      localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((Conversation)localObject1).a().b();
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData)) {
          localArrayList.add((RecentBaseData)localObject2);
        }
      }
      n = localException.size();
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + localException.toString());
      return -1;
    }
    int n;
    int i1;
    if (n > jdField_a_of_type_Int)
    {
      n = jdField_a_of_type_Int;
      break label244;
      if (i1 < n)
      {
        localObject1 = (RecentBaseData)localException.get(i1);
        if (localObject1 != null)
        {
          localObject1 = (RecentUserBaseData)localObject1;
          if (!TextUtils.equals(((RecentUserBaseData)localObject1).getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN))
          {
            if (((RecentUserBaseData)localObject1).getRecentUserType() == 5000) {
              break label249;
            }
            if (((RecentUserBaseData)localObject1).getUnreadNum() > 0)
            {
              int i2 = ((RecentUserBaseData)localObject1).getUnreadNum();
              m = i2 + m;
              break label249;
            }
          }
        }
      }
      else
      {
        return m;
      }
    }
    for (;;)
    {
      label244:
      i1 = 0;
      break;
      label249:
      i1 += 1;
      break;
    }
  }
  
  public static int b(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (pgb.f(paramArticleInfo)) {
      if (pgb.d(paramArticleInfo)) {
        switch (localSocializeFeedsInfo.jdField_a_of_type_Int)
        {
        }
      }
    }
    do
    {
      do
      {
        return 0;
        return 4;
        return 3;
        if (e(paramArticleInfo)) {
          return 6;
        }
        if (q(paramArticleInfo)) {
          return 10;
        }
      } while (!p(paramArticleInfo));
      return 8;
      if ((!pgb.a(paramArticleInfo)) && (paramArticleInfo.mFeedType != 10)) {
        break;
      }
    } while (localSocializeFeedsInfo == null);
    switch (localSocializeFeedsInfo.jdField_a_of_type_Int)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
    switch (paramArticleInfo.mFeedType)
    {
    default: 
      return 0;
    case 21: 
      return 7;
    case 23: 
      return 5;
    }
    return 9;
  }
  
  public static int b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mNewPolymericInfo == null) || (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList == null) || (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.isEmpty()) || (!paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean))
    {
      QLog.e("ReadInJoyUtils", 1, "articleInfo = null");
      return 0;
    }
    rdn localrdn = (rdn)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    if (v(paramBaseArticleInfo)) {
      return 79;
    }
    if (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 15) {
      return 131;
    }
    if (localrdn.jdField_b_of_type_Int == 10) {
      return 78;
    }
    if ((localrdn.jdField_b_of_type_Int == 4) || (localrdn.jdField_b_of_type_Int == 5)) {
      return 76;
    }
    if ((localrdn.jdField_b_of_type_Int == 6) || (localrdn.jdField_b_of_type_Int == 7) || (localrdn.jdField_b_of_type_Int == 8) || (localrdn.jdField_b_of_type_Int == 9) || (localrdn.jdField_b_of_type_Int == 12)) {
      return 77;
    }
    if (localrdn.jdField_b_of_type_Int == 0) {
      return 77;
    }
    QLog.e("FeedItemCellTypeNewPolymericBaseHeader", 1, "新聚合类卡片没有找到对应的FeedCell feedType = " + localrdn.jdField_b_of_type_Int);
    return 77;
  }
  
  private static int b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int m = new JSONObject(paramString).optInt("contentType", 0);
        return m;
      }
      catch (JSONException paramString)
      {
        QLog.e("ReadInJoyUtils", 1, "getReportPushTypeFromeLockScreenMsg: ", paramString);
      }
    }
    return -1;
  }
  
  private static long b(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((paramInt == 3) || (paramInt == 5) || (paramInt == 2) || (paramInt == 7))
    {
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep != null)) {
        return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaLangLong.longValue();
      }
    }
    else {
      return paramArticleInfo.mFeedId;
    }
    return 0L;
  }
  
  public static Handler b()
  {
    if (jdField_b_of_type_AndroidOsHandler == null) {}
    try
    {
      if (jdField_b_of_type_AndroidOsHandler == null) {
        jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      }
      return jdField_b_of_type_AndroidOsHandler;
    }
    finally {}
  }
  
  public static String b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject = (QQAppInterface)a();
      localJSONObject.put("pos_id", 100402);
      localJSONObject.put("uin", ((QQAppInterface)localObject).getAccount());
      localJSONObject.put("imei", biaq.c());
      localJSONObject.put("Qom", UserAction.getQIMEI());
      localJSONObject.put("platform", "A");
      localJSONObject.put("qqver", "8.4.8");
      localJSONObject.put("net_type", HttpUtil.getNetWorkType() + "");
      localJSONObject.put("sUserKey", ((QQAppInterface)localObject).getAccount());
      localJSONObject.put("iUserKeyType", 6);
      localJSONObject.put("req_ext", URLEncoder.encode(URLEncoder.encode(c())));
      localObject = new JSONArray();
      if (!bfwv.a(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0")) {
        ((JSONArray)localObject).put("1");
      }
      if (!bfwv.a(BaseApplicationImpl.getContext(), "com.tencent.weishi").equals("0")) {
        ((JSONArray)localObject).put("3");
      }
      localJSONObject.put("app_list", localObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return localJSONObject.toString();
  }
  
  public static String b(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      ((JSONObject)localObject).put("time", System.currentTimeMillis());
      ((JSONObject)localObject).put("channel_id", paramInt);
      ((JSONObject)localObject).put("kandian_mode", e());
      ((JSONObject)localObject).put("kandian_mode_new", ofe.a());
      ((JSONObject)localObject).put("tab_source", d());
      ((JSONObject)localObject).put("session_id", jdField_f_of_type_JavaLangString);
      ((JSONObject)localObject).put("os", 1);
      ((JSONObject)localObject).put("version", ofe.jdField_a_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String b(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("algorithm_id", paramLong);
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      ((JSONObject)localObject).put("feeds_type", paramInt1);
      ((JSONObject)localObject).put("time", System.currentTimeMillis());
      ((JSONObject)localObject).put("channel_id", paramInt2);
      ((JSONObject)localObject).put("feeds_channel_entrance", paramInt3);
      ((JSONObject)localObject).put("session_id", jdField_f_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String b(Context paramContext)
  {
    e(paramContext);
    return jdField_i_of_type_JavaLangString;
  }
  
  public static String b(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.a())) {
      return "1";
    }
    return "0";
  }
  
  private static String b(ArticleInfo paramArticleInfo, int paramInt)
  {
    String str2 = "";
    String str1;
    if ((paramInt == 0) || (paramInt == 6) || (paramInt == 8)) {
      str1 = f(paramArticleInfo);
    }
    for (;;)
    {
      paramArticleInfo = str1;
      if (str1 == null) {
        paramArticleInfo = "";
      }
      return paramArticleInfo;
      if ((paramInt == 1) || (paramInt == 3))
      {
        str1 = paramArticleInfo.mSubscribeID;
      }
      else if ((paramInt == 2) || (paramInt == 4))
      {
        str1 = e(paramArticleInfo);
      }
      else if (paramInt == 5)
      {
        str1 = String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long);
      }
      else
      {
        str1 = str2;
        if (paramInt == 7) {
          if (!pgb.o(paramArticleInfo))
          {
            str1 = String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long);
          }
          else
          {
            str1 = str2;
            if (!TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
              str1 = paramArticleInfo.mSubscribeID;
            }
          }
        }
      }
    }
  }
  
  public static String b(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    do
    {
      do
      {
        return null;
      } while ((paramBaseArticleInfo.isCardJumpUrlAvailable != 1) || (TextUtils.isEmpty(paramBaseArticleInfo.mCardJumpUrl)));
      paramBaseArticleInfo = tmd.d(paramBaseArticleInfo.mCardJumpUrl);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "shortContentUrl: " + paramBaseArticleInfo);
      }
    } while (!tgc.b(paramBaseArticleInfo));
    return tgc.b(paramBaseArticleInfo);
  }
  
  public static String b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wording", paramString);
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String b(@NotNull String paramString, long paramLong, int paramInt)
  {
    if (paramString.isEmpty()) {}
    do
    {
      return paramString;
      localObject = bjnd.a(paramString);
      if (!"6".equals((String)((Map)localObject).get("target"))) {
        break;
      }
      localObject = (String)((Map)localObject).get("v_url_base64");
    } while ((localObject == null) || (((String)localObject).isEmpty()));
    Object localObject = bfuc.encodeToString(Uri.parse(new String(bfuc.decode((String)localObject, 0))).buildUpon().appendQueryParameter("percentage", String.valueOf(paramLong)).appendQueryParameter("mutestate", String.valueOf(paramInt)).build().toString().getBytes("utf-8"), 2);
    return bjnd.b(bjnd.a(paramString, "v_url_base64"), "v_url_base64", (String)localObject);
    return Uri.parse(paramString).buildUpon().appendQueryParameter("percentage", String.valueOf(paramLong)).appendQueryParameter("mutestate", String.valueOf(paramInt)).build().toString();
  }
  
  public static String b(String paramString, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramString;
    if (paramBaseArticleInfo != null) {}
    try
    {
      localObject = new StringBuilder();
      Map localMap = bjnd.a(paramString);
      ((StringBuilder)localObject).append("mqqapi://readinjoy/open?src_type=internal&target=3").append(a(localMap, "channelID", paramBaseArticleInfo.mChannelID + "")).append(a(localMap, "strategyId", paramBaseArticleInfo.mStrategyId + "")).append(a(localMap, "algorithmID", paramBaseArticleInfo.mAlgorithmID + "")).append(a(localMap, "title", paramBaseArticleInfo.mTitle)).append(a(localMap, "firstPagePicUrl", URLEncoder.encode(paramBaseArticleInfo.mFirstPagePicUrl, "UTF-8"))).append(a(localMap, "articleID", paramBaseArticleInfo.mArticleID + "")).append(a(localMap, "subscribeName", paramBaseArticleInfo.mSubscribeName)).append(a(localMap, "rowKey", paramBaseArticleInfo.innerUniqueID)).append(a(localMap, "subscribeID", paramBaseArticleInfo.mSubscribeID)).append(a(localMap, "articleContentUrl", URLEncoder.encode(paramString, "UTF-8"))).append("&").append("readinjoyNotDecodeUrl=1");
      localObject = ((StringBuilder)localObject).toString();
      QLog.d("ReadInJoyUtils", 1, "getJumpNativeArticleScheme |  articleScheme : " + (String)localObject);
      return localObject;
    }
    catch (UnsupportedEncodingException paramBaseArticleInfo)
    {
      for (;;)
      {
        localObject = paramString;
      }
    }
  }
  
  private static String b(String paramString, MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing.structingMsg.mAlgorithmIds != null) {
      paramString = paramMessageForStructing.structingMsg.mAlgorithmIds.split("\\|")[0];
    }
    return paramString;
  }
  
  public static URL b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (b(paramString))
    {
      localObject = pai.c();
      localObject = a(paramString, ((Integer)((Pair)localObject).second).intValue(), ((Integer)((Pair)localObject).first).intValue(), 3);
    }
    return a((String)localObject);
  }
  
  private static List<RecentBaseData> b()
  {
    localArrayList = new ArrayList();
    try
    {
      QQAppInterface localQQAppInterface = a();
      Object localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null)
      {
        QLog.d("ReadInJoyUtils", 1, "conversation frame is null");
        return localArrayList;
      }
      localObject1 = ((Conversation)localObject1).a().b();
      if (localObject1 == null) {
        return localArrayList;
      }
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData)) {
          localArrayList.add((RecentBaseData)localObject2);
        }
      }
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (RecentUserBaseData)localObject2;
          if ((((RecentUserBaseData)localObject2).mUser != null) && (((RecentUserBaseData)localObject2).mUser.getType() == 1008) && (uaw.b(localQQAppInterface, ((RecentUserBaseData)localObject2).mUser.uin))) {
            ((Iterator)localObject1).remove();
          }
        }
      }
      return localArrayList;
    }
    catch (Exception localException) {}
  }
  
  public static JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("kandian_mode", e());
      localJSONObject.put("kandian_mode_new", ofe.a());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_JavaUtilQueue != null) {
      jdField_a_of_type_JavaUtilQueue.clear();
    }
  }
  
  public static void b(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilQueue == null) {
      jdField_a_of_type_JavaUtilQueue = new LinkedBlockingQueue(100);
    }
    if (!jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt)))
    {
      jdField_a_of_type_JavaUtilQueue.poll();
      jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt));
    }
  }
  
  public static void b(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramActivity == null))
    {
      QLog.d("ReadInJoyUtils", 1, "clickCommentBiuCardWrapper error!");
      return;
    }
    if ((ooy.f()) && (r(paramArticleInfo))) {}
    for (String str = paramArticleInfo.getCardJumpUrl();; str = "")
    {
      if (!TextUtils.isEmpty(str)) {
        d(paramActivity, str);
      }
      for (;;)
      {
        QLog.d("ReadInJoyUtils", 1, "clickCommentBiuCardWrapper,jumpUrl=" + str);
        return;
        if (paramArticleInfo.isPGCShortContent())
        {
          if (a(paramArticleInfo, paramActivity))
          {
            QLog.d("ReadInJoyUtils", 1, "tryJumpToUgUrl: true");
          }
          else
          {
            QLog.d("ReadInJoyUtils", 1, "short content redirectToOtherPage!");
            qgg.a(paramActivity, paramArticleInfo);
          }
        }
        else if (A(paramArticleInfo))
        {
          rwv.a(paramActivity, null, 28, paramArticleInfo);
        }
        else if (s(paramArticleInfo))
        {
          QLog.d("ReadInJoyUtils", 1, "startWebFastActivity");
          a(paramActivity, paramArticleInfo);
        }
        else
        {
          QLog.d("ReadInJoyUtils", 1, "jumpNewSocialSecondPage");
          a(paramActivity, paramArticleInfo, 7, false, 0, false);
        }
      }
    }
  }
  
  public static void b(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    int m;
    if (paramArticleInfo.hasChannelInfo())
    {
      m = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label527;
      }
    }
    Object localObject1;
    Object localObject2;
    label527:
    for (int n = 0;; n = 1)
    {
      localObject1 = d(paramArticleInfo);
      odq.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, m), false);
      odq.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, m));
      localObject2 = uhv.b(paramInt);
      odq.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, m, n, NetworkUtil.isWifiConnected(paramContext), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, f(paramArticleInfo), paramArticleInfo), false);
      odq.a((String)localObject2, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, m, n, NetworkUtil.isWifiConnected(paramContext), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, f(paramArticleInfo), paramArticleInfo));
      paramContext = new ArrayList();
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = a();
      ((ReportInfo)localObject1).mSource = 0;
      ((ReportInfo)localObject1).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject1).mChannelId = paramInt;
      ((ReportInfo)localObject1).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject1).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject1).mOperation = 1;
      ((ReportInfo)localObject1).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject1).mReadTimeLength = -1;
      ((ReportInfo)localObject1).mInnerId = paramArticleInfo.innerUniqueID;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label540;
      }
      localObject2 = new rdy();
      ((rdy)localObject2).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer != null) {
        ((rdy)localObject2).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long;
      }
      ((rdy)localObject2).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((rdy)localObject2).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramArticleInfo == null) || (paramArticleInfo.isEmpty())) {
        break label533;
      }
      ((rdy)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
      paramArticleInfo = paramArticleInfo.iterator();
      while (paramArticleInfo.hasNext())
      {
        rer localrer = (rer)paramArticleInfo.next();
        if (localrer != null) {
          ((rdy)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrer.jdField_a_of_type_Long));
        }
      }
      m = 0;
      break;
    }
    label533:
    ((ReportInfo)localObject1).mFeedsReportData = ((rdy)localObject2);
    label540:
    paramContext.add(localObject1);
    pkm.a().a(paramContext);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = paramContext;
      if (!(paramContext instanceof BasePluginActivity)) {
        break;
      }
      localObject = ((BasePluginActivity)paramContext).getOutActivity();
    } while (localObject == null);
    paramContext = new Bundle();
    paramContext.putString("url", paramString);
    paramContext.putBoolean("hide_operation_bar", true);
    paramString = new Intent((Context)localObject, QQBrowserActivity.class);
    paramString.putExtras(paramContext);
    paramString.putExtra("selfSet_leftViewText", amtj.a(2131712220));
    ((Context)localObject).startActivity(paramString);
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(a(paramContext)));
    StatisticCollector.getInstance(paramContext).collectPerformance(paramString, "actKandianVideoPreload", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  private static void b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_JavaUtilArrayList != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramBaseArticleInfo.hasNext())
      {
        rfk localrfk = (rfk)paramBaseArticleInfo.next();
        if (localrfk != null)
        {
          localrfk.jdField_b_of_type_JavaLangString = a(localrfk.jdField_b_of_type_JavaLangString);
          localrfk.jdField_c_of_type_JavaLangString = a(localrfk.jdField_c_of_type_JavaLangString);
        }
      }
    }
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mVideoColumnInfo == null)) {
      return;
    }
    odq.a(null, null, "0X800A1C3", "0X800A1C3", 0, 0, "", "", "", new sie(null, null, null, null).i(paramBaseArticleInfo.innerUniqueID).c(paramBaseArticleInfo).d(paramBaseArticleInfo).Q(paramInt).a(paramBaseArticleInfo.videoReportInfo).a(paramBaseArticleInfo, false).a().a(), false);
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((paramString.contains("mqqapi://readinjoy/open")) && (paramString.contains("target=4"))) {
        paramBaseArticleInfo.mJumpType = 2;
      }
    }
    else {
      return;
    }
    paramBaseArticleInfo.mJumpType = 1;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", paramQQAppInterface.getAccount());
    localHashMap.put("param_cpu", String.valueOf(DeviceInfoUtil.getCpuNumber()));
    localHashMap.put("param_totalMem", String.valueOf(DeviceInfoUtil.getSystemTotalMemory()));
    localHashMap.put("param_availableMem", String.valueOf(DeviceInfoUtil.getSystemAvaialbeMemory()));
    localHashMap.put("param_version", "8.4.8");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actUserDeviceInfoReport", true, 100L, 0L, localHashMap, "", true);
  }
  
  public static void b(String paramString)
  {
    jdField_f_of_type_JavaLangString = paramString;
  }
  
  public static void b(String paramString, Object paramObject, boolean paramBoolean)
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      paramObject = PkgTools.toHexStr(((ByteArrayOutputStream)localObject).toByteArray());
      localObject = bkwm.a(a(), true, paramBoolean);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramObject);
        ((SharedPreferences.Editor)localObject).commit();
      }
      QLog.d("ReadInJoyUtils", 2, "asyncWriteDataToSP successful !  key : " + paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      QLog.d("ReadInJoyUtils", 2, "write hb info to storage , error : " + paramString.toString());
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramLong < 0L) || (paramLong > 30000L)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt));
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actKandianGetUserInfoSuccAndCost", paramBoolean, paramLong, 0L, localHashMap, null);
  }
  
  public static void b(AppRuntime paramAppRuntime, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return;
    }
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actKanDianViolaHttpData", paramBoolean, -1L, -1L, paramHashMap, null, true);
  }
  
  public static void b(oju paramoju, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramoju != null) {}
    try
    {
      paramoju.jdField_d_of_type_JavaLangString = String.valueOf(paramBaseArticleInfo.mChannelID);
      paramoju.jdField_g_of_type_JavaLangString = String.valueOf(paramBaseArticleInfo.mFeedId);
      paramBaseArticleInfo = (ArticleInfo)paramBaseArticleInfo;
      paramoju.jdField_h_of_type_JavaLangString = String.valueOf(paramBaseArticleInfo.mSubscribeID);
      if ((pgb.g(paramBaseArticleInfo)) || (pgb.a(paramBaseArticleInfo))) {
        paramoju.jdField_f_of_type_JavaLangString = "5";
      }
      for (;;)
      {
        paramoju.jdField_e_of_type_JavaLangString = "2";
        return;
        if (pgb.e(paramBaseArticleInfo)) {
          paramoju.jdField_f_of_type_JavaLangString = "4";
        } else {
          paramoju.jdField_f_of_type_JavaLangString = "0";
        }
      }
      return;
    }
    catch (Exception paramoju) {}
  }
  
  public static void b(boolean paramBoolean)
  {
    for (;;)
    {
      int m;
      try
      {
        if (a() == null) {
          break label261;
        }
        if (!bkwm.i()) {
          return;
        }
        Object localObject = (KandianMergeManager)a().getManager(162);
        JSONObject localJSONObject = a();
        if ((!((KandianMergeManager)localObject).a()) && (!((KandianMergeManager)localObject).i()))
        {
          m = 1;
          if (m != 3) {
            break label245;
          }
          localObject = ((KandianMergeManager)localObject).f() + "";
          localJSONObject.put("tab_status", m);
          localJSONObject.put("kandian_mode_new", ofe.a());
          if (m == 3) {
            localJSONObject.put("reddot_num", localObject);
          }
          a(true, localJSONObject);
          if (jdField_g_of_type_Int != 0) {
            break label251;
          }
          m = 0;
          localJSONObject.put("button_state", m);
          localJSONObject.put("os", 1);
          localJSONObject.put("version", ofe.jdField_a_of_type_JavaLangString);
          if (!ReadinjoyTabFrame.d_()) {
            break label256;
          }
          m = 1;
          localJSONObject.put("isInKandian", m);
          if (ojc.a != null) {
            localJSONObject.put("channel_id", ojc.a.mChannelCoverId);
          }
          odq.a(null, "CliOper", "", null, "0X80081C3", "0X80081C3", 0, 1, null, g(jdField_a_of_type_Rdh.jdField_c_of_type_JavaLangString), jdField_a_of_type_Rdh.jdField_b_of_type_JavaLangString, localJSONObject.toString(), false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      if (localJSONException.f() > 0)
      {
        m = 3;
        continue;
        label245:
        String str = "0";
        continue;
        label251:
        m = 1;
        continue;
        label256:
        m = 0;
      }
      else
      {
        label261:
        m = 2;
      }
    }
  }
  
  public static boolean b()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    return (localBaseActivity != null) && (((localBaseActivity instanceof ReadInJoyNewFeedsActivity)) || (localBaseActivity.getClass().getSimpleName().toLowerCase().contains("kandian")) || (localBaseActivity.getClass().getSimpleName().toLowerCase().contains("readinjoy")));
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool = false;
    int m;
    if ((paramInt != 5) && (paramInt != 6))
    {
      if (paramInt != 43) {
        break label39;
      }
      m = 1;
      if (paramInt != 18) {
        break label44;
      }
    }
    label39:
    label44:
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramInt | m) != 0) {
        bool = true;
      }
      return bool;
      m = 0;
      break;
    }
  }
  
  public static boolean b(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 3) {}
    do
    {
      return true;
      if ((Aladdin.getConfig(254).getIntegerFromString("is_fix_below_15min_click_flag", 0) == 1) && (paramInt1 == 0) && (uhv.a())) {
        return false;
      }
    } while (Aladdin.getConfig(251).getIntegerFromString("bt_fix", 0) != 1);
    return false;
  }
  
  public static boolean b(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong <= 0L) {
      l1 = System.currentTimeMillis();
    }
    paramLong = l1 - bkwm.a((QQAppInterface)a());
    if (QLog.isColorLevel()) {
      if (paramLong >= pak.jdField_a_of_type_Int) {
        break label90;
      }
    }
    label90:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ReadInJoyUtils", 2, new Object[] { "isNeedToRememberHistoryPos, timeInterval = ", Long.valueOf(paramLong), " , isNeedToRemember = ", Boolean.valueOf(bool) });
      if (paramLong >= pak.jdField_a_of_type_Int) {
        break;
      }
      return true;
    }
    return false;
  }
  
  @VisibleForTesting
  static boolean b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    do
    {
      do
      {
        return false;
      } while (paramArticleInfo.isAccountShown);
      if (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramArticleInfo.mFeedType))) {
        return true;
      }
    } while (!jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramArticleInfo.mFeedType)));
    int m = pgb.a(paramArticleInfo);
    return jdField_c_of_type_JavaUtilList.contains(Integer.valueOf(m));
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return false;
    }
    if ((paramBaseArticleInfo.mFeedType == 0) && (paramBaseArticleInfo.mIsGallery > 0) && (paramBaseArticleInfo.mGalleryFeedsInfo != null))
    {
      int m = paramBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
      if ((m == 3) || (m == 2) || (m == 1))
      {
        paramBaseArticleInfo.mIsGalleryChannel = true;
        return true;
      }
    }
    paramBaseArticleInfo.mIsGalleryChannel = false;
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        bool1 = bool2;
        if (!paramQQAppInterface.isread) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if (!paramMessageRecord.mIsParsed) {
        paramMessageRecord.parse();
      }
      if (paramMessageRecord.structingMsg != null) {
        break label32;
      }
    }
    for (;;)
    {
      return true;
      label32:
      if (!TextUtils.isEmpty(paramMessageRecord.structingMsg.mExtraData)) {
        try
        {
          int m = new JSONObject(paramMessageRecord.structingMsg.mExtraData).optInt("keyguard_jump", 1);
          if (m != 1) {
            return false;
          }
        }
        catch (JSONException paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
        }
      }
    }
    return true;
  }
  
  @Deprecated
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return false;
        paramString = paramString.split("/");
      } while (paramString.length < 2);
      paramString = paramString[(paramString.length - 2)].split("_");
    } while (paramString.length < 1);
    return "open".equals(paramString[(paramString.length - 1)]);
  }
  
  public static int c()
  {
    try
    {
      jdField_b_of_type_Int += 1;
      int m = jdField_b_of_type_Int;
      return m;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int c(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mPartnerAccountInfo == null)) {}
    while (!paramBaseArticleInfo.mPartnerAccountInfo.uint32_is_account_display.has()) {
      return 0;
    }
    return paramBaseArticleInfo.mPartnerAccountInfo.uint32_is_account_display.get();
  }
  
  public static String c()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (BaseApplicationImpl.getApplication() != null)
        {
          localObject = BaseApplicationImpl.getApplication().getRuntime();
          if (localObject != null)
          {
            localObject = (WtloginManager)((AppRuntime)localObject).getManager(1);
            if (localObject != null)
            {
              localObject = ((WtloginManager)localObject).getGUID();
              if ((localObject != null) && (localObject.length > 0))
              {
                localObject = HexUtil.bytes2HexStr((byte[])localObject);
                if (!TextUtils.isEmpty((CharSequence)localObject)) {
                  localJSONObject.put("guid", localObject);
                }
              }
            }
          }
        }
        localJSONObject.put("qua", d());
        localObject = new GdtDeviceInfoHelper.Params();
        ((GdtDeviceInfoHelper.Params)localObject).businessIdForAidTicketAndTaidTicket = "ce2d9f";
        localObject = GdtDeviceInfoHelper.create(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject);
        if (localObject == null) {
          continue;
        }
        localObject = ((GdtDeviceInfoHelper.Result)localObject).deviceInfo;
        if (localObject != null) {
          localJSONObject.put("oaid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject).aid_ticket.get());
        }
        localObject = Build.BRAND;
        localJSONObject.put("machine", Build.MODEL);
        localJSONObject.put("brand", localObject);
        localJSONObject.put("qimei", UserAction.getQIMEI());
      }
      catch (Exception localException)
      {
        Object localObject;
        localException.printStackTrace();
        continue;
      }
      return localJSONObject.toString();
      localObject = null;
    }
  }
  
  public static String c(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      ((JSONObject)localObject).put("reddot_num", paramInt);
      ((JSONObject)localObject).put("kandian_mode", e());
      ((JSONObject)localObject).put("session_id", jdField_f_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String c(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext != null)
        {
          paramContext = paramContext.getConnectionInfo().getBSSID();
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return "";
      }
      paramContext = "";
    }
  }
  
  public static String c(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return "";
    }
    Object localObject2 = paa.jdField_e_of_type_JavaLangString;
    Object localObject1 = "";
    if (((String)localObject2).contains("uin")) {
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long > 0L)) {
        localObject1 = String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long);
      }
    }
    for (localObject1 = ((String)localObject2).replace("uin=", "uin=" + bfuc.encodeToString(((String)localObject1).getBytes(), 0).replace('\n', ' ').trim());; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if (((String)localObject1).contains("&feedstype=")) {
        localObject2 = ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mFeedType);
      }
      paramArticleInfo = (String)localObject2 + paramArticleInfo.mFeedId;
      QLog.d("ReadInJoyUtils", 2, new Object[] { "getNewSocialSecondUrl = ", paramArticleInfo });
      return paramArticleInfo;
      if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
        break;
      }
      localObject1 = paramArticleInfo.mSubscribeID;
      break;
    }
  }
  
  public static String c(BaseArticleInfo paramBaseArticleInfo)
  {
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramBaseArticleInfo != null)
    {
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl)) {
        break label22;
      }
      localObject = localStringBuilder;
    }
    label22:
    do
    {
      do
      {
        return localObject;
        paramBaseArticleInfo = tmd.d(paramBaseArticleInfo.mArticleContentUrl);
        localObject = localStringBuilder;
      } while (!tgc.b(paramBaseArticleInfo));
      paramBaseArticleInfo = tgc.b(paramBaseArticleInfo);
      localObject = paramBaseArticleInfo;
    } while (!QLog.isColorLevel());
    localStringBuilder = new StringBuilder().append("get viola url from articleContentUrl: ");
    if (paramBaseArticleInfo != null) {}
    for (localObject = paramBaseArticleInfo;; localObject = "null")
    {
      QLog.d("ReadInJoyUtils", 2, (String)localObject);
      return paramBaseArticleInfo;
    }
  }
  
  public static String c(String paramString)
  {
    return a(paramString, "");
  }
  
  public static String c(String paramString, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramString;
    if (paramBaseArticleInfo != null) {}
    try
    {
      localObject = new StringBuilder(paramString);
      String str = paramBaseArticleInfo.mVideoCoverUrl.toExternalForm();
      Map localMap = bjnd.a(paramString);
      ((StringBuilder)localObject).append(a(localMap, "videoType", paramBaseArticleInfo.busiType + "")).append(a(localMap, "videoVid", paramBaseArticleInfo.mVideoVid)).append(a(localMap, "videoWidth", paramBaseArticleInfo.mVideoJsonWidth + "")).append(a(localMap, "videoHeight", paramBaseArticleInfo.mVideoJsonHeight + "")).append(a(localMap, "videoDuration", paramBaseArticleInfo.mVideoDuration + "")).append(a(localMap, "title", paramBaseArticleInfo.mTitle)).append(a(localMap, "firstPagePicUrl", URLEncoder.encode(str, "UTF-8"))).append(a(localMap, "articleContentUrl", URLEncoder.encode(paramBaseArticleInfo.mArticleContentUrl, "UTF-8"))).append(a(localMap, "subscribeName", paramBaseArticleInfo.mSubscribeName)).append(a(localMap, "subscribeID", paramBaseArticleInfo.mSubscribeID)).append(a(localMap, "readinjoyNotDecodeUrl", "1"));
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.d("ReadInJoyUtils", 2, paramBaseArticleInfo.getMessage());
    }
    return paramString;
  }
  
  private static String c(String paramString, MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing.structingMsg.mStrategyIds != null) {
      paramString = paramMessageForStructing.structingMsg.mStrategyIds.split("\\|")[0];
    }
    return paramString;
  }
  
  public static void c()
  {
    jdField_f_of_type_Int = -1;
  }
  
  public static void c(int paramInt)
  {
    jdField_f_of_type_Int = paramInt;
  }
  
  private static void c(Context paramContext)
  {
    d(paramContext);
    StatisticCollector.getInstance(paramContext).collectPerformance(a().getAccount(), "actReadInJoyDDShowVideoAS", true, 0L, 0L, null, "");
  }
  
  public static void c(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((paramArticleInfo == null) || (paramContext == null))
    {
      QLog.d("ReadInJoyUtils", 1, "clickCommentBiuCard error!");
      return;
    }
    String str;
    if ((paramInt == 6) && (ooy.e()))
    {
      if ((paramArticleInfo.isCardJumpUrlAvailable != 1) || (TextUtils.isEmpty(paramArticleInfo.getCardJumpUrl()))) {
        break label144;
      }
      str = paramArticleInfo.getCardJumpUrl();
    }
    for (;;)
    {
      if (TextUtils.isEmpty(str)) {
        a(paramContext, paramArticleInfo, paramInt, false, 0, false);
      }
      for (;;)
      {
        QLog.d("ReadInJoyUtils", 1, "clickCommentBiuCard,clickType=" + paramInt + " ,jumpUrl=" + str);
        return;
        if ((paramInt != 8) || (!ooy.g()) || (TextUtils.isEmpty(paramArticleInfo.commentBtnJumpUrl))) {
          break label144;
        }
        str = paramArticleInfo.commentBtnJumpUrl;
        break;
        d(paramContext, str);
      }
      label144:
      str = "";
    }
  }
  
  public static void c(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    Object localObject;
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = Uri.parse(paramString);
      if (TextUtils.isEmpty(((Uri)localObject).getPath())) {
        break label224;
      }
      if (((Uri)localObject).getPath().equals("/mqq/vue/wendadetail"))
      {
        localBundle = new Bundle();
        localBundle.putString("url", paramString);
        str = ((Uri)localObject).getQuery();
        localObject = "https://kandian.qq.com/viola/bundle_wendadetail.js?v_bid=3256&hideNav=1&statusColor=1";
        if (!TextUtils.isEmpty(str)) {
          localObject = "https://kandian.qq.com/viola/bundle_wendadetail.js?v_bid=3256&hideNav=1&statusColor=1" + "&" + str;
        }
        tgc.a(paramContext, amtj.a(2131711968), (String)localObject, localBundle, new paz(paramContext, paramString));
      }
    }
    else
    {
      return;
    }
    if (((Uri)localObject).getPath().equals("/mqq/vue/wenda"))
    {
      localBundle = new Bundle();
      localBundle.putString("url", paramString);
      str = ((Uri)localObject).getQuery();
      localObject = "https://kandian.qq.com/viola/bundle_wenda.js?v_bid=3256&hideNav=1&statusColor=1";
      if (!TextUtils.isEmpty(str)) {
        localObject = "https://kandian.qq.com/viola/bundle_wenda.js?v_bid=3256&hideNav=1&statusColor=1" + "&" + str;
      }
      tgc.a(paramContext, amtj.a(2131711944), (String)localObject, localBundle, new pba(paramContext, paramString));
      return;
    }
    label224:
    a(paramContext, paramString, localBundle);
  }
  
  public static void c(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null) {
      paramHashMap.put("param_networkDetail", Integer.toString(a(paramContext)));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramHashMap != null)
      {
        Iterator localIterator = paramHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localStringBuilder.append((String)localEntry.getKey()).append(":").append((String)localEntry.getValue()).append(" ");
        }
      }
      QLog.d("Q.readinjoy.video", 2, "actKandianVideoGetUrl, success =" + paramBoolean + ",  data=" + localStringBuilder.toString());
    }
    StatisticCollector.getInstance(paramContext).collectPerformance(paramString, "actKandianVideoGetUrl", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  private static void c(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaUtilArrayList != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramBaseArticleInfo.hasNext())
      {
        rff localrff = (rff)paramBaseArticleInfo.next();
        if (localrff != null)
        {
          localrff.jdField_b_of_type_JavaLangString = a(localrff.jdField_b_of_type_JavaLangString);
          localrff.jdField_c_of_type_JavaLangString = a(localrff.jdField_c_of_type_JavaLangString);
        }
      }
    }
  }
  
  public static void c(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mGroupSubArticleList == null) || (paramBaseArticleInfo.mGroupSubArticleList.isEmpty())) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[");
    int n = paramBaseArticleInfo.mGroupSubArticleList.size();
    int m = 0;
    while (m < n)
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(m);
      String str = localBaseArticleInfo.getInnerUniqueID();
      int i1 = localBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Int;
      if (localBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Boolean)
      {
        localStringBuilder.append(str);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUtils", 2, "position：" + i1 + ", rowKey: " + str);
        }
      }
      if ((n != 1) && (m != n - 1)) {
        localStringBuilder.append(",");
      }
      m += 1;
    }
    localStringBuilder.append("]");
    odq.a(null, null, "0X800A5AA", "0X800A5AA", 0, 0, "", "", "", new sie(paramString, null, null, null, null).V(54).i(localStringBuilder.toString()).a().a(), false);
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (jdField_j_of_type_Boolean)
    {
      jdField_j_of_type_Boolean = false;
      i();
    }
    if (bkwm.k())
    {
      pkm.a().d(0);
      pkm.a().d(56);
      pkm.a().e(40677);
      if (pcl.b(pcl.b())) {
        pkm.a().d(pcl.b());
      }
    }
    jdField_i_of_type_Boolean = true;
    ThreadManager.post(new ReadInJoyUtils.3(paramQQAppInterface), 8, null, false);
  }
  
  public static void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      bkwm.a("key_study_mode_grade_choose", paramString);
      pkp.a().a(new pbe(paramString));
    }
    QLog.d("ReadInJoyUtils", 1, "updateSelectedGrades ! res= " + paramString);
  }
  
  public static void c(AppRuntime paramAppRuntime, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return;
    }
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actKanDianViolaJsError", paramBoolean, -1L, -1L, paramHashMap, null, true);
  }
  
  public static boolean c()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (!(localBaseActivity instanceof SplashActivity)) {
      return false;
    }
    if (((SplashActivity)localBaseActivity).a() == MainFragment.jdField_h_of_type_Int) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean c(int paramInt)
  {
    boolean bool = true;
    if ((paramInt != 0) && (!pcl.b(paramInt))) {
      return false;
    }
    if (Aladdin.getConfig(256).getIntegerFromString("enable_delete_article_after_refresh", 0) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 17) {
      return false;
    }
    return true;
  }
  
  public static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    if (s(paramBaseArticleInfo))
    {
      paramBaseArticleInfo = (rdn)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      return (paramBaseArticleInfo.jdField_a_of_type_Rdq != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.jdField_a_of_type_Rdq.jdField_a_of_type_JavaLangString));
    }
    return false;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    int n = jdField_a_of_type_Int;
    if ((paramQQAppInterface == null) || (n <= 0)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject1 = akla.a().jdField_a_of_type_JavaUtilList;
      if (localObject1 != null) {
        localArrayList.addAll((Collection)localObject1);
      }
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (RecentUserBaseData)localObject2;
          if ((((RecentUserBaseData)localObject2).mUser != null) && (((RecentUserBaseData)localObject2).mUser.getType() == 1008) && (uaw.b(paramQQAppInterface, ((RecentUserBaseData)localObject2).mUser.uin)))
          {
            ((Iterator)localObject1).remove();
            continue;
            return false;
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + paramQQAppInterface.toString());
    }
    for (;;)
    {
      int i1 = localArrayList.size();
      int m = n;
      if (n > i1) {
        m = i1;
      }
      while (n < m)
      {
        paramQQAppInterface = (RecentBaseData)localArrayList.get(n);
        if (paramQQAppInterface != null)
        {
          boolean bool = TextUtils.equals(((RecentUserBaseData)paramQQAppInterface).getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN);
          if (bool) {
            return true;
          }
        }
        n += 1;
        continue;
        n = 0;
      }
    }
  }
  
  public static boolean c(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord) == 1;
  }
  
  public static boolean c(String paramString)
  {
    Object localObject1 = new ArrayList();
    label51:
    int m;
    do
    {
      do
      {
        while (!((Iterator)localObject1).hasNext()) {
          try
          {
            localObject2 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
            if (localObject2 == null) {
              return false;
            }
            localObject2 = ((Conversation)localObject2).a().b();
            if (localObject2 == null) {
              return false;
            }
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = ((Iterator)localObject2).next();
              if (!(localObject3 instanceof RecentBaseData)) {
                break label51;
              }
              ((List)localObject1).add((RecentBaseData)localObject3);
              break label51;
            }
            localObject1 = ((List)localObject1).iterator();
          }
          catch (Exception paramString)
          {
            QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + paramString.toString());
            return false;
          }
        }
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
      } while (localObject2 == null);
      Object localObject2 = (RecentUserBaseData)localObject2;
      if (TextUtils.equals(((RecentUserBaseData)localObject2).getRecentUserUin(), paramString)) {
        return true;
      }
      m = ((RecentUserBaseData)localObject2).mMenuFlag;
    } while ((m & 0x20) != 0);
    return false;
  }
  
  public static int d()
  {
    int m = 1;
    if (jdField_f_of_type_Int != -1) {
      return jdField_f_of_type_Int;
    }
    if (bkwm.i())
    {
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity == null) {
        return -1;
      }
      Object localObject;
      if ((localBaseActivity instanceof SplashActivity))
      {
        localObject = FrameHelperActivity.a(BaseActivity.sTopActivity);
        if (localObject != null) {}
      }
      for (;;)
      {
        return -1;
        localObject = (ReadinjoyTabFrame)((FrameHelperActivity)localObject).a(ReadinjoyTabFrame.class);
        if (localObject != null)
        {
          if (bkwm.j()) {
            return 2;
          }
          int n = ((ReadinjoyTabFrame)localObject).a();
          if (n == 0) {
            return 1;
          }
          if (n == 2) {
            return 3;
          }
          if (n == 1) {
            return 2;
          }
          if ((localBaseActivity instanceof PublicFragmentActivity))
          {
            if ((localBaseActivity.getIntent() != null) && (QLog.isColorLevel())) {
              QLog.d("ReadInJoyUtils", 2, new Object[] { "ClassName: ", localBaseActivity.getIntent().getStringExtra("public_fragment_class") });
            }
            if ((localBaseActivity.getIntent() != null) && (localBaseActivity.getIntent().getStringExtra("public_fragment_class").equals("com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment"))) {
              return 3;
            }
            if ((localBaseActivity.getIntent() != null) && (localBaseActivity.getIntent().getStringExtra("public_fragment_class").equals("com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment"))) {
              return 6;
            }
          }
          if ((localBaseActivity instanceof ReadInJoyNewFeedsActivity)) {
            return ReadInJoyNewFeedsActivity.jdField_c_of_type_Int + 1;
          }
          if ((localBaseActivity instanceof ReadInJoyChannelActivity))
          {
            if (localBaseActivity.getIntent().getIntExtra("channel_id", 0) == 56) {}
            while (m != 0)
            {
              return 2;
              m = 0;
            }
          }
        }
      }
    }
    return ReadInJoyNewFeedsActivity.jdField_c_of_type_Int + 1;
  }
  
  public static String d()
  {
    if (!jdField_a_of_type_JavaLangString.isEmpty()) {
      return jdField_a_of_type_JavaLangString;
    }
    int m = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int n = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i1;
    if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2)
    {
      i1 = n;
      n = m;
    }
    for (;;)
    {
      String str = "" + i1 + "*" + n;
      jdField_a_of_type_JavaLangString = "PR=QQ&PP=com.tencent.mobileqq&PPVN=8.4.8.4810&CO=SYS&PL=ADR&LCID=" + AppSetting.d() + "&RL=" + str + "&DE=" + Build.BRAND + "&MO=" + Build.MODEL + "&REF=NA_0";
      return jdField_a_of_type_JavaLangString;
      i1 = m;
    }
  }
  
  public static String d(int paramInt)
  {
    Object localObject = a();
    int n = Math.max(10, jdField_a_of_type_Int);
    if (localObject == null) {
      return "";
    }
    List localList = b();
    StringBuilder localStringBuilder = new StringBuilder(jdField_a_of_type_Int + ":");
    int m = localList.size();
    if (0 + n < m) {
      m = 0 + n;
    }
    for (;;)
    {
      abwp localabwp = ((QQAppInterface)localObject).getConversationFacade();
      n = 0;
      if (n < m)
      {
        localObject = (RecentBaseData)localList.get(n);
        RecentUserBaseData localRecentUserBaseData;
        int i1;
        if (localObject != null)
        {
          localRecentUserBaseData = (RecentUserBaseData)localObject;
          if ((localRecentUserBaseData.mUser != null) && ((localRecentUserBaseData.mUser.getType() == paramInt) || (paramInt == -1)))
          {
            i1 = localabwp.a(localRecentUserBaseData.getRecentUserUin(), localRecentUserBaseData.mUser.getType());
            if (localRecentUserBaseData.mUnreadFlag == 3) {
              i1 = 0;
            }
            if (localRecentUserBaseData.mUser.getType() != 1008) {
              break label244;
            }
          }
        }
        label244:
        for (localObject = "1";; localObject = "0")
        {
          localStringBuilder.append((String)localObject).append("_").append(localRecentUserBaseData.getRecentUserUin()).append("_").append(i1);
          if (n != m - 1) {
            localStringBuilder.append(":");
          }
          n += 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, "getScreenPaInfo : " + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
  }
  
  public static String d(@NotNull Context paramContext)
  {
    return Aladdin.getConfig(264).getString("push_title", paramContext.getResources().getString(2131717409));
  }
  
  private static String d(ArticleInfo paramArticleInfo)
  {
    if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
      return "0";
    }
    long l1 = Long.parseLong(paramArticleInfo.mSubscribeID);
    try
    {
      bool = ((amxz)BaseApplicationImpl.getApplication().getRuntime().getManager(56)).a(Long.valueOf(l1), true);
      if (bool) {
        return "1";
      }
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    return "2";
  }
  
  public static String d(BaseArticleInfo paramBaseArticleInfo)
  {
    int n = 1;
    int m;
    if (qxf.a((ArticleInfo)paramBaseArticleInfo) == 2)
    {
      m = 1;
      if (qxf.a((ArticleInfo)paramBaseArticleInfo) != 1) {
        break label52;
      }
    }
    for (;;)
    {
      if (!B(paramBaseArticleInfo)) {
        break label57;
      }
      return String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long);
      m = 0;
      break;
      label52:
      n = 0;
    }
    label57:
    if (m != 0) {
      return h(paramBaseArticleInfo);
    }
    if (n != 0) {
      return ((articlesummary.SpecialTopicInfo)paramBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
    }
    if (C(paramBaseArticleInfo)) {
      return paramBaseArticleInfo.mSubscribeID;
    }
    return "";
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (paramString.length() < 8) {
      return paramString + "|" + paramString.length();
    }
    return paramString.substring(0, 8) + "|" + paramString.length();
  }
  
  private static String d(String paramString, MessageForStructing paramMessageForStructing)
  {
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mArticleIds)) {
      paramString = paramMessageForStructing.structingMsg.mArticleIds.split("\\|")[0];
    }
    return paramString;
  }
  
  public static void d()
  {
    if (!ReadinjoyTabFrame.d_()) {
      b(false);
    }
  }
  
  public static void d(int paramInt)
  {
    jdField_j_of_type_Int = paramInt;
  }
  
  private static void d(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_dian_dian", true);
    oph.a(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772240, 2130772041);
  }
  
  public static void d(Context paramContext, String paramString)
  {
    QLog.d("ReadInJoyUtils", 1, "jumToUrl: " + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("mqqapi:")) {
        break label95;
      }
      QQAppInterface localQQAppInterface = pem.a();
      if (localQQAppInterface == null) {
        break label62;
      }
      bfwg.a(localQQAppInterface, paramContext, paramString).a();
    }
    label62:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyUtils", 2, "jumpToUrl failed for appInterface is null, url:" + paramString);
    return;
    label95:
    e(paramContext, paramString);
  }
  
  public static void d(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(paramContext).collectPerformance(paramString, "actVideoFeedsStartTime", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    jdField_i_of_type_Boolean = false;
  }
  
  public static void d(String paramString)
  {
    try
    {
      pbg localpbg = new pbg();
      localpbg.l();
      localpbg.m();
      odq.a(null, "", paramString, paramString, 0, 0, "", "", "", localpbg.a(), false);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("ReadInJoyUtils", 1, "gradeEntryReport error! e= " + paramString);
    }
  }
  
  public static boolean d()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (!(localBaseActivity instanceof PublicFragmentActivity)) {
      return false;
    }
    return ((PublicFragmentActivity)localBaseActivity).a() instanceof ReadInJoyDailyFragment;
  }
  
  public static boolean d(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 16) {
      return false;
    }
    return true;
  }
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = true;
    if (paramBaseArticleInfo == null) {
      return false;
    }
    if ((paramBaseArticleInfo.mShowBigPicture) && (paramBaseArticleInfo.mIsGallery == 1))
    {
      bool1 = bool2;
      if (paramBaseArticleInfo.articleStyle != 3)
      {
        bool1 = bool2;
        if (paramBaseArticleInfo.articleStyle != 4)
        {
          bool1 = bool2;
          if (paramBaseArticleInfo.articleStyle != 5)
          {
            bool1 = bool2;
            if (paramBaseArticleInfo.articleStyle != 6) {
              if (!b(paramBaseArticleInfo)) {
                break label75;
              }
            }
          }
        }
      }
    }
    label75:
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    if (jdField_e_of_type_Boolean)
    {
      ThreadManager.executeOnSubThread(new ReadInJoyUtils.8(paramQQAppInterface));
      jdField_e_of_type_Boolean = false;
    }
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof SplashActivity))
    {
      if (((SplashActivity)localObject).a() != MainFragment.jdField_b_of_type_Int)
      {
        QLog.d("ReadInJoyUtils", 1, "r:Not in conversationtab");
        return false;
      }
    }
    else
    {
      QLog.d("ReadInJoyUtils", 1, "r:top activity is not splash");
      return false;
    }
    if (!bkwm.c(paramQQAppInterface))
    {
      QLog.d("ReadInJoyUtils", 1, "r:config false");
      return false;
    }
    if (!SettingCloneUtil.readValue(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), null, "qqsetting_kandian_key", true))
    {
      QLog.d("ReadInJoyUtils", 1, "kandian push disabled");
      return false;
    }
    localObject = bkwm.a(paramQQAppInterface);
    String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    int m = Calendar.getInstance().get(11);
    if ((!TextUtils.equals((CharSequence)localObject, str)) && (m >= 6))
    {
      if (!b(paramQQAppInterface))
      {
        QLog.d("ReadInJoyUtils", 1, "r:true to get individual push");
        return true;
      }
      QLog.d("ReadInJoyUtils", 1, "r:already has red point");
    }
    for (;;)
    {
      return false;
      QLog.d("ReadInJoyUtils", 1, "r:hour:" + m);
    }
  }
  
  public static boolean d(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString.getHost()))
      {
        bool1 = bool2;
        if (paramString.getHost().equals("kandian.qq.com"))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramString.getPath())) {
            if (!paramString.getPath().equals("/mqq/vue/wendadetail"))
            {
              bool1 = bool2;
              if (!paramString.getPath().equals("/mqq/vue/wenda")) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static int e()
  {
    return jdField_j_of_type_Int;
  }
  
  public static String e()
  {
    return a(-1L);
  }
  
  public static String e(int paramInt)
  {
    String str;
    if (paramInt == puf.a()) {
      str = jdField_d_of_type_Int + "";
    }
    for (;;)
    {
      try
      {
        Integer.parseInt(str);
        return str;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        AIOUtils.catchedExceptionInRelease("ReadInJoyUtils", "fs is not number", localNumberFormatException);
      }
      switch (paramInt)
      {
      default: 
        if (pcl.c(paramInt)) {
          str = ozh.a();
        }
        break;
      case 0: 
        str = jdField_d_of_type_Int + "";
        break;
      case 70: 
        str = ozk.a();
        if (d() == 6)
        {
          str = jdField_d_of_type_Int + "";
          continue;
          str = jdField_d_of_type_Int + "";
        }
        break;
      }
    }
    return "1";
  }
  
  private static String e(ArticleInfo paramArticleInfo)
  {
    String str = "";
    if (!pgb.o(paramArticleInfo)) {
      str = String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long);
    }
    return str;
  }
  
  public static String e(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.isSubscriptFeed()) {
      return "3";
    }
    if ((paramBaseArticleInfo.mPackInfoObj == null) || (!paramBaseArticleInfo.mPackInfoObj.pack_type.has())) {
      return "";
    }
    int m = paramBaseArticleInfo.mPackInfoObj.pack_type.get();
    if ((m == 3) && (paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.has()) && (((articlesummary.FriendRecommendInfo)paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.has())) {
      return "1";
    }
    if ((m == 2) && (paramBaseArticleInfo.mPackInfoObj.msg_special_topic_info.has())) {
      return "2";
    }
    return "";
  }
  
  public static String e(String paramString)
  {
    if (DeviceInfoUtil.getPortraitHeight() > 720L) {
      return a(paramString, 18);
    }
    return a(paramString, 24);
  }
  
  public static void e()
  {
    if (jdField_a_of_type_Rdh.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      jdField_a_of_type_Rdh.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isread = true;
    }
  }
  
  private static void e(Context paramContext)
  {
    if ((!l) && (paramContext != null))
    {
      paramContext = paramContext.getApplicationContext();
      l = true;
      AppNetConnInfo.registerNetChangeReceiver(paramContext, new pbd(paramContext));
      f(paramContext);
    }
  }
  
  public static void e(Context paramContext, String paramString)
  {
    QLog.d("ReadInJoyUtils", 1, "jumToWeb: " + paramString);
    if ((!TextUtils.isEmpty(paramString)) && (tgc.b(paramString))) {
      tgc.a(paramContext, null, tgc.b(paramString), null);
    }
    Intent localIntent;
    do
    {
      return;
      if (bbgk.d(paramString))
      {
        bbgk.a(paramContext, bbgk.a(paramString), paramString);
        return;
      }
      localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("big_brother_source_key", f(0));
    } while (TextUtils.isEmpty(paramString));
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static void e(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(paramContext).collectPerformance(paramString, "actVideoFeedsScrollIntervalTime", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void e(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      MessageForStructing localMessageForStructing;
      QQMessageFacade localQQMessageFacade;
      do
      {
        do
        {
          return;
          localMessageForStructing = a(paramQQAppInterface);
        } while ((a(paramQQAppInterface)) || (localMessageForStructing == null));
        localQQMessageFacade = paramQQAppInterface.getMessageFacade();
      } while (localQQMessageFacade == null);
      localMessageForStructing.time = NetConnInfoCenter.getServerTime();
      MessageRecord localMessageRecord = ((KandianMergeManager)paramQQAppInterface.getManager(162)).a(localMessageForStructing);
      if (localMessageRecord != null) {
        localQQMessageFacade.addMessage(localMessageRecord, paramQQAppInterface.getCurrentUin());
      }
      localQQMessageFacade.addMessage(localMessageForStructing, paramQQAppInterface.getCurrentUin());
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyUtils", 2, "notifyXinKandianMsg");
  }
  
  public static void e(String paramString)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("tab_source", paramString);
      paramString = localJSONObject.toString();
      odq.a(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", paramString, false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        paramString = str;
        if (QLog.isColorLevel())
        {
          QLog.e("ReadInJoyUtils", 2, "firstClassDeliverOperationReport:" + localJSONException.toString());
          paramString = str;
        }
      }
    }
  }
  
  public static boolean e()
  {
    return (b()) || (c());
  }
  
  public static boolean e(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong.longValue() == 23L);
  }
  
  public static boolean e(BaseArticleInfo paramBaseArticleInfo)
  {
    return paramBaseArticleInfo.mIsPolymericGallery;
  }
  
  public static boolean e(QQAppInterface paramQQAppInterface)
  {
    KeyguardManager localKeyguardManager = (KeyguardManager)BaseApplicationImpl.getContext().getApplicationContext().getSystemService("keyguard");
    return (paramQQAppInterface.isBackgroundPause) || (paramQQAppInterface.isBackgroundStop) || (localKeyguardManager.inKeyguardRestrictedInputMode());
  }
  
  public static boolean e(String paramString)
  {
    return TextUtils.equals(AppConstants.WEISHI_UIN, paramString);
  }
  
  public static int f()
  {
    boolean bool2 = false;
    int i2 = 1024;
    int i3 = 100;
    int i4 = 2;
    int m;
    int n;
    int i1;
    boolean bool1;
    if (!TextUtils.isEmpty(uex.jdField_g_of_type_JavaLangString))
    {
      m = i4;
      n = i3;
      i1 = i2;
      bool1 = bool2;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(uex.jdField_g_of_type_JavaLangString);
        m = i4;
        n = i3;
        i1 = i2;
        bool1 = bool2;
        bool2 = localJSONObject.optBoolean("useNewLogic", false);
        m = i4;
        n = i3;
        i1 = i2;
        bool1 = bool2;
        i2 = localJSONObject.optInt("minTotalMem", 1024);
        m = i4;
        n = i3;
        i1 = i2;
        bool1 = bool2;
        i3 = localJSONObject.optInt("minAvailableMem", 100);
        m = i4;
        n = i3;
        i1 = i2;
        bool1 = bool2;
        i4 = localJSONObject.optInt("minCpuNum", 2);
        m = i4;
        n = i3;
        i1 = i2;
        bool1 = bool2;
        int i5 = localJSONObject.optInt("minCpuFreq", 1000);
        bool1 = bool2;
        i1 = i3;
        n = i4;
        m = i5;
      }
      catch (Exception localException)
      {
        long l1;
        long l2;
        long l3;
        i2 = i1;
        i1 = n;
        n = m;
        m = 1000;
        continue;
        if (l2 >>> 20 < i1) {
          continue;
        }
        return 2;
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        return 1;
        return 0;
      }
      if (bool1)
      {
        l1 = DeviceInfoUtil.getSystemTotalMemory();
        l2 = DeviceInfoUtil.getSystemAvaialbeMemory();
        i3 = DeviceInfoUtil.getCpuNumber();
        l3 = DeviceInfoUtil.getCpuFrequency();
        if ((l1 >>> 20 >= i2) && (i3 >= n) && (l3 >= m)) {
          return 1;
        }
      }
      if (Build.VERSION.SDK_INT >= 19) {
        return 1;
      }
      return 0;
      bool1 = false;
      i2 = 1024;
      i1 = 100;
      n = 2;
      m = 1000;
    }
  }
  
  public static String f()
  {
    int m = 1;
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      if (bkwm.C(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
      for (;;)
      {
        ((JSONObject)localObject).put("reddot_style", m);
        ((JSONObject)localObject).put("kandian_mode", e());
        ((JSONObject)localObject).put("kandian_mode_new", ofe.a());
        ((JSONObject)localObject).put("tab_source", d());
        ((JSONObject)localObject).put("session_id", jdField_f_of_type_JavaLangString);
        localObject = ((JSONObject)localObject).toString();
        return localObject;
        m = 0;
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public static String f(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (pcl.c(paramInt)) {
        return "biz_src_gzh_kandiandaily";
      }
      break;
    case 0: 
      return "biz_src_feeds_kandian";
    case 40677: 
      return "biz_src_gzh_weishi";
    }
    return "biz_src_feeds_kandian";
  }
  
  private static String f(ArticleInfo paramArticleInfo)
  {
    String str2 = "";
    String str1 = str2;
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer != null) {
        str1 = String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long);
      }
    }
    return str1;
  }
  
  public static String f(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    if (paramBaseArticleInfo.isSubscriptFeed()) {
      return "1";
    }
    if ((paramBaseArticleInfo.mPackInfoObj != null) && (paramBaseArticleInfo.mPackInfoObj.has()) && (paramBaseArticleInfo.mPackInfoObj.pack_type.get() == 3)) {
      return "2";
    }
    return "";
  }
  
  public static String f(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("&tp=webp"))) {
      return paramString;
    }
    return paramString.replace("&tp=webp", "");
  }
  
  public static void f()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)a();
    if (localQQAppInterface == null) {
      return;
    }
    a(((KandianMergeManager)localQQAppInterface.getManager(162)).a());
  }
  
  private static void f(Context paramContext)
  {
    WifiInfo localWifiInfo;
    if (paramContext != null)
    {
      localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo != null)
      {
        if (!TextUtils.isEmpty(localWifiInfo.getBSSID())) {
          break label56;
        }
        paramContext = "";
        jdField_h_of_type_JavaLangString = paramContext;
        if (!TextUtils.isEmpty(jdField_h_of_type_JavaLangString)) {
          break label64;
        }
      }
    }
    label56:
    label64:
    for (paramContext = "";; paramContext = localWifiInfo.getSSID())
    {
      jdField_i_of_type_JavaLangString = paramContext;
      return;
      paramContext = localWifiInfo.getBSSID();
      break;
    }
  }
  
  public static void f(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(a(paramContext)));
    StatisticCollector.getInstance(paramContext).collectPerformance(paramString, "actKandianVideoBehaviorsSeq", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void f(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.getMessageFacade();
    if (localObject == null) {
      return;
    }
    MessageRecord localMessageRecord = ((QQMessageFacade)localObject).getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
    localObject = localMessageRecord;
    if (jdField_a_of_type_Rdh.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      if (localMessageRecord != null)
      {
        localObject = localMessageRecord;
        if (localMessageRecord.time > jdField_a_of_type_Rdh.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time) {}
      }
      else
      {
        localObject = jdField_a_of_type_Rdh.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
    }
    a(paramQQAppInterface, (MessageRecord)localObject);
  }
  
  public static void f(String paramString)
  {
    if (jdField_j_of_type_JavaLangString != null) {
      pbm.a(jdField_j_of_type_JavaLangString);
    }
    jdField_j_of_type_JavaLangString = paramString;
  }
  
  public static boolean f()
  {
    if (!a()) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    try
    {
      localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((Conversation)localObject1).a().b();
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData))
        {
          localArrayList.add((RecentBaseData)localObject2);
          continue;
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + localException.toString());
    }
    for (;;)
    {
      int n = localException.size();
      int m = 0;
      while (m < n)
      {
        localObject1 = (RecentBaseData)localException.get(m);
        if (localObject1 != null)
        {
          localObject1 = (RecentUserBaseData)localObject1;
          if ((!TextUtils.equals(((RecentUserBaseData)localObject1).getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN)) && (((RecentUserBaseData)localObject1).getRecentUserType() != 5000))
          {
            int i1 = ((RecentUserBaseData)localObject1).getUnreadNum();
            if (i1 > 0) {
              return true;
            }
          }
        }
        m += 1;
      }
    }
  }
  
  public static boolean f(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 19) {
      return false;
    }
    return true;
  }
  
  public static boolean f(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList.size() > 0);
  }
  
  public static boolean f(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label49;
      }
    }
    label49:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null) {
        return ((amxz)((AppInterface)localObject).getManager(56)).a(Long.valueOf(paramString));
      }
      return false;
    }
  }
  
  public static int g()
  {
    return KandianVideoUploadService.a();
  }
  
  public static String g()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("kandian_mode", String.valueOf(e()));
      localJSONObject.put("kandian_mode_new", ofe.a());
      localJSONObject.put("session_id", jdField_f_of_type_JavaLangString);
      if (ptv.a()) {}
      for (String str = "1";; str = "0")
      {
        localJSONObject.put("is_requesting_articles", str);
        localJSONObject.put("os", 1);
        localJSONObject.put("version", ofe.jdField_a_of_type_JavaLangString);
        return localJSONObject.toString();
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public static String g(int paramInt)
  {
    return BaseApplication.getContext().getResources().getString(paramInt);
  }
  
  public static String g(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (!pcl.c((int)paramBaseArticleInfo.mChannelID)) || (TextUtils.isEmpty(paramBaseArticleInfo.proteusItemsData))) {
      return "";
    }
    try
    {
      paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.proteusItemsData).optString("card_report_params");
      return paramBaseArticleInfo;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("ReadInJoyUtils", 1, paramBaseArticleInfo, new Object[0]);
    }
    return "";
  }
  
  public static String g(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString)) {}
      for (;;)
      {
        paramString = new BigInteger(paramString);
        QLog.d("ReadInJoyUtils", 2, new Object[] { "convertArticleID bigInteger long value = ", Long.valueOf(paramString.longValue()) });
        return "" + paramString.longValue();
        paramString = "0";
      }
      return "0";
    }
    catch (Exception paramString)
    {
      QLog.d("ReadInJoyUtils", 1, new Object[] { "convertArticleID e = ", paramString.toString() });
    }
  }
  
  public static void g()
  {
    ThreadManagerV2.excute(new ReadInJoyUtils.25(), 64, null, true);
  }
  
  public static void g(QQAppInterface paramQQAppInterface)
  {
    
    if (paramQQAppInterface == null) {
      return;
    }
    long l1 = paramQQAppInterface.getLongAccountUin();
    long l2 = System.currentTimeMillis();
    jdField_g_of_type_JavaLangString = l1 + "_" + l2;
  }
  
  public static boolean g()
  {
    boolean bool = false;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(315);
    if (!bcoo.a()) {}
    for (;;)
    {
      QLog.d("ReadInJoyUtils", 1, "showStudyGradeEntry ! res= " + localAladdinConfig.toString());
      return bool;
      if (localAladdinConfig.getIntegerFromString("study_mode_select_grade_entry_enable", 0) == 1) {
        bool = true;
      }
    }
  }
  
  public static boolean g(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 18) {
      return false;
    }
    return true;
  }
  
  public static boolean g(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return false;
    }
    int m = pgb.a((ArticleInfo)paramBaseArticleInfo);
    if ((paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return false;
    }
    switch (m)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean g(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = bjnd.a(paramString);
      return (paramString != null) && ("1".equalsIgnoreCase((String)paramString.get("jump_android_hemera")));
    }
    return false;
  }
  
  public static int h()
  {
    return Aladdin.getConfig(196).getIntegerFromString("artical_interact_type", 0);
  }
  
  public static String h()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      ((JSONObject)localObject).put("session_id", jdField_f_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  private static String h(BaseArticleInfo paramBaseArticleInfo)
  {
    paramBaseArticleInfo = new ArrayList(((articlesummary.FriendRecommendInfo)paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
    if (paramBaseArticleInfo.size() == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int m = 0;
    while (m < paramBaseArticleInfo.size())
    {
      localStringBuilder.append(paramBaseArticleInfo.get(m));
      localStringBuilder.append(",");
      m += 1;
    }
    paramBaseArticleInfo = localStringBuilder.toString();
    return paramBaseArticleInfo.substring(0, paramBaseArticleInfo.length() - 1);
  }
  
  public static String h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paa.jdField_g_of_type_JavaLangString + bfuc.encodeToString(paramString.getBytes(), 2);
  }
  
  public static boolean h()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(uex.jdField_g_of_type_JavaLangString)) {}
    try
    {
      bool = new JSONObject(uex.jdField_g_of_type_JavaLangString).optBoolean("useNewLogic", false);
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean h(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep == null)) {}
    while ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong.longValue() != 17L) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong.longValue() != 16L)) {
      return false;
    }
    return true;
  }
  
  public static boolean h(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mPolymericInfo != null) && (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int >= 6);
  }
  
  public static boolean h(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = bjnd.a(paramString);
      return (paramString != null) && ("5".equalsIgnoreCase((String)paramString.get("target")));
    }
    return false;
  }
  
  public static int i()
  {
    return Aladdin.getConfig(199).getIntegerFromString("no_difference_jump_app_jump_src", 0);
  }
  
  public static String i()
  {
    Object localObject;
    if (jdField_h_of_type_Int >= 10) {
      localObject = "null";
    }
    String str;
    do
    {
      return localObject;
      str = bjms.a("d059d3", 5);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    jdField_h_of_type_Int += 1;
    return "null";
  }
  
  public static String i(String paramString)
  {
    Object localObject1 = Aladdin.getConfig(199);
    Object localObject2 = ((AladdinConfig)localObject1).getString("no_difference_jump_app_schema", "");
    String str1 = ((AladdinConfig)localObject1).getString("no_difference_jump_app_h5_android", "");
    String str2 = ((AladdinConfig)localObject1).getString("no_difference_jump_app_package_name", "");
    localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).replace("${rowkey}", paramString).replace("${uin}", a());
    }
    localObject2 = str1;
    if (!TextUtils.isEmpty(str1)) {
      localObject2 = str1.replace("${rowkey}", paramString).replace("${uin}", a());
    }
    paramString = new StringBuilder();
    try
    {
      paramString.append("mqqapi://readinjoy/open?src_type=internal&target=4").append("&defaultURL=").append(URLEncoder.encode((String)localObject2, "utf-8")).append("&appSchema=").append(URLEncoder.encode((String)localObject1, "utf-8")).append("&appPackageName=").append(str2).append("&readinjoyNotDecodeUrl=1").append("&version=1").append("&isCancelJump=0");
      QLog.e("ReadInJoyUtils", 1, "getNoDifferenceJumpToAppSchema schema: " + paramString.toString());
      bkwm.g();
      paramString = paramString.toString();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      QLog.e("ReadInJoyUtils", 1, "getNoDifferenceJumpToAppSchema UnsupportedEncodingException: " + paramString);
    }
    return "";
  }
  
  private static void i()
  {
    AppRuntime localAppRuntime = a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      if (!((QQAppInterface)localAppRuntime).mAutomator.b()) {
        ple.f();
      }
    }
    else {
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyUtils.2(), 500L);
  }
  
  public static boolean i()
  {
    boolean bool = false;
    if (bkwm.m(a()) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean i(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep == null)) {}
    while ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong.longValue() != 19L) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong.longValue() != 18L)) {
      return false;
    }
    return true;
  }
  
  public static boolean i(BaseArticleInfo paramBaseArticleInfo)
  {
    return (h(paramBaseArticleInfo)) && (paramBaseArticleInfo.mIsInPolymeric);
  }
  
  public static boolean i(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (h(paramString))
      {
        bool1 = bool2;
        if (paramString.contains("needsconcat=1")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static int j()
  {
    jdField_a_of_type_JavaLangInteger = null;
    return k();
  }
  
  public static String j()
  {
    Object localObject;
    if (jdField_i_of_type_Int >= 10) {
      localObject = "null";
    }
    String str;
    do
    {
      return localObject;
      str = bjms.b("d059d3", 5);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    jdField_i_of_type_Int += 1;
    return "null";
  }
  
  public static boolean j()
  {
    if (!jdField_b_of_type_Boolean)
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.KDCfg.name(), null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 2) {
          jdField_h_of_type_Boolean = localObject[1].equals("1");
        }
        jdField_b_of_type_Boolean = true;
      }
    }
    return jdField_h_of_type_Boolean;
  }
  
  public static boolean j(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 26) {
      return false;
    }
    return true;
  }
  
  public static boolean j(BaseArticleInfo paramBaseArticleInfo)
  {
    return (h(paramBaseArticleInfo)) && (paramBaseArticleInfo.mGroupSubArticleList != null);
  }
  
  public static int k()
  {
    if (jdField_a_of_type_JavaLangInteger == null)
    {
      jdField_a_of_type_JavaLangInteger = Integer.valueOf(Aladdin.getConfig(215).getIntegerFromString("message_reddot_style", 1));
      if ((!bkwm.i()) && (jdField_a_of_type_JavaLangInteger.intValue() == 0)) {
        jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
      }
      if ((jdField_a_of_type_JavaLangInteger.intValue() == 2) && (a() != null))
      {
        KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = ((KandianMergeManager)a().getManager(162)).a();
        if ((localKandianMsgBoxRedPntInfo == null) || (localKandianMsgBoxRedPntInfo.dataType == 1)) {
          break label145;
        }
        jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
      }
    }
    label145:
    for (int m = 2;; m = 1)
    {
      QLog.d("ReadInJoyUtils", 1, "init msgboxUIMode : " + jdField_a_of_type_JavaLangInteger + ", rule : " + m);
      return jdField_a_of_type_JavaLangInteger.intValue();
    }
  }
  
  public static String k()
  {
    if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString))
    {
      Object localObject2 = i();
      String str = j();
      if ((!((String)localObject2).equals("null")) && (!str.equals("null")))
      {
        jdField_b_of_type_JavaLangString = "0," + (String)localObject2 + "," + str;
        return jdField_b_of_type_JavaLangString;
      }
      Object localObject1 = localObject2;
      if (((String)localObject2).equals("null")) {
        localObject1 = "0";
      }
      localObject2 = str;
      if (str.equals("null")) {
        localObject2 = "0";
      }
      return "0," + (String)localObject1 + "," + (String)localObject2;
    }
    return jdField_b_of_type_JavaLangString;
  }
  
  public static boolean k()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public static boolean k(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn.jdField_a_of_type_Rcg == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn.jdField_c_of_type_JavaUtilList == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn.jdField_c_of_type_JavaUtilList.size() <= 0) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn.jdField_a_of_type_Rcg.jdField_b_of_type_Int != 1);
  }
  
  public static boolean k(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo;
      if ((paramBaseArticleInfo.l == 1) && (!TextUtils.isEmpty(paramBaseArticleInfo.jdField_f_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramBaseArticleInfo.jdField_g_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  public static int l()
  {
    return Aladdin.getConfig(264).getIntegerFromString("show_timing", 1);
  }
  
  public static String l()
  {
    JSONObject localJSONObject = new JSONObject();
    a(localJSONObject);
    return localJSONObject.toString();
  }
  
  public static boolean l()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - jdField_d_of_type_Long <= 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "click too fast");
      }
      jdField_d_of_type_Long = l1;
      return true;
    }
    jdField_d_of_type_Long = l1;
    return false;
  }
  
  public static boolean l(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn == null)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (paramArticleInfo.mFeedType != 21) {
          break;
        }
      } while (a(paramArticleInfo, false) == 74);
      return false;
      if ((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong.intValue() != 21)) {
        break;
      }
    } while (a(paramArticleInfo, true) == 75);
    return false;
    return false;
  }
  
  public static boolean l(BaseArticleInfo paramBaseArticleInfo)
  {
    return (h(paramBaseArticleInfo)) && ((paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 9) || (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 10) || (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11));
  }
  
  public static int m()
  {
    return Aladdin.getConfig(264).getIntegerFromString("open_type", 1);
  }
  
  public static String m()
  {
    if (jdField_g_of_type_JavaLangString == null) {
      return "0";
    }
    return jdField_g_of_type_JavaLangString;
  }
  
  public static boolean m()
  {
    return ozj.a();
  }
  
  public static boolean m(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn == null)) {
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
          if (paramArticleInfo.mFeedType != 22) {
            break;
          }
        } while (a(paramArticleInfo, false) == 72);
        return false;
        if ((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong.intValue() != 22)) {
          break;
        }
      } while (a(paramArticleInfo, true) == 73);
      return false;
    } while ((paramArticleInfo.mFeedType == 1) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_b_of_type_Int == 4));
    return false;
  }
  
  public static boolean m(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mNewPolymericInfo != null) {}
    for (int m = 1; (m != 0) && ((paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 9) || (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 10) || (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 11)); m = 0) {
      return true;
    }
    return false;
  }
  
  public static int n()
  {
    int m = 0;
    if (bcoo.a()) {
      m = 1;
    }
    while (!z()) {
      return m;
    }
    return 2;
  }
  
  public static String n()
  {
    uir.a();
    StringBuilder localStringBuilder = new StringBuilder("{");
    a(localStringBuilder, "probesize", Long.valueOf(bkwm.b()));
    localStringBuilder.append(",");
    a(localStringBuilder, "isFFProbelistSwitch", Boolean.valueOf(bkwm.r()));
    localStringBuilder.append(",");
    a(localStringBuilder, "isDownloadAsyncIo", Boolean.valueOf(bkwm.s()));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static boolean n()
  {
    return (((Boolean)bkwm.a("preload_controller", Boolean.valueOf(true))).booleanValue()) && (bkwm.k());
  }
  
  public static boolean n(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn == null)) {}
    while (paramArticleInfo.mFeedType != 21) {
      return false;
    }
    return true;
  }
  
  public static boolean n(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 15);
  }
  
  public static boolean o()
  {
    return Aladdin.getConfig(154).getIntegerFromString("need_show_social_bottom_view", 1) == 1;
  }
  
  public static boolean o(ArticleInfo paramArticleInfo)
  {
    return (p(paramArticleInfo)) || (q(paramArticleInfo));
  }
  
  public static boolean o(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 12);
  }
  
  public static boolean p()
  {
    return Aladdin.getConfig(176).getIntegerFromString("artical_interact_area", 0) == 1;
  }
  
  public static boolean p(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong == null)) {}
    while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong.intValue() != 21) {
      return false;
    }
    return true;
  }
  
  public static boolean p(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 13);
  }
  
  public static boolean q()
  {
    return Aladdin.getConfig(176).getIntegerFromString("ad_relative_pos", 0) == 1;
  }
  
  public static boolean q(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong == null)) {}
    while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_b_of_type_JavaLangLong.intValue() != 22) {
      return false;
    }
    return true;
  }
  
  public static boolean q(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mKdLiveInfo != null) && (paramBaseArticleInfo.mSubArtilceList != null) && (paramBaseArticleInfo.mSubArtilceList.size() > 0) && (paramBaseArticleInfo.mSubArtilceList.get(0) != null) && (((ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0)).mKdLiveInfo != null);
  }
  
  public static boolean r()
  {
    return Aladdin.getConfig(190).getIntegerFromString("readinjoy_feeds_overdraw_optimize_switch", 1) == 1;
  }
  
  public static boolean r(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("ReadInJoyUtils", 1, "commentBiuCanJump, canJump= " + bool1);
      return bool1;
      bool1 = bool2;
      if (paramArticleInfo.mFeedType == 36)
      {
        bool1 = bool2;
        if (paramArticleInfo.isCardJumpUrlAvailable == 1)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramArticleInfo.getCardJumpUrl())) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public static boolean r(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 24) && (paramBaseArticleInfo.mNewPolymericInfo != null);
  }
  
  public static boolean s()
  {
    return Aladdin.getConfig(253).getIntegerFromString("enable_use_exposure_data", 0) == 1;
  }
  
  public static boolean s(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("ReadInJoyUtils", 1, "canOpenNativeArticle,articleInfo=" + paramArticleInfo);
      return bool1;
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramArticleInfo.mArticleContentUrl)) {
          bool1 = true;
        }
      }
    }
  }
  
  public static boolean s(BaseArticleInfo paramBaseArticleInfo)
  {
    return paramBaseArticleInfo.mNewPolymericInfo != null;
  }
  
  public static boolean t()
  {
    return Aladdin.getConfig(255).getIntegerFromString("allow_yaobu_icon_click_report", 0) == 1;
  }
  
  public static boolean t(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mFeedType == 29);
  }
  
  public static boolean u()
  {
    return Aladdin.getConfig(245).getIntegerFromString("kandian_feeds_card_style", 0) == 1;
  }
  
  public static boolean u(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 20) && (paramBaseArticleInfo.mRecommendFollowInfos != null);
  }
  
  public static boolean v()
  {
    return (w()) && (!x());
  }
  
  public static boolean v(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBaseArticleInfo.mNewPolymericInfo != null) {
      if ((paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int != 7) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int != 8))
      {
        bool1 = bool2;
        if (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int != 9) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean w()
  {
    return l() == 2;
  }
  
  public static boolean w(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && ((paramBaseArticleInfo instanceof ArticleInfo)) && (!pgb.q((ArticleInfo)paramBaseArticleInfo)) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Int == 6);
  }
  
  public static boolean x()
  {
    return (ReadinjoyTabFrame.d_()) || (ReadInJoyDailyFragment.a()) || (ReadInJoyNewFeedsActivity.a());
  }
  
  public static boolean x(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool = false;
    switch (paramBaseArticleInfo.mFeedType)
    {
    default: 
      bool = a(paramBaseArticleInfo);
    }
    do
    {
      return bool;
    } while (paramBaseArticleInfo.mProteusTemplateBean == null);
    return b(qgc.a(paramBaseArticleInfo.mProteusTemplateBean));
  }
  
  public static boolean y()
  {
    return Aladdin.getConfig(276).getIntegerFromString("supportPreloadWebProcess", 1) == 1;
  }
  
  public static boolean y(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramBaseArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("ReadInJoyUtils", 1, "isImageArticle, flag= " + bool1);
      return bool1;
      bool1 = bool2;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramBaseArticleInfo.mFeedType == 36)
        {
          bool1 = bool2;
          if (!paramBaseArticleInfo.isPGCShortContent())
          {
            bool1 = bool2;
            if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 4)
            {
              bool1 = bool2;
              if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 5)
              {
                bool1 = bool2;
                if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 6)
                {
                  QLog.d("ReadInJoyUtils", 1, "isImageArticle, style= " + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int);
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean z()
  {
    return ((Integer)bkwm.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue() == 1;
  }
  
  public static boolean z(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramBaseArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("ReadInJoyUtils", 1, "isStructCard, flag= " + bool1);
      return bool1;
      if (paramBaseArticleInfo.isPGCShortContent())
      {
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if ((paramBaseArticleInfo instanceof ArticleInfo))
        {
          bool1 = bool2;
          if (pgb.i((ArticleInfo)paramBaseArticleInfo)) {
            bool1 = true;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pay
 * JD-Core Version:    0.7.0.1
 */