package com.tencent.mobileqq.vas.updatesystem.business;

import com.tencent.mobileqq.vas.updatesystem.callback.RemoteVasUpdateListener;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.io.File;
import mqq.app.MobileQQ;

public abstract class QQVasUpdateBusiness<T extends BaseUpdateBusiness>
  extends BaseUpdateBusiness
{
  public static final String a;
  private IUpdateListener b;
  private RemoteVasUpdateListener c = new QQVasUpdateBusiness.1(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("vas_material_folder/");
    a = localStringBuilder.toString();
  }
  
  protected abstract String a();
  
  public void a(int paramInt)
  {
    startDownload(b(paramInt));
  }
  
  public void addUpdateListener(IUpdateListener paramIUpdateListener)
  {
    super.addUpdateListener(paramIUpdateListener);
    this.b = paramIUpdateListener;
  }
  
  protected String b()
  {
    return "";
  }
  
  public String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public String c(int paramInt)
  {
    return e(b(paramInt));
  }
  
  public boolean c(String paramString)
  {
    BusinessItemInfo localBusinessItemInfo = new BusinessItemInfo();
    localBusinessItemInfo.mSavePath = e(paramString);
    return isFileExist(null, localBusinessItemInfo);
  }
  
  public String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(a());
    return new File(localStringBuilder.toString(), paramString).getAbsolutePath();
  }
  
  public boolean d(int paramInt)
  {
    return new File(c(paramInt)).exists();
  }
  
  public String e(String paramString)
  {
    return d(paramString);
  }
  
  public BusinessItemInfo getBusinessItemInfo(long paramLong, String paramString)
  {
    BusinessItemInfo localBusinessItemInfo = new BusinessItemInfo();
    localBusinessItemInfo.mSaveInDir = true;
    localBusinessItemInfo.mSavePath = e(paramString);
    return localBusinessItemInfo;
  }
  
  public void startDownload(String paramString)
  {
    if (!QQVasUpdateBusinessUtil.a())
    {
      QQVasUpdateBusinessUtil.a(getClass(), paramString, this.c);
      return;
    }
    if (VasUpdateWrapper.getLog() == null)
    {
      QLog.e("VasUpdate_ QQBusiness", 1, "update system hasn't init");
      return;
    }
    super.startDownload(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
 * JD-Core Version:    0.7.0.1
 */