package com.tencent.mobileqq.vas.updatesystem.business;

import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.entity.BusinessItemInfo;
import java.io.File;
import mqq.app.MobileQQ;

public class TestUpdateBusinessV2
  extends BaseUpdateBusiness
{
  private String a(String paramString)
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localBaseApplication.getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("test_dir");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".zip");
    return localStringBuilder.toString();
  }
  
  public long getBid()
  {
    return 1000000L;
  }
  
  public BusinessItemInfo getBusinessItemInfo(long paramLong, String paramString)
  {
    paramString = new BusinessItemInfo();
    paramString.mSaveInDir = false;
    paramString.mSavePath = a("test");
    return paramString;
  }
  
  public String getFrom()
  {
    return "TestUpdateBusinessV2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.business.TestUpdateBusinessV2
 * JD-Core Version:    0.7.0.1
 */