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
  private float jdField_d_of_type_Float = 0.0F;
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
  private boolean jdField_i_of_type_Boolean = false;
  private float jdField_j_of_type_Float = 1.0F;
  private boolean jdField_j_of_type_Boolean = false;
  private float k = 14.0F;
  private float l;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { 7.0F, 9.0F, 0.0F, 6.0F, 2.5F, 9.0F, 5.5F, 15.0F, 0.5F, 13.0F };
    String str = Build.MODEL.toUpperCase();
    boolean bool;
    if ((!str.contains("BV0720")) && (!str.contains("M821")) && ((Build.VERSION.SDK_INT != 21) || ((!str.contains("NX511J")) && (!str.contains("MI 5")) && (!str.contains("GT-I9508")) && (!str.contains("X9077")) && (!str.contains("COOLPAD 8675-A"))))) {
      bool = false;
    } else {
      bool = true;
    }
    jdField_f_of_type_Boolean = bool;
  }
  
  public BubbleImageView(Context paramContext)
  {
    super(paramContext);
    this.jdField_e_of_type_Float = 5.0F;
    this.jdField_f_of_type_Float = 4.0F;
    this.jdField_g_of_type_Float = 10.0F;
    this.jdField_h_of_type_Float = 10.0F;
    this.jdField_a_of_type_Float = Math.abs(this.jdField_d_of_type_Float - this.jdField_h_of_type_Float);
    this.jdField_g_of_type_Boolean = false;
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
    this.jdField_g_of_type_Boolean = false;
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
    this.jdField_g_of_type_Boolean = false;
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
    Paint localPaint = this.jdField_d_of_type_AndroidGraphicsPaint;
    if (localPaint != null)
    {
      Path localPath = this.jdField_d_of_type_AndroidGraphicsPath;
      if (localPath != null) {
        paramCanvas.drawPath(localPath, localPaint);
      }
    }
    paramCanvas.restoreToCount(m);
  }
  
  private void c(Canvas paramCanvas)
  {
    int m = getWidth();
    int n = getHeight();
    if ((m > 0) && (n > 0))
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((localObject != null) && ((((Bitmap)localObject).getWidth() != m) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() != n)))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        this.jdField_a_of_type_AndroidGraphicsRectF.setEmpty();
        this.jdField_a_of_type_AndroidGraphicsPath = null;
        this.jdField_b_of_type_AndroidGraphicsRectF.setEmpty();
        this.jdField_b_of_type_AndroidGraphicsPath = null;
        this.jdField_a_of_type_AndroidGraphicsShader = null;
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {}
    }
    label141:
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      label108:
      label123:
      break label108;
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_4444);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      break label123;
    }
    URLDrawable.clearMemoryCache();
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_4444);
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      break label141;
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsCanvas;
    if (localObject != null) {
      ((Canvas)localObject).setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject == null)
    {
      super.draw(paramCanvas);
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsCanvas == null)
    {
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas((Bitmap)localObject);
      this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmapShader == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmapShader = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }
    if (this.jdField_i_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsComposeShader == null)
      {
        localObject = a();
        if (localObject != null) {
          this.jdField_a_of_type_AndroidGraphicsComposeShader = new ComposeShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader, (Shader)localObject, PorterDuff.Mode.SRC_OVER);
        }
      }
      this.jdField_a_of_type_AndroidGraphicsShader = this.jdField_a_of_type_AndroidGraphicsComposeShader;
    }
    else
    {
      this.jdField_a_of_type_AndroidGraphicsShader = this.jdField_a_of_type_AndroidGraphicsBitmapShader;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsShader);
    super.draw(this.jdField_a_of_type_AndroidGraphicsCanvas);
    if (this.jdField_j_of_type_Boolean) {
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(this.jdField_b_of_type_Int);
    }
    d(paramCanvas);
    return;
    super.draw(paramCanvas);
  }
  
  private void d(Canvas paramCanvas)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentResResources;
    int m = getWidth();
    int n = getHeight();
    float f1;
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, m, n);
      localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
      f1 = this.l;
      paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    Path localPath;
    float f2;
    if (this.jdField_d_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty())
      {
        f1 = a(this.jdField_a_of_type_Float, (Resources)localObject);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, m - f1, n);
      }
      if (this.jdField_a_of_type_AndroidGraphicsPath == null)
      {
        f1 = a(this.jdField_e_of_type_Float, (Resources)localObject);
        localPath = new Path();
        localPath.moveTo(m - a(this.jdField_b_of_type_Float, (Resources)localObject), a(this.jdField_c_of_type_Float, (Resources)localObject));
        f2 = m;
        localPath.quadTo(m - a(this.jdField_f_of_type_Float, (Resources)localObject), a(this.jdField_g_of_type_Float, (Resources)localObject), f2, f1);
        f1 = m - a(this.jdField_h_of_type_Float, (Resources)localObject);
        f2 = a(this.jdField_i_of_type_Float, (Resources)localObject);
        localPath.quadTo(m - a(this.jdField_j_of_type_Float, (Resources)localObject), a(this.k, (Resources)localObject), f1, f2);
        localPath.close();
        this.jdField_a_of_type_AndroidGraphicsPath = localPath;
      }
    }
    else
    {
      if (this.jdField_b_of_type_AndroidGraphicsRectF.isEmpty())
      {
        f1 = a(this.jdField_a_of_type_Float, (Resources)localObject);
        this.jdField_b_of_type_AndroidGraphicsRectF.set(f1, 0.0F, m, n);
      }
      if (this.jdField_b_of_type_AndroidGraphicsPath == null)
      {
        f1 = a(this.jdField_e_of_type_Float, (Resources)localObject);
        localPath = new Path();
        localPath.moveTo(a(this.jdField_b_of_type_Float, (Resources)localObject), a(this.jdField_c_of_type_Float, (Resources)localObject));
        localPath.quadTo(a(this.jdField_f_of_type_Float, (Resources)localObject), a(this.jdField_g_of_type_Float, (Resources)localObject), 0.0F, f1);
        f1 = a(this.jdField_h_of_type_Float, (Resources)localObject);
        f2 = a(this.jdField_i_of_type_Float, (Resources)localObject);
        localPath.quadTo(a(this.jdField_j_of_type_Float, (Resources)localObject), a(this.k, (Resources)localObject), f1, f2);
        localPath.close();
        this.jdField_b_of_type_AndroidGraphicsPath = localPath;
      }
    }
    if (this.jdField_d_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
      f1 = this.l;
      paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      localObject = this.jdField_d_of_type_AndroidGraphicsPaint;
      if (localObject != null) {
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, (Paint)localObject);
      }
    }
    else
    {
      localObject = this.jdField_b_of_type_AndroidGraphicsRectF;
      f1 = this.l;
      paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      localObject = this.jdField_d_of_type_AndroidGraphicsPaint;
      if (localObject != null) {
        paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, (Paint)localObject);
      }
    }
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
      localObject = this.jdField_d_of_type_AndroidGraphicsPath;
      if (localObject != null)
      {
        ((Path)localObject).reset();
        this.jdField_d_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CW);
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidContentResResources;
    float f1 = a(this.jdField_a_of_type_Float, (Resources)localObject);
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_c_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramFloat1 - f1, paramFloat2);
    } else {
      this.jdField_c_of_type_AndroidGraphicsRectF.set(f1, 0.0F, paramFloat1, paramFloat2);
    }
    this.jdField_c_of_type_AndroidGraphicsPath.reset();
    float f11 = a(this.jdField_e_of_type_Float, (Resources)localObject);
    Path localPath2;
    Path localPath3;
    int m;
    if (this.jdField_d_of_type_Boolean)
    {
      if (this.jdField_g_of_type_Boolean)
      {
        localPath1 = new Path();
        localPath1.addRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CW);
        localPath1.setFillType(Path.FillType.EVEN_ODD);
        localPath2 = new Path();
        f1 = paramFloat1 - a(this.jdField_b_of_type_Float, (Resources)localObject);
        f4 = a(this.jdField_c_of_type_Float, (Resources)localObject);
        localPath2.moveTo(f1, f4);
        f5 = paramFloat1 - a(this.jdField_d_of_type_Float, (Resources)localObject);
        f7 = paramFloat1 - a(this.jdField_f_of_type_Float, (Resources)localObject);
        f9 = a(this.jdField_g_of_type_Float, (Resources)localObject);
        localPath2.quadTo(f7, f9, f5, f11);
        f8 = paramFloat1 - a(this.jdField_h_of_type_Float, (Resources)localObject);
        f6 = a(this.jdField_i_of_type_Float, (Resources)localObject);
        f3 = paramFloat1 - a(this.jdField_j_of_type_Float, (Resources)localObject);
        f2 = a(this.k, (Resources)localObject);
        localPath2.quadTo(f3, f2, f8, f6);
        localPath2.setFillType(Path.FillType.EVEN_ODD);
        localPath3 = new Path();
        m = Build.VERSION.SDK_INT;
        if (m >= 19) {
          localPath3.op(localPath1, localPath2, Path.Op.UNION);
        }
        localPath3.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        this.jdField_c_of_type_AndroidGraphicsPath = localPath3;
      }
      else
      {
        this.jdField_c_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CW);
        f3 = paramFloat1 - a(this.jdField_b_of_type_Float, (Resources)localObject);
        f4 = a(this.jdField_c_of_type_Float, (Resources)localObject);
        this.jdField_c_of_type_AndroidGraphicsPath.moveTo(f3, f4);
        f5 = paramFloat1 - a(this.jdField_d_of_type_Float, (Resources)localObject);
        f7 = paramFloat1 - a(this.jdField_f_of_type_Float, (Resources)localObject);
        f9 = a(this.jdField_g_of_type_Float, (Resources)localObject);
        this.jdField_c_of_type_AndroidGraphicsPath.quadTo(f7, f9, f5, f11);
        f8 = paramFloat1 - a(this.jdField_h_of_type_Float, (Resources)localObject);
        f6 = a(this.jdField_i_of_type_Float, (Resources)localObject);
        f1 = paramFloat1 - a(this.jdField_j_of_type_Float, (Resources)localObject);
        f2 = a(this.k, (Resources)localObject);
        this.jdField_c_of_type_AndroidGraphicsPath.quadTo(f1, f2, f8, f6);
        break label1013;
      }
    }
    else
    {
      if (!this.jdField_g_of_type_Boolean) {
        break label854;
      }
      localPath1 = new Path();
      localPath1.addRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CW);
      localPath1.setFillType(Path.FillType.EVEN_ODD);
      localPath2 = new Path();
      f1 = a(this.jdField_b_of_type_Float, (Resources)localObject);
      f4 = a(this.jdField_c_of_type_Float, (Resources)localObject);
      localPath2.moveTo(f1, f4);
      f5 = this.jdField_d_of_type_Float;
      f7 = a(this.jdField_f_of_type_Float, (Resources)localObject);
      f9 = a(this.jdField_g_of_type_Float, (Resources)localObject);
      localPath2.quadTo(f7, f9, f5, f11);
      f8 = a(this.jdField_h_of_type_Float, (Resources)localObject);
      f6 = a(this.jdField_i_of_type_Float, (Resources)localObject);
      f3 = a(this.jdField_j_of_type_Float, (Resources)localObject);
      f2 = a(this.k, (Resources)localObject);
      localPath2.quadTo(f3, f2, f8, f6);
      localPath3 = new Path();
      m = Build.VERSION.SDK_INT;
      if (m >= 19) {
        localPath3.op(localPath1, localPath2, Path.Op.UNION);
      }
      localPath3.setFillType(Path.FillType.INVERSE_EVEN_ODD);
      this.jdField_c_of_type_AndroidGraphicsPath = localPath3;
    }
    float f10 = f1;
    f1 = f3;
    float f3 = f10;
    break label1013;
    label854:
    this.jdField_c_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CCW);
    f3 = a(this.jdField_b_of_type_Float, (Resources)localObject);
    float f4 = a(this.jdField_c_of_type_Float, (Resources)localObject);
    this.jdField_c_of_type_AndroidGraphicsPath.moveTo(f3, f4);
    float f5 = this.jdField_d_of_type_Float;
    float f7 = a(this.jdField_f_of_type_Float, (Resources)localObject);
    float f9 = a(this.jdField_g_of_type_Float, (Resources)localObject);
    this.jdField_c_of_type_AndroidGraphicsPath.quadTo(f7, f9, f5, f11);
    float f8 = a(this.jdField_h_of_type_Float, (Resources)localObject);
    float f6 = a(this.jdField_i_of_type_Float, (Resources)localObject);
    f1 = a(this.jdField_j_of_type_Float, (Resources)localObject);
    float f2 = a(this.k, (Resources)localObject);
    this.jdField_c_of_type_AndroidGraphicsPath.quadTo(f1, f2, f8, f6);
    label1013:
    this.jdField_c_of_type_AndroidGraphicsPath.close();
    Path localPath1 = this.jdField_d_of_type_AndroidGraphicsPath;
    if (localPath1 != null)
    {
      localPath1.reset();
      f10 = this.l * 2.0F;
      float f12;
      float f13;
      if (this.jdField_d_of_type_Boolean)
      {
        paramFloat1 = (float)(Math.asin(a(this.jdField_i_of_type_Float - this.jdField_c_of_type_Float, (Resources)localObject) / this.jdField_b_of_type_ArrayOfFloat[2]) * 180.0D / 3.141592653589793D);
        this.jdField_d_of_type_AndroidGraphicsPath.moveTo(f8, f6);
        this.jdField_d_of_type_AndroidGraphicsPath.lineTo(f8, paramFloat2 - this.l);
        localObject = this.jdField_c_of_type_AndroidGraphicsRectF;
        f12 = f8 - f10;
        f13 = paramFloat2 - f10;
        ((RectF)localObject).set(f12, f13, f8, paramFloat2);
        this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, 0.0F, 90.0F);
        this.jdField_d_of_type_AndroidGraphicsPath.lineTo(this.l + 0.0F, paramFloat2);
        this.jdField_c_of_type_AndroidGraphicsRectF.set(0.0F, f13, f10, paramFloat2);
        this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, 90.0F, 90.0F);
        this.jdField_d_of_type_AndroidGraphicsPath.lineTo(0.0F, this.l);
        this.jdField_c_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, f10, f10);
        this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, 180.0F, 90.0F);
        this.jdField_d_of_type_AndroidGraphicsPath.lineTo(f8 - this.l, 0.0F);
        this.jdField_c_of_type_AndroidGraphicsRectF.set(f12, 0.0F, f8, f10);
        this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, 270.0F, 90.0F - paramFloat1);
        this.jdField_d_of_type_AndroidGraphicsPath.lineTo(f3, f4);
        this.jdField_d_of_type_AndroidGraphicsPath.quadTo(f7, f9, f5, f11);
        this.jdField_d_of_type_AndroidGraphicsPath.quadTo(f1, f2, f8, f6);
      }
      else
      {
        f13 = (float)(Math.asin(a(this.jdField_i_of_type_Float - this.jdField_c_of_type_Float, (Resources)localObject) / this.jdField_b_of_type_ArrayOfFloat[0]) * 180.0D / 3.141592653589793D);
        this.jdField_d_of_type_AndroidGraphicsPath.moveTo(f3, f4);
        localObject = this.jdField_c_of_type_AndroidGraphicsRectF;
        f12 = f8 + f10;
        ((RectF)localObject).set(f8, 0.0F, f12, f10);
        this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, f13 + 180.0F, 90.0F - f13);
        this.jdField_d_of_type_AndroidGraphicsPath.lineTo(paramFloat1 - this.l, 0.0F);
        localObject = this.jdField_c_of_type_AndroidGraphicsRectF;
        f13 = paramFloat1 - f10;
        ((RectF)localObject).set(f13, 0.0F, paramFloat1, f10);
        this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, 270.0F, 90.0F);
        this.jdField_d_of_type_AndroidGraphicsPath.lineTo(paramFloat1, paramFloat2 - this.l);
        localObject = this.jdField_c_of_type_AndroidGraphicsRectF;
        f10 = paramFloat2 - f10;
        ((RectF)localObject).set(f13, f10, paramFloat1, paramFloat2);
        this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, 0.0F, 90.0F);
        this.jdField_d_of_type_AndroidGraphicsPath.lineTo(this.l + f8, paramFloat2);
        this.jdField_c_of_type_AndroidGraphicsRectF.set(f8, f10, f12, paramFloat2);
        this.jdField_d_of_type_AndroidGraphicsPath.arcTo(this.jdField_c_of_type_AndroidGraphicsRectF, 90.0F, 90.0F);
        this.jdField_d_of_type_AndroidGraphicsPath.lineTo(f8, this.l);
        this.jdField_d_of_type_AndroidGraphicsPath.lineTo(f8, f6);
        this.jdField_d_of_type_AndroidGraphicsPath.quadTo(f1, f2, f5, f11);
        this.jdField_d_of_type_AndroidGraphicsPath.quadTo(f7, f9, f3, f4);
      }
      this.jdField_d_of_type_AndroidGraphicsPath.close();
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
    if (VersionUtils.e()) {
      this.jdField_a_of_type_Int = 1;
    } else {
      this.jdField_a_of_type_Int = 2;
    }
    a();
    this.jdField_a_of_type_AndroidContentResResources = getResources();
    int m = this.jdField_a_of_type_Int;
    if (m == 1)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-16777216);
      this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.jdField_c_of_type_AndroidGraphicsPath = new Path();
      this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_b_of_type_ArrayOfFloat = new float[8];
      return;
    }
    if (m == 2)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_c_of_type_AndroidGraphicsPath = new Path();
      this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_b_of_type_ArrayOfFloat = new float[8];
    }
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
    if (this.jdField_h_of_type_Boolean)
    {
      super.draw(paramCanvas);
    }
    else
    {
      int m = this.jdField_a_of_type_Int;
      if (m == 1) {
        b(paramCanvas);
      } else if (m == 2) {
        c(paramCanvas);
      } else {
        super.draw(paramCanvas);
      }
    }
    l1 = System.currentTimeMillis() - l1;
    boolean bool = false;
    if (VersionUtils.e()) {
      bool = paramCanvas.isHardwareAccelerated();
    }
    if ((QLog.isColorLevel()) && (l1 > 10L))
    {
      paramCanvas = new StringBuilder();
      paramCanvas.append("BubbleImageView");
      paramCanvas.append(this.jdField_c_of_type_Int);
      paramCanvas = paramCanvas.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("draw(): isHardwaveAccelerated= ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", drawMode = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(", cost =");
      localStringBuilder.append(l1);
      QLog.w(paramCanvas, 2, localStringBuilder.toString());
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
    if (this.jdField_e_of_type_Boolean)
    {
      setLayerType(1, null);
      return;
    }
    if ((this.jdField_a_of_type_Int == 1) && (VersionUtils.e())) {
      setLayerType(2, null);
    }
  }
  
  @TargetApi(11)
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_Int == 1) && (VersionUtils.e())) {
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
    float[] arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
    if (arrayOfFloat != null) {
      Arrays.fill(arrayOfFloat, this.l);
    }
  }
  
  public void setRadiusBottom(float paramFloat)
  {
    this.l = a(paramFloat, this.jdField_a_of_type_AndroidContentResResources);
    float[] arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
    if (arrayOfFloat != null)
    {
      Arrays.fill(arrayOfFloat, 0, 4, 0.0F);
      Arrays.fill(this.jdField_b_of_type_ArrayOfFloat, 4, 8, this.l);
    }
  }
  
  public void setRadiusTop(float paramFloat)
  {
    this.l = a(paramFloat, this.jdField_a_of_type_AndroidContentResResources);
    float[] arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
    if (arrayOfFloat != null)
    {
      Arrays.fill(arrayOfFloat, 0, 4, this.l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BubbleImageView
 * JD-Core Version:    0.7.0.1
 */