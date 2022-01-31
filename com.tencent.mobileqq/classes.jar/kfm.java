import com.tencent.av.ui.redbag.GetRedBag;
import com.tencent.qphone.base.util.QLog;

public class kfm
  implements Runnable
{
  public kfm(GetRedBag paramGetRedBag, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag.a = null;
    QLog.w(this.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag.i, 1, "getRedBag还没回包，超时结束, resultCode[" + this.jdField_a_of_type_Int + "]");
    GetRedBag.a(this.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag, this.jdField_a_of_type_Int, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kfm
 * JD-Core Version:    0.7.0.1
 */