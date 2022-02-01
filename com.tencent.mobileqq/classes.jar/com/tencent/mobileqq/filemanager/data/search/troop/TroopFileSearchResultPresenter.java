package com.tencent.mobileqq.filemanager.data.search.troop;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.search.base.presenter.IPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.utils.FileUtils;

public class TroopFileSearchResultPresenter
  implements IPresenter<ISearchResultModel, ISearchResultView>
{
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if ((paramISearchResultView.b() != null) && (!TextUtils.isEmpty(paramISearchResultModel.d())))
    {
      paramISearchResultView.b().setVisibility(0);
      paramISearchResultView.b().setText(paramISearchResultModel.d());
    }
    if ((paramISearchResultView.c() != null) && (!TextUtils.isEmpty(paramISearchResultModel.e())))
    {
      paramISearchResultView.c().setVisibility(0);
      paramISearchResultView.c().setText(paramISearchResultModel.e());
    }
    if ((paramISearchResultView.d() != null) && (!TextUtils.isEmpty(paramISearchResultModel.a())))
    {
      paramISearchResultView.d().setVisibility(0);
      paramISearchResultView.d().setText(paramISearchResultModel.a());
    }
    if ((paramISearchResultModel.f() == null) && (paramISearchResultView.e() != null)) {
      paramISearchResultView.e().setVisibility(8);
    }
    if ((paramISearchResultView.e() != null) && (paramISearchResultModel.f() != null))
    {
      paramISearchResultView.e().setVisibility(0);
      paramISearchResultView.e().setText(paramISearchResultModel.f());
    }
    AsyncImageView localAsyncImageView = (AsyncImageView)paramISearchResultView.g();
    Object localObject = (TroopFileSearchResultModel)paramISearchResultModel;
    String str = ((TroopFileSearchResultModel)localObject).i();
    localObject = ((TroopFileSearchResultModel)localObject).j();
    if (FileUtils.fileExistsAndNotEmpty(str)) {
      FileManagerUtil.a(localAsyncImageView, str, FileManagerUtil.c((String)localObject));
    } else {
      localAsyncImageView.setDefaultImage(FileManagerUtil.i((String)localObject));
    }
    paramISearchResultView = paramISearchResultView.h();
    if (paramISearchResultView != null) {
      paramISearchResultView.setOnClickListener(new TroopFileSearchResultPresenter.1(this, paramISearchResultModel));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */