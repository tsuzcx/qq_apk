package com.tencent.upload.uinterface.data;

import FileUpload.UploadUpsInfoReq;
import FileUpload.UploadUpsInfoRsp;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import com.tencent.upload.network.session.cache.CacheUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.BitmapUtils;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.UploadLog;
import java.util.Map;

public class UpsImageUploadTask
  extends AbstractUploadTask
{
  public static final String BUSINESS_CHAT_IMAGE = "gappchat";
  public static final String BUSINESS_COVER = "mqzonecover";
  public static final String BUSINESS_FACADE = "mqfacade";
  public static final String BUSINESS_FAVOR_PHOTO = "favpic";
  public static final String BUSINESS_LIVE_INTEREACT = "liveintereact";
  public static final String BUSINESS_MESSAGE = "msgboardpic";
  public static final String BUSINESS_SECRET_MOOD = "secretpic";
  public static final String BUSINESS_SHAREALBUM = "qqshare_photo";
  public static final String BUSINESS_SMART_VIDEO_COVER = "micro_video";
  public static final String BUSINESS_TOPIC_GROUP_PHOTO = "topicgroup_pic";
  private static final String TAG = "UpsImageUploadTask";
  public static final int TYPE_COVER = 2;
  public static final int TYPE_FACADE = 5;
  public static final int TYPE_FAVOR_PHOTO = 3;
  public static final int TYPE_MESSAGE = 0;
  public static final int TYPE_NONE = 0;
  public static final int TYPE_SECRET_MOOD = 4;
  public static final int TYPE_SHAREALBUM_PHOTO = 1;
  public int dataType;
  public String fileId;
  public long iBatchID;
  public int iBatchUploadCount;
  public int iBusiNessType;
  public int iCurrentUploadOrder;
  public int iUploadType = 0;
  public int keepRaw;
  public Map<String, byte[]> mapExt;
  public String sBusinessId = "";
  public String sCommand;
  public byte[] vBusiNessData;
  
  public UpsImageUploadTask(String paramString)
  {
    super(paramString);
    this.mAppid = "ups";
    this.iSync = 0;
  }
  
  public byte[] buildExtra()
  {
    UploadUpsInfoReq localUploadUpsInfoReq = new UploadUpsInfoReq();
    localUploadUpsInfoReq.iKeppRaw = this.keepRaw;
    localUploadUpsInfoReq.iAppid = this.iAppid;
    localUploadUpsInfoReq.iType = this.dataType;
    localUploadUpsInfoReq.sFileId = this.fileId;
    localUploadUpsInfoReq.sBusinessId = this.sBusinessId;
    localUploadUpsInfoReq.vBusiNessData = this.vBusiNessData;
    if (this.iBusiNessType != 0) {}
    for (int i = 1;; i = 0)
    {
      localUploadUpsInfoReq.bNotifyWns = ((byte)i);
      localUploadUpsInfoReq.iBatchId = this.iBatchID;
      localUploadUpsInfoReq.iBatUploadNum = this.iBatchUploadCount;
      localUploadUpsInfoReq.iCurUpload = this.iCurrentUploadOrder;
      localUploadUpsInfoReq.sWnsCmd = this.sCommand;
      BitmapFactory.Options localOptions = BitmapUtils.getOptions();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.uploadFilePath, localOptions);
      localUploadUpsInfoReq.iPicHight = localOptions.outHeight;
      localUploadUpsInfoReq.iPicWidth = localOptions.outWidth;
      localUploadUpsInfoReq.mapExt = this.mapExt;
      return JceEncoder.encode(localUploadUpsInfoReq);
    }
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.UpsUploadTaskType;
  }
  
  public void onDestroy()
  {
    if (!this.mKeepFileAfterUpload) {
      FileUtils.deleteTempFile(this.mFilePath);
    }
    CacheUtil.deleteSessionId(this, this.mSessionId);
  }
  
  public void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    try
    {
      localObject1 = (UploadUpsInfoRsp)JceEncoder.decode(UploadUpsInfoRsp.class, paramArrayOfByte);
      localObject2 = localObject1;
      localObject1 = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = Log.getStackTraceString(localException);
        UploadLog.w("UpsImageUploadTask", "get rsp ", localException);
      }
      Object localObject1 = new UpsImageUploadResult();
      ((UpsImageUploadResult)localObject1).flowId = this.flowId;
      ((UpsImageUploadResult)localObject1).dataType = ((UploadUpsInfoRsp)localObject2).iType;
      ((UpsImageUploadResult)localObject1).vBusiNessData = ((UploadUpsInfoRsp)localObject2).vBusiNessData;
      ((UpsImageUploadResult)localObject1).url = ((UploadUpsInfoRsp)localObject2).sUrl;
      ((UpsImageUploadResult)localObject1).rawWidth = ((UploadUpsInfoRsp)localObject2).iWidth;
      ((UpsImageUploadResult)localObject1).rawHeight = ((UploadUpsInfoRsp)localObject2).iHight;
      ((UpsImageUploadResult)localObject1).photoType = ((UploadUpsInfoRsp)localObject2).iPhotoType;
      onUploadSucceed(localObject1);
      super.processFileUploadFinishRsp(paramArrayOfByte);
      onDestroy();
    }
    if (localObject2 == null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "unpack UploadUpsInfoRsp==null. " + paramArrayOfByte;
      }
      onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), (String)localObject2);
      return;
    }
  }
  
  public void setAppid(int paramInt)
  {
    this.iAppid = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.UpsImageUploadTask
 * JD-Core Version:    0.7.0.1
 */