import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qphone.base.util.QLog;

class qvh
  implements SeekBar.OnSeekBarChangeListener
{
  qvh(qvd paramqvd) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    int j = qvd.a(this.a).a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onStopTrackingTouch(): progress=" + i + ", playState=" + qua.a(j));
    }
    if (j == 3) {
      qvd.a(this.a).a(i * 1000, qvd.a(this.a));
    }
    while (j != 5) {
      return;
    }
    qvd.a(this.a).c(i * 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qvh
 * JD-Core Version:    0.7.0.1
 */