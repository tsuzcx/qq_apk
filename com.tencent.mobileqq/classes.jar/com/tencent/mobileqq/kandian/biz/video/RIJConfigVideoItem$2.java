package com.tencent.mobileqq.kandian.biz.video;

import android.content.Context;
import android.webkit.ValueCallback;
import android.widget.TextView;
import com.huawei.hms.common.internal.Objects;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;

final class RIJConfigVideoItem$2
  implements ValueCallback<Integer>
{
  RIJConfigVideoItem$2(VideoFeedsViewHolder paramVideoFeedsViewHolder, RIJDataManager paramRIJDataManager) {}
  
  public void a(Integer paramInteger)
  {
    if (Objects.equal(paramInteger, Integer.valueOf(5))) {
      this.a.F.setText(this.b.a().A().getString(2131890946));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.RIJConfigVideoItem.2
 * JD-Core Version:    0.7.0.1
 */