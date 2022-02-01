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
  
  @NonNull
  public LiuHaiConfigInfo a(int paramInt)
  {
    return new LiuHaiConfigInfo();
  }
  
  @Nullable
  public LiuHaiConfigInfo a(QConfItem[] paramArrayOfQConfItem)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onParsed confFiles = ");
      localStringBuilder.append(paramArrayOfQConfItem);
      QLog.d("LiuHaiWhiteListConfProcessor", 2, localStringBuilder.toString());
    }
    if (this.a == null) {
      this.a = new LiuHaiConfigInfo();
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed config = ");
        localStringBuilder.append(paramArrayOfQConfItem);
        QLog.d("LiuHaiWhiteListConfProcessor", 2, localStringBuilder.toString());
      }
      this.a.b = ListConfigParseUtils.a(paramArrayOfQConfItem);
    }
    return this.a;
  }
  
  public void a(LiuHaiConfigInfo paramLiuHaiConfigInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate newConf = ");
      localStringBuilder.append(paramLiuHaiConfigInfo);
      QLog.d("LiuHaiWhiteListConfProcessor", 2, localStringBuilder.toString());
    }
    if ((paramLiuHaiConfigInfo != null) && (paramLiuHaiConfigInfo.b != null)) {
      this.a = paramLiuHaiConfigInfo;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (this.a == null) {
      this.a = b();
    }
    Object localObject = this.a;
    if ((localObject != null) && (((LiuHaiConfigInfo)localObject).b != null))
    {
      if (this.a.b.isEmpty()) {
        return false;
      }
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
      {
        localObject = this.a.b.iterator();
        while (((Iterator)localObject).hasNext())
        {
          MachineInfo localMachineInfo = (MachineInfo)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localMachineInfo.a)) && (!TextUtils.isEmpty(localMachineInfo.b)) && (!TextUtils.isEmpty(localMachineInfo.c)) && (paramString1.equals(localMachineInfo.a)) && (paramString2.equals(localMachineInfo.b)) && (paramString3.equals(localMachineInfo.c))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public LiuHaiConfigInfo b()
  {
    this.a = ((LiuHaiConfigInfo)QConfigManager.b().b(654));
    return this.a;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed failCode = ");
      localStringBuilder.append(paramInt);
      QLog.d("LiuHaiWhiteListConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 654;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.config.LiuHaiWhiteListConfProcessor
 * JD-Core Version:    0.7.0.1
 */