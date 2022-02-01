package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import java.util.HashMap;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class y
  extends oicq_request
{
  public y(t paramt)
  {
    this.t = 2064;
    this.u = 19;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  private byte[] b(int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int[] arrayOfInt = new int[4];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = 260;
    int[] tmp13_7 = tmp7_5;
    tmp13_7[1] = 8;
    int[] tmp18_13 = tmp13_7;
    tmp18_13[2] = 278;
    int[] tmp24_18 = tmp18_13;
    tmp24_18[3] = 1313;
    tmp24_18;
    ArrayList localArrayList = new ArrayList();
    int i1 = arrayOfInt.length;
    async_context localasync_context = t.b(this.x.h);
    int k = 0;
    int j = 0;
    int m;
    for (int i = 0; k < i1; i = m)
    {
      Object localObject = new byte[0];
      m = arrayOfInt[k];
      if (m != 8)
      {
        if (m != 260)
        {
          if (m != 278)
          {
            if (m == 1313) {
              for (;;)
              {
                localObject = new tlv_t(1313);
                byte[] arrayOfByte = new byte[6];
                util.int32_to_buf(arrayOfByte, 0, t.aA);
                util.int16_to_buf(arrayOfByte, 4, 0);
                ((tlv_t)localObject).set_data(arrayOfByte, 6);
                localObject = ((tlv_t)localObject).get_buf();
              }
            }
          }
          else {
            localObject = new tlv_t116().get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
          }
        }
        else {
          localObject = localasync_context._t104.get_buf();
        }
      }
      else {
        localObject = new tlv_t8().get_tlv_8(0, t.v, 0);
      }
      int n = j;
      m = i;
      if (localObject.length > 4)
      {
        n = j + 1;
        m = i + localObject.length;
        localArrayList.add(localObject);
      }
      k += 1;
      j = n;
    }
    paramArrayOfLong = (tlv_t)paramWUserSigInfo._loginExtraProductTLVMap.get(Integer.valueOf(1322));
    paramInt1 = j;
    paramInt2 = i;
    if (paramArrayOfLong != null)
    {
      paramArrayOfLong = paramArrayOfLong.get_buf();
      paramInt1 = j + 1;
      paramInt2 = i + paramArrayOfLong.length;
      localArrayList.add(paramArrayOfLong);
    }
    paramArrayOfLong = new byte[paramInt2];
    paramInt2 = 0;
    i = 0;
    while (paramInt2 < paramInt1)
    {
      paramWUserSigInfo = (byte[])localArrayList.get(paramInt2);
      System.arraycopy(paramWUserSigInfo, 0, paramArrayOfLong, i, paramWUserSigInfo.length);
      i += paramWUserSigInfo.length;
      paramInt2 += 1;
    }
    return b(paramArrayOfLong, this.u, paramInt1);
  }
  
  public int a(int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.x;
    int i = 0;
    for (;;)
    {
      Object localObject = b(paramInt1, paramInt2, paramArrayOfLong, paramWUserSigInfo);
      a(this.i, this.t, this.j, this.x.f, this.m, this.n, j, this.p, (byte[])localObject);
      int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (k != 0) {
        return k;
      }
      k = b();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("retry num:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" ret:");
      ((StringBuilder)localObject).append(k);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.x.f);
      util.LOGI((String)localObject, localStringBuilder.toString());
      if (k != 180) {
        return k;
      }
      if (i >= 1) {
        return k;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.y
 * JD-Core Version:    0.7.0.1
 */