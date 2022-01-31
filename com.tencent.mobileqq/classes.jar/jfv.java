import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.qphone.base.util.QLog;

public class jfv
  implements Runnable
{
  final HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  
  public jfv(EffectConfigBase paramEffectConfigBase, HttpNetReq paramHttpNetReq)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = paramHttpNetReq;
  }
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.a != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null)) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase.a.getNetEngine(0).a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jfv
 * JD-Core Version:    0.7.0.1
 */