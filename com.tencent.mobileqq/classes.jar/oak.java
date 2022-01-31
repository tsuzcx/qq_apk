import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity.1;

public class oak
  implements DialogInterface.OnCancelListener
{
  public oak(ReadInJoyUploadAvatarActivity.1 param1) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a.this$0.getIntent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("retCode", 1);
    localBundle.putString("msg", alud.a(2131713482));
    paramDialogInterface.putExtra("Bundle", localBundle);
    this.a.this$0.setResult(-1, paramDialogInterface);
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oak
 * JD-Core Version:    0.7.0.1
 */