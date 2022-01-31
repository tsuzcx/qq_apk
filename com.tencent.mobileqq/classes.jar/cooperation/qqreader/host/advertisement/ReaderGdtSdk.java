package cooperation.qqreader.host.advertisement;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import bfne;
import bfnf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.mobileqq.fragment.ReaderAdVideoCeilingFragment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.ExternalExpInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import yjm;
import yjo;
import yjr;
import yjs;
import yjt;
import ynv;
import yny;
import yoi;

public class ReaderGdtSdk
{
  public static void bindViewForReport(View paramView, ReaderGdtSdk.ReportListener paramReportListener)
  {
    if (paramReportListener != null)
    {
      paramView.setTag(2131313371, ReaderGdtSdk.ReportListener.a(paramReportListener).a());
      paramView.setTag(2131313370, paramReportListener);
      return;
    }
    paramView.setTag(2131313371, null);
    paramView.setTag(2131313370, null);
  }
  
  public static void cleanImpressionCountingMap()
  {
    yoi.a().a();
  }
  
  public static void handleClick(@Nullable ContextWrapper paramContextWrapper, @NonNull ReaderAdWrapper paramReaderAdWrapper, ReaderGdtSdk.GdtAppReceiverWrapper paramGdtAppReceiverWrapper)
  {
    handleClick(paramContextWrapper, paramReaderAdWrapper, paramGdtAppReceiverWrapper, 0);
  }
  
  public static void handleClick(@Nullable ContextWrapper paramContextWrapper, @NonNull ReaderAdWrapper paramReaderAdWrapper, ReaderGdtSdk.GdtAppReceiverWrapper paramGdtAppReceiverWrapper, int paramInt)
  {
    paramContextWrapper = bfnf.a(paramContextWrapper);
    if (paramContextWrapper == null)
    {
      bfne.a("ReaderGdtSdkProvider", "handleClick: act == null");
      return;
    }
    yjs localyjs = new yjs();
    localyjs.jdField_a_of_type_Int = 7;
    localyjs.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContextWrapper);
    localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramReaderAdWrapper.a();
    localyjs.jdField_a_of_type_Boolean = true;
    localyjs.jdField_b_of_type_Boolean = true;
    if (paramGdtAppReceiverWrapper != null) {}
    for (paramContextWrapper = ReaderGdtSdk.GdtAppReceiverWrapper.a(paramGdtAppReceiverWrapper);; paramContextWrapper = null)
    {
      localyjs.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramContextWrapper);
      localyjs.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForJS.class;
      if (paramReaderAdWrapper.isVideoAd())
      {
        localyjs.jdField_a_of_type_JavaLangClass = ReaderAdVideoCeilingFragment.class;
        localyjs.c = true;
        localyjs.d = false;
      }
      if (localyjs.jdField_a_of_type_AndroidOsBundle == null) {
        localyjs.jdField_a_of_type_AndroidOsBundle = new Bundle();
      }
      localyjs.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_jc_neirong");
      localyjs.jdField_a_of_type_Long = paramInt;
      yjr.a(localyjs);
      return;
    }
  }
  
  public static boolean isBackFromMotiveVideoPage(int paramInt)
  {
    return paramInt == 101;
  }
  
  public static boolean isProfitableForMotiveVideo(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getBooleanExtra("profitable_flag", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void jumpToMotiveVideoPage(ContextWrapper paramContextWrapper, ReaderAdWrapper paramReaderAdWrapper)
  {
    Activity localActivity = bfnf.a(paramContextWrapper);
    GdtAd localGdtAd;
    if ((localActivity != null) && (paramReaderAdWrapper.a() != null))
    {
      localGdtAd = paramReaderAdWrapper.a();
      paramReaderAdWrapper = new GdtMotiveVideoPageData();
      paramReaderAdWrapper.productType = localGdtAd.getProductType();
      paramReaderAdWrapper.vSize = localGdtAd.getCreativeSize();
      paramReaderAdWrapper.screenOrientation = 1;
      paramReaderAdWrapper.adId = localGdtAd.getAdvertiserId();
      paramReaderAdWrapper.vid = localGdtAd.getTencent_video_id();
      paramReaderAdWrapper.url = localGdtAd.getVideoUrl();
      yny.d("ReaderGdtSdkProvider", "VideoUrl " + paramReaderAdWrapper.url);
      if ((!TextUtils.isEmpty(paramReaderAdWrapper.url)) && (paramReaderAdWrapper.url.startsWith("https://"))) {
        paramReaderAdWrapper.url = paramReaderAdWrapper.url.replaceFirst("https://", "http://");
      }
      if (localGdtAd.getImageData() != null) {
        break label258;
      }
      paramContextWrapper = "";
      paramReaderAdWrapper.previewImgUrl = paramContextWrapper;
      paramReaderAdWrapper.bannerImgName = localGdtAd.getAdvertiser_corporate_image_name();
      paramReaderAdWrapper.bannerBaseInfoText = localGdtAd.getText();
      paramReaderAdWrapper.bannerLogo = localGdtAd.getAdvertiser_corporate_logo();
      paramReaderAdWrapper.exposureUrl = localGdtAd.getUrlForImpression();
      paramReaderAdWrapper.appScore = Double.valueOf(localGdtAd.getAppScore()).doubleValue();
      paramReaderAdWrapper.downloadNum = localGdtAd.getAppDownloadNum();
      paramReaderAdWrapper.style = localGdtAd.getStyle();
      paramContextWrapper = ynv.a(localGdtAd.info);
      if (paramContextWrapper != null) {
        break label269;
      }
    }
    label258:
    label269:
    for (paramContextWrapper = "";; paramContextWrapper = paramContextWrapper.toString())
    {
      paramReaderAdWrapper.adsContent = paramContextWrapper;
      paramReaderAdWrapper.processId = BaseApplicationImpl.sProcessId;
      paramReaderAdWrapper.refId = "biz_src_jc_neirong";
      GdtMotiveVideoFragment.a(localActivity, GdtMotiveVideoFragment.class, paramReaderAdWrapper);
      return;
      paramContextWrapper = localGdtAd.getImageData().a;
      break;
    }
  }
  
  public static void reportImpression(View paramView)
  {
    yoi.a().a(paramView);
  }
  
  public static void requestAdData(Context paramContext, Map<String, Integer> paramMap, String paramString1, String paramString2, ReaderGdtSdk.RequestListener paramRequestListener)
  {
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    Object localObject = new qq_ad_get.QQAdGet.UserInfo();
    ((qq_ad_get.QQAdGet.UserInfo)localObject).qq.set(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    localQQAdGet.user_info.set((MessageMicro)localObject, true);
    localObject = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject).deep_link_version.set(1, true);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (((Integer)localEntry.getValue()).intValue() > 0)
      {
        qq_ad_get.QQAdGet.PositionInfo localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
        localPositionInfo.pos_id.set((String)localEntry.getKey(), true);
        localPositionInfo.ad_count.set(((Integer)localEntry.getValue()).intValue(), true);
        localPositionInfo.pos_ext.set((MessageMicro)localObject, true);
        localQQAdGet.position_info.add(localPositionInfo);
      }
    }
    localQQAdGet.gdt_cookie.set(paramString1, true);
    localQQAdGet.support_https.set(true, true);
    localQQAdGet.external_exp_info.exp_id.add(paramString2);
    localQQAdGet.external_exp_info.traffic_type.set(8);
    paramMap = new yjo();
    paramMap.a = localQQAdGet;
    new yjm(paramMap, new WeakReference(paramRequestListener)).a(new WeakReference(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderGdtSdk
 * JD-Core Version:    0.7.0.1
 */