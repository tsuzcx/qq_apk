import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class ssu
{
  private static blnb a;
  
  public static void a()
  {
    if ((a != null) && (a.isShowing())) {
      a.dismiss();
    }
    a = null;
  }
  
  public static void a(Activity paramActivity, AdData paramAdData)
  {
    if (paramAdData.a) {
      a(paramActivity, paramAdData.j);
    }
    for (;;)
    {
      paramActivity = (QQAppInterface)ozs.a();
      if (paramActivity != null) {
        nzq.a(paramActivity, paramAdData);
      }
      return;
      if (paramAdData.jdField_b_of_type_Int == 12) {
        a(paramActivity, paramAdData.h, paramAdData.f);
      } else {
        a(paramActivity, paramAdData.f);
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_ad_json", paramString);
    PublicTransFragmentActivity.b(paramActivity, localIntent, ReadInJoyNativeAdFragment.class);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (bhnv.h(paramContext)) {
        str = paramString + "&acttype=42";
      }
    }
    ozs.a(paramContext, str);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      if (!paramString2.contains("?")) {
        break label70;
      }
    }
    label70:
    for (str = paramString2 + "?"; nzq.a(paramContext, paramString1); str = paramString2 + "&")
    {
      ozs.a(paramContext, str + "_wv=33554437");
      return;
    }
    a(paramContext, str + "_wv=1");
  }
  
  public static void a(BaseData paramBaseData, View paramView, Context paramContext)
  {
    Object localObject;
    if ((paramBaseData != null) && ((paramBaseData.r == 10) || (paramBaseData.r == 17) || (paramBaseData.r == 22) || (paramBaseData.r == 24) || (paramBaseData.r == 9)))
    {
      if (paramBaseData.r != 17) {
        break label147;
      }
      localObject = (ProteusBannerVideoItemData)paramBaseData;
    }
    for (;;)
    {
      if (a == null) {
        a = new blnb((Activity)paramContext);
      }
      if (!a.a()) {
        a.a();
      }
      paramBaseData = new ssv(paramContext, paramBaseData, (AdData)localObject);
      if (a.a(0, ((AdData)localObject).jdField_b_of_type_JavaUtilArrayList))
      {
        a.a(paramView, paramBaseData);
        a.a(new ssw(paramContext, (AdData)localObject));
      }
      return;
      label147:
      if (paramBaseData.r == 10) {
        localObject = (ProteusBannerBigPicItemData)paramBaseData;
      } else if (paramBaseData.r == 24) {
        localObject = (ProteusBannerTriplePicItemData)paramBaseData;
      } else if (paramBaseData.r == 9) {
        localObject = (RecommendAdData)paramBaseData;
      } else {
        localObject = (ProteusInnerData)paramBaseData;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssu
 * JD-Core Version:    0.7.0.1
 */