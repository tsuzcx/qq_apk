import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.gaudio.GaInviteLockActivity.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class lqb
  extends lht
{
  public lqb(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  protected void a(long paramLong1, long paramLong2, ArrayList<lqk> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onReceiveMemberList mMemberChangeEventReceiver size:" + paramArrayList.size());
    }
    ThreadManager.getUIHandler().post(new GaInviteLockActivity.1.1(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lqb
 * JD-Core Version:    0.7.0.1
 */