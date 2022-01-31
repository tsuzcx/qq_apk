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
    int[] arrayOfInt = new int[10];
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
    tmp85_79;
    paramArrayOfByte10 = new ArrayList();
    int i1 = arrayOfInt.length;
    int j = 0;
    int i = 0;
    int k = 0;
    label216:
    label221:
    int m;
    if (k < i1) {
      switch (arrayOfInt[k])
      {
      default: 
        paramArrayOfByte7 = new byte[0];
        if (paramArrayOfByte7.length <= 4) {
          break;
        }
        m = paramArrayOfByte7.length;
        paramArrayOfByte10.add(paramArrayOfByte7);
        i = m + i;
        j += 1;
      }
    } else {
      for (;;)
      {
        k += 1;
        break;
        paramArrayOfByte7 = new RegTLV(1);
        paramArrayOfByte7.setData(arrayOfByte1, arrayOfByte1.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label221;
        paramArrayOfByte7 = new RegTLV(2);
        paramArrayOfByte7.setLong(paramLong3);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label221;
        paramArrayOfByte7 = new RegTLV(3);
        paramArrayOfByte7.setData(paramArrayOfByte8, paramArrayOfByte8.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label221;
        paramArrayOfByte7 = new RegTLV(4);
        paramArrayOfByte7.setData(paramArrayOfByte9, paramArrayOfByte9.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label221;
        paramArrayOfByte7 = new RegTLV(13);
        paramArrayOfByte7.setInt((int)paramLong2);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label221;
        paramArrayOfByte7 = new RegTLV(6);
        Object localObject = new byte[arrayOfByte2.length + 3];
        if (arrayOfByte2.length == 0) {}
        for (m = 1;; m = 2)
        {
          util.int8_to_buf((byte[])localObject, 0, m);
          util.int16_to_buf((byte[])localObject, 1, arrayOfByte2.length);
          System.arraycopy(arrayOfByte2, 0, localObject, 3, arrayOfByte2.length);
          m = arrayOfByte2.length;
          paramArrayOfByte7.setData((byte[])localObject, localObject.length);
          paramArrayOfByte7 = paramArrayOfByte7.getBuf();
          break;
        }
        paramArrayOfByte7 = new RegTLV(7);
        int n = 0x0 | t.aj;
        m = n;
        if (true == t.ai) {
          m = n | 0x2;
        }
        paramArrayOfByte7.setInt(m | 0x8 | 0x10);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label221;
        paramArrayOfByte7 = new RegTLV(18);
        paramArrayOfByte7.setData(paramArrayOfByte3, paramArrayOfByte3.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label221;
        paramArrayOfByte7 = new RegTLV(37);
        paramArrayOfByte7.setShort(t.ax);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break label221;
        localObject = new StringBuilder(23);
        sec_trans.SecTransInfo localSecTransInfo = new sec_trans.SecTransInfo();
        localSecTransInfo.str_phone_brand.set(Build.BRAND);
        ((StringBuilder)localObject).append("brand:").append(Build.BRAND);
        localSecTransInfo.str_model_type.set(Build.MODEL);
        ((StringBuilder)localObject).append(" model:").append(Build.MODEL);
        PBStringField localPBStringField = localSecTransInfo.str_wifi_mac;
        if (t.ay == null)
        {
          paramArrayOfByte7 = "";
          label701:
          localPBStringField.set(paramArrayOfByte7);
          ((StringBuilder)localObject).append(" regMacAddress:").append(t.ay);
          localPBStringField = localSecTransInfo.str_gps_location;
          if (t.aB != null) {
            break label910;
          }
          paramArrayOfByte7 = "";
          label739:
          localPBStringField.set(paramArrayOfByte7);
          ((StringBuilder)localObject).append(" regLocation:").append(t.aB);
          localPBStringField = localSecTransInfo.str_os_language;
          if (t.az != null) {
            break label918;
          }
        }
        label910:
        label918:
        for (paramArrayOfByte7 = "";; paramArrayOfByte7 = t.az)
        {
          localPBStringField.set(paramArrayOfByte7);
          ((StringBuilder)localObject).append(" regOSLanguage:").append(t.az);
          localSecTransInfo.uint32_qq_language.set(t.aA);
          ((StringBuilder)localObject).append(" regQQLanguage:").append(t.aA);
          util.LOGI(((StringBuilder)localObject).toString(), "");
          if (localSecTransInfo == null) {
            break label926;
          }
          paramArrayOfByte7 = localSecTransInfo.toByteArray();
          localObject = new RegTLV(50);
          ((RegTLV)localObject).setData(paramArrayOfByte7, paramArrayOfByte7.length);
          util.LOGI("tlv50 len:" + paramArrayOfByte7.length, "");
          paramArrayOfByte7 = ((RegTLV)localObject).getBuf();
          break;
          paramArrayOfByte7 = t.ay;
          break label701;
          paramArrayOfByte7 = t.aB;
          break label739;
        }
        label926:
        util.LOGI("tlv50 sectrans is null", "");
        break label216;
        paramArrayOfByte7 = paramMap.keySet().iterator();
        while (paramArrayOfByte7.hasNext())
        {
          paramArrayOfByte8 = ((RegTLV)paramMap.get((Integer)paramArrayOfByte7.next())).getBuf();
          paramArrayOfByte10.add(paramArrayOfByte8);
          i += paramArrayOfByte8.length;
        }
        k = paramArrayOfByte10.size();
        paramArrayOfByte7 = new byte[i + 2];
        util.int16_to_buf(paramArrayOfByte7, 0, (byte)k);
        j = 2;
        i = 0;
        while (i < k)
        {
          paramArrayOfByte8 = (byte[])paramArrayOfByte10.get(i);
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