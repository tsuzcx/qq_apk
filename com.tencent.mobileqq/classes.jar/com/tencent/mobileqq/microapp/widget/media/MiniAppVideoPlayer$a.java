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
      if (!"resetPlayer".equals((String)paramObject)) {
        break label34;
      }
      this.a.g();
      this.a.a();
    }
    label34:
    do
    {
      do
      {
        return;
      } while (!"resumePlayer".equals((String)paramObject));
      paramObservable = this.a.n.appBrandRuntime;
    } while (paramObservable == null);
    if (paramObservable.j)
    {
      this.a.g();
      this.a.a();
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.MiniAppVideoPlayer.a
 * JD-Core Version:    0.7.0.1
 */