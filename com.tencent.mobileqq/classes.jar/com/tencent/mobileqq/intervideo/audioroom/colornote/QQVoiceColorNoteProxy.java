package com.tencent.mobileqq.intervideo.audioroom.colornote;

import android.app.Activity;
import android.content.ContextWrapper;
import aqre;
import aquy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QQVoiceColorNoteProxy
{
  private aqre jdField_a_of_type_Aqre;
  private IQQVoiceServiceInfo jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomColornoteIQQVoiceServiceInfo;
  
  public QQVoiceColorNoteProxy(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Aqre = new aqre(BaseApplication.getContext(), paramBoolean1, paramBoolean2);
  }
  
  public static void showColorNote(boolean paramBoolean)
  {
    aquy.a(BaseApplicationImpl.getContext(), 2, paramBoolean);
  }
  
  public void addHistoryNote()
  {
    this.jdField_a_of_type_Aqre.p();
  }
  
  public void addToRecentNote()
  {
    this.jdField_a_of_type_Aqre.n();
  }
  
  public void attachToActivity(ContextWrapper paramContextWrapper)
  {
    if ((paramContextWrapper instanceof Activity)) {
      paramContextWrapper = (Activity)paramContextWrapper;
    }
    for (;;)
    {
      if (paramContextWrapper != null) {
        this.jdField_a_of_type_Aqre.a(paramContextWrapper);
      }
      QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy attachToActivity");
      return;
      if ((paramContextWrapper != null) && ((paramContextWrapper.getBaseContext() instanceof Activity))) {
        paramContextWrapper = (Activity)paramContextWrapper.getBaseContext();
      } else {
        paramContextWrapper = null;
      }
    }
  }
  
  public boolean canAddColorNote()
  {
    return this.jdField_a_of_type_Aqre.b();
  }
  
  public void deleteColorNote()
  {
    this.jdField_a_of_type_Aqre.f();
  }
  
  public void exitAnimation()
  {
    this.jdField_a_of_type_Aqre.d();
  }
  
  public IQQVoiceServiceInfo getServiceInfo()
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomColornoteIQQVoiceServiceInfo;
  }
  
  public void insertColorNote()
  {
    this.jdField_a_of_type_Aqre.e();
  }
  
  public boolean isColorNoteExist()
  {
    return this.jdField_a_of_type_Aqre.c();
  }
  
  public void onCannotAdd()
  {
    this.jdField_a_of_type_Aqre.i();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Aqre.c();
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_Aqre.b();
    QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy onResume");
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_Aqre.a()) {
      this.jdField_a_of_type_Aqre.a();
    }
    QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy onResume");
  }
  
  public void setColorNoteAnimFinishCallback(OnColorNoteAnimFinish paramOnColorNoteAnimFinish)
  {
    this.jdField_a_of_type_Aqre.a(new QQVoiceColorNoteProxy.1(this, paramOnColorNoteAnimFinish));
  }
  
  public void setServiceInfo(IQQVoiceServiceInfo paramIQQVoiceServiceInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomColornoteIQQVoiceServiceInfo = paramIQQVoiceServiceInfo;
    this.jdField_a_of_type_Aqre.a(new QQVoiceColorNoteProxy.2(this, paramIQQVoiceServiceInfo));
  }
  
  public boolean shouldDisplayColorNote()
  {
    return this.jdField_a_of_type_Aqre.a();
  }
  
  public void updateColorNote(QQVoiceColorNote paramQQVoiceColorNote)
  {
    this.jdField_a_of_type_Aqre.a(paramQQVoiceColorNote.mColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.colornote.QQVoiceColorNoteProxy
 * JD-Core Version:    0.7.0.1
 */