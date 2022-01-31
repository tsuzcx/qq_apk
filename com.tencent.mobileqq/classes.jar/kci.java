import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.SysCallTransparentActivity;
import com.tencent.av.utils.PstnUtils;

class kci
  implements DialogInterface.OnClickListener
{
  kci(kcg paramkcg, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    PstnUtils.a(this.jdField_a_of_type_Kcg.a.app, this.jdField_a_of_type_Kcg.a, this.jdField_a_of_type_Int, 16, true);
    this.jdField_a_of_type_Kcg.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kci
 * JD-Core Version:    0.7.0.1
 */