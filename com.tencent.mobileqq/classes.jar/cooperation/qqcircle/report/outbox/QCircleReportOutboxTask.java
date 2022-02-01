package cooperation.qqcircle.report.outbox;

import com.tencent.biz.qcircleshadow.local.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import mqq.app.AppRuntime;

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
  public int mRetryNum;
  @NeedParcel
  public int mState;
  @NeedParcel
  public long mTime;
  
  public QCircleReportOutboxTask() {}
  
  public QCircleReportOutboxTask(QCircleBaseRequest paramQCircleBaseRequest)
  {
    this.id = System.nanoTime();
    this.mRequest = paramQCircleBaseRequest;
    this.mRequestByteData = paramQCircleBaseRequest.getRequestByteKey();
    this.mCmdName = paramQCircleBaseRequest.getCmdName();
    this.mRequestKey = (this.mCmdName + BaseApplicationImpl.sApplication.getRuntime().getAccount() + QUA.getQUA3() + new String(this.mRequestByteData));
  }
  
  public void clear() {}
  
  public void doResend()
  {
    if (this.mRequest == null) {
      this.mRequest = new QCircleReportOutboxRequest(this.mCmdName, this.mRequestByteData);
    }
    VSNetworkHelper.getInstance().sendRequest(this.mRequest, new QCircleReportOutboxTask.1(this));
    QLog.i("QCircleReportOutboxTask", 1, "doResend id:" + getTaskId());
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
      QLog.e(paramString1 + "_QCircleSenderTask", 1, paramString2 + " id:" + getTaskId() + " ,state:" + this.mState + " ,cmd:" + this.mCmdName);
      return;
    }
    QLog.d(paramString1 + "_QCircleSenderTask", 1, paramString2 + " id:" + getTaskId() + " ,state:" + this.mState + " ,cmd:" + this.mCmdName);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxTask
 * JD-Core Version:    0.7.0.1
 */