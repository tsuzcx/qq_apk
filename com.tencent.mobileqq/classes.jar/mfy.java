import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.qphone.base.util.QLog;

public class mfy
  implements SeekBar.OnSeekBarChangeListener
{
  public mfy(VideoUIManager paramVideoUIManager) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    int j = VideoUIManager.a(this.a).a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onStopTrackingTouch(): progress=" + i + ", playState=" + VideoPlayUtils.a(j));
    }
    if (j == 3) {
      VideoUIManager.a(this.a).a(i * 1000, VideoUIManager.a(this.a));
    }
    while (j != 5) {
      return;
    }
    VideoUIManager.a(this.a).c(i * 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfy
 * JD-Core Version:    0.7.0.1
 */