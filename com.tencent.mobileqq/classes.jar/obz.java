import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.gson.JsonArray;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoySSOHandlerThread;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.1;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.10;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.14;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.17;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.18;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.2;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.20;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.21;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.22;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.23;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.3;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.4;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.5;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.6;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.7;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.8;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.9;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.SPEventReportSwitch;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
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
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
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
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.util.NetworkState;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspTraceRecord;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class obz
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
  public static HashMap<Integer, nhw> a;
  private static Map<String, MessageForStructing> jdField_a_of_type_JavaUtilMap;
  private static Queue<Integer> jdField_a_of_type_JavaUtilQueue;
  public static final ppp a;
  public static volatile boolean a;
  public static int b;
  public static long b;
  private static Handler b;
  public static String b;
  public static boolean b;
  public static int c;
  private static long c;
  public static String c;
  public static volatile boolean c;
  public static int d;
  private static long d;
  public static String d;
  public static boolean d;
  public static int e;
  private static long jdField_e_of_type_Long;
  private static String jdField_e_of_type_JavaLangString;
  public static boolean e;
  public static int f;
  private static String jdField_f_of_type_JavaLangString;
  private static boolean jdField_f_of_type_Boolean;
  public static int g;
  private static String jdField_g_of_type_JavaLangString;
  private static volatile boolean jdField_g_of_type_Boolean;
  private static int jdField_h_of_type_Int;
  private static String jdField_h_of_type_JavaLangString;
  private static volatile boolean jdField_h_of_type_Boolean;
  private static int jdField_i_of_type_Int;
  private static String jdField_i_of_type_JavaLangString;
  private static boolean jdField_i_of_type_Boolean;
  private static int jdField_j_of_type_Int;
  private static volatile boolean jdField_j_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    jdField_b_of_type_JavaLangString = "0";
    jdField_c_of_type_JavaLangString = "1";
    jdField_d_of_type_JavaLangString = "2";
    jdField_a_of_type_Int = 7;
    jdField_c_of_type_Int = -2;
    jdField_h_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_c_of_type_Long = 300000L;
    jdField_e_of_type_Int = -1;
    jdField_e_of_type_JavaLangString = "";
    jdField_a_of_type_Ppp = new ppp();
    jdField_a_of_type_JavaUtilQueue = new LinkedBlockingQueue(100);
    jdField_f_of_type_Int = -1;
    jdField_j_of_type_Int = 1;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_g_of_type_JavaLangString = "";
    jdField_h_of_type_JavaLangString = "";
    jdField_g_of_type_Int = 0;
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
      int k = 0;
      while (k < localException.size())
      {
        localObject1 = (RecentBaseData)localException.get(k);
        if (localObject1 != null)
        {
          boolean bool = TextUtils.equals(((RecentUserBaseData)localObject1).a(), ajed.az);
          if (bool) {
            return k;
          }
        }
        k += 1;
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
    int m = badq.a(paramContext);
    int k;
    if (m >= 1)
    {
      k = m;
      if (m <= 4) {}
    }
    else
    {
      k = 5;
    }
    return k;
  }
  
  public static int a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return 0;
    }
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri != null))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri.jdField_a_of_type_Boolean) {
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
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri == null) || ((!paramBoolean) && (paramArticleInfo.mFeedType != 21) && (paramArticleInfo.mFeedType != 22)) || ((paramBoolean) && (!n(paramArticleInfo)))) {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyUtils", 1, "something is null.");
      }
    }
    do
    {
      return 7;
      if ((paramBoolean) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_Int == 3)) {
        return 75;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_Int == 3) {
        return 74;
      }
      if ((paramBoolean) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_Int == 4)) {
        return 73;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_Int == 4) {
        return 72;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ReadInJoyUtils", 1, "error ugcFeedsSrc = " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_Int);
    return 7;
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    int k = 10;
    int n = qoe.c((ArticleInfo)paramBaseArticleInfo);
    label554:
    int m;
    switch (n)
    {
    case 13: 
    case 70: 
    case 76: 
    case 77: 
    case 78: 
    case 79: 
    case 94: 
    case 95: 
    case 97: 
    case 98: 
    case 99: 
    case 100: 
    case 119: 
    case 121: 
    case 122: 
    case 126: 
    case 127: 
    default: 
      k = 0;
    case 10: 
    case 12: 
    case 44: 
      m = k;
      if (pmu.a((ArticleInfo)paramBaseArticleInfo) == 3) {
        m = k;
      }
      switch (n)
      {
      default: 
        m = k;
      case 5: 
      case 6: 
        label622:
        if (s(paramBaseArticleInfo)) {
          if (m(paramBaseArticleInfo))
          {
            m = 67;
            label639:
            if (paramBaseArticleInfo.isTwoItem) {
              m = 43;
            }
            if (ppc.b(paramBaseArticleInfo)) {
              m = 69;
            }
            switch (paramBaseArticleInfo.mFeedType)
            {
            }
          }
        }
        break;
      }
      break;
    }
    do
    {
      return m;
      if ((paramBaseArticleInfo instanceof AdvertisementInfo))
      {
        k = 55;
        break label554;
      }
      k = 1;
      break label554;
      if ((paramBaseArticleInfo instanceof AdvertisementInfo))
      {
        k = 57;
        break label554;
      }
      k = 2;
      break label554;
      if ((paramBaseArticleInfo instanceof AdvertisementInfo))
      {
        k = 58;
        break label554;
      }
      k = 3;
      break label554;
      k = 4;
      break label554;
      if ((paramBaseArticleInfo instanceof AdvertisementInfo))
      {
        k = 56;
        break label554;
      }
      k = 5;
      break label554;
      if ((paramBaseArticleInfo instanceof AdvertisementInfo))
      {
        k = 59;
        break label554;
      }
      k = 6;
      break label554;
      k = 7;
      break label554;
      k = 8;
      break label554;
      k = 9;
      break label554;
      k = 11;
      break label554;
      k = 19;
      break label554;
      k = 20;
      break label554;
      k = 18;
      break label554;
      k = 101;
      break label554;
      k = 22;
      break label554;
      k = 21;
      break label554;
      k = 2005;
      break label554;
      k = 23;
      break label554;
      k = 30;
      break label554;
      k = 29;
      break label554;
      if (och.a(paramBaseArticleInfo) == 32)
      {
        k = 2006;
        break label554;
      }
      k = 31;
      break label554;
      k = 24;
      break label554;
      k = 26;
      break label554;
      k = 32;
      break label554;
      k = 33;
      break label554;
      k = 34;
      break label554;
      k = 25;
      break label554;
      k = 27;
      break label554;
      k = 28;
      break label554;
      k = 28;
      break label554;
      k = 28;
      break label554;
      k = 35;
      break label554;
      k = 36;
      break label554;
      k = 37;
      break label554;
      k = 38;
      break label554;
      k = 39;
      break label554;
      k = 40;
      break label554;
      if (b((ArticleInfo)paramBaseArticleInfo))
      {
        k = 41;
        break label554;
      }
      k = 42;
      break label554;
      k = 19;
      break label554;
      k = 37;
      break label554;
      k = 43;
      break label554;
      if (e((ArticleInfo)paramBaseArticleInfo))
      {
        k = 45;
        break label554;
      }
      k = 46;
      break label554;
      k = 29;
      break label554;
      k = 30;
      break label554;
      k = 31;
      break label554;
      k = 47;
      break label554;
      if (((paramBaseArticleInfo instanceof ArticleInfo)) && (!TextUtils.isEmpty(((ArticleInfo)paramBaseArticleInfo).mArticleSubscriptText)))
      {
        k = 79;
        break label554;
      }
      k = 48;
      break label554;
      k = 1005;
      break label554;
      k = 1006;
      break label554;
      k = 1007;
      break label554;
      if (((paramBaseArticleInfo instanceof ArticleInfo)) && (!TextUtils.isEmpty(((ArticleInfo)paramBaseArticleInfo).mArticleSubscriptText)))
      {
        k = 78;
        break label554;
      }
      k = 49;
      break label554;
      k = 80;
      break label554;
      k = 50;
      break label554;
      k = 51;
      break label554;
      k = 52;
      break label554;
      k = 53;
      break label554;
      k = 54;
      break label554;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri.jdField_a_of_type_Boolean)
      {
        k = 62;
        break label554;
      }
      k = 61;
      break label554;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri.jdField_a_of_type_Boolean)
      {
        k = 64;
        break label554;
      }
      k = 63;
      break label554;
      k = 65;
      break label554;
      k = 66;
      break label554;
      k = 70;
      break label554;
      k = 73;
      break label554;
      k = 74;
      break label554;
      k = 72;
      break label554;
      k = 71;
      break label554;
      if ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqr == null)) {
        break;
      }
      k = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqr.jdField_a_of_type_Int;
      break label554;
      k = 75;
      break label554;
      k = 77;
      break label554;
      k = 999;
      break label554;
      k = 998;
      break label554;
      k = 1023;
      break label554;
      k = 1024;
      break label554;
      k = 1025;
      break label554;
      k = 1028;
      break label554;
      k = 1032;
      break label554;
      k = 1033;
      break label554;
      k = 1034;
      break label554;
      k = 1035;
      break label554;
      k = 2004;
      break label554;
      m = 12;
      break label622;
      m = 13;
      break label622;
      m = 14;
      break label622;
      m = 15;
      break label622;
      m = 16;
      break label622;
      m = 17;
      break label622;
      if (p(paramBaseArticleInfo))
      {
        m = 82;
        break label639;
      }
      if (o(paramBaseArticleInfo))
      {
        m = 83;
        break label639;
      }
      m = 68;
      break label639;
      if (l(paramBaseArticleInfo))
      {
        m = 54;
        break label639;
      }
      if (!i(paramBaseArticleInfo)) {
        break label639;
      }
      m = 47;
      break label639;
      return 1031;
    } while (paramBaseArticleInfo.mProteusTemplateBean == null);
    return oxy.a(paramBaseArticleInfo.mProteusTemplateBean);
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
    if ((qoe.a(paramArticleInfo)) || (paramInt == 77) || (paramInt == 78))
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
                  if ((!qoe.a(paramArticleInfo)) && (paramInt != 72) && (paramInt != 74)) {
                    break;
                  }
                  l1 = l2;
                } while (paramArticleInfo.mSocialFeedInfo == null);
                l1 = l2;
              } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null);
              return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Long;
              if (paramInt != 76) {
                break;
              }
              l1 = l2;
            } while (paramArticleInfo.mSocialFeedInfo == null);
            l1 = l2;
          } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo == null);
          return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
          if ((qoe.f(paramArticleInfo)) || (paramInt == 73)) {
            break;
          }
          l1 = l2;
        } while (paramInt != 75);
        l1 = l2;
      } while (paramArticleInfo.mSocialFeedInfo == null);
      l1 = l2;
    } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo == null);
    return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    int i4 = 0;
    long l1 = NetConnInfoCenter.getServerTime();
    int k = jdField_a_of_type_Int;
    int m = k - 2;
    if ((paramQQAppInterface == null) || (k <= 0))
    {
      QLog.d("ReadInJoyUtils", 1, "break insert individual push time:" + l1);
      return l1;
    }
    Object localObject1 = new ArrayList();
    Object localObject2;
    int i3;
    int i1;
    try
    {
      localObject2 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject2 != null) {
        break label198;
      }
      QLog.d("ReadInJoyUtils", 1, "conversation frame is null");
      return l1;
    }
    catch (Exception paramQQAppInterface)
    {
      i3 = 0;
      i1 = k;
    }
    label104:
    QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + paramQQAppInterface.toString());
    int n = i1;
    k = i3;
    label140:
    if (k != 0)
    {
      k = 0;
      label146:
      i1 = i4;
      if (k >= n) {}
    }
    for (;;)
    {
      long l2;
      try
      {
        paramQQAppInterface = (RecentBaseData)((List)localObject1).get(k);
        if (paramQQAppInterface != null)
        {
          l2 = ((RecentUserBaseData)paramQQAppInterface).mUser.showUpTime;
          if (l2 <= 0L) {}
        }
        else
        {
          k += 1;
          break label146;
          label198:
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
            if ((((RecentUserBaseData)localObject3).mUser == null) || (((RecentUserBaseData)localObject3).mUser.getType() != 1008) || (!rol.b(paramQQAppInterface, ((RecentUserBaseData)localObject3).mUser.uin))) {
              continue;
            }
            ((Iterator)localObject2).remove();
            continue;
          }
          n = ((List)localObject1).size();
          i1 = k;
          if (k > n) {
            i1 = n;
          }
          i2 = 0;
          k = 0;
          if (i2 < i1) {
            i3 = k;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        int i2;
        boolean bool;
        QLog.d("ReadInJoyUtils", 1, "failed to construct individual push time " + paramQQAppInterface.toString());
      }
      try
      {
        paramQQAppInterface = (RecentBaseData)((List)localObject1).get(i2);
        i3 = k;
        if (paramQQAppInterface == null) {
          break label741;
        }
        i3 = k;
        paramQQAppInterface = (RecentUserBaseData)paramQQAppInterface;
        n = k;
        i3 = k;
        if (paramQQAppInterface.mUnreadNum > 0) {
          n = 1;
        }
        i3 = n;
        bool = TextUtils.equals(paramQQAppInterface.a(), ajed.az);
        i3 = n;
        if (!bool) {
          break label741;
        }
        k = i2;
        m = n;
        i2 += 1;
        n = m;
        m = k;
        k = n;
      }
      catch (Exception paramQQAppInterface) {}
      n = i1;
      break label140;
      i1 = k;
      if (i1 >= m)
      {
        QLog.d("ReadInJoyUtils", 1, "insert individual push time:" + l1);
        return l1;
      }
      for (;;)
      {
        QLog.d("ReadInJoyUtils", 1, "insert individual push time:" + l1);
        return l1;
        k = (int)(Math.random() * (m - i1)) + 1 + i1;
        paramQQAppInterface = (RecentUserBaseData)((List)localObject1).get(k - 1);
        localObject1 = (RecentUserBaseData)((List)localObject1).get(k);
        l2 = Math.max(paramQQAppInterface.mUser.lastmsgtime, paramQQAppInterface.mUser.lastmsgdrafttime);
        long l3 = Math.max(((RecentUserBaseData)localObject1).mUser.lastmsgtime, ((RecentUserBaseData)localObject1).mUser.lastmsgdrafttime);
        double d1 = Math.random();
        l1 = l2 - ((l2 - l3) * d1) - 1L;
        continue;
        QLog.d("ReadInJoyUtils", 1, "construct individual push first " + n + " msg no red point");
      }
      break label104;
      label741:
      k = m;
      m = i3;
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
    localIntent.putExtra("banner_wording", String.format(ajjy.a(2131647335), new Object[] { paramArticleInfo.mTitle }));
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
  
  public static Intent a(Intent paramIntent, ArticleInfo paramArticleInfo, int paramInt1, String paramString, long paramLong, int paramInt2, int paramInt3)
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
    if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm == null) {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm = new pqm();
    }
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramArticleInfo = new SocializeFeedsInfo.BiuCommentInfo();
    paramArticleInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString))) {
      paramArticleInfo.jdField_b_of_type_JavaLangString = (": " + paramString);
    }
    paramArticleInfo.jdField_b_of_type_Int = localArticleInfo.mFeedType;
    paramArticleInfo.jdField_c_of_type_Int = paramInt2;
    paramArticleInfo.jdField_b_of_type_JavaLangLong = Long.valueOf(localArticleInfo.mFeedId);
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList.add(paramArticleInfo);
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
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 == null) {}
    do
    {
      return paramDrawable;
      localObject1 = ((QQMessageFacade)localObject1).b(ajed.az, 7220);
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
          paramQQAppInterface = paramQQAppInterface.a(1, "kd_" + (String)localObject1, (byte)3, 0, 100, true);
          localObject2 = (rcn)babe.a(paramQQAppInterface);
          if (localObject2 != null)
          {
            QLog.d("ReadInJoyUtils", 2, "getMergeIcon From cache ! key : " + paramQQAppInterface + ", tipUin : " + (String)localObject1);
            return localObject2;
          }
          localObject2 = bacm.a(paramDrawable);
          if (localObject2 == null) {
            break;
          }
          localObject1 = new rcn((Bitmap)localObject2, aciy.a(50.0F, localResources), localResources, (String)localObject1, 1);
          babe.a(paramQQAppInterface, (Sizeable)localObject1);
          return localObject1;
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        paramQQAppInterface = bacm.a(paramDrawable);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface = new rcn(paramQQAppInterface, (String)localObject2, aciy.a(50.0F, localResources), localResources, 1);
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
  
  private static JsonArray a(long paramLong)
  {
    Object localObject = pcj.a(paramLong);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      JsonArray localJsonArray = new JsonArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
        if ((localArticleInfo != null) && (localArticleInfo.mProteusTemplateBean.getData() != null)) {
          localJsonArray.add(localArticleInfo.mProteusTemplateBean.getData().optString("rowkey"));
        }
      }
      return localJsonArray;
    }
    return null;
  }
  
  public static ArticleInfo a(String paramString)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    Object localObject5;
    long l1;
    Object localObject6;
    Object localObject2;
    int k;
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
          paramString = new String(baaw.decode((String)localObject3, 0));
        }
        catch (Exception localException3)
        {
          Object localObject4;
          paramString = (String)localObject1;
          l6 = l7;
          localObject1 = localObject4;
          break;
          if (m == 4) {
            continue;
          }
          if (m != 5) {
            continue;
          }
          continue;
        }
        try
        {
          localObject3 = new String(baaw.decode((String)localObject1, 0));
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
        k = ((JSONObject)localObject5).optInt("duration");
        ((JSONObject)localObject5).optString("callback");
        localObject3 = new String(baaw.decode(((JSONObject)localObject5).optString("accountDesc"), 0));
        m = ((JSONObject)localObject5).optInt("feedsType", 1);
        localArticleInfo.mArticleID = l9;
        localArticleInfo.mTitle = ((String)localObject1);
        localArticleInfo.mSubscribeName = ((String)localObject2);
        localArticleInfo.mFirstPagePicUrl = paramString;
        localArticleInfo.mVideoDuration = k;
        localArticleInfo.mFeedId = l10;
        localArticleInfo.mFeedType = m;
        localArticleInfo.mSummary = ((String)localObject3);
        localArticleInfo.businessId = l7;
        paramString = ((JSONObject)localObject5).getJSONArray("biuLevelList");
        localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm = new pqm();
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaLangLong = Long.valueOf(l8);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong = Long.valueOf(l1);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList = new ArrayList();
        if (paramString == null) {
          break label912;
        }
        k = 0;
        if (k >= paramString.length()) {
          break label912;
        }
        localObject2 = new SocializeFeedsInfo.BiuCommentInfo();
        localObject3 = paramString.getJSONObject(k);
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
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangString = new String(baaw.decode(((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangString, 0));
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_a_of_type_JavaLangString = ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangString;
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
        continue;
      }
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList.add(localObject2);
      k += 1;
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
    if ((paramString != null) && ((m == 4) || (m == 5) || ((m == 1) && ((l1 == 4L) || (l1 == 5L)))))
    {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre = new pre();
      m = paramString.optInt("ugcType", 0);
      localObject2 = paramString.optString("ugcComment");
      localObject4 = paramString.optJSONArray("ugcAtLevelList");
      if (localObject4 != null)
      {
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Pqm = new pqm();
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList = new ArrayList();
        k = 0;
        for (;;)
        {
          if (k >= ((JSONArray)localObject4).length()) {
            break label1247;
          }
          localObject5 = new SocializeFeedsInfo.BiuCommentInfo();
          localObject6 = ((JSONArray)localObject4).getJSONObject(k);
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
            ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString = new String(baaw.decode(((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString, 0));
            ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_JavaLangString = ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString;
          }
          catch (Exception localException5)
          {
            for (;;)
            {
              localException5.printStackTrace();
            }
          }
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList.add(localObject5);
          k += 1;
        }
      }
      label1247:
      localArticleInfo.mTitle = new String(baaw.decode((String)localObject2, 0));
      localArticleInfo.mSummary = "";
      if ((m != 3) && (m != 2)) {
        break label1582;
      }
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = new prf();
      paramString = paramString.optJSONArray("ugcPicInfo");
      if ((paramString != null) && (paramString.length() > 0))
      {
        ((prf)localObject1).jdField_c_of_type_JavaLangString = paramString.getJSONObject(0).optString("ugcPicUrl");
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      }
    }
    for (;;)
    {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Int = m;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_JavaLangString = localArticleInfo.mTitle;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString = "";
      localArticleInfo.mSocialFeedInfo.jdField_c_of_type_JavaLangString = "";
      localArticleInfo.mSocialFeedInfo.jdField_b_of_type_JavaLangString = "";
      return localArticleInfo;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      localObject2 = new prg();
      paramString = paramString.optJSONObject("ugcVideoInfo");
      if (paramString != null)
      {
        ((prg)localObject2).jdField_d_of_type_JavaLangString = paramString.optString("ugcVideoCoverUrl");
        ((prg)localObject2).jdField_a_of_type_Long = paramString.optInt("ugcVideoDuration");
        ((prg)localObject2).jdField_e_of_type_JavaLangString = ((String)localObject1);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
        continue;
        if (m == 1) {
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
    long l = System.currentTimeMillis();
    if (l - jdField_d_of_type_Long > jdField_c_of_type_Long)
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = akfu.a("readinjoy_anti_cheating");
      jdField_d_of_type_Long = l;
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
        paramAppRuntime = bgmq.a(paramAppRuntime, true, paramBoolean);
        if (paramAppRuntime != null)
        {
          paramAppRuntime = paramAppRuntime.getString(paramString, "");
          if (!TextUtils.isEmpty(paramAppRuntime))
          {
            paramAppRuntime = new ObjectInputStream(new ByteArrayInputStream(bakz.a(paramAppRuntime)));
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
      ((JSONObject)localObject).put("session_id", jdField_e_of_type_JavaLangString);
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
    int k;
    if (e() == 6)
    {
      bool = true;
      str = jdField_c_of_type_JavaLangString;
      if (paramLong != 1004L) {
        break label93;
      }
      if (!bool) {
        break label79;
      }
      k = bgmq.b(BaseApplicationImpl.getApplication().getRuntime(), 0);
      label38:
      if (k != 0) {
        break label123;
      }
      str = jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject = bgmq.a(a(), true, false);
      if (localObject != null) {
        break label149;
      }
      QLog.d("ReadInJoyUtils", 1, "getVideoAutoPlaySetting failed to get sp");
      return str;
      bool = false;
      break;
      label79:
      k = bgmq.a(BaseApplicationImpl.getApplication().getRuntime(), 0);
      break label38;
      label93:
      if (bool)
      {
        k = bgmq.c(BaseApplicationImpl.getApplication().getRuntime());
        break label38;
      }
      k = bgmq.b(BaseApplicationImpl.getApplication().getRuntime());
      break label38;
      label123:
      if (k == 1) {
        str = jdField_c_of_type_JavaLangString;
      } else if (k == 2) {
        str = jdField_b_of_type_JavaLangString;
      }
    }
    label149:
    if (bool) {}
    for (Object localObject = ((SharedPreferences)localObject).getString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_VIDEO_FLOW_SETTING", str);; localObject = ((SharedPreferences)localObject).getString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_SETTING", str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "getVideoAutoPlaySetting(),isVideoFlowEnter = " + bool + ", autoSetting = " + (String)localObject + ",localSettingDefaultValue=" + str + ", remoteSettingDefaultValue=" + k + " channelFrom:" + paramLong);
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
      ((JSONObject)localObject).put("session_id", jdField_e_of_type_JavaLangString);
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
        paramString3.put("kandian_mode_new", new.a());
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
        paramString3.put("proteus_bid", bgmq.a("default_feeds_proteus_offline_bid"));
        paramString3.put("ads_jump", paramInt9);
        paramString3.put("ads_source", paramInt10);
        paramString3.put("star_logo", b(paramArticleInfo));
        if (bati.a() == 1)
        {
          paramString1 = "1";
          paramString3.put("simCardType", paramString1);
          if ((odm.c(paramInt2)) && (paramArticleInfo != null))
          {
            paramLong1 = ((Long)bgmq.a("readinjoy_daily_article_first_exposure_" + paramArticleInfo.mArticleID, Long.valueOf(0L))).longValue();
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
              break label631;
            }
            if (paramArticleInfo.mVideoCommentCount <= 100) {
              break label608;
            }
            break label631;
            paramString3.put("comment_exposure", paramInt1);
          }
          if (paramArticleInfo != null)
          {
            if ((opa.a() == -1) || (opa.a() == 0)) {
              break label613;
            }
            paramString3.put("mainfeeds_showcase", opa.a());
            paramString3.put("configchannel_name", opa.a());
          }
          if ((paramArticleInfo != null) && (pol.a(paramArticleInfo))) {
            paramString3.put("jump_src", pol.a(paramArticleInfo));
          }
          paramString1 = paramString3.toString();
          paramString2 = paramString1;
          if (paramArticleInfo != null) {
            paramString2 = paramString1;
          }
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
        if (paramArticleInfo.mChannelID == 56L) {
          paramString2 = new qmv(paramString1).c(paramArticleInfo).d(paramArticleInfo).a(paramArticleInfo.videoReportInfo).a(paramArticleInfo, true).a().a();
        }
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
      label608:
      paramInt1 = 2;
      continue;
      label613:
      paramString3.put("mainfeeds_showcase", 0);
      continue;
      label631:
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
      paramString2.put("proteus_bid", bgmq.a("default_feeds_proteus_offline_bid"));
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
    f(paramContext);
    return jdField_g_of_type_JavaLangString;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    int k = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
      if (badq.h(paramContext)) {
        k = 0;
      }
      for (;;)
      {
        localJSONObject.put("network", k);
        localJSONObject.put("version", paramString1);
        localJSONObject.put("os", 1);
        localJSONObject.put("uin", paramString2);
        return localJSONObject.toString();
        boolean bool = badq.c(paramContext);
        if (!bool) {
          k = 2;
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
    qmv localqmv = new qmv(null, null, null, null);
    localqmv.T(ReadinjoyTabFrame.jdField_a_of_type_Int).U(paramInt);
    if (paramVideoInfo != null) {
      if (paramVideoInfo.jdField_h_of_type_Boolean) {
        if (paramVideoInfo.jdField_g_of_type_Boolean)
        {
          paramInt = 3;
          localqmv.a("status", Integer.valueOf(paramInt)).h(paramVideoInfo.jdField_g_of_type_JavaLangString).e(paramVideoInfo.jdField_f_of_type_Long).e(paramVideoInfo.jdField_a_of_type_JavaLangString).V(0).a(0);
        }
      }
    }
    for (;;)
    {
      return localqmv.a().a();
      paramInt = 2;
      break;
      paramInt = 4;
      break;
      localqmv.a("status", Integer.valueOf(1));
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo)
  {
    return a(paramArticleInfo, false);
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
      str = rjb.b(paramBaseArticleInfo);
      if (!rjb.b(paramBaseArticleInfo)) {
        break;
      }
      paramBaseArticleInfo = str;
    } while (!TextUtils.isEmpty(str));
    return null;
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    String str;
    if (f(paramString)) {
      str = b(paramString, paramBaseArticleInfo);
    }
    do
    {
      return str;
      str = paramString;
    } while (!g(paramString));
    return c(paramString, paramBaseArticleInfo);
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return jdField_a_of_type_Ppp.jdField_b_of_type_JavaLangString;
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
  
  public static String a(String paramString, int paramInt)
  {
    String str = paramString;
    int k;
    if (!TextUtils.isEmpty(paramString))
    {
      k = 0;
      m = 0;
      if (k >= paramString.length()) {
        break label144;
      }
      int n = paramString.charAt(k);
      if (((97 > n) || (n > 122)) && ((65 > n) || (n > 90)) && ((48 > n) || (n > 57))) {
        break label130;
      }
      m += 1;
      label75:
      if (m <= paramInt) {
        break label137;
      }
    }
    label130:
    label137:
    label144:
    for (int m = 1;; m = 0)
    {
      str = paramString;
      if (m != 0)
      {
        m = k;
        if (k == paramInt) {
          m = k - 1;
        }
        str = paramString.substring(0, m) + "…";
      }
      return str;
      m += 2;
      break label75;
      k += 1;
      break;
    }
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (!bgmq.b(a())) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "smart crop switch is false ! url : " + paramString);
      }
    }
    String[] arrayOfString2;
    String[] arrayOfString1;
    do
    {
      do
      {
        do
        {
          return paramString;
        } while ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http://qqpublic.qpic.cn")));
        arrayOfString2 = paramString.split("/");
      } while (arrayOfString2.length < 2);
      arrayOfString1 = arrayOfString2[(arrayOfString2.length - 2)].split("_");
    } while (arrayOfString1.length < 1);
    String str = arrayOfString1[(arrayOfString1.length - 1)];
    Object localObject;
    label125:
    double d2;
    double d1;
    int k;
    label149:
    double d3;
    double d4;
    if ("open".equals(str))
    {
      localObject = obb.a;
      int m = localObject.length;
      d2 = 1.0D * paramInt2 / paramInt1;
      d1 = 1.7976931348623157E+308D;
      arrayOfString1 = null;
      k = 0;
      if (k >= m) {
        break label370;
      }
      d3 = 1.0D * ((Integer)localObject[k].second).intValue() / ((Integer)localObject[k].first).intValue();
      d4 = Math.abs(d3 - d2);
      if (d4 >= d1) {
        break label252;
      }
      d1 = Math.abs(d3 - d2);
      arrayOfString1 = localObject[k];
    }
    label370:
    for (;;)
    {
      k += 1;
      break label149;
      if (!"vsmcut".equals(str)) {
        break;
      }
      localObject = obb.b;
      break label125;
      label252:
      if ((d4 == d1) && (arrayOfString1 != null))
      {
        int n = Math.abs(((Integer)arrayOfString1.second).intValue() - paramInt2);
        int i1 = Math.abs(((Integer)arrayOfString1.first).intValue() - paramInt1);
        int i2 = Math.abs(((Integer)localObject[k].second).intValue() - paramInt2);
        if (n + i1 > Math.abs(((Integer)localObject[k].first).intValue() - paramInt1) + i2)
        {
          d1 = Math.abs(d3 - d2);
          arrayOfString1 = localObject[k];
          continue;
          if (arrayOfString1 == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "the picture size : w : " + paramInt1 + " h : " + paramInt2 + ", select scale : " + arrayOfString1.first + ":" + arrayOfString1.second + " bias : " + d1);
          }
          localObject = arrayOfString2[(arrayOfString2.length - 1)];
          return paramString.replace(String.format("_%s/%s", new Object[] { str, localObject }), String.format("_%s_%d_%d/%s", new Object[] { str, arrayOfString1.first, arrayOfString1.second, localObject }));
        }
      }
    }
  }
  
  @Deprecated
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!bgmq.b(a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "smart crop switch is false ! url : " + paramString);
      }
      return paramString;
    }
    double d2 = 1.0D * paramInt1 / paramInt2;
    double d1 = 1.7976931348623157E+308D;
    Object localObject1 = null;
    int m = obb.a.length;
    Object localObject2 = obb.a;
    int k = 0;
    label74:
    double d3;
    double d4;
    if (k < m)
    {
      d3 = 1.0D * ((Integer)localObject2[k].second).intValue() / ((Integer)localObject2[k].first).intValue();
      d4 = Math.abs(d3 - d2);
      if (d4 < d1)
      {
        d1 = Math.abs(d3 - d2);
        localObject1 = localObject2[k];
      }
    }
    for (;;)
    {
      k += 1;
      break label74;
      if ((d4 == d1) && (localObject1 != null))
      {
        int n = Math.abs(((Integer)localObject1.second).intValue() - paramInt1);
        int i1 = Math.abs(((Integer)localObject1.first).intValue() - paramInt2);
        int i2 = Math.abs(((Integer)localObject2[k].second).intValue() - paramInt1);
        if (n + i1 > Math.abs(((Integer)localObject2[k].first).intValue() - paramInt2) + i2)
        {
          d1 = Math.abs(d3 - d2);
          localObject1 = localObject2[k];
          continue;
          if (localObject1 == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "the picture size : w : " + paramInt2 + " h : " + paramInt1 + ", select scale : " + localObject1.first + ":" + localObject1.second + " bias : " + d1 + " from : " + paramInt3);
          }
          localObject2 = paramString.split("/");
          localObject2 = localObject2[(localObject2.length - 1)];
          return paramString.replace("_open/" + (String)localObject2, "_open_" + localObject1.first + "_" + localObject1.second + "/" + (String)localObject2);
        }
      }
    }
  }
  
  public static String a(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong, int paramInt3)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    return String.format("https://kandian.qq.com/mqq/html/badcase.html?_wv=1027&_bid=2464&articleid=%s&senceID=%s&articleRecommend=%s&articleChannel=%s&algorithmID=%s&strategyID=%s", new Object[] { paramString1, String.valueOf(paramInt1), Base64.encodeToString(str.getBytes(), 0), String.valueOf(paramInt2), String.valueOf(paramLong), String.valueOf(paramInt3) });
  }
  
  public static String a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("algorithm_id", paramLong);
      localJSONObject.put("feeds_friends_interaction", paramInt);
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      localJSONObject.put("version", "8.2.6".replace(".", ""));
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
      localJSONObject.put("feeds_source", ((prx)paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int);
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
      if (qoe.a(paramArticleInfo)) {
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
        localJSONObject.put("feeds_source", localSocializeFeedsInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long);
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
        int n = ((JSONObject)localObject2).optInt("duration");
        String str3 = ((JSONObject)localObject2).optString("thirdIcon");
        String str4 = ((JSONObject)localObject2).optString("thirdName");
        String str5 = ((JSONObject)localObject2).optString("thirdAction");
        String str6 = ((JSONObject)localObject2).optString("innerUniqueID");
        String str7 = ((JSONObject)localObject2).optString("width", "0");
        String str8 = ((JSONObject)localObject2).optString("height", "0");
        int m = ((JSONObject)localObject2).optInt("busiType");
        int k = m;
        if (m == 0) {
          k = 1;
        }
        String str9 = ((JSONObject)localObject2).optString("third_uin", "");
        String str10 = ((JSONObject)localObject2).optString("third_uin_name", "");
        paramString = "0";
        String str1 = "";
        l2 = 0L;
        if (!qoe.d(paramBaseArticleInfo)) {
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
              m = 0;
              localObject3 = str1;
              l1 = l2;
              localObject2 = paramString;
              paramBaseArticleInfo = str1;
              localObject1 = paramString;
              if (m < localJSONArray.length())
              {
                paramBaseArticleInfo = str1;
                localObject1 = paramString;
                JSONObject localJSONObject = localJSONArray.optJSONObject(m);
                if (localJSONObject == null) {
                  continue;
                }
                paramBaseArticleInfo = str1;
                localObject1 = paramString;
                int i1 = localJSONObject.optInt("network_type");
                paramBaseArticleInfo = str1;
                localObject1 = paramString;
                l1 = localJSONObject.optLong("file_size");
                if (i1 != 2) {
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
          return str2 + ";" + n + ";" + str3 + ";" + str4 + ";" + str5 + ";" + str6 + ";" + k + ";" + str7 + ";" + str8 + ";" + str9 + ";" + str10 + ";" + (String)localObject2 + ";" + (String)localObject3 + ";" + l1;
          m += 1;
        }
      }
    }
    return null;
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
      localJSONObject.put("proteus_bid", bgmq.a("default_feeds_proteus_offline_bid"));
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
    int m = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("time", System.currentTimeMillis());
      localJSONObject.put("algorithm_id", paramString1);
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
      if (paramBoolean)
      {
        k = 1;
        localJSONObject.put("avatar", k);
        localJSONObject.put("kd_pos", jdField_e_of_type_Int);
        if (!TextUtils.isEmpty(paramString3)) {
          localJSONObject.put("stick", paramString3);
        }
        if (jdField_d_of_type_Int == 6)
        {
          localJSONObject.put("id", paramString2);
          localJSONObject.put("social_uin", paramString4);
        }
        if (!e()) {
          break label231;
        }
        k = 1;
        label143:
        localJSONObject.put("message_status", k);
        if (bgmq.I(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          break label237;
        }
        k = 1;
        label170:
        localJSONObject.put("reddot_style", k);
        if (!bgmq.y(a())) {
          break label243;
        }
      }
      label231:
      label237:
      label243:
      for (int k = m;; k = 0)
      {
        localJSONObject.put("hemera_switch", k);
        localJSONObject.put("kandian_mode_new", new.a());
        paramString1 = localJSONObject.toString();
        return paramString1;
        k = 0;
        break;
        k = 0;
        break label143;
        k = 0;
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
  
  public static String a(String paramString, ppv paramppv, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramString;
    if (paramppv != null)
    {
      localObject = paramString;
      if (paramBaseArticleInfo != null)
      {
        localObject = paramString;
        if (TextUtils.isEmpty(paramppv.jdField_c_of_type_JavaLangString)) {}
      }
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mqqapi://readinjoy/open?src_type=internal&target=3").append("&channelID=").append(paramBaseArticleInfo.mChannelID).append("&strategyId=").append(paramppv.jdField_a_of_type_Int).append("&algorithmID=").append(paramppv.jdField_b_of_type_Long).append("&title=").append(paramppv.jdField_a_of_type_JavaLangString).append("&firstPagePicUrl=").append(URLEncoder.encode(paramppv.jdField_c_of_type_JavaLangString, "UTF-8")).append("&articleID=").append(paramppv.jdField_a_of_type_Long).append("&subscribeName=").append(paramppv.jdField_f_of_type_JavaLangString).append("&rowKey=").append(paramppv.jdField_g_of_type_JavaLangString).append("&subscribeID=").append(paramppv.jdField_e_of_type_JavaLangString).append("&articleContentUrl=").append(URLEncoder.encode(paramString, "UTF-8")).append("&readinjoyNotDecodeUrl=1");
      localObject = ((StringBuilder)localObject).toString();
      QLog.d("ReadInJoyUtils", 1, "getJumpNativeArticleScheme | polymeric articleScheme : " + (String)localObject);
      return localObject;
    }
    catch (UnsupportedEncodingException paramppv)
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
      int m = paramArrayOfString.length;
      int k = 0;
      for (;;)
      {
        if (k >= m) {
          break label65;
        }
        String str = paramArrayOfString[k];
        if (str.contains(paramString))
        {
          paramString = str.split("=");
          if ((paramString == null) || (paramString.length != 2)) {
            break;
          }
          return paramString[1];
        }
        k += 1;
      }
    }
  }
  
  /* Error */
  public static String a(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 1645	java/io/StringWriter
    //   5: dup
    //   6: invokespecial 1646	java/io/StringWriter:<init>	()V
    //   9: astore_1
    //   10: new 1648	java/io/PrintWriter
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 1651	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   18: astore_3
    //   19: aload_0
    //   20: aload_3
    //   21: invokevirtual 1656	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   24: aload_3
    //   25: invokevirtual 1659	java/io/PrintWriter:flush	()V
    //   28: aload_1
    //   29: invokevirtual 1660	java/io/StringWriter:flush	()V
    //   32: aload_1
    //   33: ifnull +7 -> 40
    //   36: aload_1
    //   37: invokevirtual 1661	java/io/StringWriter:close	()V
    //   40: aload_3
    //   41: ifnull +7 -> 48
    //   44: aload_3
    //   45: invokevirtual 1662	java/io/PrintWriter:close	()V
    //   48: aload_1
    //   49: invokevirtual 1663	java/io/StringWriter:toString	()Ljava/lang/String;
    //   52: areturn
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 1664	java/io/IOException:printStackTrace	()V
    //   58: goto -18 -> 40
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_2
    //   65: ifnull +7 -> 72
    //   68: aload_2
    //   69: invokevirtual 1661	java/io/StringWriter:close	()V
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 1662	java/io/PrintWriter:close	()V
    //   80: aload_0
    //   81: athrow
    //   82: astore_2
    //   83: aload_2
    //   84: invokevirtual 1664	java/io/IOException:printStackTrace	()V
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
        localJSONObject.put("type", localDislikeInfo.jdField_c_of_type_Int);
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
  
  public static String a(JSONObject paramJSONObject)
  {
    int k = 1;
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      if (bgmq.I(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
      for (;;)
      {
        localJSONObject.put("reddot_style", k);
        localJSONObject.put("kandian_mode", e());
        localJSONObject.put("kandian_mode_new", new.a());
        localJSONObject.put("tab_source", d());
        localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
        paramJSONObject = localJSONObject.toString();
        return paramJSONObject;
        k = 0;
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
          paramBaseArticleInfo = rsl.a(paramBaseArticleInfo.optString("picture"), 3);
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
    return rsl.a(paramString, 3);
  }
  
  public static URL a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (a(paramString)) {
      if (!paramBoolean1) {
        break label57;
      }
    }
    label57:
    for (localObject = obj.e();; localObject = obj.a())
    {
      localObject = a(paramString, ((Integer)((android.util.Pair)localObject).second).intValue(), ((Integer)((android.util.Pair)localObject).first).intValue(), 3);
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
  
  public static ocg a()
  {
    ocg localocg = new ocg();
    try
    {
      localocg.i();
      localocg.j();
      localocg.k();
      localocg.m();
      localocg.l();
      return localocg;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localocg;
  }
  
  public static ocg a(int paramInt1, long paramLong, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    ocg localocg = new ocg();
    try
    {
      paramString1 = localocg.a(paramLong).b().c().k(paramInt2).a(paramInt1).l().c(paramString1).j().k().b(paramString2).f(paramInt3).g(paramInt4).h(paramInt5).i(paramInt6).j(paramInt7).d().e().f().g();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return localocg;
  }
  
  public static ocg a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    localocg1 = new ocg();
    try
    {
      ocg localocg2 = localocg1.b().c().a(paramInt1).e().f().g().h().a(paramString).d(paramInt2).e(paramInt3).a();
      if (paramBoolean) {}
      for (paramString = "1";; paramString = "2")
      {
        localocg2.a("refresh_way", paramString).i().m();
        if (paramInt4 == -1) {
          break;
        }
        localocg1.a("pull_image", String.valueOf(paramInt4));
        return localocg1;
      }
      return localocg1;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static ocg a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null))
    {
      SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
      Object localObject;
      int k;
      if (qoe.a(paramArticleInfo))
      {
        localObject = paramArticleInfo.mSubscribeID;
        if (localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList == null) {
          break label171;
        }
        k = localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList.size();
        label49:
        if (!TextUtils.isEmpty(localSocializeFeedsInfo.jdField_a_of_type_JavaLangString)) {
          break label176;
        }
      }
      label171:
      label176:
      for (int m = 0;; m = 1)
      {
        int n = localSocializeFeedsInfo.jdField_b_of_type_Int;
        int i1 = localSocializeFeedsInfo.jdField_d_of_type_Int;
        int i2 = localSocializeFeedsInfo.jdField_f_of_type_Int;
        return a((int)paramArticleInfo.mChannelID, paramArticleInfo.mAlgorithmID, paramArticleInfo.mFeedType, (String)localObject, paramArticleInfo.innerUniqueID, k + 1, m, n, i1, i2);
        StringBuilder localStringBuilder = new StringBuilder().append("");
        if (localSocializeFeedsInfo.jdField_a_of_type_Pqo != null) {}
        for (localObject = Long.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long);; localObject = "")
        {
          localObject = localObject;
          break;
        }
        k = 0;
        break label49;
      }
    }
    return new ocg();
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
            int k = paramString.length();
            if (k >= 1) {
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
    int k = 0;
    for (;;)
    {
      try
      {
        if ((k >= paramJSONArray1.length()) || (k >= paramJSONArray2.length())) {
          break;
        }
        if (((paramJSONArray2.get(k) instanceof JSONObject)) && ((paramJSONArray1.get(k) instanceof JSONObject)))
        {
          JSONObject localJSONObject1 = (JSONObject)paramJSONArray2.get(k);
          JSONObject localJSONObject2 = (JSONObject)paramJSONArray1.get(k);
          Iterator localIterator = localJSONObject1.keys();
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject2.put(str, localJSONObject1.get(str));
            continue;
          }
        }
        k += 1;
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
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
      localJSONObject.put("kandian_mode_new", new.a());
      localJSONObject.put("algorithm_id", jdField_a_of_type_Ppp.jdField_a_of_type_JavaLangString);
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
    label148:
    label178:
    int k;
    try
    {
      localJSONObject.put("algorithm_id", paramLong);
      localJSONObject.put("folder_status", e(paramInt2));
      localJSONObject.put("feeds_type", paramInt1);
      localJSONObject.put("time", System.currentTimeMillis());
      localJSONObject.put("channel_id", paramInt2);
      if (!paramBoolean) {
        break label1421;
      }
      paramInt1 = 2;
      localJSONObject.put("network_type", paramInt1);
      localJSONObject.put("feeds_source", paramString1);
      localJSONObject.put("imei", f());
      localJSONObject.put("imsi", g());
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
      if ((paramInt2 == 0) || (odm.c(paramInt2)))
      {
        if (paramInt2 != 0) {
          break label1426;
        }
        paramString1 = rvf.jdField_a_of_type_JavaLangString;
        localJSONObject.put("r_session_id", paramString1);
        if (paramArticleInfo != null)
        {
          if (paramInt2 != 0) {
            break label1434;
          }
          paramString1 = rvf.a(paramArticleInfo.mArticleID);
          if (paramString1 != null)
          {
            localJSONObject.put("r_session_position", paramString1.first);
            localJSONObject.put("r_session_ispush", paramString1.second);
          }
        }
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("rowkey", paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("account_type", paramString3);
      }
      if ((!a(paramArticleInfo)) && (!qoe.a(paramArticleInfo)) && (!qoe.i(paramArticleInfo)) && (!qoe.n(paramArticleInfo)) && (!qoe.j(paramArticleInfo)) && (!qoe.k(paramArticleInfo))) {
        break label1538;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList == null) {
        break label2963;
      }
      paramInt1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList.size();
      localJSONObject.put("number", paramInt1 + 1);
      k = 0;
      if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList == null)) {
        break label1516;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList.size() <= 1) {
        break label1447;
      }
      paramInt1 = 2;
      label384:
      localJSONObject.put("words", paramInt1);
      localJSONObject.put("likes", paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int);
      localJSONObject.put("comment", paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int);
      localJSONObject.put("biu", paramArticleInfo.mSocialFeedInfo.jdField_f_of_type_Int);
      label445:
      if (bgmq.I(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
        break label2968;
      }
      paramInt1 = 1;
      label460:
      localJSONObject.put("reddot_style", paramInt1);
      localJSONObject.put("feeds_type", a(paramArticleInfo));
      localJSONObject.put("kandian_mode", e());
      localJSONObject.put("kandian_mode_new", new.a());
      localJSONObject.put("tab_source", paramInt4);
      localJSONObject.put("jump_to_channel", paramInt3);
      if ((paramArticleInfo != null) && (paramArticleInfo.feedsFirstExposurePos != -1)) {
        localJSONObject.put("card_pos", paramArticleInfo.feedsFirstExposurePos);
      }
      if (!bgmq.y(a())) {
        break label2973;
      }
      paramInt1 = 1;
      label569:
      localJSONObject.put("hemera_switch", paramInt1);
      localJSONObject.put("proteus_bid", bgmq.a("default_feeds_proteus_offline_bid"));
      paramString1 = bgmq.a("kd_topic_recommend_card_jump_switch");
      if (!(paramString1 instanceof Boolean)) {
        break label2943;
      }
      paramBoolean = ((Boolean)paramString1).booleanValue();
    }
    catch (JSONException paramString1)
    {
      label623:
      long l;
      paramString1.printStackTrace();
    }
    localJSONObject.put("jump_mode", paramString1);
    localJSONObject.put("star_logo", b(paramArticleInfo));
    l = 0L;
    paramLong = l;
    if (paramArticleInfo != null)
    {
      if ((!qoe.c(paramArticleInfo)) && (!qoe.n(paramArticleInfo)) && (!qoe.j(paramArticleInfo))) {
        break label1591;
      }
      paramLong = l;
      if (paramArticleInfo.mTopicRecommendFeedsInfo != null)
      {
        paramLong = l;
        if (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null)
        {
          paramLong = l;
          if (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            paramLong = l;
            if (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0) != null) {
              paramLong = ((prx)paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int;
            }
          }
        }
      }
      label763:
      if ((paramArticleInfo.recommentFlag & 0x1000) == 0) {
        break label1646;
      }
      localJSONObject.put("msg_back", "1");
    }
    for (;;)
    {
      localJSONObject.put("topicid", paramLong);
      if (new.jdField_a_of_type_JavaLangString == null) {
        new.jdField_a_of_type_JavaLangString = "8.2.6".replace(".", "");
      }
      localJSONObject.put("version", new.jdField_a_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      if (paramInt2 == 0) {
        localJSONObject.put("preload_flag", ooq.b());
      }
      if ((paramArticleInfo != null) && (paramArticleInfo.mFeedType == 26))
      {
        if (!TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
          localJSONObject.put("touin", paramArticleInfo.mSubscribeID);
        }
        localJSONObject.put("uin", a());
        if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri.jdField_a_of_type_Poq != null)) {
          localJSONObject.put("likes", paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri.jdField_a_of_type_Poq.jdField_a_of_type_Int);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          localJSONObject.put("ans_rowkey", paramString2);
        }
        if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri.jdField_a_of_type_Poq != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri.jdField_a_of_type_Poq.jdField_a_of_type_JavaLangString))) {
          localJSONObject.put("rowkey", paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri.jdField_a_of_type_Poq.jdField_a_of_type_JavaLangString);
        }
      }
      new.a(localJSONObject);
      if (bati.a() != 1) {
        break label2985;
      }
      paramString1 = "1";
      label1075:
      localJSONObject.put("simCardType", paramString1);
      if ((paramArticleInfo != null) && (paramArticleInfo.hotWordInfo != null) && (paramArticleInfo.mFeedType == 28))
      {
        if (paramArticleInfo.hotWordInfo.jdField_a_of_type_JavaUtilList == null) {
          break label2992;
        }
        paramInt1 = paramArticleInfo.hotWordInfo.jdField_a_of_type_JavaUtilList.size();
        label1134:
        localJSONObject.put("hotword_card_num", paramInt1);
      }
      if ((paramArticleInfo != null) && (paramArticleInfo.mChannelID == 0L) && (g(paramArticleInfo)))
      {
        if (paramArticleInfo.mCommentCount > 100L) {
          break label2958;
        }
        if (paramArticleInfo.mVideoCommentCount <= 100) {
          break label2997;
        }
        break label2958;
        label1192:
        localJSONObject.put("comment_exposure", paramInt1);
      }
      if ((paramArticleInfo != null) && (qoe.f(paramArticleInfo)))
      {
        paramString1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm;
        if (paramString1 != null) {
          localJSONObject.put("ori_feeds_id", paramString1.jdField_a_of_type_JavaLangLong);
        }
      }
      paramInt1 = ReadInJoyBaseFragment.a(paramInt2);
      if (paramInt1 >= 0) {
        localJSONObject.put("entry_path", paramInt1);
      }
      if (((!oxy.a(paramArticleInfo)) && ((paramArticleInfo == null) || (!paramArticleInfo.isPGCShortContent()))) || (paramArticleInfo.mProteusTemplateBean == null)) {
        break label1660;
      }
      paramString1 = paramArticleInfo.mProteusTemplateBean.getDataAttribute(null);
      if ((paramString1 == null) || (paramString1.entrySet() == null)) {
        break label1660;
      }
      paramString1 = paramString1.entrySet().iterator();
      while ((paramString1 != null) && (paramString1.hasNext()))
      {
        paramString3 = (Map.Entry)paramString1.next();
        paramString2 = (String)paramString3.getKey();
        paramString3 = paramString3.getValue();
        localJSONObject.put(paramString2, "" + paramString3);
      }
      label1418:
      return localJSONObject;
      label1421:
      paramInt1 = 1;
      break;
      label1426:
      paramString1 = oab.jdField_a_of_type_JavaLangString;
      break label148;
      label1434:
      paramString1 = oab.a(paramArticleInfo.mArticleID);
      break label178;
      label1447:
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        paramInt1 = 1;
        break label384;
      }
      paramInt1 = k;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList.size() != 0) {
        break label384;
      }
      paramInt1 = k;
      if (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString)) {
        break label384;
      }
      paramInt1 = 1;
      break label384;
      label1516:
      paramInt1 = k;
      if (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString)) {
        break label384;
      }
      paramInt1 = 1;
      break label384;
      label1538:
      localJSONObject.put("number", 0);
      localJSONObject.put("words", 0);
      localJSONObject.put("likes", 0);
      localJSONObject.put("comment", 0);
      localJSONObject.put("biu", 0);
      break label445;
      label1591:
      if ((i(paramArticleInfo)) && ((paramArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 7) || (paramArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 8)))
      {
        paramLong = paramArticleInfo.mPolymericInfo.jdField_f_of_type_Long;
        break label763;
      }
      paramLong = paramArticleInfo.businessId;
      break label763;
      label1646:
      localJSONObject.put("msg_back", "0");
    }
    label1660:
    if (odm.c(paramInt2)) {
      localJSONObject.put("cmd", bgmq.g());
    }
    if (n())
    {
      paramInt1 = 1;
      localJSONObject.put("interact_bar", paramInt1);
      paramBoolean = false;
      if (paramArticleInfo != null)
      {
        paramBoolean = paramArticleInfo.isPGCShortContent();
        if ((TextUtils.isEmpty(paramArticleInfo.proteusItemsData)) || (!paramArticleInfo.proteusItemsData.contains("article_main_body_text"))) {
          break label3029;
        }
        paramInt1 = 1;
        break label3002;
        label1742:
        paramString1 = rvf.a(paramArticleInfo.mChannelID);
        if ((paramString1 != null) && (paramString1.get(Long.valueOf(paramArticleInfo.mArticleID)) != null))
        {
          localJSONObject.put("main_text_read_time", ((rvk)paramString1.get(Long.valueOf(paramArticleInfo.mArticleID))).jdField_a_of_type_Long);
          break label3014;
          label1808:
          localJSONObject.put("short_content_rsc", paramInt1);
          paramString1 = new StringBuilder().append("");
          if (paramArticleInfo == null) {
            break label3042;
          }
          paramInt1 = paramArticleInfo.isSuperTop;
          label1843:
          localJSONObject.put("keep_top", paramInt1);
          if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramArticleInfo.mReportCommonData))) {
            break label3047;
          }
          paramString1 = paramArticleInfo.mReportCommonData;
          label1884:
          localJSONObject.put("report_common_data", paramString1);
          if (TextUtils.isEmpty(Build.BRAND)) {
            break label3054;
          }
          paramString1 = Build.BRAND;
          label1909:
          localJSONObject.put("device_brand", paramString1);
          if (TextUtils.isEmpty(Build.MODEL)) {
            break label3061;
          }
          paramString1 = Build.MODEL;
          label1934:
          localJSONObject.put("device_type", paramString1);
          if ((paramArticleInfo != null) && ((paramArticleInfo.isPGCShortContent()) || (paramArticleInfo.isAccountShown)))
          {
            localJSONObject.put("click_area", paramArticleInfo.click_area);
            paramArticleInfo.click_area = 0;
            if (!paramArticleInfo.isShowGif) {
              break label2615;
            }
            localJSONObject.put("short_content_gif", 1);
            localJSONObject.put("gif_playmode", ComponentPGCShortContentBig.jdField_a_of_type_Int);
          }
          localJSONObject.put("account_expose_card", c(paramArticleInfo));
          if (paramArticleInfo == null) {
            break label3068;
          }
        }
      }
    }
    label2156:
    label3054:
    label3061:
    label3068:
    for (paramString1 = paramArticleInfo.getProteusItemData();; paramString1 = null)
    {
      if (paramString1 != null)
      {
        localJSONObject.put("jump_page", paramString1.optString("jump_page_fg_button"));
        localJSONObject.put("jump_src", paramString1.optString("jump_src_fg_button"));
      }
      if ((paramArticleInfo != null) && (paramArticleInfo.isPGCShortContent())) {
        localJSONObject.put("picture_click_jumptype", Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0));
      }
      if ((!localJSONObject.has("jump_src")) && (poi.a().a(paramArticleInfo, false, poi.jdField_a_of_type_Int)))
      {
        localJSONObject.put("jump_src", pol.a(paramArticleInfo));
        if ((paramInt2 == 0) && (paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.adReportCommonData))) {
          localJSONObject.put("bytes_ad_report_common_data", paramArticleInfo.adReportCommonData);
        }
        if (paramInt2 == 41695)
        {
          paramString1 = ogy.a().a();
          if (paramString1 != null)
          {
            paramString1 = paramString1.a();
            if (paramString1 != null)
            {
              localJSONObject.put("channel_city", paramString1.city);
              if (QLog.isColorLevel()) {
                QLog.i("ReadInJoyUtils", 2, "reportReadArticle CHANNEL_ID_LOCAL r5Str = " + localJSONObject);
              }
            }
          }
        }
        if (paramArticleInfo != null)
        {
          if ((opa.a() == -1) || (opa.a() == 0)) {
            break label2662;
          }
          localJSONObject.put("mainfeeds_showcase", opa.a());
          localJSONObject.put("configchannel_name", opa.a());
        }
      }
      for (;;)
      {
        if ((paramArticleInfo != null) && (paramArticleInfo.mFeedType == 34) && (paramArticleInfo.scripCmsInfo != null))
        {
          paramString3 = paramArticleInfo.scripCmsInfo;
          paramString2 = "";
          paramString1 = paramString2;
          if (BaseApplicationImpl.getApplication() != null)
          {
            paramString1 = paramString2;
            if (BaseApplicationImpl.getApplication().getRuntime() != null) {
              paramString1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            }
          }
          localJSONObject.put("uin", paramString1);
          localJSONObject.put("fromuin", "" + paramString3.jdField_a_of_type_Long);
          localJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
          localJSONObject.put("zhitiao_num_daily", orc.a(BaseApplicationImpl.getApplication(), paramString1));
          localJSONObject.put("zhitiao_sum", pqi.jdField_c_of_type_Int);
          localJSONObject.put("tag", paramString3.j);
          localJSONObject.put("zhitiao_show", paramString3.jdField_b_of_type_Int);
        }
        if ((paramArticleInfo == null) || (paramArticleInfo.mFeedType != 35) || (paramArticleInfo.multiVideoColumnInfo == null)) {
          break label2765;
        }
        paramString1 = paramArticleInfo.multiVideoColumnInfo;
        localJSONObject.put("column_id", paramString1.jdField_a_of_type_Int);
        if (paramString1.jdField_a_of_type_JavaUtilList.size() <= 0) {
          break label2686;
        }
        paramString2 = new JsonArray();
        paramString3 = paramString1.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString3.hasNext()) {
          paramString2.add(((prj)paramString3.next()).jdField_a_of_type_JavaLangString);
        }
        localJSONObject.put("main_text_read_time", 0);
        break label3034;
        localJSONObject.put("short_content_gif", 0);
        break;
        if ((paramArticleInfo == null) || (!a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
          break label2156;
        }
        localJSONObject.put("jump_src", i());
        break label2156;
        localJSONObject.put("mainfeeds_showcase", 0);
      }
      localJSONObject.put("all_rowkey", paramString2);
      label2686:
      paramInt1 = 0;
      if (paramString1.jdField_a_of_type_Boolean) {
        paramInt1 = 1;
      }
      localJSONObject.put("subscribe", paramInt1);
      paramString2 = a(paramArticleInfo.mArticleID);
      if (paramString2 != null) {
        localJSONObject.put("rowkey", paramString2);
      }
      if (!TextUtils.isEmpty(paramString1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_e_of_type_JavaLangString)) {
        localJSONObject.put("jump_report_info", paramString1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_e_of_type_JavaLangString);
      }
      if ((paramArticleInfo == null) || (paramArticleInfo.mNewPolymericInfo == null) || (paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int != 15)) {
        break label1418;
      }
      localJSONObject.put("feeds_type", 1036);
      localJSONObject.put("feeds_size", paramArticleInfo.mNewPolymericInfo.jdField_c_of_type_Int);
      localJSONObject.put("feeds_head", paramArticleInfo.mNewPolymericInfo.jdField_b_of_type_Int);
      localJSONObject.put("column_id", paramArticleInfo.mNewPolymericInfo.jdField_d_of_type_Int);
      if (paramArticleInfo.mNewPolymericInfo.jdField_b_of_type_Int == 3)
      {
        localJSONObject.put("column_id", paramArticleInfo.mNewPolymericInfo.jdField_d_of_type_Int);
        localJSONObject.put("subscribe_flag", paramArticleInfo.mNewPolymericInfo.jdField_e_of_type_Int);
      }
      localJSONObject.put("report_common_data", paramArticleInfo.mReportCommonData);
      paramString1 = a(paramArticleInfo.mArticleID);
      if (paramString1 == null) {
        break label1418;
      }
      localJSONObject.put("rowkey", paramString1);
      return localJSONObject;
      label2943:
      paramBoolean = false;
      if (paramBoolean)
      {
        paramString1 = "2";
        break label623;
        paramInt1 = 1;
        break label1192;
        paramInt1 = 0;
        break;
        paramInt1 = 0;
        break label460;
        paramInt1 = 0;
        break label569;
      }
      paramString1 = "1";
      break label623;
      paramString1 = "0";
      break label1075;
      paramInt1 = 0;
      break label1134;
      paramInt1 = 2;
      break label1192;
      if (!paramBoolean)
      {
        if (paramInt1 == 0) {
          break label3034;
        }
        break label1742;
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label3037;
        }
        paramInt1 = 1;
        break label1808;
        paramInt1 = 0;
        break;
        paramInt1 = 0;
        break label3002;
        break label1742;
      }
      paramInt1 = 0;
      break label1808;
      paramInt1 = 0;
      break label1843;
      paramString1 = "";
      break label1884;
      paramString1 = "";
      break label1909;
      paramString1 = "";
      break label1934;
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
        localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
        localJSONObject.put("mp_article_id", paramArticleInfo.mArticleID);
        localJSONObject.put("channel_id", paramInt);
        if (badq.h(paramContext))
        {
          paramInt = 1;
          localJSONObject.put("network_type", paramInt);
          localJSONObject.put("os", "1");
          localJSONObject.put("version", "8.2.6".replace(".", ""));
          localJSONObject.put("imei", f());
          localJSONObject.put("imsi", g());
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
  
  public static JSONObject a(ppz paramppz)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", jdField_d_of_type_Int);
        localJSONObject.put("kandian_mode", String.valueOf(e()));
        localJSONObject.put("tab_source", d());
        k = -1;
        switch (paramppz.jdField_a_of_type_Int)
        {
        default: 
          localJSONObject.put("use_type", k);
          if (k == 2)
          {
            l = paramppz.jdField_b_of_type_Long;
            localJSONObject.put("type_id", l);
            localJSONObject.put("algorithm_id", paramppz.jdField_e_of_type_Long);
            return localJSONObject;
          }
          long l = paramppz.jdField_f_of_type_Long;
          continue;
          continue;
        }
      }
      catch (JSONException paramppz)
      {
        paramppz.printStackTrace();
        return localJSONObject;
      }
      int k = 2;
      continue;
      k = 1;
      continue;
      k = 3;
    }
  }
  
  public static void a()
  {
    m = 0;
    try
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label168;
      }
      localObject = ((QQAppInterface)localObject).a();
      if (localObject == null) {
        break label168;
      }
      localObject = ((QQMessageFacade)localObject).b(ajed.az, 7220);
      k = m;
      if (localObject != null)
      {
        k = m;
        if (((MessageRecord)localObject).extInt != 1)
        {
          if (((MessageRecord)localObject).extInt != 3) {
            break label203;
          }
          k = m;
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
            k = m;
            if (((MessageRecord)localObject).extInt != 4) {
              continue;
            }
            continue;
            if (k == 0)
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
            if (k != 1) {
              continue;
            }
            jdField_d_of_type_Int = 2;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
          int k = 1;
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
    jdField_a_of_type_Int = (int)(paramFloat / paramResources.getDimensionPixelSize(2131167514) + 0.5F);
  }
  
  public static void a(int paramInt)
  {
    jdField_d_of_type_Int = paramInt;
    jdField_a_of_type_Ppp.jdField_a_of_type_Int = jdField_d_of_type_Int;
    SPEventReportSwitch.a(paramInt);
    QLog.d("ReadInJoyUtils", 1, new Object[] { "update fs : ", Integer.valueOf(paramInt) });
  }
  
  public static void a(int paramInt, long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyUtils.23(paramInt, System.currentTimeMillis() - paramLong));
  }
  
  public static void a(int paramInt, long paramLong, qht paramqht, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    qmv localqmv = new qmv("", "", "", "").a(paramInt).b(paramLong);
    if (paramqht != null) {
      localqmv.e(paramqht.jdField_g_of_type_Long).c(paramqht.jdField_g_of_type_Int);
    }
    if (paramBaseArticleInfo != null) {
      localqmv.g(paramBaseArticleInfo.innerUniqueID).F(a(paramBaseArticleInfo));
    }
    if (paramBoolean) {}
    for (paramqht = "1";; paramqht = "0")
    {
      ndn.a(null, "", "0X8007DBB", "0X8007DBB", 0, 0, paramqht, "", "", localqmv.a().a(), false);
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
      for (long l = -1L;; l = Long.valueOf(paramString4).longValue())
      {
        localReportInfo.mPuin = l;
        paramInt1 = paramInt2;
        if (paramInt2 == -1) {
          paramInt1 = jdField_d_of_type_Int;
        }
        localReportInfo.mFolderStatus = paramInt1;
        localArrayList.add(localReportInfo);
        new oqv(null, null, pdc.a(), null).b(localArrayList);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("ReadInJoyUtils", 1, "reportRealTimeKandianAction error ", paramString1);
    }
  }
  
  public static void a(int paramInt, List<beml> paramList)
  {
    beml localbeml;
    if ((paramInt & 0x1) != 0)
    {
      localbeml = new beml();
      localbeml.jdField_a_of_type_Int = 0;
      localbeml.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131652599);
      localbeml.jdField_b_of_type_Int = 2130842202;
      paramList.add(localbeml);
    }
    if ((paramInt & 0x2) != 0)
    {
      localbeml = new beml();
      localbeml.jdField_a_of_type_Int = 1;
      localbeml.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131652603);
      localbeml.jdField_b_of_type_Int = 2130842206;
      paramList.add(localbeml);
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
      ndn.a(null, null, str, str, 0, 0, "", "", "", new qmv(null, null, null, null).e(paramLong).a().a(), false);
      return;
    }
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return;
    }
    if ((paramArticleInfo.mArticleContentUrl != null) && (paramArticleInfo.mArticleContentUrl.startsWith("mqqapi:")))
    {
      e(paramActivity, paramArticleInfo.mArticleContentUrl);
      a(paramArticleInfo, paramArticleInfo.mArticleContentUrl);
      return;
    }
    rbf.a("FastWebActivity.show");
    ogy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    Intent localIntent = new Intent(paramActivity, FastWebActivity.class);
    localIntent.putExtra("fast_web_article_info", paramArticleInfo);
    paramActivity.startActivityForResult(localIntent, 10922);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, qoe paramqoe, int paramInt)
  {
    a(paramActivity, paramArticleInfo, paramqoe, paramInt);
    ogy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramqoe.notifyDataSetChanged();
    if (scb.a(paramArticleInfo))
    {
      paramqoe = new Intent(paramActivity, PublicAccountImageCollectionMainActivity.class);
      paramqoe.putExtra("source_for_report", 9);
      scb.a(paramActivity, paramqoe, String.valueOf(paramArticleInfo.innerUniqueID));
      return;
    }
    paramInt = paramqoe.a();
    long l = paramArticleInfo.mRecommendSeq;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (qoe.b(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!qoe.f(paramArticleInfo)) {
        localObject1 = ((prx)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString;
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
      if (!c((String)localObject2)) {
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
    localBundle.putLong("recommendSeq", l);
    localBundle.putInt("channelid", paramInt);
    localBundle.putInt("strategyid", paramArticleInfo.mStrategyId);
    localBundle.putLong("algorithmid", paramArticleInfo.mAlgorithmID);
    localBundle.putInt("articalChannelId", 9);
    localBundle.putStringArray("insertPluginsArray", new String[] { "pubAccountPreload" });
    localBundle.putBoolean("ip_connect", rsp.m);
    l = System.currentTimeMillis();
    localBundle.putLong("startOpenPageTime", l);
    localBundle.putLong("click_time", l);
    localBundle.putLong("available_memory", babp.e());
    localBundle.putBoolean("preload_tool_white_list", g());
    Intent localIntent = new Intent(paramActivity, ReadInJoyArticleDetailActivity.class);
    localObject2 = PreloadManager.a((String)localObject2);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if ((bace.b(ajed.cE + (String)localObject1)) && (PreloadManager.a().b((String)localObject1) != null))
    {
      localBundle.putString("read_in_joy_from_cache", (String)localObject1);
      if (!paramqoe.a(paramInt, paramArticleInfo.mArticleID))
      {
        paramArticleInfo = PreloadManager.a();
        if ((NetworkState.getNetworkType() != 1) && (NetworkState.getNetworkType() != 4) && (NetworkState.getNetworkType() != 5)) {
          break label655;
        }
        paramqoe = paramArticleInfo.a((String)localObject1);
        if ((paramqoe != null) && (paramqoe.size() > 0))
        {
          ThreadManager.post(new ReadInJoyUtils.22(paramArticleInfo, (rsf)paramqoe.get(0)), 5, null, false);
          if (paramqoe.size() <= 1) {
            break label643;
          }
          localBundle.putString("preload_iamge_url", ((rsf)paramqoe.get(1)).jdField_a_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      localIntent.putExtras(localBundle);
      paramActivity.startActivityForResult(localIntent, 9991);
      return;
      label643:
      localBundle.putString("preload_iamge_url", null);
      continue;
      label655:
      paramArticleInfo = paramArticleInfo.a((String)localObject1);
      if ((paramArticleInfo != null) && (paramArticleInfo.size() > 0)) {
        localBundle.putString("preload_iamge_url", ((rsf)paramArticleInfo.get(0)).jdField_a_of_type_JavaLangString);
      } else {
        localBundle.putString("preload_iamge_url", null);
      }
    }
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
      if ((!azzu.b()) && (!azzu.d()))
      {
        paramSystemBarCompact.setStatusBarColor(-7829368);
        return;
      }
      paramSystemBarCompact.setStatusBarColor(-7829368);
      paramSystemBarCompact.setStatusBarDarkMode(true);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!azzu.b()) && (!azzu.d()))
    {
      a(paramActivity, true);
      paramSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!azzu.d())
    {
      paramSystemBarCompact.setStatusBarColor(-2368549);
      return;
    }
    paramSystemBarCompact.setStatusBarColor(-1);
    paramSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  public static void a(Context paramContext)
  {
    d(paramContext, null);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)a().getManager(162);
    int k = localKandianMergeManager.d();
    Object localObject1 = localKandianMergeManager.a();
    Object localObject2;
    if ((localObject1 == null) || (TextUtils.isEmpty(((KandianMsgBoxRedPntInfo)localObject1).mJumpUrl))) {
      localObject2 = obb.jdField_h_of_type_JavaLangString + k + "&message_entry=" + paramInt;
    }
    for (localObject1 = "http://viola.qq.com/js/messageBox.js?_rij_violaUrl=1&v_tid=6&v_bundleName=messageBox&v_bid=3740&statusColor=1&support_night=1&adtag=1&privateLetters=" + k + "&message_entry=" + paramInt;; localObject1 = "http://viola.qq.com/js/messageBox.js?_rij_violaUrl=1&v_tid=6&v_bundleName=messageBox&v_bid=3740&statusColor=1&support_night=1&adtag=2&privateLetters=" + k + "&message_entry=" + paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "person message box url: " + (String)localObject2);
      }
      localKandianMergeManager.q();
      if (!Boolean.valueOf(bgmq.q(a())).booleanValue()) {
        break;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("requestCode", 20001);
      rjb.a(paramContext, ajjy.a(2131647320), (String)localObject1, (Bundle)localObject2);
      return;
      localObject2 = ((KandianMsgBoxRedPntInfo)localObject1).mJumpUrl + "&privateLetters=" + k + "&message_entry=" + paramInt;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("requestCode", 20001);
    a(paramContext, (String)localObject2, (Bundle)localObject1);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mGalleryFeedsInfo != null) && (paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
    {
      paramArticleInfo = Uri.parse(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8()).buildUpon();
      paramArticleInfo.appendQueryParameter("showComment", "1");
      paramArticleInfo = paramArticleInfo.toString();
      e(paramContext, paramArticleInfo);
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
    if ((paramContext == null) || (paramArticleInfo == null)) {
      return;
    }
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    Object localObject3 = obb.jdField_e_of_type_JavaLangString;
    Object localObject1;
    if (((String)localObject3).contains("uin=")) {
      if (paramInt1 == 0) {
        localObject1 = ((String)localObject3).replace("uin=", "uin=" + baaw.encodeToString(String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long).getBytes(), 0).replace('\n', ' ').trim());
      }
    }
    for (;;)
    {
      label92:
      localObject3 = localObject1;
      label175:
      label235:
      Object localObject4;
      boolean bool;
      if (((String)localObject1).contains("&feedstype="))
      {
        if (((!qoe.i(paramArticleInfo)) && (!qoe.k(paramArticleInfo))) || ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 5))) {
          localObject3 = ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong);
        }
      }
      else
      {
        if ((paramInt1 != 3) && (paramInt1 != 5) && (paramInt1 != 2)) {
          break label1032;
        }
        localObject1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaLangLong;
        localObject1 = (String)localObject3 + String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaLangLong);
        localObject4 = new Bundle();
        if (pye.a(paramArticleInfo))
        {
          localObject3 = pye.a();
          if ((paramInt1 != 1) && (paramInt1 != 3)) {
            break label1068;
          }
          bool = true;
          label269:
          ((pye)localObject3).a(paramArticleInfo, bool, (String)localObject1);
        }
        localObject3 = localObject1;
        if (paramInt3 >= 0) {
          localObject3 = (String)localObject1 + "&jumptype=" + paramInt3;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUtils", 2, "new social second url:" + (String)localObject3);
        }
        a(paramContext, (String)localObject3, (Bundle)localObject4);
        if ((paramBoolean) || ((!a(paramArticleInfo)) && (!qoe.a(paramArticleInfo)) && (!qoe.a(paramArticleInfo)) && (!qoe.i(paramArticleInfo)) && (!qoe.j(paramArticleInfo)) && (!qoe.k(paramArticleInfo)))) {
          break;
        }
        paramContext = "";
      }
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("folder_status", jdField_d_of_type_Int);
          if (paramInt1 != 1) {
            continue;
          }
          ((JSONObject)localObject1).put("feeds_source", paramArticleInfo.mSubscribeID);
          ((JSONObject)localObject1).put("rowkey", paramArticleInfo.innerUniqueID);
          ((JSONObject)localObject1).put("feeds_type", "" + a(paramArticleInfo));
          ((JSONObject)localObject1).put("kandian_mode", "" + e());
          ((JSONObject)localObject1).put("tab_source", "" + d());
          if (paramInt2 > 0) {
            ((JSONObject)localObject1).put("entry_mode", "" + paramInt2);
          }
          ((JSONObject)localObject1).put("channel_id", "" + paramArticleInfo.mChannelID);
          ((JSONObject)localObject1).put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
          localObject1 = ((JSONObject)localObject1).toString();
          paramContext = (Context)localObject1;
        }
        catch (JSONException localJSONException)
        {
          long l;
          label1032:
          label1068:
          localJSONException.printStackTrace();
          continue;
          localObject2 = "0X8007B64";
          continue;
          ndn.a(null, paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, String.valueOf(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, paramContext, false);
          return;
        }
        if (!rvf.a(paramArticleInfo.mChannelID)) {
          continue;
        }
        localObject1 = "0X800935D";
        if ((!qoe.a(paramArticleInfo)) && (!qoe.i(paramArticleInfo)) && (!qoe.j(paramArticleInfo)) && (!qoe.k(paramArticleInfo))) {
          continue;
        }
        if (qoe.o(paramArticleInfo)) {
          break;
        }
        ndn.a(null, String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Long), (String)localObject1, (String)localObject1, 0, 0, String.valueOf(paramArticleInfo.mFeedId), "0", "" + paramArticleInfo.mStrategyId, paramContext, false);
        return;
        if ((paramInt1 == 1) || (paramInt1 == 3))
        {
          localObject4 = paramArticleInfo.mSubscribeID;
          localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = "";
          }
          localObject1 = ((String)localObject3).replace("uin=", "uin=" + baaw.encodeToString(((String)localObject1).getBytes(), 0).replace('\n', ' ').trim());
          break label92;
        }
        if ((paramInt1 == 2) || (paramInt1 == 4))
        {
          if (qoe.o(paramArticleInfo)) {
            break label1167;
          }
          l = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Long;
          localObject1 = ((String)localObject3).replace("uin=", "uin=" + baaw.encodeToString(String.valueOf(l).getBytes(), 0).replace('\n', ' ').trim());
          break label92;
        }
        if (paramInt1 != 5) {
          break label1167;
        }
        l = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
        localObject1 = ((String)localObject3).replace("uin=", "uin=" + baaw.encodeToString(String.valueOf(l).getBytes(), 0).replace('\n', ' ').trim());
        break label92;
        localObject3 = ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mFeedType);
        break label175;
        l = paramArticleInfo.mFeedId;
        localObject1 = (String)localObject3 + String.valueOf(paramArticleInfo.mFeedId);
        break label235;
        bool = false;
        break label269;
        ((JSONObject)localObject1).put("feeds_source", paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long);
      }
      label1167:
      Object localObject2 = localObject3;
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
    for (int k = 2;; k = 0)
    {
      a(paramContext, paramArticleInfo, paramInt1, paramBoolean1, paramInt2, k);
      return;
    }
  }
  
  @Deprecated
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, qoe paramqoe, int paramInt)
  {
    if ((paramArticleInfo == null) || (paramqoe == null)) {
      return;
    }
    int n = paramqoe.a();
    int k;
    if (paramArticleInfo.hasChannelInfo())
    {
      k = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label577;
      }
    }
    Object localObject;
    label577:
    for (int m = 0;; m = 1)
    {
      paramqoe = c(paramArticleInfo);
      ndn.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), n, k), false);
      ndn.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, k));
      localObject = rvf.b(n);
      ndn.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject, (String)localObject, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), n, k, m, badq.h(paramContext), paramqoe, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, e(paramArticleInfo), paramArticleInfo), false);
      ndn.a((String)localObject, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), n, k, m, badq.h(paramContext), paramqoe, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, e(paramArticleInfo), paramArticleInfo));
      paramContext = new ArrayList();
      paramqoe = new ReportInfo();
      paramqoe.mUin = a();
      paramqoe.mSource = 0;
      paramqoe.mSourceArticleId = paramArticleInfo.mArticleID;
      paramqoe.mChannelId = n;
      paramqoe.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      paramqoe.mStrategyId = paramArticleInfo.mStrategyId;
      paramqoe.mOperation = 1;
      paramqoe.mServerContext = paramArticleInfo.mServerContext;
      paramqoe.mReadTimeLength = -1;
      paramqoe.mInnerId = paramArticleInfo.innerUniqueID;
      if ((paramArticleInfo != null) && (!pol.a(paramArticleInfo)) && (!obv.a().a()) && (a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
        paramqoe.noDifferenceJump = 1;
      }
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label589;
      }
      localObject = new pqg();
      ((pqg)localObject).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo != null) {
        ((pqg)localObject).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
      }
      ((pqg)localObject).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((pqg)localObject).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramArticleInfo == null) || (paramArticleInfo.isEmpty())) {
        break label583;
      }
      ((pqg)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
      paramArticleInfo = paramArticleInfo.iterator();
      while (paramArticleInfo.hasNext())
      {
        pqo localpqo = (pqo)paramArticleInfo.next();
        if (localpqo != null) {
          ((pqg)localObject).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localpqo.jdField_a_of_type_Long));
        }
      }
      k = 0;
      break;
    }
    label583:
    paramqoe.mFeedsReportData = ((pqg)localObject);
    label589:
    paramArticleInfo = obv.a().a();
    if (paramArticleInfo != null) {
      paramqoe.srtClickInfo = paramArticleInfo;
    }
    paramContext.add(paramqoe);
    ogy.a().a(paramContext);
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
      nis localnis = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Nis;
      b(localnis, paramBaseArticleInfo);
      a(paramContext, localnis);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    paramString = a(paramBaseArticleInfo, paramString);
    QLog.d("ReadInJoyUtils", 1, "jumpTo |  scheme : " + paramString);
    a(paramBaseArticleInfo, paramString);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      QLog.d("ReadInJoyUtils", 1, "context or scehme null");
    }
    while (omi.a(paramContext, paramString)) {
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
      Object localObject = rjb.b(paramString);
      if ((rjb.b(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        rjb.a(paramContext, null, (String)localObject, null);
        return;
      }
      if ((paramString.startsWith("http://clientui.3g.qq.com/mqqapi/")) || (paramString.startsWith("http://clientui.3g.qq.com/mqq/")) || (paramString.startsWith("http://qm.qq.com/cgi-bin/")) || (paramString.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard"))) {}
      for (int k = 1;; k = 0)
      {
        if ((k == 0) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
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
  
  public static void a(Context paramContext, nis paramnis)
  {
    if ((paramContext != null) && (paramnis != null) && (!TextUtils.isEmpty(paramnis.jdField_c_of_type_JavaLangString)))
    {
      if (1 == paramnis.jdField_b_of_type_Int) {
        e(paramContext, paramnis.jdField_c_of_type_JavaLangString);
      }
      ndn.a(null, null, "0X8009BD5", "0X8009BD5", 0, 0, "", "", "", paramnis.a(), false);
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
    paramView2.post(new ReadInJoyUtils.20(paramView1, paramInt1, paramInt2, paramInt3, paramInt4, paramView2));
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
      pqg localpqg = new pqg();
      localpqg.jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo != null) {
        localpqg.jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
      }
      localpqg.jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localpqg.jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
      {
        localpqg.jdField_a_of_type_JavaUtilList = new ArrayList();
        paramArticleInfo = paramArticleInfo.iterator();
        while (paramArticleInfo.hasNext())
        {
          pqo localpqo = (pqo)paramArticleInfo.next();
          if (localpqo != null) {
            localpqg.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localpqo.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = localpqg;
    }
    localArrayList.add(localReportInfo);
    ogy.a().a(localArrayList);
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
        if ((qoe.b(paramBaseArticleInfo)) && (!qoe.f(paramBaseArticleInfo)))
        {
          paramBaseArticleInfo.mSinglePicture = a(((prx)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_d_of_type_JavaLangString, true, true);
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "preParseArticleJsonParam mJsonVideoList = " + paramBaseArticleInfo.mJsonVideoList);
          }
          if (TextUtils.isEmpty(paramBaseArticleInfo.mJsonVideoList)) {
            break label529;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "preParseArticleJsonParam article.mArticleID:" + paramBaseArticleInfo.mArticleID + " article.mTitle:" + paramBaseArticleInfo.mTitle + " article.mSummary:" + paramBaseArticleInfo.mSummary + "mJsonVideoList:" + paramBaseArticleInfo.mJsonVideoList);
          }
          paramBaseArticleInfo.mVideoCoverUrl = a(paramBaseArticleInfo, paramBaseArticleInfo.mJsonVideoList);
          localObject = a(paramBaseArticleInfo.mJsonVideoList, paramBaseArticleInfo);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label570;
          }
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
          return;
        }
        if (((paramBaseArticleInfo instanceof ArticleInfo)) && ((qoe.a((ArticleInfo)paramBaseArticleInfo)) || (qoe.f((ArticleInfo)paramBaseArticleInfo))))
        {
          paramBaseArticleInfo.mSinglePicture = a(paramBaseArticleInfo.mFirstPagePicUrl, qoe.g((ArticleInfo)paramBaseArticleInfo), true);
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
      paramBaseArticleInfo.mSinglePicture = b(paramBaseArticleInfo.mFirstPagePicUrl, qoe.g((ArticleInfo)paramBaseArticleInfo), true);
    }
    Object localObject = paramBaseArticleInfo.mFirstPagePicUrl;
    boolean bool2 = paramBaseArticleInfo.mShowBigPicture;
    if (paramBaseArticleInfo.mVideoType == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramBaseArticleInfo.mSinglePicture = a((String)localObject, bool2, bool1);
      break;
      label529:
      if (((paramBaseArticleInfo instanceof ArticleInfo)) && (!qoe.q((ArticleInfo)paramBaseArticleInfo))) {
        paramBaseArticleInfo.busiType = ((prg)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_f_of_type_Int;
      }
      label570:
      return;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    ndn.a(null, null, "0X800A5AB", "0X800A5AB", 0, 0, "", "", "", new qmv(null, null, null, null).W(54).h(paramBaseArticleInfo.getInnerUniqueID()).x(paramInt + 1).a().a(), false);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, String paramString)
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
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, pov parampov)
  {
    if ((paramBaseArticleInfo == null) || (!q(paramBaseArticleInfo))) {
      return;
    }
    parampov = new qmv(null, null, null, null).W(Integer.valueOf("2007").intValue());
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
    parampov.r(paramBaseArticleInfo.mKdLiveInfo.jdField_g_of_type_JavaLangString);
    ndn.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", parampov.a().a(), false);
    parampov.r(localBaseArticleInfo.mKdLiveInfo.jdField_g_of_type_JavaLangString);
    ndn.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", parampov.a().a(), false);
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
        if ((localMessageForStructing != null) && (localMessageForStructing.structingMsg != null)) {
          ((JSONObject)localObject).put("rowkey", localMessageForStructing.structingMsg.mInnerUniqIds);
        }
        ((JSONObject)localObject).put("folder_status", paramKandianRedDotInfo.forderStatus);
        ((JSONObject)localObject).put("report_time", NetConnInfoCenter.getServerTimeMillis());
        ((JSONObject)localObject).put("articleID", paramKandianRedDotInfo.articleIDList.get(0));
        ndn.a(null, "CliOper", "", "", "0X80081DB", "0X80081DB", 0, 0, "", paramKandianRedDotInfo.articleIDList.get(0) + "", paramKandianRedDotInfo.strategyID + "", ((JSONObject)localObject).toString(), false);
        ohp.a(41, Integer.valueOf(paramKandianRedDotInfo.forderStatus).intValue(), (int)paramKandianRedDotInfo.algorithmID, (int)paramKandianRedDotInfo.strategyID);
        localObject = new ReportInfo();
        ((ReportInfo)localObject).mUin = a();
        ((ReportInfo)localObject).mSourceArticleId = ((Long)paramKandianRedDotInfo.articleIDList.get(0)).longValue();
        ((ReportInfo)localObject).mAlgorithmId = ((int)paramKandianRedDotInfo.algorithmID);
        ((ReportInfo)localObject).mStrategyId = ((int)paramKandianRedDotInfo.strategyID);
        ((ReportInfo)localObject).mOperation = 55;
        ((ReportInfo)localObject).mFolderStatus = Integer.valueOf(paramKandianRedDotInfo.forderStatus).intValue();
        paramKandianRedDotInfo = new ArrayList();
        paramKandianRedDotInfo.add(localObject);
        ogy.a().a(paramKandianRedDotInfo);
      }
      return;
    }
    catch (Exception paramKandianRedDotInfo)
    {
      QLog.e("ReadInJoyUtils", 1, paramKandianRedDotInfo, new Object[0]);
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
      if ((Build.VERSION.SDK_INT < 23) || (azzu.b()) || (azzu.d())) {
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
    if (!azzu.d())
    {
      paramBaseActivity.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    paramBaseActivity.mSystemBarComp.setStatusBarColor(paramInt);
    paramBaseActivity.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public static void a(BaseActivity paramBaseActivity, View paramView)
  {
    awrn.a(paramBaseActivity).a(a(), "actReadInJoyDDShowPopupMenu", true, 0L, 0L, null, "");
    ArrayList localArrayList = new ArrayList();
    a(bgmq.r(a()), localArrayList);
    if (localArrayList.size() == 0) {
      a(31, localArrayList);
    }
    bemi.a(paramBaseActivity, localArrayList, new occ(paramBaseActivity), new ocd(), aciy.a(125.0F, paramBaseActivity.getResources()), false, 2130842181, 2131689492).showAsDropDown(paramView);
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
    int k;
    if (paramMessageRecord != null)
    {
      if (!paramMessageRecord.isread) {
        break label152;
      }
      k = 1;
    }
    for (;;)
    {
      a(k);
      jdField_a_of_type_Ppp.jdField_a_of_type_Int = k;
      jdField_a_of_type_Ppp.jdField_a_of_type_JavaLangString = ((String)localObject1);
      jdField_a_of_type_Ppp.jdField_b_of_type_JavaLangString = paramQQAppInterface;
      jdField_a_of_type_Ppp.jdField_c_of_type_JavaLangString = ((String)localObject2);
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
              jdField_a_of_type_Ppp.jdField_a_of_type_Long = paramQQAppInterface.optLong("sp_last_kadnian_red_pnt_exposure_time_key", 0L);
              long l = paramQQAppInterface.optLong("sp_last_locksc_kadnian_red_pnt_exposure_time_key", -1L);
              if (l > 0L) {
                jdField_a_of_type_Ppp.jdField_a_of_type_Long = l;
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
            jdField_a_of_type_Ppp.jdField_b_of_type_Long = paramMessageRecord.time;
            return;
            if ((paramMessageRecord.extInt != 1) && (paramMessageRecord.extInt != 3)) {
              continue;
            }
            if ((localObject3 != null) && (((KandianMergeManager)localObject3).a(paramMessageRecord) == 1))
            {
              k = 5;
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
                    k = Integer.parseInt(localMessageForStructing.structingMsg.reportEventFolderStatusValue);
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
          k = 3;
          paramQQAppInterface = (QQAppInterface)localObject6;
          localObject1 = localObject5;
          localObject2 = localObject4;
          break;
          if ((paramMessageRecord.extInt == 2) || (paramMessageRecord.extInt == 4))
          {
            k = 2;
            break;
          }
          if (paramMessageRecord.extInt == 5)
          {
            k = 6;
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
            k = ((JSONObject)localObject6).getInt("folder_status");
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
            k = 10;
            paramQQAppInterface = (QQAppInterface)localObject5;
            localObject1 = localObject4;
          }
        }
        break;
        jdField_a_of_type_Ppp.jdField_a_of_type_Long = 0L;
      }
      label578:
      k = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (!bgmq.i()) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyUtils.17(paramQQAppInterface));
    ThreadManager.executeOnSubThread(new ReadInJoyUtils.18(paramRedTypeInfo, paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    paramQQAppInterface = paramQQAppInterface.c();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      SettingCloneUtil.writeValue(localMobileQQ, paramQQAppInterface, null, "qqsetting_kandian_key", paramBoolean);
      return;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_Ppp.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public static void a(String paramString)
  {
    Object localObject = bgmq.a(a(), true, false);
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
      bgmq.a((SharedPreferences.Editor)localObject, true);
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
      ndn.a(null, null, "0X8009CCD", "0X8009CCD", 0, 0, "", "", "", localJSONObject.toString(), false);
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
        ndn.a(null, "", paramString1, paramString1, 0, 0, String.valueOf(paramLong), str, paramString2, "", false);
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
    long l = bgmq.a();
    if ((l != -1L) && (System.currentTimeMillis() - l < 600000L)) {}
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
        localObject = paramQQAppInterface.a();
      } while (localObject == null);
      localObject = ((QQMessageFacade)localObject).a();
    } while ((localObject == null) || (((akaq)localObject).a(paramString, 1008) <= 0));
    ThreadManager.post(new ReadInJoyUtils.21(paramString, paramQQAppInterface), 8, null, false);
  }
  
  public static void a(String paramString, Object paramObject, boolean paramBoolean)
  {
    if (!(paramObject instanceof Serializable)) {
      throw new RuntimeException("the data obj must implement Serializable interface ! ");
    }
    ThreadManager.executeOnFileThread(new ReadInJoyUtils.10(paramObject, paramBoolean, paramString));
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
      ndn.a(null, "", "0X8008C5D", "0X8008C5D", 0, 0, "", "", "", paramString1, false);
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
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, ocf paramocf)
  {
    ThreadManager.executeOnNetWorkThread(new ReadInJoyUtils.14(paramString4, paramString3, paramString2, paramString1, paramocf));
  }
  
  public static void a(String paramString, pov parampov, qmv paramqmv)
  {
    if (parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {}
    long l;
    do
    {
      return;
      l = parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
      localObject1 = pcj.a(l);
    } while (localObject1 == null);
    paramqmv = new qmv(paramqmv.a().a());
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
            paramqmv.a((String)localEntry.getKey(), localEntry.getValue().toString());
          }
        }
        QLog.d("ReadInJoyUtils", 1, "reportArticleItemExpose: " + localArticleInfo + "  bean :" + localArticleInfo.mProteusTemplateBean.getDataAttribute(null));
      }
      for (;;)
      {
        ndn.a(null, "CliOper", "", parampov.jdField_d_of_type_JavaLangString, paramString, paramString, 0, 0, Long.toString(parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(parampov.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(parampov.jdField_b_of_type_Int), paramqmv.a().a(), false);
        break;
        QLog.d("ReadInJoyUtils", 1, "reportArticleItemExpose: " + localArticleInfo);
      }
    }
    pcj.a(l);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.executeOnFileThread(new ReadInJoyUtils.9(paramBoolean, paramString));
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
    awrn.a(paramAppRuntime.getApplication()).a(null, "actKandianRefreshBackEndTrace", true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("LOOP_ERROR_CODE", Integer.toString(paramInt));
    awrn.a(paramAppRuntime.getApplication()).a(null, "actWebRenderLoopEvent", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("LOOP_STEP", Integer.toString(paramInt));
    localHashMap.put("LOOP_STEP_COST", Long.toString(paramLong));
    awrn.a(paramAppRuntime.getApplication()).a(null, "actWebRenderLoopEventCost", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramLong < 0L) || (paramLong > 30000L)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt));
    awrn.a(paramAppRuntime.getApplication()).a(null, "actKandianGetShareJsonSuccAndCost", paramBoolean, paramLong, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt1));
    localHashMap.put("param_OpCode", String.valueOf(paramInt2));
    awrn.a(paramAppRuntime.getApplication()).a(null, "actKandian0x83eResult", paramBoolean, paramLong, 0L, localHashMap, null);
    QLog.d("ReadInJoyUtils", 1, "reportKandian83eMonitorData| actKandian0x83eResult | retCode ： " + paramInt1 + "| param_OpCode : " + paramInt2);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if ((paramAppRuntime == null) || (paramLong < 0L) || (paramLong > 50000L)) {
      return;
    }
    awrn.a(paramAppRuntime.getApplication()).a(a(), "actKandianRefreshSuccAndCost", paramBoolean, paramLong, 0L, paramHashMap, null);
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
    awrn.a(paramAppRuntime.getApplication()).a(null, "actreportWebRenderPluginEventCost", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return;
    }
    awrn.a(paramAppRuntime.getApplication()).a(null, "actKanDianViolaData", paramBoolean, -1L, -1L, paramHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramAppRuntime == null) {
      return;
    }
    ThreadManager.post(new ReadInJoyUtils.7(paramJSONObject, paramAppRuntime, paramBoolean), 5, null, true);
  }
  
  public static void a(nis paramnis)
  {
    if (paramnis == null) {
      return;
    }
    ndn.a(null, null, "0X8009BD4", "0X8009BD4", 0, 0, "", "", "", paramnis.a(), false);
  }
  
  public static void a(nis paramnis, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramnis != null) && (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      b(paramnis, paramBaseArticleInfo);
      a(paramnis);
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
        if (qoe.a(paramArticleInfo))
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
          if ((localSocializeFeedsInfo == null) || (localSocializeFeedsInfo.jdField_a_of_type_Pqo == null)) {
            continue;
          }
          paramJSONObject.put("feeds_source", localSocializeFeedsInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long);
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
  
  public static void a(JSONObject paramJSONObject, nis paramnis)
  {
    if ((paramJSONObject == null) || (paramnis == null)) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramnis.jdField_b_of_type_JavaLangString)) {}
      for (;;)
      {
        QLog.d("ReadInJoyUtils", 1, "bindMedalData : " + paramJSONObject.toString());
        return;
        if ((paramnis.jdField_c_of_type_Int > 0) && (paramnis.jdField_d_of_type_Int > 0))
        {
          paramJSONObject.put("header_medal_jump_url", paramnis.jdField_c_of_type_JavaLangString);
          paramJSONObject.put("header_medal_wh_rate", Double.valueOf(paramnis.jdField_c_of_type_Int).doubleValue() / paramnis.jdField_d_of_type_Int);
          paramJSONObject.put("header_medal_image_url", paramnis.jdField_b_of_type_JavaLangString);
        }
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public static void a(pov parampov, String paramString1, String paramString2)
  {
    if ((parampov == null) || (parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {}
    for (;;)
    {
      return;
      try
      {
        if ((pcj.a() != null) && (parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo != null) && (parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null))
        {
          paramString1 = new JSONObject(paramString1);
          if (parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean != null)
          {
            localObject1 = parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getDataAttribute(null);
            if ((localObject1 != null) && (((Map)localObject1).entrySet() != null))
            {
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while ((localObject1 != null) && (((Iterator)localObject1).hasNext()))
              {
                localObject2 = (Map.Entry)((Iterator)localObject1).next();
                paramString1.put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue().toString());
              }
            }
          }
          Object localObject1 = parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList;
          Object localObject2 = pcj.a().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Integer localInteger = (Integer)((Iterator)localObject2).next();
            if ((localInteger.intValue() < ((List)localObject1).size()) && (((List)localObject1).get(localInteger.intValue()) != null))
            {
              paramString1.put("rowkey", ((ppv)((List)localObject1).get(localInteger.intValue())).jdField_g_of_type_JavaLangString);
              ndn.a(null, "CliOper", "", parampov.jdField_d_of_type_JavaLangString, paramString2, paramString2, 0, 0, Long.toString(parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(parampov.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(parampov.jdField_b_of_type_Int), paramString1.toString(), false);
            }
          }
          pcj.a();
          return;
        }
      }
      catch (JSONException parampov) {}
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int m = 1;
    Object localObject1 = (QQAppInterface)a();
    if (localObject1 == null) {}
    label158:
    label161:
    for (;;)
    {
      return;
      localObject1 = ((QQAppInterface)localObject1).a();
      if (localObject1 != null)
      {
        Object localObject2 = ((QQMessageFacade)localObject1).b(ajed.az, 7220);
        if (localObject2 != null)
        {
          if ((localObject2 instanceof MessageForStructing))
          {
            localObject1 = (MessageForStructing)localObject2;
            if (((MessageForStructing)localObject1).structingMsg == null) {
              ((MessageForStructing)localObject1).parse();
            }
          }
          int k;
          if (!paramBoolean)
          {
            k = 1;
            if (((MessageRecord)localObject2).isread) {
              break label158;
            }
          }
          for (;;)
          {
            if ((k | m) == 0) {
              break label161;
            }
            localObject1 = ((MessageRecord)localObject2).senderuin;
            try
            {
              localObject2 = new JSONObject(((MessageRecord)localObject2).extStr);
              if (((JSONObject)localObject2).has("kdUin")) {
                localObject1 = ((JSONObject)localObject2).getString("kdUin");
              }
              paramJSONObject.put("feeds_source", localObject1);
              return;
            }
            catch (Exception paramJSONObject)
            {
              paramJSONObject.printStackTrace();
              return;
            }
            k = 0;
            break;
            m = 0;
          }
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject, pov parampov)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      parampov = new qmv(null, null, null, null).W(Integer.valueOf("1031").intValue()).s(paramJSONObject.optString("double_videocard_jump_page")).t(paramJSONObject.optString("double_videocard_jump_src")).f(parampov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      String str;
      if (paramBoolean)
      {
        str = paramJSONObject.optString("column_id");
        if (!TextUtils.isEmpty(str)) {
          parampov.a("columnId", str);
        }
        parampov.h(paramJSONObject.optString("all_rowkey"));
        parampov.u(paramJSONObject.optString("subscript"));
        ndn.a(null, null, "0X800A5A8", "0X800A5A8", 0, 0, "", "", "", parampov.a().a(), false);
        return;
      }
      int k = 0;
      while (k < 2)
      {
        str = paramJSONObject.optString("columnId_" + (k + 1));
        if (!TextUtils.isEmpty(str)) {
          parampov.a("columnId", str);
        }
        parampov.h(paramJSONObject.optString("rowKey_" + (k + 1)));
        parampov.u(paramJSONObject.optString("subscript_" + (k + 1)));
        parampov.ab(k);
        ndn.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", parampov.a().a(), false);
        k += 1;
      }
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString1, String paramString2)
  {
    ThreadManagerV2.executeOnSubThread(new ReadInJoyUtils.5(paramBoolean2, paramInt1, paramInt3, paramInt2, paramLong, paramString1, paramBoolean1, paramString2));
  }
  
  public static boolean a()
  {
    return (a() instanceof QQAppInterface);
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
      float f1 = bgmq.b(a());
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
    while ((paramContext.isBackground_Pause) || (paramContext.isBackground_Stop)) {
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
    if ((paramBaseArticleInfo.mChannelID != 0L) && (!odm.c((int)paramBaseArticleInfo.mChannelID))) {
      QLog.e("ReadInJoyUtils", 1, "judgeShouldNoDifferenceJumpToApp channelID: " + paramBaseArticleInfo.mChannelID);
    }
    int k;
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
        boolean bool2 = bgmq.x();
        if (!bool2)
        {
          QLog.e("ReadInJoyUtils", 1, "judgeShouldNoDifferenceJumpToApp is not first no difference jump app today.");
          return false;
        }
        k = qoe.c((ArticleInfo)paramBaseArticleInfo);
        int m;
        int n;
        boolean bool3;
        if ((paramBaseArticleInfo.mFeedType == 0) && ((k == 1) || (k == 2) || (k == 3) || (k == 4) || (k == 6)))
        {
          m = 1;
          if ((paramBaseArticleInfo.mFeedType != 29) || ((!paramString.equalsIgnoreCase("ReadInjoy_daily_small_img_cell")) && (!paramString.equalsIgnoreCase("ReadInjoy_daily_triple_img_cell")) && (!paramString.equalsIgnoreCase("ReadInjoy_daily_large_img_cell")))) {
            break label333;
          }
          n = 1;
          if (localAladdinConfig.getIntegerFromString("no_difference_jump_app_switch", 0) != 1) {
            break label339;
          }
          k = 1;
          if ((m == 0) && (n == 0)) {
            break label344;
          }
          m = 1;
          bool3 = TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptText);
          if (paramBaseArticleInfo.isSuperTop != 0) {
            break label350;
          }
          n = 1;
          if ((TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl)) || ((!paramBaseArticleInfo.mArticleContentUrl.startsWith("mqqapi")) && (!paramBaseArticleInfo.mArticleContentUrl.contains("target=4")))) {
            break label356;
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((k == 0) || (!bool2) || (m == 0) || (!bool3) || (n == 0) || (i1 != 0)) {
            break label360;
          }
          k = localAladdinConfig.getIntegerFromString("no_difference_jump_app_type", 0);
          paramBaseArticleInfo = localAladdinConfig.getString("no_difference_jump_app_package_name", "");
          if (k != 0) {
            break label362;
          }
          return true;
          m = 0;
          break;
          n = 0;
          break label185;
          k = 0;
          break label200;
          m = 0;
          break label213;
          n = 0;
          break label232;
        }
      }
      if (k == 1)
      {
        if (!bady.a(paramContext, paramBaseArticleInfo)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (k != 2);
    label333:
    label339:
    label344:
    label350:
    label356:
    return bady.a(paramContext, paramBaseArticleInfo);
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    return pmu.b(qoe.c(paramArticleInfo));
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
    if (!SettingCloneUtil.readValue(paramQQAppInterface.getApplication(), paramQQAppInterface.c(), null, "qqsetting_kandian_key", true)) {}
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
  
  @Deprecated
  public static boolean a(String paramString)
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
  
  public static boolean a(String paramString, long paramLong, int paramInt, ArticleInfo paramArticleInfo)
  {
    if (!bgmq.y(a())) {}
    while (((paramArticleInfo instanceof AdvertisementInfo)) || (paramLong == 1000000L)) {
      return false;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = befm.a(paramString);
      if (paramString.containsKey("article_type")) {
        return TextUtils.equals("1", (CharSequence)paramString.get("article_type"));
      }
    }
    return q(paramArticleInfo);
  }
  
  public static boolean a(pre parampre)
  {
    return (parampre != null) && (parampre.jdField_a_of_type_Pqm != null) && (parampre.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList != null) && ((parampre.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList.size() > 1) || ((parampre.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList.size() == 1) && (!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)parampre.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString))));
  }
  
  public static int[] a(Activity paramActivity)
  {
    Object localObject = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    int m;
    int k;
    if (Build.VERSION.SDK_INT >= 17)
    {
      ((Display)localObject).getRealSize(localPoint);
      m = localPoint.x;
      k = localPoint.y;
    }
    for (;;)
    {
      return new int[] { m, k };
      if (Build.VERSION.SDK_INT >= 15)
      {
        ((Display)localObject).getSize(localPoint);
        m = localPoint.x;
        k = localPoint.y;
      }
      else
      {
        localObject = new DisplayMetrics();
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        m = ((DisplayMetrics)localObject).widthPixels;
        k = ((DisplayMetrics)localObject).heightPixels;
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
          paramString = obj.a();
          if (!b(paramBaseArticleInfo)) {
            break label211;
          }
          k = paramBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
          if (k == 2)
          {
            paramString = obj.b();
            break label216;
            if (k < localJSONArray.length())
            {
              paramBaseArticleInfo = localJSONArray.optJSONObject(k).optString("picture");
              if (TextUtils.isEmpty(paramBaseArticleInfo)) {
                break label221;
              }
              if (!a(paramBaseArticleInfo)) {
                break label208;
              }
              paramBaseArticleInfo = a(paramBaseArticleInfo, ((Integer)paramString.second).intValue(), ((Integer)paramString.first).intValue(), 1);
              arrayOfURL[k] = rsl.a(paramBaseArticleInfo, 3);
              break label221;
            }
          }
          else
          {
            if (k == 3)
            {
              paramString = obj.d();
              break label216;
            }
            if (k != 1) {
              break label211;
            }
            paramString = obj.c();
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
      int k = 0;
      continue;
      label221:
      k += 1;
    }
  }
  
  public static int b()
  {
    int k = 0;
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
      m = localException.size();
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + localException.toString());
      return -1;
    }
    int m;
    int n;
    if (m > jdField_a_of_type_Int)
    {
      m = jdField_a_of_type_Int;
      break label243;
      if (n < m)
      {
        localObject1 = (RecentBaseData)localException.get(n);
        if (localObject1 != null)
        {
          localObject1 = (RecentUserBaseData)localObject1;
          if (!TextUtils.equals(((RecentUserBaseData)localObject1).a(), ajed.az))
          {
            if (((RecentUserBaseData)localObject1).a() == 5000) {
              break label248;
            }
            if (((RecentUserBaseData)localObject1).b() > 0)
            {
              int i1 = ((RecentUserBaseData)localObject1).b();
              k = i1 + k;
              break label248;
            }
          }
        }
      }
      else
      {
        return k;
      }
    }
    for (;;)
    {
      label243:
      n = 0;
      break;
      label248:
      n += 1;
      break;
    }
  }
  
  public static int b(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (qoe.f(paramArticleInfo)) {
      if (qoe.d(paramArticleInfo)) {
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
        if (d(paramArticleInfo)) {
          return 6;
        }
        if (p(paramArticleInfo)) {
          return 10;
        }
      } while (!o(paramArticleInfo));
      return 8;
      if ((!qoe.a(paramArticleInfo)) && (paramArticleInfo.mFeedType != 10)) {
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
    ppv localppv = (ppv)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    if (v(paramBaseArticleInfo)) {
      return 79;
    }
    if (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 15) {
      return 131;
    }
    if (localppv.jdField_b_of_type_Int == 10) {
      return 78;
    }
    if ((localppv.jdField_b_of_type_Int == 4) || (localppv.jdField_b_of_type_Int == 5)) {
      return 76;
    }
    if ((localppv.jdField_b_of_type_Int == 6) || (localppv.jdField_b_of_type_Int == 7) || (localppv.jdField_b_of_type_Int == 8) || (localppv.jdField_b_of_type_Int == 9) || (localppv.jdField_b_of_type_Int == 12)) {
      return 77;
    }
    if (localppv.jdField_b_of_type_Int == 0) {
      return 77;
    }
    QLog.e("FeedItemCellTypeNewPolymericBaseHeader", 1, "新聚合类卡片没有找到对应的FeedCell feedType = " + localppv.jdField_b_of_type_Int);
    return 77;
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
    return a(-1L);
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
      ((JSONObject)localObject).put("kandian_mode_new", new.a());
      ((JSONObject)localObject).put("tab_source", d());
      ((JSONObject)localObject).put("session_id", jdField_e_of_type_JavaLangString);
      ((JSONObject)localObject).put("os", 1);
      ((JSONObject)localObject).put("version", new.jdField_a_of_type_JavaLangString);
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
      ((JSONObject)localObject).put("session_id", jdField_e_of_type_JavaLangString);
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
    f(paramContext);
    return jdField_h_of_type_JavaLangString;
  }
  
  public static String b(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.a())) {
      return "1";
    }
    return "0";
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
      paramBaseArticleInfo = rmb.d(paramBaseArticleInfo.mCardJumpUrl);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "shortContentUrl: " + paramBaseArticleInfo);
      }
    } while (!rjb.b(paramBaseArticleInfo));
    return rjb.b(paramBaseArticleInfo);
  }
  
  public static String b(String paramString)
  {
    return a(paramString, "");
  }
  
  public static String b(String paramString, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramString;
    if (paramBaseArticleInfo != null) {}
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mqqapi://readinjoy/open?src_type=internal&target=3").append("&channelID=").append(paramBaseArticleInfo.mChannelID).append("&strategyId=").append(paramBaseArticleInfo.mStrategyId).append("&algorithmID=").append(paramBaseArticleInfo.mAlgorithmID).append("&title=").append(paramBaseArticleInfo.mTitle).append("&firstPagePicUrl=").append(URLEncoder.encode(paramBaseArticleInfo.mFirstPagePicUrl, "UTF-8")).append("&articleID=").append(paramBaseArticleInfo.mArticleID).append("&subscribeName=").append(paramBaseArticleInfo.mSubscribeName).append("&rowKey=").append(paramBaseArticleInfo.innerUniqueID).append("&subscribeID=").append(paramBaseArticleInfo.mSubscribeID).append("&articleContentUrl=").append(URLEncoder.encode(paramString, "UTF-8")).append("&").append("readinjoyNotDecodeUrl=1");
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
  
  public static URL b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (a(paramString))
    {
      localObject = obj.c();
      localObject = a(paramString, ((Integer)((android.util.Pair)localObject).second).intValue(), ((Integer)((android.util.Pair)localObject).first).intValue(), 3);
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
          if ((((RecentUserBaseData)localObject2).mUser != null) && (((RecentUserBaseData)localObject2).mUser.getType() == 1008) && (rol.b(localQQAppInterface, ((RecentUserBaseData)localObject2).mUser.uin))) {
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
      localJSONObject.put("kandian_mode_new", new.a());
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
  
  public static void b(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    int k;
    if (paramArticleInfo.hasChannelInfo())
    {
      k = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label527;
      }
    }
    Object localObject1;
    Object localObject2;
    label527:
    for (int m = 0;; m = 1)
    {
      localObject1 = c(paramArticleInfo);
      ndn.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, k), false);
      ndn.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, k));
      localObject2 = rvf.b(paramInt);
      ndn.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, k, m, badq.h(paramContext), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, e(paramArticleInfo), paramArticleInfo), false);
      ndn.a((String)localObject2, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, k, m, badq.h(paramContext), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, e(paramArticleInfo), paramArticleInfo));
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
      localObject2 = new pqg();
      ((pqg)localObject2).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo != null) {
        ((pqg)localObject2).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
      }
      ((pqg)localObject2).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((pqg)localObject2).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramArticleInfo == null) || (paramArticleInfo.isEmpty())) {
        break label533;
      }
      ((pqg)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
      paramArticleInfo = paramArticleInfo.iterator();
      while (paramArticleInfo.hasNext())
      {
        pqo localpqo = (pqo)paramArticleInfo.next();
        if (localpqo != null) {
          ((pqg)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localpqo.jdField_a_of_type_Long));
        }
      }
      k = 0;
      break;
    }
    label533:
    ((ReportInfo)localObject1).mFeedsReportData = ((pqg)localObject2);
    label540:
    paramContext.add(localObject1);
    ogy.a().a(paramContext);
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
    paramString.putExtra("selfSet_leftViewText", ajjy.a(2131647317));
    ((Context)localObject).startActivity(paramString);
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(a(paramContext)));
    awrn.a(paramContext).a(paramString, "actKandianVideoPreload", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (TextUtils.isEmpty(paramBaseArticleInfo.proteusItemsData))) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new JSONObject(paramBaseArticleInfo.proteusItemsData);
        QLog.d("ReadInJoyUtils", 2, new Object[] { "mArticleInfo.proteusItemsData = ", paramBaseArticleInfo.proteusItemsData });
        localObject = ((JSONObject)localObject).keys();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!"id_super_topic".equals((String)((Iterator)localObject).next()));
        paramBaseArticleInfo.isSuperTopic = true;
        return;
      }
      catch (JSONException paramBaseArticleInfo)
      {
        QLog.d("ReadInJoyUtils", 2, "preParseProteusItemData", paramBaseArticleInfo);
      }
    }
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mVideoColumnInfo == null)) {
      return;
    }
    ndn.a(null, null, "0X800A1C3", "0X800A1C3", 0, 0, "", "", "", new qmv(null, null, null, null).h(paramBaseArticleInfo.innerUniqueID).c(paramBaseArticleInfo).d(paramBaseArticleInfo).R(paramInt).a(paramBaseArticleInfo.videoReportInfo).a(paramBaseArticleInfo, false).a().a(), false);
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mGroupSubArticleList == null) || (paramBaseArticleInfo.mGroupSubArticleList.isEmpty())) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[");
    int m = paramBaseArticleInfo.mGroupSubArticleList.size();
    int k = 0;
    while (k < m)
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(k);
      String str = localBaseArticleInfo.getInnerUniqueID();
      int n = localBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Int;
      if (localBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Boolean)
      {
        localStringBuilder.append(str);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUtils", 2, "position：" + n + ", rowKey: " + str);
        }
      }
      if ((m != 1) && (k != m - 1)) {
        localStringBuilder.append(",");
      }
      k += 1;
    }
    localStringBuilder.append("]");
    ndn.a(null, null, "0X800A5AA", "0X800A5AA", 0, 0, "", "", "", new qmv(paramString, null, null, null, null).W(54).h(localStringBuilder.toString()).a().a(), false);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", paramQQAppInterface.getAccount());
    localHashMap.put("param_cpu", String.valueOf(babp.b()));
    localHashMap.put("param_totalMem", String.valueOf(babp.d()));
    localHashMap.put("param_availableMem", String.valueOf(babp.e()));
    localHashMap.put("param_version", "8.2.6");
    awrn.a(BaseApplication.getContext()).a(null, "actUserDeviceInfoReport", true, 100L, 0L, localHashMap, "", true);
  }
  
  public static void b(String paramString)
  {
    jdField_e_of_type_JavaLangString = paramString;
  }
  
  public static void b(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramLong < 0L) || (paramLong > 30000L)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt));
    awrn.a(paramAppRuntime.getApplication()).a(null, "actKandianGetUserInfoSuccAndCost", paramBoolean, paramLong, 0L, localHashMap, null);
  }
  
  public static void b(AppRuntime paramAppRuntime, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return;
    }
    awrn.a(paramAppRuntime.getApplication()).a(null, "actKanDianViolaHttpData", paramBoolean, -1L, -1L, paramHashMap, null, true);
  }
  
  public static void b(nis paramnis, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramnis != null) {}
    try
    {
      paramnis.jdField_d_of_type_JavaLangString = String.valueOf(paramBaseArticleInfo.mChannelID);
      paramnis.jdField_g_of_type_JavaLangString = String.valueOf(paramBaseArticleInfo.mFeedId);
      paramBaseArticleInfo = (ArticleInfo)paramBaseArticleInfo;
      paramnis.jdField_h_of_type_JavaLangString = String.valueOf(paramBaseArticleInfo.mSubscribeID);
      if ((qoe.a(paramBaseArticleInfo)) || (qoe.a(paramBaseArticleInfo))) {
        paramnis.jdField_f_of_type_JavaLangString = "5";
      }
      for (;;)
      {
        paramnis.jdField_e_of_type_JavaLangString = "2";
        return;
        if (qoe.e(paramBaseArticleInfo)) {
          paramnis.jdField_f_of_type_JavaLangString = "4";
        } else {
          paramnis.jdField_f_of_type_JavaLangString = "0";
        }
      }
      return;
    }
    catch (Exception paramnis) {}
  }
  
  public static void b(boolean paramBoolean)
  {
    for (;;)
    {
      int k;
      try
      {
        if (a() == null) {
          break label241;
        }
        if (!bgmq.i()) {
          return;
        }
        Object localObject = (KandianMergeManager)a().getManager(162);
        JSONObject localJSONObject = a();
        if ((!((KandianMergeManager)localObject).a()) && (!((KandianMergeManager)localObject).i()))
        {
          k = 1;
          if (k != 3) {
            break label225;
          }
          localObject = ((KandianMergeManager)localObject).f() + "";
          localJSONObject.put("tab_status", k);
          localJSONObject.put("kandian_mode_new", new.a());
          if (k == 3) {
            localJSONObject.put("reddot_num", localObject);
          }
          a(true, localJSONObject);
          if (jdField_g_of_type_Int != 0) {
            break label231;
          }
          k = 0;
          localJSONObject.put("button_state", k);
          localJSONObject.put("os", 1);
          localJSONObject.put("version", new.jdField_a_of_type_JavaLangString);
          if (!ReadinjoyTabFrame.c_()) {
            break label236;
          }
          k = 1;
          localJSONObject.put("isInKandian", k);
          ndn.a(null, "CliOper", "", null, "0X80081C3", "0X80081C3", 0, 1, null, g(jdField_a_of_type_Ppp.jdField_c_of_type_JavaLangString), jdField_a_of_type_Ppp.jdField_b_of_type_JavaLangString, localJSONObject.toString(), false);
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
        k = 3;
        continue;
        label225:
        String str = "0";
        continue;
        label231:
        k = 1;
        continue;
        label236:
        k = 0;
      }
      else
      {
        label241:
        k = 2;
      }
    }
  }
  
  public static boolean b()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    return (localBaseActivity != null) && (((localBaseActivity instanceof ReadInJoyNewFeedsActivity)) || ((localBaseActivity instanceof FastWebActivity)) || (localBaseActivity.getClass().getSimpleName().toLowerCase().contains("kandian")) || (localBaseActivity.getClass().getSimpleName().toLowerCase().contains("readinjoy")));
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool = false;
    int k;
    if ((paramInt != 5) && (paramInt != 6))
    {
      if (paramInt != 43) {
        break label39;
      }
      k = 1;
      if (paramInt != 18) {
        break label44;
      }
    }
    label39:
    label44:
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramInt | k) != 0) {
        bool = true;
      }
      return bool;
      k = 0;
      break;
    }
  }
  
  public static boolean b(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 3) {}
    do
    {
      return true;
      if ((Aladdin.getConfig(254).getIntegerFromString("is_fix_below_15min_click_flag", 0) == 1) && (paramInt1 == 0) && (rvf.a())) {
        return false;
      }
    } while (Aladdin.getConfig(251).getIntegerFromString("bt_fix", 0) != 1);
    return false;
  }
  
  public static boolean b(long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = System.currentTimeMillis();
    }
    paramLong = l - bgmq.a((QQAppInterface)a());
    if (QLog.isColorLevel()) {
      if (paramLong >= obl.jdField_a_of_type_Int) {
        break label90;
      }
    }
    label90:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ReadInJoyUtils", 2, new Object[] { "isNeedToRememberHistoryPos, timeInterval = ", Long.valueOf(paramLong), " , isNeedToRemember = ", Boolean.valueOf(bool) });
      if (paramLong >= obl.jdField_a_of_type_Int) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 17) {
      return false;
    }
    return true;
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return false;
    }
    if ((paramBaseArticleInfo.mFeedType == 0) && (paramBaseArticleInfo.mIsGallery > 0) && (paramBaseArticleInfo.mGalleryFeedsInfo != null))
    {
      int k = paramBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
      if ((k == 3) || (k == 2) || (k == 1))
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
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(ajed.az, 7220);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isread)) {
        return true;
      }
    }
    return false;
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
          int k = new JSONObject(paramMessageRecord.structingMsg.mExtraData).optInt("keyguard_jump", 1);
          if (k != 1) {
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
  
  public static boolean b(String paramString)
  {
    Object localObject1 = new ArrayList();
    label50:
    int k;
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
                break label50;
              }
              ((List)localObject1).add((RecentBaseData)localObject3);
              break label50;
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
      if (TextUtils.equals(((RecentUserBaseData)localObject2).a(), paramString)) {
        return true;
      }
      k = ((RecentUserBaseData)localObject2).mMenuFlag;
    } while ((k & 0x20) != 0);
    return false;
  }
  
  public static int c()
  {
    try
    {
      jdField_b_of_type_Int += 1;
      int k = jdField_b_of_type_Int;
      return k;
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
    int k = 1;
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      if (bgmq.I(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
      for (;;)
      {
        ((JSONObject)localObject).put("reddot_style", k);
        ((JSONObject)localObject).put("kandian_mode", e());
        ((JSONObject)localObject).put("kandian_mode_new", new.a());
        ((JSONObject)localObject).put("tab_source", d());
        ((JSONObject)localObject).put("session_id", jdField_e_of_type_JavaLangString);
        localObject = ((JSONObject)localObject).toString();
        return localObject;
        k = 0;
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
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
      ((JSONObject)localObject).put("session_id", jdField_e_of_type_JavaLangString);
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
    Object localObject2 = obb.jdField_e_of_type_JavaLangString;
    Object localObject1 = "";
    if (((String)localObject2).contains("uin")) {
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long > 0L)) {
        localObject1 = String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long);
      }
    }
    for (localObject1 = ((String)localObject2).replace("uin=", "uin=" + baaw.encodeToString(((String)localObject1).getBytes(), 0).replace('\n', ' ').trim());; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if (((String)localObject1).contains("&feedstype=")) {
        localObject2 = ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mFeedType);
      }
      paramArticleInfo = (String)localObject2 + String.valueOf(paramArticleInfo.mFeedId);
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
    Object localObject2 = "";
    Object localObject1;
    if (a((ArticleInfo)paramBaseArticleInfo))
    {
      localObject1 = localObject2;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        localObject1 = localObject2;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo != null) {
          localObject1 = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          if (pmu.a((ArticleInfo)paramBaseArticleInfo) == 2)
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).addAll(((articlesummary.FriendRecommendInfo)paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
            paramBaseArticleInfo = "";
            int k = 0;
            while (k < ((ArrayList)localObject2).size())
            {
              localObject1 = paramBaseArticleInfo + ((ArrayList)localObject2).get(k);
              paramBaseArticleInfo = (BaseArticleInfo)localObject1;
              if (k != ((ArrayList)localObject2).size() - 1) {
                paramBaseArticleInfo = (String)localObject1 + ",";
              }
              k += 1;
            }
            return paramBaseArticleInfo;
          }
          if (pmu.a((ArticleInfo)paramBaseArticleInfo) == 1) {
            return ((articlesummary.SpecialTopicInfo)paramBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
          }
          if (pmu.a((ArticleInfo)paramBaseArticleInfo) == 3) {
            return paramBaseArticleInfo.mSubscribeID;
          }
          if (qoe.a((ArticleInfo)paramBaseArticleInfo)) {
            return paramBaseArticleInfo.mSubscribeID;
          }
          if ((!qoe.a((ArticleInfo)paramBaseArticleInfo)) && (!qoe.i((ArticleInfo)paramBaseArticleInfo)) && (!qoe.j((ArticleInfo)paramBaseArticleInfo)) && (!qoe.k((ArticleInfo)paramBaseArticleInfo))) {
            break;
          }
          localObject1 = localObject2;
        } while (paramBaseArticleInfo.mSocialFeedInfo == null);
        localObject1 = localObject2;
      } while (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo == null);
      return String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long);
      if (qoe.c((ArticleInfo)paramBaseArticleInfo)) {
        return paramBaseArticleInfo.mSubscribeID;
      }
      if (qoe.n((ArticleInfo)paramBaseArticleInfo)) {
        return paramBaseArticleInfo.mSubscribeID;
      }
      if (s(paramBaseArticleInfo)) {
        return paramBaseArticleInfo.mSubscribeID;
      }
      if (paramBaseArticleInfo.isPGCShortContent()) {
        return paramBaseArticleInfo.mSubscribeID;
      }
      localObject1 = localObject2;
    } while (!paramBaseArticleInfo.isAccountShown);
    return paramBaseArticleInfo.mSubscribeID;
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (paramString.length() < 8) {
      return paramString + "|" + paramString.length();
    }
    return paramString.substring(0, 8) + "|" + paramString.length();
  }
  
  public static String c(String paramString, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramString;
    if (paramBaseArticleInfo != null) {}
    try
    {
      localObject = new StringBuilder(paramString);
      ((StringBuilder)localObject).append("&videoType=").append(paramBaseArticleInfo.busiType).append("&videoVid=").append(paramBaseArticleInfo.mVideoVid).append("&videoWidth=").append(paramBaseArticleInfo.mVideoJsonWidth).append("&videoHeight=").append(paramBaseArticleInfo.mVideoJsonHeight).append("&videoDuration=").append(paramBaseArticleInfo.mVideoDuration).append("&title=").append(paramBaseArticleInfo.mTitle).append("&firstPagePicUrl=").append(URLEncoder.encode(paramBaseArticleInfo.mVideoCoverUrl.getPath(), "UTF-8")).append("&articleContentUrl=").append(URLEncoder.encode(paramBaseArticleInfo.mArticleContentUrl, "UTF-8")).append("&subscribeName=").append(paramBaseArticleInfo.mSubscribeName).append("&subscribeID=").append(paramBaseArticleInfo.mSubscribeID).append("&readinjoyNotDecodeUrl=1");
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.d("ReadInJoyUtils", 2, paramBaseArticleInfo.getMessage());
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
        rjb.a(paramContext, ajjy.a(2131647065), (String)localObject, localBundle, new oca(paramContext, paramString));
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
      rjb.a(paramContext, ajjy.a(2131647041), (String)localObject, localBundle, new ocb(paramContext, paramString));
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
    awrn.a(paramContext).a(paramString, "actKandianVideoGetUrl", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (jdField_h_of_type_Boolean)
    {
      jdField_h_of_type_Boolean = false;
      h();
    }
    if (bgmq.k())
    {
      ogy.a().d(0);
      ogy.a().d(56);
      ogy.a().e(40677);
      if (odm.b(odm.b())) {
        ogy.a().d(odm.b());
      }
    }
    jdField_g_of_type_Boolean = true;
    ThreadManager.post(new ReadInJoyUtils.3(paramQQAppInterface), 8, null, false);
  }
  
  public static void c(String paramString)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("tab_source", paramString);
      paramString = localJSONObject.toString();
      ndn.a(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", paramString, false);
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
  
  public static void c(AppRuntime paramAppRuntime, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return;
    }
    awrn.a(paramAppRuntime.getApplication()).a(null, "actKanDianViolaJsError", paramBoolean, -1L, -1L, paramHashMap, null, true);
  }
  
  public static boolean c()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity == null) || (!(localBaseActivity instanceof SplashActivity))) {
      return false;
    }
    return ((SplashActivity)localBaseActivity).a() == MainFragment.jdField_h_of_type_Int;
  }
  
  public static boolean c(int paramInt)
  {
    boolean bool = true;
    if ((paramInt != 0) && (!odm.b(paramInt))) {
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
    while (paramArticleInfo.mFeedType != 16) {
      return false;
    }
    return true;
  }
  
  public static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    if (s(paramBaseArticleInfo))
    {
      paramBaseArticleInfo = (ppv)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      return (paramBaseArticleInfo.jdField_a_of_type_Ppy != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.jdField_a_of_type_Ppy.jdField_a_of_type_JavaLangString));
    }
    return false;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    int m = jdField_a_of_type_Int;
    if ((paramQQAppInterface == null) || (m <= 0)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject1 = ahay.a().jdField_a_of_type_JavaUtilList;
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
          if ((((RecentUserBaseData)localObject2).mUser != null) && (((RecentUserBaseData)localObject2).mUser.getType() == 1008) && (rol.b(paramQQAppInterface, ((RecentUserBaseData)localObject2).mUser.uin)))
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
      int n = localArrayList.size();
      int k = m;
      if (m > n) {
        k = n;
      }
      while (m < k)
      {
        paramQQAppInterface = (RecentBaseData)localArrayList.get(m);
        if (paramQQAppInterface != null)
        {
          boolean bool = TextUtils.equals(((RecentUserBaseData)paramQQAppInterface).a(), ajed.az);
          if (bool) {
            return true;
          }
        }
        m += 1;
        continue;
        m = 0;
      }
    }
  }
  
  public static boolean c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if ((!TextUtils.isEmpty(paramString.getHost())) && (paramString.getHost().equals("kandian.qq.com")) && (!TextUtils.isEmpty(paramString.getPath())) && ((paramString.getPath().equals("/mqq/vue/wendadetail")) || (paramString.getPath().equals("/mqq/vue/wenda")))) {
        return true;
      }
    }
    return false;
  }
  
  public static int d()
  {
    int k = 1;
    if (jdField_f_of_type_Int != -1) {
      return jdField_f_of_type_Int;
    }
    if (bgmq.i())
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
          if (bgmq.j()) {
            return 2;
          }
          int m = ((ReadinjoyTabFrame)localObject).a();
          if (m == 0) {
            return 1;
          }
          if (m == 2) {
            return 3;
          }
          if (m == 1) {
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
            while (k != 0)
            {
              return 2;
              k = 0;
            }
          }
        }
      }
    }
    return ReadInJoyNewFeedsActivity.jdField_c_of_type_Int + 1;
  }
  
  public static String d()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("kandian_mode", String.valueOf(e()));
      localJSONObject.put("kandian_mode_new", new.a());
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
      if (ooq.a()) {}
      for (String str = "1";; str = "0")
      {
        localJSONObject.put("is_requesting_articles", str);
        localJSONObject.put("os", 1);
        localJSONObject.put("version", new.jdField_a_of_type_JavaLangString);
        return localJSONObject.toString();
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public static String d(int paramInt)
  {
    Object localObject = a();
    int m = Math.max(10, jdField_a_of_type_Int);
    if (localObject == null) {
      return "";
    }
    List localList = b();
    StringBuilder localStringBuilder = new StringBuilder(jdField_a_of_type_Int + ":");
    int k = localList.size();
    if (0 + m < k) {
      k = 0 + m;
    }
    for (;;)
    {
      akaq localakaq = ((QQAppInterface)localObject).a();
      m = 0;
      if (m < k)
      {
        localObject = (RecentBaseData)localList.get(m);
        RecentUserBaseData localRecentUserBaseData;
        int n;
        if (localObject != null)
        {
          localRecentUserBaseData = (RecentUserBaseData)localObject;
          if ((localRecentUserBaseData.mUser != null) && ((localRecentUserBaseData.mUser.getType() == paramInt) || (paramInt == -1)))
          {
            n = localakaq.a(localRecentUserBaseData.a(), localRecentUserBaseData.mUser.getType());
            if (localRecentUserBaseData.mUnreadFlag == 3) {
              n = 0;
            }
            if (localRecentUserBaseData.mUser.getType() != 1008) {
              break label244;
            }
          }
        }
        label244:
        for (localObject = "1";; localObject = "0")
        {
          localStringBuilder.append((String)localObject).append("_").append(localRecentUserBaseData.a()).append("_").append(n);
          if (m != k - 1) {
            localStringBuilder.append(":");
          }
          m += 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, "getScreenPaInfo : " + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
  }
  
  private static String d(ArticleInfo paramArticleInfo)
  {
    if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
      return "0";
    }
    long l = Long.parseLong(paramArticleInfo.mSubscribeID);
    try
    {
      bool = ((ajoy)BaseApplicationImpl.getApplication().getRuntime().getManager(56)).a(Long.valueOf(l), true);
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
    if (paramBaseArticleInfo.isSubscriptFeed()) {
      return "3";
    }
    if ((paramBaseArticleInfo.mPackInfoObj == null) || (!paramBaseArticleInfo.mPackInfoObj.pack_type.has())) {
      return "";
    }
    int k = paramBaseArticleInfo.mPackInfoObj.pack_type.get();
    if ((k == 3) && (paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.has()) && (((articlesummary.FriendRecommendInfo)paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.has())) {
      return "1";
    }
    if ((k == 2) && (paramBaseArticleInfo.mPackInfoObj.msg_special_topic_info.has())) {
      return "2";
    }
    return "";
  }
  
  public static String d(String paramString)
  {
    if (babp.j() > 720L) {
      return a(paramString, 18);
    }
    return a(paramString, 24);
  }
  
  public static void d()
  {
    if (!ReadinjoyTabFrame.c_()) {
      b(false);
    }
  }
  
  public static void d(int paramInt)
  {
    jdField_j_of_type_Int = paramInt;
  }
  
  private static void d(Context paramContext)
  {
    e(paramContext);
    awrn.a(paramContext).a(a().getAccount(), "actReadInJoyDDShowVideoAS", true, 0L, 0L, null, "");
  }
  
  public static void d(Context paramContext, String paramString)
  {
    Object localObject = amfg.a();
    if (!TextUtils.isEmpty(((amff)localObject).jdField_a_of_type_JavaLangString))
    {
      String str = ((amff)localObject).jdField_a_of_type_JavaLangString;
      localObject = str;
      if (!TextUtils.isEmpty(paramString)) {
        localObject = str + "&placeholder=" + Uri.encode(paramString, "utf-8");
      }
      if (System.currentTimeMillis() - jdField_b_of_type_Long > 1000L) {
        avwf.a(null, paramContext, (String)localObject);
      }
      jdField_b_of_type_Long = System.currentTimeMillis();
    }
    for (;;)
    {
      ndn.a(null, "CliOper", "", "", "0X80067D3", "0X80067D3", 0, 0, "", "", "", c(), false);
      return;
      paramContext.startActivity(new Intent(paramContext, ReadInJoyNewSearchActivity.class));
    }
  }
  
  public static void d(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    awrn.a(paramContext).a(paramString, "actVideoFeedsStartTime", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    jdField_g_of_type_Boolean = false;
  }
  
  public static void d(String paramString)
  {
    if (jdField_i_of_type_JavaLangString != null) {
      ocr.a(jdField_i_of_type_JavaLangString);
    }
    jdField_i_of_type_JavaLangString = paramString;
  }
  
  public static boolean d()
  {
    return (b()) || (b());
  }
  
  public static boolean d(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong.longValue() == 23L);
  }
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((!paramBaseArticleInfo.mShowBigPicture) || (paramBaseArticleInfo.mIsGallery != 1) || ((paramBaseArticleInfo.articleStyle != 3) && (paramBaseArticleInfo.articleStyle != 4) && (paramBaseArticleInfo.articleStyle != 5) && (paramBaseArticleInfo.articleStyle != 6) && (!b(paramBaseArticleInfo)))) {
      return false;
    }
    return true;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    if (jdField_c_of_type_Boolean)
    {
      ThreadManager.executeOnSubThread(new ReadInJoyUtils.8(paramQQAppInterface));
      jdField_c_of_type_Boolean = false;
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
    if (!bgmq.c(paramQQAppInterface))
    {
      QLog.d("ReadInJoyUtils", 1, "r:config false");
      return false;
    }
    if (!SettingCloneUtil.readValue(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), null, "qqsetting_kandian_key", true))
    {
      QLog.d("ReadInJoyUtils", 1, "kandian push disabled");
      return false;
    }
    localObject = bgmq.a(paramQQAppInterface);
    String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    int k = Calendar.getInstance().get(11);
    if ((!TextUtils.equals((CharSequence)localObject, str)) && (k >= 6))
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
      QLog.d("ReadInJoyUtils", 1, "r:hour:" + k);
    }
  }
  
  public static boolean d(String paramString)
  {
    return TextUtils.equals(ajed.aO, paramString);
  }
  
  public static int e()
  {
    return jdField_j_of_type_Int;
  }
  
  public static String e()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      ((JSONObject)localObject).put("session_id", jdField_e_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String e(int paramInt)
  {
    String str;
    if (paramInt == opa.a()) {
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
        aciy.a("ReadInJoyUtils", "fs is not number", localNumberFormatException);
      }
      switch (paramInt)
      {
      default: 
        if (odm.c(paramInt)) {
          str = oab.a();
        }
        break;
      case 0: 
        str = jdField_d_of_type_Int + "";
        break;
      case 70: 
        str = oae.a();
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
  
  public static String e(BaseArticleInfo paramBaseArticleInfo)
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
  
  public static String e(String paramString)
  {
    return "https://kandian.qq.com/mqq/watchspot/gallery.html?_wv=2147483777&rowkey=" + paramString + "&x5PreFetch=1&_bid=3002";
  }
  
  public static void e()
  {
    if (jdField_a_of_type_Ppp.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      jdField_a_of_type_Ppp.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isread = true;
    }
  }
  
  private static void e(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_dian_dian", true);
    nsz.a(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772217, 2130772038);
  }
  
  public static void e(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("mqqapi:")) {
        break label69;
      }
      QQAppInterface localQQAppInterface = qoe.a();
      if (localQQAppInterface == null) {
        break label36;
      }
      bade.a(localQQAppInterface, paramContext, paramString).c();
    }
    label36:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyUtils", 2, "jumpToUrl failed for appInterface is null, url:" + paramString);
    return;
    label69:
    f(paramContext, paramString);
  }
  
  public static void e(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    awrn.a(paramContext).a(paramString, "actVideoFeedsScrollIntervalTime", paramBoolean, -1L, 0L, paramHashMap, null);
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
        localQQMessageFacade = paramQQAppInterface.a();
      } while (localQQMessageFacade == null);
      localMessageForStructing.time = NetConnInfoCenter.getServerTime();
      MessageRecord localMessageRecord = ((KandianMergeManager)paramQQAppInterface.getManager(162)).a(localMessageForStructing);
      if (localMessageRecord != null) {
        localQQMessageFacade.a(localMessageRecord, paramQQAppInterface.c());
      }
      localQQMessageFacade.a(localMessageForStructing, paramQQAppInterface.c());
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyUtils", 2, "notifyXinKandianMsg");
  }
  
  public static boolean e()
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
      int m = localException.size();
      int k = 0;
      while (k < m)
      {
        localObject1 = (RecentBaseData)localException.get(k);
        if (localObject1 != null)
        {
          localObject1 = (RecentUserBaseData)localObject1;
          if ((!TextUtils.equals(((RecentUserBaseData)localObject1).a(), ajed.az)) && (((RecentUserBaseData)localObject1).a() != 5000))
          {
            int n = ((RecentUserBaseData)localObject1).b();
            if (n > 0) {
              return true;
            }
          }
        }
        k += 1;
      }
    }
  }
  
  public static boolean e(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 19) {
      return false;
    }
    return true;
  }
  
  public static boolean e(BaseArticleInfo paramBaseArticleInfo)
  {
    return paramBaseArticleInfo.mIsPolymericGallery;
  }
  
  public static boolean e(String paramString)
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
        return ((ajoy)((AppInterface)localObject).getManager(56)).a(Long.valueOf(paramString));
      }
      return false;
    }
  }
  
  public static int f()
  {
    boolean bool2 = false;
    int i1 = 1024;
    int i2 = 100;
    int i3 = 2;
    int k;
    int m;
    int n;
    boolean bool1;
    if (!TextUtils.isEmpty(rsp.jdField_g_of_type_JavaLangString))
    {
      k = i3;
      m = i2;
      n = i1;
      bool1 = bool2;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(rsp.jdField_g_of_type_JavaLangString);
        k = i3;
        m = i2;
        n = i1;
        bool1 = bool2;
        bool2 = localJSONObject.optBoolean("useNewLogic", false);
        k = i3;
        m = i2;
        n = i1;
        bool1 = bool2;
        i1 = localJSONObject.optInt("minTotalMem", 1024);
        k = i3;
        m = i2;
        n = i1;
        bool1 = bool2;
        i2 = localJSONObject.optInt("minAvailableMem", 100);
        k = i3;
        m = i2;
        n = i1;
        bool1 = bool2;
        i3 = localJSONObject.optInt("minCpuNum", 2);
        k = i3;
        m = i2;
        n = i1;
        bool1 = bool2;
        int i4 = localJSONObject.optInt("minCpuFreq", 1000);
        bool1 = bool2;
        n = i2;
        m = i3;
        k = i4;
      }
      catch (Exception localException)
      {
        long l1;
        long l2;
        long l3;
        i1 = n;
        n = m;
        m = k;
        k = 1000;
        continue;
        if (l2 >>> 20 < n) {
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
        l1 = babp.d();
        l2 = babp.e();
        i2 = babp.b();
        l3 = babp.a();
        if ((l1 >>> 20 >= i1) && (i2 >= m) && (l3 >= k)) {
          return 1;
        }
      }
      if (Build.VERSION.SDK_INT >= 19) {
        return 1;
      }
      return 0;
      bool1 = false;
      i1 = 1024;
      n = 100;
      m = 2;
      k = 1000;
    }
  }
  
  public static String f()
  {
    Object localObject;
    if (jdField_h_of_type_Int >= 10) {
      localObject = "null";
    }
    String str;
    do
    {
      return localObject;
      str = befc.a("d059d3", 5);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    jdField_h_of_type_Int += 1;
    return "null";
  }
  
  public static String f(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (odm.c(paramInt)) {
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
  
  public static String f(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (!odm.c((int)paramBaseArticleInfo.mChannelID)) || (TextUtils.isEmpty(paramBaseArticleInfo.proteusItemsData))) {
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
    if ((!jdField_j_of_type_Boolean) && (paramContext != null))
    {
      paramContext = paramContext.getApplicationContext();
      jdField_j_of_type_Boolean = true;
      AppNetConnInfo.registerNetChangeReceiver(paramContext, new oce(paramContext));
      g(paramContext);
    }
  }
  
  public static void f(Context paramContext, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (rjb.b(paramString))) {
      rjb.a(paramContext, null, rjb.b(paramString), null);
    }
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("big_brother_source_key", f(0));
    } while (TextUtils.isEmpty(paramString));
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static void f(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(a(paramContext)));
    awrn.a(paramContext).a(paramString, "actKandianVideoBehaviors", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void f(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.a();
    if (localObject == null) {
      return;
    }
    MessageRecord localMessageRecord = ((QQMessageFacade)localObject).b(ajed.az, 7220);
    localObject = localMessageRecord;
    if (jdField_a_of_type_Ppp.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      if (localMessageRecord != null)
      {
        localObject = localMessageRecord;
        if (localMessageRecord.time > jdField_a_of_type_Ppp.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time) {}
      }
      else
      {
        localObject = jdField_a_of_type_Ppp.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
    }
    a(paramQQAppInterface, (MessageRecord)localObject);
  }
  
  public static boolean f()
  {
    return jdField_i_of_type_Boolean;
  }
  
  public static boolean f(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 18) {
      return false;
    }
    return true;
  }
  
  public static boolean f(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList.size() > 0);
  }
  
  public static boolean f(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = befm.a(paramString);
      if ((paramString != null) && ("1".equalsIgnoreCase((String)paramString.get("jump_android_hemera")))) {
        return true;
      }
    }
    return false;
  }
  
  public static int g()
  {
    return KandianVideoUploadService.a();
  }
  
  public static String g()
  {
    Object localObject;
    if (jdField_i_of_type_Int >= 10) {
      localObject = "null";
    }
    String str;
    do
    {
      return localObject;
      str = befc.b("d059d3", 5);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    jdField_i_of_type_Int += 1;
    return "null";
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
  
  private static void g(Context paramContext)
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
        jdField_g_of_type_JavaLangString = paramContext;
        if (!TextUtils.isEmpty(jdField_g_of_type_JavaLangString)) {
          break label64;
        }
      }
    }
    label56:
    label64:
    for (paramContext = "";; paramContext = localWifiInfo.getSSID())
    {
      jdField_h_of_type_JavaLangString = paramContext;
      return;
      paramContext = localWifiInfo.getBSSID();
      break;
    }
  }
  
  public static void g(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(a(paramContext)));
    awrn.a(paramContext).a(paramString, "actKandianVideoBehaviorsSeq", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void g(QQAppInterface paramQQAppInterface)
  {
    
    if (paramQQAppInterface == null) {
      return;
    }
    long l1 = paramQQAppInterface.getLongAccountUin();
    long l2 = System.currentTimeMillis();
    jdField_f_of_type_JavaLangString = String.valueOf(l1) + "_" + String.valueOf(l2);
  }
  
  public static boolean g()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(rsp.jdField_g_of_type_JavaLangString)) {}
    try
    {
      bool = new JSONObject(rsp.jdField_g_of_type_JavaLangString).optBoolean("useNewLogic", false);
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean g(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm == null)) {}
    while ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong.longValue() != 17L) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong.longValue() != 16L)) {
      return false;
    }
    return true;
  }
  
  public static boolean g(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return false;
    }
    int k = qoe.c((ArticleInfo)paramBaseArticleInfo);
    if ((paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return false;
    }
    switch (k)
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
      paramString = befm.a(paramString);
      if ((paramString != null) && ("5".equalsIgnoreCase((String)paramString.get("target")))) {
        return true;
      }
    }
    return false;
  }
  
  public static int h()
  {
    return Aladdin.getConfig(196).getIntegerFromString("artical_interact_type", 0);
  }
  
  public static String h()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      Object localObject2 = f();
      String str = g();
      if ((!((String)localObject2).equals("null")) && (!str.equals("null")))
      {
        jdField_a_of_type_JavaLangString = "0," + (String)localObject2 + "," + str;
        return jdField_a_of_type_JavaLangString;
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
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return obb.jdField_g_of_type_JavaLangString + baaw.encodeToString(paramString.getBytes(), 2);
  }
  
  private static void h()
  {
    AppRuntime localAppRuntime = a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      if (!((QQAppInterface)localAppRuntime).a.b()) {
        ohp.f();
      }
    }
    else {
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyUtils.2(), 500L);
  }
  
  public static boolean h()
  {
    boolean bool = false;
    if (bgmq.r(a()) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean h(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm == null)) {}
    while ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong.longValue() != 19L) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong.longValue() != 18L)) {
      return false;
    }
    return true;
  }
  
  public static boolean h(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mPolymericInfo != null) && (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int >= 6);
  }
  
  public static int i()
  {
    return Aladdin.getConfig(199).getIntegerFromString("no_difference_jump_app_jump_src", 0);
  }
  
  public static String i()
  {
    if (jdField_f_of_type_JavaLangString == null) {
      return "0";
    }
    return jdField_f_of_type_JavaLangString;
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
      bgmq.e();
      paramString = paramString.toString();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      QLog.e("ReadInJoyUtils", 1, "getNoDifferenceJumpToAppSchema UnsupportedEncodingException: " + paramString);
    }
    return "";
  }
  
  public static boolean i()
  {
    if (!jdField_b_of_type_Boolean)
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.KDCfg.name(), null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 2) {
          jdField_f_of_type_Boolean = localObject[1].equals("1");
        }
        jdField_b_of_type_Boolean = true;
      }
    }
    return jdField_f_of_type_Boolean;
  }
  
  public static boolean i(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 26) {
      return false;
    }
    return true;
  }
  
  public static boolean i(BaseArticleInfo paramBaseArticleInfo)
  {
    return (h(paramBaseArticleInfo)) && (paramBaseArticleInfo.mIsInPolymeric);
  }
  
  public static int j()
  {
    jdField_a_of_type_JavaLangInteger = null;
    return k();
  }
  
  public static String j()
  {
    rwa.a();
    StringBuilder localStringBuilder = new StringBuilder("{");
    a(localStringBuilder, "probesize", Long.valueOf(bgmq.c()));
    localStringBuilder.append(",");
    a(localStringBuilder, "isFFProbelistSwitch", Boolean.valueOf(bgmq.r()));
    localStringBuilder.append(",");
    a(localStringBuilder, "isDownloadAsyncIo", Boolean.valueOf(bgmq.s()));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static boolean j()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public static boolean j(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      bool1 = bool2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri != null)
      {
        bool1 = bool2;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri.jdField_a_of_type_Poq != null)
        {
          bool1 = bool2;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri.c != null)
          {
            bool1 = bool2;
            if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri.c.size() > 0)
            {
              bool1 = bool2;
              if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri.jdField_a_of_type_Poq.jdField_b_of_type_Int == 1) {
                bool1 = false;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean j(BaseArticleInfo paramBaseArticleInfo)
  {
    return (h(paramBaseArticleInfo)) && (paramBaseArticleInfo.mGroupSubArticleList != null);
  }
  
  public static int k()
  {
    if (jdField_a_of_type_JavaLangInteger == null)
    {
      jdField_a_of_type_JavaLangInteger = Integer.valueOf(Aladdin.getConfig(215).getIntegerFromString("message_reddot_style", 0));
      if ((bgmq.i()) || (jdField_a_of_type_JavaLangInteger.intValue() != 0)) {
        break label151;
      }
      jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
    }
    label151:
    for (int k = 1;; k = 0)
    {
      if ((jdField_a_of_type_JavaLangInteger.intValue() == 2) && (a() != null))
      {
        KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = ((KandianMergeManager)a().getManager(162)).a();
        int m = k;
        if (localKandianMsgBoxRedPntInfo != null)
        {
          m = k;
          if (localKandianMsgBoxRedPntInfo.dataType != 1)
          {
            jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
            m = 2;
          }
        }
        QLog.d("ReadInJoyUtils", 1, "init msgboxUIMode : " + jdField_a_of_type_JavaLangInteger + ", rule : " + m);
      }
      return jdField_a_of_type_JavaLangInteger.intValue();
    }
  }
  
  public static boolean k()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_e_of_type_Long <= 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "click too fast");
      }
      jdField_e_of_type_Long = l;
      return true;
    }
    jdField_e_of_type_Long = l;
    return false;
  }
  
  public static boolean k(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri == null)) {
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
      if ((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong.intValue() != 21)) {
        break;
      }
    } while (a(paramArticleInfo, true) == 75);
    return false;
    return false;
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
  
  public static boolean l()
  {
    return oad.a();
  }
  
  public static boolean l(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri == null)) {
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
        if ((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong.intValue() != 22)) {
          break;
        }
      } while (a(paramArticleInfo, true) == 73);
      return false;
    } while ((paramArticleInfo.mFeedType == 1) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_b_of_type_Int == 4));
    return false;
  }
  
  public static boolean l(BaseArticleInfo paramBaseArticleInfo)
  {
    return (h(paramBaseArticleInfo)) && ((paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 9) || (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 10) || (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11));
  }
  
  public static boolean m()
  {
    return (((Boolean)bgmq.a("preload_controller", Boolean.valueOf(true))).booleanValue()) && (bgmq.k());
  }
  
  public static boolean m(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri == null)) {}
    while (paramArticleInfo.mFeedType != 21) {
      return false;
    }
    return true;
  }
  
  public static boolean m(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mNewPolymericInfo != null) {}
    for (int k = 1; (k != 0) && ((paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 9) || (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 10) || (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 11)); k = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean n()
  {
    return Aladdin.getConfig(154).getIntegerFromString("need_show_social_bottom_view", 1) == 1;
  }
  
  public static boolean n(ArticleInfo paramArticleInfo)
  {
    return (o(paramArticleInfo)) || (p(paramArticleInfo));
  }
  
  public static boolean n(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 15);
  }
  
  public static boolean o()
  {
    return Aladdin.getConfig(176).getIntegerFromString("artical_interact_area", 0) == 1;
  }
  
  public static boolean o(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong == null)) {}
    while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong.intValue() != 21) {
      return false;
    }
    return true;
  }
  
  public static boolean o(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 12);
  }
  
  public static boolean p()
  {
    return Aladdin.getConfig(176).getIntegerFromString("ad_relative_pos", 0) == 1;
  }
  
  public static boolean p(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong == null)) {}
    while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_b_of_type_JavaLangLong.intValue() != 22) {
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
    return Aladdin.getConfig(190).getIntegerFromString("readinjoy_feeds_overdraw_optimize_switch", 1) == 1;
  }
  
  private static boolean q(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.isAccountShown) {
      return false;
    }
    switch (paramArticleInfo.mFeedType)
    {
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    case 11: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      return false;
    case 0: 
    case 8: 
    case 10: 
    case 12: 
    case 16: 
    case 17: 
      return true;
    }
    switch (qoe.c(paramArticleInfo))
    {
    default: 
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
    return Aladdin.getConfig(253).getIntegerFromString("enable_use_exposure_data", 0) == 1;
  }
  
  public static boolean r(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 24) && (paramBaseArticleInfo.mNewPolymericInfo != null);
  }
  
  public static boolean s()
  {
    return Aladdin.getConfig(255).getIntegerFromString("allow_yaobu_icon_click_report", 0) == 1;
  }
  
  public static boolean s(BaseArticleInfo paramBaseArticleInfo)
  {
    return paramBaseArticleInfo.mNewPolymericInfo != null;
  }
  
  public static boolean t(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mFeedType == 29);
  }
  
  public static boolean u(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 20) && (paramBaseArticleInfo.mRecommendFollowInfos != null);
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
  
  public static boolean w(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && ((paramBaseArticleInfo instanceof ArticleInfo)) && (!qoe.q((ArticleInfo)paramBaseArticleInfo)) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Int == 6);
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
    return b(oxy.a(paramBaseArticleInfo.mProteusTemplateBean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     obz
 * JD-Core Version:    0.7.0.1
 */