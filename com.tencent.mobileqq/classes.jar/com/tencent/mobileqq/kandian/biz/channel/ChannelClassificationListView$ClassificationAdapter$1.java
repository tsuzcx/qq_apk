package com.tencent.mobileqq.kandian.biz.channel;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelClassificationListView$ClassificationAdapter$1
  implements View.OnClickListener
{
  ChannelClassificationListView$ClassificationAdapter$1(ChannelClassificationListView.ClassificationAdapter paramClassificationAdapter, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (ChannelClassificationListView.c(this.b.a) != null) {
      ChannelClassificationListView.c(this.b.a).onItemClick((AdapterView)this.a, paramView, i, this.b.getItemId(i));
    }
    paramView = new JSONObject();
    try
    {
      paramView.put("subchannelid", this.b.a(i).b());
      paramView.put("subchannelname", this.b.a(i).a());
      paramView.put("channelid", ChannelClassificationListView.a(this.b.a));
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(RIJQQAppInterfaceUtil.c());
    localStringBuilder.append("");
    PublicAccountReportUtils.a(null, localStringBuilder.toString(), "0X8009933", "0X8009933", 0, 0, "", "", "", paramView.toString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.ChannelClassificationListView.ClassificationAdapter.1
 * JD-Core Version:    0.7.0.1
 */