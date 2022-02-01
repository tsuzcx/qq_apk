package com.tencent.mobileqq.filemanager.data.search.troop;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.utils.FileUtils;

public class TroopFileSearchResultPresenter
  implements IPresenter<ISearchResultModel, ISearchResultView>
{
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if ((paramISearchResultView.a() != null) && (!TextUtils.isEmpty(paramISearchResultModel.a())))
    {
      paramISearchResultView.a().setVisibility(0);
      paramISearchResultView.a().setText(paramISearchResultModel.a());
    }
    if ((paramISearchResultView.b() != null) && (!TextUtils.isEmpty(paramISearchResultModel.b())))
    {
      paramISearchResultView.b().setVisibility(0);
      paramISearchResultView.b().setText(paramISearchResultModel.b());
    }
    if ((paramISearchResultView.c() != null) && (!TextUtils.isEmpty(paramISearchResultModel.c())))
    {
      paramISearchResultView.c().setVisibility(0);
      paramISearchResultView.c().setText(paramISearchResultModel.c());
    }
    if ((paramISearchResultModel.d() == null) && (paramISearchResultView.d() != null)) {
      paramISearchResultView.d().setVisibility(8);
    }
    if ((paramISearchResultView.d() != null) && (paramISearchResultModel.d() != null))
    {
      paramISearchResultView.d().setVisibility(0);
      paramISearchResultView.d().setText(paramISearchResultModel.d());
    }
    AsyncImageView localAsyncImageView = (AsyncImageView)paramISearchResultView.b();
    Object localObject = (TroopFileSearchResultModel)paramISearchResultModel;
    String str = ((TroopFileSearchResultModel)localObject).c();
    localObject = ((TroopFileSearchResultModel)localObject).d();
    if (FileUtils.b(str)) {
      FileManagerUtil.a(localAsyncImageView, str, FileManagerUtil.a((String)localObject));
    }
    for (;;)
    {
      paramISearchResultView = paramISearchResultView.a();
      if (paramISearchResultView != null) {
        paramISearchResultView.setOnClickListener(new TroopFileSearchResultPresenter.1(this, paramISearchResultModel));
      }
      return;
      localAsyncImageView.setDefaultImage(FileManagerUtil.b((String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */