import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment.1;

public class onc
  implements DialogInterface.OnCancelListener
{
  public onc(ReadInJoyUploadAvatarFragment.1 param1) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a.a.getIntent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("retCode", 1);
    localBundle.putString("msg", amtj.a(2131712202));
    paramDialogInterface.putExtra("Bundle", localBundle);
    this.a.a.setResult(-1, paramDialogInterface);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     onc
 * JD-Core Version:    0.7.0.1
 */