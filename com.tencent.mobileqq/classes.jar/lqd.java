import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class lqd
  extends lhe
{
  public lqd(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  protected void a(long paramLong, ArrayList<lfu> paramArrayList, int paramInt1, int paramInt2)
  {
    GaInviteLockActivity.a(this.a, paramLong, paramArrayList, paramInt1);
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onMembersChange");
    }
    if ((paramLong != this.a.a) || (paramBoolean)) {}
    while (((paramInt != 10) && (paramInt != 1)) || (!this.a.isResume())) {
      return;
    }
    GaInviteLockActivity.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lqd
 * JD-Core Version:    0.7.0.1
 */