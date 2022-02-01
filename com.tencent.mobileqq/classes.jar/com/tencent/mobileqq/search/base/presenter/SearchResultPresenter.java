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
    if ((paramISearchResultView.a() != null) && (paramISearchResultModel != null)) {
      paramISearchResultView.a().setText(paramISearchResultModel.b());
    }
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    d(paramISearchResultModel, paramISearchResultView);
    a(paramISearchResultView, paramISearchResultModel);
    if (paramISearchResultView.b() != null) {
      paramISearchResultView.b().setText(paramISearchResultModel.c());
    }
    if (paramISearchResultView.c() != null) {
      paramISearchResultView.c().setText(paramISearchResultModel.a());
    }
    if (paramISearchResultView.d() != null) {
      paramISearchResultView.d().setText(paramISearchResultModel.d());
    }
    if (paramISearchResultView.a() != null) {
      if (paramISearchResultModel.a()) {
        paramISearchResultView.a().setVisibility(0);
      } else {
        paramISearchResultView.a().setVisibility(8);
      }
    }
    c(paramISearchResultModel, paramISearchResultView);
    if ((paramISearchResultModel instanceof GroupNetSearchModelArticleItem)) {
      try
      {
        Object localObject2 = (ImageView)paramISearchResultView.a().findViewById(2131381027);
        ImageView localImageView = (ImageView)paramISearchResultView.a().findViewById(2131365284);
        TextView localTextView = (TextView)paramISearchResultView.a().findViewById(2131368313);
        if ((localObject2 != null) && (localImageView != null) && (localTextView != null))
        {
          ((ImageView)localObject2).setVisibility(4);
          localImageView.setVisibility(4);
          localTextView.setVisibility(4);
        }
        localObject1 = (GroupNetSearchModelArticleItem)paramISearchResultModel;
        int i = paramISearchResultView.a().getResources().getDimensionPixelSize(2131297515);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(((GroupNetSearchModelArticleItem)localObject1).c(), i, i);
        paramISearchResultView.b().setImageDrawable(localURLDrawable);
        if ((((GroupNetSearchModelArticleItem)localObject1).a() != null) && (((GroupNetSearchModelArticleItem)localObject1).a().video_article.has()) && (((GroupNetSearchModelArticleItem)localObject1).a().video_article.get() == SearchUtils.a) && (localObject2 != null) && (localImageView != null))
        {
          ((ImageView)localObject2).setVisibility(0);
          localImageView.getBackground().setAlpha(25);
          localImageView.setVisibility(0);
        }
        if ((((GroupNetSearchModelArticleItem)paramISearchResultModel).a() != null) && (localTextView != null))
        {
          localTextView.setVisibility(0);
          if (paramISearchResultView.a() != null) {
            paramISearchResultView.a().setMaxWidth(SearchUtils.a(190.0F, paramISearchResultView.a().getResources()));
          }
          if ((localObject1 != null) && (((GroupNetSearchModelArticleItem)localObject1).a() != null))
          {
            localObject2 = ((GroupNetSearchModelArticleItem)localObject1).a().hotword.get();
            i = ((GroupNetSearchModelArticleItem)localObject1).a().hotword_type.get();
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F27", "0X8006F27", 0, 0, ((GroupNetSearchModelArticleItem)localObject1).b(), (String)localObject2, String.valueOf(i), "");
          }
        }
        if (paramISearchResultModel.a() != null) {
          break label536;
        }
        paramISearchResultView.c().setVisibility(8);
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
    label536:
    if (!TextUtils.isEmpty(paramISearchResultModel.a())) {
      try
      {
        if (Integer.valueOf(paramISearchResultModel.a()).intValue() == ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getShoppingAccount())
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
    if ((paramISearchResultView.b() != null) && (!(paramISearchResultModel instanceof GroupNetSearchModelArticleItem))) {
      paramISearchResultView.b().setImageBitmap(paramBitmap);
    }
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if ((paramISearchResultView.b() != null) && (!(paramISearchResultModel instanceof GroupNetSearchModelArticleItem)) && ((paramISearchResultModel instanceof IFaceModel))) {
      paramISearchResultView.b().setImageDrawable(SearchUtils.a(this.a, paramISearchResultModel));
    }
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    paramISearchResultView = paramISearchResultView.a();
    if (paramISearchResultView != null) {
      paramISearchResultView.setOnClickListener(new SearchResultPresenter.1(this, paramISearchResultModel));
    }
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    paramISearchResultView = paramISearchResultView.a();
    if (paramISearchResultModel.b() == 0)
    {
      Integer localInteger1 = (Integer)paramISearchResultView.getTag(2131380883);
      Integer localInteger2 = (Integer)paramISearchResultView.getTag(2131380885);
      if ((localInteger1 != null) && (localInteger2 != null)) {
        SearchViewUtils.a(paramISearchResultModel, localInteger1.intValue(), localInteger2.intValue());
      }
    }
    int j = paramISearchResultModel.b();
    int k = paramISearchResultModel.f_();
    int i;
    if ((paramISearchResultModel instanceof ISearchResultPositionModel)) {
      i = ((ISearchResultPositionModel)paramISearchResultModel).u;
    } else {
      i = 0;
    }
    SearchViewUtils.a(j, k, paramISearchResultView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.presenter.SearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */