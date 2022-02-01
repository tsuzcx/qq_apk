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
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.network.session.SessionPool;
import com.tencent.upload.request.UploadRequest;
import com.tencent.upload.request.UploadResponse;
import com.tencent.upload.request.impl.BatchControlRequest;
import com.tencent.upload.request.impl.FileControlRequest;
import com.tencent.upload.task.TaskState;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.token.TokenProvider;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.ProtocolUtil;
import com.tencent.upload.utils.UploadLog;
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
  public List<MoodUploadTask.PictureInfo> pictureInfoList = null;
  public String sAlbumID = "";
  
  public MoodUploadTask()
  {
    super(new byte[0]);
    this.mAppid = "commit_shuoshuo";
  }
  
  private static Map<String, String> clearInValidValue(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return paramMap;
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() == null) {
        paramMap.put(localEntry.getKey(), "");
      }
    }
    return paramMap;
  }
  
  private ShuoshuoInfoReq createReq()
  {
    ShuoshuoInfoReq localShuoshuoInfoReq = new ShuoshuoInfoReq();
    localShuoshuoInfoReq.iAlbumTypeID = this.iAlbumTypeID;
    localShuoshuoInfoReq.iBatchID = this.iBatchID;
    localShuoshuoInfoReq.sAlbumID = this.sAlbumID;
    localShuoshuoInfoReq.pic_list = new ArrayList();
    Object localObject = this.pictureInfoList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MoodUploadTask.PictureInfo localPictureInfo = (MoodUploadTask.PictureInfo)((Iterator)localObject).next();
        localShuoshuoInfoReq.pic_list.add(toShuoshuoPicInfo(localPictureInfo));
      }
    }
    localShuoshuoInfoReq.busiData = this.businessData;
    if (localShuoshuoInfoReq.busiData == null) {
      localShuoshuoInfoReq.busiData = new byte[0];
    }
    return localShuoshuoInfoReq;
  }
  
  private static final ShuoshuoPicInfo toShuoshuoPicInfo(MoodUploadTask.PictureInfo paramPictureInfo)
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
    Object localObject1 = createReq();
    Object localObject3 = localObject1.getClass().getSimpleName();
    Object localObject2;
    try
    {
      localObject1 = ProtocolUtil.pack((String)localObject3, localObject1);
    }
    catch (Exception localException)
    {
      UploadLog.e("MoodUploadTask", localException.toString());
      localObject2 = null;
    }
    localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = super.buildExtra();
      UploadLog.e("MoodUploadTask", "package ShuoshuoInfoReq error!!!");
    }
    return localObject3;
  }
  
  protected UploadRequest getControlRequest()
  {
    Object localObject1 = TokenProvider.getAuthToken(this.vLoginData, this.vLoginKey);
    this.mCheckType = CheckType.TYPE_SHA1;
    this.mChecksum = "";
    buildEnv();
    this.mModel = UploadModel.MODEL_NORMAL;
    this.mStEnv = UploadGlobalConfig.getEnv();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.iUin);
    ((StringBuilder)localObject2).append("");
    localObject1 = new FileControlRequest(((StringBuilder)localObject2).toString(), this.mAppid, (AuthToken)localObject1, this.mChecksum, this.mCheckType, this.mDataLength, this.mStEnv, this.mModel, this.mSessionId, this.mNeedIpRedirect, true, this.iSync, null, this.mExtend_info);
    ((FileControlRequest)localObject1).setExtraParam(buildExtra());
    localObject2 = new HashMap();
    ((Map)localObject2).put("1", (FileControlReq)((FileControlRequest)localObject1).createJceRequest());
    return new BatchControlRequest((Map)localObject2);
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.ImageUploadTaskType;
  }
  
  protected void onFileControlResponse(JceStruct paramJceStruct, UploadResponse paramUploadResponse)
  {
    processUploadMoodRsp(((FileControlRsp)((FileBatchControlRsp)paramJceStruct).control_rsp.get("1")).biz_rsp);
  }
  
  public boolean onRun()
  {
    UploadRequest localUploadRequest = getControlRequest();
    IUploadSession localIUploadSession = this.mSessionPool.poll();
    if (localIUploadSession == null)
    {
      UploadLog.e("MoodUploadTask", "MoodUploadTask onRun(), get session return null !");
      retryPollSession();
      return false;
    }
    this.mSavedSession = localIUploadSession;
    this.mSession = localIUploadSession;
    return this.mSession.send(localUploadRequest, this);
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
      UploadLog.e("MoodUploadTask", "vRspData == null");
      return;
    }
    try
    {
      paramArrayOfByte = (ShuoshuoInfoRsp)ProtocolUtil.unpack(ShuoshuoInfoRsp.class.getSimpleName(), paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      UploadLog.e("MoodUploadTask", paramArrayOfByte.toString());
      paramArrayOfByte = null;
    }
    if (paramArrayOfByte == null)
    {
      int i = Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("(");
      paramArrayOfByte.append(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode());
      paramArrayOfByte.append(")");
      paramArrayOfByte.append(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getDesc());
      onError(i, paramArrayOfByte.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUploadSucceed flowid = ");
    localStringBuilder.append(this.flowId);
    UploadLog.d("MoodUploadTask", localStringBuilder.toString());
    onUploadSucceed(new MoodUploadResult(paramArrayOfByte.vBusiNessDataRsp));
    setTaskStatus(TaskState.SUCCEED);
    onTaskFinished(Const.UploadRetCode.SUCCEED.getCode(), Const.UploadRetCode.SUCCEED.getDesc());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.MoodUploadTask
 * JD-Core Version:    0.7.0.1
 */