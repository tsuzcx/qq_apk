package com.tencent.mobileqq.kandian.biz.feeds.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyFooterPresenter$5
  implements View.OnClickListener
{
  ReadInJoyFooterPresenter$5(ReadInJoyFooterPresenter paramReadInJoyFooterPresenter, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyActivityHelper.INSTANCE.launchChannelActivity(ReadInJoyFooterPresenter.a(this.b), this.a.mChannelInfoId, this.a.mChannelInfoName, this.a.mChannelInfoType, 1);
    int i;
    if (this.a.hasChannelInfo()) {
      i = this.a.mChannelInfoId;
    } else {
      i = 0;
    }
    try
    {
      paramView = new JSONObject();
      paramView.put("feeds_channel_entrance", i);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8006DF3", "0X8006DF3", 0, 0, "", "", "", paramView.toString(), false);
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyFooterPresenter.5
 * JD-Core Version:    0.7.0.1
 */