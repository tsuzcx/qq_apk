package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.widget.KandianNegativeWindow.OnUninterestConfirmListener;
import java.util.ArrayList;

class FeedItemCell$5
  implements KandianNegativeWindow.OnUninterestConfirmListener
{
  FeedItemCell$5(FeedItemCell paramFeedItemCell) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPtsReadInJoyModelImpl != null)
    {
      paramView = this.a;
      FeedItemCell.a(paramView, paramView.jdField_a_of_type_ComTencentMobileqqKandianBizPtsReadInJoyModelImpl, paramInt, paramArrayList, paramObject);
      return;
    }
    paramView = this.a;
    FeedItemCell.a(paramView, (IReadInJoyModel)paramView.jdField_a_of_type_JavaLangObject, paramInt, paramArrayList, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell.5
 * JD-Core Version:    0.7.0.1
 */