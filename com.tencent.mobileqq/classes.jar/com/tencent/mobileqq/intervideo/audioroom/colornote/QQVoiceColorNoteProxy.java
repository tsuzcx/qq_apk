package com.tencent.mobileqq.intervideo.audioroom.colornote;

import android.content.ContextWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.intervideo.audioroom.utils.QQVoiceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QQVoiceColorNoteProxy
{
  private IColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController = (IColorNoteController)QRoute.api(IColorNoteController.class);
  private IQQVoiceServiceInfo jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomColornoteIQQVoiceServiceInfo;
  
  public QQVoiceColorNoteProxy(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.init(BaseApplication.getContext(), paramBoolean1, paramBoolean2);
  }
  
  public static void showColorNote(boolean paramBoolean)
  {
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, paramBoolean);
  }
  
  public void addHistoryNote()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.addHistoryNote();
  }
  
  public void addToRecentNote()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.addToRecentNote();
  }
  
  public void attachToActivity(ContextWrapper paramContextWrapper)
  {
    paramContextWrapper = QQVoiceUtil.getActFromShadowContext(paramContextWrapper);
    if (paramContextWrapper != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.attachToActivity(paramContextWrapper);
    }
    QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy attachToActivity");
  }
  
  public boolean canAddColorNote()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.canAddColorNote();
  }
  
  public void deleteColorNote()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.deleteColorNote();
  }
  
  public void exitAnimation()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.exitAnimation();
  }
  
  public IQQVoiceServiceInfo getServiceInfo()
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomColornoteIQQVoiceServiceInfo;
  }
  
  public void insertColorNote()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.insertColorNote();
  }
  
  public boolean isColorNoteExist()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.isColorNoteExist();
  }
  
  public void onCannotAdd()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onCannotAdd();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onDestroy();
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onPause();
    QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy onResume");
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.shouldDisplayColorNote()) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onResume();
    }
    QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy onResume");
  }
  
  public void setColorNoteAnimFinishCallback(OnColorNoteAnimFinish paramOnColorNoteAnimFinish)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnColorNoteAnimFinishListener(new QQVoiceColorNoteProxy.1(this, paramOnColorNoteAnimFinish));
  }
  
  public void setServiceInfo(IQQVoiceServiceInfo paramIQQVoiceServiceInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomColornoteIQQVoiceServiceInfo = paramIQQVoiceServiceInfo;
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setServiceInfo(new QQVoiceColorNoteProxy.2(this, paramIQQVoiceServiceInfo));
  }
  
  public boolean shouldDisplayColorNote()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.shouldDisplayColorNote();
  }
  
  public void updateColorNote(QQVoiceColorNote paramQQVoiceColorNote)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.updateColorNote(paramQQVoiceColorNote.mColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.colornote.QQVoiceColorNoteProxy
 * JD-Core Version:    0.7.0.1
 */