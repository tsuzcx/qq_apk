package com.tencent.upload.uinterface.data;

import FileUpload.UploadPicInfoRsp;
import SLICE_UPLOAD.FileBatchCommitReq;
import SLICE_UPLOAD.FileBatchCommitRsp;
import SLICE_UPLOAD.FileCommitReq;
import SLICE_UPLOAD.FileCommitRsp;
import SLICE_UPLOAD.stResult;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.network.session.SessionPool;
import com.tencent.upload.request.impl.BatchCommitRequest;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.UploadLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BatchCommitUploadTask
  extends AbstractUploadTask
{
  private static final String TAG = "BatchCommitUploadTask";
  public List<ImageUploadTask> commitImageTasks = null;
  
  public BatchCommitUploadTask()
  {
    super(new byte[0]);
    this.mAppid = "pic_qzone";
  }
  
  public BatchCommitUploadTask(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
    this.mAppid = "pic_qzone";
  }
  
  private FileBatchCommitReq buildReq()
  {
    FileBatchCommitReq localFileBatchCommitReq = new FileBatchCommitReq();
    localFileBatchCommitReq.commit_req = new HashMap();
    if (this.commitImageTasks == null) {
      return localFileBatchCommitReq;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preupload{");
    Iterator localIterator = this.commitImageTasks.iterator();
    while (localIterator.hasNext())
    {
      ImageUploadTask localImageUploadTask = (ImageUploadTask)localIterator.next();
      Object localObject = JceEncoder.encode(localImageUploadTask.createUploadPicInfoReq());
      String str = SessionPool.getSessionIdByPath(localImageUploadTask.getFilePath());
      if (!TextUtils.isEmpty(str))
      {
        localObject = new FileCommitReq(this.iUin + "", str, (byte[])localObject, this.mAppid, null);
        localFileBatchCommitReq.commit_req.put(localImageUploadTask.flowId + "", localObject);
        localStringBuilder.append("[path:").append(localImageUploadTask.getFilePath());
        localStringBuilder.append(", flowId:" + localImageUploadTask.flowId);
        localStringBuilder.append(", sessionId:" + str);
        localStringBuilder.append("]");
      }
    }
    localStringBuilder.append("}");
    UploadLog.d("BatchCommitUploadTask", "buildReq preupload.size: " + this.commitImageTasks.size() + " " + localStringBuilder.toString());
    return localFileBatchCommitReq;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.BatchCommitUploadType;
  }
  
  public boolean onRun()
  {
    BatchCommitRequest localBatchCommitRequest = new BatchCommitRequest(buildReq(), this.flowId);
    IUploadSession localIUploadSession = this.mSessionPool.poll();
    if (localIUploadSession == null)
    {
      UploadLog.e("BatchCommitUploadTask", "BatchCommitUploadTask onRun(), get session return null !");
      retryPollSession();
      return false;
    }
    this.mSavedSession = localIUploadSession;
    this.mSession = localIUploadSession;
    return this.mSession.send(localBatchCommitRequest, this);
  }
  
  public boolean onVerifyUploadFile()
  {
    return true;
  }
  
  public void processFileBatchCommitRsp(FileBatchCommitRsp paramFileBatchCommitRsp)
  {
    if ((paramFileBatchCommitRsp == null) || (paramFileBatchCommitRsp.commit_rsp == null))
    {
      onError(Const.UploadRetCode.ERROR_BATCH_COMMIT.getCode(), "rsp invalid");
      UploadLog.w("BatchCommitUploadTask", "rsp == null");
      return;
    }
    Object localObject1 = new StringBuilder().append("processBatchCommitRsp commit size:");
    int i;
    Object localObject2;
    if (paramFileBatchCommitRsp.commit_rsp == null)
    {
      i = 0;
      UploadLog.d("BatchCommitUploadTask", i + " flowId:" + this.flowId);
      localObject1 = new HashMap();
      localObject2 = this.commitImageTasks.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label455;
      }
      ImageUploadTask localImageUploadTask = (ImageUploadTask)((Iterator)localObject2).next();
      Object localObject3 = Integer.toString(localImageUploadTask.flowId);
      FileCommitRsp localFileCommitRsp = (FileCommitRsp)paramFileBatchCommitRsp.commit_rsp.get(localObject3);
      if ((localFileCommitRsp == null) || (localFileCommitRsp.biz_rsp == null))
      {
        UploadLog.e("BatchCommitUploadTask", "fcp == null flowId:" + (String)localObject3);
        continue;
        i = paramFileBatchCommitRsp.commit_rsp.size();
        break;
      }
      if (localFileCommitRsp.result == null)
      {
        UploadLog.e("BatchCommitUploadTask", "fcp.result == null flowId:" + (String)localObject3);
      }
      else if (localFileCommitRsp.result.ret < 0)
      {
        UploadLog.e("BatchCommitUploadTask", "fcp.result.ret:" + localFileCommitRsp.result.ret + " flag:" + localFileCommitRsp.result.flag + " flowId:" + (String)localObject3);
      }
      else
      {
        localObject3 = (UploadPicInfoRsp)JceEncoder.decode(UploadPicInfoRsp.class, localFileCommitRsp.biz_rsp);
        if (localObject3 == null)
        {
          UploadLog.e("BatchCommitUploadTask", "uploadPicInfoRsp == null");
        }
        else
        {
          if (this.uploadTaskCallback != null) {
            this.uploadTaskCallback.onUploadSucceed(localImageUploadTask, new ImageUploadResult(localImageUploadTask.iUin, localImageUploadTask.flowId, localImageUploadTask.iBatchID, (UploadPicInfoRsp)localObject3));
          }
          ((Map)localObject1).put(localImageUploadTask.flowId + "", localObject3);
          UploadLog.d("BatchCommitUploadTask", "processBatchCommitRsp commit flow:" + localImageUploadTask.flowId);
          report(Const.UploadRetCode.ERROR_PRE_UPLOAD_HIT.getCode(), null);
        }
      }
    }
    label455:
    if (this.uploadTaskCallback != null)
    {
      localObject2 = new BatchCommitUploadResult();
      ((BatchCommitUploadResult)localObject2).flowId = this.flowId;
      ((BatchCommitUploadResult)localObject2).mapPicInfoRsp = ((Map)localObject1);
      this.uploadTaskCallback.onUploadSucceed(this, localObject2);
    }
    UploadLog.d("BatchCommitUploadTask", "processBatchCommitRsp cancel self");
    super.processFileBatchCommitRsp(paramFileBatchCommitRsp);
  }
  
  public void processUploadTask()
  {
    Iterator localIterator = this.commitImageTasks.iterator();
    while (localIterator.hasNext())
    {
      ImageUploadTask localImageUploadTask = (ImageUploadTask)localIterator.next();
      Object localObject = UploadGlobalConfig.getContext();
      String str = FileUtils.getFilePathByPrefix((Context)localObject, localImageUploadTask.uploadFilePath, localImageUploadTask.md5);
      if (!TextUtils.isEmpty(str))
      {
        localObject = FileUtils.getTempFilePath((Context)localObject, localImageUploadTask.uploadFilePath, localImageUploadTask.md5, localImageUploadTask.flowId);
        if (FileUtils.copyFile(str, (String)localObject)) {
          localImageUploadTask.uploadFilePath = ((String)localObject);
        }
      }
    }
  }
  
  public void report(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.BatchCommitUploadTask
 * JD-Core Version:    0.7.0.1
 */