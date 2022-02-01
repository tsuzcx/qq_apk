import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.widget.Switch;

class ntx
  implements DialogInterface.OnClickListener
{
  ntx(ntc paramntc, oag paramoag, boolean paramBoolean, Switch paramSwitch) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      if ((3 == this.jdField_a_of_type_Oag.e) && (this.jdField_a_of_type_Oag.d == 0))
      {
        paramDialogInterface = this.jdField_a_of_type_Ntc;
        localoag = this.jdField_a_of_type_Oag;
        if (!this.jdField_a_of_type_Boolean) {
          paramDialogInterface.a(localoag, bool);
        }
      }
      else
      {
        this.jdField_a_of_type_Ntc.a(this.jdField_a_of_type_Oag, this.jdField_a_of_type_ComTencentWidgetSwitch);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        oag localoag;
        return;
        bool = false;
      }
    }
    this.jdField_a_of_type_Ntc.a(this.jdField_a_of_type_Oag, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ntx
 * JD-Core Version:    0.7.0.1
 */