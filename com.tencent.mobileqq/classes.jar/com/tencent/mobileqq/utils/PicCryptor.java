package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.HttpNetReq.IFlowDecoder;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
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
    SoLoadUtilNew.loadSoByName(BaseApplication.getContext(), "piccryptor");
  }
  
  public PicCryptor(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_ArrayOfByte = paramArrayOfByte;
    this.f = 0;
  }
  
  private int a()
  {
    String str = (String)this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.mReqProperties.get("Range");
    boolean bool = TextUtils.isEmpty(str);
    int j = 0;
    int i = j;
    if (!bool)
    {
      str = str.replace("bytes=", "");
      int k = str.indexOf("-");
      i = j;
      if (k != -1) {
        i = Integer.valueOf(str.substring(0, k)).intValue();
      }
    }
    return i;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = PkgTools.toHexStr(paramArrayOfByte);
    if (paramArrayOfByte != null) {
      return paramArrayOfByte.toLowerCase();
    }
    throw new IllegalArgumentException("byte2Hex error, byte not null");
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static byte[] a(String paramString)
  {
    paramString = PkgTools.hexToBytes(paramString);
    if (paramString != null) {
      return paramString;
    }
    throw new IllegalArgumentException("hex2byte error, hexStr length must even");
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2);
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length >= 0)) {
      return paramArrayOfByte1;
    }
    throw new Exception("Tea Decrypt Error ! ");
  }
  
  private byte[] b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    int j = paramArrayOfByte.length;
    byte[] arrayOfByte2 = new byte[j];
    int i = 0;
    byte[] arrayOfByte1;
    for (;;)
    {
      arrayOfByte1 = arrayOfByte2;
      if (i >= j) {
        break label213;
      }
      int k = this.jdField_e_of_type_Int;
      arrayOfByte1 = this.jdField_d_of_type_ArrayOfByte;
      if (k >= arrayOfByte1.length) {
        break;
      }
      int m = paramArrayOfByte[i];
      this.jdField_e_of_type_Int = (k + 1);
      arrayOfByte2[i] = ((byte)(arrayOfByte1[k] ^ m));
      if (this.jdField_e_of_type_Int == this.jdField_b_of_type_Int)
      {
        this.f = 2;
        k = i + 1;
        m = j - k;
        if ((m == 1) && (paramArrayOfByte[k] == 41))
        {
          i = j - 1;
          arrayOfByte1 = new byte[i];
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, i);
          break label213;
        }
        if (m != 0) {
          throw new IllegalArgumentException("Invalid encrypt data end format");
        }
      }
      i += 1;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("decryptKey len overflow! bodyLen:");
    paramArrayOfByte.append(this.jdField_b_of_type_Int);
    paramArrayOfByte.append(",encryptLen:");
    paramArrayOfByte.append(this.jdField_d_of_type_ArrayOfByte.length);
    throw new Exception(paramArrayOfByte.toString());
    label213:
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      paramArrayOfByte = new byte[Math.min(20, j)];
      System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    return arrayOfByte1;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject = ByteBuffer.allocate(paramArrayOfByte.length);
    ((ByteBuffer)localObject).put(paramArrayOfByte);
    ((ByteBuffer)localObject).rewind();
    boolean bool;
    if (((ByteBuffer)localObject).get() == 40) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, "Invalid encrypt data start format");
    this.jdField_a_of_type_Int = ((ByteBuffer)localObject).getInt();
    this.jdField_b_of_type_Int = ((ByteBuffer)localObject).getInt();
    if ((this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, "head or body length is not negative");
    if (this.jdField_a_of_type_Int + 1 + 8 > paramArrayOfByte.length) {
      return null;
    }
    this.jdField_c_of_type_Int = ((ByteBuffer)localObject).getShort();
    if (this.jdField_c_of_type_Int == 1) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, "magic num not equal 1!");
    this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int - 2];
    ((ByteBuffer)localObject).get(this.jdField_a_of_type_ArrayOfByte);
    paramArrayOfByte = a(this.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_ArrayOfByte);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfByte.length);
    localByteBuffer.put(paramArrayOfByte);
    localByteBuffer.rewind();
    this.jdField_d_of_type_Int = localByteBuffer.getShort();
    if (this.jdField_d_of_type_Int > 0) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, "seed len is no allow negative");
    try
    {
      this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_d_of_type_Int];
      localByteBuffer.get(this.jdField_b_of_type_ArrayOfByte);
      paramArrayOfByte = getISSACSequence(a(this.jdField_b_of_type_ArrayOfByte), this.jdField_b_of_type_Int + a()).substring(a() * 2);
      if (paramArrayOfByte == null) {
        return null;
      }
      long l = Runtime.getRuntime().totalMemory();
      l = Runtime.getRuntime().maxMemory() - (l - Runtime.getRuntime().freeMemory());
      if (l >= paramArrayOfByte.length() * 3)
      {
        this.jdField_d_of_type_ArrayOfByte = a(paramArrayOfByte);
        this.f = 1;
        this.jdField_e_of_type_Int = 0;
        try
        {
          paramArrayOfByte = MessageDigest.getInstance("MD5");
          paramArrayOfByte.update(this.jdField_d_of_type_ArrayOfByte);
          a(paramArrayOfByte.digest());
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
        int i = ((ByteBuffer)localObject).capacity() - ((ByteBuffer)localObject).position();
        if (i > 0)
        {
          paramArrayOfByte = new byte[i];
          ((ByteBuffer)localObject).get(paramArrayOfByte);
          return paramArrayOfByte;
        }
        return null;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkMemoryForEncrypt : memory is not enough ! remainMemory = ");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(", flowKeyHexStr.length() = ");
      ((StringBuilder)localObject).append(paramArrayOfByte.length());
      QLog.e("PicCryptor", 1, ((StringBuilder)localObject).toString());
      throw new Exception("applying memory too large!");
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    long l = SystemClock.uptimeMillis();
    int i = this.f;
    Object localObject = null;
    if (i == 0)
    {
      byte[] arrayOfByte1 = this.jdField_e_of_type_ArrayOfByte;
      if (arrayOfByte1 != null)
      {
        byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, 0, paramArrayOfByte.length);
        this.jdField_e_of_type_ArrayOfByte = arrayOfByte2;
      }
      else
      {
        this.jdField_e_of_type_ArrayOfByte = paramArrayOfByte;
      }
      arrayOfByte1 = a(this.jdField_e_of_type_ArrayOfByte);
      paramArrayOfByte = localObject;
      if (this.f == 1)
      {
        paramArrayOfByte = localObject;
        if (arrayOfByte1 != null) {
          paramArrayOfByte = b(arrayOfByte1);
        }
      }
    }
    else if (i == 1)
    {
      paramArrayOfByte = b(paramArrayOfByte);
    }
    else
    {
      if ((paramArrayOfByte.length != 1) || (paramArrayOfByte[0] != 41)) {
        break label159;
      }
      paramArrayOfByte = localObject;
    }
    this.jdField_a_of_type_Long += SystemClock.uptimeMillis() - l;
    return paramArrayOfByte;
    label159:
    throw new Exception("pic data len is error!");
  }
  
  public native String getISSACSequence(String paramString, int paramInt);
  
  public boolean isFinish()
  {
    return this.f == 2;
  }
  
  public void reset()
  {
    this.f = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_e_of_type_ArrayOfByte = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PicCryptor
 * JD-Core Version:    0.7.0.1
 */