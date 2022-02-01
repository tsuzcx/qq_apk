package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ReflectionUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(19)
public class QQBlur
{
  public static int a;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread = ThreadManagerV2.newFreeHandlerThread("QQBlur", -8);
  private static Field jdField_a_of_type_JavaLangReflectField;
  private float jdField_a_of_type_Float = 8.0F;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private volatile Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#DAFAFAFC"));
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private QQBlur.BackgroundViewDirtyListener jdField_a_of_type_ComTencentMobileqqWidgetQQBlur$BackgroundViewDirtyListener;
  private QQBlur.OnDrawBgListener jdField_a_of_type_ComTencentMobileqqWidgetQQBlur$OnDrawBgListener;
  private String jdField_a_of_type_JavaLangString;
  private List<View> jdField_a_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = 1.0F;
  private int jdField_b_of_type_Int = 6;
  private long jdField_b_of_type_Long;
  private volatile View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 1.0F;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = 2;
  private long jdField_d_of_type_Long;
  private float jdField_e_of_type_Float;
  private long jdField_e_of_type_Long;
  private long f;
  private long g;
  private long h;
  
  static
  {
    jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  private static int a(float paramFloat1, float paramFloat2)
  {
    return (int)Math.ceil(paramFloat1 / paramFloat2);
  }
  
  public static int a(int paramInt)
  {
    int i = paramInt % 16;
    if (i == 0) {
      return paramInt;
    }
    return paramInt - i + 16;
  }
  
  private CharSequence a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "StackBlur.Java";
        }
        return "GaussBlur.RS";
      }
      return "StackBlur.RS";
    }
    return "StackBlur.Native";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPolicyChange() called with: from = [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], to = [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QLog.d("QQBlur", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
  }
  
  private void a(View paramView, int paramInt)
  {
    SystemClock.uptimeMillis();
    try
    {
      if (jdField_a_of_type_JavaLangReflectField == null) {
        jdField_a_of_type_JavaLangReflectField = ReflectionUtil.a("android.view.View", "mViewFlags");
      }
      int i = jdField_a_of_type_JavaLangReflectField.getInt(paramView);
      jdField_a_of_type_JavaLangReflectField.setInt(paramView, paramInt & 0xC | i & 0xFFFFFFF3);
    }
    catch (Exception paramView)
    {
      QLog.e("QQBlur", 1, "setViewInvisible: ", paramView);
    }
    SystemClock.uptimeMillis();
    if (this.h >= 100000L) {
      this.h = 0L;
    }
    this.h += 1L;
    long l = this.h;
  }
  
  private void a(View paramView, List<View> paramList)
  {
    if (paramView == null) {
      return;
    }
    if (paramView.getVisibility() != 0) {
      return;
    }
    paramList.add(paramView);
    a(paramView, 4);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        a(paramView.getChildAt(i), paramList);
        i += 1;
      }
    }
  }
  
  private void a(StackBlurManager paramStackBlurManager)
  {
    paramStackBlurManager = new QQBlur.1(this, paramStackBlurManager);
    this.jdField_a_of_type_AndroidOsHandler.post(paramStackBlurManager);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    int i = a(paramInt1, this.jdField_a_of_type_Float);
    int j = a(paramInt2, this.jdField_a_of_type_Float);
    int k = a(i);
    int m = a(j);
    if (k > this.jdField_b_of_type_AndroidViewView.getResources().getDisplayMetrics().widthPixels)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("prepareBlurBitmapCore: roundScaledWidth = ");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(", viewWidth = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", scaleFactor = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Float);
      QLog.e("QQBlur", 1, ((StringBuilder)localObject1).toString());
      return true;
    }
    if (m > this.jdField_b_of_type_AndroidViewView.getResources().getDisplayMetrics().heightPixels)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("prepareBlurBitmapCore: roundScaledHeight = ");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append(", viewHeight = ");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", scaleFactor = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Float);
      QLog.e("QQBlur", 1, ((StringBuilder)localObject1).toString());
      return true;
    }
    this.jdField_c_of_type_Float = (j / m);
    this.jdField_b_of_type_Float = (i / k);
    float f2 = this.jdField_a_of_type_Float;
    float f1 = this.jdField_b_of_type_Float * f2;
    f2 *= this.jdField_c_of_type_Float;
    Object localObject1 = null;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
      localObject1 = localBitmap;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQBlur", 1, "prepareBlurBitmapCore: ", localThrowable);
    }
    if (localObject1 == null) {
      return true;
    }
    this.jdField_e_of_type_Long = ((Bitmap)localObject1).getWidth();
    this.f = ((Bitmap)localObject1).getHeight();
    if (Build.VERSION.SDK_INT >= 19) {
      this.g = ((Bitmap)localObject1).getAllocationByteCount();
    } else {
      this.g = ((Bitmap)localObject1).getByteCount();
    }
    ((Bitmap)localObject1).eraseColor(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap((Bitmap)localObject1);
    Object localObject2 = new int[2];
    this.jdField_b_of_type_AndroidViewView.getLocationInWindow((int[])localObject2);
    Object localObject3 = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationInWindow((int[])localObject3);
    this.jdField_a_of_type_AndroidGraphicsCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsCanvas.translate(-(localObject2[0] - localObject3[0]) / f1, -(localObject2[1] - localObject3[1]) / f2);
    this.jdField_a_of_type_AndroidGraphicsCanvas.scale(1.0F / f1, 1.0F / f2);
    localObject2 = new StackBlurManager((Bitmap)localObject1);
    ((StackBlurManager)localObject2).setDbg(false);
    ((StackBlurManager)localObject2).setExecutorThreads(((StackBlurManager)localObject2).getExecutorThreads());
    localObject3 = new Bundle();
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur$OnDrawBgListener;
    if (localObject4 != null) {
      ((QQBlur.OnDrawBgListener)localObject4).a((Bundle)localObject3);
    }
    this.jdField_c_of_type_Boolean = true;
    if ((Build.VERSION.SDK_INT > 27) && (this.jdField_b_of_type_AndroidViewView.getContext().getApplicationInfo().targetSdkVersion > 27))
    {
      this.jdField_a_of_type_AndroidViewView.draw(this.jdField_a_of_type_AndroidGraphicsCanvas);
    }
    else
    {
      localObject4 = this.jdField_a_of_type_AndroidGraphicsCanvas.getClipBounds();
      ((Rect)localObject4).inset(-((Bitmap)localObject1).getWidth(), -((Bitmap)localObject1).getHeight());
      if (this.jdField_a_of_type_AndroidGraphicsCanvas.clipRect((Rect)localObject4, Region.Op.REPLACE)) {
        this.jdField_a_of_type_AndroidViewView.draw(this.jdField_a_of_type_AndroidGraphicsCanvas);
      } else {
        QLog.e("QQBlur", 1, "prepareBlurBitmapCore: canvas clip rect empty. Cannot draw!!!");
      }
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.restore();
    g();
    this.jdField_c_of_type_Boolean = false;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur$OnDrawBgListener;
    if (localObject1 != null) {
      ((QQBlur.OnDrawBgListener)localObject1).b((Bundle)localObject3);
    }
    a((StackBlurManager)localObject2);
    return false;
  }
  
  private void e()
  {
    long l1 = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      int i = this.jdField_b_of_type_AndroidViewView.getWidth();
      int j = this.jdField_b_of_type_AndroidViewView.getHeight();
      if ((i > 0) && (j > 0))
      {
        if (a(i, j)) {
          return;
        }
        long l2 = SystemClock.elapsedRealtime();
        this.jdField_a_of_type_Long += 1L;
        this.jdField_b_of_type_Long += l2 - l1;
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepareBlurBitmap: viewWidth = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" viewHeight = ");
      localStringBuilder.append(j);
      QLog.e("QQBlur", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("prepareBlurBitmap: mBgView = ");
    localStringBuilder.append(this.jdField_a_of_type_AndroidViewView);
    localStringBuilder.append(" mBlurView = ");
    localStringBuilder.append(this.jdField_b_of_type_AndroidViewView);
    QLog.e("QQBlur", 1, localStringBuilder.toString());
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidViewView != null)) {
      View localView = this.jdField_b_of_type_AndroidViewView;
    }
  }
  
  private void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView != null) {
        a(localView, 0);
      }
    }
  }
  
  public QQBlur a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlur", 2, "onCreate() called");
    }
    boolean bool = this.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_b_of_type_AndroidViewView.getContext();
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_b_of_type_Boolean = true;
    f();
    return this;
  }
  
  public QQBlur a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    return this;
  }
  
  public QQBlur a(QQBlur.OnDrawBgListener paramOnDrawBgListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur$OnDrawBgListener = paramOnDrawBgListener;
    return this;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("方案=");
    localStringBuilder1.append(a(jdField_a_of_type_Int));
    localStringBuilder1.append(",");
    localStringBuilder1.append("缩放倍数=");
    localStringBuilder1.append(this.jdField_a_of_type_Float);
    localStringBuilder1.append(",");
    localStringBuilder1.append("模糊半径=");
    localStringBuilder1.append(this.jdField_b_of_type_Int);
    localStringBuilder1.append(",");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("尺寸=");
    localStringBuilder2.append(this.jdField_e_of_type_Long);
    localStringBuilder2.append("x");
    localStringBuilder2.append(this.f);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("空间=");
    localStringBuilder2.append(this.g / 1000L);
    localStringBuilder2.append("KB");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("并发数=");
    localStringBuilder2.append(this.jdField_d_of_type_Int);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("主线程采样=[");
    localStringBuilder2.append(String.format("%.2f", new Object[] { Float.valueOf((float)this.jdField_b_of_type_Long / (float)this.jdField_a_of_type_Long) }));
    localStringBuilder2.append("]ms");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("后台线程处理=[");
    localStringBuilder2.append(String.format("%.2f", new Object[] { Float.valueOf((float)this.jdField_d_of_type_Long / (float)this.jdField_c_of_type_Long) }));
    localStringBuilder2.append("]ms");
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQBlur.");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    QLog.i(localStringBuilder.toString(), 2, a());
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(View paramView, Canvas paramCanvas)
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null)
    {
      paramCanvas.save();
      paramCanvas.scale(paramView.getWidth() * 1.0F / localBitmap.getWidth(), paramView.getHeight() * 1.0F / localBitmap.getHeight());
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, localBitmap.getWidth(), localBitmap.getHeight());
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_d_of_type_Float, this.jdField_e_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (paramView != null)
      {
        paramView.setBounds(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      paramCanvas.restore();
      return;
    }
    paramCanvas = new StringBuilder();
    paramCanvas.append("onDrawBlur: blured bitmap is null ");
    paramCanvas.append(Integer.toHexString(System.identityHashCode(paramView)));
    QLog.e("QQBlur", 1, paramCanvas.toString());
  }
  
  public void a(QQBlur.BackgroundViewDirtyListener paramBackgroundViewDirtyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur$BackgroundViewDirtyListener = paramBackgroundViewDirtyListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public QQBlur b(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    return this;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur$BackgroundViewDirtyListener;
    boolean bool;
    if (localObject != null)
    {
      bool = ((QQBlur.BackgroundViewDirtyListener)localObject).isDirty();
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        bool = ((View)localObject).isDirty();
      } else {
        bool = false;
      }
    }
    localObject = this.jdField_b_of_type_AndroidViewView;
    if ((!this.jdField_a_of_type_Boolean) && (bool) && (localObject != null) && (((View)localObject).isShown()))
    {
      e();
      ((View)localObject).invalidate();
    }
    return true;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBlur", 2, "onDestroy() called");
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_b_of_type_AndroidViewView = null;
      this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(null);
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
      this.jdField_a_of_type_AndroidGraphicsPaint = null;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlur$OnDrawBgListener = null;
      this.jdField_a_of_type_AndroidContentContext = null;
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    a(this.jdField_a_of_type_AndroidViewView.getRootView(), this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQBlur
 * JD-Core Version:    0.7.0.1
 */