package dov.com.qq.im.ae.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathDashPathEffect;
import android.graphics.PathDashPathEffect.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bnrk;
import bnrl;
import bnrm;
import bnrn;
import bnro;
import bnrp;
import bnrq;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class AECMShowFaceScanView
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 1003;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  protected Matrix a;
  public Paint a;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private Xfermode jdField_a_of_type_AndroidGraphicsXfermode;
  bnrp jdField_a_of_type_Bnrp;
  public bnrq a;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 1.0F;
  protected Matrix b;
  Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 0.0F;
  Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  public Paint d = new Paint();
  
  public AECMShowFaceScanView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    a();
  }
  
  public AECMShowFaceScanView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    a();
  }
  
  public AECMShowFaceScanView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    a();
  }
  
  private ValueAnimator a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 0.8F });
    localValueAnimator.setDuration(800L);
    localValueAnimator.addUpdateListener(new bnrk(this));
    return localValueAnimator;
  }
  
  private ValueAnimator a(ValueAnimator paramValueAnimator)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
    localValueAnimator.setDuration(600L);
    localValueAnimator.addUpdateListener(new bnrl(this));
    localValueAnimator.addListener(new bnrm(this, paramValueAnimator));
    return localValueAnimator;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPath.addCircle(0.0F, 0.0F, 5.0F, Path.Direction.CW);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(12.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(new PathDashPathEffect(this.jdField_a_of_type_AndroidGraphicsPath, 30.0F, 0.0F, PathDashPathEffect.Style.TRANSLATE));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130837669);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      RectF localRectF = new RectF();
      localRectF.left = (this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.left + 3.0F);
      localRectF.top = (this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.top + 3.0F);
      localRectF.right = (this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.right - 3.0F);
      localRectF.bottom = (this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.bottom - 3.0F);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha((int)(76.5F * this.jdField_a_of_type_Float));
      localRectF = new RectF();
      localRectF.left = this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.left;
      localRectF.top = (this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.top + this.jdField_a_of_type_Float * this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.height() - 5.0F);
      localRectF.right = this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.right;
      localRectF.bottom = (this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.bottom + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2.0F);
      int i = paramCanvas.saveLayer(null, null, 31);
      if (this.jdField_a_of_type_Bnrp.jdField_a_of_type_Float != 0.0F)
      {
        this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
        this.jdField_b_of_type_AndroidGraphicsMatrix.postRotate(this.jdField_a_of_type_Bnrp.jdField_a_of_type_Float, this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.centerY());
        paramCanvas.concat(this.jdField_b_of_type_AndroidGraphicsMatrix);
      }
      paramCanvas.drawOval(this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsPaint);
      this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsXfermode);
      paramCanvas.drawRect(localRectF, this.jdField_b_of_type_AndroidGraphicsPaint);
      this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(null);
      paramCanvas.restoreToCount(i);
    }
  }
  
  @NotNull
  private ValueAnimator b()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(800L);
    localValueAnimator.setRepeatCount(2);
    localValueAnimator.setRepeatMode(2);
    localValueAnimator.addUpdateListener(new bnrn(this));
    localValueAnimator.addListener(new bnro(this));
    return localValueAnimator;
  }
  
  private void b()
  {
    switch (this.jdField_a_of_type_Int)
    {
    case 1002: 
    default: 
      return;
    case 1000: 
      setVisibility(0);
      postInvalidate();
      return;
    case 1001: 
      setVisibility(0);
      c();
      return;
    }
    setVisibility(8);
  }
  
  private void b(Canvas paramCanvas)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
    {
      RadialGradient localRadialGradient = new RadialGradient(this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.centerY(), Math.min(getHeight(), getWidth()), 0, -16777216, Shader.TileMode.CLAMP);
      this.d.setAlpha((int)(this.jdField_c_of_type_Float * 255.0F));
      this.d.setShader(localRadialGradient);
      paramCanvas.drawCircle(this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.centerY(), Math.max(getHeight(), getWidth()), this.d);
    }
  }
  
  private void c()
  {
    ValueAnimator localValueAnimator = a(b());
    a().start();
    localValueAnimator.start();
  }
  
  private void c(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      float f1 = this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.top + this.jdField_a_of_type_Float * this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.height() - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2.0F;
      float f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      f2 = this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.width() / f2;
      RectF localRectF = new RectF();
      localRectF.left = this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.left;
      localRectF.right = this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.right;
      localRectF.top = f1;
      localRectF.bottom = (f1 + f2);
      paramCanvas.save();
      if (this.jdField_a_of_type_Bnrp.jdField_a_of_type_Float != 0.0F)
      {
        this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
        this.jdField_b_of_type_AndroidGraphicsMatrix.postRotate(this.jdField_a_of_type_Bnrp.jdField_a_of_type_Float, this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.centerY());
        paramCanvas.concat(this.jdField_b_of_type_AndroidGraphicsMatrix);
      }
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, localRectF, this.jdField_c_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
    }
  }
  
  private void d(Canvas paramCanvas)
  {
    paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.jdField_b_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.centerY());
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(this.jdField_b_of_type_Float * 255.0F));
    }
    if (this.jdField_a_of_type_Bnrp.jdField_a_of_type_Float != 0.0F) {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(this.jdField_a_of_type_Bnrp.jdField_a_of_type_Float, this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF.centerY());
    }
    paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
    paramCanvas.drawOval(this.jdField_a_of_type_Bnrp.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  public void a(int paramInt, bnrp parambnrp)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bnrp = parambnrp;
    ThreadManager.getUIHandler().post(new AECMShowFaceScanView.1(this));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Bnrp != null)
    {
      b(paramCanvas);
      d(paramCanvas);
      c(paramCanvas);
      a(paramCanvas);
    }
  }
  
  public void setListener(bnrq parambnrq)
  {
    this.jdField_a_of_type_Bnrq = parambnrq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.view.AECMShowFaceScanView
 * JD-Core Version:    0.7.0.1
 */