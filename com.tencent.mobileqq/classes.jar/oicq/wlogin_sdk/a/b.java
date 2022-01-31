package oicq.wlogin_sdk.a;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tlv_type.RegTLV;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class b
  extends c
{
  public b()
  {
    this.b = 17;
  }
  
  public byte[] a(long paramLong, int paramInt1, byte paramByte1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte paramByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt2, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10)
  {
    if ((paramArrayOfByte10 == null) || (paramArrayOfByte10.length == 0))
    {
      util.LOGI("token is null", "");
      return null;
    }
    int[] arrayOfInt = new int[13];
    int[] tmp28_26 = arrayOfInt;
    tmp28_26[0] = 2;
    int[] tmp32_28 = tmp28_26;
    tmp32_28[1] = 3;
    int[] tmp36_32 = tmp32_28;
    tmp36_32[2] = 6;
    int[] tmp41_36 = tmp36_32;
    tmp41_36[3] = 10;
    int[] tmp46_41 = tmp41_36;
    tmp46_41[4] = 13;
    int[] tmp51_46 = tmp46_41;
    tmp51_46[5] = 14;
    int[] tmp56_51 = tmp51_46;
    tmp56_51[6] = 18;
    int[] tmp62_56 = tmp56_51;
    tmp62_56[7] = 19;
    int[] tmp68_62 = tmp62_56;
    tmp68_62[8] = 20;
    int[] tmp74_68 = tmp68_62;
    tmp74_68[9] = 23;
    int[] tmp80_74 = tmp74_68;
    tmp80_74[10] = 24;
    int[] tmp86_80 = tmp80_74;
    tmp86_80[11] = 32;
    int[] tmp92_86 = tmp86_80;
    tmp92_86[12] = 37;
    tmp92_86;
    ArrayList localArrayList = new ArrayList();
    int i1 = tmp28_26.length;
    int i = 0;
    int j = 0;
    int n = 0;
    if (n < i1)
    {
      Object localObject = new byte[0];
      switch (tmp28_26[n])
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
        localObject = new RegTLV(6);
        ((RegTLV)localObject).setData(paramArrayOfByte3, paramArrayOfByte3.length);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(10);
        ((RegTLV)localObject).setData(paramArrayOfByte4, paramArrayOfByte4.length);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(13);
        ((RegTLV)localObject).setInt(paramInt2);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(14);
        ((RegTLV)localObject).setData(paramArrayOfByte5, paramArrayOfByte5.length);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(18);
        ((RegTLV)localObject).setData(paramArrayOfByte6, paramArrayOfByte6.length);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(19);
        ((RegTLV)localObject).setData(paramArrayOfByte7, paramArrayOfByte7.length);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(20);
        ((RegTLV)localObject).setData(paramArrayOfByte8, paramArrayOfByte8.length);
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
        localObject = new RegTLV(32);
        ((RegTLV)localObject).setData(paramArrayOfByte9, paramArrayOfByte9.length);
        localObject = ((RegTLV)localObject).getBuf();
        continue;
        localObject = new RegTLV(37);
        ((RegTLV)localObject).setShort(t.au);
        localObject = ((RegTLV)localObject).getBuf();
      }
    }
    paramArrayOfByte3 = new byte[j + 2];
    util.int16_to_buf(paramArrayOfByte3, 0, i);
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
      paramArrayOfByte5.writeByte(paramArrayOfByte10.length);
      paramArrayOfByte5.write(paramArrayOfByte10);
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
 * Qualified Name:     oicq.wlogin_sdk.a.b
 * JD-Core Version:    0.7.0.1
 */