package com.tencent.upload.uinterface.data;

import SLICE_UPLOAD.AuthToken;
import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.DumpBussinessReq;
import SLICE_UPLOAD.FileBatchControlRsp;
import SLICE_UPLOAD.FileControlReq;
import SLICE_UPLOAD.FileControlRsp;
import SLICE_UPLOAD.UploadModel;
import SLICE_UPLOAD.stResult;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.impl.UploadTaskManager;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.network.session.SessionPool;
import com.tencent.upload.request.IActionRequest;
import com.tencent.upload.request.UploadRequest;
import com.tencent.upload.request.UploadResponse;
import com.tencent.upload.request.impl.BatchControlRequest;
import com.tencent.upload.request.impl.FileControlRequest;
import com.tencent.upload.task.TaskState;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.token.TokenProvider;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
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
  UploadTaskManager mTaskManager;
  List<AbstractUploadTask> mTasks;
  
  public BatchControlTask(String paramString)
  {
    super(paramString);
    this.mFilePaths = new ArrayList();
  }
  
  public BatchControlTask(List<AbstractUploadTask> paramList, UploadTaskManager paramUploadTaskManager)
  {
    super(new byte[0]);
    this.flowId = this.mTaskId;
    this.mTaskManager = paramUploadTaskManager;
    this.mFilePaths = new ArrayList();
    this.mTasks = new ArrayList(paramList);
    paramList = (AbstractUploadTask)this.mTasks.get(0);
    this.uploadEntrance = paramList.uploadEntrance;
    this.sRefer = paramList.sRefer;
    this.iUin = paramList.iUin;
    this.mAppid = paramList.getProtocolAppid();
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
  
  protected UploadRequest getBatchControlRequest()
  {
    Object localObject2 = this;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("taskId:");
    ((StringBuilder)localObject1).append(getTaskId());
    ((StringBuilder)localObject1).append(" ! ---------------getBatchControlRequest-------------- !");
    localObject1 = ((StringBuilder)localObject1).toString();
    String str = "BatchControlTask";
    UploadLog.i("BatchControlTask", (String)localObject1);
    localObject1 = TokenProvider.getAuthToken(((BatchControlTask)localObject2).vLoginData, ((BatchControlTask)localObject2).vLoginKey);
    buildEnv();
    ((BatchControlTask)localObject2).mModel = UploadModel.MODEL_NORMAL;
    if (((BatchControlTask)localObject2).preupload == 1) {
      ((BatchControlTask)localObject2).mModel = UploadModel.MODEL_PRE_UPLOAD;
    }
    localObject2 = new HashMap();
    int i = 0;
    for (;;)
    {
      Object localObject4 = this;
      if (i >= ((BatchControlTask)localObject4).mTasks.size()) {
        break;
      }
      AbstractUploadTask localAbstractUploadTask = (AbstractUploadTask)((BatchControlTask)localObject4).mTasks.get(i);
      Object localObject3 = localAbstractUploadTask.getFilePath();
      Object localObject5;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        if (((BatchControlTask)localObject4).mAppid.equalsIgnoreCase("video_qzone"))
        {
          ((BatchControlTask)localObject4).mCheckType = CheckType.TYPE_SHA1;
          localObject5 = FileUtils.getFileSha1(new File((String)localObject3));
          ((BatchControlTask)localObject4).sha1 = ((String)localObject5);
          ((BatchControlTask)localObject4).mChecksum = ((String)localObject5);
        }
        else
        {
          ((BatchControlTask)localObject4).mCheckType = CheckType.TYPE_MD5;
          localObject5 = FileUtils.getMd5ByFile_REAL(new File((String)localObject3));
          ((BatchControlTask)localObject4).md5 = ((String)localObject5);
          ((BatchControlTask)localObject4).mChecksum = ((String)localObject5);
        }
      }
      if (TextUtils.isEmpty(((BatchControlTask)localObject4).mChecksum))
      {
        localAbstractUploadTask.onError(Const.UploadRetCode.FILE_NOT_EXIST.getCode(), Const.UploadRetCode.FILE_NOT_EXIST.getDesc());
      }
      else
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("batchControlId:");
        ((StringBuilder)localObject5).append(getTaskId());
        ((StringBuilder)localObject5).append(", index: ");
        ((StringBuilder)localObject5).append(i);
        ((StringBuilder)localObject5).append(", taskId:");
        ((StringBuilder)localObject5).append(localAbstractUploadTask.getTaskId());
        ((StringBuilder)localObject5).append(", path:");
        ((StringBuilder)localObject5).append((String)localObject3);
        ((StringBuilder)localObject5).append(", mCheckType:");
        ((StringBuilder)localObject5).append(((BatchControlTask)localObject4).mCheckType);
        ((StringBuilder)localObject5).append(", mChecksum:");
        ((StringBuilder)localObject5).append(((BatchControlTask)localObject4).mChecksum);
        UploadLog.d(str, ((StringBuilder)localObject5).toString());
        long l = FileUtils.getFileLength((String)localObject3);
        if (localAbstractUploadTask.isSyncWeishi)
        {
          localObject3 = new HashMap();
          localObject5 = new DumpBussinessReq();
          ((DumpBussinessReq)localObject5).IMEI = localAbstractUploadTask.sDevIMEI;
          ((Map)localObject3).put(Integer.valueOf(1), localObject5);
        }
        else
        {
          localObject3 = null;
        }
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(((BatchControlTask)localObject4).iUin);
        ((StringBuilder)localObject5).append("");
        localObject3 = new FileControlRequest(((StringBuilder)localObject5).toString(), ((BatchControlTask)localObject4).mAppid, (AuthToken)localObject1, ((BatchControlTask)localObject4).mChecksum, ((BatchControlTask)localObject4).mCheckType, l, ((BatchControlTask)localObject4).mStEnv, ((BatchControlTask)localObject4).mModel, "", ((BatchControlTask)localObject4).mNeedIpRedirect, true, localAbstractUploadTask.iSync, (Map)localObject3, localAbstractUploadTask.mExtend_info);
        localObject4 = localAbstractUploadTask.buildExtra();
        if (localObject4 == null)
        {
          localAbstractUploadTask.onError(Const.UploadRetCode.DATA_ENCODE_EXCEPTION.getCode(), Const.UploadRetCode.DATA_ENCODE_EXCEPTION.getDesc());
        }
        else
        {
          ((FileControlRequest)localObject3).setExtraParam((byte[])localObject4);
          localObject3 = (FileControlReq)((FileControlRequest)localObject3).createJceRequest();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(i + 1);
          ((StringBuilder)localObject4).append("");
          ((Map)localObject2).put(((StringBuilder)localObject4).toString(), localObject3);
        }
      }
      i += 1;
    }
    if (((Map)localObject2).size() == 0)
    {
      setTaskStatus(TaskState.CANCEL);
      onTaskFinished(0, "Damn shit, no file need to upload !");
      UploadLog.d(str, "Damn shit, no file need to upload !");
      return null;
    }
    return new BatchControlRequest((Map)localObject2);
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
  
  protected void onFileControlResponse(JceStruct paramJceStruct, UploadResponse paramUploadResponse)
  {
    paramUploadResponse = (FileBatchControlRsp)paramJceStruct;
    this.mEndTime = System.currentTimeMillis();
    paramJceStruct = new StringBuilder();
    paramJceStruct.append("[speed] batch control pkg cost: ");
    paramJceStruct.append(getCostTime());
    UploadLog.d("BatchControlTask", paramJceStruct.toString());
    if ((paramUploadResponse != null) && (paramUploadResponse.control_rsp != null))
    {
      if (paramUploadResponse.control_rsp.size() <= 0) {
        return;
      }
      paramJceStruct = new BatchControlResult();
      int i = 1;
      Object localObject1;
      Object localObject2;
      while (i <= paramUploadResponse.control_rsp.size())
      {
        localObject1 = paramUploadResponse.control_rsp;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("");
        localObject1 = (FileControlRsp)((Map)localObject1).get(((StringBuilder)localObject2).toString());
        paramJceStruct.mMap.put(this.mFilePaths.get(i - 1), localObject1);
        i += 1;
      }
      this.mResult = paramJceStruct;
      paramUploadResponse = new StringBuilder();
      paramUploadResponse.append("Num:");
      paramUploadResponse.append(paramJceStruct.mMap.size());
      UploadLog.d("BatchControlTask", paramUploadResponse.toString());
      long l2 = getCostTime();
      long l1 = l2;
      if (!this.mTasks.isEmpty()) {
        l1 = l2 / this.mTasks.size();
      }
      paramUploadResponse = this.mTasks.iterator();
      while (paramUploadResponse.hasNext())
      {
        localObject1 = (AbstractUploadTask)paramUploadResponse.next();
        localObject2 = (FileControlRsp)paramJceStruct.mMap.get(((AbstractUploadTask)localObject1).getFilePath());
        if ((localObject2 != null) && (((FileControlRsp)localObject2).result != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("flowid:");
          localStringBuilder.append(((AbstractUploadTask)localObject1).flowId);
          localStringBuilder.append(" FileControlRsp rsp ret:");
          localStringBuilder.append(((FileControlRsp)localObject2).result.ret);
          localStringBuilder.append(" flag:");
          localStringBuilder.append(((FileControlRsp)localObject2).result.flag);
          localStringBuilder.append(" rsp.session:");
          localStringBuilder.append(((FileControlRsp)localObject2).session);
          localStringBuilder.append(" path:");
          localStringBuilder.append(((AbstractUploadTask)localObject1).getFilePath());
          UploadLog.d("BatchControlTask", localStringBuilder.toString());
          if (((FileControlRsp)localObject2).result.ret == 0)
          {
            if (((FileControlRsp)localObject2).result.flag == 1) {
              ((AbstractUploadTask)localObject1).setSecondUpload((FileControlRsp)localObject2);
            } else {
              if (((FileControlRsp)localObject2).result.flag == 2) {
                continue;
              }
            }
            ((AbstractUploadTask)localObject1).setSessionId(((FileControlRsp)localObject2).session);
            ((AbstractUploadTask)localObject1).setSliceSize((int)((FileControlRsp)localObject2).slice_size);
          }
          if (((AbstractUploadTask)localObject1).getTaskState() != TaskState.CANCEL) {
            this.mTaskManager.sendAsync((AbstractUploadTask)localObject1);
          }
        }
        ((AbstractUploadTask)localObject1).getReportObj().batchCtrlCostAvg = l1;
      }
      setTaskStatus(TaskState.SUCCEED);
      onTaskFinished(Const.UploadRetCode.SUCCEED.getCode(), Const.UploadRetCode.SUCCEED.getDesc());
    }
  }
  
  public boolean onRun()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("BatchControlTask onRun() is start !! taskId:");
    ((StringBuilder)localObject).append(getTaskId());
    UploadLog.d("BatchControlTask", ((StringBuilder)localObject).toString());
    this.mFinish = false;
    localObject = getBatchControlRequest();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onRun(), req == null !! taskId:");
      ((StringBuilder)localObject).append(getTaskId());
      UploadLog.e("BatchControlTask", ((StringBuilder)localObject).toString());
      return false;
    }
    if (this.mFinish)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("BatchControlTask onRun(), task is finished already ! taskId:");
      ((StringBuilder)localObject).append(getTaskId());
      UploadLog.e("BatchControlTask", ((StringBuilder)localObject).toString());
      return false;
    }
    IUploadSession localIUploadSession = this.mSessionPool.poll();
    if (localIUploadSession == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("BatchControlTask onRun(), get session return null ! taskId:");
      ((StringBuilder)localObject).append(getTaskId());
      UploadLog.e("BatchControlTask", ((StringBuilder)localObject).toString());
      retryPollSession();
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BatchControlTask onRun() session is not null. ready to send taskId:");
    localStringBuilder.append(getTaskId());
    UploadLog.d("BatchControlTask", localStringBuilder.toString());
    setState(TaskState.CONNECTING);
    this.mSavedSession = localIUploadSession;
    this.mSession = localIUploadSession;
    this.mStartTime = System.currentTimeMillis();
    this.mFlagError = false;
    return this.mSession.send((IActionRequest)localObject, this);
  }
  
  protected void onUploadError(int paramInt, String paramString)
  {
    Object localObject = this.mTasks;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.mTasks.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbstractUploadTask)((Iterator)localObject).next()).onError(paramInt, paramString);
      }
    }
  }
  
  public boolean onVerifyUploadFile()
  {
    return true;
  }
  
  public String printAllTaskInBatchControl()
  {
    Object localObject = this.mTasks;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = new StringBuilder();
      int i = 0;
      while (i < this.mTasks.size())
      {
        AbstractUploadTask localAbstractUploadTask = (AbstractUploadTask)this.mTasks.get(i);
        ((StringBuilder)localObject).append("index:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" taskId:");
        ((StringBuilder)localObject).append(localAbstractUploadTask.getTaskId());
        ((StringBuilder)localObject).append("\n");
        i += 1;
      }
      return ((StringBuilder)localObject).toString();
    }
    return "no task in batchControlTask";
  }
  
  protected void report(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.BatchControlTask
 * JD-Core Version:    0.7.0.1
 */