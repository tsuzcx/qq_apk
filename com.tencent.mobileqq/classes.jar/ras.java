import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.DeliverData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ras
  extends beyf
{
  public boolean a;
  
  public ras(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void handleMessage(Message paramMessage)
  {
    bete localbete = (bete)paramMessage.obj;
    if ((localbete == null) || (localbete.jdField_b_of_type_Int != 24) || (localbete.jdField_c_of_type_Int != 10)) {}
    do
    {
      do
      {
        for (;;)
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1003: 
            if (this.jdField_a_of_type_Boolean)
            {
              int j = (int)localbete.jdField_b_of_type_Long;
              ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).f(j, NetConnInfoCenter.getServerTimeMillis());
              ocd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.app, "", "0X800817F", "0X800817F", 0, 0, String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).d()[j]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).c()[j]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).b()[j] - ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a()[j]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).e()[j] - ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).f()[j]));
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler send finished!");
              }
              try
              {
                ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).put("picCount", 1);
                paramMessage = new JSONArray();
                localObject = new JSONObject();
                ((JSONObject)localObject).put("url", localbete.i);
                ((JSONObject)localObject).put("md5", localbete.f);
                paramMessage.put(localObject);
                ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).put("picList", paramMessage);
                if (QLog.isColorLevel()) {
                  QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler resultJson=" + ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).toString()));
                }
                if ((j < ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity)) && (!localbete.i.equals(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a()[j])) && (!localbete.f.equals(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).b()[j])))
                {
                  paramMessage = ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a();
                  localObject = paramMessage.get(j);
                  localObject = ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, localObject);
                  i = j;
                  if ((i < paramMessage.size()) && (!ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).equals(paramMessage.get(i)))) {}
                }
                else
                {
                  if ((ReadInJoyDeliverUGCActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity) != ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity)) || (ReadInJoyDeliverUGCActivity.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity))) {
                    continue;
                  }
                  ReadInJoyDeliverUGCActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, true);
                  pfa.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.app.c(), ReadInJoyDeliverUGCActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a(), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a(), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).b(), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).b(), ReadInJoyDeliverUGCActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity));
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("ReadInJoyDeliverUGCActivity", 2, "allFinishUp");
                  return;
                }
              }
              catch (Exception paramMessage)
              {
                Object localObject;
                for (;;)
                {
                  QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler resultJson=log error");
                }
                if (i == j)
                {
                  ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a(i, localbete.i);
                  ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).b(i, localbete.f);
                  ReadInJoyDeliverUGCActivity.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity);
                  if (QLog.isColorLevel()) {
                    QLog.d("ReadInJoyDeliverUGCActivity", 2, "finishUp" + i);
                  }
                }
                for (;;)
                {
                  i += 1;
                  break;
                  if (((String)localObject).equals(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, paramMessage.get(i))))
                  {
                    ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a(i, localbete.i);
                    ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).b(i, localbete.f);
                    ReadInJoyDeliverUGCActivity.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity);
                    if (QLog.isColorLevel()) {
                      QLog.d("ReadInJoyDeliverUGCActivity", 2, "finishUp" + i);
                    }
                  }
                }
              }
            }
            break;
          }
        }
      } while (!this.jdField_a_of_type_Boolean);
      int i = (int)localbete.jdField_b_of_type_Long;
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).f(i, NetConnInfoCenter.getServerTimeMillis());
      ocd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.app, "", "0X800817F", "0X800817F", 0, 0, String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).d()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).c()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).b()[i] - ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).e()[i] - ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).f()[i]));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler send error or cancel!");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.l();
      ReadInJoyDeliverUGCActivity.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.getString(2131717106));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.i();
      ReadInJoyDeliverUGCActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, 1002);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyDeliverUGCActivity", 2, "handleMessage: FileMsg.STATUS_SEND_CANCEL.\nfilePath: " + localbete.jdField_c_of_type_JavaLangString + "\nfileMd5: " + localbete.f + "\nfileUrl: " + localbete.i + "\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ras
 * JD-Core Version:    0.7.0.1
 */