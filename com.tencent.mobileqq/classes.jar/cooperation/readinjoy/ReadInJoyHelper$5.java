package cooperation.readinjoy;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

final class ReadInJoyHelper$5
  implements Runnable
{
  ReadInJoyHelper$5(AppRuntime paramAppRuntime, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      ReadInJoyHelper.a(localJSONObject);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), "0X8009662", "0X8009662", 0, 0, String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.b), "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadInJoyHelper", 2, "only kandian tab switch, report error:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.readinjoy.ReadInJoyHelper.5
 * JD-Core Version:    0.7.0.1
 */