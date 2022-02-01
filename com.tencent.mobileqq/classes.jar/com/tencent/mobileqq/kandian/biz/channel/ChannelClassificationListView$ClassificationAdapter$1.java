package com.tencent.mobileqq.kandian.biz.channel;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelClassificationListView$ClassificationAdapter$1
  implements View.OnClickListener
{
  ChannelClassificationListView$ClassificationAdapter$1(ChannelClassificationListView.ClassificationAdapter paramClassificationAdapter, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (ChannelClassificationListView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView$ClassificationAdapter.a) != null) {
      ChannelClassificationListView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView$ClassificationAdapter.a).onItemClick((AdapterView)this.jdField_a_of_type_AndroidViewViewGroup, paramView, i, this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView$ClassificationAdapter.getItemId(i));
    }
    paramView = new JSONObject();
    try
    {
      paramView.put("subchannelid", this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView$ClassificationAdapter.a(i).b());
      paramView.put("subchannelname", this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView$ClassificationAdapter.a(i).a());
      paramView.put("channelid", ChannelClassificationListView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelChannelClassificationListView$ClassificationAdapter.a));
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
    localStringBuilder.append("");
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, localStringBuilder.toString(), "0X8009933", "0X8009933", 0, 0, "", "", "", paramView.toString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.ChannelClassificationListView.ClassificationAdapter.1
 * JD-Core Version:    0.7.0.1
 */