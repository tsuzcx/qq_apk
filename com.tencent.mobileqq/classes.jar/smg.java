import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class smg
  extends BaseAdapter
{
  private smg(ChannelClassificationListView paramChannelClassificationListView) {}
  
  public T a(int paramInt)
  {
    return (smi)ChannelClassificationListView.a(this.a).get(paramInt);
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
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131562748, paramViewGroup, false);
      paramView.setOnClickListener(new smh(this, paramViewGroup));
    }
    for (;;)
    {
      Object localObject = (smi)ChannelClassificationListView.a(this.a).get(paramInt);
      paramView.setTag(Integer.valueOf(paramInt));
      ((TextView)paramView).setText(((smi)localObject).a());
      if (!((smi)localObject).a())
      {
        ((smi)localObject).a(true);
        localObject = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject).put("subchannelid", a(paramInt).b());
        ((JSONObject)localObject).put("subchannelname", a(paramInt).a());
        ((JSONObject)localObject).put("channelid", ChannelClassificationListView.a(this.a));
        oat.a(null, pha.a() + "", "0X8009932", "0X8009932", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smg
 * JD-Core Version:    0.7.0.1
 */