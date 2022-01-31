package com.tencent.mobileqq.nearby.now;

import android.app.Activity;
import atnk;

class StoryPlayController$9
  implements Runnable
{
  StoryPlayController$9(StoryPlayController paramStoryPlayController) {}
  
  public void run()
  {
    if ((StoryPlayController.a(this.this$0) != null) && (StoryPlayController.a(this.this$0).isShowing()))
    {
      if (((this.this$0.a instanceof Activity)) && ((StoryPlayController.b(this.this$0)) || (((Activity)this.this$0.a).isFinishing()))) {
        StoryPlayController.a(this.this$0, null);
      }
    }
    else {
      return;
    }
    StoryPlayController.a(this.this$0).dismiss();
    StoryPlayController.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.StoryPlayController.9
 * JD-Core Version:    0.7.0.1
 */