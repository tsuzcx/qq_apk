package com.tencent.mobileqq.kandian.biz.fastweb;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyFastWebBottomSocialViewNew$1$1
  implements ViewBase.OnClickListener
{
  ReadInJoyFastWebBottomSocialViewNew$1$1(ReadInJoyFastWebBottomSocialViewNew.1 param1) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    for (;;)
    {
      int i;
      try
      {
        localObject = paramViewBase.getEventAttachedData();
        i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
        AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.jdField_a_of_type_ComTencentMobileqqKandianRepoPtsEntityProteusItemData.b;
        FastWebArticleInfo localFastWebArticleInfo = this.a.jdField_a_of_type_ComTencentMobileqqKandianRepoPtsEntityProteusItemData.a;
        if (i != 1129) {}
        switch (i)
        {
        case 1004: 
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            RIJJumpUtils.a(this.a.jdField_a_of_type_AndroidContentContext, (String)localObject);
            return;
            ReadInJoyFastWebBottomSocialViewNew.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew, this.a.jdField_a_of_type_AndroidContentContext, localAbsBaseArticleInfo, localFastWebArticleInfo, 1);
            return;
            ReadInJoyFastWebBottomSocialViewNew.d(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew, this.a.jdField_a_of_type_AndroidContentContext, localAbsBaseArticleInfo, localFastWebArticleInfo);
            return;
            ReadInJoyFastWebBottomSocialViewNew.e(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew, this.a.jdField_a_of_type_AndroidContentContext, localAbsBaseArticleInfo, localFastWebArticleInfo);
            return;
            ReadInJoyFastWebBottomSocialViewNew.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew, this.a.jdField_a_of_type_AndroidContentContext, localAbsBaseArticleInfo, localFastWebArticleInfo);
            return;
          }
          break;
        case 1003: 
          ReadInJoyFastWebBottomSocialViewNew.b(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew, this.a.jdField_a_of_type_AndroidContentContext, localAbsBaseArticleInfo, localFastWebArticleInfo);
          return;
        case 1002: 
          ReadInJoyFastWebBottomSocialViewNew.c(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew, this.a.jdField_a_of_type_AndroidContentContext, localAbsBaseArticleInfo, localFastWebArticleInfo);
          return;
          ReadInJoyFastWebBottomSocialViewNew.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew, paramViewBase, localAbsBaseArticleInfo, localFastWebArticleInfo, 7);
          return;
        }
      }
      catch (Exception paramViewBase)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("findClickableViewListener error!  msg=");
        ((StringBuilder)localObject).append(paramViewBase);
        QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, ((StringBuilder)localObject).toString());
      }
      return;
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialViewNew.1.1
 * JD-Core Version:    0.7.0.1
 */