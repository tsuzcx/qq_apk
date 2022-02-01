package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import bbbq;
import bdka;
import bdla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.qwallet.plugin.QWalletHelper;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import uuc;

public class TickReq
  extends BaseReq
{
  public static final int TICK_TYPE_EXIT_QWALLET_TIME = 4;
  public static final int TICK_TYPE_PUBACC = 3;
  public static final int TICK_TYPE_QWALLET_ONRESUME = 7;
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
  
  private void onPubAcc()
  {
    QQAppInterface localQQAppInterface = QWalletHelper.getAppInterface();
    if ((localQQAppInterface != null) && (!TextUtils.isEmpty(this.pubAccUin))) {
      uuc.a(localQQAppInterface, localQQAppInterface.getApp(), this.pubAccUin, null, false);
    }
  }
  
  private void onRedpoint()
  {
    Object localObject = QWalletHelper.getAppInterface();
    if (localObject != null)
    {
      localObject = (bbbq)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_RED_TOUCH);
      ((bbbq)localObject).b(this.redpointPath);
      if ((this.redpointPath != null) && (this.redpointPath.equals("100007.102000")) && (((bbbq)localObject).a(100007) != null)) {}
    }
    else
    {
      return;
    }
    ((bbbq)localObject).a(100007, this.redpointPath);
  }
  
  private void onReport()
  {
    if (this.reportContents != null)
    {
      int i = 0;
      if (i < this.reportContents.size())
      {
        Object localObject = (String)this.reportContents.get(i);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (;;)
        {
          i += 1;
          break;
          if (QWalletHelper.getAppInterface() != null)
          {
            StatisticCollector.getInstance(BaseApplication.getContext()).reportToPCliOper(QWalletHelper.getAppInterface(), (String)localObject);
          }
          else
          {
            try
            {
              localObject = ((String)localObject + "|s").split("\\|");
              if (localObject.length < 12) {
                return;
              }
              bdla.b(null, "P_CliOper", localObject[0], localObject[2], localObject[3], localObject[4], Integer.valueOf(localObject[5]).intValue(), Integer.valueOf(localObject[7]).intValue(), localObject[8], localObject[9], localObject[10], localObject[11]);
            }
            catch (Exception localException) {}
            if (QLog.isDevelopLevel()) {
              QLog.d("reportClickEvent", 4, "com.qwallet.QWalletUtils reportClickError:" + localException.getMessage());
            }
          }
        }
      }
    }
  }
  
  private void onSetBaseActivityUnlockSuceess()
  {
    com.tencent.mobileqq.app.BaseActivity.isUnLockSuccess = true;
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
    case 1: 
      onReport();
      return;
    case 2: 
      onRedpoint();
      return;
    case 3: 
      onPubAcc();
      return;
    case 4: 
      try
      {
        PatternLockUtils.setLastExitWalletTime(BaseApplicationImpl.getContext().getApplicationContext(), BaseApplicationImpl.sApplication.getRuntime().getLongAccountUin() + "", this.exitQWalletTime);
        return;
      }
      catch (Throwable localThrowable)
      {
        return;
      }
    case 5: 
      onSetBaseActivityUnlockSuceess();
      return;
    case 6: 
      onReportDc();
      return;
    }
    QWalletHelper.resetLaunchTime();
  }
  
  public void onReportDc()
  {
    if ((TextUtils.isEmpty(this.dcId)) || (TextUtils.isEmpty(this.dcDetail))) {}
    do
    {
      return;
      bdka.a(null, this.dcId, this.dcDetail, this.dcIsMerge);
    } while (!QLog.isColorLevel());
    QLog.i("Q.qwallet.pay.dc", 2, this.dcId + '|' + this.dcDetail + '|' + this.dcIsMerge);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.TickReq
 * JD-Core Version:    0.7.0.1
 */