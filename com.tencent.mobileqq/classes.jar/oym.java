import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class oym
  implements DialogInterface.OnClickListener
{
  oym(pan parampan, pay parampay) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Pan != null)
      {
        paramDialogInterface = this.jdField_a_of_type_Pan.a();
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(this.jdField_a_of_type_Pay);
          this.jdField_a_of_type_Pan.notifyDataSetChanged();
        }
      }
      bmqa.a("family_comment_card_hide_timestamp", Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oym
 * JD-Core Version:    0.7.0.1
 */