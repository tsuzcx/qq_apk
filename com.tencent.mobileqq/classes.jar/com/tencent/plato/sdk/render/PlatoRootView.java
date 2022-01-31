package com.tencent.plato.sdk.render;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.plato.IPlatoSurface;
import com.tencent.plato.IPlatoSurface.ISurfaceRender;

public class PlatoRootView
  extends FrameLayout
  implements IPlatoSurface
{
  @Nullable
  private IPlatoSurface.ISurfaceRender mDom;
  private boolean mWasMeasured = false;
  
  public PlatoRootView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public PlatoRootView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PlatoRootView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void refreshSurface()
  {
    if (this.mDom != null) {
      post(new Runnable()
      {
        public void run()
        {
          PlatoRootView.this.mDom.refreshSurface();
        }
      });
    }
  }
  
  public void attachRender(IPlatoSurface.ISurfaceRender paramISurfaceRender)
  {
    this.mDom = paramISurfaceRender;
    if (this.mWasMeasured) {
      refreshSurface();
    }
  }
  
  public int getHeightMeasureSpec()
  {
    return getMeasuredHeight();
  }
  
  public int getWidthMeasureSpec()
  {
    return getMeasuredWidth();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((!this.mWasMeasured) || (paramBoolean))
    {
      this.mWasMeasured = true;
      refreshSurface();
    }
  }
  
  public boolean wasMeasure()
  {
    return this.mWasMeasured;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.render.PlatoRootView
 * JD-Core Version:    0.7.0.1
 */