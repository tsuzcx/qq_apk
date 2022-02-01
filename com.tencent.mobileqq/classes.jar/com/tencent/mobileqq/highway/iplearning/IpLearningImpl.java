package com.tencent.mobileqq.highway.iplearning;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class IpLearningImpl
  implements IpLearning
{
  public static final int DEFAULT_SUCC_FAIL_COUNT = -1;
  public static final boolean IS_DEBUG = true;
  public static int sEnableIpLearning = 0;
  public static int sMaxFailCount = 3;
  public static long sTimeToLiveMills = 600000L;
  private ConcurrentHashMap<String, IpConnInfo> mIpConnInfos = new ConcurrentHashMap();
  private String mSuccIpInfo_Key = null;
  
  private String dumpIpLearningInfos()
  {
    StringBuilder localStringBuilder = new StringBuilder("_IpLearning_\n");
    localStringBuilder.append("mSuccIpInfo_Key");
    localStringBuilder.append(this.mSuccIpInfo_Key);
    localStringBuilder.append("\n");
    Iterator localIterator = this.mIpConnInfos.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      IpConnInfo localIpConnInfo = (IpConnInfo)this.mIpConnInfos.get(str);
      localStringBuilder.append("Host:");
      localStringBuilder.append(str);
      localStringBuilder.append(" Info:");
      if (localIpConnInfo != null) {
        str = localIpConnInfo.toString();
      } else {
        str = "null";
      }
      localStringBuilder.append(str);
    }
    BdhLogUtil.LogEvent("C", localStringBuilder.toString());
    return localStringBuilder.toString();
  }
  
  private static String dumpIpList(ArrayList<EndPoint> paramArrayList, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(Arrays.toString(paramArrayList.toArray()));
    BdhLogUtil.LogEvent("C", localStringBuilder.toString());
    return "IS NOT DEBUG";
  }
  
  public ArrayList<EndPoint> adjustNewIpList(ArrayList<EndPoint> paramArrayList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return localArrayList1;
      }
      dumpIpLearningInfos();
      Object localObject = this.mSuccIpInfo_Key;
      Iterator localIterator = paramArrayList.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        EndPoint localEndPoint = (EndPoint)localIterator.next();
        IpConnInfo localIpConnInfo = (IpConnInfo)this.mIpConnInfos.get(localEndPoint.host);
        if (localIpConnInfo == null) {
          localEndPoint.failCount = 0;
        } else if (localIpConnInfo.isConnSucc)
        {
          if ((localObject != null) && (localEndPoint.host.equalsIgnoreCase((String)localObject)))
          {
            i = 1;
            if (SystemClock.uptimeMillis() - localIpConnInfo.lLastSuccTimeMills > sTimeToLiveMills)
            {
              this.mIpConnInfos.remove(localObject);
              this.mSuccIpInfo_Key = null;
            }
            else
            {
              localEndPoint.failCount = -1;
            }
          }
          else
          {
            this.mIpConnInfos.remove(localIpConnInfo.mHost);
            this.mSuccIpInfo_Key = null;
          }
        }
        else if (localIpConnInfo.iFailCount > sMaxFailCount) {
          localArrayList2.add(localEndPoint);
        } else {
          localEndPoint.failCount = localIpConnInfo.iFailCount;
        }
      }
      if ((localObject != null) && (i == 0))
      {
        localObject = (IpConnInfo)this.mIpConnInfos.get(localObject);
        if (localObject != null)
        {
          localObject = new EndPoint(((IpConnInfo)localObject).mHost, ((IpConnInfo)localObject).mPort, ((IpConnInfo)localObject).isSameIsp);
          ((EndPoint)localObject).failCount = -1;
          localArrayList1.add(localObject);
        }
        else
        {
          this.mSuccIpInfo_Key = null;
        }
      }
      dumpIpList(paramArrayList, " DUMP_IPLIST_IN ");
      localArrayList1.addAll(paramArrayList);
      if (this.mIpConnInfos.isEmpty())
      {
        dumpIpList(localArrayList1, " DUMP_IPLIST_OUT ");
        return localArrayList1;
      }
      localArrayList1.removeAll(localArrayList2);
      Collections.sort(localArrayList1, new IpLearningImpl.IpListCompartor());
      dumpIpList(localArrayList1, " DUMP_IPLIST_OUT ");
    }
    return localArrayList1;
  }
  
  public void onIpConnFail(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    Object localObject = this.mSuccIpInfo_Key;
    if ((localObject != null) && (((String)localObject).equalsIgnoreCase(paramString))) {
      this.mSuccIpInfo_Key = null;
    }
    localObject = new IpConnInfo(paramString, paramInt, false, false, SystemClock.uptimeMillis());
    paramString = (IpConnInfo)this.mIpConnInfos.putIfAbsent(paramString, localObject);
    if (paramString != null) {
      paramString.markAsFailOnceMore();
    } else {
      ((IpConnInfo)localObject).markAsFailOnceMore();
    }
    dumpIpLearningInfos();
  }
  
  public void onIpConnSucc(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    IpConnInfo localIpConnInfo = new IpConnInfo(paramString, paramInt, true, paramBoolean, SystemClock.uptimeMillis());
    localIpConnInfo = (IpConnInfo)this.mIpConnInfos.putIfAbsent(paramString, localIpConnInfo);
    if (localIpConnInfo != null) {
      localIpConnInfo.markAsSucc();
    }
    this.mSuccIpInfo_Key = paramString;
    dumpIpLearningInfos();
  }
  
  public void onRecvClearCMD()
  {
    this.mSuccIpInfo_Key = null;
    this.mIpConnInfos.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.iplearning.IpLearningImpl
 * JD-Core Version:    0.7.0.1
 */