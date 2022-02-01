package mqq.manager;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public abstract interface WtloginManager
  extends Manager
{
  public abstract int askDevLockSms(String paramString, WtloginObserver paramWtloginObserver);
  
  public abstract void cancelCode(String paramString, long paramLong, byte[] paramArrayOfByte);
  
  public abstract int checkDevLockSms(String paramString1, long paramLong, String paramString2, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver);
  
  public abstract int checkDevLockStatus(String paramString, long paramLong, WtloginObserver paramWtloginObserver);
  
  public abstract int checkPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver);
  
  public abstract int checkSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver);
  
  public abstract int checkSMSAndGetStExt(String paramString, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver);
  
  public abstract int checkSMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt, WtloginObserver paramWtloginObserver);
  
  public abstract int checkSMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver);
  
  public abstract Boolean clearUserFastLoginData(String paramString, long paramLong);
  
  public abstract int closeCode(String paramString, long paramLong, byte[] paramArrayOfByte, int paramInt, ArrayList<String> paramArrayList, WtloginObserver paramWtloginObserver);
  
  public abstract int closeDevLock(String paramString, long paramLong, WtloginObserver paramWtloginObserver);
  
  public abstract int getA1WithA1(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WFastLoginInfo paramWFastLoginInfo, WtloginObserver paramWtloginObserver);
  
  public abstract List<WloginLoginInfo> getAllLoginInfo();
  
  public abstract Boolean getBasicUserInfo(String paramString, WloginSimpleInfo paramWloginSimpleInfo);
  
  public abstract byte[] getGUID();
  
  public abstract boolean getHasPwd(String paramString);
  
  public abstract WUserSigInfo getLocalSig(String paramString, long paramLong);
  
  public abstract Ticket getLocalTicket(String paramString, long paramLong, int paramInt);
  
  public abstract int getOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, WtloginObserver paramWtloginObserver);
  
  public abstract byte[] getPkgSigFromApkName(Context paramContext, String paramString);
  
  public abstract int getStViaSMSVerifyLogin(String paramString1, String paramString2, int paramInt, WtloginObserver paramWtloginObserver);
  
  public abstract int getStWithPasswd(String paramString1, long paramLong, String paramString2, WtloginObserver paramWtloginObserver);
  
  public abstract int getStWithoutPasswd(String paramString, long paramLong1, long paramLong2, WtloginObserver paramWtloginObserver);
  
  public abstract int getSubAccountStViaSMSVerifyLogin(String paramString1, String paramString2, String paramString3, int paramInt, WtloginObserver paramWtloginObserver);
  
  public abstract boolean isNeedLoginWithPasswd(String paramString, int paramInt);
  
  public abstract boolean isUserHaveA1(String paramString, long paramLong);
  
  public abstract boolean isWtLoginUrl(String paramString);
  
  public abstract int quickLoginByGateway(byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver);
  
  public abstract void refreLocalHelper(Context paramContext);
  
  public abstract void refreshMemorySig();
  
  public abstract int refreshPictureData(String paramString, WtloginObserver paramWtloginObserver);
  
  public abstract int refreshSMSData(String paramString, WtloginObserver paramWtloginObserver);
  
  public abstract int refreshSMSVerifyLoginCode(String paramString1, String paramString2, WtloginObserver paramWtloginObserver);
  
  public abstract int regGetSMSVerifyLoginAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, String paramString2, WtloginObserver paramWtloginObserver);
  
  public abstract int regGetSMSVerifyLoginAccountWithLH(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, String paramString2, WtloginObserver paramWtloginObserver);
  
  public abstract void setDevLockMobileType(int paramInt);
  
  public abstract void setHasPwd(String paramString, boolean paramBoolean);
  
  public abstract void setRegDevLockFlag(int paramInt);
  
  public abstract int verifyCode(String paramString, long paramLong, boolean paramBoolean, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt, WtloginObserver paramWtloginObserver);
  
  public abstract int verifySMSVerifyLoginCode(String paramString1, String paramString2, String paramString3, WtloginObserver paramWtloginObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.manager.WtloginManager
 * JD-Core Version:    0.7.0.1
 */