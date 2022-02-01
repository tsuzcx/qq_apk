package com.tencent.qqperf.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class QConfigAPMProcessor
  extends IQConfigProcessor<APMConfRoot>
{
  public static final int CONFIG_ID = 255;
  public static final String TAG = "QAPM.Processor";
  
  public Class<APMConfRoot> clazz()
  {
    return APMConfRoot.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  @NonNull
  public APMConfRoot migrateOldOrDefaultContent(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAPM.Processor", 2, "migrateOldOrDefaultContent ");
    }
    return new APMConfRoot();
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public APMConfRoot onParsed(QConfItem[] paramArrayOfQConfItem)
  {
    if (paramArrayOfQConfItem.length > 0) {
      paramArrayOfQConfItem = (APMConfRoot)new Gson().fromJson(paramArrayOfQConfItem[0].b, APMConfRoot.class);
    } else {
      paramArrayOfQConfItem = null;
    }
    Object localObject = paramArrayOfQConfItem;
    if (paramArrayOfQConfItem == null) {
      localObject = new APMConfRoot();
    }
    return localObject;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public void onUpdate(APMConfRoot paramAPMConfRoot) {}
  
  public int type()
  {
    return 255;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.config.QConfigAPMProcessor
 * JD-Core Version:    0.7.0.1
 */