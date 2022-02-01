package cooperation.qzone.report;

import NS_MOBILE_FEEDS.mobile_online_report_item;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneReq;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class QzoneOnlineTimeCollectRptService
{
  private static final int DEFAULT_INTERVAL_TIME = 3600;
  private static final int DEFAULT_MAX_NUM = 1;
  private static final int DEFAULT_TIME_INTERVAL = 10000;
  private static final String KEY_ONLINETIME = "QZonlinetime";
  private static final String KEY_ONLINETIME_LASTRECORD = "QZonlinetimeLastRecord";
  private static final String KEY_ONLINETIME_LASTRECORD_PICTURE = "QZonlinetimeLastRecord_picture";
  private static final String KEY_ONLINETIME_LASTRECORD_VIDEO = "QZonlinetimeLastRecord_video";
  private static final String KEY_ONLINETIME_LASTRECORD_WEB = "QZonlinetimeLastRecord_web";
  private static final String KEY_ONLINETIME_PICTURE = "QZonlinetime_picture";
  private static final String KEY_ONLINETIME_VIDEO = "QZonlinetime_video";
  private static final String KEY_ONLINETIME_WEB = "QZonlinetime_web";
  public static final int KEY_PICTURE = 3;
  public static final int KEY_QZONE = 0;
  public static final int KEY_VIDEO = 4;
  public static final int KEY_WEB = 1;
  private static final String TAG = "QzoneOnlineTimeCollectRptService";
  private static QzoneOnlineTimeCollectRptService mInstance;
  int RetryTimes = 0;
  private volatile boolean isForeground = false;
  private ArrayList<mobile_online_report_item> mBackupItems = new ArrayList();
  private int mDelay = 10000;
  private String mKeyOnlineSp = "QZonlinetime";
  private String mKeyOnlineUpdateSp = "QZonlinetimeLastRecord";
  private long mLastReportTime = 0L;
  private Runnable mOnlineTimeCheckTraceRunnable = new QzoneOnlineTimeCollectRptService.3(this);
  private mobile_online_report_item mRecord;
  private ArrayList<mobile_online_report_item> mReportItems = new ArrayList();
  long mUin = 0L;
  
  private void checkToReport()
  {
    try
    {
      if (isNeedToReport())
      {
        if (this.mBackupItems.size() > 0) {
          this.mBackupItems.clear();
        }
        this.mBackupItems.addAll(this.mReportItems);
        this.mReportItems.clear();
        if (this.mUin != 0L) {
          report(this.mBackupItems);
        }
      }
      return;
    }
    finally {}
  }
  
  public static final QzoneOnlineTimeCollectRptService getInstance()
  {
    if (mInstance == null) {
      mInstance = new QzoneOnlineTimeCollectRptService();
    }
    return mInstance;
  }
  
  private void initData()
  {
    long l1 = this.mUin;
    if (l1 == 0L) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.mKeyOnlineSp);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(l1);
    Object localObject2 = LocalMultiProcConfig.getString(((StringBuilder)localObject1).toString(), "");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.mKeyOnlineUpdateSp);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(l1);
    Object localObject3 = LocalMultiProcConfig.getString(((StringBuilder)localObject1).toString(), "");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("key_sp_qzone_crash_time_");
    ((StringBuilder)localObject1).append(l1);
    long l2 = LocalMultiProcConfig.getLong(((StringBuilder)localObject1).toString(), 0L);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("sp:");
    ((StringBuilder)localObject1).append(this.mKeyOnlineSp);
    ((StringBuilder)localObject1).append(" lost time:");
    ((StringBuilder)localObject1).append((String)localObject3);
    ((StringBuilder)localObject1).append(" sp:");
    ((StringBuilder)localObject1).append(this.mKeyOnlineUpdateSp);
    ((StringBuilder)localObject1).append(" crash time:");
    ((StringBuilder)localObject1).append(l2);
    QLog.d("QzoneOnlineTimeCollectRptService", 1, ((StringBuilder)localObject1).toString());
    localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject1 = localObject3;
      if (l2 != 0L)
      {
        localObject1 = localObject3;
        if (this.mKeyOnlineSp.equals("QZonlinetime"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((String)localObject3).substring(0, ((String)localObject3).lastIndexOf(";")));
          ((StringBuilder)localObject1).append(";");
          ((StringBuilder)localObject1).append(l2);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(";");
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject3).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.mKeyOnlineSp);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(l1);
      LocalMultiProcConfig.putString(((StringBuilder)localObject2).toString(), (String)localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.mKeyOnlineUpdateSp);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(l1);
      LocalMultiProcConfig.putString(((StringBuilder)localObject2).toString(), "");
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("key_sp_qzone_crash_time_");
    ((StringBuilder)localObject2).append(l1);
    LocalMultiProcConfig.putLong(((StringBuilder)localObject2).toString(), 0L);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("s:");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d("QzoneOnlineTimeCollectRptService", 1, ((StringBuilder)localObject2).toString());
    localObject1 = ((String)localObject1).split(";");
    if (localObject1 != null)
    {
      if (localObject1.length <= 1) {
        return;
      }
      int i = 0;
      try
      {
        while (i < localObject1.length)
        {
          localObject2 = new mobile_online_report_item(l1, Long.parseLong(localObject1[i]), Long.parseLong(localObject1[(i + 1)]));
          this.mReportItems.add(localObject2);
          i += 2;
        }
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("e:");
        ((StringBuilder)localObject2).append(localException.toString());
        QLog.e("QzoneOnlineTimeCollectRptService", 1, ((StringBuilder)localObject2).toString());
      }
      if ((this.mReportItems.size() >= 1) && (this.mReportItems.get(0) != null)) {
        this.mLastReportTime = ((mobile_online_report_item)this.mReportItems.get(0)).uptime;
      }
      checkToReport();
    }
  }
  
  private boolean isNeedToReport()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    long l = this.mLastReportTime;
    boolean bool2 = false;
    boolean bool1 = false;
    if (l != 0L)
    {
      if ((System.currentTimeMillis() / 1000L - this.mLastReportTime > localQzoneConfig.getConfig("ClientReport", "OnlineReportInterval", 3600)) || (this.mReportItems.size() >= localQzoneConfig.getConfig("ClientReport", "OnlineReportFrequency", 1))) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.mReportItems.size() >= localQzoneConfig.getConfig("ClientReport", "OnlineReportFrequency", 1)) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void report(ArrayList<mobile_online_report_item> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.mLastReportTime = System.currentTimeMillis();
      paramArrayList = new ArrayList(paramArrayList);
      ((IQzoneReq)QRoute.api(IQzoneReq.class)).sentOnlineTimeServlet(paramArrayList);
      return;
    }
    QLog.e("QzoneOnlineTimeCollectRptService", 1, "There is no record to report!");
  }
  
  private void saveData()
  {
    Object localObject1 = this.mReportItems;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
    {
      localObject1 = new StringBuilder();
      Object localObject2 = this.mReportItems.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        mobile_online_report_item localmobile_online_report_item = (mobile_online_report_item)((Iterator)localObject2).next();
        if (localmobile_online_report_item != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localmobile_online_report_item.uptime);
          localStringBuilder.append(";");
          localStringBuilder.append(localmobile_online_report_item.downtime);
          localStringBuilder.append(";");
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
        }
      }
      if (((StringBuilder)localObject1).length() != 0)
      {
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.mKeyOnlineSp);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(this.mUin);
        LocalMultiProcConfig.putString(((StringBuilder)localObject2).toString(), ((StringBuilder)localObject1).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("saveData mReportItems size:");
        ((StringBuilder)localObject2).append(this.mReportItems.size());
        ((StringBuilder)localObject2).append(" mLastReportTime:");
        ((StringBuilder)localObject2).append(this.mLastReportTime);
        ((StringBuilder)localObject2).append(" re:");
        ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
        QLog.d("QzoneOnlineTimeCollectRptService", 1, ((StringBuilder)localObject2).toString());
        this.mReportItems.clear();
      }
      else
      {
        QLog.w("QzoneOnlineTimeCollectRptService", 1, "re length:0");
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.mKeyOnlineUpdateSp);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(this.mUin);
    LocalMultiProcConfig.putString(((StringBuilder)localObject1).toString(), "");
  }
  
  public void addRecord(mobile_online_report_item parammobile_online_report_item)
  {
    if ((parammobile_online_report_item != null) && (parammobile_online_report_item.uptime != 0L) && (parammobile_online_report_item.downtime != 0L)) {
      this.mReportItems.add(parammobile_online_report_item);
    }
    checkToReport();
  }
  
  public void beginRecord()
  {
    try
    {
      if (this.mRecord == null)
      {
        this.mRecord = new mobile_online_report_item();
      }
      else
      {
        this.mRecord.downtime = 0L;
        this.mRecord.loginuin = 0L;
        this.mRecord.uptime = 0L;
      }
      this.mRecord.uptime = (System.currentTimeMillis() / 1000L);
      return;
    }
    finally {}
  }
  
  public void beginTrace(int paramInt)
  {
    setType(paramInt);
    ThreadManager.getSubThreadHandler().post(new QzoneOnlineTimeCollectRptService.1(this));
  }
  
  public void closeRecord()
  {
    try
    {
      if (this.mRecord != null)
      {
        this.mRecord.downtime = (System.currentTimeMillis() / 1000L);
        this.mRecord.loginuin = this.mUin;
        addRecord(this.mRecord);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void closeTrace()
  {
    ThreadManager.getSubThreadHandler().post(new QzoneOnlineTimeCollectRptService.2(this));
  }
  
  public boolean isForeground()
  {
    return this.isForeground;
  }
  
  public void onTaskResponse(int paramInt)
  {
    Object localObject;
    if (paramInt != 1000)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QzoneOnlineTimeCollectRptService report failure resultCode:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" RetryTimes:");
      ((StringBuilder)localObject).append(this.RetryTimes);
      QLog.w("QzoneOnlineTimeCollectRptService", 1, ((StringBuilder)localObject).toString());
      if (this.RetryTimes < 2)
      {
        report(this.mBackupItems);
        this.RetryTimes += 1;
      }
    }
    else
    {
      QLog.d("QzoneOnlineTimeCollectRptService", 1, "QzoneOnlineTimeCollectRptService task succeed!");
      paramInt = 0;
      this.RetryTimes = 0;
      localObject = this.mBackupItems;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        while (paramInt < this.mBackupItems.size())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sp:");
          ((StringBuilder)localObject).append(this.mKeyOnlineSp);
          ((StringBuilder)localObject).append(" report uptime:");
          ((StringBuilder)localObject).append(((mobile_online_report_item)this.mBackupItems.get(paramInt)).uptime);
          ((StringBuilder)localObject).append(" downtime:");
          ((StringBuilder)localObject).append(((mobile_online_report_item)this.mBackupItems.get(paramInt)).downtime);
          QLog.d("QzoneOnlineTimeCollectRptService", 1, ((StringBuilder)localObject).toString());
          paramInt += 1;
        }
        this.mBackupItems.clear();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mKeyOnlineSp);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.mUin);
      LocalMultiProcConfig.putString(((StringBuilder)localObject).toString(), "");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mKeyOnlineUpdateSp);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.mUin);
      LocalMultiProcConfig.putString(((StringBuilder)localObject).toString(), "");
    }
  }
  
  public void setType(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          this.mKeyOnlineSp = "QZonlinetime_video";
          this.mKeyOnlineUpdateSp = "QZonlinetimeLastRecord_video";
          return;
        }
        this.mKeyOnlineSp = "QZonlinetime_picture";
        this.mKeyOnlineUpdateSp = "QZonlinetimeLastRecord_picture";
        return;
      }
      this.mKeyOnlineSp = "QZonlinetime_web";
      this.mKeyOnlineUpdateSp = "QZonlinetimeLastRecord_web";
      return;
    }
    this.mKeyOnlineSp = "QZonlinetime";
    this.mKeyOnlineUpdateSp = "QZonlinetimeLastRecord";
  }
  
  public void updateRecord()
  {
    Object localObject = this.mRecord;
    if (localObject != null)
    {
      if (((mobile_online_report_item)localObject).uptime > 0L)
      {
        this.mRecord.downtime = (System.currentTimeMillis() / 1000L);
        if (this.mRecord.uptime == this.mRecord.downtime)
        {
          localObject = this.mRecord;
          ((mobile_online_report_item)localObject).downtime += 1L;
        }
      }
      else
      {
        this.mRecord.uptime = (System.currentTimeMillis() / 1000L);
        localObject = this.mRecord;
        ((mobile_online_report_item)localObject).downtime = (((mobile_online_report_item)localObject).uptime + 1L);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update sp:");
        ((StringBuilder)localObject).append(this.mKeyOnlineUpdateSp);
        ((StringBuilder)localObject).append(" last time:");
        ((StringBuilder)localObject).append(this.mRecord.downtime);
        QLog.d("QzoneOnlineTimeCollectRptService", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mKeyOnlineUpdateSp);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.mUin);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mRecord.uptime);
      localStringBuilder.append(";");
      localStringBuilder.append(this.mRecord.downtime);
      LocalMultiProcConfig.putString((String)localObject, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.QzoneOnlineTimeCollectRptService
 * JD-Core Version:    0.7.0.1
 */