package com.tencent.mqq.shared_file_accessor.test;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccessRecorder
{
  private static final int BUF_LEN = 32768;
  private static final String FILE_LOCATED_DIR;
  private static final String WRITE_FILE_NAME_BASE = "sp_rw_";
  private static volatile AccessRecorder mInstance = null;
  private Handler mHandler = null;
  private StringBuilder mStringBuilder = new StringBuilder(32768);
  private FileWriter mWriter = null;
  private String mWritingFileName = null;
  private HandlerThread mWritingThread = null;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/sp");
    FILE_LOCATED_DIR = localStringBuilder.toString();
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private AccessRecorder()
  {
    this.mWritingThread.start();
    this.mHandler = new AccessRecorder.PrivateHandler(this, this.mWritingThread.getLooper());
    Object localObject = new Date();
    localObject = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format((Date)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_rw_");
    localStringBuilder.append((String)localObject);
    this.mWritingFileName = localStringBuilder.toString();
    try
    {
      localObject = new File(FILE_LOCATED_DIR);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FILE_LOCATED_DIR);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.mWritingFileName);
      ((StringBuilder)localObject).append(".csv");
      this.mWriter = new FileWriter(((StringBuilder)localObject).toString());
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static AccessRecorder getInstance()
  {
    if (mInstance != null) {
      return mInstance;
    }
    try
    {
      if (mInstance == null) {
        mInstance = new AccessRecorder();
      }
      AccessRecorder localAccessRecorder = mInstance;
      return localAccessRecorder;
    }
    finally {}
  }
  
  public void log(String[] paramArrayOfString)
  {
    try
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j - 1)
      {
        localStringBuilder = this.mStringBuilder;
        localStringBuilder.append(paramArrayOfString[i]);
        localStringBuilder.append('\t');
        i += 1;
      }
      StringBuilder localStringBuilder = this.mStringBuilder;
      localStringBuilder.append(paramArrayOfString[(paramArrayOfString.length - 1)]);
      localStringBuilder.append('\n');
      if (this.mStringBuilder.length() > 32768)
      {
        paramArrayOfString = this.mStringBuilder.toString();
        if (this.mHandler.hasMessages(1)) {
          this.mHandler.removeMessages(1);
        }
        this.mHandler.sendMessage(Message.obtain(this.mHandler, 0, paramArrayOfString));
        this.mStringBuilder.setLength(0);
      }
      else if (!this.mHandler.hasMessages(1))
      {
        this.mHandler.sendEmptyMessageDelayed(1, 1000L);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramArrayOfString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.test.AccessRecorder
 * JD-Core Version:    0.7.0.1
 */