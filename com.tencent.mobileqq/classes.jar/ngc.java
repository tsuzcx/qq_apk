import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.widget.Switch;

class ngc
  implements CompoundButton.OnCheckedChangeListener
{
  ngc(nfr paramnfr, nms paramnms, Switch paramSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Nfr.c)
    {
      this.jdField_a_of_type_Nfr.c = true;
      return;
    }
    if (this.jdField_a_of_type_Nms.f == 1) {
      this.jdField_a_of_type_Nfr.a(this.jdField_a_of_type_Nms, paramBoolean);
    }
    for (;;)
    {
      nfr.a(this.jdField_a_of_type_Nfr, this.jdField_a_of_type_Nms.a);
      return;
      if (this.jdField_a_of_type_Nms.f == 2)
      {
        if (paramBoolean) {
          this.jdField_a_of_type_Nfr.a(this.jdField_a_of_type_Nms, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Nfr.a(this.jdField_a_of_type_Nms, paramBoolean);
        }
      }
      else if (this.jdField_a_of_type_Nms.f == 3)
      {
        if (!paramBoolean) {
          this.jdField_a_of_type_Nfr.a(this.jdField_a_of_type_Nms, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_Nfr.a(this.jdField_a_of_type_Nms, paramBoolean);
        }
      }
      else {
        this.jdField_a_of_type_Nfr.a(this.jdField_a_of_type_Nms, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngc
 * JD-Core Version:    0.7.0.1
 */