package com.tencent.mobileqq.troop.fans.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.fans.api.ITroopFansService;
import com.tencent.mobileqq.troop.fans.data.TroopFansInfo.IdolItem;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

@Service(process={""})
public class TroopFansServiceImpl
  implements ITroopFansService
{
  AppRuntime app;
  protected ConcurrentHashMap<String, TroopFansInfo.IdolItem> mTroopIdolInfoCache;
  
  public TroopFansInfo.IdolItem getTroopIdolInfoDate(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (TroopFansInfo.IdolItem)this.mTroopIdolInfoCache.get(paramString);
    }
    return null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    if (this.mTroopIdolInfoCache == null) {
      try
      {
        if (this.mTroopIdolInfoCache == null) {
          this.mTroopIdolInfoCache = new ConcurrentHashMap();
        }
        return;
      }
      finally {}
    }
  }
  
  public void onDestroy() {}
  
  public void setTroopIdolInfoDate(String paramString, TroopFansInfo.IdolItem paramIdolItem)
  {
    if ((paramIdolItem != null) && (!TextUtils.isEmpty(paramString))) {
      this.mTroopIdolInfoCache.put(paramString, paramIdolItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fans.api.impl.TroopFansServiceImpl
 * JD-Core Version:    0.7.0.1
 */