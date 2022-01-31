import com.tencent.av.service.AVServiceForQQ;
import com.tencent.qphone.base.util.QLog;

class jnd
  implements Runnable
{
  jnd(jnc paramjnc) {}
  
  public void run()
  {
    try
    {
      this.a.a.startForeground(2130840347, this.a.a.jdField_a_of_type_AndroidAppNotification);
      return;
    }
    catch (Exception localException)
    {
      QLog.d(this.a.a.jdField_a_of_type_JavaLangString, 1, "setAVServiceForegroud, e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jnd
 * JD-Core Version:    0.7.0.1
 */