import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import org.json.JSONException;
import org.json.JSONObject;

class qzp
  implements View.OnClickListener
{
  qzp(qzo paramqzo, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (ChannelClassificationListView.a(this.jdField_a_of_type_Qzo.a) != null) {
      ChannelClassificationListView.a(this.jdField_a_of_type_Qzo.a).onItemClick((AdapterView)this.jdField_a_of_type_AndroidViewViewGroup, paramView, i, this.jdField_a_of_type_Qzo.getItemId(i));
    }
    paramView = new JSONObject();
    try
    {
      paramView.put("subchannelid", this.jdField_a_of_type_Qzo.a(i).b());
      paramView.put("subchannelname", this.jdField_a_of_type_Qzo.a(i).a());
      paramView.put("channelid", ChannelClassificationListView.a(this.jdField_a_of_type_Qzo.a));
      noo.a(null, onk.a() + "", "0X8009933", "0X8009933", 0, 0, "", "", "", paramView.toString(), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qzp
 * JD-Core Version:    0.7.0.1
 */