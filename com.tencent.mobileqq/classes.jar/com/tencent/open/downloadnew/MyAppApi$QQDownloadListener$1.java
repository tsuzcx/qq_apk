package com.tencent.open.downloadnew;

import bjsz;
import bjtx;
import bjwq;
import bjxd;
import bjxp;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class MyAppApi$QQDownloadListener$1
  implements Runnable
{
  public MyAppApi$QQDownloadListener$1(bjxp parambjxp, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = null;
    int i;
    bjwq localbjwq;
    DownloadInfo localDownloadInfo;
    if (this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
    {
      bjtx.a("State_Log", "OpenSDK onDownloadTaskStateChanged state=" + this.jdField_a_of_type_Int + " errorCode=" + this.b + " param SNGAppId=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName + " version=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion + " uin=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin + " via=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
      i = bjwq.a(this.jdField_a_of_type_Int);
      bjtx.c("State_Log", "onDownloadTaskStateChanged--localState = " + i + "state = " + this.jdField_a_of_type_Int + "errorCode = " + this.b);
      localbjwq = bjwq.a();
      localDownloadInfo = localbjwq.b(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId, i);
      if ((localDownloadInfo != null) || (this.jdField_a_of_type_Int == 6)) {
        break label413;
      }
      localDownloadInfo = this.jdField_a_of_type_Bjxp.a.a(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, null);
      localbjwq.e(localDownloadInfo);
      localbjwq.b(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId, i);
      localObject = null;
    }
    for (;;)
    {
      if (localDownloadInfo != null)
      {
        bjtx.c("State_Log", "onDownloadTaskStateChanged notifyListener localState=" + i + " dlInfo=" + localDownloadInfo.toString());
        localbjwq.a(i, localDownloadInfo, this.b, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        for (;;)
        {
          bjsz.a().a(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_Int, (TMAssistantCallYYBTaskInfo)localObject, this.b, this.jdField_a_of_type_JavaLangString);
          return;
          bjtx.a("State_Log", "OpenSDK onDownloadTaskStateChanged state=" + this.jdField_a_of_type_Int + " errorCode=" + this.b + " param== null");
          return;
          label413:
          if (((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 3)) || (!this.jdField_a_of_type_Bjxp.a.e())) {
            break label571;
          }
          try
          {
            TMAssistantCallYYBTaskInfo localTMAssistantCallYYBTaskInfo = this.jdField_a_of_type_Bjxp.a.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct);
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
              bjtx.a("MyAppApi", "onDownloadTaskStateChanged info progress = " + j);
            }
            localObject = localTMAssistantCallYYBTaskInfo;
          }
          catch (Exception localException)
          {
            bjtx.c("MyAppApi", "getDownloadTaskState>>>", localException);
          }
        }
        break;
        bjtx.c("MyAppApi", "onDownloadTaskStateChanged notifyListener error dlInfo == null");
      }
      label571:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.QQDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */