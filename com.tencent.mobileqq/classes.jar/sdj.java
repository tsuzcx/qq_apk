import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import org.json.JSONException;
import org.json.JSONObject;

public class sdj
  implements blmh
{
  public sdj(ChannelClassificationListView paramChannelClassificationListView) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    JSONObject localJSONObject;
    if (paramInt == 4098) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("channelid", ChannelClassificationListView.a(this.a));
      ocd.a(null, ozs.a() + "", "0X8009934", "0X8009934", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdj
 * JD-Core Version:    0.7.0.1
 */