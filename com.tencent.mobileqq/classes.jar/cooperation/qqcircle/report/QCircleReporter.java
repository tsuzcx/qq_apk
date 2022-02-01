package cooperation.qqcircle.report;

import NS_COMM.COMM.Entry;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.biz.qcircleshadow.local.util.QCircleHostProtoUtil;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.requests.CommandReportRequest;
import com.tencent.mobileqq.qcircle.api.requests.QCircleClientReportRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTask;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue;
import cooperation.qqcircle.report.outbox.SimpleTaskQueue;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mqq.app.MobileQQ;
import qqcircle.QQCircleReport.SingleDcData;

public class QCircleReporter
{
  private static final int MESSAGE_CHECK_SHOULD_IMMEDIATE_REPORT_TO_SERVER = 4098;
  private static final int MESSAGE_CHECK_SHOULD_REPORT_TO_SERVER = 4097;
  private static final int REPORT_COUNT_THRESHOLD_NORMAL;
  private static final int REPORT_COUNT_THRESHOLD_QUALITY = QCircleConfig.getQQCircleQualityReportBufferLength();
  private static final long REPORT_IMMEDIATE_INTERVAL = 1000L;
  private static final long REPORT_NORMAL_INTERVAL = TimeUnit.SECONDS.toMillis(QCircleConfig.getQQCircleReportInterval());
  private static final long REPORT_QUALITY_INTERVAL;
  public static final String TAG = "QCircleReporter";
  private static volatile QCircleReporter sInstance;
  private List<APP_REPORT_TRANSFER.SingleDcData> mCommandListPool = new ArrayList();
  private List<QQCircleReport.SingleDcData> mImmediateDataListPool = new ArrayList();
  private long mLastCommandReportTimeMillis = System.currentTimeMillis();
  private long mLastQualityReportTimeMillis = System.currentTimeMillis();
  private long mLastReportTimeMillis = System.currentTimeMillis();
  private List<QQCircleReport.SingleDcData> mMissSessionDataListPool = new ArrayList();
  private List<QQCircleReport.SingleDcData> mNormalDataListPool = new ArrayList();
  private List<QQCircleReport.SingleDcData> mQualityDataListPool = new ArrayList();
  private Handler reportHandler;
  
  static
  {
    REPORT_COUNT_THRESHOLD_NORMAL = QCircleConfig.getQQCircleReportBufferLength();
    REPORT_QUALITY_INTERVAL = TimeUnit.SECONDS.toMillis(QCircleConfig.getQQCircleQualityReportInterval());
  }
  
  private QCircleReporter()
  {
    HandlerThread localHandlerThread = new HandlerThread("qqcircle_report");
    localHandlerThread.setPriority(10);
    localHandlerThread.start();
    this.reportHandler = new QCircleReporter.1(this, localHandlerThread.getLooper());
    initOutbox();
  }
  
  private void checkShouldImmediateReportToServer()
  {
    if (!this.reportHandler.hasMessages(4098)) {
      this.reportHandler.sendEmptyMessageDelayed(4098, 1000L);
    }
  }
  
  private void checkShouldReportToServer()
  {
    if ((this.mNormalDataListPool.size() > 0) || (this.mQualityDataListPool.size() > 0) || (this.mCommandListPool.size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((System.currentTimeMillis() - this.mLastReportTimeMillis > REPORT_NORMAL_INTERVAL) || (this.mNormalDataListPool.size() >= REPORT_COUNT_THRESHOLD_NORMAL)) {
          performNormalDataListReportToServer();
        }
        if ((System.currentTimeMillis() - this.mLastQualityReportTimeMillis > REPORT_QUALITY_INTERVAL) || (this.mQualityDataListPool.size() >= REPORT_COUNT_THRESHOLD_QUALITY)) {
          performQualityDataListReportToServer();
        }
        if ((System.currentTimeMillis() - this.mLastCommandReportTimeMillis > REPORT_QUALITY_INTERVAL) || (this.mCommandListPool.size() >= REPORT_COUNT_THRESHOLD_QUALITY)) {
          performCommandDataListReportToServer();
        }
      }
      if ((!this.reportHandler.hasMessages(4097)) && ((i != 0) || (System.currentTimeMillis() - this.mLastReportTimeMillis <= 10L * REPORT_NORMAL_INTERVAL))) {
        break;
      }
      return;
    }
    this.reportHandler.sendEmptyMessageDelayed(4097, REPORT_NORMAL_INTERVAL);
  }
  
