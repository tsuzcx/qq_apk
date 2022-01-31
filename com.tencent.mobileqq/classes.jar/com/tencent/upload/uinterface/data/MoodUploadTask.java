package com.tencent.upload.uinterface.data;

import FileUpload.ShuoshuoInfoReq;
import FileUpload.ShuoshuoInfoRsp;
import FileUpload.ShuoshuoPicInfo;
import SLICE_UPLOAD.AuthToken;
import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.FileBatchControlRsp;
import SLICE_UPLOAD.FileControlReq;
import SLICE_UPLOAD.FileControlRsp;
import SLICE_UPLOAD.UploadModel;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.common.Const.UploadRetCode;
import com.tencent.upload.e.e;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.TaskTypeConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MoodUploadTask
  extends AbstractUploadTask
{
  private static final String TAG = "MoodUploadTask";
  public byte[] businessData = null;
  public int iAlbumTypeID = 0;
  public long iBatchID = 0L;
  public List<PictureInfo> pictureInfoList = null;
  public String sAlbumID = "";
  
  public MoodUploadTask()
  {
    super(new byte[0]);
    this.mAppid = "commit_shuoshuo";
  }
  
  private static Map<String, String> clearInValidValue(Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return paramMap;
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() == null) {
          paramMap.put(localEntry.getKey(), "");
        }
      }
    }
  }
  
  private ShuoshuoInfoReq createReq()
  {
    ShuoshuoInfoReq localShuoshuoInfoReq = new ShuoshuoInfoReq();
    localShuoshuoInfoReq.iAlbumTypeID = this.iAlbumTypeID;
    localShuoshuoInfoReq.iBatchID = this.iBatchID;
    localShuoshuoInfoReq.sAlbumID = this.sAlbumID;
    localShuoshuoInfoReq.pic_list = new ArrayList();
    if (this.pictureInfoList != null)
    {
      Iterator localIterator = this.pictureInfoList.iterator();
      while (localIterator.hasNext())
      {
        PictureInfo localPictureInfo = (PictureInfo)localIterator.next();
        localShuoshuoInfoReq.pic_list.add(toShuoshuoPicInfo(localPictureInfo));
      }
    }
    localShuoshuoInfoReq.busiData = this.businessData;
    if (localShuoshuoInfoReq.busiData == null) {
      localShuoshuoInfoReq.busiData = new byte[0];
    }
    return localShuoshuoInfoReq;
  }
  
  private static final ShuoshuoPicInfo toShuoshuoPicInfo(PictureInfo paramPictureInfo)
  {
    ShuoshuoPicInfo localShuoshuoPicInfo = new ShuoshuoPicInfo();
    localShuoshuoPicInfo.albumid = paramPictureInfo.albumid;
    localShuoshuoPicInfo.pictureid = paramPictureInfo.pictureid;
    localShuoshuoPicInfo.sloc = paramPictureInfo.sloc;
    localShuoshuoPicInfo.pictype = paramPictureInfo.pictype;
    if (paramPictureInfo.pictype == 2) {
      localShuoshuoPicInfo.sourceType = 2;
    }
    localShuoshuoPicInfo.picheight = paramPictureInfo.picheight;
    localShuoshuoPicInfo.picwidth = paramPictureInfo.picwidth;
    localShuoshuoPicInfo.ishd = paramPictureInfo.ishd;
    localShuoshuoPicInfo.hdid = paramPictureInfo.hdid;
    localShuoshuoPicInfo.hdheight = paramPictureInfo.hdheight;
    localShuoshuoPicInfo.hdwidth = paramPictureInfo.hdwidth;
    localShuoshuoPicInfo.strWaterMarkID = paramPictureInfo.strWaterMarkID;
    localShuoshuoPicInfo.strWaterMarkMemo = paramPictureInfo.strWaterMarkMemo;
    localShuoshuoPicInfo.mapWaterMarkParams = clearInValidValue(paramPictureInfo.mapWaterMarkParams);
    localShuoshuoPicInfo.pic_url = paramPictureInfo.picUrl;
    localShuoshuoPicInfo.is_appext_pic = paramPictureInfo.isAppExtPic;
    localShuoshuoPicInfo.richval = paramPictureInfo.richval;
    return localShuoshuoPicInfo;
  }
  
  public byte[] buildExtra()
  {
    Object localObject1 = null;
    Object localObject2 = createReq();
    String str = localObject2.getClass().getSimpleName();
    try
    {
      localObject2 = e.a(str, localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.upload.common.b.e("MoodUploadTask", localException.toString());
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = super.buildExtra();
      com.tencent.upload.common.b.e("MoodUploadTask", "package ShuoshuoInfoReq error!!!");
    }
    return localObject2;
  }
  
  protected com.tencent.upload.c.b getControlRequest()
  {
    Object localObject1 = this.vLoginData;
    Object localObject2 = new AuthToken(2, (byte[])localObject1, this.vLoginKey, com.tencent.upload.common.a.b().getAppId());
    StringBuilder localStringBuilder = new StringBuilder().append(" vLoginData.size:");
    if (localObject1 == null) {}
    for (localObject1 = "null";; localObject1 = Integer.valueOf(localObject1.length))
    {
      com.tencent.upload.common.b.c("MoodUploadTask", localObject1 + " vLoginKey.size:" + this.vLoginKey.length);
      this.mCheckType = CheckType.TYPE_SHA1;
      this.mChecksum = "";
      buildEnv();
      this.mModel = UploadModel.MODEL_NORMAL;
      this.mStEnv = com.tencent.upload.common.a.g();
      localObject1 = new com.tencent.upload.c.a.c(this.iUin + "", this.mAppid, (AuthToken)localObject2, this.mChecksum, this.mCheckType, this.mDataLength, this.mStEnv, this.mModel, this.mSessionId, this.mNeedIpRedirect, true, this.iSync);
      ((com.tencent.upload.c.a.c)localObject1).a(buildExtra());
      localObject2 = new HashMap();
      ((Map)localObject2).put("1", (FileControlReq)((com.tencent.upload.c.a.c)localObject1).h());
      return new com.tencent.upload.c.a.b((Map)localObject2);
    }
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.ImageUploadTaskType;
  }
  
  protected void onFileControlResponse(JceStruct paramJceStruct, com.tencent.upload.c.c paramc)
  {
    processUploadMoodRsp(((FileControlRsp)((FileBatchControlRsp)paramJceStruct).control_rsp.get("1")).biz_rsp);
  }
  
  public boolean onRun()
  {
    com.tencent.upload.c.b localb = getControlRequest();
    this.mSession = this.mSessionPool.c();
    if (this.mSession == null)
    {
      com.tencent.upload.common.b.e("MoodUploadTask", "MoodUploadTask onRun(), get session return null !");
      retryPollSession();
      return false;
    }
    return this.mSession.a(localb, this);
  }
  
  public boolean onVerifyUploadFile()
  {
    return true;
  }
  
  protected void processUploadMoodRsp(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), "vRspData invalid");
      com.tencent.upload.common.b.e("MoodUploadTask", "vRspData == null");
      return;
    }
    try
    {
      paramArrayOfByte = (ShuoshuoInfoRsp)e.a(ShuoshuoInfoRsp.class.getSimpleName(), paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), "processMoodRsp() unpack ShuoshuoInfoRsp == null !");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        com.tencent.upload.common.b.e("MoodUploadTask", paramArrayOfByte.toString());
        paramArrayOfByte = null;
      }
      com.tencent.upload.common.b.b("MoodUploadTask", "onUploadSucceed flowid = " + this.flowId);
      onUploadSucceed(new MoodUploadResult(paramArrayOfByte.vBusiNessDataRsp));
      setTaskStatus(com.tencent.upload.d.c.g);
      onTaskFinished(Const.UploadRetCode.SUCCEED.getCode(), Const.UploadRetCode.SUCCEED.getDesc());
    }
  }
  
  public static final class PictureInfo
  {
    public String albumid;
    public int hdheight;
    public String hdid;
    public int hdwidth;
    public int isAppExtPic;
    public boolean ishd;
    public Map<String, String> mapWaterMarkParams;
    public String picUrl;
    public int picheight;
    public String pictureid;
    public int pictype;
    public int picwidth;
    public String richval;
    public String sloc;
    public String strWaterMarkID;
    public String strWaterMarkMemo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.MoodUploadTask
 * JD-Core Version:    0.7.0.1
 */