import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sqi
  implements SeekBar.OnSeekBarChangeListener
{
  sqi(sqd paramsqd) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    int j = sqd.a(this.a).a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onStopTrackingTouch(): progress=" + i + ", playState=" + spm.a(j));
    }
    if (j == 3) {
      sqd.a(this.a).a(i * 1000, sqd.a(this.a));
    }
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      if (j == 5) {
        sqd.a(this.a).c(i * 1000);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sqi
 * JD-Core Version:    0.7.0.1
 */