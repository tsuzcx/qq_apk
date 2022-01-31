import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.av.ui.beauty.BeautySeekView;

public class mon
  implements SeekBar.OnSeekBarChangeListener
{
  public mon(BeautySeekView paramBeautySeekView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (BeautySeekView.a(this.a) != paramInt)
    {
      BeautySeekView.a(this.a, paramInt);
      if (paramBoolean) {
        BeautySeekView.a(this.a).setContentDescription(paramInt + "%");
      }
      BeautySeekView.a(this.a, paramInt);
      BeautySeekView.b(this.a, BeautySeekView.a(this.a));
    }
    if (BeautySeekView.a(this.a) != null) {
      BeautySeekView.a(this.a).a(BeautySeekView.a(this.a), 2, paramInt);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    BeautySeekView.a(this.a).removeCallbacks(this.a.a);
    BeautySeekView.a(this.a).setVisibility(0);
    if (BeautySeekView.a(this.a) != null) {
      BeautySeekView.a(this.a).a(BeautySeekView.a(this.a), 1, BeautySeekView.a(this.a));
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    BeautySeekView.a(this.a).postDelayed(this.a.a, 300L);
    if (BeautySeekView.a(this.a) != null) {
      BeautySeekView.a(this.a).a(BeautySeekView.a(this.a), 3, BeautySeekView.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mon
 * JD-Core Version:    0.7.0.1
 */