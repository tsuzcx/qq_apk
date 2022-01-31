package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t174;
import oicq.wlogin_sdk.tlv_type.tlv_t17c;
import oicq.wlogin_sdk.tlv_type.tlv_t401;
import oicq.wlogin_sdk.tlv_type.tlv_t402;
import oicq.wlogin_sdk.tlv_type.tlv_t403;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class o
  extends oicq_request
{
  public o(t paramt)
  {
    this.t = 2064;
    this.u = 7;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.w;
    async_context localasync_context = t.b(this.x.h);
    tlv_t104 localtlv_t104 = localasync_context._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    for (;;)
    {
      tlv_t174 localtlv_t174 = localasync_context._t174;
      if (localtlv_t174 == null) {
        localtlv_t174 = new tlv_t174();
      }
      for (;;)
      {
        Object localObject2 = localasync_context._t402;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new tlv_t402();
        }
        tlv_t403 localtlv_t403 = localasync_context._t403;
        localObject2 = localtlv_t403;
        if (localtlv_t403 == null) {
          localObject2 = new tlv_t403();
        }
        localasync_context._dpwd = util.get_mpasswd().getBytes();
        localasync_context._G = c(t.A, localasync_context._dpwd, ((tlv_t402)localObject1).get_data());
        if ((((tlv_t402)localObject1).get_data_len() > 0) && (((tlv_t403)localObject2).get_data_len() > 0)) {
          localasync_context._sec_guid_flag = true;
        }
        int i = 0;
        for (;;)
        {
          localObject1 = a(localtlv_t104.get_data(), paramArrayOfByte, localtlv_t174.get_data(), paramInt1, paramInt2, paramArrayOfLong, localasync_context._G);
          a(this.i, this.t, this.j, this.x.f, this.m, this.n, j, this.p, (byte[])localObject1);
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
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, long[] paramArrayOfLong, byte[] paramArrayOfByte4)
  {
    int[] arrayOfInt = new int[7];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 8;
    int[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 260;
    int[] tmp19_13 = tmp13_8;
    tmp19_13[2] = 278;
    int[] tmp25_19 = tmp19_13;
    tmp25_19[3] = 372;
    int[] tmp31_25 = tmp25_19;
    tmp31_25[4] = 380;
    int[] tmp37_31 = tmp31_25;
    tmp37_31[5] = 1025;
    int[] tmp43_37 = tmp37_31;
    tmp43_37[6] = 408;
    tmp43_37;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if (j < arrayOfInt.length)
    {
      Object localObject = null;
      switch (arrayOfInt[j])
      {
      }
      for (;;)
      {
        int k = i;
        if (localObject != null)
        {
          localArrayList.add(localObject);
          k = i + localObject.length;
        }
        j += 1;
        i = k;
        break;
        localObject = new tlv_t8().get_tlv_8(0, t.u, 0);
        continue;
        localObject = new tlv_t104().get_tlv_104(paramArrayOfByte1);
        continue;
        localObject = new tlv_t116().get_tlv_116(paramInt1, paramInt2, paramArrayOfLong);
        continue;
        localObject = new tlv_t174().get_tlv_174(paramArrayOfByte3);
        continue;
        localObject = new tlv_t17c().get_tlv_17c(paramArrayOfByte2);
        continue;
        localObject = new tlv_t401().get_tlv_401(paramArrayOfByte4);
        continue;
        localObject = new tlv_t(408);
        ((tlv_t)localObject).set_data(new byte[] { (byte)r.K }, 1);
        localObject = ((tlv_t)localObject).get_buf();
      }
    }
    j = localArrayList.size();
    paramArrayOfByte1 = new byte[i];
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      paramArrayOfByte2 = (byte[])localArrayList.get(paramInt1);
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt2, paramArrayOfByte2.length);
      paramInt2 += paramArrayOfByte2.length;
      paramInt1 += 1;
    }
    return b(paramArrayOfByte1, this.u, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.o
 * JD-Core Version:    0.7.0.1
 */