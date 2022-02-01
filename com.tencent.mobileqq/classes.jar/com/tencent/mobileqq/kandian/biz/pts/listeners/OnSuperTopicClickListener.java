package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.WendaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class OnSuperTopicClickListener
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  
  public OnSuperTopicClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((AbsBaseArticleInfo)localObject).proteusItemsData))) {
      try
      {
        localObject = new JSONObject(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.proteusItemsData);
        QLog.d("OnSuperTopicClickListener", 2, new Object[] { "mArticleInfo.proteusItemsData = ", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.proteusItemsData });
        Iterator localIterator = ((JSONObject)localObject).keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ("id_super_topic".equals(str))
          {
            localObject = ((JSONObject)localObject).getJSONObject(str).getString("super_topic_jump_url");
            QLog.d("OnSuperTopicClickListener", 2, new Object[] { "jumpToSuperTopic, jumpUrl = ", localObject });
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, null);
              return;
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.d("OnSuperTopicClickListener", 2, "jumpToSuperTopic", localJSONException);
      }
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.a;
    if (paramAbsBaseArticleInfo != null)
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.d;
      RIJJumpUtils.b(paramContext, paramAbsBaseArticleInfo);
      paramContext = new StringBuilder();
      paramContext.append("jumpToWendaRefer jumpUrl +");
      paramContext.append(paramAbsBaseArticleInfo);
      QLog.i("OnSuperTopicClickListener", 2, paramContext.toString());
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((!RIJFeedsType.t(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (!RIJFeedsType.u(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)))
    {
      a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportLabelsClick(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_AndroidContentContext);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportLabelsClick(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnSuperTopicClickListener
 * JD-Core Version:    0.7.0.1
 */