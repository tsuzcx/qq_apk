package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import tencent.im.qim.trans.QIMVideoUpload.QIMVideoUpload.ReqBody;

public class QIMWebVideoUploaderFirstFrame
{
  public static final String TAG = "QIMWebVideoUploaderFirstFrame";
  AppInterface mApp;
  private QIMWebVideoUploaderFirstFrame.IQIMWebVideoUpCallback mCallback;
  private int mErrCode;
  private String mErrDesc;
  private volatile boolean mIsCacheDiff = false;
  public boolean mNotifyStory = false;
  private byte[] mPicFileMd5;
  private String mPicFilePath;
  private HashMap<String, String> mReportInfo = new HashMap();
  public int mServiceType = 1;
  private long mStartTime;
  private Transaction mTrans = null;
  private String mTransInfo;
  private String mUin;
  private RandomAccessFile mVideoRaf;
  private String mVideouuid;
  
  public QIMWebVideoUploaderFirstFrame(AppInterface paramAppInterface, QIMWebVideoUploaderFirstFrame.IQIMWebVideoUpCallback paramIQIMWebVideoUpCallback, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2)
  {
    this.mApp = paramAppInterface;
    this.mCallback = paramIQIMWebVideoUpCallback;
    this.mPicFilePath = paramString1;
    this.mPicFileMd5 = paramArrayOfByte;
    this.mUin = this.mApp.getCurrentAccountUin();
    this.mServiceType = paramInt;
    this.mVideouuid = paramString2;
  }
  
  public boolean doUpload()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMWebVideoUploaderFirstFrame", 2, "<BDH_LOG> doUpload " + this.mNotifyStory);
    }
    this.mStartTime = SystemClock.uptimeMillis();
    if (this.mVideoRaf == null) {
      try
      {
        this.mVideoRaf = new RandomAccessFile(this.mPicFilePath, "r");
        if (this.mVideoRaf == null)
        {
          this.mErrCode = 9303;
          this.mErrDesc = "read video file error";
          this.mCallback.onPicUploadFailed(this.mErrCode, this.mErrDesc);
          return false;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.mVideoRaf = null;
        }
      }
    }
    Object localObject = new QIMVideoUpload.ReqBody();
    ((QIMVideoUpload.ReqBody)localObject).uint64_uin.set(Long.parseLong(this.mUin));
    ((QIMVideoUpload.ReqBody)localObject).uint64_service_type.set(this.mServiceType);
    ((QIMVideoUpload.ReqBody)localObject).uint64_data_type.set(1L);
    ((QIMVideoUpload.ReqBody)localObject).bytes_md5.set(ByteStringMicro.copyFrom(this.mPicFileMd5));
    ((QIMVideoUpload.ReqBody)localObject).uint64_pic_type.set(1L);
    ((QIMVideoUpload.ReqBody)localObject).str_video_uuid.set(this.mVideouuid);
    localObject = ((QIMVideoUpload.ReqBody)localObject).toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("QIMWebVideoUploaderFirstFrame", 2, "doUpload|mVideoFileMd5= " + HexUtil.bytes2HexStr(this.mPicFileMd5));
    }
    QIMWebVideoUploaderFirstFrame.1 local1 = new QIMWebVideoUploaderFirstFrame.1(this);
    this.mTrans = new Transaction(this.mUin, 53, this.mPicFilePath, 0, this.mPicFileMd5, local1, (byte[])localObject, false);
    int i = this.mApp.getHwEngine().submitTransactionTask(this.mTrans);
    if (QLog.isColorLevel()) {
      QLog.d("QIMWebVideoUploaderFirstFrame", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.mTrans.getTransationId() + " MD5:" + HexUtil.bytes2HexStr(this.mPicFileMd5) + " Path:" + this.mTrans.filePath + " Cmd:" + 53);
    }
    if (i != 0)
    {
      this.mErrCode = i;
      this.mErrDesc = "SubmitError";
      this.mCallback.onPicUploadFailed(this.mErrCode, this.mErrDesc);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.QIMWebVideoUploaderFirstFrame
 * JD-Core Version:    0.7.0.1
 */