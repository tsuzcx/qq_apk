package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.util.StreamUtils;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

public class FileDataSource
  implements IDataSource
{
  private long currentPosition;
  private RandomAccessFile file;
  private FileInputStream fileInputStream;
  private final String filePath;
  private boolean opened = false;
  private BufferedInputStream readingStream;
  
  public FileDataSource(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void close()
  {
    if (!this.opened) {
      return;
    }
    Object localObject = this.fileInputStream;
    if (localObject != null) {
      ((FileInputStream)localObject).close();
    }
    localObject = this.readingStream;
    if (localObject != null) {
      ((BufferedInputStream)localObject).close();
    }
    localObject = this.file;
    if (localObject != null) {
      ((RandomAccessFile)localObject).close();
    }
    this.opened = false;
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    return AudioRecognition.recognitionAudioFormatExactly(this.filePath);
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public long getSize()
  {
    return this.file.length();
  }
  
  public void open()
  {
    if (this.opened) {
      return;
    }
    this.opened = true;
    this.file = new RandomAccessFile(this.filePath, "r");
    this.fileInputStream = new FileInputStream(this.file.getFD());
    this.readingStream = new BufferedInputStream(this.fileInputStream);
    this.currentPosition = 0L;
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = this.currentPosition;
    if (l != paramLong)
    {
      if (l > paramLong)
      {
        this.file.seek(paramLong);
        this.readingStream = new BufferedInputStream(this.fileInputStream);
        l = paramLong;
      }
      else
      {
        l += StreamUtils.skipForBufferStream(this.readingStream, paramLong - l);
      }
      if (l != paramLong) {
        return -1;
      }
      this.currentPosition = paramLong;
    }
    paramInt1 = this.readingStream.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 >= 0) {
      this.currentPosition += paramInt1;
    }
    return paramInt1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(fd)");
    localStringBuilder.append(this.filePath);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.FileDataSource
 * JD-Core Version:    0.7.0.1
 */