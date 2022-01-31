import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class okd
  implements DialogInterface.OnClickListener
{
  okd(omg paramomg, omt paramomt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Omg != null)
      {
        paramDialogInterface = this.jdField_a_of_type_Omg.a();
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(this.jdField_a_of_type_Omt);
          this.jdField_a_of_type_Omg.notifyDataSetChanged();
        }
      }
      bjxj.a("family_comment_card_hide_timestamp", Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okd
 * JD-Core Version:    0.7.0.1
 */