package dov.com.qq.im.capture.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class VideoCoverPickerProviderView$1
  implements View.OnClickListener
{
  VideoCoverPickerProviderView$1(VideoCoverPickerProviderView paramVideoCoverPickerProviderView) {}
  
  public void onClick(View paramView)
  {
    if (VideoCoverPickerProviderView.a(this.a) != null)
    {
      VideoCoverPickerProviderView.PickerListener localPickerListener = (VideoCoverPickerProviderView.PickerListener)VideoCoverPickerProviderView.a(this.a).get();
      if (localPickerListener != null) {
        localPickerListener.a(VideoCoverPickerProviderView.a(this.a), true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.capture.view.VideoCoverPickerProviderView.1
 * JD-Core Version:    0.7.0.1
 */