package com.tencent.ttpic.baseutils.encrypt;

import android.annotation.SuppressLint;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

@SuppressLint({"NewApi"})
public class FileEncryptUtils
{
  public static final byte[] ENCRYPE_HEAD = { 69, 78, 67, 82 };
  public static final int ENCRYPT_SIZE = 1024;
  
  public static byte[] decryptFile(InputStream paramInputStream)
  {
    try
    {
      Object localObject1 = new byte[4];
      paramInputStream.read((byte[])localObject1);
      if ((localObject1[0] == ENCRYPE_HEAD[0]) && (localObject1[1] == ENCRYPE_HEAD[1]) && (localObject1[2] == ENCRYPE_HEAD[2]) && (localObject1[3] == ENCRYPE_HEAD[3]))
      {
        localObject1 = new ByteArrayOutputStream(readInt(paramInputStream));
        int j = readInt(paramInputStream);
        localObject2 = new byte[j];
        int i = paramInputStream.read((byte[])localObject2, 0, j);
        while (i < j)
        {
          int k = paramInputStream.read((byte[])localObject2, i, j - i);
          if (-1 != k) {
            i += k;
          } else {
            throw new RuntimeException("decryptFile: inputStream end before all data read");
          }
        }
        LogUtils.d("decryptFile m - ", Integer.toString(i));
        localObject2 = EncryptUtils.decode((byte[])localObject2);
        ((ByteArrayOutputStream)localObject1).write((byte[])localObject2, 0, localObject2.length);
        IOUtils.copy(paramInputStream, (OutputStream)localObject1);
        return ((ByteArrayOutputStream)localObject1).toByteArray();
      }
      Object localObject2 = new ByteArrayOutputStream();
      ((ByteArrayOutputStream)localObject2).write((byte[])localObject1);
      IOUtils.copy(paramInputStream, (OutputStream)localObject2);
      paramInputStream = ((ByteArrayOutputStream)localObject2).toByteArray();
      return paramInputStream;
    }
    catch (AssertionError paramInputStream)
    {
      LogUtils.e("FileEncryptUtils", paramInputStream.toString());
    }
    catch (OutOfMemoryError paramInputStream)
    {
      LogUtils.e("FileEncryptUtils", "decryptFile OOM");
      paramInputStream.printStackTrace();
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return null;
  }
  
  public static void encryptByte2File(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramString = new DataOutputStream(new FileOutputStream(new File(paramString)));
      paramString.write(ENCRYPE_HEAD);
      if (paramArrayOfByte.length > 1024)
      {
        writeInt(paramString, paramArrayOfByte.length);
        byte[] arrayOfByte = EncryptUtils.encode(Arrays.copyOfRange(paramArrayOfByte, 0, 1024));
        writeInt(paramString, arrayOfByte.length);
        paramString.write(arrayOfByte);
        paramString.write(paramArrayOfByte, 1024, paramArrayOfByte.length - 1024);
      }
      else
      {
        writeInt(paramString, paramArrayOfByte.length);
        paramArrayOfByte = EncryptUtils.encode(paramArrayOfByte);
        writeInt(paramString, paramArrayOfByte.length);
        paramString.write(paramArrayOfByte);
      }
      paramString.close();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public static void encryptFile(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new FileInputStream(new File(paramString1));
      byte[] arrayOfByte = IOUtils.toByteArray(paramString1);
      paramString1.close();
      encryptByte2File(arrayOfByte, paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  static int readInt(InputStream paramInputStream)
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    int k = paramInputStream.read();
    int m = paramInputStream.read();
    if ((i | j | k | m) >= 0) {
      return (i << 24) + (j << 16) + (k << 8) + (m << 0);
    }
    throw new EOFException();
  }
  
  static void writeInt(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.encrypt.FileEncryptUtils
 * JD-Core Version:    0.7.0.1
 */