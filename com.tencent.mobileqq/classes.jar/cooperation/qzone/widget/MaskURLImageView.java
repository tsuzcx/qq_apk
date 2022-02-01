package cooperation.qzone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

public class MaskURLImageView
  extends URLImageView
{
  private float moreIconSize;
  private boolean needSowPlayIcon = false;
  private int num;
  private float paddingSize;
  Paint paint;
  private float playIconSize;
  private float textSize;
  
  public MaskURLImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MaskURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MaskURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void drawMask(Canvas paramCanvas)
  {
    if (this.needSowPlayIcon)
    {
      drawPlayIcon(paramCanvas);
      return;
    }
    if (this.num <= 0) {
      return;
    }
    paramCanvas.drawColor(1711276032);
    int i = (int)(this.paint.measureText(String.valueOf(this.num)) + this.paddingSize + this.moreIconSize);
    int j = (getWidth() - i) / 2;
    float f1 = getHeight();
    float f2 = this.moreIconSize;
    int k = (int)((f1 - f2) / 2.0F);
    int m = (int)(j + f2);
    int n = (int)(k + f2);
    Object localObject = this.paint.getFontMetrics();
    f1 = ((Paint.FontMetrics)localObject).bottom;
    f2 = ((Paint.FontMetrics)localObject).top;
    f1 = (getHeight() - (f1 - f2)) / 2.0F;
    f2 = ((Paint.FontMetrics)localObject).top;
    localObject = getResources().getDrawable(2130849599);
    ((Drawable)localObject).setBounds(j, k, m, n);
    ((Drawable)localObject).draw(paramCanvas);
    paramCanvas.drawText(String.valueOf(this.num), i + j, f1 - f2, this.paint);
  }
  
  private void drawPlayIcon(Canvas paramCanvas)
  {
    int i = (int)((getWidth() - this.playIconSize) / 2.0F);
    int j = (int)((getHeight() - this.playIconSize) / 2.0F);
    Drawable localDrawable = getResources().getDrawable(2130850225);
    if (localDrawable != null)
    {
      float f1 = i;
      float f2 = this.playIconSize;
      localDrawable.setBounds(i, j, (int)(f1 + f2), (int)(j + f2));
      localDrawable.draw(paramCanvas);
    }
  }
  
  private void init()
  {
    this.paint = new Paint();
    this.paint.setColor(-1);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.textSize = TypedValue.applyDimension(2, 18.0F, localDisplayMetrics);
    this.paddingSize = TypedValue.applyDimension(1, 4.0F, localDisplayMetrics);
    this.moreIconSize = TypedValue.applyDimension(1, 12.0F, localDisplayMetrics);
    this.playIconSize = TypedValue.applyDimension(1, 28.0F, localDisplayMetrics);
    this.paint.setTextSize(this.textSize);
    this.paint.setAntiAlias(true);
    this.paint.setTextAlign(Paint.Align.RIGHT);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    drawMask(paramCanvas);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    super.onLoadCanceled(paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public void setHasMore(int paramInt)
  {
    this.num = paramInt;
    invalidate();
  }
  
  public void setNeedSowPlayIcon(boolean paramBoolean)
  {
    this.needSowPlayIcon = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.widget.MaskURLImageView
 * JD-Core Version:    0.7.0.1
 */