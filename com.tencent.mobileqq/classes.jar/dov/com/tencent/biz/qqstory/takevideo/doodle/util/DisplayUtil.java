package dov.com.tencent.biz.qqstory.takevideo.doodle.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;

@TargetApi(14)
public class DisplayUtil
{
  public static int a;
  public static int b;
  
  public static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 < paramInt4) {
      return 1.0F;
    }
    return paramInt4 / paramInt2;
  }
  
  public static int a()
  {
    return a(BaseApplicationImpl.getApplication().getBaseContext(), 30.0F);
  }
  
  public static int a(Context paramContext)
  {
    if (a > 0) {
      return a;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (a = localPoint.x;; a = paramContext.getDefaultDisplay().getWidth()) {
      return a;
    }
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static void a(Canvas paramCanvas, GestureHelper paramGestureHelper, GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = a();
    paramCanvas.concat(paramGestureHelper.b(paramZoomItem));
    int j = (int)(paramZoomItem.u * paramZoomItem.q * paramZoomItem.w) + paramZoomItem.jdField_j_of_type_Int * 2;
    int k = (int)(paramZoomItem.v * paramZoomItem.q * paramZoomItem.w) + paramZoomItem.jdField_j_of_type_Int * 2;
    paramCanvas.translate(-j * 1.0F / 2.0F, -k * 1.0F / 2.0F);
    paramGestureHelper = new Paint();
    paramGestureHelper.setStyle(Paint.Style.STROKE);
    paramGestureHelper.setColor(BaseApplicationImpl.getApplication().getResources().getColor(2131492908));
    paramGestureHelper.setStrokeWidth(a(BaseApplicationImpl.getApplication().getBaseContext(), 1.0F));
    int m = a(BaseApplicationImpl.getApplication().getBaseContext(), 3.0F);
    paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, j, k), m, m, paramGestureHelper);
    paramCanvas.translate(-i / 2, -i / 2);
    if (paramInt1 > 0)
    {
      paramGestureHelper = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt1);
      paramGestureHelper.setBounds(0, 0, i, i);
      paramGestureHelper.draw(paramCanvas);
    }
    paramCanvas.translate(j, k);
    if (paramInt3 > 0)
    {
      paramGestureHelper = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt3);
      paramGestureHelper.setBounds(0, 0, i, i);
      paramGestureHelper.draw(paramCanvas);
    }
    paramCanvas.translate(0.0F, -k);
    if (paramInt2 > 0)
    {
      paramGestureHelper = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt2);
      paramGestureHelper.setBounds(0, 0, i, i);
      paramGestureHelper.draw(paramCanvas);
    }
  }
  
  public static int b()
  {
    return a(BaseApplicationImpl.getApplication().getBaseContext(), 32.0F);
  }
  
  public static int b(Context paramContext)
  {
    if (b > 0) {
      return b;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (b = localPoint.y;; b = paramContext.getDefaultDisplay().getHeight()) {
      return b;
    }
  }
  
  public static void b(Canvas paramCanvas, GestureHelper paramGestureHelper, GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = a();
    int i = b();
    if ((paramZoomItem.f) && (paramZoomItem.g))
    {
      paramCanvas.translate(paramZoomItem.l, paramZoomItem.m);
      paramCanvas.translate(paramZoomItem.jdField_j_of_type_Float, paramZoomItem.k);
      paramCanvas.translate(-i * paramZoomItem.n * 1.0F / 2.0F, -i * paramZoomItem.n * 1.0F / 2.0F);
      if (!paramZoomItem.f) {
        break label301;
      }
      paramGestureHelper = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt2);
      label96:
      if (!paramZoomItem.d) {
        break label316;
      }
      paramGestureHelper.setAlpha(77);
      label109:
      if (!paramZoomItem.f) {
        break label326;
      }
      paramGestureHelper.setBounds(0, 0, (int)(i * paramZoomItem.n), (int)(i * paramZoomItem.n));
    }
    for (;;)
    {
      paramGestureHelper.draw(paramCanvas);
      return;
      paramCanvas.concat(paramGestureHelper.b(paramZoomItem));
      int j = (int)(paramZoomItem.u * paramZoomItem.q * paramZoomItem.w);
      int k = paramZoomItem.jdField_j_of_type_Int;
      int m = (int)(paramZoomItem.v * paramZoomItem.q * paramZoomItem.w);
      int n = paramZoomItem.jdField_j_of_type_Int;
      paramCanvas.translate(-(j + k * 2) * 1.0F / 2.0F, (m + n * 2) * 1.0F / 2.0F);
      paramCanvas.rotate(0.0F - paramZoomItem.r);
      if (paramZoomItem.f)
      {
        paramCanvas.translate(-i * paramZoomItem.n * 1.0F / 2.0F, -i * paramZoomItem.n * 1.0F / 2.0F);
        break;
      }
      paramCanvas.translate(-paramInt1 * 1.0F / 2.0F, -paramInt1 * 1.0F / 2.0F);
      break;
      label301:
      paramGestureHelper = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt3);
      break label96;
      label316:
      paramGestureHelper.setAlpha(255);
      break label109;
      label326:
      paramGestureHelper.setBounds(0, 0, (int)(paramInt1 * paramZoomItem.n), (int)(paramInt1 * paramZoomItem.n));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil
 * JD-Core Version:    0.7.0.1
 */