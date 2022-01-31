import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class odv
{
  public static int a(ProteusBannerBigPicItemData paramProteusBannerBigPicItemData)
  {
    if (b(paramProteusBannerBigPicItemData)) {
      return 28;
    }
    if (a(paramProteusBannerBigPicItemData)) {
      return 25;
    }
    if (paramProteusBannerBigPicItemData.a) {
      return 26;
    }
    return 10;
  }
  
  public static int a(ProteusBannerTriplePicItemData paramProteusBannerTriplePicItemData)
  {
    if (a(paramProteusBannerTriplePicItemData)) {
      return 30;
    }
    return 27;
  }
  
  public static int a(ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    if (a(paramProteusBannerVideoItemData)) {
      return 29;
    }
    return 15;
  }
  
  public static int a(ProteusInnerData paramProteusInnerData)
  {
    int j = 20;
    int i;
    if (a(paramProteusInnerData)) {
      i = 24;
    }
    do
    {
      do
      {
        return i;
        if (paramProteusInnerData.a()) {
          return 21;
        }
        i = j;
      } while (paramProteusInnerData.b());
      if (paramProteusInnerData.c()) {
        return 31;
      }
      i = j;
    } while (!paramProteusInnerData.d());
    return 31;
  }
  
  public static void a(Context paramContext, AdData paramAdData)
  {
    if (a(paramAdData))
    {
      String str1 = paramAdData.jdField_a_of_type_Obd.m;
      if (!TextUtils.isEmpty(paramAdData.jdField_a_of_type_Obd.n)) {
        str1 = paramAdData.jdField_a_of_type_Obd.n;
      }
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        str2 = str1;
        if (!TextUtils.isEmpty(paramAdData.m)) {
          str2 = paramAdData.m;
        }
      }
      ors.d(paramContext, szl.a(str2));
    }
  }
  
  public static void a(Context paramContext, AdData paramAdData, int paramInt)
  {
    if (paramAdData == null) {
      return;
    }
    szl.a(paramContext, paramAdData.K, paramAdData.m, paramAdData.u);
    paramContext = (QQAppInterface)ors.a();
    noy.a(new obk().a(paramContext).a(BaseApplication.getContext()).a(noy.J).b(noy.K).a(oef.a(paramAdData)).d(paramInt).d(noy.a(paramAdData)).a());
  }
  
  public static void a(Context paramContext, ViewBase paramViewBase, String paramString, int paramInt)
  {
    try
    {
      View localView = ((psj)paramViewBase).getNativeView();
      a(paramContext, paramViewBase, paramString, paramInt, localView.getWidth(), localView.getHeight());
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FastWeqAdUtils", 2, "loadImage error " + paramContext.getMessage());
    }
  }
  
  public static void a(Context paramContext, ViewBase paramViewBase, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramViewBase = (psj)paramViewBase;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramInt2;
      localURLDrawableOptions.mRequestHeight = paramInt3;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(bcuq.b(paramInt2, paramInt3, aekt.a(paramInt1, paramContext.getResources())));
      paramString.setDecodeHandler(bcuq.i);
      paramViewBase.setImageDrawable(paramString, true);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FastWeqAdUtils", 2, "loadImage error " + paramContext.getMessage());
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    szl.a(paramContext);
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      ors.d(paramContext, szl.a(paramString2));
      return;
      if (!TextUtils.isEmpty(paramString3)) {
        paramString2 = paramString3;
      } else {
        paramString2 = paramString1;
      }
    }
  }
  
  public static boolean a(AdData paramAdData)
  {
    return (paramAdData != null) && (paramAdData.jdField_a_of_type_Obd != null) && (!TextUtils.isEmpty(paramAdData.jdField_a_of_type_Obd.b));
  }
  
  public static void b(Context paramContext, AdData paramAdData)
  {
    if (paramAdData == null) {
      return;
    }
    szl.a(paramContext, paramAdData.K, paramAdData.m, paramAdData.u);
    paramContext = (QQAppInterface)ors.a();
    noy.a(new obk().a(paramContext).a(BaseApplication.getContext()).a(noy.J).b(noy.K).a(oef.a(paramAdData)).d(noy.a(paramAdData)).a());
  }
  
  public static boolean b(AdData paramAdData)
  {
    return (paramAdData != null) && (paramAdData.jdField_a_of_type_Obl != null) && (5001 == paramAdData.jdField_a_of_type_Obl.i);
  }
  
  public static boolean c(AdData paramAdData)
  {
    return (a(paramAdData)) && ("3".equals(paramAdData.jdField_a_of_type_Obd.x));
  }
  
  public static boolean d(AdData paramAdData)
  {
    return (a(paramAdData)) && ("1".equals(paramAdData.jdField_a_of_type_Obd.x));
  }
  
  public static boolean e(AdData paramAdData)
  {
    return (a(paramAdData)) && ("2".equals(paramAdData.jdField_a_of_type_Obd.x));
  }
  
  public static boolean f(AdData paramAdData)
  {
    if (paramAdData == null) {}
    while ((TextUtils.isEmpty(paramAdData.K)) || (!paramAdData.c) || (!oed.d(paramAdData))) {
      return false;
    }
    return true;
  }
  
  public static boolean g(AdData paramAdData)
  {
    if ((paramAdData instanceof ProteusInnerData)) {
      return ((ProteusInnerData)paramAdData).d();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     odv
 * JD-Core Version:    0.7.0.1
 */