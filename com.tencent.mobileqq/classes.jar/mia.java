import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.qphone.base.util.QLog;

public class mia
  extends meu
{
  public mia(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(bdjk parambdjk)
  {
    if ((QLog.isDevelopLevel()) || (this.a.a != parambdjk.a)) {
      QLog.w(this.a.d, 1, "onGroupInviteFlagChanged, mCanAutoInviteMemIntoTroop[" + this.a.a + "->" + parambdjk.a + "]");
    }
    if (this.a.a != parambdjk.a)
    {
      this.a.a = parambdjk.a;
      this.a.f(0L, 65535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mia
 * JD-Core Version:    0.7.0.1
 */