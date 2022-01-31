import com.tencent.biz.qqstory.network.handler.ReportEvilToXinanHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class nej
  implements Runnable
{
  public nej(ReportEvilToXinanHandler paramReportEvilToXinanHandler, String paramString) {}
  
  public void run()
  {
    try
    {
      i = new JSONObject(this.jdField_a_of_type_JavaLangString).getInt("rtn_code");
      if (i == 0)
      {
        QQToast.a(BaseApplication.getContext(), "举报成功，客服人员将尽快处理", 0).a();
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        int i = -1;
      }
      QQToast.a(BaseApplication.getContext(), "举报失败，请稍后重试", 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nej
 * JD-Core Version:    0.7.0.1
 */