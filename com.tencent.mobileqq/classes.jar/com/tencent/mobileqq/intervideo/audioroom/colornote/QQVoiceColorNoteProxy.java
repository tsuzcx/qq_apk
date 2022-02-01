package com.tencent.mobileqq.intervideo.audioroom.colornote;

import android.content.ContextWrapper;
import apkn;
import apoh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.audioroom.utils.QQVoiceUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QQVoiceColorNoteProxy
{
  private apkn jdField_a_of_type_Apkn;
  private IQQVoiceServiceInfo jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomColornoteIQQVoiceServiceInfo;
  
  public QQVoiceColorNoteProxy(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Apkn = new apkn(BaseApplication.getContext(), paramBoolean1, paramBoolean2);
  }
  
  public static void showColorNote(boolean paramBoolean)
  {
    apoh.a(BaseApplicationImpl.getContext(), 2, paramBoolean);
  }
  
  public void addHistoryNote()
  {
    this.jdField_a_of_type_Apkn.p();
  }
  
  public void addToRecentNote()
  {
    this.jdField_a_of_type_Apkn.n();
  }
  
  public void attachToActivity(ContextWrapper paramContextWrapper)
  {
    paramContextWrapper = QQVoiceUtil.getActFromShadowContext(paramContextWrapper);
    if (paramContextWrapper != null) {
      this.jdField_a_of_type_Apkn.a(paramContextWrapper);
    }
    QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy attachToActivity");
  }
  
  public boolean canAddColorNote()
  {
    return this.jdField_a_of_type_Apkn.b();
  }
  
  public void deleteColorNote()
  {
    this.jdField_a_of_type_Apkn.f();
  }
  
  public void exitAnimation()
  {
    this.jdField_a_of_type_Apkn.d();
  }
  
  public IQQVoiceServiceInfo getServiceInfo()
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomColornoteIQQVoiceServiceInfo;
  }
  
  public void insertColorNote()
  {
    this.jdField_a_of_type_Apkn.e();
  }
  
  public boolean isColorNoteExist()
  {
    return this.jdField_a_of_type_Apkn.c();
  }
  
  public void onCannotAdd()
  {
    this.jdField_a_of_type_Apkn.i();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Apkn.c();
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_Apkn.b();
    QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy onResume");
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_Apkn.a()) {
      this.jdField_a_of_type_Apkn.a();
    }
    QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy onResume");
  }
  
  public void setColorNoteAnimFinishCallback(OnColorNoteAnimFinish paramOnColorNoteAnimFinish)
  {
    this.jdField_a_of_type_Apkn.a(new QQVoiceColorNoteProxy.1(this, paramOnColorNoteAnimFinish));
  }
  
  public void setServiceInfo(IQQVoiceServiceInfo paramIQQVoiceServiceInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomColornoteIQQVoiceServiceInfo = paramIQQVoiceServiceInfo;
    this.jdField_a_of_type_Apkn.a(new QQVoiceColorNoteProxy.2(this, paramIQQVoiceServiceInfo));
  }
  
  public boolean shouldDisplayColorNote()
  {
    return this.jdField_a_of_type_Apkn.a();
  }
  
  public void updateColorNote(QQVoiceColorNote paramQQVoiceColorNote)
  {
    this.jdField_a_of_type_Apkn.a(paramQQVoiceColorNote.mColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.colornote.QQVoiceColorNoteProxy
 * JD-Core Version:    0.7.0.1
 */