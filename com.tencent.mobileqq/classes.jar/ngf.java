import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.widget.Switch;

class ngf
  implements CompoundButton.OnCheckedChangeListener
{
  ngf(nfu paramnfu, nmv paramnmv, Switch paramSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Nfu.c)
    {
      this.jdField_a_of_type_Nfu.c = true;
      return;
    }
    if (this.jdField_a_of_type_Nmv.f == 1) {
      this.jdField_a_of_type_Nfu.a(this.jdField_a_of_type_Nmv, paramBoolean);
    }
    for (;;)
    {
      nfu.a(this.jdField_a_of_type_Nfu, this.jdField_a_of_type_Nmv.a);
      return;
      if (this.jdField_a_of_type_Nmv.f == 2)
      {
        if (paramBoolean) {
          this.jdField_a_of_type_Nfu.a(this.jdField_a_of_type_Nmv, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Nfu.a(this.jdField_a_of_type_Nmv, paramBoolean);
        }
      }
      else if (this.jdField_a_of_type_Nmv.f == 3)
      {
        if (!paramBoolean) {
          this.jdField_a_of_type_Nfu.a(this.jdField_a_of_type_Nmv, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Nfu.a(this.jdField_a_of_type_Nmv, paramBoolean);
        }
      }
      else {
        this.jdField_a_of_type_Nfu.a(this.jdField_a_of_type_Nmv, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngf
 * JD-Core Version:    0.7.0.1
 */