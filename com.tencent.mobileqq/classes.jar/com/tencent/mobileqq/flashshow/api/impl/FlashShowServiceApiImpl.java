package com.tencent.mobileqq.flashshow.api.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.flashshow.api.IFSQQBaseService;
import com.tencent.mobileqq.flashshow.api.IFlashShowServiceApi;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.api.instance.FlashShowController;
import com.tencent.mobileqq.flashshow.api.interfaces.IFlashShowController;
import com.tencent.mobileqq.flashshow.bean.FSSchemeBean;
import com.tencent.mobileqq.flashshow.launcher.FSSchemeLauncher;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

public class FlashShowServiceApiImpl
  implements IFlashShowServiceApi
{
  public static IFSQQBaseService getQQService()
  {
    return (IFSQQBaseService)QRoute.api(IFSQQBaseService.class);
  }
  
  public void enterBySchemeAction(Context paramContext, String paramString, @NonNull HashMap<String, String> paramHashMap)
  {
    FSSchemeBean localFSSchemeBean = new FSSchemeBean();
    localFSSchemeBean.setSchemeAction(paramString);
    localFSSchemeBean.setAttrs(paramHashMap);
    FSSchemeLauncher.a(paramContext, localFSSchemeBean);
  }
  
  public IFlashShowController getFlashShowController()
  {
    return FlashShowController.a();
  }
  
  public void reportTo1101(DataBuilder paramDataBuilder)
  {
    FSLpReportDc11001.a(paramDataBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.impl.FlashShowServiceApiImpl
 * JD-Core Version:    0.7.0.1
 */