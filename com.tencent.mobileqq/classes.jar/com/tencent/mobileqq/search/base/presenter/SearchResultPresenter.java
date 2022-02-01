package com.tencent.mobileqq.search.base.presenter;

import addcontacts.AccountSearchPb.hotwordrecord;
import addcontacts.AccountSearchPb.record;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.business.net.model.GroupNetSearchModelArticleItem;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;

public class SearchResultPresenter
  implements IFacePresenter<ISearchResultModel, ISearchResultView>
{
  private IFaceDecoder a;
  
  public SearchResultPresenter(IFaceDecoder paramIFaceDecoder)
  {
    this.a = paramIFaceDecoder;
  }
  
  protected void a(ISearchResultView paramISearchResultView, ISearchResultModel paramISearchResultModel)
  {
    if ((paramISearchResultView.b() != null) && (paramISearchResultModel != null)) {
      paramISearchResultView.b().setText(paramISearchResultModel.d());
    }
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    d(paramISearchResultModel, paramISearchResultView);
    a(paramISearchResultView, paramISearchResultModel);
    if (paramISearchResultView.c() != null) {
      paramISearchResultView.c().setText(paramISearchResultModel.e());
    }
    if (paramISearchResultView.d() != null) {
      paramISearchResultView.d().setText(paramISearchResultModel.a());
    }
    if (paramISearchResultView.e() != null) {
      paramISearchResultView.e().setText(paramISearchResultModel.f());
    }
    if (paramISearchResultView.f() != null) {
      if (paramISearchResultModel.h()) {
        paramISearchResultView.f().setVisibility(0);
      } else {
        paramISearchResultView.f().setVisibility(8);
      }
    }
    c(paramISearchResultModel, paramISearchResultView);
    if ((paramISearchResultModel instanceof GroupNetSearchModelArticleItem)) {
      try
      {
        Object localObject2 = (ImageView)paramISearchResultView.h().findViewById(2131450036);
        ImageView localImageView = (ImageView)paramISearchResultView.h().findViewById(2131431458);
        TextView localTextView = (TextView)paramISearchResultView.h().findViewById(2131435186);
        if ((localObject2 != null) && (localImageView != null) && (localTextView != null))
        {
          ((ImageView)localObject2).setVisibility(4);
          localImageView.setVisibility(4);
          localTextView.setVisibility(4);
        }
        localObject1 = (GroupNetSearchModelArticleItem)paramISearchResultModel;
        int i = paramISearchResultView.h().getResources().getDimensionPixelSize(2131298168);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(((GroupNetSearchModelArticleItem)localObject1).m(), i, i);
        paramISearchResultView.g().setImageDrawable(localURLDrawable);
        if ((((GroupNetSearchModelArticleItem)localObject1).i() != null) && (((GroupNetSearchModelArticleItem)localObject1).i().video_article.has()) && (((GroupNetSearchModelArticleItem)localObject1).i().video_article.get() == SearchUtils.f) && (localObject2 != null) && (localImageView != null))
        {
          ((ImageView)localObject2).setVisibility(0);
          localImageView.getBackground().setAlpha(25);
          localImageView.setVisibility(0);
        }
        if ((((GroupNetSearchModelArticleItem)paramISearchResultModel).j() != null) && (localTextView != null))
        {
          localTextView.setVisibility(0);
          if (paramISearchResultView.b() != null) {
            paramISearchResultView.b().setMaxWidth(SearchUtils.a(190.0F, paramISearchResultView.h().getResources()));
          }
          if ((localObject1 != null) && (((GroupNetSearchModelArticleItem)localObject1).j() != null))
          {
            localObject2 = ((GroupNetSearchModelArticleItem)localObject1).j().hotword.get();
            i = ((GroupNetSearchModelArticleItem)localObject1).j().hotword_type.get();
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F27", "0X8006F27", 0, 0, ((GroupNetSearchModelArticleItem)localObject1).g(), (String)localObject2, String.valueOf(i), "");
          }
        }
        if (paramISearchResultModel.a() != null) {
          break label526;
        }
        paramISearchResultView.d().setVisibility(8);
      }
      catch (Exception paramISearchResultView)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("groupnetsearch model construct error:");
        ((StringBuilder)localObject1).append(paramISearchResultView.toString());
        QLog.d("SearchResultPresenter", 1, ((StringBuilder)localObject1).toString());
      }
    } else {
      b(paramISearchResultModel, paramISearchResultView);
    }
    label526:
    if (!TextUtils.isEmpty(paramISearchResultModel.c())) {
      try
      {
        if (Integer.valueOf(paramISearchResultModel.c()).intValue() == ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getShoppingAccount())
        {
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportEshopExpo("search", "");
          return;
        }
      }
      catch (Exception paramISearchResultModel)
      {
        QLog.e("SearchResultPresenter", 1, "report expo failed", paramISearchResultModel);
      }
    }
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView, Bitmap paramBitmap)
  {
    if ((paramISearchResultView.g() != null) && (!(paramISearchResultModel instanceof GroupNetSearchModelArticleItem))) {
      paramISearchResultView.g().setImageBitmap(paramBitmap);
    }
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if ((paramISearchResultView.g() != null) && (!(paramISearchResultModel instanceof GroupNetSearchModelArticleItem)) && ((paramISearchResultModel instanceof IFaceModel))) {
      paramISearchResultView.g().setImageDrawable(SearchUtils.a(this.a, paramISearchResultModel));
    }
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    paramISearchResultView = paramISearchResultView.h();
    if (paramISearchResultView != null) {
      paramISearchResultView.setOnClickListener(new SearchResultPresenter.1(this, paramISearchResultModel));
    }
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    paramISearchResultView = paramISearchResultView.h();
    if (paramISearchResultModel.ck_() == 0)
    {
      Integer localInteger1 = (Integer)paramISearchResultView.getTag(2131449866);
      Integer localInteger2 = (Integer)paramISearchResultView.getTag(2131449868);
      if ((localInteger1 != null) && (localInteger2 != null)) {
        SearchViewUtils.a(paramISearchResultModel, localInteger1.intValue(), localInteger2.intValue());
      }
    }
    int j = paramISearchResultModel.ck_();
    int k = paramISearchResultModel.cl_();
    int i;
    if ((paramISearchResultModel instanceof ISearchResultPositionModel)) {
      i = ((ISearchResultPositionModel)paramISearchResultModel).af;
    } else {
      i = 0;
    }
    SearchViewUtils.a(j, k, paramISearchResultView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.presenter.SearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */