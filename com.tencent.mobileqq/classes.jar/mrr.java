import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class mrr
  implements DialogInterface.OnClickListener
{
  mrr(mrp parammrp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    mrp.a(this.a, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mrr
 * JD-Core Version:    0.7.0.1
 */