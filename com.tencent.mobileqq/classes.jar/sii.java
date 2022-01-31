import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.AppRuntime;

class sii
  implements DialogInterface.OnClickListener
{
  sii(sih paramsih) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.a() != null)
    {
      Intent localIntent = new Intent(BaseApplicationImpl.sApplication.getRuntime().getApplication(), QQBrowserActivity.class);
      localIntent.putExtra("url", "https://myun.tenpay.com/mqq/auth/index.shtml?_wv=1027&from=36");
      this.a.a.a().startActivity(localIntent);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sii
 * JD-Core Version:    0.7.0.1
 */