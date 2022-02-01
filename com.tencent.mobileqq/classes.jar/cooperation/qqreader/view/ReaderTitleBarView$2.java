package cooperation.qqreader.view;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReaderTitleBarView$2
  implements RadioGroup.OnCheckedChangeListener
{
  ReaderTitleBarView$2(ReaderTitleBarView paramReaderTitleBarView) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    ReaderTitleBarView.a(this.a, paramInt);
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.view.ReaderTitleBarView.2
 * JD-Core Version:    0.7.0.1
 */