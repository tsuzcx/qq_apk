package com.tencent.open.downloadnew;

import bjjq;
import bjko;
import bjna;
import bjnn;
import bjnz;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class MyAppApi$QQDownloadListener$1
  implements Runnable
{
  public MyAppApi$QQDownloadListener$1(bjnz parambjnz, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = null;
    int i;
    bjna localbjna;
    DownloadInfo localDownloadInfo;
    if (this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
    {
      bjko.a("State_Log", "OpenSDK onDownloadTaskStateChanged state=" + this.jdField_a_of_type_Int + " errorCode=" + this.b + " param SNGAppId=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName + " version=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion + " uin=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin + " via=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
      i = bjna.a(this.jdField_a_of_type_Int);
      bjko.c("State_Log", "onDownloadTaskStateChanged--localState = " + i + "state = " + this.jdField_a_of_type_Int + "errorCode = " + this.b);
      localbjna = bjna.a();
      localDownloadInfo = localbjna.b(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId, i);
      if ((localDownloadInfo != null) || (this.jdField_a_of_type_Int == 6)) {
        break label413;
      }
      localDownloadInfo = this.jdField_a_of_type_Bjnz.a.a(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, null);
      localbjna.e(localDownloadInfo);
      localbjna.b(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId, i);
      localObject = null;
    }
    for (;;)
    {
      if (localDownloadInfo != null)
      {
        bjko.c("State_Log", "onDownloadTaskStateChanged notifyListener localState=" + i + " dlInfo=" + localDownloadInfo.toString());
        localbjna.a(i, localDownloadInfo, this.b, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        for (;;)
        {
          bjjq.a().a(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_Int, (TMAssistantCallYYBTaskInfo)localObject, this.b, this.jdField_a_of_type_JavaLangString);
          return;
          bjko.a("State_Log", "OpenSDK onDownloadTaskStateChanged state=" + this.jdField_a_of_type_Int + " errorCode=" + this.b + " param== null");
          return;
          label413:
          if (((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 3)) || (!this.jdField_a_of_type_Bjnz.a.e())) {
            break label571;
          }
          try
          {
            TMAssistantCallYYBTaskInfo localTMAssistantCallYYBTaskInfo = this.jdField_a_of_type_Bjnz.a.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct);
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
              bjko.a("MyAppApi", "onDownloadTaskStateChanged info progress = " + j);
            }
            localObject = localTMAssistantCallYYBTaskInfo;
          }
          catch (Exception localException)
          {
            bjko.c("MyAppApi", "getDownloadTaskState>>>", localException);
          }
        }
        break;
        bjko.c("MyAppApi", "onDownloadTaskStateChanged notifyListener error dlInfo == null");
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