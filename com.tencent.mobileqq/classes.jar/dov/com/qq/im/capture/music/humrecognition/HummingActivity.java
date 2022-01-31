package dov.com.qq.im.capture.music.humrecognition;

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
import anuv;
import anuw;
import anux;
import anuy;
import anuz;
import anva;
import anvb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.audio.AudioDataCache;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.MusicDownloadListener;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.music.humrecognition.humming.HumSongRecognizer;
import dov.com.qq.im.capture.music.humrecognition.humming.HumVoiceRecognizer;
import dov.com.qq.im.capture.music.humrecognition.humming.IRecognizer;
import dov.com.qq.im.capture.music.humrecognition.recognize.AcousticFingerprint;
import dov.com.qq.im.capture.music.humrecognition.recognize.RecognitionManager;

public class HummingActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, HumObserver
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AudioCapture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture;
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  public MusicDownloadListener a;
  private QimMusicPlayer jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
  private IRecognizer jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHummingIRecognizer;
  private RecognitionManager jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager = (RecognitionManager)QIMManager.a().c(10);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 1;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private Button c;
  
  public HummingActivity()
  {
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener = new anuv(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangRunnable = new anuw(this);
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
      QQToast.a(this, 2131439277, 0).a();
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362849));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new anux(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131362853));
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838497);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131362854));
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130838537);
    this.c = ((Button)findViewById(2131362852));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362850));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131439278);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362851));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131439274);
    setTitle(2131439275);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2131034313);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new anuy(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new anuz(this));
    this.c.setOnClickListener(new anva(this));
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HUM_HummingActivity", 2, "updateHumMusicItemToMyTab: invoked. info: musicItemInfo = " + paramMusicItemInfo);
    }
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.d == 7)) {
      return;
    }
    ((QIMMusicConfigManager)QIMManager.a().c(2)).a(paramMusicItemInfo, true);
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
      if ((this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHummingIRecognizer instanceof HumSongRecognizer))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131439271);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131439273);
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
      if (!(this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHummingIRecognizer instanceof HumVoiceRecognizer)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131439272);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131439274);
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
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131439274);
  }
  
  private void f()
  {
    anvb localanvb;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.f();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.d();
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a != null)
      {
        localanvb = new anvb(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a.b());
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break label67;
        }
        ThreadManager.post(localanvb, 5, null, false);
      }
    }
    return;
    label67:
    localanvb.run();
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
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHummingIRecognizer = new HumSongRecognizer();
      setTitle(2131439275);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131439271);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838497);
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130838537);
    }
    for (;;)
    {
      c();
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHummingIRecognizer = new HumVoiceRecognizer();
        setTitle(2131439276);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131439272);
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838537);
        this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130838497);
      }
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
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
    if (paramMusicItemInfo.d != 7)
    {
      this.jdField_b_of_type_Boolean = true;
      Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramMusicItemInfo;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
      QQToast.a(BaseApplicationImpl.getContext(), "识别结束。结果：" + paramMusicItemInfo, 0).a();
      b(paramMusicItemInfo);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130968606);
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager.a(this);
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHummingIRecognizer = new HumSongRecognizer();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(AcousticFingerprint.jdField_a_of_type_JavaLangString, 1, 8000, 16, 2, null, null);
    b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager.b(this);
    e();
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener = null;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    e();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
  }
  
  protected void doOnStop()
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
      if (!paramMessage.jdField_a_of_type_Boolean)
      {
        QQToast.a(this, 0, "无法下载音乐。" + paramMessage.jdField_a_of_type_JavaLangString + " 无版权", 0).a();
        return false;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.c.setText("点击播放：" + HumUtils.a(paramMessage));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMessage;
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      e();
      return false;
    case 2: 
      this.jdField_a_of_type_AndroidWidgetTextView.setText("将手机靠近音源识别更准确");
      return false;
    case 4: 
      e();
      return false;
    }
    e();
    this.jdField_a_of_type_AndroidWidgetTextView.setText("未匹配到结果，点击重新识别");
    this.jdField_a_of_type_Boolean = true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.HummingActivity
 * JD-Core Version:    0.7.0.1
 */