  public static QCircleReporter getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QCircleReporter();
      }
      return sInstance;
    }
    finally {}
  }
  
  private static String parseCommandString(APP_REPORT_TRANSFER.SingleDcData paramSingleDcData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramSingleDcData != null)
    {
      localStringBuilder.append("dcid:").append(paramSingleDcData.dcid.get()).append(",report_data:{");
      Iterator localIterator = paramSingleDcData.report_data.get().iterator();
      while (localIterator.hasNext())
      {
        COMM.Entry localEntry = (COMM.Entry)localIterator.next();
        localStringBuilder.append(localEntry.key.get()).append("=").append(localEntry.value.get()).append(", ");
      }
      if (paramSingleDcData.extinfo.has())
      {
        localStringBuilder.append("},byteExtInfo:{");
        paramSingleDcData = paramSingleDcData.extinfo.get().iterator();
        while (paramSingleDcData.hasNext()) {
          localStringBuilder.append(((COMM.Entry)paramSingleDcData.next()).key.get()).append(", ");
        }
      }
      localStringBuilder.append("}\n");
    }
    return localStringBuilder.toString();
  }
  
  private static String parseString(QQCircleReport.SingleDcData paramSingleDcData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramSingleDcData != null)
    {
      localStringBuilder.append("dcid:").append(paramSingleDcData.dcid.get()).append(",report_data:{");
      Iterator localIterator = paramSingleDcData.report_data.get().iterator();
      while (localIterator.hasNext())
      {
        FeedCloudCommon.Entry localEntry = (FeedCloudCommon.Entry)localIterator.next();
        localStringBuilder.append(localEntry.key.get()).append("=").append(localEntry.value.get()).append(", ");
      }
      if (paramSingleDcData.byteExtinfo.has())
      {
        localStringBuilder.append("},byteExtInfo:{");
        paramSingleDcData = paramSingleDcData.byteExtinfo.get().iterator();
        while (paramSingleDcData.hasNext()) {
          localStringBuilder.append(((FeedCloudCommon.BytesEntry)paramSingleDcData.next()).key.get()).append(", ");
        }
      }
      localStringBuilder.append("}\n");
    }
    return localStringBuilder.toString();
  }
  
  private void performClientReport(List<QQCircleReport.SingleDcData> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = new QCircleClientReportRequest(new ArrayList(paramList));
      if (!NetworkUtil.g(MobileQQ.sMobileQQ.getApplicationContext()))
      {
        RFLog.d("QCircleReporter", RFLog.CLR, "performClientReport fail! network is not available,save in cache first");
        QCircleReportOutboxTaskQueue.getInstance().addPausedTask(new QCircleReportOutboxTask(paramList));
      }
    }
    else
    {
      return;
    }
    VSNetworkHelper.getInstance().sendRequest(MobileQQ.sMobileQQ, paramList, new QCircleReporter.4(this));
  }
  
  private void performCommandDataListReportToServer()
  {
    this.mLastCommandReportTimeMillis = System.currentTimeMillis();
    performCommandReport(this.mCommandListPool);
    this.mCommandListPool.clear();
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
      RFLog.d("QCircleReporter", RFLog.CLR, "performQualityDataListReportToServer called");
    }
  }
  
  private void performCommandReport(List<APP_REPORT_TRANSFER.SingleDcData> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = new CommandReportRequest(paramList);
      VSNetworkHelper.getInstance().sendRequest(paramList, new QCircleReporter.5(this));
    }
  }
  
  private void performImmediateDataListReportToServer()
  {
    performClientReport(this.mImmediateDataListPool);
    this.mImmediateDataListPool.clear();
    RFLog.d("QCircleReporter", RFLog.CLR, "performImmediateDataListReportToServer called");
  }
  
  private void performNormalDataListReportToServer()
  {
    this.mLastReportTimeMillis = System.currentTimeMillis();
    performClientReport(this.mNormalDataListPool);
    this.mNormalDataListPool.clear();
    RFLog.d("QCircleReporter", RFLog.CLR, "performNormalDataListReportToServer called");
  }
  
  private void performQualityDataListReportToServer()
  {
    this.mLastQualityReportTimeMillis = System.currentTimeMillis();
    performClientReport(this.mQualityDataListPool);
    this.mQualityDataListPool.clear();
    RFLog.d("QCircleReporter", RFLog.CLR, "performQualityDataListReportToServer called");
  }
  
  private void performVideoDataListReportToServer(List<QQCircleReport.SingleDcData> paramList)
  {
    performClientReport(paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQCircleReport.SingleDcData localSingleDcData = (QQCircleReport.SingleDcData)paramList.next();
      if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
        RFLog.d("QCircleReporter", RFLog.CLR, "perform video Data:" + parseString(localSingleDcData));
      }
    }
    RFLog.d("QCircleReporter", RFLog.CLR, "performVideoDataListReportToServer called");
  }
  
  public void add(QQCircleReport.SingleDcData paramSingleDcData, boolean paramBoolean)
  {
    this.reportHandler.post(new QCircleReporter.6(this, paramBoolean, paramSingleDcData));
  }
  
  public void addCommandReportData(APP_REPORT_TRANSFER.SingleDcData paramSingleDcData)
  {
    this.reportHandler.post(new QCircleReporter.8(this, paramSingleDcData));
  }
  
  public void addMissSessionReportDataCache(QQCircleReport.SingleDcData paramSingleDcData)
  {
    this.reportHandler.post(new QCircleReporter.9(this, paramSingleDcData));
  }
  
  public void addQualityReportData(QQCircleReport.SingleDcData paramSingleDcData)
  {
    this.reportHandler.post(new QCircleReporter.7(this, paramSingleDcData));
  }
  
  public void flush()
  {
    this.reportHandler.post(new QCircleReporter.10(this));
  }
  
  public void flushVideoReport(List<QQCircleReport.SingleDcData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      RFLog.d("QCircleReporter", RFLog.USR, "flushVideoReport data error");
      return;
    }
    this.reportHandler.post(new QCircleReporter.11(this, paramList));
  }
  
  public void flushVideoReportByByte(List<byte[]> paramList)
  {
    flushVideoReport(QCircleHostProtoUtil.a(paramList));
  }
  
  public Handler getReportHandler()
  {
    return this.reportHandler;
  }
  
  public void initOutbox()
  {
    this.reportHandler.postDelayed(new QCircleReporter.2(this), 10000L);
  }
  
  public void reportCacheDataListToServerWithSession(byte[] paramArrayOfByte)
  {
    this.reportHandler.post(new QCircleReporter.3(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter
 * JD-Core Version:    0.7.0.1
 */