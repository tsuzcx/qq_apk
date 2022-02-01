package com.tencent.qqmini.sdk.widget.media;

import java.util.Observable;
import java.util.Observer;

class MiniAppVideoController$14
  implements Observer
{
  MiniAppVideoController$14(MiniAppVideoController paramMiniAppVideoController) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof String)) {}
    do
    {
      return;
      if (("resetPlayer".equals((String)paramObject)) && (MiniAppVideoController.access$800(this.this$0).autoPauseIfNavigate))
      {
        this.this$0.smallScreen();
        this.this$0.stop();
        return;
      }
    } while (!"resumePlayer".equals((String)paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.14
 * JD-Core Version:    0.7.0.1
 */