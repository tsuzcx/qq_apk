package com.tencent.mobileqq.microapp.widget.media;

import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import java.util.Observable;
import java.util.Observer;

public final class MiniAppVideoPlayer$a
  implements Observer
{
  public MiniAppVideoPlayer$a(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramObservable = (String)paramObject;
      if ("resetPlayer".equals(paramObservable))
      {
        this.a.g();
        this.a.a();
        return;
      }
      if ("resumePlayer".equals(paramObservable))
      {
        paramObservable = this.a.n.appBrandRuntime;
        if (paramObservable == null) {
          return;
        }
        if (paramObservable.j)
        {
          this.a.g();
          this.a.a();
          return;
        }
        this.a.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.MiniAppVideoPlayer.a
 * JD-Core Version:    0.7.0.1
 */