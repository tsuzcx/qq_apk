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
  TextView a;
  TextView b;
  RecordMicView c;
  LinearLayout d;
  TextView e;
  ImageView f;
  VoiceRedPacketHelperImpl g;
  public long h = 0L;
  private VolumeIndicateSquareView i;
  private VolumeIndicateSquareView j;
  private boolean k = false;
  private Handler l;
  private int m;
  private Bundle n;
  private String o;
  
  private void b(int paramInt)
  {
    paramInt /= 1180;
    this.i.a(paramInt);
    this.j.a(paramInt);
  }
  
  private void b(String paramString)
  {
    Object localObject = new StringBuilder(50);
    ((StringBuilder)localObject).append("msgType=13");
    ((StringBuilder)localObject).append("&isOffline=");
    ((StringBuilder)localObject).append(this.k);
    long l1 = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByVoice", ((StringBuilder)localObject).toString(), 0, null, SystemClock.uptimeMillis());
    IPasswdRedBagService localIPasswdRedBagService = (IPasswdRedBagService)getQBaseActivity().getAppRuntime().getRuntimeService(IPasswdRedBagService.class, "all");
    PasswdRedBagInfo localPasswdRedBagInfo = localIPasswdRedBagService.getPasswdRedBagInfoById(this.J.mQQWalletRedPacketMsg.redPacketId);
    localIPasswdRedBagService.setPasswdRedBagOpen(this.J.mQQWalletRedPacketMsg.redPacketId, this.J.frienduin, this.J.istroop);
    localObject = (IQWalletConfigService)getQBaseActivity().getAppRuntime().getRuntimeService(IQWalletConfigService.class, "");
    int i1;
    if (localObject != null) {
      i1 = ((IQWalletConfigService)localObject).getInt("voice_pwd", 1, new String[] { "scoreSwitch" });
    } else {
      i1 = 1;
    }
    BaseSessionInfo localBaseSessionInfo = this.I;
    if (i1 == 1) {
      localObject = paramString;
    } else {
      localObject = "";
    }
    localIPasswdRedBagService.openPasswdBagByTenpay(localBaseSessionInfo, localPasswdRedBagInfo, l1, 65536, (String)localObject, this.J.mQQWalletRedPacketMsg.elem.v, this.J.fromHBList, null);
    QWalletTools.a(getQBaseActivity().getAppRuntime(), this.J);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("click open passwdredbag, isPasswdRedBagOpen=");
      ((StringBuilder)localObject).append(localPasswdRedBagInfo.f);
      ((StringBuilder)localObject).append(",isPasswdRedBagFinish=");
      ((StringBuilder)localObject).append(localPasswdRedBagInfo.g);
      ((StringBuilder)localObject).append(",isPasswdRedBagOverDue=");
      ((StringBuilder)localObject).append(localPasswdRedBagInfo.a());
      ((StringBuilder)localObject).append("|scoreSwitch:");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("|scoreId");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PasswdRedBagSgervice", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void i()
  {
    AppRuntime localAppRuntime;
    if (!p()) {
      localAppRuntime = getQBaseActivity().getAppRuntime();
    } else {
      localAppRuntime = null;
    }
    if (localAppRuntime != null) {
      ThreadManager.post(new RedPacketVoiceFragment.2(this, new WeakReference(localAppRuntime)), 5, null, true);
    }
  }
  
  private boolean j()
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
  
  private void l()
  {
    this.i.a();
    this.j.a();
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
    ((ViewStub)paramView.findViewById(R.id.cp)).inflate();
    this.a = ((TextView)paramView.findViewById(R.id.bm));
    this.b = ((TextView)paramView.findViewById(R.id.cB));
    this.c = ((RecordMicView)paramView.findViewById(R.id.bS));
    this.f = ((ImageView)paramView.findViewById(R.id.db));
    a(this.f);
    this.d = ((LinearLayout)paramView.findViewById(R.id.dc));
    this.i = ((VolumeIndicateSquareView)paramView.findViewById(R.id.ay));
    this.j = ((VolumeIndicateSquareView)paramView.findViewById(R.id.az));
    this.e = ((TextView)paramView.findViewById(R.id.S));
  }
  
  public void a(String paramString)
  {
    this.b.setText(paramString);
    this.d.setVisibility(8);
    l();
    this.g.cancelRecord();
    this.c.c();
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
    this.G.setBackgroundDrawable(getResources().getDrawable(R.drawable.l));
    Object localObject1 = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName(this.J.senderuin, true);
    localObject1 = QWalletTools.a(getQBaseActivity(), (String)localObject1, 135.0F, this.F.getPaint());
    Object localObject2 = this.F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(HardCodeUtil.a(R.string.cj));
    ((TextView)localObject2).setText(localStringBuilder.toString());
    localObject1 = this.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("“");
    ((StringBuilder)localObject2).append(this.J.mQQWalletRedPacketMsg.elem.c);
    ((StringBuilder)localObject2).append("”");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    this.b.setText(getResources().getString(R.string.q));
    this.c.setStatusListener(this);
    this.g = VoiceRedPacketHelperImpl.getInstance();
    this.g.setOnVoiceRedPacketListener(this);
    this.k = j();
    this.m = (this.J.mQQWalletRedPacketMsg.elem.t * 1000);
    this.c.setRecordTime(this.m);
    if (this.J.isSend())
    {
      this.e.setVisibility(0);
      this.n = ((Bundle)getArguments().getParcelable("detail_bundle"));
      this.e.setOnClickListener(new RedPacketVoiceFragment.1(this));
    }
    FontConvert.a().b();
    i();
    this.l = new Handler(ThreadManager.getSubThreadLooper());
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.show", 0, 0, "", "", "", "");
    return true;
  }
  
  public boolean c()
  {
    if (this.h == 0L) {
      this.h = SystemClock.uptimeMillis();
    } else if (SystemClock.uptimeMillis() - this.h < 75L) {
      return false;
    }
    this.h = SystemClock.uptimeMillis();
    return true;
  }
  
  public void d()
  {
    this.b.setText(getResources().getString(R.string.s));
    this.d.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketVoiceFragment", 2, "onBegin() is called");
    }
    if (AudioUtil.b(1)) {
      ((IPttUtils)QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(getQBaseActivity());
    }
    this.k = j();
    if (TextUtils.isEmpty(this.o)) {
      try
      {
        this.o = FontConvert.a().a(this.J.mQQWalletRedPacketMsg.elem.c);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    if ((this.g != null) && (this.J != null)) {
      this.g.startRecord(this.I, this.J, this.o, this.k);
    }
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.start", 0, 0, "", "", "", "");
  }
  
  public void e()
  {
    this.b.setText(getResources().getString(R.string.t));
    this.d.setVisibility(8);
    l();
    f();
    VoiceRedPacketHelperImpl localVoiceRedPacketHelperImpl = this.g;
    if (localVoiceRedPacketHelperImpl != null) {
      localVoiceRedPacketHelperImpl.stopRecord();
    }
  }
  
  public void f()
  {
    this.l.removeCallbacksAndMessages(null);
    this.l.postDelayed(new RedPacketVoiceFragment.6(this), 20000L);
  }
  
  public void g()
  {
    a(getResources().getString(R.string.q));
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.cancel", 0, 0, "", "", "", "");
  }
  
  public void h()
  {
    a(getResources().getString(R.string.r));
  }
  
  public int k()
  {
    return 30000;
  }
  
  public void m() {}
  
  public void n() {}
  
  public boolean onBackEvent()
  {
    if (this.L) {
      ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.keyback", 0, 0, "", "", "", "");
    } else {
      ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.back", 0, 0, "", "", "", "");
    }
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Handler localHandler = this.l;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    b(this.f);
  }
  
  public boolean p()
  {
    return super.p();
  }
  
  public void u()
  {
    super.u();
    VoiceRedPacketHelperImpl.getInstance().clearReportStatus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketVoiceFragment
 * JD-Core Version:    0.7.0.1
 */