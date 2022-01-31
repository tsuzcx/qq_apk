import android.app.ProgressDialog;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity;

public class leu
  implements Runnable
{
  public leu(ReadInJoyUploadAvatarActivity paramReadInJoyUploadAvatarActivity) {}
  
  public void run()
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a = new ProgressDialog(this.a, 2131624516);
    this.a.a.setCancelable(true);
    this.a.a.show();
    this.a.a.setContentView(2130969180);
    ((TextView)this.a.a.findViewById(2131363399)).setText("上传中...");
    this.a.a.setOnCancelListener(new lev(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     leu
 * JD-Core Version:    0.7.0.1
 */