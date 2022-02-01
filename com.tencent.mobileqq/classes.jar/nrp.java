import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

class nrp
  implements CompoundButton.OnCheckedChangeListener
{
  nrp(nre paramnre, nyl paramnyl, Switch paramSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Nre.c)
    {
      this.jdField_a_of_type_Nre.c = true;
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    if (this.jdField_a_of_type_Nyl.f == 1) {
      this.jdField_a_of_type_Nre.a(this.jdField_a_of_type_Nyl, paramBoolean);
    }
    for (;;)
    {
      nre.a(this.jdField_a_of_type_Nre, this.jdField_a_of_type_Nyl.a);
      break;
      if (this.jdField_a_of_type_Nyl.f == 2)
      {
        if (paramBoolean) {
          this.jdField_a_of_type_Nre.a(this.jdField_a_of_type_Nyl, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Nre.a(this.jdField_a_of_type_Nyl, paramBoolean);
        }
      }
      else if (this.jdField_a_of_type_Nyl.f == 3)
      {
        if (!paramBoolean) {
          this.jdField_a_of_type_Nre.a(this.jdField_a_of_type_Nyl, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Nre.a(this.jdField_a_of_type_Nyl, paramBoolean);
        }
      }
      else {
        this.jdField_a_of_type_Nre.a(this.jdField_a_of_type_Nyl, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrp
 * JD-Core Version:    0.7.0.1
 */