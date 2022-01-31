import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
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
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.24;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.25;
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
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
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
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
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

public class onh
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
  public static HashMap<Integer, ntd> a;
  private static Map<String, MessageForStructing> jdField_a_of_type_JavaUtilMap;
  private static Queue<Integer> jdField_a_of_type_JavaUtilQueue;
  public static final qbi a;
  public static volatile boolean a;
  public static int b;
  public static long b;
  private static Handler b;
  public static String b;
  public static boolean b;
  public static int c;
  private static long c;
  public static String c;
  public static boolean c;
  public static int d;
  private static long d;
  public static String d;
  public static boolean d;
  public static int e;
  private static long jdField_e_of_type_Long;
  private static String jdField_e_of_type_JavaLangString;
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
  private static volatile boolean jdField_j_of_type_Boolean;
  private static boolean k;
  private static volatile boolean l;
  
  static
  {
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    jdField_b_of_type_JavaLangString = "0";
    jdField_c_of_type_JavaLangString = "1";
    jdField_d_of_type_JavaLangString = "2";
    jdField_a_of_type_Int = 7;
    jdField_c_of_type_Int = -2;
    jdField_j_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_c_of_type_Long = 300000L;
    jdField_e_of_type_Int = -1;
    jdField_e_of_type_JavaLangString = "";
    jdField_a_of_type_Qbi = new qbi();
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
      int m = 0;
      while (m < localException.size())
      {
        localObject1 = (RecentBaseData)localException.get(m);
        if (localObject1 != null)
        {
          boolean bool = TextUtils.equals(((RecentUserBaseData)localObject1).a(), ajsd.aA);
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
    int n = bbfj.a(paramContext);
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
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde != null))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Boolean) {
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
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde == null) || ((!paramBoolean) && (paramArticleInfo.mFeedType != 21) && (paramArticleInfo.mFeedType != 22)) || ((paramBoolean) && (!n(paramArticleInfo)))) {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyUtils", 1, "something is null.");
      }
    }
    do
    {
      return 7;
      if ((paramBoolean) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_Int == 3)) {
        return 75;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_Int == 3) {
        return 74;
      }
      if ((paramBoolean) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_Int == 4)) {
        return 73;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_Int == 4) {
        return 72;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ReadInJoyUtils", 1, "error ugcFeedsSrc = " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_Int);
    return 7;
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    int m = 10;
    int i1 = ram.c((ArticleInfo)paramBaseArticleInfo);
    label552:
    label554:
    int n;
    switch (i1)
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
    case 127: 
    default: 
      m = 0;
    case 10: 
    case 12: 
    case 44: 
      n = m;
      if (pym.a((ArticleInfo)paramBaseArticleInfo) == 3) {
        n = m;
      }
      switch (i1)
      {
      default: 
        n = m;
      case 5: 
      case 6: 
        label622:
        if (s(paramBaseArticleInfo)) {
          if (m(paramBaseArticleInfo))
          {
            n = 67;
            label639:
            if (paramBaseArticleInfo.isTwoItem) {
              n = 43;
            }
            if (qav.b(paramBaseArticleInfo)) {
              n = 69;
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
    for (;;)
    {
      if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco != null)) {}
      switch (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Int)
      {
      default: 
        return n;
        if ((paramBaseArticleInfo instanceof AdvertisementInfo))
        {
          m = 55;
          break label554;
        }
        m = 1;
        break label554;
        if ((paramBaseArticleInfo instanceof AdvertisementInfo))
        {
          m = 57;
          break label554;
        }
        m = 2;
        break label554;
        if ((paramBaseArticleInfo instanceof AdvertisementInfo))
        {
          m = 58;
          break label554;
        }
        m = 3;
        break label554;
        m = 4;
        break label554;
        if ((paramBaseArticleInfo instanceof AdvertisementInfo))
        {
          m = 56;
          break label554;
        }
        m = 5;
        break label554;
        if ((paramBaseArticleInfo instanceof AdvertisementInfo))
        {
          m = 59;
          break label554;
        }
        m = 6;
        break label554;
        m = 7;
        break label554;
        m = 8;
        break label554;
        m = 9;
        break label554;
        m = 11;
        break label554;
        m = 19;
        break label554;
        m = 20;
        break label554;
        m = 18;
        break label554;
        m = 101;
        break label554;
        m = 22;
        break label554;
        m = 21;
        break label554;
        m = 2005;
        break label554;
        m = 23;
        break label554;
        m = 30;
        break label554;
        m = 29;
        break label554;
        if (onp.a(paramBaseArticleInfo) == 32)
        {
          m = 2006;
          break label554;
        }
        m = 31;
        break label554;
        m = 24;
        break label554;
        m = 26;
        break label554;
        m = 32;
        break label554;
        m = 33;
        break label554;
        m = 34;
        break label554;
        m = 25;
        break label554;
        m = 27;
        break label554;
        m = 28;
        break label554;
        m = 28;
        break label554;
        m = 28;
        break label554;
        m = 35;
        break label554;
        m = 36;
        break label554;
        m = 37;
        break label554;
        m = 38;
        break label554;
        m = 39;
        break label554;
        m = 40;
        break label554;
        if (b((ArticleInfo)paramBaseArticleInfo))
        {
          m = 41;
          break label554;
        }
        m = 42;
        break label554;
        m = 19;
        break label554;
        m = 37;
        break label554;
        m = 43;
        break label554;
        if (e((ArticleInfo)paramBaseArticleInfo))
        {
          m = 45;
          break label554;
        }
        m = 46;
        break label554;
        m = 29;
        break label554;
        m = 30;
        break label554;
        m = 31;
        break label554;
        m = 47;
        break label554;
        if (((paramBaseArticleInfo instanceof ArticleInfo)) && (!TextUtils.isEmpty(((ArticleInfo)paramBaseArticleInfo).mArticleSubscriptText)))
        {
          m = 79;
          break label554;
        }
        m = 48;
        break label554;
        m = 1005;
        break label554;
        m = 1006;
        break label554;
        m = 1007;
        break label554;
        if (((paramBaseArticleInfo instanceof ArticleInfo)) && (!TextUtils.isEmpty(((ArticleInfo)paramBaseArticleInfo).mArticleSubscriptText)))
        {
          m = 78;
          break label554;
        }
        m = 49;
        break label554;
        m = 80;
        break label554;
        m = 50;
        break label554;
        m = 51;
        break label554;
        m = 52;
        break label554;
        m = 53;
        break label554;
        m = 54;
        break label554;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Boolean)
        {
          m = 62;
          break label554;
        }
        m = 61;
        break label554;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Boolean)
        {
          m = 64;
          break label554;
        }
        m = 63;
        break label554;
        m = 65;
        break label554;
        m = 66;
        break label554;
        m = 70;
        break label554;
        m = 73;
        break label554;
        m = 74;
        break label554;
        m = 72;
        break label554;
        m = 71;
        break label554;
        if ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl == null)) {
          break label552;
        }
        m = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Int;
        break label554;
        m = 75;
        break label554;
        m = 77;
        break label554;
        m = 999;
        break label554;
        m = 998;
        break label554;
        m = 1023;
        break label554;
        m = 1024;
        break label554;
        m = 1025;
        break label554;
        m = 1028;
        break label554;
        m = 1032;
        break label554;
        m = 1033;
        break label554;
        m = 1034;
        break label554;
        m = 1035;
        break label554;
        m = 2004;
        break label554;
        n = 12;
        break label622;
        n = 13;
        break label622;
        n = 14;
        break label622;
        n = 15;
        break label622;
        n = 16;
        break label622;
        n = 17;
        break label622;
        if (p(paramBaseArticleInfo))
        {
          n = 82;
          break label639;
        }
        if (o(paramBaseArticleInfo))
        {
          n = 83;
          break label639;
        }
        n = 68;
        break label639;
        if (l(paramBaseArticleInfo))
        {
          n = 54;
          break label639;
        }
        if (!i(paramBaseArticleInfo)) {
          break label639;
        }
        n = 47;
        break label639;
        n = 1031;
        continue;
        if (paramBaseArticleInfo.mProteusTemplateBean != null) {
          n = pjn.a(paramBaseArticleInfo.mProteusTemplateBean);
        }
        break;
      }
    }
    return 1038;
    return 1040;
    return 1041;
    return 1039;
    return 1042;
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
    if ((ram.a(paramArticleInfo)) || (paramInt == 77) || (paramInt == 78))
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
                  if ((!ram.a(paramArticleInfo)) && (paramInt != 72) && (paramInt != 74)) {
                    break;
                  }
                  l1 = l2;
                } while (paramArticleInfo.mSocialFeedInfo == null);
                l1 = l2;
              } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null);
              return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long;
              if (paramInt != 76) {
                break;
              }
              l1 = l2;
            } while (paramArticleInfo.mSocialFeedInfo == null);
            l1 = l2;
          } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci == null);
          return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
          if ((ram.f(paramArticleInfo)) || (paramInt == 73)) {
            break;
          }
          l1 = l2;
        } while (paramInt != 75);
        l1 = l2;
      } while (paramArticleInfo.mSocialFeedInfo == null);
      l1 = l2;
    } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci == null);
    return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
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
        break label198;
      }
      QLog.d("ReadInJoyUtils", 1, "conversation frame is null");
      return l1;
    }
    catch (Exception paramQQAppInterface)
    {
      i4 = 0;
      i2 = m;
    }
    label104:
    QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + paramQQAppInterface.toString());
    int i1 = i2;
    m = i4;
    label140:
    if (m != 0)
    {
      m = 0;
      label146:
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
            if ((((RecentUserBaseData)localObject3).mUser == null) || (((RecentUserBaseData)localObject3).mUser.getType() != 1008) || (!saz.b(paramQQAppInterface, ((RecentUserBaseData)localObject3).mUser.uin))) {
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
          break label741;
        }
        i4 = m;
        paramQQAppInterface = (RecentUserBaseData)paramQQAppInterface;
        i1 = m;
        i4 = m;
        if (paramQQAppInterface.mUnreadNum > 0) {
          i1 = 1;
        }
        i4 = i1;
        bool = TextUtils.equals(paramQQAppInterface.a(), ajsd.aA);
        i4 = i1;
        if (!bool) {
          break label741;
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
      break label140;
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
      break label104;
      label741:
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
    localIntent.putExtra("banner_wording", String.format(ajya.a(2131713134), new Object[] { paramArticleInfo.mTitle }));
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
    if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg == null) {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg = new qcg();
    }
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList = new ArrayList();
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
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.add(paramArticleInfo);
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
      localObject1 = ((QQMessageFacade)localObject1).b(ajsd.aA, 7220);
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
          localObject2 = (roy)bbcw.a(paramQQAppInterface);
          if (localObject2 != null)
          {
            QLog.d("ReadInJoyUtils", 2, "getMergeIcon From cache ! key : " + paramQQAppInterface + ", tipUin : " + (String)localObject1);
            return localObject2;
          }
          localObject2 = bbef.a(paramDrawable);
          if (localObject2 == null) {
            break;
          }
          localObject1 = new roy((Bitmap)localObject2, actj.a(50.0F, localResources), localResources, (String)localObject1, 1);
          bbcw.a(paramQQAppInterface, (Sizeable)localObject1);
          return localObject1;
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        paramQQAppInterface = bbef.a(paramDrawable);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface = new roy(paramQQAppInterface, (String)localObject2, actj.a(50.0F, localResources), localResources, 1);
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
    Object localObject = pny.a(paramLong);
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
          paramString = new String(bbco.decode((String)localObject3, 0));
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
          localObject3 = new String(bbco.decode((String)localObject1, 0));
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
        localObject3 = new String(bbco.decode(((JSONObject)localObject5).optString("accountDesc"), 0));
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
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg = new qcg();
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaLangLong = Long.valueOf(l8);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong = Long.valueOf(l1);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList = new ArrayList();
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
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangString = new String(bbco.decode(((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangString, 0));
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_a_of_type_JavaLangString = ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangString;
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
        continue;
      }
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.add(localObject2);
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
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda = new qda();
      n = paramString.optInt("ugcType", 0);
      localObject2 = paramString.optString("ugcComment");
      localObject4 = paramString.optJSONArray("ugcAtLevelList");
      if (localObject4 != null)
      {
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Qcg = new qcg();
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList = new ArrayList();
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
            ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString = new String(bbco.decode(((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString, 0));
            ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_JavaLangString = ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString;
          }
          catch (Exception localException5)
          {
            for (;;)
            {
              localException5.printStackTrace();
            }
          }
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.add(localObject5);
          m += 1;
        }
      }
      label1247:
      localArticleInfo.mTitle = new String(bbco.decode((String)localObject2, 0));
      localArticleInfo.mSummary = "";
      if ((n != 3) && (n != 2)) {
        break label1582;
      }
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = new qdb();
      paramString = paramString.optJSONArray("ugcPicInfo");
      if ((paramString != null) && (paramString.length() > 0))
      {
        ((qdb)localObject1).jdField_c_of_type_JavaLangString = paramString.getJSONObject(0).optString("ugcPicUrl");
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      }
    }
    for (;;)
    {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int = n;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaLangString = localArticleInfo.mTitle;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString = "";
      localArticleInfo.mSocialFeedInfo.jdField_c_of_type_JavaLangString = "";
      localArticleInfo.mSocialFeedInfo.jdField_b_of_type_JavaLangString = "";
      return localArticleInfo;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      localObject2 = new qdc();
      paramString = paramString.optJSONObject("ugcVideoInfo");
      if (paramString != null)
      {
        ((qdc)localObject2).jdField_d_of_type_JavaLangString = paramString.optString("ugcVideoCoverUrl");
        ((qdc)localObject2).jdField_a_of_type_Long = paramString.optInt("ugcVideoDuration");
        ((qdc)localObject2).jdField_e_of_type_JavaLangString = ((String)localObject1);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
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
    if (l1 - jdField_d_of_type_Long > jdField_c_of_type_Long)
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = akuf.a("readinjoy_anti_cheating");
      jdField_d_of_type_Long = l1;
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
        paramAppRuntime = bhvy.a(paramAppRuntime, true, paramBoolean);
        if (paramAppRuntime != null)
        {
          paramAppRuntime = paramAppRuntime.getString(paramString, "");
          if (!TextUtils.isEmpty(paramAppRuntime))
          {
            paramAppRuntime = new ObjectInputStream(new ByteArrayInputStream(bbmx.a(paramAppRuntime)));
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
    int m;
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
      m = bhvy.b(BaseApplicationImpl.getApplication().getRuntime(), 0);
      label38:
      if (m != 0) {
        break label123;
      }
      str = jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject = bhvy.a(a(), true, false);
      if (localObject != null) {
        break label149;
      }
      QLog.d("ReadInJoyUtils", 1, "getVideoAutoPlaySetting failed to get sp");
      return str;
      bool = false;
      break;
      label79:
      m = bhvy.a(BaseApplicationImpl.getApplication().getRuntime(), 0);
      break label38;
      label93:
      if (bool)
      {
        m = bhvy.c(BaseApplicationImpl.getApplication().getRuntime());
        break label38;
      }
      m = bhvy.b(BaseApplicationImpl.getApplication().getRuntime());
      break label38;
      label123:
      if (m == 1) {
        str = jdField_c_of_type_JavaLangString;
      } else if (m == 2) {
        str = jdField_b_of_type_JavaLangString;
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
        paramString3.put("kandian_mode_new", npu.a());
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
        paramString3.put("proteus_bid", bhvy.a("default_feeds_proteus_offline_bid"));
        paramString3.put("ads_jump", paramInt9);
        paramString3.put("ads_source", paramInt10);
        paramString3.put("star_logo", b(paramArticleInfo));
        if (bbwq.a() == 1)
        {
          paramString1 = "1";
          paramString3.put("simCardType", paramString1);
          if ((oou.c(paramInt2)) && (paramArticleInfo != null))
          {
            paramLong1 = ((Long)bhvy.a("readinjoy_daily_article_first_exposure_" + paramArticleInfo.mArticleID, Long.valueOf(0L))).longValue();
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
              break label654;
            }
            if (paramArticleInfo.mVideoCommentCount <= 100) {
              break label626;
            }
            break label654;
            paramString3.put("comment_exposure", paramInt1);
          }
          if (paramArticleInfo != null)
          {
            if ((ozy.a() == -1) || (ozy.a() == 0)) {
              break label631;
            }
            paramString3.put("mainfeeds_showcase", ozy.a());
            paramString3.put("configchannel_name", ozy.a());
          }
          if ((paramArticleInfo != null) && (qae.a(paramArticleInfo))) {
            paramString3.put("jump_src", qae.a(paramArticleInfo));
          }
          if (!jdField_c_of_type_Boolean) {
            break label644;
          }
          paramInt1 = 1;
          paramString3.put("from_aio", paramInt1);
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
          paramString2 = new qzb(paramString1).c(paramArticleInfo).d(paramArticleInfo).a(paramArticleInfo.videoReportInfo).a(paramArticleInfo, true).a().a();
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
      label626:
      paramInt1 = 2;
      continue;
      label631:
      paramString3.put("mainfeeds_showcase", 0);
      continue;
      label644:
      paramInt1 = 0;
      continue;
      label654:
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
      paramString2.put("proteus_bid", bhvy.a("default_feeds_proteus_offline_bid"));
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
    int m = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
      if (bbfj.h(paramContext)) {
        m = 0;
      }
      for (;;)
      {
        localJSONObject.put("network", m);
        localJSONObject.put("version", paramString1);
        localJSONObject.put("os", 1);
        localJSONObject.put("uin", paramString2);
        return localJSONObject.toString();
        boolean bool = bbfj.c(paramContext);
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
    qzb localqzb = new qzb(null, null, null, null);
    localqzb.U(ReadinjoyTabFrame.jdField_a_of_type_Int).V(paramInt);
    if (paramVideoInfo != null) {
      if (paramVideoInfo.jdField_h_of_type_Boolean) {
        if (paramVideoInfo.jdField_g_of_type_Boolean)
        {
          paramInt = 3;
          localqzb.a("status", Integer.valueOf(paramInt)).h(paramVideoInfo.jdField_g_of_type_JavaLangString).e(paramVideoInfo.jdField_f_of_type_Long).e(paramVideoInfo.jdField_a_of_type_JavaLangString).W(0).a(0);
        }
      }
    }
    for (;;)
    {
      return localqzb.a().a();
      paramInt = 2;
      break;
      paramInt = 4;
      break;
      localqzb.a("status", Integer.valueOf(1));
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
      str = rvx.b(paramBaseArticleInfo);
      if (!rvx.b(paramBaseArticleInfo)) {
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
    return jdField_a_of_type_Qbi.jdField_b_of_type_JavaLangString;
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
    if (!bhvy.b(a())) {
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
    int m;
    label149:
    double d3;
    double d4;
    if ("open".equals(str))
    {
      localObject = omj.a;
      int n = localObject.length;
      d2 = 1.0D * paramInt2 / paramInt1;
      d1 = 1.7976931348623157E+308D;
      arrayOfString1 = null;
      m = 0;
      if (m >= n) {
        break label370;
      }
      d3 = 1.0D * ((Integer)localObject[m].second).intValue() / ((Integer)localObject[m].first).intValue();
      d4 = Math.abs(d3 - d2);
      if (d4 >= d1) {
        break label252;
      }
      d1 = Math.abs(d3 - d2);
      arrayOfString1 = localObject[m];
    }
    label370:
    for (;;)
    {
      m += 1;
      break label149;
      if (!"vsmcut".equals(str)) {
        break;
      }
      localObject = omj.b;
      break label125;
      label252:
      if ((d4 == d1) && (arrayOfString1 != null))
      {
        int i1 = Math.abs(((Integer)arrayOfString1.second).intValue() - paramInt2);
        int i2 = Math.abs(((Integer)arrayOfString1.first).intValue() - paramInt1);
        int i3 = Math.abs(((Integer)localObject[m].second).intValue() - paramInt2);
        if (i1 + i2 > Math.abs(((Integer)localObject[m].first).intValue() - paramInt1) + i3)
        {
          d1 = Math.abs(d3 - d2);
          arrayOfString1 = localObject[m];
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
    if (!bhvy.b(a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "smart crop switch is false ! url : " + paramString);
      }
      return paramString;
    }
    double d2 = 1.0D * paramInt1 / paramInt2;
    double d1 = 1.7976931348623157E+308D;
    Object localObject1 = null;
    int n = omj.a.length;
    Object localObject2 = omj.a;
    int m = 0;
    label74:
    double d3;
    double d4;
    if (m < n)
    {
      d3 = 1.0D * ((Integer)localObject2[m].second).intValue() / ((Integer)localObject2[m].first).intValue();
      d4 = Math.abs(d3 - d2);
      if (d4 < d1)
      {
        d1 = Math.abs(d3 - d2);
        localObject1 = localObject2[m];
      }
    }
    for (;;)
    {
      m += 1;
      break label74;
      if ((d4 == d1) && (localObject1 != null))
      {
        int i1 = Math.abs(((Integer)localObject1.second).intValue() - paramInt1);
        int i2 = Math.abs(((Integer)localObject1.first).intValue() - paramInt2);
        int i3 = Math.abs(((Integer)localObject2[m].second).intValue() - paramInt1);
        if (i1 + i2 > Math.abs(((Integer)localObject2[m].first).intValue() - paramInt2) + i3)
        {
          d1 = Math.abs(d3 - d2);
          localObject1 = localObject2[m];
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
      localJSONObject.put("version", "8.3.0".replace(".", ""));
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
      localJSONObject.put("feeds_source", ((qds)paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int);
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
      if (ram.a(paramArticleInfo)) {
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
        localJSONObject.put("feeds_source", localSocializeFeedsInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long);
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
        if (!ram.d(paramBaseArticleInfo)) {
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
      localJSONObject.put("proteus_bid", bhvy.a("default_feeds_proteus_offline_bid"));
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
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
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
        if (!e()) {
          break label231;
        }
        m = 1;
        label143:
        localJSONObject.put("message_status", m);
        if (bhvy.I(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          break label237;
        }
        m = 1;
        label170:
        localJSONObject.put("reddot_style", m);
        if (!bhvy.z(a())) {
          break label243;
        }
      }
      label231:
      label237:
      label243:
      for (int m = n;; m = 0)
      {
        localJSONObject.put("hemera_switch", m);
        localJSONObject.put("kandian_mode_new", npu.a());
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
  
  public static String a(String paramString, qbo paramqbo, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramString;
    if (paramqbo != null)
    {
      localObject = paramString;
      if (paramBaseArticleInfo != null)
      {
        localObject = paramString;
        if (TextUtils.isEmpty(paramqbo.jdField_c_of_type_JavaLangString)) {}
      }
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mqqapi://readinjoy/open?src_type=internal&target=3").append("&channelID=").append(paramBaseArticleInfo.mChannelID).append("&strategyId=").append(paramqbo.jdField_a_of_type_Int).append("&algorithmID=").append(paramqbo.jdField_b_of_type_Long).append("&title=").append(paramqbo.jdField_a_of_type_JavaLangString).append("&firstPagePicUrl=").append(URLEncoder.encode(paramqbo.jdField_c_of_type_JavaLangString, "UTF-8")).append("&articleID=").append(paramqbo.jdField_a_of_type_Long).append("&subscribeName=").append(paramqbo.jdField_f_of_type_JavaLangString).append("&rowKey=").append(paramqbo.jdField_g_of_type_JavaLangString).append("&subscribeID=").append(paramqbo.jdField_e_of_type_JavaLangString).append("&articleContentUrl=").append(URLEncoder.encode(paramString, "UTF-8")).append("&readinjoyNotDecodeUrl=1");
      localObject = ((StringBuilder)localObject).toString();
      QLog.d("ReadInJoyUtils", 1, "getJumpNativeArticleScheme | polymeric articleScheme : " + (String)localObject);
      return localObject;
    }
    catch (UnsupportedEncodingException paramqbo)
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
    //   2: new 1665	java/io/StringWriter
    //   5: dup
    //   6: invokespecial 1666	java/io/StringWriter:<init>	()V
    //   9: astore_1
    //   10: new 1668	java/io/PrintWriter
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 1671	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   18: astore_3
    //   19: aload_0
    //   20: aload_3
    //   21: invokevirtual 1676	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   24: aload_3
    //   25: invokevirtual 1679	java/io/PrintWriter:flush	()V
    //   28: aload_1
    //   29: invokevirtual 1680	java/io/StringWriter:flush	()V
    //   32: aload_1
    //   33: ifnull +7 -> 40
    //   36: aload_1
    //   37: invokevirtual 1681	java/io/StringWriter:close	()V
    //   40: aload_3
    //   41: ifnull +7 -> 48
    //   44: aload_3
    //   45: invokevirtual 1682	java/io/PrintWriter:close	()V
    //   48: aload_1
    //   49: invokevirtual 1683	java/io/StringWriter:toString	()Ljava/lang/String;
    //   52: areturn
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 1684	java/io/IOException:printStackTrace	()V
    //   58: goto -18 -> 40
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_2
    //   65: ifnull +7 -> 72
    //   68: aload_2
    //   69: invokevirtual 1681	java/io/StringWriter:close	()V
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 1682	java/io/PrintWriter:close	()V
    //   80: aload_0
    //   81: athrow
    //   82: astore_2
    //   83: aload_2
    //   84: invokevirtual 1684	java/io/IOException:printStackTrace	()V
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
      if (bhvy.I(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
      for (;;)
      {
        localJSONObject.put("reddot_style", m);
        localJSONObject.put("kandian_mode", e());
        localJSONObject.put("kandian_mode_new", npu.a());
        localJSONObject.put("tab_source", d());
        localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
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
          paramBaseArticleInfo = sfa.a(paramBaseArticleInfo.optString("picture"), 3);
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
    return sfa.a(paramString, 3);
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
    for (localObject = omr.e();; localObject = omr.a())
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
  
  public static ono a()
  {
    ono localono = new ono();
    try
    {
      localono.i();
      localono.j();
      localono.k();
      localono.m();
      localono.l();
      return localono;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localono;
  }
  
  public static ono a(int paramInt1, long paramLong, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    ono localono = new ono();
    try
    {
      paramString1 = localono.a(paramLong).b().c().k(paramInt2).a(paramInt1).l().c(paramString1).j().k().b(paramString2).f(paramInt3).g(paramInt4).h(paramInt5).i(paramInt6).j(paramInt7).d().e().f().g();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return localono;
  }
  
  public static ono a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    localono1 = new ono();
    try
    {
      ono localono2 = localono1.b().c().a(paramInt1).e().f().g().h().a(paramString).d(paramInt2).e(paramInt3).a();
      if (paramBoolean) {}
      for (paramString = "1";; paramString = "2")
      {
        localono2.a("refresh_way", paramString).i().m();
        if (paramInt4 == -1) {
          break;
        }
        localono1.a("pull_image", String.valueOf(paramInt4));
        return localono1;
      }
      return localono1;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static ono a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null))
    {
      SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
      Object localObject;
      int m;
      if (ram.a(paramArticleInfo))
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
        if (localSocializeFeedsInfo.jdField_a_of_type_Qci != null) {}
        for (localObject = Long.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long);; localObject = "")
        {
          localObject = localObject;
          break;
        }
        m = 0;
        break label49;
      }
    }
    return new ono();
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
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
      localJSONObject.put("kandian_mode_new", npu.a());
      localJSONObject.put("algorithm_id", jdField_a_of_type_Qbi.jdField_a_of_type_JavaLangString);
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
    int m;
    try
    {
      localJSONObject.put("algorithm_id", paramLong);
      localJSONObject.put("folder_status", e(paramInt2));
      localJSONObject.put("feeds_type", paramInt1);
      localJSONObject.put("time", System.currentTimeMillis());
      localJSONObject.put("channel_id", paramInt2);
      if (!paramBoolean) {
        break label1405;
      }
      paramInt1 = 2;
      localJSONObject.put("network_type", paramInt1);
      localJSONObject.put("feeds_source", paramString1);
      localJSONObject.put("imei", f());
      localJSONObject.put("imsi", g());
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
      if ((paramInt2 == 0) || (oou.c(paramInt2)))
      {
        if (paramInt2 != 0) {
          break label1410;
        }
        paramString1 = shu.jdField_a_of_type_JavaLangString;
        localJSONObject.put("r_session_id", paramString1);
        if (paramArticleInfo != null)
        {
          if (paramInt2 != 0) {
            break label1418;
          }
          paramString1 = shu.a(paramArticleInfo.mArticleID);
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
      if ((!a(paramArticleInfo)) && (!ram.a(paramArticleInfo)) && (!ram.i(paramArticleInfo)) && (!ram.n(paramArticleInfo)) && (!ram.j(paramArticleInfo)) && (!ram.k(paramArticleInfo))) {
        break label1522;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList == null) {
        break label3185;
      }
      paramInt1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList.size();
      localJSONObject.put("number", paramInt1 + 1);
      m = 0;
      if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList == null)) {
        break label1500;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.size() <= 1) {
        break label1431;
      }
      paramInt1 = 2;
      label384:
      localJSONObject.put("words", paramInt1);
      localJSONObject.put("likes", paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int);
      localJSONObject.put("comment", paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int);
      localJSONObject.put("biu", paramArticleInfo.mSocialFeedInfo.jdField_f_of_type_Int);
      label445:
      if (bhvy.I(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
        break label3190;
      }
      paramInt1 = 1;
      label460:
      localJSONObject.put("reddot_style", paramInt1);
      localJSONObject.put("feeds_type", a(paramArticleInfo));
      localJSONObject.put("kandian_mode", e());
      localJSONObject.put("kandian_mode_new", npu.a());
      localJSONObject.put("tab_source", paramInt4);
      localJSONObject.put("jump_to_channel", paramInt3);
      if ((paramArticleInfo != null) && (paramArticleInfo.feedsFirstExposurePos != -1)) {
        localJSONObject.put("card_pos", paramArticleInfo.feedsFirstExposurePos);
      }
      if (!bhvy.z(a())) {
        break label3195;
      }
      paramInt1 = 1;
      label569:
      localJSONObject.put("hemera_switch", paramInt1);
      localJSONObject.put("proteus_bid", bhvy.a("default_feeds_proteus_offline_bid"));
      paramString1 = bhvy.a("kd_topic_recommend_card_jump_switch");
      if (!(paramString1 instanceof Boolean)) {
        break label3165;
      }
      paramBoolean = ((Boolean)paramString1).booleanValue();
    }
    catch (JSONException paramString1)
    {
      label623:
      long l1;
      paramString1.printStackTrace();
    }
    localJSONObject.put("jump_mode", paramString1);
    localJSONObject.put("star_logo", b(paramArticleInfo));
    l1 = 0L;
    paramLong = l1;
    if (paramArticleInfo != null)
    {
      if ((!ram.c(paramArticleInfo)) && (!ram.n(paramArticleInfo)) && (!ram.j(paramArticleInfo))) {
        break label1575;
      }
      paramLong = l1;
      if (paramArticleInfo.mTopicRecommendFeedsInfo != null)
      {
        paramLong = l1;
        if (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null)
        {
          paramLong = l1;
          if (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            paramLong = l1;
            if (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0) != null) {
              paramLong = ((qds)paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int;
            }
          }
        }
      }
      label763:
      if ((paramArticleInfo.recommentFlag & 0x1000) == 0) {
        break label1630;
      }
      localJSONObject.put("msg_back", "1");
    }
    for (;;)
    {
      localJSONObject.put("topicid", paramLong);
      if (npu.jdField_a_of_type_JavaLangString == null) {
        npu.jdField_a_of_type_JavaLangString = "8.3.0".replace(".", "");
      }
      localJSONObject.put("version", npu.jdField_a_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      if (paramInt2 == 0) {
        localJSONObject.put("preload_flag", ozo.b());
      }
      if ((paramArticleInfo != null) && (paramArticleInfo.mFeedType == 26))
      {
        if (!TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
          localJSONObject.put("touin", paramArticleInfo.mSubscribeID);
        }
        localJSONObject.put("uin", a());
        if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Qaj != null)) {
          localJSONObject.put("likes", paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Qaj.jdField_a_of_type_Int);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          localJSONObject.put("ans_rowkey", paramString2);
        }
        if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Qaj != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Qaj.jdField_a_of_type_JavaLangString))) {
          localJSONObject.put("rowkey", paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Qaj.jdField_a_of_type_JavaLangString);
        }
      }
      npu.a(localJSONObject);
      if (bbwq.a() != 1) {
        break label3207;
      }
      paramString1 = "1";
      label1075:
      localJSONObject.put("simCardType", paramString1);
      if ((paramArticleInfo != null) && (paramArticleInfo.hotWordInfo != null) && (paramArticleInfo.mFeedType == 28))
      {
        if (paramArticleInfo.hotWordInfo.jdField_a_of_type_JavaUtilList == null) {
          break label3214;
        }
        paramInt1 = paramArticleInfo.hotWordInfo.jdField_a_of_type_JavaUtilList.size();
        label1134:
        localJSONObject.put("hotword_card_num", paramInt1);
      }
      if ((paramArticleInfo != null) && (paramArticleInfo.mChannelID == 0L) && (g(paramArticleInfo)))
      {
        if (paramArticleInfo.mCommentCount > 100L) {
          break label3180;
        }
        if (paramArticleInfo.mVideoCommentCount <= 100) {
          break label3219;
        }
        break label3180;
        label1192:
        localJSONObject.put("comment_exposure", paramInt1);
      }
      if ((paramArticleInfo != null) && (ram.f(paramArticleInfo)))
      {
        paramString1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg;
        if (paramString1 != null) {
          localJSONObject.put("ori_feeds_id", paramString1.jdField_a_of_type_JavaLangLong);
        }
      }
      paramInt1 = ReadInJoyBaseFragment.a(paramInt2);
      if (paramInt1 >= 0) {
        localJSONObject.put("entry_path", paramInt1);
      }
      if ((paramArticleInfo == null) || (paramArticleInfo.mProteusTemplateBean == null)) {
        break label1644;
      }
      paramString1 = paramArticleInfo.mProteusTemplateBean.getDataAttribute(null);
      if ((paramString1 == null) || (paramString1.entrySet() == null)) {
        break label1644;
      }
      paramString1 = paramString1.entrySet().iterator();
      while ((paramString1 != null) && (paramString1.hasNext()))
      {
        paramString3 = (Map.Entry)paramString1.next();
        paramString2 = (String)paramString3.getKey();
        paramString3 = paramString3.getValue();
        localJSONObject.put(paramString2, "" + paramString3);
      }
      return localJSONObject;
      label1405:
      paramInt1 = 1;
      break;
      label1410:
      paramString1 = olj.jdField_a_of_type_JavaLangString;
      break label148;
      label1418:
      paramString1 = olj.a(paramArticleInfo.mArticleID);
      break label178;
      label1431:
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        paramInt1 = 1;
        break label384;
      }
      paramInt1 = m;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.size() != 0) {
        break label384;
      }
      paramInt1 = m;
      if (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString)) {
        break label384;
      }
      paramInt1 = 1;
      break label384;
      label1500:
      paramInt1 = m;
      if (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString)) {
        break label384;
      }
      paramInt1 = 1;
      break label384;
      label1522:
      localJSONObject.put("number", 0);
      localJSONObject.put("words", 0);
      localJSONObject.put("likes", 0);
      localJSONObject.put("comment", 0);
      localJSONObject.put("biu", 0);
      break label445;
      label1575:
      if ((i(paramArticleInfo)) && ((paramArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 7) || (paramArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 8)))
      {
        paramLong = paramArticleInfo.mPolymericInfo.jdField_f_of_type_Long;
        break label763;
      }
      paramLong = paramArticleInfo.businessId;
      break label763;
      label1630:
      localJSONObject.put("msg_back", "0");
    }
    label1644:
    if (oou.c(paramInt2)) {
      localJSONObject.put("cmd", bhvy.g());
    }
    if (m())
    {
      paramInt1 = 1;
      localJSONObject.put("interact_bar", paramInt1);
      paramBoolean = false;
      if (paramArticleInfo != null)
      {
        paramBoolean = paramArticleInfo.isPGCShortContent();
        if ((TextUtils.isEmpty(paramArticleInfo.proteusItemsData)) || (!paramArticleInfo.proteusItemsData.contains("article_main_body_text"))) {
          break label3251;
        }
        paramInt1 = 1;
        break label3224;
        label1726:
        paramString1 = shu.a(paramArticleInfo.mChannelID);
        if ((paramString1 != null) && (paramString1.get(Long.valueOf(paramArticleInfo.mArticleID)) != null))
        {
          localJSONObject.put("main_text_read_time", ((shz)paramString1.get(Long.valueOf(paramArticleInfo.mArticleID))).jdField_a_of_type_Long);
          break label3236;
          label1792:
          localJSONObject.put("short_content_rsc", paramInt1);
          paramString1 = new StringBuilder().append("");
          if (paramArticleInfo == null) {
            break label3264;
          }
          paramInt1 = paramArticleInfo.isSuperTop;
          label1827:
          localJSONObject.put("keep_top", paramInt1);
          if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramArticleInfo.mReportCommonData))) {
            break label3269;
          }
          paramString1 = paramArticleInfo.mReportCommonData;
          label1868:
          localJSONObject.put("report_common_data", paramString1);
          if (TextUtils.isEmpty(Build.BRAND)) {
            break label3276;
          }
          paramString1 = Build.BRAND;
          label1893:
          localJSONObject.put("device_brand", paramString1);
          if (TextUtils.isEmpty(Build.MODEL)) {
            break label3283;
          }
          paramString1 = Build.MODEL;
          label1918:
          localJSONObject.put("device_type", paramString1);
          if ((paramArticleInfo != null) && ((paramArticleInfo.isPGCShortContent()) || (paramArticleInfo.isAccountShown)))
          {
            localJSONObject.put("click_area", paramArticleInfo.click_area);
            paramArticleInfo.click_area = 0;
            if (!paramArticleInfo.isShowGif) {
              break label2599;
            }
            localJSONObject.put("short_content_gif", 1);
            localJSONObject.put("gif_playmode", ComponentPGCShortContentBig.jdField_a_of_type_Int);
          }
          localJSONObject.put("account_expose_card", c(paramArticleInfo));
          if (paramArticleInfo == null) {
            break label3290;
          }
        }
      }
    }
    label2599:
    label2646:
    label3290:
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
      if ((!localJSONObject.has("jump_src")) && (qaa.a().a(paramArticleInfo, false, qaa.jdField_a_of_type_Int)))
      {
        localJSONObject.put("jump_src", qae.a(paramArticleInfo));
        label2140:
        if ((paramInt2 == 0) && (paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.adReportCommonData))) {
          localJSONObject.put("bytes_ad_report_common_data", paramArticleInfo.adReportCommonData);
        }
        if (paramInt2 == 41695)
        {
          paramString1 = osg.a().a();
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
          if ((ozy.a() == -1) || (ozy.a() == 0)) {
            break label2646;
          }
          localJSONObject.put("mainfeeds_showcase", ozy.a());
          localJSONObject.put("configchannel_name", ozy.a());
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
          localJSONObject.put("zhitiao_num_daily", pcb.a(BaseApplicationImpl.getApplication(), paramString1));
          localJSONObject.put("zhitiao_sum", qcb.jdField_c_of_type_Int);
          localJSONObject.put("tag", paramString3.j);
          localJSONObject.put("zhitiao_show", paramString3.jdField_b_of_type_Int);
        }
        if ((paramArticleInfo == null) || (paramArticleInfo.mFeedType != 35) || (paramArticleInfo.multiVideoColumnInfo == null)) {
          break label2749;
        }
        paramString1 = paramArticleInfo.multiVideoColumnInfo;
        localJSONObject.put("column_id", paramString1.jdField_a_of_type_Int);
        if (paramString1.jdField_a_of_type_JavaUtilList.size() <= 0) {
          break label2670;
        }
        paramString2 = new JsonArray();
        paramString3 = paramString1.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString3.hasNext()) {
          paramString2.add(((qdf)paramString3.next()).jdField_a_of_type_JavaLangString);
        }
        localJSONObject.put("main_text_read_time", 0);
        break label3256;
        localJSONObject.put("short_content_gif", 0);
        break;
        if ((paramArticleInfo == null) || (!a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
          break label2140;
        }
        localJSONObject.put("jump_src", i());
        break label2140;
        localJSONObject.put("mainfeeds_showcase", 0);
      }
      localJSONObject.put("all_rowkey", paramString2);
      label2670:
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
      if ((paramArticleInfo != null) && (paramArticleInfo.mNewPolymericInfo != null) && (paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 15))
      {
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
        if (paramString1 != null) {
          localJSONObject.put("rowkey", paramString1);
        }
      }
      label2932:
      String str2;
      if (jdField_c_of_type_Boolean)
      {
        paramInt1 = 1;
        localJSONObject.put("from_aio", paramInt1);
        paramString3 = "";
        str2 = "";
        paramString2 = paramString3;
      }
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qce.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          paramString2 = paramString3;
          paramString1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qce.jdField_a_of_type_JavaLangString;
          str1 = str2;
          paramString3 = paramString1;
          paramString2 = paramString1;
          if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qcu.jdField_b_of_type_JavaLangString))
          {
            paramString2 = paramString1;
            str1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qcu.jdField_b_of_type_JavaLangString;
            paramString3 = paramString1;
          }
        }
        catch (NullPointerException paramString1)
        {
          paramString1.printStackTrace();
          String str1 = str2;
          paramString3 = paramString2;
          continue;
        }
        if (!TextUtils.isEmpty(paramString3)) {
          localJSONObject.put("rowkey1", paramString3);
        }
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        localJSONObject.put("url", str1);
        return localJSONObject;
        paramInt1 = 0;
        break label2932;
        paramString1 = paramString3;
        paramString2 = paramString3;
        if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qcx.jdField_f_of_type_JavaLangString))
        {
          paramString2 = paramString3;
          paramString1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qcx.jdField_f_of_type_JavaLangString;
        }
      }
      label3165:
      paramBoolean = false;
      if (paramBoolean)
      {
        paramString1 = "2";
        break label623;
        label3180:
        paramInt1 = 1;
        break label1192;
        label3185:
        paramInt1 = 0;
        break;
        label3190:
        paramInt1 = 0;
        break label460;
        label3195:
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
          break label3256;
        }
        break label1726;
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label3259;
        }
        paramInt1 = 1;
        break label1792;
        paramInt1 = 0;
        break;
        paramInt1 = 0;
        break label3224;
        break label1726;
      }
      paramInt1 = 0;
      break label1792;
      paramInt1 = 0;
      break label1827;
      paramString1 = "";
      break label1868;
      paramString1 = "";
      break label1893;
      paramString1 = "";
      break label1918;
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
        if (bbfj.h(paramContext))
        {
          paramInt = 1;
          localJSONObject.put("network_type", paramInt);
          localJSONObject.put("os", "1");
          localJSONObject.put("version", "8.3.0".replace(".", ""));
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
  
  public static JSONObject a(qbs paramqbs)
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
        switch (paramqbs.jdField_a_of_type_Int)
        {
        default: 
          localJSONObject.put("use_type", m);
          if (m == 2)
          {
            l1 = paramqbs.jdField_b_of_type_Long;
            localJSONObject.put("type_id", l1);
            localJSONObject.put("algorithm_id", paramqbs.jdField_e_of_type_Long);
            return localJSONObject;
          }
          long l1 = paramqbs.jdField_f_of_type_Long;
          continue;
          continue;
        }
      }
      catch (JSONException paramqbs)
      {
        paramqbs.printStackTrace();
        return localJSONObject;
      }
      int m = 2;
      continue;
      m = 1;
      continue;
      m = 3;
    }
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
      localObject = ((QQAppInterface)localObject).a();
      if (localObject == null) {
        break label168;
      }
      localObject = ((QQMessageFacade)localObject).b(ajsd.aA, 7220);
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
    jdField_a_of_type_Int = (int)(paramFloat / paramResources.getDimensionPixelSize(2131298607) + 0.5F);
  }
  
  public static void a(int paramInt)
  {
    jdField_d_of_type_Int = paramInt;
    jdField_a_of_type_Qbi.jdField_a_of_type_Int = jdField_d_of_type_Int;
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
  
  public static void a(int paramInt, long paramLong, qtv paramqtv, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    qzb localqzb = new qzb("", "", "", "").a(paramInt).b(paramLong);
    if (paramqtv != null) {
      localqzb.e(paramqtv.jdField_g_of_type_Long).d(paramqtv.jdField_g_of_type_Int);
    }
    if (paramBaseArticleInfo != null) {
      localqzb.g(paramBaseArticleInfo.innerUniqueID).G(a(paramBaseArticleInfo));
    }
    if (paramBoolean) {}
    for (paramqtv = "1";; paramqtv = "0")
    {
      nol.a(null, "", "0X8007DBB", "0X8007DBB", 0, 0, paramqtv, "", "", localqzb.a().a(), false);
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
        new pbu(null, null, por.a(), null).b(localArrayList);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("ReadInJoyUtils", 1, "reportRealTimeKandianAction error ", paramString1);
    }
  }
  
  public static void a(int paramInt, List<bfuw> paramList)
  {
    bfuw localbfuw;
    if ((paramInt & 0x1) != 0)
    {
      localbfuw = new bfuw();
      localbfuw.jdField_a_of_type_Int = 0;
      localbfuw.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131718429);
      localbfuw.jdField_b_of_type_Int = 2130842287;
      paramList.add(localbfuw);
    }
    if ((paramInt & 0x2) != 0)
    {
      localbfuw = new bfuw();
      localbfuw.jdField_a_of_type_Int = 1;
      localbfuw.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131718433);
      localbfuw.jdField_b_of_type_Int = 2130842291;
      paramList.add(localbfuw);
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
      nol.a(null, null, str, str, 0, 0, "", "", "", new qzb(null, null, null, null).e(paramLong).a().a(), false);
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
    rnu.a("FastWebActivity.show");
    osg.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    Intent localIntent = new Intent(paramActivity, FastWebActivity.class);
    localIntent.putExtra("fast_web_article_info", paramArticleInfo);
    paramActivity.startActivityForResult(localIntent, 10922);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, ram paramram, int paramInt)
  {
    a(paramActivity, paramArticleInfo, paramram, paramInt);
    osg.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramram.notifyDataSetChanged();
    if (sou.a(paramArticleInfo))
    {
      paramram = new Intent(paramActivity, PublicAccountImageCollectionMainActivity.class);
      paramram.putExtra("source_for_report", 9);
      sou.a(paramActivity, paramram, String.valueOf(paramArticleInfo.innerUniqueID));
      return;
    }
    paramInt = paramram.a();
    long l1 = paramArticleInfo.mRecommendSeq;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (ram.b(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!ram.f(paramArticleInfo)) {
        localObject1 = ((qds)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdq.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString;
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
    localBundle.putLong("recommendSeq", l1);
    localBundle.putInt("channelid", paramInt);
    localBundle.putInt("strategyid", paramArticleInfo.mStrategyId);
    localBundle.putLong("algorithmid", paramArticleInfo.mAlgorithmID);
    localBundle.putInt("articalChannelId", 9);
    localBundle.putStringArray("insertPluginsArray", new String[] { "pubAccountPreload" });
    localBundle.putBoolean("ip_connect", sfe.m);
    l1 = System.currentTimeMillis();
    localBundle.putLong("startOpenPageTime", l1);
    localBundle.putLong("click_time", l1);
    localBundle.putLong("available_memory", bbdh.e());
    localBundle.putBoolean("preload_tool_white_list", f());
    Intent localIntent = new Intent(paramActivity, ReadInJoyArticleDetailActivity.class);
    localObject2 = PreloadManager.a((String)localObject2);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if ((bbdx.b(ajsd.cG + (String)localObject1)) && (PreloadManager.a().b((String)localObject1) != null))
    {
      localBundle.putString("read_in_joy_from_cache", (String)localObject1);
      if (!paramram.a(paramInt, paramArticleInfo.mArticleID))
      {
        paramArticleInfo = PreloadManager.a();
        if ((NetworkState.getNetworkType() != 1) && (NetworkState.getNetworkType() != 4) && (NetworkState.getNetworkType() != 5)) {
          break label655;
        }
        paramram = paramArticleInfo.a((String)localObject1);
        if ((paramram != null) && (paramram.size() > 0))
        {
          ThreadManager.post(new ReadInJoyUtils.23(paramArticleInfo, (seu)paramram.get(0)), 5, null, false);
          if (paramram.size() <= 1) {
            break label643;
          }
          localBundle.putString("preload_iamge_url", ((seu)paramram.get(1)).jdField_a_of_type_JavaLangString);
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
        localBundle.putString("preload_iamge_url", ((seu)paramArticleInfo.get(0)).jdField_a_of_type_JavaLangString);
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
      if ((!bbbm.b()) && (!bbbm.d()))
      {
        paramSystemBarCompact.setStatusBarColor(-7829368);
        return;
      }
      paramSystemBarCompact.setStatusBarColor(-7829368);
      paramSystemBarCompact.setStatusBarDarkMode(true);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!bbbm.b()) && (!bbbm.d()))
    {
      a(paramActivity, true);
      paramSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!bbbm.d())
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
    a(paramContext, paramInt, false);
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    a(paramContext, paramInt, paramBoolean, "");
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean, String paramString)
  {
    int m = 2;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)a().getManager(162);
    int n = localKandianMergeManager.d();
    Object localObject1 = localKandianMergeManager.a();
    String str;
    if ((localObject1 == null) || (TextUtils.isEmpty(((KandianMsgBoxRedPntInfo)localObject1).mJumpUrl)))
    {
      str = omj.jdField_h_of_type_JavaLangString + n + "&message_entry=" + paramInt;
      localObject1 = rvx.a(a()) + "&adtag=1&privateLetters=" + n + "&message_entry=" + paramInt;
      Object localObject2 = localObject1;
      if (paramBoolean)
      {
        n = baxn.b(paramContext, (float)bbdh.l()) / 3;
        localObject2 = (String)localObject1 + "&v_present_radius=10&v_present=2&v_rij_floating=1&v_present_bar=0&v_nav_immer=1&hideNav=1&v_present_auto_top=0&v_present_top=" + n;
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString)) {
        localObject1 = (String)localObject2 + "&msgId=" + paramString;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "person message box url: " + str);
      }
      if (!Boolean.valueOf(bhvy.r(a())).booleanValue()) {
        break label422;
      }
      paramString = new Bundle();
      if (paramInt != 6) {
        break label412;
      }
      paramInt = m;
    }
    for (;;)
    {
      label273:
      if (paramInt != -1) {
        paramString.putInt("floating_window_scene", paramInt);
      }
      paramString.putInt("requestCode", 20001);
      rvx.a(paramContext, ajya.a(2131713119), (String)localObject1, paramString);
      for (;;)
      {
        ThreadManager.excute(new ReadInJoyUtils.22(localKandianMergeManager), 64, null, true);
        return;
        str = ((KandianMsgBoxRedPntInfo)localObject1).mJumpUrl + "&privateLetters=" + n + "&message_entry=" + paramInt;
        localObject1 = rvx.a(a()) + "&adtag=2&privateLetters=" + n + "&message_entry=" + paramInt;
        break;
        label412:
        if (paramInt != 5) {
          break label450;
        }
        paramInt = 3;
        break label273;
        label422:
        paramString = new Bundle();
        paramString.putInt("requestCode", 20001);
        a(paramContext, str, paramString);
      }
      label450:
      paramInt = -1;
    }
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
    Object localObject3 = omj.jdField_e_of_type_JavaLangString;
    Object localObject1;
    if (((String)localObject3).contains("uin=")) {
      if (paramInt1 == 0) {
        localObject1 = ((String)localObject3).replace("uin=", "uin=" + bbco.encodeToString(String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long).getBytes(), 0).replace('\n', ' ').trim());
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
        if (((!ram.i(paramArticleInfo)) && (!ram.k(paramArticleInfo))) || ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 5))) {
          localObject3 = ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong);
        }
      }
      else
      {
        if ((paramInt1 != 3) && (paramInt1 != 5) && (paramInt1 != 2)) {
          break label1032;
        }
        localObject1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaLangLong;
        localObject1 = (String)localObject3 + String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaLangLong);
        localObject4 = new Bundle();
        if (qkb.a(paramArticleInfo))
        {
          localObject3 = qkb.a();
          if ((paramInt1 != 1) && (paramInt1 != 3)) {
            break label1068;
          }
          bool = true;
          label269:
          ((qkb)localObject3).a(paramArticleInfo, bool, (String)localObject1);
        }
        localObject3 = localObject1;
        if (paramInt3 >= 0) {
          localObject3 = (String)localObject1 + "&jumptype=" + paramInt3;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUtils", 2, "new social second url:" + (String)localObject3);
        }
        a(paramContext, (String)localObject3, (Bundle)localObject4);
        if ((paramBoolean) || ((!a(paramArticleInfo)) && (!ram.a(paramArticleInfo)) && (!ram.a(paramArticleInfo)) && (!ram.i(paramArticleInfo)) && (!ram.j(paramArticleInfo)) && (!ram.k(paramArticleInfo)))) {
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
          long l1;
          label1032:
          label1068:
          localJSONException.printStackTrace();
          continue;
          localObject2 = "0X8007B64";
          continue;
          nol.a(null, paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, String.valueOf(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, paramContext, false);
          return;
        }
        if (!shu.a(paramArticleInfo.mChannelID)) {
          continue;
        }
        localObject1 = "0X800935D";
        if ((!ram.a(paramArticleInfo)) && (!ram.i(paramArticleInfo)) && (!ram.j(paramArticleInfo)) && (!ram.k(paramArticleInfo))) {
          continue;
        }
        if (ram.o(paramArticleInfo)) {
          break;
        }
        nol.a(null, String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long), (String)localObject1, (String)localObject1, 0, 0, String.valueOf(paramArticleInfo.mFeedId), "0", "" + paramArticleInfo.mStrategyId, paramContext, false);
        return;
        if ((paramInt1 == 1) || (paramInt1 == 3))
        {
          localObject4 = paramArticleInfo.mSubscribeID;
          localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = "";
          }
          localObject1 = ((String)localObject3).replace("uin=", "uin=" + bbco.encodeToString(((String)localObject1).getBytes(), 0).replace('\n', ' ').trim());
          break label92;
        }
        if ((paramInt1 == 2) || (paramInt1 == 4))
        {
          if (ram.o(paramArticleInfo)) {
            break label1167;
          }
          l1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long;
          localObject1 = ((String)localObject3).replace("uin=", "uin=" + bbco.encodeToString(String.valueOf(l1).getBytes(), 0).replace('\n', ' ').trim());
          break label92;
        }
        if (paramInt1 != 5) {
          break label1167;
        }
        l1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
        localObject1 = ((String)localObject3).replace("uin=", "uin=" + bbco.encodeToString(String.valueOf(l1).getBytes(), 0).replace('\n', ' ').trim());
        break label92;
        localObject3 = ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mFeedType);
        break label175;
        l1 = paramArticleInfo.mFeedId;
        localObject1 = (String)localObject3 + String.valueOf(paramArticleInfo.mFeedId);
        break label235;
        bool = false;
        break label269;
        ((JSONObject)localObject1).put("feeds_source", paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long);
      }
      label1167:
      Object localObject2 = localObject3;
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
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, ram paramram, int paramInt)
  {
    if ((paramArticleInfo == null) || (paramram == null)) {
      return;
    }
    int i1 = paramram.a();
    int m;
    if (paramArticleInfo.hasChannelInfo())
    {
      m = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label577;
      }
    }
    Object localObject;
    label577:
    for (int n = 0;; n = 1)
    {
      paramram = c(paramArticleInfo);
      nol.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), i1, m), false);
      nol.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, m));
      localObject = shu.b(i1);
      nol.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject, (String)localObject, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), i1, m, n, bbfj.h(paramContext), paramram, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, e(paramArticleInfo), paramArticleInfo), false);
      nol.a((String)localObject, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), i1, m, n, bbfj.h(paramContext), paramram, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, e(paramArticleInfo), paramArticleInfo));
      paramContext = new ArrayList();
      paramram = new ReportInfo();
      paramram.mUin = a();
      paramram.mSource = 0;
      paramram.mSourceArticleId = paramArticleInfo.mArticleID;
      paramram.mChannelId = i1;
      paramram.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      paramram.mStrategyId = paramArticleInfo.mStrategyId;
      paramram.mOperation = 1;
      paramram.mServerContext = paramArticleInfo.mServerContext;
      paramram.mReadTimeLength = -1;
      paramram.mInnerId = paramArticleInfo.innerUniqueID;
      if ((paramArticleInfo != null) && (!qae.a(paramArticleInfo)) && (!ond.a().a()) && (a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
        paramram.noDifferenceJump = 1;
      }
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label589;
      }
      localObject = new qbz();
      ((qbz)localObject).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci != null) {
        ((qbz)localObject).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
      }
      ((qbz)localObject).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((qbz)localObject).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramArticleInfo == null) || (paramArticleInfo.isEmpty())) {
        break label583;
      }
      ((qbz)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
      paramArticleInfo = paramArticleInfo.iterator();
      while (paramArticleInfo.hasNext())
      {
        qci localqci = (qci)paramArticleInfo.next();
        if (localqci != null) {
          ((qbz)localObject).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqci.jdField_a_of_type_Long));
        }
      }
      m = 0;
      break;
    }
    label583:
    paramram.mFeedsReportData = ((qbz)localObject);
    label589:
    paramArticleInfo = ond.a().a();
    if (paramArticleInfo != null) {
      paramram.srtClickInfo = paramArticleInfo;
    }
    paramContext.add(paramram);
    osg.a().a(paramContext);
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
      ntz localntz = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Ntz;
      b(localntz, paramBaseArticleInfo);
      a(paramContext, localntz);
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
    while (oxt.a(paramContext, paramString)) {
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
      Object localObject = rvx.b(paramString);
      if ((rvx.b(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        rvx.a(paramContext, null, (String)localObject, null);
        return;
      }
      if ((paramString.startsWith("http://clientui.3g.qq.com/mqqapi/")) || (paramString.startsWith("http://clientui.3g.qq.com/mqq/")) || (paramString.startsWith("http://qm.qq.com/cgi-bin/")) || (paramString.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard"))) {}
      for (int m = 1;; m = 0)
      {
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
  
  public static void a(Context paramContext, ntz paramntz)
  {
    if ((paramContext != null) && (paramntz != null) && (!TextUtils.isEmpty(paramntz.jdField_c_of_type_JavaLangString)))
    {
      if (1 == paramntz.jdField_b_of_type_Int) {
        e(paramContext, paramntz.jdField_c_of_type_JavaLangString);
      }
      nol.a(null, null, "0X8009BD5", "0X8009BD5", 0, 0, "", "", "", paramntz.a(), false);
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
      qbz localqbz = new qbz();
      localqbz.jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci != null) {
        localqbz.jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
      }
      localqbz.jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localqbz.jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
      {
        localqbz.jdField_a_of_type_JavaUtilList = new ArrayList();
        paramArticleInfo = paramArticleInfo.iterator();
        while (paramArticleInfo.hasNext())
        {
          qci localqci = (qci)paramArticleInfo.next();
          if (localqci != null) {
            localqbz.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqci.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = localqbz;
    }
    localArrayList.add(localReportInfo);
    osg.a().a(localArrayList);
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
        if ((ram.b(paramBaseArticleInfo)) && (!ram.f(paramBaseArticleInfo)))
        {
          paramBaseArticleInfo.mSinglePicture = a(((qds)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdq.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_d_of_type_JavaLangString, true, true);
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
        if (((paramBaseArticleInfo instanceof ArticleInfo)) && ((ram.a((ArticleInfo)paramBaseArticleInfo)) || (ram.f((ArticleInfo)paramBaseArticleInfo))))
        {
          paramBaseArticleInfo.mSinglePicture = a(paramBaseArticleInfo.mFirstPagePicUrl, ram.g((ArticleInfo)paramBaseArticleInfo), true);
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
      paramBaseArticleInfo.mSinglePicture = b(paramBaseArticleInfo.mFirstPagePicUrl, ram.g((ArticleInfo)paramBaseArticleInfo), true);
    }
    Object localObject = paramBaseArticleInfo.mFirstPagePicUrl;
    boolean bool2 = paramBaseArticleInfo.mShowBigPicture;
    if (paramBaseArticleInfo.mVideoType == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramBaseArticleInfo.mSinglePicture = a((String)localObject, bool2, bool1);
      break;
      label529:
      if (((paramBaseArticleInfo instanceof ArticleInfo)) && (!ram.q((ArticleInfo)paramBaseArticleInfo))) {
        paramBaseArticleInfo.busiType = ((qdc)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_f_of_type_Int;
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
    nol.a(null, null, "0X800A5AB", "0X800A5AB", 0, 0, "", "", "", new qzb(null, null, null, null).X(54).h(paramBaseArticleInfo.getInnerUniqueID()).y(paramInt + 1).a().a(), false);
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
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, qao paramqao)
  {
    if ((paramBaseArticleInfo == null) || (!q(paramBaseArticleInfo))) {
      return;
    }
    paramqao = new qzb(null, null, null, null).X(Integer.valueOf("2007").intValue());
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
    paramqao.r(paramBaseArticleInfo.mKdLiveInfo.jdField_g_of_type_JavaLangString);
    nol.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramqao.a().a(), false);
    paramqao.r(localBaseArticleInfo.mKdLiveInfo.jdField_g_of_type_JavaLangString);
    nol.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramqao.a().a(), false);
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
        ((JSONObject)localObject).put("rowkey", paramKandianRedDotInfo.getRowkey());
        ((JSONObject)localObject).put("folder_status", paramKandianRedDotInfo.forderStatus);
        ((JSONObject)localObject).put("report_time", NetConnInfoCenter.getServerTimeMillis());
        ((JSONObject)localObject).put("articleID", paramKandianRedDotInfo.articleIDList.get(0));
        nol.a(null, "CliOper", "", "", "0X80081DB", "0X80081DB", 0, 0, "", paramKandianRedDotInfo.articleIDList.get(0) + "", paramKandianRedDotInfo.strategyID + "", ((JSONObject)localObject).toString(), false);
        osx.a(41, Integer.valueOf(paramKandianRedDotInfo.forderStatus).intValue(), (int)paramKandianRedDotInfo.algorithmID, (int)paramKandianRedDotInfo.strategyID);
        localObject = new ReportInfo();
        ((ReportInfo)localObject).mUin = a();
        ((ReportInfo)localObject).mSourceArticleId = ((Long)paramKandianRedDotInfo.articleIDList.get(0)).longValue();
        ((ReportInfo)localObject).mAlgorithmId = ((int)paramKandianRedDotInfo.algorithmID);
        ((ReportInfo)localObject).mStrategyId = ((int)paramKandianRedDotInfo.strategyID);
        ((ReportInfo)localObject).mOperation = 55;
        ((ReportInfo)localObject).mFolderStatus = Integer.valueOf(paramKandianRedDotInfo.forderStatus).intValue();
        paramKandianRedDotInfo = new ArrayList();
        paramKandianRedDotInfo.add(localObject);
        osg.a().a(paramKandianRedDotInfo);
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
      if ((Build.VERSION.SDK_INT < 23) || (bbbm.b()) || (bbbm.d())) {
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
    if (!bbbm.d())
    {
      paramBaseActivity.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    paramBaseActivity.mSystemBarComp.setStatusBarColor(paramInt);
    paramBaseActivity.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public static void a(BaseActivity paramBaseActivity, View paramView)
  {
    axrn.a(paramBaseActivity).a(a(), "actReadInJoyDDShowPopupMenu", true, 0L, 0L, null, "");
    ArrayList localArrayList = new ArrayList();
    a(bhvy.r(a()), localArrayList);
    if (localArrayList.size() == 0) {
      a(31, localArrayList);
    }
    bfut.a(paramBaseActivity, localArrayList, new onk(paramBaseActivity), new onl(), actj.a(125.0F, paramBaseActivity.getResources()), false, 2130842267, 2131755028).showAsDropDown(paramView);
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
      jdField_a_of_type_Qbi.jdField_a_of_type_Int = m;
      jdField_a_of_type_Qbi.jdField_a_of_type_JavaLangString = ((String)localObject1);
      jdField_a_of_type_Qbi.jdField_b_of_type_JavaLangString = paramQQAppInterface;
      jdField_a_of_type_Qbi.jdField_c_of_type_JavaLangString = ((String)localObject2);
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
              jdField_a_of_type_Qbi.jdField_a_of_type_Long = paramQQAppInterface.optLong("sp_last_kadnian_red_pnt_exposure_time_key", 0L);
              long l1 = paramQQAppInterface.optLong("sp_last_locksc_kadnian_red_pnt_exposure_time_key", -1L);
              if (l1 > 0L) {
                jdField_a_of_type_Qbi.jdField_a_of_type_Long = l1;
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
            jdField_a_of_type_Qbi.jdField_b_of_type_Long = paramMessageRecord.time;
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
        jdField_a_of_type_Qbi.jdField_a_of_type_Long = 0L;
      }
      label578:
      m = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (!bhvy.i()) {
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
    jdField_a_of_type_Qbi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public static void a(String paramString)
  {
    Object localObject = bhvy.a(a(), true, false);
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
      bhvy.a((SharedPreferences.Editor)localObject, true);
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
      nol.a(null, null, "0X8009CCD", "0X8009CCD", 0, 0, "", "", "", localJSONObject.toString(), false);
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
        nol.a(null, "", paramString1, paramString1, 0, 0, String.valueOf(paramLong), str, paramString2, "", false);
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
    long l1 = bhvy.a();
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
        localObject = paramQQAppInterface.a();
      } while (localObject == null);
      localObject = ((QQMessageFacade)localObject).a();
    } while ((localObject == null) || (((akpb)localObject).a(paramString, 1008) <= 0));
    ThreadManager.post(new ReadInJoyUtils.21(paramString, paramQQAppInterface), 8, null, false);
  }
  
  public static void a(String paramString, Object paramObject, boolean paramBoolean)
  {
    if (!(paramObject instanceof Serializable)) {
      throw new RuntimeException("the data obj must implement Serializable interface ! ");
    }
    ThreadManager.executeOnFileThread(new ReadInJoyUtils.10(paramString, paramObject, paramBoolean));
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
      nol.a(null, "", "0X8008C5D", "0X8008C5D", 0, 0, "", "", "", paramString1, false);
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
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, onn paramonn)
  {
    ThreadManager.executeOnNetWorkThread(new ReadInJoyUtils.14(paramString4, paramString3, paramString2, paramString1, paramonn));
  }
  
  public static void a(String paramString, qao paramqao, qzb paramqzb)
  {
    if (paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {}
    long l1;
    do
    {
      return;
      l1 = paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
      localObject1 = pny.a(l1);
    } while (localObject1 == null);
    paramqzb = new qzb(paramqzb.a().a());
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
            paramqzb.a((String)localEntry.getKey(), localEntry.getValue().toString());
          }
        }
        QLog.d("ReadInJoyUtils", 1, "reportArticleItemExpose: " + localArticleInfo + "  bean :" + localArticleInfo.mProteusTemplateBean.getDataAttribute(null));
      }
      for (;;)
      {
        nol.a(null, "CliOper", "", paramqao.jdField_d_of_type_JavaLangString, paramString, paramString, 0, 0, Long.toString(paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramqao.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramqao.jdField_b_of_type_Int), paramqzb.a().a(), false);
        break;
        QLog.d("ReadInJoyUtils", 1, "reportArticleItemExpose: " + localArticleInfo);
      }
    }
    pny.a(l1);
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
    axrn.a(paramAppRuntime.getApplication()).a(null, "actKandianRefreshBackEndTrace", true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("LOOP_ERROR_CODE", Integer.toString(paramInt));
    axrn.a(paramAppRuntime.getApplication()).a(null, "actWebRenderLoopEvent", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("LOOP_STEP", Integer.toString(paramInt));
    localHashMap.put("LOOP_STEP_COST", Long.toString(paramLong));
    axrn.a(paramAppRuntime.getApplication()).a(null, "actWebRenderLoopEventCost", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramLong < 0L) || (paramLong > 30000L)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt));
    axrn.a(paramAppRuntime.getApplication()).a(null, "actKandianGetShareJsonSuccAndCost", paramBoolean, paramLong, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt1));
    localHashMap.put("param_OpCode", String.valueOf(paramInt2));
    axrn.a(paramAppRuntime.getApplication()).a(null, "actKandian0x83eResult", paramBoolean, paramLong, 0L, localHashMap, null);
    QLog.d("ReadInJoyUtils", 1, "reportKandian83eMonitorData| actKandian0x83eResult | retCode ： " + paramInt1 + "| param_OpCode : " + paramInt2);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if ((paramAppRuntime == null) || (paramLong < 0L) || (paramLong > 50000L)) {
      return;
    }
    axrn.a(paramAppRuntime.getApplication()).a(a(), "actKandianRefreshSuccAndCost", paramBoolean, paramLong, 0L, paramHashMap, null);
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
    axrn.a(paramAppRuntime.getApplication()).a(null, "actreportWebRenderPluginEventCost", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return;
    }
    axrn.a(paramAppRuntime.getApplication()).a(null, "actKanDianViolaData", paramBoolean, -1L, -1L, paramHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramAppRuntime == null) {
      return;
    }
    ThreadManager.post(new ReadInJoyUtils.7(paramJSONObject, paramAppRuntime, paramBoolean), 5, null, true);
  }
  
  public static void a(ntz paramntz)
  {
    if (paramntz == null) {
      return;
    }
    nol.a(null, null, "0X8009BD4", "0X8009BD4", 0, 0, "", "", "", paramntz.a(), false);
  }
  
  public static void a(ntz paramntz, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramntz != null) && (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      b(paramntz, paramBaseArticleInfo);
      a(paramntz);
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
        if (ram.a(paramArticleInfo))
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
          if ((localSocializeFeedsInfo == null) || (localSocializeFeedsInfo.jdField_a_of_type_Qci == null)) {
            continue;
          }
          paramJSONObject.put("feeds_source", localSocializeFeedsInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long);
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
  
  public static void a(JSONObject paramJSONObject, ntz paramntz)
  {
    if ((paramJSONObject == null) || (paramntz == null)) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramntz.jdField_b_of_type_JavaLangString)) {}
      for (;;)
      {
        QLog.d("ReadInJoyUtils", 1, "bindMedalData : " + paramJSONObject.toString());
        return;
        if ((paramntz.jdField_c_of_type_Int > 0) && (paramntz.jdField_d_of_type_Int > 0))
        {
          paramJSONObject.put("header_medal_jump_url", paramntz.jdField_c_of_type_JavaLangString);
          paramJSONObject.put("header_medal_wh_rate", Double.valueOf(paramntz.jdField_c_of_type_Int).doubleValue() / paramntz.jdField_d_of_type_Int);
          paramJSONObject.put("header_medal_image_url", paramntz.jdField_b_of_type_JavaLangString);
        }
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public static void a(qao paramqao, String paramString1, String paramString2)
  {
    if ((paramqao == null) || (paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {}
    for (;;)
    {
      return;
      try
      {
        if ((pny.a() != null) && (paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo != null) && (paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null))
        {
          paramString1 = new JSONObject(paramString1);
          if (paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean != null)
          {
            localObject1 = paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getDataAttribute(null);
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
          Object localObject1 = paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList;
          Object localObject2 = pny.a().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Integer localInteger = (Integer)((Iterator)localObject2).next();
            if ((localInteger.intValue() < ((List)localObject1).size()) && (((List)localObject1).get(localInteger.intValue()) != null))
            {
              paramString1.put("rowkey", ((qbo)((List)localObject1).get(localInteger.intValue())).jdField_g_of_type_JavaLangString);
              nol.a(null, "CliOper", "", paramqao.jdField_d_of_type_JavaLangString, paramString2, paramString2, 0, 0, Long.toString(paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramqao.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramqao.jdField_b_of_type_Int), paramString1.toString(), false);
            }
          }
          pny.a();
          return;
        }
      }
      catch (JSONException paramqao) {}
    }
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
    label158:
    label161:
    for (;;)
    {
      return;
      localObject1 = ((QQAppInterface)localObject1).a();
      if (localObject1 != null)
      {
        Object localObject2 = ((QQMessageFacade)localObject1).b(ajsd.aA, 7220);
        if (localObject2 != null)
        {
          if ((localObject2 instanceof MessageForStructing))
          {
            localObject1 = (MessageForStructing)localObject2;
            if (((MessageForStructing)localObject1).structingMsg == null) {
              ((MessageForStructing)localObject1).parse();
            }
          }
          int m;
          if (!paramBoolean)
          {
            m = 1;
            if (((MessageRecord)localObject2).isread) {
              break label158;
            }
          }
          for (;;)
          {
            if ((m | n) == 0) {
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
            m = 0;
            break;
            n = 0;
          }
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject, qao paramqao)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      paramqao = new qzb(null, null, null, null).X(Integer.valueOf("1031").intValue()).s(paramJSONObject.optString("double_videocard_jump_page")).t(paramJSONObject.optString("double_videocard_jump_src")).f(paramqao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      String str;
      if (paramBoolean)
      {
        str = paramJSONObject.optString("column_id");
        if (!TextUtils.isEmpty(str)) {
          paramqao.a("columnId", str);
        }
        paramqao.h(paramJSONObject.optString("all_rowkey"));
        paramqao.u(paramJSONObject.optString("subscript"));
        nol.a(null, null, "0X800A5A8", "0X800A5A8", 0, 0, "", "", "", paramqao.a().a(), false);
        return;
      }
      int m = 0;
      while (m < 2)
      {
        str = paramJSONObject.optString("columnId_" + (m + 1));
        if (!TextUtils.isEmpty(str)) {
          paramqao.a("columnId", str);
        }
        paramqao.h(paramJSONObject.optString("rowKey_" + (m + 1)));
        paramqao.u(paramJSONObject.optString("subscript_" + (m + 1)));
        paramqao.ac(m);
        nol.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramqao.a().a(), false);
        m += 1;
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
      float f1 = bhvy.b(a());
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
    if ((paramBaseArticleInfo.mChannelID != 0L) && (!oou.c((int)paramBaseArticleInfo.mChannelID))) {
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
        boolean bool2 = bhvy.w();
        if (!bool2)
        {
          QLog.e("ReadInJoyUtils", 1, "judgeShouldNoDifferenceJumpToApp is not first no difference jump app today.");
          return false;
        }
        m = ram.c((ArticleInfo)paramBaseArticleInfo);
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
        if (!bbfr.a(paramContext, paramBaseArticleInfo)) {}
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
    return bbfr.a(paramContext, paramBaseArticleInfo);
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    return pym.b(ram.c(paramArticleInfo));
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
  
  public static boolean a(String paramString, long paramLong, ArticleInfo paramArticleInfo)
  {
    if (!bhvy.z(a())) {
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
      paramString = bfnx.a(paramString);
      if ((paramString.containsKey("article_type")) && (!TextUtils.equals("1", (CharSequence)paramString.get("article_type")))) {
        return false;
      }
    }
    return q(paramArticleInfo);
  }
  
  public static boolean a(qda paramqda)
  {
    return (paramqda != null) && (paramqda.jdField_a_of_type_Qcg != null) && (paramqda.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList != null) && ((paramqda.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.size() > 1) || ((paramqda.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.size() == 1) && (!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)paramqda.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString))));
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
          paramString = omr.a();
          if (!b(paramBaseArticleInfo)) {
            break label211;
          }
          m = paramBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
          if (m == 2)
          {
            paramString = omr.b();
            break label216;
            if (m < localJSONArray.length())
            {
              paramBaseArticleInfo = localJSONArray.optJSONObject(m).optString("picture");
              if (TextUtils.isEmpty(paramBaseArticleInfo)) {
                break label221;
              }
              if (!a(paramBaseArticleInfo)) {
                break label208;
              }
              paramBaseArticleInfo = a(paramBaseArticleInfo, ((Integer)paramString.second).intValue(), ((Integer)paramString.first).intValue(), 1);
              arrayOfURL[m] = sfa.a(paramBaseArticleInfo, 3);
              break label221;
            }
          }
          else
          {
            if (m == 3)
            {
              paramString = omr.d();
              break label216;
            }
            if (m != 1) {
              break label211;
            }
            paramString = omr.c();
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
      break label243;
      if (i1 < n)
      {
        localObject1 = (RecentBaseData)localException.get(i1);
        if (localObject1 != null)
        {
          localObject1 = (RecentUserBaseData)localObject1;
          if (!TextUtils.equals(((RecentUserBaseData)localObject1).a(), ajsd.aA))
          {
            if (((RecentUserBaseData)localObject1).a() == 5000) {
              break label248;
            }
            if (((RecentUserBaseData)localObject1).b() > 0)
            {
              int i2 = ((RecentUserBaseData)localObject1).b();
              m = i2 + m;
              break label248;
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
      label243:
      i1 = 0;
      break;
      label248:
      i1 += 1;
      break;
    }
  }
  
  public static int b(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (ram.f(paramArticleInfo)) {
      if (ram.d(paramArticleInfo)) {
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
      if ((!ram.a(paramArticleInfo)) && (paramArticleInfo.mFeedType != 10)) {
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
    qbo localqbo = (qbo)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    if (v(paramBaseArticleInfo)) {
      return 79;
    }
    if (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 15) {
      return 131;
    }
    if (localqbo.jdField_b_of_type_Int == 10) {
      return 78;
    }
    if ((localqbo.jdField_b_of_type_Int == 4) || (localqbo.jdField_b_of_type_Int == 5)) {
      return 76;
    }
    if ((localqbo.jdField_b_of_type_Int == 6) || (localqbo.jdField_b_of_type_Int == 7) || (localqbo.jdField_b_of_type_Int == 8) || (localqbo.jdField_b_of_type_Int == 9) || (localqbo.jdField_b_of_type_Int == 12)) {
      return 77;
    }
    if (localqbo.jdField_b_of_type_Int == 0) {
      return 77;
    }
    QLog.e("FeedItemCellTypeNewPolymericBaseHeader", 1, "新聚合类卡片没有找到对应的FeedCell feedType = " + localqbo.jdField_b_of_type_Int);
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
      ((JSONObject)localObject).put("kandian_mode_new", npu.a());
      ((JSONObject)localObject).put("tab_source", d());
      ((JSONObject)localObject).put("session_id", jdField_e_of_type_JavaLangString);
      ((JSONObject)localObject).put("os", 1);
      ((JSONObject)localObject).put("version", npu.jdField_a_of_type_JavaLangString);
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
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.a())) {
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
      paramBaseArticleInfo = ryp.d(paramBaseArticleInfo.mCardJumpUrl);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "shortContentUrl: " + paramBaseArticleInfo);
      }
    } while (!rvx.b(paramBaseArticleInfo));
    return rvx.b(paramBaseArticleInfo);
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
      Map localMap = bfnx.a(paramString);
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
  
  public static URL b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (a(paramString))
    {
      localObject = omr.c();
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
          if ((((RecentUserBaseData)localObject2).mUser != null) && (((RecentUserBaseData)localObject2).mUser.getType() == 1008) && (saz.b(localQQAppInterface, ((RecentUserBaseData)localObject2).mUser.uin))) {
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
      localJSONObject.put("kandian_mode_new", npu.a());
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
      localObject1 = c(paramArticleInfo);
      nol.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, m), false);
      nol.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), b(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, m));
      localObject2 = shu.b(paramInt);
      nol.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, m, n, bbfj.h(paramContext), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, e(paramArticleInfo), paramArticleInfo), false);
      nol.a((String)localObject2, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), a(paramArticleInfo.mAlgorithmID, a(paramArticleInfo), paramInt, m, n, bbfj.h(paramContext), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, e(paramArticleInfo), paramArticleInfo));
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
      localObject2 = new qbz();
      ((qbz)localObject2).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci != null) {
        ((qbz)localObject2).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
      }
      ((qbz)localObject2).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((qbz)localObject2).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramArticleInfo == null) || (paramArticleInfo.isEmpty())) {
        break label533;
      }
      ((qbz)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
      paramArticleInfo = paramArticleInfo.iterator();
      while (paramArticleInfo.hasNext())
      {
        qci localqci = (qci)paramArticleInfo.next();
        if (localqci != null) {
          ((qbz)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqci.jdField_a_of_type_Long));
        }
      }
      m = 0;
      break;
    }
    label533:
    ((ReportInfo)localObject1).mFeedsReportData = ((qbz)localObject2);
    label540:
    paramContext.add(localObject1);
    osg.a().a(paramContext);
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
    paramString.putExtra("selfSet_leftViewText", ajya.a(2131713116));
    ((Context)localObject).startActivity(paramString);
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(a(paramContext)));
    axrn.a(paramContext).a(paramString, "actKandianVideoPreload", paramBoolean, -1L, 0L, paramHashMap, null);
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
    nol.a(null, null, "0X800A1C3", "0X800A1C3", 0, 0, "", "", "", new qzb(null, null, null, null).h(paramBaseArticleInfo.innerUniqueID).c(paramBaseArticleInfo).d(paramBaseArticleInfo).S(paramInt).a(paramBaseArticleInfo.videoReportInfo).a(paramBaseArticleInfo, false).a().a(), false);
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, String paramString)
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
    nol.a(null, null, "0X800A5AA", "0X800A5AA", 0, 0, "", "", "", new qzb(paramString, null, null, null, null).X(54).h(localStringBuilder.toString()).a().a(), false);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", paramQQAppInterface.getAccount());
    localHashMap.put("param_cpu", String.valueOf(bbdh.b()));
    localHashMap.put("param_totalMem", String.valueOf(bbdh.d()));
    localHashMap.put("param_availableMem", String.valueOf(bbdh.e()));
    localHashMap.put("param_version", "8.3.0");
    axrn.a(BaseApplication.getContext()).a(null, "actUserDeviceInfoReport", true, 100L, 0L, localHashMap, "", true);
  }
  
  public static void b(String paramString)
  {
    jdField_e_of_type_JavaLangString = paramString;
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
      paramObject = bbmx.a(((ByteArrayOutputStream)localObject).toByteArray());
      localObject = bhvy.a(a(), true, paramBoolean);
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
    axrn.a(paramAppRuntime.getApplication()).a(null, "actKandianGetUserInfoSuccAndCost", paramBoolean, paramLong, 0L, localHashMap, null);
  }
  
  public static void b(AppRuntime paramAppRuntime, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return;
    }
    axrn.a(paramAppRuntime.getApplication()).a(null, "actKanDianViolaHttpData", paramBoolean, -1L, -1L, paramHashMap, null, true);
  }
  
  public static void b(ntz paramntz, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramntz != null) {}
    try
    {
      paramntz.jdField_d_of_type_JavaLangString = String.valueOf(paramBaseArticleInfo.mChannelID);
      paramntz.jdField_g_of_type_JavaLangString = String.valueOf(paramBaseArticleInfo.mFeedId);
      paramBaseArticleInfo = (ArticleInfo)paramBaseArticleInfo;
      paramntz.jdField_h_of_type_JavaLangString = String.valueOf(paramBaseArticleInfo.mSubscribeID);
      if ((ram.a(paramBaseArticleInfo)) || (ram.a(paramBaseArticleInfo))) {
        paramntz.jdField_f_of_type_JavaLangString = "5";
      }
      for (;;)
      {
        paramntz.jdField_e_of_type_JavaLangString = "2";
        return;
        if (ram.e(paramBaseArticleInfo)) {
          paramntz.jdField_f_of_type_JavaLangString = "4";
        } else {
          paramntz.jdField_f_of_type_JavaLangString = "0";
        }
      }
      return;
    }
    catch (Exception paramntz) {}
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
        if (!bhvy.i()) {
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
          localJSONObject.put("kandian_mode_new", npu.a());
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
          localJSONObject.put("version", npu.jdField_a_of_type_JavaLangString);
          if (!ReadinjoyTabFrame.c_()) {
            break label256;
          }
          m = 1;
          localJSONObject.put("isInKandian", m);
          if (nth.a != null) {
            localJSONObject.put("channel_id", nth.a.mChannelCoverId);
          }
          nol.a(null, "CliOper", "", null, "0X80081C3", "0X80081C3", 0, 1, null, g(jdField_a_of_type_Qbi.jdField_c_of_type_JavaLangString), jdField_a_of_type_Qbi.jdField_b_of_type_JavaLangString, localJSONObject.toString(), false);
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
      if ((Aladdin.getConfig(254).getIntegerFromString("is_fix_below_15min_click_flag", 0) == 1) && (paramInt1 == 0) && (shu.a())) {
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
    paramLong = l1 - bhvy.a((QQAppInterface)a());
    if (QLog.isColorLevel()) {
      if (paramLong >= omt.jdField_a_of_type_Int) {
        break label90;
      }
    }
    label90:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ReadInJoyUtils", 2, new Object[] { "isNeedToRememberHistoryPos, timeInterval = ", Long.valueOf(paramLong), " , isNeedToRemember = ", Boolean.valueOf(bool) });
      if (paramLong >= omt.jdField_a_of_type_Int) {
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
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(ajsd.aA, 7220);
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
  
  public static boolean b(String paramString)
  {
    Object localObject1 = new ArrayList();
    label50:
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
      m = ((RecentUserBaseData)localObject2).mMenuFlag;
    } while ((m & 0x20) != 0);
    return false;
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
    int m = 1;
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      if (bhvy.I(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
      for (;;)
      {
        ((JSONObject)localObject).put("reddot_style", m);
        ((JSONObject)localObject).put("kandian_mode", e());
        ((JSONObject)localObject).put("kandian_mode_new", npu.a());
        ((JSONObject)localObject).put("tab_source", d());
        ((JSONObject)localObject).put("session_id", jdField_e_of_type_JavaLangString);
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
    Object localObject2 = omj.jdField_e_of_type_JavaLangString;
    Object localObject1 = "";
    if (((String)localObject2).contains("uin")) {
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long > 0L)) {
        localObject1 = String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long);
      }
    }
    for (localObject1 = ((String)localObject2).replace("uin=", "uin=" + bbco.encodeToString(((String)localObject1).getBytes(), 0).replace('\n', ' ').trim());; localObject1 = localObject2)
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
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci != null) {
          localObject1 = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long);
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
          if (pym.a((ArticleInfo)paramBaseArticleInfo) == 2)
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).addAll(((articlesummary.FriendRecommendInfo)paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
            paramBaseArticleInfo = "";
            int m = 0;
            while (m < ((ArrayList)localObject2).size())
            {
              localObject1 = paramBaseArticleInfo + ((ArrayList)localObject2).get(m);
              paramBaseArticleInfo = (BaseArticleInfo)localObject1;
              if (m != ((ArrayList)localObject2).size() - 1) {
                paramBaseArticleInfo = (String)localObject1 + ",";
              }
              m += 1;
            }
            return paramBaseArticleInfo;
          }
          if (pym.a((ArticleInfo)paramBaseArticleInfo) == 1) {
            return ((articlesummary.SpecialTopicInfo)paramBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
          }
          if (pym.a((ArticleInfo)paramBaseArticleInfo) == 3) {
            return paramBaseArticleInfo.mSubscribeID;
          }
          if (ram.a((ArticleInfo)paramBaseArticleInfo)) {
            return paramBaseArticleInfo.mSubscribeID;
          }
          if ((!ram.a((ArticleInfo)paramBaseArticleInfo)) && (!ram.i((ArticleInfo)paramBaseArticleInfo)) && (!ram.j((ArticleInfo)paramBaseArticleInfo)) && (!ram.k((ArticleInfo)paramBaseArticleInfo))) {
            break;
          }
          localObject1 = localObject2;
        } while (paramBaseArticleInfo.mSocialFeedInfo == null);
        localObject1 = localObject2;
      } while (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci == null);
      return String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long);
      if (ram.c((ArticleInfo)paramBaseArticleInfo)) {
        return paramBaseArticleInfo.mSubscribeID;
      }
      if (ram.n((ArticleInfo)paramBaseArticleInfo)) {
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
      Map localMap = bfnx.a(paramString);
      ((StringBuilder)localObject).append(a(localMap, "videoType", paramBaseArticleInfo.busiType + "")).append(a(localMap, "videoVid", paramBaseArticleInfo.mVideoVid)).append(a(localMap, "videoWidth", paramBaseArticleInfo.mVideoJsonWidth + "")).append(a(localMap, "videoHeight", paramBaseArticleInfo.mVideoJsonHeight + "")).append(a(localMap, "videoDuration", paramBaseArticleInfo.mVideoDuration + "")).append(a(localMap, "title", paramBaseArticleInfo.mTitle)).append(a(localMap, "firstPagePicUrl", URLEncoder.encode(paramBaseArticleInfo.mVideoCoverUrl.getPath(), "UTF-8"))).append(a(localMap, "articleContentUrl", URLEncoder.encode(paramBaseArticleInfo.mArticleContentUrl, "UTF-8"))).append(a(localMap, "subscribeName", paramBaseArticleInfo.mSubscribeName)).append(a(localMap, "subscribeID", paramBaseArticleInfo.mSubscribeID)).append(a(localMap, "readinjoyNotDecodeUrl", "1"));
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
        rvx.a(paramContext, ajya.a(2131712864), (String)localObject, localBundle, new oni(paramContext, paramString));
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
      rvx.a(paramContext, ajya.a(2131712840), (String)localObject, localBundle, new onj(paramContext, paramString));
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
    axrn.a(paramContext).a(paramString, "actKandianVideoGetUrl", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (jdField_j_of_type_Boolean)
    {
      jdField_j_of_type_Boolean = false;
      i();
    }
    if (bhvy.k())
    {
      osg.a().d(0);
      osg.a().d(56);
      osg.a().e(40677);
      if (oou.b(oou.b())) {
        osg.a().d(oou.b());
      }
    }
    jdField_i_of_type_Boolean = true;
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
      nol.a(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", paramString, false);
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
    axrn.a(paramAppRuntime.getApplication()).a(null, "actKanDianViolaJsError", paramBoolean, -1L, -1L, paramHashMap, null, true);
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
    if ((paramInt != 0) && (!oou.b(paramInt))) {
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
      paramBaseArticleInfo = (qbo)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      return (paramBaseArticleInfo.jdField_a_of_type_Qbr != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.jdField_a_of_type_Qbr.jdField_a_of_type_JavaLangString));
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
      Object localObject1 = ahnl.a().jdField_a_of_type_JavaUtilList;
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
          if ((((RecentUserBaseData)localObject2).mUser != null) && (((RecentUserBaseData)localObject2).mUser.getType() == 1008) && (saz.b(paramQQAppInterface, ((RecentUserBaseData)localObject2).mUser.uin)))
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
          boolean bool = TextUtils.equals(((RecentUserBaseData)paramQQAppInterface).a(), ajsd.aA);
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
    int m = 1;
    if (jdField_f_of_type_Int != -1) {
      return jdField_f_of_type_Int;
    }
    if (bhvy.i())
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
          if (bhvy.j()) {
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
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("kandian_mode", String.valueOf(e()));
      localJSONObject.put("kandian_mode_new", npu.a());
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
      if (ozo.a()) {}
      for (String str = "1";; str = "0")
      {
        localJSONObject.put("is_requesting_articles", str);
        localJSONObject.put("os", 1);
        localJSONObject.put("version", npu.jdField_a_of_type_JavaLangString);
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
      akpb localakpb = ((QQAppInterface)localObject).a();
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
            i1 = localakpb.a(localRecentUserBaseData.a(), localRecentUserBaseData.mUser.getType());
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
          localStringBuilder.append((String)localObject).append("_").append(localRecentUserBaseData.a()).append("_").append(i1);
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
  
  private static String d(ArticleInfo paramArticleInfo)
  {
    if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
      return "0";
    }
    long l1 = Long.parseLong(paramArticleInfo.mSubscribeID);
    try
    {
      bool = ((akdh)BaseApplicationImpl.getApplication().getRuntime().getManager(56)).a(Long.valueOf(l1), true);
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
    int m = paramBaseArticleInfo.mPackInfoObj.pack_type.get();
    if ((m == 3) && (paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.has()) && (((articlesummary.FriendRecommendInfo)paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.has())) {
      return "1";
    }
    if ((m == 2) && (paramBaseArticleInfo.mPackInfoObj.msg_special_topic_info.has())) {
      return "2";
    }
    return "";
  }
  
  public static String d(String paramString)
  {
    if (bbdh.j() > 720L) {
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
    axrn.a(paramContext).a(a().getAccount(), "actReadInJoyDDShowVideoAS", true, 0L, 0L, null, "");
  }
  
  public static void d(Context paramContext, String paramString)
  {
    Object localObject = amvl.a();
    if (!TextUtils.isEmpty(((amvk)localObject).jdField_a_of_type_JavaLangString))
    {
      String str = ((amvk)localObject).jdField_a_of_type_JavaLangString;
      localObject = str;
      if (!TextUtils.isEmpty(paramString)) {
        localObject = str + "&placeholder=" + Uri.encode(paramString, "utf-8");
      }
      if (System.currentTimeMillis() - jdField_b_of_type_Long > 1000L) {
        awwa.a(null, paramContext, (String)localObject);
      }
      jdField_b_of_type_Long = System.currentTimeMillis();
    }
    for (;;)
    {
      nol.a(null, "CliOper", "", "", "0X80067D3", "0X80067D3", 0, 0, "", "", "", c(), false);
      return;
      paramContext.startActivity(new Intent(paramContext, ReadInJoyNewSearchActivity.class));
    }
  }
  
  public static void d(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    axrn.a(paramContext).a(paramString, "actVideoFeedsStartTime", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    jdField_i_of_type_Boolean = false;
  }
  
  public static void d(String paramString)
  {
    if (jdField_i_of_type_JavaLangString != null) {
      onz.a(jdField_i_of_type_JavaLangString);
    }
    jdField_i_of_type_JavaLangString = paramString;
  }
  
  public static boolean d()
  {
    return (b()) || (c());
  }
  
  public static boolean d(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong.longValue() == 23L);
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
    if (!bhvy.c(paramQQAppInterface))
    {
      QLog.d("ReadInJoyUtils", 1, "r:config false");
      return false;
    }
    if (!SettingCloneUtil.readValue(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), null, "qqsetting_kandian_key", true))
    {
      QLog.d("ReadInJoyUtils", 1, "kandian push disabled");
      return false;
    }
    localObject = bhvy.a(paramQQAppInterface);
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
    return TextUtils.equals(ajsd.aP, paramString);
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
    if (paramInt == ozy.a()) {
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
        actj.a("ReadInJoyUtils", "fs is not number", localNumberFormatException);
      }
      switch (paramInt)
      {
      default: 
        if (oou.c(paramInt)) {
          str = olj.a();
        }
        break;
      case 0: 
        str = jdField_d_of_type_Int + "";
        break;
      case 70: 
        str = olm.a();
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
    if (jdField_a_of_type_Qbi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      jdField_a_of_type_Qbi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isread = true;
    }
  }
  
  private static void e(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_dian_dian", true);
    oeg.a(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772217, 2130772038);
  }
  
  public static void e(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("mqqapi:")) {
        break label69;
      }
      QQAppInterface localQQAppInterface = ram.a();
      if (localQQAppInterface == null) {
        break label36;
      }
      bbex.a(localQQAppInterface, paramContext, paramString).c();
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
    axrn.a(paramContext).a(paramString, "actVideoFeedsScrollIntervalTime", paramBoolean, -1L, 0L, paramHashMap, null);
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
      int n = localException.size();
      int m = 0;
      while (m < n)
      {
        localObject1 = (RecentBaseData)localException.get(m);
        if (localObject1 != null)
        {
          localObject1 = (RecentUserBaseData)localObject1;
          if ((!TextUtils.equals(((RecentUserBaseData)localObject1).a(), ajsd.aA)) && (((RecentUserBaseData)localObject1).a() != 5000))
          {
            int i1 = ((RecentUserBaseData)localObject1).b();
            if (i1 > 0) {
              return true;
            }
          }
        }
        m += 1;
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
  
  public static boolean e(QQAppInterface paramQQAppInterface)
  {
    KeyguardManager localKeyguardManager = (KeyguardManager)BaseApplicationImpl.getContext().getApplicationContext().getSystemService("keyguard");
    return (paramQQAppInterface.isBackground_Pause) || (paramQQAppInterface.isBackground_Stop) || (localKeyguardManager.inKeyguardRestrictedInputMode());
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
        return ((akdh)((AppInterface)localObject).getManager(56)).a(Long.valueOf(paramString));
      }
      return false;
    }
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
    if (!TextUtils.isEmpty(sfe.jdField_g_of_type_JavaLangString))
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
        JSONObject localJSONObject = new JSONObject(sfe.jdField_g_of_type_JavaLangString);
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
        l1 = bbdh.d();
        l2 = bbdh.e();
        i3 = bbdh.b();
        l3 = bbdh.a();
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
    Object localObject;
    if (jdField_h_of_type_Int >= 10) {
      localObject = "null";
    }
    String str;
    do
    {
      return localObject;
      str = bfnn.a("d059d3", 5);
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
      if (oou.c(paramInt)) {
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
    if ((paramBaseArticleInfo == null) || (!oou.c((int)paramBaseArticleInfo.mChannelID)) || (TextUtils.isEmpty(paramBaseArticleInfo.proteusItemsData))) {
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
    if ((!l) && (paramContext != null))
    {
      paramContext = paramContext.getApplicationContext();
      l = true;
      AppNetConnInfo.registerNetChangeReceiver(paramContext, new onm(paramContext));
      g(paramContext);
    }
  }
  
  public static void f(Context paramContext, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (rvx.b(paramString))) {
      rvx.a(paramContext, null, rvx.b(paramString), null);
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
    axrn.a(paramContext).a(paramString, "actKandianVideoBehaviors", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void f(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.a();
    if (localObject == null) {
      return;
    }
    MessageRecord localMessageRecord = ((QQMessageFacade)localObject).b(ajsd.aA, 7220);
    localObject = localMessageRecord;
    if (jdField_a_of_type_Qbi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      if (localMessageRecord != null)
      {
        localObject = localMessageRecord;
        if (localMessageRecord.time > jdField_a_of_type_Qbi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time) {}
      }
      else
      {
        localObject = jdField_a_of_type_Qbi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
    }
    a(paramQQAppInterface, (MessageRecord)localObject);
  }
  
  public static boolean f()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(sfe.jdField_g_of_type_JavaLangString)) {}
    try
    {
      bool = new JSONObject(sfe.jdField_g_of_type_JavaLangString).optBoolean("useNewLogic", false);
      return bool;
    }
    catch (Exception localException) {}
    return false;
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
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.size() > 0);
  }
  
  public static boolean f(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = bfnx.a(paramString);
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
      str = bfnn.b("d059d3", 5);
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
  
  public static void g()
  {
    ThreadManagerV2.excute(new ReadInJoyUtils.25(), 64, null, true);
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
    axrn.a(paramContext).a(paramString, "actKandianVideoBehaviorsSeq", paramBoolean, -1L, 0L, paramHashMap, null);
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
    if (bhvy.r(a()) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean g(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg == null)) {}
    while ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong.longValue() != 17L) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong.longValue() != 16L)) {
      return false;
    }
    return true;
  }
  
  public static boolean g(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return false;
    }
    int m = ram.c((ArticleInfo)paramBaseArticleInfo);
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
      paramString = bfnx.a(paramString);
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
    return omj.jdField_g_of_type_JavaLangString + bbco.encodeToString(paramString.getBytes(), 2);
  }
  
  public static boolean h()
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
  
  public static boolean h(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg == null)) {}
    while ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong.longValue() != 19L) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong.longValue() != 18L)) {
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
      bhvy.e();
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
      if (!((QQAppInterface)localAppRuntime).a.b()) {
        osx.f();
      }
    }
    else {
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new ReadInJoyUtils.2(), 500L);
  }
  
  public static boolean i()
  {
    return Looper.myLooper() == Looper.getMainLooper();
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
    siq.a();
    StringBuilder localStringBuilder = new StringBuilder("{");
    a(localStringBuilder, "probesize", Long.valueOf(bhvy.b()));
    localStringBuilder.append(",");
    a(localStringBuilder, "isFFProbelistSwitch", Boolean.valueOf(bhvy.q()));
    localStringBuilder.append(",");
    a(localStringBuilder, "isDownloadAsyncIo", Boolean.valueOf(bhvy.r()));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static boolean j()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - jdField_e_of_type_Long <= 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "click too fast");
      }
      jdField_e_of_type_Long = l1;
      return true;
    }
    jdField_e_of_type_Long = l1;
    return false;
  }
  
  public static boolean j(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      bool1 = bool2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde != null)
      {
        bool1 = bool2;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Qaj != null)
        {
          bool1 = bool2;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.c != null)
          {
            bool1 = bool2;
            if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.c.size() > 0)
            {
              bool1 = bool2;
              if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Qaj.jdField_b_of_type_Int == 1) {
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
      if ((bhvy.i()) || (jdField_a_of_type_JavaLangInteger.intValue() != 0)) {
        break label151;
      }
      jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
    }
    label151:
    for (int m = 1;; m = 0)
    {
      if ((jdField_a_of_type_JavaLangInteger.intValue() == 2) && (a() != null))
      {
        KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = ((KandianMergeManager)a().getManager(162)).a();
        int n = m;
        if (localKandianMsgBoxRedPntInfo != null)
        {
          n = m;
          if (localKandianMsgBoxRedPntInfo.dataType != 1)
          {
            jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
            n = 2;
          }
        }
        QLog.d("ReadInJoyUtils", 1, "init msgboxUIMode : " + jdField_a_of_type_JavaLangInteger + ", rule : " + n);
      }
      return jdField_a_of_type_JavaLangInteger.intValue();
    }
  }
  
  public static boolean k()
  {
    return oll.a();
  }
  
  public static boolean k(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde == null)) {
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
      if ((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong.intValue() != 21)) {
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
  
  public static int l()
  {
    return Aladdin.getConfig(264).getIntegerFromString("show_timing", 1);
  }
  
  public static boolean l()
  {
    return (((Boolean)bhvy.a("preload_controller", Boolean.valueOf(true))).booleanValue()) && (bhvy.k());
  }
  
  public static boolean l(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde == null)) {
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
        if ((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong.intValue() != 22)) {
          break;
        }
      } while (a(paramArticleInfo, true) == 73);
      return false;
    } while ((paramArticleInfo.mFeedType == 1) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_Int == 4));
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
  
  public static boolean m()
  {
    return Aladdin.getConfig(154).getIntegerFromString("need_show_social_bottom_view", 1) == 1;
  }
  
  public static boolean m(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde == null)) {}
    while (paramArticleInfo.mFeedType != 21) {
      return false;
    }
    return true;
  }
  
  public static boolean m(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mNewPolymericInfo != null) {}
    for (int m = 1; (m != 0) && ((paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 9) || (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 10) || (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 11)); m = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean n()
  {
    return Aladdin.getConfig(176).getIntegerFromString("artical_interact_area", 0) == 1;
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
    return Aladdin.getConfig(176).getIntegerFromString("ad_relative_pos", 0) == 1;
  }
  
  public static boolean o(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong == null)) {}
    while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong.intValue() != 21) {
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
    return Aladdin.getConfig(190).getIntegerFromString("readinjoy_feeds_overdraw_optimize_switch", 1) == 1;
  }
  
  public static boolean p(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong == null)) {}
    while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_b_of_type_JavaLangLong.intValue() != 22) {
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
    return Aladdin.getConfig(253).getIntegerFromString("enable_use_exposure_data", 0) == 1;
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
    switch (ram.c(paramArticleInfo))
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
    return Aladdin.getConfig(255).getIntegerFromString("allow_yaobu_icon_click_report", 0) == 1;
  }
  
  public static boolean r(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 24) && (paramBaseArticleInfo.mNewPolymericInfo != null);
  }
  
  public static boolean s()
  {
    return Aladdin.getConfig(245).getIntegerFromString("kandian_feeds_card_style", 0) == 1;
  }
  
  public static boolean s(BaseArticleInfo paramBaseArticleInfo)
  {
    return paramBaseArticleInfo.mNewPolymericInfo != null;
  }
  
  public static boolean t()
  {
    return (u()) && (!v());
  }
  
  public static boolean t(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mFeedType == 29);
  }
  
  public static boolean u()
  {
    return l() == 2;
  }
  
  public static boolean u(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 20) && (paramBaseArticleInfo.mRecommendFollowInfos != null);
  }
  
  public static boolean v()
  {
    return (ReadinjoyTabFrame.c_()) || (ReadInJoyDailyFragment.a()) || (ReadInJoyNewFeedsActivity.a());
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
    return jdField_d_of_type_Boolean;
  }
  
  public static boolean w(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && ((paramBaseArticleInfo instanceof ArticleInfo)) && (!ram.q((ArticleInfo)paramBaseArticleInfo)) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int == 6);
  }
  
  public static boolean x()
  {
    return Aladdin.getConfig(276).getIntegerFromString("supportPreloadWebProcess", 1) == 1;
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
    return b(pjn.a(paramBaseArticleInfo.mProteusTemplateBean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     onh
 * JD-Core Version:    0.7.0.1
 */