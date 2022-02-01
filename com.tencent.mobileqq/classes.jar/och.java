import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.widget.Switch;

class och
  implements DialogInterface.OnClickListener
{
  och(obm paramobm, oji paramoji, boolean paramBoolean, Switch paramSwitch) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      if ((3 == this.jdField_a_of_type_Oji.e) && (this.jdField_a_of_type_Oji.d == 0))
      {
        paramDialogInterface = this.jdField_a_of_type_Obm;
        localoji = this.jdField_a_of_type_Oji;
        if (!this.jdField_a_of_type_Boolean) {
          paramDialogInterface.a(localoji, bool);
        }
      }
      else
      {
        this.jdField_a_of_type_Obm.a(this.jdField_a_of_type_Oji, this.jdField_a_of_type_ComTencentWidgetSwitch);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        oji localoji;
        return;
        bool = false;
      }
    }
    this.jdField_a_of_type_Obm.a(this.jdField_a_of_type_Oji, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     och
 * JD-Core Version:    0.7.0.1
 */