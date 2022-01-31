package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t109;
import oicq.wlogin_sdk.tlv_type.tlv_t112;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t154;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class v
  extends oicq_request
{
  public v(t paramt)
  {
    this.t = 2064;
    this.u = 17;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte, String paramString, int paramInt2, int paramInt3, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.w;
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = a(paramLong1, paramLong2, paramInt1, j, paramArrayOfByte, paramString.getBytes(), paramInt2, paramInt3, paramArrayOfLong, paramWUserSigInfo);
      a(this.i, this.t, this.j, this.x.f, this.m, this.n, j, this.p, arrayOfByte);
      int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (k != 0) {
        return k;
      }
      k = b();
      util.LOGI("retry num:" + i + " ret:" + k, "" + this.x.f);
      if (k != 180) {
        return k;
      }
      if (i >= 1) {
        return k;
      }
      i += 1;
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int i = 0;
    int[] arrayOfInt = new int[10];
    int[] tmp11_9 = arrayOfInt;
    tmp11_9[0] = 256;
    int[] tmp17_11 = tmp11_9;
    tmp17_11[1] = 264;
    int[] tmp23_17 = tmp17_11;
    tmp23_17[2] = 265;
    int[] tmp29_23 = tmp23_17;
    tmp29_23[3] = 8;
    int[] tmp34_29 = tmp29_23;
    tmp34_29[4] = 322;
    int[] tmp40_34 = tmp34_29;
    tmp40_34[5] = 325;
    int[] tmp46_40 = tmp40_34;
    tmp46_40[6] = 340;
    int[] tmp53_46 = tmp46_40;
    tmp53_46[7] = 274;
    int[] tmp60_53 = tmp53_46;
    tmp60_53[8] = 278;
    int[] tmp67_60 = tmp60_53;
    tmp67_60[9] = 1313;
    tmp67_60;
    ArrayList localArrayList = new ArrayList();
    int m = tmp11_9.length;
    int j = 0;
    int k = 0;
    Object localObject2;
    Object localObject1;
    int n;
    if (k < m)
    {
      localObject2 = new byte[0];
      switch (tmp11_9[k])
      {
      default: 
        localObject1 = localObject2;
        if (localObject1.length > 4)
        {
          i += 1;
          n = localObject1.length;
          localArrayList.add(localObject1);
          j = n + j;
        }
        break;
      }
    }
    for (;;)
    {
      localObject1 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Integer)((Iterator)localObject1).next();
          byte[] arrayOfByte = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(localObject2)).get_buf();
          localArrayList.add(arrayOfByte);
          n = arrayOfByte.length;
          util.LOGI("Extra Tlv from user：0x" + localObject2);
          j = n + j;
          continue;
          localObject1 = new tlv_t100().get_tlv_100(paramLong1, paramLong2, paramInt2, paramInt1);
          break;
          localObject1 = localObject2;
          if (paramArrayOfByte1 == null) {
            break;
          }
          localObject1 = localObject2;
          if (paramArrayOfByte1.length <= 0) {
            break;
          }
          localObject1 = new tlv_t108().get_tlv_108(paramArrayOfByte1);
          break;
          localObject1 = localObject2;
          if (t.M == null) {
            break;
          }
          localObject1 = localObject2;
          if (t.M.length <= 0) {
            break;
          }
          localObject1 = new tlv_t109().get_tlv_109(t.M);
          break;
          localObject1 = new tlv_t8().get_tlv_8(0, t.u, 0);
          break;
          localObject1 = new tlv_t142().get_tlv_142(t.E);
          break;
          localObject1 = new tlv_t145().get_tlv_145(t.A);
          break;
          localObject1 = new tlv_t154().get_tlv_154(this.x.i);
          break;
          localObject1 = new tlv_t112().get_tlv_112(paramArrayOfByte2);
          break;
          localObject1 = new tlv_t116().get_tlv_116(paramInt3, paramInt4, paramArrayOfLong);
          break;
          localObject1 = new tlv_t(1313);
          localObject2 = new byte[6];
          util.int32_to_buf((byte[])localObject2, 0, t.au);
          util.int16_to_buf((byte[])localObject2, 4, 0);
          ((tlv_t)localObject1).set_data((byte[])localObject2, 6);
          localObject1 = ((tlv_t)localObject1).get_buf();
          break;
        }
      }
      k += 1;
      break;
      paramArrayOfByte1 = new byte[j];
      paramInt2 = 0;
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        paramArrayOfByte2 = (byte[])localArrayList.get(paramInt1);
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt2, paramArrayOfByte2.length);
        paramInt2 += paramArrayOfByte2.length;
        paramInt1 += 1;
      }
      return b(paramArrayOfByte1, this.u, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.v
 * JD-Core Version:    0.7.0.1
 */