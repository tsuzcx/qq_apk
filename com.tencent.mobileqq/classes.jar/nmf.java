import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.3;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.4;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdDislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AttachedAdData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class nmf
{
  public static int A;
  public static int B;
  public static int C;
  public static int D;
  public static int E;
  public static int F;
  public static int G;
  public static int H;
  public static int I;
  public static int J;
  public static int K;
  public static int L;
  public static int M;
  public static int N;
  public static int O;
  public static int P;
  public static int Q;
  public static int R;
  public static int S;
  public static int T;
  public static int U;
  public static int V;
  public static int W;
  public static int X;
  public static int Y;
  public static int Z;
  public static int a;
  public static String a;
  public static int aA;
  public static int aB = 1;
  public static int aC = 2;
  public static int aD = 1;
  public static int aE = 2;
  public static int aF = 9;
  public static int aG = 10;
  public static int aH = 35;
  public static int aI = 34;
  public static int aJ = 37;
  public static int aK = 18;
  public static int aL = 38;
  public static int aM = 39;
  public static int aN = 33;
  public static int aO;
  public static int aP = 2;
  public static int aa;
  public static int ab;
  public static int ac;
  public static int ad;
  public static int ae;
  public static int af;
  public static int ag;
  public static int ah;
  public static int ai;
  public static int aj;
  public static int ak;
  public static int al;
  public static int am;
  public static int an;
  public static int ao;
  public static int ap;
  public static int aq;
  public static int ar;
  public static int as;
  public static int at;
  public static int au;
  public static int av;
  public static int aw;
  public static int ax;
  public static int ay;
  public static int az;
  public static int b;
  public static String b;
  public static int c;
  private static volatile String c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  public static int k;
  public static int l;
  public static int m;
  public static int n;
  public static int o;
  public static int p;
  public static int q;
  public static int r;
  public static int s;
  public static int t;
  public static int u;
  public static int v;
  public static int w;
  public static int x;
  public static int y;
  public static int z;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
    jdField_d_of_type_Int = 4;
    jdField_e_of_type_Int = 5;
    jdField_f_of_type_Int = 6;
    jdField_g_of_type_Int = 7;
    h = 8;
    i = 9;
    jdField_j_of_type_Int = 15;
    k = 80;
    jdField_l_of_type_Int = 81;
    jdField_m_of_type_Int = 108;
    jdField_n_of_type_Int = 109;
    jdField_o_of_type_Int = 110;
    jdField_p_of_type_Int = 16;
    q = 17;
    r = 18;
    s = 19;
    t = 20;
    u = 21;
    v = 23;
    w = 116;
    x = 117;
    y = 118;
    z = 24;
    A = 25;
    B = 26;
    C = 27;
    D = 28;
    E = 27;
    F = 1;
    G = 2;
    H = 3;
    I = 4;
    J = 42;
    K = 1;
    L = 3;
    M = 4;
    N = 5;
    O = 7;
    P = 10;
    Q = 11;
    R = 8;
    S = 12;
    T = 13;
    U = 15;
    V = 17;
    W = 18;
    X = 20;
    Y = 21;
    Z = 22;
    aa = 23;
    ab = 24;
    ac = 25;
    ad = 26;
    ae = 27;
    af = 28;
    ag = 29;
    ah = 30;
    ai = 31;
    aj = 32;
    ak = 34;
    al = 35;
    am = 36;
    an = 37;
    ao = 1;
    ap = 1;
    aq = 2;
    ar = 3;
    as = 4;
    at = 8;
    au = 15;
    av = 16;
    aw = 17;
    ax = 21;
    ay = 1000;
    az = 1;
    aA = 2;
    jdField_a_of_type_JavaLangString = "ad_complain_tel";
    jdField_b_of_type_JavaLangString = "ad_complain_txt";
  }
  
  public static double a(BaseArticleInfo paramBaseArticleInfo, Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {
      return 0.0D;
    }
    SosoInterface.SosoLbsInfo localSosoLbsInfo = akug.a("readinjoy_feed_ad_distance");
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null))
    {
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mAdExtInfo)) {}
    }
    for (;;)
    {
      return 0.0D;
      try
      {
        paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.mAdExtInfo);
        double d1 = paramBaseArticleInfo.getDouble(paramString1);
        double d2 = paramBaseArticleInfo.getDouble(paramString2);
        double d3 = localSosoLbsInfo.a.a;
        double d4 = localSosoLbsInfo.a.b;
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "getADPosition cached latitude =  " + d3 + " longitude = " + d4 + " adLatitude = " + d1 + " adLongitude = " + d2);
        }
        if ((d3 <= 0.0D) || (d3 >= 90.0D) || (d4 <= 0.0D) || (d4 >= 180.0D) || (d1 <= 0.0D) || (d1 >= 90.0D) || (d2 <= 0.0D) || (d2 >= 180.0D)) {
          continue;
        }
        return TencentLocationUtils.distanceBetween(d3, d4, d1, d2);
      }
      catch (Exception paramBaseArticleInfo) {}
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition not  cached ......");
      }
      if (a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "getADPosition Permission PERMISSION_GRANTED");
        }
        a(paramContext);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("NativeAdUtils", 2, "getADPosition Permission DENY,need to permission ...");
      }
    }
  }
  
  public static double a(double[] paramArrayOfDouble, Context paramContext)
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = akug.a("readinjoy_feed_ad_distance");
    double d1;
    double d2;
    double d3;
    double d4;
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null))
    {
      d1 = paramArrayOfDouble[0];
      d2 = paramArrayOfDouble[1];
      d3 = localSosoLbsInfo.a.a;
      d4 = localSosoLbsInfo.a.b;
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition cached latitude =  " + d3 + " longitude = " + d4 + " adLatitude = " + d1 + " adLongitude = " + d2);
      }
      if ((d3 > 0.0D) && (d3 < 90.0D) && (d4 > 0.0D) && (d4 < 180.0D) && (d1 > 0.0D) && (d1 < 90.0D) && (d2 > 0.0D) && (d2 < 180.0D)) {}
    }
    for (;;)
    {
      return 0.0D;
      return TencentLocationUtils.distanceBetween(d3, d4, d1, d2);
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition not  cached ......");
      }
      if (a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "getADPosition Permission PERMISSION_GRANTED");
        }
        a(paramContext);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("NativeAdUtils", 2, "getADPosition Permission DENY,need to permission ...");
      }
    }
  }
  
  public static int a(Context paramContext, nld paramnld)
  {
    if ((paramContext == null) || (paramnld == null)) {}
    do
    {
      DownloadInfo localDownloadInfo;
      do
      {
        do
        {
          return -1;
          paramContext = paramnld.jdField_f_of_type_JavaLangString;
          paramnld = paramnld.jdField_d_of_type_JavaLangString;
          if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(paramnld))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramnld + " false");
        return -1;
        localDownloadInfo = bdkp.a().a(paramnld);
        if (localDownloadInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramnld + " false");
      return -1;
      if (localDownloadInfo.a() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramnld + " true");
        }
        return localDownloadInfo.jdField_f_of_type_Int;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramnld + " false");
    return -1;
  }
  
  public static int a(AdData paramAdData)
  {
    if (oal.a(paramAdData)) {
      return ac;
    }
    return K;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, String paramString3, View.OnClickListener paramOnClickListener2, String paramString4)
  {
    paramContext = new Dialog(paramContext, 2131755791);
    paramContext.setContentView(2131558883);
    TextView localTextView = (TextView)paramContext.findViewById(2131365151);
    if (localTextView != null)
    {
      if (paramString1 != null) {
        localTextView.setText(paramString1);
      }
    }
    else
    {
      paramString1 = (TextView)paramContext.findViewById(2131365147);
      if (paramString1 != null)
      {
        if (paramString4 == null) {
          break label154;
        }
        paramString1.setText(paramString4);
      }
      label72:
      paramString1 = (TextView)paramContext.findViewById(2131365136);
      if (paramString1 != null)
      {
        if (paramString2 == null) {
          break label163;
        }
        paramString1.setText(paramString2);
        if (paramOnClickListener1 != null) {
          paramString1.setOnClickListener(paramOnClickListener1);
        }
      }
    }
    for (;;)
    {
      paramString1 = (TextView)paramContext.findViewById(2131365142);
      if (paramString1 != null)
      {
        if (paramString3 == null) {
          break label172;
        }
        paramString1.setText(paramString3);
        if (paramOnClickListener2 != null) {
          paramString1.setOnClickListener(paramOnClickListener2);
        }
      }
      return paramContext;
      localTextView.setVisibility(8);
      break;
      label154:
      paramString1.setVisibility(8);
      break label72;
      label163:
      paramString1.setVisibility(8);
    }
    label172:
    paramString1.setVisibility(8);
    return paramContext;
  }
  
  public static VideoAdInfo a(AdvertisementInfo paramAdvertisementInfo)
  {
    VideoAdInfo localVideoAdInfo = new VideoAdInfo();
    if (paramAdvertisementInfo != null)
    {
      localVideoAdInfo.jdField_a_of_type_Long = paramAdvertisementInfo.mAdFetchTime;
      localVideoAdInfo.jdField_a_of_type_Int = paramAdvertisementInfo.mAdPosLayout;
      localVideoAdInfo.jdField_b_of_type_Long = paramAdvertisementInfo.mAdPosID;
      localVideoAdInfo.jdField_c_of_type_Long = paramAdvertisementInfo.mChannelID;
      localVideoAdInfo.jdField_b_of_type_Int = paramAdvertisementInfo.mAdKdPos;
      localVideoAdInfo.jdField_a_of_type_JavaLangString = paramAdvertisementInfo.mAdCl;
      localVideoAdInfo.jdField_b_of_type_JavaLangString = paramAdvertisementInfo.mAdImg;
      localVideoAdInfo.jdField_c_of_type_JavaLangString = paramAdvertisementInfo.mAdImgs;
      localVideoAdInfo.jdField_d_of_type_JavaLangString = paramAdvertisementInfo.mAdTxt;
      localVideoAdInfo.jdField_e_of_type_JavaLangString = paramAdvertisementInfo.mAdDesc;
      localVideoAdInfo.jdField_f_of_type_JavaLangString = paramAdvertisementInfo.mAdRl;
      localVideoAdInfo.jdField_g_of_type_JavaLangString = paramAdvertisementInfo.mAdApurl;
      localVideoAdInfo.jdField_h_of_type_JavaLangString = paramAdvertisementInfo.mAdTraceId;
      localVideoAdInfo.i = paramAdvertisementInfo.mAdProductId;
      localVideoAdInfo.jdField_c_of_type_Int = paramAdvertisementInfo.mAdProductType;
      localVideoAdInfo.jdField_d_of_type_Int = paramAdvertisementInfo.mAdType;
      localVideoAdInfo.jdField_j_of_type_JavaLangString = paramAdvertisementInfo.mAdLandingPage;
      localVideoAdInfo.k = paramAdvertisementInfo.mAdPrice;
      localVideoAdInfo.jdField_l_of_type_JavaLangString = paramAdvertisementInfo.mAdBtnTxt;
      localVideoAdInfo.jdField_m_of_type_JavaLangString = paramAdvertisementInfo.mAdViewId;
      localVideoAdInfo.jdField_n_of_type_JavaLangString = paramAdvertisementInfo.mAdCustomizedInvokeUrl;
      localVideoAdInfo.jdField_o_of_type_JavaLangString = paramAdvertisementInfo.mAdCorporationName;
      localVideoAdInfo.jdField_p_of_type_JavaLangString = paramAdvertisementInfo.mAdCorporateImageName;
      localVideoAdInfo.q = paramAdvertisementInfo.mAdCorporateLogo;
      localVideoAdInfo.jdField_d_of_type_Long = paramAdvertisementInfo.mAdUin;
      localVideoAdInfo.r = paramAdvertisementInfo.mAdExt;
      localVideoAdInfo.s = paramAdvertisementInfo.mAdVideoUrl;
      localVideoAdInfo.jdField_e_of_type_Int = paramAdvertisementInfo.mAdCostType;
      localVideoAdInfo.jdField_e_of_type_Long = paramAdvertisementInfo.mAdAid;
      localVideoAdInfo.jdField_f_of_type_Int = paramAdvertisementInfo.mAdLayout;
      localVideoAdInfo.jdField_g_of_type_Int = paramAdvertisementInfo.mAdMaterialId;
      localVideoAdInfo.t = paramAdvertisementInfo.mAdVia;
      localVideoAdInfo.v = paramAdvertisementInfo.mAdExtInfo;
      localVideoAdInfo.jdField_l_of_type_Int = paramAdvertisementInfo.mAdJumpMode;
      localVideoAdInfo.w = paramAdvertisementInfo.mAdAppJson;
      localVideoAdInfo.x = paramAdvertisementInfo.mAdAppDownLoadSchema;
      localVideoAdInfo.y = paramAdvertisementInfo.mAdCanvasJson;
      localVideoAdInfo.z = paramAdvertisementInfo.mAdLandingPageReportUrl;
      localVideoAdInfo.jdField_g_of_type_Long = paramAdvertisementInfo.mAdAdvertiseId;
      localVideoAdInfo.jdField_n_of_type_Int = paramAdvertisementInfo.mAdDestType;
      localVideoAdInfo.A = paramAdvertisementInfo.mAdEffectUrl;
      localVideoAdInfo.jdField_h_of_type_Long = paramAdvertisementInfo.mAdNocoId;
      localVideoAdInfo.B = paramAdvertisementInfo.mAdDownloadApiUrl;
      localVideoAdInfo.jdField_o_of_type_Int = paramAdvertisementInfo.mC2SSwitch;
      localVideoAdInfo.jdField_f_of_type_JavaUtilArrayList = paramAdvertisementInfo.mC2SClickUrl;
      localVideoAdInfo.jdField_g_of_type_JavaUtilArrayList = paramAdvertisementInfo.mC2SExposureUrl;
      localVideoAdInfo.jdField_p_of_type_Int = paramAdvertisementInfo.replay;
      paramAdvertisementInfo = paramAdvertisementInfo.mAdDislikeInfos;
      if ((paramAdvertisementInfo != null) && (!paramAdvertisementInfo.isEmpty()))
      {
        localVideoAdInfo.jdField_e_of_type_JavaUtilArrayList = new ArrayList(paramAdvertisementInfo.size());
        int i1 = 0;
        while (i1 < paramAdvertisementInfo.size())
        {
          AdDislikeInfo localAdDislikeInfo = (AdDislikeInfo)paramAdvertisementInfo.get(i1);
          VideoAdInfo.NegFeedback localNegFeedback = new VideoAdInfo.NegFeedback();
          localNegFeedback.jdField_a_of_type_JavaLangString = localAdDislikeInfo.jdField_a_of_type_JavaLangString;
          localNegFeedback.jdField_a_of_type_Long = localAdDislikeInfo.jdField_a_of_type_Long;
          localVideoAdInfo.jdField_e_of_type_JavaUtilArrayList.add(localNegFeedback);
          i1 += 1;
        }
      }
      localVideoAdInfo.a(localVideoAdInfo.v);
    }
    return localVideoAdInfo;
  }
  
  public static AdvertisementInfo a(VideoAdInfo paramVideoAdInfo)
  {
    AdvertisementInfo localAdvertisementInfo = new AdvertisementInfo();
    if (paramVideoAdInfo != null)
    {
      localAdvertisementInfo.mAdTraceId = paramVideoAdInfo.jdField_h_of_type_JavaLangString;
      localAdvertisementInfo.mAdFetchTime = paramVideoAdInfo.jdField_a_of_type_Long;
      localAdvertisementInfo.mAdViewId = paramVideoAdInfo.jdField_m_of_type_JavaLangString;
      localAdvertisementInfo.mAdPosID = paramVideoAdInfo.jdField_b_of_type_Long;
      localAdvertisementInfo.mAdKdPos = paramVideoAdInfo.jdField_b_of_type_Int;
      localAdvertisementInfo.mAdProductId = paramVideoAdInfo.i;
      localAdvertisementInfo.mAdProductType = paramVideoAdInfo.jdField_c_of_type_Int;
      localAdvertisementInfo.mAdRl = paramVideoAdInfo.jdField_f_of_type_JavaLangString;
      localAdvertisementInfo.mAdAdvertiseId = paramVideoAdInfo.jdField_g_of_type_Long;
      localAdvertisementInfo.mAdVideoUrl = paramVideoAdInfo.s;
      localAdvertisementInfo.mAdAid = paramVideoAdInfo.jdField_e_of_type_Long;
      localAdvertisementInfo.mAdTraceId = paramVideoAdInfo.jdField_h_of_type_JavaLangString;
      localAdvertisementInfo.mAdViewId = paramVideoAdInfo.jdField_m_of_type_JavaLangString;
      localAdvertisementInfo.mAdProductId = paramVideoAdInfo.i;
      localAdvertisementInfo.mAdVia = paramVideoAdInfo.t;
      localAdvertisementInfo.mAdNocoId = paramVideoAdInfo.jdField_h_of_type_Long;
      localAdvertisementInfo.mAdApurl = paramVideoAdInfo.jdField_g_of_type_JavaLangString;
      localAdvertisementInfo.mAdRl = paramVideoAdInfo.jdField_f_of_type_JavaLangString;
      localAdvertisementInfo.mAdEffectUrl = paramVideoAdInfo.A;
      localAdvertisementInfo.mAdLandingPageReportUrl = paramVideoAdInfo.z;
      localAdvertisementInfo.mAdLandingPage = paramVideoAdInfo.jdField_j_of_type_JavaLangString;
      localAdvertisementInfo.mAdCanvasJson = paramVideoAdInfo.y;
      localAdvertisementInfo.mAdDestType = paramVideoAdInfo.jdField_n_of_type_Int;
      localAdvertisementInfo.mAdExt = paramVideoAdInfo.r;
      localAdvertisementInfo.mAdExtInfo = paramVideoAdInfo.v;
      localAdvertisementInfo.mAdAppDownLoadSchema = paramVideoAdInfo.x;
      localAdvertisementInfo.mAdCustomizedInvokeUrl = paramVideoAdInfo.jdField_n_of_type_JavaLangString;
      localAdvertisementInfo.mAdProductType = paramVideoAdInfo.jdField_c_of_type_Int;
      VideoAdInfo.a(paramVideoAdInfo);
      localAdvertisementInfo.mC2SSwitch = paramVideoAdInfo.jdField_o_of_type_Int;
      localAdvertisementInfo.mC2SClickUrl = paramVideoAdInfo.jdField_f_of_type_JavaUtilArrayList;
      localAdvertisementInfo.mC2SExposureUrl = paramVideoAdInfo.jdField_g_of_type_JavaUtilArrayList;
      localAdvertisementInfo.mPopFormH5Url = paramVideoAdInfo.C;
      localAdvertisementInfo.mShowAdButton = paramVideoAdInfo.jdField_b_of_type_Boolean;
      localAdvertisementInfo.replay = paramVideoAdInfo.jdField_p_of_type_Int;
      localAdvertisementInfo.mRevisionVideoType = paramVideoAdInfo.jdField_m_of_type_Int;
      localAdvertisementInfo.isMultiyVideo = paramVideoAdInfo.jdField_a_of_type_Boolean;
      localAdvertisementInfo.processAdExt(paramVideoAdInfo.r);
    }
    return localAdvertisementInfo;
  }
  
  public static String a()
  {
    for (;;)
    {
      try
      {
        if (jdField_c_of_type_JavaLangString == null)
        {
          localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
          if (localObject1 == null) {
            jdField_c_of_type_JavaLangString = "";
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("NativeAdUtils", 2, "getAdCookie cookie=" + jdField_c_of_type_JavaLangString);
          }
          localObject1 = jdField_c_of_type_JavaLangString;
          return localObject1;
        }
        Object localObject1 = bhvh.a((AppRuntime)localObject1, true, false);
        if (localObject1 != null) {
          jdField_c_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("sp_key_ad_cookie", "");
        } else {
          jdField_c_of_type_JavaLangString = "";
        }
      }
      finally {}
    }
  }
  
  public static String a(double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return "";
    }
    paramDouble = Math.ceil(paramDouble);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramDouble < 1000.0D) {
      localStringBuilder.append((int)paramDouble).append('m');
    }
    for (;;)
    {
      return localStringBuilder.toString();
      long l1 = Math.round(paramDouble / 1000.0D);
      if (l1 < 1000L) {
        localStringBuilder.append(l1).append("km");
      } else {
        localStringBuilder.append("999km");
      }
    }
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo, Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    double d1 = a(paramBaseArticleInfo, paramContext, paramString1, paramString2);
    paramBaseArticleInfo = localObject;
    if (d1 > 0.0D) {
      paramBaseArticleInfo = a(d1);
    }
    return paramBaseArticleInfo;
  }
  
  public static String a(String paramString)
  {
    return bdhu.a(paramString);
  }
  
  public static JSONObject a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt1 == paramInt2)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bt", paramInt1);
      localJSONObject.put("et", paramInt2);
      localJSONObject.put("bf", paramInt3);
      localJSONObject.put("ef", paramInt4);
      localJSONObject.put("pp", paramInt8);
      localJSONObject.put("pa", paramInt5);
      localJSONObject.put("pb", paramInt6);
      localJSONObject.put("duration", paramInt7);
      localJSONObject.put("ps", paramInt9);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static JSONObject a(Context paramContext)
  {
    // Byte code:
    //   0: new 324	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 814	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: invokestatic 844	oai:a	()Ljava/lang/String;
    //   12: astore 5
    //   14: invokestatic 846	oai:c	()Ljava/lang/String;
    //   17: astore 4
    //   19: aload 5
    //   21: invokestatic 322	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +328 -> 352
    //   27: aload 5
    //   29: invokevirtual 851	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   32: astore_3
    //   33: aload 6
    //   35: ldc_w 853
    //   38: aload_3
    //   39: invokestatic 857	bdhv:d	(Ljava/lang/String;)Ljava/lang/String;
    //   42: invokevirtual 851	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   45: invokevirtual 860	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   48: pop
    //   49: aload 6
    //   51: ldc_w 862
    //   54: iconst_1
    //   55: invokevirtual 820	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   58: pop
    //   59: aload 4
    //   61: astore 5
    //   63: aload_3
    //   64: astore 4
    //   66: aload 5
    //   68: astore_3
    //   69: new 864	yyt
    //   72: dup
    //   73: invokespecial 865	yyt:<init>	()V
    //   76: astore 5
    //   78: aload 5
    //   80: ldc_w 867
    //   83: putfield 868	yyt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: invokestatic 874	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   89: aload 5
    //   91: invokestatic 879	yys:a	(Landroid/content/Context;Lyyt;)Lyyu;
    //   94: astore 5
    //   96: aload 5
    //   98: ifnull +51 -> 149
    //   101: aload 5
    //   103: getfield 884	yyu:a	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   106: ifnull +43 -> 149
    //   109: aload 6
    //   111: ldc_w 853
    //   114: aload 5
    //   116: getfield 884	yyu:a	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   119: getfield 889	tencent/gdt/qq_ad_get$QQAdGet$DeviceInfo:muid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   122: invokevirtual 893	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   125: invokevirtual 860	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   128: pop
    //   129: aload 6
    //   131: ldc_w 862
    //   134: aload 5
    //   136: getfield 884	yyu:a	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   139: getfield 896	tencent/gdt/qq_ad_get$QQAdGet$DeviceInfo:muid_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   142: invokevirtual 900	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   145: invokevirtual 820	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   148: pop
    //   149: aload 6
    //   151: ldc_w 902
    //   154: invokestatic 905	njo:a	()I
    //   157: invokevirtual 820	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   160: pop
    //   161: aload 6
    //   163: ldc_w 907
    //   166: aload_0
    //   167: invokestatic 912	vyp:c	(Landroid/content/Context;)Ljava/lang/String;
    //   170: invokevirtual 860	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   173: pop
    //   174: iconst_0
    //   175: istore_1
    //   176: invokestatic 916	bbct:e	()I
    //   179: istore_2
    //   180: iload_2
    //   181: istore_1
    //   182: aload 6
    //   184: ldc_w 918
    //   187: iload_1
    //   188: invokevirtual 820	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   191: pop
    //   192: aload 6
    //   194: ldc_w 920
    //   197: invokestatic 922	bbct:e	()Ljava/lang/String;
    //   200: invokevirtual 860	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   203: pop
    //   204: aload 6
    //   206: ldc_w 924
    //   209: invokestatic 925	bbct:c	()Ljava/lang/String;
    //   212: invokevirtual 860	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   215: pop
    //   216: aload 6
    //   218: ldc_w 927
    //   221: invokestatic 930	com/tencent/common/config/AppSetting:a	()I
    //   224: invokestatic 934	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   227: invokevirtual 860	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   230: pop
    //   231: aload 6
    //   233: ldc_w 936
    //   236: invokestatic 941	fi:a	()J
    //   239: invokestatic 944	fi:a	(J)Ljava/lang/String;
    //   242: invokevirtual 860	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   245: pop
    //   246: aload 6
    //   248: ldc_w 946
    //   251: aload_0
    //   252: invokestatic 949	onk:c	(Landroid/content/Context;)Ljava/lang/String;
    //   255: invokevirtual 860	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   258: pop
    //   259: aload 6
    //   261: ldc_w 951
    //   264: aload_3
    //   265: invokevirtual 860	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload 6
    //   271: ldc_w 953
    //   274: iconst_2
    //   275: invokevirtual 820	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   278: pop
    //   279: aload 6
    //   281: ldc_w 955
    //   284: invokestatic 957	bbct:k	()Ljava/lang/String;
    //   287: invokevirtual 860	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   290: pop
    //   291: aload 6
    //   293: ldc_w 959
    //   296: invokestatic 961	bbct:i	()Ljava/lang/String;
    //   299: invokevirtual 860	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   302: pop
    //   303: aload 6
    //   305: ldc_w 963
    //   308: invokestatic 965	bbct:h	()Ljava/lang/String;
    //   311: invokevirtual 860	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   314: pop
    //   315: aload 6
    //   317: ldc_w 967
    //   320: aload 4
    //   322: invokevirtual 860	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   325: pop
    //   326: aload_0
    //   327: ifnull +22 -> 349
    //   330: aload 6
    //   332: ldc_w 969
    //   335: aload_0
    //   336: invokevirtual 975	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   339: ldc_w 977
    //   342: invokestatic 982	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   345: invokevirtual 860	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   348: pop
    //   349: aload 6
    //   351: areturn
    //   352: aload 4
    //   354: astore_3
    //   355: aload 4
    //   357: invokestatic 322	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   360: ifne +98 -> 458
    //   363: aload 4
    //   365: ldc_w 984
    //   368: ldc_w 757
    //   371: invokevirtual 987	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   374: invokevirtual 990	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   377: astore_3
    //   378: aload 6
    //   380: ldc_w 853
    //   383: aload_3
    //   384: invokestatic 857	bdhv:d	(Ljava/lang/String;)Ljava/lang/String;
    //   387: invokevirtual 851	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   390: invokevirtual 860	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   393: pop
    //   394: aload 6
    //   396: ldc_w 862
    //   399: iconst_3
    //   400: invokevirtual 820	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   403: pop
    //   404: goto +54 -> 458
    //   407: astore_0
    //   408: ldc_w 346
    //   411: iconst_1
    //   412: new 348	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 992
    //   422: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_0
    //   426: invokevirtual 993	java/lang/Exception:toString	()Ljava/lang/String;
    //   429: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: aload 6
    //   440: areturn
    //   441: astore_0
    //   442: aload_0
    //   443: invokevirtual 994	java/lang/Exception:printStackTrace	()V
    //   446: aconst_null
    //   447: areturn
    //   448: astore 5
    //   450: goto -268 -> 182
    //   453: astore 5
    //   455: goto -209 -> 246
    //   458: aload 5
    //   460: astore 4
    //   462: goto -393 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	paramContext	Context
    //   175	13	1	i1	int
    //   179	2	2	i2	int
    //   32	352	3	localObject1	Object
    //   17	444	4	localObject2	Object
    //   12	123	5	localObject3	Object
    //   448	1	5	localException1	Exception
    //   453	6	5	localException2	Exception
    //   7	432	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   330	349	407	java/lang/Exception
    //   9	59	441	java/lang/Exception
    //   69	96	441	java/lang/Exception
    //   101	149	441	java/lang/Exception
    //   149	174	441	java/lang/Exception
    //   182	231	441	java/lang/Exception
    //   246	326	441	java/lang/Exception
    //   355	404	441	java/lang/Exception
    //   408	438	441	java/lang/Exception
    //   176	180	448	java/lang/Exception
    //   231	246	453	java/lang/Exception
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAdvertisementInfo != null) {}
    for (;;)
    {
      try
      {
        localJSONObject.put("traceid", paramAdvertisementInfo.mAdTraceId);
        localJSONObject.put("pull_time", paramAdvertisementInfo.mAdFetchTime);
        localJSONObject.put("apurl", paramAdvertisementInfo.mAdApurl);
        localJSONObject.put("rl", paramAdvertisementInfo.mAdRl);
        localJSONObject.put("viewid", paramAdvertisementInfo.mAdViewId);
        localJSONObject.put("posid", paramAdvertisementInfo.mAdPosID);
        localJSONObject.put("channel_id", paramAdvertisementInfo.mChannelID);
        localJSONObject.put("kd_pos", paramAdvertisementInfo.mAdKdPos);
        localJSONObject.put("cl", paramAdvertisementInfo.mAdCl);
        localJSONObject.put("pos_layout", paramAdvertisementInfo.mAdPosLayout);
        localJSONObject.put("product_id", paramAdvertisementInfo.mAdProductId);
        localJSONObject.put("product_type", paramAdvertisementInfo.mAdProductType);
        localJSONObject.put("ad_type", paramAdvertisementInfo.mAdType);
        localJSONObject.put("price", paramAdvertisementInfo.mAdPrice);
        localJSONObject.put("customized_invoke_url", paramAdvertisementInfo.mAdCustomizedInvokeUrl);
        localJSONObject.put("corporation_name", paramAdvertisementInfo.mAdCorporationName);
        localJSONObject.put("corporate_image_name", paramAdvertisementInfo.mAdCorporateImageName);
        localJSONObject.put("corporate_logo", paramAdvertisementInfo.mAdCorporateLogo);
        localJSONObject.put("ad_uin", paramAdvertisementInfo.mAdUin);
        localJSONObject.put("ext", paramAdvertisementInfo.mAdExt);
        localJSONObject.put("video_url", paramAdvertisementInfo.mVideoVid);
        localJSONObject.put("cost_type", paramAdvertisementInfo.mAdCostType);
        localJSONObject.put("aid", paramAdvertisementInfo.mAdAid);
        localJSONObject.put("img", paramAdvertisementInfo.mAdImg);
        localJSONObject.put("img_s", paramAdvertisementInfo.mAdImgs);
        localJSONObject.put("txt", paramAdvertisementInfo.mAdTxt);
        localJSONObject.put("desc", paramAdvertisementInfo.mAdDesc);
        localJSONObject.put("ad_layout", paramAdvertisementInfo.mAdLayout);
        localJSONObject.put("ad_material_id", paramAdvertisementInfo.mAdMaterialId);
        localJSONObject.put("algo_id", "" + paramAdvertisementInfo.mAlgorithmID);
        localJSONObject.put("replay", paramAdvertisementInfo.replay);
        a(localJSONObject, paramAdvertisementInfo);
        if (paramAdvertisementInfo.mProgressFromFeeds)
        {
          if (paramAdvertisementInfo.downloadState == 0) {
            localJSONObject.put("download_state", "0");
          }
        }
        else
        {
          if (paramVideoAdInfo != null)
          {
            if (localJSONObject.isNull("apurl")) {
              localJSONObject.put("apurl", paramVideoAdInfo.jdField_g_of_type_JavaLangString);
            }
            localJSONObject.put("via", paramVideoAdInfo.t);
            localJSONObject.put("dis_channel", paramVideoAdInfo.jdField_j_of_type_Int);
            localJSONObject.put("button_url", paramVideoAdInfo.u);
          }
          localJSONObject.put("cookie", a());
          if (paramInt <= 0) {
            break;
          }
          localJSONObject.put("click_pos", paramInt);
          return localJSONObject;
        }
        if (paramAdvertisementInfo.downloadState == 3)
        {
          localJSONObject.put("download_state", "1");
          continue;
        }
        if (paramAdvertisementInfo.downloadState != 4) {
          break label572;
        }
      }
      catch (JSONException paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
        return localJSONObject;
      }
      localJSONObject.put("download_state", "2");
      continue;
      label572:
      if ((paramAdvertisementInfo.downloadState == 5) || (paramAdvertisementInfo.downloadState == 1)) {
        localJSONObject.put("download_state", "3");
      }
    }
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.clickPos > 0)) {
      localJSONObject.put("click_pos", paramAdvertisementInfo.clickPos);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(AdData paramAdData)
  {
    return a(paramAdData, null);
  }
  
  public static JSONObject a(AdData paramAdData, HashMap<String, Object> paramHashMap)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramAdData != null)
      {
        if (!TextUtils.isEmpty(paramAdData.M)) {
          localJSONObject.put("article_id", paramAdData.M);
        }
        if (!TextUtils.isEmpty(paramAdData.N)) {
          localJSONObject.put("rowkey", paramAdData.N);
        }
        if (!TextUtils.isEmpty(paramAdData.O)) {
          localJSONObject.put("tags", paramAdData.O);
        }
        if (oal.a(paramAdData))
        {
          localJSONObject.put("game_component_type", paramAdData.jdField_a_of_type_Nxz.x);
          localJSONObject.put("game_pkg", paramAdData.jdField_a_of_type_Nxz.jdField_b_of_type_JavaLangString);
        }
        if (paramAdData.jdField_a_of_type_OrgJsonJSONObject != null) {
          localJSONObject.put("article_ad_ext", paramAdData.jdField_a_of_type_OrgJsonJSONObject.toString());
        }
      }
      if ((paramHashMap != null) && (paramHashMap.size() > 0))
      {
        paramAdData = paramHashMap.keySet().iterator();
        while (paramAdData.hasNext())
        {
          String str = (String)paramAdData.next();
          Object localObject = paramHashMap.get(str);
          if (localObject != null) {
            localJSONObject.put(str, localObject);
          }
        }
      }
      return localJSONObject;
    }
    catch (Exception paramAdData)
    {
      paramAdData.printStackTrace();
      return null;
    }
  }
  
  private static JSONObject a(QQAppInterface paramQQAppInterface, AdData paramAdData, int paramInt1, int paramInt2, JSONObject paramJSONObject)
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramQQAppInterface.getAccount());
      localJSONObject.put("ts", NetConnInfoCenter.getServerTimeMillis());
      localJSONObject.put("dinfo", b(paramQQAppInterface.getApplication().getApplicationContext()));
      localJSONObject.put("ver", "8.2.8");
      localJSONObject.put("type", paramInt1);
      localJSONObject.put("stype", paramInt2);
      localJSONObject.put("isdpg", 1);
      if (paramAdData != null)
      {
        if (paramInt1 != 1) {
          break label184;
        }
        paramQQAppInterface = paramAdData.jdField_m_of_type_JavaLangString;
        localJSONObject.put("ext", paramQQAppInterface);
        localJSONObject.put("oudid", paramAdData.s);
        if (!(paramAdData instanceof AttachedAdData)) {
          break label192;
        }
        localJSONObject.put("aname", paramAdData.jdField_j_of_type_JavaLangString);
        localJSONObject.put("posid", paramAdData.jdField_e_of_type_Int);
      }
      for (;;)
      {
        if (paramJSONObject == null) {
          break label226;
        }
        localJSONObject.put("exposureExtraInfo", paramJSONObject);
        return localJSONObject;
        label184:
        paramQQAppInterface = paramAdData.jdField_o_of_type_JavaLangString;
        break;
        label192:
        localJSONObject.put("aname", paramAdData.q);
        localJSONObject.put("posid", paramAdData.i);
      }
      return localJSONObject;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static JSONObject a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HashMap<String, Object> paramHashMap)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("article_id", paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("rowkey", paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("tags", paramString3);
      }
      if ((!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString5)))
      {
        localJSONObject.put("game_component_type", paramString4);
        localJSONObject.put("game_pkg", paramString5);
      }
      if ((paramHashMap != null) && (paramHashMap.size() > 0))
      {
        paramString1 = paramHashMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          paramString3 = paramHashMap.get(paramString2);
          if (paramString3 != null) {
            localJSONObject.put(paramString2, paramString3);
          }
        }
      }
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
  }
  
  public static JSONObject a(HashMap<String, Object> paramHashMap)
  {
    return a(null, paramHashMap);
  }
  
  public static void a(Activity paramActivity, nld paramnld, bdko parambdko)
  {
    if ((paramActivity == null) || (paramnld == null)) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return;
      str1 = paramnld.jdField_f_of_type_JavaLangString;
      str2 = paramnld.jdField_d_of_type_JavaLangString;
      str3 = paramnld.jdField_j_of_type_JavaLangString;
      paramnld = paramnld.i;
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(paramnld)));
    Bundle localBundle = new Bundle();
    localBundle.putString(bdkm.jdField_f_of_type_JavaLangString, str1);
    localBundle.putString(bdkm.jdField_b_of_type_JavaLangString, str2);
    localBundle.putString(bdkm.jdField_j_of_type_JavaLangString, str3);
    localBundle.putString(bdkm.jdField_l_of_type_JavaLangString, paramnld);
    localBundle.putInt(bdkm.k, 2);
    localBundle.putInt(bdkm.E, 0);
    localBundle.putBoolean(bdkm.x, false);
    localBundle.putInt(bdkm.H, 0);
    localBundle.putBoolean(bdkm.y, true);
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "downloadApk pkg:" + str1 + ", appid:" + str2 + ", name:" + paramnld + ", url:" + str3);
    }
    if (parambdko != null) {
      bdkp.a().a(parambdko);
    }
    bdki.a(paramActivity, localBundle, "biz_src_yyb", null, 0);
  }
  
  private static void a(Context paramContext)
  {
    if (aO >= 3) {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition doStartADLocation retryLocationCount >= 3");
      }
    }
    while ((paramContext == null) || (!bbev.g(paramContext))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "getADPosition doStartADLocation network is Available...");
    }
    akug.a(new nmj("readinjoy_feed_ad_distance"));
    aO += 1;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "launchApp pkg:" + paramString);
      }
      paramString = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    } while (paramString == null);
    paramContext.startActivity(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    if (oat.a(paramAdData))
    {
      a(new nyg().a(paramQQAppInterface).a(BaseApplication.getContext()).a(jdField_b_of_type_Int).b(a(paramAdData)).a(oav.a(paramAdData)).d(a(paramAdData)).a());
      return;
    }
    a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 5, 1, null).toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, float paramFloat, long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("exposureArea", paramFloat);
      localJSONObject.put("exposureTime", paramLong);
      if (oat.a(paramAdData))
      {
        a(new nyg().a(paramQQAppInterface).a(BaseApplication.getContext()).a(jdField_b_of_type_Int).b(a(paramAdData)).a(oav.a(paramAdData)).c(localJSONObject).d(a(paramAdData)).a());
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
      a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 5, 1, localJSONObject).toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, int paramInt)
  {
    if (oat.a(paramAdData, false))
    {
      a(new nyg().a(paramQQAppInterface).a(BaseApplication.getContext()).a(jdField_a_of_type_Int).b(K).a(oav.a(paramAdData)).d(a(paramAdData)).d(paramInt).a());
      return;
    }
    a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 1, 3, null).toString());
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "nativeEngineAdReport json:" + paramString);
      }
      if (!TextUtils.isEmpty(paramString))
      {
        WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
        localWebSsoRequestBody.data.set(paramString);
        paramString = new NewIntent(paramQQAppInterface.getApplication(), nou.class);
        paramString.putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_report");
        paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
        paramString.setObserver(new nmh());
        paramQQAppInterface.startServlet(paramString);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    axqw.b(paramQQAppInterface, "dc04719", "ad", "0", paramString1.toUpperCase(), paramString2.toUpperCase(), paramInt1, paramInt2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramQQAppInterface.c());
      localJSONObject.put("adId", paramString1);
      localJSONObject.put("channelId", paramString2);
      localJSONObject.put("info", paramString3);
      localJSONObject.put("version", "8.2.8");
      localJSONObject.put("actionCode", paramInt1);
      localJSONObject.put("subType", paramInt2);
      if (paramInt1 == 4) {
        localJSONObject.put("extValue", paramInt3);
      }
      paramString2 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "doAdReport json:" + paramString2);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = new WebSsoBody.WebSsoRequestBody();
        paramString1.data.set(paramString2);
        paramString2 = new NewIntent(paramQQAppInterface.getApplication(), nou.class);
        paramString2.putExtra("cmd", "KdAdReportSsoSvr.kandian_ad");
        paramString2.putExtra("data", paramString1.toByteArray());
        paramString2.setObserver(new nmg());
        paramQQAppInterface.startServlet(paramString2);
      }
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  public static void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      jdField_c_of_type_JavaLangString = str;
      ThreadManager.executeOnFileThread(new NativeAdUtils.4(str));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(nye paramnye)
  {
    if (paramnye == null) {}
    Context localContext;
    int i1;
    int i2;
    AdvertisementInfo localAdvertisementInfo;
    VideoAdInfo localVideoAdInfo;
    long l1;
    String str;
    JSONObject localJSONObject1;
    int i3;
    JSONObject localJSONObject2;
    Bundle localBundle;
    JSONObject localJSONObject3;
    JSONObject localJSONObject4;
    JSONObject localJSONObject5;
    JSONObject localJSONObject6;
    int i4;
    boolean bool;
    do
    {
      return;
      AppInterface localAppInterface = paramnye.a();
      localContext = paramnye.a();
      i1 = paramnye.a();
      i2 = paramnye.b();
      localAdvertisementInfo = paramnye.a();
      localVideoAdInfo = paramnye.a();
      l1 = paramnye.a();
      str = paramnye.a();
      localJSONObject1 = paramnye.a();
      i3 = paramnye.d();
      localJSONObject2 = paramnye.b();
      localBundle = paramnye.a();
      localJSONObject3 = paramnye.c();
      localJSONObject4 = paramnye.d();
      localJSONObject5 = paramnye.f();
      localJSONObject6 = paramnye.e();
      i4 = paramnye.c();
      bool = paramnye.a();
      paramnye = localAppInterface;
      if (localAppInterface == null)
      {
        paramnye = localAppInterface;
        if (BaseApplicationImpl.sProcessId == 1)
        {
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
          paramnye = localAppInterface;
          if (localAppRuntime != null)
          {
            paramnye = localAppInterface;
            if ((localAppRuntime instanceof QQAppInterface)) {
              paramnye = (QQAppInterface)localAppRuntime;
            }
          }
        }
      }
    } while (paramnye == null);
    ThreadManager.post(new NativeAdUtils.3(localJSONObject3, paramnye.getAccount(), i1, i2, i4, localContext, localAdvertisementInfo, localVideoAdInfo, i3, localJSONObject1, localJSONObject2, localBundle, str, l1, localJSONObject4, localJSONObject6, localJSONObject5, paramnye, bool), 5, null, true);
  }
  
  private static void a(JSONObject paramJSONObject, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramJSONObject != null) && (paramAdvertisementInfo != null) && (paramAdvertisementInfo.gameAdComData != null)) {}
    while ((paramJSONObject == null) || (paramAdvertisementInfo == null) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdExtInfo))) {
      try
      {
        paramJSONObject.put("pkg_name", paramAdvertisementInfo.gameAdComData.jdField_d_of_type_JavaLangString);
        paramJSONObject.put("game_adtag", new JSONObject(paramAdvertisementInfo.gameAdComData.A).optString("ADTAG"));
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
    }
    try
    {
      paramJSONObject.put("extra_data", paramAdvertisementInfo.mAdExtInfo);
      paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
      paramJSONObject.put("game_adtag", paramAdvertisementInfo.optString("game_adtag"));
      paramJSONObject.put("pkg_name", paramAdvertisementInfo.optString("game_pkg_name"));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private static boolean a()
  {
    boolean bool2 = true;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    boolean bool1;
    if (localBaseActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition activity null");
      }
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (Build.VERSION.SDK_INT < 23);
      bool1 = bool2;
    } while (localBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0);
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool1;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = bbfd.a(paramContext, paramString);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("NativeAdUtils", 2, "isAppInstall pkg:" + paramString + " " + bool2);
    return bool2;
  }
  
  public static boolean a(Context paramContext, nld paramnld)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramContext != null)
    {
      if (paramnld != null) {
        break label22;
      }
      bool2 = bool1;
    }
    label22:
    String str1;
    String str2;
    DownloadInfo localDownloadInfo;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool2;
            str1 = paramnld.jdField_f_of_type_JavaLangString;
            str2 = paramnld.jdField_d_of_type_JavaLangString;
            bool2 = bool1;
          } while (TextUtils.isEmpty(str1));
          bool2 = bool1;
        } while (TextUtils.isEmpty(str2));
        localDownloadInfo = bdkp.a().a(str2);
        bool2 = bool1;
      } while (localDownloadInfo == null);
      paramnld = "";
      if (TextUtils.isEmpty(localDownloadInfo.jdField_l_of_type_JavaLangString)) {
        break;
      }
      paramnld = localDownloadInfo.jdField_l_of_type_JavaLangString;
      bool1 = bool3;
      if (!TextUtils.isEmpty(paramnld))
      {
        bool1 = bool3;
        if (new File(paramnld).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("NativeAdUtils", 2, "isPkgExist(" + bool1 + ") pkg:" + str1 + ", appid:" + str2 + ", path:" + paramnld);
    return bool1;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    if (localDownloadInfo.jdField_c_of_type_Int == 0)
    {
      localTMAssistantDownloadTaskInfo2 = bdkp.a().a(localDownloadInfo.jdField_d_of_type_JavaLangString);
      paramContext = paramnld;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = paramnld;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      paramnld = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = bdkp.a().a(localDownloadInfo);
        paramnld = paramContext;
      }
    }
    for (;;)
    {
      paramContext = paramnld;
      if (localTMAssistantDownloadTaskInfo1 != null)
      {
        paramContext = paramnld;
        if (localTMAssistantDownloadTaskInfo1.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo1.mSavePath;
        }
      }
      paramnld = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        break;
      }
      localDownloadInfo.jdField_l_of_type_JavaLangString = paramContext;
      localDownloadInfo.a(4);
      bdkp.a().e(localDownloadInfo);
      paramnld = paramContext;
      break;
      localTMAssistantDownloadTaskInfo2 = bdkp.a().a(localDownloadInfo);
      paramContext = paramnld;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = paramnld;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      paramnld = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = bdkp.a().a(localDownloadInfo.jdField_d_of_type_JavaLangString);
        paramnld = paramContext;
      }
    }
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof AdvertisementInfo)) {}
    for (;;)
    {
      return false;
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
      if (paramBaseArticleInfo.mLocalInfo != null) {
        try
        {
          String str1 = paramBaseArticleInfo.mLocalInfo.jdField_d_of_type_JavaLangString;
          double d1 = Double.parseDouble(paramBaseArticleInfo.mLocalInfo.jdField_e_of_type_JavaLangString);
          if ((Double.parseDouble(str1) != 0.0D) || (d1 != 0.0D))
          {
            str1 = paramBaseArticleInfo.mLocalInfo.jdField_c_of_type_JavaLangString;
            String str2 = paramBaseArticleInfo.mLocalInfo.jdField_f_of_type_JavaLangString;
            paramBaseArticleInfo = paramBaseArticleInfo.mLocalInfo.jdField_b_of_type_JavaLangString;
            if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
            {
              boolean bool = TextUtils.isEmpty(paramBaseArticleInfo);
              if (!bool)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("NativeAdUtils", 2, "hasAddLocationInfo is -> true");
                }
                return true;
              }
            }
          }
        }
        catch (Exception paramBaseArticleInfo) {}
      }
    }
    return false;
  }
  
  public static boolean a(nld paramnld)
  {
    String str1 = paramnld.jdField_f_of_type_JavaLangString;
    String str2 = paramnld.jdField_d_of_type_JavaLangString;
    String str3 = paramnld.jdField_j_of_type_JavaLangString;
    paramnld = paramnld.i;
    Bundle localBundle = new Bundle();
    localBundle.putInt(bdkm.k, 5);
    localBundle.putString(bdkm.jdField_f_of_type_JavaLangString, str1);
    localBundle.putString(bdkm.jdField_b_of_type_JavaLangString, str2);
    localBundle.putString(bdkm.jdField_j_of_type_JavaLangString, str3);
    localBundle.putString(bdkm.jdField_l_of_type_JavaLangString, paramnld);
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "installApk pkg:" + str1 + ", appid:" + str2 + ", name:" + paramnld + ", url:" + str3);
    }
    return bdki.a(localBundle);
  }
  
  public static double[] a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof AdvertisementInfo)) {}
    for (;;)
    {
      return null;
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
      if (paramBaseArticleInfo.mLocalInfo != null) {
        try
        {
          String str = paramBaseArticleInfo.mLocalInfo.jdField_d_of_type_JavaLangString;
          double d1 = nmk.a(paramBaseArticleInfo.mLocalInfo.jdField_e_of_type_JavaLangString, 0.0D);
          double d2 = nmk.a(str, 0.0D);
          if ((d2 != 0.0D) || (d1 != 0.0D)) {
            return new double[] { d1, d2 };
          }
        }
        catch (Exception paramBaseArticleInfo) {}
      }
    }
    return null;
  }
  
  private static JSONObject b(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("dma", oai.c());
        localJSONObject.put("hwm", bbct.i());
        localJSONObject.put("hwma", bbct.h());
        localJSONObject.put("osver", bbct.e());
        localJSONObject.put("imei", oai.a());
        localJSONObject.put("brd", bbct.k());
        localJSONObject.put("ns", nam.a());
        localJSONObject.put("andid", Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
        localJSONObject.put("mid", "mid");
        localJSONObject.put("pf", "android");
        localJSONObject.put("wn", vyp.c(paramContext));
        str = "";
        switch (ajne.b())
        {
        case 1: 
          localJSONObject.put("mnc", str);
          localJSONObject.put("rma", onk.c(paramContext));
          return localJSONObject;
        }
      }
      catch (Exception paramContext)
      {
        String str;
        paramContext.printStackTrace();
        return localJSONObject;
      }
      str = ajyc.a(2131707066);
      continue;
      str = ajyc.a(2131707064);
      continue;
      str = ajyc.a(2131707062);
    }
  }
  
  private static void b(int paramInt, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    if (paramInt == jdField_b_of_type_Int)
    {
      if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mC2SSwitch != 1)) {
        break label271;
      }
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, " C2S AD_EXPOSURE: advertisementInfo = " + paramAdvertisementInfo.toString() + " clickurl = " + paramAdvertisementInfo.mC2SClickUrl + " exposureUrl = " + paramAdvertisementInfo.mC2SExposureUrl);
      }
      yxy.a(0, 1, sht.a(paramAdvertisementInfo));
    }
    label270:
    label271:
    label379:
    do
    {
      do
      {
        break label270;
        break label270;
        if (paramInt == jdField_a_of_type_Int)
        {
          if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mC2SSwitch != 1)) {
            break label379;
          }
          if (QLog.isColorLevel()) {
            QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo = " + paramAdvertisementInfo.toString() + " clickurl = " + paramAdvertisementInfo.mC2SClickUrl + " exposureUrl = " + paramAdvertisementInfo.mC2SExposureUrl);
          }
          yxy.a(1, 1, sht.a(paramAdvertisementInfo));
        }
        for (;;)
        {
          if (paramInt == E)
          {
            if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mC2SSwitch != 1)) {
              break label495;
            }
            if (QLog.isColorLevel()) {
              QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo = " + paramAdvertisementInfo.toString() + " clickurl = " + paramAdvertisementInfo.mC2SVideoPlayUrl + " videoClickUrl = " + paramAdvertisementInfo.mC2SVideoPlayUrl);
            }
            yxy.a(2, 1, sht.a(paramAdvertisementInfo));
          }
          return;
          if ((paramVideoAdInfo == null) || (paramVideoAdInfo.jdField_o_of_type_Int != 1)) {
            break;
          }
          AdvertisementInfo localAdvertisementInfo = a(paramVideoAdInfo);
          if (localAdvertisementInfo == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("NativeAdUtils", 2, " C2S AD_EXPOSURE: advertisementInfo1 = " + localAdvertisementInfo.toString() + " videoAdInfo = " + paramVideoAdInfo.toString() + " clickurl = " + localAdvertisementInfo.mC2SClickUrl + " exposureUrl = " + localAdvertisementInfo.mC2SExposureUrl);
          }
          yxy.a(0, 1, sht.a(localAdvertisementInfo));
          break;
          if ((paramVideoAdInfo != null) && (paramVideoAdInfo.jdField_o_of_type_Int == 1))
          {
            localAdvertisementInfo = a(paramVideoAdInfo);
            if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mC2SSwitch == 1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo1 = " + localAdvertisementInfo.toString() + " videoAdInfo = " + paramVideoAdInfo.toString() + " clickurl = " + localAdvertisementInfo.mC2SClickUrl + " exposureUrl = " + localAdvertisementInfo.mC2SExposureUrl);
              }
              yxy.a(1, 1, sht.a(localAdvertisementInfo));
            }
          }
        }
      } while ((paramVideoAdInfo == null) || (paramVideoAdInfo.jdField_o_of_type_Int != 1));
      paramAdvertisementInfo = a(paramVideoAdInfo);
    } while ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mC2SSwitch != 1));
    label495:
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo1 = " + paramAdvertisementInfo.toString() + " videoAdInfo = " + paramVideoAdInfo.toString() + " clickurl = " + paramAdvertisementInfo.mC2SVideoPlayUrl + " videoClickUrl = " + paramAdvertisementInfo.mC2SVideoPlayUrl);
    }
    yxy.a(2, 1, sht.a(paramAdvertisementInfo));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    if (oat.a(paramAdData))
    {
      a(new nyg().a(paramQQAppInterface).a(BaseApplication.getContext()).a(jdField_l_of_type_Int).b(a(paramAdData)).a(oav.a(paramAdData)).d(a(paramAdData)).a());
      return;
    }
    a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 81, 1, null).toString());
  }
  
  private static boolean b(int paramInt1, int paramInt2, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    return (paramInt2 == ae) || (paramInt1 == B);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    a(paramQQAppInterface, paramAdData, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmf
 * JD-Core Version:    0.7.0.1
 */