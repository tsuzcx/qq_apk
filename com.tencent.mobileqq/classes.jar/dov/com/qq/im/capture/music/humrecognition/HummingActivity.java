package dov.com.qq.im.capture.music.humrecognition;

import ajjy;
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
import ausj;
import bbmy;
import befq;
import bhfm;
import bhim;
import bhiu;
import bhiw;
import bhix;
import bhja;
import bhjb;
import bhjc;
import bhjd;
import bhje;
import bhjf;
import bhjg;
import bhjh;
import bhjk;
import bhjl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class HummingActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, bhiw
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private befq jdField_a_of_type_Befq = new befq(Looper.getMainLooper(), this);
  public bhim a;
  private bhiu jdField_a_of_type_Bhiu = (bhiu)bhfm.a().c(8);
  private bhjh jdField_a_of_type_Bhjh;
  private bhjl jdField_a_of_type_Bhjl = (bhjl)bhfm.a().c(10);
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
    this.jdField_a_of_type_Bhim = new bhja(this);
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
      bbmy.a(this, 2131632572, 0).a();
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298445));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bhjb(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298115));
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838998);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131298145));
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839037);
    this.c = ((Button)findViewById(2131298015));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311396));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131632559);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311401));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131632562);
    setTitle(2131632569);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130772204);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bhjc(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new bhjd(this));
    this.c.setOnClickListener(new bhje(this));
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HUM_HummingActivity", 2, "updateHumMusicItemToMyTab: invoked. info: musicItemInfo = " + paramMusicItemInfo);
    }
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType == 7)) {
      return;
    }
    ((QIMMusicConfigManager)bhfm.a().c(2)).a(paramMusicItemInfo, true);
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
      if ((this.jdField_a_of_type_Bhjh instanceof bhjf))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131632560);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131632563);
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
      if (!(this.jdField_a_of_type_Bhjh instanceof bhjg)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131632561);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131632562);
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
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131632562);
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
      this.jdField_a_of_type_Bhjh = new bhjf();
      setTitle(2131632569);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131632560);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838998);
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839037);
    }
    for (;;)
    {
      c();
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        this.jdField_a_of_type_Bhjh = new bhjg();
        setTitle(2131632570);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131632561);
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839037);
        this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130838998);
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
      Message localMessage = this.jdField_a_of_type_Befq.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramMusicItemInfo;
      this.jdField_a_of_type_Befq.sendMessage(localMessage);
      bbmy.a(BaseApplicationImpl.getContext(), ajjy.a(2131639877) + paramMusicItemInfo, 0).a();
      b(paramMusicItemInfo);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Befq.sendEmptyMessage(2);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131492908);
    this.jdField_a_of_type_Bhjl.a(this);
    this.jdField_a_of_type_Bhjh = new bhjf();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(bhjk.a, 1, 8000, 16, 2, null, null);
    b();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Bhjl.b(this);
    e();
    this.jdField_a_of_type_Bhim = null;
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
        bbmy.a(this, 0, ajjy.a(2131639879) + paramMessage.mMusicName + ajjy.a(2131639880), 0).a();
        return false;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.c.setText(ajjy.a(2131639881) + bhix.a(paramMessage));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMessage;
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      e();
      return false;
    case 2: 
      paramMessage = ajjy.a(2131639876);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
      return false;
    case 4: 
      e();
      return false;
    }
    e();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131639875));
    this.jdField_a_of_type_Boolean = true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.HummingActivity
 * JD-Core Version:    0.7.0.1
 */