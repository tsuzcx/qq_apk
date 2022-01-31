package dov.com.qq.im.capture.music.humrecognition.view;

import alpo;
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
import bfhq;
import bhow;
import blmf;
import blpg;
import blpo;
import blpq;
import blpr;
import blqb;
import blqc;
import blqd;
import blqf;
import blqh;
import blwi;
import bmfp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.ProviderView;

public class BgmRecognitionProviderView
  extends ProviderView
  implements Handler.Callback, View.OnClickListener, blpq
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhow jdField_a_of_type_Bhow;
  blpg jdField_a_of_type_Blpg = new blqh(this);
  private blpo jdField_a_of_type_Blpo;
  private blqb jdField_a_of_type_Blqb;
  private blqf jdField_a_of_type_Blqf;
  private bmfp jdField_a_of_type_Bmfp;
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
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698600);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  private void i()
  {
    if (blpr.b()) {
      return;
    }
    this.jdField_a_of_type_Blqb = new blqd();
    q();
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickOriginalSongRecognition: invoked. ");
    }
    if (blpr.b()) {
      return;
    }
    this.jdField_a_of_type_Blqb = new blqc();
    q();
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickHumRecognitionResult: invoked. ");
    }
    if (blpr.b()) {}
    while (this.jdField_a_of_type_Blpo == null) {
      return;
    }
    if (this.jdField_a_of_type_Blpo.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))
    {
      this.jdField_a_of_type_Blpo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.g);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698602);
    this.jdField_a_of_type_Blpo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_Blpg);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Blwi != null) {
      this.jdField_a_of_type_Blwi.c(true);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Blpo != null) {
      this.jdField_a_of_type_Blpo.e();
    }
  }
  
  private void q()
  {
    bfhq.a().a(2131698609);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698604);
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, false);
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickCancel: invoked. ");
    }
    p();
    if (this.jdField_a_of_type_Blwi != null) {
      this.jdField_a_of_type_Blwi.d(2);
    }
    h();
  }
  
  private void s()
  {
    h();
    if (this.jdField_a_of_type_Blwi != null)
    {
      this.jdField_a_of_type_Blwi.d(2);
      this.jdField_a_of_type_Blwi.a(33, Integer.valueOf(1001));
    }
  }
  
  public int a()
  {
    return 2131560710;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onDestroy: invoked. info: TAG = BgmRecognitionProviderView");
    }
    super.a();
    this.jdField_a_of_type_Blpg = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onCreate: invoked. info: data = " + paramBundle);
    }
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560710, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    setNeedTabBar(false);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_Bhow = new bhow(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Blqf = ((blqf)blmf.a().c(10));
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = ((QIMMusicConfigManager)blmf.a(2));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363808));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363818));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363649));
    this.c.setOnClickListener(this);
    this.d = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363650));
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377730));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377739));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_Blpo = ((blpo)blmf.a().c(8));
    h();
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "update: invoked. info: musicItemInfo = " + paramMusicItemInfo);
    }
    bfhq.a().a(alpo.a(2131701456) + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType == 7))
    {
      localMessage = this.jdField_a_of_type_Bhow.obtainMessage();
      localMessage.obj = paramMusicItemInfo;
      localMessage.what = 1002;
      this.jdField_a_of_type_Bhow.sendMessage(localMessage);
      return;
    }
    Message localMessage = this.jdField_a_of_type_Bhow.obtainMessage();
    localMessage.obj = paramMusicItemInfo;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    localMessage.what = 1001;
    this.jdField_a_of_type_Bhow.sendMessage(localMessage);
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onProviderShow: invoked. info: TAG = BgmRecognitionProviderView");
    }
    this.jdField_a_of_type_Blqf.a(this);
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onProviderDismiss: invoked. info: TAG = BgmRecognitionProviderView");
    }
    this.jdField_a_of_type_Blqf.b(this);
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
    if (this.jdField_a_of_type_Blpo != null)
    {
      if (this.jdField_a_of_type_Blpo.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))
      {
        this.jdField_a_of_type_Blpo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
        o();
        s();
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698602);
    this.jdField_a_of_type_Blpo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_Blpg);
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698603);
      if (!localMusicItemInfo.mHasCopyright)
      {
        paramMessage = blpr.a(localMusicItemInfo) + alpo.a(2131701457);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        return false;
      }
      paramMessage = alpo.a(2131701454) + blpr.a(localMusicItemInfo);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      return false;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698603);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(blpr.a(localMusicItemInfo));
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      return false;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698601);
      if (this.jdField_a_of_type_Blpo != null) {
        this.jdField_a_of_type_Blpo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
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
    case 2131363808: 
      r();
      return;
    case 2131363818: 
      g();
      return;
    case 2131363649: 
      j();
      return;
    case 2131363650: 
      i();
      return;
    }
    n();
  }
  
  public void setRecognitionPart(bmfp parambmfp)
  {
    this.jdField_a_of_type_Bmfp = parambmfp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView
 * JD-Core Version:    0.7.0.1
 */