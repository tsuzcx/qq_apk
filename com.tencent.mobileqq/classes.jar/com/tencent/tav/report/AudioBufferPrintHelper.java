package com.tencent.tav.report;

import android.annotation.SuppressLint;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AudioBufferPrintHelper
{
  public static final boolean CLEAR_MODE = false;
  public static final boolean ENABLE = false;
  public static final String SDCARD_TAVKIT_DEMO_INFO = "/sdcard/tavkit_demo/info/";
  private static final String TAG = "DebugUtils";
  private boolean enable = false;
  private List<String> list = new ArrayList();
  private int maxPrintCount = 0;
  private long startIndex = 0L;
  private String startName = "";
  private long startTimeMs = 0L;
  private long waitMs;
  
  public static void clearFiles() {}
  
  public static ByteBuffer clone(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.capacity());
    paramByteBuffer.rewind();
    localByteBuffer.put(paramByteBuffer);
    paramByteBuffer.rewind();
    localByteBuffer.flip();
    return localByteBuffer;
  }
  
  public static ShortBuffer clone(ShortBuffer paramShortBuffer)
  {
    ShortBuffer localShortBuffer = ShortBuffer.allocate(paramShortBuffer.capacity());
    paramShortBuffer.rewind();
    localShortBuffer.put(paramShortBuffer);
    paramShortBuffer.rewind();
    localShortBuffer.flip();
    return localShortBuffer;
  }
  
  public static File createNewFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if ((!paramString1.exists()) && (!paramString1.mkdirs())) {
      return null;
    }
    paramString1 = new File(paramString1, paramString2);
    try
    {
      if (paramString1.delete()) {
        Log.d("DebugUtils", "export: 文件已存在，删除");
      }
      if (!paramString1.createNewFile())
      {
        paramString2 = new StringBuilder();
        paramString2.append("export: 创建输出文件失败:");
        paramString2.append(paramString1.getAbsolutePath());
        Log.e("DebugUtils", paramString2.toString());
        return null;
      }
      return paramString1;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      Log.e("DebugUtils", "export: 创建输出文件失败, e = ", paramString1);
    }
    return null;
  }
  
  private static void deleteAllFiles(File paramFile)
  {
    paramFile = paramFile.listFiles();
    if (paramFile == null) {
      return;
    }
    int j = paramFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramFile[i];
      if (localFile.isDirectory())
      {
        deleteAllFiles(localFile);
        localFile.delete();
      }
      else if (localFile.exists())
      {
        deleteAllFiles(localFile);
        localFile.delete();
      }
      i += 1;
    }
  }
  
  public static AudioBufferPrintHelper getInstance()
  {
    return AudioBufferPrintHelper.Instance.access$000();
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private void initFlag(int paramInt)
  {
    if (this.startTimeMs == 0L)
    {
      this.startTimeMs = System.currentTimeMillis();
      this.startName = new SimpleDateFormat("HHmmss").format(new Date(this.startTimeMs));
    }
    if (this.maxPrintCount == 0) {
      this.maxPrintCount = paramInt;
    }
  }
  
  public static void reset()
  {
    AudioBufferPrintHelper.Instance.access$002(new AudioBufferPrintHelper());
  }
  
  public void printByteBuffer(String paramString, ByteBuffer paramByteBuffer) {}
  
  public void printByteBuffer(String paramString, ShortBuffer paramShortBuffer) {}
  
  public void printByteBuffer(String paramString, short[] paramArrayOfShort) {}
  
  public void startDelay(long paramLong)
  {
    startDelay(paramLong, 100);
  }
  
  public void startDelay(long paramLong, int paramInt)
  {
    initFlag(paramInt);
    boolean bool;
    if (System.currentTimeMillis() >= this.startTimeMs + paramLong) {
      bool = true;
    } else {
      bool = false;
    }
    this.enable = bool;
    if (this.enable)
    {
      paramInt = this.maxPrintCount;
      this.maxPrintCount = (paramInt - 1);
      if (paramInt < 0) {
        this.enable = false;
      }
    }
  }
  
  public void startIgnoreBegin(int paramInt)
  {
    startIgnoreBegin(paramInt, 100);
  }
  
  public void startIgnoreBegin(int paramInt1, int paramInt2)
  {
    initFlag(paramInt2);
    long l = this.startIndex;
    this.startIndex = (1L + l);
    if (l > paramInt1) {
      this.enable = true;
    }
    if (this.enable)
    {
      paramInt1 = this.maxPrintCount;
      this.maxPrintCount = (paramInt1 - 1);
      if (paramInt1 < 0) {
        this.enable = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.report.AudioBufferPrintHelper
 * JD-Core Version:    0.7.0.1
 */