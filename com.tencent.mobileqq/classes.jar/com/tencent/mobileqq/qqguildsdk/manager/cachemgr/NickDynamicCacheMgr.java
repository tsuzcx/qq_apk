package com.tencent.mobileqq.qqguildsdk.manager.cachemgr;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.GProUserSimpleProfile;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public class NickDynamicCacheMgr
  extends DynamicCacheMgr<GProUserSimpleProfile>
{
  private GPSManagerEngine b;
  
  public NickDynamicCacheMgr(GPSManagerEngine paramGPSManagerEngine, Map<String, GProUserSimpleProfile> paramMap, Vector<String> paramVector)
  {
    super(paramMap, paramVector);
    this.b = paramGPSManagerEngine;
  }
  
  protected void a(List<String> paramList)
  {
    this.b.a(new ArrayList(paramList));
  }
  
  protected boolean a(Object paramObject)
  {
    return TextUtils.isEmpty((String)paramObject);
  }
  
  protected boolean a(String paramString)
  {
    return (super.a(paramString)) && (!TextUtils.isEmpty(((GProUserSimpleProfile)this.a.get(paramString)).d()));
  }
  
  protected boolean a(String paramString, Object paramObject)
  {
    return ((GProUserSimpleProfile)this.a.get(paramString)).a((String)paramObject);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return d(paramString1, paramString2);
  }
  
  protected GProUserSimpleProfile b(String paramString, Object paramObject)
  {
    return new GProUserSimpleProfile(paramString, (String)paramObject);
  }
  
  public String b(String paramString)
  {
    paramString = (GProUserSimpleProfile)c(paramString);
    if (paramString == null) {
      return "";
    }
    return paramString.d();
  }
  
  public Map<String, String> b(List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = c(paramList);
    if (paramList != null)
    {
      paramList = paramList.entrySet().iterator();
      while (paramList.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramList.next();
        localHashMap.put(localEntry.getKey(), ((GProUserSimpleProfile)localEntry.getValue()).d());
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.cachemgr.NickDynamicCacheMgr
 * JD-Core Version:    0.7.0.1
 */