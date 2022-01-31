import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.widget.Switch;

class nji
  implements DialogInterface.OnClickListener
{
  nji(nin paramnin, npo paramnpo, boolean paramBoolean, Switch paramSwitch) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      if ((3 == this.jdField_a_of_type_Npo.e) && (this.jdField_a_of_type_Npo.d == 0))
      {
        paramDialogInterface = this.jdField_a_of_type_Nin;
        localnpo = this.jdField_a_of_type_Npo;
        if (!this.jdField_a_of_type_Boolean) {
          paramDialogInterface.a(localnpo, bool);
        }
      }
      else
      {
        this.jdField_a_of_type_Nin.a(this.jdField_a_of_type_Npo, this.jdField_a_of_type_ComTencentWidgetSwitch);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        npo localnpo;
        return;
        bool = false;
      }
    }
    this.jdField_a_of_type_Nin.a(this.jdField_a_of_type_Npo, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nji
 * JD-Core Version:    0.7.0.1
 */