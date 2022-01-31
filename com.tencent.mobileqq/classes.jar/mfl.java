import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.DoubleVideoMeetingCtrlUI;
import com.tencent.av.ui.QavPanel;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class mfl
  extends lhe
{
  public mfl(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.d, 2, "onDestory UI-->relationId = " + paramLong);
    }
    if (this.a.jdField_a_of_type_Long == paramLong) {
      this.a.b(true);
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.d, 2, "onDestroyInviteUI-->GroupId = " + paramLong);
    }
    if (paramLong == this.a.jdField_a_of_type_Long)
    {
      super.a(paramLong);
      this.a.b(true);
    }
  }
  
  protected void a(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2)
  {
    if (this.a.g()) {}
    label381:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w(this.a.d, 1, "onGaOperationResult, result[" + paramInt1 + "], uin[" + paramLong2 + "], info[" + paramLong3 + "], groupId[" + paramLong4 + "], relationType[" + paramInt2 + "], mCameraNum[" + this.a.o + "], seq[" + paramLong1 + "]");
      }
      lid locallid = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      switch (paramInt1)
      {
      case 93: 
      case 94: 
      case 95: 
      case 97: 
      case 98: 
      default: 
        return;
      case 90: 
        if (paramLong3 == 3L) {
          if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
          {
            if (this.a.o <= 1) {
              break label381;
            }
            this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372903, 0);
          }
        }
        break;
      case 96: 
        for (;;)
        {
          if ((!locallid.j) || (this.a.c))
          {
            this.a.c = false;
            this.a.i(paramLong1);
            paramInt1 = locallid.a(this.a.jdField_b_of_type_Long, 1);
            boolean bool = false;
            if (paramInt1 != -1) {
              bool = ((lqq)locallid.c.get(paramInt1)).a;
            }
            this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(bool), Long.valueOf(paramLong1) });
          }
          DoubleVideoMeetingCtrlUI.a(this.a, paramLong1);
          return;
          if ((paramLong3 != 1L) || (locallid.ao)) {
            break;
          }
          this.a.e("onGaOperationResult->REQUEST_VIDEO_SUC");
          this.a.a(paramLong1, locallid.c);
          return;
          this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372903, 8);
        }
      }
    } while ((paramLong3 == 2L) || (paramLong3 != 4L));
    return;
    this.a.c(paramLong1, true);
    this.a.n(paramLong1);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong1) });
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.d, 2, "onCreateRoomSuc-->relationId = " + paramLong2);
    }
    if (paramLong2 != this.a.jdField_a_of_type_Long) {
      return;
    }
    this.a.a(paramLong1, true);
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.a.d, 1, "onMemberVideoOut, groupId[" + paramLong2 + "], friendUin[" + paramLong3 + "], videoSrcType[" + paramInt + "], seq[" + paramLong1 + "]");
    }
    this.a.a(paramLong1, paramLong2, paramLong3, 2);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.d, 1, "onMemberLeave, groupId[" + paramLong1 + "], friendUin[" + paramLong2 + "], isQQUser[" + paramBoolean + "], seq[" + l + "]");
    }
    this.a.a(l, paramLong1, paramLong2, 6);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.d, 1, "onMemberJoin, groupId[" + paramLong1 + "], friendUin[" + paramLong2 + "], isRfresh[" + paramBoolean1 + "], isQQUser[" + paramBoolean2 + "], seq[" + l + "]");
    }
    if (paramLong2 == this.a.jdField_a_of_type_Long)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().ae = 1;
      this.a.a(l, paramLong1, paramLong2, 5);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  protected void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.d, 2, "EnterRoomSuc-->GroupId = " + paramLong2);
    }
    if (paramLong2 == this.a.jdField_a_of_type_Long) {
      this.a.A(paramLong1);
    }
    this.a.a(paramLong1, false);
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.d, 1, "onGaMemberShareSrcInOrOut, groupId[" + paramLong1 + "], groupId[" + paramLong1 + "], bIn[" + paramBoolean1 + "], isPPT[" + paramBoolean2 + "], seq[" + l + "]");
    }
    if (paramBoolean1) {
      this.a.a(l, paramLong1, paramLong2, 3);
    }
    for (;;)
    {
      this.a.jdField_b_of_type_Boolean = paramBoolean2;
      return;
      this.a.a(l, paramLong1, paramLong2, 4);
    }
  }
  
  protected void c(long paramLong, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.d, 1, "onFirstFrameDataComeIn, uin[" + paramLong + "], videoSrcType[" + paramInt + "], seq[" + l + "]");
    }
    paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, paramInt);
    if ((paramInt != -1) && (((lqq)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(paramInt)).a))
    {
      mdd.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
      mdd.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
    }
    DoubleVideoMeetingCtrlUI.b(this.a, l);
    this.a.f("OnFirstFrameDataComeIn");
  }
  
  protected void c(long paramLong1, long paramLong2)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.d, 1, "onMemberVideoIn, groupId[" + paramLong1 + "], friendUin[" + paramLong2 + "], seq[" + l + "]");
    }
    this.a.a(l, paramLong1, paramLong2, 1);
  }
  
  protected void d(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "onMeetingNotifyTimeout, relationId[" + paramLong2 + "]");
    }
    lid locallid = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((paramLong2 == this.a.jdField_a_of_type_Long) && (locallid.g == paramLong2)) {
      this.a.a(paramLong1, locallid, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mfl
 * JD-Core Version:    0.7.0.1
 */