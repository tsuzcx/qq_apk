import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.UITools;
import java.lang.ref.WeakReference;

public class jsi
  implements DialogInterface.OnClickListener
{
  public jsi(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UITools.a((AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jsi
 * JD-Core Version:    0.7.0.1
 */