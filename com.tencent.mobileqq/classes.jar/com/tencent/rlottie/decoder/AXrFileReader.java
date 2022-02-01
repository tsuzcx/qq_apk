package com.tencent.rlottie.decoder;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AXrFileReader
{
  private static final ThreadLocal<byte[]> a = new ThreadLocal();
  private static final ThreadLocal<byte[]> b = new ThreadLocal();
  
  public static String a(File paramFile)
  {
    try
    {
      Object localObject = new byte[8192];
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      paramFile = new FileInputStream(paramFile);
      int i;
      for (;;)
      {
        j = paramFile.read((byte[])localObject);
        i = 0;
        if (j == -1) {
          break;
        }
        localMessageDigest.update((byte[])localObject, 0, j);
      }
      paramFile = localMessageDigest.digest();
      localObject = new StringBuilder(paramFile.length * 2);
      int j = paramFile.length;
      while (i < j)
      {
        int k = paramFile[i] & 0xFF;
        if (k < 16) {
          ((StringBuilder)localObject).append("0");
        }
        ((StringBuilder)localObject).append(Integer.toHexString(k));
        i += 1;
      }
      paramFile = ((StringBuilder)localObject).toString();
      return paramFile;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
      return "";
    }
    catch (UnsupportedEncodingException paramFile)
    {
      throw new RuntimeException("UnsupportedEncodingException", paramFile);
    }
    catch (NoSuchAlgorithmException paramFile)
    {
      paramFile = new RuntimeException("NoSuchAlgorithmException", paramFile);
    }
    for (;;)
    {
      throw paramFile;
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        return true;
      }
      paramString = new File(paramString);
      if (!paramString.exists()) {
        return true;
      }
      File[] arrayOfFile = paramString.listFiles();
      bool1 = bool2;
      if (arrayOfFile != null)
      {
        bool1 = bool2;
        if (arrayOfFile.length > 0)
        {
          int i = 0;
          bool1 = true;
          while (i < arrayOfFile.length)
          {
            if (arrayOfFile[i].isDirectory())
            {
              if ((a(arrayOfFile[i].getAbsolutePath())) && (bool1))
              {
                bool1 = true;
                break label155;
              }
            }
            else
            {
              if (arrayOfFile[i].delete()) {
                break label155;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("delete fail, path:");
              localStringBuilder.append(arrayOfFile[i].getAbsolutePath());
              Log.e("AXrFileReader", localStringBuilder.toString());
            }
            bool1 = false;
            label155:
            i += 1;
          }
        }
      }
      paramString.delete();
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.decoder.AXrFileReader
 * JD-Core Version:    0.7.0.1
 */