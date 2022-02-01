package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Path.Op;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.Arrays;

public class BubbleImageView
  extends ChatThumbView
{
  public static final float[] a;
  protected static boolean f;
  public float a;
  public int a;
  protected Resources a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  BitmapShader jdField_a_of_type_AndroidGraphicsBitmapShader;
  Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  ComposeShader jdField_a_of_type_AndroidGraphicsComposeShader;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Path jdField_a_of_type_AndroidGraphicsPath;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  Shader jdField_a_of_type_AndroidGraphicsShader;
  private float jdField_b_of_type_Float = 14.0F;
  private int jdField_b_of_type_Int = 1610612736;
  Paint jdField_b_of_type_AndroidGraphicsPaint;
  Path jdField_b_of_type_AndroidGraphicsPath;
  RectF jdField_b_of_type_AndroidGraphicsRectF;
  float[] jdField_b_of_type_ArrayOfFloat;
  private float jdField_c_of_type_Float = 8.0F;
  private int jdField_c_of_type_Int = (int)(Math.random() * 1000.0D);
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  Path jdField_c_of_type_AndroidGraphicsPath;
  RectF jdField_c_of_type_AndroidGraphicsRectF;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float;
  private Paint jdField_d_of_type_AndroidGraphicsPaint;
  private Path jdField_d_of_type_AndroidGraphicsPath;
  public boolean d;
  private float e;
  public boolean e;
  private float f;
  private float g;
  protected boolean g;
  private float h;
  protected boolean h;
  private float jdField_i_of_type_Float = 16.0F;
  private boolean jdField_i_of_type_Boolean;
  private float jdField_j_of_type_Float = 1.0F;
  private boolean jdField_j_of_type_Boolean;
  private float k = 14.0F;
  private float l;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { 7.0F, 9.0F, 0.0F, 6.0F, 2.5F, 9.0F, 5.5F, 15.0F, 0.5F, 13.0F };
    String str = Build.MODEL.toUpperCase();
    if ((str.contains("BV0720")) || (str.contains("M821")) || ((Build.VERSION.SDK_INT == 21) && ((str.contains("NX511J")) || (str.contains("MI 5")) || (str.contains("GT-I9508")) || (str.contains("X9077")) || (str.contains("COOLPAD 8675-A"))))) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_f_of_type_Boolean = bool;
      return;
    }
  }
  
  public BubbleImageView(Context paramContext)
  {
    super(paramContext);
    this.jdField_e_of_type_Float = 5.0F;
    this.jdField_f_of_type_Float = 4.0F;
    this.jdField_g_of_type_Float = 10.0F;
    this.jdField_h_of_type_Float = 10.0F;
    this.jdField_a_of_type_Float = Math.abs(this.jdField_d_of_type_Float - this.jdField_h_of_type_Float);
    b();
  }
  
  public BubbleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_e_of_type_Float = 5.0F;
    this.jdField_f_of_type_Float = 4.0F;
    this.jdField_g_of_type_Float = 10.0F;
    this.jdField_h_of_type_Float = 10.0F;
    this.jdField_a_of_type_Float = Math.abs(this.jdField_d_of_type_Float - this.jdField_h_of_type_Float);
    b();
  }
  
  public BubbleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_e_of_type_Float = 5.0F;
    this.jdField_f_of_type_Float = 4.0F;
    this.jdField_g_of_type_Float = 10.0F;
    this.jdField_h_of_type_Float = 10.0F;
    this.jdField_a_of_type_Float = Math.abs(this.jdField_d_of_type_Float - this.jdField_h_of_type_Float);
    b();
  }
  
  public static int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void b(Canvas paramCanvas)
  {
    int m = paramCanvas.getSaveCount();
    paramCanvas.save();
    super.draw(paramCanvas);
    if (this.jdField_i_of_type_Boolean)
    {
      if (this.jdField_c_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_c_of_type_AndroidGraphicsPaint.setShader(a());
      }
      paramCanvas.drawPaint(this.jdField_c_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_j_of_type_Boolean) {
      paramCanvas.drawColor(this.jdField_b_of_type_Int);
    }
    a(paramCanvas);
    if ((this.jdField_d_of_type_AndroidGraphicsPaint != null) && (this.jdField_d_of_type_AndroidGraphicsPath != null)) {
      paramCanvas.drawPath(this.jdField_d_of_type_AndroidGraphicsPath, this.jdField_d_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.restoreToCount(m);
  }
  
  private void c(Canvas paramCanvas)
  {
    int m = getWidth();
    int n = getHeight();
    if ((m <= 0) || (n <= 0))
    {
      super.draw(paramCanvas);
      return;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && ((this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() != m) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() != n)))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidGraphicsRectF.setEmpty();
      this.jdField_a_of_type_AndroidGraphicsPath = null;
      this.jdField_b_of_type_AndroidGraphicsRectF.setEmpty();
      this.jdField_b_of_type_AndroidGraphicsPath = null;
      this.jdField_a_of_type_AndroidGraphicsShader = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
      if (this.jdField_a_of_type_AndroidGraphicsCanvas != null) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        super.draw(paramCanvas);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_4444);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          URLDrawable.clearMemoryCache();
          try
          {
            this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_4444);
          }
          catch (OutOfMemoryError localOutOfMemoryError3) {}
        }
      }
      if (this.jdField_a_of_type_AndroidGraphicsCanvas == null)
      {
        this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmapShader == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmapShader = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      }
      if (!this.jdField_i_of_type_Boolean) {
        break label337;
      }
    }
    if (this.jdField_a_of_type_AndroidGraphicsComposeShader == null)
    {
      Shader localShader = a();
      if (localShader != null) {
        this.jdField_a_of_type_AndroidGraphicsComposeShader = new ComposeShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader, localShader, PorterDuff.Mode.SRC_OVER);
      }
    }
    label337:
    for (this.jdField_a_of_type_AndroidGraphicsShader = this.jdField_a_of_type_AndroidGraphicsComposeShader;; this.jdField_a_of_type_AndroidGraphicsShader = this.jdField_a_of_type_AndroidGraphicsBitmapShader)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsShader);
      super.draw(this.jdField_a_of_type_AndroidGraphicsCanvas);
      if (this.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(this.jdField_b_of_type_Int);
      }
      d(paramCanvas);
      return;
    }
  }
  
  private void d(Canvas paramCanvas)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentResResources;
    int m = getWidth();
    int n = getHeight();
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, m, n);
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.l, this.l, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    label498:
    do
    {
      return;
      float f1;
      Path localPath;
      float f2;
      if (this.jdField_d_of_type_Boolean)
      {
        if (this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty())
        {
          f1 = a(this.jdField_a_of_type_Float, localResources);
          this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, m - f1, n);
        }
        if (this.jdField_a_of_type_AndroidGraphicsPath == null)
        {
          f1 = a(this.jdField_e_of_type_Float, localResources);
          localPath = new Path();
          localPath.moveTo(m - a(this.jdField_b_of_type_Float, localResources), a(this.jdField_c_of_type_Float, localResources));
          f2 = m;
          localPath.quadTo(m - a(this.jdField_f_of_type_Float, localResources), a(this.jdField_g_of_type_Float, localResources), f2, f1);
          f1 = m - a(this.jdField_h_of_type_Float, localResources);
          f2 = a(this.jdField_i_of_type_Float, localResources);
          localPath.quadTo(m - a(this.jdField_j_of_type_Float, localResources), a(this.k, localResources), f1, f2);
          localPath.close();
          this.jdField_a_of_type_AndroidGraphicsPath = localPath;
        }
      }
      for (;;)
      {
        if (!this.jdField_d_of_type_Boolean) {
          break label498;
        }
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.l, this.l, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        if (this.jdField_d_of_type_AndroidGraphicsPaint == null) {
          break;
        }
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_d_of_type_AndroidGraphicsPaint);
        return;
        if (this.jdField_b_of_type_AndroidGraphicsRectF.isEmpty())
        {
          f1 = a(this.jdField_a_of_type_Float, localResources);
          this.jdField_b_of_type_AndroidGraphicsRectF.set(f1, 0.0F, m, n);
        }
        if (this.jdField_b_of_type_AndroidGraphicsPath == null)
        {
          f1 = a(this.jdField_e_of_type_Float, localResources);
          localPath = new Path();
          localPath.moveTo(a(this.jdField_b_of_type_Float, localResources), a(this.jdField_c_of_type_Float, localResources));
          localPath.quadTo(a(this.jdField_f_of_type_Float, localResources), a(this.jdField_g_of_type_Float, localResources), 0.0F, f1);
          f1 = a(this.jdField_h_of_type_Float, localResources);
          f2 = a(this.jdField_i_of_type_Float, localResources);
          localPath.quadTo(a(this.jdField_j_of_type_Float, localResources), a(this.k, localResources), f1, f2);
          localPath.close();
          this.jdField_b_of_type_AndroidGraphicsPath = localPath;
        }
      }
      paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, this.l, this.l, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    } while (this.jdField_d_of_type_AndroidGraphicsPaint == null);
    paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_d_of_type_AndroidGraphicsPaint);
  }
  
  public Shader a()
  {
    return null;
  }
  
  protected void a() {}
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramFloat1, paramFloat2);
      this.jdField_c_of_type_AndroidGraphicsPath.reset();
      this.jdField_c_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CW);
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_c_of_type_AndroidGraphicsPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
      }
      if (this.jdField_d_of_type_AndroidGraphicsPath != null)
      {
        this.jdField_d_of_type_AndroidGraphicsPath.reset();
        this.jdField_d_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CW);
      }
    }
    Resources localResources;
    float f1;
    float f10;
    Path localPath1;
    Path localPath2;
    float f9;
    float f8;
    float f5;
    float f7;
    float f6;
    float f2;
    float f4;
    float f3;
    Path localPath3;
    label408:
    do
    {
      return;
      localResources = this.jdField_a_of_type_AndroidContentResResources;
      f1 = a(this.jdField_a_of_type_Float, localResources);
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      this.jdField_c_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramFloat1 - f1, paramFloat2);
      this.jdField_c_of_type_AndroidGraphicsPath.reset();
      f10 = a(this.jdField_e_of_type_Float, localResources);
      if (!this.jdField_d_of_type_Boolean) {
        break label918;
      }
      if (!this.jdField_g_of_type_Boolean) {
        break label740;
      }
      localPath1 = new Path();
      localPath1.addRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CW);
      localPath1.setFillType(Path.FillType.EVEN_ODD);
      localPath2 = new Path();
      f9 = paramFloat1 - a(this.jdField_b_of_type_Float, localResources);
      f8 = a(this.jdField_c_of_type_Float, localResources);
      localPath2.moveTo(f9, f8);
      f5 = paramFloat1 - a(this.jdField_d_of_type_Float, localResources);
      f7 = paramFloat1 - a(this.jdField_f_of_type_Float, localResources);
      f6 = a(this.jdField_g_of_type_Float, localResources);
      localPath2.quadTo(f7, f6, f5, f10);
      f2 = paramFloat1 - a(this.jdField_h_of_type_Float, localResources);
      f1 = a(this.jdField_i_of_type_Float, localResources);
      f4 = paramFloat1 - a(this.jdField_j_of_type_Float, localResources);
      f3 = a(this.k, localResources);
      localPath2.quadTo(f4, f3, f2, f1);
      localPath2.setFillType(Path.FillType.EVEN_ODD);
      localPath3 = new Path();
      if (Build.VERSION.SDK_INT >= 19) {
        localPath3.op(localPath1, localPath2, Path.Op.UNION);
      }
      localPath3.setFillType(Path.FillType.INVERSE_EVEN_ODD);
      this.jdField_c_of_type_AndroidGraphicsPath = localPath3;
      this.jdField_c_of_type_AndroidGraphicsPath.close();
    } while (this.jdField_d_of_type_AndroidGraphicsPath == null);
    this.jdField_d_of_type_AndroidGraphicsPath.reset();
    float f11 = 2.0F * this.l;
    if (this.jdField_d_of_type_Boolean)
    {
      paramFloat1 = (float)(Math.asin(a(this.jdField_i_of_type_Float - this.jdField_c_of_type_Float, localResources) / this.jdField_b_of_type_ArrayOfFloat[2]) * 180.0D / 3.141592653589793D);
      this.jdField_d_of_type_AndroidGraphicsPath.moveTo(f2, f1);
      this.jdField_d_of_type_AndroidGraphicsPath.lineTo(f2, paramFloat2 - this.l);
      this.jdField_c_of_type_AndroidGraphicsRectF.set(f2 - f11, paramFloat2 - f11, f2, paramFloat2);
      this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, 0.0F, 90.0F);
      this.jdField_d_of_type_AndroidGraphicsPath.lineTo(0.0F + this.l, paramFloat2);
      this.jdField_c_of_type_AndroidGraphicsRectF.set(0.0F, paramFloat2 - f11, f11, paramFloat2);
      this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, 90.0F, 90.0F);
      this.jdField_d_of_type_AndroidGraphicsPath.lineTo(0.0F, this.l);
      this.jdField_c_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, f11, f11);
      this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, 180.0F, 90.0F);
      this.jdField_d_of_type_AndroidGraphicsPath.lineTo(f2 - this.l, 0.0F);
      this.jdField_c_of_type_AndroidGraphicsRectF.set(f2 - f11, 0.0F, f2, f11);
      this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, 270.0F, 90.0F - paramFloat1);
      this.jdField_d_of_type_AndroidGraphicsPath.lineTo(f9, f8);
      this.jdField_d_of_type_AndroidGraphicsPath.quadTo(f7, f6, f5, f10);
      this.jdField_d_of_type_AndroidGraphicsPath.quadTo(f4, f3, f2, f1);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidGraphicsPath.close();
      return;
      this.jdField_c_of_type_AndroidGraphicsRectF.set(f1, 0.0F, paramFloat1, paramFloat2);
      break;
      label740:
      this.jdField_c_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CW);
      f9 = paramFloat1 - a(this.jdField_b_of_type_Float, localResources);
      f8 = a(this.jdField_c_of_type_Float, localResources);
      this.jdField_c_of_type_AndroidGraphicsPath.moveTo(f9, f8);
      f5 = paramFloat1 - a(this.jdField_d_of_type_Float, localResources);
      f7 = paramFloat1 - a(this.jdField_f_of_type_Float, localResources);
      f6 = a(this.jdField_g_of_type_Float, localResources);
      this.jdField_c_of_type_AndroidGraphicsPath.quadTo(f7, f6, f5, f10);
      f2 = paramFloat1 - a(this.jdField_h_of_type_Float, localResources);
      f1 = a(this.jdField_i_of_type_Float, localResources);
      f4 = paramFloat1 - a(this.jdField_j_of_type_Float, localResources);
      f3 = a(this.k, localResources);
      this.jdField_c_of_type_AndroidGraphicsPath.quadTo(f4, f3, f2, f1);
      break label408;
      label918:
      if (this.jdField_g_of_type_Boolean)
      {
        localPath1 = new Path();
        localPath1.addRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CW);
        localPath1.setFillType(Path.FillType.EVEN_ODD);
        localPath2 = new Path();
        f9 = a(this.jdField_b_of_type_Float, localResources);
        f8 = a(this.jdField_c_of_type_Float, localResources);
        localPath2.moveTo(f9, f8);
        f5 = this.jdField_d_of_type_Float;
        f7 = a(this.jdField_f_of_type_Float, localResources);
        f6 = a(this.jdField_g_of_type_Float, localResources);
        localPath2.quadTo(f7, f6, f5, f10);
        f2 = a(this.jdField_h_of_type_Float, localResources);
        f1 = a(this.jdField_i_of_type_Float, localResources);
        f4 = a(this.jdField_j_of_type_Float, localResources);
        f3 = a(this.k, localResources);
        localPath2.quadTo(f4, f3, f2, f1);
        localPath3 = new Path();
        if (Build.VERSION.SDK_INT >= 19) {
          localPath3.op(localPath1, localPath2, Path.Op.UNION);
        }
        localPath3.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        this.jdField_c_of_type_AndroidGraphicsPath = localPath3;
        break label408;
      }
      this.jdField_c_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CCW);
      f9 = a(this.jdField_b_of_type_Float, localResources);
      f8 = a(this.jdField_c_of_type_Float, localResources);
      this.jdField_c_of_type_AndroidGraphicsPath.moveTo(f9, f8);
      f5 = this.jdField_d_of_type_Float;
      f7 = a(this.jdField_f_of_type_Float, localResources);
      f6 = a(this.jdField_g_of_type_Float, localResources);
      this.jdField_c_of_type_AndroidGraphicsPath.quadTo(f7, f6, f5, f10);
      f2 = a(this.jdField_h_of_type_Float, localResources);
      f1 = a(this.jdField_i_of_type_Float, localResources);
      f4 = a(this.jdField_j_of_type_Float, localResources);
      f3 = a(this.k, localResources);
      this.jdField_c_of_type_AndroidGraphicsPath.quadTo(f4, f3, f2, f1);
      break label408;
      float f12 = (float)(Math.asin(a(this.jdField_i_of_type_Float - this.jdField_c_of_type_Float, localResources) / this.jdField_b_of_type_ArrayOfFloat[0]) * 180.0D / 3.141592653589793D);
      this.jdField_d_of_type_AndroidGraphicsPath.moveTo(f9, f8);
      this.jdField_c_of_type_AndroidGraphicsRectF.set(f2, 0.0F, f2 + f11, f11);
      this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, 180.0F + f12, 90.0F - f12);
      this.jdField_d_of_type_AndroidGraphicsPath.lineTo(paramFloat1 - this.l, 0.0F);
      this.jdField_c_of_type_AndroidGraphicsRectF.set(paramFloat1 - f11, 0.0F, paramFloat1, f11);
      this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, 270.0F, 90.0F);
      this.jdField_d_of_type_AndroidGraphicsPath.lineTo(paramFloat1, paramFloat2 - this.l);
      this.jdField_c_of_type_AndroidGraphicsRectF.set(paramFloat1 - f11, paramFloat2 - f11, paramFloat1, paramFloat2);
      this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, 0.0F, 90.0F);
      this.jdField_d_of_type_AndroidGraphicsPath.lineTo(this.l + f2, paramFloat2);
      this.jdField_c_of_type_AndroidGraphicsRectF.set(f2, paramFloat2 - f11, f11 + f2, paramFloat2);
      this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, 90.0F, 90.0F);
      this.jdField_d_of_type_AndroidGraphicsPath.lineTo(f2, this.l);
      this.jdField_d_of_type_AndroidGraphicsPath.lineTo(f2, f1);
      this.jdField_d_of_type_AndroidGraphicsPath.quadTo(f4, f3, f5, f10);
      this.jdField_d_of_type_AndroidGraphicsPath.quadTo(f7, f6, f9, f8);
    }
  }
  
  public void a(int paramInt)
  {
    setSharpCornerCor(jdField_a_of_type_ArrayOfFloat);
    if ((this.jdField_d_of_type_AndroidGraphicsPaint == null) || (this.jdField_d_of_type_AndroidGraphicsPath == null))
    {
      this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_d_of_type_AndroidGraphicsPaint.setColor(paramInt);
      this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(Math.max(1, a(0.5F, getResources())));
      this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_d_of_type_AndroidGraphicsPath = new Path();
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.drawPath(this.jdField_c_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  protected void b()
  {
    this.jdField_e_of_type_Boolean = jdField_f_of_type_Boolean;
    if (VersionUtils.isHoneycomb())
    {
      this.jdField_a_of_type_Int = 1;
      a();
      this.jdField_a_of_type_AndroidContentResResources = getResources();
      if (this.jdField_a_of_type_Int != 1) {
        break label142;
      }
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-16777216);
      this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.jdField_c_of_type_AndroidGraphicsPath = new Path();
      this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_b_of_type_ArrayOfFloat = new float[8];
    }
    label142:
    while (this.jdField_a_of_type_Int != 2)
    {
      return;
      this.jdField_a_of_type_Int = 2;
      break;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_c_of_type_AndroidGraphicsPath = new Path();
    this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_ArrayOfFloat = new float[8];
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_i_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_j_of_type_Boolean != paramBoolean)
    {
      this.jdField_j_of_type_Boolean = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean != paramBoolean)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    long l1 = System.currentTimeMillis();
    if (this.jdField_h_of_type_Boolean) {
      super.draw(paramCanvas);
    }
    for (;;)
    {
      l1 = System.currentTimeMillis() - l1;
      boolean bool = false;
      if (VersionUtils.isHoneycomb()) {
        bool = paramCanvas.isHardwareAccelerated();
      }
      if ((QLog.isColorLevel()) && (l1 > 10L)) {
        QLog.w("BubbleImageView" + this.jdField_c_of_type_Int, 2, "draw(): isHardwaveAccelerated= " + bool + ", drawMode = " + this.jdField_a_of_type_Int + ", cost =" + l1);
      }
      return;
      if (this.jdField_a_of_type_Int == 1) {
        b(paramCanvas);
      } else if (this.jdField_a_of_type_Int == 2) {
        c(paramCanvas);
      } else {
        super.draw(paramCanvas);
      }
    }
  }
  
  public void invalidate()
  {
    super.invalidate();
  }
  
  @TargetApi(11)
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_e_of_type_Boolean) {
      setLayerType(1, null);
    }
    while ((this.jdField_a_of_type_Int != 1) || (!VersionUtils.isHoneycomb())) {
      return;
    }
    setLayerType(2, null);
  }
  
  @TargetApi(11)
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_Int == 1) && (VersionUtils.isHoneycomb())) {
      setLayerType(0, null);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.jdField_a_of_type_Int == 1)) {
      a(getWidth(), getHeight());
    }
  }
  
  public void setColorMask(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setRadius(float paramFloat)
  {
    this.l = a(paramFloat, this.jdField_a_of_type_AndroidContentResResources);
    if (this.jdField_b_of_type_ArrayOfFloat != null) {
      Arrays.fill(this.jdField_b_of_type_ArrayOfFloat, this.l);
    }
  }
  
  public void setRadiusBottom(float paramFloat)
  {
    this.l = a(paramFloat, this.jdField_a_of_type_AndroidContentResResources);
    if (this.jdField_b_of_type_ArrayOfFloat != null)
    {
      Arrays.fill(this.jdField_b_of_type_ArrayOfFloat, 0, 4, 0.0F);
      Arrays.fill(this.jdField_b_of_type_ArrayOfFloat, 4, 8, this.l);
    }
  }
  
  public void setRadiusTop(float paramFloat)
  {
    this.l = a(paramFloat, this.jdField_a_of_type_AndroidContentResResources);
    if (this.jdField_b_of_type_ArrayOfFloat != null)
    {
      Arrays.fill(this.jdField_b_of_type_ArrayOfFloat, 0, 4, this.l);
      Arrays.fill(this.jdField_b_of_type_ArrayOfFloat, 4, 8, 0.0F);
    }
  }
  
  public void setSend(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean)
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      if ((getWidth() != 0) && (getHeight() != 0)) {
        a(getWidth(), getHeight());
      }
    }
  }
  
  public void setSharpCornerCor(float[] paramArrayOfFloat)
  {
    this.jdField_b_of_type_Float = paramArrayOfFloat[0];
    this.jdField_c_of_type_Float = paramArrayOfFloat[1];
    this.jdField_d_of_type_Float = paramArrayOfFloat[2];
    this.jdField_e_of_type_Float = paramArrayOfFloat[3];
    this.jdField_f_of_type_Float = paramArrayOfFloat[4];
    this.jdField_g_of_type_Float = paramArrayOfFloat[5];
    this.jdField_h_of_type_Float = paramArrayOfFloat[6];
    this.jdField_i_of_type_Float = paramArrayOfFloat[7];
    this.jdField_j_of_type_Float = paramArrayOfFloat[8];
    this.k = paramArrayOfFloat[9];
    this.jdField_a_of_type_Float = Math.abs(this.jdField_d_of_type_Float - this.jdField_h_of_type_Float);
  }
  
  public void setShowEdge(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(Color.parseColor("#14000000"));
      return;
    }
    this.jdField_d_of_type_AndroidGraphicsPaint = null;
    this.jdField_d_of_type_AndroidGraphicsPath = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BubbleImageView
 * JD-Core Version:    0.7.0.1
 */