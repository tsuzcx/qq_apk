import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.av.ui.GAudioMembersCtrlActivity.7.1;
import com.tencent.av.ui.GAudioMembersCtrlActivity.7.2;
import com.tencent.av.ui.GAudioMembersCtrlActivity.7.3;
import com.tencent.av.ui.GAudioMembersCtrlActivity.7.4;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class mdr
  extends ldy
{
  public mdr(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "onDestroyUI");
    }
    this.a.finish();
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GAudioMembersCtrlActivity", 2, "onGAudioMemberMicChanged-->uin=" + paramLong + ",isMicOff=" + paramBoolean);
    }
    GAudioMembersCtrlActivity.c(this.a, new GAudioMembersCtrlActivity.7.3(this, paramLong, paramInt1, paramInt2, paramBoolean));
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_Long != paramLong1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMembersCtrlActivity", 2, "onMemberJoin,wrong group uin.GroupUin = " + paramLong1 + " ,mGroupId = " + this.a.jdField_a_of_type_Long + " ,isQQUser = " + paramBoolean);
      }
      return;
    }
    super.a(paramLong1, paramLong2, paramBoolean);
    this.a.a(paramLong2, 1, true, 71);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (this.a.jdField_a_of_type_Long != paramLong1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMembersCtrlActivity", 2, "onMemberJoin,wrong group uin.GroupUin = " + paramLong1 + " ,mGroupId = " + this.a.jdField_a_of_type_Long + " ,isQQUser = " + paramBoolean2);
      }
      return;
    }
    this.a.a(paramLong2, 0, paramBoolean1, 70);
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GAudioMembersCtrlActivity", 2, "onGAudioRoomMicModeChanged-->uin=" + paramLong + ",isRoomMicOff=" + paramBoolean1);
    }
    GAudioMembersCtrlActivity.b(this.a, new GAudioMembersCtrlActivity.7.2(this));
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2, paramInt);
    if (paramBoolean1) {}
    for (paramInt = 42;; paramInt = 43)
    {
      this.a.a(paramLong, 2, paramBoolean2, paramInt);
      return;
    }
  }
  
  protected void a(ArrayList<lmp> paramArrayList)
  {
    GAudioMembersCtrlActivity.d(this.a, new GAudioMembersCtrlActivity.7.4(this, paramArrayList));
  }
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    this.a.jdField_a_of_type_Mdf.b(paramLong, paramBoolean);
  }
  
  protected void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.a.finish();
  }
  
  protected void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "onUpdatePstnInfo --> Start");
    }
    GAudioMembersCtrlActivity.a(this.a, new GAudioMembersCtrlActivity.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mdr
 * JD-Core Version:    0.7.0.1
 */