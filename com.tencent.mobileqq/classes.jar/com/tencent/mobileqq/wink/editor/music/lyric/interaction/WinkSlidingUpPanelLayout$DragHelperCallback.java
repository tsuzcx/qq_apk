package com.tencent.mobileqq.wink.editor.music.lyric.interaction;

import android.view.View;
import com.tencent.mobileqq.wink.editor.music.lyric.util.FloatUtils;

class WinkSlidingUpPanelLayout$DragHelperCallback
  extends ViewDragHelper.Callback
{
  private WinkSlidingUpPanelLayout$DragHelperCallback(WinkSlidingUpPanelLayout paramWinkSlidingUpPanelLayout) {}
  
  public void a(int paramInt)
  {
    if ((WinkSlidingUpPanelLayout.e(this.a) != null) && (WinkSlidingUpPanelLayout.e(this.a).a() == 0))
    {
      WinkSlidingUpPanelLayout localWinkSlidingUpPanelLayout = this.a;
      WinkSlidingUpPanelLayout.a(localWinkSlidingUpPanelLayout, WinkSlidingUpPanelLayout.a(localWinkSlidingUpPanelLayout, WinkSlidingUpPanelLayout.d(localWinkSlidingUpPanelLayout).getTop()));
      WinkSlidingUpPanelLayout.f(this.a);
      if (FloatUtils.a(WinkSlidingUpPanelLayout.g(this.a), 1.0F))
      {
        this.a.c();
        WinkSlidingUpPanelLayout.a(this.a, WinkSlidingUpPanelLayout.PanelState.EXPANDED);
        return;
      }
      if (FloatUtils.a(WinkSlidingUpPanelLayout.g(this.a), 0.0F))
      {
        WinkSlidingUpPanelLayout.a(this.a, WinkSlidingUpPanelLayout.PanelState.COLLAPSED);
        return;
      }
      if (WinkSlidingUpPanelLayout.g(this.a) < 0.0F)
      {
        WinkSlidingUpPanelLayout.a(this.a, WinkSlidingUpPanelLayout.PanelState.HIDDEN);
        WinkSlidingUpPanelLayout.d(this.a).setVisibility(4);
        return;
      }
      this.a.c();
      WinkSlidingUpPanelLayout.a(this.a, WinkSlidingUpPanelLayout.PanelState.ANCHORED);
    }
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = paramFloat2;
    if (WinkSlidingUpPanelLayout.h(this.a)) {
      paramFloat1 = -paramFloat2;
    }
    WinkSlidingUpPanelLayout localWinkSlidingUpPanelLayout;
    int i;
    if ((paramFloat1 > 0.0F) && (WinkSlidingUpPanelLayout.g(this.a) <= WinkSlidingUpPanelLayout.b(this.a)))
    {
      localWinkSlidingUpPanelLayout = this.a;
      i = WinkSlidingUpPanelLayout.b(localWinkSlidingUpPanelLayout, WinkSlidingUpPanelLayout.b(localWinkSlidingUpPanelLayout));
    }
    else if ((paramFloat1 > 0.0F) && (WinkSlidingUpPanelLayout.g(this.a) > WinkSlidingUpPanelLayout.b(this.a)))
    {
      i = WinkSlidingUpPanelLayout.b(this.a, 1.0F);
    }
    else if ((paramFloat1 < 0.0F) && (WinkSlidingUpPanelLayout.g(this.a) >= WinkSlidingUpPanelLayout.b(this.a)))
    {
      localWinkSlidingUpPanelLayout = this.a;
      i = WinkSlidingUpPanelLayout.b(localWinkSlidingUpPanelLayout, WinkSlidingUpPanelLayout.b(localWinkSlidingUpPanelLayout));
    }
    else if ((paramFloat1 < 0.0F) && (WinkSlidingUpPanelLayout.g(this.a) < WinkSlidingUpPanelLayout.b(this.a)))
    {
      i = WinkSlidingUpPanelLayout.b(this.a, 0.0F);
    }
    else if (WinkSlidingUpPanelLayout.g(this.a) >= (WinkSlidingUpPanelLayout.b(this.a) + 1.0F) / 2.0F)
    {
      i = WinkSlidingUpPanelLayout.b(this.a, 1.0F);
    }
    else if (WinkSlidingUpPanelLayout.g(this.a) >= WinkSlidingUpPanelLayout.b(this.a) / 2.0F)
    {
      localWinkSlidingUpPanelLayout = this.a;
      i = WinkSlidingUpPanelLayout.b(localWinkSlidingUpPanelLayout, WinkSlidingUpPanelLayout.b(localWinkSlidingUpPanelLayout));
    }
    else
    {
      i = WinkSlidingUpPanelLayout.b(this.a, 0.0F);
    }
    if (WinkSlidingUpPanelLayout.e(this.a) != null) {
      WinkSlidingUpPanelLayout.e(this.a).a(paramView.getLeft(), i);
    }
    this.a.invalidate();
  }
  
  public void a(View paramView, int paramInt)
  {
    this.a.d();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    WinkSlidingUpPanelLayout.b(this.a, paramInt2);
    this.a.invalidate();
  }
  
  public int b(View paramView)
  {
    return WinkSlidingUpPanelLayout.i(this.a);
  }
  
  public int b(View paramView, int paramInt1, int paramInt2)
  {
    paramInt2 = WinkSlidingUpPanelLayout.b(this.a, 0.0F);
    int i = WinkSlidingUpPanelLayout.b(this.a, 1.0F);
    if (WinkSlidingUpPanelLayout.h(this.a)) {
      return Math.min(Math.max(paramInt1, i), paramInt2);
    }
    return Math.min(Math.max(paramInt1, paramInt2), i);
  }
  
  public boolean b(View paramView, int paramInt)
  {
    return (!WinkSlidingUpPanelLayout.c(this.a)) && (paramView != null) && (paramView.equals(WinkSlidingUpPanelLayout.d(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.interaction.WinkSlidingUpPanelLayout.DragHelperCallback
 * JD-Core Version:    0.7.0.1
 */