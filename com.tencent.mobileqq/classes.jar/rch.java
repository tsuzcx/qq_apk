import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.tools.ErrMsg;

public class rch
  extends WtloginObserver
{
  public rch(UserInfoModule paramUserInfoModule, APICallback paramAPICallback) {}
  
  public void OnGetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i(UserInfoModule.a, 2, "OnGetOpenKeyWithoutPasswd userAccount=" + paramString + ", dwSrcAppid=" + paramLong1 + ", dwDstAppid=" + paramLong2 + ", dwMainSigMap=" + paramInt1 + ", ret=" + paramInt2);
    }
    ThreadManager.getUIHandler().post(new rci(this, paramInt2, paramArrayOfByte1, paramArrayOfByte2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rch
 * JD-Core Version:    0.7.0.1
 */