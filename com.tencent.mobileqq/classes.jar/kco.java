import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.utils.UITools;
import java.lang.ref.WeakReference;

public class kco
  implements DialogInterface.OnClickListener
{
  public kco(VideoControlUI paramVideoControlUI) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference != null) {
      UITools.a((AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kco
 * JD-Core Version:    0.7.0.1
 */