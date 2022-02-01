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
import com.tencent.qzonehub.api.panorama.IPanoramaBallView;

public class PanoramaBallView
  extends View
{
  public static final int HEIGHT = IPanoramaBallView.HEIGHT;
  private static final int SWEEP_ANGLE_MAX = 120;
  private static final int SWEEP_ANGLE_MIN = 45;
  public static final int WIDTH = IPanoramaBallView.WIDTH;
  private int colorBackground;
  private int innerCircleRadius;
  private Paint mPaint;
  private int mViewHeight = HEIGHT;
  private int mViewWidth = WIDTH;
  private int modeType;
  private int moveDegreeX = 0;
  private int moveDegreeY = 0;
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
    int i = this.mViewWidth;
    paramCanvas.drawCircle(i / 2, i / 2, i / 2, this.mPaint);
  }
  
  private void drawContent(Canvas paramCanvas)
  {
    int i = this.outCircleRadius;
    int j = this.innerCircleRadius;
    int k = (i - j) / 2;
    RectF localRectF = new RectF(i - j + k, i - j + k, i + j - k, i + j - k);
    this.mPaint.setColor(-1);
    float f3 = -90.0F - this.sweepAngle / 2.0F + this.moveDegreeX;
    i = this.sectorDegree;
    float f2 = f3;
    if (i != 360)
    {
      float f1 = f3;
      if (f3 < -90 - i / 2) {
        f1 = -90 - i / 2;
      }
      f3 = this.sweepAngle;
      i = this.sectorDegree;
      f2 = f1;
      if (f1 + f3 > i / 2 - 90) {
        f2 = i / 2 - 90 - f3;
      }
    }
    paramCanvas.drawArc(localRectF, f2, this.sweepAngle, true, this.mPaint);
  }
  
  private void drawContentDeco(Canvas paramCanvas)
  {
    this.mPaint.setColor(-1);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(2.0F);
    int i = this.outCircleRadius;
    int j = this.innerCircleRadius;
    Object localObject = new RectF(i - j, i - j, i + j, i + j);
    i = this.sectorDegree;
    paramCanvas.drawArc((RectF)localObject, -90 - i / 2, i, false, this.mPaint);
    this.mPaint.setStyle(Paint.Style.FILL);
    localObject = new Path();
    j = this.outCircleRadius;
    int k = this.innerCircleRadius;
    int m = (j - k) / 2;
    i = m / 2;
    ((Path)localObject).moveTo(j, j - k - m);
    j = this.outCircleRadius;
    ((Path)localObject).lineTo(j - i, j - this.innerCircleRadius);
    j = this.outCircleRadius;
    ((Path)localObject).lineTo(i + j, j - this.innerCircleRadius);
    ((Path)localObject).close();
    paramCanvas.drawPath((Path)localObject, this.mPaint);
  }
  
  private void init(Context paramContext)
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.colorBackground = paramContext.getResources().getColor(2131165580);
  }
  
  private int measureHeight(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i != 1073741824) {
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.mViewHeight);
      } else {
        paramInt = this.mViewHeight;
      }
    }
    this.mViewHeight = paramInt;
    return paramInt;
  }
  
  private int measureWidth(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i != 1073741824) {
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.mViewWidth);
      } else {
        paramInt = this.mViewWidth;
      }
    }
    this.mViewWidth = paramInt;
    return paramInt;
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
    int i = this.mViewWidth;
    this.outCircleRadius = (i / 2);
    this.innerCircleRadius = (this.outCircleRadius - i / 6);
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
    float f;
    if (this.modeType == 2)
    {
      f = paramFloat - 0.122F;
      paramFloat = 0.878F;
    }
    else
    {
      f = paramFloat - 0.35F;
      paramFloat = 1.15F;
    }
    this.sweepAngle = (f / paramFloat * 75.0F + 45.0F);
    postInvalidate();
  }
  
  public void setModeType(int paramInt)
  {
    this.modeType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaBallView
 * JD-Core Version:    0.7.0.1
 */