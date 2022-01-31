import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class jgv
  implements Runnable
{
  public jgv(EffectPendantTools paramEffectPendantTools, File paramFile, PendantItem paramPendantItem) {}
  
  public void run()
  {
    try
    {
      ZipUtils.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTools.b(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem));
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
 * Qualified Name:     jgv
 * JD-Core Version:    0.7.0.1
 */