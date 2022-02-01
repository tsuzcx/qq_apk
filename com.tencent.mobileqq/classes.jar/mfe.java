import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class mfe
  extends let
{
  public mfe(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  protected void a(long paramLong1, long paramLong2, ArrayList<lny> paramArrayList)
  {
    if (MultiIncomingCallsActivity.a(this.a) != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(MultiIncomingCallsActivity.a(this.a));
      MultiIncomingCallsActivity.a(this.a, null);
    }
    MultiIncomingCallsActivity.a(this.a, new MultiIncomingCallsActivity.1.1(this, paramArrayList));
    ThreadManager.getUIHandler().post(MultiIncomingCallsActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mfe
 * JD-Core Version:    0.7.0.1
 */