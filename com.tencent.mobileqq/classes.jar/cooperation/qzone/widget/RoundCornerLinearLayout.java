package cooperation.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class RoundCornerLinearLayout
  extends LinearLayout
{
  private Path mPath;
  private float mRadius;
  private RectF mRectF;
  
  public RoundCornerLinearLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public RoundCornerLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public RoundCornerLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mPath = new Path();
    this.mRectF = new RectF();
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    this.mPath.reset();
    this.mRectF.set(0.0F, 0.0F, getWidth(), getHeight());
    this.mPath.addRoundRect(this.mRectF, this.mRadius, this.mRadius, Path.Direction.CW);
    paramCanvas.clipPath(this.mPath);
    super.dispatchDraw(paramCanvas);
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.RoundCornerLinearLayout
 * JD-Core Version:    0.7.0.1
 */