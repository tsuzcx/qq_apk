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
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
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
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class sht
{
  public static GdtAppReceiver a;
  private static ArrayList<Integer> a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(12), Integer.valueOf(25), Integer.valueOf(30), Integer.valueOf(41), Integer.valueOf(1000) }));
  }
  
  public static GdtHandler.Params a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, rap paramrap, int paramInt, boolean paramBoolean, nyc paramnyc)
  {
    return a(paramContext, paramAdvertisementInfo, paramrap, paramInt, paramBoolean, true, false, paramnyc);
  }
  
  public static GdtHandler.Params a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, rap paramrap, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, nyc paramnyc)
  {
    if ((paramBoolean2) && (!a(paramAdvertisementInfo, paramInt))) {
      return null;
    }
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = a(paramAdvertisementInfo);
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.jdField_c_of_type_Int = 1;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)paramContext);
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(localAdInfo);
    localParams.jdField_a_of_type_Boolean = true;
    localParams.jdField_b_of_type_Boolean = paramBoolean1;
    if (paramAdvertisementInfo.clickPos > 0)
    {
      com.tencent.TMG.utils.QLog.d("ReadinJoyActionUtil", 0, "test click pos " + paramAdvertisementInfo.clickPos);
      localParams.jdField_b_of_type_Int = paramAdvertisementInfo.clickPos;
      paramAdvertisementInfo.resetClickPos();
    }
    if (paramrap != null) {
      localParams.jdField_a_of_type_Long = paramrap.a();
    }
    if (jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
    {
      jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(BaseApplicationImpl.getContext());
    }
    localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
    if ((paramInt != 3) && (paramInt != 4) && (paramAdvertisementInfo.mAdJumpMode != 6) && (!paramBoolean3) && (paramInt != 2000001))
    {
      localParams.jdField_a_of_type_JavaLangClass = ReadInJoyVideoCeilingFragment.class;
      if (paramnyc != null) {
        a(localParams, paramnyc.jdField_a_of_type_Boolean, paramAdvertisementInfo, paramContext);
      }
    }
    localParams.jdField_b_of_type_JavaLangClass = ReadInJoyForCanvasFragment.class;
    if ((paramnyc != null) && (paramnyc.jdField_b_of_type_Boolean)) {
      localParams.jdField_a_of_type_Boolean = false;
    }
    localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
    localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    a(localParams, paramAdvertisementInfo, paramnyc);
    return localParams;
  }
  
  public static String a(ArticleInfo paramArticleInfo, String paramString)
  {
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      paramArticleInfo = ((AdvertisementInfo)paramArticleInfo).mAdExtInfo;
      if (!TextUtils.isEmpty(paramArticleInfo)) {}
    }
    else
    {
      return "";
    }
    try
    {
      paramArticleInfo = new JSONObject(paramArticleInfo).optString(paramString);
      return paramArticleInfo;
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
    return "";
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
  private static nyd a(AdvertisementInfo paramAdvertisementInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull +142 -> 145
    //   6: aload_0
    //   7: getfield 262	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnyh;
    //   10: ifnull +135 -> 145
    //   13: aload_0
    //   14: getfield 262	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnyh;
    //   17: getfield 267	nyh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   20: ifnull +125 -> 145
    //   23: aload_0
    //   24: getfield 262	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnyh;
    //   27: getfield 267	nyh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   30: invokeinterface 273 1 0
    //   35: iconst_2
    //   36: if_icmplt +109 -> 145
    //   39: aload_0
    //   40: getfield 78	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:clickPos	I
    //   43: bipush 101
    //   45: if_icmpne +20 -> 65
    //   48: aload_0
    //   49: getfield 262	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnyh;
    //   52: getfield 267	nyh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   55: iconst_0
    //   56: invokeinterface 277 2 0
    //   61: checkcast 279	nyd
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 78	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:clickPos	I
    //   69: bipush 102
    //   71: if_icmpne +72 -> 143
    //   74: aload_0
    //   75: getfield 262	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnyh;
    //   78: getfield 267	nyh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   81: iconst_1
    //   82: invokeinterface 277 2 0
    //   87: checkcast 279	nyd
    //   90: astore_2
    //   91: aload_2
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: astore_2
    //   98: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   101: ifeq -10 -> 91
    //   104: ldc 80
    //   106: iconst_3
    //   107: new 82	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 281
    //   117: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 257	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 217	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_0
    //   134: areturn
    //   135: astore_2
    //   136: aload_1
    //   137: astore_0
    //   138: aload_2
    //   139: astore_1
    //   140: goto -44 -> 96
    //   143: aload_1
    //   144: areturn
    //   145: aconst_null
    //   146: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramAdvertisementInfo	AdvertisementInfo
    //   1	64	1	localnyd	nyd
    //   93	44	1	localException1	Exception
    //   139	5	1	localObject1	Object
    //   90	8	2	localObject2	Object
    //   135	4	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	39	93	java/lang/Exception
    //   39	65	93	java/lang/Exception
    //   65	91	135	java/lang/Exception
  }
  
  private static nyp a(rap paramrap, String paramString)
  {
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)paramrap.a();
    int j = localReadInJoyXListView.getFirstVisiblePosition();
    int i = Math.max(localReadInJoyXListView.getHeaderViewsCount(), j);
    int k;
    if (i < paramrap.a().size() + localReadInJoyXListView.getHeaderViewsCount())
    {
      k = i - localReadInJoyXListView.getHeaderViewsCount();
      BaseArticleInfo localBaseArticleInfo = paramrap.b(k);
      if ((66 == paramrap.getItemViewType(k)) && (localBaseArticleInfo != null) && (TextUtils.equals(localBaseArticleInfo.getInnerUniqueID(), paramString)))
      {
        int m = i - j;
        if ((m >= 0) && (m < localReadInJoyXListView.getChildCount())) {
          paramrap = localReadInJoyXListView.getChildAt(i - j);
        }
      }
    }
    for (;;)
    {
      if ((paramrap != null) && ((paramrap.getTag() instanceof nyp)))
      {
        return (nyp)paramrap.getTag();
        if ((k >= 0) && (k < paramrap.a().size())) {
          paramrap = paramrap.getView(k, null, localReadInJoyXListView);
        }
      }
      else
      {
        return null;
        i += 1;
        break;
        return null;
      }
      paramrap = null;
    }
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
    //   10: new 339	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo
    //   13: dup
    //   14: invokespecial 340	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:<init>	()V
    //   17: astore_1
    //   18: aload_1
    //   19: getfield 344	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:advertiser_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   22: aload_0
    //   23: getfield 347	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAdvertiseId	J
    //   26: invokevirtual 353	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   29: aload_0
    //   30: getfield 356	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateLogo	Ljava/lang/String;
    //   33: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifne +14 -> 50
    //   39: aload_1
    //   40: getfield 360	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:corporate_logo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   43: aload_0
    //   44: getfield 356	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateLogo	Ljava/lang/String;
    //   47: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 367	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateImageName	Ljava/lang/String;
    //   54: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +14 -> 71
    //   60: aload_1
    //   61: getfield 370	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:corporate_image_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   64: aload_0
    //   65: getfield 367	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateImageName	Ljava/lang/String;
    //   68: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   71: new 372	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo
    //   74: dup
    //   75: invokespecial 373	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:<init>	()V
    //   78: astore_2
    //   79: aload_0
    //   80: getfield 376	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoUrl	Ljava/lang/String;
    //   83: ifnull +14 -> 97
    //   86: aload_2
    //   87: getfield 379	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:video_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   90: aload_0
    //   91: getfield 376	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVideoUrl	Ljava/lang/String;
    //   94: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   97: new 381	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo
    //   100: dup
    //   101: invokespecial 382	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:<init>	()V
    //   104: astore_3
    //   105: aload_3
    //   106: getfield 386	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:advertiser_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo;
    //   109: aload_1
    //   110: invokevirtual 389	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$AdvertiserInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   113: aload_3
    //   114: getfield 393	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:video_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo;
    //   117: aload_2
    //   118: invokevirtual 394	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   121: aload_3
    //   122: getfield 398	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:mini_program_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: aload_0
    //   126: getfield 401	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:miniProgramType	I
    //   129: invokevirtual 406	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   132: new 408	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo
    //   135: dup
    //   136: invokespecial 409	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:<init>	()V
    //   139: astore_1
    //   140: aload_1
    //   141: getfield 412	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:aid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   144: aload_0
    //   145: getfield 415	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAid	J
    //   148: invokevirtual 353	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   151: aload_1
    //   152: getfield 418	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:traceid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   155: aload_0
    //   156: getfield 421	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdTraceId	Ljava/lang/String;
    //   159: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   162: aload_1
    //   163: getfield 424	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:view_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   166: aload_0
    //   167: getfield 427	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdViewId	Ljava/lang/String;
    //   170: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   173: aload_1
    //   174: getfield 430	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:product_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   177: aload_0
    //   178: getfield 433	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductId	Ljava/lang/String;
    //   181: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   184: aload_1
    //   185: getfield 436	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:via	Lcom/tencent/mobileqq/pb/PBStringField;
    //   188: aload_0
    //   189: getfield 439	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdVia	Ljava/lang/String;
    //   192: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   195: aload_1
    //   196: getfield 443	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:noco_id	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   199: aload_0
    //   200: getfield 446	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdNocoId	J
    //   203: invokevirtual 449	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   206: new 451	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo
    //   209: dup
    //   210: invokespecial 452	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:<init>	()V
    //   213: astore 4
    //   215: aload 4
    //   217: getfield 455	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:exposure_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   220: aload_0
    //   221: getfield 458	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdApurl	Ljava/lang/String;
    //   224: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   227: aload 4
    //   229: getfield 461	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   232: aload_0
    //   233: getfield 464	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdRl	Ljava/lang/String;
    //   236: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   239: aload 4
    //   241: getfield 467	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:effect_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   244: aload_0
    //   245: getfield 470	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdEffectUrl	Ljava/lang/String;
    //   248: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   251: aload 4
    //   253: getfield 473	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:landing_page_report_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   256: aload_0
    //   257: getfield 476	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPageReportUrl	Ljava/lang/String;
    //   260: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   263: aload 4
    //   265: getfield 480	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   268: aload_1
    //   269: invokevirtual 481	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   272: new 483	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls
    //   275: dup
    //   276: invokespecial 484	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:<init>	()V
    //   279: astore_1
    //   280: aload_0
    //   281: getfield 487	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SClickUrl	Ljava/util/ArrayList;
    //   284: ifnull +14 -> 298
    //   287: aload_1
    //   288: getfield 491	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_click_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   291: aload_0
    //   292: getfield 487	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SClickUrl	Ljava/util/ArrayList;
    //   295: invokevirtual 496	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   298: aload_0
    //   299: getfield 499	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SExposureUrl	Ljava/util/ArrayList;
    //   302: ifnull +14 -> 316
    //   305: aload_1
    //   306: getfield 502	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:api_exposure_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   309: aload_0
    //   310: getfield 499	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SExposureUrl	Ljava/util/ArrayList;
    //   313: invokevirtual 496	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   316: aload_0
    //   317: getfield 505	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SVideoPlayUrl	Ljava/util/ArrayList;
    //   320: ifnull +14 -> 334
    //   323: aload_1
    //   324: getfield 508	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:video_play_monitor_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   327: aload_0
    //   328: getfield 505	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mC2SVideoPlayUrl	Ljava/util/ArrayList;
    //   331: invokevirtual 496	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   334: aload 4
    //   336: getfield 512	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:thirdparty_monitor_urls	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls;
    //   339: aload_1
    //   340: invokevirtual 513	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   343: new 515	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo
    //   346: dup
    //   347: invokespecial 516	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:<init>	()V
    //   350: astore 6
    //   352: aload_0
    //   353: getfield 519	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPage	Ljava/lang/String;
    //   356: astore_2
    //   357: aload_2
    //   358: astore_1
    //   359: aload_0
    //   360: getfield 262	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnyh;
    //   363: ifnull +23 -> 386
    //   366: aload_2
    //   367: astore_1
    //   368: aload_0
    //   369: getfield 262	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnyh;
    //   372: getfield 522	nyh:h	I
    //   375: ldc_w 523
    //   378: if_icmpne +8 -> 386
    //   381: aload_2
    //   382: invokestatic 525	sht:a	(Ljava/lang/String;)Ljava/lang/String;
    //   385: astore_1
    //   386: aload 6
    //   388: getfield 528	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:landing_page	Lcom/tencent/mobileqq/pb/PBStringField;
    //   391: aload_1
    //   392: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   395: aload 6
    //   397: getfield 531	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:canvas_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   400: aload_0
    //   401: getfield 534	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCanvasJson	Ljava/lang/String;
    //   404: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   407: aload 6
    //   409: getfield 537	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:dest_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   412: aload_0
    //   413: getfield 540	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdDestType	I
    //   416: invokevirtual 406	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   419: new 542	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo
    //   422: dup
    //   423: invokespecial 543	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:<init>	()V
    //   426: astore 5
    //   428: aload_0
    //   429: getfield 546	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   432: invokestatic 551	com/tencent/gdtad/aditem/GdtBaseAdItem:a	(Ljava/lang/String;)Lcom/tencent/gdtad/aditem/GdtBaseAdItem;
    //   435: astore_1
    //   436: aload 5
    //   438: getfield 554	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:app_package_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   441: aload_1
    //   442: getfield 556	com/tencent/gdtad/aditem/GdtBaseAdItem:a	Ljava/lang/String;
    //   445: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   448: new 186	org/json/JSONObject
    //   451: dup
    //   452: aload_0
    //   453: getfield 546	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   456: invokespecial 189	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   459: astore_2
    //   460: aload_2
    //   461: ldc_w 558
    //   464: invokevirtual 193	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   467: astore_1
    //   468: aload_2
    //   469: ldc_w 560
    //   472: invokevirtual 193	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   475: astore_2
    //   476: aload_1
    //   477: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   480: ifne +12 -> 492
    //   483: aload 5
    //   485: getfield 563	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:pkg_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   488: aload_1
    //   489: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   492: aload_2
    //   493: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   496: ifne +12 -> 508
    //   499: aload 5
    //   501: getfield 566	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:app_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   504: aload_2
    //   505: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   508: aload 5
    //   510: getfield 569	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:android_app_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   513: aload_0
    //   514: getfield 433	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductId	Ljava/lang/String;
    //   517: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   520: aload 5
    //   522: getfield 572	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:pkg_download_schema	Lcom/tencent/mobileqq/pb/PBStringField;
    //   525: aload_0
    //   526: getfield 575	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdAppDownLoadSchema	Ljava/lang/String;
    //   529: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   532: aload 5
    //   534: getfield 578	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:customized_invoke_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   537: aload_0
    //   538: getfield 581	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCustomizedInvokeUrl	Ljava/lang/String;
    //   541: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   544: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   547: ifeq +32 -> 579
    //   550: ldc 80
    //   552: iconst_0
    //   553: new 82	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   560: ldc_w 583
    //   563: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload_0
    //   567: getfield 586	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   570: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 102	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: aload 5
    //   581: getfield 589	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:channel_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   584: astore_2
    //   585: aload_0
    //   586: getfield 586	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   589: ifnonnull +349 -> 938
    //   592: ldc 184
    //   594: astore_1
    //   595: aload_2
    //   596: aload_1
    //   597: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   600: aload_0
    //   601: invokestatic 594	oau:h	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   604: ifeq +38 -> 642
    //   607: aload_0
    //   608: getfield 262	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnyh;
    //   611: getfield 267	nyh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   614: ifnull +28 -> 642
    //   617: aload_0
    //   618: getfield 262	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lnyh;
    //   621: getfield 267	nyh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   624: invokeinterface 273 1 0
    //   629: iconst_2
    //   630: if_icmplt +12 -> 642
    //   633: aload_0
    //   634: invokestatic 596	sht:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lnyd;
    //   637: astore_1
    //   638: aload_1
    //   639: ifnonnull +307 -> 946
    //   642: new 598	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   645: dup
    //   646: invokespecial 599	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   649: astore_1
    //   650: aload_1
    //   651: getfield 602	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:product_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   654: aload_0
    //   655: getfield 605	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdProductType	I
    //   658: invokevirtual 406	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   661: aload_1
    //   662: getfield 609	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:display_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo;
    //   665: aload_3
    //   666: invokevirtual 610	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   669: aload_1
    //   670: getfield 614	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   673: aload 4
    //   675: invokevirtual 615	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   678: aload_1
    //   679: getfield 619	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:dest_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo;
    //   682: aload 6
    //   684: invokevirtual 620	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   687: new 622	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo
    //   690: dup
    //   691: invokespecial 623	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:<init>	()V
    //   694: astore_2
    //   695: aload_0
    //   696: getfield 176	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   699: astore_3
    //   700: aload_3
    //   701: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   704: ifne +93 -> 797
    //   707: new 186	org/json/JSONObject
    //   710: dup
    //   711: aload_3
    //   712: invokespecial 189	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   715: astore_3
    //   716: aload_2
    //   717: getfield 626	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:ad_trace_data	Lcom/tencent/mobileqq/pb/PBStringField;
    //   720: aload_3
    //   721: ldc_w 628
    //   724: invokevirtual 193	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   727: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   730: aload_2
    //   731: getfield 631	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   734: aload_3
    //   735: ldc_w 633
    //   738: invokevirtual 193	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   741: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   744: aload_2
    //   745: getfield 636	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   748: aload_3
    //   749: ldc_w 638
    //   752: invokevirtual 193	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   755: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   758: aload_2
    //   759: getfield 641	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_token	Lcom/tencent/mobileqq/pb/PBStringField;
    //   762: aload_3
    //   763: ldc_w 643
    //   766: invokevirtual 193	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   769: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   772: aload_2
    //   773: getfield 646	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:app_username	Lcom/tencent/mobileqq/pb/PBStringField;
    //   776: aload_3
    //   777: ldc_w 648
    //   780: invokevirtual 193	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   783: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   786: aload_2
    //   787: getfield 651	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:pos_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   790: aload_0
    //   791: getfield 654	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosID	J
    //   794: invokevirtual 353	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   797: aload_1
    //   798: getfield 658	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:wechat_app_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo;
    //   801: aload_2
    //   802: invokevirtual 659	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   805: aload_1
    //   806: getfield 663	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:app_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo;
    //   809: aload 5
    //   811: invokevirtual 664	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$AppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   814: aload_0
    //   815: getfield 546	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   818: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   821: ifne +180 -> 1001
    //   824: new 186	org/json/JSONObject
    //   827: dup
    //   828: aload_0
    //   829: getfield 546	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   832: invokespecial 189	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   835: ldc_w 666
    //   838: ldc 184
    //   840: invokevirtual 669	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   843: astore_0
    //   844: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   847: ifeq +29 -> 876
    //   850: ldc 80
    //   852: iconst_0
    //   853: new 82	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   860: ldc_w 671
    //   863: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload_0
    //   867: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokestatic 102	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   876: aload_1
    //   877: getfield 674	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:ext_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   880: aload_0
    //   881: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   884: aload_1
    //   885: areturn
    //   886: astore_2
    //   887: aload_1
    //   888: astore_0
    //   889: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   892: ifeq -884 -> 8
    //   895: ldc 80
    //   897: iconst_0
    //   898: new 82	java/lang/StringBuilder
    //   901: dup
    //   902: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   905: ldc_w 676
    //   908: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: aload_2
    //   912: invokevirtual 257	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   915: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: invokestatic 102	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   924: aload_1
    //   925: areturn
    //   926: astore_2
    //   927: aconst_null
    //   928: astore_1
    //   929: aload_2
    //   930: invokevirtual 677	java/lang/Exception:printStackTrace	()V
    //   933: aconst_null
    //   934: astore_2
    //   935: goto -459 -> 476
    //   938: aload_0
    //   939: getfield 586	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mSubordinateProductId	Ljava/lang/String;
    //   942: astore_1
    //   943: goto -348 -> 595
    //   946: aload_1
    //   947: getfield 679	nyd:b	Ljava/lang/String;
    //   950: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   953: ifne +15 -> 968
    //   956: aload 4
    //   958: getfield 461	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   961: aload_1
    //   962: getfield 679	nyd:b	Ljava/lang/String;
    //   965: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   968: aload_1
    //   969: getfield 680	nyd:a	Ljava/lang/String;
    //   972: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   975: ifne -333 -> 642
    //   978: aload 6
    //   980: getfield 528	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:landing_page	Lcom/tencent/mobileqq/pb/PBStringField;
    //   983: aload_1
    //   984: getfield 680	nyd:a	Ljava/lang/String;
    //   987: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   990: goto -348 -> 642
    //   993: astore_3
    //   994: aload_3
    //   995: invokevirtual 196	org/json/JSONException:printStackTrace	()V
    //   998: goto -201 -> 797
    //   1001: aload_1
    //   1002: getfield 674	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:ext_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1005: ldc 184
    //   1007: invokevirtual 364	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1010: aload_1
    //   1011: astore_0
    //   1012: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1015: ifeq -1007 -> 8
    //   1018: ldc 80
    //   1020: iconst_0
    //   1021: ldc_w 682
    //   1024: invokestatic 102	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1027: aload_1
    //   1028: areturn
    //   1029: astore_2
    //   1030: goto -101 -> 929
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1033	0	paramAdvertisementInfo	AdvertisementInfo
    //   1	1027	1	localObject1	Object
    //   78	724	2	localObject2	Object
    //   886	26	2	localException1	Exception
    //   926	4	2	localException2	Exception
    //   934	1	2	localObject3	Object
    //   1029	1	2	localException3	Exception
    //   104	673	3	localObject4	Object
    //   993	2	3	localJSONException	JSONException
    //   213	744	4	localReportInfo	qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo
    //   426	384	5	localAppInfo	tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo
    //   350	629	6	localDestInfo	qq_ad_get.QQAdGetRsp.AdInfo.DestInfo
    // Exception table:
    //   from	to	target	type
    //   824	876	886	java/lang/Exception
    //   876	884	886	java/lang/Exception
    //   448	468	926	java/lang/Exception
    //   707	797	993	org/json/JSONException
    //   468	476	1029	java/lang/Exception
  }
  
  public static void a()
  {
    if ((BaseApplicationImpl.getContext() != null) && (jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver != null))
    {
      BaseApplicationImpl.getContext().unregisterReceiver(jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = null;
    }
  }
  
  public static void a(int paramInt, GdtHandler.Params paramParams, long paramLong)
  {
    if ((paramParams == null) || (paramLong == -2147483648L)) {}
    do
    {
      return;
      if ((paramParams == null) || (paramLong == -2147483648L))
      {
        yxs.d("ReadinJoyActionUtil", " enterTimeMillis:" + paramLong + " gdtParams:" + paramParams);
        return;
      }
    } while ((paramInt != 0) && (paramInt != 3) && (paramInt != 56) && (paramInt != 2));
    long l = SystemClock.elapsedRealtime();
    yxs.b("ReadinJoyActionUtil", String.format("leave %d", new Object[] { Long.valueOf(l) }));
    if (paramLong == -2147483648L) {
      yxs.d("ReadinJoyActionUtil", "leave error");
    }
    paramLong = l - paramLong;
    yxs.b("ReadinJoyActionUtil", String.format("dwell %d", new Object[] { Long.valueOf(paramLong) }));
    yxx localyxx = new yxx();
    localyxx.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
    localyxx.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(42);
    localyxx.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(paramLong);
    yxw.a(localyxx);
  }
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("param_ad_info", paramAdvertisementInfo);
    ReadinjoyAdPKFragment.a(paramActivity, ReadinjoyAdPKFragment.class, localBundle);
  }
  
  private static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, rap paramrap, int paramInt, boolean paramBoolean)
  {
    if ((paramrap != null) && (paramBoolean)) {
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
    if (paramrap != null) {
      localBundle.putLong("param_ad_app_info_video_playposition", paramrap.a());
    }
    a(paramActivity);
    ReadInJoyNativeAdAppFragment.a(paramActivity, ReadInJoyNativeAdAppFragment.class, localBundle);
  }
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, rap paramrap, int paramInt, boolean paramBoolean, nyc paramnyc)
  {
    paramnyc = a(paramActivity, paramAdvertisementInfo, paramrap, paramInt, paramBoolean, paramnyc);
    if (((paramAdvertisementInfo instanceof AdvertisementInfo)) && (paramnyc != null))
    {
      paramnyc.d = true;
      paramnyc.jdField_c_of_type_Boolean = true;
      if (a(paramnyc, paramActivity, paramAdvertisementInfo)) {
        return;
      }
    }
    Object localObject = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).aid.set(paramAdvertisementInfo.mAdAid);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).traceid.set(paramAdvertisementInfo.mAdTraceId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).view_id.set(paramAdvertisementInfo.mAdViewId);
    paramnyc = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramnyc.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramnyc.click_url.set(paramAdvertisementInfo.mAdRl);
    paramnyc.trace_info.set((MessageMicro)localObject);
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.set(paramnyc);
    GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    localObject = paramAdvertisementInfo.mAdLandingPage;
    paramnyc = (nyc)localObject;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramnyc = Uri.parse((String)localObject).buildUpon();
      if ((bbev.b(BaseApplicationImpl.getApplication()) != 1) || (paramInt == 0)) {
        break label354;
      }
      paramnyc.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      paramnyc = paramnyc.toString();
      localObject = new GdtVideoCeilingData();
      ((GdtVideoCeilingData)localObject).setVideoData(localGdtVideoData);
      ((GdtVideoCeilingData)localObject).setAd(localGdtAd);
      ((GdtVideoCeilingData)localObject).setWebUrl(paramnyc);
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
      a(paramActivity, paramAdvertisementInfo, paramrap, 0, null);
      return;
      label354:
      paramnyc.appendQueryParameter("autodownload", "0");
    }
    a(paramActivity, paramAdvertisementInfo, paramrap, 0, false);
    return;
    label378:
    if (paramInt == 5)
    {
      b(paramActivity, paramAdvertisementInfo, paramrap, 0, false);
      return;
    }
    if (((GdtVideoCeilingData)localObject).getStyle() == -2147483648) {
      ((GdtVideoCeilingData)localObject).setStyle(1);
    }
    paramAdvertisementInfo = new Bundle();
    paramAdvertisementInfo.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, (GdtVideoCeilingData)localObject, paramAdvertisementInfo);
  }
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, rap paramrap, int paramInt, boolean paramBoolean1, boolean paramBoolean2, nyc paramnyc)
  {
    Object localObject = a(paramActivity, paramAdvertisementInfo, paramrap, paramInt, paramBoolean1, paramnyc);
    if (((paramAdvertisementInfo instanceof AdvertisementInfo)) && (localObject != null))
    {
      ((GdtHandler.Params)localObject).f = paramBoolean2;
      if (paramnyc == null)
      {
        ((GdtHandler.Params)localObject).d = false;
        ((GdtHandler.Params)localObject).jdField_c_of_type_Boolean = false;
      }
      if (a((GdtHandler.Params)localObject, paramActivity, paramAdvertisementInfo)) {
        return;
      }
    }
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).aid.set(paramAdvertisementInfo.mAdAid);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).traceid.set(paramAdvertisementInfo.mAdTraceId);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo)localObject).view_id.set(paramAdvertisementInfo.mAdViewId);
    paramnyc = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramnyc.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramnyc.click_url.set(paramAdvertisementInfo.mAdRl);
    paramnyc.trace_info.set((MessageMicro)localObject);
    localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.set(paramnyc);
    GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setDirectPlay(paramBoolean2);
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    localObject = paramAdvertisementInfo.mAdLandingPage;
    paramnyc = (nyc)localObject;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramnyc = Uri.parse((String)localObject).buildUpon();
      if ((bbev.b(BaseApplicationImpl.getApplication()) != 1) || (paramInt == 0)) {
        break label373;
      }
      paramnyc.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      paramnyc = paramnyc.toString();
      localObject = new GdtVideoCeilingData();
      ((GdtVideoCeilingData)localObject).setVideoData(localGdtVideoData);
      ((GdtVideoCeilingData)localObject).setAd(localGdtAd);
      ((GdtVideoCeilingData)localObject).setWebUrl(paramnyc);
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
      a(paramActivity, paramAdvertisementInfo, paramrap, 0, null);
      return;
      label373:
      paramnyc.appendQueryParameter("autodownload", "0");
    }
    a(paramActivity, paramAdvertisementInfo, paramrap, 0, false);
    return;
    label397:
    if (paramInt == 5)
    {
      b(paramActivity, paramAdvertisementInfo, paramrap, 0, false);
      return;
    }
    if (((GdtVideoCeilingData)localObject).getStyle() == -2147483648) {
      ((GdtVideoCeilingData)localObject).setStyle(1);
    }
    paramAdvertisementInfo = new Bundle();
    paramAdvertisementInfo.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, (GdtVideoCeilingData)localObject, paramAdvertisementInfo);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, rap paramrap, int paramInt)
  {
    Object localObject2 = onk.c(paramArticleInfo);
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
        break label622;
      }
      j = 0;
      if (paramArticleInfo.videoJumpChannelID <= 0) {
        break label628;
      }
      k = paramArticleInfo.videoJumpChannelID;
      noo.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), onk.b(paramArticleInfo.mAlgorithmID, onk.a(paramArticleInfo), paramInt, i), false);
      noo.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), onk.b(paramArticleInfo.mAlgorithmID, onk.a(paramArticleInfo), paramInt, i));
      localObject3 = shx.b(paramArticleInfo.mChannelID);
      if ((!rap.i(paramArticleInfo)) && (!rap.a(paramArticleInfo)) && (!rap.j(paramArticleInfo)) && (!rap.k(paramArticleInfo))) {
        break label635;
      }
      noo.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Long), (String)localObject3, (String)localObject3, 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), onk.a(paramArticleInfo.mAlgorithmID, onk.a(paramArticleInfo), paramInt, i, j, bbev.h(paramActivity), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Long), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, onk.e(paramArticleInfo), k, paramArticleInfo), false);
    }
    Object localObject1;
    for (;;)
    {
      noo.a((String)localObject3, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), onk.a(paramArticleInfo.mAlgorithmID, onk.a(paramArticleInfo), paramInt, i, j, bbev.h(paramActivity), (String)localObject2, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, onk.e(paramArticleInfo), k, paramArticleInfo));
      paramrap = new ArrayList();
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = onk.a();
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
        break label753;
      }
      localObject2 = new qcc();
      ((qcc)localObject2).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl != null) {
        ((qcc)localObject2).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Long;
      }
      ((qcc)localObject2).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((qcc)localObject2).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.d;
      localObject3 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
        break label746;
      }
      ((qcc)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        qcl localqcl = (qcl)((Iterator)localObject3).next();
        if (localqcl != null) {
          ((qcc)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqcl.jdField_a_of_type_Long));
        }
      }
      i = 0;
      break;
      label622:
      j = 1;
      break label32;
      label628:
      k = 56;
      break label45;
      label635:
      localObject1 = onk.a(paramArticleInfo.mAlgorithmID, onk.a(paramArticleInfo), paramInt, i, j, bbev.h(paramActivity), (String)localObject2, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, onk.e(paramArticleInfo), k, paramArticleInfo);
      paramrap = (rap)localObject1;
      if (paramInt == 0) {
        paramrap = npx.a(k, (String)npx.a.get(ReadInJoyChannelActivity.class), (String)localObject1);
      }
      noo.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject3, (String)localObject3, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramrap, false);
    }
    label746:
    ((ReportInfo)localObject1).mFeedsReportData = ((qcc)localObject2);
    label753:
    paramrap.add(localObject1);
    osj.a().a(paramrap);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (paramArticleInfo.mChannelID == 56L) {
        nmf.a(new nyg().a(paramActivity).a(nmf.jdField_a_of_type_Int).b(nmf.U).a((AdvertisementInfo)paramArticleInfo).d(((AdvertisementInfo)paramArticleInfo).clickPos).a());
      }
    }
    else {
      return;
    }
    if ((oau.m((AdvertisementInfo)paramArticleInfo)) && (oaw.jdField_b_of_type_Boolean)) {
      paramInt = nmf.an;
    }
    for (;;)
    {
      nmf.a(new nyg().a(paramActivity).a(nmf.jdField_a_of_type_Int).b(paramInt).a((AdvertisementInfo)paramArticleInfo).d(((AdvertisementInfo)paramArticleInfo).clickPos).a());
      return;
      if (a((AdvertisementInfo)paramArticleInfo, paramInt)) {
        paramInt = nmf.R;
      } else if (onk.a(paramArticleInfo)) {
        paramInt = nmf.Q;
      } else {
        paramInt = nmf.L;
      }
    }
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, rap paramrap, int paramInt, nyc paramnyc)
  {
    GdtHandler.Params localParams;
    if (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo))
    {
      a(paramActivity, paramArticleInfo, paramInt);
      if (paramInt == 0)
      {
        osj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (paramrap != null) {
          paramrap.notifyDataSetChanged();
        }
      }
      localParams = a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramrap, paramInt, true, paramnyc);
      if (!a(localParams, paramActivity, (AdvertisementInfo)paramArticleInfo))
      {
        paramnyc = paramArticleInfo.mArticleContentUrl;
        if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) || (!oau.h((AdvertisementInfo)paramArticleInfo))) {
          break label366;
        }
        paramrap = a((AdvertisementInfo)paramArticleInfo);
        if (paramrap == null) {
          break label372;
        }
      }
    }
    label342:
    label366:
    label372:
    for (paramrap = paramrap.a;; paramrap = "")
    {
      if (!TextUtils.isEmpty(paramrap)) {}
      for (;;)
      {
        paramnyc = paramrap;
        if (AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo))
        {
          paramnyc = paramrap;
          if (bbev.h(null)) {
            if (!paramrap.contains("?")) {
              break label342;
            }
          }
        }
        for (paramArticleInfo = paramrap + "&";; paramArticleInfo = paramrap + "?")
        {
          paramnyc = paramArticleInfo + "acttype=42";
          a(paramActivity);
          paramArticleInfo = new Intent(paramActivity, QQBrowserActivity.class);
          paramArticleInfo.putExtra("startOpenPageTime", System.currentTimeMillis());
          paramArticleInfo.putExtra("url", paramnyc);
          paramArticleInfo.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
          if ((localParams != null) && (localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd != null))
          {
            if (localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getNocoId() != 0L) {
              paramArticleInfo.putExtra("GdtNocoId", localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getNocoId());
            }
            if (!TextUtils.isEmpty(localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForEffect())) {
              paramArticleInfo.putExtra("GdtWebReportQQ_ACTION_URL", localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForAction());
            }
            if (!TextUtils.isEmpty(localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getTraceId())) {
              paramArticleInfo.putExtra("GdtWebReportQQ_TRACE_ID", localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getTraceId());
            }
          }
          paramActivity.startActivity(paramArticleInfo);
          return;
        }
        paramrap = paramnyc;
      }
    }
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, rap paramrap, int paramInt, boolean paramBoolean, nyc paramnyc)
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
      a(paramActivity, paramArticleInfo, paramrap, paramInt, paramnyc);
      return;
    case 2: 
      a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramrap, paramInt, paramBoolean, paramnyc);
      return;
    case 4: 
      if (TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdAppJson))
      {
        a(paramActivity, paramArticleInfo, paramrap, paramInt, paramnyc);
        return;
      }
      a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramrap, paramInt, true);
      return;
    case 3: 
      a(paramActivity, (AdvertisementInfo)paramArticleInfo, null, paramInt, paramBoolean, paramnyc);
      a(paramActivity, paramArticleInfo, paramrap, paramInt);
      osj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      paramrap.notifyDataSetChanged();
      return;
    }
    b(paramActivity, (AdvertisementInfo)paramArticleInfo, paramrap, paramInt, true);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, rap paramrap, int paramInt, boolean paramBoolean1, boolean paramBoolean2, nyc paramnyc)
  {
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) || (!(paramArticleInfo instanceof AdvertisementInfo))) {
      return;
    }
    if (paramnyc == null) {
      paramnyc = new nyc();
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
        a(paramActivity, paramArticleInfo, paramrap, paramInt, paramnyc);
        return;
      case 2: 
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramrap, paramInt, paramBoolean1, paramnyc);
        return;
      case 4: 
        if (TextUtils.isEmpty(((AdvertisementInfo)paramArticleInfo).mAdAppJson))
        {
          a(paramActivity, paramArticleInfo, paramrap, paramInt, null);
          return;
        }
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramrap, paramInt, true);
        return;
      case 3: 
        paramnyc.jdField_a_of_type_Boolean = a(paramArticleInfo, paramrap);
        int i = ((AdvertisementInfo)paramArticleInfo).clickPos;
        a(paramActivity, (AdvertisementInfo)paramArticleInfo, paramrap, paramInt, paramBoolean1, paramBoolean2, paramnyc);
        ((AdvertisementInfo)paramArticleInfo).clickPos = i;
        a(paramActivity, paramArticleInfo, paramrap, paramInt);
        osj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (paramrap == null) {
          break;
        }
        paramrap.notifyDataSetChanged();
        return;
      case 5: 
        b(paramActivity, (AdvertisementInfo)paramArticleInfo, paramrap, paramInt, true);
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
      bctn.a(paramContext, 7);
      return;
    }
    catch (Exception paramContext)
    {
      while (!com.tencent.TMG.utils.QLog.isColorLevel()) {}
      com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 0, "closeFloatWindow error:" + paramContext.getMessage());
    }
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, rap paramrap, int paramInt, boolean paramBoolean, nyc paramnyc)
  {
    a(paramContext, paramAdvertisementInfo, paramrap, paramInt, paramBoolean, paramnyc);
    a(paramContext, paramAdvertisementInfo, paramInt);
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, rap paramrap, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramAdvertisementInfo, paramrap, paramInt, paramBoolean1, paramBoolean2);
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
      i = nmf.M;
    }
    for (;;)
    {
      a(paramContext, paramArticleInfo, paramInt, i);
      label30:
      do
      {
        return;
        if ((oau.m((AdvertisementInfo)paramArticleInfo)) && (oaw.jdField_b_of_type_Boolean))
        {
          i = nmf.an;
          break;
        }
      } while ((oau.h((AdvertisementInfo)paramArticleInfo)) && (((AdvertisementInfo)paramArticleInfo).isClickFromPkFragment));
      if (a((AdvertisementInfo)paramArticleInfo, paramInt)) {
        i = nmf.R;
      } else if (onk.a(paramArticleInfo)) {
        i = nmf.Q;
      } else {
        i = nmf.L;
      }
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      nmf.a(new nyg().a(paramContext).a(nmf.jdField_a_of_type_Int).b(paramInt2).a((AdvertisementInfo)paramArticleInfo).e(new JSONObject()).a());
      b(paramContext, paramArticleInfo, paramInt1);
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, rap paramrap, int paramInt)
  {
    if ((paramrap != null) && (paramArticleInfo != null) && ((paramArticleInfo instanceof AdvertisementInfo)) && ((paramContext instanceof Activity)))
    {
      paramrap.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = a(paramContext, (AdvertisementInfo)paramArticleInfo, paramrap, paramInt, false, null);
      if (paramrap.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params == null) {
        break label57;
      }
    }
    label57:
    for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
    {
      paramrap.jdField_a_of_type_Long = l;
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
  
  public static void a(ViewBase paramViewBase1, ViewBase paramViewBase2, Activity paramActivity, ArticleInfo paramArticleInfo, rap paramrap, int paramInt1, int paramInt2)
  {
    if ((paramViewBase2 == null) || (paramActivity == null) || (paramArticleInfo == null)) {}
    while (!(paramArticleInfo instanceof AdvertisementInfo)) {
      return;
    }
    paramViewBase2.setOnClickListener(new shu(paramArticleInfo, paramActivity, paramrap, paramInt1, paramInt2, paramViewBase1));
  }
  
  public static void a(GdtHandler.Params paramParams, AdvertisementInfo paramAdvertisementInfo, nyc paramnyc)
  {
    if ((paramParams != null) && (paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd != null) && (paramnyc != null) && (paramAdvertisementInfo != null) && ((AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (paramAdvertisementInfo.isGameAdSource())) && (!TextUtils.isEmpty(paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForLandingPage()))) {}
    try
    {
      Object localObject = Uri.parse(paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForLandingPage()).buildUpon();
      if ((bbev.b(BaseApplicationImpl.getContext())) && (oat.a(paramAdvertisementInfo.mAdExtInfo)) && (paramnyc.jdField_c_of_type_Boolean))
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
          paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info.dest_info.landing_page.set((String)localObject);
        }
      }
      if ((paramParams.jdField_a_of_type_Boolean) && (!a(paramParams)))
      {
        localObject = Uri.parse(paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForClick()).buildUpon();
        if ((bbev.b(BaseApplicationImpl.getContext())) && (oat.a(paramAdvertisementInfo.mAdExtInfo)) && (paramnyc.jdField_c_of_type_Boolean) && (((Uri.Builder)localObject).build().getQueryParameter("_autodownload") == null))
        {
          ((Uri.Builder)localObject).appendQueryParameter("_autodownload", "1");
          paramAdvertisementInfo = ((Uri.Builder)localObject).toString();
          paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info.report_info.click_url.set(paramAdvertisementInfo);
        }
      }
      return;
    }
    catch (Exception paramParams)
    {
      while (!com.tencent.TMG.utils.QLog.isColorLevel()) {}
      com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 1, "appendLandingPageParams error!", paramParams);
    }
  }
  
  private static void a(GdtHandler.Params paramParams, boolean paramBoolean, AdvertisementInfo paramAdvertisementInfo, Context paramContext)
  {
    if (((paramBoolean) && (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (!oau.d(paramAdvertisementInfo))) || ((paramBoolean) && ((paramAdvertisementInfo.mAdProductType == 1000) || (paramAdvertisementInfo.mAdProductType == 25)) && (TextUtils.isEmpty(paramAdvertisementInfo.mAdCustomizedInvokeUrl))) || (!paramBoolean))
    {
      paramParams.jdField_c_of_type_Boolean = true;
      paramParams.d = true;
      return;
    }
    if (((paramAdvertisementInfo.mAdProductType == 1000) || (paramAdvertisementInfo.mAdProductType == 25)) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdCustomizedInvokeUrl)) && (!a(paramAdvertisementInfo, paramContext)))
    {
      paramParams.jdField_c_of_type_Boolean = true;
      paramParams.d = true;
      return;
    }
    if ((paramAdvertisementInfo.mAdProductType == 30) || (paramAdvertisementInfo.mAdProductType == 41))
    {
      paramParams.jdField_c_of_type_Boolean = true;
      paramParams.d = true;
      return;
    }
    paramParams.jdField_c_of_type_Boolean = false;
    paramParams.d = false;
  }
  
  public static void a(qls paramqls)
  {
    a(3, paramqls.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, paramqls.jdField_a_of_type_Long);
    paramqls.jdField_a_of_type_Long = -2147483648L;
    paramqls.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 5);
  }
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramContext == null) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))) {}
    while (!oau.n(paramAdvertisementInfo)) {
      return false;
    }
    onk.e(paramContext, paramAdvertisementInfo.mAdLandingPage);
    return true;
  }
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, rap paramrap, int paramInt, boolean paramBoolean)
  {
    paramrap = a(paramContext, paramAdvertisementInfo, paramrap, paramInt, paramBoolean, null);
    if (paramrap == null) {
      return false;
    }
    return b(paramrap, paramContext, paramAdvertisementInfo);
  }
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, rap paramrap, int paramInt, boolean paramBoolean, nyc paramnyc)
  {
    paramrap = a(paramContext, paramAdvertisementInfo, paramrap, paramInt, paramBoolean, paramnyc);
    if (paramrap == null) {
      return false;
    }
    return b(paramrap, paramContext, paramAdvertisementInfo);
  }
  
  public static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, rap paramrap, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramrap = a(paramContext, paramAdvertisementInfo, paramrap, paramInt, paramBoolean1, null);
    if (paramrap == null) {
      return false;
    }
    paramrap.f = paramBoolean2;
    return b(paramrap, paramContext, paramAdvertisementInfo);
  }
  
  public static boolean a(Context paramContext, AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramContext == null) || (!(paramContext instanceof Activity)) || (paramAdData == null) || (paramAdvertisementInfo == null)) {}
    while (!oal.a(paramAdData)) {
      return false;
    }
    a(paramContext);
    oau.b(paramAdvertisementInfo);
    oal.a(paramContext, paramAdData);
    paramContext = (QQAppInterface)onk.a();
    nmf.a(new nyg().a(paramContext).a(BaseApplication.getContext()).a(nmf.jdField_a_of_type_Int).b(nmf.ac).a(paramAdvertisementInfo).d(nmf.a(paramAdData)).a());
    return true;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {
      com.tencent.TMG.utils.QLog.e("ReadinJoyActionUtil", 3, "JumpToGdtAdPage error advertisementInfo is null");
    }
    while ((!(paramAdvertisementInfo instanceof AdvertisementInfo)) || ((paramInt == 0) && (TextUtils.isEmpty(a(paramAdvertisementInfo, "AdsIconText"))))) {
      return false;
    }
    if ((paramInt == 2) || (paramInt == 5) || (paramInt == 3) || (paramInt == 56) || (paramInt == 4) || (paramInt == 2000001) || ((oau.a(paramInt)) && (!a(paramAdvertisementInfo.mAdJumpMode)) && (jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramAdvertisementInfo.mAdProductType))))) {
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
        break label59;
      }
    }
    catch (Exception paramAdvertisementInfo)
    {
      label59:
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
  
  public static boolean a(ArticleInfo paramArticleInfo, ViewBase paramViewBase, Activity paramActivity, int paramInt, qtu paramqtu, AdvertisementInfo paramAdvertisementInfo)
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
          a(paramActivity, paramArticleInfo, paramInt, nmf.ag);
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
      if (paramqtu != null) {
        paramqtu.b(0);
      }
      localObject2 = new int[2];
      paramqtu = paramViewBase.getNativeView();
      if (localObject1 != null) {
        if ((localObject1 instanceof NativeReadInjoyImageView))
        {
          ReadInjoyIMAXAdFragment.a = ((NativeReadInjoyImageView)localObject1).getDrawable();
          paramqtu = (qtu)localObject1;
        }
      }
      for (;;)
      {
        paramqtu.getLocationOnScreen((int[])localObject2);
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
        int k = paramqtu.getWidth();
        int m = paramqtu.getHeight();
        paramViewBase = new owp();
        paramViewBase.jdField_b_of_type_Int = i;
        paramViewBase.jdField_a_of_type_Int = j;
        paramViewBase.jdField_c_of_type_Int = k;
        paramViewBase.d = m;
        paramViewBase.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
        a(paramActivity);
        ReadInjoyIMAXAdFragment.a(paramActivity, paramViewBase);
        a(paramActivity, paramArticleInfo, paramInt, nmf.ag);
        return true;
        localObject1 = paramViewBase.findViewBaseByName("id_article_large_imge");
        if (localObject1 == null) {
          break label516;
        }
        localObject1 = ((ViewBase)localObject1).getNativeView();
        break;
        paramqtu = (qtu)localObject1;
        if ((localObject1 instanceof FrameLayout))
        {
          paramqtu = (qtu)localObject1;
          if (((FrameLayout)localObject1).getChildCount() > 0)
          {
            View localView = ((FrameLayout)localObject1).getChildAt(0);
            paramqtu = (qtu)localObject1;
            if ((localView instanceof NativeReadInjoyImageView))
            {
              ReadInjoyIMAXAdFragment.a = ((NativeReadInjoyImageView)localView).getDrawable();
              paramqtu = (qtu)localObject1;
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
  
  public static boolean a(ArticleInfo paramArticleInfo, rap paramrap)
  {
    if ((paramrap != null) && (paramrap.a() != null) && (paramrap.a().b()) && (paramrap.a().a() != null))
    {
      paramrap = paramrap.a().a();
      if ((paramrap.jdField_b_of_type_Boolean) && (paramrap.a != null) && (AdvertisementInfo.isAdvertisementInfo(paramrap.a)))
      {
        paramrap = (AdvertisementInfo)paramrap.a;
        if ((!TextUtils.isEmpty(paramrap.mAdTraceId)) && ((paramArticleInfo instanceof AdvertisementInfo)) && (paramrap.mAdTraceId.equals(((AdvertisementInfo)paramArticleInfo).mAdTraceId))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(GdtHandler.Params paramParams)
  {
    return (paramParams != null) && (paramParams.a()) && (paramParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.isHitJumpExperiment());
  }
  
  public static boolean a(GdtHandler.Params paramParams, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramParams == null) {
      return false;
    }
    return b(paramParams, paramContext, paramAdvertisementInfo);
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
  
  private static void b(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, rap paramrap, int paramInt, boolean paramBoolean)
  {
    if ((paramrap != null) && (paramBoolean)) {
      a(paramActivity, paramAdvertisementInfo, paramInt);
    }
    Bundle localBundle = new Bundle();
    ola.a(localBundle, paramAdvertisementInfo);
    long l2 = 0L;
    long l1 = l2;
    if (paramrap != null)
    {
      l1 = l2;
      if (paramrap.a() != null)
      {
        l1 = l2;
        if (paramrap.a().a() != null)
        {
          l1 = l2;
          if (paramrap.a().a().c == paramAdvertisementInfo.mArticleID) {
            l1 = paramrap.a();
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
        break label119;
      }
    }
    label119:
    for (int j = 0;; j = 1)
    {
      String str1 = onk.c(paramArticleInfo);
      String str2 = shx.b(paramInt);
      noo.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), onk.a(paramArticleInfo.mAlgorithmID, onk.a(paramArticleInfo), paramInt, i, j, bbev.h(paramContext), str1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, onk.e(paramArticleInfo), paramArticleInfo), false);
      return;
      i = 0;
      break;
    }
  }
  
  public static boolean b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, rap paramrap, int paramInt, boolean paramBoolean)
  {
    paramContext = a(paramContext, paramAdvertisementInfo, paramrap, paramInt, paramBoolean, false, false, null);
    if (paramContext == null) {
      return false;
    }
    GdtHandler.a(paramContext);
    com.tencent.TMG.utils.QLog.i("ReadinJoyActionUtil", 3, "kandian JumpToTangramSDK");
    return true;
  }
  
  public static boolean b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, rap paramrap, int paramInt, boolean paramBoolean, nyc paramnyc)
  {
    if (oau.n(paramAdvertisementInfo))
    {
      a(paramContext, paramAdvertisementInfo);
      return true;
    }
    paramrap = a(paramContext, paramAdvertisementInfo, paramrap, paramInt, paramBoolean, paramnyc);
    if (paramrap == null) {
      return false;
    }
    return b(paramrap, paramContext, paramAdvertisementInfo);
  }
  
  private static boolean b(Context paramContext, rap paramrap, ArticleInfo paramArticleInfo)
  {
    if ((paramrap == null) || (paramrap.a() != 0)) {}
    nyp localnyp;
    do
    {
      do
      {
        return false;
      } while (!TextUtils.isEmpty(a(paramArticleInfo, "AdsIconText")));
      onk.a(paramArticleInfo);
      paramArticleInfo.innerUniqueID = a(paramArticleInfo, "landing_page_rowkey");
      localnyp = a(paramrap, paramArticleInfo.innerUniqueID);
    } while (localnyp == null);
    a(paramContext, paramArticleInfo, paramrap.a());
    paramrap.a(localnyp.a(), paramArticleInfo);
    return true;
  }
  
  public static boolean b(GdtHandler.Params paramParams, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if ((paramParams == null) || (paramAdvertisementInfo == null) || (paramContext == null)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        oau.b(paramAdvertisementInfo);
        if ((paramAdvertisementInfo.mAdJumpMode != 7) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))) {
          break;
        }
        a(paramContext);
        onk.e(paramContext, paramAdvertisementInfo.mAdLandingPage);
      } while (!com.tencent.TMG.utils.QLog.isColorLevel());
      com.tencent.TMG.utils.QLog.i("ReadinJoyActionUtil", 3, "JumpToGdtAdPage tovialo true");
      return true;
      GdtHandler.a(paramParams);
    } while (!com.tencent.TMG.utils.QLog.isColorLevel());
    com.tencent.TMG.utils.QLog.i("ReadinJoyActionUtil", 3, "kandian JumpToTangramSDK");
    return true;
  }
  
  public static boolean c(Context paramContext, AdvertisementInfo paramAdvertisementInfo, rap paramrap, int paramInt, boolean paramBoolean, nyc paramnyc)
  {
    paramrap = a(paramContext, paramAdvertisementInfo, paramrap, paramInt, paramBoolean, false, false, paramnyc);
    if (paramrap == null) {
      return false;
    }
    if (paramnyc == null)
    {
      paramrap.d = false;
      paramrap.jdField_c_of_type_Boolean = false;
    }
    return b(paramrap, paramContext, paramAdvertisementInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sht
 * JD-Core Version:    0.7.0.1
 */