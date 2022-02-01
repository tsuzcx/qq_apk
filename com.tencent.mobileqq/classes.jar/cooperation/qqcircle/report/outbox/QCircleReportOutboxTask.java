package cooperation.qqcircle.report.outbox;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.qcircle.api.db.util.NeedParcel;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

public class QCircleReportOutboxTask
  implements IQueueTask
{
  public static final int STATE_PAUSE = 2;
  public static final int STATE_REMOVED = 4;
  public static final int STATE_RESENDING = 1;
  public static final int STATE_SENDING_FINISH = 3;
  private static final String TAG = "QCircleReportOutboxTask";
  @NeedParcel
  private long id;
  @NeedParcel
  public String mCmdName;
  public QCircleBaseRequest mRequest;
  @NeedParcel
  public byte[] mRequestByteData;
  @NeedParcel
  public String mRequestKey;
  @NeedParcel
  public long mResultCode;
  @NeedParcel
  public String mResultMsg;
  @NeedParcel
  public int mRetryNum = 0;
  @NeedParcel
  public int mState;
  @NeedParcel
  public long mTime = 0L;
  
  public QCircleReportOutboxTask() {}
  
  public QCircleReportOutboxTask(QCircleBaseRequest paramQCircleBaseRequest)
  {
    this.id = System.nanoTime();
    this.mRequest = paramQCircleBaseRequest;
    this.mRequestByteData = paramQCircleBaseRequest.getRequestByteKey();
    this.mCmdName = paramQCircleBaseRequest.getCmdName();
    paramQCircleBaseRequest = new StringBuilder();
    paramQCircleBaseRequest.append(this.mCmdName);
    paramQCircleBaseRequest.append(QCircleHostStubUtil.getCurrentAccount());
    paramQCircleBaseRequest.append(QUA.getQUA3());
    paramQCircleBaseRequest.append(new String(this.mRequestByteData));
    this.mRequestKey = paramQCircleBaseRequest.toString();
  }
  
  private void reportOutboxResendResult(boolean paramBoolean, long paramLong, String paramString)
  {
    if (paramBoolean)
    {
      localObject1 = "0";
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject1 = QCircleReportHelper.newEntry("ret_code", (String)localObject1);
    paramString = QCircleReportHelper.newEntry("url", paramString);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.mCmdName);
    ((StringBuilder)localObject2).append("");
    localObject2 = QCircleReportHelper.newEntry("refer", ((StringBuilder)localObject2).toString());
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.mRetryNum);
    ((StringBuilder)localObject3).append("");
    localObject3 = QCircleReportHelper.newEntry("count", ((StringBuilder)localObject3).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.id);
    localStringBuilder.append("_");
    localStringBuilder.append(this.mResultCode);
    localStringBuilder.append("_");
    localStringBuilder.append(this.mResultMsg);
    localStringBuilder.append("_state=");
    localStringBuilder.append(getState());
    QCircleQualityReporter.reportQualityEvent("outbox_task_resend_event", Arrays.asList(new FeedCloudCommon.Entry[] { localObject1, paramString, localObject2, localObject3, QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()) }), false);
  }
  
  public void clear() {}
  
  public void doResend()
  {
    if (this.mRequest == null) {
      this.mRequest = new QCircleReportOutboxRequest(this.mCmdName, this.mRequestByteData);
    }
    VSNetworkHelper.getInstance().sendRequest(this.mRequest, new QCircleReportOutboxTask.1(this));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doResend id:");
    localStringBuilder.append(getTaskId());
    QLog.i("QCircleReportOutboxTask", 1, localStringBuilder.toString());
  }
  
  public String getCacheKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.id);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public long getResultCode()
  {
    return this.mResultCode;
  }
  
  public String getResultMsg()
  {
    return this.mResultMsg;
  }
  
  public int getRetryNum()
  {
    return this.mRetryNum;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public long getTaskId()
  {
    return this.id;
  }
  
  public long getTime()
  {
    return this.mTime;
  }
  
  public boolean isNullTask()
  {
    return (this.mRequest == null) && (this.mRequestByteData == null);
  }
  
  public void onRemove()
  {
    this.mRequest = null;
  }
  
  public void onRestore()
  {
    if ((this.mRequest == null) && (!isNullTask())) {
      this.mRequest = new QCircleReportOutboxRequest(this.mCmdName, this.mRequestByteData);
    }
  }
  
  public void onResume()
  {
    this.mRetryNum += 1;
  }
  
  public void printTaskInfo(String paramString1, String paramString2)
  {
    printTaskInfo(paramString1, paramString2, false);
  }
  
  public void printTaskInfo(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_QCircleSenderTask");
      paramString1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" id:");
      localStringBuilder.append(getTaskId());
      localStringBuilder.append(" ,state:");
      localStringBuilder.append(this.mState);
      localStringBuilder.append(" ,cmd:");
      localStringBuilder.append(this.mCmdName);
      QLog.e(paramString1, 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_QCircleSenderTask");
    paramString1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" id:");
    localStringBuilder.append(getTaskId());
    localStringBuilder.append(" ,state:");
    localStringBuilder.append(this.mState);
    localStringBuilder.append(" ,cmd:");
    localStringBuilder.append(this.mCmdName);
    QLog.d(paramString1, 2, localStringBuilder.toString());
  }
  
  public void resend()
  {
    if (4 == this.mState)
    {
      QLog.i("QCircleReportOutboxTask", 1, "QCircleQueueTask.run is already removed");
      return;
    }
    doResend();
    this.mTime = System.currentTimeMillis();
  }
  
  public void setResultCode(long paramLong)
  {
    this.mResultCode = paramLong;
  }
  
  public void setResultMsg(String paramString)
  {
    this.mResultMsg = paramString;
  }
  
  public void setState(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public void setTime(long paramLong)
  {
    this.mTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTask
 * JD-Core Version:    0.7.0.1
 */