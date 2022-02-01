package com.tencent.mobileqq.hiboom;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.diy.VipDiyCardConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import mqq.app.AppRuntime;

final class HiBoomManager$4
  implements HiBoomFont.HiBoomFontDownloader
{
  public String a()
  {
    return VipDiyCardConstants.a;
  }
  
  public void a(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((IVasQuickUpdateService)localAppRuntime.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(5L, "font.diycard.android." + paramInt, "HiBoomDownloader");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomManager.4
 * JD-Core Version:    0.7.0.1
 */