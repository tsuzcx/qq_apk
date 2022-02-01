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
    UploadLog.i("BatchControlTask", "taskId:" + getTaskId() + " ! ---------------getBatchControlRequest-------------- !");
    AuthToken localAuthToken = TokenProvider.getAuthToken(this.vLoginData, this.vLoginKey);
    buildEnv();
    this.mModel = UploadModel.MODEL_NORMAL;
    if (this.preupload == 1) {
      this.mModel = UploadModel.MODEL_PRE_UPLOAD;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < this.mTasks.size())
    {
      AbstractUploadTask localAbstractUploadTask = (AbstractUploadTask)this.mTasks.get(i);
      Object localObject1 = localAbstractUploadTask.getFilePath();
      Object localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (this.mAppid.equalsIgnoreCase("video_qzone"))
        {
          this.mCheckType = CheckType.TYPE_SHA1;
          localObject2 = FileUtils.getFileSha1(new File((String)localObject1));
          this.sha1 = ((String)localObject2);
          this.mChecksum = ((String)localObject2);
        }
      }
      else
      {
        label170:
        if (!TextUtils.isEmpty(this.mChecksum)) {
          break label240;
        }
        localAbstractUploadTask.onError(Const.UploadRetCode.FILE_NOT_EXIST.getCode(), Const.UploadRetCode.FILE_NOT_EXIST.getDesc());
      }
      for (;;)
      {
        i += 1;
        break;
        this.mCheckType = CheckType.TYPE_MD5;
        localObject2 = FileUtils.getMd5ByFile_REAL(new File((String)localObject1));
        this.md5 = ((String)localObject2);
        this.mChecksum = ((String)localObject2);
        break label170;
        label240:
        UploadLog.d("BatchControlTask", "batchControlId:" + getTaskId() + ", index: " + i + ", taskId:" + localAbstractUploadTask.getTaskId() + ", path:" + (String)localObject1 + ", mCheckType:" + this.mCheckType + ", mChecksum:" + this.mChecksum);
        long l = FileUtils.getFileLength((String)localObject1);
        localObject1 = null;
        if (localAbstractUploadTask.isSyncWeishi)
        {
          localObject1 = new HashMap();
          localObject2 = new DumpBussinessReq();
          ((DumpBussinessReq)localObject2).IMEI = localAbstractUploadTask.sDevIMEI;
          ((Map)localObject1).put(Integer.valueOf(1), localObject2);
        }
        localObject1 = new FileControlRequest(this.iUin + "", this.mAppid, localAuthToken, this.mChecksum, this.mCheckType, l, this.mStEnv, this.mModel, "", this.mNeedIpRedirect, true, localAbstractUploadTask.iSync, (Map)localObject1, localAbstractUploadTask.mExtend_info);
        localObject2 = localAbstractUploadTask.buildExtra();
        if (localObject2 == null)
        {
          localAbstractUploadTask.onError(Const.UploadRetCode.DATA_ENCODE_EXCEPTION.getCode(), Const.UploadRetCode.DATA_ENCODE_EXCEPTION.getDesc());
        }
        else
        {
          ((FileControlRequest)localObject1).setExtraParam((byte[])localObject2);
          localObject1 = (FileControlReq)((FileControlRequest)localObject1).createJceRequest();
          localHashMap.put(i + 1 + "", localObject1);
        }
      }
    }
    if (localHashMap.size() == 0)
    {
      setTaskStatus(TaskState.CANCEL);
      onTaskFinished(0, "Damn shit, no file need to upload !");
      UploadLog.d("BatchControlTask", "Damn shit, no file need to upload !");
      return null;
    }
    return new BatchControlRequest(localHashMap);
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
  
  public void onFileControlResponse(JceStruct paramJceStruct, UploadResponse paramUploadResponse)
  {
    paramUploadResponse = (FileBatchControlRsp)paramJceStruct;
    this.mEndTime = System.currentTimeMillis();
    UploadLog.d("BatchControlTask", "[speed] batch control pkg cost: " + getCostTime());
    if ((paramUploadResponse == null) || (paramUploadResponse.control_rsp == null) || (paramUploadResponse.control_rsp.size() <= 0)) {
      return;
    }
    paramJceStruct = new BatchControlResult();
    int i = 1;
    Object localObject;
    while (i <= paramUploadResponse.control_rsp.size())
    {
      localObject = (FileControlRsp)paramUploadResponse.control_rsp.get(i + "");
      paramJceStruct.mMap.put(this.mFilePaths.get(i - 1), localObject);
      i += 1;
    }
    this.mResult = paramJceStruct;
    UploadLog.d("BatchControlTask", "Num:" + paramJceStruct.mMap.size());
    long l = getCostTime();
    if (!this.mTasks.isEmpty()) {
      l /= this.mTasks.size();
    }
    for (;;)
    {
      paramUploadResponse = this.mTasks.iterator();
      while (paramUploadResponse.hasNext())
      {
        localObject = (AbstractUploadTask)paramUploadResponse.next();
        FileControlRsp localFileControlRsp = (FileControlRsp)paramJceStruct.mMap.get(((AbstractUploadTask)localObject).getFilePath());
        if ((localFileControlRsp != null) && (localFileControlRsp.result != null))
        {
          UploadLog.d("BatchControlTask", "flowid:" + ((AbstractUploadTask)localObject).flowId + " FileControlRsp rsp ret:" + localFileControlRsp.result.ret + " flag:" + localFileControlRsp.result.flag + " rsp.session:" + localFileControlRsp.session + " path:" + ((AbstractUploadTask)localObject).getFilePath());
          if (localFileControlRsp.result.ret == 0)
          {
            if (localFileControlRsp.result.flag != 1) {
              break label461;
            }
            ((AbstractUploadTask)localObject).setSecondUpload(localFileControlRsp);
          }
        }
        label461:
        while (localFileControlRsp.result.flag != 2)
        {
          ((AbstractUploadTask)localObject).setSessionId(localFileControlRsp.session);
          ((AbstractUploadTask)localObject).setSliceSize((int)localFileControlRsp.slice_size);
          if (((AbstractUploadTask)localObject).getTaskState() != TaskState.CANCEL) {
            this.mTaskManager.sendAsync((AbstractUploadTask)localObject);
          }
          ((AbstractUploadTask)localObject).getReportObj().batchCtrlCostAvg = l;
          break;
        }
      }
      setTaskStatus(TaskState.SUCCEED);
      onTaskFinished(Const.UploadRetCode.SUCCEED.getCode(), Const.UploadRetCode.SUCCEED.getDesc());
      return;
    }
  }
  
  public boolean onRun()
  {
    UploadLog.d("BatchControlTask", "BatchControlTask onRun() is start !! taskId:" + getTaskId());
    this.mFinish = false;
    UploadRequest localUploadRequest = getBatchControlRequest();
    if (localUploadRequest == null)
    {
      UploadLog.e("BatchControlTask", " onRun(), req == null !! taskId:" + getTaskId());
      return false;
    }
    if (this.mFinish)
    {
      UploadLog.e("BatchControlTask", "BatchControlTask onRun(), task is finished already ! taskId:" + getTaskId());
      return false;
    }
    IUploadSession localIUploadSession = this.mSessionPool.poll();
    if (localIUploadSession == null)
    {
      UploadLog.e("BatchControlTask", "BatchControlTask onRun(), get session return null ! taskId:" + getTaskId());
      retryPollSession();
      return false;
    }
    UploadLog.d("BatchControlTask", "BatchControlTask onRun() session is not null. ready to send taskId:" + getTaskId());
    setState(TaskState.CONNECTING);
    this.mSavedSession = localIUploadSession;
    this.mSession = localIUploadSession;
    this.mStartTime = System.currentTimeMillis();
    this.mFlagError = false;
    return this.mSession.send(localUploadRequest, this);
  }
  
  public void onUploadError(int paramInt, String paramString)
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
  
  public String printAllTaskInBatchControl()
  {
    if ((this.mTasks == null) || (this.mTasks.size() == 0)) {
      return "no task in batchControlTask";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.mTasks.size())
    {
      AbstractUploadTask localAbstractUploadTask = (AbstractUploadTask)this.mTasks.get(i);
      localStringBuilder.append("index:").append(i).append(" taskId:").append(localAbstractUploadTask.getTaskId()).append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void report(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.BatchControlTask
 * JD-Core Version:    0.7.0.1
 */