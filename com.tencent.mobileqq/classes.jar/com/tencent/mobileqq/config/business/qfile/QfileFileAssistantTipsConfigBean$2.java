package com.tencent.mobileqq.config.business.qfile;

import android.content.Context;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig.IBaseJump;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.qroute.QRoute;

class QfileFileAssistantTipsConfigBean$2
  implements IFileAssistantTipsConfig.IBaseJump
{
  QfileFileAssistantTipsConfigBean$2(QfileFileAssistantTipsConfigBean paramQfileFileAssistantTipsConfigBean) {}
  
  public void a(Context paramContext)
  {
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).doJumpAction(paramContext, QfileFileAssistantTipsConfigBean.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean.2
 * JD-Core Version:    0.7.0.1
 */