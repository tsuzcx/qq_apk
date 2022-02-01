package com.tencent.open.downloadnew;

import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.base.LogUtility;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

class MyAppApi$QQDownloadListener$1
  implements Runnable
{
  MyAppApi$QQDownloadListener$1(MyAppApi.QQDownloadListener paramQQDownloadListener, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = null;
    int i;
    DownloadManager localDownloadManager;
    DownloadInfo localDownloadInfo;
    if (this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
    {
      LogUtility.a("State_Log", "OpenSDK onDownloadTaskStateChanged state=" + this.jdField_a_of_type_Int + " errorCode=" + this.b + " param SNGAppId=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName + " version=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion + " uin=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin + " via=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
      i = DownloadManager.a(this.jdField_a_of_type_Int);
      LogUtility.c("State_Log", "onDownloadTaskStateChanged--localState = " + i + "state = " + this.jdField_a_of_type_Int + "errorCode = " + this.b);
      localDownloadManager = DownloadManager.a();
      localDownloadInfo = localDownloadManager.b(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId, i);
      if ((localDownloadInfo != null) || (this.jdField_a_of_type_Int == 6)) {
        break label413;
      }
      localDownloadInfo = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$QQDownloadListener.a.a(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, null);
      localDownloadManager.e(localDownloadInfo);
      localDownloadManager.b(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId, i);
      localObject = null;
    }
    for (;;)
    {
      if (localDownloadInfo != null)
      {
        LogUtility.c("State_Log", "onDownloadTaskStateChanged notifyListener localState=" + i + " dlInfo=" + localDownloadInfo.toString());
        localDownloadManager.a(i, localDownloadInfo, this.b, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        for (;;)
        {
          DownloadManagerV2.a().a(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_Int, (TMAssistantCallYYBTaskInfo)localObject, this.b, this.jdField_a_of_type_JavaLangString);
          return;
          LogUtility.a("State_Log", "OpenSDK onDownloadTaskStateChanged state=" + this.jdField_a_of_type_Int + " errorCode=" + this.b + " param== null");
          return;
          label413:
          if (((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 3)) || (!this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$QQDownloadListener.a.e())) {
            break label571;
          }
          try
          {
            TMAssistantCallYYBTaskInfo localTMAssistantCallYYBTaskInfo = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$QQDownloadListener.a.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct);
            if (localTMAssistantCallYYBTaskInfo != null)
            {
              localObject = localTMAssistantCallYYBTaskInfo;
              long l1 = localTMAssistantCallYYBTaskInfo.mReceiveDataLen;
              localObject = localTMAssistantCallYYBTaskInfo;
              long l2 = localTMAssistantCallYYBTaskInfo.mTotalDataLen;
              localObject = localTMAssistantCallYYBTaskInfo;
              int j = (int)((float)l1 * 100.0F / (float)l2);
              localObject = localTMAssistantCallYYBTaskInfo;
              localDownloadInfo.f = j;
              localObject = localTMAssistantCallYYBTaskInfo;
              LogUtility.a("MyAppApi", "onDownloadTaskStateChanged info progress = " + j);
            }
            localObject = localTMAssistantCallYYBTaskInfo;
          }
          catch (Exception localException)
          {
            LogUtility.c("MyAppApi", "getDownloadTaskState>>>", localException);
          }
        }
        break;
        LogUtility.c("MyAppApi", "onDownloadTaskStateChanged notifyListener error dlInfo == null");
      }
      label571:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.QQDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */