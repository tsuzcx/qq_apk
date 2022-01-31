package com.tencent.mobileqq.ptt;

import com.tencent.mobileqq.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class PttBuffer
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(PttBuffer.BufferTask paramBufferTask, boolean paramBoolean)
  {
    if ((paramBufferTask != null) && (paramBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      File localFile;
      if (paramBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (paramBufferTask.jdField_a_of_type_JavaIoFile == null)
        {
          localFile = new File(paramBufferTask.jdField_a_of_type_JavaLangString + "~tmp");
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          paramBufferTask.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
          paramBufferTask.jdField_a_of_type_JavaIoFile = localFile;
        }
        paramBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(paramBufferTask.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (paramBufferTask.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramBufferTask.jdField_a_of_type_JavaIoFileOutputStream.flush();
          paramBufferTask.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramBufferTask.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        if (paramBufferTask.jdField_a_of_type_JavaIoFile != null)
        {
          localFile = new File(paramBufferTask.jdField_a_of_type_JavaLangString);
          if (localFile.exists()) {
            localFile.delete();
          }
          if (!paramBufferTask.jdField_a_of_type_JavaIoFile.renameTo(localFile))
          {
            FileUtils.a(paramBufferTask.jdField_a_of_type_JavaIoFile, localFile);
            paramBufferTask.jdField_a_of_type_JavaIoFile.delete();
          }
          paramBufferTask.jdField_a_of_type_JavaIoFile = null;
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    a(paramString, true);
  }
  
  private static void a(String paramString, boolean paramBoolean)
  {
    PttBuffer.BufferTask localBufferTask = (PttBuffer.BufferTask)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localBufferTask == null) || (localBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localBufferTask.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localBufferTask.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localBufferTask.jdField_a_of_type_JavaIoFileOutputStream = null;
        if ((paramBoolean) && (localBufferTask.jdField_a_of_type_JavaIoFile != null))
        {
          localBufferTask.jdField_a_of_type_JavaIoFile.delete();
          localBufferTask.jdField_a_of_type_JavaIoFile = null;
        }
        jdField_a_of_type_JavaUtilMap.remove(paramString);
        return;
      }
      catch (Exception localException1)
      {
        break label45;
      }
    }
    catch (Exception localException2)
    {
      break label31;
    }
  }
  
  public static boolean a(String paramString)
  {
    if ((PttBuffer.BufferTask)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      PttBuffer.BufferTask localBufferTask = new PttBuffer.BufferTask();
      localBufferTask.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localBufferTask);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (PttBuffer.BufferTask)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      if (paramString.jdField_a_of_type_JavaIoByteArrayOutputStream == null) {
        paramString.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream(paramInt << 1);
      }
      paramString.jdField_a_of_type_JavaIoByteArrayOutputStream.write(paramArrayOfByte, 0, paramInt);
      if (paramString.jdField_a_of_type_JavaIoByteArrayOutputStream.size() < jdField_a_of_type_Int) {}
    }
    try
    {
      a(paramString, false);
      label66:
      paramString.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
      return true;
    }
    catch (IOException paramArrayOfByte)
    {
      break label66;
    }
  }
  
  public static boolean b(String paramString)
  {
    PttBuffer.BufferTask localBufferTask = (PttBuffer.BufferTask)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localBufferTask != null) && (localBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localBufferTask, true);
      label29:
      localBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
      a(paramString, true);
      return true;
    }
    catch (IOException localIOException)
    {
      break label29;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.PttBuffer
 * JD-Core Version:    0.7.0.1
 */