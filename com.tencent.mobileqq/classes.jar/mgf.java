import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.qphone.base.util.QLog;

public class mgf
  extends mcx
{
  public mgf(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(bhgc parambhgc)
  {
    if ((QLog.isDevelopLevel()) || (this.a.a != parambhgc.a)) {
      QLog.w(this.a.d, 1, "onGroupInviteFlagChanged, mCanAutoInviteMemIntoTroop[" + this.a.a + "->" + parambhgc.a + "]");
    }
    if (this.a.a != parambhgc.a)
    {
      this.a.a = parambhgc.a;
      this.a.i(0L, 16777215);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mgf
 * JD-Core Version:    0.7.0.1
 */