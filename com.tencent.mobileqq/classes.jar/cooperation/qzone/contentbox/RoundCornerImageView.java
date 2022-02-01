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
  private float[] radius;
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
    paramInt = this.upperLeft;
    float f1 = paramInt;
    float f2 = paramInt;
    paramInt = this.upperRight;
    float f3 = paramInt;
    float f4 = paramInt;
    paramInt = this.lowerRight;
    float f5 = paramInt;
    float f6 = paramInt;
    paramInt = this.lowerLeft;
    this.radius = new float[] { f1, f2, f3, f4, f5, f6, paramInt, paramInt };
    this.mPaint.setColor(this.mColor);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setFilterBitmap(true);
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.setLayerType(2, null);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14) {
      super.setLayerType(1, null);
    }
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
    this.rectF.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (i - j - k), getPaddingTop() + (m - n - i1));
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
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt3 >= 0) && (paramInt4 >= 0))
    {
      this.upperLeft = paramInt1;
      this.upperRight = paramInt2;
      this.lowerLeft = paramInt3;
      this.lowerRight = paramInt4;
      float[] arrayOfFloat = this.radius;
      float f = paramInt1;
      arrayOfFloat[0] = f;
      arrayOfFloat[1] = f;
      f = paramInt2;
      arrayOfFloat[2] = f;
      arrayOfFloat[3] = f;
      f = paramInt4;
      arrayOfFloat[4] = f;
      arrayOfFloat[5] = f;
      f = paramInt3;
      arrayOfFloat[6] = f;
      arrayOfFloat[7] = f;
      return;
    }
    throw new IllegalArgumentException("should not be less than 0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */