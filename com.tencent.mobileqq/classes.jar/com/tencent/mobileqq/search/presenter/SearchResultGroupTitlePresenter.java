package com.tencent.mobileqq.search.presenter;

import ahum;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.SearchResultGroupTitleView;
import com.tencent.mobileqq.theme.ThemeUtil;

public class SearchResultGroupTitlePresenter
  implements IPresenter
{
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    SearchResultGroupTitleView localSearchResultGroupTitleView = (SearchResultGroupTitleView)paramISearchResultGroupView;
    GroupSearchModeTitle localGroupSearchModeTitle;
    Object localObject;
    if ((paramIModel instanceof GroupSearchModeTitle))
    {
      localGroupSearchModeTitle = (GroupSearchModeTitle)paramIModel;
      localObject = localGroupSearchModeTitle.a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label389;
      }
      localObject = "";
    }
    label384:
    label389:
    for (;;)
    {
      if (((GroupSearchModeTitle)paramIModel).b())
      {
        String str = localGroupSearchModeTitle.b();
        if (!TextUtils.isEmpty(str))
        {
          str = SearchUtils.a(localSearchResultGroupTitleView.a(), 10.0F * SearchUtils.a(localSearchResultGroupTitleView.a(), "测"), 1, str, str, false).toString();
          localObject = new SpannableString(str + "-" + (String)localObject);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), 0, str.length(), 34);
          localSearchResultGroupTitleView.a().setText((CharSequence)localObject);
          if (!localGroupSearchModeTitle.a()) {
            break label342;
          }
          paramISearchResultGroupView.b().setText(localGroupSearchModeTitle.c());
          paramISearchResultGroupView.b().setVisibility(0);
          label198:
          paramISearchResultGroupView.b().setTag(2131362080, Integer.valueOf(-1));
          if ((paramIModel instanceof ISearchResultGroupModel))
          {
            paramIModel = (ISearchResultGroupModel)paramIModel;
            paramISearchResultGroupView.b().setOnClickListener(new ahum(this, paramIModel));
          }
          paramIModel = localSearchResultGroupTitleView.a().getResources();
          if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            break label356;
          }
          localSearchResultGroupTitleView.a.setBackgroundColor(paramIModel.getColor(2131492950));
          label278:
          paramIModel = paramISearchResultGroupView.a().getTag(2131362080);
          if (!(paramIModel instanceof Integer)) {
            break label384;
          }
        }
      }
      for (int i = ((Integer)paramIModel).intValue();; i = -1)
      {
        if (i > 0) {
          localSearchResultGroupTitleView.a(true);
        }
        label342:
        label356:
        while (i != 0)
        {
          return;
          localSearchResultGroupTitleView.a().setText((CharSequence)localObject);
          break;
          localSearchResultGroupTitleView.a().setText((CharSequence)localObject);
          break;
          paramISearchResultGroupView.b().setVisibility(8);
          break label198;
          localSearchResultGroupTitleView.a.setBackgroundColor(paramIModel.getColor(2131492949));
          break label278;
        }
        localSearchResultGroupTitleView.a(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultGroupTitlePresenter
 * JD-Core Version:    0.7.0.1
 */