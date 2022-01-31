import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import eipc.EIPCResult;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class qh
  implements Runnable
{
  public qh(VasFontIPCModule paramVasFontIPCModule, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (new File(VasUtils.a() + "libvipfont.so").exists())
    {
      localObject = EIPCResult.createResult(0, null);
      this.jdField_a_of_type_ComEtrumpMixlayoutVasFontIPCModule.callbackResult(this.jdField_a_of_type_Int, (EIPCResult)localObject);
    }
    while (!VasFontIPCModule.a(this.jdField_a_of_type_ComEtrumpMixlayoutVasFontIPCModule).compareAndSet(false, true)) {
      return;
    }
    VasFontIPCModule.a(this.jdField_a_of_type_ComEtrumpMixlayoutVasFontIPCModule, this.jdField_a_of_type_Int);
    Object localObject = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183);
    ((VasQuickUpdateManager)localObject).a(this.jdField_a_of_type_ComEtrumpMixlayoutVasFontIPCModule.a);
    ((VasQuickUpdateManager)localObject).a(1004L, "libVipFont_735", "VasFontIPCModule");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qh
 * JD-Core Version:    0.7.0.1
 */