package cooperation.qqcircle.report.requests;

import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleBase.StAppInfo;
import qqcircle.QQCircleBase.StNetworkInfo;
import qqcircle.QQCircleReport.StHeartbeatSignalReq;
import qqcircle.QQCircleReport.StHeartbeatSignalRsp;

public class QCircleHeartbeatSignalReportRequest
  extends QCircleBaseRequest
{
  private QQCircleReport.StHeartbeatSignalReq mReq = new QQCircleReport.StHeartbeatSignalReq();
  
  public QCircleHeartbeatSignalReportRequest(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    this.mReq.uin.set(QCircleHostStubUtil.getCurrentAccountLongUin());
    this.mReq.interval_time_ms.set(paramLong);
    this.mReq.sig_optype.set(paramInt);
    Object localObject = new QQCircleBase.StAppInfo();
    ((QQCircleBase.StAppInfo)localObject).app_version.set(((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getReportVersionName());
    ((QQCircleBase.StAppInfo)localObject).qua.set(QUA.getQUA3());
    ((QQCircleBase.StAppInfo)localObject).platform.set("android");
    this.mReq.app_info.set((MessageMicro)localObject);
    localObject = new QQCircleBase.StNetworkInfo();
    ((QQCircleBase.StNetworkInfo)localObject).network_type.set(QCircleReportHelper.getNetworkType());
    this.mReq.network_info.set((MessageMicro)localObject);
    localObject = new ArrayList();
    if (paramArrayOfByte != null) {
      ((ArrayList)localObject).add(QCircleReportHelper.newEntry("SessionID", paramArrayOfByte));
    }
    this.mReq.byteExtinfo.set((List)localObject);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleReport.StHeartbeatSignalRsp localStHeartbeatSignalRsp = new QQCircleReport.StHeartbeatSignalRsp();
    try
    {
      localStHeartbeatSignalRsp.mergeFrom(paramArrayOfByte);
      return localStHeartbeatSignalRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStHeartbeatSignalRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.circlereport.clientreport.ClientReport.HeartbeatSignal";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.requests.QCircleHeartbeatSignalReportRequest
 * JD-Core Version:    0.7.0.1
 */