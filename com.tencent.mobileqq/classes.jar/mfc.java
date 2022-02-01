import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class mfc
  extends lef
{
  public mfc(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  protected void a(long paramLong, ArrayList<lcv> paramArrayList, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onUserListALLUpdate");
    }
    MultiIncomingCallsActivity.a(this.a, paramLong, paramArrayList, paramInt1);
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
    MultiIncomingCallsActivity.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mfc
 * JD-Core Version:    0.7.0.1
 */