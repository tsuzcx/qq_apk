package com.tencent.mobileqq.qqguildsdk.manager.cachemgr;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.GProUserSimpleProfile;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public class AvatarUrlDynamicCacheMgr
  extends DynamicCacheMgr<GProUserSimpleProfile>
{
  private GPSManagerEngine b;
  
  public AvatarUrlDynamicCacheMgr(GPSManagerEngine paramGPSManagerEngine, Map<String, GProUserSimpleProfile> paramMap, Vector<String> paramVector)
  {
    super(paramMap, paramVector);
    this.b = paramGPSManagerEngine;
  }
  
  protected void a(List<String> paramList)
  {
    this.b.b(new ArrayList(paramList));
  }
  
  protected boolean a(Object paramObject)
  {
    return paramObject == null;
  }
  
  protected boolean a(String paramString)
  {
    return (super.a(paramString)) && (!TextUtils.isEmpty(((GProUserSimpleProfile)this.a.get(paramString)).a()));
  }
  
  public boolean a(String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    return d(paramString, paramGuildUserAvatar);
  }
  
  protected boolean a(String paramString, Object paramObject)
  {
    return ((GProUserSimpleProfile)this.a.get(paramString)).a((GuildUserAvatar)paramObject);
  }
  
  protected GProUserSimpleProfile b(String paramString, Object paramObject)
  {
    return new GProUserSimpleProfile(paramString, (GuildUserAvatar)paramObject);
  }
  
  public GuildUserAvatar b(String paramString)
  {
    paramString = (GProUserSimpleProfile)c(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.e();
  }
  
  public Map<String, GuildUserAvatar> b(List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = c(paramList);
    if (paramList != null)
    {
      paramList = paramList.entrySet().iterator();
      while (paramList.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramList.next();
        localHashMap.put(localEntry.getKey(), ((GProUserSimpleProfile)localEntry.getValue()).e());
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.cachemgr.AvatarUrlDynamicCacheMgr
 * JD-Core Version:    0.7.0.1
 */