package com.tencent.mobileqq.filemanager.fileassistant.util;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQFileDatalineConfigBean;
import com.tencent.mobileqq.qroute.QRoute;

final class QFileAssistantUtils$1
  implements Runnable
{
  QFileAssistantUtils$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ((IQFileDatalineConfigBean)QRoute.api(IQFileDatalineConfigBean.class)).setNewFileAssistantSwitch(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils.1
 * JD-Core Version:    0.7.0.1
 */