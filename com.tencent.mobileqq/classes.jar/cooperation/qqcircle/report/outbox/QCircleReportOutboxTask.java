package cooperation.qqcircle.report.outbox;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.qcircle.api.db.util.NeedParcel;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

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
    this.mRequestKey = (this.mCmdName + MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount() + QCircleServiceImpl.getQZoneService().getQUA3() + new String(this.mRequestByteData));
  }
  
  private void reportOutboxResendResult(boolean paramBoolean, long paramLong, String paramString)
  {
    if (paramBoolean) {}
    for (String str = "0";; str = paramLong + "")
    {
      QCircleQualityReporter.reportQualityEvent("outbox_task_resend_event", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("ret_code", str), QCircleReportHelper.newEntry("url", paramString), QCircleReportHelper.newEntry("refer", this.mCmdName + ""), QCircleReportHelper.newEntry("count", this.mRetryNum + ""), QCircleReportHelper.newEntry("attach_info", this.id + "_" + this.mResultCode + "_" + this.mResultMsg + "_state=" + getState()) }), false);
      return;
    }
  }
  
  public void clear() {}
  
  public void doResend()
  {
    if (this.mRequest == null) {
      this.mRequest = new QCircleReportOutboxRequest(this.mCmdName, this.mRequestByteData);
    }
    VSNetworkHelper.getInstance().sendRequest(this.mRequest, new QCircleReportOutboxTask.1(this));
    RFLog.i("QCircleReportOutboxTask", RFLog.USR, "doResend id:" + getTaskId());
  }
  
  public String getCacheKey()
  {
    return this.id + "";
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
      RFLog.e(paramString1 + "_QCircleSenderTask", RFLog.USR, paramString2 + " id:" + getTaskId() + " ,state:" + this.mState + " ,cmd:" + this.mCmdName);
      return;
    }
    RFLog.d(paramString1 + "_QCircleSenderTask", RFLog.CLR, paramString2 + " id:" + getTaskId() + " ,state:" + this.mState + " ,cmd:" + this.mCmdName);
  }
  
  public void resend()
  {
    if (4 == this.mState)
    {
      RFLog.i("QCircleReportOutboxTask", RFLog.USR, "QCircleQueueTask.run is already removed");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTask
 * JD-Core Version:    0.7.0.1
 */