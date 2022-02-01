package com.tencent.mobileqq.emoticonview.api.impl;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XPanelContainer;

public class AIOPanelInteractionListener
  implements IPanelInteractionListener
{
  private BaseChatPie baseChatPie;
  
  public AIOPanelInteractionListener(BaseChatPie paramBaseChatPie)
  {
    this.baseChatPie = paramBaseChatPie;
  }
  
  public void addView(View paramView)
  {
    if (this.baseChatPie != null) {
      this.baseChatPie.c(paramView);
    }
  }
  
  public int getDefaultExternalPanelHeight()
  {
    return XPanelContainer.b;
  }
  
  public int getExternalPanelheight()
  {
    return XPanelContainer.a;
  }
  
  public int getRootViewHeight()
  {
    if (this.baseChatPie != null) {
      return this.baseChatPie.i();
    }
    return 0;
  }
  
  public void onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.baseChatPie != null) {
      this.baseChatPie.c(paramMotionEvent);
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.baseChatPie != null) {
      this.baseChatPie.d(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.AIOPanelInteractionListener
 * JD-Core Version:    0.7.0.1
 */