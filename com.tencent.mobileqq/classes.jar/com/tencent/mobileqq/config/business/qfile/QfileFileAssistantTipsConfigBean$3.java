package com.tencent.mobileqq.config.business.qfile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig.IBaseJump;

class QfileFileAssistantTipsConfigBean$3
  implements IFileAssistantTipsConfig.IBaseJump
{
  QfileFileAssistantTipsConfigBean$3(QfileFileAssistantTipsConfigBean paramQfileFileAssistantTipsConfigBean) {}
  
  public void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    if (Build.VERSION.SDK_INT >= 9)
    {
      localIntent.setAction(QfileFileAssistantTipsConfigBean.a(this.a));
      localIntent.setData(Uri.fromParts("package", paramContext.getPackageName(), null));
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      return;
      if (Build.VERSION.SDK_INT <= 8)
      {
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setClassName("com.android.settings", QfileFileAssistantTipsConfigBean.a(this.a));
        localIntent.putExtra("com.android.settings.ApplicationPkgName", paramContext.getPackageName());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean.3
 * JD-Core Version:    0.7.0.1
 */