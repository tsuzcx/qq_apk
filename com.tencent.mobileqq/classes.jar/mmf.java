import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class mmf
  implements Runnable
{
  mmf(mme parammme) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("channel_id", this.a.a.a);
      localJSONObject.put("click_source", "b2t_float_btn");
      PublicAccountReportUtils.a(null, "", "0X8009329", "0X8009329", 0, 0, "", "", "", localJSONObject.toString(), false);
      QLog.d("ReadInJoyListViewGroup", 2, "back_to_top: { channelID : " + this.a.a.a + " , click_source : b2t_float_btn }");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmf
 * JD-Core Version:    0.7.0.1
 */