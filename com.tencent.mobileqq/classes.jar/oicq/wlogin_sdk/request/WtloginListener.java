package oicq.wlogin_sdk.request;

import java.util.HashMap;
import java.util.List;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class WtloginListener
{
  public void OnAskDevLockSms(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt1, int paramInt2, WUserSigInfo paramWUserSigInfo, int paramInt3, ErrMsg paramErrMsg) {}
  
  public void OnCheckSMSVerifyLoginAccountForReview(long paramLong1, long paramLong2, int paramInt1, String paramString, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void OnCheckWebsigAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCheckWebsigAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt) {}
  
  public void OnCloseDevLock(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo paramWUserSigInfo) {}
  
  public void OnFetchCodeSig(byte[] paramArrayOfByte1, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt) {}
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void OnGetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void OnGetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, long[] paramArrayOfLong, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void OnGuaranteeCheckValidUrl(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte) {}
  
  public void OnInit(int paramInt) {}
  
  public void OnQueryCodeResult(long paramLong1, List<byte[]> paramList, long paramLong2, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, int paramInt) {}
  
  public void OnQuickRegisterCheckAccount(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte) {}
  
  public void OnQuickRegisterGetAccount(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte) {}
  
  public void OnRefreshPictureData(String paramString, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnRefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg) {}
  
  public void OnRefreshSMSVerifyLoginCode(String paramString1, String paramString2, int paramInt1, int paramInt2, WUserSigInfo paramWUserSigInfo, int paramInt3, ErrMsg paramErrMsg) {}
  
  public void OnRegCheckDownloadMsg(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte) {}
  
  public void OnRegCheckError(int paramInt, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, Object paramObject) {}
  
  public void OnRegCheckIframe(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, Object paramObject) {}
  
  public void OnRegCheckUploadMsg(WUserSigInfo paramWUserSigInfo, String paramString) {}
  
  public void OnRegCheckValidUrl(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte) {}
  
  public void OnRegCheckWebSig(WUserSigInfo paramWUserSigInfo, String paramString1, String paramString2) {}
  
  public void OnRegError(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte) {}
  
  public void OnRegGetAccount(WUserSigInfo paramWUserSigInfo, int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {}
  
  public void OnRegGetSMSVerifyLoginAccount(WUserSigInfo paramWUserSigInfo, int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {}
  
  public void OnRegQueryAccount(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte) {}
  
  public void OnRegQueryClientSentMsgStatus(WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void OnRegRequestServerResendMsg(WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void OnRegSubmitMsgChk(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte) {}
  
  public void OnRequestTransport(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, int paramInt) {}
  
  public void OnRequestTransport(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt) {}
  
  public void OnVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, List<byte[]> paramList, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt) {}
  
  public void OnVerifySMSVerifyLoginCode(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void onGetStWithQrSig(String paramString, long paramLong1, int paramInt1, long paramLong2, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void onLoginByGateway(int paramInt, WUserSigInfo paramWUserSigInfo, String paramString, ErrMsg paramErrMsg, HashMap<String, Object> paramHashMap) {}
  
  public void onLoginByWeChat(long paramLong, byte[] paramArrayOfByte, WtloginHelper.QuickLoginParam paramQuickLoginParam, int paramInt1, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void onModifyQIMPassword(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte) {}
  
  public void onQuickLogin(String paramString, WtloginHelper.QuickLoginParam paramQuickLoginParam, int paramInt, ErrMsg paramErrMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginListener
 * JD-Core Version:    0.7.0.1
 */