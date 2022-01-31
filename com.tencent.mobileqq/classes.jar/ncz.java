import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.lebasearch.Utils;

public final class ncz
  implements DialogInterface.OnClickListener
{
  public ncz(int paramInt, ajte paramajte, Context paramContext, wxr paramwxr, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_Ajte.onUpdate(17, false, null);
        paramDialogInterface.dismiss();
        return;
      }
      Utils.sendPluginSetMessage(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wxr, this.jdField_a_of_type_Ajte, this.jdField_a_of_type_Long, false);
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      Utils.sendPluginSetMessage(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wxr, this.jdField_a_of_type_Ajte, this.jdField_a_of_type_Long, true);
      return;
    }
    this.jdField_a_of_type_Ajte.onUpdate(17, false, null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ncz
 * JD-Core Version:    0.7.0.1
 */