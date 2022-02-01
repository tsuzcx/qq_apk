package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateSquareView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.RecordMicView;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.RecordMicView.StatusListener;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl.OnVoiceRedPacketListener;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class RedPacketVoiceFragment
  extends RedPacketPopFragment
  implements RecordMicView.StatusListener, VoiceRedPacketHelperImpl.OnVoiceRedPacketListener
{
  private int jdField_a_of_type_Int;
  public long a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private VolumeIndicateSquareView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  RecordMicView jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplRecordMicView;
  VoiceRedPacketHelperImpl jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private VolumeIndicateSquareView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  TextView c;
  
  public RedPacketVoiceFragment()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void b(int paramInt)
  {
    paramInt /= 1180;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt);
  }
  
  private void b(String paramString)
  {
    Object localObject = new StringBuilder(50);
    ((StringBuilder)localObject).append("msgType=13");
    ((StringBuilder)localObject).append("&isOffline=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByVoice", ((StringBuilder)localObject).toString(), 0, null, SystemClock.uptimeMillis());
    IPasswdRedBagService localIPasswdRedBagService = (IPasswdRedBagService)getQBaseActivity().getAppRuntime().getRuntimeService(IPasswdRedBagService.class, "all");
    PasswdRedBagInfo localPasswdRedBagInfo = localIPasswdRedBagService.getPasswdRedBagInfoById(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
    localIPasswdRedBagService.setPasswdRedBagOpen(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop);
    localObject = (IQWalletConfigService)getQBaseActivity().getAppRuntime().getRuntimeService(IQWalletConfigService.class, "");
    int i;
    if (localObject != null) {
      i = ((IQWalletConfigService)localObject).getInt("voice_pwd", 1, new String[] { "scoreSwitch" });
    } else {
      i = 1;
    }
    BaseSessionInfo localBaseSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
    if (i == 1) {
      localObject = paramString;
    } else {
      localObject = "";
    }
    localIPasswdRedBagService.openPasswdBagByTenpay(localBaseSessionInfo, localPasswdRedBagInfo, l, 65536, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.i, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.fromHBList, null);
    QWalletTools.a(getQBaseActivity().getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("click open passwdredbag, isPasswdRedBagOpen=");
      ((StringBuilder)localObject).append(localPasswdRedBagInfo.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(",isPasswdRedBagFinish=");
      ((StringBuilder)localObject).append(localPasswdRedBagInfo.b);
      ((StringBuilder)localObject).append(",isPasswdRedBagOverDue=");
      ((StringBuilder)localObject).append(localPasswdRedBagInfo.a());
      ((StringBuilder)localObject).append("|scoreSwitch:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("|scoreId");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PasswdRedBagSgervice", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean e()
  {
    Object localObject = (IQWalletConfigService)getQBaseActivity().getAppRuntime().getRuntimeService(IQWalletConfigService.class, "");
    boolean bool = true;
    if (((IQWalletConfigService)localObject).getInt("voice_pwd", 0, new String[] { "offline" }) != 1) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get isOffLine fromConfig:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("RedPacketVoiceFragment", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  private void f()
  {
    AppRuntime localAppRuntime;
    if (!d()) {
      localAppRuntime = getQBaseActivity().getAppRuntime();
    } else {
      localAppRuntime = null;
    }
    if (localAppRuntime != null) {
      ThreadManager.post(new RedPacketVoiceFragment.2(this, new WeakReference(localAppRuntime)), 5, null, true);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
  }
  
  public int a()
  {
    return 30000;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(R.string.s));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketVoiceFragment", 2, "onBegin() is called");
    }
    if (AudioUtil.a(1)) {
      ((IPttUtils)QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(getQBaseActivity());
    }
    this.jdField_a_of_type_Boolean = e();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      try
      {
        this.jdField_a_of_type_JavaLangString = FontConvert.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg != null)) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.startRecord(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.start", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt)
  {
    getQBaseActivity().runOnUiThread(new RedPacketVoiceFragment.5(this, paramInt));
  }
  
  public void a(int paramInt, String paramString)
  {
    getQBaseActivity().runOnUiThread(new RedPacketVoiceFragment.4(this, paramInt, paramString));
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    ((ViewStub)paramView.findViewById(R.id.cb)).inflate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(R.id.bd));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(R.id.cn));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplRecordMicView = ((RecordMicView)paramView.findViewById(R.id.bH));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(R.id.cK));
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(R.id.cL));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)paramView.findViewById(R.id.ar));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)paramView.findViewById(R.id.as));
    this.c = ((TextView)paramView.findViewById(R.id.N));
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    g();
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.cancelRecord();
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplRecordMicView.c();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    getQBaseActivity().runOnUiThread(new RedPacketVoiceFragment.3(this, paramBoolean, paramString));
  }
  
  protected boolean a()
  {
    if (!super.a()) {
      return false;
    }
    this.jdField_e_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(R.drawable.l));
    Object localObject1 = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, true);
    localObject1 = QWalletTools.a(getQBaseActivity(), (String)localObject1, 135.0F, this.d.getPaint());
    Object localObject2 = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(HardCodeUtil.a(R.string.cg));
    ((TextView)localObject2).setText(localStringBuilder.toString());
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("“");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("”");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(R.string.q));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplRecordMicView.setStatusListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl = VoiceRedPacketHelperImpl.getInstance();
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.setOnVoiceRedPacketListener(this);
    this.jdField_a_of_type_Boolean = e();
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.g * 1000);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplRecordMicView.setRecordTime(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSend())
    {
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidOsBundle = ((Bundle)getArguments().getParcelable("detail_bundle"));
      this.c.setOnClickListener(new RedPacketVoiceFragment.1(this));
    }
    FontConvert.a().a();
    f();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.show", 0, 0, "", "", "", "");
    return true;
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(R.string.t));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    g();
    c();
    VoiceRedPacketHelperImpl localVoiceRedPacketHelperImpl = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl;
    if (localVoiceRedPacketHelperImpl != null) {
      localVoiceRedPacketHelperImpl.stopRecord();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RedPacketVoiceFragment.6(this), 20000L);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    } else if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < 75L) {
      return false;
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    return true;
  }
  
  public void d()
  {
    a(getResources().getString(R.string.q));
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.cancel", 0, 0, "", "", "", "");
  }
  
  public boolean d()
  {
    return super.d();
  }
  
  public void e()
  {
    a(getResources().getString(R.string.r));
  }
  
  public void i() {}
  
  public void j() {}
  
  public void o()
  {
    super.o();
    VoiceRedPacketHelperImpl.getInstance().clearReportStatus();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_e_of_type_Boolean) {
      ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.keyback", 0, 0, "", "", "", "");
    } else {
      ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.back", 0, 0, "", "", "", "");
    }
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    b(this.jdField_a_of_type_AndroidWidgetImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketVoiceFragment
 * JD-Core Version:    0.7.0.1
 */