package com.tencent.mobileqq.qqui.tempapi;

import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;

public class QQUITempApiImpl
  implements IQQUITempApi
{
  public boolean isNewVersionDataline()
  {
    return QFileAssistantUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqui.tempapi.QQUITempApiImpl
 * JD-Core Version:    0.7.0.1
 */