import android.os.Handler;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.ui.MultiIncomingCallUICtr;
import com.tencent.av.ui.VideoInviteFloatBar;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;

public class jxj
  extends GAudioUIObserver
{
  public jxj(MultiIncomingCallUICtr paramMultiIncomingCallUICtr) {}
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "onCreateRoomSuc-->GroupID=" + paramLong);
    }
    this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.an = true;
    if (this.a.jdField_b_of_type_Int == 1) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramLong);
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    super.c(paramLong);
    if (this.a.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "onDestroyInviteUI, doubleVideoMeeting, groupId:" + paramLong + ", mPeerUin:" + this.a.jdField_c_of_type_JavaLangString);
      }
      if ((this.a.jdField_c_of_type_JavaLangString != null) && (this.a.jdField_c_of_type_JavaLangString.equals(String.valueOf(paramLong))))
      {
        this.a.a(paramInt);
        this.a.a();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "onDestroyInviteUI, groupId:" + paramLong + ", reason:" + paramInt + ", mGroupId:" + this.a.jdField_a_of_type_Long);
      }
      return;
      if ((this.a.jdField_a_of_type_Long == paramLong) || (0L == paramLong)) {
        this.a.a();
      }
    }
  }
  
  protected void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "notifyCloseGroupVideoInviteMsgBoxByInviteId-->GroupID=" + paramLong);
    }
    if ((this.a.jdField_a_of_type_Long == paramLong) && (this.a.e.equals(paramString))) {
      this.a.a();
    }
  }
  
  protected void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "onEnterRoomSuc-->GroupID=" + paramLong);
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jxk(this, paramLong), 500L);
    this.a.g();
    SmallScreenActivityPlugin.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(false);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.c();
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_c_of_type_JavaLangRunnable, 1000L);
    TraeHelper.a().a(this.a.f);
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr.troopgroup_vedio.invite", 2, "groupId:" + paramLong1 + ", memUin:" + paramLong2 + ",invitedId:" + paramString + ", mInviterUin:" + this.a.jdField_b_of_type_Long + ", mGroupId:" + this.a.jdField_a_of_type_Long);
    }
    if ((paramLong2 == this.a.jdField_b_of_type_Long) && (paramLong1 == this.a.jdField_a_of_type_Long)) {
      this.a.a();
    }
  }
  
  protected void g(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "notifyCloseAllGroupVideoInviteMsgBox-->GroupID=" + paramLong);
    }
    if (this.a.jdField_a_of_type_Long != paramLong) {
      this.a.c(0);
    }
    this.a.a();
  }
  
  protected void h(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "notifyCloseGroupVideoInviteMsgBox-->GroupID=" + paramLong);
    }
    if (this.a.jdField_a_of_type_Long == paramLong) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jxj
 * JD-Core Version:    0.7.0.1
 */