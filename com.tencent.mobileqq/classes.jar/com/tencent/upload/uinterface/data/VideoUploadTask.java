package com.tencent.upload.uinterface.data;

import FileUpload.UploadVideoInfoReq;
import FileUpload.UploadVideoInfoRsp;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.upload.report.ReportManager;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.UploadLog;
import java.io.File;
import java.util.Map;

public class VideoUploadTask
  extends AbstractUploadTask
{
  private static final String TAG = "VideoUploadTask";
  public Map<String, String> extend_info;
  public int iBusiNessType = 0;
  public int iFlag = 0;
  public int iIsFormatF20 = 0;
  public int iIsNew;
  public int iIsOriginalVideo = 0;
  public int iPlayTime = 0;
  private int iVideoH;
  private int iVideoW;
  public String sCoverUrl = "";
  public String sDesc = "";
  public String sTitle = "";
  public byte[] vBusiNessData = null;
  
  public VideoUploadTask(String paramString)
  {
    super(paramString);
    this.mAppid = "video_qzone";
  }
  
  private void initVideoSize()
  {
    k = 0;
    i = 0;
    if (TextUtils.isEmpty(this.uploadFilePath)) {}
    do
    {
      do
      {
        return;
      } while (!new File(this.uploadFilePath).exists());
      localMediaMetadataRetriever = new MediaMetadataRetriever();
      for (;;)
      {
        try
        {
          localMediaMetadataRetriever.setDataSource(this.uploadFilePath);
          str1 = localMediaMetadataRetriever.extractMetadata(18);
          str2 = localMediaMetadataRetriever.extractMetadata(19);
          str3 = localMediaMetadataRetriever.extractMetadata(24);
        }
        catch (Exception localException)
        {
          String str1;
          String str2;
          String str3;
          int j;
          UploadLog.w("VideoUploadTask", "MediaMetadataRetriever exception", localException);
          localMediaMetadataRetriever.release();
          i = k;
          continue;
        }
        finally
        {
          localMediaMetadataRetriever.release();
        }
        try
        {
          this.iVideoW = Integer.parseInt(str1);
          this.iVideoH = Integer.parseInt(str2);
          j = Integer.valueOf(str3).intValue();
          i = j;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          this.iVideoW = 0;
          this.iVideoH = 0;
          UploadLog.w("VideoUploadTask", "Video size is not number format...", localNumberFormatException);
        }
      }
      localMediaMetadataRetriever.release();
    } while (i % 180 == 0);
    i = this.iVideoH;
    this.iVideoH = this.iVideoW;
    this.iVideoW = i;
  }
  
  public byte[] buildExtra()
  {
    initVideoSize();
    UploadVideoInfoReq localUploadVideoInfoReq = new UploadVideoInfoReq();
    localUploadVideoInfoReq.sTitle = this.sTitle;
    localUploadVideoInfoReq.sDesc = this.sDesc;
    localUploadVideoInfoReq.iFlag = this.iFlag;
    localUploadVideoInfoReq.iIsNew = this.iIsNew;
    localUploadVideoInfoReq.iUploadTime = this.iUploadTime;
    localUploadVideoInfoReq.sCoverUrl = this.sCoverUrl;
    localUploadVideoInfoReq.iPlayTime = this.iPlayTime;
    if (this.vBusiNessData == null) {}
    for (byte[] arrayOfByte = new byte[0];; arrayOfByte = this.vBusiNessData)
    {
      localUploadVideoInfoReq.vBusiNessData = arrayOfByte;
      localUploadVideoInfoReq.iBusiNessType = this.iBusiNessType;
      localUploadVideoInfoReq.iIsOriginalVideo = this.iIsOriginalVideo;
      localUploadVideoInfoReq.iIsFormatF20 = this.iIsFormatF20;
      localUploadVideoInfoReq.extend_info = this.extend_info;
      localUploadVideoInfoReq.width = this.iVideoW;
      localUploadVideoInfoReq.height = this.iVideoH;
      try
      {
        arrayOfByte = JceEncoder.encode(localUploadVideoInfoReq);
        return arrayOfByte;
      }
      catch (Exception localException)
      {
        UploadLog.e("VideoUploadTask", localException.toString());
      }
    }
    return null;
  }
  
  public Const.FileType getFileType()
  {
    return Const.FileType.Video;
  }
  
  public int getMaxNetworkRetryTimes()
  {
    return 24;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.VideoUploadTaskType;
  }
  
  public void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    try
    {
      localObject1 = (UploadVideoInfoRsp)JceEncoder.decode(UploadVideoInfoRsp.class, paramArrayOfByte);
      localObject2 = localObject1;
      localObject1 = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = Log.getStackTraceString(localException);
        UploadLog.w("VideoUploadTask", "process finish", localException);
      }
      UploadLog.d("VideoUploadTask", "onUploadSucceed flowid = " + this.flowId + " filepath = " + this.mFilePath);
      Object localObject1 = new VideoUploadResult();
      ((VideoUploadResult)localObject1).flowId = this.flowId;
      ((VideoUploadResult)localObject1).sVid = ((UploadVideoInfoRsp)localObject2).sVid;
      ((VideoUploadResult)localObject1).iBusiNessType = ((UploadVideoInfoRsp)localObject2).iBusiNessType;
      ((VideoUploadResult)localObject1).vBusiNessData = ((UploadVideoInfoRsp)localObject2).vBusiNessData;
      onUploadSucceed(localObject1);
      super.processFileUploadFinishRsp(paramArrayOfByte);
      onDestroy();
    }
    if (localObject2 == null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "unpack UploadVideoInfoRsp == null. " + paramArrayOfByte;
      }
      onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), (String)localObject2);
      return;
    }
  }
  
  public void report(int paramInt, String paramString)
  {
    super.report(paramInt, paramString);
    paramString = this.mReportObj;
    if (this.iIsNew == 1) {}
    for (paramInt = 2;; paramInt = 1)
    {
      paramString.source = paramInt;
      if (!this.mReported)
      {
        ReportManager.report(getReportObj());
        this.mReported = true;
      }
      return;
    }
  }
  
  public void setIsNew(int paramInt)
  {
    this.iIsNew = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.VideoUploadTask
 * JD-Core Version:    0.7.0.1
 */