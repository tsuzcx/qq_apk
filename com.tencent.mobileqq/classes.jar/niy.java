import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.widget.Switch;

class niy
  implements CompoundButton.OnCheckedChangeListener
{
  niy(nin paramnin, npo paramnpo, Switch paramSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Nin.c)
    {
      this.jdField_a_of_type_Nin.c = true;
      return;
    }
    if (this.jdField_a_of_type_Npo.f == 1) {
      this.jdField_a_of_type_Nin.a(this.jdField_a_of_type_Npo, paramBoolean);
    }
    for (;;)
    {
      nin.a(this.jdField_a_of_type_Nin, this.jdField_a_of_type_Npo.a);
      return;
      if (this.jdField_a_of_type_Npo.f == 2)
      {
        if (paramBoolean) {
          this.jdField_a_of_type_Nin.a(this.jdField_a_of_type_Npo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Nin.a(this.jdField_a_of_type_Npo, paramBoolean);
        }
      }
      else if (this.jdField_a_of_type_Npo.f == 3)
      {
        if (!paramBoolean) {
          this.jdField_a_of_type_Nin.a(this.jdField_a_of_type_Npo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Nin.a(this.jdField_a_of_type_Npo, paramBoolean);
        }
      }
      else {
        this.jdField_a_of_type_Nin.a(this.jdField_a_of_type_Npo, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     niy
 * JD-Core Version:    0.7.0.1
 */