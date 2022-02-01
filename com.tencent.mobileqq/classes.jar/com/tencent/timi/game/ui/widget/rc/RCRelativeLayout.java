package com.tencent.timi.game.ui.widget.rc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import com.tencent.timi.game.ui.widget.rc.helper.RCAttrs;
import com.tencent.timi.game.ui.widget.rc.helper.RCHelper;
import com.tencent.timi.game.ui.widget.rc.helper.RCHelper.OnCheckedChangeListener;

public class RCRelativeLayout
  extends RelativeLayout
  implements Checkable, RCAttrs
{
  RCHelper a = new RCHelper();
  
  public RCRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RCRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RCRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.a(paramContext, paramAttributeSet);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayer(this.a.k, null, 31);
    super.dispatchDraw(paramCanvas);
    this.a.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 0) && (!this.a.j.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))) {
      return false;
    }
    if ((i != 0) && (i != 1))
    {
      if (i == 3)
      {
        setPressed(false);
        refreshDrawableState();
      }
    }
    else {
      refreshDrawableState();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a.i)
    {
      paramCanvas.save();
      paramCanvas.clipPath(this.a.b);
      super.draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.a.b(this);
  }
  
  public float getBottomLeftRadius()
  {
    return this.a.a[4];
  }
  
  public float getBottomRightRadius()
  {
    return this.a.a[6];
  }
  
  public int getStrokeColor()
  {
    return this.a.f;
  }
  
  public int getStrokeWidth()
  {
    return this.a.h;
  }
  
  public float getTopLeftRadius()
  {
    return this.a.a[0];
  }
  
  public float getTopRightRadius()
  {
    return this.a.a[2];
  }
  
  public void invalidate()
  {
    RCHelper localRCHelper = this.a;
    if (localRCHelper != null) {
      localRCHelper.a(this);
    }
    super.invalidate();
  }
  
  public boolean isChecked()
  {
    return this.a.l;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.a(this, paramInt1, paramInt2);
  }
  
  public void setBottomLeftRadius(int paramInt)
  {
    float[] arrayOfFloat = this.a.a;
    float f = paramInt;
    arrayOfFloat[6] = f;
    this.a.a[7] = f;
    invalidate();
  }
  
  public void setBottomRightRadius(int paramInt)
  {
    float[] arrayOfFloat = this.a.a;
    float f = paramInt;
    arrayOfFloat[4] = f;
    this.a.a[5] = f;
    invalidate();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.a.l != paramBoolean)
    {
      this.a.l = paramBoolean;
      refreshDrawableState();
      if (this.a.m != null) {
        this.a.m.a(this, this.a.l);
      }
    }
  }
  
  public void setClipBackground(boolean paramBoolean)
  {
    this.a.i = paramBoolean;
    invalidate();
  }
  
  public void setOnCheckedChangeListener(RCHelper.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.a.m = paramOnCheckedChangeListener;
  }
  
  public void setRadius(int paramInt)
  {
    int i = 0;
    while (i < this.a.a.length)
    {
      this.a.a[i] = paramInt;
      i += 1;
    }
    invalidate();
  }
  
  public void setRoundAsCircle(boolean paramBoolean)
  {
    this.a.d = paramBoolean;
    invalidate();
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.a.f = paramInt;
    invalidate();
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.a.h = paramInt;
    invalidate();
  }
  
  public void setTopLeftRadius(int paramInt)
  {
    float[] arrayOfFloat = this.a.a;
    float f = paramInt;
    arrayOfFloat[0] = f;
    this.a.a[1] = f;
    invalidate();
  }
  
  public void setTopRightRadius(int paramInt)
  {
    float[] arrayOfFloat = this.a.a;
    float f = paramInt;
    arrayOfFloat[2] = f;
    this.a.a[3] = f;
    invalidate();
  }
  
  public void toggle()
  {
    setChecked(this.a.l ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.rc.RCRelativeLayout
 * JD-Core Version:    0.7.0.1
 */