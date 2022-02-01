package com.tencent.mobileqq.troopcheckin;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class CheckInServer
  extends QIPCModule
{
  public static CheckInServer a;
  private CheckInUploadTask b;
  
  private CheckInServer()
  {
    super("Module_CheckInServer");
  }
  
  public static CheckInServer a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new CheckInServer();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void b()
  {
    CheckInUploadTask localCheckInUploadTask = this.b;
    if (localCheckInUploadTask != null)
    {
      localCheckInUploadTask.d();
      this.b = null;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyUploadResult callbackId");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", data = ");
      localStringBuilder.append(paramBundle.toString());
      QLog.d("Module_CheckInServer", 2, localStringBuilder.toString());
    }
    paramBundle = EIPCResult.createResult(0, paramBundle);
    b();
    callbackResult(paramInt, paramBundle);
  }
  
  public void onAccountChange()
  {
    super.onAccountChange();
    b();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("action = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", params = ");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append(",callbackId=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Module_CheckInServer", 2, ((StringBuilder)localObject).toString());
    }
    b();
    if ((!"ACTION_UPLOAD_PIC".equals(paramString)) && (!"ACTION_UPLOAD_VIDEO".equals(paramString)))
    {
      if ("ACTION_CANCEL".equals(paramString)) {
        b();
      }
    }
    else
    {
      localObject = new CheckInResEntity();
      if ("ACTION_UPLOAD_PIC".equals(paramString))
      {
        ((CheckInResEntity)localObject).a = paramBundle.getString("BUNDLE_NAME_FILEPATH");
        paramString = new CheckInUploadPicTask((CheckInResEntity)localObject, paramInt);
      }
      else
      {
        ((CheckInResEntity)localObject).a = paramBundle.getString("BUNDLE_NAME_FILEPATH");
        ((CheckInResEntity)localObject).b = paramBundle.getString("BUNDLE_NAME_COVER");
        ((CheckInResEntity)localObject).c = paramBundle.getLong("BUNDLE_NAME_VIDEOTIME");
        paramString = new CheckInUploadVideoTask((CheckInResEntity)localObject, paramInt);
      }
      this.b = paramString;
      paramString.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopcheckin.CheckInServer
 * JD-Core Version:    0.7.0.1
 */