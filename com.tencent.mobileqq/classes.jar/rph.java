import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class rph
  extends BaseAdapter
{
  private rph(ChannelClassificationListView paramChannelClassificationListView) {}
  
  public T a(int paramInt)
  {
    return (rpj)ChannelClassificationListView.a(this.a).get(paramInt);
  }
  
  public int getCount()
  {
    return ChannelClassificationListView.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131562494, paramViewGroup, false);
      paramView.setOnClickListener(new rpi(this, paramViewGroup));
    }
    for (;;)
    {
      paramViewGroup = (rpj)ChannelClassificationListView.a(this.a).get(paramInt);
      paramView.setTag(Integer.valueOf(paramInt));
      ((TextView)paramView).setText(paramViewGroup.a());
      if (!paramViewGroup.a())
      {
        paramViewGroup.a(true);
        paramViewGroup = new JSONObject();
      }
      try
      {
        paramViewGroup.put("subchannelid", a(paramInt).b());
        paramViewGroup.put("subchannelname", a(paramInt).a());
        paramViewGroup.put("channelid", ChannelClassificationListView.a(this.a));
        nrt.a(null, ors.a() + "", "0X8009932", "0X8009932", 0, 0, "", "", "", paramViewGroup.toString(), false);
        return paramView;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rph
 * JD-Core Version:    0.7.0.1
 */