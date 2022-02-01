package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.ControlerCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class WeiYunPreviewController$1
  extends FMObserver
{
  WeiYunPreviewController$1(WeiYunPreviewController paramWeiYunPreviewController) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6)
  {
    if (QLog.isDevelopLevel())
    {
      paramString6 = new StringBuilder();
      paramString6.append("SUCCESS OnFileWeiYunPreview harcode[");
      paramString6.append(((IFMConfig)QRoute.api(IFMConfig.class)).getUserHarCodeIp());
      paramString6.append("]");
      QLog.i("PreviewStep_1", 4, paramString6.toString());
    }
    if (((IFMConfig)QRoute.api(IFMConfig.class)).getUserHarCodeIp()) {
      paramString4 = "183.61.37.13";
    }
    for (paramString5 = "443";; paramString5 = String.valueOf(paramInt2))
    {
      break;
      if ((paramString4 == null) || (paramString4.length() <= 0)) {
        paramString4 = paramString5;
      }
    }
    if (this.a.a == null) {
      return;
    }
    this.a.a.a(paramBoolean, paramString4, paramString5, paramInt1, paramString1, paramString2, paramString3, this.a.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunPreviewController.1
 * JD-Core Version:    0.7.0.1
 */