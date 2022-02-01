package com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowStatusListener;

class FloatingVideoWrapper$1
  implements IWindowStatusListener
{
  FloatingVideoWrapper$1(FloatingVideoWrapper paramFloatingVideoWrapper) {}
  
  public void a()
  {
    if (FloatingVideoWrapper.a(this.a) != null)
    {
      FloatingVideoWrapper.a(this.a).notifyVideoStop();
      FloatingVideoWrapper.a(this.a, 1);
    }
    FloatingVideoWrapper localFloatingVideoWrapper = this.a;
    localFloatingVideoWrapper.a(true, new View[] { FloatingVideoWrapper.b(localFloatingVideoWrapper) });
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!this.a.n()) && (this.a.k() != 0))
    {
      this.a.a(true);
      if ((paramBoolean) && (FloatingVideoWrapper.a(this.a) != null) && (FloatingVideoWrapper.e(this.a) == 0))
      {
        FloatingVideoWrapper.a(this.a).notifyVideoStart();
        localFloatingVideoWrapper = this.a;
        localFloatingVideoWrapper.a(false, new View[] { FloatingVideoWrapper.b(localFloatingVideoWrapper) });
        return;
      }
      if ((FloatingVideoWrapper.f(this.a) != null) && (FloatingVideoWrapper.f(this.a).getVisibility() == 0))
      {
        localFloatingVideoWrapper = this.a;
        localFloatingVideoWrapper.a(false, new View[] { FloatingVideoWrapper.b(localFloatingVideoWrapper) });
        return;
      }
      FloatingVideoWrapper localFloatingVideoWrapper = this.a;
      localFloatingVideoWrapper.a(true, new View[] { FloatingVideoWrapper.b(localFloatingVideoWrapper) });
      FloatingVideoWrapper.a(this.a, 1);
    }
  }
  
  public void b()
  {
    if (FloatingVideoWrapper.a(this.a) != null) {
      FloatingVideoWrapper.a(this.a).notifyVideoStop();
    }
    FloatingVideoWrapper localFloatingVideoWrapper = this.a;
    localFloatingVideoWrapper.a(true, new View[] { FloatingVideoWrapper.b(localFloatingVideoWrapper), FloatingVideoWrapper.c(this.a) });
    localFloatingVideoWrapper = this.a;
    localFloatingVideoWrapper.a(false, new View[] { FloatingVideoWrapper.d(localFloatingVideoWrapper) });
    this.a.a(false);
  }
  
  public void c()
  {
    this.a.a(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.1
 * JD-Core Version:    0.7.0.1
 */