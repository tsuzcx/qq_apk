package com.tencent.upload.request.impl;

import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.FileUploadReq;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.request.UploadRequest;
import com.tencent.upload.task.data.UploadDataSource;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;

public class FileUploadRequest
  extends UploadRequest
{
  private static final String TAG = "FileUploadRequest";
  private String mAppid;
  private CheckType mCheckType;
  private long mDataLength;
  private UploadDataSource mDataSource;
  public long mFileLength = 0L;
  private boolean mNeedCheckSha1;
  public long mOffset;
  private String mSession;
  private byte[] mTempFileData;
  private String mUin;
  
  public FileUploadRequest(UploadDataSource paramUploadDataSource, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, CheckType paramCheckType, boolean paramBoolean)
  {
    this.mDataSource = paramUploadDataSource;
    this.mUin = paramString1;
    this.mAppid = paramString2;
    this.mSession = paramString3;
    this.mOffset = paramLong1;
    this.mDataLength = paramLong2;
    this.mCheckType = paramCheckType;
    this.mNeedCheckSha1 = paramBoolean;
    this.mFileLength = this.mDataSource.getDataLength();
  }
  
  protected JceStruct createJceRequest()
  {
    FileUploadReq localFileUploadReq = new FileUploadReq();
    localFileUploadReq.uin = this.mUin;
    localFileUploadReq.appid = this.mAppid;
    long l1 = this.mOffset;
    localFileUploadReq.offset = l1;
    localFileUploadReq.session = this.mSession;
    localFileUploadReq.check_type = 1;
    if (this.mNeedCheckSha1)
    {
      long l2 = this.mDataLength;
      arrayOfByte1 = new byte[(int)l2];
      this.mDataSource.readData(l1, (int)l2, arrayOfByte1, 0);
      this.mTempFileData = arrayOfByte1;
      localFileUploadReq.check_type = this.mCheckType.value();
      localFileUploadReq.checksum = FileUtils.getFileSha1(localFileUploadReq.data);
    }
    try
    {
      try
      {
        arrayOfByte1 = new byte[(int)this.mDataLength];
        try
        {
          if ((this.mTempFileData != null) && (this.mTempFileData.length > 0))
          {
            System.arraycopy(this.mTempFileData, 0, arrayOfByte1, 0, (int)this.mDataLength);
            this.mTempFileData = null;
            break label238;
          }
          l1 = this.mDataSource.readData((int)this.mOffset, (int)this.mDataLength, arrayOfByte1, 0);
        }
        catch (Throwable localThrowable1) {}
        localStringBuilder = new StringBuilder();
      }
      catch (Throwable localThrowable2)
      {
        arrayOfByte1 = null;
      }
      StringBuilder localStringBuilder;
      localStringBuilder.append("encode exception. reqId=");
      localStringBuilder.append(getRequestId());
      UploadLog.e("FileUploadRequest", localStringBuilder.toString(), localThrowable2);
      label238:
      l1 = 0L;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label243:
      byte[] arrayOfByte2;
      break label243;
    }
    UploadLog.e("FileUploadRequest", "encode request OOM. gc, then retry");
    System.gc();
    l1 = this.mDataLength;
    byte[] arrayOfByte1 = new byte[(int)l1];
    arrayOfByte2 = this.mTempFileData;
    if ((arrayOfByte2 != null) && (arrayOfByte2.length > 0))
    {
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, (int)l1);
      this.mTempFileData = null;
      l1 = 0L;
    }
    else
    {
      l1 = this.mDataSource.readData((int)this.mOffset, (int)this.mDataLength, arrayOfByte1, 0);
    }
    if ((arrayOfByte1 != null) && (l1 != 0L))
    {
      localFileUploadReq.data = arrayOfByte1;
      return localFileUploadReq;
    }
    UploadLog.e("FileUploadRequest", "encode data == null");
    return null;
  }
  
  public int getCmdId()
  {
    return 2;
  }
  
  public long getRealDataSize()
  {
    return this.mDataLength;
  }
  
  public boolean needTimeout()
  {
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskId=");
    localStringBuilder.append(getTaskId());
    localStringBuilder.append(" reqId=");
    localStringBuilder.append(getRequestId());
    localStringBuilder.append(" cmd=");
    localStringBuilder.append(getCmdId());
    localStringBuilder.append(" offset=");
    localStringBuilder.append(this.mOffset);
    localStringBuilder.append(" dataSize=");
    localStringBuilder.append(this.mDataLength);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.request.impl.FileUploadRequest
 * JD-Core Version:    0.7.0.1
 */