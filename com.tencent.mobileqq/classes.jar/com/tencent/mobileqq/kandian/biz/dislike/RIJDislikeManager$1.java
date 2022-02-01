package com.tencent.mobileqq.kandian.biz.dislike;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.video.viewholder.ViewHolder;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.widget.KandianNegativeWindow.OnUninterestConfirmListener;
import java.util.ArrayList;

class RIJDislikeManager$1
  implements KandianNegativeWindow.OnUninterestConfirmListener
{
  RIJDislikeManager$1(RIJDislikeManager paramRIJDislikeManager, int paramInt, RIJDataManager paramRIJDataManager, ViewHolder paramViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().g();
      paramView = (Animation)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder.g.getTag(2131369613);
      paramView.setAnimationListener(new RIJDislikeManager.1.1(this, paramArrayList, paramObject));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder.g.post(new RIJDislikeManager.1.2(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager.1
 * JD-Core Version:    0.7.0.1
 */