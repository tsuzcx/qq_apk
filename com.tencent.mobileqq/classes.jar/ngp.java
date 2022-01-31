import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.widget.Switch;

class ngp
  implements DialogInterface.OnClickListener
{
  ngp(nfu paramnfu, nmv paramnmv, boolean paramBoolean, Switch paramSwitch) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      if ((3 == this.jdField_a_of_type_Nmv.e) && (this.jdField_a_of_type_Nmv.d == 0))
      {
        paramDialogInterface = this.jdField_a_of_type_Nfu;
        localnmv = this.jdField_a_of_type_Nmv;
        if (!this.jdField_a_of_type_Boolean) {
          paramDialogInterface.a(localnmv, bool);
        }
      }
      else
      {
        this.jdField_a_of_type_Nfu.a(this.jdField_a_of_type_Nmv, this.jdField_a_of_type_ComTencentWidgetSwitch);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        nmv localnmv;
        return;
        bool = false;
      }
    }
    this.jdField_a_of_type_Nfu.a(this.jdField_a_of_type_Nmv, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngp
 * JD-Core Version:    0.7.0.1
 */