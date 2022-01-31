package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t109;
import oicq.wlogin_sdk.tlv_type.tlv_t112;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t154;
import oicq.wlogin_sdk.tlv_type.tlv_t52c;
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class w
  extends oicq_request
{
  public w(t paramt)
  {
    this.t = 2064;
    this.u = 17;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte, String paramString, int paramInt2, int paramInt3, long[] paramArrayOfLong, int paramInt4, long paramLong3, WUserSigInfo paramWUserSigInfo)
  {
    int m = t.w;
    byte[] arrayOfByte1;
    int i;
    if ((paramString == null) && (paramInt4 == 1))
    {
      arrayOfByte1 = t.al;
      i = 0;
    }
    for (;;)
    {
      byte[] arrayOfByte2;
      label32:
      int j;
      if (paramString == null)
      {
        arrayOfByte2 = null;
        arrayOfByte2 = a(paramLong1, paramLong2, paramInt1, m, paramArrayOfByte, arrayOfByte2, paramInt4, paramLong3, arrayOfByte1, paramInt2, paramInt3, paramArrayOfLong, paramWUserSigInfo);
        a(this.i, this.t, this.j, this.x.f, this.m, this.n, m, this.p, arrayOfByte2);
        j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
        if (j == 0) {
          break label144;
        }
      }
      label144:
      do
      {
        int k;
        do
        {
          return j;
          arrayOfByte1 = null;
          break;
          arrayOfByte2 = paramString.getBytes();
          break label32;
          k = b();
          util.LOGI("retry num:" + i + " extra:" + paramLong3 + " ret:" + k, "" + this.x.f);
          j = k;
        } while (k != 180);
        j = k;
      } while (i >= 1);
      i += 1;
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, long paramLong3, byte[] paramArrayOfByte3, int paramInt4, int paramInt5, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = 0;
    int[] arrayOfInt;
    ArrayList localArrayList;
    int i;
    int k;
    label117:
    Object localObject2;
    Object localObject1;
    label252:
    int m;
    if (paramArrayOfByte2 == null) {
      if (paramInt3 == 1)
      {
        arrayOfInt = new int[] { 256, 260, 264, 265, 1325, 8, 322, 325, 340, 1324, 278, 1313 };
        localArrayList = new ArrayList();
        int n = arrayOfInt.length;
        i = 0;
        k = 0;
        if (k >= n) {
          break label897;
        }
        localObject2 = new byte[0];
        switch (arrayOfInt[k])
        {
        default: 
          localObject1 = localObject2;
          if (localObject1.length > 4)
          {
            j += 1;
            m = localObject1.length;
            localArrayList.add(localObject1);
            m += i;
            i = j;
            j = m;
          }
          break;
        }
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
          m = arrayOfByte.length;
          util.LOGI("Extra Tlv from user：0x" + localObject2);
          j = m + j;
          continue;
          arrayOfInt = new int[] { 256, 264, 265, 1325, 8, 322, 325, 340, 1324, 278, 1313 };
          break;
          arrayOfInt = new int[] { 256, 264, 265, 1325, 8, 322, 325, 340, 274, 278, 1313 };
          break;
          localObject1 = new tlv_t100().get_tlv_100(paramLong1, paramLong2, paramInt2, paramInt1);
          break label252;
          localObject1 = new tlv_t104().get_tlv_104(paramArrayOfByte3);
          break label252;
          localObject1 = localObject2;
          if (paramArrayOfByte1 == null) {
            break label252;
          }
          localObject1 = localObject2;
          if (paramArrayOfByte1.length <= 0) {
            break label252;
          }
          localObject1 = new tlv_t108().get_tlv_108(paramArrayOfByte1);
          break label252;
          localObject1 = localObject2;
          if (t.O == null) {
            break label252;
          }
          localObject1 = localObject2;
          if (t.O.length <= 0) {
            break label252;
          }
          localObject1 = new tlv_t109().get_tlv_109(t.O);
          break label252;
          localObject1 = new tlv_t52d().get_tlv_52d(this.a);
          break label252;
          localObject1 = new tlv_t8().get_tlv_8(0, t.u, 0);
          break label252;
          localObject1 = new tlv_t142().get_tlv_142(t.E);
          break label252;
          localObject1 = new tlv_t145().get_tlv_145(t.A);
          break label252;
          localObject1 = new tlv_t154().get_tlv_154(this.x.i);
          break label252;
          localObject1 = new tlv_t112().get_tlv_112(paramArrayOfByte2);
          break label252;
          localObject1 = new tlv_t116().get_tlv_116(paramInt4, paramInt5, paramArrayOfLong);
          break label252;
          localObject1 = new tlv_t(1313);
          localObject2 = new byte[6];
          util.int32_to_buf((byte[])localObject2, 0, t.az);
          util.int16_to_buf((byte[])localObject2, 4, 0);
          ((tlv_t)localObject1).set_data((byte[])localObject2, 6);
          localObject1 = ((tlv_t)localObject1).get_buf();
          break label252;
          localObject1 = new tlv_t52c().get_tlv_52c(paramInt3, paramLong3);
          break label252;
        }
      }
      m = k + 1;
      k = i;
      i = j;
      j = k;
      k = m;
      break label117;
      label897:
      paramArrayOfByte1 = (tlv_t)paramWUserSigInfo._loginExtraProductTLVMap.get(Integer.valueOf(1322));
      paramInt2 = i;
      paramInt1 = j;
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1 = paramArrayOfByte1.get_buf();
        paramInt1 = j + 1;
        paramInt2 = i + paramArrayOfByte1.length;
        localArrayList.add(paramArrayOfByte1);
      }
      paramArrayOfByte1 = new byte[paramInt2];
      paramInt3 = 0;
      paramInt2 = 0;
      while (paramInt2 < paramInt1)
      {
        paramArrayOfByte2 = (byte[])localArrayList.get(paramInt2);
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt3, paramArrayOfByte2.length);
        paramInt3 += paramArrayOfByte2.length;
        paramInt2 += 1;
      }
      return b(paramArrayOfByte1, this.u, paramInt1);
      m = j;
      j = i;
      i = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.w
 * JD-Core Version:    0.7.0.1
 */