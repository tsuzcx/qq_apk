package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IProtocolManager;
import com.tencent.mobileqq.filemanager.app.ProtocolFileCallback.OnForwardOfflineResult;
import com.tencent.mobileqq.filemanager.app.ProtocolFileCallback.OnSendLocalFileToBuddy;
import com.tencent.mobileqq.filemanager.app.ProtocolFileCallback.SetSendBuddyFileSuccessResult;
import com.tencent.mobileqq.filemanager.app.ProtocolFileInfo;
import com.tencent.mobileqq.filemanager.app.ProtocolManager;
import mqq.app.AppRuntime;

public class ProtocolManagerImpl
  implements IProtocolManager
{
  private ProtocolManager mgr;
  
  public void forwardDisc2Disc(String paramString1, String paramString2, ProtocolFileInfo paramProtocolFileInfo, ProtocolFileCallback.OnForwardOfflineResult paramOnForwardOfflineResult)
  {
    this.mgr.a(paramString1, paramString2, paramProtocolFileInfo, paramOnForwardOfflineResult);
  }
  
  public void forwardDiscToOther(String paramString1, int paramInt1, String paramString2, int paramInt2, ProtocolFileInfo paramProtocolFileInfo, int paramInt3, int paramInt4, ProtocolFileCallback.OnForwardOfflineResult paramOnForwardOfflineResult)
  {
    this.mgr.a(paramString1, paramInt1, paramString2, paramInt2, paramProtocolFileInfo, paramInt3, paramInt4, paramOnForwardOfflineResult);
  }
  
  public void forwardOfflineFileToBuddy(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, ProtocolFileCallback.OnForwardOfflineResult paramOnForwardOfflineResult)
  {
    this.mgr.a(paramString1, paramInt1, paramString2, paramString3, paramInt2, paramInt3, paramOnForwardOfflineResult);
  }
  
  public void forwardOfflineFileToOther(String paramString1, String paramString2, ProtocolFileInfo paramProtocolFileInfo, int paramInt1, int paramInt2, int paramInt3, ProtocolFileCallback.OnForwardOfflineResult paramOnForwardOfflineResult)
  {
    this.mgr.a(paramString1, paramString2, paramProtocolFileInfo, paramInt1, paramInt2, paramInt3, paramOnForwardOfflineResult);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mgr = new ProtocolManager((BaseQQAppInterface)paramAppRuntime);
  }
  
  public void onDestroy() {}
  
  public void sendLocalFileToBuddyBySHA(String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, ProtocolFileCallback.OnSendLocalFileToBuddy paramOnSendLocalFileToBuddy)
  {
    this.mgr.a(paramString1, paramString2, paramString3, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramOnSendLocalFileToBuddy);
  }
  
  public void setUploadBuddyFileSuccess(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ProtocolFileCallback.SetSendBuddyFileSuccessResult paramSetSendBuddyFileSuccessResult)
  {
    this.mgr.a(paramString, paramArrayOfByte, paramInt1, paramInt2, paramSetSendBuddyFileSuccessResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.ProtocolManagerImpl
 * JD-Core Version:    0.7.0.1
 */