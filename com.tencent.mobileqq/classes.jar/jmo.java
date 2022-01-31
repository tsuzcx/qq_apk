import com.tencent.av.service.AVServiceForQQ;
import com.tencent.qphone.base.util.QLog;

class jmo
  implements Runnable
{
  jmo(jmn paramjmn) {}
  
  public void run()
  {
    try
    {
      this.a.a.startForeground(2130840353, this.a.a.jdField_a_of_type_AndroidAppNotification);
      return;
    }
    catch (Exception localException)
    {
      QLog.d(this.a.a.jdField_a_of_type_JavaLangString, 1, "setAVServiceForegroud, e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jmo
 * JD-Core Version:    0.7.0.1
 */