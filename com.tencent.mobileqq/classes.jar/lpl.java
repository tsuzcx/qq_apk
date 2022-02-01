import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class lpl
  extends ljl
{
  lpl(lpk paramlpk) {}
  
  private void b(long paramLong)
  {
    Message localMessage = this.a.a.obtainMessage(4);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.sendToTarget();
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    QLog.w("EffectCtrlBase", 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], seq[" + paramLong + "]");
    if (paramBoolean) {
      b(paramLong);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    QLog.w("EffectCtrlBase", 1, "onAfterReopenCamera, success[" + paramBoolean + "], seq[" + l + "]");
    if (paramBoolean) {
      b(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpl
 * JD-Core Version:    0.7.0.1
 */