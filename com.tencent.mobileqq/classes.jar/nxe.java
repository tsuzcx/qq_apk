import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity.1;

public class nxe
  implements DialogInterface.OnCancelListener
{
  public nxe(ReadInJoyUploadAvatarActivity.1 param1) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a.this$0.getIntent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("retCode", 1);
    localBundle.putString("msg", ajya.a(2131713098));
    paramDialogInterface.putExtra("Bundle", localBundle);
    this.a.this$0.setResult(-1, paramDialogInterface);
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxe
 * JD-Core Version:    0.7.0.1
 */