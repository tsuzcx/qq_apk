package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.HttpNetReq.IFlowDecoder;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.HashMap;

public class PicCryptor
  implements HttpNetReq.IFlowDecoder
{
  private int jdField_a_of_type_Int;
  public long a;
  public HttpNetReq a;
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
    String str = (String)this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.a.get("Range");
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
    paramArrayOfByte = PkgTools.a(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("byte2Hex error, byte not null");
    }
    return paramArrayOfByte.toLowerCase();
  }
  
  private void a(String paramString1, String paramString2)
  {
    QLog.i("T.Q.richmedia." + RichMediaUtil.b(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.g) + "." + RichMediaUtil.c(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.f) + ".PicDecoder", 1, "id:" + this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.e + " " + paramString1 + " : " + paramString2);
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static byte[] a(String paramString)
  {
    paramString = PkgTools.a(paramString);
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
      a("XOR", "len=" + i);
      arrayOfByte1 = paramArrayOfByte;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      arrayOfByte1 = new byte[Math.min(20, j)];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, arrayOfByte1.length);
      a("CheckAndLog", "hex:" + a(arrayOfByte1));
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
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfByte.length);
    localByteBuffer.put(paramArrayOfByte);
    localByteBuffer.rewind();
    if (localByteBuffer.get() == 40)
    {
      bool = true;
      a(bool, "Invalid encrypt data start format");
      this.jdField_a_of_type_Int = localByteBuffer.getInt();
      this.jdField_b_of_type_Int = localByteBuffer.getInt();
      if ((this.jdField_a_of_type_Int <= 0) || (this.jdField_b_of_type_Int <= 0)) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      a(bool, "head or body length is not negative");
      if (this.jdField_a_of_type_Int + 1 + 8 <= paramArrayOfByte.length) {
        break label105;
      }
      return null;
      bool = false;
      break;
    }
    label105:
    this.jdField_c_of_type_Int = localByteBuffer.getShort();
    Object localObject;
    if (this.jdField_c_of_type_Int == 1)
    {
      bool = true;
      a(bool, "magic num not equal 1!");
      this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int - 2];
      localByteBuffer.get(this.jdField_a_of_type_ArrayOfByte);
      paramArrayOfByte = a(this.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_ArrayOfByte);
      localObject = ByteBuffer.allocate(paramArrayOfByte.length);
      ((ByteBuffer)localObject).put(paramArrayOfByte);
      ((ByteBuffer)localObject).rewind();
      this.jdField_d_of_type_Int = ((ByteBuffer)localObject).getShort();
      if (this.jdField_d_of_type_Int <= 0) {
        break label399;
      }
    }
    label399:
    for (bool = true;; bool = false)
    {
      a(bool, "seed len is no allow negative");
      this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_d_of_type_Int];
      ((ByteBuffer)localObject).get(this.jdField_b_of_type_ArrayOfByte);
      this.jdField_d_of_type_ArrayOfByte = a(getISSACSequence(a(this.jdField_b_of_type_ArrayOfByte), this.jdField_b_of_type_Int + a()).substring(a() * 2));
      this.f = 1;
      this.jdField_e_of_type_Int = 0;
      paramArrayOfByte = "";
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(this.jdField_d_of_type_ArrayOfByte);
        localObject = a(((MessageDigest)localObject).digest());
        paramArrayOfByte = (byte[])localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          localException.printStackTrace();
        }
      }
      a("HeaderDec", "result: succ, mBodyLen=" + this.jdField_b_of_type_Int + ",mSeed=" + a(this.jdField_b_of_type_ArrayOfByte) + ",MD5:" + paramArrayOfByte);
      i = localByteBuffer.capacity() - localByteBuffer.position();
      if (i <= 0) {
        break label414;
      }
      paramArrayOfByte = new byte[i];
      localByteBuffer.get(paramArrayOfByte);
      return paramArrayOfByte;
      bool = false;
      break;
    }
    label414:
    return null;
  }
  
  public native String getISSACSequence(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PicCryptor
 * JD-Core Version:    0.7.0.1
 */