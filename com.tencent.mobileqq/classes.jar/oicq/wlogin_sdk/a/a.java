package oicq.wlogin_sdk.a;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tlv_type.RegTLV;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class a
  extends c
{
  public a()
  {
    this.b = 16;
  }
  
  public byte[] a(long paramLong, int paramInt1, byte paramByte1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte paramByte2, byte[] paramArrayOfByte3, int paramInt2, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7)
  {
    int[] arrayOfInt = new int[11];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 2;
    int[] tmp12_8 = tmp8_6;
    tmp12_8[1] = 3;
    int[] tmp16_12 = tmp12_8;
    tmp16_12[2] = 10;
    int[] tmp21_16 = tmp16_12;
    tmp21_16[3] = 13;
    int[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 14;
    int[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 18;
    int[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 19;
    int[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 20;
    int[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 23;
    int[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 24;
    int[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 37;
    tmp60_54;
    ArrayList localArrayList = new ArrayList();
    int i1 = tmp8_6.length;
    int i = 0;
    int j = 0;
    int n = 0;
    if (n < i1)
    {
      Object localObject = new byte[0];
      switch (tmp8_6[n])
      {
      }
      for (;;)
      {
        int k = j;
        int m = i;
        if (localObject.length > 4)
        {
          m = i + 1;
          k = j + localObject.length;
          localArrayList.add(localObject);
        }
        n += 1;
        i = m;
        j = k;
        break;
        localObject = new RegTLV(2);
        ((RegTLV)localObject).setInt(paramInt1);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(3);
        ((RegTLV)localObject).setByte(paramByte2);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(10);
        ((RegTLV)localObject).setData(paramArrayOfByte3, paramArrayOfByte3.length);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(13);
        ((RegTLV)localObject).setInt(paramInt2);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(14);
        ((RegTLV)localObject).setData(paramArrayOfByte4, paramArrayOfByte4.length);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(18);
        ((RegTLV)localObject).setData(paramArrayOfByte5, paramArrayOfByte5.length);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(19);
        ((RegTLV)localObject).setData(paramArrayOfByte6, paramArrayOfByte6.length);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(20);
        ((RegTLV)localObject).setData(paramArrayOfByte7, paramArrayOfByte7.length);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(23);
        ((RegTLV)localObject).setByte((byte)5);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(24);
        ((RegTLV)localObject).setData(t.J, t.J.length);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(37);
        ((RegTLV)localObject).setShort(t.au);
        localObject = ((RegTLV)localObject).getBuf();
      }
    }
    paramArrayOfByte3 = new byte[j + 2];
    util.int16_to_buf(paramArrayOfByte3, 0, (short)i);
    j = 2;
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      paramArrayOfByte4 = (byte[])localArrayList.get(paramInt2);
      System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte3, j, paramArrayOfByte4.length);
      j += paramArrayOfByte4.length;
      paramInt2 += 1;
    }
    paramArrayOfByte4 = new ByteArrayOutputStream();
    paramArrayOfByte5 = new DataOutputStream(paramArrayOfByte4);
    try
    {
      paramArrayOfByte5.writeByte(1);
      paramArrayOfByte5.writeLong(paramLong);
      paramArrayOfByte5.writeInt(paramInt1);
      paramArrayOfByte5.writeByte(paramByte1);
      paramArrayOfByte5.writeShort(paramArrayOfByte1.length);
      paramArrayOfByte5.write(paramArrayOfByte1);
      paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte3, 0, paramArrayOfByte3.length, paramArrayOfByte2);
      if (paramArrayOfByte1 == null)
      {
        util.LOGI("encrypt failed", "");
        return null;
      }
      paramArrayOfByte5.writeShort(paramArrayOfByte1.length);
      paramArrayOfByte5.write(paramArrayOfByte1);
      paramArrayOfByte1 = paramArrayOfByte4.toByteArray();
      paramArrayOfByte5.close();
      paramArrayOfByte4.close();
      paramArrayOfByte1 = a(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      util.LOGI("getRequest failed " + paramArrayOfByte1.getMessage(), "" + paramLong);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.a
 * JD-Core Version:    0.7.0.1
 */