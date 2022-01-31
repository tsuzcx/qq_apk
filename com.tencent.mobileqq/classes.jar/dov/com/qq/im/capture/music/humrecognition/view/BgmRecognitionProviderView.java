package dov.com.qq.im.capture.music.humrecognition.view;

import ajjy;
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
import bcec;
import befq;
import bhfm;
import bhim;
import bhiu;
import bhiw;
import bhix;
import bhjh;
import bhji;
import bhjj;
import bhjl;
import bhjn;
import bhpp;
import bicr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.ProviderView;

public class BgmRecognitionProviderView
  extends ProviderView
  implements Handler.Callback, View.OnClickListener, bhiw
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private befq jdField_a_of_type_Befq;
  bhim jdField_a_of_type_Bhim = new bhjn(this);
  private bhiu jdField_a_of_type_Bhiu;
  private bhjh jdField_a_of_type_Bhjh;
  private bhjl jdField_a_of_type_Bhjl;
  private bicr jdField_a_of_type_Bicr;
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
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131632564);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  private void i()
  {
    if (bhix.b()) {
      return;
    }
    this.jdField_a_of_type_Bhjh = new bhjj();
    q();
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickOriginalSongRecognition: invoked. ");
    }
    if (bhix.b()) {
      return;
    }
    this.jdField_a_of_type_Bhjh = new bhji();
    q();
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickHumRecognitionResult: invoked. ");
    }
    if (bhix.b()) {}
    while (this.jdField_a_of_type_Bhiu == null) {
      return;
    }
    if (this.jdField_a_of_type_Bhiu.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))
    {
      this.jdField_a_of_type_Bhiu.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.g);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131632566);
    this.jdField_a_of_type_Bhiu.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_Bhim);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Bhpp != null) {
      this.jdField_a_of_type_Bhpp.c(true);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Bhiu != null) {
      this.jdField_a_of_type_Bhiu.e();
    }
  }
  
  private void q()
  {
    bcec.a().a(2131632573);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131632568);
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, false);
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickCancel: invoked. ");
    }
    p();
    if (this.jdField_a_of_type_Bhpp != null) {
      this.jdField_a_of_type_Bhpp.d(2);
    }
    h();
  }
  
  private void s()
  {
    h();
    if (this.jdField_a_of_type_Bhpp != null)
    {
      this.jdField_a_of_type_Bhpp.d(2);
      this.jdField_a_of_type_Bhpp.a(33, Integer.valueOf(1001));
    }
  }
  
  public int a()
  {
    return 2131494961;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onDestroy: invoked. info: TAG = BgmRecognitionProviderView");
    }
    super.a();
    this.jdField_a_of_type_Bhim = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onCreate: invoked. info: data = " + paramBundle);
    }
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131494961, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    setNeedTabBar(false);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_Befq = new befq(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Bhjl = ((bhjl)bhfm.a().c(10));
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = ((QIMMusicConfigManager)bhfm.a(2));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298198));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298208));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298055));
    this.c.setOnClickListener(this);
    this.d = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298056));
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311396));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311405));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_Bhiu = ((bhiu)bhfm.a().c(8));
    h();
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "update: invoked. info: musicItemInfo = " + paramMusicItemInfo);
    }
    bcec.a().a(ajjy.a(2131635292) + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType == 7))
    {
      localMessage = this.jdField_a_of_type_Befq.obtainMessage();
      localMessage.obj = paramMusicItemInfo;
      localMessage.what = 1002;
      this.jdField_a_of_type_Befq.sendMessage(localMessage);
      return;
    }
    Message localMessage = this.jdField_a_of_type_Befq.obtainMessage();
    localMessage.obj = paramMusicItemInfo;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    localMessage.what = 1001;
    this.jdField_a_of_type_Befq.sendMessage(localMessage);
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onProviderShow: invoked. info: TAG = BgmRecognitionProviderView");
    }
    this.jdField_a_of_type_Bhjl.a(this);
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onProviderDismiss: invoked. info: TAG = BgmRecognitionProviderView");
    }
    this.jdField_a_of_type_Bhjl.b(this);
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
    if (this.jdField_a_of_type_Bhiu != null)
    {
      if (this.jdField_a_of_type_Bhiu.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))
      {
        this.jdField_a_of_type_Bhiu.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
        o();
        s();
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131632566);
    this.jdField_a_of_type_Bhiu.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_Bhim);
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131632567);
      if (!localMusicItemInfo.mHasCopyright)
      {
        paramMessage = bhix.a(localMusicItemInfo) + ajjy.a(2131635293);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        return false;
      }
      paramMessage = ajjy.a(2131635290) + bhix.a(localMusicItemInfo);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      return false;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131632567);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bhix.a(localMusicItemInfo));
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      return false;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131632565);
      if (this.jdField_a_of_type_Bhiu != null) {
        this.jdField_a_of_type_Bhiu.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
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
    case 2131298198: 
      r();
      return;
    case 2131298208: 
      g();
      return;
    case 2131298055: 
      j();
      return;
    case 2131298056: 
      i();
      return;
    }
    n();
  }
  
  public void setRecognitionPart(bicr parambicr)
  {
    this.jdField_a_of_type_Bicr = parambicr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView
 * JD-Core Version:    0.7.0.1
 */