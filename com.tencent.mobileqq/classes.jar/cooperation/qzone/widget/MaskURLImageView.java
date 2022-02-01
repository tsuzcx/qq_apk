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
  private boolean needSowPlayIcon;
  private int num;
  private float paddingSize;
  Paint paint;
  private float playIconSize;
  private float textSize;
  
  static
  {
    if (!MaskURLImageView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
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
    if (this.needSowPlayIcon) {
      drawPlayIcon(paramCanvas);
    }
    while (this.num <= 0) {
      return;
    }
    paramCanvas.drawColor(1711276032);
    int i = (int)(this.paint.measureText(String.valueOf(this.num)) + this.paddingSize + this.moreIconSize);
    int j = (getWidth() - i) / 2;
    int k = (int)((getHeight() - this.moreIconSize) / 2.0F);
    int m = (int)(j + this.moreIconSize);
    int n = (int)(k + this.moreIconSize);
    Object localObject = this.paint.getFontMetrics();
    float f1 = ((Paint.FontMetrics)localObject).bottom;
    float f2 = ((Paint.FontMetrics)localObject).top;
    f1 = (getHeight() - (f1 - f2)) / 2.0F;
    f2 = ((Paint.FontMetrics)localObject).top;
    localObject = getResources().getDrawable(2130847711);
    assert (localObject != null);
    ((Drawable)localObject).setBounds(j, k, m, n);
    ((Drawable)localObject).draw(paramCanvas);
    paramCanvas.drawText(String.valueOf(this.num), i + j, f1 - f2, this.paint);
  }
  
  private void drawPlayIcon(Canvas paramCanvas)
  {
    int i = (int)((getWidth() - this.playIconSize) / 2.0F);
    int j = (int)((getHeight() - this.playIconSize) / 2.0F);
    Drawable localDrawable = getResources().getDrawable(2130848326);
    if (localDrawable != null)
    {
      localDrawable.setBounds(i, j, (int)(i + this.playIconSize), (int)(j + this.playIconSize));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.MaskURLImageView
 * JD-Core Version:    0.7.0.1
 */