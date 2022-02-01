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
  public HttpNetReq a;
  public long b = 0L;
  private int c;
  private int d;
  private int e;
  private byte[] f;
  private int g;
  private byte[] h;
  private byte[] i;
  private byte[] j;
  private int k;
  private int l;
  private boolean m = true;
  private byte[] n;
  
  static
  {
    SoLoadUtilNew.loadSoByName(BaseApplication.getContext(), "piccryptor");
  }
  
  public PicCryptor(byte[] paramArrayOfByte)
  {
    this.i = paramArrayOfByte;
    this.l = 0;
  }
  
  private int a()
  {
    String str = (String)this.a.mReqProperties.get("Range");
    boolean bool = TextUtils.isEmpty(str);
    int i2 = 0;
    int i1 = i2;
    if (!bool)
    {
      str = str.replace("bytes=", "");
      int i3 = str.indexOf("-");
      i1 = i2;
      if (i3 != -1) {
        i1 = Integer.valueOf(str.substring(0, i3)).intValue();
      }
    }
    return i1;
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
  
  public static String b(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = PkgTools.toHexStr(paramArrayOfByte);
    if (paramArrayOfByte != null) {
      return paramArrayOfByte.toLowerCase();
    }
    throw new IllegalArgumentException("byte2Hex error, byte not null");
  }
  
  private byte[] c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    int i2 = paramArrayOfByte.length;
    byte[] arrayOfByte2 = new byte[i2];
    int i1 = 0;
    byte[] arrayOfByte1;
    for (;;)
    {
      arrayOfByte1 = arrayOfByte2;
      if (i1 >= i2) {
        break label213;
      }
      int i3 = this.k;
      arrayOfByte1 = this.j;
      if (i3 >= arrayOfByte1.length) {
        break;
      }
      int i4 = paramArrayOfByte[i1];
      this.k = (i3 + 1);
      arrayOfByte2[i1] = ((byte)(arrayOfByte1[i3] ^ i4));
      if (this.k == this.d)
      {
        this.l = 2;
        i3 = i1 + 1;
        i4 = i2 - i3;
        if ((i4 == 1) && (paramArrayOfByte[i3] == 41))
        {
          i1 = i2 - 1;
          arrayOfByte1 = new byte[i1];
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, i1);
          break label213;
        }
        if (i4 != 0) {
          throw new IllegalArgumentException("Invalid encrypt data end format");
        }
      }
      i1 += 1;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("decryptKey len overflow! bodyLen:");
    paramArrayOfByte.append(this.d);
    paramArrayOfByte.append(",encryptLen:");
    paramArrayOfByte.append(this.j.length);
    throw new Exception(paramArrayOfByte.toString());
    label213:
    if (this.m)
    {
      this.m = false;
      paramArrayOfByte = new byte[Math.min(20, i2)];
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
    this.c = ((ByteBuffer)localObject).getInt();
    this.d = ((ByteBuffer)localObject).getInt();
    if ((this.c > 0) && (this.d > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, "head or body length is not negative");
    if (this.c + 1 + 8 > paramArrayOfByte.length) {
      return null;
    }
    this.e = ((ByteBuffer)localObject).getShort();
    if (this.e == 1) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, "magic num not equal 1!");
    this.f = new byte[this.c - 2];
    ((ByteBuffer)localObject).get(this.f);
    paramArrayOfByte = a(this.f, this.i);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfByte.length);
    localByteBuffer.put(paramArrayOfByte);
    localByteBuffer.rewind();
    this.g = localByteBuffer.getShort();
    if (this.g > 0) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, "seed len is no allow negative");
    try
    {
      this.h = new byte[this.g];
      localByteBuffer.get(this.h);
      paramArrayOfByte = getISSACSequence(b(this.h), this.d + a()).substring(a() * 2);
      if (paramArrayOfByte == null) {
        return null;
      }
      long l1 = Runtime.getRuntime().totalMemory();
      l1 = Runtime.getRuntime().maxMemory() - (l1 - Runtime.getRuntime().freeMemory());
      if (l1 >= paramArrayOfByte.length() * 3)
      {
        this.j = a(paramArrayOfByte);
        this.l = 1;
        this.k = 0;
        try
        {
          paramArrayOfByte = MessageDigest.getInstance("MD5");
          paramArrayOfByte.update(this.j);
          b(paramArrayOfByte.digest());
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
        int i1 = ((ByteBuffer)localObject).capacity() - ((ByteBuffer)localObject).position();
        if (i1 > 0)
        {
          paramArrayOfByte = new byte[i1];
          ((ByteBuffer)localObject).get(paramArrayOfByte);
          return paramArrayOfByte;
        }
        return null;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkMemoryForEncrypt : memory is not enough ! remainMemory = ");
      ((StringBuilder)localObject).append(l1);
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
    long l1 = SystemClock.uptimeMillis();
    int i1 = this.l;
    Object localObject = null;
    if (i1 == 0)
    {
      byte[] arrayOfByte1 = this.n;
      if (arrayOfByte1 != null)
      {
        byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, 0, paramArrayOfByte.length);
        this.n = arrayOfByte2;
      }
      else
      {
        this.n = paramArrayOfByte;
      }
      arrayOfByte1 = a(this.n);
      paramArrayOfByte = localObject;
      if (this.l == 1)
      {
        paramArrayOfByte = localObject;
        if (arrayOfByte1 != null) {
          paramArrayOfByte = c(arrayOfByte1);
        }
      }
    }
    else if (i1 == 1)
    {
      paramArrayOfByte = c(paramArrayOfByte);
    }
    else
    {
      if ((paramArrayOfByte.length != 1) || (paramArrayOfByte[0] != 41)) {
        break label159;
      }
      paramArrayOfByte = localObject;
    }
    this.b += SystemClock.uptimeMillis() - l1;
    return paramArrayOfByte;
    label159:
    throw new Exception("pic data len is error!");
  }
  
  public native String getISSACSequence(String paramString, int paramInt);
  
  public boolean isFinish()
  {
    return this.l == 2;
  }
  
  public void reset()
  {
    this.l = 0;
    this.m = true;
    this.n = null;
    this.k = 0;
    this.b = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PicCryptor
 * JD-Core Version:    0.7.0.1
 */