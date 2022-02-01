import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView.SimpleRoundProgress;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class olu
{
  public static int a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 0;
    case 3: 
      if (paramBoolean) {
        return 3;
      }
      return 1;
    case 4: 
      return 2;
    case 5: 
      return 4;
    }
    return 5;
  }
  
  public static int a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    int j = 2;
    int i;
    if ((TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.h)) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.g)))
    {
      i = 1;
      if (a(paramContext, paramAdvertisementInfo)) {
        return 1;
      }
    }
    else
    {
      i = 2;
    }
    if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.h)) {
      j = 0;
    }
    for (;;)
    {
      return j;
      if (TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_f_of_type_JavaLangString)) {
        j = i;
      }
    }
  }
  
  public static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    int j = -1;
    int i = j;
    if (paramAdvertisementInfo.mBusiJson != null)
    {
      paramAdvertisementInfo = paramAdvertisementInfo.mBusiJson.optString("article_ad_ext");
      i = j;
      if (TextUtils.isEmpty(paramAdvertisementInfo)) {}
    }
    try
    {
      i = new JSONObject(paramAdvertisementInfo).optInt("para_pos", 0);
      return i;
    }
    catch (Exception paramAdvertisementInfo)
    {
      paramAdvertisementInfo.printStackTrace();
    }
    return -1;
  }
  
  public static JSONObject a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo == null)) {
      return new JSONObject();
    }
    Object localObject = new acry();
    ((acry)localObject).jdField_a_of_type_JavaLangString = "ce2d9f";
    localObject = acrx.a(BaseApplication.getContext(), (acry)localObject);
    int i = paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int;
    int j = a(paramContext, paramAdvertisementInfo);
    paramContext = new JSONObject();
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      if ((localObject != null) && (((acrz)localObject).a != null))
      {
        localJSONObject.put("imei", opp.b());
        localJSONObject.put("oaid", ((acrz)localObject).a.aid_ticket.get());
      }
      localJSONObject.put("source_id", paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int);
      localJSONObject.put("platform_id", paramAdvertisementInfo.mAdvertisementSoftInfo.d);
      localJSONObject.put("goods_type", paramAdvertisementInfo.mAdvertisementSoftInfo.e);
      localJSONObject.put("goods_id", paramAdvertisementInfo.mAdvertisementSoftInfo.i);
      localJSONObject.put("goods_name", paramAdvertisementInfo.mAdvertisementSoftInfo.j);
      localJSONObject.put("account_id", paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_f_of_type_Int);
      localJSONObject.put("content_type", paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_a_of_type_Int);
      localJSONObject.put("rowkey", paramAdvertisementInfo.mRowKey);
      localJSONObject.put("cmsid", paramAdvertisementInfo.mAdvertisementSoftInfo.x);
      if (paramInt3 != -1) {
        localJSONObject.put("button_state", paramInt3);
      }
      localJSONObject.put("adid", paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("position", paramInt5);
      localJSONObject.put("card_style", paramInt4);
      if (i == 0) {
        localJSONObject.put("is_ams_reported", 1);
      }
      if (i == 3) {
        localJSONObject.put("author_id", paramAdvertisementInfo.mAdvertisementSoftInfo.H);
      }
      if (paramInt1 == nxw.jdField_a_of_type_Int)
      {
        if (paramInt2 != 0) {
          localJSONObject.put("click_pos", paramInt2);
        }
        localJSONObject.put("link_type", j);
        localJSONObject.put("click_type", 3);
        paramContext.put("click_info_report", localJSONObject.toString());
        return paramContext;
      }
    }
    catch (JSONException paramAdvertisementInfo)
    {
      paramAdvertisementInfo.printStackTrace();
      return paramContext;
    }
    localJSONObject.put("exposure_type", 3);
    paramContext.put("exposure_info_report", localJSONObject.toString());
    return paramContext;
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramString)) {
      for (;;)
      {
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = afur.a(paramInt2, paramContext.getResources());
          localURLDrawableOptions.mRequestHeight = afur.a(paramInt2, paramContext.getResources());
          if (paramInt3 != -1) {
            localURLDrawableOptions.mUseMemoryCache = false;
          }
          localURLDrawable = URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions);
          localURLDrawable.setTag(bgey.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, afur.a(paramInt1, paramContext.getResources())));
          if (paramInt3 != 0) {
            continue;
          }
          localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
          localURLDrawable.setDecodeHandler(bgey.k);
        }
        catch (Exception paramContext)
        {
          URLDrawable localURLDrawable;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ReadInJoyCommonAdUtils", 2, "后台下发的url格式有问题：" + paramString);
          return;
          localURLDrawable.setDecodeHandler(bgey.j);
          continue;
        }
        paramImageView.setImageDrawable(localURLDrawable);
        return;
        if (paramInt3 != 1) {
          continue;
        }
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(bgey.k);
      }
    }
  }
  
  public static void a(ReadInjoyHeaderAdDownloadView.SimpleRoundProgress paramSimpleRoundProgress)
  {
    if (paramSimpleRoundProgress != null)
    {
      paramSimpleRoundProgress.jdField_a_of_type_Int = Color.parseColor("#CCE5E5E5");
      paramSimpleRoundProgress.jdField_b_of_type_Int = Color.parseColor("#FF00CAFC");
      paramSimpleRoundProgress.jdField_a_of_type_Float = afur.a(1.5F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.jdField_b_of_type_Float = afur.a(1.5F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.jdField_c_of_type_Float = afur.a(7.0F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.jdField_c_of_type_Int = 100;
      paramSimpleRoundProgress.e = 270;
      paramSimpleRoundProgress.d = 0;
      paramSimpleRoundProgress.jdField_f_of_type_Int = 1;
    }
  }
  
  private static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramContext == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo.g == null)) {}
    for (;;)
    {
      return false;
      try
      {
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(paramAdvertisementInfo.mAdvertisementSoftInfo.g));
        paramContext = localIntent.resolveActivityInfo(paramContext.getPackageManager(), 0);
        if (paramContext != null)
        {
          boolean bool = TextUtils.isEmpty(paramContext.packageName);
          if (!bool) {
            return true;
          }
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     olu
 * JD-Core Version:    0.7.0.1
 */