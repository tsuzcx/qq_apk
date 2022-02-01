package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import bnde;
import bnjz;
import cooperation.qzone.util.QZLog;
import java.util.Timer;
import java.util.TimerTask;

public class PanoramaLoadingBall
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = PanoramaLoadingLayout.jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Handler jdField_a_of_type_AndroidOsHandler = new bnde(this, Looper.getMainLooper());
  private PanoramaLoadingBackground jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = PanoramaLoadingLayout.jdField_b_of_type_Int;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public PanoramaLoadingBall(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PanoramaLoadingBall(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private int a(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return paramInt;
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.jdField_a_of_type_Int);
      } else {
        paramInt = this.jdField_a_of_type_Int;
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    setPivotX(this.jdField_a_of_type_Int / 2 + 5);
    setPivotY(this.jdField_b_of_type_Int / 2 - 5);
  }
  
  private void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(3.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(this.jdField_a_of_type_Int / 2, this.jdField_a_of_type_Int / 2, this.d, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private int b(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt;
      return paramInt;
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.jdField_b_of_type_Int);
      } else {
        paramInt = this.jdField_b_of_type_Int;
      }
    }
  }
  
  private void b()
  {
    a();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimerTask = new PanoramaLoadingBall.2(this);
    try
    {
      this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, 0L, 15L);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QZLog.e("PanoramaLoadingBall", "startTimerTask IllegalStateException", localIllegalStateException);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    if (this.jdField_a_of_type_JavaUtilTimerTask != null) {
      this.jdField_a_of_type_JavaUtilTimerTask.cancel();
    }
  }
  
  public void a(float paramFloat, int paramInt, PanoramaLoadingBackground paramPanoramaLoadingBackground)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_b_of_type_Float = paramFloat;
    this.f = paramInt;
    this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground = paramPanoramaLoadingBackground;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramInt != 0) {
        break label42;
      }
      setRotationX(paramFloat);
    }
    for (;;)
    {
      b();
      return;
      label42:
      setRotationY(paramFloat);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.c = (this.jdField_a_of_type_Int / 2);
    this.d = (this.c - this.c / 5);
    this.e = (this.c - this.c * 2 / 5);
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1), b(paramInt2));
  }
  
  public void setRotationX(float paramFloat)
  {
    float f1 = 255.0F;
    if (!bnjz.a().c()) {
      super.setRotationX(paramFloat);
    }
    paramFloat = paramFloat / this.jdField_a_of_type_Float * (255 - PanoramaLoadingBackground.jdField_a_of_type_Int) + PanoramaLoadingBackground.jdField_a_of_type_Int;
    if (paramFloat > 255.0F) {
      paramFloat = f1;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground != null) {
        this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground.setContentAlpha((int)paramFloat);
      }
      return;
    }
  }
  
  public void setRotationY(float paramFloat)
  {
    if (!bnjz.a().c()) {
      super.setRotationY(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaLoadingBall
 * JD-Core Version:    0.7.0.1
 */