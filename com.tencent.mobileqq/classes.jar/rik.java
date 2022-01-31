import com.tencent.mfsdk.collector.DropFrameMonitor;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

public class rik
  implements AbstractUnifiedMonitor.ThreadMonitorCallback
{
  public rik(DropFrameMonitor paramDropFrameMonitor) {}
  
  public void onThreadMonitorEnd(int paramInt)
  {
    if (paramInt == 10) {
      DropFrameMonitor.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     rik
 * JD-Core Version:    0.7.0.1
 */