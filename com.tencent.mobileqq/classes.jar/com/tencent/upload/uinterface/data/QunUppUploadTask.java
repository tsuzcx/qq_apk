package com.tencent.upload.uinterface.data;

import FileUpload.MultiPicInfo;
import FileUpload.UploadUppInfoV2Req;
import FileUpload.UploadUppInfoV2Rsp;
import FileUpload.stPhotoSepcInfo;
import com.tencent.upload.image.ImageProcessUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.ProtocolUtil;
import com.tencent.upload.utils.StringUtils;
import com.tencent.upload.utils.UploadLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class QunUppUploadTask
  extends AbstractUploadTask
{
  public static final String QunUppAppId = "";
  private static final String TAG = "QunUppUploadTask";
  public String A2;
  public String albumId = "";
  public String appId = "";
  public boolean autoRotate = false;
  public long batchId = 0L;
  public String clientFakeKey;
  public String desc = "";
  public String deviceInfo = "";
  public int iUploadType = 0;
  public MultiPicInfo mutipic;
  public long photoHeight = 0L;
  public long photoSize = 0L;
  public long photoType = 0L;
  public long photoWidth = 0L;
  public String picPath = "";
  public String poiName = "";
  public int poiType = 0;
  public String poiX = "";
  public String poiY = "";
  public String title = "";
  public int type = 0;
  public long uploadIp = 0L;
  public String userId = "";
  
  public QunUppUploadTask(String paramString)
  {
    super(paramString);
  }
  
  private final UploadUppInfoV2Req getDescriptionObject(QunUppUploadTask paramQunUppUploadTask)
  {
    UploadUppInfoV2Req localUploadUppInfoV2Req = new UploadUppInfoV2Req();
    localUploadUppInfoV2Req.sAppId = "qun";
    localUploadUppInfoV2Req.sUserId = paramQunUppUploadTask.userId;
    localUploadUppInfoV2Req.sAlbumId = paramQunUppUploadTask.albumId;
    localUploadUppInfoV2Req.sTitle = paramQunUppUploadTask.title;
    localUploadUppInfoV2Req.sDesc = paramQunUppUploadTask.desc;
    localUploadUppInfoV2Req.sPicPath = paramQunUppUploadTask.uploadFilePath;
    localUploadUppInfoV2Req.iType = 0;
    localUploadUppInfoV2Req.iUploadIp = 1L;
    localUploadUppInfoV2Req.iBatchID = paramQunUppUploadTask.batchId;
    Object localObject = new stPhotoSepcInfo();
    File localFile = new File(paramQunUppUploadTask.uploadFilePath);
    ((stPhotoSepcInfo)localObject).iPhotoSize = localFile.length();
    IUploadConfig.UploadImageSize localUploadImageSize = ImageProcessUtil.decodeBitmapSize(paramQunUppUploadTask.uploadFilePath);
    ((stPhotoSepcInfo)localObject).iPhotoWidth = localUploadImageSize.width;
    ((stPhotoSepcInfo)localObject).iPhotoHeight = localUploadImageSize.height;
    ((stPhotoSepcInfo)localObject).iPhotoType = paramQunUppUploadTask.photoType;
    localUploadUppInfoV2Req.PhotoSpecInfo = ((stPhotoSepcInfo)localObject);
    localUploadUppInfoV2Req.mutlipicinfo = paramQunUppUploadTask.mutipic;
    localObject = new HashMap();
    ((Map)localObject).put("sFileMD5", FileUtils.getMd5ByFile_REAL(localFile));
    ((Map)localObject).put("sFirm", paramQunUppUploadTask.deviceInfo);
    ((Map)localObject).put("dLongitude", paramQunUppUploadTask.poiX);
    ((Map)localObject).put("dLatitude", paramQunUppUploadTask.poiY);
    ((Map)localObject).put("sPOIName", paramQunUppUploadTask.poiName);
    ((Map)localObject).put("sPOIType", Integer.toString(paramQunUppUploadTask.poiType));
    ((Map)localObject).put("mobile_fakefeeds_clientkey", StringUtils.getEmptyString(paramQunUppUploadTask.clientFakeKey));
    ((Map)localObject).put("a2", StringUtils.getEmptyString(paramQunUppUploadTask.A2));
    localUploadUppInfoV2Req.mapExt = ((Map)localObject);
    return localUploadUppInfoV2Req;
  }
  
  public byte[] buildExtra()
  {
    return null;
  }
  
  protected byte[] getControlRequestData()
  {
    try
    {
      byte[] arrayOfByte = ProtocolUtil.pack(getClass().getSimpleName(), this);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      UploadLog.w("QunUppUploadTask", "getControlRequestData()", localException);
    }
    return null;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.QunUploadTaskType;
  }
  
  public void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject;
    try
    {
      UploadUppInfoV2Rsp localUploadUppInfoV2Rsp = (UploadUppInfoV2Rsp)ProtocolUtil.unpack(UploadUppInfoV2Rsp.class.getSimpleName(), paramArrayOfByte);
      if (localUploadUppInfoV2Rsp == null)
      {
        paramArrayOfByte = "unpack PhotoWallUploadResult==null. " + paramArrayOfByte;
        onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), paramArrayOfByte);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        UploadLog.w("QunUppUploadTask", "finish", localException);
        localObject = null;
      }
      if (this.uploadTaskCallback == null) {
        break label134;
      }
    }
    if (localObject != null)
    {
      QunUppUploadResult localQunUppUploadResult = new QunUppUploadResult();
      localQunUppUploadResult.flowId = this.flowId;
      localQunUppUploadResult.url = localObject.sUrl;
      localQunUppUploadResult.photoId = localObject.sPhotoId;
      localQunUppUploadResult.mapSpecInfo = localObject.mapSpecInfo;
      this.uploadTaskCallback.onUploadSucceed(this, localQunUppUploadResult);
    }
    for (;;)
    {
      super.processFileUploadFinishRsp(paramArrayOfByte);
      return;
      label134:
      if (this.uploadTaskCallback != null) {
        this.uploadTaskCallback.onUploadSucceed(this, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.QunUppUploadTask
 * JD-Core Version:    0.7.0.1
 */