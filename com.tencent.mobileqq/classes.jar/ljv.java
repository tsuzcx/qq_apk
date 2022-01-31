import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoDownloadManager;

public class ljv
  implements DialogInterface.OnClickListener
{
  public ljv(ReadInJoyCameraCaptureActivity paramReadInJoyCameraCaptureActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReadInJoyCameraCaptureActivity.b(this.a, 6);
    ReadInJoyCameraCaptureActivity.a(this.a);
    ReadInJoyCameraCaptureActivity.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ljv
 * JD-Core Version:    0.7.0.1
 */