package com.tencent.qqmini.sdk.widget.media;

import java.util.Observable;
import java.util.Observer;

class MiniAppVideoController$14
  implements Observer
{
  MiniAppVideoController$14(MiniAppVideoController paramMiniAppVideoController) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      return;
    }
    paramObservable = (String)paramObject;
    if (("resetPlayer".equals(paramObservable)) && (MiniAppVideoController.access$000(this.this$0).autoPauseIfNavigate))
    {
      this.this$0.smallScreen();
      this.this$0.stop();
      return;
    }
    "resumePlayer".equals(paramObservable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.14
 * JD-Core Version:    0.7.0.1
 */