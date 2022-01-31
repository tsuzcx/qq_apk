import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.ui.VideoInviteFloatBar;
import com.tencent.av.ui.VideoInviteFloatBarUICtr;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class kbm
  extends GAudioUIObserver
{
  public kbm(VideoInviteFloatBarUICtr paramVideoInviteFloatBarUICtr) {}
  
  protected void a()
  {
    super.a();
    this.a.c();
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "onCreateRoomSuc-->GroupID=" + paramLong);
    }
    this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.an = true;
    if (this.a.jdField_b_of_type_Int == 1) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramLong);
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    super.c(paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "onDestroyInviteUI-->reason=" + paramInt);
    }
    if ((this.a.jdField_a_of_type_Long == paramLong) || (0L == paramLong)) {
      this.a.a();
    }
  }
  
  protected void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "notifyCloseGroupVideoInviteMsgBoxByInviteId-->groupId=" + paramLong);
    }
    if ((this.a.jdField_a_of_type_Long == paramLong) && (this.a.e.equals(paramString))) {
      this.a.a();
    }
  }
  
  protected void a(long paramLong, ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (String.valueOf(((VideoController.GAudioFriends)paramArrayList.next()).jdField_a_of_type_Long).equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount())) {
        this.a.a();
      }
    }
  }
  
  protected void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "onEnterRoomSuc-->GroupID=" + paramLong);
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new kbn(this, paramLong), 500L);
    this.a.jdField_a_of_type_ComTencentAvVideoController.g();
    SmallScreenActivityPlugin.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(false);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.c();
    }
    TraeHelper.a().a(this.a.f);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_b_of_type_JavaLangRunnable, 1000L);
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr.troopgroup_vedio.invite", 2, "groupId:" + paramLong1 + ", memUin:" + paramLong2 + ",invitedId:" + paramString + ", mInviterUin:" + this.a.jdField_b_of_type_Long + ", mGroupId:" + this.a.jdField_a_of_type_Long);
    }
    if ((paramLong2 == this.a.jdField_b_of_type_Long) && (paramLong1 == this.a.jdField_a_of_type_Long)) {
      this.a.a();
    }
  }
  
  protected void g(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "notifyCloseAllGroupVideoInviteMsgBox-->notifyByGroupId=" + paramLong);
    }
    if (this.a.jdField_a_of_type_Long != paramLong) {}
    this.a.a();
  }
  
  protected void h(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "notifyCloseGroupVideoInviteMsgBox-->groupId=" + paramLong);
    }
    if (this.a.jdField_a_of_type_Long == paramLong) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kbm
 * JD-Core Version:    0.7.0.1
 */