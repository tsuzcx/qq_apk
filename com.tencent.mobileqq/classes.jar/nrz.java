import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.widget.Switch;

class nrz
  implements DialogInterface.OnClickListener
{
  nrz(nre paramnre, nyl paramnyl, boolean paramBoolean, Switch paramSwitch) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      if ((3 == this.jdField_a_of_type_Nyl.e) && (this.jdField_a_of_type_Nyl.d == 0))
      {
        paramDialogInterface = this.jdField_a_of_type_Nre;
        localnyl = this.jdField_a_of_type_Nyl;
        if (!this.jdField_a_of_type_Boolean) {
          paramDialogInterface.a(localnyl, bool);
        }
      }
      else
      {
        this.jdField_a_of_type_Nre.a(this.jdField_a_of_type_Nyl, this.jdField_a_of_type_ComTencentWidgetSwitch);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        nyl localnyl;
        return;
        bool = false;
      }
    }
    this.jdField_a_of_type_Nre.a(this.jdField_a_of_type_Nyl, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrz
 * JD-Core Version:    0.7.0.1
 */