import com.tencent.biz.qrcode.CodeMaskManager;
import com.tencent.biz.qrcode.CodeMaskManager.Callback;
import java.util.concurrent.atomic.AtomicBoolean;

public class osh
  implements Runnable
{
  public osh(CodeMaskManager paramCodeMaskManager, osi paramosi, CodeMaskManager.Callback paramCallback) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager.a) {}
    while (!this.jdField_a_of_type_Osi.a.compareAndSet(false, true)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager$Callback.a(CodeMaskManager.a(this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager));
    CodeMaskManager.a(this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osh
 * JD-Core Version:    0.7.0.1
 */