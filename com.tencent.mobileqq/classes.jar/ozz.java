import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ozz
  implements DialogInterface.OnClickListener
{
  ozz(pcf parampcf, pdp parampdp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Pcf != null)
      {
        paramDialogInterface = this.jdField_a_of_type_Pcf.a();
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(this.jdField_a_of_type_Pdp);
          this.jdField_a_of_type_Pcf.notifyDataSetChanged();
        }
      }
      bmhv.a("family_comment_card_hide_timestamp", Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ozz
 * JD-Core Version:    0.7.0.1
 */