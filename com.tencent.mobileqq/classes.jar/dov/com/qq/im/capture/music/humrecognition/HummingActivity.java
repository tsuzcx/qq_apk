package dov.com.qq.im.capture.music.humrecognition;

import Override;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anzj;
import bbev;
import blhq;
import bplq;
import bpor;
import bpoz;
import bppb;
import bppc;
import bppf;
import bppg;
import bpph;
import bppi;
import bppj;
import bppk;
import bppl;
import bppm;
import bppp;
import bppq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class HummingActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, bppb
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private blhq jdField_a_of_type_Blhq = new blhq(Looper.getMainLooper(), this);
  public bpor a;
  private bpoz jdField_a_of_type_Bpoz = (bpoz)bplq.a().c(8);
  private bppm jdField_a_of_type_Bppm;
  private bppq jdField_a_of_type_Bppq = (bppq)bplq.a().c(10);
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
    this.jdField_a_of_type_Bpor = new bppf(this);
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
      QQToast.a(this, 2131697595, 0).a();
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364314));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bppg(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363950));
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839291);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131363985));
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839330);
    this.c = ((Button)findViewById(2131363835));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378782));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697582);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378787));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697585);
    setTitle(2131697592);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130772229);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bpph(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new bppi(this));
    this.c.setOnClickListener(new bppj(this));
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HUM_HummingActivity", 2, "updateHumMusicItemToMyTab: invoked. info: musicItemInfo = " + paramMusicItemInfo);
    }
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType == 7)) {
      return;
    }
    ((QIMMusicConfigManager)bplq.a().c(2)).a(paramMusicItemInfo, true);
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
      if ((this.jdField_a_of_type_Bppm instanceof bppk))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697583);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697586);
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
      if (!(this.jdField_a_of_type_Bppm instanceof bppl)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697584);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697585);
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
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697585);
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
      this.jdField_a_of_type_Bppm = new bppk();
      setTitle(2131697592);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697583);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839291);
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839330);
    }
    for (;;)
    {
      c();
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        this.jdField_a_of_type_Bppm = new bppl();
        setTitle(2131697593);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697584);
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839330);
        this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839291);
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
      Message localMessage = this.jdField_a_of_type_Blhq.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramMusicItemInfo;
      this.jdField_a_of_type_Blhq.sendMessage(localMessage);
      QQToast.a(BaseApplicationImpl.getContext(), anzj.a(2131704565) + paramMusicItemInfo, 0).a();
      b(paramMusicItemInfo);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Blhq.sendEmptyMessage(2);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558450);
    this.jdField_a_of_type_Bppq.a(this);
    this.jdField_a_of_type_Bppm = new bppk();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(bppp.a, 1, 8000, 16, 2, null, null);
    b();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Bppq.b(this);
    e();
    this.jdField_a_of_type_Bpor = null;
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
        QQToast.a(this, 0, anzj.a(2131704567) + paramMessage.mMusicName + anzj.a(2131704568), 0).a();
        return false;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.c.setText(anzj.a(2131704569) + bppc.a(paramMessage));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMessage;
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      e();
      return false;
    case 2: 
      paramMessage = anzj.a(2131704564);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
      return false;
    case 4: 
      e();
      return false;
    }
    e();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131704563));
    this.jdField_a_of_type_Boolean = true;
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.HummingActivity
 * JD-Core Version:    0.7.0.1
 */