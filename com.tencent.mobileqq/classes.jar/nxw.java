import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.2;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.3;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.AdDislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class nxw
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
  public static int aB;
  public static int aC;
  public static int aD;
  public static int aE;
  public static int aF;
  public static int aG;
  public static int aH;
  public static int aI;
  public static int aJ;
  public static int aK;
  public static int aL;
  public static int aM;
  public static int aN;
  public static int aO;
  public static int aP;
  public static int aQ;
  public static int aR;
  public static int aS;
  public static int aT;
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
  public static String c;
  public static int d;
  private static volatile String d;
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
    jdField_p_of_type_Int = 119;
    q = 16;
    r = 17;
    s = 18;
    t = 19;
    u = 20;
    v = 21;
    w = 23;
    x = 116;
    y = 117;
    z = 118;
    A = 24;
    B = 25;
    C = 26;
    D = 27;
    E = 28;
    F = 27;
    G = 1;
    H = 2;
    I = 3;
    J = 4;
    K = 5;
    L = 42;
    M = 1;
    N = 3;
    O = 4;
    P = 5;
    Q = 7;
    R = 10;
    S = 11;
    T = 8;
    U = 12;
    V = 13;
    W = 15;
    X = 17;
    Y = 18;
    Z = 20;
    aa = 21;
    ab = 22;
    ac = 23;
    ad = 24;
    ae = 25;
    af = 26;
    ag = 27;
    ah = 28;
    ai = 29;
    aj = 30;
    ak = 31;
    al = 32;
    am = 34;
    an = 35;
    ao = 36;
    ap = 37;
    aq = 38;
    ar = 39;
    as = 1;
    at = 1;
    au = 2;
    av = 3;
    aw = 4;
    ax = 8;
    ay = 15;
    az = 16;
    aA = 17;
    aB = 21;
    aC = 1000;
    aD = 1;
    aE = 2;
    jdField_a_of_type_JavaLangString = "ad_complain_tel";
    jdField_b_of_type_JavaLangString = "ad_complain_txt";
    aF = 1;
    aG = 2;
    aH = 1;
    aI = 2;
    aJ = 9;
    aK = 10;
    aL = 35;
    aM = 34;
    aN = 37;
    aO = 18;
    aP = 38;
    aQ = 39;
    aR = 33;
    aT = 2;
    jdField_c_of_type_JavaLangString = "game_gift_report";
  }
  
  public static double a(BaseArticleInfo paramBaseArticleInfo, Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {
      return 0.0D;
    }
    SosoInterface.SosoLbsInfo localSosoLbsInfo = aoor.a("readinjoy_feed_ad_distance");
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
    SosoInterface.SosoLbsInfo localSosoLbsInfo = aoor.a("readinjoy_feed_ad_distance");
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
  
  public static int a(Context paramContext, nww paramnww)
  {
    if ((paramContext == null) || (paramnww == null)) {}
    do
    {
      DownloadInfo localDownloadInfo;
      do
      {
        do
        {
          return -1;
          paramContext = paramnww.jdField_f_of_type_JavaLangString;
          paramnww = paramnww.jdField_d_of_type_JavaLangString;
          if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(paramnww))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramnww + " false");
        return -1;
        localDownloadInfo = bivr.a().a(paramnww);
        if (localDownloadInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramnww + " false");
      return -1;
      if (localDownloadInfo.a() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramnww + " true");
        }
        return localDownloadInfo.jdField_f_of_type_Int;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramnww + " false");
    return -1;
  }
  
  public static int a(AdData paramAdData)
  {
    if (opz.a(paramAdData)) {
      return ae;
    }
    if (paramAdData.h()) {
      return an;
    }
    return M;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, String paramString3, View.OnClickListener paramOnClickListener2, String paramString4)
  {
    paramContext = new ReportDialog(paramContext, 2131755823);
    paramContext.setContentView(2131558985);
    TextView localTextView = (TextView)paramContext.findViewById(2131365479);
    if (localTextView != null)
    {
      if (paramString1 != null) {
        localTextView.setText(paramString1);
      }
    }
    else
    {
      paramString1 = (TextView)paramContext.findViewById(2131365475);
      if (paramString1 != null)
      {
        if (paramString4 == null) {
          break label154;
        }
        paramString1.setText(paramString4);
      }
      label72:
      paramString1 = (TextView)paramContext.findViewById(2131365464);
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
      paramString1 = (TextView)paramContext.findViewById(2131365470);
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
        if (jdField_d_of_type_JavaLangString == null)
        {
          localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
          if (localObject1 == null) {
            jdField_d_of_type_JavaLangString = "";
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("NativeAdUtils", 2, "getAdCookie cookie=" + jdField_d_of_type_JavaLangString);
          }
          localObject1 = jdField_d_of_type_JavaLangString;
          return localObject1;
        }
        Object localObject1 = bmqa.a((AppRuntime)localObject1, true, false);
        if (localObject1 != null) {
          jdField_d_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("sp_key_ad_cookie", "");
        } else {
          jdField_d_of_type_JavaLangString = "";
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
    return bisz.a(paramString);
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
    //   0: new 340	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 835	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: invokestatic 865	opp:a	()Ljava/lang/String;
    //   12: astore 5
    //   14: invokestatic 867	opp:c	()Ljava/lang/String;
    //   17: astore 4
    //   19: aload 5
    //   21: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +328 -> 352
    //   27: aload 5
    //   29: invokevirtual 872	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   32: astore_3
    //   33: aload 6
    //   35: ldc_w 874
    //   38: aload_3
    //   39: invokestatic 878	bita:d	(Ljava/lang/String;)Ljava/lang/String;
    //   42: invokevirtual 872	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   45: invokevirtual 881	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   48: pop
    //   49: aload 6
    //   51: ldc_w 883
    //   54: iconst_1
    //   55: invokevirtual 841	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   58: pop
    //   59: aload 4
    //   61: astore 5
    //   63: aload_3
    //   64: astore 4
    //   66: aload 5
    //   68: astore_3
    //   69: new 885	acry
    //   72: dup
    //   73: invokespecial 886	acry:<init>	()V
    //   76: astore 5
    //   78: aload 5
    //   80: ldc_w 888
    //   83: putfield 889	acry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: invokestatic 895	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   89: aload 5
    //   91: invokestatic 900	acrx:a	(Landroid/content/Context;Lacry;)Lacrz;
    //   94: astore 5
    //   96: aload 5
    //   98: ifnull +51 -> 149
    //   101: aload 5
    //   103: getfield 905	acrz:a	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   106: ifnull +43 -> 149
    //   109: aload 6
    //   111: ldc_w 874
    //   114: aload 5
    //   116: getfield 905	acrz:a	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   119: getfield 910	tencent/gdt/qq_ad_get$QQAdGet$DeviceInfo:muid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   122: invokevirtual 914	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   125: invokevirtual 881	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   128: pop
    //   129: aload 6
    //   131: ldc_w 883
    //   134: aload 5
    //   136: getfield 905	acrz:a	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   139: getfield 917	tencent/gdt/qq_ad_get$QQAdGet$DeviceInfo:muid_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   142: invokevirtual 921	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   145: invokevirtual 841	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   148: pop
    //   149: aload 6
    //   151: ldc_w 923
    //   154: invokestatic 926	nve:a	()I
    //   157: invokevirtual 841	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   160: pop
    //   161: aload 6
    //   163: ldc_w 928
    //   166: aload_0
    //   167: invokestatic 933	zky:c	(Landroid/content/Context;)Ljava/lang/String;
    //   170: invokevirtual 881	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   173: pop
    //   174: iconst_0
    //   175: istore_1
    //   176: invokestatic 937	bgln:e	()I
    //   179: istore_2
    //   180: iload_2
    //   181: istore_1
    //   182: aload 6
    //   184: ldc_w 939
    //   187: iload_1
    //   188: invokevirtual 841	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   191: pop
    //   192: aload 6
    //   194: ldc_w 941
    //   197: invokestatic 943	bgln:e	()Ljava/lang/String;
    //   200: invokevirtual 881	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   203: pop
    //   204: aload 6
    //   206: ldc_w 945
    //   209: invokestatic 946	bgln:c	()Ljava/lang/String;
    //   212: invokevirtual 881	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   215: pop
    //   216: aload 6
    //   218: ldc_w 948
    //   221: invokestatic 951	com/tencent/common/config/AppSetting:a	()I
    //   224: invokestatic 955	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   227: invokevirtual 881	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   230: pop
    //   231: aload 6
    //   233: ldc_w 957
    //   236: invokestatic 962	dw:a	()J
    //   239: invokestatic 965	dw:a	(J)Ljava/lang/String;
    //   242: invokevirtual 881	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   245: pop
    //   246: aload 6
    //   248: ldc_w 967
    //   251: aload_0
    //   252: invokestatic 970	pha:c	(Landroid/content/Context;)Ljava/lang/String;
    //   255: invokevirtual 881	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   258: pop
    //   259: aload 6
    //   261: ldc_w 972
    //   264: aload_3
    //   265: invokevirtual 881	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload 6
    //   271: ldc_w 974
    //   274: iconst_2
    //   275: invokevirtual 841	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   278: pop
    //   279: aload 6
    //   281: ldc_w 976
    //   284: invokestatic 978	bgln:k	()Ljava/lang/String;
    //   287: invokevirtual 881	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   290: pop
    //   291: aload 6
    //   293: ldc_w 980
    //   296: invokestatic 982	bgln:i	()Ljava/lang/String;
    //   299: invokevirtual 881	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   302: pop
    //   303: aload 6
    //   305: ldc_w 984
    //   308: invokestatic 986	bgln:h	()Ljava/lang/String;
    //   311: invokevirtual 881	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   314: pop
    //   315: aload 6
    //   317: ldc_w 988
    //   320: aload 4
    //   322: invokevirtual 881	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   325: pop
    //   326: aload_0
    //   327: ifnull +22 -> 349
    //   330: aload 6
    //   332: ldc_w 990
    //   335: aload_0
    //   336: invokevirtual 996	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   339: ldc_w 998
    //   342: invokestatic 1003	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   345: invokevirtual 881	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   348: pop
    //   349: aload 6
    //   351: areturn
    //   352: aload 4
    //   354: astore_3
    //   355: aload 4
    //   357: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   360: ifne +98 -> 458
    //   363: aload 4
    //   365: ldc_w 1005
    //   368: ldc_w 778
    //   371: invokevirtual 1008	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   374: invokevirtual 1011	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   377: astore_3
    //   378: aload 6
    //   380: ldc_w 874
    //   383: aload_3
    //   384: invokestatic 878	bita:d	(Ljava/lang/String;)Ljava/lang/String;
    //   387: invokevirtual 872	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   390: invokevirtual 881	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   393: pop
    //   394: aload 6
    //   396: ldc_w 883
    //   399: iconst_3
    //   400: invokevirtual 841	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   403: pop
    //   404: goto +54 -> 458
    //   407: astore_0
    //   408: ldc_w 362
    //   411: iconst_1
    //   412: new 364	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 1013
    //   422: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_0
    //   426: invokevirtual 1014	java/lang/Exception:toString	()Ljava/lang/String;
    //   429: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: aload 6
    //   440: areturn
    //   441: astore_0
    //   442: aload_0
    //   443: invokevirtual 1015	java/lang/Exception:printStackTrace	()V
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
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mBusiJson != null)) {
      return paramAdvertisementInfo.mBusiJson;
    }
    return new JSONObject();
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
        if (paramAdvertisementInfo.downloadState == 0)
        {
          localJSONObject.put("download_state", "0");
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
          break label565;
        }
      }
      catch (JSONException paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
        return localJSONObject;
      }
      localJSONObject.put("download_state", "2");
      continue;
      label565:
      if ((paramAdvertisementInfo.downloadState == 5) || (paramAdvertisementInfo.downloadState == 1)) {
        localJSONObject.put("download_state", "3");
      }
    }
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.clickPos > 0)) {
      localJSONObject.put("click_pos", paramAdvertisementInfo.clickPos);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, HashMap<String, Object> paramHashMap)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAdvertisementInfo != null) {
      localJSONObject = a(paramAdvertisementInfo);
    }
    return nyb.a(new JSONObject[] { localJSONObject, a(paramHashMap) });
  }
  
  public static JSONObject a(AdData paramAdData)
  {
    if (paramAdData == null) {
      return new JSONObject();
    }
    if (paramAdData.a != null) {
      return a(paramAdData.a);
    }
    return a(oqk.a(paramAdData));
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
    localJSONObject = new JSONObject();
    if (paramHashMap != null) {
      try
      {
        if (paramHashMap.size() > 0)
        {
          Iterator localIterator = paramHashMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            Object localObject = paramHashMap.get(str);
            if (localObject != null) {
              localJSONObject.put(str, localObject);
            }
          }
        }
        return localJSONObject;
      }
      catch (Exception paramHashMap) {}
    }
  }
  
  public static void a(Activity paramActivity, nww paramnww, DownloadListener paramDownloadListener)
  {
    if ((paramActivity == null) || (paramnww == null)) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return;
      str1 = paramnww.jdField_f_of_type_JavaLangString;
      str2 = paramnww.jdField_d_of_type_JavaLangString;
      str3 = paramnww.jdField_j_of_type_JavaLangString;
      paramnww = paramnww.i;
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(paramnww)));
    Bundle localBundle = new Bundle();
    localBundle.putString(bivp.jdField_f_of_type_JavaLangString, str1);
    localBundle.putString(bivp.jdField_b_of_type_JavaLangString, str2);
    localBundle.putString(bivp.jdField_j_of_type_JavaLangString, str3);
    localBundle.putString(bivp.jdField_l_of_type_JavaLangString, paramnww);
    localBundle.putInt(bivp.k, 2);
    localBundle.putInt(bivp.E, 0);
    localBundle.putBoolean(bivp.x, false);
    localBundle.putInt(bivp.H, 0);
    localBundle.putBoolean(bivp.y, true);
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "downloadApk pkg:" + str1 + ", appid:" + str2 + ", name:" + paramnww + ", url:" + str3);
    }
    if (paramDownloadListener != null) {
      bivr.a().a(paramDownloadListener);
    }
    bivl.a(paramActivity, localBundle, "biz_src_yyb", null, 0);
  }
  
  private static void a(Context paramContext)
  {
    if (aS >= 3) {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition doStartADLocation retryLocationCount >= 3");
      }
    }
    while ((paramContext == null) || (!bgnt.g(paramContext))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "getADPosition doStartADLocation network is Available...");
    }
    aoor.a(new nxz("readinjoy_feed_ad_distance"));
    aS += 1;
  }
  
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo, int paramInt1, int paramInt2)
  {
    long l1 = 0L;
    if ((paramContext != null) && (paramBaseArticleInfo != null))
    {
      try
      {
        if (paramBaseArticleInfo.mSmallMiniGameInfo == null) {
          break label349;
        }
        localObject = paramBaseArticleInfo.mSmallMiniGameInfo.jdField_j_of_type_JavaLangString;
        if (!oqj.e(paramBaseArticleInfo)) {
          break label177;
        }
        l2 = 50404L;
        if (paramInt2 != jdField_a_of_type_Int) {
          break label350;
        }
        l1 = 5040402L;
      }
      catch (Exception paramContext)
      {
        Object localObject;
        long l2;
        while (QLog.isColorLevel())
        {
          QLog.d("NativeAdUtils", 2, " report mini game error :" + paramContext.getMessage());
          return;
          l2 = 0L;
        }
      }
      localObject = new nwu().a(504L).b(l2).c(l1).d((String)localObject);
      if (paramInt2 != jdField_a_of_type_Int) {
        break label390;
      }
    }
    label390:
    for (l1 = 3L;; l1 = 6L)
    {
      nwu localnwu = ((nwu)localObject).d(l1).a(paramBaseArticleInfo.innerUniqueID).b(paramBaseArticleInfo.mTitle).i(String.valueOf(paramInt1));
      if (oqj.g(paramBaseArticleInfo))
      {
        localObject = paramBaseArticleInfo.mSmallMiniGameInfo.jdField_o_of_type_JavaLangString;
        label139:
        localObject = localnwu.c((String)localObject);
        if (!MiniAppLauncher.isMiniAppUrl(paramBaseArticleInfo.mArticleContentUrl)) {
          break label294;
        }
      }
      label294:
      for (paramBaseArticleInfo = paramBaseArticleInfo.mArticleContentUrl;; paramBaseArticleInfo = paramBaseArticleInfo.mSmallMiniGameInfo.k)
      {
        a(paramContext, ((nwu)localObject).g(paramBaseArticleInfo).a());
        return;
        label177:
        if (oqj.c(paramBaseArticleInfo))
        {
          l2 = 50403L;
          if (paramInt2 != jdField_a_of_type_Int) {
            break label358;
          }
          l1 = 5040302L;
          break;
        }
        if (oqj.f(paramBaseArticleInfo))
        {
          l2 = 50402L;
          if (paramInt2 != jdField_a_of_type_Int) {
            break label366;
          }
          l1 = 5040202L;
          break;
        }
        if (oqj.g(paramBaseArticleInfo))
        {
          l2 = 50406L;
          if (paramInt2 != jdField_a_of_type_Int) {
            break label374;
          }
          l1 = 5040602L;
          break;
        }
        if (!oqj.d(paramBaseArticleInfo)) {
          break label343;
        }
        l2 = 50401L;
        if (paramInt2 != jdField_a_of_type_Int) {
          break label382;
        }
        l1 = 5040104L;
        break;
        localObject = paramBaseArticleInfo.mSubscribeName;
        break label139;
      }
      label343:
      label349:
      return;
      label350:
      l1 = 5040401L;
      break;
      label358:
      l1 = 5040301L;
      break;
      label366:
      l1 = 5040201L;
      break;
      label374:
      l1 = 5040601L;
      break;
      label382:
      l1 = 5040103L;
      break;
    }
  }
  
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramContext != null) && (paramBaseArticleInfo != null)) {}
    for (;;)
    {
      try
      {
        if ((paramBaseArticleInfo.mSmallMiniGameInfo == null) || (paramBaseArticleInfo.mSmallMiniGameInfo.a == null)) {
          break label236;
        }
        if (paramInt3 != jdField_b_of_type_Int) {
          break label237;
        }
        l1 = 5010103L;
        if (!paramBaseArticleInfo.mSmallMiniGameInfo.a()) {
          continue;
        }
        str = "3";
        paramBaseArticleInfo = (omw)paramBaseArticleInfo.mSmallMiniGameInfo.a.get(paramInt2);
        if (paramBaseArticleInfo == null) {
          continue;
        }
        nwu localnwu = new nwu().a(501L).b(50101L).c(l1);
        if (paramInt3 != jdField_a_of_type_Int) {
          continue;
        }
        l1 = 3L;
        paramBaseArticleInfo = localnwu.d(l1).d(paramBaseArticleInfo.jdField_a_of_type_JavaLangString).i(String.valueOf(paramInt1)).c(paramBaseArticleInfo.jdField_d_of_type_JavaLangString).e(paramBaseArticleInfo.jdField_c_of_type_JavaLangString).f(String.valueOf(paramInt2 + 1)).g(paramBaseArticleInfo.jdField_b_of_type_JavaLangString).h(str).a();
      }
      catch (Exception paramContext)
      {
        String str;
        if (!QLog.isColorLevel()) {
          break label236;
        }
        QLog.d("NativeAdUtils", 2, " report mini game error :" + paramContext.getMessage());
        return;
        paramBaseArticleInfo = null;
        continue;
      }
      a(paramContext, paramBaseArticleInfo);
      return;
      str = "2";
      continue;
      long l1 = 6L;
      continue;
      label236:
      return;
      label237:
      l1 = 5010104L;
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    boolean bool = oqj.a(paramContext, paramString);
    oqh.a("NativeAdUtils", "launchResult = " + bool);
  }
  
  public static void a(Context paramContext, nws paramnws)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("page_id", paramnws.jdField_a_of_type_Long);
      localJSONObject.put("oper_module", paramnws.jdField_b_of_type_Long);
      localJSONObject.put("oper_id", paramnws.jdField_c_of_type_Long);
      localJSONObject.put("oper_type", paramnws.jdField_d_of_type_Long);
      localJSONObject.put("obj_id", paramnws.jdField_a_of_type_JavaLangString);
      localJSONObject.put("obj_type", paramnws.jdField_b_of_type_JavaLangString);
      localJSONObject.put("game_pkg", paramnws.jdField_c_of_type_JavaLangString);
      localJSONObject.put("app_id", paramnws.jdField_d_of_type_JavaLangString);
      localJSONObject.put("ex1", paramnws.jdField_e_of_type_JavaLangString);
      localJSONObject.put("ex2", paramnws.jdField_f_of_type_JavaLangString);
      localJSONObject.put("ex3", paramnws.jdField_g_of_type_JavaLangString);
      localJSONObject.put("ex4", paramnws.jdField_h_of_type_JavaLangString);
      localJSONObject.put("loc_id", paramnws.i);
      paramnws = new JSONObject();
      paramnws.put(jdField_c_of_type_JavaLangString, String.valueOf(localJSONObject));
      a(new omp().a(paramContext).a(jdField_p_of_type_Int).b(ar).e(paramnws).a());
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("NativeAdUtils", 2, "reportMiniGameAd error :" + paramContext.getMessage());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    a(paramQQAppInterface, paramAdData, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, int paramInt)
  {
    olm.a(false, paramQQAppInterface.getApp().getApplicationContext(), oqk.a(paramAdData), M, jdField_a_of_type_Int, 3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    bcst.b(paramQQAppInterface, "dc04719", "ad", "0", paramString1.toUpperCase(), paramString2.toUpperCase(), paramInt1, paramInt2, paramString3, paramString4, paramString5, paramString6);
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
      localJSONObject.put("version", "8.4.1");
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
        paramString2 = new NewIntent(paramQQAppInterface.getApplication(), oaz.class);
        paramString2.putExtra("cmd", "KdAdReportSsoSvr.kandian_ad");
        paramString2.putExtra("data", paramString1.toByteArray());
        paramString2.setObserver(new nxx());
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
      jdField_d_of_type_JavaLangString = str;
      ThreadManager.executeOnFileThread(new NativeAdUtils.3(str));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(omn paramomn)
  {
    if (paramomn == null) {}
    Object localObject1;
    do
    {
      return;
      localObject2 = paramomn.a();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (BaseApplicationImpl.sProcessId == 1)
        {
          localObject3 = BaseApplicationImpl.getApplication().peekAppRuntime();
          localObject1 = localObject2;
          if ((localObject3 instanceof QQAppInterface)) {
            localObject1 = (QQAppInterface)localObject3;
          }
        }
      }
    } while (localObject1 == null);
    Object localObject2 = paramomn.a();
    int i1 = paramomn.a();
    int i2 = paramomn.b();
    Object localObject3 = paramomn.a();
    VideoAdInfo localVideoAdInfo = paramomn.a();
    long l1 = paramomn.a();
    String str = paramomn.a();
    JSONObject localJSONObject1 = paramomn.a();
    int i3 = paramomn.d();
    JSONObject localJSONObject2 = paramomn.b();
    Bundle localBundle = paramomn.a();
    JSONObject localJSONObject3 = paramomn.c();
    JSONObject localJSONObject4 = paramomn.d();
    JSONObject localJSONObject5 = paramomn.f();
    JSONObject localJSONObject6 = paramomn.e();
    int i4 = paramomn.c();
    boolean bool = paramomn.a();
    ThreadManager.post(new NativeAdUtils.2(localJSONObject3, ((AppInterface)localObject1).getAccount(), i1, i2, i4, (Context)localObject2, (AdvertisementInfo)localObject3, localVideoAdInfo, i3, localJSONObject1, localJSONObject2, localBundle, str, l1, localJSONObject4, localJSONObject6, localJSONObject5, (AppInterface)localObject1, bool), 5, null, true);
  }
  
  private static void a(JSONObject paramJSONObject, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramJSONObject != null) && (paramAdvertisementInfo != null) && (paramAdvertisementInfo.gameAdComData != null)) {}
    while ((paramJSONObject == null) || (paramAdvertisementInfo == null) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdExtInfo))) {
      try
      {
        paramJSONObject.put("pkg_name", paramAdvertisementInfo.gameAdComData.jdField_d_of_type_JavaLangString);
        paramJSONObject.put("game_adtag", new JSONObject(paramAdvertisementInfo.gameAdComData.B).optString("ADTAG"));
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
      bool2 = bgnw.a(paramContext, paramString);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("NativeAdUtils", 2, "isAppInstall pkg:" + paramString + " " + bool2);
    return bool2;
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
  
  public static boolean a(nww paramnww)
  {
    String str1 = paramnww.jdField_f_of_type_JavaLangString;
    String str2 = paramnww.jdField_d_of_type_JavaLangString;
    String str3 = paramnww.jdField_j_of_type_JavaLangString;
    paramnww = paramnww.i;
    Bundle localBundle = new Bundle();
    localBundle.putInt(bivp.k, 5);
    localBundle.putString(bivp.jdField_f_of_type_JavaLangString, str1);
    localBundle.putString(bivp.jdField_b_of_type_JavaLangString, str2);
    localBundle.putString(bivp.jdField_j_of_type_JavaLangString, str3);
    localBundle.putString(bivp.jdField_l_of_type_JavaLangString, paramnww);
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "installApk pkg:" + str1 + ", appid:" + str2 + ", name:" + paramnww + ", url:" + str3);
    }
    return bivl.a(localBundle);
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
          double d1 = nya.a(paramBaseArticleInfo.mLocalInfo.jdField_e_of_type_JavaLangString, 0.0D);
          double d2 = nya.a(str, 0.0D);
          if ((d2 != 0.0D) || (d1 != 0.0D)) {
            return new double[] { d1, d2 };
          }
        }
        catch (Exception paramBaseArticleInfo) {}
      }
    }
    return null;
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
      acre.a(0, 1, ubb.a(paramAdvertisementInfo));
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
          acre.a(1, 1, ubb.a(paramAdvertisementInfo));
        }
        for (;;)
        {
          if (paramInt == F)
          {
            if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mC2SSwitch != 1)) {
              break label495;
            }
            if (QLog.isColorLevel()) {
              QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo = " + paramAdvertisementInfo.toString() + " clickurl = " + paramAdvertisementInfo.mC2SVideoPlayUrl + " videoClickUrl = " + paramAdvertisementInfo.mC2SVideoPlayUrl);
            }
            acre.a(2, 1, ubb.a(paramAdvertisementInfo));
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
          acre.a(0, 1, ubb.a(localAdvertisementInfo));
          break;
          if ((paramVideoAdInfo != null) && (paramVideoAdInfo.jdField_o_of_type_Int == 1))
          {
            localAdvertisementInfo = a(paramVideoAdInfo);
            if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mC2SSwitch == 1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo1 = " + localAdvertisementInfo.toString() + " videoAdInfo = " + paramVideoAdInfo.toString() + " clickurl = " + localAdvertisementInfo.mC2SClickUrl + " exposureUrl = " + localAdvertisementInfo.mC2SExposureUrl);
              }
              acre.a(1, 1, ubb.a(localAdvertisementInfo));
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
    acre.a(2, 1, ubb.a(paramAdvertisementInfo));
  }
  
  private static boolean b(int paramInt1, int paramInt2, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    if ((paramInt2 == ag) || (paramInt1 == C)) {
      return true;
    }
    if ((oqr.a().a(paramAdvertisementInfo)) && (paramInt1 == jdField_b_of_type_Int))
    {
      oqh.a("ReadInJoySuperMaskAd", "has c2s report: aid = " + paramAdvertisementInfo.mAdAid);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nxw
 * JD-Core Version:    0.7.0.1
 */