import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.funchat.filter.EffectFilterTextPager;
import com.tencent.qphone.base.util.QLog;

public class kcz
  implements Runnable
{
  public kcz(EffectFilterTextPager paramEffectFilterTextPager) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.a.jdField_a_of_type_Boolean = true;
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(119), Integer.valueOf(1), Float.valueOf(this.a.jdField_a_of_type_Float), Float.valueOf(this.a.b) });
      if (QLog.isColorLevel()) {
        QLog.e("EffectFilterTextPager", 2, "[childLock] trigger animation");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kcz
 * JD-Core Version:    0.7.0.1
 */