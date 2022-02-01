package oicq.wlogin_sdk.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import oicq.wlogin_sdk.pb.sec_trans.SecTransInfo;
import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tlv_type.RegTLV;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tools.util;

public class h
  extends c
{
  public h()
  {
    this.b = 10;
  }
  
  public h.a a(Map<String, Object> paramMap)
  {
    h.a locala = new h.a(null);
    StringBuilder localStringBuilder = new StringBuilder("reg_request_submit_mobile analysisExtraMap");
    if (paramMap == null)
    {
      localStringBuilder.append(" extraMap == null");
      return locala;
    }
    locala.a = ((byte[])paramMap.get("country_english_name"));
    localStringBuilder.append("，stCountryCodeTwo = ");
    if (locala.a == null)
    {
      localStringBuilder.append("null");
      locala.b = ((byte[])paramMap.get("captcha_verify_info"));
      localStringBuilder.append("，stCaptchaVerifyInfo = ");
      if (locala.b != null) {
        break label140;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      util.LOGI(localStringBuilder.toString(), "");
      return locala;
      localStringBuilder.append(new String(locala.a));
      break;
      label140:
      localStringBuilder.append(locala.b.length);
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, long paramLong3, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, Map<Integer, RegTLV> paramMap, Map<String, Object> paramMap1)
  {
    String str = Build.VERSION.RELEASE;
    byte[] arrayOfByte1 = paramArrayOfByte7;
    if (paramArrayOfByte7 == null) {
      arrayOfByte1 = new byte[0];
    }
    byte[] arrayOfByte2 = paramArrayOfByte10;
    if (paramArrayOfByte10 == null) {
      arrayOfByte2 = new byte[0];
    }
    h.a locala = a(paramMap1);
    StringBuilder localStringBuilder1 = new StringBuilder("reg_request_submit_mobile");
    int[] arrayOfInt = new int[14];
    int[] tmp60_58 = arrayOfInt;
    tmp60_58[0] = 1;
    int[] tmp64_60 = tmp60_58;
    tmp64_60[1] = 2;
    int[] tmp68_64 = tmp64_60;
    tmp68_64[2] = 3;
    int[] tmp72_68 = tmp68_64;
    tmp72_68[3] = 4;
    int[] tmp76_72 = tmp72_68;
    tmp76_72[4] = 13;
    int[] tmp81_76 = tmp76_72;
    tmp81_76[5] = 6;
    int[] tmp86_81 = tmp81_76;
    tmp86_81[6] = 7;
    int[] tmp92_86 = tmp86_81;
    tmp92_86[7] = 18;
    int[] tmp98_92 = tmp92_86;
    tmp98_92[8] = 37;
    int[] tmp104_98 = tmp98_92;
    tmp104_98[9] = 50;
    int[] tmp110_104 = tmp104_98;
    tmp110_104[10] = 52;
    int[] tmp116_110 = tmp110_104;
    tmp116_110[11] = 53;
    int[] tmp122_116 = tmp116_110;
    tmp122_116[12] = 544;
    int[] tmp129_122 = tmp122_116;
    tmp129_122[13] = 29;
    tmp129_122;
    paramMap1 = new ArrayList();
    int i1 = arrayOfInt.length;
    int j = 0;
    int i = 0;
    int k = 0;
    label300:
    int m;
    if (k < i1)
    {
      paramArrayOfByte7 = new byte[0];
      switch (arrayOfInt[k])
      {
      default: 
        if (paramArrayOfByte7.length > 4)
        {
          m = paramArrayOfByte7.length;
          paramMap1.add(paramArrayOfByte7);
          m += i;
          i = j + 1;
          j = m;
        }
        break;
      }
    }
    for (;;)
    {
      m = k + 1;
      k = i;
      i = j;
      j = k;
      k = m;
      break;
      paramArrayOfByte7 = new RegTLV(1);
      paramArrayOfByte7.setData(arrayOfByte1, arrayOfByte1.length);
      paramArrayOfByte7 = paramArrayOfByte7.getBuf();
      break label300;
      paramArrayOfByte7 = new RegTLV(2);
      paramArrayOfByte7.setLong(paramLong3);
      paramArrayOfByte7 = paramArrayOfByte7.getBuf();
      break label300;
      paramArrayOfByte7 = new RegTLV(3);
      paramArrayOfByte7.setData(paramArrayOfByte8, paramArrayOfByte8.length);
      paramArrayOfByte7 = paramArrayOfByte7.getBuf();
      break label300;
      paramArrayOfByte7 = new RegTLV(4);
      paramArrayOfByte7.setData(paramArrayOfByte9, paramArrayOfByte9.length);
      paramArrayOfByte7 = paramArrayOfByte7.getBuf();
      break label300;
      paramArrayOfByte7 = new RegTLV(13);
      paramArrayOfByte7.setInt((int)paramLong2);
      paramArrayOfByte7 = paramArrayOfByte7.getBuf();
      break label300;
      paramArrayOfByte7 = new RegTLV(6);
      paramArrayOfByte10 = new byte[arrayOfByte2.length + 3];
      if (arrayOfByte2.length == 0) {}
      for (m = 1;; m = 2)
      {
        util.int8_to_buf(paramArrayOfByte10, 0, m);
        util.int16_to_buf(paramArrayOfByte10, 1, arrayOfByte2.length);
        System.arraycopy(arrayOfByte2, 0, paramArrayOfByte10, 3, arrayOfByte2.length);
        m = arrayOfByte2.length;
        paramArrayOfByte7.setData(paramArrayOfByte10, paramArrayOfByte10.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break;
      }
      paramArrayOfByte7 = new RegTLV(7);
      int n = 0x0 | t.ak;
      m = n;
      if (true == t.aj) {
        m = n | 0x2;
      }
      m = m | 0x8 | 0x10 | 0x40;
      paramArrayOfByte7.setInt(m);
      util.LOGI("reg_request_submit_mobile tlv7 " + m, "");
      paramArrayOfByte7 = paramArrayOfByte7.getBuf();
      break label300;
      paramArrayOfByte7 = new RegTLV(18);
      paramArrayOfByte7.setData(paramArrayOfByte3, paramArrayOfByte3.length);
      paramArrayOfByte7 = paramArrayOfByte7.getBuf();
      break label300;
      paramArrayOfByte7 = new RegTLV(37);
      paramArrayOfByte7.setShort(t.aA);
      paramArrayOfByte7 = paramArrayOfByte7.getBuf();
      break label300;
      StringBuilder localStringBuilder2 = new StringBuilder(23);
      sec_trans.SecTransInfo localSecTransInfo = new sec_trans.SecTransInfo();
      localSecTransInfo.str_phone_brand.set(Build.BRAND);
      localStringBuilder2.append("brand:").append(Build.BRAND);
      localSecTransInfo.str_model_type.set(Build.MODEL);
      localStringBuilder2.append(" model:").append(Build.MODEL);
      PBStringField localPBStringField = localSecTransInfo.str_wifi_mac;
      if (t.aB == null)
      {
        paramArrayOfByte10 = "";
        label832:
        localPBStringField.set(paramArrayOfByte10);
        localStringBuilder2.append(" regMacAddress:").append(t.aB);
        localPBStringField = localSecTransInfo.str_gps_location;
        if (t.aE != null) {
          break label1041;
        }
        paramArrayOfByte10 = "";
        label870:
        localPBStringField.set(paramArrayOfByte10);
        localStringBuilder2.append(" regLocation:").append(t.aE);
        localPBStringField = localSecTransInfo.str_os_language;
        if (t.aC != null) {
          break label1049;
        }
      }
      label1041:
      label1049:
      for (paramArrayOfByte10 = "";; paramArrayOfByte10 = t.aC)
      {
        localPBStringField.set(paramArrayOfByte10);
        localStringBuilder2.append(" regOSLanguage:").append(t.aC);
        localSecTransInfo.uint32_qq_language.set(t.aD);
        localStringBuilder2.append(" regQQLanguage:").append(t.aD);
        util.LOGI(localStringBuilder2.toString(), "");
        if (localSecTransInfo == null) {
          break label1057;
        }
        paramArrayOfByte7 = localSecTransInfo.toByteArray();
        paramArrayOfByte10 = new RegTLV(50);
        paramArrayOfByte10.setData(paramArrayOfByte7, paramArrayOfByte7.length);
        util.LOGI("tlv50 len:" + paramArrayOfByte7.length, "");
        paramArrayOfByte7 = paramArrayOfByte10.getBuf();
        break;
        paramArrayOfByte10 = t.aB;
        break label832;
        paramArrayOfByte10 = t.aE;
        break label870;
      }
      label1057:
      util.LOGI("tlv50 sectrans is null", "");
      break label300;
      paramArrayOfByte7 = new RegTLV(52);
      paramArrayOfByte10 = new byte[4];
      util.int32_to_buf(paramArrayOfByte10, 0, 15);
      paramArrayOfByte7.setData(paramArrayOfByte10, paramArrayOfByte10.length);
      paramArrayOfByte7 = paramArrayOfByte7.getBuf();
      util.LOGI("tlv52 len:" + paramArrayOfByte10.length, "");
      break label300;
      if (locala.a != null)
      {
        paramArrayOfByte7 = new RegTLV(29);
        paramArrayOfByte7.setData(locala.a, locala.a.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        util.LOGI("tlv29 len:" + locala.a.length, "");
        break label300;
      }
      util.LOGI("tlv29 byteCountryCode is null", "");
      break label300;
      if (locala.b != null)
      {
        paramArrayOfByte7 = new RegTLV(53);
        paramArrayOfByte7.setData(locala.b, locala.b.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        util.LOGI("tlv53 len:" + locala.b.length + "，" + paramArrayOfByte7.length, "");
        break label300;
      }
      util.LOGI("tlv53 byteCaptchaVerifyInfo is null", "");
      break label300;
      paramArrayOfByte7 = new byte[paramArrayOfByte1.length + paramArrayOfByte3.length + arrayOfByte2.length];
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte7, 0, paramArrayOfByte1.length);
      m = 0 + paramArrayOfByte1.length;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte7, m, paramArrayOfByte3.length);
      System.arraycopy(arrayOfByte2, 0, paramArrayOfByte7, m + paramArrayOfByte3.length, arrayOfByte2.length);
      paramArrayOfByte7 = new tlv_t544().get_common_tlv544(this.b, 0L, paramLong3, paramArrayOfByte7);
      break label300;
      paramArrayOfByte7 = paramMap.keySet().iterator();
      while (paramArrayOfByte7.hasNext())
      {
        paramArrayOfByte8 = (Integer)paramArrayOfByte7.next();
        paramArrayOfByte9 = ((RegTLV)paramMap.get(paramArrayOfByte8)).getBuf();
        paramMap1.add(paramArrayOfByte9);
        i += paramArrayOfByte9.length;
        localStringBuilder1.append(",key=").append(paramArrayOfByte8).append(",value=").append(paramArrayOfByte9.length);
      }
      util.LOGI(localStringBuilder1.toString(), "");
      k = paramMap1.size();
      paramArrayOfByte7 = new byte[i + 2];
      util.int16_to_buf(paramArrayOfByte7, 0, (byte)k);
      j = 2;
      i = 0;
      while (i < k)
      {
        paramArrayOfByte8 = (byte[])paramMap1.get(i);
        System.arraycopy(paramArrayOfByte8, 0, paramArrayOfByte7, j, paramArrayOfByte8.length);
        j += paramArrayOfByte8.length;
        i += 1;
      }
      paramArrayOfByte8 = new ByteArrayOutputStream();
      paramArrayOfByte9 = new DataOutputStream(paramArrayOfByte8);
      try
      {
        paramArrayOfByte9.writeByte(paramArrayOfByte1.length);
        paramArrayOfByte9.write(paramArrayOfByte1);
        paramArrayOfByte9.writeByte(this.c);
        paramArrayOfByte9.writeByte(str.length());
        paramArrayOfByte9.write(str.getBytes());
        paramArrayOfByte9.writeByte(paramArrayOfByte2.length);
        paramArrayOfByte9.write(paramArrayOfByte2);
        paramArrayOfByte9.writeByte(paramArrayOfByte3.length);
        paramArrayOfByte9.write(paramArrayOfByte3);
        paramArrayOfByte9.writeByte(paramInt1);
        paramArrayOfByte9.writeByte(paramInt2);
        paramArrayOfByte9.writeByte(paramInt3);
        paramArrayOfByte9.writeInt((int)paramLong1);
        if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length == 4)) {
          paramArrayOfByte9.write(paramArrayOfByte4);
        }
        for (;;)
        {
          paramArrayOfByte9.writeByte(paramArrayOfByte5.length);
          paramArrayOfByte9.write(paramArrayOfByte5);
          paramArrayOfByte9.writeByte(paramArrayOfByte6.length);
          paramArrayOfByte9.write(paramArrayOfByte6);
          paramArrayOfByte9.write(paramArrayOfByte7);
          return a(paramArrayOfByte8.toByteArray());
          paramArrayOfByte9.writeInt(0);
        }
        m = j;
      }
      catch (Exception paramArrayOfByte1)
      {
        util.LOGI("get account failed " + paramArrayOfByte1.getMessage(), "");
        return null;
      }
      j = i;
      i = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.h
 * JD-Core Version:    0.7.0.1
 */