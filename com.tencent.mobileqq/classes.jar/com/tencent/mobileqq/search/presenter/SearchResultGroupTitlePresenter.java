package com.tencent.mobileqq.search.presenter;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.presenter.IPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.business.group.view.SearchResultGroupTitleView;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;

public class SearchResultGroupTitlePresenter
  implements IPresenter<IModel, ISearchResultGroupView>
{
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    SearchResultGroupTitleView localSearchResultGroupTitleView = (SearchResultGroupTitleView)paramISearchResultGroupView;
    if ((paramIModel instanceof GroupSearchModeTitle))
    {
      GroupSearchModeTitle localGroupSearchModeTitle = (GroupSearchModeTitle)paramIModel;
      String str = localGroupSearchModeTitle.a();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "";
      }
      if (localGroupSearchModeTitle.b())
      {
        str = localGroupSearchModeTitle.b();
        if (!TextUtils.isEmpty(str))
        {
          str = SearchUtils.a(localSearchResultGroupTitleView.a(), SearchUtils.a(localSearchResultGroupTitleView.a(), HardCodeUtil.a(2131713572)) * 10.0F, 1, str, str, false, false, true).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("-");
          localStringBuilder.append((String)localObject);
          localObject = new SpannableString(localStringBuilder.toString());
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), 0, str.length(), 34);
          localSearchResultGroupTitleView.a().setText((CharSequence)localObject);
        }
        else
        {
          localSearchResultGroupTitleView.a().setText((CharSequence)localObject);
        }
      }
      else
      {
        localSearchResultGroupTitleView.a().setText((CharSequence)localObject);
      }
      if (localGroupSearchModeTitle.a())
      {
        paramISearchResultGroupView.b().setText(localGroupSearchModeTitle.c());
        paramISearchResultGroupView.b().setVisibility(0);
        if (TextUtils.equals(localGroupSearchModeTitle.a(), HardCodeUtil.a(2131697851))) {
          UniteSearchReportController.a(null, 0, UniteSearchActivity.d, "0X800BA24", 0, 0, null, null);
        }
      }
      else
      {
        paramISearchResultGroupView.b().setVisibility(8);
      }
    }
    Object localObject = paramISearchResultGroupView.b();
    int i = -1;
    ((TextView)localObject).setTag(2131380885, Integer.valueOf(-1));
    if ((paramIModel instanceof ISearchResultGroupModel))
    {
      paramIModel = (ISearchResultGroupModel)paramIModel;
      paramISearchResultGroupView.b().setOnClickListener(new SearchResultGroupTitlePresenter.1(this, paramIModel));
    }
    paramIModel = paramISearchResultGroupView.a().getTag(2131380885);
    if ((paramIModel instanceof Integer)) {
      i = ((Integer)paramIModel).intValue();
    }
    if (i > 0)
    {
      localSearchResultGroupTitleView.a(true);
      return;
    }
    if (i == 0) {
      localSearchResultGroupTitleView.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultGroupTitlePresenter
 * JD-Core Version:    0.7.0.1
 */