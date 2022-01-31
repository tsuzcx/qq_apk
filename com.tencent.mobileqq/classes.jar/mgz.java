import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class mgz
  extends lht
{
  public mgz(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  protected void a(long paramLong1, long paramLong2, ArrayList<lqk> paramArrayList)
  {
    ThreadManager.getUIHandler().post(new MultiIncomingCallsActivity.1.1(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mgz
 * JD-Core Version:    0.7.0.1
 */