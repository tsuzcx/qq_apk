import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class sdl
  implements View.OnClickListener
{
  sdl(sdk paramsdk, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (ChannelClassificationListView.a(this.jdField_a_of_type_Sdk.a) != null) {
      ChannelClassificationListView.a(this.jdField_a_of_type_Sdk.a).onItemClick((AdapterView)this.jdField_a_of_type_AndroidViewViewGroup, paramView, i, this.jdField_a_of_type_Sdk.getItemId(i));
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("subchannelid", this.jdField_a_of_type_Sdk.a(i).b());
      localJSONObject.put("subchannelname", this.jdField_a_of_type_Sdk.a(i).a());
      localJSONObject.put("channelid", ChannelClassificationListView.a(this.jdField_a_of_type_Sdk.a));
      ocd.a(null, ozs.a() + "", "0X8009933", "0X8009933", 0, 0, "", "", "", localJSONObject.toString(), false);
      EventCollector.getInstance().onViewClicked(paramView);
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
 * Qualified Name:     sdl
 * JD-Core Version:    0.7.0.1
 */