package com.tencent.mobileqq.vas.updatesystem.business;

import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.entity.BusinessItemInfo;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class QQVasUpdateBusiness<T extends BaseUpdateBusiness>
  extends BaseUpdateBusiness
{
  private static final String a = MobileQQ.getContext().getFilesDir() + File.separator + "vas_material_folder";
  
  public static <T extends QQVasUpdateBusiness> T a(Class<T> paramClass)
  {
    return (QQVasUpdateBusiness)((IVasQuickUpdateService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IVasQuickUpdateService.class, "")).getBusinessCallback(paramClass);
  }
  
  protected abstract String a();
  
  public String a(int paramInt)
  {
    return b() + paramInt;
  }
  
  public String a(String paramString)
  {
    return new File(a + a(), paramString).getAbsolutePath();
  }
  
  public void a(int paramInt)
  {
    startDownload(a(paramInt));
  }
  
  public boolean a(int paramInt)
  {
    return new File(b(paramInt)).exists();
  }
  
  protected String b()
  {
    return "";
  }
  
  public String b(int paramInt)
  {
    return b(a(paramInt));
  }
  
  public String b(String paramString)
  {
    return a(paramString);
  }
  
  public BusinessItemInfo getBusinessItemInfo(long paramLong, String paramString)
  {
    BusinessItemInfo localBusinessItemInfo = new BusinessItemInfo();
    localBusinessItemInfo.mSaveInDir = true;
    localBusinessItemInfo.mSavePath = b(paramString);
    return localBusinessItemInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
 * JD-Core Version:    0.7.0.1
 */