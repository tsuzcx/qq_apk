import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.ad.soft_ad.ReadInJoyCommonSoftAdBar;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView.SimpleRoundProgress;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class odp
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
  
  public static int a(ViewBase paramViewBase, BaseData paramBaseData)
  {
    int j = 0;
    boolean bool = false;
    int i = j;
    if ((paramViewBase instanceof ogy))
    {
      i = j;
      if ((paramBaseData instanceof AdData))
      {
        i = ((ogy)paramViewBase).c();
        j = ((AdData)paramBaseData).k;
        if (i == 4) {
          bool = true;
        }
        i = a(j, bool);
      }
    }
    return i;
  }
  
  public static JSONObject a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = 1;
    if (paramAdvertisementInfo == null) {
      return new JSONObject();
    }
    if (paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) {}
    for (;;)
    {
      int j = a(paramContext, paramAdvertisementInfo);
      paramContext = new JSONObject();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("source_id", paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int);
        localJSONObject.put("platform_id", paramAdvertisementInfo.mAdvertisementSoftInfo.d);
        localJSONObject.put("goods_type", paramAdvertisementInfo.mAdvertisementSoftInfo.e);
        localJSONObject.put("goods_id", paramAdvertisementInfo.mAdvertisementSoftInfo.i);
        localJSONObject.put("goods_name", paramAdvertisementInfo.mAdvertisementSoftInfo.j);
        localJSONObject.put("account_id", paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_f_of_type_Int);
        localJSONObject.put("content_type", 1);
        localJSONObject.put("rowkey", paramAdvertisementInfo.mRowKey);
        localJSONObject.put("cmsid", paramAdvertisementInfo.mAdvertisementSoftInfo.w);
        if (paramInt3 != -1) {
          localJSONObject.put("button_state", paramInt3);
        }
        localJSONObject.put("adid", paramAdvertisementInfo.mAdvertisementSoftInfo.a);
        localJSONObject.put("position", paramInt5);
        localJSONObject.put("card_style", paramInt4);
        if (i != 0) {
          localJSONObject.put("is_ams_reported", 1);
        }
        if (paramInt1 == noy.jdField_a_of_type_Int)
        {
          if (paramInt2 != 0) {
            localJSONObject.put("click_pos", paramInt2);
          }
          localJSONObject.put("link_type", j);
          localJSONObject.put("click_type", 3);
          paramContext.put("click_info_report", localJSONObject.toString());
        }
        else
        {
          localJSONObject.put("exposure_type", 3);
          paramContext.put("exposure_info_report", localJSONObject.toString());
        }
      }
      catch (JSONException paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
      return paramContext;
      i = 0;
    }
  }
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo == null)) {}
    do
    {
      return;
      if (paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0)
      {
        szl.a(paramActivity, paramAdvertisementInfo, null, 3, true);
        return;
      }
    } while ((TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.h)) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.g)) && (szl.a(paramAdvertisementInfo.mAdvertisementSoftInfo.g, paramActivity)));
    odv.a(paramActivity, paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_f_of_type_JavaLangString, paramAdvertisementInfo.mAdvertisementSoftInfo.h, "");
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramString)) {
      for (;;)
      {
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = aepi.a(paramInt2, paramContext.getResources());
          localURLDrawableOptions.mRequestHeight = aepi.a(paramInt2, paramContext.getResources());
          if (paramInt3 != -1) {
            localURLDrawableOptions.mUseMemoryCache = false;
          }
          localURLDrawable = URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions);
          localURLDrawable.setTag(bcyz.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, aepi.a(paramInt1, paramContext.getResources())));
          if (paramInt3 != 0) {
            continue;
          }
          localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
          localURLDrawable.setDecodeHandler(bcyz.j);
        }
        catch (Exception paramContext)
        {
          URLDrawable localURLDrawable;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ReadInJoyCommonAdUtils", 2, "后台下发的url格式有问题：" + paramString);
          return;
          localURLDrawable.setDecodeHandler(bcyz.i);
          continue;
        }
        paramImageView.setImageDrawable(localURLDrawable);
        return;
        if (paramInt3 != 1) {
          continue;
        }
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(bcyz.j);
      }
    }
  }
  
  public static void a(Context paramContext, ReadInJoyCommonSoftAdBar paramReadInJoyCommonSoftAdBar, nor paramnor)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramReadInJoyCommonSoftAdBar.setElevation(9.0F);
    }
    paramReadInJoyCommonSoftAdBar.setSoftAdClickListener(new odq(paramnor, paramReadInJoyCommonSoftAdBar, paramContext));
  }
  
  public static void a(Context paramContext, AdData paramAdData, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AdvertisementInfo localAdvertisementInfo = oef.a(paramAdData);
    localAdvertisementInfo.setClickPos(paramInt2);
    int i = 0;
    if ((paramAdData instanceof ProteusInnerData)) {
      i = ((ProteusInnerData)paramAdData).jdField_a_of_type_Int;
    }
    noy.a(new obk().a(paramContext).a(paramInt1).b(noy.al).e(a(paramContext, localAdvertisementInfo, paramInt1, paramInt2, paramInt3, paramInt4, i)).a(localAdvertisementInfo).d(noy.a(paramAdData)).a());
  }
  
  public static void a(ReadInjoyHeaderAdDownloadView.SimpleRoundProgress paramSimpleRoundProgress)
  {
    if (paramSimpleRoundProgress != null)
    {
      paramSimpleRoundProgress.jdField_a_of_type_Int = Color.parseColor("#CCE5E5E5");
      paramSimpleRoundProgress.jdField_b_of_type_Int = Color.parseColor("#FF00CAFC");
      paramSimpleRoundProgress.jdField_a_of_type_Float = aepi.a(1.5F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.jdField_b_of_type_Float = aepi.a(1.5F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.jdField_c_of_type_Float = aepi.a(7.0F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.jdField_c_of_type_Int = 100;
      paramSimpleRoundProgress.e = 270;
      paramSimpleRoundProgress.d = 0;
      paramSimpleRoundProgress.jdField_f_of_type_Int = 1;
    }
  }
  
  private static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo.g == null)) {}
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
  
  private static void b(Context paramContext, ReadInJoyCommonSoftAdBar paramReadInJoyCommonSoftAdBar, nor paramnor, int paramInt)
  {
    b(paramContext, paramReadInJoyCommonSoftAdBar, paramnor, paramInt);
  }
  
  private static void b(Context paramContext, ReadInJoyCommonSoftAdBar paramReadInJoyCommonSoftAdBar, nor paramnor, int paramInt, boolean paramBoolean)
  {
    if ((paramnor != null) && (paramReadInJoyCommonSoftAdBar != null) && (paramReadInJoyCommonSoftAdBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData != null))
    {
      int i = a(paramnor.a(paramReadInJoyCommonSoftAdBar.jdField_a_of_type_Qyj), paramReadInJoyCommonSoftAdBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData);
      if (paramBoolean) {
        i = -1;
      }
      a(paramContext, paramReadInJoyCommonSoftAdBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData, noy.jdField_a_of_type_Int, paramInt, i, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     odp
 * JD-Core Version:    0.7.0.1
 */