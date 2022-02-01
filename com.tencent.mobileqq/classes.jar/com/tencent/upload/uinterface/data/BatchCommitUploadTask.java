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
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("preupload{");
    Object localObject1 = this.commitImageTasks.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ImageUploadTask)((Iterator)localObject1).next();
      Object localObject3 = JceEncoder.encode(((ImageUploadTask)localObject2).createUploadPicInfoReq());
      String str = SessionPool.getSessionIdByPath(((ImageUploadTask)localObject2).getFilePath());
      if (!TextUtils.isEmpty(str))
      {
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.iUin);
        ((StringBuilder)localObject4).append("");
        localObject3 = new FileCommitReq(((StringBuilder)localObject4).toString(), str, (byte[])localObject3, this.mAppid, null);
        localObject4 = localFileBatchCommitReq.commit_req;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(((ImageUploadTask)localObject2).flowId);
        localStringBuilder2.append("");
        ((Map)localObject4).put(localStringBuilder2.toString(), localObject3);
        localStringBuilder1.append("[path:");
        localStringBuilder1.append(((ImageUploadTask)localObject2).getFilePath());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(", flowId:");
        ((StringBuilder)localObject3).append(((ImageUploadTask)localObject2).flowId);
        localStringBuilder1.append(((StringBuilder)localObject3).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(", sessionId:");
        ((StringBuilder)localObject2).append(str);
        localStringBuilder1.append(((StringBuilder)localObject2).toString());
        localStringBuilder1.append("]");
      }
    }
    localStringBuilder1.append("}");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("buildReq preupload.size: ");
    ((StringBuilder)localObject1).append(this.commitImageTasks.size());
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(localStringBuilder1.toString());
    UploadLog.d("BatchCommitUploadTask", ((StringBuilder)localObject1).toString());
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
  
  protected void processFileBatchCommitRsp(FileBatchCommitRsp paramFileBatchCommitRsp)
  {
    Object localObject1 = paramFileBatchCommitRsp;
    if ((localObject1 != null) && (((FileBatchCommitRsp)localObject1).commit_rsp != null))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("processBatchCommitRsp commit size:");
      int i;
      if (((FileBatchCommitRsp)localObject1).commit_rsp == null) {
        i = 0;
      } else {
        i = ((FileBatchCommitRsp)localObject1).commit_rsp.size();
      }
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" flowId:");
      ((StringBuilder)localObject2).append(this.flowId);
      UploadLog.d("BatchCommitUploadTask", ((StringBuilder)localObject2).toString());
      localObject1 = new HashMap();
      localObject2 = this.commitImageTasks.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (ImageUploadTask)((Iterator)localObject2).next();
        Object localObject4 = Integer.toString(((ImageUploadTask)localObject3).flowId);
        Object localObject5 = (FileCommitRsp)paramFileBatchCommitRsp.commit_rsp.get(localObject4);
        if ((localObject5 != null) && (((FileCommitRsp)localObject5).biz_rsp != null))
        {
          if (((FileCommitRsp)localObject5).result == null)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("fcp.result == null flowId:");
            ((StringBuilder)localObject3).append((String)localObject4);
            UploadLog.e("BatchCommitUploadTask", ((StringBuilder)localObject3).toString());
          }
          else if (((FileCommitRsp)localObject5).result.ret < 0)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("fcp.result.ret:");
            ((StringBuilder)localObject3).append(((FileCommitRsp)localObject5).result.ret);
            ((StringBuilder)localObject3).append(" flag:");
            ((StringBuilder)localObject3).append(((FileCommitRsp)localObject5).result.flag);
            ((StringBuilder)localObject3).append(" flowId:");
            ((StringBuilder)localObject3).append((String)localObject4);
            UploadLog.e("BatchCommitUploadTask", ((StringBuilder)localObject3).toString());
          }
          else
          {
            localObject4 = (UploadPicInfoRsp)JceEncoder.decode(UploadPicInfoRsp.class, ((FileCommitRsp)localObject5).biz_rsp);
            if (localObject4 == null)
            {
              UploadLog.e("BatchCommitUploadTask", "uploadPicInfoRsp == null");
            }
            else
            {
              if (this.uploadTaskCallback != null) {
                this.uploadTaskCallback.onUploadSucceed((AbstractUploadTask)localObject3, new ImageUploadResult(((ImageUploadTask)localObject3).iUin, ((ImageUploadTask)localObject3).flowId, ((ImageUploadTask)localObject3).iBatchID, (UploadPicInfoRsp)localObject4));
              }
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append(((ImageUploadTask)localObject3).flowId);
              ((StringBuilder)localObject5).append("");
              ((Map)localObject1).put(((StringBuilder)localObject5).toString(), localObject4);
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("processBatchCommitRsp commit flow:");
              ((StringBuilder)localObject4).append(((ImageUploadTask)localObject3).flowId);
              UploadLog.d("BatchCommitUploadTask", ((StringBuilder)localObject4).toString());
              report(Const.UploadRetCode.ERROR_PRE_UPLOAD_HIT.getCode(), null);
            }
          }
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("fcp == null flowId:");
          ((StringBuilder)localObject3).append((String)localObject4);
          UploadLog.e("BatchCommitUploadTask", ((StringBuilder)localObject3).toString());
        }
      }
      if (this.uploadTaskCallback != null)
      {
        localObject2 = new BatchCommitUploadResult();
        ((BatchCommitUploadResult)localObject2).flowId = this.flowId;
        ((BatchCommitUploadResult)localObject2).mapPicInfoRsp = ((Map)localObject1);
        this.uploadTaskCallback.onUploadSucceed(this, localObject2);
      }
      UploadLog.d("BatchCommitUploadTask", "processBatchCommitRsp cancel self");
      super.processFileBatchCommitRsp(paramFileBatchCommitRsp);
      return;
    }
    onError(Const.UploadRetCode.ERROR_BATCH_COMMIT.getCode(), "rsp invalid");
    UploadLog.w("BatchCommitUploadTask", "rsp == null");
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
  
  protected void report(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.BatchCommitUploadTask
 * JD-Core Version:    0.7.0.1
 */