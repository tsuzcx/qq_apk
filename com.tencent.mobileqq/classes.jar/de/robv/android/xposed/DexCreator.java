package de.robv.android.xposed;

import android.os.Environment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.Adler32;

class DexCreator
{
  public static File DALVIK_CACHE = new File(Environment.getDataDirectory(), "dalvik-cache");
  
  public static byte[] create(String paramString1, String paramString2)
  {
    int i;
    int j;
    int k;
    int m;
    ByteArrayOutputStream localByteArrayOutputStream;
    label283:
    label311:
    label329:
    String str;
    if (paramString1.compareTo(paramString2) < 0)
    {
      i = 1;
      paramString1 = stringToBytes("L" + paramString1.replace('.', '/') + ";");
      paramString2 = stringToBytes("L" + paramString2.replace('.', '/') + ";");
      j = paramString1.length + paramString2.length;
      k = -j & 0x3;
      m = j + k;
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localByteArrayOutputStream.write("".getBytes());
      localByteArrayOutputStream.write(new byte[24]);
      writeInt(localByteArrayOutputStream, m + 252);
      writeInt(localByteArrayOutputStream, 112);
      writeInt(localByteArrayOutputStream, 305419896);
      writeInt(localByteArrayOutputStream, 0);
      writeInt(localByteArrayOutputStream, 0);
      writeInt(localByteArrayOutputStream, m + 164);
      writeInt(localByteArrayOutputStream, 2);
      writeInt(localByteArrayOutputStream, 112);
      writeInt(localByteArrayOutputStream, 2);
      writeInt(localByteArrayOutputStream, 120);
      writeInt(localByteArrayOutputStream, 0);
      writeInt(localByteArrayOutputStream, 0);
      writeInt(localByteArrayOutputStream, 0);
      writeInt(localByteArrayOutputStream, 0);
      writeInt(localByteArrayOutputStream, 0);
      writeInt(localByteArrayOutputStream, 0);
      writeInt(localByteArrayOutputStream, 1);
      writeInt(localByteArrayOutputStream, 128);
      writeInt(localByteArrayOutputStream, m + 92);
      writeInt(localByteArrayOutputStream, 160);
      writeInt(localByteArrayOutputStream, 160);
      if (i == 0) {
        break label511;
      }
      j = paramString1.length;
      writeInt(localByteArrayOutputStream, j + 160);
      writeInt(localByteArrayOutputStream, 0);
      writeInt(localByteArrayOutputStream, 1);
      if (i == 0) {
        break label517;
      }
      j = 0;
      writeInt(localByteArrayOutputStream, j);
      writeInt(localByteArrayOutputStream, 1);
      if (i == 0) {
        break label522;
      }
      j = 1;
      writeInt(localByteArrayOutputStream, j);
      writeInt(localByteArrayOutputStream, 0);
      writeInt(localByteArrayOutputStream, -1);
      writeInt(localByteArrayOutputStream, 0);
      writeInt(localByteArrayOutputStream, 0);
      writeInt(localByteArrayOutputStream, 0);
      if (i == 0) {
        break label527;
      }
      str = paramString1;
      label372:
      localByteArrayOutputStream.write(str);
      if (i == 0) {
        break label533;
      }
    }
    for (;;)
    {
      localByteArrayOutputStream.write(paramString2);
      localByteArrayOutputStream.write(new byte[k]);
      writeInt(localByteArrayOutputStream, 0);
      writeInt(localByteArrayOutputStream, 7);
      writeMapItem(localByteArrayOutputStream, 0, 1, 0);
      writeMapItem(localByteArrayOutputStream, 1, 2, 112);
      writeMapItem(localByteArrayOutputStream, 2, 2, 120);
      writeMapItem(localByteArrayOutputStream, 6, 1, 128);
      writeMapItem(localByteArrayOutputStream, 8194, 2, 160);
      writeMapItem(localByteArrayOutputStream, 4099, 1, m + 160);
      writeMapItem(localByteArrayOutputStream, 4096, 1, m + 164);
      paramString1 = localByteArrayOutputStream.toByteArray();
      updateSignature(paramString1);
      updateChecksum(paramString1);
      return paramString1;
      i = 0;
      break;
      label511:
      j = paramString2.length;
      break label283;
      label517:
      j = 1;
      break label311;
      label522:
      j = 0;
      break label329;
      label527:
      str = paramString2;
      break label372;
      label533:
      paramString2 = paramString1;
    }
  }
  
