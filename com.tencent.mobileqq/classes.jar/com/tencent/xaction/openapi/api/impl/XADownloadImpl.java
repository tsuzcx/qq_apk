package com.tencent.xaction.openapi.api.impl;

import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.xaction.openapi.api.IXADownload;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class XADownloadImpl
  implements IXADownload
{
  public File getDownloadPath()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(SCID);
    ((StringBuilder)localObject).append(".zip");
    localObject = ((StringBuilder)localObject).toString();
    return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath(), (String)localObject);
  }
  
  public File getInstallRoot()
  {
    return DynamicLoaderImpl.INSTALL_ROOT;
  }
  
  public boolean isNoNeedDownload()
  {
    return getDownloadPath().exists();
  }
  
  public void onComplete(int paramInt) {}
  
  public void requestDownload()
  {
    try
    {
      ((IVasQuickUpdateService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, SCID, "xaction");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.openapi.api.impl.XADownloadImpl
 * JD-Core Version:    0.7.0.1
 */