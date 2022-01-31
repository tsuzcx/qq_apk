import android.content.Intent;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.6.1;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.AutoCheckVideoRunnable;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class lut
  extends kur
{
  public lut(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onServiceConnected");
    }
    super.a();
    if (this.a.b != 0L)
    {
      int i = this.a.d;
      Object localObject = String.valueOf(this.a.b);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, (String)localObject);
      if ((this.a.jdField_c_of_type_Int == 0) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null))
      {
        Intent localIntent = this.a.a();
        if ((localIntent == null) || (!localIntent.hasExtra("invitelist")))
        {
          localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a((String)localObject);
          if (localObject != null)
          {
            this.a.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject);
            this.a.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject, false);
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onInviteUserNotice --> Count = " + paramInt + " ,firstName = " + paramString);
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (baep.b(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.a.b)))) {
        paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(this.a.b), this.a.jdField_e_of_type_Int);
      }
      this.a.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable.a(paramInt, paramString);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable, 500L);
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (this.a.g()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_c_of_type_JavaLangString, 1, "onCreateRoomSuc, groupId[" + paramLong2 + "], isVideo[" + this.a.jdField_e_of_type_Boolean + "], seq[" + paramLong1 + "]");
    }
    if (this.a.jdField_e_of_type_Boolean)
    {
      i = 2;
      awqp.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      if (!this.a.jdField_e_of_type_Boolean) {
        break label245;
      }
    }
    label245:
    for (int i = 4;; i = 3)
    {
      mba.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      this.a.w();
      this.a.o(paramLong1);
      this.a.jdField_a_of_type_Mig.c(true);
      this.a.jdField_a_of_type_Mig.b(true);
      this.a.jdField_a_of_type_Mig.a();
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().aj = true;
      this.a.a(true, paramLong2);
      return;
      i = 1;
      break;
    }
  }
  
  protected void a(String paramString, String[] paramArrayOfString)
  {
    super.a(paramString, paramArrayOfString);
    long l = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.a.b));
    if (QLog.isColorLevel())
    {
      String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramString, String.valueOf(this.a.b), this.a.jdField_e_of_type_Int);
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onOtherMemberInvited --> l= " + String.valueOf(l) + "inviterName=" + str);
    }
    if (baep.b(l))
    {
      this.a.b(paramString, paramArrayOfString);
      return;
    }
    this.a.a(paramString, paramArrayOfString);
  }
  
  protected void b(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_c_of_type_JavaLangString, 1, "onInviteSomeoneEnter, firstUin[" + paramLong + "], length[" + paramInt + "]");
    }
    super.b(paramLong, paramInt);
    this.a.g = paramInt;
    this.a.c(paramLong, 68, true, -1);
  }
  
  protected void b(long paramLong, int paramInt1, int paramInt2)
  {
    this.a.a(paramLong, paramInt1, paramInt2);
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    if (this.a.g()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_c_of_type_JavaLangString, 1, "onEnterRoomSuc, groupId[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    if (this.a.jdField_e_of_type_Boolean)
    {
      i = 4;
      mba.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      if (!this.a.jdField_e_of_type_Boolean) {
        break label268;
      }
    }
    label268:
    for (int i = 2;; i = 1)
    {
      awqp.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      this.a.w();
      this.a.o(paramLong1);
      this.a.jdField_a_of_type_Mig.c(true);
      this.a.jdField_a_of_type_Mig.b(true);
      this.a.jdField_a_of_type_Mig.a();
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiVideoCtrlLayerUI4Discussion.AutoCheckVideoRunnable(this.a), 500L);
      this.a.y();
      this.a.a(false, paramLong2);
      this.a.f(paramLong1, 65535);
      this.a.B();
      return;
      i = 3;
      break;
    }
  }
  
  protected void c()
  {
    if (this.a.jdField_e_of_type_Int != 2) {
      return;
    }
    this.a.f(0L, 65535);
  }
  
  protected void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onUpdatePstnInfo --> Start");
    }
    AVActivity localAVActivity = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAVActivity != null) {
      localAVActivity.runOnUiThread(new MultiVideoCtrlLayerUI4Discussion.6.1(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(this.a.jdField_c_of_type_JavaLangString, 2, "onUpdatePstnInfo-->Can not get AVActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lut
 * JD-Core Version:    0.7.0.1
 */