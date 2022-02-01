package com.tencent.rmonitor.fd.analysis.analyzers;

import android.text.TextUtils;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import com.tencent.rmonitor.fd.dump.data.FdHeapData;
import com.tencent.rmonitor.fd.utils.SharkUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.sequences.Sequence;
import shark.HeapGraph;
import shark.HeapObject.HeapClass;
import shark.HeapObject.HeapInstance;

public class FdSocketAnalyzer
  extends BaseFdHeapAnalyzer
{
  private String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder(15);
    int i = 0;
    while (i < 4)
    {
      localStringBuilder.insert(0, Long.toString(0xFF & paramLong));
      if (i < 3) {
        localStringBuilder.insert(0, '.');
      }
      paramLong >>= 8;
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private String a(HeapObject.HeapInstance paramHeapInstance)
  {
    if (paramHeapInstance != null)
    {
      HeapObject.HeapInstance localHeapInstance = SharkUtil.c(paramHeapInstance, "java.net.InetAddress", "holder");
      String str = SharkUtil.b(localHeapInstance, "originalHostName");
      paramHeapInstance = str;
      if (TextUtils.isEmpty(str)) {
        paramHeapInstance = a(SharkUtil.a(localHeapInstance, "address"));
      }
      return paramHeapInstance;
    }
    return null;
  }
  
  private Set<Long> a(FdHeapData paramFdHeapData, Map<Long, String> paramMap)
  {
    Object localObject1 = paramFdHeapData.a().a("java.net.Socket");
    paramFdHeapData = new HashSet();
    if (localObject1 == null) {
      return paramFdHeapData;
    }
    localObject1 = ((HeapObject.HeapClass)localObject1).o().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      HeapObject.HeapInstance localHeapInstance = (HeapObject.HeapInstance)((Iterator)localObject1).next();
      Object localObject2 = SharkUtil.c(localHeapInstance, "java.net.Socket", "impl");
      if (localObject2 != null)
      {
        int i = SharkUtil.a((HeapObject.HeapInstance)localObject2, "java.net.SocketImpl", "port");
        localObject2 = a(SharkUtil.c((HeapObject.HeapInstance)localObject2, "java.net.SocketImpl", "address"));
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          long l = localHeapInstance.b();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("%s/");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(":");
          localStringBuilder.append(i);
          paramMap.put(Long.valueOf(l), localStringBuilder.toString());
          paramFdHeapData.add(Long.valueOf(localHeapInstance.b()));
        }
      }
    }
    return paramFdHeapData;
  }
  
  private Set<Long> b(FdHeapData paramFdHeapData, Map<Long, String> paramMap)
  {
    Object localObject1 = paramFdHeapData.a().a("sun.nio.ch.SocketChannelImpl");
    paramFdHeapData = new HashSet();
    if (localObject1 == null) {
      return paramFdHeapData;
    }
    localObject1 = ((HeapObject.HeapClass)localObject1).o().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      HeapObject.HeapInstance localHeapInstance = (HeapObject.HeapInstance)((Iterator)localObject1).next();
      Object localObject2 = SharkUtil.c(localHeapInstance, "sun.nio.ch.SocketChannelImpl", "remoteAddress");
      if (localObject2 != null)
      {
        localObject2 = SharkUtil.c((HeapObject.HeapInstance)localObject2, "java.net.InetSocketAddress", "holder");
        if (localObject2 != null)
        {
          int i = SharkUtil.a((HeapObject.HeapInstance)localObject2, "port");
          localObject2 = a(SharkUtil.c((HeapObject.HeapInstance)localObject2, "java.net.InetSocketAddress$InetSocketAddressHolder", "addr"));
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            long l = localHeapInstance.b();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("%s/");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(":");
            localStringBuilder.append(i);
            paramMap.put(Long.valueOf(l), localStringBuilder.toString());
            paramFdHeapData.add(Long.valueOf(localHeapInstance.b()));
          }
        }
      }
    }
    return paramFdHeapData;
  }
  
  public String a()
  {
    return "sockets";
  }
  
  protected void a(Set<Long> paramSet, Map<Long, String> paramMap1, Map<Long, String> paramMap2, Map<String, Integer> paramMap)
  {
    Iterator localIterator = paramMap2.keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if (paramSet.contains(localLong))
      {
        String str1 = (String)paramMap1.get(localLong);
        String str2 = (String)paramMap2.get(localLong);
        if (str2 != null) {
          str1 = String.format(str1, new Object[] { str2 });
        } else {
          str1 = String.format(str1, new Object[] { "/NoObjectPath" });
        }
        paramMap1.put(localLong, str1);
      }
    }
    paramSet = new HashSet(paramSet);
    paramSet.removeAll(paramMap2.keySet());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      paramMap2 = (Long)paramSet.next();
      paramMap1.put(paramMap2, String.format((String)paramMap1.get(paramMap2), new Object[] { "/NoObjectPath" }));
    }
    paramSet = paramMap1.keySet().iterator();
    while (paramSet.hasNext()) {
      a(paramMap, (String)paramMap1.get((Long)paramSet.next()));
    }
  }
  
  public void c(FdLeakDumpResult paramFdLeakDumpResult)
  {
    HashMap localHashMap = new HashMap();
    paramFdLeakDumpResult = (FdHeapData)paramFdLeakDumpResult.getData();
    Set localSet1 = a(paramFdLeakDumpResult, localHashMap);
    Set localSet2 = b(paramFdLeakDumpResult, localHashMap);
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(localSet1);
    localHashSet.addAll(localSet2);
    paramFdLeakDumpResult.a(a(), localHashSet);
    paramFdLeakDumpResult.a(a(), localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.analyzers.FdSocketAnalyzer
 * JD-Core Version:    0.7.0.1
 */