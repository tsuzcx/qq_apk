package com.tencent.mobileqq.qqlive.api.impl.datareport;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.datareport.IBeaconAction;
import com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule;
import com.tencent.mobileqq.qqlive.api.impl.IQQLiveBaseModule;
import com.tencent.mobileqq.qqlive.data.datareport.CommonReportData;
import com.tencent.mobileqq.qqlive.data.datareport.ReportTask;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import java.util.Map;

public class BaseDataReportModule
  extends IQQLiveBaseModule
  implements IBeaconAction, IDataReportModule
{
  private volatile CommonReportData commonReportData;
  private final long enterRoomStamp = NetConnInfoCenter.getServerTimeMillis();
  
  private void addCommonReportData(ReportTask paramReportTask)
  {
    paramReportTask.addKeyValue("appid", this.commonReportData.getAppId()).addKeyValue("commid", this.commonReportData.getCommid()).addKeyValue("roomid", this.commonReportData.getRoomId()).addKeyValue("programid", this.commonReportData.getProgramId()).addKeyValue("uid", this.commonReportData.getUid()).addKeyValue("testid", this.commonReportData.getTestId()).addKeyValue("expgrpid", this.commonReportData.getExpgrpid()).addKeyValue("devtype", this.commonReportData.getReportDevType());
  }
  
  public void destroy() {}
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    super.init(paramIQQLiveSDK);
    this.commonReportData = new CommonReportData(paramIQQLiveSDK.getAppId());
    this.commonReportData.setEnterRoomTime(this.enterRoomStamp);
    QQBeaconReport.a();
  }
  
  public ReportTask newReportTask()
  {
    ReportTaskImpl localReportTaskImpl = new ReportTaskImpl();
    addCommonReportData(localReportTaskImpl);
    localReportTaskImpl.setDataReportModule(this);
    return localReportTaskImpl;
  }
  
  public void reportEvent(@NonNull String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QQBeaconReport.b("0DOU0MNDZE4ME6PH", paramString);
    }
  }
  
  public void reportEvent(@NonNull String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QQBeaconReport.a("0DOU0MNDZE4ME6PH", "", paramString, true, paramMap, paramBoolean);
    }
  }
  
  public void reset() {}
  
  public void setLoginInfo(LoginInfo paramLoginInfo)
  {
    this.commonReportData.setLoginInfo(paramLoginInfo);
  }
  
  public void setRoomInfo(BaseRoomInfo paramBaseRoomInfo)
  {
    this.commonReportData.setRoomInfo(paramBaseRoomInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.datareport.BaseDataReportModule
 * JD-Core Version:    0.7.0.1
 */