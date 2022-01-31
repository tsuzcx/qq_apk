import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class rpy
  implements View.OnClickListener
{
  rpy(rpw paramrpw, rpv paramrpv) {}
  
  public void onClick(View paramView)
  {
    awqx.b(this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpv.a, "P_CliOper", "Pb_account_lifeservice", "", "0X8005731", "0X8005731", 0, 0, "", "", "", "");
    awqx.b(this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpv.a, "CliOper", "", "", "0X800642E", "0X800642E", 0, 0, String.valueOf(this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpu.a), "", "", "");
    if ((this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpu == null) || (TextUtils.isEmpty(String.valueOf(this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpu.a)))) {
      return;
    }
    rpw.a(this.jdField_a_of_type_Rpw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpy
 * JD-Core Version:    0.7.0.1
 */