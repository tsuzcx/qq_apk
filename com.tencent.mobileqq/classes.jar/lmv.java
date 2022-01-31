import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;

public class lmv
  implements Runnable
{
  public lmv(ReadinjoySPEventReport paramReadinjoySPEventReport, int paramInt, List paramList) {}
  
  public void run()
  {
    for (;;)
    {
      long l2;
      try
      {
        int i = ReadinjoySPEventReport.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).size();
        if (i > ReadInJoyHelper.d(ReadInJoyUtils.a()))
        {
          l1 = i - ReadInJoyHelper.d(ReadInJoyUtils.a());
          l2 = l1 - 1L;
          if (l1 > 0L)
          {
            if (ReadinjoySPEventReport.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).size() <= 1) {
              break label301;
            }
            ReadinjoySPEventReport.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).remove(1);
            l1 = l2;
            continue;
          }
        }
        if (i == 0) {
          ReadinjoySPEventReport.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        ReadinjoySPEventReport.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)ReadinjoySPEventReport.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).get(0)).first).longValue()), Integer.valueOf(this.jdField_a_of_type_Int)));
        QLog.d(ReadinjoySPEventReport.class.getSimpleName(), 2, "add aio enter or out info, type : " + this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_JavaUtilList != null) {
          ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport, ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport, this.jdField_a_of_type_JavaUtilList));
        }
        if ((this.jdField_a_of_type_Int != 0) || (!ReadinjoySPEventReport.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport))) {
          break;
        }
        ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport, false);
        if (ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport) != null)
        {
          ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport);
          return;
        }
        ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport, 0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label301:
      long l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lmv
 * JD-Core Version:    0.7.0.1
 */