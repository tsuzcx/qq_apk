package com.tencent.mobileqq.hiboom;

import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class HiBoomConstants$2
  implements HiBoomFont.HiBoomFontDownloader
{
  public String a()
  {
    return HiBoomFont.b;
  }
  
  public void a(int paramInt)
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localObject != null)
    {
      IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)((AppRuntime)localObject).getRuntimeService(IVasQuickUpdateService.class, "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("font.hifont.android.");
      localStringBuilder.append(paramInt);
      localIVasQuickUpdateService.downloadItem(5L, localStringBuilder.toString(), "HiBoomDownloader");
      localObject = ((IVasService)((AppRuntime)localObject).getRuntimeService(IVasService.class, "")).getHiBoomManager().getHiBoomItemById(paramInt);
      ((HiBoomItem)localObject).b = true;
      ((HiBoomItem)localObject).c = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomConstants.2
 * JD-Core Version:    0.7.0.1
 */