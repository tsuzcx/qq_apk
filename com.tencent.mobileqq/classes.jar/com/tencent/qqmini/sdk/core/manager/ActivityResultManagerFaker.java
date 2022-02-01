package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IRequestPermissionsResultListener;

@MiniKeep
public class ActivityResultManagerFaker
  implements IActivityResultManager
{
  public void addActivityResultListener(IActivityResultListener paramIActivityResultListener)
  {
    ActivityResultManager.g().addActivityResultListener(paramIActivityResultListener);
  }
  
  public void addRequestPermissionResultListener(IRequestPermissionsResultListener paramIRequestPermissionsResultListener)
  {
    ActivityResultManager.g().addRequestPermissionResultListener(paramIRequestPermissionsResultListener);
  }
  
  public void removeActivityResultListener(IActivityResultListener paramIActivityResultListener)
  {
    ActivityResultManager.g().removeActivityResultListener(paramIActivityResultListener);
  }
  
  public void removeRequestPermissionResultListener(IRequestPermissionsResultListener paramIRequestPermissionsResultListener)
  {
    ActivityResultManager.g().removeRequestPermissionResultListener(paramIRequestPermissionsResultListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ActivityResultManagerFaker
 * JD-Core Version:    0.7.0.1
 */