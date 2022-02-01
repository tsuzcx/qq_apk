package com.tencent.mobileqq.config.business.qfile;

import android.content.Context;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig.IBaseJump;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.qroute.QRoute;

class QfileFileAssistantTipsConfigBean$4
  implements IFileAssistantTipsConfig.IBaseJump
{
  QfileFileAssistantTipsConfigBean$4(QfileFileAssistantTipsConfigBean paramQfileFileAssistantTipsConfigBean) {}
  
  public void a(Context paramContext)
  {
    ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openLocalFileBrowserActivity(paramContext, QfileFileAssistantTipsConfigBean.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean.4
 * JD-Core Version:    0.7.0.1
 */