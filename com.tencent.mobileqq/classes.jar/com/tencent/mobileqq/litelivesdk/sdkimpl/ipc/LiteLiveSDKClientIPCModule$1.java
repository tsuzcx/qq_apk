package com.tencent.mobileqq.litelivesdk.sdkimpl.ipc;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.litelivesdk.framework.room.RoomManager;
import com.tencent.mobileqq.litelivesdk.sdkimpl.BaseLiteSDKImpl;

class LiteLiveSDKClientIPCModule$1
  extends BaseLiteSDKImpl
{
  LiteLiveSDKClientIPCModule$1(LiteLiveSDKClientIPCModule paramLiteLiveSDKClientIPCModule) {}
  
  public boolean a(String paramString1, String paramString2)
  {
    RoomManager.a(BaseApplicationImpl.getContext(), paramString2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.ipc.LiteLiveSDKClientIPCModule.1
 * JD-Core Version:    0.7.0.1
 */