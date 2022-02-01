package com.tencent.mobileqq.kandian.biz.video.click;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.framework.click.ClickHandler;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;

class RIJVideoHandleClick$5
  implements ClickHandler
{
  RIJVideoHandleClick$5(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    paramView = (articlesummary.ChannelInfo)paramView.getTag();
    if (paramView != null) {
      if ((paramView.bytes_channel_url.has()) && (paramView.bytes_channel_url.get() != null))
      {
        if (!TextUtils.isEmpty(paramView.bytes_channel_url.get().toStringUtf8())) {
          ReadInJoyUtils.a(RIJVideoHandleClick.a(this.a).a().a(), paramView.bytes_channel_url.get().toStringUtf8());
        }
      }
      else {
        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchVideoSubChannelActivity(RIJVideoHandleClick.a(this.a).a().a(), paramView.uint32_channel_id.get(), RIJFeedsType.a(paramView), paramView.uint32_channel_type.get(), 6, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.5
 * JD-Core Version:    0.7.0.1
 */