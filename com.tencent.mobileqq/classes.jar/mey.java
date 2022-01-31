import android.media.AudioManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class mey
  implements Runnable
{
  public mey(VideoVolumeControl paramVideoVolumeControl) {}
  
  public void run()
  {
    if (VideoVolumeControl.a(this.a)) {
      if (VideoVolumeControl.a(this.a) != null)
      {
        VideoVolumeControl.a(this.a).requestAudioFocus(null, 3, 2);
        break label71;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + VideoVolumeControl.a(this.a));
      }
      label71:
      return;
      if (VideoVolumeControl.a(this.a) != null)
      {
        Iterator localIterator = VideoVolumeControl.a(this.a).keySet().iterator();
        Object localObject;
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (VideoPlayManager)localIterator.next();
            if ((localObject != null) && (((VideoPlayManager)localObject).a()))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayState  IsPlaying When abandonAudioFocus:" + localObject);
              return;
            }
          }
        }
        localIterator = VideoVolumeControl.b(this.a).keySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (VideoFeedsPlayManager)localIterator.next();
            if ((localObject != null) && (((VideoFeedsPlayManager)localObject).c()))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayState  IsPlaying When abandonAudioFocus:" + localObject);
              return;
            }
          }
        }
        VideoVolumeControl.a(this.a).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mey
 * JD-Core Version:    0.7.0.1
 */