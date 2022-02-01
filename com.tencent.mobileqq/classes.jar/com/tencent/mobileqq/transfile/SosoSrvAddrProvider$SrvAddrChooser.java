package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.transfile.svraddr.ISvrAddr;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class SosoSrvAddrProvider$SrvAddrChooser
{
  private static final int MAX_FAILED_TIMES = 5;
  private int[] mUrlEncodeFailedTimes;
  
  SosoSrvAddrProvider$SrvAddrChooser(SosoSrvAddrProvider paramSosoSrvAddrProvider) {}
  
  private int findBestServer(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      ArrayList localArrayList = new ArrayList();
      int j = 5;
      int i = 0;
      if (i < paramArrayOfInt.length)
      {
        int k;
        if (paramArrayOfInt[i] < j)
        {
          k = paramArrayOfInt[i];
          localArrayList.clear();
          localArrayList.add(Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          k = j;
          if (paramArrayOfInt[i] == j)
          {
            localArrayList.add(Integer.valueOf(i));
            k = j;
          }
        }
      }
      if (localArrayList.size() > 0) {
        return ((Integer)localArrayList.get(0)).intValue();
      }
    }
    return -1;
  }
  
  private ISvrAddr findBestServer(List<ISvrAddr> paramList, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (paramArrayOfInt != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int j = 5;
      if (i < paramArrayOfInt.length)
      {
        int k = j;
        if (((ISvrAddr)paramList.get(i)).isIpv6() == paramBoolean)
        {
          if (paramArrayOfInt[i] >= j) {
            break label94;
          }
          k = paramArrayOfInt[i];
          localArrayList.clear();
          localArrayList.add(Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          label94:
          k = j;
          if (paramArrayOfInt[i] == j)
          {
            localArrayList.add(Integer.valueOf(i));
            k = j;
          }
        }
      }
      if (localArrayList.size() > 0)
      {
        i = ((Integer)localArrayList.get(0)).intValue();
        if ((i >= 0) && (i < paramList.size())) {
          return (ISvrAddr)paramList.get(i);
        }
      }
    }
    return null;
  }
  
  void clear()
  {
    this.mUrlEncodeFailedTimes = null;
  }
  
  ISvrAddr getAddr(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = null;
    List localList = SosoSrvAddrProvider.access$000(this.this$0, paramInt);
    Object localObject1 = localObject2;
    if (localList != null)
    {
      localObject1 = localObject2;
      if (localList.size() > 0) {
        localObject1 = findBestServer(localList, getFailedTimesArray(paramInt), paramBoolean);
      }
    }
    return localObject1;
  }
  
  int[] getFailedTimesArray(int paramInt)
  {
    if (paramInt == 0) {
      return this.mUrlEncodeFailedTimes;
    }
    return null;
  }
  
  void init(List<ISvrAddr> paramList)
  {
    if ((paramList != null) && (paramList != null) && (paramList.size() > 0)) {
      this.mUrlEncodeFailedTimes = new int[paramList.size()];
    }
  }
  
  void onFailed(int paramInt, String paramString)
  {
    try
    {
      List localList = SosoSrvAddrProvider.access$000(this.this$0, paramInt);
      int[] arrayOfInt = getFailedTimesArray(paramInt);
      if ((localList != null) && (localList.size() > 0) && (arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        paramString = new URL(paramString).getHost();
        if ((paramString != null) && (paramString.length() > 0)) {
          paramInt = 0;
        }
      }
      for (;;)
      {
        if (paramInt < localList.size())
        {
          String str = ((ISvrAddr)localList.get(paramInt)).getIp();
          if ((str == null) || (!str.equalsIgnoreCase(paramString))) {
            break label124;
          }
          if (arrayOfInt.length > paramInt) {
            arrayOfInt[paramInt] += 1;
          }
        }
        return;
        label124:
        paramInt += 1;
      }
      return;
    }
    catch (MalformedURLException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.SosoSrvAddrProvider.SrvAddrChooser
 * JD-Core Version:    0.7.0.1
 */