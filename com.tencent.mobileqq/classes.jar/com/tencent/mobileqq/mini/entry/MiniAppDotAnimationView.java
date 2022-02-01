package com.tencent.mobileqq.mini.entry;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MiniAppDotAnimationView
  extends View
{
  private static final int DEFAULT_OFFSET = ViewUtils.b(-20.0F);
  private static final int MARGIN_LEFT_RIGHT;
  private static final int MAX_DOT_SIZE;
  private static final int MIN_DOT_SIZE;
  private static final int SCROLL_ANIMATION_CLOSE_END;
  private static final int SCROLL_ANIMATION_CLOSE_START;
  private static final int SCROLL_ANIMATION_OPEN_END;
  private static final int SCROLL_ANIMATION_OPEN_START = ViewUtils.b(-20.0F);
  private static String TAG = "MiniAppDotAnimationView";
  private boolean hasReset = false;
  private List<MiniAppDotAnimationView.Dot> mDots = new ArrayList(3);
  private Paint mPaint;
  
  static
  {
    SCROLL_ANIMATION_OPEN_END = ViewUtils.b(-50.0F);
    SCROLL_ANIMATION_CLOSE_START = ViewUtils.b(-70.0F);
    SCROLL_ANIMATION_CLOSE_END = ViewUtils.b(-95.0F);
    MIN_DOT_SIZE = ViewUtils.b(3.0F);
    MAX_DOT_SIZE = ViewUtils.b(6.0F);
    MARGIN_LEFT_RIGHT = ViewUtils.b(30.0F);
  }
  
  public MiniAppDotAnimationView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MiniAppDotAnimationView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MiniAppDotAnimationView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void drawDots(Canvas paramCanvas)
  {
    Iterator localIterator = this.mDots.iterator();
    while (localIterator.hasNext())
    {
      MiniAppDotAnimationView.Dot localDot = (MiniAppDotAnimationView.Dot)localIterator.next();
      paramCanvas.drawCircle(getWidth() / 2 + localDot.offset, getHeight() / 2, localDot.radius, this.mPaint);
    }
  }
  
  private void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setColor(ColorUtils.parseColor("#DDDEE2"));
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setStrokeWidth(0.1F);
    this.mPaint.setAntiAlias(true);
    int i = 0;
    while (i < 3)
    {
      this.mDots.add(new MiniAppDotAnimationView.Dot(this, null));
      i += 1;
    }
  }
  
  public void doOnScroll(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      return;
    }
    int i = 0;
    this.hasReset = false;
    int j = SCROLL_ANIMATION_OPEN_START;
    Object localObject;
    MiniAppDotAnimationView.Dot localDot;
    if (paramFloat > j)
    {
      localObject = this.mDots.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDot = (MiniAppDotAnimationView.Dot)((Iterator)localObject).next();
        localDot.radius = 0.0F;
        localDot.offset = 0.0F;
      }
      ((MiniAppDotAnimationView.Dot)this.mDots.get(1)).radius = (MAX_DOT_SIZE * (Math.abs(paramFloat) / Math.abs(SCROLL_ANIMATION_OPEN_START)));
    }
    else
    {
      int k = SCROLL_ANIMATION_OPEN_END;
      if (paramFloat > k)
      {
        paramFloat = (j - paramFloat) / (j - k);
        while (i < this.mDots.size())
        {
          ((MiniAppDotAnimationView.Dot)this.mDots.get(i)).offset = (((MiniAppDotAnimationView.Dot)this.mDots.get(i)).finalOffset * paramFloat);
          if (i == 1)
          {
            localObject = (MiniAppDotAnimationView.Dot)this.mDots.get(i);
            j = MAX_DOT_SIZE;
            ((MiniAppDotAnimationView.Dot)localObject).radius = (j - (j - MIN_DOT_SIZE) * paramFloat);
          }
          else
          {
            ((MiniAppDotAnimationView.Dot)this.mDots.get(i)).radius = MIN_DOT_SIZE;
          }
          i += 1;
        }
      }
      if (paramFloat > SCROLL_ANIMATION_CLOSE_START)
      {
        localObject = this.mDots.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localDot = (MiniAppDotAnimationView.Dot)((Iterator)localObject).next();
          localDot.radius = MIN_DOT_SIZE;
          localDot.offset = localDot.finalOffset;
        }
      }
      localObject = this.mDots.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDot = (MiniAppDotAnimationView.Dot)((Iterator)localObject).next();
        localDot.offset = localDot.finalOffset;
      }
      i = SCROLL_ANIMATION_CLOSE_START;
      j = SCROLL_ANIMATION_CLOSE_END;
      float f1 = (j - i) / 2 + i;
      float f2 = j;
      if (paramFloat > f1)
      {
        paramFloat = (i - paramFloat) / (i - f1);
        localObject = (MiniAppDotAnimationView.Dot)this.mDots.get(0);
        localDot = (MiniAppDotAnimationView.Dot)this.mDots.get(2);
        i = MIN_DOT_SIZE;
        paramFloat = i - i * paramFloat;
        localDot.radius = paramFloat;
        ((MiniAppDotAnimationView.Dot)localObject).radius = paramFloat;
        ((MiniAppDotAnimationView.Dot)this.mDots.get(1)).radius = MIN_DOT_SIZE;
      }
      else if (paramFloat > f2)
      {
        paramFloat = (f1 - paramFloat) / (f1 - f2);
        localObject = (MiniAppDotAnimationView.Dot)this.mDots.get(0);
        ((MiniAppDotAnimationView.Dot)this.mDots.get(2)).radius = 0.0F;
        ((MiniAppDotAnimationView.Dot)localObject).radius = 0.0F;
        localObject = (MiniAppDotAnimationView.Dot)this.mDots.get(1);
        i = MIN_DOT_SIZE;
        ((MiniAppDotAnimationView.Dot)localObject).radius = (i - i * paramFloat);
      }
      else
      {
        localObject = this.mDots.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((MiniAppDotAnimationView.Dot)((Iterator)localObject).next()).radius = 0.0F;
        }
      }
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    drawDots(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.mDots.iterator();
    while (localIterator.hasNext())
    {
      MiniAppDotAnimationView.Dot localDot = (MiniAppDotAnimationView.Dot)localIterator.next();
      localDot.radius = 0.0F;
      localDot.offset = 0.0F;
      localDot.finalOffset = 0.0F;
    }
    paramInt1 = MARGIN_LEFT_RIGHT;
    ((MiniAppDotAnimationView.Dot)this.mDots.get(0)).finalOffset = DEFAULT_OFFSET;
    ((MiniAppDotAnimationView.Dot)this.mDots.get(1)).finalOffset = 0.0F;
    ((MiniAppDotAnimationView.Dot)this.mDots.get(2)).finalOffset = (-((MiniAppDotAnimationView.Dot)this.mDots.get(0)).finalOffset);
    this.hasReset = false;
  }
  
  public void resetDots()
  {
    if (this.hasReset) {
      return;
    }
    this.hasReset = true;
    int i = 0;
    Iterator localIterator = this.mDots.iterator();
    while (localIterator.hasNext())
    {
      MiniAppDotAnimationView.Dot localDot = (MiniAppDotAnimationView.Dot)localIterator.next();
      if ((localDot.radius != 0.0F) || (localDot.offset != 0.0F)) {
        i = 1;
      }
      localDot.radius = 0.0F;
      localDot.offset = 0.0F;
    }
    if (i != 0)
    {
      setTranslationY(0.0F);
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppDotAnimationView
 * JD-Core Version:    0.7.0.1
 */