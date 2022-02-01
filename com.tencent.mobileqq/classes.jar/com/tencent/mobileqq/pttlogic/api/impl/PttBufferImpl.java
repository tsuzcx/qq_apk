package com.tencent.mobileqq.pttlogic.api.impl;

import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer.BufferTask;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PttBufferImpl
  implements IPttBuffer
{
  private static final String PATH_SUFFIX = "~tmp";
  private static final Map<String, IPttBuffer.BufferTask> S_TASK_MAP = new ConcurrentHashMap(2);
  private static int sMaxBufferSize = 4000;
  
  private void clearBufferTask(String paramString, boolean paramBoolean)
  {
    localBufferTask = (IPttBuffer.BufferTask)S_TASK_MAP.get(paramString);
    if ((localBufferTask == null) || (localBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
    }
    catch (Exception localException1)
    {
      try
      {
        localBufferTask.jdField_a_of_type_JavaIoFileOutputStream.close();
        localBufferTask.jdField_a_of_type_JavaIoFileOutputStream = null;
        if ((!paramBoolean) || (localBufferTask.jdField_a_of_type_JavaIoFile == null)) {
          break label77;
        }
        localBufferTask.jdField_a_of_type_JavaIoFile.delete();
        localBufferTask.jdField_a_of_type_JavaIoFile = null;
        S_TASK_MAP.remove(paramString);
        return;
        localException1 = localException1;
      }
      catch (Exception localException2)
      {
        break label48;
      }
    }
    if (localBufferTask.jdField_a_of_type_JavaIoFileOutputStream == null) {}
  }
  
  private void writeBufferToFile(IPttBuffer.BufferTask paramBufferTask, boolean paramBoolean)
  {
    if ((paramBufferTask != null) && (paramBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      Object localObject;
      if (paramBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (paramBufferTask.jdField_a_of_type_JavaIoFile == null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramBufferTask.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append("~tmp");
          localObject = new File(((StringBuilder)localObject).toString());
          if (!((File)localObject).exists()) {
            ((File)localObject).createNewFile();
          }
          paramBufferTask.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream((File)localObject);
          paramBufferTask.jdField_a_of_type_JavaIoFile = ((File)localObject);
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
          localObject = new File(paramBufferTask.jdField_a_of_type_JavaLangString);
          if (((File)localObject).exists()) {
            ((File)localObject).delete();
          }
          if (!paramBufferTask.jdField_a_of_type_JavaIoFile.renameTo((File)localObject))
          {
            FileUtils.copyFile(paramBufferTask.jdField_a_of_type_JavaIoFile, (File)localObject);
            paramBufferTask.jdField_a_of_type_JavaIoFile.delete();
          }
          paramBufferTask.jdField_a_of_type_JavaIoFile = null;
        }
      }
    }
  }
  
  public boolean appendBuffer(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (IPttBuffer.BufferTask)S_TASK_MAP.get(paramString);
    if (paramString != null)
    {
      if (paramString.jdField_a_of_type_JavaIoByteArrayOutputStream == null) {
        paramString.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream(paramInt << 1);
      }
      paramString.jdField_a_of_type_JavaIoByteArrayOutputStream.write(paramArrayOfByte, 0, paramInt);
      if (paramString.jdField_a_of_type_JavaIoByteArrayOutputStream.size() < sMaxBufferSize) {}
    }
    try
    {
      writeBufferToFile(paramString, false);
      label67:
      paramString.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
      return true;
    }
    catch (IOException paramArrayOfByte)
    {
      break label67;
    }
  }
  
  public void cancelBufferTask(String paramString)
  {
    clearBufferTask(paramString, true);
  }
  
  public boolean createBufferTask(String paramString)
  {
    if ((IPttBuffer.BufferTask)S_TASK_MAP.get(paramString) == null)
    {
      IPttBuffer.BufferTask localBufferTask = new IPttBuffer.BufferTask();
      localBufferTask.jdField_a_of_type_JavaLangString = paramString;
      S_TASK_MAP.put(paramString, localBufferTask);
    }
    return true;
  }
  
  public boolean flush(String paramString)
  {
    IPttBuffer.BufferTask localBufferTask = (IPttBuffer.BufferTask)S_TASK_MAP.get(paramString);
    if ((localBufferTask != null) && (localBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      writeBufferToFile(localBufferTask, true);
      label30:
      localBufferTask.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
      clearBufferTask(paramString, true);
      return true;
    }
    catch (IOException localIOException)
    {
      break label30;
    }
  }
  
  public Map getTaskMap()
  {
    return S_TASK_MAP;
  }
  
  public void setMaxBufferSize(int paramInt)
  {
    sMaxBufferSize = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.impl.PttBufferImpl
 * JD-Core Version:    0.7.0.1
 */