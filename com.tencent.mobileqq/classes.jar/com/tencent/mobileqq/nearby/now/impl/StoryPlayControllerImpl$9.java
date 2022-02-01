package com.tencent.mobileqq.nearby.now.impl;

import android.app.Activity;
import com.tencent.mobileqq.nearby.now.view.widget.StoryNewGuideDialog;

class StoryPlayControllerImpl$9
  implements Runnable
{
  StoryPlayControllerImpl$9(StoryPlayControllerImpl paramStoryPlayControllerImpl) {}
  
  public void run()
  {
    if ((StoryPlayControllerImpl.access$400(this.this$0) != null) && (StoryPlayControllerImpl.access$400(this.this$0).isShowing()))
    {
      if (((this.this$0.mContext instanceof Activity)) && ((StoryPlayControllerImpl.access$500(this.this$0)) || (((Activity)this.this$0.mContext).isFinishing())))
      {
        StoryPlayControllerImpl.access$402(this.this$0, null);
        return;
      }
      StoryPlayControllerImpl.access$400(this.this$0).dismiss();
      StoryPlayControllerImpl.access$402(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.impl.StoryPlayControllerImpl.9
 * JD-Core Version:    0.7.0.1
 */