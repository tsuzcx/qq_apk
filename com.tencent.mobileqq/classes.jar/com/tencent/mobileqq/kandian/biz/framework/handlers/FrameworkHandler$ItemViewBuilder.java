package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.kandian.biz.account.api.impl.CellFactory;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.ark.FeedItemCellArk;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.biz.pts.network.ReadInJoyPTSCostHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.DynamicItemViewHelper;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public class FrameworkHandler$ItemViewBuilder
{
  private volatile boolean b = false;
  private VafContext c;
  private DynamicItemViewHelper d;
  
  public FrameworkHandler$ItemViewBuilder(FrameworkHandler paramFrameworkHandler) {}
  
  private View a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    View localView = paramView;
    if (paramAbsBaseArticleInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FrameworkHandler", 2, new Object[] { "getArkAppView, position: ", Integer.valueOf(paramInt), ", articleInfo: ", paramAbsBaseArticleInfo, ", arkAppMessage: ", null });
      }
      localView = a(paramAbsBaseArticleInfo, paramView, null);
    }
    return localView;
  }
  
  private View a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    Object localObject = new ReadInJoyModelImpl(this.a.i(), paramAbsBaseArticleInfo, paramInt1, this.a.c(), this.a.f(), paramInt2, this.a.u(), this.a.t(), null, this.a.g());
    View localView = CellFactory.INSTANCE.getView(paramInt2, localObject, paramInt1, paramView, this.a.i(), this.a.g(), this.a.v());
    if (localView != null)
    {
      localView.setTag(2131449867, localObject);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("CellFactoryImpl.getView = ");
        paramView.append(localView.getTag().getClass().getSimpleName());
        QLog.d("FrameworkHandler", 2, paramView.toString());
      }
      localView.setTag(2131436721, this.a.w());
      if (paramAbsBaseArticleInfo == null)
      {
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("getView() article is null, set view gone, position: ");
          paramView.append(paramInt2);
          QLog.d("FrameworkHandler", 2, paramView.toString());
        }
        if (localView.getVisibility() != 8) {
          localView.setVisibility(8);
        }
        if ((localView.getLayoutParams() instanceof AbsListView.LayoutParams))
        {
          paramView = (AbsListView.LayoutParams)localView.getLayoutParams();
          if (paramView.height != 1)
          {
            paramView.height = 1;
            localView.setLayoutParams(paramView);
          }
        }
      }
      else
      {
        if (localView.getVisibility() != 0) {
          localView.setVisibility(0);
        }
        if ((localView.getLayoutParams() instanceof AbsListView.LayoutParams))
        {
          paramView = (AbsListView.LayoutParams)localView.getLayoutParams();
          if (paramView.height != -2)
          {
            paramView.height = -2;
            localView.setLayoutParams(paramView);
          }
        }
      }
    }
    else
    {
      QLog.w("FrameworkHandler", 1, "CellFactoryImpl.getView = null");
    }
    if (localView == null) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    paramView = new StringBuilder();
    paramView.append(this.a.f());
    paramView.append("");
    localObject = paramView.toString();
    if (paramAbsBaseArticleInfo != null) {
      paramView = String.valueOf(paramAbsBaseArticleInfo.mArticleID);
    } else {
      paramView = "";
    }
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append(this.a.c());
    paramAbsBaseArticleInfo.append("");
    PublicAccountReportUtils.a(null, "", "0X80095B4", "0X80095B4", 0, paramInt1, (String)localObject, paramView, paramAbsBaseArticleInfo.toString(), "", false);
    return localView;
  }
  
  private View a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, int paramInt1, int paramInt2)
  {
    paramAbsBaseArticleInfo2 = new ReadInJoyModelImpl(this.a.i(), paramAbsBaseArticleInfo1, paramInt1, this.a.c(), this.a.f(), paramInt2, this.a.u(), this.a.t(), paramAbsBaseArticleInfo2, this.a.g());
    paramAbsBaseArticleInfo2.a(this.c);
    long l;
    if ((paramView != null) && ((paramView instanceof ProteusItemView)))
    {
      l = System.currentTimeMillis();
      paramView = (ProteusItemView)paramView;
      ProteusSupportUtil.a(paramView, paramInt1, paramAbsBaseArticleInfo1, this.c, this.a.v(), this.a.g(), paramAbsBaseArticleInfo2, paramInt2, "default_feeds");
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.convertview#bindData", System.currentTimeMillis() - l);
    }
    else
    {
      l = System.currentTimeMillis();
      paramView = ProteusSupportUtil.a(this.c, paramInt1, paramAbsBaseArticleInfo1);
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      ProteusSupportUtil.a(paramView, paramInt1, paramAbsBaseArticleInfo1, this.c, this.a.v(), this.a.g(), paramAbsBaseArticleInfo2, paramInt2, "default_feeds");
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.newview#bindData", System.currentTimeMillis() - l);
    }
    if ((paramView != null) && (paramView.getContainer() != null))
    {
      l = System.currentTimeMillis();
      paramAbsBaseArticleInfo1 = this.a.w();
      paramView.getContainer().setTag(2131436721, paramAbsBaseArticleInfo1);
      paramView.setTag(2131449867, paramAbsBaseArticleInfo2);
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.setTag", System.currentTimeMillis() - l);
    }
    return paramView;
  }
  
  private View a(AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView, ArkAppMessage paramArkAppMessage)
  {
    if (paramAbsBaseArticleInfo == null) {
      return paramView;
    }
    if ((paramView != null) && ((paramView.getTag() instanceof FeedItemCellArk)))
    {
      paramAbsBaseArticleInfo = (FeedItemCellArk)paramView.getTag();
      return paramView;
    }
    paramAbsBaseArticleInfo = new FeedItemCellArk(paramArkAppMessage, paramAbsBaseArticleInfo);
    if (paramAbsBaseArticleInfo.a() != null)
    {
      paramView = paramAbsBaseArticleInfo.a();
      paramView.setTag(paramAbsBaseArticleInfo);
    }
    return paramView;
  }
  
  private View b(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, int paramInt1, int paramInt2)
  {
    paramAbsBaseArticleInfo2 = new ReadInJoyModelImpl(this.a.i(), paramAbsBaseArticleInfo1, paramInt1, this.a.c(), this.a.f(), paramInt2, this.a.u(), this.a.t(), paramAbsBaseArticleInfo2, this.a.g());
    long l;
    if ((paramView != null) && ((paramView instanceof ProteusItemView)))
    {
      l = System.currentTimeMillis();
      DynamicItemViewHelper localDynamicItemViewHelper = this.d;
      paramView = (ProteusItemView)paramView;
      localDynamicItemViewHelper.a(paramView, paramInt1, paramAbsBaseArticleInfo1, this.c, this.a.v(), this.a.g(), paramAbsBaseArticleInfo2, paramInt2);
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(paramInt1), "getDynamicProteusView.convertview#bindData", System.currentTimeMillis() - l);
    }
    else
    {
      l = System.currentTimeMillis();
      paramView = this.d.a(this.c, paramInt1, paramAbsBaseArticleInfo1);
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(paramInt1), "getDynamicProteusView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      this.d.a(paramView, paramInt1, paramAbsBaseArticleInfo1, this.c, this.a.v(), this.a.g(), paramAbsBaseArticleInfo2, paramInt2);
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(paramInt1), "getDynamicProteusView.newview#bindData", System.currentTimeMillis() - l);
    }
    paramAbsBaseArticleInfo1 = this.a.w();
    if (paramView.getContainer() != null) {
      paramView.getContainer().setTag(2131436721, paramAbsBaseArticleInfo1);
    }
    paramView.setTag(2131449867, paramAbsBaseArticleInfo2);
    return paramView;
  }
  
  public void a()
  {
    try
    {
      if (!this.b)
      {
        this.c = this.a.g().F();
        this.d = this.a.g().G();
        this.b = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler.ItemViewBuilder
 * JD-Core Version:    0.7.0.1
 */