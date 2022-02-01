package com.tencent.mobileqq.richmediabrowser.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

@KeepClassConstructor
public class LiuHaiWhiteListConfProcessor
  extends IQConfigProcessor<LiuHaiConfigInfo>
{
  public LiuHaiConfigInfo a;
  
  public static LiuHaiWhiteListConfProcessor a()
  {
    return LiuHaiWhiteListConfProcessor.SingletonHolder.a();
  }
  
  public LiuHaiConfigInfo a()
  {
    this.a = ((LiuHaiConfigInfo)QConfigManager.a().a(654));
    return this.a;
  }
  
  @NonNull
  public LiuHaiConfigInfo a(int paramInt)
  {
    return new LiuHaiConfigInfo();
  }
  
  @Nullable
  public LiuHaiConfigInfo a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LiuHaiWhiteListConfProcessor", 2, "onParsed confFiles = " + paramArrayOfQConfItem);
    }
    if (this.a == null) {
      this.a = new LiuHaiConfigInfo();
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("LiuHaiWhiteListConfProcessor", 2, "onParsed config = " + paramArrayOfQConfItem);
      }
      this.a.a = ListConfigParseUtils.a(paramArrayOfQConfItem);
    }
    return this.a;
  }
  
  public void a(LiuHaiConfigInfo paramLiuHaiConfigInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LiuHaiWhiteListConfProcessor", 2, "onUpdate newConf = " + paramLiuHaiConfigInfo);
    }
    if ((paramLiuHaiConfigInfo != null) && (paramLiuHaiConfigInfo.a != null)) {
      this.a = paramLiuHaiConfigInfo;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (this.a == null) {
      this.a = a();
    }
    if ((this.a == null) || (this.a.a == null) || (this.a.a.isEmpty())) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      Iterator localIterator = this.a.a.iterator();
      while (localIterator.hasNext())
      {
        MachineInfo localMachineInfo = (MachineInfo)localIterator.next();
        if ((!TextUtils.isEmpty(localMachineInfo.a)) && (!TextUtils.isEmpty(localMachineInfo.b)) && (!TextUtils.isEmpty(localMachineInfo.c)) && (paramString1.equals(localMachineInfo.a)) && (paramString2.equals(localMachineInfo.b)) && (paramString3.equals(localMachineInfo.c))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Class<LiuHaiConfigInfo> clazz()
  {
    return LiuHaiConfigInfo.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LiuHaiWhiteListConfProcessor", 2, "onReqFailed failCode = " + paramInt);
    }
  }
  
  public int type()
  {
    return 654;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.config.LiuHaiWhiteListConfProcessor
 * JD-Core Version:    0.7.0.1
 */