package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.filemanager.app.ProtocolFileCallback.OnForwardOfflineResult;
import com.tencent.mobileqq.filemanager.app.ProtocolFileCallback.OnSendLocalFileToBuddy;
import com.tencent.mobileqq.filemanager.app.ProtocolFileCallback.SetSendBuddyFileSuccessResult;
import com.tencent.mobileqq.filemanager.app.ProtocolFileInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IProtocolManager
  extends IRuntimeService
{
  public abstract void forwardDisc2Disc(String paramString1, String paramString2, ProtocolFileInfo paramProtocolFileInfo, ProtocolFileCallback.OnForwardOfflineResult paramOnForwardOfflineResult);
  
  public abstract void forwardDiscToOther(String paramString1, int paramInt1, String paramString2, int paramInt2, ProtocolFileInfo paramProtocolFileInfo, int paramInt3, int paramInt4, ProtocolFileCallback.OnForwardOfflineResult paramOnForwardOfflineResult);
  
  public abstract void forwardOfflineFileToBuddy(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, ProtocolFileCallback.OnForwardOfflineResult paramOnForwardOfflineResult);
  
  public abstract void forwardOfflineFileToOther(String paramString1, String paramString2, ProtocolFileInfo paramProtocolFileInfo, int paramInt1, int paramInt2, int paramInt3, ProtocolFileCallback.OnForwardOfflineResult paramOnForwardOfflineResult);
  
  public abstract void sendLocalFileToBuddyBySHA(String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, ProtocolFileCallback.OnSendLocalFileToBuddy paramOnSendLocalFileToBuddy);
  
  public abstract void setUploadBuddyFileSuccess(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ProtocolFileCallback.SetSendBuddyFileSuccessResult paramSetSendBuddyFileSuccessResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IProtocolManager
 * JD-Core Version:    0.7.0.1
 */