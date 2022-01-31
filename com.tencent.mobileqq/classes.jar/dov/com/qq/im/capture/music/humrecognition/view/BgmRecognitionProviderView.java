package dov.com.qq.im.capture.music.humrecognition.view;

import amwl;
import amwm;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.MusicDownloadListener;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.music.humrecognition.HumObserver;
import dov.com.qq.im.capture.music.humrecognition.HumUtils;
import dov.com.qq.im.capture.music.humrecognition.humming.IRecognizer;
import dov.com.qq.im.capture.music.humrecognition.humming.OriginalBgmRecognizer;
import dov.com.qq.im.capture.music.humrecognition.humming.VoiceBgmRecognizer;
import dov.com.qq.im.capture.music.humrecognition.recognize.RecognitionManager;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;
import dov.com.tencent.biz.qqstory.takevideo.EditRecognitionPart;

public class BgmRecognitionProviderView
  extends ProviderView
  implements Handler.Callback, View.OnClickListener, HumObserver
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public MusicItemInfo a;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  MusicDownloadListener jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener = new amwl(this);
  QIMMusicConfigManager jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager;
  private QimMusicPlayer jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
  private IRecognizer jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHummingIRecognizer;
  private RecognitionManager jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager;
  private EditRecognitionPart jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecognitionPart;
  private Runnable jdField_a_of_type_JavaLangRunnable = new amwm(this);
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Button c;
  private Button d;
  
  public BgmRecognitionProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "updateHumMusicItemToMyTab: invoked. info: musicItemInfo = " + paramMusicItemInfo);
    }
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.d == 7)) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(paramMusicItemInfo, true);
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131439223);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  private void i()
  {
    if (HumUtils.b()) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHummingIRecognizer = new VoiceBgmRecognizer();
    o();
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickOriginalSongRecognition: invoked. ");
    }
    if (HumUtils.b()) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHummingIRecognizer = new OriginalBgmRecognizer();
    o();
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickHumRecognitionResult: invoked. ");
    }
    if (HumUtils.b()) {
      return;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))
    {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.f);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131439219);
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.e(true);
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.e();
  }
  
  private void o()
  {
    ToastUtil.a().a(2131439224);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131439222);
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, false);
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickCancel: invoked. ");
    }
    n();
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.d(2);
    }
    h();
  }
  
  private void q()
  {
    h();
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.d(2);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a(33, Integer.valueOf(1001));
    }
  }
  
  protected int a()
  {
    return 2130970064;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onProviderShow: invoked. info: TAG = BgmRecognitionProviderView");
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager.a(this);
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onCreate: invoked. info: data = " + paramBundle);
    }
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130970064, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    setNeedTabBar(false);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager = ((RecognitionManager)QIMManager.a().c(10));
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = ((QIMMusicConfigManager)QIMManager.a(2));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131368881));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131368882));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131368884));
    this.c.setOnClickListener(this);
    this.d = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131368885));
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362827));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368886));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    h();
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "update: invoked. info: musicItemInfo = " + paramMusicItemInfo);
    }
    ToastUtil.a().a("识别结束。结果：" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.d == 7))
    {
      localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
      localMessage.obj = paramMusicItemInfo;
      localMessage.what = 1002;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
      return;
    }
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
    localMessage.obj = paramMusicItemInfo;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    localMessage.what = 1001;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
  }
  
  public void b()
  {
    super.b();
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onProviderDismiss: invoked. info: TAG = BgmRecognitionProviderView");
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager.b(this);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onDestroy: invoked. info: TAG = BgmRecognitionProviderView");
    }
    super.c();
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickFinish: invoked. ");
    }
    this.jdField_a_of_type_Boolean = true;
    b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))
    {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      m();
      q();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131439219);
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener);
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onResume: invoked. info: TAG = BgmRecognitionProviderView");
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onStop: invoked. info: TAG = BgmRecognitionProviderView");
    }
    super.f();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)paramMessage.obj;
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131439220);
      if (!localMusicItemInfo.jdField_a_of_type_Boolean)
      {
        paramMessage = HumUtils.a(localMusicItemInfo) + " 无版权";
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        return false;
      }
      paramMessage = "点击播放：" + HumUtils.a(localMusicItemInfo);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      return false;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131439220);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HumUtils.a(localMusicItemInfo));
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      return false;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131439221);
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      m();
    } while (!this.jdField_a_of_type_Boolean);
    q();
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368881: 
      p();
      return;
    case 2131368882: 
      d();
      return;
    case 2131368884: 
      j();
      return;
    case 2131368885: 
      i();
      return;
    }
    l();
  }
  
  public void setRecognitionPart(EditRecognitionPart paramEditRecognitionPart)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecognitionPart = paramEditRecognitionPart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView
 * JD-Core Version:    0.7.0.1
 */