import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.av.utils.PstnUtils;
import java.lang.ref.WeakReference;

public class jxc
  implements DialogInterface.OnClickListener
{
  public jxc(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().n()) && (this.a.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      PstnUtils.a(null, (Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jxc
 * JD-Core Version:    0.7.0.1
 */