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
    if ((localBufferTask == null) || (localBufferTask.b != null)) {}
    try
    {
      localBufferTask.b.close();
    }
    catch (Exception localException1)
    {
      try
      {
        localBufferTask.d.close();
        localBufferTask.d = null;
        if ((!paramBoolean) || (localBufferTask.c == null)) {
          break label77;
        }
        localBufferTask.c.delete();
        localBufferTask.c = null;
        S_TASK_MAP.remove(paramString);
        return;
        localException1 = localException1;
      }
      catch (Exception localException2)
      {
        break label48;
      }
    }
    if (localBufferTask.d == null) {}
  }
  
  private void writeBufferToFile(IPttBuffer.BufferTask paramBufferTask, boolean paramBoolean)
  {
    if ((paramBufferTask != null) && (paramBufferTask.b != null))
    {
      Object localObject;
      if (paramBufferTask.b.size() > 0)
      {
        if (paramBufferTask.c == null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramBufferTask.a);
          ((StringBuilder)localObject).append("~tmp");
          localObject = new File(((StringBuilder)localObject).toString());
          if (!((File)localObject).exists()) {
            ((File)localObject).createNewFile();
          }
          paramBufferTask.d = new FileOutputStream((File)localObject);
          paramBufferTask.c = ((File)localObject);
        }
        paramBufferTask.b.writeTo(paramBufferTask.d);
      }
      if (paramBoolean)
      {
        if (paramBufferTask.d != null)
        {
          paramBufferTask.d.flush();
          paramBufferTask.d.close();
          paramBufferTask.d = null;
        }
        if (paramBufferTask.c != null)
        {
          localObject = new File(paramBufferTask.a);
          if (((File)localObject).exists()) {
            ((File)localObject).delete();
          }
          if (!paramBufferTask.c.renameTo((File)localObject))
          {
            FileUtils.copyFile(paramBufferTask.c, (File)localObject);
            paramBufferTask.c.delete();
          }
          paramBufferTask.c = null;
        }
      }
    }
  }
  
  public boolean appendBuffer(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (IPttBuffer.BufferTask)S_TASK_MAP.get(paramString);
    if (paramString != null)
    {
      if (paramString.b == null) {
        paramString.b = new ByteArrayOutputStream(paramInt << 1);
      }
      paramString.b.write(paramArrayOfByte, 0, paramInt);
      if (paramString.b.size() < sMaxBufferSize) {}
    }
    try
    {
      writeBufferToFile(paramString, false);
      label67:
      paramString.b.reset();
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
      localBufferTask.a = paramString;
      S_TASK_MAP.put(paramString, localBufferTask);
    }
    return true;
  }
  
  public boolean flush(String paramString)
  {
    IPttBuffer.BufferTask localBufferTask = (IPttBuffer.BufferTask)S_TASK_MAP.get(paramString);
    if ((localBufferTask != null) && (localBufferTask.b != null)) {}
    try
    {
      writeBufferToFile(localBufferTask, true);
      label30:
      localBufferTask.b.reset();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.impl.PttBufferImpl
 * JD-Core Version:    0.7.0.1
 */