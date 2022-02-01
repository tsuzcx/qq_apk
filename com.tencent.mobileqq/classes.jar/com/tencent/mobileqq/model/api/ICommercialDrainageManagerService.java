package com.tencent.mobileqq.model.api;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ICommercialDrainageManagerService
  extends IRuntimeService
{
  public abstract int getShowCount(long paramLong, String paramString1, String paramString2, int paramInt);
  
  public abstract boolean isIPSite(Emoticon paramEmoticon);
  
  public abstract boolean isIPSite(EmoticonPackage paramEmoticonPackage);
  
  public abstract boolean isRichIPSite(VipIPSiteInfo paramVipIPSiteInfo);
  
  public abstract boolean shouldHiden(EmoticonPackage paramEmoticonPackage);
  
  public abstract void updateDisPlayInteval(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.model.api.ICommercialDrainageManagerService
 * JD-Core Version:    0.7.0.1
 */