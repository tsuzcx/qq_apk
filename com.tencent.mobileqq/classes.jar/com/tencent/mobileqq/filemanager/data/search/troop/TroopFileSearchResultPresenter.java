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
    if ((paramISearchResultView.a() != null) && (!TextUtils.isEmpty(paramISearchResultModel.b())))
    {
      paramISearchResultView.a().setVisibility(0);
      paramISearchResultView.a().setText(paramISearchResultModel.b());
    }
    if ((paramISearchResultView.b() != null) && (!TextUtils.isEmpty(paramISearchResultModel.c())))
    {
      paramISearchResultView.b().setVisibility(0);
      paramISearchResultView.b().setText(paramISearchResultModel.c());
    }
    if ((paramISearchResultView.c() != null) && (!TextUtils.isEmpty(paramISearchResultModel.a())))
    {
      paramISearchResultView.c().setVisibility(0);
      paramISearchResultView.c().setText(paramISearchResultModel.a());
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
    if (FileUtils.fileExistsAndNotEmpty(str)) {
      FileManagerUtil.a(localAsyncImageView, str, FileManagerUtil.a((String)localObject));
    } else {
      localAsyncImageView.setDefaultImage(FileManagerUtil.b((String)localObject));
    }
    paramISearchResultView = paramISearchResultView.a();
    if (paramISearchResultView != null) {
      paramISearchResultView.setOnClickListener(new TroopFileSearchResultPresenter.1(this, paramISearchResultModel));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */