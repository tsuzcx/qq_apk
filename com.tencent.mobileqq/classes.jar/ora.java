import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ora
  implements DialogInterface.OnClickListener
{
  ora(otd paramotd, otp paramotp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Otd != null)
      {
        paramDialogInterface = this.jdField_a_of_type_Otd.a();
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(this.jdField_a_of_type_Otp);
          this.jdField_a_of_type_Otd.notifyDataSetChanged();
        }
      }
      bnrf.a("family_comment_card_hide_timestamp", Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ora
 * JD-Core Version:    0.7.0.1
 */