package com.tencent.mobileqq.kandian.biz.channel;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelClassificationListView$1
  implements HorizontalListView.OnScrollStateChangedListener
{
  ChannelClassificationListView$1(ChannelClassificationListView paramChannelClassificationListView) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4098)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("channelid", ChannelClassificationListView.a(this.a));
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(RIJQQAppInterfaceUtil.c());
      localStringBuilder.append("");
      PublicAccountReportUtils.a(null, localStringBuilder.toString(), "0X8009934", "0X8009934", 0, 0, "", "", "", localJSONObject.toString(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.ChannelClassificationListView.1
 * JD-Core Version:    0.7.0.1
 */