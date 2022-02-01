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
import oicq.wlogin_sdk.tlv_type.tlv_t178;
import oicq.wlogin_sdk.tlv_type.tlv_t179;
import oicq.wlogin_sdk.tlv_type.tlv_t17d;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import oicq.wlogin_sdk.tlv_type.tlv_t184;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
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
  
  public int a(WUserSigInfo paramWUserSigInfo)
  {
    int i = 0;
    for (;;)
    {
      Object localObject = a(paramWUserSigInfo.extraLoginTLVMap);
      a(this.x.f, (byte[])localObject, this.y);
      int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (j != 0) {
        return j;
      }
      j = b();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("quickLoginByGateway.request_login_by_gateway,retry num:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",ret:");
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
  
  public byte[] a(Map<Integer, tlv_t> paramMap)
  {
    Object localObject2 = new int[7];
    Object tmp8_6 = localObject2;
    tmp8_6[0] = 256;
    Object tmp14_8 = tmp8_6;
    tmp14_8[1] = 322;
    Object tmp20_14 = tmp14_8;
    tmp20_14[2] = 325;
    Object tmp26_20 = tmp20_14;
    tmp26_20[3] = 387;
    Object tmp32_26 = tmp26_20;
    tmp32_26[4] = 388;
    Object tmp38_32 = tmp32_26;
    tmp38_32[5] = 1331;
    Object tmp44_38 = tmp38_32;
    tmp44_38[6] = 1313;
    tmp44_38;
    ArrayList localArrayList = new ArrayList();
    int i1 = localObject2.length;
    StringBuilder localStringBuilder = new StringBuilder("quickLoginByGateway.request_login_by_gateway");
    localStringBuilder.append(" getRequestBody");
    Object localObject3 = t.b(this.x.h);
    int k = 0;
    int j = 0;
    Object localObject1;
    for (int i = 0; k < i1; i = m)
    {
      localObject1 = new byte[0];
      m = localObject2[k];
      if (m != 256)
      {
        if (m != 322) {
          if (m != 325) {
            if (m != 1313) {
              if (m != 387) {
                if (m != 388) {
                  break label481;
                }
              }
            }
          }
        }
        for (;;)
        {
          Object localObject4 = new tlv_t184();
          localObject1 = ((tlv_t184)localObject4).get_tlv_184(((async_context)localObject3)._msalt, ((async_context)localObject3)._mpasswd);
          localStringBuilder.append(",_mS2=");
          localStringBuilder.append(((tlv_t184)localObject4).get_data_len());
          break;
          localObject1 = new tlv_t183().get_tlv_183(((async_context)localObject3)._msalt);
          localStringBuilder.append(",_msalt=");
          localStringBuilder.append(((async_context)localObject3)._msalt);
          continue;
          localObject1 = new tlv_t(1313);
          localObject4 = new byte[6];
          util.int32_to_buf((byte[])localObject4, 0, t.aA);
          util.int16_to_buf((byte[])localObject4, 4, 0);
          ((tlv_t)localObject1).set_data((byte[])localObject4, 6);
          localObject1 = ((tlv_t)localObject1).get_buf();
          localStringBuilder.append(",_productType=");
          localStringBuilder.append(t.aA);
          continue;
          localObject1 = new tlv_t145().get_tlv_145(t.B);
          localStringBuilder.append(",guid=");
          localStringBuilder.append(new String(t.B));
          continue;
          localObject1 = new tlv_t142().get_tlv_142(t.F);
          localStringBuilder.append(",apk_id=");
          localStringBuilder.append(new String(t.F));
        }
      }
      else
      {
        localObject1 = new tlv_t100().get_tlv_100(((async_context)localObject3)._appid, ((async_context)localObject3)._sub_appid, 0, ((async_context)localObject3)._main_sigmap);
        localStringBuilder.append(",appid=");
        localStringBuilder.append(((async_context)localObject3)._appid);
        localStringBuilder.append(",subAppid=");
        localStringBuilder.append(((async_context)localObject3)._sub_appid);
      }
      label481:
      int n = j;
      m = i;
      if (localObject1.length > 4)
      {
        n = j + 1;
        m = i + localObject1.length;
        localArrayList.add(localObject1);
      }
      k += 1;
      j = n;
    }
    k = j;
    int m = i;
    if (paramMap != null)
    {
      localObject1 = paramMap.keySet().iterator();
      for (;;)
      {
        k = j;
        m = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (Integer)((Iterator)localObject1).next();
        localObject3 = (tlv_t)paramMap.get(localObject2);
        if (localObject3 != null)
        {
          localObject3 = ((tlv_t)localObject3).get_buf();
          j += 1;
          localArrayList.add(localObject3);
          i += localObject3.length;
          localStringBuilder.append(",key=");
          localStringBuilder.append(localObject2);
          localStringBuilder.append(",Buff=");
          localStringBuilder.append(localObject3.length);
        }
      }
    }
    paramMap = new byte[m];
    i = 0;
    j = 0;
    while (i < k)
    {
      localObject1 = (byte[])localArrayList.get(i);
      System.arraycopy(localObject1, 0, paramMap, j, localObject1.length);
      j += localObject1.length;
      i += 1;
    }
    localStringBuilder.append(",tlvCnt=");
    localStringBuilder.append(k);
    util.LOGI(localStringBuilder.toString(), "");
    return b(paramMap, this.u, k);
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 5) {
      return -1009;
    }
    async_context localasync_context = t.b(this.x.h);
    paramInt2 = c(paramArrayOfByte, paramInt1 + 2);
    int i = paramInt1 + 5;
    Object localObject1 = new tlv_t543();
    paramInt1 = ((tlv_t543)localObject1).get_tlv(paramArrayOfByte, i, this.c - i);
    localasync_context._t543 = ((tlv_t543)localObject1);
    localObject1 = new StringBuilder("quickLoginByGateway.request_login_by_gateway");
    ((StringBuilder)localObject1).append(",get_response_body ret=");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(",ret543=");
    ((StringBuilder)localObject1).append(paramInt1);
    paramInt1 = paramInt2;
    if (paramInt2 == 0)
    {
      localObject2 = new tlv_t113();
      paramInt1 = ((tlv_t113)localObject2).get_tlv(paramArrayOfByte, i, this.c - i - 1);
      ((StringBuilder)localObject1).append(",ret113=");
      ((StringBuilder)localObject1).append(paramInt1);
      if (paramInt1 >= 0)
      {
        this.x.f = ((tlv_t113)localObject2).get_uin();
        localasync_context._uin = this.x.f;
        paramInt1 = 0;
      }
      else
      {
        paramInt1 = -2004;
      }
    }
    Object localObject2 = new tlv_t104();
    paramInt2 = ((tlv_t104)localObject2).get_tlv(paramArrayOfByte, i, this.c - i);
    ((StringBuilder)localObject1).append(",ret104=");
    ((StringBuilder)localObject1).append(paramInt2);
    if (paramInt2 >= 0) {
      localasync_context._t104 = ((tlv_t104)localObject2);
    }
    a(paramArrayOfByte, i, new tlv_t178(), new tlv_t179(), new tlv_t17d(), localasync_context);
    util.LOGI(((StringBuilder)localObject1).toString(), "");
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.request.u
 * JD-Core Version:    0.7.0.1
 */