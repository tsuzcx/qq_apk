package com.tencent.mobileqq.hiboom;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import mqq.app.AppRuntime;

final class HiBoomManager$3
  implements HiBoomFont.HiBoomFontDownloader
{
  public String a()
  {
    return HiBoomFont.b;
  }
  
  public void a(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      ((IVasQuickUpdateService)((AppRuntime)localObject).getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(5L, "font.hifont.android." + paramInt, "HiBoomDownloader");
      localObject = ((HiBoomManager)((AppRuntime)localObject).getManager(QQManagerFactory.HIBOOM_MANAGER)).a(paramInt);
      ((HiBoomItem)localObject).b = true;
      ((HiBoomItem)localObject).c = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomManager.3
 * JD-Core Version:    0.7.0.1
 */