import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.logic.DiandianTopConfigManager;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0xb7e.RspBody;

class lqz
  implements Runnable
{
  lqz(lqy paramlqy, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(false, null);
      return;
    }
    oidb_0xb7e.RspBody localRspBody = new oidb_0xb7e.RspBody();
    try
    {
      localRspBody.mergeFrom(this.jdField_a_of_type_ArrayOfByte);
      DiandianTopConfigManager.a(this.jdField_a_of_type_Lqy.a, localRspBody);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(DiandianTopConfigManager.a, 2, "loadDiandianTopConfig, e = " + localException);
      }
      ReadInJoyLogicEngineEventDispatcher.a().a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lqz
 * JD-Core Version:    0.7.0.1
 */