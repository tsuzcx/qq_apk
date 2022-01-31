package com.tencent.open.downloadnew;

import bfkr;
import bflp;
import bfok;
import bfox;
import bfpj;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class MyAppApi$QQDownloadListener$1
  implements Runnable
{
  public MyAppApi$QQDownloadListener$1(bfpj parambfpj, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = null;
    int i;
    bfok localbfok;
    DownloadInfo localDownloadInfo;
    if (this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
    {
      bflp.a("State_Log", "OpenSDK onDownloadTaskStateChanged state=" + this.jdField_a_of_type_Int + " errorCode=" + this.b + " param SNGAppId=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskPackageName + " version=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.taskVersion + " uin=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.uin + " via=" + this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.via);
      i = bfok.a(this.jdField_a_of_type_Int);
      bflp.c("State_Log", "onDownloadTaskStateChanged--localState = " + i + "state = " + this.jdField_a_of_type_Int + "errorCode = " + this.b);
      localbfok = bfok.a();
      localDownloadInfo = localbfok.b(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId, i);
      if ((localDownloadInfo != null) || (this.jdField_a_of_type_Int == 6)) {
        break label413;
      }
      localDownloadInfo = this.jdField_a_of_type_Bfpj.a.a(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, null);
      localbfok.e(localDownloadInfo);
      localbfok.b(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.SNGAppId, i);
      localObject = null;
    }
    for (;;)
    {
      if (localDownloadInfo != null)
      {
        bflp.c("State_Log", "onDownloadTaskStateChanged notifyListener localState=" + i + " dlInfo=" + localDownloadInfo.toString());
        localbfok.a(i, localDownloadInfo, this.b, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        for (;;)
        {
          bfkr.a().a(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, this.jdField_a_of_type_Int, (TMAssistantCallYYBTaskInfo)localObject, this.b, this.jdField_a_of_type_JavaLangString);
          return;
          bflp.a("State_Log", "OpenSDK onDownloadTaskStateChanged state=" + this.jdField_a_of_type_Int + " errorCode=" + this.b + " param== null");
          return;
          label413:
          if (((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 3)) || (!this.jdField_a_of_type_Bfpj.a.e())) {
            break label571;
          }
          try
          {
            TMAssistantCallYYBTaskInfo localTMAssistantCallYYBTaskInfo = this.jdField_a_of_type_Bfpj.a.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct);
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
              bflp.a("MyAppApi", "onDownloadTaskStateChanged info progress = " + j);
            }
            localObject = localTMAssistantCallYYBTaskInfo;
          }
          catch (Exception localException)
          {
            bflp.c("MyAppApi", "getDownloadTaskState>>>", localException);
          }
        }
        break;
        bflp.c("MyAppApi", "onDownloadTaskStateChanged notifyListener error dlInfo == null");
      }
      label571:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.QQDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */