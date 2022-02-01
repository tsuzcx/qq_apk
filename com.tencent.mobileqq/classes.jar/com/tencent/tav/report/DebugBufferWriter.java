package com.tencent.tav.report;

import android.os.Build.VERSION;
import com.tencent.tav.decoder.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class DebugBufferWriter
{
  private static final String DIR = "/sdcard/tavkit_demo/buffers/";
  private final String TAG;
  private long lastTime;
  private Path path;
  
  public DebugBufferWriter()
  {
    this("");
  }
  
  public DebugBufferWriter(String paramString)
  {
    this("/sdcard/tavkit_demo/buffers/", localStringBuilder.toString());
  }
  
  public DebugBufferWriter(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DebugBufferWriter@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.lastTime = -10086L;
    if (Build.VERSION.SDK_INT < 26)
    {
      Logger.e(this.TAG, "DebugBufferWriter: Android O 可用");
      return;
    }
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
    paramString1 = new File(paramString1, paramString2);
    if (!paramString1.exists()) {
      try
      {
        paramString1.createNewFile();
      }
      catch (IOException paramString2)
      {
        Logger.e(this.TAG, "DebugBufferWriter: ", paramString2);
      }
    }
    this.path = paramString1.toPath();
  }
  
  public void write(ByteBuffer paramByteBuffer)
  {
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("write() called with: buffer = [");
    localStringBuilder.append(paramByteBuffer);
    localStringBuilder.append("]");
    Logger.v((String)localObject, localStringBuilder.toString());
    if (paramByteBuffer == null) {
      return;
    }
    localObject = ByteBuffer.allocate(paramByteBuffer.limit());
    paramByteBuffer.rewind();
    ((ByteBuffer)localObject).put(paramByteBuffer);
    paramByteBuffer.rewind();
    ((ByteBuffer)localObject).flip();
    write(((ByteBuffer)localObject).array());
  }
  
  public void write(ByteBuffer paramByteBuffer, long paramLong)
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("write() called with: buffer = [");
    localStringBuilder.append(paramByteBuffer);
    localStringBuilder.append("], timeUs = [");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    Logger.v(str, localStringBuilder.toString());
    if (paramLong - this.lastTime < 100L) {
      return;
    }
    this.lastTime = paramLong;
    write(paramByteBuffer);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return;
    }
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("write() called with: bytes = [");
    localStringBuilder.append(Arrays.toString(paramArrayOfByte));
    localStringBuilder.append("]");
    Logger.v(str, localStringBuilder.toString());
    try
    {
      Files.write(this.path, paramArrayOfByte, new OpenOption[] { StandardOpenOption.APPEND });
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      Logger.e(this.TAG, "write: ", paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.report.DebugBufferWriter
 * JD-Core Version:    0.7.0.1
 */