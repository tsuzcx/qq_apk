package com.tencent.tav.report;

import android.util.Log;
import com.tencent.tav.decoder.logger.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class BufferPrintHelper
{
  public static final String SDCARD_TAVKIT_DEMO_INFO = "/sdcard/tavkit_demo/info/";
  private static final String TAG = "DebugUtils";
  private boolean clearOldFile;
  private int ignoreCount;
  private List<String> list = new ArrayList();
  private int maxPrintCount = 0;
  private boolean printStarted = false;
  private long startIndex = 0L;
  private String startName = "";
  private long startTimeMs = 0L;
  private long waitMs;
  
  private static void clearFiles()
  {
    File localFile = new File("/sdcard/tavkit_demo/info/");
    if (localFile.exists()) {
      deleteAllFiles(localFile);
    }
  }
  
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
  
  public static BufferPrintHelper getInstance()
  {
    return BufferPrintHelper.Instance.access$000();
  }
  
  @Nullable
  private File newFile(String paramString)
  {
    long l = this.startIndex + 1L;
    this.startIndex = l;
    if ((l > this.ignoreCount) && (System.currentTimeMillis() >= this.startTimeMs + this.waitMs)) {
      this.printStarted = true;
    }
    if ((this.printStarted) && (!this.list.contains(paramString)))
    {
      int i = this.maxPrintCount - 1;
      this.maxPrintCount = i;
      if (i < 0) {
        return null;
      }
      this.list.add(paramString);
      Object localObject;
      if (this.clearOldFile)
      {
        localObject = "";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.startName);
        ((StringBuilder)localObject).append("-");
        localObject = ((StringBuilder)localObject).toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(paramString);
      localStringBuilder.append(".tavfile");
      paramString = createNewFile("/sdcard/tavkit_demo/info/", localStringBuilder.toString());
      if (paramString == null) {
        return null;
      }
      return paramString;
    }
    return null;
  }
  
  public static void reset()
  {
    BufferPrintHelper.Instance.access$002(new BufferPrintHelper());
  }
  
  public void init(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.waitMs = paramLong;
    this.ignoreCount = paramInt1;
    this.maxPrintCount = paramInt2;
    this.clearOldFile = paramBoolean;
    this.startTimeMs = System.currentTimeMillis();
    this.startName = new SimpleDateFormat("HHmmss").format(new Date(this.startTimeMs));
    if (paramBoolean) {
      clearFiles();
    }
  }
  
  public void printByteBuffer(String paramString, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null)
    {
      Logger.e("DebugUtils", "saveByteBuffer: buffer is null");
      return;
    }
    printByteBuffer(paramString, clone(paramByteBuffer).array());
  }
  
  public void printByteBuffer(String paramString, byte[] paramArrayOfByte)
  {
    paramString = newFile(paramString);
    if (paramString == null) {
      return;
    }
    try
    {
      paramString = new PrintStream(paramString);
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        paramString.println(paramArrayOfByte[i]);
        i += 1;
      }
      paramString.close();
      return;
    }
    catch (IOException paramString)
    {
      Logger.e("DebugUtils", "printBuffer: ", paramString);
    }
  }
  
  public void printShortBuffer(String paramString, ShortBuffer paramShortBuffer)
  {
    printShortBuffer(paramString, clone(paramShortBuffer).array());
  }
  
  public void printShortBuffer(String paramString, short[] paramArrayOfShort)
  {
    paramString = newFile(paramString);
    if (paramString == null) {
      return;
    }
    try
    {
      paramString = new PrintStream(paramString);
      int j = paramArrayOfShort.length;
      int i = 0;
      while (i < j)
      {
        paramString.println(paramArrayOfShort[i]);
        i += 1;
      }
      paramString.close();
      return;
    }
    catch (IOException paramString)
    {
      Logger.e("DebugUtils", "printShortBuffer: ", paramString);
    }
  }
  
  public void printShotBuffer(String paramString, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null)
    {
      Logger.e("DebugUtils", "saveByteBuffer: buffer is null");
      return;
    }
    printShortBuffer(paramString, clone(paramByteBuffer).asShortBuffer());
  }
  
  public void saveByteBuffer(String paramString, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null)
    {
      Logger.e("DebugUtils", "saveByteBuffer: buffer is null");
      return;
    }
    saveByteBuffer(paramString, clone(paramByteBuffer).array());
  }
  
  public void saveByteBuffer(String paramString, byte[] paramArrayOfByte)
  {
    paramString = newFile(paramString);
    if (paramString == null) {
      return;
    }
    try
    {
      paramString = new FileOutputStream(paramString);
      paramString.write(paramArrayOfByte);
      paramString.close();
      return;
    }
    catch (IOException paramString)
    {
      Logger.e("DebugUtils", "printBuffer: ", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.report.BufferPrintHelper
 * JD-Core Version:    0.7.0.1
 */