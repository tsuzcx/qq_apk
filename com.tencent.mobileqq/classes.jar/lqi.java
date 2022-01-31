import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class lqi
  implements Runnable
{
  lqi(lqh paramlqh) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("channel_id", 70);
      localJSONObject.put("click_source", "b2t_title_text");
      PublicAccountReportUtils.a(null, "", "0X8009329", "0X8009329", 0, 0, "", "", "", localJSONObject.toString(), false);
      QLog.d("IphoneTitleBarFragment", 2, "back_to_top: { channelID : 70 , click_source : b2t_title_text }");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lqi
 * JD-Core Version:    0.7.0.1
 */