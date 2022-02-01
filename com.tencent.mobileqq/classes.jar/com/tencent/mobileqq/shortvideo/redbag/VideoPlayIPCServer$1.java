package com.tencent.mobileqq.shortvideo.redbag;

import android.os.Bundle;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResult;

class VideoPlayIPCServer$1
  extends QIPCModule
{
  VideoPlayIPCServer$1(VideoPlayIPCServer paramVideoPlayIPCServer, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ("CMD_GET_CURRENT_NICK_NAME".equals(paramString))
    {
      paramString = localQQAppInterface.getCurrentNickname();
      paramBundle = new Bundle();
      paramBundle.putString("VALUE_GET_CURRENT_NICK_NAME", paramString);
      return EIPCResult.createSuccessResult(paramBundle);
    }
    if ("CMD_GET_CURRENT_USER_HEAD".equals(paramString))
    {
      paramString = localQQAppInterface.getCustomFaceFilePath(1, localQQAppInterface.getCurrentUin(), 200);
      paramBundle = new Bundle();
      paramBundle.putString("VALUE_GET_CURRENT_USER_HEAD", paramString);
      return EIPCResult.createSuccessResult(paramBundle);
    }
    boolean bool = "CMD_DOWNLOAD_PTU_BASE_RES".equals(paramString);
    paramInt = 0;
    if (bool)
    {
      ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.AE_RES_BASE_PACKAGE, null, false);
      AEQLog.b("VideoPlayIPCServer", "launchForResult requestAEKitDownload : AEKIT_ADDITIONAL_PACKAGE");
      return EIPCResult.createSuccessResult(new Bundle());
    }
    if ("CMD_QUERY_STATUS_PTU_RES".equals(paramString))
    {
      if ((paramBundle != null) && (paramBundle.getString("VALUE_MSG_LIGHT_BUNDLE_PREFIX") != null))
      {
        paramString = AEResInfo.getAEResInfoByPrefix(paramBundle.getString("VALUE_MSG_LIGHT_BUNDLE_PREFIX"));
        if (paramString != null)
        {
          paramInt = ((IAEResDownload)QRoute.api(IAEResDownload.class)).getResPackageStatus(paramString);
          paramString = new StringBuilder();
          paramString.append("query additional_package:");
          paramString.append(paramBundle.getString("VALUE_MSG_LIGHT_BUNDLE_PREFIX"));
          paramString.append(" result:");
          paramString.append(paramInt);
          AEQLog.b("PreCheckAERes", paramString.toString());
        }
      }
      else
      {
        AEQLog.d("VideoPlayIPCServer", "query additional_package:params is null");
      }
      paramString = new Bundle();
      paramString.putInt("VALUE_MSG_PTU_RES_STATUS", paramInt);
      return EIPCResult.createSuccessResult(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.VideoPlayIPCServer.1
 * JD-Core Version:    0.7.0.1
 */