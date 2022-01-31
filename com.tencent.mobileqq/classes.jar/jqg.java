import com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI;
import com.tencent.qphone.base.util.QLog;

public class jqg
  implements Runnable
{
  public jqg(SmallScreenDoubleVideoControlUI paramSmallScreenDoubleVideoControlUI) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "2s has past, startTimer now!");
    }
    this.a.v();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jqg
 * JD-Core Version:    0.7.0.1
 */