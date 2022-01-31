import android.media.MediaRecorder;
import android.media.MediaRecorder.OnInfoListener;
import com.tencent.mobileqq.activity.MakeVideoActivity;
import com.tencent.qphone.base.util.QLog;

public class syt
  implements MediaRecorder.OnInfoListener
{
  public syt(MakeVideoActivity paramMakeVideoActivity) {}
  
  public void onInfo(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      QLog.i(this.a.a, 4, "start|onInfo|what=" + paramInt1 + ",extra=" + paramInt2);
      return;
    }
    QLog.i(this.a.a, 4, "start|onInfo|max file size reached.extra=" + paramInt2);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     syt
 * JD-Core Version:    0.7.0.1
 */