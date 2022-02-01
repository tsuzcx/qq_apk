package com.tencent.mobileqq.cmshow.engine.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Typeface;
import android.support.v4.util.MQLruCache;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.portal.StrokeTextView;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

public class FontUtils
{
  public static int a = -1;
  private static Map a;
  
  public static Bitmap a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, int paramInt5)
  {
    String str = paramString3;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[drawTextOnBitmap], l:");
      ((StringBuilder)localObject1).append(paramFloat1);
      ((StringBuilder)localObject1).append(",t:");
      ((StringBuilder)localObject1).append(paramFloat2);
      ((StringBuilder)localObject1).append("w:");
      ((StringBuilder)localObject1).append(paramFloat3);
      ((StringBuilder)localObject1).append(",h:");
      ((StringBuilder)localObject1).append(paramFloat4);
      ((StringBuilder)localObject1).append(",bWidth:");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(",bHeight:");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(",text:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(",slotName:");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(",rotate:");
      ((StringBuilder)localObject1).append(paramInt3);
      ((StringBuilder)localObject1).append(",flip:");
      ((StringBuilder)localObject1).append(paramInt4);
      ((StringBuilder)localObject1).append(",roleName:");
      ((StringBuilder)localObject1).append(str);
      QLog.d("[cmshow]FontUtils", 2, new Object[] { ((StringBuilder)localObject1).toString(), ", bubbleId=", Integer.valueOf(paramInt5) });
    }
    if ((!TextUtils.isEmpty(paramString2)) && (("Bubble_Word".equals(paramString2)) || ("Bubble_Name_Word".equals(paramString2))))
    {
      localObject1 = a(paramInt1, paramInt2);
      localTextView = new TextView(BaseApplicationImpl.getContext());
      Object localObject2 = new Paint.FontMetricsInt();
      localTextView.getPaint().getFontMetricsInt((Paint.FontMetricsInt)localObject2);
      paramInt1 = ((Paint.FontMetricsInt)localObject2).ascent - ((Paint.FontMetricsInt)localObject2).top;
      paramInt2 = paramInt1;
      if (paramInt1 == 0) {
        paramInt2 = (int)(DeviceInfoUtil.a * 2.0F);
      }
      paramInt1 = ApolloActionManager.a().a.get();
      paramInt3 = jdField_a_of_type_Int;
      if (paramInt3 != -1) {
        paramInt1 = paramInt3;
      }
      localObject2 = a(paramString1, paramInt1);
      boolean bool;
      if (TextUtils.isEmpty(paramString3)) {
        bool = false;
      } else {
        bool = str.contains("pet");
      }
      if ((!bool) && ((paramInt1 == 0) || ((1 == paramInt1) && ("Bubble_Word".equals(paramString2))) || (8 == paramInt1)))
      {
        localTextView.setGravity(17);
        localTextView.setTextColor(-16777216);
        localTextView.setTextSize(51.0F / DeviceInfoUtil.a);
        paramInt1 = 3;
      }
      else if (((1 == paramInt1) || (bool)) && ("Bubble_Name_Word".equals(paramString2)))
      {
        paramString2 = BaseApplicationImpl.getApplication().getRuntime();
        ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramString2.getRuntimeService(IApolloManagerService.class, "all");
        paramString1 = str;
        if (!TextUtils.isEmpty(paramString3))
        {
          paramString1 = str;
          if (str.endsWith("#")) {
            paramString1 = str.substring(0, paramString3.length() - 1);
          }
        }
        float f;
        if (bool)
        {
          paramInt1 = -6578766;
          f = paramFloat3;
        }
        for (;;)
        {
          paramFloat3 = f;
          break label634;
          if ((localApolloManagerServiceImpl == null) || (TextUtils.isEmpty(paramString1)) || (!localApolloManagerServiceImpl.isSuperYellow(paramString1))) {
            break;
          }
          paramInt3 = -9889778;
          f = paramFloat3;
          paramInt1 = paramInt3;
          if (paramString2 != null)
          {
            f = paramFloat3;
            paramInt1 = paramInt3;
            if (paramString1.equals(paramString2.getCurrentAccountUin()))
            {
              f = paramFloat3 + (int)(DeviceInfoUtil.a * 2.0F);
              paramInt1 = paramInt3;
            }
          }
        }
        paramInt1 = -1;
        label634:
        localTextView.setGravity(17);
        localTextView.setTextColor(paramInt1);
        localTextView.setTextSize(42.0F / DeviceInfoUtil.a);
        paramInt1 = 1;
      }
      else
      {
        if (2 == paramInt1)
        {
          localTextView.setGravity(17);
          localTextView.setTextColor(-16777216);
          localTextView.setTextSize(30.0F / DeviceInfoUtil.a);
        }
        else if (3 == paramInt1)
        {
          localTextView.setGravity(19);
          localTextView.setTextColor(-16777216);
          localTextView.setTextSize(21.0F / DeviceInfoUtil.a);
        }
        for (;;)
        {
          paramInt1 = 2;
          break label848;
          if ((4 == paramInt1) || (5 == paramInt1)) {
            break;
          }
          if ((6 != paramInt1) && (7 != paramInt1) && (9 != paramInt1))
          {
            paramInt1 = 3;
            break label848;
          }
          localTextView.setGravity(17);
          localTextView.setTextColor(-16777216);
          localTextView.setTextSize(27.0F / DeviceInfoUtil.a);
          localTextView.setPadding(0, paramInt2, 0, 0);
        }
        localTextView.setGravity(17);
        localTextView.setTextColor(-7645212);
        localTextView.setTextSize(24.0F / DeviceInfoUtil.a);
        paramInt1 = 6;
      }
      label848:
      localTextView.setWidth((int)paramFloat3);
      localTextView.setHeight((int)paramFloat4 + paramInt2);
      localTextView.setText(ApolloUtilImpl.autoSplitText(localTextView.getPaint(), paramFloat3, (String)localObject2, paramInt1));
      localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramInt3 = localTextView.getMeasuredWidth();
      localTextView.layout(0, 0, paramInt3, localTextView.getMeasuredHeight());
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("lineHeight");
        paramString1.append(localTextView.getLineHeight());
        QLog.d("[cmshow]FontUtils", 2, paramString1.toString());
      }
      if (localTextView.getLineCount() == 0) {
        localTextView.setLineSpacing(59.0F - localTextView.getLineHeight(), 0.9F);
      } else {
        localTextView.setLineSpacing((paramInt2 + paramFloat4) / localTextView.getLineCount() - localTextView.getLineHeight(), 0.9F);
      }
    }
    try
    {
      paramString1 = new Canvas((Bitmap)localObject1);
    }
    catch (OutOfMemoryError paramString1)
    {
      QLog.d("[cmshow]FontUtils", 1, paramString1.getMessage());
      paramString1 = null;
      paramInt1 = 1;
      paramString2 = new Matrix();
      if (1 != paramInt4) {
        break label1141;
      }
      paramString2.setValues(new float[] { -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
      paramString2.postTranslate(paramFloat3, 0.0F);
      paramInt1 = -1;
      paramString2.postTranslate(paramFloat1 + paramInt1 * (paramFloat3 - paramInt3) / 2.0F, paramFloat2 - paramInt2);
      paramString1.setMatrix(paramString2);
      localTextView.draw(paramString1);
      return localObject1;
      if (!QLog.isColorLevel()) {
        break label1197;
      }
      QLog.d("[cmshow]FontUtils", 2, "errInfo->wrong slotName.");
      return null;
    }
    catch (Exception paramString1)
    {
      label1035:
      break label1035;
    }
    QLog.d("[cmshow]FontUtils", 1, "errInfo->canvas failure.");
    return null;
  }
  
  @Nullable
  private static Bitmap a(int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("group_brand_");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramInt2);
    String str = ((StringBuilder)localObject1).toString();
    Object localObject2;
    if (GlobalImageCache.a != null)
    {
      localObject2 = (Bitmap)GlobalImageCache.a.get(str);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("group brand ----> get bitmap from cache key: ");
          ((StringBuilder)localObject1).append(str);
          QLog.d("[cmshow]FontUtils", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 == null) {}
    try
    {
      localObject2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject1 = localObject2;
      if (GlobalImageCache.a != null)
      {
        GlobalImageCache.a.put(str, localObject2);
        return localObject2;
        ((Bitmap)localObject1).eraseColor(0);
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("errInfo->");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("[cmshow]FontUtils", 1, ((StringBuilder)localObject2).toString());
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("errInfo->");
      ((StringBuilder)localObject2).append(localOutOfMemoryError.getMessage());
      QLog.e("[cmshow]FontUtils", 1, ((StringBuilder)localObject2).toString());
    }
    return null;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    try
    {
      paramString1 = new TextView(BaseApplicationImpl.getContext());
      Paint.FontMetricsInt localFontMetricsInt = new Paint.FontMetricsInt();
      paramString1.getPaint().getFontMetricsInt(localFontMetricsInt);
      paramString1.setWidth(paramInt3);
      paramString1.setHeight(paramInt4);
      a(paramInt5, paramString1);
      paramString1.setTextColor(paramInt2);
      paramString1.setTextSize(paramInt1);
      paramString1.setText(paramString2);
      paramString1.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramInt1 = paramString1.getMeasuredWidth();
      paramInt2 = paramString1.getMeasuredHeight();
      paramString1.layout(0, 0, paramInt1, paramInt2);
      paramString2 = a(paramInt1, paramInt2);
      paramString1.draw(new Canvas(paramString2));
      return paramString2;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("getTextBitMapException e=");
      paramString2.append(paramString1.toString());
      QLog.e("[cmshow]FontUtils", 1, paramString2.toString());
      return null;
    }
    catch (OutOfMemoryError paramString1)
    {
      QLog.e("[cmshow]FontUtils", 1, paramString1.getMessage());
    }
    return null;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, int paramInt6)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    int k = 3;
    int j = -16777216;
    int i = 17;
    if (2 == paramInt6)
    {
      paramInt1 = (int)(30.0F / DeviceInfoUtil.a);
      paramInt2 = k;
      paramInt5 = j;
      paramInt6 = i;
    }
    else if (3 == paramInt6)
    {
      paramInt1 = (int)(21.0F / DeviceInfoUtil.a);
      paramInt2 = 2;
      paramInt6 = 19;
      paramInt5 = j;
    }
    else if ((4 != paramInt6) && (5 != paramInt6))
    {
      if ((6 != paramInt6) && (7 != paramInt6) && (9 != paramInt6))
      {
        paramInt6 = paramInt2;
        i = paramInt5;
        paramInt2 = k;
        paramInt5 = paramInt6;
        paramInt6 = i;
      }
      else
      {
        paramInt1 = (int)(27.0F / DeviceInfoUtil.a);
        paramInt2 = 2;
        paramInt5 = j;
        paramInt6 = i;
      }
    }
    else
    {
      paramInt1 = (int)(24.0F / DeviceInfoUtil.a);
      paramInt2 = 6;
      paramInt5 = -7645212;
      paramInt6 = i;
    }
    try
    {
      paramString1 = new TextView(BaseApplicationImpl.getContext());
      Paint.FontMetricsInt localFontMetricsInt = new Paint.FontMetricsInt();
      paramString1.getPaint().getFontMetricsInt(localFontMetricsInt);
      paramString1.setWidth(paramInt3);
      paramString1.setHeight(paramInt4);
      a(paramInt6, paramString1);
      paramString1.setTextColor(paramInt5);
      paramString1.setTextSize(paramInt1);
      paramString1.setText(ApolloUtilImpl.autoSplitText(paramString1.getPaint(), paramInt3, paramString2, paramInt2));
      paramString1.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramInt1 = paramString1.getMeasuredWidth();
      paramInt2 = paramString1.getMeasuredHeight();
      paramString1.layout(0, 0, paramInt1, paramInt2);
      paramString2 = a(paramInt1, paramInt2);
      paramString1.draw(new Canvas(paramString2));
      return paramString2;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("getTextBitMapException e=");
      paramString2.append(paramString1.toString());
      QLog.e("[cmshow]FontUtils", 1, paramString2.toString());
      return null;
    }
    catch (OutOfMemoryError paramString1)
    {
      QLog.e("[cmshow]FontUtils", 1, paramString1.getMessage());
    }
    return null;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, int paramInt7, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt8)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    double d1 = paramInt1;
    Double.isNaN(d1);
    try
    {
      float f = DeviceInfoUtil.a;
      double d2 = f;
      Double.isNaN(d2);
      f = (float)(d1 * 1.0D / d2);
      StrokeTextView localStrokeTextView = new StrokeTextView(BaseApplicationImpl.getContext(), null);
      localStrokeTextView.setTextSize(f);
      localStrokeTextView.setIncludeFontPadding(false);
      localStrokeTextView.setWidth(paramInt3);
      localStrokeTextView.setHeight(paramInt4);
      a(paramInt5, localStrokeTextView);
      paramString2 = a(paramString2);
      if (paramInt6 == 1) {
        localStrokeTextView.setTypeface(paramString2, 1);
      } else if (paramInt6 == 2) {
        localStrokeTextView.setTypeface(paramString2, 2);
      } else if (paramInt6 == 3) {
        localStrokeTextView.setTypeface(paramString2, 3);
      }
      if ((paramFloat1 != 0.0F) && (paramFloat1 != (0.0F / 0.0F)))
      {
        localStrokeTextView.setStrokeEnable(true);
        localStrokeTextView.setStrokeSize((int)paramFloat1);
        localStrokeTextView.setStrokeColor(paramInt7);
      }
      if ((paramFloat2 != 0.0F) && (paramFloat2 != (0.0F / 0.0F))) {
        localStrokeTextView.setShadow(paramFloat2, paramFloat3, paramFloat4, paramInt8);
      }
      localStrokeTextView.setInnerTextColor(paramInt2);
      localStrokeTextView.setText(paramString1);
      localStrokeTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramInt1 = localStrokeTextView.getMeasuredWidth();
      paramInt2 = localStrokeTextView.getMeasuredHeight();
      localStrokeTextView.layout(0, 0, paramInt1, paramInt2);
      paramString1 = a(paramInt1, paramInt2);
      if (paramString1 == null) {
        return null;
      }
      localStrokeTextView.draw(new Canvas(paramString1));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("getTextBitMapException e=");
      paramString2.append(paramString1.toString());
      QLog.e("[cmshow]FontUtils", 1, paramString2.toString());
    }
    return null;
  }
  
  private static Typeface a(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      if (jdField_a_of_type_JavaUtilMap == null) {
        jdField_a_of_type_JavaUtilMap = new HashMap();
      }
      if (jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        return (Typeface)jdField_a_of_type_JavaUtilMap.get(paramString);
      }
      Typeface localTypeface = Typeface.createFromFile(paramString);
      jdField_a_of_type_JavaUtilMap.put(paramString, localTypeface);
      return localTypeface;
    }
    return null;
  }
  
  @Nullable
  public static String a(String paramString, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bubbleType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("[cmshow]FontUtils", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && ((paramInt == 0) || (1 == paramInt)))
      {
        localObject = Base64Util.decode(paramString.getBytes("utf-8"), 0);
        if (localObject != null)
        {
          localObject = new String((byte[])localObject);
          return localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]FontUtils", 1, localThrowable, new Object[0]);
      return paramString;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("[cmshow]FontUtils", 1, localOutOfMemoryError.getMessage());
    }
    return paramString;
  }
  
  private static void a(int paramInt, TextView paramTextView)
  {
    if (paramInt == 0)
    {
      paramTextView.setGravity(3);
      return;
    }
    if (paramInt == 1)
    {
      paramTextView.setGravity(17);
      return;
    }
    if (paramInt == 2) {
      paramTextView.setGravity(5);
    }
  }
  
  public static int[] a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    paramString1 = new TextView(BaseApplicationImpl.getContext());
    Paint.FontMetricsInt localFontMetricsInt = new Paint.FontMetricsInt();
    paramString1.getPaint().getFontMetricsInt(localFontMetricsInt);
    paramString1.setGravity(17);
    paramString1.setTextSize(paramInt1);
    paramString1.setText(paramString2);
    if (paramInt2 != 0) {
      paramString1.setMaxWidth(paramInt2);
    }
    paramString1.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramInt1 = paramString1.getMeasuredWidth();
    paramInt2 = paramString1.getMeasuredHeight();
    paramString1.layout(0, 0, paramInt1, paramInt2);
    return new int[] { paramInt1, paramInt2 };
  }
  
  public static int[] a(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, int paramInt8, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt9)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    double d1 = paramInt1;
    Double.isNaN(d1);
    double d2 = DeviceInfoUtil.a;
    Double.isNaN(d2);
    float f = (float)(d1 * 1.0D / d2);
    StrokeTextView localStrokeTextView = new StrokeTextView(BaseApplicationImpl.getContext(), null);
    localStrokeTextView.setTextSize(f);
    localStrokeTextView.setIncludeFontPadding(false);
    a(paramInt6, localStrokeTextView);
    paramString2 = a(paramString2);
    if (paramInt7 == 1) {
      localStrokeTextView.setTypeface(paramString2, 1);
    }
    for (;;)
    {
      break;
      if (paramInt7 == 2) {
        localStrokeTextView.setTypeface(paramString2, 2);
      } else if (paramInt7 == 3) {
        localStrokeTextView.setTypeface(paramString2, 3);
      }
    }
    localStrokeTextView.setText(paramString1);
    if (paramInt4 != 0) {
      localStrokeTextView.setMaxWidth(paramInt4);
    }
    if (paramInt5 != 0) {
      localStrokeTextView.setMaxHeight(paramInt5);
    }
    if (paramFloat1 != 0.0F)
    {
      localStrokeTextView.setStrokeEnable(true);
      localStrokeTextView.setStrokeSize((int)paramFloat1);
      localStrokeTextView.setStrokeColor(paramInt8);
    }
    if (paramFloat2 != 0.0F) {
      localStrokeTextView.setShadow(paramFloat2, paramFloat3, paramFloat4, paramInt9);
    }
    localStrokeTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramInt6 = localStrokeTextView.getMeasuredWidth();
    paramInt5 = localStrokeTextView.getMeasuredHeight();
    paramInt4 = paramInt6;
    paramInt1 = paramInt5;
    if (paramFloat2 != 0.0F)
    {
      paramInt4 = Math.max(paramInt6, (int)paramFloat3 + paramInt6);
      paramInt1 = Math.max(paramInt5, (int)paramFloat4 + paramInt5);
    }
    paramString1 = new int[4];
    paramString1[0] = paramInt4;
    paramString1[1] = paramInt1;
    paramString1[2] = paramInt4;
    paramString1[3] = paramInt1;
    if (paramInt2 != 0) {
      paramString1[0] = paramInt2;
    }
    if (paramInt3 != 0) {
      paramString1[1] = paramInt3;
    }
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.util.FontUtils
 * JD-Core Version:    0.7.0.1
 */