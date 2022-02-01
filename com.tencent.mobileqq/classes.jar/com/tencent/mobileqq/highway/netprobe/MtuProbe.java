package com.tencent.mobileqq.highway.netprobe;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MtuProbe
  extends ProbeItem
{
  private static final int MAX_MTU = 1472;
  private static final int MIN_MTU = 56;
  private static final int[] MTU_COMMON_VALUES = { 1390, 1400, 1492 };
  private static final int PACKAGE_RECEIVED_INDEX = 2;
  private static final Pattern PING_RESULT_PATTERN = Pattern.compile("---\\n(\\d+) packets transmitted, (\\d+)[\\s\\S]* received, (\\d+).*");
  public static final String PROBE_NAME = "Mtu_Probe";
  public static final int RESULT_BLOCKING_CONNECT = 1;
  public static final int RESULT_OK = 0;
  private String mPeerIp;
  
  private int findMaxMtu()
  {
    int j = 56;
    int i = 1472;
    int k = 0;
    Object localObject;
    int m;
    int n;
    for (;;)
    {
      localObject = MTU_COMMON_VALUES;
      m = j;
      n = i;
      if (k >= localObject.length) {
        break;
      }
      int i1 = localObject[k] - 28;
      localObject = PingProbe.execPing(3, 10, i1, this.mPeerIp);
      if (localObject == null) {
        return -1;
      }
      if (!isSuccess((String)localObject))
      {
        m = j;
        n = i;
        if (i1 < i)
        {
          n = i1;
          m = j;
        }
      }
      else if (i1 < j)
      {
        m = j;
        n = i;
      }
      else
      {
        m = i1;
        n = i;
      }
      k += 1;
      j = m;
      i = n;
    }
    while (m < n)
    {
      double d = (m + n) / 2.0F;
      Double.isNaN(d);
      i = (int)(d + 0.5D);
      localObject = PingProbe.execPing(3, 10, i, this.mPeerIp);
      if (localObject == null) {
        return -1;
      }
      if (isSuccess((String)localObject)) {
        m = i;
      } else {
        n = i - 1;
      }
    }
    return m + 28;
  }
  
  public void doProbe()
  {
    this.mPeerIp = this.mRequest.getIp();
    if (isConnecting())
    {
      onFinish(0, Integer.valueOf(findMaxMtu()));
      return;
    }
    onFinish(1, null);
  }
  
  public String getProbeName()
  {
    return "Mtu_Probe";
  }
  
  public int getRecvPkgNum(String paramString)
  {
    if ((paramString == null) && (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    paramString = PING_RESULT_PATTERN.matcher(paramString);
    if ((paramString != null) && (paramString.find()) && (paramString.groupCount() == 3)) {
      return Integer.valueOf(paramString.group(2)).intValue();
    }
    return -1;
  }
  
  public boolean isConnecting()
  {
    return isSuccess(PingProbe.execPing(56, this.mPeerIp));
  }
  
  public boolean isSuccess(String paramString)
  {
    return getRecvPkgNum(paramString) > 0;
  }
  
  public void onFinish(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      paramObject = this.mResult;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("the ip ");
      ((StringBuilder)localObject).append(this.mPeerIp);
      ((StringBuilder)localObject).append(" can't transmit package!");
      paramObject.errDesc = ((StringBuilder)localObject).toString();
      this.mResult.success = false;
      this.mResult.errCode = 1;
      return;
    }
    Object localObject = this.mResult;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("successful find the max mtu : ");
    localStringBuilder.append((Integer)paramObject);
    ((ProbeItem.ProbeResult)localObject).appendResult(localStringBuilder.toString());
    this.mResult.success = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.MtuProbe
 * JD-Core Version:    0.7.0.1
 */