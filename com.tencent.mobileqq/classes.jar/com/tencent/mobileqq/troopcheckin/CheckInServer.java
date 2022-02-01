package com.tencent.mobileqq.troopcheckin;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class CheckInServer
  extends QIPCModule
{
  public static CheckInServer a;
  private CheckInUploadTask a;
  
  private CheckInServer()
  {
    super("Module_CheckInServer");
  }
  
  public static CheckInServer a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopcheckinCheckInServer == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTroopcheckinCheckInServer == null) {
        jdField_a_of_type_ComTencentMobileqqTroopcheckinCheckInServer = new CheckInServer();
      }
      return jdField_a_of_type_ComTencentMobileqqTroopcheckinCheckInServer;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopcheckinCheckInUploadTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopcheckinCheckInUploadTask.d();
      this.jdField_a_of_type_ComTencentMobileqqTroopcheckinCheckInUploadTask = null;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Module_CheckInServer", 2, "notifyUploadResult callbackId" + paramInt + ", data = " + paramBundle.toString());
    }
    paramBundle = EIPCResult.createResult(0, paramBundle);
    a();
    callbackResult(paramInt, paramBundle);
  }
  
  public void onAccountChange()
  {
    super.onAccountChange();
    a();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Module_CheckInServer", 2, "action = " + paramString + ", params = " + paramBundle + ",callbackId=" + paramInt);
    }
    a();
    CheckInResEntity localCheckInResEntity;
    if (("ACTION_UPLOAD_PIC".equals(paramString)) || ("ACTION_UPLOAD_VIDEO".equals(paramString)))
    {
      localCheckInResEntity = new CheckInResEntity();
      if ("ACTION_UPLOAD_PIC".equals(paramString))
      {
        localCheckInResEntity.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
        paramString = new CheckInUploadPicTask(localCheckInResEntity, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqTroopcheckinCheckInUploadTask = paramString;
        paramString.a();
      }
    }
    for (;;)
    {
      return null;
      localCheckInResEntity.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
      localCheckInResEntity.b = paramBundle.getString("BUNDLE_NAME_COVER");
      localCheckInResEntity.jdField_a_of_type_Long = paramBundle.getLong("BUNDLE_NAME_VIDEOTIME");
      paramString = new CheckInUploadVideoTask(localCheckInResEntity, paramInt);
      break;
      if ("ACTION_CANCEL".equals(paramString)) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopcheckin.CheckInServer
 * JD-Core Version:    0.7.0.1
 */