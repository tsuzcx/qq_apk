package com.tencent.mobileqq.kandian.biz.fastweb;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSDataConverter;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebVideoItemUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ItemDatasListUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.AuthorData;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleTopicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
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
    if ((FastWebActivity.d(this.a) != null) && (FastWebActivity.d(this.a).I != null) && (FastWebActivity.d(this.a).I.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject2 = FastWebActivity.d(this.a).I.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject1 = (ArticleTopicInfo)((Iterator)localObject2).next();
        if (TextUtils.equals(((ArticleTopicInfo)localObject1).b, paramString))
        {
          paramString = RIJTransMergeKanDianReport.g();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(FastWebActivity.d(this.a).y);
          paramString.addStringNotThrow("puin", ((StringBuilder)localObject2).toString());
          paramString.addStringNotThrow("rowkey", FastWebActivity.d(this.a).q);
          paramString.addStringNotThrow("article_id", FastWebActivity.d(this.a).x);
          paramString.addStringNotThrow("tag_from_page", "3");
          paramString.addStringNotThrow("tag_rk", ((ArticleTopicInfo)localObject1).d);
          PublicAccountReportUtils.a(null, "", "0X800B9BC", "0X800B9BC", 0, 0, "", "", "", paramString.build(), false);
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
  
  public void a(long paramLong, int paramInt)
  {
    FastWebActivity localFastWebActivity = this.a;
    boolean bool;
    if (paramInt == 2) {
      bool = true;
    } else {
      bool = false;
    }
    FastWebActivity.e(localFastWebActivity, bool);
    if (FastWebActivity.k(this.a) != null) {
      FastWebActivity.k(this.a).a(true);
    }
    if (FastWebActivity.o(this.a) != null)
    {
      FastWebActivity.o(this.a).a(paramLong);
      FastWebActivity.o(this.a).notifyDataSetChanged();
    }
  }
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    if (FastWebActivity.p(this.a) != null) {
      FastWebActivity.p(this.a).a(paramView, paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramInt);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    FastWebPTSDataConverter.a(FastWebActivity.m(this.a), this.a.g, FastWebActivity.d(this.a), this.a.n);
    FastWebActivity.n(this.a);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    FastWebActivity.f(this.a, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (FastWebActivity.l(this.a) == null) {
      return;
    }
    FastWebVideoItemUtils.a(FastWebActivity.m(this.a), paramString, paramInt1, paramInt2);
    FastWebActivity.n(this.a);
  }
  
  @RequiresApi(api=19)
  public void a(ArrayList<String> paramArrayList)
  {
    String str;
    if (this.a.g != null) {
      str = this.a.g.innerUniqueID;
    } else {
      str = "";
    }
    if (!TextUtils.isEmpty(str))
    {
      if (FastWebActivity.m(this.a) == null) {
        return;
      }
      paramArrayList = FastWebRequestUtil.a(str, 23, paramArrayList);
      int i = 0;
      while (i < paramArrayList.size())
      {
        BaseData localBaseData = (BaseData)paramArrayList.get(i);
        if ((localBaseData instanceof ProteusItemData)) {
          FastWebRequestUtil.a(this.a.g, (ProteusItemData)localBaseData, 3, this.a.n);
        }
        ItemDatasListUtils.b(FastWebActivity.m(this.a), localBaseData);
        i += 1;
      }
      paramArrayList = ReadInJoyLogicEngine.a().d();
      if (paramArrayList != null) {
        paramArrayList.a(str, FastWebActivity.m(this.a));
      }
      FastWebActivity.n(this.a);
      QLog.d("FastWebActivity", 1, "m0xc6dRespObserver,onHandle0xc6dResp");
    }
  }
  
  public void a(List<oidb_cmd0xe7e.ModuleInfo> paramList, List<oidb_cmd0xe7e.TextCardInfo> paramList1)
  {
    ThreadManager.getUIHandler().post(new FastWebActivity.25.2(this, paramList, paramList1));
  }
  
  public void cE_()
  {
    super.cE_();
    if (!FastWebActivity.F(this.a))
    {
      if (FastWebActivity.l(this.a) == null) {
        return;
      }
      FastWebActivity.n(this.a);
    }
  }
  
  public void cF_()
  {
    super.cF_();
    if ((!FastWebActivity.H(this.a)) && (FastWebActivity.l(this.a) != null) && (FastWebActivity.k(this.a) != null))
    {
      if (FastWebActivity.d(this.a) == null) {
        return;
      }
      FastWebPTSDataConverter.a(FastWebActivity.m(this.a), FastWebActivity.d(this.a));
      FastWebActivity.G(this.a);
      FastWebActivity.n(this.a);
    }
  }
  
  public void cG_()
  {
    if (FastWebActivity.l(this.a) == null) {
      return;
    }
    FastWebActivity.G(this.a);
    FastWebActivity.n(this.a);
  }
  
  public void j_(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = paramString.substring(0, paramString.length() - 25);
    e(str);
    RIJJumpUtils.c(this.a, str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onTopicTagClick] url = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", jumpUrl = ");
    localStringBuilder.append(str);
    QLog.i("FastWebActivity", 1, localStringBuilder.toString());
  }
  
  public void k_(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" onWebCallback : ");
    localStringBuilder.append(paramString);
    QLog.d("Q.readinjoy.fast_web", 2, localStringBuilder.toString());
    if (!FastWebActivity.I(this.a)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.25
 * JD-Core Version:    0.7.0.1
 */