package me.ele.uetool.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import me.ele.uetool.util.ViewKnife;

public class TreeNodeLayout
  extends LinearLayout
{
  private final int color0x = -7829368;
  private final int color10x = -8767197;
  private final int color11x = -16777216;
  private final int color1x = -4007720;
  private final int color2x = -8666684;
  private final int color3x = -9385265;
  private final int color4x = -7286335;
  private final int color5x = -6499759;
  private final int color6x = -1191319;
  private final int color7x = -1990297;
  private final int color8x = -1273480;
  private final int color9x = -1410987;
  private final int interval = ViewKnife.dip2px(8.0F);
  private int layerCount;
  private Paint paint = new TreeNodeLayout.1(this);
  private int sysLayoutCount;
  
  public TreeNodeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TreeNodeLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TreeNodeLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = 1;
    if (i <= this.layerCount)
    {
      if (i > this.sysLayoutCount) {
        if (i >= this.sysLayoutCount + 11)
        {
          this.paint.setColor(-16777216);
          label43:
          this.paint.setStrokeWidth(ViewKnife.dip2px(1.0F));
        }
      }
      for (;;)
      {
        paramCanvas.drawLine(this.interval * i, 0.0F, this.interval * i, getMeasuredHeight(), this.paint);
        i += 1;
        break;
        if (i >= this.sysLayoutCount + 10)
        {
          this.paint.setColor(-8767197);
          break label43;
        }
        if (i >= this.sysLayoutCount + 9)
        {
          this.paint.setColor(-1410987);
          break label43;
        }
        if (i >= this.sysLayoutCount + 8)
        {
          this.paint.setColor(-1273480);
          break label43;
        }
        if (i == this.sysLayoutCount + 7)
        {
          this.paint.setColor(-1990297);
          break label43;
        }
        if (i == this.sysLayoutCount + 6)
        {
          this.paint.setColor(-1191319);
          break label43;
        }
        if (i == this.sysLayoutCount + 5)
        {
          this.paint.setColor(-6499759);
          break label43;
        }
        if (i == this.sysLayoutCount + 4)
        {
          this.paint.setColor(-7286335);
          break label43;
        }
        if (i == this.sysLayoutCount + 3)
        {
          this.paint.setColor(-9385265);
          break label43;
        }
        if (i == this.sysLayoutCount + 2)
        {
          this.paint.setColor(-8666684);
          break label43;
        }
        if (i != this.sysLayoutCount + 1) {
          break label43;
        }
        this.paint.setColor(-4007720);
        break label43;
        this.paint.setStrokeWidth(ViewKnife.dip2px(0.5F));
        this.paint.setColor(-7829368);
      }
    }
  }
  
  public void setLayerCount(int paramInt1, int paramInt2)
  {
    this.layerCount = paramInt1;
    this.sysLayoutCount = paramInt2;
    setPadding(this.interval * paramInt1 + ViewKnife.dip2px(2.0F), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.view.TreeNodeLayout
 * JD-Core Version:    0.7.0.1
 */