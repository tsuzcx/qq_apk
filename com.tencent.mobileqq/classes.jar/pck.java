import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.util.NetworkState;

class pck
  implements DialogInterface.OnClickListener
{
  pck(pcj parampcj, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkState.isNetSupport())
    {
      if (this.jdField_a_of_type_Pcj.jdField_a_of_type_Pbx != null) {
        this.jdField_a_of_type_Pcj.jdField_a_of_type_Pbx.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramInt);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_Pcj.jdField_a_of_type_Pcf.a, 1, anvx.a(2131699134), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pck
 * JD-Core Version:    0.7.0.1
 */