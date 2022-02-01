import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.qphone.base.util.QLog;

public class mga
  extends mct
{
  public mga(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(bhon parambhon)
  {
    if ((QLog.isDevelopLevel()) || (this.a.a != parambhon.a)) {
      QLog.w(this.a.d, 1, "onGroupInviteFlagChanged, mCanAutoInviteMemIntoTroop[" + this.a.a + "->" + parambhon.a + "]");
    }
    if (this.a.a != parambhon.a)
    {
      this.a.a = parambhon.a;
      this.a.i(0L, 65535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mga
 * JD-Core Version:    0.7.0.1
 */