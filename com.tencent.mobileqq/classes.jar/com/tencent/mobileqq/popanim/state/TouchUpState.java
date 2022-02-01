package com.tencent.mobileqq.popanim.state;

import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.MobileQQ;

public class TouchUpState
  extends BaseState
{
  protected TouchUpState(RelativeLayout paramRelativeLayout, StateContext paramStateContext)
  {
    super(paramRelativeLayout, paramStateContext);
  }
  
  public void a(BaseState paramBaseState)
  {
    this.c.g.removeStickerMaskOnPanel();
    if (this.c.k)
    {
      paramBaseState = MobileQQ.sMobileQQ.waitAppRuntime(null);
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(paramBaseState, "StickerBubble", false);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
      this.c.a();
    }
    return true;
  }
  
  public void b(BaseState paramBaseState) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.state.TouchUpState
 * JD-Core Version:    0.7.0.1
 */