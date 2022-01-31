import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qphone.base.util.QLog;

class qve
  implements SeekBar.OnSeekBarChangeListener
{
  qve(qva paramqva) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    int j = qva.a(this.a).a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onStopTrackingTouch(): progress=" + i + ", playState=" + qtx.a(j));
    }
    if (j == 3) {
      qva.a(this.a).a(i * 1000, qva.a(this.a));
    }
    while (j != 5) {
      return;
    }
    qva.a(this.a).c(i * 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qve
 * JD-Core Version:    0.7.0.1
 */