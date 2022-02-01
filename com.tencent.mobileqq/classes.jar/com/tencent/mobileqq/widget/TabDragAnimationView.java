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
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.api.R.styleable;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TabDragAnimationView
  extends View
{
  private static final int jdField_g_of_type_Int = ViewUtils.b(2.0F);
  float jdField_a_of_type_Float = 0.0F;
  protected int a;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private GestureDetector.OnDoubleTapListener jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  public URLDrawable a;
  private TabDragAnimationView.OnDragListener jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$OnDragListener;
  private final TabDragAnimationView.ScaleAnimUpdateListener jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener;
  private final TabDragAnimationView.ScrollAnimUpdateListener jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScrollAnimUpdateListener;
  private final TabDragAnimationView.StopAnimUpdateListener jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$StopAnimUpdateListener;
  private String jdField_a_of_type_JavaLangString = "TabDragAnimationView@" + Integer.toHexString(hashCode());
  public boolean a;
  float jdField_b_of_type_Float = 0.0F;
  protected int b;
  ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  protected boolean b;
  float jdField_c_of_type_Float = 0.0F;
  protected int c;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  public boolean c;
  float jdField_d_of_type_Float = 0.0F;
  int jdField_d_of_type_Int = 1;
  private Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_d_of_type_Boolean = false;
  private float jdField_e_of_type_Float = 0.0F;
  int jdField_e_of_type_Int;
  private Drawable jdField_e_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = false;
  private final boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean = true;
  private int j = -1;
  private int k = 0;
  private int l = 0;
  private int m = -1;
  private int n = 10000;
  
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aR, paramInt, 0);
    try
    {
      this.jdField_a_of_type_Int = paramAttributeSet.getInt(R.styleable.jdField_a_of_type_Int, 0);
      this.jdField_h_of_type_Int = paramAttributeSet.getDimensionPixelSize(R.styleable.jdField_c_of_type_Int, 0);
      this.jdField_i_of_type_Int = paramAttributeSet.getDimensionPixelSize(R.styleable.jdField_b_of_type_Int, 0);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "load xml attr, expected logo width=" + this.jdField_h_of_type_Int + ", expected logo height=" + this.jdField_i_of_type_Int);
      }
      paramAttributeSet.recycle();
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$StopAnimUpdateListener = new TabDragAnimationView.StopAnimUpdateListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScrollAnimUpdateListener = new TabDragAnimationView.ScrollAnimUpdateListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener = new TabDragAnimationView.ScaleAnimUpdateListener(this);
      this.jdField_c_of_type_Boolean = ThemeUtil.c();
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
    paramInt1 = i1;
    if (i1 > this.jdField_h_of_type_Int) {
      paramInt1 = this.jdField_h_of_type_Int;
    }
    this.jdField_b_of_type_Int = paramInt1;
    if (paramInt2 > this.jdField_i_of_type_Int)
    {
      paramInt1 = this.jdField_i_of_type_Int;
      this.jdField_c_of_type_Int = paramInt1;
      if (this.j == -1) {
        break label163;
      }
      paramInt1 = this.j;
      label78:
      if (this.j == -1) {
        break label174;
      }
    }
    label163:
    label174:
    for (paramInt2 = this.j;; paramInt2 = this.jdField_c_of_type_Int / 10)
    {
      this.l = ((int)Math.sqrt(Math.pow(paramInt1, 2.0D) + Math.pow(paramInt2, 2.0D)));
      double d1 = Math.pow(paramInt1 + this.jdField_b_of_type_Int / 2, 2.0D);
      this.k = ((int)Math.sqrt(Math.pow(this.jdField_c_of_type_Int / 2 + paramInt2, 2.0D) + d1));
      return;
      paramInt1 = paramInt2;
      break;
      paramInt1 = this.jdField_b_of_type_Int / 10;
      break label78;
    }
  }
  
  private boolean a()
  {
    return this.jdField_e_of_type_AndroidGraphicsDrawableDrawable != null;
  }
  
  Drawable a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        return this.jdField_a_of_type_ComTencentImageURLDrawable;
      }
      String str1 = ThemeUtil.a(this.jdField_e_of_type_Int);
      Drawable localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_width", this.jdField_b_of_type_Int);
      localBundle.putInt("key_height", this.jdField_c_of_type_Int);
      localBundle.putInt("key_loop", 1);
      int i1 = this.jdField_f_of_type_Int;
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      String str2 = "- tab-" + this.jdField_e_of_type_Int;
      String str3 = "- tab-" + this.jdField_e_of_type_Int;
      this.jdField_a_of_type_ComTencentImageURLDrawable = VasApngUtil.getApngDrawable(localAppRuntime, str1, str2, localDrawable, new int[] { i1 }, str3, localBundle);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable.setCallback(this);
        return this.jdField_a_of_type_ComTencentImageURLDrawable;
      }
    }
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setCallback(null);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
    return this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_d_of_type_Int = 8;
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
    //   0: new 346	java/io/FileOutputStream
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 349	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: astore_2
    //   11: aload_1
    //   12: getstatic 355	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   15: bipush 90
    //   17: aload_3
    //   18: invokevirtual 361	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   21: pop
    //   22: aload_3
    //   23: ifnull +7 -> 30
    //   26: aload_3
    //   27: invokevirtual 364	java/io/FileOutputStream:close	()V
    //   30: return
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   36: return
    //   37: astore 4
    //   39: aconst_null
    //   40: astore_1
    //   41: aload_1
    //   42: astore_2
    //   43: aload 4
    //   45: invokevirtual 368	java/lang/Exception:printStackTrace	()V
    //   48: aload_1
    //   49: ifnull -19 -> 30
    //   52: aload_1
    //   53: invokevirtual 364	java/io/FileOutputStream:close	()V
    //   56: return
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   62: return
    //   63: astore_1
    //   64: aconst_null
    //   65: astore_2
    //   66: aload_2
    //   67: ifnull +7 -> 74
    //   70: aload_2
    //   71: invokevirtual 364	java/io/FileOutputStream:close	()V
    //   74: aload_1
    //   75: athrow
    //   76: astore_2
    //   77: aload_2
    //   78: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   81: goto -7 -> 74
    //   84: astore_1
    //   85: goto -19 -> 66
    //   88: astore 4
    //   90: aload_3
    //   91: astore_1
    //   92: goto -51 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	TabDragAnimationView
    //   0	95	1	paramBitmap	Bitmap
    //   0	95	2	paramString	String
    //   8	83	3	localFileOutputStream	java.io.FileOutputStream
    //   37	7	4	localException1	java.lang.Exception
    //   88	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   26	30	31	java/io/IOException
    //   0	9	37	java/lang/Exception
    //   52	56	57	java/io/IOException
    //   0	9	63	finally
    //   70	74	76	java/io/IOException
    //   11	22	84	finally
    //   43	48	84	finally
    //   11	22	88	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString += paramString;
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
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_b_of_type_AndroidAnimationValueAnimator.removeUpdateListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener);
    }
    this.jdField_d_of_type_Int = 1;
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
      Object localObject = Environment.getExternalStorageDirectory() + "/aaaa/";
      new File((String)localObject).mkdirs();
      paramCanvas = this.jdField_a_of_type_AndroidGraphicsBitmap;
      localObject = new StringBuilder().append((String)localObject);
      int i1 = this.n;
      this.n = (i1 + 1);
      a(paramCanvas, i1 + ".png");
    }
  }
  
  void e()
  {
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_b_of_type_AndroidAnimationValueAnimator.removeUpdateListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.a();
      this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
    }
  }
  
  void f()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
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
  
  public void onDraw(Canvas paramCanvas)
  {
    int i4 = getPaddingLeft();
    int i3 = getRight() - getLeft() - getPaddingRight();
    int i2 = getPaddingTop();
    int i1 = getBottom() - getTop() - getPaddingBottom();
    int i6;
    Drawable localDrawable2;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      i6 = (i3 + i4) / 2;
      i5 = (i1 + i2) / 2;
      i4 = i6 - this.jdField_b_of_type_Int / 2;
      i3 = i6 + this.jdField_b_of_type_Int / 2;
      i2 = i5 - this.jdField_c_of_type_Int / 2;
      i1 = this.jdField_c_of_type_Int / 2 + i5;
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
      if ((this.jdField_d_of_type_Int != 1) || (this.jdField_a_of_type_Boolean)) {
        break label659;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_b_of_type_Boolean)) && (this.jdField_d_of_type_Boolean))
      {
        localDrawable2 = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
        label208:
        if (((!this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_b_of_type_Boolean)) || (!this.jdField_d_of_type_Boolean)) {
          break label650;
        }
      }
      break;
    }
    Drawable localDrawable3;
    label650:
    for (Drawable localDrawable1 = a();; localDrawable1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_a_of_type_Float != 1.0F) {
        paramCanvas.scale(this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_a_of_type_Float, i6, i5);
      }
      if (localDrawable1 != null)
      {
        localDrawable1.setBounds(i4, i2, i3, i1);
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
          localDrawable2.setBounds(i4, i2, i3, i1);
          if (!a()) {
            localDrawable2.draw(paramCanvas);
          }
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16776961);
          localDrawable3 = localDrawable1;
        }
      }
      if ((a()) && (localDrawable3 != null))
      {
        this.jdField_e_of_type_AndroidGraphicsDrawableDrawable.setBounds(localDrawable3.getBounds());
        this.jdField_e_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      return;
      i6 = (i4 + i3) / 2;
      i5 = i2 + this.jdField_c_of_type_Int / 2;
      i4 = i6 - this.jdField_b_of_type_Int / 2;
      i3 = i6 + this.jdField_b_of_type_Int / 2;
      i1 = this.jdField_c_of_type_Int + i2;
      break;
      i6 = (i4 + i3) / 2;
      i5 = i1 - this.jdField_c_of_type_Int / 2;
      i4 = i6 - this.jdField_b_of_type_Int / 2;
      i3 = i6 + this.jdField_b_of_type_Int / 2;
      i2 = i1 - this.jdField_c_of_type_Int;
      break;
      i6 = i4 + this.jdField_b_of_type_Int / 2;
      i5 = (i1 + i2) / 2;
      i3 = i4 + this.jdField_b_of_type_Int;
      i2 = i5 - this.jdField_c_of_type_Int / 2;
      i1 = this.jdField_c_of_type_Int / 2 + i5;
      break;
      i6 = i3 - this.jdField_b_of_type_Int / 2;
      i5 = (i1 + i2) / 2;
      i4 = i3 - this.jdField_b_of_type_Int / 2;
      i2 = i5 - this.jdField_c_of_type_Int / 2;
      i1 = this.jdField_c_of_type_Int / 2 + i5;
      break;
      localDrawable2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      break label208;
    }
    label659:
    label672:
    label685:
    double d2;
    double d1;
    label777:
    label789:
    int i8;
    label810:
    label818:
    int i9;
    int i10;
    label846:
    int i7;
    if (this.jdField_d_of_type_Boolean)
    {
      localDrawable2 = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
      if (!this.jdField_d_of_type_Boolean) {
        break label1019;
      }
      localDrawable1 = a();
      if ((int)Math.sqrt(Math.pow(this.jdField_b_of_type_Int / 2 + Math.abs(this.jdField_c_of_type_Float), 2.0D) + Math.pow(this.jdField_c_of_type_Int / 2 + Math.abs(this.jdField_d_of_type_Float), 2.0D)) <= this.k) {
        break label1131;
      }
      if ((this.jdField_c_of_type_Float != 0.0F) && (this.jdField_d_of_type_Float != 0.0F)) {
        break label1057;
      }
      if (this.jdField_c_of_type_Float == 0.0F) {
        break label1028;
      }
      d2 = this.l;
      d1 = 0.0D;
      if (this.jdField_c_of_type_Float <= 0.0F) {
        break label1119;
      }
      i5 = 1;
      i8 = (int)(d2 * i5);
      if (this.jdField_d_of_type_Float <= 0.0F) {
        break label1125;
      }
      i5 = 1;
      i5 = (int)(d1 * i5);
      i9 = i8 * 2;
      i10 = i5 * 2;
      if (localDrawable1 != null)
      {
        if (!this.jdField_e_of_type_Boolean) {
          break label1148;
        }
        i6 = i4;
        if (!this.jdField_e_of_type_Boolean) {
          break label1158;
        }
        i7 = i2;
        label857:
        if (!this.jdField_e_of_type_Boolean) {
          break label1168;
        }
        i8 = i3;
        label868:
        if (!this.jdField_e_of_type_Boolean) {
          break label1178;
        }
      }
    }
    label1028:
    label1158:
    label1168:
    label1178:
    for (int i5 = i1;; i5 = i1 - i5)
    {
      localDrawable1.setBounds(i6, i7, i8, i5);
      if (!a()) {
        localDrawable1.draw(paramCanvas);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
      this.jdField_a_of_type_AndroidGraphicsRect.set(localDrawable1.getBounds());
      if ((localDrawable2 != null) && (this.jdField_b_of_type_Boolean))
      {
        paramCanvas.save();
        localDrawable2.setBounds(i4 - i9, i2 - i10, i3 - i9, i1 - i10);
        if (!a())
        {
          if (!this.jdField_d_of_type_Boolean) {}
          localDrawable2.draw(paramCanvas);
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16776961);
        paramCanvas.restore();
      }
      localDrawable3 = localDrawable1;
      break;
      localDrawable2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      break label672;
      label1019:
      localDrawable1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break label685;
      if (this.jdField_d_of_type_Float != 0.0F)
      {
        d2 = 0.0D;
        d1 = this.l;
        break label777;
      }
      d2 = 0.0D;
      d1 = 0.0D;
      break label777;
      label1057:
      d1 = Math.pow(this.jdField_d_of_type_Float, 2.0D) / Math.pow(this.jdField_c_of_type_Float, 2.0D);
      d2 = this.l * (1.0D / Math.sqrt(1.0D + d1));
      double d3 = this.l;
      d1 = Math.sqrt(d1 / (1.0D + d1)) * d3;
      break label777;
      label1119:
      i5 = -1;
      break label789;
      label1125:
      i5 = -1;
      break label810;
      label1131:
      i8 = (int)this.jdField_c_of_type_Float;
      i5 = (int)this.jdField_d_of_type_Float;
      break label818;
      label1148:
      i6 = i4 - i8;
      break label846;
      i7 = i2 - i5;
      break label857;
      i8 = i3 - i8;
      break label868;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = getPaddingLeft();
    int i5 = getPaddingRight();
    int i6 = this.jdField_h_of_type_Int;
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    int i3 = this.jdField_i_of_type_Int;
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
    if ((this.jdField_e_of_type_AndroidGraphicsDrawableDrawable != null) && ((this.jdField_e_of_type_AndroidGraphicsDrawableDrawable instanceof Animatable)) && (!((Animatable)this.jdField_e_of_type_AndroidGraphicsDrawableDrawable).isRunning())) {
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
    i7 = (i2 + (i3 - i4 - i5)) / 2;
    i2 = (int)Math.sqrt(Math.pow(this.jdField_b_of_type_Int / 2.0D, 2.0D) + Math.pow(this.jdField_c_of_type_Int / 2.0D, 2.0D));
    i3 = getWidth();
    i4 = getHeight();
    i5 = paramMotionEvent.getActionMasked();
    float f1;
    float f2;
    double d1;
    switch (i5)
    {
    default: 
      return false;
    case 3: 
      if (this.jdField_g_of_type_Boolean)
      {
        i6 = (int)(DeviceInfoUtil.j() - ViewUtils.a(14.0F));
        if (this.jdField_e_of_type_Float > i6)
        {
          this.jdField_a_of_type_Float = 0.0F;
          this.jdField_b_of_type_Float = 0.0F;
          this.jdField_e_of_type_Float = 0.0F;
          this.m = -1;
          this.jdField_f_of_type_Boolean = false;
          if (this.jdField_a_of_type_Boolean) {
            b();
          }
          return false;
        }
      }
    case 1: 
      this.m = -1;
      this.jdField_f_of_type_Boolean = false;
      if (this.jdField_a_of_type_Boolean) {
        b();
      }
      i6 = (int)Math.sqrt(Math.pow(this.jdField_a_of_type_Float - i1, 2.0D) + Math.pow(this.jdField_b_of_type_Float - i7, 2.0D)) + jdField_g_of_type_Int;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      d1 = Math.pow(f1 - i1, 2.0D);
      i7 = (int)Math.sqrt(Math.pow(f2 - i7, 2.0D) + d1);
      if (((i6 >= i2) || (i7 <= i2)) && (f1 > 0.0F) && (f1 < i3) && (f2 > 0.0F) && (f2 < i4)) {}
      for (i1 = 1;; i1 = 0)
      {
        if ((i1 == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$OnDragListener != null)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$OnDragListener.a();
        }
        if ((this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener == null) && (getParent() != null) && (i1 != 0))
        {
          ((ViewGroup)getParent()).performClick();
          if (QLog.isColorLevel())
          {
            float f3 = paramMotionEvent.getRawX();
            float f4 = paramMotionEvent.getRawY();
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "TabDragView perform click, action=" + i5 + ", ux=" + f1 + ", uy=" + f2 + ", urx=" + f3 + ", ury=" + f4 + ", w=" + i3 + ", vh=" + i4 + ", radius=" + i6 + ", innerRadius=" + i2 + ", upRidus=" + i7);
          }
        }
        return true;
      }
    case 0: 
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      this.jdField_e_of_type_Float = paramMotionEvent.getRawY();
      this.m = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
      d1 = Math.pow(this.jdField_a_of_type_Float - i1, 2.0D);
      if ((int)Math.sqrt(Math.pow(this.jdField_b_of_type_Float - i7, 2.0D) + d1) <= i2)
      {
        if (!this.jdField_d_of_type_Boolean) {
          break label746;
        }
        c();
      }
      for (;;)
      {
        return true;
        label746:
        if (this.jdField_i_of_type_Boolean) {
          d();
        }
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      i2 = paramMotionEvent.findPointerIndex(this.m);
      if (i2 == -1)
      {
        this.jdField_f_of_type_Boolean = false;
        return false;
      }
      f2 = paramMotionEvent.getX(i2);
      f1 = paramMotionEvent.getY(i2);
      d1 = Math.pow(f2 - i1, 2.0D);
      if (((int)Math.sqrt(Math.pow(f1 - i7, 2.0D) + d1) <= this.k) && ((f2 != this.jdField_a_of_type_Float) || (f1 != this.jdField_b_of_type_Float)))
      {
        f2 = this.jdField_a_of_type_Float - f2;
        f1 = this.jdField_b_of_type_Float - f1;
        this.jdField_f_of_type_Boolean = true;
      }
      for (;;)
      {
        if (this.jdField_f_of_type_Boolean)
        {
          e();
          a(f2, f1, false);
        }
        return this.jdField_f_of_type_Boolean;
        if (this.jdField_f_of_type_Boolean)
        {
          f2 = this.jdField_a_of_type_Float - f2;
          f1 = this.jdField_b_of_type_Float - f1;
        }
        else
        {
          f2 = 0.0F;
          f1 = 0.0F;
        }
      }
    }
    return false;
  }
  
  public void setAnimEnable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setBgDrawable(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setBgDrawable() called with: bgId = [" + paramInt + "]");
    }
    if (paramInt != -1)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt);
      invalidate();
    }
  }
  
  public void setBgPressedDrawable(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setBgPressedDrawable() called with: bgPressId = [" + paramInt + "]");
    }
    if (paramInt != -1)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt);
      invalidate();
    }
  }
  
  public void setClickAnimationDrawable(Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setClickAnimationDrawable() called with: drawable = [" + paramDrawable + "]");
    }
    Drawable localDrawable = this.jdField_e_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_e_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_e_of_type_AndroidGraphicsDrawableDrawable.setCallback(this);
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
    this.jdField_e_of_type_Int = paramInt5;
    this.jdField_f_of_type_Int = paramInt6;
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
    this.j = paramInt;
    if (paramInt != -1) {
      this.l = ((int)Math.sqrt(Math.pow(this.j, 2.0D) * 2.0D));
    }
  }
  
  public void setFaceDrawable(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setFaceDrawable() called with: faceId = [" + paramInt + "]");
    }
    if (paramInt != -1) {}
    for (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt);; this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null)
    {
      invalidate();
      return;
    }
  }
  
  public void setFacePressedDrawable(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setFacePressedDrawable() called with: facePressId = [" + paramInt + "]");
    }
    if (paramInt != -1) {}
    for (this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt);; this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = null)
    {
      invalidate();
      return;
    }
  }
  
  public void setIconGravity(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 3) || (paramInt == 4) || (paramInt == 1) || (paramInt == 2))
    {
      this.jdField_a_of_type_Int = paramInt;
      invalidate();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(this.jdField_a_of_type_JavaLangString, 2, "unsupported gravity=" + paramInt);
  }
  
  public void setIconSize(int paramInt1, int paramInt2)
  {
    Drawable localDrawable;
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView$ScaleAnimUpdateListener.jdField_b_of_type_Boolean)) && (this.jdField_d_of_type_Boolean))
    {
      localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      if (paramInt2 < 0) {
        break label113;
      }
      this.jdField_i_of_type_Int = paramInt2;
      label41:
      if (paramInt1 < 0) {
        break label128;
      }
      this.jdField_h_of_type_Int = paramInt1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setIconSize, mExpectedLogoWidth=" + this.jdField_h_of_type_Int + ", mExpectedLogoHeight=" + this.jdField_i_of_type_Int);
      }
      requestLayout();
      return;
      localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break;
      label113:
      if (localDrawable == null) {
        break label41;
      }
      this.jdField_i_of_type_Int = localDrawable.getIntrinsicHeight();
      break label41;
      label128:
      if (localDrawable != null) {
        this.jdField_h_of_type_Int = localDrawable.getIntrinsicWidth();
      }
    }
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
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setPressChanged() called with: enable = [" + paramBoolean + "]");
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable == a()))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localDrawable instanceof ApngDrawable)) {
        ((ApngDrawable)localDrawable).repaly();
      }
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabDragAnimationView
 * JD-Core Version:    0.7.0.1
 */