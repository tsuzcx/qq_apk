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

public class x
  extends oicq_request
{
  public x(t paramt)
  {
    this.t = 2064;
    this.u = 17;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte, String paramString, int paramInt2, int paramInt3, long[] paramArrayOfLong, int paramInt4, long paramLong3, WUserSigInfo paramWUserSigInfo)
  {
    int k = t.x;
    byte[] arrayOfByte;
    if ((paramString == null) && (paramInt4 == 1)) {
      arrayOfByte = t.am;
    } else {
      arrayOfByte = null;
    }
    int j;
    for (int i = 0;; i = j)
    {
      if (paramString == null) {
        localObject = null;
      } else {
        localObject = paramString.getBytes();
      }
      Object localObject = a(paramLong1, paramLong2, paramInt1, k, paramArrayOfByte, (byte[])localObject, paramInt4, paramLong3, arrayOfByte, paramInt2, paramInt3, paramArrayOfLong, paramWUserSigInfo);
      a(this.i, this.t, this.j, this.x.f, this.m, this.n, k, this.p, (byte[])localObject);
      j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (j != 0) {
        return j;
      }
      int m = b();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("retry num:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" extra:");
      ((StringBuilder)localObject).append(paramLong3);
      ((StringBuilder)localObject).append(" ret:");
      ((StringBuilder)localObject).append(m);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.x.f);
      util.LOGI((String)localObject, localStringBuilder.toString());
      if (m != 180) {
        return m;
      }
      j = i + 1;
      if (i >= 1) {
        return m;
      }
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, long paramLong3, byte[] paramArrayOfByte3, int paramInt4, int paramInt5, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int[] arrayOfInt;
    if (paramArrayOfByte2 == null)
    {
      if (paramInt3 == 1)
      {
        arrayOfInt = new int[12];
        int[] tmp19_17 = arrayOfInt;
        tmp19_17[0] = 256;
        int[] tmp25_19 = tmp19_17;
        tmp25_19[1] = 260;
        int[] tmp31_25 = tmp25_19;
        tmp31_25[2] = 264;
        int[] tmp37_31 = tmp31_25;
        tmp37_31[3] = 265;
        int[] tmp43_37 = tmp37_31;
        tmp43_37[4] = 1325;
        int[] tmp49_43 = tmp43_37;
        tmp49_43[5] = 8;
        int[] tmp54_49 = tmp49_43;
        tmp54_49[6] = 322;
        int[] tmp61_54 = tmp54_49;
        tmp61_54[7] = 325;
        int[] tmp68_61 = tmp61_54;
        tmp68_61[8] = 340;
        int[] tmp75_68 = tmp68_61;
        tmp75_68[9] = 1324;
        int[] tmp82_75 = tmp75_68;
        tmp82_75[10] = 278;
        int[] tmp89_82 = tmp82_75;
        tmp89_82[11] = 1313;
        tmp89_82;
      }
      else
      {
        arrayOfInt = new int[11];
        int[] tmp108_106 = arrayOfInt;
        tmp108_106[0] = 256;
        int[] tmp114_108 = tmp108_106;
        tmp114_108[1] = 264;
        int[] tmp120_114 = tmp114_108;
        tmp120_114[2] = 265;
        int[] tmp126_120 = tmp120_114;
        tmp126_120[3] = 1325;
        int[] tmp132_126 = tmp126_120;
        tmp132_126[4] = 8;
        int[] tmp137_132 = tmp132_126;
        tmp137_132[5] = 322;
        int[] tmp143_137 = tmp137_132;
        tmp143_137[6] = 325;
        int[] tmp150_143 = tmp143_137;
        tmp150_143[7] = 340;
        int[] tmp157_150 = tmp150_143;
        tmp157_150[8] = 1324;
        int[] tmp164_157 = tmp157_150;
        tmp164_157[9] = 278;
        int[] tmp171_164 = tmp164_157;
        tmp171_164[10] = 1313;
        tmp171_164;
      }
    }
    else
    {
      arrayOfInt = new int[11];
      int[] tmp190_188 = arrayOfInt;
      tmp190_188[0] = 256;
      int[] tmp196_190 = tmp190_188;
      tmp196_190[1] = 264;
      int[] tmp202_196 = tmp196_190;
      tmp202_196[2] = 265;
      int[] tmp208_202 = tmp202_196;
      tmp208_202[3] = 1325;
      int[] tmp214_208 = tmp208_202;
      tmp214_208[4] = 8;
      int[] tmp219_214 = tmp214_208;
      tmp219_214[5] = 322;
      int[] tmp225_219 = tmp219_214;
      tmp225_219[6] = 325;
      int[] tmp232_225 = tmp225_219;
      tmp232_225[7] = 340;
      int[] tmp239_232 = tmp232_225;
      tmp239_232[8] = 274;
      int[] tmp246_239 = tmp239_232;
      tmp246_239[9] = 278;
      int[] tmp253_246 = tmp246_239;
      tmp253_246[10] = 1313;
      tmp253_246;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = arrayOfInt.length;
    int k = 0;
    int j = 0;
    int m;
    for (int i = 0;; i = m)
    {
      byte[] arrayOfByte1 = paramArrayOfByte1;
      if (k >= i1) {
        break;
      }
      byte[] arrayOfByte2 = new byte[0];
      m = arrayOfInt[k];
      Object localObject;
      if (m != 8)
      {
        if (m != 256)
        {
          if (m != 260)
          {
            if (m != 274)
            {
              if (m != 278)
              {
                if (m != 322) {
                  if (m != 325) {
                    if (m != 340) {
                      if (m != 1313) {
                        if (m != 264)
                        {
                          if (m != 265)
                          {
                            if (m != 1324)
                            {
                              if (m != 1325) {
                                localObject = arrayOfByte2;
                              } else {
                                localObject = new tlv_t52d().get_tlv_52d(this.a);
                              }
                            }
                            else {
                              localObject = new tlv_t52c().get_tlv_52c(paramInt3, paramLong3);
                            }
                          }
                          else
                          {
                            localObject = arrayOfByte2;
                            if (t.P != null)
                            {
                              localObject = arrayOfByte2;
                              if (t.P.length > 0) {
                                localObject = new tlv_t109().get_tlv_109(t.P);
                              }
                            }
                          }
                        }
                        else
                        {
                          localObject = arrayOfByte2;
                          if (arrayOfByte1 != null)
                          {
                            localObject = arrayOfByte2;
                            if (arrayOfByte1.length > 0) {
                              localObject = new tlv_t108().get_tlv_108(arrayOfByte1);
                            }
                          }
                        }
                      }
                    }
                  }
                }
                for (;;)
                {
                  break;
                  localObject = new tlv_t(1313);
                  arrayOfByte1 = new byte[6];
                  util.int32_to_buf(arrayOfByte1, 0, t.aA);
                  util.int16_to_buf(arrayOfByte1, 4, 0);
                  ((tlv_t)localObject).set_data(arrayOfByte1, 6);
                  localObject = ((tlv_t)localObject).get_buf();
                  continue;
                  localObject = new tlv_t154().get_tlv_154(this.x.i);
                  continue;
                  localObject = new tlv_t145().get_tlv_145(t.B);
                  continue;
                  localObject = new tlv_t142().get_tlv_142(t.F);
                }
              }
              localObject = new tlv_t116().get_tlv_116(paramInt4, paramInt5, paramArrayOfLong);
            }
            else
            {
              localObject = new tlv_t112().get_tlv_112(paramArrayOfByte2);
            }
          }
          else {
            localObject = new tlv_t104().get_tlv_104(paramArrayOfByte3);
          }
        }
        else {
          localObject = new tlv_t100().get_tlv_100(paramLong1, paramLong2, paramInt2, paramInt1);
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
    paramArrayOfByte1 = (tlv_t)paramWUserSigInfo._loginExtraProductTLVMap.get(Integer.valueOf(1322));
    paramInt1 = j;
    paramInt2 = i;
    if (paramArrayOfByte1 != null)
    {
      paramArrayOfByte1 = paramArrayOfByte1.get_buf();
      paramInt1 = j + 1;
      paramInt2 = i + paramArrayOfByte1.length;
      localArrayList.add(paramArrayOfByte1);
    }
    paramArrayOfByte1 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
    while (paramArrayOfByte1.hasNext())
    {
      paramArrayOfByte2 = (Integer)paramArrayOfByte1.next();
      paramArrayOfByte3 = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfByte2)).get_buf();
      paramInt2 += paramArrayOfByte3.length;
      localArrayList.add(paramArrayOfByte3);
      paramInt1 += 1;
      paramArrayOfByte3 = new StringBuilder();
      paramArrayOfByte3.append("Extra Tlv from user：0x");
      paramArrayOfByte3.append(paramArrayOfByte2);
      util.LOGI(paramArrayOfByte3.toString());
    }
    paramArrayOfByte1 = new byte[paramInt2];
    paramInt2 = 0;
    paramInt3 = 0;
    while (paramInt2 < paramInt1)
    {
      paramArrayOfByte2 = (byte[])localArrayList.get(paramInt2);
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt3, paramArrayOfByte2.length);
      paramInt3 += paramArrayOfByte2.length;
      paramInt2 += 1;
    }
    return b(paramArrayOfByte1, this.u, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.x
 * JD-Core Version:    0.7.0.1
 */