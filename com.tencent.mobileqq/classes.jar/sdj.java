import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class sdj
{
  private static bhuf a;
  
  public static void a()
  {
    if ((a != null) && (a.isShowing())) {
      a.dismiss();
    }
    a = null;
  }
  
  public static void a(Activity paramActivity, AdData paramAdData)
  {
    if (paramAdData.jdField_b_of_type_Boolean) {
      a(paramActivity, paramAdData.r);
    }
    for (;;)
    {
      paramActivity = (QQAppInterface)ors.a();
      if (paramActivity != null) {
        noy.c(paramActivity, paramAdData);
      }
      return;
      if (paramAdData.d == 12) {
        a(paramActivity, paramAdData.p, paramAdData.n);
      } else {
        a(paramActivity, paramAdData.n);
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
      if (bdee.h(paramContext)) {
        str = paramString + "&acttype=42";
      }
    }
    ors.a(paramContext, str);
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
    for (str = paramString2 + "?"; noy.a(paramContext, paramString1); str = paramString2 + "&")
    {
      ors.a(paramContext, str + "_wv=33554437");
      return;
    }
    a(paramContext, str + "_wv=1");
  }
  
  public static void a(BaseData paramBaseData, View paramView, Context paramContext)
  {
    Object localObject;
    if ((paramBaseData != null) && ((paramBaseData.s == 10) || (paramBaseData.s == 17) || (paramBaseData.s == 22) || (paramBaseData.s == 24) || (paramBaseData.s == 9)))
    {
      if (paramBaseData.s != 17) {
        break label147;
      }
      localObject = (ProteusBannerVideoItemData)paramBaseData;
    }
    for (;;)
    {
      if (a == null) {
        a = new bhuf((Activity)paramContext);
      }
      if (!a.a()) {
        a.a();
      }
      paramBaseData = new sdk(paramContext, paramBaseData, (AdData)localObject);
      if (a.a(0, ((AdData)localObject).jdField_b_of_type_JavaUtilArrayList))
      {
        a.a(paramView, paramBaseData);
        a.a(new sdl(paramContext, (AdData)localObject));
      }
      return;
      label147:
      if (paramBaseData.s == 10) {
        localObject = (ProteusBannerBigPicItemData)paramBaseData;
      } else if (paramBaseData.s == 24) {
        localObject = (ProteusBannerTriplePicItemData)paramBaseData;
      } else if (paramBaseData.s == 9) {
        localObject = (RecommendAdData)paramBaseData;
      } else {
        localObject = (ProteusInnerData)paramBaseData;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sdj
 * JD-Core Version:    0.7.0.1
 */