package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
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
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class v
  extends oicq_request
{
  public v(t paramt)
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
      Object localObject = a(paramArrayOfByte1, paramArrayOfByte2, paramWUserSigInfo.extraLoginTLVMap);
      a(this.x.f, (byte[])localObject, this.y);
      int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (j != 0) {
        return j;
      }
      j = b();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("retry num:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" ret:");
      ((StringBuilder)localObject).append(j);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.x.f);
      util.LOGI((String)localObject, localStringBuilder.toString());
      if (j != 180) {
        return j;
      }
      if (i >= 1) {
        return j;
      }
      i += 1;
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, Map<Integer, tlv_t> paramMap)
  {
    int[] arrayOfInt = new int[7];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 256;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 322;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 325;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 387;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 388;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 1331;
    int[] tmp44_38 = tmp38_32;
    tmp44_38[6] = 1313;
    tmp44_38;
    ArrayList localArrayList = new ArrayList();
    int i1 = arrayOfInt.length;
    async_context localasync_context = t.b(this.x.h);
    int k = 0;
    int j = 0;
    for (int i = 0; k < i1; i = m)
    {
      Object localObject = new byte[0];
      m = arrayOfInt[k];
      if (m != 256)
      {
        if (m != 322) {
          if (m != 325) {
            if (m != 1313) {
              if (m != 1331) {
                if (m != 387) {
                  if (m != 388) {
                    break label344;
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          localObject = new tlv_t184().get_tlv_184(localasync_context._msalt, localasync_context._mpasswd);
          continue;
          localObject = new tlv_t183().get_tlv_183(localasync_context._msalt);
          continue;
          localObject = new tlv_t533().get_tlv_533(paramArrayOfByte1, paramArrayOfByte2);
          continue;
          localObject = new tlv_t(1313);
          byte[] arrayOfByte = new byte[6];
          util.int32_to_buf(arrayOfByte, 0, t.aA);
          util.int16_to_buf(arrayOfByte, 4, 0);
          ((tlv_t)localObject).set_data(arrayOfByte, 6);
          localObject = ((tlv_t)localObject).get_buf();
          continue;
          localObject = new tlv_t145().get_tlv_145(t.B);
          continue;
          localObject = new tlv_t142().get_tlv_142(t.F);
        }
      }
      else
      {
        localObject = new tlv_t100().get_tlv_100(localasync_context._appid, localasync_context._sub_appid, 0, localasync_context._main_sigmap);
      }
      label344:
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
    k = j;
    int m = i;
    if (paramMap != null)
    {
      paramArrayOfByte1 = paramMap.keySet().iterator();
      for (;;)
      {
        k = j;
        m = i;
        if (!paramArrayOfByte1.hasNext()) {
          break;
        }
        paramArrayOfByte2 = (tlv_t)paramMap.get((Integer)paramArrayOfByte1.next());
        if (paramArrayOfByte2 != null)
        {
          paramArrayOfByte2 = paramArrayOfByte2.get_buf();
          j += 1;
          localArrayList.add(paramArrayOfByte2);
          i += paramArrayOfByte2.length;
        }
      }
    }
    paramArrayOfByte1 = new byte[m];
    i = 0;
    j = 0;
    while (i < k)
    {
      paramArrayOfByte2 = (byte[])localArrayList.get(i);
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, j, paramArrayOfByte2.length);
      j += paramArrayOfByte2.length;
      i += 1;
    }
    return b(paramArrayOfByte1, this.u, k);
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 5) {
      return -1009;
    }
    Object localObject3 = new tlv_t104();
    tlv_t113 localtlv_t113 = new tlv_t113();
    Object localObject1 = new tlv_t(1344);
    tlv_t541 localtlv_t541 = new tlv_t541();
    Object localObject2 = t.b(this.x.h);
    paramInt2 = c(paramArrayOfByte, paramInt1 + 2);
    int i = paramInt1 + 5;
    this.x.d = null;
    if (paramInt2 != 0)
    {
      if (paramInt2 != 230)
      {
        c(paramArrayOfByte, i, this.c - i - 1);
        paramInt1 = paramInt2;
      }
      else
      {
        localObject3 = new tlv_t543();
        paramInt1 = ((tlv_t543)localObject3).get_tlv(paramArrayOfByte, i, this.c - i);
        if (paramInt1 > 0)
        {
          ((async_context)localObject2)._t543 = ((tlv_t543)localObject3);
          paramInt1 = ((tlv_t)localObject1).get_tlv(paramArrayOfByte, i, this.c - i);
          if (paramInt1 > 0)
          {
            ((async_context)localObject2).tlv540 = ((tlv_t)localObject1);
            paramInt1 = 230;
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(this.x.f);
            util.LOGI("request_login_by_wechat ret oxe6 t540 is null subCmd= 0x17", ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(this.x.f);
          util.LOGI("request_login_by_wechat ret oxe6 t543 is null subCmd= 0x17", ((StringBuilder)localObject1).toString());
        }
      }
    }
    else
    {
      paramInt1 = ((tlv_t104)localObject3).get_tlv(paramArrayOfByte, i, this.c - i);
      if (paramInt1 >= 0)
      {
        ((async_context)localObject2)._t104 = ((tlv_t104)localObject3);
        if (((tlv_t)localObject1).get_tlv(paramArrayOfByte, i, this.c - i) > 0)
        {
          ((async_context)localObject2).tlv540 = ((tlv_t)localObject1);
          if (localtlv_t541.get_tlv(paramArrayOfByte, i, this.c - i - 1) >= 0) {
            ((async_context)localObject2)._weixinUserFlags = localtlv_t541.get_flags();
          }
          if (localtlv_t113.get_tlv(paramArrayOfByte, i, this.c - i - 1) >= 0)
          {
            this.x.f = localtlv_t113.get_uin();
            ((async_context)localObject2)._uin = this.x.f;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(this.x.f);
            util.LOGI("request_login_by_wechat get_response_body subCmd= 0x17 success", ((StringBuilder)localObject1).toString());
            paramInt1 = 0;
          }
          else
          {
            paramInt1 = -2003;
          }
        }
        else
        {
          paramInt1 = -2002;
        }
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("request_login_by_wechat type:");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(" ret:");
    if (paramInt1 > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0x");
      ((StringBuilder)localObject1).append(Integer.toHexString(paramInt1));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = Integer.valueOf(paramInt1);
    }
    ((StringBuilder)localObject2).append(localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.x.f);
    util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
    if (paramInt1 == 0)
    {
      a(null);
    }
    else
    {
      new tlv_t508().get_tlv(paramArrayOfByte, i, this.c - i - 1);
      if (tlv_t508.doFetch)
      {
        paramArrayOfByte = new ErrMsg();
        paramInt2 = new h(this.x, this.t, this.u, paramArrayOfByte).b(paramInt1);
        if (paramInt2 != -1000)
        {
          a(paramArrayOfByte);
          paramInt1 = paramInt2;
        }
      }
    }
    if ((paramInt1 != 10) && (paramInt1 != 161) && (paramInt1 != 162) && (paramInt1 != 164) && (paramInt1 != 165) && (paramInt1 != 166) && (paramInt1 != 154))
    {
      paramInt2 = paramInt1;
      if (paramInt1 >= 128)
      {
        paramInt2 = paramInt1;
        if (paramInt1 > 143) {}
      }
    }
    else
    {
      paramInt2 = -1000;
    }
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.v
 * JD-Core Version:    0.7.0.1
 */