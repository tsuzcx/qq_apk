package mqq.manager;

import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class VerifyDevLockManager$VerifyDevLockObserver
{
  private int mSeq;
  
  public int getSeq()
  {
    return this.mSeq;
  }
  
  public void onReceive(VerifyDevLockManager.NotifyType paramNotifyType, int paramInt, Object paramObject) {}
  
  public void onRecvNotice(VerifyDevLockManager.NotifyType paramNotifyType, int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo) {}
  
  public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void setSeq(int paramInt)
  {
    this.mSeq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.manager.VerifyDevLockManager.VerifyDevLockObserver
 * JD-Core Version:    0.7.0.1
 */