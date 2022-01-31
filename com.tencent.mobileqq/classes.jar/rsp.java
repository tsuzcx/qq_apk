import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;

public class rsp
  implements DialogInterface.OnClickListener
{
  public rsp(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent(this.a.a, FavEmosmManageActivity.class);
    this.a.a.startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rsp
 * JD-Core Version:    0.7.0.1
 */