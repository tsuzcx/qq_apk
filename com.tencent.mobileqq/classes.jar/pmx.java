import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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

public class pmx
  extends qhj
  implements bdlc
{
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(new Random().nextInt(10000));
  
  public pmx()
  {
    super(null, null, null, qxn.a(), null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    paramToServiceMsg.extraData.putInt("request_req", paramInt1);
    paramToServiceMsg.extraData.putInt("request_retry_time", paramInt2);
    paramToServiceMsg.extraData.putByteArray("request_report_datas", paramArrayOfByte);
    paramToServiceMsg.setTimeout(30000L);
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    oidb_cmd0xe13.ReqBody localReqBody = new oidb_cmd0xe13.ReqBody();
    long l = NetConnInfoCenter.getServerTimeMillis();
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      oidb_cmd0xe13.ReportInfo localReportInfo = new oidb_cmd0xe13.ReportInfo();
      localReportInfo.uint64_time.set(l);
      localReportInfo.bytes_report.set(ByteStringMicro.copyFromUtf8(str));
      localReqBody.msg_report_info.add(localReportInfo);
    }
    localReqBody.uint32_seq.set(i);
    localObject = qxp.a("OidbSvc.0xe13", 3603, 0, localReqBody.toByteArray());
    a((ToServiceMsg)localObject, i, 0, localReqBody.toByteArray());
    a((ToServiceMsg)localObject);
    QLog.d("RIJNewReporter", 1, "send report data to servlet, size : " + paramArrayList.size() + ", seq : " + i + ", contents : " + paramArrayList);
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
    if ((paramReporting == null) || (TextUtils.isEmpty(paramReporting.mDetail))) {}
    do
    {
      return;
      String str = paramReporting.mDetail.replace("${count_unknown}", String.valueOf(paramReporting.mCount));
      paramReporting = str;
      if (str.startsWith("${report_seq_prefix}")) {
        paramReporting = str.substring(str.indexOf("|") + 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RIJNewReporter", 2, "report data : " + paramReporting);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramReporting);
    } while (this.jdField_a_of_type_JavaUtilArrayList.size() < 20);
    a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("request_req");
    int j = paramToServiceMsg.extraData.getInt("request_retry_time");
    QLog.d("RIJNewReporter", 1, "receive servlet oxe13 resp ! seq : " + i + ", retryTime : " + j);
    oidb_cmd0xe13.RspBody localRspBody = new oidb_cmd0xe13.RspBody();
    int k = qxp.a(paramFromServiceMsg, paramObject, localRspBody);
    if (k == 0)
    {
      QLog.d("RIJNewReporter", 1, "receive servlet oxe13 resp success !  businessCode : " + localRspBody.uint32_result.get());
      return;
    }
    if (j < 2)
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("request_report_datas");
      paramFromServiceMsg = qxp.a("OidbSvc.0xe13", 3603, 0, paramToServiceMsg);
      a(paramFromServiceMsg, i, j + 1, paramToServiceMsg);
      a(paramFromServiceMsg);
      QLog.d("RIJNewReporter", 1, "receive servlet oxe13 resp error ! code : " + k + ", toRertry ：" + true);
      return;
    }
    QLog.d("RIJNewReporter", 1, "receive servlet oxe13 resp error ! code : " + k + ", toRertry ：" + false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmx
 * JD-Core Version:    0.7.0.1
 */