import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.widget.Switch;

class mvo
  implements DialogInterface.OnClickListener
{
  mvo(mut parammut, nbu paramnbu, boolean paramBoolean, Switch paramSwitch) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      if ((3 == this.jdField_a_of_type_Nbu.e) && (this.jdField_a_of_type_Nbu.d == 0))
      {
        paramDialogInterface = this.jdField_a_of_type_Mut;
        localnbu = this.jdField_a_of_type_Nbu;
        if (!this.jdField_a_of_type_Boolean) {
          paramDialogInterface.a(localnbu, bool);
        }
      }
      else
      {
        this.jdField_a_of_type_Mut.a(this.jdField_a_of_type_Nbu, this.jdField_a_of_type_ComTencentWidgetSwitch);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        nbu localnbu;
        return;
        bool = false;
      }
    }
    this.jdField_a_of_type_Mut.a(this.jdField_a_of_type_Nbu, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mvo
 * JD-Core Version:    0.7.0.1
 */