import android.view.Choreographer.FrameCallback;
import com.tencent.mfsdk.collector.DropFrameMonitor;

public class rbb
  implements Choreographer.FrameCallback
{
  public rbb(DropFrameMonitor paramDropFrameMonitor) {}
  
  public void doFrame(long paramLong)
  {
    this.a.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     rbb
 * JD-Core Version:    0.7.0.1
 */