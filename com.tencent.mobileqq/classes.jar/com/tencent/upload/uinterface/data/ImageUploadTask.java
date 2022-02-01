package com.tencent.upload.uinterface.data;

import FileUpload.MultiPicInfo;
import FileUpload.PicExtendInfo;
import FileUpload.UploadPicInfoReq;
import FileUpload.UploadPicInfoRsp;
import FileUpload.stPoi;
import FileUpload.stWaterTemplate;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.image.ImageProcessUtil;
import com.tencent.upload.impl.ImageCompressor;
import com.tencent.upload.network.session.SessionPool;
import com.tencent.upload.report.ReportManager;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.BitmapUtils;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.StringUtils;
import com.tencent.upload.utils.UploadLog;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class ImageUploadTask
  extends AbstractUploadTask
{
  public static final int IMAGE_QUALITY_HIGH = 2;
  public static final int IMAGE_QUALITY_ORIGIN = 3;
  private static final String TAG = "ImageUploadTask";
  public boolean autoRotate = false;
  public boolean bWaterType = false;
  public String clientFakeKey;
  public long compressEndTime;
  public long compressStartTime;
  public String exifTime = "";
  public int iAlbumTypeID = 0;
  public long iBatchID = 0L;
  public int iBitmap = 0;
  public int iBusiNessType = 0;
  public int iDistinctUse = 0;
  public int iUpPicType = 0;
  public int iUploadType = 0;
  public boolean isCover;
  public boolean isHead;
  public HashMap<String, byte[]> mExternalByteData = null;
  public HashMap<String, String> mapExt = null;
  public MultiPicInfo mutliPicInfo = null;
  public boolean needBatch = true;
  public String sAlbumID = "";
  public String sAlbumName = "";
  public String sPicDesc = "";
  public String sPicTitle = "";
  public String srcVideoPath;
  public PicExtendInfo stExtendInfo = null;
  public HashMap<String, String> stExternalMapExt = null;
  public stPoi uploadPoi = null;
  public byte[] vBusiNessData = null;
  public String waterTemplateId;
  public String watermarkPoiName;
  
  public ImageUploadTask(String paramString)
  {
    super(paramString);
    this.mKeepFileAfterUpload = false;
  }
  
  public ImageUploadTask(boolean paramBoolean, String paramString)
  {
    this(paramString);
    this.isHead = paramBoolean;
    this.mAppid = "pic_qzone";
    this.mNeedBatch = this.needBatch;
  }
  
  private boolean isValidImageFile()
  {
    SoftReference localSoftReference = new SoftReference(new byte[0]);
    IUploadConfig.UploadImageSize localUploadImageSize = ImageProcessUtil.decodeBitmapSize(this.uploadFilePath);
    if (localSoftReference.get() == null) {}
    for (boolean bool = true;; bool = false)
    {
      if ((localUploadImageSize.height <= 0) || (localUploadImageSize.width <= 0)) {
        bool = false;
      }
      return bool;
    }
  }
  
  private boolean needRetryCompress(File paramFile)
  {
    this.mFilePath = getOriginalUploadFilePath();
    Object localObject = ImageProcessUtil.decodeBitmapOptions(this.mFilePath);
    if ("image/gif".equalsIgnoreCase(((BitmapFactory.Options)localObject).outMimeType))
    {
      long l = paramFile.length();
      i = UploadConfiguration.getCurrentNetworkCategory();
      if (((i == 1) && (l < 5242880L)) || ((i == 3) && (l < 819200L)) || ((i == 2) && (l < 2097152L)) || ((i == 6) && (l < 2097152L)) || ((i == 7) && (l < 2097152L))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          paramFile = BitmapUtils.getOptions();
          localObject = ImageProcessUtil.decodeFileWithRetry(this.mFilePath, paramFile);
          String str = FileUtils.getTempFilePath(UploadGlobalConfig.getContext(), this.mFilePath, this.md5, this.flowId);
          paramFile = (File)localObject;
          if (localObject != null)
          {
            paramFile = (File)localObject;
            if (str != null)
            {
              paramFile = (File)localObject;
              if (ImageProcessUtil.bitmapToFile((Bitmap)localObject, str, 80, false, false, null))
              {
                ((Bitmap)localObject).recycle();
                paramFile = null;
              }
            }
          }
          if (paramFile != null) {
            paramFile.recycle();
          }
        }
        ImageCompressor.copyTaskFile(this);
        return true;
      }
    }
    if ("image/jpeg".equalsIgnoreCase(((BitmapFactory.Options)localObject).outMimeType)) {}
    for (int i = UploadConfiguration.getPictureQuality(this.mFilePath);; i = 100)
    {
      int j = i;
      if (i <= 0) {
        j = 100;
      }
      paramFile = new IUploadConfig.UploadImageSize(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight, 100);
      if ((paramFile.width == 0) && (paramFile.height == 0)) {
        return false;
      }
      UploadGlobalConfig.getConfig();
      if (0 != 0) {
        throw new NullPointerException();
      }
      if (1 == 0)
      {
        i = paramFile.width;
        throw new NullPointerException();
      }
      ImageCompressor.copyTaskFile(this);
      return true;
    }
  }
  
  private String safeString(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  public byte[] buildExtra()
  {
    Object localObject = createUploadPicInfoReq();
    try
    {
      localObject = JceEncoder.encode((JceStruct)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      UploadLog.e("ImageUploadTask", localException.toString());
    }
    return null;
  }
  
  public UploadPicInfoReq createUploadPicInfoReq()
  {
    UploadPicInfoReq localUploadPicInfoReq = new UploadPicInfoReq();
    localUploadPicInfoReq.sPicTitle = StringUtils.getEmptyString(this.sPicTitle);
    localUploadPicInfoReq.sPicDesc = StringUtils.getEmptyString(this.sPicDesc);
    localUploadPicInfoReq.sAlbumID = StringUtils.getEmptyString(this.sAlbumID);
    localUploadPicInfoReq.sAlbumName = StringUtils.getEmptyString(this.sAlbumName);
    localUploadPicInfoReq.iAlbumTypeID = this.iAlbumTypeID;
    localUploadPicInfoReq.iBitmap = this.iBitmap;
    localUploadPicInfoReq.iUploadType = this.iUploadType;
    localUploadPicInfoReq.iUpPicType = this.iUpPicType;
    localUploadPicInfoReq.iBatchID = this.iBatchID;
    localUploadPicInfoReq.mutliPicInfo = this.mutliPicInfo;
    localUploadPicInfoReq.mapExt = this.mapExt;
    if (this.stExtendInfo == null) {
      this.stExtendInfo = new PicExtendInfo();
    }
    localUploadPicInfoReq.stExtendInfo = this.stExtendInfo;
    localUploadPicInfoReq.stExternalMapExt = this.stExternalMapExt;
    if ((this.isCover) && (!TextUtils.isEmpty(this.srcVideoPath))) {
      localUploadPicInfoReq.sPicPath = this.srcVideoPath;
    }
    for (;;)
    {
      Object localObject1 = ImageProcessUtil.decodeBitmapSize(this.uploadFilePath);
      localUploadPicInfoReq.iPicWidth = ((IUploadConfig.UploadImageSize)localObject1).width;
      localUploadPicInfoReq.iPicHight = ((IUploadConfig.UploadImageSize)localObject1).height;
      int i;
      label217:
      label240:
      Object localObject3;
      Object localObject2;
      if (this.bWaterType)
      {
        i = 1;
        localUploadPicInfoReq.iWaterType = i;
        if (Build.VERSION.SDK_INT >= 5)
        {
          if (localUploadPicInfoReq.stExtendInfo != null) {
            break label1187;
          }
          localObject1 = null;
          if (localObject1 != null)
          {
            localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("Make"));
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localUploadPicInfoReq.sExif_CameraMaker = ((String)localObject2);
            localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("Model"));
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localUploadPicInfoReq.sExif_CameraModel = ((String)localObject2);
            localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("GPSLatitude"));
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localUploadPicInfoReq.sExif_Latitude = ((String)localObject2);
            localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("GPSLatitudeRef"));
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localUploadPicInfoReq.sExif_LatitudeRef = ((String)localObject2);
            localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("GPSLongitude"));
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localUploadPicInfoReq.sExif_Longitude = ((String)localObject2);
            localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("GPSLongitudeRef"));
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localUploadPicInfoReq.sExif_LongitudeRef = ((String)localObject2);
            if (this.iUploadType == 3) {
              localObject1 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("Orientation"));
            }
          }
        }
      }
      try
      {
        switch (Integer.parseInt((String)localObject1))
        {
        case 4: 
        case 5: 
        case 7: 
          localObject1 = "0";
          if (localUploadPicInfoReq.stExtendInfo.mapParams == null) {
            localUploadPicInfoReq.stExtendInfo.mapParams = new HashMap();
          }
          localObject3 = localUploadPicInfoReq.stExtendInfo.mapParams;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          ((Map)localObject3).put("rotation", localObject2);
          localUploadPicInfoReq.sExif_Time = this.exifTime;
          localUploadPicInfoReq.iUploadTime = this.iUploadTime;
          localObject1 = (HashMap)localUploadPicInfoReq.mapExt;
          if (localObject1 == null)
          {
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("mobile_fakefeeds_clientkey", StringUtils.getEmptyString(this.clientFakeKey));
            if ((localUploadPicInfoReq.stExtendInfo != null) && (localUploadPicInfoReq.stExtendInfo.mapParams == null)) {
              localUploadPicInfoReq.stExtendInfo.mapParams = new HashMap();
            }
            if (localUploadPicInfoReq.stExtendInfo == null) {
              break;
            }
          }
          break;
        case 6: 
        case 8: 
          try
          {
            label520:
            localObject2 = getOriginalUploadFilePath();
            localObject3 = ImageProcessUtil.decodeBitmapOptions((String)localObject2);
            localUploadPicInfoReq.stExtendInfo.mapParams.put("raw_width", Integer.toString(((BitmapFactory.Options)localObject3).outWidth));
            localUploadPicInfoReq.stExtendInfo.mapParams.put("raw_height", Integer.toString(((BitmapFactory.Options)localObject3).outHeight));
            localUploadPicInfoReq.stExtendInfo.mapParams.put("raw_size", Long.toString(new File((String)localObject2).length()));
            localObject2 = (String)this.stExtendInfo.mapParams.get("geo_x");
            localUploadPicInfoReq.stExtendInfo.mapParams.put("geo_x", safeString((String)localObject2));
            localObject2 = (String)this.stExtendInfo.mapParams.get("geo_y");
            localUploadPicInfoReq.stExtendInfo.mapParams.put("geo_y", safeString((String)localObject2));
            localObject2 = (String)this.stExtendInfo.mapParams.get("geo_id");
            localUploadPicInfoReq.stExtendInfo.mapParams.put("geo_id", safeString((String)localObject2));
            localObject2 = (String)this.stExtendInfo.mapParams.get("geo_idname");
            localUploadPicInfoReq.stExtendInfo.mapParams.put("geo_idname", safeString((String)localObject2));
            localObject2 = (String)this.stExtendInfo.mapParams.get("geo_name");
            localUploadPicInfoReq.stExtendInfo.mapParams.put("geo_name", safeString((String)localObject2));
            localObject2 = (String)this.stExtendInfo.mapParams.get("show_geo");
            localUploadPicInfoReq.stExtendInfo.mapParams.put("show_geo", safeString((String)localObject2));
            ((HashMap)localObject1).put("appid", this.mAppid);
            if ((this.vLoginData != null) && (this.vLoginData.length > 0)) {
              ((HashMap)localObject1).put("a2_key", new String(this.vLoginData));
            }
            if (!TextUtils.isEmpty(this.uiRefer)) {
              ((HashMap)localObject1).put("refer", this.uiRefer);
            }
            localUploadPicInfoReq.mapExt = ((Map)localObject1);
            localUploadPicInfoReq.iDistinctUse = this.iDistinctUse;
            localUploadPicInfoReq.uploadPoi = this.uploadPoi;
            localUploadPicInfoReq.waterTemplate = new stWaterTemplate(this.waterTemplateId, this.watermarkPoiName);
            localUploadPicInfoReq.iBusiNessType = this.iBusiNessType;
            if (localUploadPicInfoReq.iBusiNessType == 1) {
              if (this.vBusiNessData == null) {
                localObject1 = new byte[0];
              }
            }
            label1152:
            for (localUploadPicInfoReq.vBusiNessData = ((byte[])localObject1);; localUploadPicInfoReq.vBusiNessData = new byte[0])
            {
              localUploadPicInfoReq.ExternalData = this.mExternalByteData;
              return localUploadPicInfoReq;
              localUploadPicInfoReq.sPicPath = getOriginalUploadFilePath();
              break;
              i = 0;
              break label217;
              label1187:
              localObject1 = localUploadPicInfoReq.stExtendInfo.mapExif;
              break label240;
              localObject1 = "90";
              break label520;
              localObject1 = "270";
              break label520;
              localObject1 = this.vBusiNessData;
              break label1152;
            }
          }
          catch (Exception localException)
          {
            break;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          continue;
          continue;
          continue;
          localObject1 = "180";
        }
      }
    }
  }
  
  public long getCompressTime()
  {
    if ((this.compressEndTime == 0L) || (this.compressStartTime == 0L)) {
      return 0L;
    }
    return this.compressEndTime - this.compressStartTime;
  }
  
  public Const.FileType getFileType()
  {
    return Const.FileType.Photo;
  }
  
  public final String getOriginalUploadFilePath()
  {
    return this.mFilePath;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    if (this.isHead) {
      return TaskTypeConfig.HeadUploadTaskType;
    }
    return TaskTypeConfig.ImageUploadTaskType;
  }
  
  public void onDestroy()
  {
    if (!this.mKeepFileAfterUpload)
    {
      UploadLog.d("ImageUploadTask", "onDestroy taskId=" + getTaskId() + ", delete tmpFile=" + this.mTmpUploadPath);
      FileUtils.deleteTempFile(this.mTmpUploadPath);
    }
    super.onDestroy();
  }
  
  public void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    UploadLog.d("ImageUploadTask", "ImageUploadTask put <" + this.mOriginFilePath + "," + this.mSessionId + ">");
    SessionPool.recordSessionId(this.mOriginFilePath, this.mSessionId);
    Object localObject1 = localObject2;
    if (!this.isHead)
    {
      localObject1 = localObject2;
      if (paramArrayOfByte != null)
      {
        localObject1 = localObject2;
        if (paramArrayOfByte.length > 0)
        {
          try
          {
            localObject1 = (UploadPicInfoRsp)JceEncoder.decode(UploadPicInfoRsp.class, paramArrayOfByte);
            localObject3 = localObject1;
            localObject2 = null;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localObject2 = Log.getStackTraceString(localException);
              UploadLog.w("ImageUploadTask", "get rsp ", localException);
            }
          }
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "unpack UploadPicInfoRsp=null. " + paramArrayOfByte;
            }
            onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), (String)localObject1);
            return;
          }
        }
      }
    }
    localObject2 = localException;
    if (localException == null) {
      localObject2 = new UploadPicInfoRsp();
    }
    ImageUploadResult localImageUploadResult = new ImageUploadResult(this.iUin, this.flowId, this.iBatchID, (UploadPicInfoRsp)localObject2);
    localImageUploadResult.sessionId = this.mSessionId;
    UploadLog.d("ImageUploadTask", "onUploadSucceed flowid = " + this.flowId + " filepath = " + this.mFilePath);
    onUploadSucceed(localImageUploadResult);
    super.processFileUploadFinishRsp(paramArrayOfByte);
    onDestroy();
  }
  
  public void report(int paramInt, String paramString)
  {
    super.report(paramInt, paramString);
    if (!this.mReported)
    {
      ReportManager.getInstance().report(this);
      this.mReported = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.ImageUploadTask
 * JD-Core Version:    0.7.0.1
 */