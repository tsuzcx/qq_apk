import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class rmj
  implements DialogInterface.OnClickListener
{
  rmj(rmh paramrmh) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.a.a.a.a.setText("");
      BaseChatPie.a(this.a.a.a).delete(0, BaseChatPie.a(this.a.a.a).length());
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rmj
 * JD-Core Version:    0.7.0.1
 */