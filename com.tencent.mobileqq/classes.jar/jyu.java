import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.mobileqq.utils.QAVGroupConfig.GroupInviteFlag;
import com.tencent.qphone.base.util.QLog;

public class jyu
  extends ControlUIObserver
{
  public jyu(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(QAVGroupConfig.GroupInviteFlag paramGroupInviteFlag)
  {
    if ((QLog.isDevelopLevel()) || (this.a.b != paramGroupInviteFlag.a)) {
      QLog.w(this.a.c, 1, "onGroupInviteFlagChanged, mEnableInvite[" + this.a.b + "->" + paramGroupInviteFlag.a + "]");
    }
    if (this.a.b != paramGroupInviteFlag.a)
    {
      this.a.b = paramGroupInviteFlag.a;
      this.a.s_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jyu
 * JD-Core Version:    0.7.0.1
 */