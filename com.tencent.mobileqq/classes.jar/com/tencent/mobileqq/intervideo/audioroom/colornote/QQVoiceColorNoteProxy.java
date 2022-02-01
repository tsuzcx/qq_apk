package com.tencent.mobileqq.intervideo.audioroom.colornote;

import android.content.ContextWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.intervideo.audioroom.utils.QQVoiceUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QQVoiceColorNoteProxy
{
  private ColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController;
  private IQQVoiceServiceInfo jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomColornoteIQQVoiceServiceInfo;
  
  public QQVoiceColorNoteProxy(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController = new ColorNoteController(BaseApplication.getContext(), paramBoolean1, paramBoolean2);
  }
  
  public static void showColorNote(boolean paramBoolean)
  {
    ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, paramBoolean);
  }
  
  public void addHistoryNote()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.p();
  }
  
  public void addToRecentNote()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.n();
  }
  
  public void attachToActivity(ContextWrapper paramContextWrapper)
  {
    paramContextWrapper = QQVoiceUtil.getActFromShadowContext(paramContextWrapper);
    if (paramContextWrapper != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(paramContextWrapper);
    }
    QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy attachToActivity");
  }
  
  public boolean canAddColorNote()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.b();
  }
  
  public void deleteColorNote()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.f();
  }
  
  public void exitAnimation()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.d();
  }
  
  public IQQVoiceServiceInfo getServiceInfo()
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomColornoteIQQVoiceServiceInfo;
  }
  
  public void insertColorNote()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.e();
  }
  
  public boolean isColorNoteExist()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c();
  }
  
  public void onCannotAdd()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.i();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c();
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.b();
    QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy onResume");
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a()) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a();
    }
    QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy onResume");
  }
  
  public void setColorNoteAnimFinishCallback(OnColorNoteAnimFinish paramOnColorNoteAnimFinish)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(new QQVoiceColorNoteProxy.1(this, paramOnColorNoteAnimFinish));
  }
  
  public void setServiceInfo(IQQVoiceServiceInfo paramIQQVoiceServiceInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomColornoteIQQVoiceServiceInfo = paramIQQVoiceServiceInfo;
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(new QQVoiceColorNoteProxy.2(this, paramIQQVoiceServiceInfo));
  }
  
  public boolean shouldDisplayColorNote()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a();
  }
  
  public void updateColorNote(QQVoiceColorNote paramQQVoiceColorNote)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(paramQQVoiceColorNote.mColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.colornote.QQVoiceColorNoteProxy
 * JD-Core Version:    0.7.0.1
 */