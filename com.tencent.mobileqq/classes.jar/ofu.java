import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ofu
  implements DialogInterface.OnClickListener
{
  ofu(ohv paramohv, oii paramoii) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Ohv != null)
      {
        paramDialogInterface = this.jdField_a_of_type_Ohv.a();
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(this.jdField_a_of_type_Oii);
          this.jdField_a_of_type_Ohv.notifyDataSetChanged();
        }
      }
      bhvh.a("family_comment_card_hide_timestamp", Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ofu
 * JD-Core Version:    0.7.0.1
 */