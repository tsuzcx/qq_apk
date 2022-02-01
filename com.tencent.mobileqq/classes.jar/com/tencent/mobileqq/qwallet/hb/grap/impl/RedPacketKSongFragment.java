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
  public static final String a;
  public static final String[] a;
  public static final String b;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new RedPacketKSongFragment.8(this);
  MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new RedPacketKSongFragment.1(this);
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private RedPacketKSongFragment.SongInfo jdField_a_of_type_ComTencentMobileqqQwalletHbGrapImplRedPacketKSongFragment$SongInfo;
  KSongMicView jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongMicView;
  KSongProsBar jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongProsBar;
  KSongView jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView;
  KSongVolumeView jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongVolumeView;
  VoiceRedPacketHelperImpl jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl;
  AnimationView jdField_a_of_type_ComTencentMobileqqWidgetAnimationView;
  public boolean a;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new RedPacketKSongFragment.2(this);
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  TextView c;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  public String e;
  private boolean f = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(R.string.bZ);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(R.string.cp);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { HardCodeUtil.a(R.string.cl), HardCodeUtil.a(R.string.cf), HardCodeUtil.a(R.string.cu) };
  }
  
  public RedPacketKSongFragment()
  {
    this.jdField_c_of_type_JavaLangString = "https://i.gtimg.cn/channel/imglib/201806/upload_8f5d7c5994fc2ceb1e92f11436db039d.zip";
    this.jdField_d_of_type_JavaLangString = "https://imgcache.qq.com/channel/static/socialpay/music/song_54.zip";
    this.jdField_e_of_type_JavaLangString = "https://imgcache.qq.com/channel/static/socialpay/music/";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void b(int paramInt)
  {
    paramInt /= 1180;
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongVolumeView.a(paramInt);
  }
  
  private void c(String paramString)
  {
    Object localObject = new StringBuilder(50);
    ((StringBuilder)localObject).append("msgType=18");
    ((StringBuilder)localObject).append("&isOffline=");
    ((StringBuilder)localObject).append(false);
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByKSong", ((StringBuilder)localObject).toString(), 0, null, SystemClock.uptimeMillis());
    IPasswdRedBagService localIPasswdRedBagService = (IPasswdRedBagService)getQBaseActivity().getAppRuntime().getRuntimeService(IPasswdRedBagService.class, "");
    PasswdRedBagInfo localPasswdRedBagInfo = localIPasswdRedBagService.getPasswdRedBagInfoById(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
    localIPasswdRedBagService.setPasswdRedBagOpen(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop);
    localObject = (IQWalletConfigService)getQBaseActivity().getAppRuntime().getRuntimeService(IQWalletConfigService.class, "");
    int i;
    if (localObject != null) {
      i = ((IQWalletConfigService)localObject).getInt("voice_pwd", 1, new String[] { "scoreSwitch" });
    } else {
      i = 1;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("feedsid", a());
    VoiceRedPacketHelperImpl.saveKSongFeedsId(a(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    QWalletTools.a(getQBaseActivity().getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    BaseSessionInfo localBaseSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
    if (i == 1) {
      localObject = paramString;
    } else {
      localObject = "";
    }
    localIPasswdRedBagService.openPasswdBagByTenpay(localBaseSessionInfo, localPasswdRedBagInfo, l, 131072, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.i, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.fromHBList, localBundle);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("click open passwdredbag, isPasswdRedBagOpen=");
      ((StringBuilder)localObject).append(localPasswdRedBagInfo.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(",isPasswdRedBagFinish=");
      ((StringBuilder)localObject).append(localPasswdRedBagInfo.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(",isPasswdRedBagOverDue=");
      ((StringBuilder)localObject).append(localPasswdRedBagInfo.a());
      ((StringBuilder)localObject).append("|scoreSwitch:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("|scoreId");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PasswdRedBagSgervice", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_Boolean = false;
    q();
    f();
  }
  
  private void q()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView;
    int i = 0;
    ((AnimationView)localObject).setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    int j = new Random().nextInt(3);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(jdField_a_of_type_ArrayOfJavaLangString[(j + 0)]);
    localObject = ((IQWalletConfigService)getQBaseActivity().getAppRuntime().getRuntimeService(IQWalletConfigService.class, "")).getString("redPackPanel", "", new String[] { "panelRedPkgList" });
    try
    {
      localObject = new JSONArray((String)localObject);
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
        if ((localJSONObject != null) && (localJSONObject.optInt("type") == 7))
        {
          this.jdField_e_of_type_JavaLangString = localJSONObject.optJSONObject("params").optString("prefix", "https://imgcache.qq.com/channel/static/socialpay/music/");
          break;
        }
        i += 1;
      }
    }
    catch (Throwable localThrowable)
    {
      label156:
      break label156;
    }
    ((IPreloadService)getQBaseActivity().getAppRuntime().getRuntimeService(IPreloadService.class, "")).getResPath(this.jdField_c_of_type_JavaLangString, new RedPacketKSongFragment.9(this));
  }
  
  private void r()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.stop();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setVisibility(8);
  }
  
  private void s()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public int a()
  {
    return 30000;
  }
  
  public String a()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView.a().jdField_b_of_type_JavaLangString;
      return str;
    }
    catch (Throwable localThrowable)
    {
      label13:
      break label13;
    }
    return "";
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onPlayBtnClick:");
      localStringBuilder1.append(this.jdField_b_of_type_Boolean);
      localStringBuilder1.append("|");
      localStringBuilder1.append(this.jdField_c_of_type_Boolean);
      QLog.d("RedPacketKSongFragment", 2, localStringBuilder1.toString());
    }
    try
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(R.drawable.ad));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(jdField_b_of_type_JavaLangString);
        d();
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      if (this.f)
      {
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView.b();
          this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(R.drawable.ac));
          this.jdField_c_of_type_AndroidWidgetTextView.setText(jdField_a_of_type_JavaLangString);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView.a(true);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(R.drawable.ad));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(jdField_b_of_type_JavaLangString);
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
    ((ViewStub)paramView.findViewById(R.id.ca)).inflate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(R.id.cn));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongMicView = ((KSongMicView)paramView.findViewById(R.id.bH));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView = ((AnimationView)paramView.findViewById(R.id.aD));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(R.id.aN));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(R.id.aO);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(R.id.aZ));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(R.id.ba));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView = ((KSongView)paramView.findViewById(R.id.aF));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongProsBar = ((KSongProsBar)paramView.findViewById(R.id.aE));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongVolumeView = ((KSongVolumeView)paramView.findViewById(R.id.aq));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(R.id.bJ);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(R.id.aC));
    a(this.jdField_b_of_type_AndroidWidgetImageView);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
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
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      this.f = false;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new RedPacketKSongFragment.5(this, paramBoolean));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new RedPacketKSongFragment.6(this));
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView.setKListener(new RedPacketKSongFragment.7(this, paramKListener));
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
    this.jdField_e_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(R.drawable.R));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(QWalletTools.a(0.7F));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    Object localObject = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getBuddyName(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, true);
    localObject = QWalletTools.a(getQBaseActivity(), (String)localObject, 135.0F, this.jdField_d_of_type_AndroidWidgetTextView.getPaint());
    TextView localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("的K歌红包");
    localTextView.setText(localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongMicView.setStatusListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl = VoiceRedPacketHelperImpl.getInstance();
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.setOnVoiceRedPacketListener(this);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
    ((IntentFilter)localObject).addAction("android.intent.action.PHONE_STATE");
    getQBaseActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(jdField_a_of_type_JavaLangString);
    AccessibilityUtil.b(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView, false);
    p();
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.show", 0, 0, "", "", "", "");
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(R.drawable.ac));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongVolumeView.setVisibility(8);
    b();
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView.a();
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView.setVisibility(8);
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null) {
      localMediaPlayer.release();
    }
    a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.cancelRecord();
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongMicView.b();
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void c()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapImplRedPacketKSongFragment$SongInfo.jdField_b_of_type_JavaLangString, new RedPacketKSongFragment.3(this), false);
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
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.play", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(R.drawable.ad));
    a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapImplRedPacketKSongFragment$SongInfo.jdField_a_of_type_JavaLangString, new RedPacketKSongFragment.4(this), true);
  }
  
  public boolean d()
  {
    return super.d();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(R.string.cz));
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("song_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.n);
    localStringBuilder.append(".zip");
    this.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
    ((IPreloadService)getQBaseActivity().getAppRuntime().getRuntimeService(IPreloadService.class, "")).getResPath(this.jdField_d_of_type_JavaLangString, new RedPacketKSongFragment.10(this));
  }
  
  public void g()
  {
    getQBaseActivity().runOnUiThread(new RedPacketKSongFragment.11(this));
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongMicView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void i()
  {
    c();
  }
  
  public void j()
  {
    this.jdField_d_of_type_Boolean = false;
    k();
  }
  
  public void k()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RedPacketKSongFragment.15(this), 20000L);
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "onBegin() is called");
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "onEnd() is called");
    }
    if (AudioUtil.a(1)) {
      ((IPttUtils)QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(getQBaseActivity());
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongVolumeView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView.a();
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null) {
      localMediaPlayer.release();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.setAccompanyPath(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapImplRedPacketKSongFragment$SongInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl.startRecord(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg, "", false);
      this.jdField_d_of_type_Boolean = true;
    }
    ReportController.b(getQBaseActivity().getAppRuntime(), "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.start", 0, 0, "", "", "", "");
  }
  
  public void n() {}
  
  public void o()
  {
    super.o();
    VoiceRedPacketHelperImpl.getInstance().clearReportStatus();
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplVoiceRedPacketHelperImpl;
    if (localObject != null) {
      ((VoiceRedPacketHelperImpl)localObject).cancelRecord();
    }
    r();
    localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localObject != null) {
      ((MediaPlayer)localObject).release();
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView.c();
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.getAnimationFromInfo();
    if (localObject != null) {
      ((AnimationView.AnimationInfo)localObject).destoryBitmaps();
    }
    try
    {
      getQBaseActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label77:
      s();
      b(this.jdField_b_of_type_AndroidWidgetImageView);
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
      localStringBuilder.append(this.jdField_d_of_type_Boolean);
      QLog.d("RedPacketKSongFragment", 2, localStringBuilder.toString());
    }
    if (this.jdField_d_of_type_Boolean) {
      b(HardCodeUtil.a(R.string.ci));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketKSongFragment
 * JD-Core Version:    0.7.0.1
 */