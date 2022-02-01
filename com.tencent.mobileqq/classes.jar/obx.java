import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

class obx
  implements CompoundButton.OnCheckedChangeListener
{
  obx(obm paramobm, oji paramoji, Switch paramSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Obm.c)
    {
      this.jdField_a_of_type_Obm.c = true;
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    if (this.jdField_a_of_type_Oji.f == 1) {
      this.jdField_a_of_type_Obm.a(this.jdField_a_of_type_Oji, paramBoolean);
    }
    for (;;)
    {
      obm.a(this.jdField_a_of_type_Obm, this.jdField_a_of_type_Oji.a);
      break;
      if (this.jdField_a_of_type_Oji.f == 2)
      {
        if (paramBoolean) {
          this.jdField_a_of_type_Obm.a(this.jdField_a_of_type_Oji, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Obm.a(this.jdField_a_of_type_Oji, paramBoolean);
        }
      }
      else if (this.jdField_a_of_type_Oji.f == 3)
      {
        if (!paramBoolean) {
          this.jdField_a_of_type_Obm.a(this.jdField_a_of_type_Oji, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Obm.a(this.jdField_a_of_type_Oji, paramBoolean);
        }
      }
      else {
        this.jdField_a_of_type_Obm.a(this.jdField_a_of_type_Oji, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obx
 * JD-Core Version:    0.7.0.1
 */