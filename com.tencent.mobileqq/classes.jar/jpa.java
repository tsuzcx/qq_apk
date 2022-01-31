import com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI;
import com.tencent.qphone.base.util.QLog;

public class jpa
  implements Runnable
{
  public String a;
  
  public jpa(SmallScreenMultiVideoControlUI paramSmallScreenMultiVideoControlUI) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "StartRecvAllVideoRunnable-->FunctionName=" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jpa
 * JD-Core Version:    0.7.0.1
 */