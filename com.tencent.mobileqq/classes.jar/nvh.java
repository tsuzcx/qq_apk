import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.widget.Switch;

class nvh
  implements DialogInterface.OnClickListener
{
  nvh(num paramnum, obr paramobr, boolean paramBoolean, Switch paramSwitch) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      if ((3 == this.jdField_a_of_type_Obr.e) && (this.jdField_a_of_type_Obr.d == 0))
      {
        paramDialogInterface = this.jdField_a_of_type_Num;
        localobr = this.jdField_a_of_type_Obr;
        if (!this.jdField_a_of_type_Boolean) {
          paramDialogInterface.a(localobr, bool);
        }
      }
      else
      {
        this.jdField_a_of_type_Num.a(this.jdField_a_of_type_Obr, this.jdField_a_of_type_ComTencentWidgetSwitch);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        obr localobr;
        return;
        bool = false;
      }
    }
    this.jdField_a_of_type_Num.a(this.jdField_a_of_type_Obr, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nvh
 * JD-Core Version:    0.7.0.1
 */