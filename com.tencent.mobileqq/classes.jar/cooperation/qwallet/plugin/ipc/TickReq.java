package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class TickReq
  extends BaseReq
{
  public static final int TICK_TYPE_EXIT_QWALLET_TIME = 4;
  public static final int TICK_TYPE_PUBACC = 3;
  public static final int TICK_TYPE_QWALLET_ONRESUME = 7;
  public static final int TICK_TYPE_QWALLET_REPORT_REDPOINT_SHOW = 8;
  public static final int TICK_TYPE_REDPOINT = 2;
  public static final int TICK_TYPE_REPORT = 1;
  public static final int TICK_TYPE_REPORT_DC = 6;
  public static final int TICK_TYPE_SET_BASE_ACTIVITY_UNLOCK_SUCCESS = 5;
  public String dcDetail;
  public String dcId;
  public boolean dcIsMerge;
  public long exitQWalletTime;
  public String pubAccUin;
  public String redpointPath;
  public ArrayList<String> reportContents;
  public int tickType;
  
  private void onRedpoint()
  {
    try
    {
      Object localObject = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getRuntime();
      if (localObject != null)
      {
        localObject = (IRedTouchManager)((AppRuntime)localObject).getRuntimeService(IRedTouchManager.class, "");
        ((IRedTouchManager)localObject).onRedTouchItemClick(this.redpointPath);
        if ((this.redpointPath != null) && (this.redpointPath.equals("100007.102000")))
        {
          if (((IRedTouchManager)localObject).getNumRedPathListByAppId(100007) == null) {
            return;
          }
          ((IRedTouchManager)localObject).onReportNumRedPoint(100007, this.redpointPath);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRedpoint:");
        localStringBuilder.append(localException.getMessage());
        QLog.d("Q.qwallet.pay.dc", 4, localStringBuilder.toString());
      }
    }
  }
  
  private void onReport()
  {
    if (this.reportContents != null)
    {
      int i = 0;
      while (i < this.reportContents.size())
      {
        Object localObject1 = (String)this.reportContents.get(i);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          Object localObject2 = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getRuntime();
          if (localObject2 != null) {
            StatisticCollector.getInstance(BaseApplication.getContext()).reportToPCliOper((AppRuntime)localObject2, (String)localObject1);
          } else {
            try
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append("|s");
              localObject1 = ((StringBuilder)localObject2).toString().split("\\|");
              if (localObject1.length < 12) {
                return;
              }
              ReportController.b(null, "P_CliOper", localObject1[0], localObject1[2], localObject1[3], localObject1[4], Integer.valueOf(localObject1[5]).intValue(), Integer.valueOf(localObject1[7]).intValue(), localObject1[8], localObject1[9], localObject1[10], localObject1[11]);
            }
            catch (Exception localException)
            {
              if (QLog.isDevelopLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("com.qwallet.QWalletUtils reportClickError:");
                ((StringBuilder)localObject2).append(localException.getMessage());
                QLog.d("reportClickEvent", 4, ((StringBuilder)localObject2).toString());
              }
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private void onReportRedpointShow()
  {
    try
    {
      Object localObject1 = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getRuntime();
      if (localObject1 != null)
      {
        localObject1 = (IRedTouchManager)((AppRuntime)localObject1).getRuntimeService(IRedTouchManager.class, "");
        localObject2 = ((IRedTouchManager)localObject1).getAppInfoByPath(this.redpointPath);
        if (localObject2 != null)
        {
          ((IRedTouchManager)localObject1).onRedTouchItemExposure((BusinessInfoCheckUpdate.AppInfo)localObject2, "");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onRedpoint:");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.d("Q.qwallet.pay.dc", 4, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.tickType = paramBundle.getInt("_qwallet_ipc_TickReq_tickType");
    this.reportContents = paramBundle.getStringArrayList("_qwallet_ipc_TickReq_reportContents");
    this.redpointPath = paramBundle.getString("_qwallet_ipc_TickReq_redpointPath");
    this.pubAccUin = paramBundle.getString("_qwallet_ipc_TickReq_pubAccUin");
    this.exitQWalletTime = paramBundle.getLong("_qwallet_ipc_TickReq_exitQWalletTime");
    this.dcId = paramBundle.getString("_qwallet_ipc_TickReq_dcId");
    this.dcDetail = paramBundle.getString("_qwallet_ipc_TickReq_dcDetail");
    this.dcIsMerge = paramBundle.getBoolean("_qwallet_ipc_TickReq_dcIsMerge", true);
  }
  
  public void onReceive()
  {
    switch (this.tickType)
    {
    default: 
      return;
    case 8: 
      onReportRedpointShow();
      return;
    case 7: 
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).resetLaunchTime();
      return;
    case 6: 
      onReportDc();
      return;
    case 5: 
      ((IQWalletApiProxy)QRoute.api(IQWalletApiProxy.class)).onSetBaseActivityUnlockSuceess();
      return;
    case 4: 
      ((IQWalletApiProxy)QRoute.api(IQWalletApiProxy.class)).setLastExitWalletTime(this.exitQWalletTime, this);
      return;
    case 3: 
      ((IQWalletApiProxy)QRoute.api(IQWalletApiProxy.class)).onPubAcc(this.pubAccUin);
      return;
    case 2: 
      onRedpoint();
      return;
    }
    onReport();
  }
  
  public void onReportDc()
  {
    if (!TextUtils.isEmpty(this.dcId))
    {
      if (TextUtils.isEmpty(this.dcDetail)) {
        return;
      }
      DcReportUtil.a(null, this.dcId, this.dcDetail, this.dcIsMerge);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.dcId);
        localStringBuilder.append('|');
        localStringBuilder.append(this.dcDetail);
        localStringBuilder.append('|');
        localStringBuilder.append(this.dcIsMerge);
        QLog.i("Q.qwallet.pay.dc", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putInt("_qwallet_ipc_TickReq_tickType", this.tickType);
    paramBundle.putStringArrayList("_qwallet_ipc_TickReq_reportContents", this.reportContents);
    paramBundle.putString("_qwallet_ipc_TickReq_redpointPath", this.redpointPath);
    paramBundle.putString("_qwallet_ipc_TickReq_pubAccUin", this.pubAccUin);
    paramBundle.putLong("_qwallet_ipc_TickReq_exitQWalletTime", this.exitQWalletTime);
    paramBundle.putString("_qwallet_ipc_TickReq_dcId", this.dcId);
    paramBundle.putString("_qwallet_ipc_TickReq_dcDetail", this.dcDetail);
    paramBundle.putBoolean("_qwallet_ipc_TickReq_dcIsMerge", this.dcIsMerge);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.TickReq
 * JD-Core Version:    0.7.0.1
 */