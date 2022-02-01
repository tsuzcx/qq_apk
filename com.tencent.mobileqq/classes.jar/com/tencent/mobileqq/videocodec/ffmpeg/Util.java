package com.tencent.mobileqq.videocodec.ffmpeg;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

@TargetApi(14)
class Util
{
  static <T> T[] concatenate(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    int i = paramArrayOfT1.length;
    int j = paramArrayOfT2.length;
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT1.getClass().getComponentType(), i + j);
    System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, i);
    System.arraycopy(paramArrayOfT2, 0, arrayOfObject, i, j);
    return arrayOfObject;
  }
  
  static String convertInputStreamToString(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = paramInputStream.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      paramInputStream = localStringBuilder.toString();
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      SLog.c("FFmpegCmd", "error converting input stream to string", paramInputStream);
    }
    return null;
  }
  
  static void destroyProcess(Process paramProcess)
  {
    if (paramProcess != null) {
      paramProcess.destroy();
    }
  }
  
  static boolean isProcessCompleted(Process paramProcess)
  {
    if (paramProcess == null) {
      return true;
    }
    try
    {
      paramProcess.exitValue();
      if (QLog.isColorLevel()) {
        QLog.d("FFmpegCmd", 2, "isProcessCompleted: true  in  process.exitValue()");
      }
      return true;
    }
    catch (IllegalThreadStateException paramProcess)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FFmpegCmd", 2, "IllegalThreadStateException e, ", paramProcess);
      }
    }
    return false;
  }
  
  static void killFFmpegProcess(FFmpegExecuteAsyncTask paramFFmpegExecuteAsyncTask)
  {
    if ((paramFFmpegExecuteAsyncTask != null) && (!paramFFmpegExecuteAsyncTask.isProcessCompleted()))
    {
      if (paramFFmpegExecuteAsyncTask.mProcess != null)
      {
        paramFFmpegExecuteAsyncTask.mProcess.destroy();
        paramFFmpegExecuteAsyncTask.mProcess = null;
      }
      if (!paramFFmpegExecuteAsyncTask.isCancelled()) {
        paramFFmpegExecuteAsyncTask.cancel(true);
      }
      SLog.e("FFmpegCmd", "kill ffmpeg task", new Object[] { Arrays.toString(paramFFmpegExecuteAsyncTask.cmd) });
    }
  }
  
  static boolean setFileExecutable(File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return false;
      }
      if (!paramFile.canExecute()) {
        return paramFile.setExecutable(true);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.Util
 * JD-Core Version:    0.7.0.1
 */