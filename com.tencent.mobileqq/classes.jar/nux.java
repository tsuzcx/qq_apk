import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

class nux
  implements CompoundButton.OnCheckedChangeListener
{
  nux(num paramnum, obr paramobr, Switch paramSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Num.c)
    {
      this.jdField_a_of_type_Num.c = true;
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    if (this.jdField_a_of_type_Obr.f == 1) {
      this.jdField_a_of_type_Num.a(this.jdField_a_of_type_Obr, paramBoolean);
    }
    for (;;)
    {
      num.a(this.jdField_a_of_type_Num, this.jdField_a_of_type_Obr.a);
      break;
      if (this.jdField_a_of_type_Obr.f == 2)
      {
        if (paramBoolean) {
          this.jdField_a_of_type_Num.a(this.jdField_a_of_type_Obr, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Num.a(this.jdField_a_of_type_Obr, paramBoolean);
        }
      }
      else if (this.jdField_a_of_type_Obr.f == 3)
      {
        if (!paramBoolean) {
          this.jdField_a_of_type_Num.a(this.jdField_a_of_type_Obr, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Num.a(this.jdField_a_of_type_Obr, paramBoolean);
        }
      }
      else {
        this.jdField_a_of_type_Num.a(this.jdField_a_of_type_Obr, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nux
 * JD-Core Version:    0.7.0.1
 */