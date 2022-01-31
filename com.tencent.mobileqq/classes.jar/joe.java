import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.EllipsisUtil;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class joe
  extends GAudioUIObserver
{
  public joe(SmallScreenMultiVideoControlUI paramSmallScreenMultiVideoControlUI) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onServiceConnected");
    }
    super.a();
    if (this.a.a() != 0L)
    {
      int i = this.a.c;
      Object localObject = String.valueOf(this.a.a());
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, (String)localObject);
      if ((this.a.jdField_a_of_type_ArrayOfLong != null) && (this.a.jdField_a_of_type_ArrayOfLong.length == 0) && (this.a.jdField_b_of_type_Int == 0))
      {
        localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a((String)localObject);
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (localObject != null))
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject);
          i = ConfigSystemImpl.c(this.a.jdField_a_of_type_ComTencentAvVideoController.a());
          this.a.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject, false, i, 1);
        }
      }
    }
  }
  
  protected void a(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.a.d != 1) {}
    do
    {
      return;
      if (paramInt2 == 102)
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().aa = true;
        return;
      }
    } while (paramInt2 != 103);
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {}
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().aa = false;
  }
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2)
  {
    label189:
    VideoViewInfo localVideoViewInfo;
    switch (paramInt1)
    {
    default: 
    case 96: 
    case 97: 
    case 98: 
    case 90: 
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenMultiVideoControlUI", 2, "request video success,Info=" + paramLong2);
          }
          if (paramLong2 == 1L)
          {
            this.a.a("onGaOperationResult");
            this.a.q();
            this.a.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c);
            return;
          }
        } while (paramLong2 != 0L);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenMultiVideoControlUI", 2, "request video failed");
        }
        this.a.a(paramLong1, paramInt1, false, -1);
        return;
      } while (paramLong2 != 3L);
      ArrayList localArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
      paramInt1 = 0;
      if (paramInt1 < localArrayList.size())
      {
        localVideoViewInfo = (VideoViewInfo)localArrayList.get(paramInt1);
        if (paramLong1 != localVideoViewInfo.jdField_a_of_type_Long) {
          break;
        }
      }
      break;
    }
    for (boolean bool = localVideoViewInfo.jdField_a_of_type_Boolean;; bool = false)
    {
      this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(105), Boolean.valueOf(bool) });
      this.a.q();
      return;
      paramInt1 += 1;
      break label189;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenMultiVideoControlUI", 2, "go on stage failed");
      }
      if (this.a.d != 2) {
        break;
      }
      ReportController.b(null, "CliOper", "", "", "0X800441E", "0X800441E", 0, 0, "", "", "", "");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SmallScreenMultiVideoControlUI", 2, "Go Off Stage-->roomMode=" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().I + " isBeBan" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().ad + " isPressSpeaking=" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().Z + " isOnlyManagerCanOnStage=" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().aa);
      return;
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onInviteUserNotice --> Count = " + paramInt + " ,firstName = " + paramString);
    }
  }
  
  protected void a(int paramInt, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onUpdatePstnInfo --> Start ");
    }
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onCreateRoomSuc-->GroupID=" + paramLong);
    }
    super.a(paramLong);
    this.a.g();
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().an = true;
    if (this.a.c == 1) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.a());
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    this.a.a(paramLong2, 5, false, 72);
  }
  
  protected void a(long paramLong1, long paramLong2, int paramInt)
  {
    super.a(paramLong1, paramLong2);
    if (paramLong2 == this.a.jdField_a_of_type_Long) {
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SmallScreenMultiVideoControlUI", 2, "onMemberVideoOut-->Server  gooffstahe ,must close local video");
        }
        this.a.o();
      }
    }
    for (;;)
    {
      this.a.a(paramLong2, 6, false, 73);
      return;
      VideoViewInfo localVideoViewInfo = new VideoViewInfo();
      localVideoViewInfo.jdField_a_of_type_Long = paramLong2;
      localVideoViewInfo.jdField_a_of_type_Int = paramInt;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localVideoViewInfo);
      this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    }
  }
  
  protected void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onVideoSrcTypeChange-->mGroupId=" + this.a.a() + " userUin=" + paramLong2 + " groupUin=" + paramLong1 + " videoSrcType=" + paramInt1 + " relationType" + paramInt2);
    }
    if (paramLong1 != this.a.a()) {}
    while (paramInt2 != 1) {
      return;
    }
    this.a.a(paramLong2, 10, false, paramInt1);
    if ((paramInt1 == 2) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().g))
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(111), Boolean.valueOf(true) });
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(111), Boolean.valueOf(false) });
  }
  
  protected void a(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onMemberBanOrCancelBanAudio-->relationId=" + paramLong1 + " userUin=" + paramLong2 + " relationType=" + paramInt + " bBan=" + paramBoolean);
    }
    if ((this.a.a() != paramLong1) || (paramLong2 != this.a.jdField_a_of_type_Long) || (paramInt != 1)) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().ad = true;
    } while (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean);
    this.a.o();
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 1, false);
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onGroupSecurityLimit-->groupid=" + paramLong1 + " info=" + paramLong2 + " strMsg=" + paramString);
    }
    if (this.a.d != 1) {}
    do
    {
      do
      {
        return;
      } while (paramLong1 != this.a.a());
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 33);
      localIntent.putExtra("relationId", paramLong1);
      localIntent.putExtra("uinType", this.a.c);
      localIntent.putExtra("info", paramLong2);
      localIntent.putExtra("strMsg", paramString);
      localIntent.putExtra("MultiAVType", this.a.jdField_a_of_type_ComTencentAvVideoController.a().D);
      localIntent.putExtra("from", "SmallScreenMultiVideoControlUI1");
      paramString = (SmallScreenService)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramString != null)
      {
        localIntent.setPackage(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        paramString.sendBroadcast(localIntent);
        paramString.stopSelf();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SmallScreenMultiVideoControlUI", 2, "onGroupSecurityLimit-->can not get the activity");
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().G) {
      if (this.a.a() != paramLong1) {
        if (QLog.isColorLevel()) {
          QLog.e("SmallScreenMultiVideoControlUI", 2, "onMemberLeave,wrong group uin.GroupUin = " + paramLong1 + " ,mGroupId = " + this.a.a() + " ,isQQUser = " + paramBoolean);
        }
      }
    }
    while (paramLong2 == this.a.jdField_a_of_type_Long)
    {
      return;
      super.a(paramLong1, paramLong2, paramBoolean);
      this.a.a(paramLong2, 1, true, 71);
      return;
    }
    this.a.x();
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (this.a.a() != paramLong1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "onMemberJoin,wrong group uin.GroupUin = " + paramLong1 + " ,mGroupId = " + this.a.a() + " ,isQQUser = " + paramBoolean2);
      }
      return;
    }
    this.a.a(paramLong2, 0, paramBoolean1, 70);
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2);
    if (paramBoolean1) {}
    for (int i = 42;; i = 43)
    {
      this.a.a(paramLong, 2, paramBoolean2, i);
      return;
    }
  }
  
  protected void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
  }
  
  protected void a(String paramString, String[] paramArrayOfString)
  {
    super.a(paramString, paramArrayOfString);
    int i = paramArrayOfString.length;
    if (i < 1) {
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayOfString, String.valueOf(this.a.a()), this.a.d);
    if (i == 1) {
      this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429016);
    }
    for (;;)
    {
      this.a.a(Long.valueOf(paramString).longValue(), 82, true, -1);
      return;
      String.format(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429015), new Object[] { Integer.valueOf(i) });
    }
  }
  
  protected void b(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.a.d != 1) {
      return;
    }
    switch (paramInt2)
    {
    case 102: 
    case 103: 
    case 105: 
    case 106: 
    default: 
      return;
    case 101: 
      this.a.jdField_a_of_type_ComTencentAvVideoController.a("SmallScreenMultiVideoControlUI.onSpeakModeChanged", this.a.a(), false);
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().Z = true;
      return;
    case 108: 
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().I = 108;
      return;
    case 107: 
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().I = 107;
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().I = 104;
  }
  
  protected void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onEnterRoomSuc-->GroupID=" + paramLong);
    }
    super.b(paramLong);
    this.a.g();
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new joh(this), 500L);
  }
  
  protected void b(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onInviteSomeoneEnter-->firstUin=" + paramLong + " length=" + paramInt);
    }
    super.b(paramLong, paramInt);
    this.a.a(paramLong, 68, true, -1);
  }
  
  protected void b(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onGroupVideoChatClosed-->relationId" + paramLong);
    }
    if (this.a.a() != paramLong) {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "onGroupVideoChatClosed--> relationId != mIntentGroupId");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.a.d != 1);
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 32);
      localIntent.putExtra("relationId", paramLong);
      localIntent.putExtra("uinType", this.a.c);
      localIntent.putExtra("closeType", paramInt1);
      localIntent.putExtra("MultiAVType", paramInt2);
      localIntent.putExtra("from", "SmallScreenMultiVideoControlUI2");
      SmallScreenService localSmallScreenService = (SmallScreenService)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localSmallScreenService != null)
      {
        localIntent.setPackage(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        localSmallScreenService.sendBroadcast(localIntent);
        this.a.f(true);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SmallScreenMultiVideoControlUI", 2, "onGroupVideoChatClosed-->can not get the activity");
  }
  
  protected void b(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    if (this.a.d != 1) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.size() == 0)
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(false, false);
        this.a.q();
        this.a.a(false, false, false);
        return;
      }
      if ((!NetworkUtil.h((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().a() == -1) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().as)) {
        break;
      }
    } while (this.a.e >= 4);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_a_of_type_Jol);
    this.a.jdField_a_of_type_Jol.a = "onMemberPPTInOrOut";
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_Jol, 1000L);
    return;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
    this.a.q();
    this.a.a(true, true, true);
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.a.d != 1) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().ae = true;
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    int i;
    if (paramBoolean1) {
      i = 7;
    }
    for (int j = 78;; j = 79)
    {
      this.a.a(paramLong2, i, false, j);
      return;
      i = 8;
    }
  }
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    super.b(paramLong, paramBoolean);
    if ((paramLong == 0L) || (paramLong == this.a.jdField_a_of_type_Long)) {
      return;
    }
    Object localObject2;
    if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramLong), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long), this.a.d);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() != 0) {}
      }
      else
      {
        localObject1 = String.valueOf(paramLong);
      }
      float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559833);
      localObject2 = new StringBuilder();
      EllipsisUtil.b((StringBuilder)localObject2, (String)localObject1, this.a.jdField_b_of_type_AndroidWidgetTextView.getPaint(), f);
      if (!paramBoolean) {
        break label199;
      }
    }
    label199:
    for (Object localObject1 = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429162);; localObject1 = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429163))
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(70, ((StringBuilder)localObject2).toString(), 5000L, 0);
      this.a.e(paramBoolean);
      return;
    }
  }
  
  protected void c() {}
  
  protected void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onDestroyUI");
    }
    super.c(paramLong);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jof(this, paramLong), 1500L);
  }
  
  @SuppressLint({"NewApi"})
  protected void c(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onFirstFrameDataComeIn");
    }
    paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, paramInt);
    if ((paramInt != -1) && (((VideoViewInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(paramInt)).jdField_a_of_type_Boolean)) {}
    this.a.b("onFirstFrameDataComeIn");
  }
  
  protected void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.a.d != 1) {}
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().ae = false;
    } while (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean);
  }
  
  protected void c(long paramLong, boolean paramBoolean)
  {
    super.c(paramLong, paramBoolean);
    if (paramLong == this.a.jdField_a_of_type_Long) {
      return;
    }
    Object localObject2;
    if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramLong), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long), this.a.d);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() != 0) {}
      }
      else
      {
        localObject1 = String.valueOf(paramLong);
      }
      float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559833);
      localObject2 = new StringBuilder();
      EllipsisUtil.b((StringBuilder)localObject2, (String)localObject1, this.a.jdField_b_of_type_AndroidWidgetTextView.getPaint(), f);
      if (!paramBoolean) {
        break label193;
      }
    }
    label193:
    for (Object localObject1 = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429160);; localObject1 = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429161))
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(70, ((StringBuilder)localObject2).toString(), 5000L, 0);
      this.a.e(paramBoolean);
      return;
    }
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onUpdatePstnInfo --> Start");
    }
    SmallScreenService localSmallScreenService = (SmallScreenService)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localSmallScreenService != null) {
      localSmallScreenService.b.post(new jog(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("SmallScreenMultiVideoControlUI", 2, "onUpdatePstnInfo-->Can not get AVActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     joe
 * JD-Core Version:    0.7.0.1
 */