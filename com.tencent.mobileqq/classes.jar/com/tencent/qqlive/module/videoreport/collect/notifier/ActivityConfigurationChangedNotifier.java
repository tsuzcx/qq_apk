package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.app.Activity;
import android.content.res.Configuration;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

public class ActivityConfigurationChangedNotifier
  implements IEventNotifier
{
  private Activity mActivity;
  private Configuration mConfiguration;
  
  public int getReuseType()
  {
    return 9;
  }
  
  public void init(Activity paramActivity, Configuration paramConfiguration)
  {
    this.mActivity = paramActivity;
    this.mConfiguration = paramConfiguration;
  }
  
  public void notifyEvent(IEventListener paramIEventListener)
  {
    paramIEventListener.onActivityConfigurationChanged(this.mActivity, this.mConfiguration);
  }
  
  public void reset()
  {
    this.mActivity = null;
    this.mConfiguration = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.notifier.ActivityConfigurationChangedNotifier
 * JD-Core Version:    0.7.0.1
 */