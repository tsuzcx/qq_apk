import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.av.wtogether.view.WatchTogetherAdminControlView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nay
  implements SeekBar.OnSeekBarChangeListener
{
  public nay(WatchTogetherAdminControlView paramWatchTogetherAdminControlView, SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener != null) {
      this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener.onProgressChanged(paramSeekBar, paramInt, paramBoolean);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener != null) {
      this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener.onStartTrackingTouch(paramSeekBar);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener != null) {
      this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener.onStopTrackingTouch(paramSeekBar);
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nay
 * JD-Core Version:    0.7.0.1
 */