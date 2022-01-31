import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.NativeAd.fragment.NativeAdVideoFragment;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdAppFragment;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.ad.fragment.ReadinjoyAdPKFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdPopSheetBrowserFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyForCanvasFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoCeilingFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class rvb
{
  public static GdtAppReceiver a;
  private static ArrayList<Integer> a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(12), Integer.valueOf(25), Integer.valueOf(30), Integer.valueOf(41), Integer.valueOf(1000) }));
  }
  
  public static String a(String paramString)
  {
    Object localObject = paramString;
    String str;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.startsWith("http"))
      {
        localObject = paramString;
        if (!paramString.startsWith("https")) {}
      }
      else
      {
        str = paramString;
      }
    }
    try
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel())
      {
        str = paramString;
        com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 0, "appendUrlParameter, before url:" + paramString);
      }
      str = paramString;
      localObject = Uri.parse(paramString).buildUpon();
      str = paramString;
      ((Uri.Builder)localObject).appendQueryParameter("adclickts", String.valueOf(System.currentTimeMillis()));
      str = paramString;
      paramString = ((Uri.Builder)localObject).build().toString();
      localObject = paramString;
      str = paramString;
      if (com.tencent.TMG.utils.QLog.isColorLevel())
      {
        str = paramString;
        com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 0, "appendUrlParameter, after url:" + paramString);
        localObject = paramString;
      }
    }
    catch (Exception paramString)
    {
      do
      {
        localObject = str;
      } while (!com.tencent.TMG.utils.QLog.isColorLevel());
      com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 0, "appendUrlParameter, url:" + str + " , error:" + paramString.getMessage());
    }
    return localObject;
    return str;
  }
  
  /* Error */
  private static nms a(AdvertisementInfo paramAdvertisementInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull +141 -> 144
    //   6: aload_0
    //   7: getfield 125	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnmw;
    //   10: ifnull +134 -> 144
    //   13: aload_0
    //   14: getfield 125	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnmw;
    //   17: getfield 130	nmw:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   20: ifnull +124 -> 144
    //   23: aload_0
    //   24: getfield 125	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnmw;
    //   27: getfield 130	nmw:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   30: invokeinterface 136 1 0
    //   35: iconst_2
    //   36: if_icmplt +108 -> 144
    //   39: aload_0
    //   40: getfield 140	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:clickPos	I
    //   43: bipush 101
    //   45: if_icmpne +20 -> 65
    //   48: aload_0
    //   49: getfield 125	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnmw;
    //   52: getfield 130	nmw:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   55: iconst_0
    //   56: invokeinterface 144 2 0
    //   61: checkcast 146	nms
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 140	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:clickPos	I
    //   69: bipush 102
    //   71: if_icmpne +71 -> 142
    //   74: aload_0
    //   75: getfield 125	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnmw;
    //   78: getfield 130	nmw:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   81: iconst_1
    //   82: invokeinterface 144 2 0
    //   87: checkcast 146	nms
    //   90: astore_2
    //   91: aload_2
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: astore_2
    //   98: invokestatic 57	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   101: ifeq -10 -> 91
    //   104: ldc 59
    //   106: iconst_3
    //   107: new 61	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   114: ldc 148
    //   116: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 118	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 77	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload_0
    //   133: areturn
    //   134: astore_2
    //   135: aload_1
    //   136: astore_0
    //   137: aload_2
    //   138: astore_1
    //   139: goto -43 -> 96
    //   142: aload_1
    //   143: areturn
    //   144: aconst_null
    //   145: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramAdvertisementInfo	AdvertisementInfo
    //   1	64	1	localnms	nms
    //   93	43	1	localException1	Exception
    //   138	5	1	localObject1	Object
    //   90	8	2	localObject2	Object
    //   134	4	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	39	93	java/lang/Exception
    //   39	65	93	java/lang/Exception
    //   65	91	134	java/lang/Exception
  }
  
  /* Error */
  public static qq_ad_get.QQAdGetRsp.AdInfo a(AdvertisementInfo paramAdvertisementInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnonnull +7 -> 10
    //   6: aload_1
    //   7: astore_0
    //   8: aload_0
    //   9: areturn
    //   10: new 151	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo
    //   13: dup
    //   14: invokespecial 152	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:<init>	()V
    //   17: astore_1
    //   18: aload_1
    //   19: getfield 156	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:advertiser_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   22: aload_0
    //   23: getfield 160	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAdvertiseId	J
    //   26: invokevirtual 166	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   29: aload_0
    //   30: getfield 170	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateLogo	Ljava/lang/String;
    //   33: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifne +14 -> 50
    //   39: aload_1
    //   40: getfield 174	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:corporate_logo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   43: aload_0
    //   44: getfield 170	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateLogo	Ljava/lang/String;
    //   47: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 182	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateImageName	Ljava/lang/String;
    //   54: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +14 -> 71
    //   60: aload_1
    //   61: getfield 185	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:corporate_image_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   64: aload_0
    //   65: getfield 182	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateImageName	Ljava/lang/String;
    //   68: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   71: new 187	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo
    //   74: dup
    //   75: invokespecial 188	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:<init>	()V
    //   78: astore_2
    //   79: aload_0
    //   80: getfield 191	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoUrl	Ljava/lang/String;
    //   83: ifnull +14 -> 97
    //   86: aload_2
    //   87: getfield 194	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:video_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   90: aload_0
    //   91: getfield 191	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoUrl	Ljava/lang/String;
    //   94: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   97: new 196	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo
    //   100: dup
    //   101: invokespecial 197	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:<init>	()V
    //   104: astore_3
    //   105: aload_3
    //   106: getfield 201	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:advertiser_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo;
    //   109: aload_1
    //   110: invokevirtual 204	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   113: aload_3
    //   114: getfield 208	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:video_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo;
    //   117: aload_2
    //   118: invokevirtual 209	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   121: aload_3
    //   122: getfield 213	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:mini_program_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: aload_0
    //   126: getfield 216	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:miniProgramType	I
    //   129: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   132: new 223	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo
    //   135: dup
    //   136: invokespecial 224	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:<init>	()V
    //   139: astore_1
    //   140: aload_1
    //   141: getfield 227	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:aid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   144: aload_0
    //   145: getfield 230	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAid	J
    //   148: invokevirtual 166	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   151: aload_1
    //   152: getfield 233	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:traceid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   155: aload_0
    //   156: getfield 236	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdTraceId	Ljava/lang/String;
    //   159: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   162: aload_1
    //   163: getfield 239	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:view_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   166: aload_0
    //   167: getfield 242	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdViewId	Ljava/lang/String;
    //   170: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   173: aload_1
    //   174: getfield 245	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:product_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   177: aload_0
    //   178: getfield 248	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductId	Ljava/lang/String;
    //   181: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   184: aload_1
    //   185: getfield 251	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:via	Lcom/tencent/mobileqq/pb/PBStringField;
    //   188: aload_0
    //   189: getfield 254	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVia	Ljava/lang/String;
    //   192: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   195: aload_1
    //   196: getfield 258	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:noco_id	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   199: aload_0
    //   200: getfield 261	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdNocoId	J
    //   203: invokevirtual 264	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   206: new 266	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo
    //   209: dup
    //   210: invokespecial 267	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:<init>	()V
    //   213: astore 4
    //   215: aload 4
    //   217: getfield 270	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:exposure_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   220: aload_0
    //   221: getfield 273	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdApurl	Ljava/lang/String;
    //   224: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   227: aload 4
    //   229: getfield 276	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   232: aload_0
    //   233: getfield 279	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdRl	Ljava/lang/String;
    //   236: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   239: aload 4
    //   241: getfield 282	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:effect_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   244: aload_0
    //   245: getfield 285	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdEffectUrl	Ljava/lang/String;
    //   248: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   251: aload 4
    //   253: getfield 288	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:landing_page_report_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   256: aload_0
    //   257: getfield 291	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPageReportUrl	Ljava/lang/String;
    //   260: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   263: aload 4
    //   265: getfield 295	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   268: aload_1
    //   269: invokevirtual 296	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   272: new 298	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls
    //   275: dup
    //   276: invokespecial 299	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:<init>	()V
    //   279: astore_1
    //   280: aload_0
    //   281: getfield 302	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SClickUrl	Ljava/util/ArrayList;
    //   284: ifnull +14 -> 298
    //   287: aload_1
    //   288: getfield 306	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_click_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   291: aload_0
    //   292: getfield 302	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SClickUrl	Ljava/util/ArrayList;
    //   295: invokevirtual 311	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   298: aload_0
    //   299: getfield 314	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SExposureUrl	Ljava/util/ArrayList;
    //   302: ifnull +14 -> 316
    //   305: aload_1
    //   306: getfield 317	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_exposure_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   309: aload_0
    //   310: getfield 314	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SExposureUrl	Ljava/util/ArrayList;
    //   313: invokevirtual 311	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   316: aload_0
    //   317: getfield 320	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SVideoPlayUrl	Ljava/util/ArrayList;
    //   320: ifnull +14 -> 334
    //   323: aload_1
    //   324: getfield 323	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:video_play_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   327: aload_0
    //   328: getfield 320	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SVideoPlayUrl	Ljava/util/ArrayList;
    //   331: invokevirtual 311	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   334: aload 4
    //   336: getfield 327	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:thirdparty_monitor_urls	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls;
    //   339: aload_1
    //   340: invokevirtual 328	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   343: new 330	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo
    //   346: dup
    //   347: invokespecial 331	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:<init>	()V
    //   350: astore 5
    //   352: aload_0
    //   353: getfield 334	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPage	Ljava/lang/String;
    //   356: astore_2
    //   357: aload_2
    //   358: astore_1
    //   359: aload_0
    //   360: getfield 125	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnmw;
    //   363: ifnull +23 -> 386
    //   366: aload_2
    //   367: astore_1
    //   368: aload_0
    //   369: getfield 125	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnmw;
    //   372: getfield 337	nmw:h	I
    //   375: ldc_w 338
    //   378: if_icmpne +8 -> 386
    //   381: aload_2
    //   382: invokestatic 340	rvb:a	(Ljava/lang/String;)Ljava/lang/String;
    //   385: astore_1
    //   386: aload 5
    //   388: getfield 343	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:landing_page	Lcom/tencent/mobileqq/pb/PBStringField;
    //   391: aload_1
    //   392: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   395: aload 5
    //   397: getfield 346	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:canvas_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   400: aload_0
    //   401: getfield 349	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCanvasJson	Ljava/lang/String;
    //   404: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   407: aload 5
    //   409: getfield 352	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:dest_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   412: aload_0
    //   413: getfield 355	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdDestType	I
    //   416: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   419: new 357	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo
    //   422: dup
    //   423: invokespecial 358	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:<init>	()V
    //   426: astore 6
    //   428: aload_0
    //   429: getfield 361	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   432: invokestatic 366	com/tencent/gdtad/aditem/GdtBaseAdItem:a	(Ljava/lang/String;)Lcom/tencent/gdtad/aditem/GdtBaseAdItem;
    //   435: astore_1
    //   436: aload 6
    //   438: getfield 369	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:app_package_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   441: aload_1
    //   442: getfield 371	com/tencent/gdtad/aditem/GdtBaseAdItem:a	Ljava/lang/String;
    //   445: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   448: new 373	org/json/JSONObject
    //   451: dup
    //   452: aload_0
    //   453: getfield 361	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   456: invokespecial 375	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   459: astore_2
    //   460: aload_2
    //   461: ldc_w 377
    //   464: invokevirtual 380	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   467: astore_1
    //   468: aload_2
    //   469: ldc_w 382
    //   472: invokevirtual 380	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   475: astore_2
    //   476: aload_1
    //   477: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   480: ifne +12 -> 492
    //   483: aload 6
    //   485: getfield 385	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:pkg_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   488: aload_1
    //   489: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   492: aload_2
    //   493: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   496: ifne +12 -> 508
    //   499: aload 6
    //   501: getfield 388	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:app_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   504: aload_2
    //   505: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   508: aload 6
    //   510: getfield 391	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:android_app_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   513: aload_0
    //   514: getfield 248	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductId	Ljava/lang/String;
    //   517: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   520: aload 6
    //   522: getfield 394	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:pkg_download_schema	Lcom/tencent/mobileqq/pb/PBStringField;
    //   525: aload_0
    //   526: getfield 397	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAppDownLoadSchema	Ljava/lang/String;
    //   529: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   532: aload 6
    //   534: getfield 400	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:customized_invoke_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   537: aload_0
    //   538: getfield 403	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCustomizedInvokeUrl	Ljava/lang/String;
    //   541: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   544: invokestatic 57	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   547: ifeq +32 -> 579
    //   550: ldc 59
    //   552: iconst_0
    //   553: new 61	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   560: ldc_w 405
    //   563: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload_0
    //   567: getfield 408	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   570: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 411	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: aload 6
    //   581: getfield 414	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:channel_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   584: astore_2
    //   585: aload_0
    //   586: getfield 408	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   589: ifnonnull +233 -> 822
    //   592: ldc_w 416
    //   595: astore_1
    //   596: aload_2
    //   597: aload_1
    //   598: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   601: aload_0
    //   602: invokestatic 421	npj:h	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   605: ifeq +38 -> 643
    //   608: aload_0
    //   609: getfield 125	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnmw;
    //   612: getfield 130	nmw:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   615: ifnull +28 -> 643
    //   618: aload_0
    //   619: getfield 125	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnmw;
    //   622: getfield 130	nmw:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   625: invokeinterface 136 1 0
    //   630: iconst_2
    //   631: if_icmplt +12 -> 643
    //   634: aload_0
    //   635: invokestatic 423	rvb:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lnms;
    //   638: astore_1
    //   639: aload_1
    //   640: ifnonnull +190 -> 830
    //   643: new 425	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   646: dup
    //   647: invokespecial 426	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   650: astore_1
    //   651: aload_1
    //   652: getfield 429	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:product_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   655: aload_0
    //   656: getfield 432	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductType	I
    //   659: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   662: aload_1
    //   663: getfield 436	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:display_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo;
    //   666: aload_3
    //   667: invokevirtual 437	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   670: aload_1
    //   671: getfield 441	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   674: aload 4
    //   676: invokevirtual 442	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   679: aload_1
    //   680: getfield 446	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:dest_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo;
    //   683: aload 5
    //   685: invokevirtual 447	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   688: aload_1
    //   689: getfield 451	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:app_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo;
    //   692: aload 6
    //   694: invokevirtual 452	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   697: aload_0
    //   698: getfield 361	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   701: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   704: ifne +173 -> 877
    //   707: new 373	org/json/JSONObject
    //   710: dup
    //   711: aload_0
    //   712: getfield 361	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   715: invokespecial 375	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   718: ldc_w 454
    //   721: ldc_w 416
    //   724: invokevirtual 457	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   727: astore_0
    //   728: invokestatic 57	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   731: ifeq +29 -> 760
    //   734: ldc 59
    //   736: iconst_0
    //   737: new 61	java/lang/StringBuilder
    //   740: dup
    //   741: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   744: ldc_w 459
    //   747: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: aload_0
    //   751: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokestatic 411	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   760: aload_1
    //   761: getfield 462	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:ext_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   764: aload_0
    //   765: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   768: aload_1
    //   769: areturn
    //   770: astore_2
    //   771: aload_1
    //   772: astore_0
    //   773: invokestatic 57	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   776: ifeq -768 -> 8
    //   779: ldc 59
    //   781: iconst_0
    //   782: new 61	java/lang/StringBuilder
    //   785: dup
    //   786: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   789: ldc_w 464
    //   792: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: aload_2
    //   796: invokevirtual 118	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   799: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokestatic 411	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   808: aload_1
    //   809: areturn
    //   810: astore_2
    //   811: aconst_null
    //   812: astore_1
    //   813: aload_2
    //   814: invokevirtual 467	java/lang/Exception:printStackTrace	()V
    //   817: aconst_null
    //   818: astore_2
    //   819: goto -343 -> 476
    //   822: aload_0
    //   823: getfield 408	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   826: astore_1
    //   827: goto -231 -> 596
    //   830: aload_1
    //   831: getfield 470	nms:b	Ljava/lang/String;
    //   834: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   837: ifne +15 -> 852
    //   840: aload 4
    //   842: getfield 276	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   845: aload_1
    //   846: getfield 470	nms:b	Ljava/lang/String;
    //   849: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   852: aload_1
    //   853: getfield 471	nms:a	Ljava/lang/String;
    //   856: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   859: ifne -216 -> 643
    //   862: aload 5
    //   864: getfield 343	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:landing_page	Lcom/tencent/mobileqq/pb/PBStringField;
    //   867: aload_1
    //   868: getfield 471	nms:a	Ljava/lang/String;
    //   871: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   874: goto -231 -> 643
    //   877: aload_1
    //   878: getfield 462	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:ext_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   881: ldc_w 416
    //   884: invokevirtual 179	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   887: aload_1
    //   888: astore_0
    //   889: invokestatic 57	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   892: ifeq -884 -> 8
    //   895: ldc 59
    //   897: iconst_0
    //   898: ldc_w 473
    //   901: invokestatic 411	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   904: aload_1
    //   905: areturn
    //   906: astore_2
    //   907: goto -94 -> 813
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	910	0	paramAdvertisementInfo	AdvertisementInfo
    //   1	904	1	localObject1	Object
    //   78	519	2	localObject2	Object
    //   770	26	2	localException1	Exception
    //   810	4	2	localException2	Exception
    //   818	1	2	localObject3	Object
    //   906	1	2	localException3	Exception
    //   104	563	3	localDisplayInfo	tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo
    //   213	628	4	localReportInfo	qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo
    //   350	513	5	localDestInfo	qq_ad_get.QQAdGetRsp.AdInfo.DestInfo
    //   426	267	6	localAppInfo	tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo
    // Exception table:
    //   from	to	target	type
    //   707	760	770	java/lang/Exception
    //   760	768	770	java/lang/Exception
    //   448	468	810	java/lang/Exception
    //   468	476	906	java/lang/Exception
  }
  
  public static yjs a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, qoe paramqoe, int paramInt, boolean paramBoolean, nmr paramnmr)
  {
    return a(paramContext, paramAdvertisementInfo, paramqoe, paramInt, paramBoolean, true, false, paramnmr);
  }
  
  public static yjs a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, qoe paramqoe, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, nmr paramnmr)
  {
    if ((paramBoolean2) && (!a(paramAdvertisementInfo, paramInt))) {
      return null;
    }
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = a(paramAdvertisementInfo);
    yjs localyjs = new yjs();
    localyjs.jdField_a_of_type_Int = 1;
    localyjs.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)paramContext);
    localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(localAdInfo);
    localyjs.jdField_a_of_type_Boolean = true;
    localyjs.jdField_b_of_type_Boolean = paramBoolean1;
    if (paramAdvertisementInfo.clickPos > 0)
    {
      com.tencent.TMG.utils.QLog.d("ReadinJoyActionUtil", 0, "test click pos " + paramAdvertisementInfo.clickPos);
      localyjs.jdField_c_of_type_Int = paramAdvertisementInfo.clickPos;
      paramAdvertisementInfo.resetClickPos();
    }
    if (paramqoe != null) {
      localyjs.jdField_a_of_type_Long = paramqoe.a();
    }
    if (jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
    {
      jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(BaseApplicationImpl.getContext());
    }
    localyjs.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
    if ((paramInt != 3) && (paramInt != 4) && (paramAdvertisementInfo.mAdJumpMode != 6) && (!paramBoolean3) && (paramInt != 2000001))
    {
      localyjs.jdField_a_of_type_JavaLangClass = ReadInJoyVideoCeilingFragment.class;
      if (paramnmr != null) {
        a(localyjs, paramnmr.jdField_a_of_type_Boolean, paramAdvertisementInfo, paramContext);
      }
    }
    localyjs.jdField_b_of_type_JavaLangClass = ReadInJoyForCanvasFragment.class;
    if ((paramnmr != null) && (paramnmr.jdField_b_of_type_Boolean)) {
      localyjs.jdField_a_of_type_Boolean = false;
    }
    localyjs.jdField_a_of_type_AndroidOsBundle = new Bundle();
    localyjs.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    a(localyjs, paramAdvertisementInfo, paramnmr);
    return localyjs;
  }
  
  public static void a()
  {
    if ((BaseApplicationImpl.getContext() != null) && (jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver != null))
    {
      BaseApplicationImpl.getContext().unregisterReceiver(jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = null;
    }
  }
  
  public static void a(int paramInt, yjs paramyjs, long paramLong)
  {
    if ((paramyjs == null) || (paramLong == -2147483648L)) {}
    do
    {
      return;
      if ((paramyjs == null) || (paramLong == -2147483648L))
      {
        yny.d("ReadinJoyActionUtil", " enterTimeMillis:" + paramLong + " gdtParams:" + paramyjs);
        return;
      }
    } while ((paramInt != 0) && (paramInt != 3) && (paramInt != 56) && (paramInt != 2));
    long l = SystemClock.elapsedRealtime();
    yny.b("ReadinJoyActionUtil", String.format("leave %d", new Object[] { Long.valueOf(l) }));
    if (paramLong == -2147483648L) {
      yny.d("ReadinJoyActionUtil", "leave error");
    }
    paramLong = l - paramLong;
    yny.b("ReadinJoyActionUtil", String.format("dwell %d", new Object[] { Long.valueOf(paramLong) }));
    yoe localyoe = new yoe();
    localyoe.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
    localyoe.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(42);
    localyoe.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(paramLong);
    yod.a(localyoe);
  }
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("param_ad_info", paramAdvertisementInfo);
    ReadinjoyAdPKFragment.a(paramActivity, ReadinjoyAdPKFragment.class, localBundle);
  }
  
  private static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, qoe paramqoe, int paramInt, boolean paramBoolean)
  {
    if ((paramqoe != null) && (paramBoolean)) {
      a(paramActivity, paramAdvertisementInfo, paramInt);
    }
    String str = paramAdvertisementInfo.mAdAppJson;
    Bundle localBundle = new Bundle();
    localBundle.putString("param_ad_json", str);
    localBundle.putString("param_ad_app_info_trace_id", paramAdvertisementInfo.mAdTraceId);
    localBundle.putLong("param_ad_app_info_pull_time", paramAdvertisementInfo.mAdFetchTime);
    localBundle.putString("param_ad_app_info_view_id", paramAdvertisementInfo.mAdViewId);
    localBundle.putLong("param_ad_app_info_pos_id", paramAdvertisementInfo.mAdPosID);
    localBundle.putInt("param_ad_app_info_kd_pos", paramAdvertisementInfo.mAdKdPos);
    localBundle.putString("param_ad_app_info_product_id", paramAdvertisementInfo.mAdProductId);
    localBundle.putInt("param_ad_app_info_product_type", paramAdvertisementInfo.mAdProductType);
    localBundle.putString("param_ad_app_info_ap_url", paramAdvertisementInfo.mAdApurl);
    if (paramqoe != null) {
      localBundle.putLong("param_ad_app_info_video_playposition", paramqoe.a());
    }
    a(paramActivity);
    ReadInJoyNativeAdAppFragment.a(paramActivity, ReadInJoyNativeAdAppFragment.class, localBundle);
  }
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, qoe paramqoe, int paramInt, boolean paramBoolean, nmr paramnmr)
  {
    paramnmr = a(paramActivity, paramAdvertisementInfo, paramqoe, paramInt, paramBoolean, paramnmr);
    if (((paramAdvertisementInfo instanceof AdvertisementInfo)) && (paramnmr != null))
    {
      paramnmr.d = true;
      paramnmr.jdField_c_of_type_Boolean = true;
      if (a(paramnmr, paramActivity, paramAdvertisementInfo)) {
        return;
      }
    }
    Object localObject = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).aid.set(paramAdvertisementInfo.mAdAid);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).traceid.set(paramAdvertisementInfo.mAdTraceId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).view_id.set(paramAdvertisementInfo.mAdViewId);
    paramnmr = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramnmr.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramnmr.click_url.set(paramAdvertisementInfo.mAdRl);
    paramnmr.trace_info.set((MessageMicro)localObject);
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.set(paramnmr);
    GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    localObject = paramAdvertisementInfo.mAdLandingPage;
    paramnmr = (nmr)localObject;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramnmr = Uri.parse((String)localObject).buildUpon();
      if ((badq.b(BaseApplicationImpl.getApplication()) != 1) || (paramInt == 0)) {
        break label354;
      }
      paramnmr.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      paramnmr = paramnmr.toString();
      localObject = new GdtVideoCeilingData();
      ((GdtVideoCeilingData)localObject).setVideoData(localGdtVideoData);
      ((GdtVideoCeilingData)localObject).setAd(localGdtAd);
      ((GdtVideoCeilingData)localObject).setWebUrl(paramnmr);
      paramInt = paramAdvertisementInfo.mAdJumpMode;
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("ReadinJoyActionUtil", 0, "jump mode = " + paramInt);
      }
      if (paramInt != 4) {
        break label378;
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdAppJson)) {
        break;
      }
      a(paramActivity, paramAdvertisementInfo, paramqoe, 0, null);
      return;
      label354:
      paramnmr.appendQueryParameter("autodownload", "0");
    }
    a(paramActivity, paramAdvertisementInfo, paramqoe, 0, false);
    return;
    label378:
    if (paramInt == 5)
    {
      b(paramActivity, paramAdvertisementInfo, paramqoe, 0, false);
      return;
    }
    if (((GdtVideoCeilingData)localObject).getStyle() == -2147483648) {
      ((GdtVideoCeilingData)localObject).setStyle(1);
    }
    paramAdvertisementInfo = new Bundle();
    paramAdvertisementInfo.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, (GdtVideoCeilingData)localObject, paramAdvertisementInfo);
  }
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, qoe paramqoe, int paramInt, boolean paramBoolean1, boolean paramBoolean2, nmr paramnmr)
  {
    Object localObject = a(paramActivity, paramAdvertisementInfo, paramqoe, paramInt, paramBoolean1, paramnmr);
    if (((paramAdvertisementInfo instanceof AdvertisementInfo)) && (localObject != null))
    {
      ((yjs)localObject).f = paramBoolean2;
      if (paramnmr == null)
      {
        ((yjs)localObject).d = false;
        ((yjs)localObject).jdField_c_of_type_Boolean = false;
      }
      if (a((yjs)localObject, paramActivity, paramAdvertisementInfo)) {
        return;
      }
    }
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).aid.set(paramAdvertisementInfo.mAdAid);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).traceid.set(paramAdvertisementInfo.mAdTraceId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).view_id.set(paramAdvertisementInfo.mAdViewId);
    paramnmr = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramnmr.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramnmr.click_url.set(paramAdvertisementInfo.mAdRl);
    paramnmr.trace_info.set((MessageMicro)localObject);
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.set(paramnmr);
    GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setDirectPlay(paramBoolean2);
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    localObject = paramAdvertisementInfo.mAdLandingPage;
    paramnmr = (nmr)localObject;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramnmr = Uri.parse((String)localObject).buildUpon();
      if ((badq.b(BaseApplicationImpl.getApplication()) != 1) || (paramInt == 0)) {
        break label373;
      }
      paramnmr.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      paramnmr = paramnmr.toString();
      localObject = new GdtVideoCeilingData();
      ((GdtVideoCeilingData)localObject).setVideoData(localGdtVideoData);
      ((GdtVideoCeilingData)localObject).setAd(localGdtAd);
      ((GdtVideoCeilingData)localObject).setWebUrl(paramnmr);
      paramInt = paramAdvertisementInfo.mAdJumpMode;
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("ReadinJoyActionUtil", 0, "jump mode = " + paramInt);
      }
      if (paramInt != 4) {
        break label397;
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdAppJson)) {
        break;
      }
      a(paramActivity, paramAdvertisementInfo, paramqoe, 0, null);
      return;
      label373:
      paramnmr.appendQueryParameter("autodownload", "0");
    }
    a(paramActivity, paramAdvertisementInfo, paramqoe, 0, false);
    return;
    label397:
    if (paramInt == 5)
    {
      b(paramActivity, paramAdvertisementInfo, paramqoe, 0, false);
      return;
    }
    if (((GdtVideoCeilingData)localObject).getStyle() == -2147483648) {
      ((GdtVideoCeilingData)localObject).setStyle(1);
    }
    paramAdvertisementInfo = new Bundle();
    paramAdvertisementInfo.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, (GdtVideoCeilingData)localObject, paramAdvertisementInfo);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, qoe paramqoe, int paramInt)
  {
    Object localObject2 = obz.c(paramArticleInfo);
    int i;
    int j;
    label32:
    int k;
    label45:
    Object localObject3;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label629;
      }
      j = 0;
      if (paramArticleInfo.videoJumpChannelID <= 0) {
        break label635;
      }
      k = paramArticleInfo.videoJumpChannelID;
      ndn.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), obz.b(paramArticleInfo.mAlgorithmID, obz.a(paramArticleInfo), paramInt, i), false);
      ndn.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), obz.b(paramArticleInfo.mAlgorithmID, obz.a(paramArticleInfo), paramInt, i));
      localObject3 = rvf.b(paramArticleInfo.mChannelID);
      if ((!qoe.i(paramArticleInfo)) && (!qoe.a(paramArticleInfo)) && (!qoe.j(paramArticleInfo)) && (!qoe.k(paramArticleInfo))) {
        break label642;
      }
      ndn.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Long), (String)localObject3, (String)localObject3, 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), obz.a(paramArticleInfo.mAlgorithmID, obz.a(paramArticleInfo), paramInt, i, j, badq.h(paramActivity), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, obz.e(paramArticleInfo), k, paramArticleInfo), false);
    }
    Object localObject1;
    for (;;)
    {
      ndn.a((String)localObject3, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), obz.a(paramArticleInfo.mAlgorithmID, obz.a(paramArticleInfo), paramInt, i, j, badq.h(paramActivity), (String)localObject2, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, obz.e(paramArticleInfo), k, paramArticleInfo));
      paramqoe = new ArrayList();
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = obz.a();
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
        break label761;
      }
      localObject2 = new pqg();
      ((pqg)localObject2).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo != null) {
        ((pqg)localObject2).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
      }
      ((pqg)localObject2).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((pqg)localObject2).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.d;
      localObject3 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
        break label754;
      }
      ((pqg)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        pqo localpqo = (pqo)((Iterator)localObject3).next();
        if (localpqo != null) {
          ((pqg)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localpqo.jdField_a_of_type_Long));
        }
      }
      i = 0;
      break;
      label629:
      j = 1;
      break label32;
      label635:
      k = 56;
      break label45;
      label642:
      localObject1 = obz.a(paramArticleInfo.mAlgorithmID, obz.a(paramArticleInfo), paramInt, i, j, badq.h(paramActivity), (String)localObject2, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, obz.e(paramArticleInfo), k, paramArticleInfo);
      paramqoe = (qoe)localObject1;
      if (paramInt == 0) {
        paramqoe = new.a(k, (String)new.a.get(ReadInJoyChannelActivity.class), (String)localObject1);
      }
      ndn.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject3, (String)localObject3, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramqoe, false);
    }
    label754:
    ((ReportInfo)localObject1).mFeedsReportData = ((pqg)localObject2);
    label761:
    paramqoe.add(localObject1);
    ogy.a().a(paramqoe);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (paramArticleInfo.mChannelID == 56L) {
        nbe.a(new nmv().a(paramActivity).a(nbe.jdField_a_of_type_Int).b(nbe.U).a((AdvertisementInfo)paramArticleInfo).a());
      }
    }
    else {
      return;
    }
    if ((npj.m((AdvertisementInfo)paramArticleInfo)) && (npl.jdField_b_of_type_Boolean)) {
      paramInt = nbe.an;
    }
    for (;;)
    {
      nbe.a(new nmv().a(paramActivity).a(nbe.jdField_a_of_type_Int).b(paramInt).a((AdvertisementInfo)paramArticleInfo).a());
      return;
      if (a((AdvertisementInfo)paramArticleInfo, paramInt)) {
        paramInt = nbe.R;
      } else if (obz.a(paramArticleInfo)) {
        paramInt = nbe.Q;
      } else {
        paramInt = nbe.L;
      }
    }
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, qoe paramqoe, int paramInt, nmr paramnmr)
  {
    yjs localyjs;
    if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
    {
      a(paramActivity, paramArticleInfo, paramInt);
      if (paramInt == 0)
      {
        ogy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (paramqoe != null) {
          paramqoe.notifyDataSetChanged();
        }
      }
      localyjs = a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramqoe, paramInt, true, paramnmr);
      if (!a(localyjs, paramActivity, (AdvertisementInfo)paramArticleInfo))
      {
        paramnmr = paramArticleInfo.mArticleContentUrl;
        if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) || (!npj.h((AdvertisementInfo)paramArticleInfo))) {
          break label366;
        }
        paramqoe = a((AdvertisementInfo)paramArticleInfo);
        if (paramqoe == null) {
          break label372;
        }
      }
    }
    label342:
    label366:
    label372:
    for (paramqoe = paramqoe.a;; paramqoe = "")
    {
      if (!TextUtils.isEmpty(paramqoe)) {}
      for (;;)
      {
        paramnmr = paramqoe;
        if (AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo))
        {
          paramnmr = paramqoe;
          if (badq.h(null)) {
            if (!paramqoe.contains("?")) {
              break label342;
            }
          }
        }
        for (paramArticleInfo = paramqoe + "&";; paramArticleInfo = paramqoe + "?")
        {
          paramnmr = paramArticleInfo + "acttype=42";
          a(paramActivity);
          paramArticleInfo = new Intent(paramActivity, QQBrowserActivity.class);
          paramArticleInfo.putExtra("startOpenPageTime", System.currentTimeMillis());
          paramArticleInfo.putExtra("url", paramnmr);
          paramArticleInfo.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
          if ((localyjs != null) && (localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd != null))
          {
            if (localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getNocoId() != 0L) {
              paramArticleInfo.putExtra("GdtNocoId", localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getNocoId());
            }
            if (!TextUtils.isEmpty(localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForEffect())) {
              paramArticleInfo.putExtra("GdtWebReportQQ_ACTION_URL", localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForAction());
            }
            if (!TextUtils.isEmpty(localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getTraceId())) {
              paramArticleInfo.putExtra("GdtWebReportQQ_TRACE_ID", localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getTraceId());
            }
          }
          paramActivity.startActivity(paramArticleInfo);
          return;
        }
        paramqoe = paramnmr;
      }
    }
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, qoe paramqoe, int paramInt, boolean paramBoolean, nmr paramnmr)
  {
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) || (!(paramArticleInfo instanceof AdvertisementInfo))) {
      return;
    }
    switch (((AdvertisementInfo)paramArticleInfo).mAdJumpMode)
    {
    default: 
      return;
    case 0: 
    case 1: 
    case 6: 
    case 7: 
      a(paramActivity, paramArticleInfo, paramqoe, paramInt, paramnmr);
      return;
    case 2: 
      a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramqoe, paramInt, paramBoolean, paramnmr);
      return;
    case 4: 
      if (TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdAppJson))
      {
        a(paramActivity, paramArticleInfo, paramqoe, paramInt, paramnmr);
        return;
      }
      a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramqoe, paramInt, true);
      return;
    case 3: 
      a(paramActivity, (AdvertisementInfo)paramArticleInfo, null, paramInt, paramBoolean, paramnmr);
      a(paramActivity, paramArticleInfo, paramqoe, paramInt);
      ogy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      paramqoe.notifyDataSetChanged();
      return;
    }
    b(paramActivity, (AdvertisementInfo)paramArticleInfo, paramqoe, paramInt, true);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, qoe paramqoe, int paramInt, boolean paramBoolean1, boolean paramBoolean2, nmr paramnmr)
  {
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) || (!(paramArticleInfo instanceof AdvertisementInfo))) {
      return;
    }
    if (paramnmr == null) {
      paramnmr = new nmr();
    }
    for (;;)
    {
      switch (((AdvertisementInfo)paramArticleInfo).mAdJumpMode)
      {
      default: 
        return;
      case 0: 
      case 1: 
      case 6: 
      case 7: 
        a(paramActivity, paramArticleInfo, paramqoe, paramInt, paramnmr);
        return;
      case 2: 
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramqoe, paramInt, paramBoolean1, paramnmr);
        return;
      case 4: 
        if (TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdAppJson))
        {
          a(paramActivity, paramArticleInfo, paramqoe, paramInt, null);
          return;
        }
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramqoe, paramInt, true);
        return;
      case 3: 
        paramnmr.jdField_a_of_type_Boolean = a(paramArticleInfo, paramqoe);
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramqoe, paramInt, paramBoolean1, paramBoolean2, paramnmr);
        a(paramActivity, paramArticleInfo, paramqoe, paramInt);
        ogy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (paramqoe == null) {
          break;
        }
        paramqoe.notifyDataSetChanged();
        return;
      case 5: 
        b(paramActivity, (AdvertisementInfo)paramArticleInfo, paramqoe, paramInt, true);
        return;
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("ad", paramAdvertisementInfo);
    localIntent.putExtra("fragmentClass", ReadInJoyAdIMAXBrowserFragment.class);
    localIntent.setClass(BaseApplicationImpl.getApplication(), QQBrowserActivity.class);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130771979, 17432577);
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      bbqo.a(paramContext, 7);
      return;
    }
    catch (Exception paramContext)
    {
      while (!com.tencent.TMG.utils.QLog.isColorLevel()) {}
      com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 0, "closeFloatWindow error:" + paramContext.getMessage());
    }
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, qoe paramqoe, int paramInt, boolean paramBoolean, nmr paramnmr)
  {
    a(paramContext, paramAdvertisementInfo, paramqoe, paramInt, paramBoolean, paramnmr);
    a(paramContext, paramAdvertisementInfo, paramInt);
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, qoe paramqoe, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramAdvertisementInfo, paramqoe, paramInt, paramBoolean1, paramBoolean2);
    a(paramContext, paramAdvertisementInfo, paramInt);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    int i;
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (paramArticleInfo.mChannelID != 56L) {
        break label30;
      }
      i = nbe.M;
    }
    for (;;)
    {
      a(paramContext, paramArticleInfo, paramInt, i);
      label30:
      do
      {
        return;
        if ((npj.m((AdvertisementInfo)paramArticleInfo)) && (npl.jdField_b_of_type_Boolean))
        {
          i = nbe.an;
          break;
        }
      } while ((npj.h((AdvertisementInfo)paramArticleInfo)) && (((AdvertisementInfo)paramArticleInfo).isClickFromPkFragment));
      if (a((AdvertisementInfo)paramArticleInfo, paramInt)) {
        i = nbe.R;
      } else if (obz.a(paramArticleInfo)) {
        i = nbe.Q;
      } else {
        i = nbe.L;
      }
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      nbe.a(new nmv().a(paramContext).a(nbe.jdField_a_of_type_Int).b(paramInt2).a((AdvertisementInfo)paramArticleInfo).e(new JSONObject()).a());
      b(paramContext, paramArticleInfo, paramInt1);
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, qoe paramqoe, int paramInt)
  {
    if ((paramqoe != null) && (paramArticleInfo != null) && ((paramArticleInfo instanceof AdvertisementInfo)) && ((paramContext instanceof Activity)))
    {
      paramqoe.jdField_a_of_type_Yjs = a(paramContext, (AdvertisementInfo)paramArticleInfo, paramqoe, paramInt, false, null);
      if (paramqoe.jdField_a_of_type_Yjs == null) {
        break label57;
      }
    }
    label57:
    for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
    {
      paramqoe.jdField_a_of_type_Long = l;
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("h5url", paramString1);
    localIntent.putExtra("adrl", paramString2);
    localIntent.putExtra("traceId", paramString3);
    localIntent.putExtra("fragmentClass", ReadInJoyAdPopSheetBrowserFragment.class);
    localIntent.setClass(BaseApplicationImpl.getApplication(), QQTranslucentBrowserActivity.class);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(ViewBase paramViewBase1, ViewBase paramViewBase2, Activity paramActivity, ArticleInfo paramArticleInfo, qoe paramqoe, int paramInt1, int paramInt2)
  {
    if ((paramViewBase2 == null) || (paramActivity == null) || (paramArticleInfo == null)) {}
    while (!(paramArticleInfo instanceof AdvertisementInfo)) {
      return;
    }
    paramViewBase2.setOnClickListener(new rvc(paramArticleInfo, paramActivity, paramqoe, paramInt1, paramInt2, paramViewBase1));
  }
  
  public static void a(pzs parampzs)
  {
    a(3, parampzs.jdField_a_of_type_Yjs, parampzs.jdField_a_of_type_Long);
    parampzs.jdField_a_of_type_Long = -2147483648L;
    parampzs.jdField_a_of_type_Yjs = null;
  }
  
  public static void a(yjs paramyjs, AdvertisementInfo paramAdvertisementInfo, nmr paramnmr)
  {
    if ((paramyjs != null) && (paramyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd != null) && (paramnmr != null) && (paramAdvertisementInfo != null) && ((AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (paramAdvertisementInfo.isGameAdSource())) && (!TextUtils.isEmpty(paramyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForLandingPage()))) {}
    try
    {
      Object localObject = Uri.parse(paramyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForLandingPage()).buildUpon();
      if ((badq.b(BaseApplicationImpl.getContext())) && (npi.a(paramAdvertisementInfo.mAdExtInfo)) && (paramnmr.jdField_c_of_type_Boolean))
      {
        int i = 0;
        if (((Uri.Builder)localObject).build().getQueryParameter("autodownload") == null)
        {
          ((Uri.Builder)localObject).appendQueryParameter("autodownload", "1");
          i = 1;
        }
        int j = i;
        if (((Uri.Builder)localObject).build().getQueryParameter("autoDownload") == null)
        {
          j = i;
          if (paramAdvertisementInfo.isGameAdSource())
          {
            ((Uri.Builder)localObject).appendQueryParameter("autoDownload", "1");
            j = 1;
          }
        }
        if (j != 0)
        {
          localObject = ((Uri.Builder)localObject).toString();
          paramyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info.dest_info.landing_page.set((String)localObject);
        }
      }
      if ((paramyjs.jdField_a_of_type_Boolean) && (!a(paramyjs)))
      {
        localObject = Uri.parse(paramyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForClick()).buildUpon();
        if ((badq.b(BaseApplicationImpl.getContext())) && (npi.a(paramAdvertisementInfo.mAdExtInfo)) && (paramnmr.jdField_c_of_type_Boolean) && (((Uri.Builder)localObject).build().getQueryParameter("_autodownload") == null))
        {
          ((Uri.Builder)localObject).appendQueryParameter("_autodownload", "1");
          paramAdvertisementInfo = ((Uri.Builder)localObject).toString();
          paramyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info.report_info.click_url.set(paramAdvertisementInfo);
        }
      }
      return;
    }
    catch (Exception paramyjs)
    {
      while (!com.tencent.TMG.utils.QLog.isColorLevel()) {}
      com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 1, "appendLandingPageParams error!", paramyjs);
    }
  }
  
  private static void a(yjs paramyjs, boolean paramBoolean, AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    if (((paramBoolean) && (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (!npj.d(paramAdvertisementInfo))) || ((paramBoolean) && ((paramAdvertisementInfo.mAdProductType == 1000) || (paramAdvertisementInfo.mAdProductType == 25)) && (TextUtils.isEmpty(paramAdvertisementInfo.mAdCustomizedInvokeUrl))) || (!paramBoolean))
    {
      paramyjs.jdField_c_of_type_Boolean = true;
      paramyjs.d = true;
      return;
    }
    if (((paramAdvertisementInfo.mAdProductType == 1000) || (paramAdvertisementInfo.mAdProductType == 25)) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdCustomizedInvokeUrl)) && (!a(paramAdvertisementInfo, paramContext)))
    {
      paramyjs.jdField_c_of_type_Boolean = true;
      paramyjs.d = true;
      return;
    }
    if ((paramAdvertisementInfo.mAdProductType == 30) || (paramAdvertisementInfo.mAdProductType == 41))
    {
      paramyjs.jdField_c_of_type_Boolean = true;
      paramyjs.d = true;
      return;
    }
    paramyjs.jdField_c_of_type_Boolean = false;
    paramyjs.d = false;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 5);
  }
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramContext == null) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))) {}
    while (!npj.n(paramAdvertisementInfo)) {
      return false;
    }
    obz.e(paramContext, paramAdvertisementInfo.mAdLandingPage);
    return true;
  }
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, qoe paramqoe, int paramInt, boolean paramBoolean)
  {
    paramqoe = a(paramContext, paramAdvertisementInfo, paramqoe, paramInt, paramBoolean, null);
    if (paramqoe == null) {
      return false;
    }
    return b(paramqoe, paramContext, paramAdvertisementInfo);
  }
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, qoe paramqoe, int paramInt, boolean paramBoolean, nmr paramnmr)
  {
    paramqoe = a(paramContext, paramAdvertisementInfo, paramqoe, paramInt, paramBoolean, paramnmr);
    if (paramqoe == null) {
      return false;
    }
    return b(paramqoe, paramContext, paramAdvertisementInfo);
  }
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, qoe paramqoe, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramqoe = a(paramContext, paramAdvertisementInfo, paramqoe, paramInt, paramBoolean1, null);
    if (paramqoe == null) {
      return false;
    }
    paramqoe.f = paramBoolean2;
    return b(paramqoe, paramContext, paramAdvertisementInfo);
  }
  
  public static boolean a(Context paramContext, AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramContext == null) || (!(paramContext instanceof Activity)) || (paramAdData == null) || (paramAdvertisementInfo == null)) {}
    while (!npa.a(paramAdData)) {
      return false;
    }
    a(paramContext);
    npj.b(paramAdvertisementInfo);
    npa.a(paramContext, paramAdData);
    paramContext = (QQAppInterface)obz.a();
    nbe.a(new nmv().a(paramContext).a(BaseApplication.getContext()).a(nbe.jdField_a_of_type_Int).b(nbe.ac).a(paramAdvertisementInfo).d(nbe.a(paramAdData)).a());
    return true;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {
      com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 3, "JumpToGdtAdPage error advertisementInfo is null");
    }
    while (!(paramAdvertisementInfo instanceof AdvertisementInfo)) {
      return false;
    }
    if ((paramInt == 2) || (paramInt == 5) || (paramInt == 3) || (paramInt == 56) || (paramInt == 4) || (paramInt == 2000001) || ((npj.a(paramInt)) && (!a(paramAdvertisementInfo.mAdJumpMode)) && (jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramAdvertisementInfo.mAdProductType))))) {
      return true;
    }
    com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 3, "readInjoy product not go Gdt QQB channelId:" + paramInt + " AdProductType:" + paramAdvertisementInfo.mAdProductType);
    return false;
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    paramAdvertisementInfo = new Intent("android.intent.action.VIEW", Uri.parse(paramAdvertisementInfo.mAdCustomizedInvokeUrl));
    paramAdvertisementInfo.addFlags(268435456);
    try
    {
      paramContext = paramAdvertisementInfo.resolveActivityInfo(paramContext.getPackageManager(), 0);
      paramAdvertisementInfo = "";
      if (paramContext != null) {
        paramAdvertisementInfo = paramContext.packageName;
      }
      boolean bool = TextUtils.isEmpty(paramAdvertisementInfo);
      if (!bool) {
        break label60;
      }
    }
    catch (Exception paramAdvertisementInfo)
    {
      label60:
      while (!com.tencent.TMG.utils.QLog.isColorLevel()) {}
      com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 1, "resolveActivityInfo error!", paramAdvertisementInfo);
    }
    return false;
    return true;
    return false;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    return (jdField_a_of_type_Boolean) && (paramArticleInfo != null) && ((paramArticleInfo instanceof AdvertisementInfo)) && (((AdvertisementInfo)paramArticleInfo).mAdFeedId != 0L) && (!TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdInteractionReportUrl));
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, ViewBase paramViewBase, Activity paramActivity, int paramInt, qhp paramqhp, AdvertisementInfo paramAdvertisementInfo)
  {
    Object localObject1;
    Object localObject2;
    if ((paramAdvertisementInfo.mImaxShowAdType == 1001) || (paramAdvertisementInfo.mImaxShowAdType == 1002))
    {
      if (((AdvertisementInfo)paramArticleInfo).isHideForAnimate) {
        return true;
      }
      if (paramAdvertisementInfo.mImaxShowAdType == 1001)
      {
        localObject1 = paramViewBase.findViewBaseByName("id_view_Ad_CompleteGudie");
        if ((localObject1 != null) && (((ViewBase)localObject1).getNativeView() != null) && (((ViewBase)localObject1).getNativeView().getVisibility() == 0))
        {
          a(paramActivity, paramAdvertisementInfo.mAdLandingPage, paramAdvertisementInfo);
          a(paramActivity, paramArticleInfo, paramInt, nbe.ag);
          return true;
        }
      }
      localObject1 = null;
      if (paramAdvertisementInfo.mImaxShowAdType == 1002)
      {
        localObject2 = paramViewBase.findViewBaseByName("id_article_double_image");
        if (localObject2 != null) {
          localObject1 = ((ViewBase)localObject2).getNativeView();
        }
      }
    }
    for (;;)
    {
      ((AdvertisementInfo)paramArticleInfo).isHideForAnimate = true;
      if (paramqhp != null) {
        paramqhp.b(0);
      }
      localObject2 = new int[2];
      paramqhp = paramViewBase.getNativeView();
      if (localObject1 != null) {
        if ((localObject1 instanceof NativeReadInjoyImageView))
        {
          ReadInjoyIMAXAdFragment.a = ((NativeReadInjoyImageView)localObject1).getDrawable();
          paramqhp = (qhp)localObject1;
        }
      }
      for (;;)
      {
        paramqhp.getLocationOnScreen((int[])localObject2);
        if (((AdvertisementInfo)paramArticleInfo).mImaxShowAdType == 1001)
        {
          localObject1 = paramViewBase.findViewBaseByName("id_video_bg");
          if (localObject1 != null) {
            ((ViewBase)localObject1).getNativeView().setVisibility(4);
          }
          localObject1 = paramViewBase.findViewBaseByName("id_view_Ad_CompleteGudie");
          if (localObject1 != null) {
            ((ViewBase)localObject1).getNativeView().setVisibility(4);
          }
          localObject1 = paramViewBase.findViewBaseByName("id_large_video_icon");
          if (localObject1 != null) {
            ((ViewBase)localObject1).getNativeView().setVisibility(4);
          }
          localObject1 = paramViewBase.findViewBaseByName("id_large_video_duration");
          if (localObject1 != null) {
            ((ViewBase)localObject1).getNativeView().setVisibility(4);
          }
          if (((AdvertisementInfo)paramArticleInfo).isIMaxAndNewStyle)
          {
            paramViewBase = paramViewBase.findViewBaseByName("id_artilce_title");
            if (paramViewBase != null) {
              paramViewBase.getNativeView().setVisibility(4);
            }
          }
        }
        int i = localObject2[1];
        int j = localObject2[0];
        int k = paramqhp.getWidth();
        int m = paramqhp.getHeight();
        paramViewBase = new old();
        paramViewBase.jdField_b_of_type_Int = i;
        paramViewBase.jdField_a_of_type_Int = j;
        paramViewBase.jdField_c_of_type_Int = k;
        paramViewBase.d = m;
        paramViewBase.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
        a(paramActivity);
        ReadInjoyIMAXAdFragment.a(paramActivity, paramViewBase);
        a(paramActivity, paramArticleInfo, paramInt, nbe.ag);
        return true;
        localObject1 = paramViewBase.findViewBaseByName("id_article_large_imge");
        if (localObject1 == null) {
          break label516;
        }
        localObject1 = ((ViewBase)localObject1).getNativeView();
        break;
        paramqhp = (qhp)localObject1;
        if ((localObject1 instanceof FrameLayout))
        {
          paramqhp = (qhp)localObject1;
          if (((FrameLayout)localObject1).getChildCount() > 0)
          {
            View localView = ((FrameLayout)localObject1).getChildAt(0);
            paramqhp = (qhp)localObject1;
            if ((localView instanceof NativeReadInjoyImageView))
            {
              ReadInjoyIMAXAdFragment.a = ((NativeReadInjoyImageView)localView).getDrawable();
              paramqhp = (qhp)localObject1;
              continue;
              return false;
            }
          }
        }
      }
      label516:
      localObject1 = null;
    }
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, qoe paramqoe)
  {
    if ((paramqoe != null) && (paramqoe.a() != null) && (paramqoe.a().a()) && (paramqoe.a().a() != null))
    {
      paramqoe = paramqoe.a().a();
      if ((paramqoe.jdField_b_of_type_Boolean) && (paramqoe.a != null) && (AdvertisementInfo.isAdvertisementInfo(paramqoe.a)))
      {
        paramqoe = (AdvertisementInfo)paramqoe.a;
        if ((!TextUtils.isEmpty(paramqoe.mAdTraceId)) && ((paramArticleInfo instanceof AdvertisementInfo)) && (paramqoe.mAdTraceId.equals(((AdvertisementInfo)paramArticleInfo).mAdTraceId))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(String paramString, Activity paramActivity)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      localIntent.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
      localIntent.putExtra("big_brother_ref_source_key", "biz_src_feeds_kandian");
      paramString = localIntent.resolveActivityInfo(paramActivity.getPackageManager(), 0);
      if (paramString == null) {
        return false;
      }
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("ReadinJoyActionUtil", 2, "jumpToLandingPage: packageName = " + paramString.packageName);
      }
      if (!TextUtils.isEmpty(paramString.packageName))
      {
        a(paramActivity);
        paramActivity.startActivity(localIntent);
        return true;
      }
    }
    catch (Exception paramString)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("ReadinJoyActionUtil", 0, "jumpScheme: e = " + paramString.getMessage());
      }
    }
    return false;
  }
  
  private static boolean a(yjs paramyjs)
  {
    return (paramyjs != null) && (paramyjs.a()) && (paramyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd.isHitJumpExperiment());
  }
  
  public static boolean a(yjs paramyjs, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramyjs == null) {
      return false;
    }
    return b(paramyjs, paramContext, paramAdvertisementInfo);
  }
  
  private static void b(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, qoe paramqoe, int paramInt, boolean paramBoolean)
  {
    if ((paramqoe != null) && (paramBoolean)) {
      a(paramActivity, paramAdvertisementInfo, paramInt);
    }
    Bundle localBundle = new Bundle();
    nzp.a(localBundle, paramAdvertisementInfo);
    long l2 = 0L;
    long l1 = l2;
    if (paramqoe != null)
    {
      l1 = l2;
      if (paramqoe.a() != null)
      {
        l1 = l2;
        if (paramqoe.a().a() != null)
        {
          l1 = l2;
          if (paramqoe.a().a().c == paramAdvertisementInfo.mArticleID) {
            l1 = paramqoe.a();
          }
        }
      }
    }
    localBundle.putLong("param_ad_app_info_video_playposition", l1);
    a(paramActivity);
    NativeAdVideoFragment.a(paramActivity, NativeAdVideoFragment.class, localBundle);
  }
  
  private static void b(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    int i;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label120;
      }
    }
    label120:
    for (int j = 0;; j = 1)
    {
      String str1 = obz.c(paramArticleInfo);
      String str2 = rvf.b(paramInt);
      ndn.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), obz.a(paramArticleInfo.mAlgorithmID, obz.a(paramArticleInfo), paramInt, i, j, badq.h(paramContext), str1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, obz.e(paramArticleInfo), paramArticleInfo), false);
      return;
      i = 0;
      break;
    }
  }
  
  public static boolean b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, qoe paramqoe, int paramInt, boolean paramBoolean)
  {
    paramContext = a(paramContext, paramAdvertisementInfo, paramqoe, paramInt, paramBoolean, false, false, null);
    if (paramContext == null) {
      return false;
    }
    yjr.a(paramContext);
    com.tencent.TMG.utils.QLog.i("ReadinJoyActionUtil", 3, "kandian JumpToTangramSDK");
    return true;
  }
  
  public static boolean b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, qoe paramqoe, int paramInt, boolean paramBoolean, nmr paramnmr)
  {
    if (npj.n(paramAdvertisementInfo))
    {
      a(paramContext, paramAdvertisementInfo);
      return true;
    }
    paramqoe = a(paramContext, paramAdvertisementInfo, paramqoe, paramInt, paramBoolean, paramnmr);
    if (paramqoe == null) {
      return false;
    }
    return b(paramqoe, paramContext, paramAdvertisementInfo);
  }
  
  public static boolean b(yjs paramyjs, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if ((paramyjs == null) || (paramAdvertisementInfo == null) || (paramContext == null)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        npj.b(paramAdvertisementInfo);
        if ((paramAdvertisementInfo.mAdJumpMode != 7) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))) {
          break;
        }
        a(paramContext);
        obz.e(paramContext, paramAdvertisementInfo.mAdLandingPage);
      } while (!com.tencent.TMG.utils.QLog.isColorLevel());
      com.tencent.TMG.utils.QLog.i("ReadinJoyActionUtil", 3, "JumpToGdtAdPage tovialo true");
      return true;
      yjr.a(paramyjs);
    } while (!com.tencent.TMG.utils.QLog.isColorLevel());
    com.tencent.TMG.utils.QLog.i("ReadinJoyActionUtil", 3, "kandian JumpToTangramSDK");
    return true;
  }
  
  public static boolean c(Context paramContext, AdvertisementInfo paramAdvertisementInfo, qoe paramqoe, int paramInt, boolean paramBoolean, nmr paramnmr)
  {
    paramqoe = a(paramContext, paramAdvertisementInfo, paramqoe, paramInt, paramBoolean, false, false, paramnmr);
    if (paramqoe == null) {
      return false;
    }
    if (paramnmr == null)
    {
      paramqoe.d = false;
      paramqoe.jdField_c_of_type_Boolean = false;
    }
    return b(paramqoe, paramContext, paramAdvertisementInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvb
 * JD-Core Version:    0.7.0.1
 */