import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PayBridgeActivity;

public class tes
  implements DialogInterface.OnClickListener
{
  public tes(PayBridgeActivity paramPayBridgeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tes
 * JD-Core Version:    0.7.0.1
 */