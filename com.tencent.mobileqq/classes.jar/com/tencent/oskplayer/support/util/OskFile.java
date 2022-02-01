package com.tencent.oskplayer.support.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.oskplayer.support.OskSupport;
import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

public class OskFile
{
  private static final long FILE_COPY_BUFFER_SIZE = 31457280L;
  public static final long ONE_EB = 1152921504606846976L;
  public static final BigInteger ONE_EB_BI;
  public static final long ONE_GB = 1073741824L;
  public static final BigInteger ONE_GB_BI;
  public static final long ONE_KB = 1024L;
  public static final BigInteger ONE_KB_BI = BigInteger.valueOf(1024L);
  public static final long ONE_MB = 1048576L;
  public static final BigInteger ONE_MB_BI;
  public static final long ONE_PB = 1125899906842624L;
  public static final BigInteger ONE_PB_BI;
  public static final long ONE_TB = 1099511627776L;
  public static final BigInteger ONE_TB_BI;
  public static final BigInteger ONE_YB = ONE_KB_BI.multiply(ONE_ZB);
  public static final BigInteger ONE_ZB;
  public static final String TAG = "OskFile";
  
  static
  {
    BigInteger localBigInteger = ONE_KB_BI;
    ONE_MB_BI = localBigInteger.multiply(localBigInteger);
    ONE_GB_BI = ONE_KB_BI.multiply(ONE_MB_BI);
    ONE_TB_BI = ONE_KB_BI.multiply(ONE_GB_BI);
    ONE_PB_BI = ONE_KB_BI.multiply(ONE_TB_BI);
    ONE_EB_BI = ONE_KB_BI.multiply(ONE_PB_BI);
    ONE_ZB = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
  }
  
  public static String byteCountToDisplaySize(long paramLong)
  {
    return byteCountToDisplaySize(BigInteger.valueOf(paramLong));
  }
  
  public static String byteCountToDisplaySize(BigInteger paramBigInteger)
  {
    if (paramBigInteger.divide(ONE_EB_BI).compareTo(BigInteger.ZERO) > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramBigInteger.divide(ONE_EB_BI)));
      localStringBuilder.append(" EB");
      return localStringBuilder.toString();
    }
    if (paramBigInteger.divide(ONE_PB_BI).compareTo(BigInteger.ZERO) > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramBigInteger.divide(ONE_PB_BI)));
      localStringBuilder.append(" PB");
      return localStringBuilder.toString();
    }
    if (paramBigInteger.divide(ONE_TB_BI).compareTo(BigInteger.ZERO) > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramBigInteger.divide(ONE_TB_BI)));
      localStringBuilder.append(" TB");
      return localStringBuilder.toString();
    }
    if (paramBigInteger.divide(ONE_GB_BI).compareTo(BigInteger.ZERO) > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramBigInteger.divide(ONE_GB_BI)));
      localStringBuilder.append(" GB");
      return localStringBuilder.toString();
    }
    if (paramBigInteger.divide(ONE_MB_BI).compareTo(BigInteger.ZERO) > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramBigInteger.divide(ONE_MB_BI)));
      localStringBuilder.append(" MB");
      return localStringBuilder.toString();
    }
    if (paramBigInteger.divide(ONE_KB_BI).compareTo(BigInteger.ZERO) > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramBigInteger.divide(ONE_KB_BI)));
      localStringBuilder.append(" KB");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramBigInteger));
    localStringBuilder.append(" bytes");
    return localStringBuilder.toString();
  }
  
  public static void copy(File paramFile1, File paramFile2)
  {
    paramFile1 = new FileInputStream(paramFile1);
    try
    {
      paramFile2 = new FileOutputStream(paramFile2);
      try
      {
        byte[] arrayOfByte = new byte[8192];
        for (;;)
        {
          int i = paramFile1.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          paramFile2.write(arrayOfByte, 0, i);
        }
        paramFile2.close();
        return;
      }
      finally
      {
        paramFile2.close();
      }
      throw paramFile2;
    }
    finally
    {
      paramFile1.close();
    }
    for (;;) {}
  }
  
  private static String ensureDir(File paramFile)
  {
    boolean bool1;
    if ((paramFile.exists()) && (paramFile.isFile())) {
      bool1 = paramFile.delete();
    } else {
      bool1 = false;
    }
    if (!paramFile.exists()) {
      bool1 = paramFile.mkdirs();
    }
    boolean bool2 = bool1;
    if (paramFile.isDirectory())
    {
      bool2 = bool1;
      if (paramFile.exists()) {
        bool2 = true;
      }
    }
    ILogger localILogger = Logger.g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ensureDir ");
    localStringBuilder.append(paramFile);
    localStringBuilder.append(" result:");
    localStringBuilder.append(bool2);
    localILogger.i("OskFile", localStringBuilder.toString());
    if (bool2) {
      return paramFile.getAbsolutePath();
    }
    return null;
  }
  
  public static boolean ensureDirEmpty(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (!bool2)
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        bool1 = paramString.delete();
      }
      if (!paramString.exists()) {
        bool1 = paramString.mkdirs();
      }
      bool2 = bool1;
      if (paramString.isDirectory())
      {
        bool2 = bool1;
        if (paramString.exists()) {
          bool2 = true;
        }
      }
      ILogger localILogger = Logger.g();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ensureDirEmpty ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" result:");
      localStringBuilder.append(bool2);
      localILogger.i("OskFile", localStringBuilder.toString());
      return bool2;
    }
    Logger.g().i("OskFile", "ensureDirEmpty invalidPath");
    return false;
  }
  
  public static String ensureFilesDir(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = "";
    Object localObject2 = localObject1;
    Object localObject4;
    if (!bool)
    {
      Object localObject5 = null;
      try
      {
        localObject2 = OskSupport.getContext().getExternalFilesDir(null);
      }
      catch (Exception localException1)
      {
        Logger.g().e("OskFile", "cant get extFilesRootDir", localException1);
        localObject3 = null;
      }
      if (localObject3 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localObject3);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(paramString);
        localObject1 = ensureDir(new File(((StringBuilder)localObject1).toString()));
      }
      Object localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        try
        {
          localObject3 = OskSupport.getContext().getFilesDir();
          localObject5 = localObject3;
        }
        catch (Exception localException2)
        {
          Logger.g().e("OskFile", "cant get internalFilesRootDir", localException2);
        }
        localObject4 = localObject1;
        if (localObject5 != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(localObject5);
          ((StringBuilder)localObject1).append(File.separator);
          ((StringBuilder)localObject1).append(paramString);
          localObject4 = ensureDir(new File(((StringBuilder)localObject1).toString()));
        }
      }
    }
    return localObject4;
  }
  
  public static String getFileExtension(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    if (!bool)
    {
      paramString = new File(paramString).getName();
      int i = paramString.lastIndexOf('.');
      if (i == -1) {
        return "";
      }
      str = paramString.substring(i + 1);
    }
    return str;
  }
  
  public static boolean isLocalFile(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("/")) || (paramString.startsWith("file://")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.support.util.OskFile
 * JD-Core Version:    0.7.0.1
 */