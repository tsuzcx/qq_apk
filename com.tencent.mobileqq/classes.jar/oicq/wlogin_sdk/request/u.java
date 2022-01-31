package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t113;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import oicq.wlogin_sdk.tlv_type.tlv_t184;
import oicq.wlogin_sdk.tlv_type.tlv_t508;
import oicq.wlogin_sdk.tlv_type.tlv_t533;
import oicq.wlogin_sdk.tlv_type.tlv_t541;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class u
  extends oicq_request
{
  public u(t paramt)
  {
    this.t = 2064;
    this.u = 23;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, WUserSigInfo paramWUserSigInfo)
  {
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = c(paramArrayOfByte1, paramArrayOfByte2);
      a(this.x.f, arrayOfByte, this.y);
      int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (j != 0) {
        return j;
      }
      j = b();
      util.LOGI("retry num:" + i + " ret:" + j, "" + this.x.f);
      if (j != 180) {
        return j;
      }
      if (i >= 1) {
        return j;
      }
      i += 1;
    }
  }
  
  public byte[] c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    int[] arrayOfInt = new int[7];
    int[] tmp10_8 = arrayOfInt;
    tmp10_8[0] = 256;
    int[] tmp16_10 = tmp10_8;
    tmp16_10[1] = 322;
    int[] tmp22_16 = tmp16_10;
    tmp22_16[2] = 325;
    int[] tmp28_22 = tmp22_16;
    tmp28_22[3] = 387;
    int[] tmp34_28 = tmp28_22;
    tmp34_28[4] = 388;
    int[] tmp40_34 = tmp34_28;
    tmp40_34[5] = 1331;
    int[] tmp46_40 = tmp40_34;
    tmp46_40[6] = 1313;
    tmp46_40;
    ArrayList localArrayList = new ArrayList();
    int m = arrayOfInt.length;
    int j = 0;
    async_context localasync_context = t.b(this.x.h);
    int k = 0;
    Object localObject;
    if (k < m)
    {
      localObject = new byte[0];
      switch (arrayOfInt[k])
      {
      default: 
        label168:
        if (localObject.length > 4)
        {
          int n = localObject.length;
          localArrayList.add(localObject);
          j = n + j;
          i += 1;
        }
        break;
      }
    }
    for (;;)
    {
      k += 1;
      break;
      localObject = new tlv_t100().get_tlv_100(localasync_context._appid, localasync_context._sub_appid, 0, localasync_context._main_sigmap);
      break label168;
      localObject = new tlv_t142().get_tlv_142(t.E);
      break label168;
      localObject = new tlv_t145().get_tlv_145(t.A);
      break label168;
      localObject = new tlv_t183().get_tlv_183(localasync_context._msalt);
      break label168;
      localObject = new tlv_t184().get_tlv_184(localasync_context._msalt, localasync_context._mpasswd);
      break label168;
      localObject = new tlv_t533().get_tlv_533(paramArrayOfByte1, paramArrayOfByte2);
      break label168;
      localObject = new tlv_t(1313);
      byte[] arrayOfByte = new byte[6];
      util.int32_to_buf(arrayOfByte, 0, t.az);
      util.int16_to_buf(arrayOfByte, 4, 0);
      ((tlv_t)localObject).set_data(arrayOfByte, 6);
      localObject = ((tlv_t)localObject).get_buf();
      break label168;
      paramArrayOfByte1 = new byte[j];
      k = 0;
      j = 0;
      while (j < i)
      {
        paramArrayOfByte2 = (byte[])localArrayList.get(j);
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, k, paramArrayOfByte2.length);
        k += paramArrayOfByte2.length;
        j += 1;
      }
      return b(paramArrayOfByte1, this.u, i);
    }
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 5)
    {
      paramInt1 = -1009;
      return paramInt1;
    }
    Object localObject1 = new tlv_t104();
    Object localObject2 = new tlv_t113();
    tlv_t localtlv_t = new tlv_t(1344);
    tlv_t541 localtlv_t541 = new tlv_t541();
    async_context localasync_context = t.b(this.x.h);
    paramInt2 = c(paramArrayOfByte, paramInt1 + 2);
    int j = paramInt1 + 5;
    this.x.d = null;
    switch (paramInt2)
    {
    default: 
      c(paramArrayOfByte, j, this.c - j - 1);
      paramInt1 = paramInt2;
      label130:
      localObject2 = new StringBuilder().append("request_login_by_wechat type:").append(paramInt2).append(" ret:");
      if (paramInt1 > 0)
      {
        localObject1 = "0x" + Integer.toHexString(paramInt1);
        label181:
        util.LOGI(localObject1, "" + this.x.f);
        if (paramInt1 != 0) {
          break label558;
        }
        a(null);
        paramInt2 = paramInt1;
      }
      break;
    }
    for (;;)
    {
      if ((paramInt2 != 10) && (paramInt2 != 161) && (paramInt2 != 162) && (paramInt2 != 164) && (paramInt2 != 165) && (paramInt2 != 166) && (paramInt2 != 154))
      {
        paramInt1 = paramInt2;
        if (paramInt2 < 128) {
          break;
        }
        paramInt1 = paramInt2;
        if (paramInt2 > 143) {
          break;
        }
      }
      return -1000;
      int i = ((tlv_t104)localObject1).get_tlv(paramArrayOfByte, j, this.c - j);
      paramInt1 = i;
      if (i < 0) {
        break label130;
      }
      localasync_context._t104 = ((tlv_t104)localObject1);
      if (localtlv_t.get_tlv(paramArrayOfByte, j, this.c - j) > 0)
      {
        localasync_context.tlv540 = localtlv_t;
        if (localtlv_t541.get_tlv(paramArrayOfByte, j, this.c - j - 1) >= 0) {
          localasync_context._weixinUserFlags = localtlv_t541.get_flags();
        }
        if (((tlv_t113)localObject2).get_tlv(paramArrayOfByte, j, this.c - j - 1) < 0) {
          break label474;
        }
        this.x.f = ((tlv_t113)localObject2).get_uin();
        localasync_context._uin = this.x.f;
        util.LOGI("request_login_by_wechat get_response_body subCmd= 0x17 success", "" + this.x.f);
        paramInt1 = 0;
        break label130;
      }
      paramInt1 = -2002;
      break label130;
      label474:
      paramInt1 = -2003;
      break label130;
      paramInt1 = localtlv_t.get_tlv(paramArrayOfByte, j, this.c - j);
      if (paramInt1 > 0)
      {
        localasync_context.tlv540 = localtlv_t;
        paramInt1 = 230;
        break label130;
      }
      util.LOGI("request_login_by_wechat ret oxe6 t540 is null subCmd= 0x17", "" + this.x.f);
      break label130;
      localObject1 = Integer.valueOf(paramInt1);
      break label181;
      label558:
      new tlv_t508().get_tlv(paramArrayOfByte, j, this.c - j - 1);
      paramInt2 = paramInt1;
      if (tlv_t508.doFetch)
      {
        paramArrayOfByte = new ErrMsg();
        i = new h(this.x, this.t, this.u, paramArrayOfByte).b(paramInt1);
        paramInt2 = paramInt1;
        if (i != -1000)
        {
          a(paramArrayOfByte);
          paramInt2 = i;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.u
 * JD-Core Version:    0.7.0.1
 */