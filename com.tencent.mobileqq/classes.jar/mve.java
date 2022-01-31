import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.widget.Switch;

class mve
  implements CompoundButton.OnCheckedChangeListener
{
  mve(mut parammut, nbu paramnbu, Switch paramSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Mut.c)
    {
      this.jdField_a_of_type_Mut.c = true;
      return;
    }
    if (this.jdField_a_of_type_Nbu.f == 1) {
      this.jdField_a_of_type_Mut.a(this.jdField_a_of_type_Nbu, paramBoolean);
    }
    for (;;)
    {
      mut.a(this.jdField_a_of_type_Mut, this.jdField_a_of_type_Nbu.a);
      return;
      if (this.jdField_a_of_type_Nbu.f == 2)
      {
        if (paramBoolean) {
          this.jdField_a_of_type_Mut.a(this.jdField_a_of_type_Nbu, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Mut.a(this.jdField_a_of_type_Nbu, paramBoolean);
        }
      }
      else if (this.jdField_a_of_type_Nbu.f == 3)
      {
        if (!paramBoolean) {
          this.jdField_a_of_type_Mut.a(this.jdField_a_of_type_Nbu, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Mut.a(this.jdField_a_of_type_Nbu, paramBoolean);
        }
      }
      else {
        this.jdField_a_of_type_Mut.a(this.jdField_a_of_type_Nbu, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mve
 * JD-Core Version:    0.7.0.1
 */