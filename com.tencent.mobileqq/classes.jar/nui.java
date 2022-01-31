import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class nui
  implements DialogInterface.OnClickListener
{
  nui(nwk paramnwk, nwx paramnwx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Nwk != null)
      {
        paramDialogInterface = this.jdField_a_of_type_Nwk.a();
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(this.jdField_a_of_type_Nwx);
          this.jdField_a_of_type_Nwk.notifyDataSetChanged();
        }
      }
      bgmq.a("family_comment_card_hide_timestamp", Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nui
 * JD-Core Version:    0.7.0.1
 */