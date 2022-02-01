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
import oicq.wlogin_sdk.tools.util;

public class h
  extends c
{
  public h()
  {
    this.b = 10;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, long paramLong3, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, Map<Integer, RegTLV> paramMap)
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
    int[] arrayOfInt = new int[11];
    int[] tmp41_39 = arrayOfInt;
    tmp41_39[0] = 1;
    int[] tmp45_41 = tmp41_39;
    tmp45_41[1] = 2;
    int[] tmp49_45 = tmp45_41;
    tmp49_45[2] = 3;
    int[] tmp53_49 = tmp49_45;
    tmp53_49[3] = 4;
    int[] tmp57_53 = tmp53_49;
    tmp57_53[4] = 13;
    int[] tmp62_57 = tmp57_53;
    tmp62_57[5] = 6;
    int[] tmp67_62 = tmp62_57;
    tmp67_62[6] = 7;
    int[] tmp73_67 = tmp67_62;
    tmp73_67[7] = 18;
    int[] tmp79_73 = tmp73_67;
    tmp79_73[8] = 37;
    int[] tmp85_79 = tmp79_73;
    tmp85_79[9] = 50;
    int[] tmp91_85 = tmp85_79;
    tmp91_85[10] = 52;
    tmp91_85;
    ArrayList localArrayList = new ArrayList();
    int i1 = arrayOfInt.length;
    int j = 0;
    int i = 0;
    int k = 0;
    label236:
    int m;
    if (k < i1)
    {
      paramArrayOfByte7 = new byte[0];
      switch (arrayOfInt[k])
      {
      default: 
        if (paramArrayOfByte7.length <= 4) {
          break;
        }
        m = paramArrayOfByte7.length;
        localArrayList.add(paramArrayOfByte7);
        i = m + i;
        j += 1;
      }
    }
    else
    {
      for (;;)
      {
        k += 1;
        break;
        paramArrayOfByte7 = new RegTLV(1);
        paramArrayOfByte7.setData(arrayOfByte1, arrayOfByte1.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label236;
        paramArrayOfByte7 = new RegTLV(2);
        paramArrayOfByte7.setLong(paramLong3);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label236;
        paramArrayOfByte7 = new RegTLV(3);
        paramArrayOfByte7.setData(paramArrayOfByte8, paramArrayOfByte8.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label236;
        paramArrayOfByte7 = new RegTLV(4);
        paramArrayOfByte7.setData(paramArrayOfByte9, paramArrayOfByte9.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label236;
        paramArrayOfByte7 = new RegTLV(13);
        paramArrayOfByte7.setInt((int)paramLong2);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label236;
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
        paramArrayOfByte7.setInt(m | 0x8 | 0x10);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label236;
        paramArrayOfByte7 = new RegTLV(18);
        paramArrayOfByte7.setData(paramArrayOfByte3, paramArrayOfByte3.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label236;
        paramArrayOfByte7 = new RegTLV(37);
        paramArrayOfByte7.setShort(t.aA);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label236;
        StringBuilder localStringBuilder = new StringBuilder(23);
        sec_trans.SecTransInfo localSecTransInfo = new sec_trans.SecTransInfo();
        localSecTransInfo.str_phone_brand.set(Build.BRAND);
        localStringBuilder.append("brand:").append(Build.BRAND);
        localSecTransInfo.str_model_type.set(Build.MODEL);
        localStringBuilder.append(" model:").append(Build.MODEL);
        PBStringField localPBStringField = localSecTransInfo.str_wifi_mac;
        if (t.aB == null)
        {
          paramArrayOfByte10 = "";
          label716:
          localPBStringField.set(paramArrayOfByte10);
          localStringBuilder.append(" regMacAddress:").append(t.aB);
          localPBStringField = localSecTransInfo.str_gps_location;
          if (t.aE != null) {
            break label925;
          }
          paramArrayOfByte10 = "";
          label754:
          localPBStringField.set(paramArrayOfByte10);
          localStringBuilder.append(" regLocation:").append(t.aE);
          localPBStringField = localSecTransInfo.str_os_language;
          if (t.aC != null) {
            break label933;
          }
        }
        label925:
        label933:
        for (paramArrayOfByte10 = "";; paramArrayOfByte10 = t.aC)
        {
          localPBStringField.set(paramArrayOfByte10);
          localStringBuilder.append(" regOSLanguage:").append(t.aC);
          localSecTransInfo.uint32_qq_language.set(t.aD);
          localStringBuilder.append(" regQQLanguage:").append(t.aD);
          util.LOGI(localStringBuilder.toString(), "");
          if (localSecTransInfo == null) {
            break label941;
          }
          paramArrayOfByte7 = localSecTransInfo.toByteArray();
          paramArrayOfByte10 = new RegTLV(50);
          paramArrayOfByte10.setData(paramArrayOfByte7, paramArrayOfByte7.length);
          util.LOGI("tlv50 len:" + paramArrayOfByte7.length, "");
          paramArrayOfByte7 = paramArrayOfByte10.getBuf();
          break;
          paramArrayOfByte10 = t.aB;
          break label716;
          paramArrayOfByte10 = t.aE;
          break label754;
        }
        label941:
        util.LOGI("tlv50 sectrans is null", "");
        break label236;
        paramArrayOfByte7 = new RegTLV(52);
        paramArrayOfByte10 = new byte[4];
        util.int32_to_buf(paramArrayOfByte10, 0, 13);
        paramArrayOfByte7.setData(paramArrayOfByte10, paramArrayOfByte10.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        util.LOGI("tlv52 len:" + paramArrayOfByte10.length, "");
        break label236;
        paramArrayOfByte7 = paramMap.keySet().iterator();
        while (paramArrayOfByte7.hasNext())
        {
          paramArrayOfByte8 = ((RegTLV)paramMap.get((Integer)paramArrayOfByte7.next())).getBuf();
          localArrayList.add(paramArrayOfByte8);
          i += paramArrayOfByte8.length;
        }
        k = localArrayList.size();
        paramArrayOfByte7 = new byte[i + 2];
        util.int16_to_buf(paramArrayOfByte7, 0, (byte)k);
        j = 2;
        i = 0;
        while (i < k)
        {
          paramArrayOfByte8 = (byte[])localArrayList.get(i);
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
        }
        catch (Exception paramArrayOfByte1)
        {
          util.LOGI("get account failed " + paramArrayOfByte1.getMessage(), "");
          return null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.h
 * JD-Core Version:    0.7.0.1
 */