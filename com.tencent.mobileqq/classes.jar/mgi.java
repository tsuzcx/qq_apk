import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.av.ui.GAudioMembersCtrlActivity.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class mgi
  extends lhs
{
  public mgi(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  protected void a(long paramLong1, long paramLong2, ArrayList<lfu> paramArrayList)
  {
    ThreadManager.getUIHandler().post(new GAudioMembersCtrlActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mgi
 * JD-Core Version:    0.7.0.1
 */