import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity;

class lhj
  implements DialogInterface.OnCancelListener
{
  lhj(lhi paramlhi) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("retCode", 1);
    localBundle.putString("msg", "用户取消");
    paramDialogInterface.putExtra("Bundle", localBundle);
    this.a.a.setResult(-1, paramDialogInterface);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lhj
 * JD-Core Version:    0.7.0.1
 */