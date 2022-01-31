import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.widget.Switch;

class ngm
  implements DialogInterface.OnClickListener
{
  ngm(nfr paramnfr, nms paramnms, boolean paramBoolean, Switch paramSwitch) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      if ((3 == this.jdField_a_of_type_Nms.e) && (this.jdField_a_of_type_Nms.d == 0))
      {
        paramDialogInterface = this.jdField_a_of_type_Nfr;
        localnms = this.jdField_a_of_type_Nms;
        if (!this.jdField_a_of_type_Boolean) {
          paramDialogInterface.a(localnms, bool);
        }
      }
      else
      {
        this.jdField_a_of_type_Nfr.a(this.jdField_a_of_type_Nms, this.jdField_a_of_type_ComTencentWidgetSwitch);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        nms localnms;
        return;
        bool = false;
      }
    }
    this.jdField_a_of_type_Nfr.a(this.jdField_a_of_type_Nms, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngm
 * JD-Core Version:    0.7.0.1
 */