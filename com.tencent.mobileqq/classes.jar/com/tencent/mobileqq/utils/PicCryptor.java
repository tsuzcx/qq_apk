package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import baps;
import bapu;
import bdlr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.HashMap;

public class PicCryptor
  implements bapu
{
  private int jdField_a_of_type_Int;
  public long a;
  public baps a;
  private boolean jdField_a_of_type_Boolean = true;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int jdField_d_of_type_Int;
  private byte[] jdField_d_of_type_ArrayOfByte;
  private int jdField_e_of_type_Int;
  private byte[] jdField_e_of_type_ArrayOfByte;
  private int f;
  
  static
  {
    SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "piccryptor");
  }
  
  public PicCryptor(byte[] paramArrayOfByte)
  {
    this.jdField_c_of_type_ArrayOfByte = paramArrayOfByte;
    this.f = 0;
  }
  
  private int a()
  {
    String str = (String)this.jdField_a_of_type_Baps.a.get("Range");
    if (!TextUtils.isEmpty(str))
    {
      str = str.replace("bytes=", "");
      int i = str.indexOf("-");
      if (i != -1) {
        return Integer.valueOf(str.substring(0, i)).intValue();
      }
    }
    return 0;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = bdlr.a(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("byte2Hex error, byte not null");
    }
    return paramArrayOfByte.toLowerCase();
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static byte[] a(String paramString)
  {
    paramString = bdlr.a(paramString);
    if (paramString == null) {
      throw new IllegalArgumentException("hex2byte error, hexStr length must even");
    }
    return paramString;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2);
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length < 0)) {
      throw new Exception("Tea Decrypt Error ! ");
    }
    return paramArrayOfByte1;
  }
  
  private byte[] c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      arrayOfByte1 = null;
      return arrayOfByte1;
    }
    int j = paramArrayOfByte.length;
    byte[] arrayOfByte1 = new byte[j];
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      if (this.jdField_e_of_type_Int >= this.jdField_d_of_type_ArrayOfByte.length) {
        throw new Exception("decryptKey len overflow! bodyLen:" + this.jdField_b_of_type_Int + ",encryptLen:" + this.jdField_d_of_type_ArrayOfByte.length);
      }
      k = paramArrayOfByte[i];
      byte[] arrayOfByte2 = this.jdField_d_of_type_ArrayOfByte;
      int m = this.jdField_e_of_type_Int;
      this.jdField_e_of_type_Int = (m + 1);
      arrayOfByte1[i] = ((byte)(k ^ arrayOfByte2[m]));
      if (this.jdField_e_of_type_Int == this.jdField_b_of_type_Int)
      {
        this.f = 2;
        k = j - (i + 1);
        if ((k == 1) && (paramArrayOfByte[(i + 1)] == 41))
        {
          paramArrayOfByte = new byte[j - 1];
          System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, 0, j - 1);
        }
      }
    }
    for (;;)
    {
      arrayOfByte1 = paramArrayOfByte;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      arrayOfByte1 = new byte[Math.min(20, j)];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, arrayOfByte1.length);
      return paramArrayOfByte;
      if (k != 0) {
        throw new IllegalArgumentException("Invalid encrypt data end format");
      }
      i += 1;
      break label20;
      paramArrayOfByte = arrayOfByte1;
    }
  }
  
  public void a()
  {
    this.f = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_e_of_type_ArrayOfByte = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public boolean a()
  {
    return this.f == 2;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    long l1 = SystemClock.uptimeMillis();
    Object localObject1;
    if (this.f == 0) {
      if (this.jdField_e_of_type_ArrayOfByte != null)
      {
        localObject1 = new byte[this.jdField_e_of_type_ArrayOfByte.length + paramArrayOfByte.length];
        System.arraycopy(this.jdField_e_of_type_ArrayOfByte, 0, localObject1, 0, this.jdField_e_of_type_ArrayOfByte.length);
        System.arraycopy(paramArrayOfByte, 0, localObject1, 0, paramArrayOfByte.length);
        this.jdField_e_of_type_ArrayOfByte = ((byte[])localObject1);
        paramArrayOfByte = b(this.jdField_e_of_type_ArrayOfByte);
        localObject1 = localObject2;
        if (this.f == 1)
        {
          localObject1 = localObject2;
          if (paramArrayOfByte != null) {
            localObject1 = c(paramArrayOfByte);
          }
        }
      }
    }
    label148:
    do
    {
      for (;;)
      {
        long l2 = this.jdField_a_of_type_Long;
        this.jdField_a_of_type_Long = (SystemClock.uptimeMillis() - l1 + l2);
        return localObject1;
        this.jdField_e_of_type_ArrayOfByte = paramArrayOfByte;
        break;
        if (this.f != 1) {
          break label148;
        }
        localObject1 = c(paramArrayOfByte);
      }
      if (paramArrayOfByte.length != 1) {
        break label166;
      }
      localObject1 = localObject2;
    } while (paramArrayOfByte[0] == 41);
    label166:
    throw new Exception("pic data len is error!");
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(paramArrayOfByte.length);
    localByteBuffer1.put(paramArrayOfByte);
    localByteBuffer1.rewind();
    if (localByteBuffer1.get() == 40)
    {
      bool1 = true;
      a(bool1, "Invalid encrypt data start format");
      this.jdField_a_of_type_Int = localByteBuffer1.getInt();
      this.jdField_b_of_type_Int = localByteBuffer1.getInt();
      if ((this.jdField_a_of_type_Int <= 0) || (this.jdField_b_of_type_Int <= 0)) {
        break label102;
      }
    }
    label102:
    for (boolean bool1 = true;; bool1 = false)
    {
      a(bool1, "head or body length is not negative");
      if (this.jdField_a_of_type_Int + 1 + 8 <= paramArrayOfByte.length) {
        break label107;
      }
      return null;
      bool1 = false;
      break;
    }
    label107:
    this.jdField_c_of_type_Int = localByteBuffer1.getShort();
    ByteBuffer localByteBuffer2;
    if (this.jdField_c_of_type_Int == 1)
    {
      bool1 = true;
      a(bool1, "magic num not equal 1!");
      this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int - 2];
      localByteBuffer1.get(this.jdField_a_of_type_ArrayOfByte);
      paramArrayOfByte = a(this.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_ArrayOfByte);
      localByteBuffer2 = ByteBuffer.allocate(paramArrayOfByte.length);
      localByteBuffer2.put(paramArrayOfByte);
      localByteBuffer2.rewind();
      this.jdField_d_of_type_Int = localByteBuffer2.getShort();
      if (this.jdField_d_of_type_Int <= 0) {
        break label450;
      }
    }
    label450:
    for (bool1 = bool2;; bool1 = false)
    {
      a(bool1, "seed len is no allow negative");
      try
      {
        this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_d_of_type_Int];
        localByteBuffer2.get(this.jdField_b_of_type_ArrayOfByte);
        paramArrayOfByte = getISSACSequence(a(this.jdField_b_of_type_ArrayOfByte), this.jdField_b_of_type_Int + a()).substring(a() * 2);
        if (paramArrayOfByte == null) {
          return null;
        }
        long l = Runtime.getRuntime().totalMemory();
        l = Runtime.getRuntime().maxMemory() - (l - Runtime.getRuntime().freeMemory());
        if (l < paramArrayOfByte.length() * 3)
        {
          QLog.e("PicCryptor", 1, "checkMemoryForEncrypt : memory is not enough ! remainMemory = " + l + ", flowKeyHexStr.length() = " + paramArrayOfByte.length());
          throw new Exception("applying memory too large!");
        }
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      this.jdField_d_of_type_ArrayOfByte = a(paramArrayOfByte);
      this.f = 1;
      this.jdField_e_of_type_Int = 0;
      try
      {
        paramArrayOfByte = MessageDigest.getInstance("MD5");
        paramArrayOfByte.update(this.jdField_d_of_type_ArrayOfByte);
        a(paramArrayOfByte.digest());
        int i = localByteBuffer1.capacity() - localByteBuffer1.position();
        if (i > 0)
        {
          paramArrayOfByte = new byte[i];
          localByteBuffer1.get(paramArrayOfByte);
          return paramArrayOfByte;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
      return null;
      bool1 = false;
      break;
    }
  }
  
  public native String getISSACSequence(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PicCryptor
 * JD-Core Version:    0.7.0.1
 */