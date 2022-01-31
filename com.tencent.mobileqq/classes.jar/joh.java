import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI;
import com.tencent.qphone.base.util.QLog;

class joh
  implements Runnable
{
  joh(joe paramjoe) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "AutoCheckVideoRunnable");
    }
    if (this.a.a.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.a.a.jdField_a_of_type_ComTencentAvVideoController.a().an = true;
    }
    this.a.a.p();
    if ((this.a.a.c == 1) && (this.a.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.a.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.a.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     joh
 * JD-Core Version:    0.7.0.1
 */