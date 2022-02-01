package com.tencent.mobileqq.search.presenter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.GroupNetSearchModelArticleItem;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;

public class SearchResultPresenter
  implements IFacePresenter<ISearchResultModel, ISearchResultView>
{
  private IFaceDecoder a;
  
  public SearchResultPresenter(IFaceDecoder paramIFaceDecoder)
  {
    this.a = paramIFaceDecoder;
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if ((paramISearchResultView.b() != null) && (!(paramISearchResultModel instanceof GroupNetSearchModelArticleItem)) && ((paramISearchResultModel instanceof IFaceModel))) {
      paramISearchResultView.b().setImageDrawable(SearchUtils.a(this.a, paramISearchResultModel));
    }
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView, Bitmap paramBitmap)
  {
    if ((paramISearchResultView.b() != null) && (!(paramISearchResultModel instanceof GroupNetSearchModelArticleItem))) {
      paramISearchResultView.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(ISearchResultView paramISearchResultView, ISearchResultModel paramISearchResultModel)
  {
    if ((paramISearchResultView.a() != null) && (paramISearchResultModel != null)) {
      paramISearchResultView.a().setText(paramISearchResultModel.a());
    }
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    d(paramISearchResultModel, paramISearchResultView);
    a(paramISearchResultView, paramISearchResultModel);
    if (paramISearchResultView.b() != null) {
      paramISearchResultView.b().setText(paramISearchResultModel.b());
    }
    if (paramISearchResultView.c() != null) {
      paramISearchResultView.c().setText(paramISearchResultModel.c());
    }
    if (paramISearchResultView.d() != null) {
      paramISearchResultView.d().setText(paramISearchResultModel.d());
    }
    if (paramISearchResultView.a() != null)
    {
      if (paramISearchResultModel.a()) {
        paramISearchResultView.a().setVisibility(0);
      }
    }
    else
    {
      c(paramISearchResultModel, paramISearchResultView);
      if (!(paramISearchResultModel instanceof GroupNetSearchModelArticleItem)) {
        break label564;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = (ImageView)paramISearchResultView.a().findViewById(2131381805);
        ImageView localImageView = (ImageView)paramISearchResultView.a().findViewById(2131365419);
        TextView localTextView = (TextView)paramISearchResultView.a().findViewById(2131368570);
        if ((localObject != null) && (localImageView != null) && (localTextView != null))
        {
          ((ImageView)localObject).setVisibility(4);
          localImageView.setVisibility(4);
          localTextView.setVisibility(4);
        }
        GroupNetSearchModelArticleItem localGroupNetSearchModelArticleItem = (GroupNetSearchModelArticleItem)paramISearchResultModel;
        int i = paramISearchResultView.a().getResources().getDimensionPixelSize(2131297524);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(localGroupNetSearchModelArticleItem.c(), i, i);
        paramISearchResultView.b().setImageDrawable(localURLDrawable);
        if ((localGroupNetSearchModelArticleItem.a() != null) && (localGroupNetSearchModelArticleItem.a().video_article.has()) && (localGroupNetSearchModelArticleItem.a().video_article.get() == SearchUtils.a) && (localObject != null) && (localImageView != null))
        {
          ((ImageView)localObject).setVisibility(0);
          localImageView.getBackground().setAlpha(25);
          localImageView.setVisibility(0);
        }
        if ((((GroupNetSearchModelArticleItem)paramISearchResultModel).a() != null) && (localTextView != null))
        {
          localTextView.setVisibility(0);
          if (paramISearchResultView.a() != null) {
            paramISearchResultView.a().setMaxWidth(AIOUtils.a(190.0F, paramISearchResultView.a().getResources()));
          }
          if ((localGroupNetSearchModelArticleItem != null) && (localGroupNetSearchModelArticleItem.a() != null))
          {
            localObject = localGroupNetSearchModelArticleItem.a().hotword.get();
            i = localGroupNetSearchModelArticleItem.a().hotword_type.get();
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F27", "0X8006F27", 0, 0, localGroupNetSearchModelArticleItem.a(), (String)localObject, String.valueOf(i), "");
          }
        }
        if (paramISearchResultModel.c() == null) {
          paramISearchResultView.c().setVisibility(8);
        }
      }
      catch (Exception paramISearchResultView)
      {
        QLog.d("SearchResultPresenter", 1, "groupnetsearch model construct error:" + paramISearchResultView.toString());
        continue;
      }
      if (!TextUtils.isEmpty(paramISearchResultModel.b())) {}
      try
      {
        if (Integer.valueOf(paramISearchResultModel.b()).intValue() == 36) {
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportEshopExpo("search", "");
        }
        return;
      }
      catch (Exception paramISearchResultModel)
      {
        label564:
        QLog.e("SearchResultPresenter", 1, "report expo failed", paramISearchResultModel);
      }
      paramISearchResultView.a().setVisibility(8);
      break;
      a(paramISearchResultModel, paramISearchResultView);
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
    if (paramISearchResultModel.a() == 0)
    {
      Integer localInteger1 = (Integer)paramISearchResultView.getTag(2131381650);
      Integer localInteger2 = (Integer)paramISearchResultView.getTag(2131381652);
      if ((localInteger1 != null) && (localInteger2 != null)) {
        SearchViewUtils.a(paramISearchResultModel, localInteger1.intValue(), localInteger2.intValue());
      }
    }
    int j = paramISearchResultModel.a();
    int k = paramISearchResultModel.b();
    if ((paramISearchResultModel instanceof ISearchResultPositionModel)) {}
    for (int i = ((ISearchResultPositionModel)paramISearchResultModel).u;; i = 0)
    {
      SearchViewUtils.a(j, k, paramISearchResultView, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */