package com.tencent.qqmusic.mediaplayer.downstream;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.RandomAccessFile;

public class FileDataSink
  implements IDataSink
{
  private static final String TAG = "FileDataSink";
  private long currentPosition = 0L;
  private final String filePath;
  private boolean opened = false;
  private RandomAccessFile randomAccessFile = null;
  
  public FileDataSink(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void close()
  {
    if (!this.opened) {
      return;
    }
    this.randomAccessFile.close();
    this.currentPosition = 0L;
  }
  
  public void open()
  {
    if (this.opened) {
      return;
    }
    this.randomAccessFile = new RandomAccessFile(this.filePath, "rw");
    this.currentPosition = 0L;
    this.opened = true;
  }
  
  public int write(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.randomAccessFile != null)
    {
      if (this.currentPosition != paramLong)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[write] seek to: ");
        localStringBuilder.append(paramLong);
        Logger.d("FileDataSink", localStringBuilder.toString());
        this.randomAccessFile.seek(paramLong);
        this.currentPosition = paramLong;
      }
      this.randomAccessFile.write(paramArrayOfByte, paramInt1, paramInt2);
      this.currentPosition += paramInt2;
      return paramInt2;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.downstream.FileDataSink
 * JD-Core Version:    0.7.0.1
 */