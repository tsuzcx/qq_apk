package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;

public class FilePicQFavActivity
  extends IphoneTitleBarActivity
{
  long jdField_a_of_type_Long;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  
  private void a()
  {
    if (this.jdField_a_of_type_Long != -1L)
    {
      FileManagerEntity localFileManagerEntity = this.app.a().a(this.jdField_a_of_type_Long);
      if ((localFileManagerEntity != null) && (-1L != localFileManagerEntity.uniseq))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)this.app.a().b(localFileManagerEntity.peerUin, localFileManagerEntity.peerType, localFileManagerEntity.uniseq));
        new QfavBuilder(3).a(this.app, this, localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, false);
      }
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Long = getIntent().getLongExtra("file_pic_favorites", -1L);
    a();
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FilePicQFavActivity
 * JD-Core Version:    0.7.0.1
 */