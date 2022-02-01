package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.qroute.QRoute;

public class WeiYunPreviewController
  extends FilePreViewControllerBase
{
  AppInterface b;
  String c;
  String d;
  FMObserver e = null;
  
  public WeiYunPreviewController(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    this.b = paramAppInterface;
    this.c = paramString1;
    this.d = paramString2;
    d();
  }
  
  public boolean a()
  {
    ((IQQFileEngine)this.b.getRuntimeService(IQQFileEngine.class, "")).getWeiYunPreview(this.c, this.d);
    return true;
  }
  
  public void b()
  {
    if (this.e != null) {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.e);
    }
  }
  
  public int c()
  {
    return 4;
  }
  
  public void d()
  {
    this.e = new WeiYunPreviewController.1(this);
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addObserver(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunPreviewController
 * JD-Core Version:    0.7.0.1
 */