package com.tencent.mobileqq.troop.troopnotification.ui;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

class TroopNotificationFragment$GetUnReadNumRunnable
  implements Runnable
{
  private AppRuntime a;
  private WeakReference<Activity> b;
  private TextView c;
  private ImageView d;
  
  public TroopNotificationFragment$GetUnReadNumRunnable(AppRuntime paramAppRuntime, WeakReference<Activity> paramWeakReference, TextView paramTextView, ImageView paramImageView)
  {
    this.a = paramAppRuntime;
    this.b = paramWeakReference;
    this.c = paramTextView;
    this.d = paramImageView;
  }
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (IMessageFacade)((AppRuntime)localObject).getRuntimeService(IMessageFacade.class, "");
      if (localObject == null) {
        return;
      }
      int i = ((IMessageFacade)localObject).getUnreadMsgsNum();
      ThreadManager.getUIHandler().post(new TroopNotificationFragment.GetUnReadNumRunnable.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.GetUnReadNumRunnable
 * JD-Core Version:    0.7.0.1
 */