import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.qphone.base.util.QLog;

public class mfj
  extends mcc
{
  public mfj(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(bfxk parambfxk)
  {
    if ((QLog.isDevelopLevel()) || (this.a.a != parambfxk.a)) {
      QLog.w(this.a.d, 1, "onGroupInviteFlagChanged, mCanAutoInviteMemIntoTroop[" + this.a.a + "->" + parambfxk.a + "]");
    }
    if (this.a.a != parambfxk.a)
    {
      this.a.a = parambfxk.a;
      this.a.i(0L, 65535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mfj
 * JD-Core Version:    0.7.0.1
 */