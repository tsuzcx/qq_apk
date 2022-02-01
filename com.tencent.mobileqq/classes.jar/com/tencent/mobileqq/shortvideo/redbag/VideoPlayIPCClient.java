package com.tencent.mobileqq.shortvideo.redbag;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class VideoPlayIPCClient
{
  private static volatile VideoPlayIPCClient a;
  
  public static VideoPlayIPCClient a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new VideoPlayIPCClient();
        }
      }
      finally {}
    }
    return a;
  }
  
  public Bundle a(String paramString, Bundle paramBundle)
  {
    boolean bool = "CMD_GET_CURRENT_NICK_NAME".equals(paramString);
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    if (bool)
    {
      paramBundle = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoPlayIPCServer", "CMD_GET_CURRENT_NICK_NAME", paramBundle);
      paramString = (String)localObject1;
      if (paramBundle != null)
      {
        paramString = (String)localObject1;
        if (paramBundle.isSuccess()) {
          paramString = paramBundle.data;
        }
      }
      return paramString;
    }
    if ("CMD_GET_CURRENT_USER_HEAD".equals(paramString))
    {
      paramBundle = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoPlayIPCServer", "CMD_GET_CURRENT_USER_HEAD", paramBundle);
      paramString = localObject2;
      if (paramBundle != null)
      {
        paramString = localObject2;
        if (paramBundle.isSuccess()) {
          paramString = paramBundle.data;
        }
      }
      return paramString;
    }
    if ("CMD_DOWNLOAD_PTU_BASE_RES".equals(paramString))
    {
      paramBundle = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoPlayIPCServer", "CMD_DOWNLOAD_PTU_BASE_RES", paramBundle);
      paramString = localObject3;
      if (paramBundle != null)
      {
        paramString = localObject3;
        if (paramBundle.isSuccess()) {
          paramString = paramBundle.data;
        }
      }
      return paramString;
    }
    localObject1 = localObject4;
    if ("CMD_QUERY_STATUS_PTU_RES".equals(paramString))
    {
      paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoPlayIPCServer", "CMD_QUERY_STATUS_PTU_RES", paramBundle);
      localObject1 = localObject4;
      if (paramString != null)
      {
        localObject1 = localObject4;
        if (paramString.isSuccess()) {
          localObject1 = paramString.data;
        }
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.VideoPlayIPCClient
 * JD-Core Version:    0.7.0.1
 */