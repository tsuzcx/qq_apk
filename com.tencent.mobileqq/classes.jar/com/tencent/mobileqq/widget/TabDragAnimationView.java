package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi;
import com.tencent.mobileqq.qqcontext.R.styleable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TabDragAnimationView
  extends View
{
  public static final int a;
  private static final int jdField_h_of_type_Int = ViewUtils.b(2.0F);
  float jdField_a_of_type_Float;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private GestureDetector.OnDoubleTapListener jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  public URLDrawable a;
  private TabDragAnimationView.OnDragListener jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$OnDragListener;
  private final TabDragAnimationView.ScaleAnimUpdateListener jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener;
  private final TabDragAnimationView.ScrollAnimUpdateListener jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScrollAnimUpdateListener;
  private final TabDragAnimationView.StopAnimUpdateListener jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$StopAnimUpdateListener;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  float jdField_b_of_type_Float;
  protected int b;
  ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  protected boolean b;
  float jdField_c_of_type_Float;
  protected int c;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  public boolean c;
  float jdField_d_of_type_Float;
  protected int d;
  private Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  int jdField_e_of_type_Int;
  private Drawable jdField_e_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  int jdField_g_of_type_Int;
  private final boolean jdField_g_of_type_Boolean;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  
  static
  {
    jdField_a_of_type_Int = ViewUtils.b(33.330002F);
  }
  
  public TabDragAnimationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TabDragAnimationView@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    this.k = -1;
    boolean bool = false;
    this.l = 0;
    this.m = 0;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_e_of_type_Int = 1;
    this.n = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_e_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
    this.o = 10000;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bE, paramInt, 0);
    try
    {
      this.jdField_b_of_type_Int = paramAttributeSet.getInt(R.styleable.jdField_a_of_type_Int, 0);
      this.jdField_i_of_type_Int = paramAttributeSet.getDimensionPixelSize(R.styleable.jdField_c_of_type_Int, 0);
      this.j = paramAttributeSet.getDimensionPixelSize(R.styleable.jdField_b_of_type_Int, 0);
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load xml attr, expected logo width=");
        localStringBuilder.append(this.jdField_i_of_type_Int);
        localStringBuilder.append(", expected logo height=");
        localStringBuilder.append(this.j);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      paramAttributeSet.recycle();
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$StopAnimUpdateListener = new TabDragAnimationView.StopAnimUpdateListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScrollAnimUpdateListener = new TabDragAnimationView.ScrollAnimUpdateListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener = new TabDragAnimationView.ScaleAnimUpdateListener(this);
      this.jdField_c_of_type_Boolean = ((IVasApngUtilApi)QRoute.api(IVasApngUtilApi.class)).isNowThemeIsAnimate();
      if ((Build.MODEL.contains("vivo")) || (Build.MANUFACTURER.contains("vivo"))) {
        bool = true;
      }
      this.jdField_g_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new TabDragAnimationView.1(this), this.jdField_a_of_type_AndroidOsHandler);
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = paramInt2 - getPaddingTop() - getPaddingBottom();
    int i2 = this.jdField_i_of_type_Int;
    paramInt1 = i1;
    if (i1 > i2) {
      paramInt1 = i2;
    }
    this.jdField_c_of_type_Int = paramInt1;
    paramInt1 = this.j;
    if (paramInt2 <= paramInt1) {
      paramInt1 = paramInt2;
    }
    this.jdField_d_of_type_Int = paramInt1;
    paramInt1 = this.k;
    if (paramInt1 == -1) {
      paramInt1 = this.jdField_c_of_type_Int / 10;
    }
    paramInt2 = this.k;
    if (paramInt2 == -1) {
      paramInt2 = this.jdField_d_of_type_Int / 10;
    }
    this.m = ((int)Math.sqrt(Math.pow(paramInt1, 2.0D) + Math.pow(paramInt2, 2.0D)));
    this.l = ((int)Math.sqrt(Math.pow(this.jdField_c_of_type_Int / 2 + paramInt1, 2.0D) + Math.pow(this.jdField_d_of_type_Int / 2 + paramInt2, 2.0D)));
  }
  
  private boolean a()
  {
    return this.jdField_e_of_type_AndroidGraphicsDrawableDrawable != null;
  }
  
  Drawable a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (localObject1 != null) {
        return localObject1;
      }
      localObject1 = ((IVasApngUtilApi)QRoute.api(IVasApngUtilApi.class)).getAnimatePathByTag(this.jdField_f_of_type_Int);
      Drawable localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_width", this.jdField_c_of_type_Int);
      localBundle.putInt("key_height", this.jdField_d_of_type_Int);
      localBundle.putInt("key_loop", 1);
      int i1 = this.jdField_g_of_type_Int;
      IVasApngUtilApi localIVasApngUtilApi = (IVasApngUtilApi)QRoute.api(IVasApngUtilApi.class);
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("- tab-");
      ((StringBuilder)localObject2).append(this.jdField_f_of_type_Int);
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("- tab-");
      ((StringBuilder)localObject3).append(this.jdField_f_of_type_Int);
      localObject3 = ((StringBuilder)localObject3).toString();
      this.jdField_a_of_type_ComTencentImageURLDrawable = localIVasApngUtilApi.getApngDrawable(localAppRuntime, (String)localObject1, (String)localObject2, localDrawable, new int[] { i1 }, (String)localObject3, localBundle);
      localObject1 = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (localObject1 != null)
      {
        ((URLDrawable)localObject1).setCallback(this);
        return this.jdField_a_of_type_ComTencentImageURLDrawable;
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localObject1 != null)
    {
      ((URLDrawable)localObject1).setCallback(null);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
    return this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_e_of_type_Int = 8;
      this.jdField_c_of_type_Float = paramFloat1;
      this.jdField_d_of_type_Float = paramFloat2;
      this.jdField_e_of_type_Boolean = paramBoolean;
      invalidate();
    }
  }
  
  /* Error */
  public void a(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 356	java/io/FileOutputStream
    //   8: dup
    //   9: aload_2
    //   10: invokespecial 359	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_1
    //   15: getstatic 365	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   18: bipush 90
    //   20: aload_2
    //   21: invokevirtual 371	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   24: pop
    //   25: aload_2
    //   26: invokevirtual 374	java/io/FileOutputStream:close	()V
    //   29: return
    //   30: astore_1
    //   31: aload_2
    //   32: astore_3
    //   33: goto +40 -> 73
    //   36: astore_3
    //   37: aload_2
    //   38: astore_1
    //   39: aload_3
    //   40: astore_2
    //   41: goto +11 -> 52
    //   44: astore_1
    //   45: goto +28 -> 73
    //   48: astore_2
    //   49: aload 4
    //   51: astore_1
    //   52: aload_1
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 377	java/lang/Exception:printStackTrace	()V
    //   58: aload_1
    //   59: ifnull +13 -> 72
    //   62: aload_1
    //   63: invokevirtual 374	java/io/FileOutputStream:close	()V
    //   66: return
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 378	java/io/IOException:printStackTrace	()V
    //   72: return
    //   73: aload_3
    //   74: ifnull +15 -> 89
    //   77: aload_3
    //   78: invokevirtual 374	java/io/FileOutputStream:close	()V
    //   81: goto +8 -> 89
    //   84: astore_2
    //   85: aload_2
    //   86: invokevirtual 378	java/io/IOException:printStackTrace	()V
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	TabDragAnimationView
    //   0	91	1	paramBitmap	Bitmap
    //   0	91	2	paramString	String
    //   4	29	3	str	String
    //   36	4	3	localException	java.lang.Exception
    //   53	25	3	localBitmap	Bitmap
    //   1	49	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	25	30	finally
    //   14	25	36	java/lang/Exception
    //   5	14	44	finally
    //   54	58	44	finally
    //   5	14	48	java/lang/Exception
    //   25	29	67	java/io/IOException
    //   62	66	67	java/io/IOException
    //   77	81	84	java/io/IOException
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(paramString);
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$StopAnimUpdateListener.a();
      f();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
    c();
  }
  
  public void c()
  {
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    invalidate();
  }
  
  void d()
  {
    ValueAnimator localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_b_of_type_AndroidAnimationValueAnimator.removeUpdateListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener);
    }
    this.jdField_e_of_type_Int = 1;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.75F, 0.5F, 0.75F, 1.0F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(200L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.jdField_h_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap.eraseColor(-1);
      this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      super.draw(this.jdField_a_of_type_AndroidGraphicsCanvas);
      paramCanvas = new StringBuilder();
      paramCanvas.append(Environment.getExternalStorageDirectory());
      paramCanvas.append("/aaaa/");
      paramCanvas = paramCanvas.toString();
      new File(paramCanvas).mkdirs();
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramCanvas);
      int i1 = this.o;
      this.o = (i1 + 1);
      localStringBuilder.append(i1);
      localStringBuilder.append(".png");
      a(localBitmap, localStringBuilder.toString());
    }
  }
  
  void e()
  {
    ValueAnimator localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_b_of_type_AndroidAnimationValueAnimator.removeUpdateListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.a();
      this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    }
  }
  
  void f()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeUpdateListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$StopAnimUpdateListener);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$StopAnimUpdateListener);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i4 = getPaddingLeft();
    int i5 = getRight() - getLeft() - getPaddingRight();
    int i3 = getPaddingTop();
    int i2 = getBottom() - getTop() - getPaddingBottom();
    int i1 = this.jdField_b_of_type_Int;
    int i6;
    int i7;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            i5 = (i4 + i5) / 2;
            i6 = (i3 + i2) / 2;
            i1 = this.jdField_c_of_type_Int;
            i2 = i1 / 2;
            i3 = i1 / 2;
            i4 = this.jdField_d_of_type_Int;
            i1 = i4 / 2;
            i7 = i4 / 2;
            i3 += i5;
            i1 = i6 - i1;
            i4 = i5 - i2;
            i2 = i7 + i6;
            break label447;
          }
          i4 = this.jdField_c_of_type_Int;
          i1 = i5 - i4 / 2;
          i6 = (i3 + i2) / 2;
          i4 = i5 - i4 / 2;
          i2 = this.jdField_d_of_type_Int;
          i7 = i6 - i2 / 2;
          i3 = i2 / 2;
          i2 = i5;
          i5 = i3;
          i3 = i1;
          i1 = i7;
        }
        else
        {
          i1 = this.jdField_c_of_type_Int;
          i5 = i1 / 2 + i4;
          i6 = (i3 + i2) / 2;
          i2 = i1 + i4;
          i3 = this.jdField_d_of_type_Int;
          i1 = i6 - i3 / 2;
          i7 = i3 / 2;
          i3 = i5;
          i5 = i7;
        }
        i7 = i5 + i6;
        i5 = i3;
        i3 = i2;
        i2 = i7;
      }
      else
      {
        i5 = (i4 + i5) / 2;
        i1 = this.jdField_d_of_type_Int;
        i6 = i2 - i1 / 2;
        i3 = this.jdField_c_of_type_Int;
        i4 = i5 - i3 / 2;
        i3 = i3 / 2 + i5;
        i1 = i2 - i1;
      }
    }
    else
    {
      i5 = (i4 + i5) / 2;
      i1 = this.jdField_d_of_type_Int;
      i7 = i1 / 2;
      i2 = this.jdField_c_of_type_Int;
      i4 = i5 - i2 / 2;
      i2 = i2 / 2 + i5;
      i6 = i1 + i3;
      i1 = i3;
      i7 += i3;
      i3 = i2;
      i2 = i6;
      i6 = i7;
    }
    label447:
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    Drawable localDrawable2;
    Drawable localDrawable1;
    Drawable localDrawable3;
    if ((this.jdField_e_of_type_Int == 1) && (!this.jdField_a_of_type_Boolean))
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_b_of_type_Boolean)) && (this.jdField_d_of_type_Boolean)) {
        localDrawable2 = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
      } else {
        localDrawable2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_b_of_type_Boolean)) && (this.jdField_d_of_type_Boolean)) {
        localDrawable1 = a();
      } else {
        localDrawable1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_a_of_type_Float != 1.0F) {
        paramCanvas.scale(this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_a_of_type_Float, i5, i6);
      }
      if (localDrawable1 != null)
      {
        localDrawable1.setBounds(i4, i1, i3, i2);
        if (!a()) {
          localDrawable1.draw(paramCanvas);
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
        this.jdField_a_of_type_AndroidGraphicsRect.set(localDrawable1.getBounds());
      }
      if ((localDrawable2 != null) && (this.jdField_b_of_type_Boolean))
      {
        localDrawable2.setBounds(i4, i1, i3, i2);
        if (!a()) {
          localDrawable2.draw(paramCanvas);
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16776961);
      }
      localDrawable3 = localDrawable1;
    }
    else
    {
      if (this.jdField_d_of_type_Boolean) {
        localDrawable2 = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
      } else {
        localDrawable2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      }
      if (this.jdField_d_of_type_Boolean) {
        localDrawable1 = a();
      } else {
        localDrawable1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      label944:
      int i8;
      if ((int)Math.sqrt(Math.pow(this.jdField_c_of_type_Int / 2 + Math.abs(this.jdField_c_of_type_Float), 2.0D) + Math.pow(this.jdField_d_of_type_Int / 2 + Math.abs(this.jdField_d_of_type_Float), 2.0D)) > this.l)
      {
        float f1 = this.jdField_c_of_type_Float;
        double d3 = 0.0D;
        double d1;
        if (f1 != 0.0F)
        {
          f1 = this.jdField_d_of_type_Float;
          if (f1 != 0.0F)
          {
            d1 = Math.pow(f1, 2.0D) / Math.pow(this.jdField_c_of_type_Float, 2.0D);
            d2 = this.m;
            d3 = d1 + 1.0D;
            double d4 = 1.0D / Math.sqrt(d3);
            Double.isNaN(d2);
            d2 *= d4;
            d4 = this.m;
            d1 = Math.sqrt(d1 / d3);
            Double.isNaN(d4);
            d1 *= d4;
            break label944;
          }
        }
        if (this.jdField_c_of_type_Float != 0.0F)
        {
          d2 = this.m;
          d1 = d3;
          d3 = d2;
        }
        else if (this.jdField_d_of_type_Float != 0.0F)
        {
          d1 = this.m;
        }
        else
        {
          d1 = 0.0D;
        }
        if (this.jdField_c_of_type_Float > 0.0F) {
          i5 = 1;
        } else {
          i5 = -1;
        }
        double d2 = i5;
        Double.isNaN(d2);
        i8 = (int)(d3 * d2);
        if (this.jdField_d_of_type_Float > 0.0F) {
          i5 = 1;
        } else {
          i5 = -1;
        }
        d2 = i5;
        Double.isNaN(d2);
        i5 = (int)(d1 * d2);
      }
      else
      {
        i8 = (int)this.jdField_c_of_type_Float;
        i5 = (int)this.jdField_d_of_type_Float;
      }
      int i9 = i8 * 2;
      int i10 = i5 * 2;
      if (localDrawable1 != null)
      {
        if (this.jdField_e_of_type_Boolean) {
          i6 = i4;
        } else {
          i6 = i4 - i8;
        }
        if (this.jdField_e_of_type_Boolean) {
          i7 = i1;
        } else {
          i7 = i1 - i5;
        }
        if (this.jdField_e_of_type_Boolean) {
          i8 = i3;
        } else {
          i8 = i3 - i8;
        }
        if (this.jdField_e_of_type_Boolean) {
          i5 = i2;
        } else {
          i5 = i2 - i5;
        }
        localDrawable1.setBounds(i6, i7, i8, i5);
        if (!a()) {
          localDrawable1.draw(paramCanvas);
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
        this.jdField_a_of_type_AndroidGraphicsRect.set(localDrawable1.getBounds());
      }
      localDrawable3 = localDrawable1;
      if (localDrawable2 != null)
      {
        localDrawable3 = localDrawable1;
        if (this.jdField_b_of_type_Boolean)
        {
          paramCanvas.save();
          localDrawable2.setBounds(i4 - i9, i1 - i10, i3 - i9, i2 - i10);
          if (!a())
          {
            boolean bool = this.jdField_d_of_type_Boolean;
            localDrawable2.draw(paramCanvas);
          }
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16776961);
          paramCanvas.restore();
          localDrawable3 = localDrawable1;
        }
      }
    }
    if ((a()) && (localDrawable3 != null))
    {
      this.jdField_e_of_type_AndroidGraphicsDrawableDrawable.setBounds(localDrawable3.getBounds());
      this.jdField_e_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = getPaddingLeft();
    int i5 = getPaddingRight();
    int i6 = this.jdField_i_of_type_Int;
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    int i3 = this.j;
    paramInt1 = resolveSizeAndState(i4 + i5 + i6, paramInt1, 0);
    paramInt2 = resolveSizeAndState(i1 + i2 + i3, paramInt2, 0);
    View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getSize(paramInt2);
    a(paramInt1, paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener != null) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    Object localObject = this.jdField_e_of_type_AndroidGraphicsDrawableDrawable;
    if ((localObject != null) && ((localObject instanceof Animatable)) && (!((Animatable)localObject).isRunning())) {
      setClickAnimationDrawable(null);
    }
    int i1 = getPaddingLeft();
    int i6 = getRight();
    int i7 = getLeft();
    int i8 = getPaddingRight();
    int i2 = getPaddingTop();
    int i3 = getBottom();
    int i4 = getTop();
    int i5 = getPaddingBottom();
    i1 = (i1 + (i6 - i7 - i8)) / 2;
    i6 = (i2 + (i3 - i4 - i5)) / 2;
    double d1 = this.jdField_c_of_type_Int;
    Double.isNaN(d1);
    d1 = Math.pow(d1 / 2.0D, 2.0D);
    double d2 = this.jdField_d_of_type_Int;
    Double.isNaN(d2);
    i2 = (int)Math.sqrt(d1 + Math.pow(d2 / 2.0D, 2.0D));
    i3 = getWidth();
    i4 = getHeight();
    i5 = paramMotionEvent.getActionMasked();
    if (i5 != 0)
    {
      float f2 = 0.0F;
      if (i5 != 1) {
        if (i5 != 2)
        {
          if (i5 != 3) {
            return false;
          }
          if (this.jdField_g_of_type_Boolean)
          {
            i7 = (int)(DeviceInfoUtil.j() - ViewUtils.a(14.0F));
            if (this.jdField_e_of_type_Float > i7)
            {
              this.jdField_a_of_type_Float = 0.0F;
              this.jdField_b_of_type_Float = 0.0F;
              this.jdField_e_of_type_Float = 0.0F;
              this.n = -1;
              this.jdField_f_of_type_Boolean = false;
              if (this.jdField_a_of_type_Boolean) {
                b();
              }
              return false;
            }
          }
        }
        else
        {
          if (this.jdField_b_of_type_Boolean)
          {
            i2 = paramMotionEvent.findPointerIndex(this.n);
            if (i2 == -1)
            {
              this.jdField_f_of_type_Boolean = false;
              return false;
            }
            f3 = paramMotionEvent.getX(i2);
            f1 = paramMotionEvent.getY(i2);
            if (((int)Math.sqrt(Math.pow(f3 - i1, 2.0D) + Math.pow(f1 - i6, 2.0D)) <= this.l) && ((f3 != this.jdField_a_of_type_Float) || (f1 != this.jdField_b_of_type_Float)))
            {
              f2 = this.jdField_a_of_type_Float - f3;
              f1 = this.jdField_b_of_type_Float - f1;
              this.jdField_f_of_type_Boolean = true;
            }
            else if (this.jdField_f_of_type_Boolean)
            {
              f2 = this.jdField_a_of_type_Float - f3;
              f1 = this.jdField_b_of_type_Float - f1;
            }
            else
            {
              f1 = 0.0F;
            }
            if (this.jdField_f_of_type_Boolean)
            {
              e();
              a(f2, f1, false);
            }
            return this.jdField_f_of_type_Boolean;
          }
          return false;
        }
      }
      this.n = -1;
      this.jdField_f_of_type_Boolean = false;
      if (this.jdField_a_of_type_Boolean) {
        b();
      }
      f2 = this.jdField_a_of_type_Float;
      float f1 = i1;
      d1 = Math.pow(f2 - f1, 2.0D);
      f2 = this.jdField_b_of_type_Float;
      float f4 = i6;
      i6 = (int)Math.sqrt(d1 + Math.pow(f2 - f4, 2.0D)) + jdField_h_of_type_Int;
      f2 = paramMotionEvent.getX();
      float f3 = paramMotionEvent.getY();
      i7 = (int)Math.sqrt(Math.pow(f2 - f1, 2.0D) + Math.pow(f3 - f4, 2.0D));
      if (((i6 >= i2) || (i7 <= i2)) && (f2 > 0.0F) && (f2 < i3) && (f3 > 0.0F) && (f3 < i4)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$OnDragListener;
        if (localObject != null) {
          ((TabDragAnimationView.OnDragListener)localObject).a();
        }
      }
      if ((this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener == null) && (getParent() != null) && (i1 != 0))
      {
        ((ViewGroup)getParent()).performClick();
        if (QLog.isColorLevel())
        {
          f1 = paramMotionEvent.getRawX();
          f4 = paramMotionEvent.getRawY();
          paramMotionEvent = this.jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("TabDragView perform click, action=");
          ((StringBuilder)localObject).append(i5);
          ((StringBuilder)localObject).append(", ux=");
          ((StringBuilder)localObject).append(f2);
          ((StringBuilder)localObject).append(", uy=");
          ((StringBuilder)localObject).append(f3);
          ((StringBuilder)localObject).append(", urx=");
          ((StringBuilder)localObject).append(f1);
          ((StringBuilder)localObject).append(", ury=");
          ((StringBuilder)localObject).append(f4);
          ((StringBuilder)localObject).append(", w=");
          ((StringBuilder)localObject).append(i3);
          ((StringBuilder)localObject).append(", vh=");
          ((StringBuilder)localObject).append(i4);
          ((StringBuilder)localObject).append(", radius=");
          ((StringBuilder)localObject).append(i6);
          ((StringBuilder)localObject).append(", innerRadius=");
          ((StringBuilder)localObject).append(i2);
          ((StringBuilder)localObject).append(", upRidus=");
          ((StringBuilder)localObject).append(i7);
          QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
        }
      }
      return true;
    }
    this.jdField_a_of_type_Float = paramMotionEvent.getX();
    this.jdField_b_of_type_Float = paramMotionEvent.getY();
    this.jdField_e_of_type_Float = paramMotionEvent.getRawY();
    this.n = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
    if ((int)Math.sqrt(Math.pow(this.jdField_a_of_type_Float - i1, 2.0D) + Math.pow(this.jdField_b_of_type_Float - i6, 2.0D)) <= i2) {
      if (this.jdField_d_of_type_Boolean) {
        c();
      } else if (this.jdField_i_of_type_Boolean) {
        d();
      }
    }
    return true;
  }
  
  public void setAnimEnable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setBgDrawable(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBgDrawable() called with: bgId = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt != -1)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt);
      invalidate();
    }
  }
  
  public void setBgPressedDrawable(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBgPressedDrawable() called with: bgPressId = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt != -1)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt);
      invalidate();
    }
  }
  
  public void setClickAnimationDrawable(Drawable paramDrawable)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setClickAnimationDrawable() called with: drawable = [");
      localStringBuilder.append(paramDrawable);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.jdField_e_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null) {
      ((Drawable)localObject).setCallback(null);
    }
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    paramDrawable = this.jdField_e_of_type_AndroidGraphicsDrawableDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    invalidate();
  }
  
  public void setDebug(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public void setEmotionDrawable(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Resources localResources = getResources();
    this.jdField_f_of_type_Int = paramInt5;
    this.jdField_g_of_type_Int = paramInt6;
    if (paramInt1 != -1) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = localResources.getDrawable(paramInt1);
    }
    if (paramInt2 != -1) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localResources.getDrawable(paramInt2);
    }
    if (paramInt3 != -1) {
      this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = localResources.getDrawable(paramInt3);
    }
    if (paramInt4 != -1) {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = localResources.getDrawable(paramInt4);
    }
  }
  
  public void setEmotionDrawable(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable1;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable2;
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = paramDrawable3;
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable4;
  }
  
  public void setEnableClickScaleAnimation(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public void setExpectedLogoMoveDistance(int paramInt)
  {
    this.k = paramInt;
    if (paramInt != -1) {
      this.m = ((int)Math.sqrt(Math.pow(this.k, 2.0D) * 2.0D));
    }
  }
  
  public void setFaceDrawable(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFaceDrawable() called with: faceId = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt != -1) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt);
    } else {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    invalidate();
  }
  
  public void setFacePressedDrawable(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFacePressedDrawable() called with: facePressId = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt != -1) {
      this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt);
    } else {
      this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    invalidate();
  }
  
  public void setIconGravity(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 3) && (paramInt != 4) && (paramInt != 1) && (paramInt != 2))
    {
      if (QLog.isColorLevel())
      {
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unsupported gravity=");
        localStringBuilder.append(paramInt);
        QLog.e(str, 2, localStringBuilder.toString());
      }
    }
    else
    {
      this.jdField_b_of_type_Int = paramInt;
      invalidate();
    }
  }
  
  public void setIconSize(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_b_of_type_Boolean)) && (this.jdField_d_of_type_Boolean)) {
      localObject = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
    } else {
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    if (paramInt2 >= 0) {
      this.j = paramInt2;
    } else if (localObject != null) {
      this.j = Math.max(((Drawable)localObject).getIntrinsicHeight(), jdField_a_of_type_Int);
    }
    if (paramInt1 >= 0) {
      this.jdField_i_of_type_Int = paramInt1;
    } else if (localObject != null) {
      this.jdField_i_of_type_Int = Math.max(((Drawable)localObject).getIntrinsicWidth(), jdField_a_of_type_Int);
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setIconSize, mExpectedLogoWidth=");
      localStringBuilder.append(this.jdField_i_of_type_Int);
      localStringBuilder.append(", mExpectedLogoHeight=");
      localStringBuilder.append(this.j);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    requestLayout();
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener = paramOnDoubleTapListener;
  }
  
  public void setOnDragListener(TabDragAnimationView.OnDragListener paramOnDragListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$OnDragListener = paramOnDragListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    super.setOnLongClickListener(paramOnLongClickListener);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
  }
  
  public void setPressChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPressChanged() called with: enable = [");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if ((localObject != null) && (localObject == a()))
    {
      localObject = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localObject instanceof ApngDrawable)) {
        ((ApngDrawable)localObject).repaly();
      }
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabDragAnimationView
 * JD-Core Version:    0.7.0.1
 */