package com.tencent.mobileqq.pic.api.impl;

import com.tencent.mobileqq.data.SigInfo;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.transfile.C2CPicDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPicDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import mqq.app.AppRuntime;

public class PicTransFileImpl
  implements IPicTransFile
{
  AppRuntime app;
  private SigInfo mSig;
  
  public Class getC2CPicDownloadProClass()
  {
    return C2CPicDownloadProcessor.class;
  }
  
  public Class getC2CUploadProClass()
  {
    return C2CPicUploadProcessor.class;
  }
  
  public Class getGroupDownloadProClass()
  {
    return GroupPicDownloadProcessor.class;
  }
  
  public Class getGroupUploadProClass()
  {
    return GroupPicUploadProcessor.class;
  }
  
  public byte[] getSessionKey()
  {
    if ((this.app.getAccount() != null) && (this.app.isLogin()))
    {
      SigInfo localSigInfo = this.mSig;
      if (localSigInfo != null) {
        return localSigInfo.sessionKey;
      }
    }
    return null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void setSig(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (this.mSig == null) {
      this.mSig = new SigInfo();
    }
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      SigInfo localSigInfo = this.mSig;
      localSigInfo.sessionKey = new byte[paramArrayOfByte1.length];
      System.arraycopy(paramArrayOfByte1, 0, localSigInfo.sessionKey, 0, paramArrayOfByte1.length);
      paramArrayOfByte1 = this.mSig;
      paramArrayOfByte1.signature = new byte[paramArrayOfByte2.length];
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1.signature, 0, paramArrayOfByte2.length);
      paramArrayOfByte1 = this.mSig;
      paramArrayOfByte1.wSignatureLen = ((short)paramArrayOfByte1.signature.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.impl.PicTransFileImpl
 * JD-Core Version:    0.7.0.1
 */