import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;

public class lgy
  implements DialogInterface.OnClickListener
{
  public lgy(ReadInJoyCameraCaptureActivity paramReadInJoyCameraCaptureActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.setResult(0, this.a.getIntent());
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgy
 * JD-Core Version:    0.7.0.1
 */