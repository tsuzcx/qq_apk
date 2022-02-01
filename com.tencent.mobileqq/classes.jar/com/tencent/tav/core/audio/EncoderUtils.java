package com.tencent.tav.core.audio;

import com.tencent.tav.decoder.logger.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

class EncoderUtils
{
  private static final int FREQ_IDX = 4;
  public static final int INDEX_START = 1;
  private static final int PROFILE = 2;
  private static final String TAG = "EncoderUtils";
  
  public static void addADTStoPacket(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = generateADTSHeader(paramArrayOfByte.length, paramInt);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, arrayOfByte.length);
  }
  
  public static void close(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable)
    {
      Logger.e("EncoderUtils", "close: ", paramCloseable);
    }
  }
  
  static void deleteAllTmpFiles(String paramString1, int paramInt, String paramString2)
  {
    Logger.d("EncoderUtils", "deleteAllTmpFiles " + paramInt + " sessionId = " + paramString2);
    int i = 1;
    while (i <= paramInt)
    {
      File localFile = new File(getAudioOutSaveFilePath(paramString1, i, paramString2));
      boolean bool = localFile.delete();
      Logger.d("EncoderUtils", "delete file " + localFile.getAbsolutePath() + " deleteResult = " + bool);
      i += 1;
    }
  }
  
  public static byte[] generateADTSHeader(int paramInt1, int paramInt2)
  {
    return new byte[] { -1, -7, (byte)((paramInt2 >> 2) + 80), (byte)(((paramInt2 & 0x3) << 6) + (paramInt1 >> 11)), (byte)((paramInt1 & 0x7FF) >> 3), (byte)(((paramInt1 & 0x7) << 5) + 31), -4 };
  }
  
  static String getAudioOutSaveFilePath(String paramString1, int paramInt, String paramString2)
  {
    int i = paramString1.lastIndexOf(".");
    if (i > 0) {
      return paramString1.substring(0, i) + "_" + paramString2 + "_" + paramInt + paramString1.substring(i);
    }
    return paramString1 + "_" + paramString2 + "_" + paramInt;
  }
  
  private static boolean isValidFile(File paramFile)
  {
    return (paramFile.createNewFile()) || ((paramFile.exists()) && (paramFile.isFile()));
  }
  
  static boolean mergeAllFiles(String paramString1, int paramInt, String paramString2)
  {
    Logger.d("EncoderUtils", "mergeAllFiles " + paramInt + " sessionId = " + paramString2);
    try
    {
      Object localObject = new File(paramString1);
      ((File)localObject).delete();
      if (isValidFile((File)localObject))
      {
        localObject = new RandomAccessFile((File)localObject, "rw");
        int i = 1;
        while (i <= paramInt)
        {
          ((RandomAccessFile)localObject).write(readFromFile(getAudioOutSaveFilePath(paramString1, i, paramString2)));
          i += 1;
        }
        close((Closeable)localObject);
        return true;
      }
    }
    catch (Exception paramString1)
    {
      Logger.e("EncoderUtils", "mergeAllFiles: ", paramString1);
    }
    return false;
  }
  
  private static byte[] readFromFile(String paramString)
  {
    paramString = new FileInputStream(paramString);
    try
    {
      byte[] arrayOfByte = new byte[paramString.available()];
      paramString.read(arrayOfByte);
      return arrayOfByte;
    }
    finally
    {
      close(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.core.audio.EncoderUtils
 * JD-Core Version:    0.7.0.1
 */