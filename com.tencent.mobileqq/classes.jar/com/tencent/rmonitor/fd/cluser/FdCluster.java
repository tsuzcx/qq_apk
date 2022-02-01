package com.tencent.rmonitor.fd.cluser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public class FdCluster
{
  private static final IFdMatcher[] a = { new PrefixFdMatcher(1, new String[] { "socket:[" }), new ExactFdMatcher(2, new String[] { "anon_inode:[eventpoll]", "anon_inode:[eventfd]" }), new PrefixFdMatcher(3, new String[] { "/dev/ashmem" }), new PrefixFdMatcher(4, new String[] { "/dmabuf", "anon_inode:dmabuf", "/dev/ion" }), new PrefixFdMatcher(5, new String[] { "/data/", "/system/", "/storage/", "/apex/" }) };
  
  public static FdClusterItem a(Map<Integer, FdClusterItem> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = new ArrayList(paramMap.values());
      Collections.sort(paramMap);
      return (FdClusterItem)paramMap.get(0);
    }
    return null;
  }
  
  @Nullable
  private IFdMatcher a(String paramString)
  {
    IFdMatcher[] arrayOfIFdMatcher = a;
    int j = arrayOfIFdMatcher.length;
    int i = 0;
    while (i < j)
    {
      IFdMatcher localIFdMatcher = arrayOfIFdMatcher[i];
      if (localIFdMatcher.a(paramString)) {
        return localIFdMatcher;
      }
      i += 1;
    }
    return null;
  }
  
  private void a(int paramInt, String paramString, Map<Integer, FdClusterItem> paramMap)
  {
    FdClusterItem localFdClusterItem2 = (FdClusterItem)paramMap.get(Integer.valueOf(paramInt));
    FdClusterItem localFdClusterItem1 = localFdClusterItem2;
    if (localFdClusterItem2 == null)
    {
      localFdClusterItem1 = new FdClusterItem(paramInt);
      paramMap.put(Integer.valueOf(paramInt), localFdClusterItem1);
    }
    localFdClusterItem1.a(paramString);
  }
  
  public Map<Integer, FdClusterItem> a(List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      IFdMatcher localIFdMatcher = a(str);
      if (localIFdMatcher != null) {
        a(localIFdMatcher.a(), str, localHashMap);
      } else {
        a(6, str, localHashMap);
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.cluser.FdCluster
 * JD-Core Version:    0.7.0.1
 */