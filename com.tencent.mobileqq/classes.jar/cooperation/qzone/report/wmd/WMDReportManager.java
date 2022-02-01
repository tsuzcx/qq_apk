package cooperation.qzone.report.wmd;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.QZoneCommonServlet;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.wmd.IWMDReport;
import cooperation.qzone.QZoneCommonRequest;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
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
    ((IWMDReport)QRoute.api(IWMDReport.class)).loadConfig();
    this.reportTimeInternal = (((IWMDReport)QRoute.api(IWMDReport.class)).getReportTime() * 1000);
    this.reportBatchNum = ((IWMDReport)QRoute.api(IWMDReport.class)).getReportCount();
    this.reportId = ((IWMDReport)QRoute.api(IWMDReport.class)).getReportId();
  }
  
  public static WMDReportManager getInstance()
  {
    if (reportManager == null) {
      try
      {
        if (reportManager == null) {
          reportManager = new WMDReportManager();
        }
      }
      finally {}
    }
    return reportManager;
  }
  
  private boolean meetReportCondition()
  {
    ArrayList localArrayList = this.storedMsgs;
    if ((localArrayList != null) && (localArrayList.size() >= this.reportBatchNum)) {
      return true;
    }
    return System.currentTimeMillis() - this.lastReportTime > this.reportTimeInternal;
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
    }
    else
    {
      QLog.e("WMDReportManager", 1, "onReceive bundle is null");
    }
  }
  
  public void report(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("WMDReportManager", 1, "action is null");
      return;
    }
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
      if (meetReportCondition()) {
        reportImediately();
      }
      return;
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
      localObject2 = new WMDReportReq(this.reportId, (ArrayList)localObject2, null);
      ??? = new QzoneCommonIntent(MobileQQ.getContext(), QZoneCommonServlet.class);
      ((QzoneCommonIntent)???).setRequest((QZoneCommonRequest)localObject2);
      ((QzoneCommonIntent)???).setObserver(this);
      localObject2 = MobileQQ.sMobileQQ.peekAppRuntime();
      if (localObject2 != null) {
        ((AppRuntime)localObject2).startServlet((NewIntent)???);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.wmd.WMDReportManager
 * JD-Core Version:    0.7.0.1
 */