import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class lfj
  extends kzq
{
  lfj(lfi paramlfi) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    QLog.w(lfi.jdField_a_of_type_JavaLangString, 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], seq[" + paramLong + "]");
    if (paramBoolean) {
      b(paramLong);
    }
  }
  
  void b(long paramLong)
  {
    Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.sendToTarget();
  }
  
  protected void b(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    QLog.w(lfi.jdField_a_of_type_JavaLangString, 1, "onAfterReopenCamera, success[" + paramBoolean + "], seq[" + l + "]");
    if (paramBoolean) {
      b(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfj
 * JD-Core Version:    0.7.0.1
 */