package com.tencent.upload.uinterface.data;

import ClientRecordUpload.ClientRecordUploadReq;
import SLICE_UPLOAD.UploadTouchuanReq;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.UploadLog;

public class ZipUploadTask
  extends AbstractUploadTask
{
  private static final String TAG = "ZipUploadTask";
  public int appid = 0;
  public int format = 0;
  private ClientRecordUploadReq req;
  public int zip_length = 0;
  
  public ZipUploadTask(String paramString, ClientRecordUploadReq paramClientRecordUploadReq)
  {
    super(paramString);
    this.mAppid = "touchuan_outer";
    this.iSync = 0;
    this.req = paramClientRecordUploadReq;
  }
  
  private byte[] getZipReq()
  {
    try
    {
      byte[] arrayOfByte = JceEncoder.encode(this.req);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return new byte[0];
  }
  
  public byte[] buildExtra()
  {
    Object localObject = new UploadTouchuanReq();
    ((UploadTouchuanReq)localObject).iUploadType = getUploadTaskType().uploadType;
    ((UploadTouchuanReq)localObject).vReqData = getZipReq();
    try
    {
      localObject = JceEncoder.encode((JceStruct)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      UploadLog.e("ZipUploadTask", localException.toString());
    }
    return null;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.ZipUploadTaskType;
  }
  
  public void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    onUploadSucceed(new ZipUploadResult());
    super.processFileUploadFinishRsp(paramArrayOfByte);
    onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.ZipUploadTask
 * JD-Core Version:    0.7.0.1
 */