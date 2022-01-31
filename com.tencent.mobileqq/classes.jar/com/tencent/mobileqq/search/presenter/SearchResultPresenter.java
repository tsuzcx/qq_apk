package com.tencent.mobileqq.search.presenter;

import ahgl;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.model.GroupNetSearchModelArticleItem;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;

public class SearchResultPresenter
  implements IFacePresenter
{
  private FaceDecoder a;
  
  public SearchResultPresenter(FaceDecoder paramFaceDecoder)
  {
    this.a = paramFaceDecoder;
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    c(paramISearchResultModel, paramISearchResultView);
    a(paramISearchResultView, paramISearchResultModel);
    if (paramISearchResultView.f() != null) {
      paramISearchResultView.f().setText(paramISearchResultModel.b());
    }
    if (paramISearchResultView.g() != null) {
      paramISearchResultView.g().setText(paramISearchResultModel.c());
    }
    if (paramISearchResultView.h() != null) {
      paramISearchResultView.h().setText(paramISearchResultModel.d());
    }
    if (paramISearchResultView.b() != null)
    {
      if (!paramISearchResultModel.a()) {
        break label462;
      }
      paramISearchResultView.b().setVisibility(0);
    }
    for (;;)
    {
      d(paramISearchResultModel, paramISearchResultView);
      if (!(paramISearchResultModel instanceof GroupNetSearchModelArticleItem)) {
        break;
      }
      try
      {
        Object localObject = (ImageView)paramISearchResultView.a().findViewById(2131371092);
        ImageView localImageView = (ImageView)paramISearchResultView.a().findViewById(2131364453);
        TextView localTextView = (TextView)paramISearchResultView.a().findViewById(2131371093);
        if ((localObject != null) && (localImageView != null) && (localTextView != null))
        {
          ((ImageView)localObject).setVisibility(4);
          localImageView.setVisibility(4);
          localTextView.setVisibility(4);
        }
        GroupNetSearchModelArticleItem localGroupNetSearchModelArticleItem = (GroupNetSearchModelArticleItem)paramISearchResultModel;
        int i = paramISearchResultView.a().getResources().getDimensionPixelSize(2131559207);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(localGroupNetSearchModelArticleItem.c(), i, i);
        paramISearchResultView.a().setImageDrawable(localURLDrawable);
        if ((localGroupNetSearchModelArticleItem.a() != null) && (localGroupNetSearchModelArticleItem.a().video_article.has()) && (localGroupNetSearchModelArticleItem.a().video_article.get() == SearchUtils.a) && (localObject != null) && (localImageView != null))
        {
          ((ImageView)localObject).setVisibility(0);
          localImageView.getBackground().setAlpha(25);
          localImageView.setVisibility(0);
        }
        if ((((GroupNetSearchModelArticleItem)paramISearchResultModel).a() != null) && (localTextView != null))
        {
          localTextView.setVisibility(0);
          if (paramISearchResultView.e() != null) {
            paramISearchResultView.e().setMaxWidth(AIOUtils.a(190.0F, paramISearchResultView.a().getResources()));
          }
          if ((localGroupNetSearchModelArticleItem != null) && (localGroupNetSearchModelArticleItem.a() != null))
          {
            localObject = localGroupNetSearchModelArticleItem.a().hotword.get();
            i = localGroupNetSearchModelArticleItem.a().hotword_type.get();
            PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F27", "0X8006F27", 0, 0, localGroupNetSearchModelArticleItem.b(), (String)localObject, String.valueOf(i), "");
          }
        }
        if (paramISearchResultModel.c() == null) {
          paramISearchResultView.g().setVisibility(8);
        }
        return;
      }
      catch (Exception paramISearchResultModel)
      {
        label462:
        QLog.d("SearchResultPresenter", 1, "groupnetsearch model construct error:" + paramISearchResultModel.toString());
        return;
      }
      paramISearchResultView.b().setVisibility(8);
    }
    b(paramISearchResultModel, paramISearchResultView);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView, Bitmap paramBitmap)
  {
    if ((paramISearchResultView.a() != null) && (!(paramISearchResultModel instanceof GroupNetSearchModelArticleItem))) {
      paramISearchResultView.a().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(ISearchResultView paramISearchResultView, ISearchResultModel paramISearchResultModel)
  {
    if ((paramISearchResultView.e() != null) && (paramISearchResultModel != null)) {
      paramISearchResultView.e().setText(paramISearchResultModel.a());
    }
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if ((paramISearchResultView.a() != null) && (!(paramISearchResultModel instanceof GroupNetSearchModelArticleItem)) && ((paramISearchResultModel instanceof IFaceModel))) {
      paramISearchResultView.a().setImageDrawable(SearchUtils.a(this.a, paramISearchResultModel));
    }
  }
  
  public void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    paramISearchResultView = paramISearchResultView.a();
    if (paramISearchResultModel.c() == 0)
    {
      localObject = (Integer)paramISearchResultView.getTag(2131362081);
      Integer localInteger = (Integer)paramISearchResultView.getTag(2131362080);
      if ((localObject != null) && (localInteger != null)) {
        SearchViewUtils.a(paramISearchResultModel, ((Integer)localObject).intValue(), localInteger.intValue());
      }
    }
    SearchViewUtils.a(paramISearchResultModel.c(), paramISearchResultModel.d(), paramISearchResultView);
    paramISearchResultModel = paramISearchResultView.findViewById(2131365658);
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    Object localObject = paramISearchResultView.getResources();
    if (paramISearchResultModel != null)
    {
      if (bool)
      {
        paramISearchResultView.setBackgroundColor(((Resources)localObject).getColor(2131492947));
        paramISearchResultModel.setBackgroundResource(2130838576);
        return;
      }
      paramISearchResultView.setBackgroundColor(((Resources)localObject).getColor(2131492968));
      paramISearchResultModel.setBackgroundResource(2130838575);
      return;
    }
    if (bool)
    {
      paramISearchResultView.setBackgroundResource(2130838576);
      return;
    }
    paramISearchResultView.setBackgroundResource(2130838575);
  }
  
  protected void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    paramISearchResultView = paramISearchResultView.a();
    if (paramISearchResultView != null) {
      paramISearchResultView.setOnClickListener(new ahgl(this, paramISearchResultModel));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */