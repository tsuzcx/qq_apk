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
  
  public JceStruct createJceRequest()
  {
    FileUploadReq localFileUploadReq = new FileUploadReq();
    localFileUploadReq.uin = this.mUin;
    localFileUploadReq.appid = this.mAppid;
    localFileUploadReq.offset = this.mOffset;
    localFileUploadReq.session = this.mSession;
    localFileUploadReq.check_type = 1;
    if (this.mNeedCheckSha1)
    {
      localObject = new byte[(int)this.mDataLength];
      this.mDataSource.readData(this.mOffset, (int)this.mDataLength, (byte[])localObject, 0);
      this.mTempFileData = ((byte[])localObject);
      localFileUploadReq.check_type = this.mCheckType.value();
      localFileUploadReq.checksum = FileUtils.getFileSha1(localFileUploadReq.data);
    }
    Object localObject = null;
    for (long l1 = 0L;; l1 = l2)
    {
      try
      {
        arrayOfByte2 = new byte[(int)this.mDataLength];
        localObject = arrayOfByte2;
        if (this.mTempFileData == null) {
          break label210;
        }
        localObject = arrayOfByte2;
        if (this.mTempFileData.length <= 0) {
          break label210;
        }
        localObject = arrayOfByte2;
        System.arraycopy(this.mTempFileData, 0, arrayOfByte2, 0, (int)this.mDataLength);
        localObject = arrayOfByte2;
        this.mTempFileData = null;
        l1 = 0L;
        localObject = arrayOfByte2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          byte[] arrayOfByte2;
          long l2;
          UploadLog.e("FileUploadRequest", "encode request OOM. gc, then retry");
          System.gc();
          arrayOfByte1 = new byte[(int)this.mDataLength];
          if ((this.mTempFileData != null) && (this.mTempFileData.length > 0))
          {
            System.arraycopy(this.mTempFileData, 0, arrayOfByte1, 0, (int)this.mDataLength);
            this.mTempFileData = null;
          }
          else
          {
            l1 = this.mDataSource.readData((int)this.mOffset, (int)this.mDataLength, arrayOfByte1, 0);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        label210:
        byte[] arrayOfByte1;
        for (;;)
        {
          UploadLog.e("FileUploadRequest", "encode exception. reqId=" + getRequestId(), localThrowable);
        }
        localFileUploadReq.data = arrayOfByte1;
      }
      if ((localObject != null) && (l1 != 0L)) {
        break label360;
      }
      UploadLog.e("FileUploadRequest", "encode data == null");
      return null;
      localObject = arrayOfByte2;
      l2 = this.mDataSource.readData((int)this.mOffset, (int)this.mDataLength, arrayOfByte2, 0);
    }
    label360:
    return localFileUploadReq;
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
    localStringBuilder.append("taskId=").append(getTaskId()).append(" reqId=").append(getRequestId()).append(" cmd=").append(getCmdId()).append(" offset=").append(this.mOffset).append(" dataSize=").append(this.mDataLength);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.request.impl.FileUploadRequest
 * JD-Core Version:    0.7.0.1
 */