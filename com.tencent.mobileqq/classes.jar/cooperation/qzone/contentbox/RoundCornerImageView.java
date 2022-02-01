package cooperation.qzone.contentbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

public class RoundCornerImageView
  extends URLImageView
{
  private int lowerLeft = 0;
  private int lowerRight = 0;
  private int mColor = Color.parseColor("#FFD5D5D5");
  private Paint mPaint = new Paint();
  private Path mPath = new Path();
  private float[] radius = { this.upperLeft, this.upperLeft, this.upperRight, this.upperRight, this.lowerRight, this.lowerRight, this.lowerLeft, this.lowerLeft };
  private RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop());
  private int upperLeft = 0;
  private int upperRight = 0;
  
  public RoundCornerImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint.setColor(this.mColor);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setFilterBitmap(true);
    if (Build.VERSION.SDK_INT >= 16) {
      super.setLayerType(2, null);
    }
    while (Build.VERSION.SDK_INT < 14) {
      return;
    }
    super.setLayerType(1, null);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mPath == null) {
      this.mPath = new Path();
    }
    this.mPath.reset();
    int i = getWidth();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int m = getHeight();
    int n = getPaddingTop();
    int i1 = getPaddingBottom();
    this.rectF.set(getPaddingLeft(), getPaddingTop(), i - j - k + getPaddingLeft(), m - n - i1 + getPaddingTop());
    this.mPath.addRoundRect(this.rectF, this.radius, Path.Direction.CW);
    this.mPath.setFillType(Path.FillType.EVEN_ODD);
    paramCanvas.clipPath(this.mPath);
    super.draw(paramCanvas);
  }
  
  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
  }
  
  public void setCorner(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0)) {
      throw new IllegalArgumentException("should not be less than 0");
    }
    this.upperLeft = paramInt1;
    this.upperRight = paramInt2;
    this.lowerLeft = paramInt3;
    this.lowerRight = paramInt4;
    this.radius[0] = paramInt1;
    this.radius[1] = paramInt1;
    this.radius[2] = paramInt2;
    this.radius[3] = paramInt2;
    this.radius[4] = paramInt4;
    this.radius[5] = paramInt4;
    this.radius[6] = paramInt3;
    this.radius[7] = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */