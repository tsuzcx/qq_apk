import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.av.ui.PstnCallbackWaitingUi;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoNetStateBar;
import com.tencent.av.ui.VoiceChangeDataReport;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class jwj
  extends GAudioUIObserver
{
  public jwj(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onServiceConnected");
    }
    super.a();
    if (this.a.jdField_b_of_type_Long != 0L)
    {
      int i = this.a.jdField_c_of_type_Int;
      Object localObject = String.valueOf(this.a.jdField_b_of_type_Long);
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
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onInviteUserNotice --> Count = " + paramInt + " ,firstName = " + paramString);
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (QAVHrMeeting.b(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.a.jdField_b_of_type_Long)))) {
        paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(this.a.jdField_b_of_type_Long), this.a.d);
      }
      this.a.jdField_a_of_type_Jxd.a(paramInt, paramString);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_Jxd, 500L);
    }
  }
  
  protected void a(int paramInt, ArrayList paramArrayList)
  {
    super.a(paramInt, paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "Pstn_Invite_Fail onUpdatePstnInfo --> Start ");
    }
    Object localObject1;
    Object localObject2;
    if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      if (paramArrayList == null) {
        break label459;
      }
      if (((paramArrayList == null) || (paramArrayList.size() == 0)) && (QLog.isColorLevel())) {
        QLog.e(this.a.jdField_c_of_type_JavaLangString, 2, "onPstnErrorMsg --> List is null Or Empty. Type = " + paramInt);
      }
      localObject1 = new String();
      localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = ((AVPhoneUserInfo)((Iterator)localObject2).next()).telInfo.mobile;
        str = this.a.jdField_a_of_type_ComTencentAvVideoController.a(str);
        localObject1 = (String)localObject1 + str + " ";
      }
      switch (paramInt)
      {
      default: 
        paramArrayList = null;
      }
    }
    for (;;)
    {
      localObject1 = this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager;
      localObject2 = this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager;
      ((TipsManager)localObject1).a(82, paramArrayList, 5000L, 0);
      label459:
      do
      {
        return;
        if (paramArrayList.size() == 1)
        {
          paramArrayList = (String)localObject1 + "的电话号码被呼叫限制";
          break;
        }
        float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559833);
        localObject1 = UITools.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject1, this.a.i, f);
        paramArrayList = (String)localObject1 + "等" + paramArrayList.size() + "人电话号码被呼叫限制";
        break;
        if (paramArrayList.size() == 1)
        {
          paramArrayList = "被叫次数已达上限，" + (String)localObject1 + "无法呼叫";
          break;
        }
        f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559833);
        localObject1 = UITools.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject1, this.a.i, f);
        paramArrayList = "被叫次数已达上限，" + (String)localObject1 + "等" + paramArrayList.size() + "人无法呼叫";
        break;
        switch (paramInt)
        {
        }
      } while (!QLog.isColorLevel());
      QLog.e(this.a.jdField_c_of_type_JavaLangString, 2, "onPstnErrorMsg --> type is Wrong. Type = " + paramInt);
      return;
      paramArrayList = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429141);
      continue;
      paramArrayList = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429142);
      continue;
      paramArrayList = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429143);
      continue;
      paramArrayList = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429144);
      continue;
      paramArrayList = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429139);
      continue;
      paramArrayList = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429140);
      continue;
      paramArrayList = "剩余时长不足，部分用户呼叫失败。";
      continue;
      paramArrayList = "呼叫手机失败，请先购买时长。";
      continue;
      paramArrayList = "呼叫手机失败，请稍候再试。";
    }
  }
  
  protected void a(long paramLong)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onCreateRoomSuc-->GroupID = " + paramLong);
    }
    if (this.a.jdField_f_of_type_Boolean)
    {
      MultiVideoRichActionReportCollection.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      if (!this.a.jdField_f_of_type_Boolean) {
        break label272;
      }
    }
    label272:
    for (i = 4;; i = 3)
    {
      VoiceChangeDataReport.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      this.a.J();
      this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
      this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
      this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a();
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().an = true;
      if ((this.a.jdField_f_of_type_Boolean) && (this.a.jdField_f_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jwl(this), 500L);
      }
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
        this.a.L();
      }
      this.a.a(true, paramLong);
      return;
      i = 1;
      break;
    }
  }
  
  protected void a(String paramString, String[] paramArrayOfString)
  {
    super.a(paramString, paramArrayOfString);
    long l = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.a.jdField_b_of_type_Long));
    if (QLog.isColorLevel())
    {
      String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramString, String.valueOf(this.a.jdField_b_of_type_Long), this.a.d);
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onOtherMemberInvited --> l= " + String.valueOf(l) + "inviterName=" + str);
    }
    if (QAVHrMeeting.b(l))
    {
      this.a.b(paramString, paramArrayOfString);
      return;
    }
    this.a.a(paramString, paramArrayOfString);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean) {
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().x == 1))
      {
        if (this.a.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi != null) {
          this.a.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi.d();
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
          this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setMultiPstnCallback(true);
        }
        this.a.a(0L, 11, true, 0);
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b(8);
        }
      }
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi != null) {
        this.a.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi.e();
      }
    } while ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().x != 1));
    if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setMultiPstnCallback(true);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b(8);
    }
    this.a.a(0L, 12, true, 0);
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    this.a.a(paramInt);
  }
  
  protected void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onEnterRoomSuc-->GroupID=" + paramLong);
    }
    super.b(paramLong);
    if (this.a.jdField_f_of_type_Boolean)
    {
      i = 4;
      VoiceChangeDataReport.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      if (!this.a.jdField_f_of_type_Boolean) {
        break label299;
      }
    }
    label299:
    for (int i = 2;; i = 1)
    {
      MultiVideoRichActionReportCollection.a(i, this.a.jdField_a_of_type_ComTencentAvVideoController.d() + "");
      this.a.J();
      this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
      this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
      this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a();
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jwp(this.a), 500L);
      if ((this.a.jdField_f_of_type_Boolean) && (this.a.jdField_f_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jwm(this), 600L);
      }
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
        this.a.L();
      }
      this.a.U();
      this.a.a(false, paramLong);
      return;
      i = 3;
      break;
    }
  }
  
  protected void b(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onInviteSomeoneEnter-->firstUin = " + paramLong + " , length = " + paramInt);
    }
    super.b(paramLong, paramInt);
    this.a.jdField_f_of_type_Int = paramInt;
    this.a.c(paramLong, 68, true, -1);
  }
  
  protected void c()
  {
    super.c();
    if (this.a.d != 2) {}
    while (this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365391)) {
      return;
    }
    this.a.t_();
  }
  
  protected void c(int paramInt)
  {
    super.c(paramInt);
    if (paramInt > 0)
    {
      this.a.f(paramInt);
      return;
    }
    this.a.A();
  }
  
  protected void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "onUpdatePstnInfo --> Start");
    }
    AVActivity localAVActivity = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAVActivity != null) {
      localAVActivity.runOnUiThread(new jwk(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(this.a.jdField_c_of_type_JavaLangString, 2, "onUpdatePstnInfo-->Can not get AVActivity");
  }
  
  protected void e()
  {
    super.e();
    this.a.A();
  }
  
  protected void f()
  {
    super.f();
    this.a.W();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jwj
 * JD-Core Version:    0.7.0.1
 */