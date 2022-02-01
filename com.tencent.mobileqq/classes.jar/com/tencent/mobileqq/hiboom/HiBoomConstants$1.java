package com.tencent.mobileqq.hiboom;

import com.tencent.mobileqq.profile.diy.VipDiyCardConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class HiBoomConstants$1
  implements HiBoomFont.HiBoomFontDownloader
{
  public String a()
  {
    return VipDiyCardConstants.a;
  }
  
  public void a(int paramInt)
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localObject != null)
    {
      localObject = (IVasQuickUpdateService)((AppRuntime)localObject).getRuntimeService(IVasQuickUpdateService.class, "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("font.diycard.android.");
      localStringBuilder.append(paramInt);
      ((IVasQuickUpdateService)localObject).downloadItem(5L, localStringBuilder.toString(), "HiBoomDownloader");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomConstants.1
 * JD-Core Version:    0.7.0.1
 */