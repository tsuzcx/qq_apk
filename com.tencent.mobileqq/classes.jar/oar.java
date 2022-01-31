import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoyAdUtils.1;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdGestureView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class oar
{
  private static HashSet<Integer> a = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(56), Integer.valueOf(40531), Integer.valueOf(14), Integer.valueOf(40174), Integer.valueOf(8), Integer.valueOf(1), Integer.valueOf(13), Integer.valueOf(15), Integer.valueOf(5), Integer.valueOf(11), Integer.valueOf(40466), Integer.valueOf(41541), Integer.valueOf(40013), Integer.valueOf(58), Integer.valueOf(16), Integer.valueOf(53), Integer.valueOf(52), Integer.valueOf(41629), Integer.valueOf(55), Integer.valueOf(40007), Integer.valueOf(59), Integer.valueOf(10), Integer.valueOf(9), Integer.valueOf(54), Integer.valueOf(41504) }));
  
  public static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    return ((Integer)oaq.a(paramAdvertisementInfo.mAdExtInfo, "game_button_type", Integer.valueOf(0))).intValue();
  }
  
  public static long a(qma paramqma, boolean paramBoolean)
  {
    if (!a(paramqma)) {}
    for (;;)
    {
      return -1L;
      if ((paramqma != null) && (paramqma.jdField_a_of_type_Qql != null) && (paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null))
      {
        paramqma = paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a;
        try
        {
          paramqma = new JSONObject(paramqma.v);
          if (paramqma != null)
          {
            paramqma = paramqma.optJSONObject("GesturesAd_info");
            if (paramqma != null)
            {
              if (paramBoolean) {
                return paramqma.optInt("showGesturesAd_beginTime");
              }
              int i = paramqma.optInt("showGesturesAd_endTime");
              return i;
            }
          }
        }
        catch (Exception paramqma)
        {
          paramqma.printStackTrace();
        }
      }
    }
    return -1L;
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = new URL(paramString).openConnection();
      i = ((HttpURLConnection)paramString).getContentLength();
      paramString.connect();
      localInputStream = paramString.getInputStream();
      localBufferedInputStream = new BufferedInputStream(localInputStream, i);
      localBitmap = BitmapFactory.decodeStream(localBufferedInputStream);
      paramString = localBitmap;
    }
    catch (Exception localException1)
    {
      int i;
      InputStream localInputStream;
      BufferedInputStream localBufferedInputStream;
      Bitmap localBitmap;
      int j;
      label102:
      Matrix localMatrix;
      paramString = null;
      label168:
      localException1.printStackTrace();
      return paramString;
    }
    try
    {
      i = localBitmap.getWidth();
      paramString = localBitmap;
      j = localBitmap.getHeight();
      if ((i <= 0) || (j <= 0)) {
        break label180;
      }
      paramString = localBitmap;
      f2 = paramInt1 / i;
      paramString = localBitmap;
      f1 = paramInt2 / j;
    }
    catch (Exception localException2)
    {
      break label168;
      f1 = 1.0F;
      f2 = 1.0F;
      break label102;
    }
    paramString = localBitmap;
    localMatrix = new Matrix();
    paramString = localBitmap;
    localMatrix.postScale(f2, f1);
    paramString = localBitmap;
    localBitmap = Bitmap.createBitmap(localBitmap, 0, 0, i, j, localMatrix, true);
    paramString = localBitmap;
    localBufferedInputStream.close();
    paramString = localBitmap;
    localInputStream.close();
    return localBitmap;
  }
  
  public static ShapeDrawable a(int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    float f9 = actj.a(1.0F, paramContext.getResources());
    float f1 = 6;
    float f2 = 6;
    float f3 = 6;
    float f4 = 6;
    float f5 = 6;
    float f6 = 6;
    float f7 = 6;
    float f8 = 6;
    paramContext = new RectF(f9, f9, f9, f9);
    f9 = 5;
    float f10 = 5;
    float f11 = 5;
    float f12 = 5;
    float f13 = 5;
    float f14 = 5;
    float f15 = 5;
    float f16 = 5;
    paramContext = new ShapeDrawable(new RoundRectShape(new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, paramContext, new float[] { f9, f10, f11, f12, f13, f14, f15, f16 }));
    LinearGradient localLinearGradient = new LinearGradient(50.0F, 50.0F, 50.0F, 50.0F, paramInt, paramInt, Shader.TileMode.REPEAT);
    paramContext.getPaint().setShader(localLinearGradient);
    return paramContext;
  }
  
  @NonNull
  public static String a(Activity paramActivity, VideoInfo paramVideoInfo, int paramInt)
  {
    String str3 = "详情";
    String str4 = "查看详情";
    String str1 = str4;
    String str2 = str3;
    if (a(paramVideoInfo))
    {
      str1 = str4;
      str2 = str3;
      if (paramVideoInfo.a.c == 12)
      {
        str1 = str4;
        str2 = str3;
        try
        {
          if (bbfr.a(paramActivity, new JSONObject(paramVideoInfo.a.r).optString("pkg_name")))
          {
            paramActivity = "打开";
            if (paramInt == 1) {
              return paramActivity;
            }
            return "立即打开";
          }
        }
        catch (JSONException paramActivity)
        {
          str2 = "下载";
          str1 = "立即下载";
        }
      }
    }
    switch (paramVideoInfo.a.q)
    {
    default: 
      paramActivity = str2;
    }
    for (;;)
    {
      if (paramInt != 1) {
        break label177;
      }
      if (TextUtils.isEmpty(paramVideoInfo.a.I)) {
        break;
      }
      return paramVideoInfo.a.I;
      paramActivity = "购买";
      str1 = "立即购买";
      continue;
      paramActivity = "详情";
      str1 = "查看详情";
    }
    label177:
    if (TextUtils.isEmpty(paramVideoInfo.a.J)) {
      return str1;
    }
    return paramVideoInfo.a.J;
  }
  
  @NonNull
  public static String a(Activity paramActivity, VideoInfo paramVideoInfo, Resources paramResources)
  {
    if (paramResources == null) {
      paramActivity = "";
    }
    Object localObject1;
    label208:
    do
    {
      do
      {
        for (;;)
        {
          return paramActivity;
          localObject1 = "";
          Object localObject2 = localObject1;
          if (paramVideoInfo != null)
          {
            localObject2 = localObject1;
            if (paramVideoInfo.a != null)
            {
              localObject2 = localObject1;
              if (!TextUtils.isEmpty(paramVideoInfo.a.l)) {
                localObject2 = paramVideoInfo.a.l;
              }
            }
          }
          localObject1 = localObject2;
          if (paramVideoInfo != null)
          {
            localObject1 = localObject2;
            if (paramVideoInfo.a != null)
            {
              localObject1 = localObject2;
              if (a(paramVideoInfo.a)) {
                localObject1 = paramResources.getText(2131718467).toString();
              }
            }
          }
          if ((paramVideoInfo == null) || (paramVideoInfo.a == null) || (paramVideoInfo.a.c != 12)) {
            break label208;
          }
          try
          {
            if (bbfr.a(paramActivity, new JSONObject(paramVideoInfo.a.r).optString("pkg_name"))) {
              return paramResources.getText(2131718464).toString();
            }
            paramActivity = (Activity)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              paramActivity = paramResources.getText(2131718462).toString();
              return paramActivity;
            }
          }
          catch (JSONException paramActivity)
          {
            paramActivity = (Activity)localObject1;
          }
        }
      } while (!TextUtils.isEmpty((CharSequence)localObject1));
      return paramResources.getText(2131718462).toString();
      paramActivity = (Activity)localObject1;
    } while (!TextUtils.isEmpty((CharSequence)localObject1));
    return paramResources.getText(2131718505).toString();
  }
  
  public static String a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null)
    {
      paramAdvertisementInfo = null;
      return paramAdvertisementInfo;
    }
    Object localObject1 = ajya.a(2131712853);
    for (;;)
    {
      try
      {
        if (oau.a(paramAdvertisementInfo))
        {
          str = ajya.a(2131712886);
          localObject1 = str;
        }
      }
      catch (JSONException paramAdvertisementInfo)
      {
        try
        {
          String str;
          if (a(paramAdvertisementInfo)) {
            return BaseApplicationImpl.getContext().getResources().getString(2131718466);
          }
          if (e(paramAdvertisementInfo)) {
            return BaseApplicationImpl.getContext().getResources().getString(2131718467);
          }
          int i = a(paramAdvertisementInfo);
          if ((AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (i == 2))
          {
            Object localObject2 = new JSONObject(paramAdvertisementInfo.mAdExt);
            str = ((JSONObject)localObject2).optString("pkg_name");
            localObject2 = ((JSONObject)localObject2).optString("appname");
            if (i == 2) {
              str = b(paramAdvertisementInfo);
            }
            if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdCustomizedInvokeUrl))
            {
              if (bbfr.a(BaseApplicationImpl.getContext(), str)) {
                return a((String)localObject2);
              }
              if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdBtnTxt)) {
                return paramAdvertisementInfo.mAdBtnTxt;
              }
            }
            if (bbfr.a(BaseApplicationImpl.getContext(), str)) {
              return a((String)localObject2);
            }
            if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdBtnTxt)) {
              return paramAdvertisementInfo.mAdBtnTxt;
            }
          }
          if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdBtnTxt)) {
            return paramAdvertisementInfo.mAdBtnTxt;
          }
          if (i == 1) {
            return BaseApplicationImpl.getContext().getResources().getString(2131718467);
          }
          if (!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
          {
            paramAdvertisementInfo = (AdvertisementInfo)localObject1;
            if (i != 2) {
              break;
            }
          }
          paramAdvertisementInfo = BaseApplicationImpl.getContext().getResources().getString(2131718462);
          return paramAdvertisementInfo;
        }
        catch (JSONException paramAdvertisementInfo)
        {
          continue;
        }
        paramAdvertisementInfo = paramAdvertisementInfo;
        paramAdvertisementInfo.printStackTrace();
        return localObject1;
      }
    }
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null)
    {
      localObject1 = null;
      return localObject1;
    }
    Object localObject1 = paramBaseArticleInfo.getSubscribeName();
    Object localObject2;
    if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
    {
      localObject2 = (AdvertisementInfo)paramBaseArticleInfo;
      if (!AdvertisementInfo.isAppAdvertisementInfo(paramBaseArticleInfo)) {}
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(((AdvertisementInfo)localObject2).mAdExt).getString("appname");
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        int j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyAdUtils", 2, "cannot get name from app advertisement");
        continue;
      }
      j = paramBaseArticleInfo.mSubscribeName.length();
      if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
      {
        i = 9;
        if (j > i)
        {
          localObject1 = new StringBuilder();
          localObject2 = paramBaseArticleInfo.mSubscribeName;
          if (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
            break label160;
          }
          i = 8;
          return ((String)localObject2).substring(0, i) + "…";
          localObject1 = localJSONException.mAdCorporateImageName;
        }
      }
      else
      {
        i = 18;
        continue;
      }
      break;
      label160:
      int i = 17;
    }
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.length();
    if ((i > 0) && (i <= 2)) {
      return ajya.a(2131712720) + paramString;
    }
    return BaseApplicationImpl.getContext().getResources().getString(2131718464);
  }
  
  public static JSONObject a(int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("click_type", paramInt1);
      localJSONObject1.put("gesture_type", paramInt2);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("click_info_report", localJSONObject1.toString());
      return localJSONObject2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static JSONObject a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject)
  {
    if ((paramAdvertisementInfo == null) || (paramJSONObject == null) || (!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdExt))) {
      return paramJSONObject;
    }
    for (;;)
    {
      try
      {
        if (!nmc.a(paramContext, new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name"))) {
          break label102;
        }
        i = 2;
        paramJSONObject.put("action_type", i);
        return paramJSONObject;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ReadInJoyAdUtils", 2, "doGdtWebClickReport fail message:" + paramContext.getMessage());
      return paramJSONObject;
      label102:
      int i = 1;
    }
  }
  
  public static void a()
  {
    Object localObject = obb.a(2);
    if ((localObject != null) && ((localObject instanceof nyg))) {
      try
      {
        localObject = (nyg)localObject;
        int i;
        JSONObject localJSONObject1;
        JSONObject localJSONObject2;
        if (((nyg)localObject).a())
        {
          i = nmc.L;
          if (((nyg)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mOrigin > 0) {
            i = ((nyg)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mOrigin;
          }
          localJSONObject1 = new JSONObject();
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("stat_type", nmc.aP);
          localJSONObject2.put("webview_click", ((nyg)localObject).jdField_a_of_type_Long);
          localJSONObject2.put("webview_start", ((nyg)localObject).b);
          localJSONObject2.put("webview_head", ((nyg)localObject).c);
          localJSONObject2.put("webview_body", ((nyg)localObject).d);
          localJSONObject2.put("webview_close", System.currentTimeMillis());
          if (!((nyg)localObject).jdField_a_of_type_Boolean) {
            break label203;
          }
          localJSONObject2.put("wvalive", 1);
        }
        for (;;)
        {
          localJSONObject1.put("statistics_data_report", localJSONObject2.toString());
          nmc.a(new nyd().a(nmc.A).b(i).a(((nyg)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(localJSONObject1).a());
          obb.a(2);
          return;
          label203:
          localJSONObject2.put("wvalive", 0);
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyAdUtils", 2, "doGdtWebClickReport fail message:" + localException.getMessage());
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    paramActivity.setDrawingCacheEnabled(true);
    paramActivity.buildDrawingCache();
    Bitmap localBitmap = Bitmap.createBitmap(paramActivity.getDrawingCache());
    paramActivity.setDrawingCacheEnabled(false);
    if (localBitmap == null) {
      return;
    }
    obb.a(paramInt, localBitmap);
  }
  
  public static void a(VideoAdInfo paramVideoAdInfo)
  {
    a(oav.a(paramVideoAdInfo));
  }
  
  public static void a(VideoInfo paramVideoInfo, qma paramqma)
  {
    if ((paramVideoInfo == null) || (!paramVideoInfo.c) || (paramqma == null) || (paramVideoInfo.a == null) || (TextUtils.isEmpty(paramVideoInfo.a.v))) {
      return;
    }
    for (;;)
    {
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.a.v);
        if (!paramVideoInfo.has("AdsIconText")) {
          break;
        }
        if (!TextUtils.isEmpty(paramVideoInfo.optString("AdsIconText")))
        {
          if (paramqma.a() != null) {
            paramqma.a().setText(paramVideoInfo.optString("AdsIconText"));
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ReadInJoyAdUtils", 2, "detail ad  video adInconText:" + paramVideoInfo.optString("AdsIconText"));
          return;
        }
      }
      catch (Exception paramVideoInfo)
      {
        paramVideoInfo.printStackTrace();
        return;
      }
      if (paramqma.jdField_a_of_type_Int == 4)
      {
        if (paramqma.a() != null) {
          paramqma.a().setVisibility(8);
        }
      }
      else if (paramqma.a() != null) {
        paramqma.a().setVisibility(8);
      }
    }
  }
  
  public static void a(ReadInJoyAdGestureView paramReadInJoyAdGestureView, LinearLayout paramLinearLayout)
  {
    if ((paramReadInJoyAdGestureView == null) || (paramLinearLayout == null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramReadInJoyAdGestureView.getLayoutParams();
    if (paramLinearLayout.getHeight() != 0) {
      localLayoutParams.bottomMargin = paramLinearLayout.getHeight();
    }
    paramReadInJoyAdGestureView.setLayoutParams(localLayoutParams);
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      try
      {
        paramAdvertisementInfo = new GdtAd(shq.a(paramAdvertisementInfo));
        ysu.a().a(paramAdvertisementInfo);
        return;
      }
      catch (Exception paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("ReadInJoyAdUtils", 2, "preLoadAdForMiniProgram fail");
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, int paramInt, VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    qql localqql = null;
    if (paramVideoFeedsPlayManager != null) {
      localqql = paramVideoFeedsPlayManager.a();
    }
    if (paramAdvertisementInfo != null)
    {
      paramAdvertisementInfo.setClickPos(paramInt);
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdVideoUrl)) {
        a(localqql, true);
      }
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject = b(paramBaseArticleInfo.mSubscribeName);
    paramBaseArticleInfo = (BaseArticleInfo)localObject;
    if (((String)localObject).length() > 13) {
      paramBaseArticleInfo = ((String)localObject).substring(0, 12) + "…";
    }
    localObject = new JSONObject();
    ((JSONObject)localObject).put("info_source_text", paramBaseArticleInfo);
    paramJSONObject.put("id_info_source", localObject);
  }
  
  public static void a(AdData paramAdData)
  {
    a(oas.a(paramAdData));
  }
  
  public static void a(JSONObject paramJSONObject, nye paramnye)
  {
    if (paramnye == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject;
          if (!TextUtils.isEmpty(paramnye.b))
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("iconUrl", paramnye.b);
            paramJSONObject.put("id_pk_icon", localObject);
          }
          if ((paramnye.a != null) && (paramnye.b.length() >= 2))
          {
            localObject = (nya)paramnye.a.get(0);
            JSONObject localJSONObject;
            if (!TextUtils.isEmpty(((nya)localObject).d))
            {
              localJSONObject = new JSONObject();
              localJSONObject.put("iconUrl", ((nya)localObject).d);
              paramJSONObject.put("id_pk_image_bg_left", localJSONObject);
            }
            if (!TextUtils.isEmpty(((nya)localObject).c))
            {
              localJSONObject = new JSONObject();
              localJSONObject.put("text", ((nya)localObject).c);
              paramJSONObject.put("id_pk_label_left", localJSONObject);
            }
            paramnye = (nya)paramnye.a.get(1);
            if (!TextUtils.isEmpty(paramnye.d))
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("iconUrl", paramnye.d);
              paramJSONObject.put("id_pk_image_bg_right", localObject);
            }
            if (!TextUtils.isEmpty(paramnye.c))
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("text", paramnye.c);
              paramJSONObject.put("id_pk_label_right", localObject);
              return;
            }
          }
        }
        catch (Exception paramJSONObject) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdUtils", 2, "bindPkButton error message:" + paramJSONObject.getMessage());
  }
  
  public static void a(qjf paramqjf, qlp paramqlp, qmp paramqmp)
  {
    if ((paramqjf == null) || (paramqlp == null) || (paramqmp == null)) {}
    while ((!(paramqmp instanceof qma)) || (!a((qma)paramqmp)) || (((qma)paramqmp).a() == null) || (!((qma)paramqmp).a().a())) {
      return;
    }
    paramqjf.e();
    paramqlp.a(paramqmp);
  }
  
  public static void a(qql paramqql)
  {
    if ((paramqql != null) && (paramqql.jdField_a_of_type_Qbt != null)) {
      paramqql.jdField_a_of_type_Qbt.e = false;
    }
  }
  
  public static void a(qql paramqql, boolean paramBoolean)
  {
    if ((paramqql != null) && (paramqql.jdField_a_of_type_Qbt != null)) {
      paramqql.jdField_a_of_type_Qbt.e = paramBoolean;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (a.contains(Integer.valueOf(paramInt))) || (oou.b(paramInt));
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      paramString = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    } while (paramString == null);
    try
    {
      paramString.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
      paramContext.startActivity(paramString);
      return true;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static boolean a(VideoAdInfo paramVideoAdInfo)
  {
    return e(nmc.a(paramVideoAdInfo));
  }
  
  public static boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.a != null) && (!TextUtils.isEmpty(paramVideoInfo.a.F));
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    int i = a(paramAdvertisementInfo);
    paramAdvertisementInfo = b(paramAdvertisementInfo);
    return (i == 3) || ((i == 1) && (oba.a(null, paramAdvertisementInfo)));
  }
  
  public static boolean a(qma paramqma)
  {
    if ((paramqma != null) && (paramqma.jdField_a_of_type_Qql != null) && (paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null))
    {
      paramqma = paramqma.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a;
      try
      {
        paramqma = new JSONObject(paramqma.v);
        if (paramqma == null) {
          return false;
        }
        paramqma = paramqma.optJSONObject("GesturesAd_info");
        if (paramqma != null)
        {
          int i = paramqma.optInt("showGesturesAdType");
          if (i > 0) {
            return true;
          }
        }
      }
      catch (Exception paramqma)
      {
        paramqma.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean a(qnu paramqnu)
  {
    String str = bhvy.a("sp_key_ad_soft_total_area");
    if ((TextUtils.isEmpty(str)) || ("0".equals(str))) {}
    int i;
    int j;
    do
    {
      return true;
      i = nmh.a(bhvy.a("sp_key_ad_soft_ad_max"), 25);
      j = paramqnu.b();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdUtils", 2, "isOverAdFrequency: dayDisplayCount=" + j + ",adShowMaxCount=" + i);
      }
    } while (j > i);
    return false;
  }
  
  public static boolean a(qql paramqql)
  {
    if ((paramqql != null) && (paramqql.jdField_a_of_type_Qbt != null)) {
      return paramqql.jdField_a_of_type_Qbt.e;
    }
    return false;
  }
  
  public static int b(AdvertisementInfo paramAdvertisementInfo)
  {
    if (h(paramAdvertisementInfo)) {
      return 116;
    }
    return 39;
  }
  
  public static String b(AdvertisementInfo paramAdvertisementInfo)
  {
    return (String)oaq.a(paramAdvertisementInfo.mAdExtInfo, "game_pkg_name", "");
  }
  
  private static String b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static void b(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null) {}
    try
    {
      nyg localnyg = new nyg();
      localnyg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
      localnyg.jdField_a_of_type_JavaLangString = String.valueOf(paramAdvertisementInfo.mAdAid);
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))
      {
        paramAdvertisementInfo = Uri.parse(paramAdvertisementInfo.mAdLandingPage).getQueryParameter("adtag");
        if (!TextUtils.isEmpty(paramAdvertisementInfo))
        {
          int i = paramAdvertisementInfo.lastIndexOf(".");
          if ((i > 0) && (i < paramAdvertisementInfo.length() - 1)) {
            localnyg.jdField_a_of_type_JavaLangString = paramAdvertisementInfo.substring(i + 1);
          }
        }
      }
      localnyg.jdField_a_of_type_Long = System.currentTimeMillis();
      obb.a(2, localnyg);
      ThreadManager.getSubThreadHandler().post(new ReadInJoyAdUtils.1());
      return;
    }
    catch (Exception paramAdvertisementInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoyAdUtils", 2, "addGdtWebClickReport fail message:" + paramAdvertisementInfo.getMessage());
    }
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    do
    {
      do
      {
        do
        {
          return;
          localJSONObject = new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo);
          paramJSONObject.put("id_info_operate_parent", new JSONObject());
          paramJSONObject.put("id_large_cell_container", new JSONObject());
          if (!localJSONObject.has("AdsIconText")) {
            break;
          }
          paramBaseArticleInfo = new JSONObject();
          if (!TextUtils.isEmpty(localJSONObject.optString("AdsIconText")))
          {
            paramBaseArticleInfo.put("info_status_text", localJSONObject.optString("AdsIconText"));
            paramJSONObject.put("id_info_status", paramBaseArticleInfo);
          }
        } while (!QLog.isColorLevel());
        QLog.d("ReadInJoyAdUtils", 2, "bindAdStatus AdsIconText:" + localJSONObject.optString("AdsIconText"));
        return;
      } while (TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptText));
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("info_status_text", paramBaseArticleInfo.mArticleSubscriptText);
      paramJSONObject.put("id_info_status", localJSONObject);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdUtils", 2, "bindAdStatus mArticleSubscriptText:" + paramBaseArticleInfo.mArticleSubscriptText);
  }
  
  public static boolean b(VideoAdInfo paramVideoAdInfo)
  {
    if (!TextUtils.isEmpty(paramVideoAdInfo.D)) {}
    for (;;)
    {
      return true;
      Object localObject = paramVideoAdInfo.v;
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("video_rowkey")) {
          paramVideoAdInfo.D = ((JSONObject)localObject).optString("video_rowkey", "");
        }
        boolean bool = TextUtils.isEmpty(paramVideoAdInfo.D);
        if (bool) {
          return false;
        }
      }
      catch (JSONException paramVideoAdInfo)
      {
        paramVideoAdInfo.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    return a(paramAdvertisementInfo) == 1;
  }
  
  public static String c(AdvertisementInfo paramAdvertisementInfo)
  {
    String str = ajya.a(2131712830);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
      paramAdvertisementInfo = str;
      if (localJSONObject.has("AdsIconText")) {
        paramAdvertisementInfo = localJSONObject.optString("AdsIconText");
      }
      return paramAdvertisementInfo;
    }
    catch (JSONException paramAdvertisementInfo)
    {
      paramAdvertisementInfo.printStackTrace();
    }
    return str;
  }
  
  public static boolean c(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    int i = a(paramAdvertisementInfo);
    boolean bool1;
    if (!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      bool1 = bool2;
      if (i != 2) {
        break label69;
      }
    }
    try
    {
      String str = new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name");
      if (i == 2) {
        str = b(paramAdvertisementInfo);
      }
      boolean bool3 = bbfr.a(BaseApplicationImpl.getContext(), str);
      bool1 = bool2;
      if (!bool3) {
        bool1 = true;
      }
      label69:
      return bool1;
    }
    catch (Exception paramAdvertisementInfo) {}
    return false;
  }
  
  public static boolean d(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) {}
    try
    {
      paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExt).optString("pkg_name");
      boolean bool3 = bbfr.a(BaseApplicationImpl.getContext(), paramAdvertisementInfo);
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramAdvertisementInfo) {}
    return false;
  }
  
  public static boolean e(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    while ((TextUtils.isEmpty(paramAdvertisementInfo.mPopFormH5Url)) || (!oaq.d(paramAdvertisementInfo))) {
      return false;
    }
    return true;
  }
  
  public static boolean f(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo.mInteractType == 2) && (!TextUtils.isEmpty(paramAdvertisementInfo.mInteractImageList));
  }
  
  public static boolean g(AdvertisementInfo paramAdvertisementInfo)
  {
    return paramAdvertisementInfo.downloadState != 3;
  }
  
  public static boolean h(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (5001 == paramAdvertisementInfo.mAdvertisementExtInfo.g);
  }
  
  public static boolean i(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (1003 == paramAdvertisementInfo.mAdvertisementExtInfo.g);
  }
  
  public static boolean j(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (5002 == paramAdvertisementInfo.mAdvertisementExtInfo.g);
  }
  
  public static boolean k(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (1022 == paramAdvertisementInfo.mAdvertisementExtInfo.g);
  }
  
  public static boolean l(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (1009 == paramAdvertisementInfo.mAdvertisementExtInfo.g);
  }
  
  public static boolean m(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && ((1014 == paramAdvertisementInfo.mAdvertisementExtInfo.g) || (1015 == paramAdvertisementInfo.mAdvertisementExtInfo.g));
  }
  
  public static boolean n(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null) {
      try
      {
        paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
        if (paramAdvertisementInfo == null) {
          return false;
        }
        paramAdvertisementInfo = paramAdvertisementInfo.optJSONObject("GesturesAd_info");
        if (paramAdvertisementInfo != null)
        {
          int i = paramAdvertisementInfo.optInt("showGesturesAdType");
          if (i > 0) {
            return true;
          }
        }
      }
      catch (Exception paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oar
 * JD-Core Version:    0.7.0.1
 */