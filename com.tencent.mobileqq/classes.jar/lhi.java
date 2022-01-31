import android.app.ProgressDialog;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity;

public class lhi
  implements Runnable
{
  public lhi(ReadInJoyUploadAvatarActivity paramReadInJoyUploadAvatarActivity) {}
  
  public void run()
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a = new ProgressDialog(this.a, 2131624516);
    this.a.a.setCancelable(true);
    this.a.a.show();
    this.a.a.setContentView(2130969178);
    ((TextView)this.a.a.findViewById(2131363418)).setText("上传中...");
    this.a.a.setOnCancelListener(new lhj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lhi
 * JD-Core Version:    0.7.0.1
 */