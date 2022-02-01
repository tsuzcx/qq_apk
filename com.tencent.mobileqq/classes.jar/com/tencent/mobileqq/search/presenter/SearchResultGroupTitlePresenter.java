package com.tencent.mobileqq.search.presenter;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.SearchResultGroupTitleView;

public class SearchResultGroupTitlePresenter
  implements IPresenter<IModel, ISearchResultGroupView>
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
        break label372;
      }
      localObject = "";
    }
    label233:
    label367:
    label372:
    for (;;)
    {
      if (((GroupSearchModeTitle)paramIModel).b())
      {
        String str = localGroupSearchModeTitle.b();
        if (!TextUtils.isEmpty(str))
        {
          str = SearchUtils.a(localSearchResultGroupTitleView.a(), 10.0F * SearchUtils.a(localSearchResultGroupTitleView.a(), HardCodeUtil.a(2131713605)), 1, str, str, false, false, true).toString();
          localObject = new SpannableString(str + "-" + (String)localObject);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), 0, str.length(), 34);
          localSearchResultGroupTitleView.a().setText((CharSequence)localObject);
          if (!localGroupSearchModeTitle.a()) {
            break label342;
          }
          paramISearchResultGroupView.b().setText(localGroupSearchModeTitle.c());
          paramISearchResultGroupView.b().setVisibility(0);
          if (TextUtils.equals(localGroupSearchModeTitle.a(), HardCodeUtil.a(2131697845))) {
            UniteSearchReportController.a(null, 0, UniteSearchActivity.d, "0X800BA24", 0, 0, null, null);
          }
          paramISearchResultGroupView.b().setTag(2131381652, Integer.valueOf(-1));
          if ((paramIModel instanceof ISearchResultGroupModel))
          {
            paramIModel = (ISearchResultGroupModel)paramIModel;
            paramISearchResultGroupView.b().setOnClickListener(new SearchResultGroupTitlePresenter.1(this, paramIModel));
          }
          paramIModel = paramISearchResultGroupView.a().getTag(2131381652);
          if (!(paramIModel instanceof Integer)) {
            break label367;
          }
        }
      }
      for (int i = ((Integer)paramIModel).intValue();; i = -1)
      {
        if (i > 0) {
          localSearchResultGroupTitleView.a(true);
        }
        while (i != 0)
        {
          return;
          localSearchResultGroupTitleView.a().setText((CharSequence)localObject);
          break;
          localSearchResultGroupTitleView.a().setText((CharSequence)localObject);
          break;
          paramISearchResultGroupView.b().setVisibility(8);
          break label233;
        }
        localSearchResultGroupTitleView.a(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultGroupTitlePresenter
 * JD-Core Version:    0.7.0.1
 */