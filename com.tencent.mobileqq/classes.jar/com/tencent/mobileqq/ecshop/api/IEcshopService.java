package com.tencent.mobileqq.ecshop.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Service(process={""})
public abstract interface IEcshopService
  extends IRuntimeService
{
  public abstract void enterGDTVideoActivity(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, String paramString1, String paramString2, Activity paramActivity);
  
  public abstract void enterGDTVideoActivity(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, String paramString, boolean paramBoolean, Activity paramActivity);
  
  public abstract boolean enterGdtCanvasActivity(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, String paramString1, String paramString2, Activity paramActivity);
  
  public abstract boolean enterGdtCanvasActivity(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, String paramString, boolean paramBoolean, Activity paramActivity);
  
  public abstract boolean isInWalletGTKList(String paramString);
  
  public abstract boolean isInWalletReportList(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.api.IEcshopService
 * JD-Core Version:    0.7.0.1
 */