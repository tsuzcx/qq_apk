package com.tencent.raft.codegenmeta.service;

import com.tencent.raft.codegenmeta.utils.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RAServiceMetaCenter
{
  private static final String TAG = "RAServiceMetaCenter";
  public Map<String, String> mClassToServiceNameMap = new ConcurrentHashMap();
  public Map<String, RAServiceMeta> mServiceNameToMetaMap = new ConcurrentHashMap();
  
  public RAServiceMeta getServiceMeta(String paramString)
  {
    paramString = (String)this.mClassToServiceNameMap.get(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (RAServiceMeta)this.mServiceNameToMetaMap.get(paramString);
  }
  
  public void init(List<Map<String, Object>> paramList)
  {
    if (paramList != null) {
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject1 = (Map)paramList.next();
          Object localObject2 = new RAServiceMeta();
          ((RAServiceMeta)localObject2).parse((Map)localObject1);
          localObject1 = ((RAServiceMeta)localObject2).getServiceKey();
          this.mServiceNameToMetaMap.put(localObject1, localObject2);
          if (!TextUtils.isEmpty(((RAServiceMeta)localObject2).getServiceKey())) {
            this.mClassToServiceNameMap.put(((RAServiceMeta)localObject2).getServiceKey(), localObject1);
          }
          localObject2 = ((RAServiceMeta)localObject2).interfaces.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            this.mClassToServiceNameMap.put(str, localObject1);
          }
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.codegenmeta.service.RAServiceMetaCenter
 * JD-Core Version:    0.7.0.1
 */