package com.tencent.mobileqq.kandian.repo.report;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController.BusinessDataReporter;
import com.tencent.mobileqq.statistics.Reporting;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.cmd0xe13.oidb_cmd0xe13.ReportInfo;
import tencent.im.oidb.cmd0xe13.oidb_cmd0xe13.ReqBody;
import tencent.im.oidb.cmd0xe13.oidb_cmd0xe13.RspBody;

public class RIJNewReporter
  extends ReadInJoyEngineModule
  implements ReportController.BusinessDataReporter
{
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(new Random().nextInt(10000));
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    paramToServiceMsg.extraData.putInt("request_req", paramInt1);
    paramToServiceMsg.extraData.putInt("request_retry_time", paramInt2);
    paramToServiceMsg.extraData.putByteArray("request_report_datas", paramArrayOfByte);
    paramToServiceMsg.setTimeout(30000L);
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    Object localObject1 = new oidb_cmd0xe13.ReqBody();
    long l = NetConnInfoCenter.getServerTimeMillis();
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    Object localObject2 = paramArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      oidb_cmd0xe13.ReportInfo localReportInfo = new oidb_cmd0xe13.ReportInfo();
      localReportInfo.uint64_time.set(l);
      localReportInfo.bytes_report.set(ByteStringMicro.copyFromUtf8(str));
      ((oidb_cmd0xe13.ReqBody)localObject1).msg_report_info.add(localReportInfo);
    }
    ((oidb_cmd0xe13.ReqBody)localObject1).uint32_seq.set(i);
    localObject2 = ((IReadInJoyOidbHelper)QRoute.api(IReadInJoyOidbHelper.class)).makeOIDBPkg("OidbSvc.0xe13", 3603, 0, ((oidb_cmd0xe13.ReqBody)localObject1).toByteArray());
    a((ToServiceMsg)localObject2, i, 0, ((oidb_cmd0xe13.ReqBody)localObject1).toByteArray());
    sendPbReq((ToServiceMsg)localObject2);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("send report data to servlet, size : ");
    ((StringBuilder)localObject1).append(paramArrayList.size());
    ((StringBuilder)localObject1).append(", seq : ");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(", contents : ");
    ((StringBuilder)localObject1).append(paramArrayList);
    QLog.d("RIJNewReporter", 1, ((StringBuilder)localObject1).toString());
  }
  
  public void a()
  {
    QLog.d("RIJNewReporter", 1, "notifyCurrentReportLoopFinish");
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(Reporting paramReporting)
  {
    if (paramReporting != null)
    {
      if (TextUtils.isEmpty(paramReporting.mDetail)) {
        return;
      }
      Object localObject = paramReporting.mDetail.replace("${count_unknown}", String.valueOf(paramReporting.mCount));
      paramReporting = (Reporting)localObject;
      if (((String)localObject).startsWith("${report_seq_prefix}")) {
        paramReporting = ((String)localObject).substring(((String)localObject).indexOf("|") + 1);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report data : ");
        ((StringBuilder)localObject).append(paramReporting);
        QLog.d("RIJNewReporter", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramReporting);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 20)
      {
        a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("request_req");
    int j = paramToServiceMsg.extraData.getInt("request_retry_time");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receive servlet oxe13 resp ! seq : ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", retryTime : ");
    ((StringBuilder)localObject).append(j);
    QLog.d("RIJNewReporter", 1, ((StringBuilder)localObject).toString());
    localObject = new oidb_cmd0xe13.RspBody();
    int k = ((IReadInJoyOidbHelper)QRoute.api(IReadInJoyOidbHelper.class)).parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    if (k == 0)
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("receive servlet oxe13 resp success !  businessCode : ");
      paramToServiceMsg.append(((oidb_cmd0xe13.RspBody)localObject).uint32_result.get());
      QLog.d("RIJNewReporter", 1, paramToServiceMsg.toString());
      return;
    }
    if (j < 2)
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("request_report_datas");
      paramFromServiceMsg = ((IReadInJoyOidbHelper)QRoute.api(IReadInJoyOidbHelper.class)).makeOIDBPkg("OidbSvc.0xe13", 3603, 0, paramToServiceMsg);
      a(paramFromServiceMsg, i, j + 1, paramToServiceMsg);
      sendPbReq(paramFromServiceMsg);
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("receive servlet oxe13 resp error ! code : ");
      paramToServiceMsg.append(k);
      paramToServiceMsg.append(", toRertry ：");
      paramToServiceMsg.append(true);
      QLog.d("RIJNewReporter", 1, paramToServiceMsg.toString());
      return;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("receive servlet oxe13 resp error ! code : ");
    paramToServiceMsg.append(k);
    paramToServiceMsg.append(", toRertry ：");
    paramToServiceMsg.append(false);
    QLog.d("RIJNewReporter", 1, paramToServiceMsg.toString());
  }
  
  public void unInitialize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.RIJNewReporter
 * JD-Core Version:    0.7.0.1
 */