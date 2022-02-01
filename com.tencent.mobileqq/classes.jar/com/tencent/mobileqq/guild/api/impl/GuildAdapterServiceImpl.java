package com.tencent.mobileqq.guild.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class GuildAdapterServiceImpl
  implements IGuildAdapterService
{
  private AppRuntime app;
  private GPServiceObserver mGPServiceObserver = new GuildAdapterServiceImpl.1(this);
  private List<ICategoryInfo> visitorCategoryListInfoList = null;
  private String visitorGuildId;
  private IGProGuildInfo visitorGuildInfo = null;
  
  public List<ICategoryInfo> getCategoryInfoList(String paramString, int paramInt)
  {
    AppRuntime localAppRuntime = this.app;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if (paramInt == 1) {
        return ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).getChannelCategoryList(paramString);
      }
      localObject1 = localObject2;
      if (paramInt == 0)
      {
        localObject1 = localObject2;
        if (this.visitorCategoryListInfoList != null)
        {
          localObject1 = localObject2;
          if (paramString.equals(this.visitorGuildId)) {
            localObject1 = this.visitorCategoryListInfoList;
          }
        }
      }
    }
    return localObject1;
  }
  
  public List<IGProChannelInfo> getChannelList(String paramString, boolean paramBoolean)
  {
    if ((this.app != null) && (!TextUtils.isEmpty(paramString)))
    {
      List localList = ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).getChannelList(paramString);
      ArrayList localArrayList = null;
      Iterator localIterator = localList.iterator();
      do
      {
        paramString = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramString = (IGProChannelInfo)localIterator.next();
      } while (paramString.getType() != 3);
      localArrayList = new ArrayList(localList);
      if (paramString != null) {
        localArrayList.remove(paramString);
      }
      return localArrayList;
    }
    return Collections.emptyList();
  }
  
  public List<IGProChannelInfo> getChannelList(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramInt == 1) {
      return getChannelList(paramString, paramBoolean);
    }
    Object localObject = null;
    paramString = localObject;
    if (paramInt == 0)
    {
      List localList = this.visitorCategoryListInfoList;
      paramString = localObject;
      if (localList != null)
      {
        paramString = localObject;
        if (!localList.isEmpty()) {
          paramString = ((ICategoryInfo)this.visitorCategoryListInfoList.get(0)).c();
        }
      }
    }
    return paramString;
  }
  
  @Deprecated
  public HashMap<String, List<IGProChannelInfo>> getChannelMap(String paramString, boolean paramBoolean)
  {
    paramString = getChannelList(paramString, paramBoolean);
    HashMap localHashMap = new HashMap();
    localHashMap.put("", paramString);
    localHashMap.put("分组1", paramString);
    localHashMap.put("分组2", paramString);
    return localHashMap;
  }
  
  public IGProGuildInfo getGuildInfo(String paramString, int paramInt)
  {
    AppRuntime localAppRuntime = this.app;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if (paramInt == 1) {
        return ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString);
      }
      localObject1 = localObject2;
      if (paramInt == 0)
      {
        localObject1 = localObject2;
        if (this.visitorGuildInfo != null)
        {
          localObject1 = localObject2;
          if (paramString.equals(this.visitorGuildId)) {
            localObject1 = this.visitorGuildInfo;
          }
        }
      }
    }
    return localObject1;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).addObserver(this.mGPServiceObserver);
  }
  
  public void onDestroy()
  {
    ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).deleteObserver(this.mGPServiceObserver);
    setVisitorGuildCardInfo(null, null, null);
  }
  
  public void setVisitorGuildCardInfo(String paramString, IGProGuildInfo paramIGProGuildInfo, List<ICategoryInfo> paramList)
  {
    this.visitorGuildId = paramString;
    this.visitorGuildInfo = paramIGProGuildInfo;
    this.visitorCategoryListInfoList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildAdapterServiceImpl
 * JD-Core Version:    0.7.0.1
 */