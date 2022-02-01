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
    int m = tmp8_6.length;
    int j = 0;
    int k = 0;
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = paramArrayOfByte5;
      Object localObject2 = paramArrayOfByte4;
      Object localObject1 = paramArrayOfByte3;
      if (j >= m) {
        break;
      }
      int n = tmp8_6[j];
      if (n != 2)
      {
        if (n != 3)
        {
          if (n != 10)
          {
            if (n != 37)
            {
              if (n != 13)
              {
                if (n != 14)
                {
                  if (n != 23)
                  {
                    if (n != 24)
                    {
                      switch (n)
                      {
                      default: 
                        localObject1 = new byte[0];
                        break;
                      case 20: 
                        localObject1 = new RegTLV(20);
                        ((RegTLV)localObject1).setData(paramArrayOfByte7, paramArrayOfByte7.length);
                        localObject1 = ((RegTLV)localObject1).getBuf();
                        break;
                      case 19: 
                        localObject1 = new RegTLV(19);
                        ((RegTLV)localObject1).setData(paramArrayOfByte6, paramArrayOfByte6.length);
                        localObject1 = ((RegTLV)localObject1).getBuf();
                        break;
                      case 18: 
                        localObject1 = new RegTLV(18);
                        ((RegTLV)localObject1).setData(arrayOfByte, arrayOfByte.length);
                        localObject1 = ((RegTLV)localObject1).getBuf();
                        break;
                      }
                    }
                    else
                    {
                      localObject1 = new RegTLV(24);
                      ((RegTLV)localObject1).setData(t.K, t.K.length);
                      localObject1 = ((RegTLV)localObject1).getBuf();
                    }
                  }
                  else
                  {
                    localObject1 = new RegTLV(23);
                    ((RegTLV)localObject1).setByte((byte)5);
                    localObject1 = ((RegTLV)localObject1).getBuf();
                  }
                }
                else
                {
                  localObject1 = new RegTLV(14);
                  ((RegTLV)localObject1).setData((byte[])localObject2, localObject2.length);
                  localObject1 = ((RegTLV)localObject1).getBuf();
                }
              }
              else
              {
                localObject1 = new RegTLV(13);
                ((RegTLV)localObject1).setInt(paramInt2);
                localObject1 = ((RegTLV)localObject1).getBuf();
              }
            }
            else
            {
              localObject1 = new RegTLV(37);
              ((RegTLV)localObject1).setShort(t.aA);
              localObject1 = ((RegTLV)localObject1).getBuf();
            }
          }
          else
          {
            localObject2 = new RegTLV(10);
            ((RegTLV)localObject2).setData((byte[])localObject1, localObject1.length);
            localObject1 = ((RegTLV)localObject2).getBuf();
          }
        }
        else
        {
          localObject1 = new RegTLV(3);
          ((RegTLV)localObject1).setByte(paramByte2);
          localObject1 = ((RegTLV)localObject1).getBuf();
        }
      }
      else
      {
        localObject1 = new RegTLV(2);
        ((RegTLV)localObject1).setInt(paramInt1);
        localObject1 = ((RegTLV)localObject1).getBuf();
      }
      if (localObject1.length > 4)
      {
        i += 1;
        k += localObject1.length;
        localArrayList.add(localObject1);
      }
      j += 1;
    }
    paramArrayOfByte3 = new byte[k + 2];
    util.int16_to_buf(paramArrayOfByte3, 0, (short)i);
    paramInt2 = 0;
    j = 2;
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
      if (paramArrayOfByte1 == null) {}
      try
      {
        util.LOGI("encrypt failed", "");
        return null;
      }
      catch (Exception paramArrayOfByte1) {}
      paramArrayOfByte5.writeShort(paramArrayOfByte1.length);
      paramArrayOfByte5.write(paramArrayOfByte1);
      paramArrayOfByte1 = paramArrayOfByte4.toByteArray();
      paramArrayOfByte5.close();
      paramArrayOfByte4.close();
      try
      {
        paramArrayOfByte1 = a(paramArrayOfByte1);
        return paramArrayOfByte1;
      }
      catch (Exception paramArrayOfByte1) {}
      paramArrayOfByte2 = new StringBuilder();
    }
    catch (Exception paramArrayOfByte1) {}
    paramArrayOfByte2.append("getRequest failed ");
    paramArrayOfByte2.append(paramArrayOfByte1.getMessage());
    paramArrayOfByte1 = paramArrayOfByte2.toString();
    paramArrayOfByte2 = new StringBuilder();
    paramArrayOfByte2.append("");
    paramArrayOfByte2.append(paramLong);
    util.LOGI(paramArrayOfByte1, paramArrayOfByte2.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.a.a
 * JD-Core Version:    0.7.0.1
 */