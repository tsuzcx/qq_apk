package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.QfavBuilder;

public class FilePicQFavActivity
  extends IphoneTitleBarActivity
{
  long a;
  ChatMessage b;
  
  private void a()
  {
    if (this.a != -1L)
    {
      FileManagerEntity localFileManagerEntity = this.app.getFileManagerDataCenter().a(this.a);
      if ((localFileManagerEntity != null) && (-1L != localFileManagerEntity.uniseq))
      {
        this.b = ((ChatMessage)this.app.getMessageFacade().b(localFileManagerEntity.peerUin, localFileManagerEntity.peerType, localFileManagerEntity.uniseq));
        new QfavBuilder(3).a(this.app, this, localFileManagerEntity, this.b, false);
      }
    }
    finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = getIntent().getLongExtra("file_pic_favorites", -1L);
    a();
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isDevelopLevel()) {
      QLog.d("FilePicQFavActivity", 4, "FilePicQFavActivity onDestroy");
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FilePicQFavActivity
 * JD-Core Version:    0.7.0.1
 */