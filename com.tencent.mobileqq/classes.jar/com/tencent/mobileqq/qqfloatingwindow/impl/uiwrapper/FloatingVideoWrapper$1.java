package com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenContainer;
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
    this.a.a(true, new View[] { FloatingVideoWrapper.a(this.a) });
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.a.mFloatingContainer != null) && (this.a.mFloatingContainer.getVisibility() != 0))
    {
      this.a.a(true, new View[] { this.a.mFloatingContainer });
      if ((paramBoolean) && (FloatingVideoWrapper.a(this.a) != null) && (FloatingVideoWrapper.a(this.a) == 0))
      {
        FloatingVideoWrapper.a(this.a).notifyVideoStart();
        this.a.a(false, new View[] { FloatingVideoWrapper.a(this.a) });
      }
    }
    else
    {
      return;
    }
    if ((FloatingVideoWrapper.c(this.a) != null) && (FloatingVideoWrapper.c(this.a).getVisibility() == 0))
    {
      this.a.a(false, new View[] { FloatingVideoWrapper.a(this.a) });
      return;
    }
    this.a.a(true, new View[] { FloatingVideoWrapper.a(this.a) });
    FloatingVideoWrapper.a(this.a, 1);
  }
  
  public void b()
  {
    if (FloatingVideoWrapper.a(this.a) != null) {
      FloatingVideoWrapper.a(this.a).notifyVideoStop();
    }
    this.a.a(true, new View[] { FloatingVideoWrapper.a(this.a), FloatingVideoWrapper.a(this.a) });
    this.a.a(false, new View[] { this.a.mFloatingContainer, FloatingVideoWrapper.b(this.a) });
  }
  
  public void c()
  {
    this.a.b(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper.1
 * JD-Core Version:    0.7.0.1
 */