package com.tencent.mobileqq.kandian.biz.video.click;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.framework.click.ClickHandler;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsWithColumnViewHolder;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class RIJVideoHandleClick$6
  implements ClickHandler
{
  RIJVideoHandleClick$6(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof VideoFeedsWithColumnViewHolder))
    {
      ((VideoFeedsWithColumnViewHolder)localObject).onClick(paramView);
      return;
    }
    localObject = (VideoFeedsViewHolder)paramView.getTag();
    localObject = RIJVideoHandleClick.a(this.a).a(((VideoFeedsViewHolder)localObject).a);
    if (localObject == null) {
      return;
    }
    RIJUserLevelModule.getInstance().doActionsByUserLevel(RIJVideoHandleClick.a(this.a), 2, new RIJVideoHandleClick.6.1(this, (AbsBaseArticleInfo)localObject, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.6
 * JD-Core Version:    0.7.0.1
 */