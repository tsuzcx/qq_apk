package dov.com.qq.im.capture.music.humrecognition;

import ajyc;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import avrs;
import bcpw;
import bfnk;
import bjae;
import bjde;
import bjdm;
import bjdo;
import bjdp;
import bjds;
import bjdt;
import bjdu;
import bjdv;
import bjdw;
import bjdx;
import bjdy;
import bjdz;
import bjec;
import bjed;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class HummingActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, bjdo
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bfnk jdField_a_of_type_Bfnk = new bfnk(Looper.getMainLooper(), this);
  public bjde a;
  private bjdm jdField_a_of_type_Bjdm = (bjdm)bjae.a().c(8);
  private bjdz jdField_a_of_type_Bjdz;
  private bjed jdField_a_of_type_Bjed = (bjed)bjae.a().c(10);
  private AudioCapture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture;
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 1;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private Button c;
  
  public HummingActivity()
  {
    this.jdField_a_of_type_Bjde = new bjds(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangRunnable = new HummingActivity.2(this);
  }
  
  private void a(long paramLong)
  {
    a();
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
  }
  
  private void a(boolean paramBoolean)
  {
    e();
    if (paramBoolean)
    {
      i();
      bcpw.a(this, 2131698308, 0).a();
      if (this.jdField_b_of_type_Int == 1) {
        a(3000L);
      }
      while (this.jdField_b_of_type_Int != 2) {
        return;
      }
      a(7000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364002));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bjdt(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363667));
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839026);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131363698));
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839065);
    this.c = ((Button)findViewById(2131363565));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377207));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698295);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377212));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698298);
    setTitle(2131698305);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130772204);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bjdu(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new bjdv(this));
    this.c.setOnClickListener(new bjdw(this));
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HUM_HummingActivity", 2, "updateHumMusicItemToMyTab: invoked. info: musicItemInfo = " + paramMusicItemInfo);
    }
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType == 7)) {
      return;
    }
    ((QIMMusicConfigManager)bjae.a().c(2)).a(paramMusicItemInfo, true);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = true;
    d();
  }
  
  private void d()
  {
    a(this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      if ((this.jdField_a_of_type_Bjdz instanceof bjdx))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698296);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698299);
        label56:
        if (this.jdField_a_of_type_Boolean) {
          break label116;
        }
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      if (!(this.jdField_a_of_type_Bjdz instanceof bjdy)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698297);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698298);
      break label56;
    }
  }
  
  private void e()
  {
    f();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698298);
  }
  
  private void f()
  {
    HummingActivity.7 local7;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.g();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a != null)
      {
        local7 = new HummingActivity.7(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a.b());
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break label67;
        }
        ThreadManager.post(local7, 5, null, false);
      }
    }
    return;
    label67:
    local7.run();
  }
  
  private void g()
  {
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void h()
  {
    g();
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_Bjdz = new bjdx();
      setTitle(2131698305);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698296);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839026);
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839065);
    }
    for (;;)
    {
      c();
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        this.jdField_a_of_type_Bjdz = new bjdy();
        setTitle(2131698306);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698297);
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839065);
        this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839026);
      }
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.f();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HUM_HummingActivity", 2, "update: invoked. info: musicItemInfo = " + paramMusicItemInfo);
    }
    if (paramMusicItemInfo == null) {
      return;
    }
    if (paramMusicItemInfo.mType != 7)
    {
      this.jdField_b_of_type_Boolean = true;
      Message localMessage = this.jdField_a_of_type_Bfnk.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramMusicItemInfo;
      this.jdField_a_of_type_Bfnk.sendMessage(localMessage);
      bcpw.a(BaseApplicationImpl.getContext(), ajyc.a(2131705662) + paramMusicItemInfo, 0).a();
      b(paramMusicItemInfo);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Bfnk.sendEmptyMessage(2);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558445);
    this.jdField_a_of_type_Bjed.a(this);
    this.jdField_a_of_type_Bjdz = new bjdx();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(bjec.a, 1, 8000, 16, 2, null, null);
    b();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Bjed.b(this);
    e();
    this.jdField_a_of_type_Bjde = null;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    e();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    e();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    default: 
    case 1: 
      do
      {
        return false;
        paramMessage = (MusicItemInfo)paramMessage.obj;
        if (paramMessage != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("HUM_HummingActivity", 2, "handleMessage: humMusicItemInfo = " + paramMessage);
      return false;
      if (!paramMessage.mHasCopyright)
      {
        bcpw.a(this, 0, ajyc.a(2131705664) + paramMessage.mMusicName + ajyc.a(2131705665), 0).a();
        return false;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.c.setText(ajyc.a(2131705666) + bjdp.a(paramMessage));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMessage;
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      e();
      return false;
    case 2: 
      paramMessage = ajyc.a(2131705661);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
      return false;
    case 4: 
      e();
      return false;
    }
    e();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131705660));
    this.jdField_a_of_type_Boolean = true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.HummingActivity
 * JD-Core Version:    0.7.0.1
 */