import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import com.tencent.mobileqq.activity.MakeVideoActivity;
import com.tencent.qphone.base.util.QLog;

public class syu
  implements MediaRecorder.OnErrorListener
{
  public syu(MakeVideoActivity paramMakeVideoActivity) {}
  
  public void onError(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    paramMediaRecorder = "(code = " + paramInt1 + ", extra = " + paramInt2 + ")";
    QLog.w(this.a.a, 1, "MakeVideoActivity error " + paramMediaRecorder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     syu
 * JD-Core Version:    0.7.0.1
 */