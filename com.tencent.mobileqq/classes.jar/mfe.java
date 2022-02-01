import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.qphone.base.util.QLog;

public class mfe
  extends mbx
{
  public mfe(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(bgol parambgol)
  {
    if ((QLog.isDevelopLevel()) || (this.a.a != parambgol.a)) {
      QLog.w(this.a.d, 1, "onGroupInviteFlagChanged, mCanAutoInviteMemIntoTroop[" + this.a.a + "->" + parambgol.a + "]");
    }
    if (this.a.a != parambgol.a)
    {
      this.a.a = parambgol.a;
      this.a.f(0L, 65535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mfe
 * JD-Core Version:    0.7.0.1
 */