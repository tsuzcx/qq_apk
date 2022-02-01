package com.tencent.mobileqq.litelivesdk;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.sdkimpl.LiteSDKForImmutableProcess;
import com.tencent.mobileqq.litelivesdk.sdkimpl.ipc.LiteSDKForCrossProcess;

public class LiteLiveSDKFactory
{
  public static ILiveSDK a()
  {
    if (BaseApplicationImpl.getApplication().getQQProcessName().equals("com.tencent.mobileqq")) {
      return LiteSDKForCrossProcess.a();
    }
    return LiteSDKForImmutableProcess.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory
 * JD-Core Version:    0.7.0.1
 */