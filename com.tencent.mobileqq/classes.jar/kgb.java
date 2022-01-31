import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.AVRedBagConfig;
import com.tencent.qphone.base.util.QLog;

class kgb
  implements Runnable
{
  kgb(kga paramkga) {}
  
  public void run()
  {
    if (!this.a.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.a.jdField_a_of_type_ComTencentAvServiceIAVRedPacketCallback))
    {
      QLog.w(this.a.a.i, 1, "getAVRedPacketConfig失败" + Thread.currentThread().getId() + "]");
      this.a.a.a(null);
      this.a.a.b(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kgb
 * JD-Core Version:    0.7.0.1
 */