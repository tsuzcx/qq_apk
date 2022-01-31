package com.tencent.mobileqq.highway.iplearning;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class IpLearningImpl
  implements IpLearning
{
  public static final int DEFAULT_SUCC_FAIL_COUNT = -1;
  public static final boolean IS_DEBUG = true;
  public static int sEnableIpLearning;
  public static int sMaxFailCount = 3;
  public static long sTimeToLiveMills = 600000L;
  private ConcurrentHashMap<String, IpConnInfo> mIpConnInfos = new ConcurrentHashMap();
  private String mSuccIpInfo_Key;
  
  private String dumpIpLearningInfos()
  {
    StringBuilder localStringBuilder = new StringBuilder("_IpLearning_\n");
    localStringBuilder.append("mSuccIpInfo_Key").append(this.mSuccIpInfo_Key).append("\n");
    Iterator localIterator = this.mIpConnInfos.keySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      Object localObject1 = (IpConnInfo)this.mIpConnInfos.get(localObject2);
      localObject2 = localStringBuilder.append("Host:").append((String)localObject2).append(" Info:");
      if (localObject1 != null) {}
      for (localObject1 = ((IpConnInfo)localObject1).toString();; localObject1 = "null")
      {
        ((StringBuilder)localObject2).append((String)localObject1);
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("IpLearning", 2, localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  private static String dumpIpList(ArrayList<EndPoint> paramArrayList, String paramString)
  {
    paramArrayList = paramString + Arrays.toString(paramArrayList.toArray());
    if (QLog.isColorLevel()) {
      QLog.d("IpLearning", 2, paramArrayList);
    }
    return "IS NOT DEBUG";
  }
  
  public ArrayList<EndPoint> adjustNewIpList(ArrayList<EndPoint> paramArrayList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return localArrayList1;
    }
    dumpIpLearningInfos();
    int i = 0;
    Object localObject = this.mSuccIpInfo_Key;
    Iterator localIterator = paramArrayList.iterator();
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
      if (localObject == null) {
        break label326;
      }
      localObject = new EndPoint(((IpConnInfo)localObject).mHost, ((IpConnInfo)localObject).mPort, ((IpConnInfo)localObject).isSameIsp);
      ((EndPoint)localObject).failCount = -1;
      localArrayList1.add(localObject);
    }
    for (;;)
    {
      dumpIpList(paramArrayList, " DUMP_IPLIST_IN ");
      localArrayList1.addAll(paramArrayList);
      if (!this.mIpConnInfos.isEmpty()) {
        break;
      }
      dumpIpList(localArrayList1, " DUMP_IPLIST_OUT ");
      return localArrayList1;
      label326:
      this.mSuccIpInfo_Key = null;
    }
    localArrayList1.removeAll(localArrayList2);
    Collections.sort(localArrayList1, new IpListCompartor());
    dumpIpList(localArrayList1, " DUMP_IPLIST_OUT ");
    return localArrayList1;
  }
  
  public void onIpConnFail(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    if ((this.mSuccIpInfo_Key != null) && (this.mSuccIpInfo_Key.equalsIgnoreCase(paramString))) {
      this.mSuccIpInfo_Key = null;
    }
    IpConnInfo localIpConnInfo = new IpConnInfo(paramString, paramInt, false, false, SystemClock.uptimeMillis());
    paramString = (IpConnInfo)this.mIpConnInfos.putIfAbsent(paramString, localIpConnInfo);
    if (paramString != null) {
      paramString.markAsFailOnceMore();
    }
    for (;;)
    {
      dumpIpLearningInfos();
      return;
      localIpConnInfo.markAsFailOnceMore();
    }
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
  
  static class IpListCompartor
    implements Comparator<EndPoint>
  {
    public int compare(EndPoint paramEndPoint1, EndPoint paramEndPoint2)
    {
      if ((paramEndPoint1.isSameIsp) && (!paramEndPoint2.isSameIsp)) {
        return -1;
      }
      if ((!paramEndPoint1.isSameIsp) && (paramEndPoint2.isSameIsp)) {
        return 1;
      }
      return paramEndPoint1.failCount - paramEndPoint2.failCount;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.iplearning.IpLearningImpl
 * JD-Core Version:    0.7.0.1
 */