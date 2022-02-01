package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.core.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class DefaultFileModel$1
  implements ControlerCallback
{
  DefaultFileModel$1(DefaultFileModel paramDefaultFileModel, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      paramString1 = new StringBuilder();
      paramString1.append("sending cs to get preview url but failed, retCode[");
      paramString1.append(paramLong);
      paramString1.append("], retMeg[");
      paramString1.append(paramString3);
      paramString1.append("]");
      QLog.e("FileBrowserModelBase", 1, paramString1.toString());
      if (this.b.n != null) {
        this.b.n.a(paramLong);
      }
      if (this.b.k != null) {
        this.b.k.h();
      }
      this.b.a.getFileManagerDataCenter().c(this.b.c.r());
      return;
    }
    paramString3 = this.b;
    paramString3.d = paramString1;
    paramString3.e = paramString2;
    paramString3.f = paramString4;
    paramString3.g = paramString5;
    paramString1 = null;
    short s = 0;
    boolean bool = false;
    if (paramBundle != null)
    {
      if (this.a == 3000) {
        paramBoolean = ((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4Disc_ZipInner(this.b.a);
      } else {
        paramBoolean = ((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C_ZipInner(this.b.a);
      }
      paramString2 = paramBundle.getString("httpsdomain");
      if ((!TextUtils.isEmpty(paramString2)) && (paramBoolean))
      {
        s = paramBundle.getShort("httpsport");
        paramString1 = paramString2;
        paramBoolean = true;
      }
      else
      {
        s = 0;
        paramBoolean = bool;
      }
      paramString2 = paramBundle.getString("ipv6domain", "");
    }
    else
    {
      paramString1 = null;
      paramString2 = "";
      paramBoolean = false;
    }
    paramString3 = this.b;
    paramString3.a(paramString3.d, this.b.e, this.b.f, FileManagerUtil.p(this.b.c.r()), "/", this.b.g, this.b.c.r(), paramBoolean, paramString1, s, paramString2, new DefaultFileModel.1.1(this, paramBoolean, paramString1, s));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel.1
 * JD-Core Version:    0.7.0.1
 */