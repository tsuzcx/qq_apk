import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qphone.base.util.QLog;

class rku
  implements SeekBar.OnSeekBarChangeListener
{
  rku(rkp paramrkp) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    int j = rkp.a(this.a).a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onStopTrackingTouch(): progress=" + i + ", playState=" + rjm.a(j));
    }
    if (j == 3) {
      rkp.a(this.a).a(i * 1000, rkp.a(this.a));
    }
    while (j != 5) {
      return;
    }
    rkp.a(this.a).c(i * 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rku
 * JD-Core Version:    0.7.0.1
 */