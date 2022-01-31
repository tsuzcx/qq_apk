package com.tencent.mobileqq.studyroom.webview;

import awbx;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;

public class StudyRoomAppInterface
  extends AppInterface
{
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public awbx getEntityManagerFactory(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.webview.StudyRoomAppInterface
 * JD-Core Version:    0.7.0.1
 */