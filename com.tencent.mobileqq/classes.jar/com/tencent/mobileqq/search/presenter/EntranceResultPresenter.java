package com.tencent.mobileqq.search.presenter;

import ahuh;
import ahui;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.view.SearchResultEntranceView;
import pb.unite.search.DynamicSearch.SubItem;

public class EntranceResultPresenter
  implements IPresenter
{
  public void a(SearchResultModelForEntrance paramSearchResultModelForEntrance, SearchResultEntranceView paramSearchResultEntranceView)
  {
    paramSearchResultEntranceView.a(paramSearchResultModelForEntrance);
    paramSearchResultEntranceView.a().setOnClickListener(new ahuh(this, paramSearchResultModelForEntrance));
    if (paramSearchResultModelForEntrance.a != null)
    {
      if (TextUtils.isEmpty(paramSearchResultModelForEntrance.a.jump_url.get().toStringUtf8())) {
        paramSearchResultEntranceView.a().setOnTouchListener(new ahui(this));
      }
    }
    else {
      return;
    }
    paramSearchResultEntranceView.a().setOnTouchListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.EntranceResultPresenter
 * JD-Core Version:    0.7.0.1
 */