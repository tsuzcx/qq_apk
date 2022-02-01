package com.tencent.mobileqq.kandian.biz.fastweb;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSDataConverter;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebVideoItemUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ItemDatasListUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleTopicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.ModuleInfo;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.TextCardInfo;

class FastWebActivity$25
  extends ReadInJoyObserver
{
  FastWebActivity$25(FastWebActivity paramFastWebActivity) {}
  
  private void e(String paramString)
  {
    if ((FastWebActivity.a(this.a) != null) && (FastWebActivity.a(this.a).b != null) && (FastWebActivity.a(this.a).b.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject2 = FastWebActivity.a(this.a).b.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject1 = (ArticleTopicInfo)((Iterator)localObject2).next();
        if (TextUtils.equals(((ArticleTopicInfo)localObject1).b, paramString))
        {
          paramString = RIJTransMergeKanDianReport.a();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(FastWebActivity.a(this.a).e);
          paramString.addStringNotThrow("puin", ((StringBuilder)localObject2).toString());
          paramString.addStringNotThrow("rowkey", FastWebActivity.a(this.a).j);
          paramString.addStringNotThrow("article_id", FastWebActivity.a(this.a).o);
          paramString.addStringNotThrow("tag_from_page", "3");
          paramString.addStringNotThrow("tag_rk", ((ArticleTopicInfo)localObject1).c);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B9BC", "0X800B9BC", 0, 0, "", "", "", paramString.build(), false);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[reportTopicTagClick] 0X800B9BC, r5 = ");
          ((StringBuilder)localObject1).append(paramString.build());
          QLog.i("FastWebActivity", 1, ((StringBuilder)localObject1).toString());
        }
      }
      return;
    }
    QLog.i("FastWebActivity", 1, "[reportTopicTagClick] jumpUrl or topicTag is empty.");
  }
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    if (FastWebActivity.a(this.a) != null) {
      FastWebActivity.a(this.a).a(paramView, paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramInt);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    FastWebPTSDataConverter.a(FastWebActivity.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, FastWebActivity.a(this.a), this.a.jdField_a_of_type_AndroidUtilSparseArray);
    FastWebActivity.e(this.a);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    FastWebActivity.a(this.a, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (FastWebActivity.a(this.a) == null) {
      return;
    }
    FastWebVideoItemUtils.a(FastWebActivity.a(this.a), paramString, paramInt1, paramInt2);
    FastWebActivity.e(this.a);
  }
  
  @RequiresApi(api=19)
  public void a(ArrayList<String> paramArrayList)
  {
    String str;
    if (this.a.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) {
      str = this.a.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID;
    } else {
      str = "";
    }
    if (!TextUtils.isEmpty(str))
    {
      if (FastWebActivity.a(this.a) == null) {
        return;
      }
      paramArrayList = FastWebRequestUtil.a(str, 23, paramArrayList);
      int i = 0;
      while (i < paramArrayList.size())
      {
        BaseData localBaseData = (BaseData)paramArrayList.get(i);
        if ((localBaseData instanceof ProteusItemData)) {
          FastWebRequestUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, (ProteusItemData)localBaseData, 3, this.a.jdField_a_of_type_AndroidUtilSparseArray);
        }
        ItemDatasListUtils.b(FastWebActivity.a(this.a), localBaseData);
        i += 1;
      }
      paramArrayList = ReadInJoyLogicEngine.a().a();
      if (paramArrayList != null) {
        paramArrayList.a(str, FastWebActivity.a(this.a));
      }
      FastWebActivity.e(this.a);
      QLog.d("FastWebActivity", 1, "m0xc6dRespObserver,onHandle0xc6dResp");
    }
  }
  
  public void a(List<oidb_cmd0xe7e.ModuleInfo> paramList, List<oidb_cmd0xe7e.TextCardInfo> paramList1)
  {
    ThreadManager.getUIHandler().post(new FastWebActivity.25.2(this, paramList, paramList1));
  }
  
  public void aE_()
  {
    FastWebActivity.b(this.a, true);
    if (FastWebActivity.a(this.a) != null) {
      FastWebActivity.a(this.a).notifyDataSetChanged();
    }
  }
  
  public void aq_()
  {
    super.aq_();
    if ((!FastWebActivity.e(this.a)) && (FastWebActivity.a(this.a) != null) && (FastWebActivity.a(this.a) != null))
    {
      if (FastWebActivity.a(this.a) == null) {
        return;
      }
      FastWebPTSDataConverter.a(FastWebActivity.a(this.a), FastWebActivity.a(this.a));
      FastWebActivity.i(this.a);
      FastWebActivity.e(this.a);
    }
  }
  
  public void ar_()
  {
    if (FastWebActivity.a(this.a) == null) {
      return;
    }
    FastWebActivity.i(this.a);
    FastWebActivity.e(this.a);
  }
  
  public void c()
  {
    super.c();
    if (!FastWebActivity.d(this.a))
    {
      if (FastWebActivity.a(this.a) == null) {
        return;
      }
      FastWebActivity.e(this.a);
    }
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = paramString.substring(0, paramString.length() - 25);
    e(str);
    RIJJumpUtils.a(this.a, str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onTopicTagClick] url = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", jumpUrl = ");
    localStringBuilder.append(str);
    QLog.i("FastWebActivity", 1, localStringBuilder.toString());
  }
  
  public void d_(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" onWebCallback : ");
    localStringBuilder.append(paramString);
    QLog.d("Q.readinjoy.fast_web", 2, localStringBuilder.toString());
    if (!FastWebActivity.f(this.a)) {
      return;
    }
    boolean bool = "onPageStarted".equals(paramString);
    int i = 0;
    if (bool) {
      i = 300;
    } else {
      "onConversationJumpRestoreStack".equals(paramString);
    }
    ThreadManager.getUIHandler().postDelayed(new FastWebActivity.25.1(this), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.25
 * JD-Core Version:    0.7.0.1
 */