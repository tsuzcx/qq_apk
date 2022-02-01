package com.tencent.mobileqq.winkpublish.task;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.db.util.NeedParcel;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.mobileqq.winkpublish.common.IUploadServiceListener;
import com.tencent.mobileqq.winkpublish.model.PublishQueueTaskInfo;
import com.tencent.mobileqq.winkpublish.queue.AUploadTaskQueue;
import com.tencent.mobileqq.winkpublish.queue.IUploadQueueListener;
import com.tencent.mobileqq.winkpublish.task.report.TaskReportInfo;
import com.tencent.mobileqq.winkpublish.task.report.TaskReportInfo.MediaReportInfo;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.utils.Const.UploadRetCode;
import java.util.Iterator;
import java.util.List;

public abstract class AUploadQueueTask
  extends AUploadTask
  implements IQueueTask, IUploadServiceListener, IUploadQueueListener
{
  public long J = 0L;
  @NeedParcel
  public int K;
  public long L;
  public long M;
  @NeedParcel
  public long N;
  public long O;
  @NeedParcel
  public int P;
  @NeedParcel
  public int Q;
  @NeedParcel
  public String R;
  public TaskReportInfo S = new TaskReportInfo();
  String T = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoQueueing", "排队中...");
  String U = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoStop", "任务暂停");
  String V = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoFailMsg", "任务失败,");
  String W = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoFail", "任务失败");
  String X = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoNetWorkError", "网络错误");
  String Y = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoFileNotExist", "文件不存在");
  String Z = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoCancel", "已取消");
  private long a = System.nanoTime();
  String aa = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoSuccess", "上传成功");
  
  public AUploadQueueTask()
  {
    this.ad = this;
  }
  
  public AUploadQueueTask(int paramInt)
  {
    super(null, null, null, paramInt);
    this.ad = this;
  }
  
  protected int a(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append(str);
    paramString.append(String.valueOf(paramInt));
    paramString.append(System.currentTimeMillis());
    return paramInt + paramString.toString().hashCode();
  }
  
  public void a(int paramInt)
  {
    this.K = paramInt;
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt, String paramString) {}
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    this.R = paramString;
    this.L = paramLong1;
    this.M = paramLong2;
    AUploadTaskQueue.a().g(this);
  }
  
  public void b(TaskReportInfo.MediaReportInfo paramMediaReportInfo)
  {
    if (paramMediaReportInfo == null)
    {
      QLog.e(ab, 1, "addReportInfo error, reportinfo null");
      return;
    }
    if (this.S == null) {
      this.S = new TaskReportInfo();
    }
    this.S.a(paramMediaReportInfo);
  }
  
  public boolean cancel()
  {
    return false;
  }
  
  public void clear() {}
  
  public void dC_()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.O;
    if ((l2 == 0L) || (l1 - l2 > 20000L))
    {
      this.O = l1;
      Object localObject = AUploadTaskQueue.a().e();
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          IQueueTask localIQueueTask = (IQueueTask)((Iterator)localObject).next();
          if (localIQueueTask != null) {
            localIQueueTask.setTime(l1);
          }
        }
      }
    }
  }
  
  public abstract void e();
  
  public List<String> g()
  {
    return null;
  }
  
  public String getClientKey()
  {
    return this.al;
  }
  
  public abstract int getExactType();
  
  public PublishQueueTaskInfo getInfo()
  {
    PublishQueueTaskInfo localPublishQueueTaskInfo = new PublishQueueTaskInfo();
    int i = this.K;
    localPublishQueueTaskInfo.state = i;
    Object localObject;
    StringBuilder localStringBuilder;
    switch (i)
    {
    default: 
      break;
    case 5: 
      if ((this.af != 301002) && (this.af != 301013))
      {
        if (this.af == Const.UploadRetCode.FILE_NOT_EXIST.getCode())
        {
          localPublishQueueTaskInfo.detail = this.Y;
        }
        else
        {
          localObject = ab;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("STATE_CANCEL mResultCode:");
          localStringBuilder.append(this.af);
          QLog.i((String)localObject, 1, localStringBuilder.toString());
          if (this.af == 0) {
            localPublishQueueTaskInfo.detail = this.U;
          } else {
            localPublishQueueTaskInfo.detail = this.Z;
          }
        }
      }
      else {
        localPublishQueueTaskInfo.detail = this.X;
      }
      break;
    case 3: 
      localPublishQueueTaskInfo.detail = this.aa;
      break;
    case 2: 
      localObject = ab;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("STATE_PAUSE mResultCode:");
      localStringBuilder.append(this.af);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      if (this.af == 0)
      {
        localPublishQueueTaskInfo.detail = this.U;
      }
      else if (!TextUtils.isEmpty(this.ae))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.V);
        ((StringBuilder)localObject).append(this.ae);
        localPublishQueueTaskInfo.detail = ((StringBuilder)localObject).toString();
      }
      else if (AUploadTaskQueue.a().b(this, false))
      {
        localPublishQueueTaskInfo.detail = QCircleConfigHelper.a("QZoneSetting", "SafetyStrikeMessage", "你的帐户被禁止发言");
      }
      else
      {
        localPublishQueueTaskInfo.detail = this.W;
      }
      break;
    case 0: 
    case 1: 
    case 4: 
    case 6: 
      localPublishQueueTaskInfo.detail = this.T;
    }
    localPublishQueueTaskInfo.recvDataSize = this.L;
    localPublishQueueTaskInfo.totalSize = this.M;
    return localPublishQueueTaskInfo;
  }
  
  public long getLeaveSize()
  {
    long l = this.M;
    if (l != 0L) {
      l = l * 1024L - this.L * 1024L;
    } else {
      l = i();
    }
    return l + 0L;
  }
  
  public int getManualRetryNum()
  {
    return this.Q;
  }
  
  public String getMissionId()
  {
    return "";
  }
  
  public String getPhotoSource()
  {
    return this.R;
  }
  
  public List<String> getPhotoSources()
  {
    return g();
  }
  
  public int getResultCode()
  {
    return this.af;
  }
  
  public String getResultMsg()
  {
    return this.ae;
  }
  
  public int getRetryNum()
  {
    return this.P;
  }
  
  public int getState()
  {
    return this.K;
  }
  
  public long getTaskId()
  {
    return this.a;
  }
  
  public long getTime()
  {
    return this.J;
  }
  
  public long getTimeStamp()
  {
    return this.an;
  }
  
  public long getUploadTime()
  {
    return 0L;
  }
  
  protected long i()
  {
    return 0L;
  }
  
  public void increaseManualRetryNum()
  {
    try
    {
      this.Q += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void increaseRetryNum()
  {
    try
    {
      this.P += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isNeedRetryByQueue()
  {
    return true;
  }
  
  public boolean isNullTask()
  {
    return false;
  }
  
  public boolean isQunTask()
  {
    return false;
  }
  
  public boolean isVideoTask()
  {
    return false;
  }
  
  public void n()
  {
    if (5 == this.K)
    {
      String str = ab;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QCircleQueueTask.run type:");
      localStringBuilder.append(getExactType());
      localStringBuilder.append(" is canceled");
      QLog.i(str, 1, localStringBuilder.toString());
      return;
    }
    e();
    this.J = System.currentTimeMillis();
    super.n();
  }
  
  public boolean needShowCloseBt()
  {
    return false;
  }
  
  public void notifyComplete(boolean paramBoolean) {}
  
  public void onRemove() {}
  
  public void onRestore() {}
  
  public void onResume()
  {
    this.P += 1;
    resetDataSize();
  }
  
  public void resetDataSize()
  {
    this.L = 0L;
    this.M = 0L;
  }
  
  public void setResultCode(int paramInt)
  {
    this.af = paramInt;
  }
  
  public void setResultMsg(String paramString)
  {
    this.ae = paramString;
  }
  
  public void setState(int paramInt)
  {
    this.K = paramInt;
  }
  
  public void setTime(long paramLong)
  {
    this.J = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.task.AUploadQueueTask
 * JD-Core Version:    0.7.0.1
 */