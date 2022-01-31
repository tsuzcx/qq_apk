import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;

public class lpf
  implements Runnable
{
  public lpf(ReadinjoySPEventReport paramReadinjoySPEventReport, int paramInt) {}
  
  public void run()
  {
    int i;
    if (ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport) != null)
    {
      if (((Integer)ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).second).intValue() == this.jdField_a_of_type_Int) {
        return;
      }
      if (((Integer)ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).second).intValue() < this.jdField_a_of_type_Int) {
        i = 1;
      }
    }
    for (;;)
    {
      label59:
      int j = ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).size();
      long l1;
      if (j > ReadInJoyHelper.b(ReadInJoyUtils.a())) {
        l1 = j - ReadInJoyHelper.b(ReadInJoyUtils.a());
      }
      for (;;)
      {
        long l2 = l1 - 1L;
        if (l1 > 0L)
        {
          if (ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).size() <= 1) {
            break label824;
          }
          ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).remove(1);
          l1 = l2;
          continue;
          i = 0;
          break label59;
        }
        ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport, false);
        if (j == 0) {
          ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).get(0)).first).longValue()), Integer.valueOf(this.jdField_a_of_type_Int)));
        ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).add(ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport));
        QLog.d(ReadinjoySPEventReport.class.getSimpleName(), 2, "update msg tab total red pnt change, cnt : " + this.jdField_a_of_type_Int);
        j = ReadInJoyUtils.b();
        if (j < 0) {
          break;
        }
        if (j > this.jdField_a_of_type_Int) {
          j = this.jdField_a_of_type_Int;
        }
        for (;;)
        {
          int k = ReadinjoySPEventReport.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).size();
          if (k > ReadInJoyHelper.c(ReadInJoyUtils.a())) {
            l1 = k - ReadInJoyHelper.c(ReadInJoyUtils.a());
          }
          for (;;)
          {
            l2 = l1 - 1L;
            if (l1 > 0L)
            {
              if (ReadinjoySPEventReport.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).size() > 1)
              {
                ReadinjoySPEventReport.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).remove(1);
                l1 = l2;
              }
            }
            else
            {
              if ((ReadinjoySPEventReport.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport) != null) && (((Integer)ReadinjoySPEventReport.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).second).intValue() == j)) {
                break;
              }
              if (k == 0) {
                ReadinjoySPEventReport.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
              }
              ReadinjoySPEventReport.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)ReadinjoySPEventReport.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).get(0)).first).longValue()), Integer.valueOf(j)));
              ReadinjoySPEventReport.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).add(ReadinjoySPEventReport.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport));
              QLog.d(ReadinjoySPEventReport.class.getSimpleName(), 2, "update msg tab first screen red pnt change, cnt : " + j);
              j = ReadInJoyHelper.a();
              if ((this.jdField_a_of_type_Int <= j) && (!ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport)) && (i == 0))
              {
                if ((ReadinjoySPEventReport.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport) != null) && (ReadinjoySPEventReport.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).size() > 0))
                {
                  i = ((Integer)((Pair)ReadinjoySPEventReport.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).get(ReadinjoySPEventReport.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).size() - 1)).second).intValue();
                  l1 = ((Long)((Pair)ReadinjoySPEventReport.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).get(0)).first).longValue();
                  l2 = ((Long)((Pair)ReadinjoySPEventReport.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).get(ReadinjoySPEventReport.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport).size() - 1)).first).longValue();
                  if ((System.currentTimeMillis() / 1000L - (l1 + l2) <= 600L) && (i == 1))
                  {
                    ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport, true);
                    return;
                  }
                }
                if (ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport) != null) {
                  break label804;
                }
                ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport, 0);
              }
              for (;;)
              {
                ReadinjoySPEventReport.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport, false);
                return;
                label804:
                ReadinjoySPEventReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport);
              }
            }
            l1 = l2;
          }
        }
        label824:
        l1 = l2;
      }
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpf
 * JD-Core Version:    0.7.0.1
 */