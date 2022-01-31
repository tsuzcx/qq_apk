package com.tencent.util;

import android.annotation.SuppressLint;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

@SuppressLint({"NewApi"})
public class FileEncryptUtils
{
  public static final byte[] ENCRYPE_HEAD = { 69, 78, 67, 82 };
  public static final int ENCRYPT_SIZE = 1024;
  
  public static void decryptFile(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new FileOutputStream(new File(paramString2));
      paramString2.write(decryptFile(paramString1));
      paramString2.close();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static byte[] decryptFile(InputStream paramInputStream)
  {
    Object localObject1;
    int i;
    for (;;)
    {
      int k;
      try
      {
        localObject1 = new byte[4];
        paramInputStream.read((byte[])localObject1);
        if ((localObject1[0] != ENCRYPE_HEAD[0]) || (localObject1[1] != ENCRYPE_HEAD[1]) || (localObject1[2] != ENCRYPE_HEAD[2]) || (localObject1[3] != ENCRYPE_HEAD[3])) {
          break label178;
        }
        localObject1 = new ByteArrayOutputStream(readInt(paramInputStream));
        int j = readInt(paramInputStream);
        localObject2 = new byte[j];
        i = paramInputStream.read((byte[])localObject2, 0, j);
        if (i >= j) {
          break;
        }
        k = paramInputStream.read((byte[])localObject2, i, j - i);
        if (-1 == k) {
          throw new RuntimeException("decryptFile: inputStream end before all data read");
        }
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
        return null;
      }
      i += k;
    }
    Log.d("decryptFile m - ", Integer.toString(i));
    Object localObject2 = EncryptUtils.decode((byte[])localObject2);
    ((ByteArrayOutputStream)localObject1).write((byte[])localObject2, 0, localObject2.length);
    IOUtils.copy(paramInputStream, (OutputStream)localObject1);
    return ((ByteArrayOutputStream)localObject1).toByteArray();
    label178:
    localObject2 = new ByteArrayOutputStream();
    ((ByteArrayOutputStream)localObject2).write((byte[])localObject1);
    IOUtils.copy(paramInputStream, (OutputStream)localObject2);
    paramInputStream = ((ByteArrayOutputStream)localObject2).toByteArray();
    return paramInputStream;
  }
  
  public static byte[] decryptFile(String paramString)
  {
    try
    {
      paramString = new DataInputStream(new FileInputStream(new File(paramString)));
      byte[] arrayOfByte = decryptFile(paramString);
      paramString.close();
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void encryptAllFile(String paramString1, String paramString2)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(new File(paramString1));
      paramString1 = IOUtils.toByteArray(localFileInputStream);
      localFileInputStream.close();
      paramString2 = new DataOutputStream(new FileOutputStream(new File(paramString2)));
      paramString2.write(ENCRYPE_HEAD);
      writeInt(paramString2, paramString1.length);
      paramString1 = EncryptUtils.encode(paramString1);
      writeInt(paramString2, paramString1.length);
      paramString2.write(paramString1);
      paramString2.close();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
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
      for (;;)
      {
        paramString.close();
        return;
        writeInt(paramString, paramArrayOfByte.length);
        paramArrayOfByte = EncryptUtils.encode(paramArrayOfByte);
        writeInt(paramString, paramArrayOfByte.length);
        paramString.write(paramArrayOfByte);
      }
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
    throws IOException
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    int k = paramInputStream.read();
    int m = paramInputStream.read();
    if ((i | j | k | m) < 0) {
      throw new EOFException();
    }
    return (i << 24) + (j << 16) + (k << 8) + (m << 0);
  }
  
  static void writeInt(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.util.FileEncryptUtils
 * JD-Core Version:    0.7.0.1
 */