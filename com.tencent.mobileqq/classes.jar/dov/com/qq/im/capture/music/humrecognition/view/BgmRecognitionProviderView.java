package dov.com.qq.im.capture.music.humrecognition.view;

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
import anzj;
import bjuh;
import blhq;
import bplq;
import bpor;
import bpoz;
import bppb;
import bppc;
import bppm;
import bppn;
import bppo;
import bppq;
import bpps;
import bpvt;
import bqdc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.ProviderView;

public class BgmRecognitionProviderView
  extends ProviderView
  implements Handler.Callback, View.OnClickListener, bppb
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private blhq jdField_a_of_type_Blhq;
  bpor jdField_a_of_type_Bpor = new bpps(this);
  private bpoz jdField_a_of_type_Bpoz;
  private bppm jdField_a_of_type_Bppm;
  private bppq jdField_a_of_type_Bppq;
  private bqdc jdField_a_of_type_Bqdc;
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
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697587);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  private void i()
  {
    if (bppc.b()) {
      return;
    }
    this.jdField_a_of_type_Bppm = new bppo();
    q();
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickOriginalSongRecognition: invoked. ");
    }
    if (bppc.b()) {
      return;
    }
    this.jdField_a_of_type_Bppm = new bppn();
    q();
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickHumRecognitionResult: invoked. ");
    }
    if (bppc.b()) {}
    while (this.jdField_a_of_type_Bpoz == null) {
      return;
    }
    if (this.jdField_a_of_type_Bpoz.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))
    {
      this.jdField_a_of_type_Bpoz.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.g);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697589);
    this.jdField_a_of_type_Bpoz.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_Bpor);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Bpvt != null) {
      this.jdField_a_of_type_Bpvt.c(true);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Bpoz != null) {
      this.jdField_a_of_type_Bpoz.e();
    }
  }
  
  private void q()
  {
    bjuh.a().a(2131697596);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697591);
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, false);
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickCancel: invoked. ");
    }
    p();
    if (this.jdField_a_of_type_Bpvt != null) {
      this.jdField_a_of_type_Bpvt.d(2);
    }
    h();
  }
  
  private void s()
  {
    h();
    if (this.jdField_a_of_type_Bpvt != null)
    {
      this.jdField_a_of_type_Bpvt.d(2);
      this.jdField_a_of_type_Bpvt.a(33, Integer.valueOf(1001));
    }
  }
  
  public int a()
  {
    return 2131560964;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onDestroy: invoked. info: TAG = BgmRecognitionProviderView");
    }
    super.a();
    this.jdField_a_of_type_Bpor = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onCreate: invoked. info: data = " + paramBundle);
    }
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560964, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    setNeedTabBar(false);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_Blhq = new blhq(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Bppq = ((bppq)bplq.a().c(10));
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = ((QIMMusicConfigManager)bplq.a(2));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364042));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364052));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363879));
    this.c.setOnClickListener(this);
    this.d = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363880));
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378782));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378791));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_Bpoz = ((bpoz)bplq.a().c(8));
    h();
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "update: invoked. info: musicItemInfo = " + paramMusicItemInfo);
    }
    bjuh.a().a(anzj.a(2131699999) + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType == 7))
    {
      localMessage = this.jdField_a_of_type_Blhq.obtainMessage();
      localMessage.obj = paramMusicItemInfo;
      localMessage.what = 1002;
      this.jdField_a_of_type_Blhq.sendMessage(localMessage);
      return;
    }
    Message localMessage = this.jdField_a_of_type_Blhq.obtainMessage();
    localMessage.obj = paramMusicItemInfo;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    localMessage.what = 1001;
    this.jdField_a_of_type_Blhq.sendMessage(localMessage);
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onProviderShow: invoked. info: TAG = BgmRecognitionProviderView");
    }
    this.jdField_a_of_type_Bppq.a(this);
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onProviderDismiss: invoked. info: TAG = BgmRecognitionProviderView");
    }
    this.jdField_a_of_type_Bppq.b(this);
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
    if (this.jdField_a_of_type_Bpoz != null)
    {
      if (this.jdField_a_of_type_Bpoz.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))
      {
        this.jdField_a_of_type_Bpoz.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
        o();
        s();
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697589);
    this.jdField_a_of_type_Bpoz.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_Bpor);
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697590);
      if (!localMusicItemInfo.mHasCopyright)
      {
        paramMessage = bppc.a(localMusicItemInfo) + anzj.a(2131700000);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        return false;
      }
      paramMessage = anzj.a(2131699997) + bppc.a(localMusicItemInfo);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      return false;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697590);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bppc.a(localMusicItemInfo));
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      return false;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697588);
      if (this.jdField_a_of_type_Bpoz != null) {
        this.jdField_a_of_type_Bpoz.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      r();
      continue;
      g();
      continue;
      j();
      continue;
      i();
      continue;
      n();
    }
  }
  
  public void setRecognitionPart(bqdc parambqdc)
  {
    this.jdField_a_of_type_Bqdc = parambqdc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView
 * JD-Core Version:    0.7.0.1
 */