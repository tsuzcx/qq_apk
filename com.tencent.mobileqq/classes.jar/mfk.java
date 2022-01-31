import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.qphone.base.util.QLog;

public class mfk
  extends mcf
{
  public mfk(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(bbgf parambbgf)
  {
    if ((QLog.isDevelopLevel()) || (this.a.a != parambbgf.a)) {
      QLog.w(this.a.c, 1, "onGroupInviteFlagChanged, mCanAutoInviteMemIntoTroop[" + this.a.a + "->" + parambbgf.a + "]");
    }
    if (this.a.a != parambbgf.a)
    {
      this.a.a = parambbgf.a;
      this.a.f(0L, 65535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mfk
 * JD-Core Version:    0.7.0.1
 */