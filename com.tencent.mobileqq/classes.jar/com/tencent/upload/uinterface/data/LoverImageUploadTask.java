package com.tencent.upload.uinterface.data;

import SLICE_UPLOAD.UploadTouchuanReq;
import SWU.SWUploadPicReq;
import SWU.SWUploadPicRsp;
import com.tencent.upload.network.session.cache.CacheUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.ProtocolUtil;

public class LoverImageUploadTask
  extends AbstractUploadTask
{
  private static final String TAG = "LoverImageUploadTask";
  private int iRetCode = 0;
  public int iUploadType = 0;
  public String mAddress = "";
  public String mAlbumID = "";
  public String mAppVersion = "";
  public long mBatchID = 0L;
  public String mClientip = "";
  public int mCurPicNum = 0;
  public String mDeviceID = "";
  public int mFromQZone = 0;
  public int mIsShareFeeds = 0;
  public String mLocalid = "";
  public String mOs = "";
  public String mOsVersion = "";
  public String mPicDesc = "";
  public int mPicHight = 0;
  public String mPicTitle = "";
  public String mPicUrl = "";
  public int mPicWidth = 0;
  public int mPictotalNum = 0;
  public int mPictureType = 0;
  public String mUserAgent = "";
  
  public LoverImageUploadTask(String paramString)
  {
    super(paramString);
    this.mAppid = "touchuan";
  }
  
  private byte[] getSWUploadPicReq()
  {
    Object localObject = new SWUploadPicReq();
    ((SWUploadPicReq)localObject).sPicTitle = this.mPicTitle;
    ((SWUploadPicReq)localObject).sPicDesc = this.mPicDesc;
    ((SWUploadPicReq)localObject).eUseType = 3;
    ((SWUploadPicReq)localObject).sAlbumID = this.mAlbumID;
    ((SWUploadPicReq)localObject).iBatchID = this.mBatchID;
    ((SWUploadPicReq)localObject).eFileType = this.mPictureType;
    ((SWUploadPicReq)localObject).sPicPath = this.uploadFilePath;
    ((SWUploadPicReq)localObject).iPicWidth = this.mPicWidth;
    ((SWUploadPicReq)localObject).iPicHight = this.mPicHight;
    ((SWUploadPicReq)localObject).sClientip = this.mClientip;
    ((SWUploadPicReq)localObject).isShareFeeds = this.mIsShareFeeds;
    ((SWUploadPicReq)localObject).sUserAgent = this.mUserAgent;
    ((SWUploadPicReq)localObject).sAddress = this.mAddress;
    ((SWUploadPicReq)localObject).iPictotalNum = this.mPictotalNum;
    ((SWUploadPicReq)localObject).iCurPicNum = this.mCurPicNum;
    ((SWUploadPicReq)localObject).iFromQZone = this.mFromQZone;
    ((SWUploadPicReq)localObject).pic_url = this.mPicUrl;
    ((SWUploadPicReq)localObject).keyType = 64;
    ((SWUploadPicReq)localObject).wnskey = this.vLoginData;
    ((SWUploadPicReq)localObject).localid = this.mLocalid;
    ((SWUploadPicReq)localObject).os = this.mOs;
    ((SWUploadPicReq)localObject).device = this.mDeviceID;
    ((SWUploadPicReq)localObject).osver = this.mOsVersion;
    ((SWUploadPicReq)localObject).ver = this.mAppVersion;
    ((SWUploadPicReq)localObject).duration = "0.0";
    ((SWUploadPicReq)localObject).itemid = "0";
    ((SWUploadPicReq)localObject).emojitype = "0";
    try
    {
      localObject = ProtocolUtil.pack(localObject.getClass().getSimpleName(), localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return new byte[0];
  }
  
  public byte[] buildExtra()
  {
    UploadTouchuanReq localUploadTouchuanReq = new UploadTouchuanReq();
    localUploadTouchuanReq.iUploadType = getUploadTaskType().uploadType;
    localUploadTouchuanReq.vReqData = getSWUploadPicReq();
    return JceEncoder.encode(localUploadTouchuanReq);
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.LoverImageUploadTaskType;
  }
  
  protected void onDestroy()
  {
    if (!this.mKeepFileAfterUpload) {
      FileUtils.deleteTempFile(this.mFilePath);
    }
    CacheUtil.deleteSessionId(this, this.mSessionId);
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    SWUploadPicRsp localSWUploadPicRsp = new SWUploadPicRsp();
    int i = this.iRetCode;
    localSWUploadPicRsp.iCode = i;
    if (i != 0)
    {
      i = Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("iRetCode = ");
      paramArrayOfByte.append(this.iRetCode);
      onError(i, paramArrayOfByte.toString());
      return;
    }
    LoverImageUploadResult localLoverImageUploadResult = new LoverImageUploadResult();
    localLoverImageUploadResult.code = localSWUploadPicRsp.iCode;
    localLoverImageUploadResult.albumId = localSWUploadPicRsp.sAlbumID;
    localLoverImageUploadResult.flowId = this.flowId;
    localLoverImageUploadResult.height = localSWUploadPicRsp.iHeight;
    localLoverImageUploadResult.width = localSWUploadPicRsp.iWidth;
    localLoverImageUploadResult.name = localSWUploadPicRsp.sName;
    localLoverImageUploadResult.photoId = localSWUploadPicRsp.sPhotoID;
    localLoverImageUploadResult.picType = localSWUploadPicRsp.ePicType;
    localLoverImageUploadResult.uploadTs = localSWUploadPicRsp.iUploadTs;
    localLoverImageUploadResult.url = localSWUploadPicRsp.sURL;
    onUploadSucceed(localLoverImageUploadResult);
    super.processFileUploadFinishRsp(paramArrayOfByte);
    onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.LoverImageUploadTask
 * JD-Core Version:    0.7.0.1
 */