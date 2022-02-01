package com.tencent.upload.uinterface.data;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import org.json.JSONObject;

public class PhotoWallUploadTask
  extends AbstractUploadTask
{
  private static final String TAG = "PhotoWallUploadTask";
  public boolean autoRotate = false;
  public String clientIp;
  public int iUploadType = 0;
  public boolean mDeleteFileAfterUpload;
  public int op;
  public int source;
  public String title;
  
  public PhotoWallUploadTask(String paramString)
  {
    super(paramString);
  }
  
  private byte[] createDescInfor(PhotoWallUploadTask paramPhotoWallUploadTask)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("op", paramPhotoWallUploadTask.op);
    localJSONObject.put("source", paramPhotoWallUploadTask.source);
    if (!TextUtils.isEmpty(paramPhotoWallUploadTask.clientIp)) {
      localJSONObject.put("ip", paramPhotoWallUploadTask.clientIp);
    }
    if (!TextUtils.isEmpty(paramPhotoWallUploadTask.title)) {
      localJSONObject.put("title", paramPhotoWallUploadTask.title);
    }
    return localJSONObject.toString().getBytes();
  }
  
  private PhotoWallUploadResult decodeUploadResult(String paramString)
  {
    PhotoWallUploadResult localPhotoWallUploadResult = new PhotoWallUploadResult();
    localPhotoWallUploadResult.flowId = this.flowId;
    paramString = new JSONObject(paramString);
    localPhotoWallUploadResult.burl = paramString.getString("burl");
    localPhotoWallUploadResult.ctime = paramString.getInt("ctime");
    localPhotoWallUploadResult.filekey = paramString.getString("filekey");
    localPhotoWallUploadResult.publish_code = paramString.getInt("publish_code");
    localPhotoWallUploadResult.surl = paramString.getString("surl");
    localPhotoWallUploadResult.murl = paramString.getString("murl");
    localPhotoWallUploadResult.url = paramString.getString("url");
    return localPhotoWallUploadResult;
  }
  
  public byte[] buildExtra()
  {
    return null;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.PhotoWallUploadTaskType;
  }
  
  protected void onDestroy()
  {
    if (this.mDeleteFileAfterUpload) {
      FileUtils.deleteTempFile(this.mFilePath);
    }
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), "photowall upload task response is null");
      return;
    }
    Object localObject2 = new String(paramArrayOfByte);
    Object localObject1 = null;
    Object localObject3;
    try
    {
      localObject2 = decodeUploadResult((String)localObject2);
    }
    catch (Exception localException)
    {
      localObject1 = Log.getStackTraceString(localException);
      UploadLog.e("PhotoWallUploadTask", "decode photowallUpload result err", localException);
      localObject3 = null;
    }
    if (localObject3 == null)
    {
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("unpack PhotoWallUploadResult==null. ");
        ((StringBuilder)localObject1).append(paramArrayOfByte);
        localObject3 = ((StringBuilder)localObject1).toString();
      }
      onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), (String)localObject3);
      return;
    }
    if (this.uploadTaskCallback != null) {
      this.uploadTaskCallback.onUploadSucceed(this, localObject3);
    }
    super.processFileUploadFinishRsp(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.PhotoWallUploadTask
 * JD-Core Version:    0.7.0.1
 */