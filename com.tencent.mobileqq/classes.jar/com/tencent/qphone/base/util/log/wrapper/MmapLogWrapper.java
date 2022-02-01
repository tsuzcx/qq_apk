package com.tencent.qphone.base.util.log.wrapper;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.ILogWriter;
import com.tencent.qphone.base.util.log.encrypt.XorKey;
import com.tencent.qphone.base.util.log.processor.ByteProcessorComposer;
import com.tencent.qphone.base.util.log.processor.DeflateCompressor;
import com.tencent.qphone.base.util.log.processor.ProcessByteData;
import com.tencent.qphone.base.util.log.processor.XOREncryption;
import com.tencent.qphone.base.util.log.utils.JavaStringCoder;
import com.tencent.qphone.base.util.log.utils.JavaStringCoder.JavaStringCoderCallback;
import com.tencent.qphone.base.util.log.utils.MagicHeadWriter;
import com.tencent.qphone.base.util.log.utils.MappedLogWriter;
import com.tencent.qphone.base.util.log.utils.MmapUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

public class MmapLogWrapper
  implements ILogWriter, JavaStringCoder.JavaStringCoderCallback
{
  public static final String TAG = "JavaMmapAppender";
  int bufferSize;
  MappedByteBuffer cacheFileMmapBuffer;
  boolean compress;
  boolean encrypt;
  MappedLogWriter finalLogFileWriter;
  private boolean isLastUnwriteMmapExist;
  JavaStringCoder javaStringCoder;
  protected Object lock;
  String logPath;
  MagicHeadWriter magicWriter;
  String mmapCachePath;
  ByteProcessorComposer processors;
  
  public MmapLogWrapper(MmapLogWrapper.Builder paramBuilder)
  {
    this.mmapCachePath = MmapLogWrapper.Builder.access$000(paramBuilder);
    this.logPath = MmapLogWrapper.Builder.access$100(paramBuilder);
    this.bufferSize = MmapLogWrapper.Builder.access$200(paramBuilder);
    this.compress = MmapLogWrapper.Builder.access$300(paramBuilder);
    this.encrypt = MmapLogWrapper.Builder.access$400(paramBuilder);
    this.lock = this;
    try
    {
      this.isLastUnwriteMmapExist = new File(this.mmapCachePath).exists();
      this.cacheFileMmapBuffer = MmapUtil.getMmapFileByPath(this.mmapCachePath, this.bufferSize);
      this.finalLogFileWriter = new MappedLogWriter(this.logPath);
      this.processors = new ByteProcessorComposer();
      this.processors.addProcessor(new DeflateCompressor(this.compress));
      this.processors.addProcessor(new XOREncryption(this.encrypt));
      this.magicWriter = new MagicHeadWriter(this.cacheFileMmapBuffer, this.compress);
      this.javaStringCoder = new JavaStringCoder(this);
      writeLastCacheAndNewHeader();
      return;
    }
    catch (IOException paramBuilder)
    {
      paramBuilder.printStackTrace();
    }
  }
  
  private void copyCacheToLogFileAndReset()
  {
    if (this.magicWriter.prepareToWrite()) {
      this.finalLogFileWriter.writeThroughMmapBuffer(this.cacheFileMmapBuffer);
    }
    this.cacheFileMmapBuffer.clear();
    this.magicWriter.writeInitLength();
  }
  
  private static byte[] getExistedMmapBytes(MappedByteBuffer paramMappedByteBuffer)
  {
    paramMappedByteBuffer.getInt();
    int i = paramMappedByteBuffer.getInt();
    if ((i > paramMappedByteBuffer.capacity()) || (i <= 0)) {
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    paramMappedByteBuffer.get(arrayOfByte);
    return arrayOfByte;
  }
  
  private void writeLastCacheAndNewHeader()
  {
    for (;;)
    {
      try
      {
        if (this.isLastUnwriteMmapExist)
        {
          localObject = getExistedMmapBytes(this.cacheFileMmapBuffer);
          if ((localObject != null) && (localObject.length != 0))
          {
            if (!this.compress) {
              continue;
            }
            i = -21937241;
            arrayOfByte = ByteBuffer.allocate(4).putInt(i).array();
            this.finalLogFileWriter.writeThroughByteArray(arrayOfByte);
            arrayOfByte = ByteBuffer.allocate(4).putInt(localObject.length).array();
            this.finalLogFileWriter.writeThroughByteArray(arrayOfByte);
            this.finalLogFileWriter.writeThroughByteArray((byte[])localObject);
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject;
        int i;
        byte[] arrayOfByte;
        Log.e("JavaMmapAppender", "writeLastCacheAndNewHeader failed. ", localThrowable1);
        continue;
      }
      this.cacheFileMmapBuffer.clear();
      try
      {
        localObject = XorKey.encryptedKey(XOREncryption.getXorKey());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.cacheFileMmapBuffer.putInt(-20190711);
          arrayOfByte = ((String)localObject).getBytes(XOREncryption.charset);
          this.cacheFileMmapBuffer.putInt(arrayOfByte.length + 4);
          this.cacheFileMmapBuffer.putInt(1);
          this.cacheFileMmapBuffer.put(arrayOfByte);
          if (QLog.isDebugVersion())
          {
            Log.d("JavaMmapAppender", "copyCacheToLogFileAndReset:  encryptedKey: " + (String)localObject);
            Log.d("JavaMmapAppender", "writeThroughMmapBuffer first length=" + this.cacheFileMmapBuffer.position() + " limit=" + this.cacheFileMmapBuffer.limit());
          }
          this.cacheFileMmapBuffer.flip();
          this.finalLogFileWriter.writeThroughMmapBuffer(this.cacheFileMmapBuffer);
        }
      }
      catch (Throwable localThrowable2)
      {
        Log.e("JavaMmapAppender", "", localThrowable2);
        continue;
      }
      this.cacheFileMmapBuffer.clear();
      this.magicWriter.writeInitLength();
      return;
      i = -18239;
    }
  }
  
  public void close()
  {
    synchronized (this.lock)
    {
      this.javaStringCoder.flush();
      copyCacheToLogFileAndReset();
      try
      {
        this.finalLogFileWriter.close();
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  public void flush()
  {
    synchronized (this.lock)
    {
      this.javaStringCoder.flush();
      return;
    }
  }
  
  public void onBufferFull(ProcessByteData paramProcessByteData)
  {
    paramProcessByteData = this.processors.handleData(paramProcessByteData);
    this.cacheFileMmapBuffer.put(paramProcessByteData.bytes, paramProcessByteData.offset, paramProcessByteData.length);
    this.magicWriter.updateLength();
    if (this.cacheFileMmapBuffer.position() > this.cacheFileMmapBuffer.capacity() - 2048)
    {
      copyCacheToLogFileAndReset();
      this.processors.reset();
    }
  }
  
  public void write(int paramInt)
  {
    synchronized (this.lock)
    {
      this.javaStringCoder.feedIn(paramInt);
      return;
    }
  }
  
  public void write(String paramString)
  {
    synchronized (this.lock)
    {
      this.javaStringCoder.feedIn(paramString);
      return;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      this.javaStringCoder.feedIn(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      this.javaStringCoder.feedIn(paramArrayOfChar, paramInt1, paramInt2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.wrapper.MmapLogWrapper
 * JD-Core Version:    0.7.0.1
 */