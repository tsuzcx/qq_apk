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
    if (this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("OpenSDK onDownloadTaskStateChanged state=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append(" errorCode=");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(" param SNGAppId=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId);
      ((StringBuilder)localObject1).append(" apkId=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId);
      ((StringBuilder)localObject1).append(" taskAppId=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId);
      ((StringBuilder)localObject1).append(" packageName=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName);
      ((StringBuilder)localObject1).append(" version=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion);
      ((StringBuilder)localObject1).append(" uin=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin);
      ((StringBuilder)localObject1).append(" via=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
      LogUtility.a("State_Log", ((StringBuilder)localObject1).toString());
      int i = DownloadManager.a(this.jdField_a_of_type_Int);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDownloadTaskStateChanged--localState = ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("state = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append("errorCode = ");
      ((StringBuilder)localObject1).append(this.b);
      LogUtility.c("State_Log", ((StringBuilder)localObject1).toString());
      DownloadManager localDownloadManager = DownloadManager.a();
      DownloadInfo localDownloadInfo2 = localDownloadManager.b(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId, i);
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject2;
      DownloadInfo localDownloadInfo1;
      if ((localDownloadInfo2 == null) && (this.jdField_a_of_type_Int != 6))
      {
        localObject2 = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$QQDownloadListener.a.a(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, null);
        localDownloadManager.e((DownloadInfo)localObject2);
        localDownloadManager.b(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId, i);
        localObject1 = localObject3;
      }
      else
      {
        int j = this.jdField_a_of_type_Int;
        if (j != 2)
        {
          localObject2 = localDownloadInfo2;
          localObject1 = localObject3;
          if (j != 3) {}
        }
        else
        {
          localObject2 = localDownloadInfo2;
          localObject1 = localObject3;
          if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$QQDownloadListener.a.e())
          {
            localObject1 = localObject4;
            try
            {
              localObject3 = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$QQDownloadListener.a.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct);
              localObject2 = localDownloadInfo2;
              localObject1 = localObject3;
              if (localObject3 != null)
              {
                localObject1 = localObject3;
                long l1 = ((TMAssistantCallYYBTaskInfo)localObject3).mReceiveDataLen;
                localObject1 = localObject3;
                long l2 = ((TMAssistantCallYYBTaskInfo)localObject3).mTotalDataLen;
                localObject1 = localObject3;
                j = (int)((float)l1 * 100.0F / (float)l2);
                localObject1 = localObject3;
                localDownloadInfo2.f = j;
                localObject1 = localObject3;
                localObject2 = new StringBuilder();
                localObject1 = localObject3;
                ((StringBuilder)localObject2).append("onDownloadTaskStateChanged info progress = ");
                localObject1 = localObject3;
                ((StringBuilder)localObject2).append(j);
                localObject1 = localObject3;
                LogUtility.a("MyAppApi", ((StringBuilder)localObject2).toString());
                localObject2 = localDownloadInfo2;
                localObject1 = localObject3;
              }
            }
            catch (Exception localException)
            {
              LogUtility.c("MyAppApi", "getDownloadTaskState>>>", localException);
              localDownloadInfo1 = localDownloadInfo2;
            }
          }
        }
      }
      if (localDownloadInfo1 != null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onDownloadTaskStateChanged notifyListener localState=");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append(" dlInfo=");
        ((StringBuilder)localObject3).append(localDownloadInfo1.toString());
        LogUtility.c("State_Log", ((StringBuilder)localObject3).toString());
        localDownloadManager.a(i, localDownloadInfo1, this.b, this.jdField_a_of_type_JavaLangString);
      }
      else
      {
        LogUtility.c("MyAppApi", "onDownloadTaskStateChanged notifyListener error dlInfo == null");
      }
      DownloadManagerV2.a().a(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_Int, (TMAssistantCallYYBTaskInfo)localObject1, this.b, this.jdField_a_of_type_JavaLangString);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("OpenSDK onDownloadTaskStateChanged state=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject1).append(" errorCode=");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(" param== null");
    LogUtility.a("State_Log", ((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.QQDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */