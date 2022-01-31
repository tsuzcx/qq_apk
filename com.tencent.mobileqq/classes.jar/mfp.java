import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.qphone.base.util.QLog;

public class mfp
  extends mck
{
  public mfp(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(bbfr parambbfr)
  {
    if ((QLog.isDevelopLevel()) || (this.a.a != parambbfr.a)) {
      QLog.w(this.a.c, 1, "onGroupInviteFlagChanged, mCanAutoInviteMemIntoTroop[" + this.a.a + "->" + parambbfr.a + "]");
    }
    if (this.a.a != parambbfr.a)
    {
      this.a.a = parambbfr.a;
      this.a.f(0L, 65535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mfp
 * JD-Core Version:    0.7.0.1
 */