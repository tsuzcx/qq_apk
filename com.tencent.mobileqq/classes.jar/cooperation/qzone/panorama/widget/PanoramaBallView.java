package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.utils.ViewUtils;

public class PanoramaBallView
  extends View
{
  public static final int HEIGHT = ViewUtils.dpToPx(32.0F);
  private static final int SWEEP_ANGLE_MAX = 120;
  private static final int SWEEP_ANGLE_MIN = 45;
  public static final int WIDTH = ViewUtils.dpToPx(32.0F);
  private int colorBackground;
  private int innerCircleRadius;
  private Paint mPaint;
  private int mViewHeight = HEIGHT;
  private int mViewWidth = WIDTH;
  private int modeType;
  private int moveDegreeX;
  private int moveDegreeY;
  private int outCircleRadius;
  private int sectorDegree = 360;
  private float sweepAngle;
  
  public PanoramaBallView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PanoramaBallView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void drawBackground(Canvas paramCanvas)
  {
    this.mPaint.setColor(this.colorBackground);
    this.mPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.mViewWidth / 2, this.mViewWidth / 2, this.mViewWidth / 2, this.mPaint);
  }
  
  private void drawContent(Canvas paramCanvas)
  {
    int i = (this.outCircleRadius - this.innerCircleRadius) / 2;
    RectF localRectF = new RectF(this.outCircleRadius - this.innerCircleRadius + i, this.outCircleRadius - this.innerCircleRadius + i, this.outCircleRadius + this.innerCircleRadius - i, this.outCircleRadius + this.innerCircleRadius - i);
    this.mPaint.setColor(-1);
    float f3 = -90.0F - this.sweepAngle / 2.0F + this.moveDegreeX;
    float f2 = f3;
    if (this.sectorDegree != 360)
    {
      f1 = f3;
      if (f3 < -90 - this.sectorDegree / 2) {
        f1 = -90 - this.sectorDegree / 2;
      }
      f2 = f1;
      if (this.sweepAngle + f1 <= this.sectorDegree / 2 - 90) {}
    }
    for (float f1 = this.sectorDegree / 2 - 90 - this.sweepAngle;; f1 = f2)
    {
      paramCanvas.drawArc(localRectF, f1, this.sweepAngle, true, this.mPaint);
      return;
    }
  }
  
  private void drawContentDeco(Canvas paramCanvas)
  {
    this.mPaint.setColor(-1);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(2.0F);
    paramCanvas.drawArc(new RectF(this.outCircleRadius - this.innerCircleRadius, this.outCircleRadius - this.innerCircleRadius, this.outCircleRadius + this.innerCircleRadius, this.outCircleRadius + this.innerCircleRadius), -90 - this.sectorDegree / 2, this.sectorDegree, false, this.mPaint);
    this.mPaint.setStyle(Paint.Style.FILL);
    Path localPath = new Path();
    int i = (this.outCircleRadius - this.innerCircleRadius) / 2;
    int j = i / 2;
    localPath.moveTo(this.outCircleRadius, this.outCircleRadius - this.innerCircleRadius - i);
    localPath.lineTo(this.outCircleRadius - j, this.outCircleRadius - this.innerCircleRadius);
    localPath.lineTo(this.outCircleRadius + j, this.outCircleRadius - this.innerCircleRadius);
    localPath.close();
    paramCanvas.drawPath(localPath, this.mPaint);
  }
  
  private void init(Context paramContext)
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.colorBackground = paramContext.getResources().getColor(2131165370);
  }
  
  private int measureHeight(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    for (;;)
    {
      this.mViewHeight = paramInt;
      return paramInt;
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.mViewHeight);
      } else {
        paramInt = this.mViewHeight;
      }
    }
  }
  
  private int measureWidth(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    for (;;)
    {
      this.mViewWidth = paramInt;
      return paramInt;
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.mViewWidth);
      } else {
        paramInt = this.mViewWidth;
      }
    }
  }
  
  public int getMoveDegreeX()
  {
    return this.moveDegreeX;
  }
  
  public int getMoveDegreeY()
  {
    return this.moveDegreeY;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.outCircleRadius = (this.mViewWidth / 2);
    this.innerCircleRadius = (this.outCircleRadius - this.mViewWidth / 6);
    drawBackground(paramCanvas);
    drawContentDeco(paramCanvas);
    drawContent(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(measureWidth(paramInt1), measureHeight(paramInt2));
  }
  
  public void setDegreeChange(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.sectorDegree = paramInt1;
    this.moveDegreeX = paramInt2;
    this.moveDegreeY = paramInt3;
    if (this.modeType == 2) {}
    for (paramFloat = (paramFloat - 0.122F) / 0.878F;; paramFloat = (paramFloat - 0.35F) / 1.15F)
    {
      this.sweepAngle = (paramFloat * 75.0F + 45.0F);
      postInvalidate();
      return;
    }
  }
  
  public void setModeType(int paramInt)
  {
    this.modeType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaBallView
 * JD-Core Version:    0.7.0.1
 */