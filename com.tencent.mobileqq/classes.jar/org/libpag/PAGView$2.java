package org.libpag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

class PAGView$2
  extends AnimatorListenerAdapter
{
  PAGView$2(PAGView paramPAGView) {}
  
  public void onAnimationCancel(Animator arg1)
  {
    super.onAnimationCancel(???);
    synchronized (this.this$0)
    {
      Iterator localIterator = PAGView.access$400(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((PAGView.PAGViewListener)localIterator.next()).onAnimationCancel(this.this$0);
      }
    }
  }
  
  public void onAnimationEnd(Animator arg1)
  {
    super.onAnimationEnd(???);
    synchronized (this.this$0)
    {
      Iterator localIterator = PAGView.access$400(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((PAGView.PAGViewListener)localIterator.next()).onAnimationEnd(this.this$0);
      }
    }
  }
  
  public void onAnimationRepeat(Animator arg1)
  {
    super.onAnimationRepeat(???);
    synchronized (this.this$0)
    {
      Iterator localIterator = PAGView.access$400(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((PAGView.PAGViewListener)localIterator.next()).onAnimationRepeat(this.this$0);
      }
    }
  }
  
  public void onAnimationStart(Animator arg1)
  {
    super.onAnimationStart(???);
    synchronized (this.this$0)
    {
      Iterator localIterator = PAGView.access$400(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((PAGView.PAGViewListener)localIterator.next()).onAnimationStart(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.libpag.PAGView.2
 * JD-Core Version:    0.7.0.1
 */