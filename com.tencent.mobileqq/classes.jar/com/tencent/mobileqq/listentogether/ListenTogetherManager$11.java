package com.tencent.mobileqq.listentogether;

import com.tencent.mobileqq.app.BaseActivity;
import mqq.util.WeakReference;

class ListenTogetherManager$11
  implements OnJoinListenTogetherCallback
{
  ListenTogetherManager$11(ListenTogetherManager paramListenTogetherManager, WeakReference paramWeakReference, int paramInt, String paramString) {}
  
  public void a()
  {
    BaseActivity localBaseActivity = (BaseActivity)this.a.get();
    if ((!ListenTogetherManager.p(this.d)) && (localBaseActivity != null))
    {
      if (localBaseActivity.isFinishing()) {
        return;
      }
      ListenTogetherManager.a(ListenTogetherManager.j(this.d)).a(localBaseActivity, this.b, this.c, 1002);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.11
 * JD-Core Version:    0.7.0.1
 */