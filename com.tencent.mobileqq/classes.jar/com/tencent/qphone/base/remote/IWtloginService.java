package com.tencent.qphone.base.remote;

import android.os.IInterface;
import java.util.List;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;

public abstract interface IWtloginService
  extends IInterface
{
  public abstract int CheckPictureAndGetSt(String paramString1, String paramString2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker);
  
  public abstract int CheckSMSAndGetSt(String paramString1, String paramString2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker);
  
  public abstract int CloseCode(String paramString1, String paramString2, long paramLong, byte[] paramArrayOfByte, int paramInt, List paramList, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker);
  
  public abstract int GetA1WithA1(String paramString1, String paramString2, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker);
  
  public abstract int GetStWithPasswd(String paramString1, String paramString2, long paramLong, String paramString3, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker);
  
  public abstract int GetStWithoutPasswd(String paramString1, String paramString2, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker);
  
  public abstract int RefreshPictureData(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker);
  
  public abstract int RefreshSMSData(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker);
  
  public abstract int VerifyCode(String paramString1, String paramString2, long paramLong, boolean paramBoolean, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker);
  
  public abstract void removeRemoteHelper(String paramString);
  
  public abstract void setTestHost(String paramString1, int paramInt, String paramString2, IWtloginServiceCallbacker paramIWtloginServiceCallbacker);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IWtloginService
 * JD-Core Version:    0.7.0.1
 */