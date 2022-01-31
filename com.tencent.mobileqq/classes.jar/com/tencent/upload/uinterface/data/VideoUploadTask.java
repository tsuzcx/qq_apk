package com.tencent.upload.uinterface.data;

import FileUpload.UploadVideoInfoReq;
import FileUpload.UploadVideoInfoRsp;
import android.util.Log;
import com.tencent.upload.a.a;
import com.tencent.upload.common.Const.UploadRetCode;
import com.tencent.upload.common.Const.b;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
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
  public String sCoverUrl = "";
  public String sDesc = "";
  public String sTitle = "";
  public byte[] vBusiNessData = null;
  
  public VideoUploadTask(String paramString)
  {
    super(paramString);
    this.mAppid = "video_qzone";
  }
  
  public byte[] buildExtra()
  {
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
      try
      {
        arrayOfByte = com.tencent.upload.e.b.a(localUploadVideoInfoReq);
        return arrayOfByte;
      }
      catch (Exception localException)
      {
        com.tencent.upload.common.b.e("VideoUploadTask", localException.toString());
      }
    }
    return null;
  }
  
  public Const.b getFileType()
  {
    return Const.b.d;
  }
  
  protected int getMaxNetworkRetryTimes()
  {
    return 24;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.VideoUploadTaskType;
  }
  
  protected void onDestroy()
  {
    a.b(this, this.mSessionId);
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    try
    {
      localObject1 = (UploadVideoInfoRsp)com.tencent.upload.e.b.a(UploadVideoInfoRsp.class, paramArrayOfByte);
      localObject2 = localObject1;
      localObject1 = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = Log.getStackTraceString(localException);
        com.tencent.upload.common.b.b("VideoUploadTask", "process finish", localException);
      }
      com.tencent.upload.common.b.b("VideoUploadTask", "onUploadSucceed flowid = " + this.flowId + " filepath = " + this.mFilePath);
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
  
  protected void report(int paramInt, String paramString)
  {
    super.report(paramInt, paramString);
    paramString = this.mReportObj;
    if (this.iIsNew == 1) {}
    for (paramInt = 2;; paramInt = 1)
    {
      paramString.source = paramInt;
      if (!this.mReported)
      {
        com.tencent.upload.report.b.a(getReportObj());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.VideoUploadTask
 * JD-Core Version:    0.7.0.1
 */