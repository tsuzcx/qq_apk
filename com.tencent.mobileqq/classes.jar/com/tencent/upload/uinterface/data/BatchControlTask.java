package com.tencent.upload.uinterface.data;

import SLICE_UPLOAD.AuthToken;
import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.FileBatchControlRsp;
import SLICE_UPLOAD.FileControlReq;
import SLICE_UPLOAD.FileControlRsp;
import SLICE_UPLOAD.UploadModel;
import SLICE_UPLOAD.stResult;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.b.g;
import com.tencent.upload.common.Const.UploadRetCode;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.TaskTypeConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BatchControlTask
  extends AbstractUploadTask
{
  private static final String TAG = "BatchControlTask";
  long mEndTime;
  private List<String> mFilePaths;
  private BatchControlResult mResult;
  long mStartTime;
  g mTaskManager;
  List<AbstractUploadTask> mTasks;
  
  public BatchControlTask(String paramString)
  {
    super(paramString);
    this.mFilePaths = new ArrayList();
  }
  
  public BatchControlTask(List<AbstractUploadTask> paramList, g paramg)
  {
    super(new byte[0]);
    this.flowId = this.mTaskId;
    this.mTaskManager = paramg;
    this.mFilePaths = new ArrayList();
    this.mTasks = new ArrayList(paramList);
    paramList = (AbstractUploadTask)this.mTasks.get(0);
    this.uploadEntrance = paramList.uploadEntrance;
    this.sRefer = paramList.sRefer;
    this.iUin = paramList.iUin;
    this.mAppid = paramList.getProtocalAppid();
    this.b2Gt = paramList.b2Gt;
    this.vLoginData = paramList.vLoginData;
    this.vLoginKey = paramList.vLoginKey;
    this.preupload = paramList.preupload;
    paramList = this.mTasks.iterator();
    while (paramList.hasNext()) {
      addBatchFile(((AbstractUploadTask)paramList.next()).getFilePath());
    }
  }
  
  public void addBatchFile(String paramString)
  {
    this.mFilePaths.add(paramString);
  }
  
  protected com.tencent.upload.c.b getBatchControlRequest()
  {
    com.tencent.upload.common.b.c("BatchControlTask", "taskId:" + getTaskId() + " ! ---------------getBatchControlRequest-------------- !");
    Object localObject1 = this.vLoginData;
    AuthToken localAuthToken = new AuthToken(2, (byte[])localObject1, this.vLoginKey, com.tencent.upload.common.a.b().getAppId());
    Object localObject2 = new StringBuilder().append(" vLoginData.size:");
    int i;
    label150:
    Object localObject3;
    Object localObject4;
    if (localObject1 == null)
    {
      localObject1 = "null";
      com.tencent.upload.common.b.c("BatchControlTask", localObject1 + " vLoginKey.size:" + this.vLoginKey.length);
      buildEnv();
      this.mModel = UploadModel.MODEL_NORMAL;
      if (this.preupload == 1) {
        this.mModel = UploadModel.MODEL_PRE_UPLOAD;
      }
      localObject1 = new HashMap();
      i = 0;
      if (i >= this.mTasks.size()) {
        break label569;
      }
      localObject2 = (AbstractUploadTask)this.mTasks.get(i);
      localObject3 = ((AbstractUploadTask)localObject2).getFilePath();
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        if (!this.mAppid.equalsIgnoreCase("video_qzone")) {
          break label283;
        }
        this.mCheckType = CheckType.TYPE_SHA1;
        localObject4 = FileUtils.getFileSha1(new File((String)localObject3));
        this.sha1 = ((String)localObject4);
        this.mChecksum = ((String)localObject4);
      }
      label238:
      if (!TextUtils.isEmpty(this.mChecksum)) {
        break label319;
      }
      ((AbstractUploadTask)localObject2).onError(Const.UploadRetCode.FILE_NOT_EXIST.getCode(), Const.UploadRetCode.FILE_NOT_EXIST.getDesc());
    }
    for (;;)
    {
      i += 1;
      break label150;
      localObject1 = Integer.valueOf(localObject1.length);
      break;
      label283:
      this.mCheckType = CheckType.TYPE_MD5;
      localObject4 = FileUtils.getMd5ByFile_REAL(new File((String)localObject3));
      this.md5 = ((String)localObject4);
      this.mChecksum = ((String)localObject4);
      break label238;
      label319:
      com.tencent.upload.common.b.b("BatchControlTask", "batchControlId:" + getTaskId() + ", index: " + i + ", taskId:" + ((AbstractUploadTask)localObject2).getTaskId() + ", path:" + (String)localObject3 + ", mCheckType:" + this.mCheckType + ", mChecksum:" + this.mChecksum);
      long l = FileUtils.getFileLength((String)localObject3);
      localObject3 = new com.tencent.upload.c.a.c(this.iUin + "", this.mAppid, localAuthToken, this.mChecksum, this.mCheckType, l, this.mStEnv, this.mModel, "", this.mNeedIpRedirect, true, ((AbstractUploadTask)localObject2).iSync);
      localObject4 = ((AbstractUploadTask)localObject2).buildExtra();
      if (localObject4 == null)
      {
        ((AbstractUploadTask)localObject2).onError(Const.UploadRetCode.DATA_ENCODE_EXCEPTION.getCode(), Const.UploadRetCode.DATA_ENCODE_EXCEPTION.getDesc());
      }
      else
      {
        ((com.tencent.upload.c.a.c)localObject3).a((byte[])localObject4);
        localObject2 = (FileControlReq)((com.tencent.upload.c.a.c)localObject3).h();
        ((Map)localObject1).put(i + 1 + "", localObject2);
      }
    }
    label569:
    if (((Map)localObject1).size() == 0)
    {
      setTaskStatus(com.tencent.upload.d.c.e);
      onTaskFinished(0, "Damn shit, no file need to upload !");
      com.tencent.upload.common.b.b("BatchControlTask", "Damn shit, no file need to upload !");
      return null;
    }
    return new com.tencent.upload.c.a.b((Map)localObject1);
  }
  
  public int getBatchCount()
  {
    return this.mTasks.size();
  }
  
  public long getCostTime()
  {
    return this.mEndTime - this.mStartTime;
  }
  
  public BatchControlResult getResult()
  {
    return this.mResult;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.ImageUploadTaskType;
  }
  
  protected void onFileControlResponse(JceStruct paramJceStruct, com.tencent.upload.c.c paramc)
  {
    paramc = (FileBatchControlRsp)paramJceStruct;
    this.mEndTime = System.currentTimeMillis();
    com.tencent.upload.common.b.b("BatchControlTask", "[speed] batch control pkg cost: " + getCostTime());
    if ((paramc == null) || (paramc.control_rsp == null) || (paramc.control_rsp.size() <= 0)) {
      return;
    }
    paramJceStruct = new BatchControlResult();
    int i = 1;
    Object localObject;
    while (i <= paramc.control_rsp.size())
    {
      localObject = (FileControlRsp)paramc.control_rsp.get(i + "");
      paramJceStruct.mMap.put(this.mFilePaths.get(i - 1), localObject);
      i += 1;
    }
    this.mResult = paramJceStruct;
    com.tencent.upload.common.b.b("BatchControlTask", "Num:" + paramJceStruct.mMap.size());
    long l = getCostTime();
    if (!this.mTasks.isEmpty()) {
      l /= this.mTasks.size();
    }
    for (;;)
    {
      paramc = this.mTasks.iterator();
      while (paramc.hasNext())
      {
        localObject = (AbstractUploadTask)paramc.next();
        FileControlRsp localFileControlRsp = (FileControlRsp)paramJceStruct.mMap.get(((AbstractUploadTask)localObject).getFilePath());
        if ((localFileControlRsp != null) && (localFileControlRsp.result != null))
        {
          com.tencent.upload.common.b.b("BatchControlTask", "flowid:" + ((AbstractUploadTask)localObject).flowId + " FileControlRsp rsp ret:" + localFileControlRsp.result.ret + " flag:" + localFileControlRsp.result.flag);
          if (localFileControlRsp.result.ret == 0)
          {
            if (localFileControlRsp.result.flag != 1) {
              break label433;
            }
            ((AbstractUploadTask)localObject).setSecondUpload(localFileControlRsp);
          }
        }
        label433:
        while (localFileControlRsp.result.flag != 2)
        {
          ((AbstractUploadTask)localObject).setSessionId(localFileControlRsp.session);
          ((AbstractUploadTask)localObject).setSliceSize((int)localFileControlRsp.slice_size);
          if (((AbstractUploadTask)localObject).getTaskState() != com.tencent.upload.d.c.e) {
            this.mTaskManager.a((AbstractUploadTask)localObject);
          }
          ((AbstractUploadTask)localObject).getReportObj().batchCtrlCostAvg = l;
          break;
        }
      }
      setTaskStatus(com.tencent.upload.d.c.g);
      onTaskFinished(Const.UploadRetCode.SUCCEED.getCode(), Const.UploadRetCode.SUCCEED.getDesc());
      return;
    }
  }
  
  public boolean onRun()
  {
    this.mFinish = false;
    com.tencent.upload.c.b localb = getBatchControlRequest();
    if (localb == null) {
      return false;
    }
    setState(com.tencent.upload.d.c.b);
    com.tencent.upload.network.a.a locala = this.mSessionPool.c();
    this.mSavedSession = locala;
    this.mSession = locala;
    if (this.mFinish)
    {
      com.tencent.upload.common.b.e("BatchControlTask", "BatchControlTask onRun(), task is finished already !");
      return false;
    }
    if (this.mSession == null)
    {
      com.tencent.upload.common.b.e("BatchControlTask", "BatchControlTask onRun(), get session return null !");
      retryPollSession();
      return false;
    }
    this.mStartTime = System.currentTimeMillis();
    this.mFlagError = false;
    return this.mSession.a(localb, this);
  }
  
  protected void onUploadError(int paramInt, String paramString)
  {
    if ((this.mTasks != null) && (this.mTasks.size() > 0))
    {
      Iterator localIterator = this.mTasks.iterator();
      while (localIterator.hasNext()) {
        ((AbstractUploadTask)localIterator.next()).onError(paramInt, paramString);
      }
    }
  }
  
  public boolean onVerifyUploadFile()
  {
    return true;
  }
  
  protected void report(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.BatchControlTask
 * JD-Core Version:    0.7.0.1
 */