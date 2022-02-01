package com.tencent.qqmini.sdk.core.manager;

import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IRequestPermissionsResultListener;
import java.util.ArrayList;
import java.util.Iterator;

public class ActivityResultManager
{
  public static final int ACTION_REQUEST_API_PERMISSION = 5;
  public static final int ACTION_REQUEST_CODE_CAMERA = 4;
  public static final int ACTION_REQUEST_CODE_CHOOSE_LOCATION = 3;
  public static final int ACTION_REQUEST_CODE_CHOOSE_MESSAGE_FILE = 6001;
  public static final int ACTION_REQUEST_CODE_GAME_PAY_BY_FRIEND_H5 = 3004;
  public static final int ACTION_REQUEST_CODE_GAME_PAY_BY_H5 = 3003;
  public static final int ACTION_REQUEST_CODE_GAME_PAY_BY_WX_H5 = 3005;
  public static final int ACTION_REQUEST_CODE_GAME_PAY_THROUGH_TOOL = 3002;
  public static final int ACTION_REQUEST_CODE_GET_VIDEO = 2;
  public static final int ACTION_REQUEST_CODE_LOAD_MINI_CONF = 1;
  public static final int ACTION_REQUEST_CODE_PAY = 3001;
  public static final int ACTION_REQUEST_INTERSTITIAL_AD = 10001;
  public static final int ACTION_REQUEST_OPEN_BLUETOOTH = 6;
  public static final int ACTION_REQUEST_OPEN_GROUP_API = 9;
  public static final int ACTION_REQUEST_OPEN_GROUP_SELECTMEMBERS = 10;
  public static final int ACTION_REQUEST_PERMISSION = 9527;
  public static final int ACTION_REQUEST_PERMISSION_ACCESS_FINE_LOCATION = 9528;
  public static final int ACTION_REQUEST_SELECT_PHOTO = 8;
  public static final int ACTION_REQUEST_SHARE = 7;
  public static final String TAG = "ActivityResultManager";
  private static final ActivityResultManager sInstance = new ActivityResultManager();
  private ArrayList<IActivityResultListener> mActivityResultListenerList;
  private ArrayList<IRequestPermissionsResultListener> mRequestPermissionsResultListenerList;
  
  public static ActivityResultManager g()
  {
    return sInstance;
  }
  
  public void addActivityResultListener(IActivityResultListener paramIActivityResultListener)
  {
    QMLog.d("ActivityResultManager", "addActivityResultListener " + paramIActivityResultListener);
    if (paramIActivityResultListener == null) {
      return;
    }
    try
    {
      if (this.mActivityResultListenerList == null) {
        this.mActivityResultListenerList = new ArrayList();
      }
      this.mActivityResultListenerList.add(paramIActivityResultListener);
      return;
    }
    catch (Throwable paramIActivityResultListener)
    {
      QMLog.e("ActivityResultManager", paramIActivityResultListener.getMessage(), paramIActivityResultListener);
    }
  }
  
  public void addRequestPermissionResultListener(IRequestPermissionsResultListener paramIRequestPermissionsResultListener)
  {
    QMLog.d("ActivityResultManager", "addRequestPermissionResultListener " + paramIRequestPermissionsResultListener);
    if (paramIRequestPermissionsResultListener == null) {
      return;
    }
    try
    {
      if (this.mRequestPermissionsResultListenerList == null) {
        this.mRequestPermissionsResultListenerList = new ArrayList();
      }
      this.mRequestPermissionsResultListenerList.add(paramIRequestPermissionsResultListener);
      return;
    }
    catch (Throwable paramIRequestPermissionsResultListener)
    {
      QMLog.e("ActivityResultManager", paramIRequestPermissionsResultListener.getMessage(), paramIRequestPermissionsResultListener);
    }
  }
  
  public void notifyActivityResultListener(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QMLog.d("ActivityResultManager", "notifyActivityResultListener requestCode:" + paramInt1 + " resultCode:" + paramInt2);
    if ((this.mActivityResultListenerList == null) || (this.mActivityResultListenerList.size() == 0))
    {
      QMLog.e("ActivityResultManager", "mActivityResultListenerList == null || mActivityResultListenerList.size() == 0");
      return;
    }
    try
    {
      synchronized (this.mActivityResultListenerList)
      {
        Iterator localIterator = this.mActivityResultListenerList.iterator();
        while (localIterator.hasNext())
        {
          IActivityResultListener localIActivityResultListener = (IActivityResultListener)localIterator.next();
          if (localIActivityResultListener.doOnActivityResult(paramInt1, paramInt2, paramIntent))
          {
            QMLog.d("ActivityResultManager", "triggerListener " + localIActivityResultListener);
            return;
          }
        }
      }
    }
    catch (Throwable paramIntent)
    {
      QMLog.e("ActivityResultManager", paramIntent.getMessage(), paramIntent);
      return;
    }
  }
  
  public void notifyRequestPermissionResultListener(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QMLog.d("ActivityResultManager", "notifyRequestPermissionResultListener requestCode:" + paramInt + " permission:" + paramArrayOfString);
    if ((this.mRequestPermissionsResultListenerList == null) || (this.mRequestPermissionsResultListenerList.size() == 0))
    {
      QMLog.e("ActivityResultManager", "mActivityResultListenerList == null || mActivityResultListenerList.size() == 0");
      return;
    }
    try
    {
      synchronized (this.mRequestPermissionsResultListenerList)
      {
        Iterator localIterator = this.mRequestPermissionsResultListenerList.iterator();
        while (localIterator.hasNext())
        {
          IRequestPermissionsResultListener localIRequestPermissionsResultListener = (IRequestPermissionsResultListener)localIterator.next();
          if (localIRequestPermissionsResultListener.doOnRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt))
          {
            QMLog.d("ActivityResultManager", "triggerListener " + localIRequestPermissionsResultListener);
            return;
          }
        }
      }
    }
    catch (Throwable paramArrayOfString)
    {
      QMLog.e("ActivityResultManager", paramArrayOfString.getMessage(), paramArrayOfString);
      return;
    }
  }
  
  public void removeActivityResultListener(IActivityResultListener paramIActivityResultListener)
  {
    QMLog.d("ActivityResultManager", "removeActivityResultListener " + paramIActivityResultListener);
    if (paramIActivityResultListener != null) {
      try
      {
        if (this.mActivityResultListenerList == null) {
          return;
        }
        this.mActivityResultListenerList.remove(paramIActivityResultListener);
        return;
      }
      catch (Throwable paramIActivityResultListener)
      {
        QMLog.e("ActivityResultManager", paramIActivityResultListener.getMessage(), paramIActivityResultListener);
      }
    }
  }
  
  public void removeRequestPermissionResultListener(IRequestPermissionsResultListener paramIRequestPermissionsResultListener)
  {
    QMLog.d("ActivityResultManager", "removeRequestPermissionResultListener " + paramIRequestPermissionsResultListener);
    if (paramIRequestPermissionsResultListener != null) {
      try
      {
        if (this.mRequestPermissionsResultListenerList == null) {
          return;
        }
        this.mRequestPermissionsResultListenerList.remove(paramIRequestPermissionsResultListener);
        return;
      }
      catch (Throwable paramIRequestPermissionsResultListener)
      {
        QMLog.e("ActivityResultManager", paramIRequestPermissionsResultListener.getMessage(), paramIRequestPermissionsResultListener);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ActivityResultManager
 * JD-Core Version:    0.7.0.1
 */