package com.tencent.mobileqq.mini.widget.media;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import java.util.Observable;
import java.util.Observer;

public class MiniAppVideoPlayer$VideoPlayerStatusObserver
  implements Observer
{
  public MiniAppVideoPlayer$VideoPlayerStatusObserver(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof String)) {}
    do
    {
      do
      {
        return;
        if (("resetPlayer".equals((String)paramObject)) && (this.this$0.autoPauseIfNavigate))
        {
          this.this$0.smallScreen();
          this.this$0.stop();
          return;
        }
      } while (!"resumePlayer".equals((String)paramObject));
      paramObservable = this.this$0.webviewContainer.appBrandRuntime;
    } while ((paramObservable == null) || (!paramObservable.isPause));
    this.this$0.smallScreen();
    this.this$0.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.VideoPlayerStatusObserver
 * JD-Core Version:    0.7.0.1
 */