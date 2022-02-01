package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import tencent.im.qim.trans.QIMVideoUpload.QIMVideoUpload.ReqBody;

public class QIMWebVideoUploader
{
  public static final String TAG = "QIMWebVideoUploader";
  AppInterface mApp;
  private QIMWebVideoUploader.IQIMWebVideoUpCallback mCallback;
  private int mErrCode;
  private String mErrDesc;
  private volatile boolean mIsCacheDiff;
  public boolean mNotifyStory;
  private HashMap<String, String> mReportInfo = new HashMap();
  public int mServiceType = 1;
  private long mStartTime;
  private Transaction mTrans;
  private String mTransInfo;
  private String mUUID;
  private String mUin;
  private byte[] mVideoFileMd5;
  private String mVideoFilePath;
  private RandomAccessFile mVideoRaf;
  
  public QIMWebVideoUploader(AppInterface paramAppInterface, QIMWebVideoUploader.IQIMWebVideoUpCallback paramIQIMWebVideoUpCallback, String paramString, byte[] paramArrayOfByte)
  {
    this(paramAppInterface, paramIQIMWebVideoUpCallback, paramString, paramArrayOfByte, 1, true);
  }
  
  public QIMWebVideoUploader(AppInterface paramAppInterface, QIMWebVideoUploader.IQIMWebVideoUpCallback paramIQIMWebVideoUpCallback, String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    this.mApp = paramAppInterface;
    this.mCallback = paramIQIMWebVideoUpCallback;
    this.mVideoFilePath = paramString;
    this.mVideoFileMd5 = paramArrayOfByte;
    this.mUin = this.mApp.getCurrentAccountUin();
    this.mServiceType = paramInt;
    this.mNotifyStory = paramBoolean;
  }
  
  private void doReport(boolean paramBoolean)
  {
    long l = (System.nanoTime() - this.mStartTime) / 1000000L;
    this.mReportInfo.put("param_uuid", this.mUUID);
    this.mReportInfo.put("param_fileMd5", HexUtil.bytes2HexStr(this.mVideoFileMd5));
    this.mReportInfo.put("param_BDH_Cache_Diff", String.valueOf(this.mIsCacheDiff));
    if (paramBoolean) {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "QIMWebVideoUploader", true, l, 0L, this.mReportInfo, "");
    }
    while (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.mReportInfo.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.mReportInfo.get(str) != null)
        {
          localStringBuilder.append("&");
          localStringBuilder.append(str);
          localStringBuilder.append("=");
          localStringBuilder.append((String)this.mReportInfo.get(str));
        }
      }
      this.mReportInfo.put("param_FailCode", String.valueOf(this.mErrCode));
      this.mReportInfo.put("param_errorDesc", this.mErrDesc);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "QIMWebVideoUploader", false, l, 0L, this.mReportInfo, "");
    }
  }
  
  public void cancelTask()
  {
    if (this.mTrans != null) {
      this.mTrans.cancelTransaction();
    }
  }
  
  public boolean doUpload()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMWebVideoUploader", 2, "<BDH_LOG> doUpload " + this.mNotifyStory);
    }
    this.mStartTime = SystemClock.uptimeMillis();
    if (this.mVideoRaf == null) {
      try
      {
        this.mVideoRaf = new RandomAccessFile(this.mVideoFilePath, "r");
        if (this.mVideoRaf == null)
        {
          this.mErrCode = 9303;
          this.mErrDesc = "read video file error";
          this.mCallback.onFailed(this.mErrCode, this.mErrDesc);
          doReport(false);
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
    Object localObject1 = new QIMVideoUpload.ReqBody();
    ((QIMVideoUpload.ReqBody)localObject1).uint64_uin.set(Long.parseLong(this.mUin));
    ((QIMVideoUpload.ReqBody)localObject1).uint64_service_type.set(this.mServiceType);
    ((QIMVideoUpload.ReqBody)localObject1).uint64_data_type.set(2L);
    ((QIMVideoUpload.ReqBody)localObject1).bytes_md5.set(ByteStringMicro.copyFrom(this.mVideoFileMd5));
    Object localObject2 = ((QIMVideoUpload.ReqBody)localObject1).uint64_not_notify_story_flag;
    if (this.mNotifyStory) {}
    for (long l = 0L;; l = 1L)
    {
      ((PBUInt64Field)localObject2).set(l);
      localObject1 = ((QIMVideoUpload.ReqBody)localObject1).toByteArray();
      if (QLog.isColorLevel()) {
        QLog.d("QIMWebVideoUploader", 2, "doUpload|mVideoFileMd5= " + HexUtil.bytes2HexStr(this.mVideoFileMd5));
      }
      localObject2 = new QIMWebVideoUploader.1(this);
      this.mTrans = new Transaction(this.mUin, 52, this.mVideoFilePath, 0, this.mVideoFileMd5, (ITransactionCallback)localObject2, (byte[])localObject1, false);
      int i = this.mApp.getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel()) {
        QLog.d("QIMWebVideoUploader", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.mTrans.getTransationId() + " MD5:" + HexUtil.bytes2HexStr(this.mVideoFileMd5) + " Path:" + this.mTrans.filePath + " Cmd:" + 52);
      }
      if (i == 0) {
        break;
      }
      this.mErrCode = i;
      this.mErrDesc = "SubmitError";
      this.mCallback.onFailed(this.mErrCode, this.mErrDesc);
      doReport(false);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.QIMWebVideoUploader
 * JD-Core Version:    0.7.0.1
 */