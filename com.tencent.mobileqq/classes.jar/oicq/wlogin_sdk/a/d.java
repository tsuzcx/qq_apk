package oicq.wlogin_sdk.a;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tlv_type.RegTLV;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class d
  extends c
{
  public d()
  {
    this.b = 6;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt1, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, boolean paramBoolean, byte[] paramArrayOfByte7, long paramLong, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, int paramInt2, byte[] paramArrayOfByte10, Map<Integer, RegTLV> paramMap)
  {
    int k = 0;
    if (paramArrayOfByte6 == null) {
      paramArrayOfByte6 = new byte[0];
    }
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte4 = new byte[0];
    }
    if (paramArrayOfByte7 == null) {
      paramArrayOfByte7 = new byte[0];
    }
    byte[] arrayOfByte1;
    if (paramArrayOfByte10 == null) {
      arrayOfByte1 = new byte[0];
    } else {
      arrayOfByte1 = paramArrayOfByte10;
    }
    StringBuilder localStringBuilder = new StringBuilder("reg_request_get_account");
    if (paramBoolean)
    {
      paramArrayOfByte10 = new int[14];
      byte[] tmp83_81 = paramArrayOfByte10;
      tmp83_81[0] = 1;
      byte[] tmp87_83 = tmp83_81;
      tmp87_83[1] = 5;
      byte[] tmp91_87 = tmp87_83;
      tmp91_87[2] = 6;
      byte[] tmp96_91 = tmp91_87;
      tmp96_91[3] = 8;
      byte[] tmp101_96 = tmp96_91;
      tmp101_96[4] = 15;
      byte[] tmp106_101 = tmp101_96;
      tmp106_101[5] = 37;
      byte[] tmp111_106 = tmp106_101;
      tmp111_106[6] = 9;
      byte[] tmp117_111 = tmp111_106;
      tmp117_111[7] = 10;
      byte[] tmp123_117 = tmp117_111;
      tmp123_117[8] = 11;
      byte[] tmp129_123 = tmp123_117;
      tmp129_123[9] = 13;
      byte[] tmp135_129 = tmp129_123;
      tmp135_129[10] = 14;
      byte[] tmp141_135 = tmp135_129;
      tmp141_135[11] = 18;
      byte[] tmp147_141 = tmp141_135;
      tmp147_141[12] = 56;
      byte[] tmp153_147 = tmp147_141;
      tmp153_147[13] = 544;
      tmp153_147;
    }
    else
    {
      paramArrayOfByte10 = new int[12];
      byte[] tmp172_170 = paramArrayOfByte10;
      tmp172_170[0] = 1;
      byte[] tmp176_172 = tmp172_170;
      tmp176_172[1] = 5;
      byte[] tmp180_176 = tmp176_172;
      tmp180_176[2] = 6;
      byte[] tmp185_180 = tmp180_176;
      tmp185_180[3] = 8;
      byte[] tmp190_185 = tmp185_180;
      tmp190_185[4] = 15;
      byte[] tmp195_190 = tmp190_185;
      tmp195_190[5] = 37;
      byte[] tmp200_195 = tmp195_190;
      tmp200_195[6] = 10;
      byte[] tmp206_200 = tmp200_195;
      tmp206_200[7] = 13;
      byte[] tmp212_206 = tmp206_200;
      tmp212_206[8] = 14;
      byte[] tmp218_212 = tmp212_206;
      tmp218_212[9] = 18;
      byte[] tmp224_218 = tmp218_212;
      tmp224_218[10] = 56;
      byte[] tmp230_224 = tmp224_218;
      tmp230_224[11] = 544;
      tmp230_224;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfByte10.length;
    int i = 0;
    byte[] arrayOfByte2 = paramArrayOfByte10;
    paramArrayOfByte10 = paramArrayOfByte4;
    for (;;)
    {
      paramArrayOfByte4 = paramArrayOfByte8;
      if (k >= j) {
        break;
      }
      int m = arrayOfByte2[k];
      if (m != 1)
      {
        if (m != 18)
        {
          if (m != 37)
          {
            if (m != 56)
            {
              if (m != 544) {
                if (m != 5) {
                  if (m != 6) {
                    switch (m)
                    {
                    default: 
                      switch (m)
                      {
                      default: 
                        paramArrayOfByte4 = new byte[0];
                      }
                      break;
                    }
                  }
                }
              }
              for (;;)
              {
                break;
                paramArrayOfByte4 = new RegTLV(15);
                paramArrayOfByte4.setInt(paramInt2);
                paramArrayOfByte4 = paramArrayOfByte4.getBuf();
                break;
                Object localObject = new RegTLV(14);
                ((RegTLV)localObject).setData(paramArrayOfByte4, paramArrayOfByte4.length);
                paramArrayOfByte4 = ((RegTLV)localObject).getBuf();
                continue;
                paramArrayOfByte4 = new RegTLV(13);
                paramArrayOfByte4.setInt((int)paramLong);
                paramArrayOfByte4 = paramArrayOfByte4.getBuf();
                continue;
                paramArrayOfByte4 = new RegTLV(11);
                paramArrayOfByte4.setData(paramArrayOfByte3, paramArrayOfByte3.length);
                paramArrayOfByte4 = paramArrayOfByte4.getBuf();
                continue;
                paramArrayOfByte4 = new RegTLV(10);
                paramArrayOfByte4.setData(paramArrayOfByte7, paramArrayOfByte7.length);
                paramArrayOfByte4 = paramArrayOfByte4.getBuf();
                continue;
                paramArrayOfByte4 = new RegTLV(9);
                paramArrayOfByte4.setByte((byte)1);
                paramArrayOfByte4 = paramArrayOfByte4.getBuf();
                continue;
                paramArrayOfByte4 = new RegTLV(8);
                paramArrayOfByte4.setByte((byte)1);
                paramArrayOfByte4 = paramArrayOfByte4.getBuf();
                continue;
                paramArrayOfByte4 = new RegTLV(6);
                paramArrayOfByte4.setData(paramArrayOfByte10, paramArrayOfByte10.length);
                paramArrayOfByte4 = paramArrayOfByte4.getBuf();
                continue;
                paramArrayOfByte4 = new RegTLV(5);
                paramArrayOfByte4.setData(paramArrayOfByte6, paramArrayOfByte6.length);
                paramArrayOfByte4 = paramArrayOfByte4.getBuf();
                continue;
                paramArrayOfByte4 = MD5.toMD5Byte(paramArrayOfByte1);
                localObject = MD5.toMD5Byte(paramArrayOfByte3);
                byte[] arrayOfByte3 = new byte[paramArrayOfByte4.length + paramArrayOfByte5.length + localObject.length + 6];
                util.int16_to_buf(arrayOfByte3, 0, paramArrayOfByte4.length);
                System.arraycopy(paramArrayOfByte4, 0, arrayOfByte3, 0, paramArrayOfByte4.length);
                m = paramArrayOfByte4.length + 2;
                util.int16_to_buf(arrayOfByte3, m, paramArrayOfByte5.length);
                m += 2;
                System.arraycopy(paramArrayOfByte5, 0, arrayOfByte3, m, paramArrayOfByte5.length);
                m += paramArrayOfByte5.length;
                util.int16_to_buf(arrayOfByte3, m, localObject.length);
                System.arraycopy(localObject, 0, arrayOfByte3, m + 2, localObject.length);
                paramArrayOfByte4 = new tlv_t544().get_tlv_544("", "812_6", arrayOfByte3);
              }
            }
            paramArrayOfByte4 = new RegTLV(56);
            paramArrayOfByte4.setData(arrayOfByte1, arrayOfByte1.length);
            paramArrayOfByte4 = paramArrayOfByte4.getBuf();
          }
          else
          {
            paramArrayOfByte4 = new RegTLV(37);
            paramArrayOfByte4.setShort(t.aA);
            paramArrayOfByte4 = paramArrayOfByte4.getBuf();
          }
        }
        else
        {
          paramArrayOfByte4 = new RegTLV(18);
          paramArrayOfByte4.setData(paramArrayOfByte9, paramArrayOfByte9.length);
          paramArrayOfByte4 = paramArrayOfByte4.getBuf();
        }
      }
      else
      {
        paramArrayOfByte4 = new RegTLV(1);
        paramArrayOfByte4.setData(paramArrayOfByte5, paramArrayOfByte5.length);
        paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      }
      m = i;
      if (paramArrayOfByte4.length >= 2)
      {
        m = i + paramArrayOfByte4.length;
        localArrayList.add(paramArrayOfByte4);
      }
      k += 1;
      i = m;
    }
    paramArrayOfByte4 = paramMap.keySet().iterator();
    while (paramArrayOfByte4.hasNext())
    {
      paramArrayOfByte5 = (Integer)paramArrayOfByte4.next();
      paramArrayOfByte6 = ((RegTLV)paramMap.get(paramArrayOfByte5)).getBuf();
      localArrayList.add(paramArrayOfByte6);
      i += paramArrayOfByte6.length;
      localStringBuilder.append(",key=");
      localStringBuilder.append(paramArrayOfByte5);
      localStringBuilder.append(",value=");
      localStringBuilder.append(paramArrayOfByte6.length);
    }
    j = localArrayList.size();
    paramArrayOfByte4 = new byte[i + 2];
    util.int16_to_buf(paramArrayOfByte4, 0, (byte)j);
    localStringBuilder.append(",tlv cnt=");
    localStringBuilder.append(j);
    util.LOGI(localStringBuilder.toString(), "");
    paramInt2 = 0;
    i = 2;
    while (paramInt2 < j)
    {
      paramArrayOfByte5 = (byte[])localArrayList.get(paramInt2);
      System.arraycopy(paramArrayOfByte5, 0, paramArrayOfByte4, i, paramArrayOfByte5.length);
      i += paramArrayOfByte5.length;
      paramInt2 += 1;
    }
    paramArrayOfByte5 = new ByteArrayOutputStream();
    paramArrayOfByte6 = new DataOutputStream(paramArrayOfByte5);
    try
    {
      paramArrayOfByte6.writeByte(paramArrayOfByte1.length);
      paramArrayOfByte6.write(paramArrayOfByte1);
      paramArrayOfByte6.writeByte(paramArrayOfByte3.length);
      paramArrayOfByte6.write(paramArrayOfByte3);
      paramArrayOfByte6.writeByte(paramInt1);
      paramArrayOfByte6.write(paramArrayOfByte4);
      paramArrayOfByte3 = paramArrayOfByte5.toByteArray();
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0))
      {
        paramArrayOfByte4 = new StringBuilder();
        paramArrayOfByte4.append("msgchk is ");
        paramArrayOfByte4.append(util.buf_to_string(paramArrayOfByte2, paramArrayOfByte2.length));
        util.LOGI(paramArrayOfByte4.toString(), "");
        paramArrayOfByte2 = MD5.toMD5Byte(paramArrayOfByte2);
      }
      else
      {
        util.LOGI("msgchk is null or length is 0", "");
        paramArrayOfByte2 = k.a.getBytes();
      }
      paramArrayOfByte2 = cryptor.encrypt(paramArrayOfByte3, 0, paramArrayOfByte3.length, paramArrayOfByte2);
      this.d = (paramArrayOfByte1.length + 1 + 2 + paramArrayOfByte2.length);
      paramArrayOfByte3 = new byte[this.d];
      util.int8_to_buf(paramArrayOfByte3, 0, paramArrayOfByte1.length);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, 1, paramArrayOfByte1.length);
      paramInt1 = paramArrayOfByte1.length + 1;
      util.int16_to_buf(paramArrayOfByte3, paramInt1, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, paramInt1 + 2, paramArrayOfByte2.length);
      paramInt1 = paramArrayOfByte2.length;
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("encryptedContent length ");
      paramArrayOfByte1.append(paramArrayOfByte2.length);
      util.LOGI(paramArrayOfByte1.toString(), "");
      return a(paramArrayOfByte3);
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte2 = new StringBuilder();
      paramArrayOfByte2.append("get account failed ");
      paramArrayOfByte2.append(paramArrayOfByte1.getMessage());
      util.LOGI(paramArrayOfByte2.toString(), "");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.a.d
 * JD-Core Version:    0.7.0.1
 */