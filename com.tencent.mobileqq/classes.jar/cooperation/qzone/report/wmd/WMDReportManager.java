package cooperation.qzone.report.wmd;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.QZoneCommonServlet;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic.WMDConfig;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneCommonRequest;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class WMDReportManager
  implements BusinessObserver
{
  private static final int DEAFULT_REPORT_TIME_INTERNAL = 30;
  private static final int DEFAULT_REPORT_BATCH_NUM = 20;
  private static final String REPORT_BATCH_NUM = "reportBatchNum";
  private static final String REPORT_TIME_INTERNAL = "reportTimeInternal";
  private static final String TAG = "WMDReportManager";
  private static WMDReportManager reportManager;
  private long lastReportTime = 0L;
  private int reportBatchNum;
  private String reportId;
  private long reportTimeInternal;
  private ArrayList<String> storedMsgs = new ArrayList();
  
  public WMDReportManager()
  {
    QZoneUnreadServletLogic.WMDConfig localWMDConfig = new QZoneUnreadServletLogic.WMDConfig();
    localWMDConfig.a();
    this.reportTimeInternal = (localWMDConfig.d * 1000);
    this.reportBatchNum = localWMDConfig.c;
    this.reportId = localWMDConfig.a;
  }
  
  public static WMDReportManager getInstance()
  {
    if (reportManager == null) {}
    try
    {
      if (reportManager == null) {
        reportManager = new WMDReportManager();
      }
      return reportManager;
    }
    finally {}
  }
  
  private boolean meetReportCondition()
  {
    if ((this.storedMsgs != null) && (this.storedMsgs.size() >= this.reportBatchNum)) {}
    while (System.currentTimeMillis() - this.lastReportTime > this.reportTimeInternal) {
      return true;
    }
    return false;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("key_response_code");
      String str = paramBundle.getString("key_response_msg");
      if (QLog.isColorLevel()) {
        QLog.i("WMDReportManager", 2, String.format("type :%d, success:%b, code:%d, msg:%s, bundle:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(i), str, paramBundle.toString() }));
      }
      return;
    }
    QLog.e("WMDReportManager", 1, "onReceive bundle is null");
  }
  
  public void report(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("WMDReportManager", 1, "action is null");
    }
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(this.reportId))
      {
        QLog.e("WMDReportManager", 1, "reportId is null");
        return;
      }
      if (this.lastReportTime == 0L) {
        this.lastReportTime = System.currentTimeMillis();
      }
      synchronized (this.storedMsgs)
      {
        this.storedMsgs.add(paramString);
        if (!meetReportCondition()) {
          continue;
        }
        reportImediately();
        return;
      }
    }
  }
  
  public void reportImediately()
  {
    if (this.storedMsgs.isEmpty()) {
      return;
    }
    synchronized (this.storedMsgs)
    {
      Object localObject2 = (ArrayList)this.storedMsgs.clone();
      this.storedMsgs.clear();
      this.lastReportTime = System.currentTimeMillis();
      ??? = new WMDReportReq(this.reportId, (ArrayList)localObject2, null);
      localObject2 = new QzoneCommonIntent(BaseApplicationImpl.getContext(), QZoneCommonServlet.class);
      ((QzoneCommonIntent)localObject2).setRequest((QZoneCommonRequest)???);
      ((QzoneCommonIntent)localObject2).setObserver(this);
      BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.report.wmd.WMDReportManager
 * JD-Core Version:    0.7.0.1
 */