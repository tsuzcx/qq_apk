package com.tencent.mobileqq.troop.troopnotification;

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
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  
  public TroopNotificationFragment$GetUnReadNumRunnable(AppRuntime paramAppRuntime, WeakReference<Activity> paramWeakReference, TextView paramTextView, ImageView paramImageView)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.GetUnReadNumRunnable
 * JD-Core Version:    0.7.0.1
 */