  public static File ensure(File paramFile, String paramString1, String paramString2)
  {
    try
    {
      if (matches(XposedHelpers.inputStreamToByteArray(new FileInputStream(paramFile)), paramString1, paramString2)) {
        return paramFile;
      }
      paramFile.delete();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        paramFile.delete();
      }
    }
    paramString1 = create(paramString1, paramString2);
    paramString2 = new FileOutputStream(paramFile);
    paramString2.write(paramString1);
    paramString2.close();
    return paramFile;
  }
  
  public static File ensure(String paramString, Class<?> paramClass)
  {
    return ensure(getDefaultFile(paramString), paramString, paramClass.getName());
  }
  
  public static File ensure(String paramString, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (!paramClass2.isAssignableFrom(paramClass1)) {
      throw new ClassCastException("Cannot initialize " + paramString + " because " + paramClass1 + " does not extend " + paramClass2);
    }
    try
    {
      paramClass1 = ensure("xposed.dummy." + paramString + "SuperClass", paramClass1);
      return paramClass1;
    }
    catch (IOException paramClass1)
    {
      throw new IOException("Failed to create a superclass for " + paramString, paramClass1);
    }
  }
  
  public static File getDefaultFile(String paramString)
  {
    return new File(DALVIK_CACHE, "xposed_" + paramString.substring(paramString.lastIndexOf('.') + 1) + ".dex");
  }
  
  public static boolean matches(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    if (paramString1.compareTo(paramString2) < 0) {}
    int i;
    for (int j = 1;; j = 0)
    {
      paramString1 = stringToBytes("L" + paramString1.replace('.', '/') + ";");
      paramString2 = stringToBytes("L" + paramString2.replace('.', '/') + ";");
      i = 160;
      if (paramString1.length + 160 + paramString2.length < paramArrayOfByte.length) {
        break;
      }
      return false;
    }
    if (j != 0) {}
    int m;
    int k;
    for (String str = paramString1;; str = paramString2)
    {
      m = str.length;
      k = 0;
      for (;;)
      {
        if (k >= m) {
          break label164;
        }
        int n = str[k];
        if (paramArrayOfByte[i] != n) {
          break;
        }
        k += 1;
        i += 1;
      }
    }
    label164:
    if (j != 0) {}
    for (;;)
    {
      k = paramString2.length;
      j = 0;
      for (;;)
      {
        if (j >= k) {
          break label215;
        }
        m = paramString2[j];
        if (paramArrayOfByte[i] != m) {
          break;
        }
        j += 1;
        i += 1;
      }
      paramString2 = paramString1;
    }
    label215:
    return true;
  }
  
  private static byte[] stringToBytes(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    writeUleb128(localByteArrayOutputStream, paramString.length());
    localByteArrayOutputStream.write(paramString.getBytes("UTF-8"));
    localByteArrayOutputStream.write(0);
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static void updateChecksum(byte[] paramArrayOfByte)
  {
    Adler32 localAdler32 = new Adler32();
    localAdler32.update(paramArrayOfByte, 12, paramArrayOfByte.length - 12);
    int i = (int)localAdler32.getValue();
    paramArrayOfByte[8] = ((byte)(i & 0xFF));
    paramArrayOfByte[9] = ((byte)(i >> 8 & 0xFF));
    paramArrayOfByte[10] = ((byte)(i >> 16 & 0xFF));
    paramArrayOfByte[11] = ((byte)(i >> 24 & 0xFF));
  }
  
  private static void updateSignature(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramArrayOfByte, 32, paramArrayOfByte.length - 32);
      localMessageDigest.digest(paramArrayOfByte, 12, 20);
      return;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
    catch (DigestException paramArrayOfByte)
    {
      label30:
      break label30;
    }
  }
  
  private static void writeInt(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(paramInt);
    paramOutputStream.write(paramInt >> 8);
    paramOutputStream.write(paramInt >> 16);
    paramOutputStream.write(paramInt >> 24);
  }
  
  private static void writeMapItem(OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3)
  {
    writeInt(paramOutputStream, paramInt1);
    writeInt(paramOutputStream, paramInt2);
    writeInt(paramOutputStream, paramInt3);
  }
  
  private static void writeUleb128(OutputStream paramOutputStream, int paramInt)
  {
    while (paramInt > 127)
    {
      paramOutputStream.write(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
    paramOutputStream.write(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.DexCreator
 * JD-Core Version:    0.7.0.1
 */