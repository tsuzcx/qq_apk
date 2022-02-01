package dov.com.qq.im.ae.camera.ui.watermark;

import android.widget.DatePicker;
import java.util.Calendar;
import java.util.Date;

class WatermarkEditView$1
  implements WatermarkEditListAdapter.OnDateItemClickedListener
{
  WatermarkEditView$1(WatermarkEditView paramWatermarkEditView) {}
  
  public void a()
  {
    WatermarkEditView.a(this.a).setVisibility(8);
  }
  
  public void a(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    WatermarkEditView.a(this.a).init(localCalendar.get(1), localCalendar.get(2), localCalendar.get(5), WatermarkEditView.a(this.a));
    WatermarkEditView.a(this.a).setVisibility(0);
  }
  
  public void b()
  {
    WatermarkEditView.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditView.1
 * JD-Core Version:    0.7.0.1
 */