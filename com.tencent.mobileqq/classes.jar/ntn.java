import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

class ntn
  implements CompoundButton.OnCheckedChangeListener
{
  ntn(ntc paramntc, oag paramoag, Switch paramSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Ntc.c)
    {
      this.jdField_a_of_type_Ntc.c = true;
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    if (this.jdField_a_of_type_Oag.f == 1) {
      this.jdField_a_of_type_Ntc.a(this.jdField_a_of_type_Oag, paramBoolean);
    }
    for (;;)
    {
      ntc.a(this.jdField_a_of_type_Ntc, this.jdField_a_of_type_Oag.a);
      break;
      if (this.jdField_a_of_type_Oag.f == 2)
      {
        if (paramBoolean) {
          this.jdField_a_of_type_Ntc.a(this.jdField_a_of_type_Oag, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Ntc.a(this.jdField_a_of_type_Oag, paramBoolean);
        }
      }
      else if (this.jdField_a_of_type_Oag.f == 3)
      {
        if (!paramBoolean) {
          this.jdField_a_of_type_Ntc.a(this.jdField_a_of_type_Oag, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Ntc.a(this.jdField_a_of_type_Oag, paramBoolean);
        }
      }
      else {
        this.jdField_a_of_type_Ntc.a(this.jdField_a_of_type_Oag, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ntn
 * JD-Core Version:    0.7.0.1
 */