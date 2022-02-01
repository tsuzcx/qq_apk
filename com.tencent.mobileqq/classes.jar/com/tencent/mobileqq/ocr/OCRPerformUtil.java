package com.tencent.mobileqq.ocr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.dov.edit.api.IStartDovEditPic;
import com.tencent.mobileqq.gallery.picocr.PicOcrResultBean;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import com.tencent.mobileqq.gallery.picocr.PicOrcUtils;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.req.OCRReqContext;
import com.tencent.mobileqq.ocr.view.OcrImageTextView;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.share.api.IShareActivityStartup;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.BaseFileUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class OCRPerformUtil
{
  public static PicOcrRspResult a;
  public static OCRPerformUtil.OCRLanHolder a;
  public static TranslateResult a;
  public static OCRReqContext a;
  public static CharSequence a;
  static final HashMap<String, Integer> a;
  public static boolean a = false;
  public static OCRPerformUtil.OCRLanHolder b;
  public static CharSequence b;
  
  static
  {
    jdField_a_of_type_JavaLangCharSequence = "";
    jdField_b_of_type_JavaLangCharSequence = "";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("zh", Integer.valueOf(1));
    jdField_a_of_type_JavaUtilHashMap.put("en", Integer.valueOf(2));
    HashMap localHashMap = jdField_a_of_type_JavaUtilHashMap;
    Integer localInteger = Integer.valueOf(3);
    localHashMap.put("ja", localInteger);
    jdField_a_of_type_JavaUtilHashMap.put("jp", localInteger);
    localHashMap = jdField_a_of_type_JavaUtilHashMap;
    localInteger = Integer.valueOf(4);
    localHashMap.put("ko", localInteger);
    jdField_a_of_type_JavaUtilHashMap.put("kr", localInteger);
    jdField_a_of_type_JavaUtilHashMap.put("fr", Integer.valueOf(5));
    jdField_a_of_type_JavaUtilHashMap.put("es", Integer.valueOf(6));
    jdField_a_of_type_JavaUtilHashMap.put("it", Integer.valueOf(7));
    jdField_a_of_type_JavaUtilHashMap.put("de", Integer.valueOf(8));
    jdField_a_of_type_JavaUtilHashMap.put("tr", Integer.valueOf(9));
    jdField_a_of_type_JavaUtilHashMap.put("ru", Integer.valueOf(10));
    jdField_a_of_type_JavaUtilHashMap.put("pt", Integer.valueOf(11));
    jdField_a_of_type_JavaUtilHashMap.put("vi", Integer.valueOf(12));
    jdField_a_of_type_JavaUtilHashMap.put("id", Integer.valueOf(13));
    jdField_a_of_type_JavaUtilHashMap.put("ms", Integer.valueOf(14));
    jdField_a_of_type_JavaUtilHashMap.put("th", Integer.valueOf(15));
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = paramOptions.outHeight;
    paramInt2 = paramOptions.outWidth;
    if (paramInt2 > paramInt1 * 1.2F)
    {
      i /= 2;
      int j = paramInt2 / 2;
      paramInt2 = 2;
      for (;;)
      {
        i = paramInt2;
        if (j / paramInt2 <= paramInt1) {
          break;
        }
        paramInt2 *= 2;
      }
    }
    i = 1;
    if (QLog.isColorLevel())
    {
      paramOptions = new StringBuilder();
      paramOptions.append("calculateInSampleSize:");
      paramOptions.append(i);
      QLog.i("OCRPerformUtil", 2, paramOptions.toString());
    }
    return i;
  }
  
  public static int a(Point paramPoint1, Point paramPoint2)
  {
    int i = Math.abs(paramPoint2.x - paramPoint1.x);
    int j = Math.abs(paramPoint2.y - paramPoint1.y);
    return (int)Math.ceil(Math.sqrt(i * i + j * j));
  }
  
  public static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return ((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString.trim().toLowerCase())).intValue();
    }
    return 0;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OCRPerformUtil", 2, "drawable2Bitmap, drawable is null");
      }
      return null;
    }
    Object localObject;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable.getIntrinsicWidth() > 0) && (paramDrawable.getIntrinsicHeight() > 0)) {
      localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    } else {
      localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localObject;
  }
  
  public static Bitmap a(String paramString, DisplayMetrics paramDisplayMetrics)
  {
    int i = paramDisplayMetrics.widthPixels;
    int j = paramDisplayMetrics.heightPixels;
    paramDisplayMetrics = new BitmapFactory.Options();
    paramDisplayMetrics.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, paramDisplayMetrics);
    i = a(paramDisplayMetrics, i, j);
    paramDisplayMetrics.inJustDecodeBounds = false;
    paramDisplayMetrics.inSampleSize = i;
    Bitmap localBitmap = PicOrcUtils.a(paramString, paramDisplayMetrics, 1, 4);
    paramDisplayMetrics = localBitmap;
    if (localBitmap != null)
    {
      i = BaseImageUtil.c(paramString);
      paramDisplayMetrics = localBitmap;
      if (i != 0)
      {
        paramDisplayMetrics = localBitmap;
        if (i % 90 == 0)
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("decodeBitmapForOcr rotate:");
            paramString.append(i);
            QLog.d("OCRPerformUtil", 2, paramString.toString());
          }
          j = localBitmap.getWidth();
          int k = localBitmap.getHeight();
          paramString = new Matrix();
          paramString.postRotate(i, j / 2.0F, k / 2.0F);
          paramDisplayMetrics = Bitmap.createBitmap(localBitmap, 0, 0, j, k, paramString, true);
        }
      }
    }
    return paramDisplayMetrics;
  }
  
  public static URLDrawable.URLDrawableOptions a(URLImageView paramURLImageView, Drawable paramDrawable)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    if (paramURLImageView.getLayoutParams() != null)
    {
      localURLDrawableOptions.mRequestWidth = paramURLImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramURLImageView.getLayoutParams().height;
    }
    return localURLDrawableOptions;
  }
  
  public static OCRPerformUtil.OCRLanHolder a(OCRPerformUtil.OCRLanHolder paramOCRLanHolder, String paramString, List<String> paramList, HashMap<String, String> paramHashMap)
  {
    OCRPerformUtil.OCRLanHolder localOCRLanHolder = paramOCRLanHolder;
    if (paramOCRLanHolder == null) {
      localOCRLanHolder = new OCRPerformUtil.OCRLanHolder();
    }
    if (TextUtils.isEmpty(paramString)) {
      paramOCRLanHolder = "";
    } else {
      paramOCRLanHolder = paramString.toLowerCase();
    }
    localOCRLanHolder.jdField_a_of_type_JavaLangString = paramOCRLanHolder;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (localOCRLanHolder.jdField_a_of_type_JavaUtilList == null) {
        localOCRLanHolder.jdField_a_of_type_JavaUtilList = new ArrayList();
      } else {
        localOCRLanHolder.jdField_a_of_type_JavaUtilList.clear();
      }
      paramOCRLanHolder = paramList.iterator();
      while (paramOCRLanHolder.hasNext())
      {
        paramString = (String)paramOCRLanHolder.next();
        paramList = a(paramString);
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramList))) {
          localOCRLanHolder.jdField_a_of_type_JavaUtilList.add(paramString.toLowerCase());
        }
      }
    }
    localOCRLanHolder.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    localOCRLanHolder.jdField_b_of_type_JavaLangString = localOCRLanHolder.jdField_a_of_type_JavaLangString;
    localOCRLanHolder.jdField_c_of_type_JavaUtilList = a(localOCRLanHolder.jdField_b_of_type_JavaLangString);
    paramOCRLanHolder = localOCRLanHolder.jdField_c_of_type_JavaUtilList;
    int i = 0;
    localOCRLanHolder.jdField_c_of_type_JavaLangString = ((String)paramOCRLanHolder.get(0));
    localOCRLanHolder.jdField_b_of_type_JavaUtilList = a(localOCRLanHolder.jdField_c_of_type_JavaLangString);
    paramOCRLanHolder = "en/ja/ko/fr/es/it/de/tr/ru/pt/vi/id/ms/th".trim().split("/");
    int j = paramOCRLanHolder.length;
    while (i < j)
    {
      paramString = paramOCRLanHolder[i];
      if (!localOCRLanHolder.a(localOCRLanHolder.jdField_b_of_type_JavaUtilList, paramString)) {
        localOCRLanHolder.jdField_b_of_type_JavaUtilList.add(paramString);
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      paramOCRLanHolder = new StringBuilder();
      paramOCRLanHolder.append("recordOcrLanInfo:ocrLanHolder:");
      paramOCRLanHolder.append(localOCRLanHolder.a());
      QLog.d("OCRPerformUtil", 2, paramOCRLanHolder.toString());
    }
    return localOCRLanHolder;
  }
  
  public static CharSequence a(ArrayList<PicOcrResultBean> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int i = 1;
    while (paramArrayList.hasNext())
    {
      PicOcrResultBean localPicOcrResultBean = (PicOcrResultBean)paramArrayList.next();
      if (localPicOcrResultBean.b == i)
      {
        localStringBuilder.append(localPicOcrResultBean.jdField_a_of_type_JavaLangString.trim());
      }
      else
      {
        localStringBuilder.append("\n\n");
        localStringBuilder.append(localPicOcrResultBean.jdField_a_of_type_JavaLangString.trim());
        i = localPicOcrResultBean.b;
      }
    }
    return new QQText(localStringBuilder.toString(), 8, 16);
  }
  
  public static String a(TextView paramTextView)
  {
    if (paramTextView == null) {
      return null;
    }
    int i = paramTextView.getSelectionStart();
    int j = paramTextView.getSelectionEnd();
    paramTextView = paramTextView.getText().toString();
    if ((!TextUtils.isEmpty(paramTextView)) && (i < j) && (i >= 0))
    {
      if (j > paramTextView.length()) {
        return null;
      }
      paramTextView = paramTextView.substring(i, j);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("collectSelectedText ");
        localStringBuilder.append(paramTextView);
        QLog.d("OCRPerformUtil", 2, localStringBuilder.toString());
      }
      return paramTextView;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    return OcrConfig.getDefaultLanguageName(paramString);
  }
  
  public static List<String> a(String paramString)
  {
    return OcrConfig.getDefaultSupportLanguages(paramString);
  }
  
  public static void a()
  {
    if (jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext != null) {
      jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext = null;
    }
    if (jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder != null) {
      jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder = null;
    }
    if (jdField_b_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder != null) {
      jdField_b_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder = null;
    }
    if (jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult != null) {
      jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult = null;
    }
    if (jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null) {
      jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult = null;
    }
    if (jdField_a_of_type_JavaLangCharSequence != null) {
      jdField_a_of_type_JavaLangCharSequence = null;
    }
    if (jdField_b_of_type_JavaLangCharSequence != null) {
      jdField_b_of_type_JavaLangCharSequence = null;
    }
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("param_succ_flag", localStringBuilder.toString());
    localHashMap.put("param_err_msg", paramString2);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString1, true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("param_succ_flag", localStringBuilder.toString());
    localHashMap.put("param_md5", paramString1);
    localHashMap.put("param_text", paramString2);
    localHashMap.put("param_errMsg", paramString4);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString3, true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(Activity paramActivity, OcrImageTextView paramOcrImageTextView)
  {
    if (paramActivity != null)
    {
      if (paramOcrImageTextView == null) {
        return;
      }
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramOcrImageTextView.getWidth(), paramOcrImageTextView.getHeight(), Bitmap.Config.RGB_565);
        Object localObject = new Canvas(localBitmap);
        paramOcrImageTextView.layout(paramOcrImageTextView.getLeft(), paramOcrImageTextView.getTop(), paramOcrImageTextView.getRight(), paramOcrImageTextView.getBottom());
        Drawable localDrawable = paramOcrImageTextView.getBackground();
        if (localDrawable != null) {
          localDrawable.draw((Canvas)localObject);
        }
        paramOcrImageTextView.draw((Canvas)localObject);
        paramOcrImageTextView = MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramOcrImageTextView);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(SystemClock.uptimeMillis());
        ((StringBuilder)localObject).append(".jpg");
        paramOcrImageTextView = ((StringBuilder)localObject).toString();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("forwardDrawable:");
          ((StringBuilder)localObject).append(paramOcrImageTextView);
          QLog.d("OCRPerformUtil", 2, ((StringBuilder)localObject).toString());
        }
        BaseFileUtil.a(localBitmap, paramOcrImageTextView);
        localBitmap.recycle();
        ((IShareActivityStartup)QRoute.api(IShareActivityStartup.class)).gotoShareActivity(paramActivity, paramOcrImageTextView);
        return;
      }
      catch (IOException paramActivity)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("OCRPerformUtil", 2, "forwardContent error, content is empty");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    localBundle.putString("forward_text", paramString);
    paramString = new Intent();
    paramString.putExtra("isFromShare", true);
    paramString.putExtras(localBundle);
    ((IForwardOption)QRoute.api(IForwardOption.class)).startForwardActivityForResult(paramActivity, paramString, 21);
  }
  
  public static void a(String paramString, int paramInt)
  {
    a(paramString, paramString, paramInt);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", paramString1, paramString2, paramInt, 0, "", "0", "0", "");
  }
  
  public static void b(Activity paramActivity, String paramString)
  {
    ((IStartDovEditPic)QRoute.api(IStartDovEditPic.class)).enterCropActivity(paramActivity, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformUtil
 * JD-Core Version:    0.7.0.1
 */