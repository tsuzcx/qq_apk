package com.tencent.upload.uinterface.data;

import FileUpload.UploadPicInfoRsp;
import FileUpload.stWaterTemplate;
import com.tencent.upload.uinterface.AbstractUploadResult;

public class ImageUploadResult
  extends AbstractUploadResult
{
  public long iBatchID = 0L;
  public int iBusiNessType = 0;
  public int iHeight = 0;
  public int iOriHeight = 0;
  public int iOriWidth = 0;
  public int iPicType = 0;
  public long iUin = 0L;
  public int iWidth = 0;
  public String imageFilePath = "";
  public UploadPicInfoRsp rsp;
  public String sAdaptUrl_1000 = "";
  public String sAdaptUrl_160 = "";
  public String sAdaptUrl_200 = "";
  public String sAdaptUrl_400 = "";
  public String sAdaptUrl_640 = "";
  public String sAlbumID = "";
  public String sBURL = "";
  public String sOriPhotoID = "";
  public String sOriUrl = "";
  public String sPhotoID = "";
  public String sPhotoMD5 = "";
  public String sSURL = "";
  public String sSloc = "";
  public byte[] vBusiNessData = null;
  public stWaterTemplate waterTemplate = null;
  
  public ImageUploadResult(long paramLong1, int paramInt, long paramLong2, UploadPicInfoRsp paramUploadPicInfoRsp)
  {
    this.iUin = paramLong1;
    this.iBatchID = paramLong2;
    this.flowId = paramInt;
    if (paramUploadPicInfoRsp == null) {
      return;
    }
    this.rsp = paramUploadPicInfoRsp;
    this.sSURL = paramUploadPicInfoRsp.sSURL;
    this.sBURL = paramUploadPicInfoRsp.sBURL;
    this.sAlbumID = paramUploadPicInfoRsp.sAlbumID;
    this.sPhotoID = paramUploadPicInfoRsp.sPhotoID;
    this.sSloc = paramUploadPicInfoRsp.sSloc;
    this.iWidth = paramUploadPicInfoRsp.iWidth;
    this.iHeight = paramUploadPicInfoRsp.iHeight;
    this.sOriUrl = paramUploadPicInfoRsp.sOriUrl;
    this.iOriWidth = paramUploadPicInfoRsp.iOriWidth;
    this.iOriHeight = paramUploadPicInfoRsp.iOriHeight;
    this.sOriPhotoID = paramUploadPicInfoRsp.sOriPhotoID;
    this.iPicType = paramUploadPicInfoRsp.iPicType;
    this.sAdaptUrl_160 = paramUploadPicInfoRsp.sAdaptUrl_160;
    this.sAdaptUrl_200 = paramUploadPicInfoRsp.sAdaptUrl_200;
    this.sAdaptUrl_400 = paramUploadPicInfoRsp.sAdaptUrl_400;
    this.sAdaptUrl_640 = paramUploadPicInfoRsp.sAdaptUrl_640;
    this.sAdaptUrl_1000 = paramUploadPicInfoRsp.sAdaptUrl_1000;
    this.waterTemplate = paramUploadPicInfoRsp.waterTemplate;
    this.iBusiNessType = paramUploadPicInfoRsp.iBusiNessType;
    this.vBusiNessData = paramUploadPicInfoRsp.vBusiNessDataRsp;
    this.sPhotoMD5 = paramUploadPicInfoRsp.sPhotoMD5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.ImageUploadResult
 * JD-Core Version:    0.7.0.1
 */