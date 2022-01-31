import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qphone.base.util.QLog;

class qjc
  implements SeekBar.OnSeekBarChangeListener
{
  qjc(qiy paramqiy) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    int j = qiy.a(this.a).a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onStopTrackingTouch(): progress=" + i + ", playState=" + qhv.a(j));
    }
    if (j == 3) {
      qiy.a(this.a).a(i * 1000, qiy.a(this.a));
    }
    while (j != 5) {
      return;
    }
    qiy.a(this.a).c(i * 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qjc
 * JD-Core Version:    0.7.0.1
 */