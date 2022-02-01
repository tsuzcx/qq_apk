package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleBasicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class ComponentContentGridImage$1
  implements AdapterView.OnItemClickListener
{
  ComponentContentGridImage$1(ComponentContentGridImage paramComponentContentGridImage) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((ComponentContentGridImage.a(this.a) != 62) && (ComponentContentGridImage.a(this.a) != 63) && (ComponentContentGridImage.a(this.a) != 64) && (ComponentContentGridImage.a(this.a) != 65))
    {
      if ((Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0) == 1) && (((ReadInJoyModelImpl)this.a.a).a().mSocialFeedInfo != null) && (((ReadInJoyModelImpl)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (((ReadInJoyModelImpl)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a) && (((ReadInJoyModelImpl)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo != null)) {
        try
        {
          RIJJumpUtils.a(this.a.getContext(), ((ReadInJoyModelImpl)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo.a.c, null);
          return;
        }
        catch (Exception paramAdapterView)
        {
          QLog.e("ComponentContentGridImage", 1, paramAdapterView.getLocalizedMessage());
          return;
        }
      }
      paramAdapterView = this.a;
      ComponentContentGridImage.a(paramAdapterView, paramInt, ComponentContentGridImage.a(paramAdapterView).a());
      return;
    }
    if (ComponentContentGridImage.a(this.a) != null) {
      ComponentContentGridImage.a(this.a).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage.1
 * JD-Core Version:    0.7.0.1
 */