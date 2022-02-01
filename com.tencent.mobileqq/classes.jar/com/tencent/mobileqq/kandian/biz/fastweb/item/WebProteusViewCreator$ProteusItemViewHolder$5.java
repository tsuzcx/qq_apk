package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.AuthorData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ProteusRecommendItemData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import org.json.JSONObject;

class WebProteusViewCreator$ProteusItemViewHolder$5
  implements WebProteusViewCreator.ProteusItemViewOnClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$5(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    if ((paramProteusItemData instanceof AuthorData))
    {
      paramViewBase = (AuthorData)paramProteusItemData;
      if (TextUtils.isEmpty(paramViewBase.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (paramViewBase.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
      {
        paramContext = paramViewBase.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
        com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramContext;
        paramProteusItemData = paramViewBase.c;
        FastWebPTSUtils.a(this.a.a.getContext(), paramContext, paramProteusItemData, paramViewBase.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, 0);
      }
    }
    else if ((paramProteusItemData instanceof ProteusRecommendItemData))
    {
      paramViewBase = (AuthorData)paramProteusItemData.c.opt("author_data");
      if (TextUtils.isEmpty(paramViewBase.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (paramViewBase.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
      {
        paramContext = paramViewBase.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
        com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramContext;
        paramProteusItemData = paramViewBase.c;
        FastWebPTSUtils.a(this.a.a.getContext(), paramContext, paramProteusItemData, paramViewBase.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.5
 * JD-Core Version:    0.7.0.1
 */