package com.tencent.mobileqq.vas;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.tencent.mobileqq.theme.IDownloadListener;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.QLog;

class QuickUpdateIPCModule$RemoteListener
  implements IBinder.DeathRecipient, QuickUpdateListener
{
  private long jdField_a_of_type_Long;
  private IDownloadListener jdField_a_of_type_ComTencentMobileqqThemeIDownloadListener;
  private String jdField_a_of_type_JavaLangString;
  
  private QuickUpdateIPCModule$RemoteListener(long paramLong, String paramString, IDownloadListener paramIDownloadListener)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqThemeIDownloadListener = paramIDownloadListener;
    try
    {
      paramIDownloadListener.asBinder().linkToDeath(this, 0);
      return;
    }
    catch (RemoteException paramString)
    {
      QLog.e("QuickUpdateIPCModule", 1, "linkToDeath fail: " + this, paramString);
    }
  }
  
  public void binderDied()
  {
    QLog.e("QuickUpdateIPCModule", 1, "binderDied: " + this);
    UpdateCallbackSelector.getCallback(this.jdField_a_of_type_Long).removeListener(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this);
  }
  
  public void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    QLog.e("QuickUpdateIPCModule", 1, "onCompleted: " + paramInt1 + ", " + this);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqThemeIDownloadListener.onComplete(paramString1, paramInt1);
      return;
    }
    catch (RemoteException paramString1)
    {
      QLog.e("QuickUpdateIPCModule", 1, "onCompleted: " + this, paramString1);
    }
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqThemeIDownloadListener.onProgress(paramString1, paramLong2, paramLong3);
      return;
    }
    catch (RemoteException paramString1)
    {
      QLog.e("QuickUpdateIPCModule", 1, "onProgress: " + this, paramString1);
    }
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_Long + "_" + this.jdField_a_of_type_JavaLangString + "," + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.QuickUpdateIPCModule.RemoteListener
 * JD-Core Version:    0.7.0.1
 */