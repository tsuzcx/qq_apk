package com.tencent.mobileqq.kandian.biz.ugc.selectmember.search;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.repo.follow.FollowingMember;
import com.tencent.mobileqq.search.base.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import java.util.HashSet;
import java.util.Set;

public class FollowSearchResultPresenter
  extends SearchResultPresenter
{
  private ContactSearchResultPresenter.OnActionListener jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter$OnActionListener;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  FollowSearchResultPresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener, Set<String> paramSet)
  {
    super(paramIFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter$OnActionListener = paramOnActionListener;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if ((paramISearchResultModel instanceof FollowingSearchResultModel))
    {
      paramISearchResultModel = ((FollowingSearchResultModel)paramISearchResultModel).a().b();
      paramISearchResultView = paramISearchResultView.b();
      Drawable localDrawable = paramISearchResultView.getResources().getDrawable(2130840321);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      paramISearchResultModel = URLDrawable.getDrawable(paramISearchResultModel, localURLDrawableOptions);
      paramISearchResultModel.setTag(URLDrawableDecodeHandler.a(140, 140));
      paramISearchResultModel.setDecodeHandler(URLDrawableDecodeHandler.n);
      paramISearchResultView.setImageDrawable(paramISearchResultModel);
      return;
    }
    super.b(paramISearchResultModel, paramISearchResultView);
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.c(paramISearchResultModel, paramISearchResultView);
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter$OnActionListener != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramISearchResultModel.a()))) {
      paramISearchResultView.a().setOnClickListener(new FollowSearchResultPresenter.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.search.FollowSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */