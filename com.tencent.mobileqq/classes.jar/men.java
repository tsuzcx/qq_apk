import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.av.ui.GAudioMembersCtrlActivity.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class men
  extends les
{
  public men(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  protected void a(long paramLong1, long paramLong2, ArrayList<lcu> paramArrayList)
  {
    ThreadManager.getUIHandler().post(new GAudioMembersCtrlActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     men
 * JD-Core Version:    0.7.0.1
 */