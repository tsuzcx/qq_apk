import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class orz
  implements DialogInterface.OnClickListener
{
  orz(ouc paramouc, ouo paramouo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Ouc != null)
      {
        paramDialogInterface = this.jdField_a_of_type_Ouc.a();
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(this.jdField_a_of_type_Ouo);
          this.jdField_a_of_type_Ouc.notifyDataSetChanged();
        }
      }
      bkwm.a("family_comment_card_hide_timestamp", Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     orz
 * JD-Core Version:    0.7.0.1
 */