package com.tencent.mobileqq.qwallet.hb.grap.impl;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSHelper.Config;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSHelper.KListener;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongMicView;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongMicView.StatusListener;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongProsBar;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongView;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongVolumeView;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl.OnVoiceRedPacketListener;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class RedPacketKSongFragment
  extends RedPacketPopFragment
  implements KSongMicView.StatusListener, VoiceRedPacketHelperImpl.OnVoiceRedPacketListener
{
  public static final String a = HardCodeUtil.a(R.string.cc);
  public static final String b = HardCodeUtil.a(R.string.cs);
  public static final String[] f = { HardCodeUtil.a(R.string.co), HardCodeUtil.a(R.string.ci), HardCodeUtil.a(R.string.cx) };
  private Handler M;
  private RedPacketKSongFragment.SongInfo N;
  private View.OnClickListener O = new RedPacketKSongFragment.1(this);
  private View.OnClickListener P = new RedPacketKSongFragment.2(this);
  private boolean Q = false;
  private BroadcastReceiver R = new RedPacketKSongFragment.8(this);
  public String c = "https://i.gtimg.cn/channel/imglib/201806/upload_8f5d7c5994fc2ceb1e92f11436db039d.zip";
  public String d = "https://imgcache.qq.com/channel/static/socialpay/music/song_54.zip";
  public String e = "https://imgcache.qq.com/channel/static/socialpay/music/";
  TextView g;
  KSongMicView h;
  AnimationView i;
  TextView j;
  View k;
  ImageView l;
  TextView m;
  KSongView n;
  KSongProsBar o;
  KSongVolumeView p;
  View q;
  ImageView r;
  VoiceRedPacketHelperImpl s;
  MediaPlayer t;
  public boolean u = false;
  public boolean v = false;
  public boolean w = true;
  public boolean x = false;
  public long y = 0L;
  
  private void b(int paramInt)
  {
    paramInt /= 1180;
    this.p.a(paramInt);
  }
  
  private void c(String paramString)
  {
    Object localObject = new StringBuilder(50);
    ((StringBuilder)localObject).append("msgType=18");
    ((StringBuilder)localObject).append("&isOffline=");
    ((StringBuilder)localObject).append(false);
    long l1 = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByKSong", ((StringBuilder)localObject).toString(), 0, null, SystemClock.uptimeMillis());
    IPasswdRedBagService localIPasswdRedBagService = (IPasswdRedBagService)getQBaseActivity().getAppRuntime().getRuntimeService(IPasswdRedBagService.class, "");
    PasswdRedBagInfo localPasswdRedBagInfo = localIPasswdRedBagService.getPasswdRedBagInfoById(this.J.mQQWalletRedPacketMsg.redPacketId);
    localIPasswdRedBagService.setPasswdRedBagOpen(this.J.mQQWalletRedPacketMsg.redPacketId, this.J.frienduin, this.J.istroop);
    localObject = (IQWalletConfigService)getQBaseActivity().getAppRuntime().getRuntimeService(IQWalletConfigService.class, "");
    int i1;
    if (localObject != null) {
      i1 = ((IQWalletConfigService)localObject).getInt("voice_pwd", 1, new String[] { "scoreSwitch" });
    } else {
      i1 = 1;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("feedsid", t());
    VoiceRedPacketHelperImpl.saveKSongFeedsId(t(), this.J);
    QWalletTools.a(getQBaseActivity().getAppRuntime(), this.J);
    BaseSessionInfo localBaseSessionInfo = this.I;
    if (i1 == 1) {
      localObject = paramString;
    } else {
      localObject = "";
    }
    localIPasswdRedBagService.openPasswdBagByTenpay(localBaseSessionInfo, localPasswdRedBagInfo, l1, 131072, (String)localObject, this.J.mQQWalletRedPacketMsg.elem.v, this.J.fromHBList, localBundle);
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
  
  private void v()
  {
    this.u = false;
    w();
    h();
  }
  
  private void w()
  {
    Object localObject = this.i;
    int i1 = 0;
    ((AnimationView)localObject).setVisibility(0);
    this.j.setVisibility(0);
    int i2 = new Random().nextInt(3);
    this.j.setText(f[(i2 + 0)]);
    localObject = ((IQWalletConfigService)getQBaseActivity().getAppRuntime().getRuntimeService(IQWalletConfigService.class, "")).getString("redPackPanel", "", new String[] { "panelRedPkgList" });
    try
    {
      localObject = new JSONArray((String)localObject);
      while (i1 < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i1);
        if ((localJSONObject != null) && (localJSONObject.optInt("type") == 7))
        {
          this.e = localJSONObject.optJSONObject("params").optString("prefix", "https://imgcache.qq.com/channel/static/socialpay/music/");
          break;
        }
        i1 += 1;
      }
    }
    catch (Throwable localThrowable)
    {
      label156:
      break label156;
    }
    ((IPreloadService)getQBaseActivity().getAppRuntime().getRuntimeService(IPreloadService.class, "")).getResPath(this.c, new RedPacketKSongFragment.9(this));
  }
  
  private void x()
  {
    this.u = true;
    this.i.stop();
    this.j.setVisibility(8);
    this.i.setVisibility(8);
  }
  
  private void y()
  {
    Handler localHandler = this.M;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(int paramInt)
  {
    getQBaseActivity().runOnUiThread(new RedPacketKSongFragment.14(this, paramInt));
  }
  
  public void a(int paramInt, String paramString)
  {
    getQBaseActivity().runOnUiThread(new RedPacketKSongFragment.13(this, paramInt, paramString));
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    ((ViewStub)paramView.findViewById(R.id.co)).inflate();
    this.g = ((TextView)paramView.findViewById(R.id.cB));
    this.h = ((KSongMicView)paramView.findViewById(R.id.bS));
    this.i = ((AnimationView)paramView.findViewById(R.id.aL));
    this.j = ((TextView)paramView.findViewById(R.id.aV));
    this.k = paramView.findViewById(R.id.aW);
    this.l = ((ImageView)paramView.findViewById(R.id.bh));
    this.m = ((TextView)paramView.findViewById(R.id.bi));
    this.n = ((KSongView)paramView.findViewById(R.id.aN));
    this.o = ((KSongProsBar)paramView.findViewById(R.id.aM));
    this.p = ((KSongVolumeView)paramView.findViewById(R.id.ax));
    this.q = paramView.findViewById(R.id.bV);
    this.r = ((ImageView)paramView.findViewById(R.id.aK));
    a(this.r);
  }
  
  public void a(String paramString)
  {
    this.n.setVisibility(8);
    this.g.setVisibility(0);
    this.g.setText(paramString);
  }
  
  public void a(String paramString, KSHelper.KListener paramKListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playSong:");
      localStringBuilder.append(paramString);
      QLog.d("RedPacketKSongFragment", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      if (this.t != null) {
        this.t.release();
      }
      this.t = new MediaPlayer();
      this.t.setAudioStreamType(3);
      this.t.setDataSource(paramString);
      this.t.prepareAsync();
      this.Q = false;
      this.t.setOnPreparedListener(new RedPacketKSongFragment.5(this, paramBoolean));
      this.t.setOnCompletionListener(new RedPacketKSongFragment.6(this));
      this.n.setKListener(new RedPacketKSongFragment.7(this, paramKListener));
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    getQBaseActivity().runOnUiThread(new RedPacketKSongFragment.12(this, paramBoolean, paramString));
  }
  
  protected boolean a()
  {
    if (!super.a()) {
      return false;
    }
    this.G.setBackgroundDrawable(getResources().getDrawable(R.drawable.S));
    this.q.setOnClickListener(this.O);
    this.q.setOnTouchListener(QWalletTools.a(0.7F));
    this.l.setOnClickListener(this.P);
    Object localObject = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName(this.J.senderuin, true);
    localObject = QWalletTools.a(getQBaseActivity(), (String)localObject, 135.0F, this.F.getPaint());
    TextView localTextView = this.F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("的K歌红包");
    localTextView.setText(localStringBuilder.toString());
    this.h.setStatusListener(this);
    this.s = VoiceRedPacketHelperImpl.getInstance();
    this.s.setOnVoiceRedPacketListener(this);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
    ((IntentFilter)localObject).addAction("android.intent.action.PHONE_STATE");
    getQBaseActivity().registerReceiver(this.R, (IntentFilter)localObject);
    this.M = new Handler(ThreadManager.getSubThreadLooper());
    this.l.setContentDescription(a);
    AccessibilityUtil.b(this.n, false);
    v();
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.show", 0, 0, "", "", "", "");
    return true;
  }
  
  public void b(String paramString)
  {
    this.p.setVisibility(8);
    d();
    this.n.a();
    this.n.setVisibility(8);
    MediaPlayer localMediaPlayer = this.t;
    if (localMediaPlayer != null) {
      localMediaPlayer.release();
    }
    a(paramString);
    this.s.cancelRecord();
    this.h.b();
    this.x = false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onPlayBtnClick:");
      localStringBuilder1.append(this.v);
      localStringBuilder1.append("|");
      localStringBuilder1.append(this.w);
      QLog.d("RedPacketKSongFragment", 2, localStringBuilder1.toString());
    }
    try
    {
      if (!this.v)
      {
        this.v = true;
        this.l.setImageDrawable(getResources().getDrawable(R.drawable.ae));
        this.m.setText(b);
        f();
        this.n.setVisibility(0);
        this.g.setVisibility(8);
        return;
      }
      if (this.Q)
      {
        if (this.w)
        {
          this.n.b();
          this.t.pause();
          this.w = false;
          this.l.setImageDrawable(getResources().getDrawable(R.drawable.ad));
          this.m.setText(a);
          return;
        }
        this.n.a(true);
        this.t.start();
        this.w = true;
        this.l.setImageDrawable(getResources().getDrawable(R.drawable.ae));
        this.m.setText(b);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("onPlayBtnClick throwable:");
        localStringBuilder2.append(localThrowable.getMessage());
        QLog.d("RedPacketKSongFragment", 2, localStringBuilder2.toString());
      }
    }
  }
  
  public void d()
  {
    this.l.setImageDrawable(getResources().getDrawable(R.drawable.ad));
    this.l.setVisibility(0);
    this.m.setVisibility(0);
    this.m.setText(a);
    this.v = false;
    this.w = true;
  }
  
  public void e()
  {
    a(this.N.b, new RedPacketKSongFragment.3(this), false);
  }
  
  public void f()
  {
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.play", 0, 0, "", "", "", "");
    this.l.setImageDrawable(getResources().getDrawable(R.drawable.ae));
    a(this.N.a, new RedPacketKSongFragment.4(this), true);
  }
  
  public void g()
  {
    this.g.setVisibility(0);
    this.g.setText(HardCodeUtil.a(R.string.cC));
    this.q.setVisibility(0);
  }
  
  public void h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e);
    localStringBuilder.append("song_");
    localStringBuilder.append(this.J.mQQWalletRedPacketMsg.elem.B);
    localStringBuilder.append(".zip");
    this.d = localStringBuilder.toString();
    ((IPreloadService)getQBaseActivity().getAppRuntime().getRuntimeService(IPreloadService.class, "")).getResPath(this.d, new RedPacketKSongFragment.10(this));
  }
  
  public void i()
  {
    getQBaseActivity().runOnUiThread(new RedPacketKSongFragment.11(this));
  }
  
  public void j()
  {
    this.k.setVisibility(0);
    this.h.setVisibility(0);
    this.l.setVisibility(0);
    this.m.setVisibility(0);
  }
  
  public int k()
  {
    return 30000;
  }
  
  public boolean l()
  {
    if (this.y == 0L) {
      this.y = SystemClock.uptimeMillis();
    } else if (SystemClock.uptimeMillis() - this.y < 75L) {
      return false;
    }
    this.y = SystemClock.uptimeMillis();
    return true;
  }
  
  public void m()
  {
    e();
  }
  
  public void n()
  {
    this.x = false;
    o();
  }
  
  public void o()
  {
    this.M.removeCallbacksAndMessages(null);
    this.M.postDelayed(new RedPacketKSongFragment.15(this), 20000L);
  }
  
  public boolean onBackEvent()
  {
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.close", 0, 0, "", "", "", "");
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQAudioUtils.a(getQBaseActivity(), false);
    Object localObject = this.s;
    if (localObject != null) {
      ((VoiceRedPacketHelperImpl)localObject).cancelRecord();
    }
    x();
    localObject = this.t;
    if (localObject != null) {
      ((MediaPlayer)localObject).release();
    }
    this.n.c();
    localObject = this.i.getAnimationFromInfo();
    if (localObject != null) {
      ((AnimationView.AnimationInfo)localObject).destoryBitmaps();
    }
    try
    {
      getQBaseActivity().unregisterReceiver(this.R);
      label77:
      y();
      b(this.r);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label77;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause() is called :");
      localStringBuilder.append(this.x);
      QLog.d("RedPacketKSongFragment", 2, localStringBuilder.toString());
    }
    if (this.x) {
      b(HardCodeUtil.a(R.string.cl));
    }
  }
  
  public boolean p()
  {
    return super.p();
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "onBegin() is called");
    }
  }
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "onEnd() is called");
    }
    if (AudioUtil.b(1)) {
      ((IPttUtils)QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(getQBaseActivity());
    }
    this.p.setVisibility(0);
    this.g.setVisibility(8);
    this.n.setVisibility(0);
    this.l.setVisibility(8);
    this.m.setVisibility(8);
    this.n.a();
    MediaPlayer localMediaPlayer = this.t;
    if (localMediaPlayer != null) {
      localMediaPlayer.release();
    }
    if ((this.s != null) && (this.J != null))
    {
      this.s.setAccompanyPath(this.N.b);
      this.s.startRecord(this.I, this.J, "", false);
      this.x = true;
    }
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.start", 0, 0, "", "", "", "");
  }
  
  public void s() {}
  
  public String t()
  {
    try
    {
      String str = this.n.getConfig().c;
      return str;
    }
    catch (Throwable localThrowable)
    {
      label13:
      break label13;
    }
    return "";
  }
  
  public void u()
  {
    super.u();
    VoiceRedPacketHelperImpl.getInstance().clearReportStatus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKSongFragment
 * JD-Core Version:    0.7.0.1
 */