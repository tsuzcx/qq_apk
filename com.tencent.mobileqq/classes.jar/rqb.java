import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.widget.QQToast;

public class rqb
  implements DialogInterface.OnClickListener
{
  public rqb(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQToast.a(this.a.a, 0, this.a.a.getResources().getString(2131433766), 0).a();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rqb
 * JD-Core Version:    0.7.0.1
 */