package com.tencent.mobileqq.config.business.qfile;

import android.content.Context;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig.IBaseJump;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.qroute.QRoute;

class QfileFileAssistantTipsConfigBean$1
  implements IFileAssistantTipsConfig.IBaseJump
{
  QfileFileAssistantTipsConfigBean$1(QfileFileAssistantTipsConfigBean paramQfileFileAssistantTipsConfigBean) {}
  
  public void a(Context paramContext)
  {
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openQQBrowserWithoutAD(paramContext, QfileFileAssistantTipsConfigBean.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean.1
 * JD-Core Version:    0.7.0.1
 */