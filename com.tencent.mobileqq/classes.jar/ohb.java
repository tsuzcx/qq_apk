import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ohb
  implements DialogInterface.OnClickListener
{
  ohb(ogy paramogy, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("stat_src", "2");
    noy.a(new obk().a(BaseApplication.getContext()).a(noy.e).b(noy.ac).a(oef.a(ogy.a(this.jdField_a_of_type_Ogy))).d(noy.a(ogy.a(this.jdField_a_of_type_Ogy), paramDialogInterface)).a());
    if (!this.jdField_a_of_type_Boolean) {
      if (!ogy.a(this.jdField_a_of_type_Ogy)) {}
    }
    while (!(this.jdField_a_of_type_Ogy.a instanceof Activity))
    {
      return;
      this.jdField_a_of_type_Ogy.g();
      return;
    }
    szl.a(this.jdField_a_of_type_Ogy.a);
    odv.a(this.jdField_a_of_type_Ogy.a, ogy.a(this.jdField_a_of_type_Ogy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ohb
 * JD-Core Version:    0.7.0.1
 */