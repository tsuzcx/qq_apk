package com.tencent.mobileqq.shortvideo.redbag;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.utils.ContactUtils;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResManager;
import dov.com.qq.im.ae.util.AEQLog;
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
    if ("CMD_GET_NICK_NAME_BY_UIN".equals(paramString))
    {
      paramString = new Bundle();
      paramString.putString("VALUE_USER_NICK_NAME", ContactUtils.c(localQQAppInterface, paramBundle.getString("VALUE_USER_UIN_TO_GET_NICK_NAME"), true));
      return EIPCResult.createSuccessResult(paramString);
    }
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
    if ("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT".equals(paramString))
    {
      paramString = paramBundle.getString("VALUE_MSG_FRIENDUIN");
      paramInt = paramBundle.getInt("VALUE_MSG_ISTROOP");
      paramBundle = paramBundle.getString("VALUE_MSG_VIDEO_ID");
      if (paramBundle != null)
      {
        RedBagVideoManager.a(localQQAppInterface).a(paramString, paramInt, paramBundle);
        VideoRedbagData.updateRewardStat(paramBundle);
      }
      return EIPCResult.createSuccessResult(new Bundle());
    }
    if ("CMD_QUERY_VIDEO_REDBAG_STAT".equals(paramString))
    {
      boolean bool = VideoRedbagData.queryRewardStat(paramBundle.getString("VALUE_MSG_VIDEO_ID"));
      paramString = new Bundle();
      paramString.putBoolean("VALUE_MSG_REDBAG_STAT", bool);
      return EIPCResult.createSuccessResult(paramString);
    }
    if ("CMD_DOWNLOAD_PTU_BASE_RES".equals(paramString))
    {
      AEResManager.a().a(AEResInfo.b, null, false);
      AEQLog.b("VideoPlayIPCServer", "launchForResult requestAEKitDownload : AEKIT_ADDITIONAL_PACKAGE");
      return EIPCResult.createSuccessResult(new Bundle());
    }
    if ("CMD_QUERY_STATUS_PTU_RES".equals(paramString))
    {
      if ((paramBundle != null) && (paramBundle.getString("VALUE_MSG_LIGHT_BUNDLE_PREFIX") != null))
      {
        paramString = AEResInfo.a(paramBundle.getString("VALUE_MSG_LIGHT_BUNDLE_PREFIX"));
        if (paramString == null) {
          break label379;
        }
        paramInt = AEResManager.a().a(paramString);
        AEQLog.b("PreCheckAERes", "query additional_package:" + paramBundle.getString("VALUE_MSG_LIGHT_BUNDLE_PREFIX") + " result:" + paramInt);
      }
      for (;;)
      {
        paramString = new Bundle();
        paramString.putInt("VALUE_MSG_PTU_RES_STATUS", paramInt);
        return EIPCResult.createSuccessResult(paramString);
        AEQLog.d("VideoPlayIPCServer", "query additional_package:params is null");
        label379:
        paramInt = 0;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.VideoPlayIPCServer.1
 * JD-Core Version:    0.7.0.1
 */