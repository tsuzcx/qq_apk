package cooperation.ilive.lite.module;

import android.os.Handler;
import androidx.lifecycle.Observer;
import com.tencent.ilive.pages.room.events.ScrollBottomEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;

class IliveReportModule$4
  implements Observer<ScrollBottomEvent>
{
  IliveReportModule$4(IliveReportModule paramIliveReportModule) {}
  
  public void a(ScrollBottomEvent paramScrollBottomEvent)
  {
    ThreadManagerV2.getUIHandlerV2().post(new IliveReportModule.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveReportModule.4
 * JD-Core Version:    0.7.0.1
 */