package cooperation.qzone.report;

import NS_MOBILE_FEEDS.mobile_online_report_item;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
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
  QQAppInterface app;
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
    if (this.mUin == 0L) {
      return;
    }
    long l1 = this.mUin;
    String str = LocalMultiProcConfig.getString(this.mKeyOnlineSp + "_" + l1, "");
    Object localObject2 = LocalMultiProcConfig.getString(this.mKeyOnlineUpdateSp + "_" + l1, "");
    long l2 = LocalMultiProcConfig.getLong("key_sp_qzone_crash_time_" + l1, 0L);
    QLog.d("QzoneOnlineTimeCollectRptService", 1, "sp:" + this.mKeyOnlineSp + " lost time:" + (String)localObject2 + " sp:" + this.mKeyOnlineUpdateSp + " crash time:" + l2);
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (l2 != 0L)
      {
        localObject1 = localObject2;
        if (this.mKeyOnlineSp.equals("QZonlinetime")) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf(";")) + ";" + l2;
        }
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(str)) {
        localObject2 = str + ";" + (String)localObject1;
      }
      LocalMultiProcConfig.putString(this.mKeyOnlineSp + "_" + l1, (String)localObject2);
      LocalMultiProcConfig.putString(this.mKeyOnlineUpdateSp + "_" + l1, "");
    }
    for (;;)
    {
      LocalMultiProcConfig.putLong("key_sp_qzone_crash_time_" + l1, 0L);
      QLog.d("QzoneOnlineTimeCollectRptService", 1, "s:" + (String)localObject2);
      localObject1 = ((String)localObject2).split(";");
      if ((localObject1 == null) || (localObject1.length <= 1)) {
        break;
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
        localObject2 = str;
      }
      catch (Exception localException)
      {
        QLog.e("QzoneOnlineTimeCollectRptService", 1, "e:" + localException.toString());
        if ((this.mReportItems.size() >= 1) && (this.mReportItems.get(0) != null)) {
          this.mLastReportTime = ((mobile_online_report_item)this.mReportItems.get(0)).uptime;
        }
        checkToReport();
        return;
      }
    }
  }
  
  private boolean isNeedToReport()
  {
    boolean bool1 = false;
    boolean bool2 = true;
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    if (this.mLastReportTime != 0L)
    {
      if ((System.currentTimeMillis() / 1000L - this.mLastReportTime > localQzoneConfig.getConfig("ClientReport", "OnlineReportInterval", 3600)) || (this.mReportItems.size() >= localQzoneConfig.getConfig("ClientReport", "OnlineReportFrequency", 1))) {
        bool1 = true;
      }
      return bool1;
    }
    if (this.mReportItems.size() >= localQzoneConfig.getConfig("ClientReport", "OnlineReportFrequency", 1)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  private void report(ArrayList<mobile_online_report_item> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.mLastReportTime = System.currentTimeMillis();
      paramArrayList = new ArrayList(paramArrayList);
      NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getContext(), QzoneOnlineTimeServlet.class);
      localNewIntent.putExtra("list", paramArrayList);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
      return;
    }
    QLog.e("QzoneOnlineTimeCollectRptService", 1, "There is no record to report!");
  }
  
  private void saveData()
  {
    if ((this.mReportItems != null) && (this.mReportItems.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.mReportItems.iterator();
      while (localIterator.hasNext())
      {
        mobile_online_report_item localmobile_online_report_item = (mobile_online_report_item)localIterator.next();
        if (localmobile_online_report_item != null) {
          localStringBuilder.append(localmobile_online_report_item.uptime + ";" + localmobile_online_report_item.downtime + ";");
        }
      }
      if (localStringBuilder.length() == 0) {
        break label252;
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      LocalMultiProcConfig.putString(this.mKeyOnlineSp + "_" + this.mUin, localStringBuilder.toString());
      QLog.d("QzoneOnlineTimeCollectRptService", 1, "saveData mReportItems size:" + this.mReportItems.size() + " mLastReportTime:" + this.mLastReportTime + " re:" + localStringBuilder.toString());
      this.mReportItems.clear();
    }
    for (;;)
    {
      LocalMultiProcConfig.putString(this.mKeyOnlineUpdateSp + "_" + this.mUin, "");
      return;
      label252:
      QLog.w("QzoneOnlineTimeCollectRptService", 1, "re length:0");
    }
  }
  
  public void addRecord(mobile_online_report_item parammobile_online_report_item)
  {
    if ((parammobile_online_report_item != null) && (parammobile_online_report_item.uptime != 0L) && (parammobile_online_report_item.downtime != 0L)) {
      this.mReportItems.add(parammobile_online_report_item);
    }
    checkToReport();
  }
  
  /* Error */
  public void beginRecord()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 358	cooperation/qzone/report/QzoneOnlineTimeCollectRptService:mRecord	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   6: ifnonnull +31 -> 37
    //   9: aload_0
    //   10: new 227	NS_MOBILE_FEEDS/mobile_online_report_item
    //   13: dup
    //   14: invokespecial 359	NS_MOBILE_FEEDS/mobile_online_report_item:<init>	()V
    //   17: putfield 358	cooperation/qzone/report/QzoneOnlineTimeCollectRptService:mRecord	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   20: aload_0
    //   21: getfield 358	cooperation/qzone/report/QzoneOnlineTimeCollectRptService:mRecord	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   24: invokestatic 265	java/lang/System:currentTimeMillis	()J
    //   27: ldc2_w 266
    //   30: ldiv
    //   31: putfield 252	NS_MOBILE_FEEDS/mobile_online_report_item:uptime	J
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: getfield 358	cooperation/qzone/report/QzoneOnlineTimeCollectRptService:mRecord	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   41: lconst_0
    //   42: putfield 333	NS_MOBILE_FEEDS/mobile_online_report_item:downtime	J
    //   45: aload_0
    //   46: getfield 358	cooperation/qzone/report/QzoneOnlineTimeCollectRptService:mRecord	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   49: lconst_0
    //   50: putfield 362	NS_MOBILE_FEEDS/mobile_online_report_item:loginuin	J
    //   53: aload_0
    //   54: getfield 358	cooperation/qzone/report/QzoneOnlineTimeCollectRptService:mRecord	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   57: lconst_0
    //   58: putfield 252	NS_MOBILE_FEEDS/mobile_online_report_item:uptime	J
    //   61: goto -41 -> 20
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	QzoneOnlineTimeCollectRptService
    //   64	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	64	finally
    //   20	34	64	finally
    //   37	61	64	finally
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
    if (paramInt != 1000)
    {
      QLog.w("QzoneOnlineTimeCollectRptService", 1, "QzoneOnlineTimeCollectRptService report failure resultCode:" + paramInt + " RetryTimes:" + this.RetryTimes);
      if (this.RetryTimes < 2)
      {
        report(this.mBackupItems);
        this.RetryTimes += 1;
      }
      return;
    }
    QLog.d("QzoneOnlineTimeCollectRptService", 1, "QzoneOnlineTimeCollectRptService task succeed!");
    this.RetryTimes = 0;
    if ((this.mBackupItems != null) && (this.mBackupItems.size() > 0))
    {
      paramInt = 0;
      while (paramInt < this.mBackupItems.size())
      {
        QLog.d("QzoneOnlineTimeCollectRptService", 1, "sp:" + this.mKeyOnlineSp + " report uptime:" + ((mobile_online_report_item)this.mBackupItems.get(paramInt)).uptime + " downtime:" + ((mobile_online_report_item)this.mBackupItems.get(paramInt)).downtime);
        paramInt += 1;
      }
      this.mBackupItems.clear();
    }
    LocalMultiProcConfig.putString(this.mKeyOnlineSp + "_" + this.mUin, "");
    LocalMultiProcConfig.putString(this.mKeyOnlineUpdateSp + "_" + this.mUin, "");
  }
  
  public void setType(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.mKeyOnlineSp = "QZonlinetime";
      this.mKeyOnlineUpdateSp = "QZonlinetimeLastRecord";
      return;
    case 1: 
      this.mKeyOnlineSp = "QZonlinetime_web";
      this.mKeyOnlineUpdateSp = "QZonlinetimeLastRecord_web";
      return;
    case 3: 
      this.mKeyOnlineSp = "QZonlinetime_picture";
      this.mKeyOnlineUpdateSp = "QZonlinetimeLastRecord_picture";
      return;
    }
    this.mKeyOnlineSp = "QZonlinetime_video";
    this.mKeyOnlineUpdateSp = "QZonlinetimeLastRecord_video";
  }
  
  public void updateRecord()
  {
    mobile_online_report_item localmobile_online_report_item;
    if (this.mRecord != null)
    {
      if (this.mRecord.uptime <= 0L) {
        break label185;
      }
      this.mRecord.downtime = (System.currentTimeMillis() / 1000L);
      if (this.mRecord.uptime == this.mRecord.downtime) {
        localmobile_online_report_item = this.mRecord;
      }
    }
    for (localmobile_online_report_item.downtime += 1L;; this.mRecord.downtime = (this.mRecord.uptime + 1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneOnlineTimeCollectRptService", 2, "update sp:" + this.mKeyOnlineUpdateSp + " last time:" + this.mRecord.downtime);
      }
      LocalMultiProcConfig.putString(this.mKeyOnlineUpdateSp + "_" + this.mUin, this.mRecord.uptime + ";" + this.mRecord.downtime);
      return;
      label185:
      this.mRecord.uptime = (System.currentTimeMillis() / 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.report.QzoneOnlineTimeCollectRptService
 * JD-Core Version:    0.7.0.1
 */