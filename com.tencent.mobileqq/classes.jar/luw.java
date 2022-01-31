import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.qphone.base.util.QLog;

public class luw
  extends lru
{
  public luw(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(baem parambaem)
  {
    if ((QLog.isDevelopLevel()) || (this.a.a != parambaem.a)) {
      QLog.w(this.a.c, 1, "onGroupInviteFlagChanged, mCanAutoInviteMemIntoTroop[" + this.a.a + "->" + parambaem.a + "]");
    }
    if (this.a.a != parambaem.a)
    {
      this.a.a = parambaem.a;
      this.a.f(0L, 65535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     luw
 * JD-Core Version:    0.7.0.1
 */