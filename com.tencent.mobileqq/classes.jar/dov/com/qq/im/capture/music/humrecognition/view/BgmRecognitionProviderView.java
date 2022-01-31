package dov.com.qq.im.capture.music.humrecognition.view;

import ajya;
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
import bdis;
import bfob;
import bjav;
import bjdv;
import bjed;
import bjef;
import bjeg;
import bjeq;
import bjer;
import bjes;
import bjeu;
import bjew;
import bjky;
import bjuf;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.ProviderView;

public class BgmRecognitionProviderView
  extends ProviderView
  implements Handler.Callback, View.OnClickListener, bjef
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bfob jdField_a_of_type_Bfob;
  bjdv jdField_a_of_type_Bjdv = new bjew(this);
  private bjed jdField_a_of_type_Bjed;
  private bjeq jdField_a_of_type_Bjeq;
  private bjeu jdField_a_of_type_Bjeu;
  private bjuf jdField_a_of_type_Bjuf;
  public MusicItemInfo a;
  QIMMusicConfigManager jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager;
  private Runnable jdField_a_of_type_JavaLangRunnable = new BgmRecognitionProviderView.2(this);
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
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType == 7)) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(paramMusicItemInfo, true);
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698310);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  private void i()
  {
    if (bjeg.b()) {
      return;
    }
    this.jdField_a_of_type_Bjeq = new bjes();
    q();
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickOriginalSongRecognition: invoked. ");
    }
    if (bjeg.b()) {
      return;
    }
    this.jdField_a_of_type_Bjeq = new bjer();
    q();
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickHumRecognitionResult: invoked. ");
    }
    if (bjeg.b()) {}
    while (this.jdField_a_of_type_Bjed == null) {
      return;
    }
    if (this.jdField_a_of_type_Bjed.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))
    {
      this.jdField_a_of_type_Bjed.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.g);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698312);
    this.jdField_a_of_type_Bjed.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_Bjdv);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Bjky != null) {
      this.jdField_a_of_type_Bjky.c(true);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Bjed != null) {
      this.jdField_a_of_type_Bjed.e();
    }
  }
  
  private void q()
  {
    bdis.a().a(2131698319);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698314);
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, false);
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickCancel: invoked. ");
    }
    p();
    if (this.jdField_a_of_type_Bjky != null) {
      this.jdField_a_of_type_Bjky.d(2);
    }
    h();
  }
  
  private void s()
  {
    h();
    if (this.jdField_a_of_type_Bjky != null)
    {
      this.jdField_a_of_type_Bjky.d(2);
      this.jdField_a_of_type_Bjky.a(33, Integer.valueOf(1001));
    }
  }
  
  public int a()
  {
    return 2131560534;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onDestroy: invoked. info: TAG = BgmRecognitionProviderView");
    }
    super.a();
    this.jdField_a_of_type_Bjdv = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onCreate: invoked. info: data = " + paramBundle);
    }
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560534, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    setNeedTabBar(false);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_Bfob = new bfob(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Bjeu = ((bjeu)bjav.a().c(10));
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = ((QIMMusicConfigManager)bjav.a(2));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363752));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363762));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363604));
    this.c.setOnClickListener(this);
    this.d = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363605));
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377209));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377218));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_Bjed = ((bjed)bjav.a().c(8));
    h();
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "update: invoked. info: musicItemInfo = " + paramMusicItemInfo);
    }
    bdis.a().a(ajya.a(2131701087) + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType == 7))
    {
      localMessage = this.jdField_a_of_type_Bfob.obtainMessage();
      localMessage.obj = paramMusicItemInfo;
      localMessage.what = 1002;
      this.jdField_a_of_type_Bfob.sendMessage(localMessage);
      return;
    }
    Message localMessage = this.jdField_a_of_type_Bfob.obtainMessage();
    localMessage.obj = paramMusicItemInfo;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    localMessage.what = 1001;
    this.jdField_a_of_type_Bfob.sendMessage(localMessage);
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onProviderShow: invoked. info: TAG = BgmRecognitionProviderView");
    }
    this.jdField_a_of_type_Bjeu.a(this);
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onProviderDismiss: invoked. info: TAG = BgmRecognitionProviderView");
    }
    this.jdField_a_of_type_Bjeu.b(this);
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
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickFinish: invoked. ");
    }
    this.jdField_a_of_type_Boolean = true;
    b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    if (this.jdField_a_of_type_Bjed != null)
    {
      if (this.jdField_a_of_type_Bjed.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))
      {
        this.jdField_a_of_type_Bjed.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
        o();
        s();
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698312);
    this.jdField_a_of_type_Bjed.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_Bjdv);
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698313);
      if (!localMusicItemInfo.mHasCopyright)
      {
        paramMessage = bjeg.a(localMusicItemInfo) + ajya.a(2131701088);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        return false;
      }
      paramMessage = ajya.a(2131701085) + bjeg.a(localMusicItemInfo);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      return false;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698313);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bjeg.a(localMusicItemInfo));
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      return false;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698311);
      if (this.jdField_a_of_type_Bjed != null) {
        this.jdField_a_of_type_Bjed.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
      o();
    } while (!this.jdField_a_of_type_Boolean);
    s();
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363752: 
      r();
      return;
    case 2131363762: 
      g();
      return;
    case 2131363604: 
      j();
      return;
    case 2131363605: 
      i();
      return;
    }
    n();
  }
  
  public void setRecognitionPart(bjuf parambjuf)
  {
    this.jdField_a_of_type_Bjuf = parambjuf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView
 * JD-Core Version:    0.7.0.1
 */