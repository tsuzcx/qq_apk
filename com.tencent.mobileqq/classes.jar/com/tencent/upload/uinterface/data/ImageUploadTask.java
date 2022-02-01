package com.tencent.upload.uinterface.data;

import FileUpload.MultiPicInfo;
import FileUpload.PicExtendInfo;
import FileUpload.UploadPicInfoReq;
import FileUpload.UploadPicInfoRsp;
import FileUpload.stPoi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
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
import com.tencent.upload.utils.UploadLog;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;

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
    boolean bool;
    if (localSoftReference.get() == null) {
      bool = true;
    } else {
      bool = false;
    }
    if (localUploadImageSize.height > 0)
    {
      if (localUploadImageSize.width <= 0) {
        return false;
      }
      return bool;
    }
    return false;
  }
  
  private boolean needRetryCompress(File paramFile)
  {
    this.mFilePath = getOriginalUploadFilePath();
    Object localObject = ImageProcessUtil.decodeBitmapOptions(this.mFilePath);
    boolean bool = "image/gif".equalsIgnoreCase(((BitmapFactory.Options)localObject).outMimeType);
    int j = 0;
    if (bool)
    {
      long l = paramFile.length();
      int k = UploadConfiguration.getCurrentNetworkCategory();
      int i;
      if (((k != 1) || (l >= 5242880L)) && ((k != 3) || (l >= 819200L)) && ((k != 2) || (l >= 2097152L)) && ((k != 6) || (l >= 2097152L)))
      {
        i = j;
        if (k == 7)
        {
          i = j;
          if (l >= 2097152L) {}
        }
      }
      else
      {
        i = 1;
      }
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
    if ("image/jpeg".equalsIgnoreCase(((BitmapFactory.Options)localObject).outMimeType)) {
      UploadConfiguration.getPictureQuality(this.mFilePath);
    }
    paramFile = new IUploadConfig.UploadImageSize(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight, 100);
    if ((paramFile.width == 0) && (paramFile.height == 0)) {
      return false;
    }
    UploadGlobalConfig.getConfig();
    ImageCompressor.copyTaskFile(this);
    return true;
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
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("buildExtra ");
      localStringBuilder.append(localThrowable.toString());
      UploadLog.e("ImageUploadTask", localStringBuilder.toString());
    }
    return null;
  }
  
  public UploadPicInfoReq createUploadPicInfoReq()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public long getCompressTime()
  {
    long l1 = this.compressEndTime;
    if (l1 != 0L)
    {
      long l2 = this.compressStartTime;
      if (l2 == 0L) {
        return 0L;
      }
      return l1 - l2;
    }
    return 0L;
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
  
  protected void onDestroy()
  {
    if (!this.mKeepFileAfterUpload)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy taskId=");
      localStringBuilder.append(getTaskId());
      localStringBuilder.append(", delete tmpFile=");
      localStringBuilder.append(this.mTmpUploadPath);
      UploadLog.d("ImageUploadTask", localStringBuilder.toString());
      FileUtils.deleteTempFile(this.mTmpUploadPath);
    }
    super.onDestroy();
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ImageUploadTask put <");
    ((StringBuilder)localObject1).append(this.mOriginFilePath);
    ((StringBuilder)localObject1).append(",");
    ((StringBuilder)localObject1).append(this.mSessionId);
    ((StringBuilder)localObject1).append(">");
    UploadLog.d("ImageUploadTask", ((StringBuilder)localObject1).toString());
    SessionPool.recordSessionId(this.mOriginFilePath, this.mSessionId);
    boolean bool = this.isHead;
    String str = null;
    Object localObject3 = null;
    localObject1 = str;
    if (!bool)
    {
      localObject1 = str;
      if (paramArrayOfByte != null)
      {
        localObject1 = str;
        if (paramArrayOfByte.length > 0)
        {
          try
          {
            localObject1 = (UploadPicInfoRsp)JceEncoder.decode(UploadPicInfoRsp.class, paramArrayOfByte);
            str = null;
            localObject3 = localObject1;
          }
          catch (Exception localException)
          {
            str = Log.getStackTraceString(localException);
            UploadLog.w("ImageUploadTask", "get rsp ", localException);
          }
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            if (str == null)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("unpack UploadPicInfoRsp=null. ");
              ((StringBuilder)localObject2).append(paramArrayOfByte);
              ((StringBuilder)localObject2).toString();
            }
            int i = Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode();
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("(");
            paramArrayOfByte.append(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode());
            paramArrayOfByte.append(")");
            paramArrayOfByte.append(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getDesc());
            onError(i, paramArrayOfByte.toString());
            return;
          }
        }
      }
    }
    localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = new UploadPicInfoRsp();
    }
    Object localObject2 = new ImageUploadResult(this.iUin, this.flowId, this.iBatchID, (UploadPicInfoRsp)localObject3);
    ((ImageUploadResult)localObject2).sessionId = this.mSessionId;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("onUploadSucceed flowid = ");
    ((StringBuilder)localObject3).append(this.flowId);
    ((StringBuilder)localObject3).append(" filepath = ");
    ((StringBuilder)localObject3).append(this.mFilePath);
    UploadLog.d("ImageUploadTask", ((StringBuilder)localObject3).toString());
    onUploadSucceed(localObject2);
    super.processFileUploadFinishRsp(paramArrayOfByte);
    onDestroy();
  }
  
  protected void report(int paramInt, String paramString)
  {
    super.report(paramInt, paramString);
    if (!this.mReported)
    {
      ReportManager.getInstance().report(this);
      this.mReported = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.ImageUploadTask
 * JD-Core Version:    0.7.0.1
 */