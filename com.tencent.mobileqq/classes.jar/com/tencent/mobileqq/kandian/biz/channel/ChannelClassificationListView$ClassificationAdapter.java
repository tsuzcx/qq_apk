package com.tencent.mobileqq.kandian.biz.channel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelClassificationListView$ClassificationAdapter
  extends BaseAdapter
{
  private ChannelClassificationListView$ClassificationAdapter(ChannelClassificationListView paramChannelClassificationListView) {}
  
  public T a(int paramInt)
  {
    return (ChannelClassificationListView.IClassData)ChannelClassificationListView.b(this.a).get(paramInt);
  }
  
  public int getCount()
  {
    return ChannelClassificationListView.b(this.a).size();
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
      localView = LayoutInflater.from(this.a.getContext()).inflate(2131629127, paramViewGroup, false);
      localView.setOnClickListener(new ChannelClassificationListView.ClassificationAdapter.1(this, paramViewGroup));
    }
    paramView = (ChannelClassificationListView.IClassData)ChannelClassificationListView.b(this.a).get(paramInt);
    localView.setTag(Integer.valueOf(paramInt));
    ((TextView)localView).setText(paramView.a());
    if (!paramView.c())
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
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(RIJQQAppInterfaceUtil.c());
      paramViewGroup.append("");
      PublicAccountReportUtils.a(null, paramViewGroup.toString(), "0X8009932", "0X8009932", 0, 0, "", "", "", paramView.toString(), false);
    }
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.ChannelClassificationListView.ClassificationAdapter
 * JD-Core Version:    0.7.0.1
 */