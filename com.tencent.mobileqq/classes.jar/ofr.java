import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ofr
  implements DialogInterface.OnClickListener
{
  ofr(ohs paramohs, oif paramoif) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Ohs != null)
      {
        paramDialogInterface = this.jdField_a_of_type_Ohs.a();
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(this.jdField_a_of_type_Oif);
          this.jdField_a_of_type_Ohs.notifyDataSetChanged();
        }
      }
      bhvy.a("family_comment_card_hide_timestamp", Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ofr
 * JD-Core Version:    0.7.0.1
 */