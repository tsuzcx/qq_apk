import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class nrz
  implements DialogInterface.OnClickListener
{
  nrz(nrw paramnrw, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("stat_src", "2");
    nbe.a(new nmv().a(BaseApplication.getContext()).a(nbe.e).b(nbe.ac).a(npk.a(nrw.a(this.jdField_a_of_type_Nrw))).d(nbe.a(nrw.a(this.jdField_a_of_type_Nrw), paramDialogInterface)).a());
    if (!this.jdField_a_of_type_Boolean) {
      if (!nrw.a(this.jdField_a_of_type_Nrw)) {}
    }
    while (!(this.jdField_a_of_type_Nrw.a instanceof Activity))
    {
      return;
      this.jdField_a_of_type_Nrw.g();
      return;
    }
    rvb.a(this.jdField_a_of_type_Nrw.a);
    npa.a(this.jdField_a_of_type_Nrw.a, nrw.a(this.jdField_a_of_type_Nrw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrz
 * JD-Core Version:    0.7.0.1
 */