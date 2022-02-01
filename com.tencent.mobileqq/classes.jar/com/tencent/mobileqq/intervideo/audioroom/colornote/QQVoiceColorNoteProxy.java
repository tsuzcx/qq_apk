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
  private IColorNoteController a = (IColorNoteController)QRoute.api(IColorNoteController.class);
  private IQQVoiceServiceInfo b;
  
  public QQVoiceColorNoteProxy(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.init(BaseApplication.getContext(), paramBoolean1, paramBoolean2);
  }
  
  public static void showColorNote(boolean paramBoolean)
  {
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, paramBoolean);
  }
  
  public void addHistoryNote()
  {
    this.a.addHistoryNote();
  }
  
  public void addToRecentNote()
  {
    this.a.addToRecentNote();
  }
  
  public void attachToActivity(ContextWrapper paramContextWrapper)
  {
    paramContextWrapper = QQVoiceUtil.getActFromShadowContext(paramContextWrapper);
    if (paramContextWrapper != null) {
      this.a.attachToActivity(paramContextWrapper);
    }
    QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy attachToActivity");
  }
  
  public boolean canAddColorNote()
  {
    return this.a.canAddColorNote();
  }
  
  public void deleteColorNote()
  {
    this.a.deleteColorNote();
  }
  
  public void exitAnimation()
  {
    this.a.exitAnimation();
  }
  
  public IQQVoiceServiceInfo getServiceInfo()
  {
    return this.b;
  }
  
  public void insertColorNote()
  {
    this.a.insertColorNote();
  }
  
  public boolean isColorNoteExist()
  {
    return this.a.isColorNoteExist();
  }
  
  public void onCannotAdd()
  {
    this.a.onCannotAdd();
  }
  
  public void onDestroy()
  {
    this.a.onDestroy();
  }
  
  public void onPause()
  {
    this.a.onPause();
    QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy onResume");
  }
  
  public void onResume()
  {
    if (this.a.shouldDisplayColorNote()) {
      this.a.onResume();
    }
    QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy onResume");
  }
  
  public void setColorNoteAnimFinishCallback(OnColorNoteAnimFinish paramOnColorNoteAnimFinish)
  {
    this.a.setOnColorNoteAnimFinishListener(new QQVoiceColorNoteProxy.1(this, paramOnColorNoteAnimFinish));
  }
  
  public void setServiceInfo(IQQVoiceServiceInfo paramIQQVoiceServiceInfo)
  {
    this.b = paramIQQVoiceServiceInfo;
    this.a.setServiceInfo(new QQVoiceColorNoteProxy.2(this, paramIQQVoiceServiceInfo));
  }
  
  public boolean shouldDisplayColorNote()
  {
    return this.a.shouldDisplayColorNote();
  }
  
  public void updateColorNote(QQVoiceColorNote paramQQVoiceColorNote)
  {
    this.a.updateColorNote(paramQQVoiceColorNote.mColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.colornote.QQVoiceColorNoteProxy
 * JD-Core Version:    0.7.0.1
 */