package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.FitSystemWindowsRelativeLayout.DispatchTouchEventListener;
import com.tencent.widget.FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MultiCardRootLayout
  extends FitSystemWindowsRelativeLayout
{
  private static final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private float jdField_a_of_type_Float = ViewUtils.b(18.0F);
  private Paint jdField_a_of_type_AndroidGraphicsPaint = null;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private FitSystemWindowsRelativeLayout.DispatchTouchEventListener jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$DispatchTouchEventListener;
  private FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$OnInterceptTouchEventListener;
  private WeakReference<MultiCardRootLayout.MultiCardRootLayoutListener> jdField_a_of_type_JavaLangRefWeakReference;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = null;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c = true;
  private boolean d = false;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList.add("HUAWEI;VKY-AL00");
    jdField_a_of_type_JavaUtilArrayList.add("Meizu;m3 note");
    jdField_a_of_type_JavaUtilArrayList.add("samsung;SM-C7000");
    jdField_a_of_type_JavaUtilArrayList.add("HUAWEI;JMM-AL00");
  }
  
  public MultiCardRootLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MultiCardRootLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    a();
  }
  
  private void a()
  {
    setWillNotDraw(false);
    if ((Build.VERSION.SDK_INT <= 18) || (a())) {
      setLayerType(1, null);
    }
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    if (this.jdField_a_of_type_AndroidViewGestureDetector == null) {
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new MultiCardRootLayout.1(this), new Handler(Looper.getMainLooper()));
    }
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$DispatchTouchEventListener = new MultiCardRootLayout.2(this);
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$OnInterceptTouchEventListener = new MultiCardRootLayout.3(this);
    a(true);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (paramCanvas == null) {
      return;
    }
    if (this.jdField_b_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131167103));
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131167104));
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getWidth(), getHeight());
      Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      float f = this.jdField_a_of_type_Float;
      localPath.addRoundRect(localRectF, f, f, Path.Direction.CW);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.jdField_b_of_type_AndroidGraphicsPaint);
    int j = (int)(getHeight() * 0.203704F);
    int k = (int)(getWidth() * 0.1034483F);
    int i = 0;
    while (i < 5)
    {
      a(paramCanvas, k, j);
      j += (int)(getHeight() * 0.139918F);
      i += 1;
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int i = (int)(getWidth() * 0.6275862F);
    int j = (int)(getWidth() * 0.796552F);
    int k = (int)(getHeight() * 0.02880658F);
    int m = (int)(getHeight() * 0.02469136F);
    int n = (int)(getHeight() * 0.02469136F);
    a(paramCanvas, paramInt1, paramInt2, i, k);
    a(paramCanvas, paramInt1, paramInt2 + n + k, j, m);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    if ((localPaint != null) && (paramCanvas != null)) {
      paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, localPaint);
    }
  }
  
  private boolean a()
  {
    if ((Build.VERSION.SDK_INT == 24) && ("Xiaomi".equals(Build.MANUFACTURER)) && ("MIX".equals(Build.MODEL))) {
      return true;
    }
    if ((Build.VERSION.SDK_INT == 24) && ("HUAWEI".equals(Build.MANUFACTURER)) && ("BND-AL10".equals(Build.MODEL))) {
      return true;
    }
    if ((Build.VERSION.SDK_INT == 24) && ("HUAWEI".equals(Build.MANUFACTURER)) && ("HUAWEI CAZ-AL10".equals(Build.MODEL))) {
      return true;
    }
    if ((Build.VERSION.SDK_INT == 24) && ("Meizu".equals(Build.MANUFACTURER)) && ("M5 Note".equals(Build.MODEL))) {
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    return jdField_a_of_type_JavaUtilArrayList.contains(localObject);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.setOnInterceptTouchEventListener(this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$OnInterceptTouchEventListener);
      super.setDispatchTouchEventListener(this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout$DispatchTouchEventListener);
      return;
    }
    super.setOnInterceptTouchEventListener(null);
    super.setDispatchTouchEventListener(null);
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getWidth(), getHeight());
      Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      float f = this.jdField_a_of_type_Float;
      localPath.addRoundRect(localRectF, f, f, Path.Direction.CW);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.c) {
      a(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setListener(MultiCardRootLayout.MultiCardRootLayoutListener paramMultiCardRootLayoutListener)
  {
    if (paramMultiCardRootLayoutListener == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMultiCardRootLayoutListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRootLayout
 * JD-Core Version:    0.7.0.1
 */