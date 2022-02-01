package com.tencent.mobileqq.kandian.biz.channel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelClassificationListView$ClassificationAdapter
  extends BaseAdapter
{
  private ChannelClassificationListView$ClassificationAdapter(ChannelClassificationListView paramChannelClassificationListView) {}
  
  public T a(int paramInt)
  {
    return (ChannelClassificationListView.IClassData)ChannelClassificationListView.a(this.a).get(paramInt);
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
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a.getContext()).inflate(2131562696, paramViewGroup, false);
      localView.setOnClickListener(new ChannelClassificationListView.ClassificationAdapter.1(this, paramViewGroup));
    }
    paramView = (ChannelClassificationListView.IClassData)ChannelClassificationListView.a(this.a).get(paramInt);
    localView.setTag(Integer.valueOf(paramInt));
    ((TextView)localView).setText(paramView.a());
    if (!paramView.a())
    {
      paramView.a(true);
      paramView = new JSONObject();
      try
      {
        paramView.put("subchannelid", a(paramInt).b());
        paramView.put("subchannelname", a(paramInt).a());
        paramView.put("channelid", ChannelClassificationListView.a(this.a));
      }
      catch (JSONException paramViewGroup)
      {
        paramViewGroup.printStackTrace();
      }
      paramViewGroup = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
      localStringBuilder.append("");
      paramViewGroup.publicAccountReportClickEvent(null, localStringBuilder.toString(), "0X8009932", "0X8009932", 0, 0, "", "", "", paramView.toString(), false);
    }
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.ChannelClassificationListView.ClassificationAdapter
 * JD-Core Version:    0.7.0.1
 */