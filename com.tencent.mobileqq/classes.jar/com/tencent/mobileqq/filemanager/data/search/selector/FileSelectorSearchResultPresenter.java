package com.tencent.mobileqq.filemanager.data.search.selector;

import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.search.base.presenter.IPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.model.ISearchResultModel;

public class FileSelectorSearchResultPresenter
  implements IPresenter<ISearchResultModel, ISearchResultView>
{
  private OnFileSelectorSearchCheckedListener a;
  
  public void a(OnFileSelectorSearchCheckedListener paramOnFileSelectorSearchCheckedListener)
  {
    this.a = paramOnFileSelectorSearchCheckedListener;
  }
  
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
    FileSelectorSearchResultModel localFileSelectorSearchResultModel = (FileSelectorSearchResultModel)paramISearchResultModel;
    View localView = paramISearchResultView.a();
    paramISearchResultView = (AsyncImageView)paramISearchResultView.b();
    String str = localFileSelectorSearchResultModel.c();
    int i = localFileSelectorSearchResultModel.c();
    if (!TextUtils.isEmpty(str)) {
      FileManagerUtil.a(paramISearchResultView, str, i);
    } else {
      paramISearchResultView.setDefaultImage(FileManagerUtil.a(i));
    }
    paramISearchResultView.setOnClickListener(new FileSelectorSearchResultPresenter.1(this, paramISearchResultModel));
    paramISearchResultView = (CheckBox)localView.findViewById(2131366794);
    if (localFileSelectorSearchResultModel.e_() > 1) {
      paramISearchResultView.setVisibility(8);
    } else {
      paramISearchResultView.setVisibility(0);
    }
    paramISearchResultView.setChecked(localFileSelectorSearchResultModel.b());
    localView.setOnClickListener(new FileSelectorSearchResultPresenter.2(this, paramISearchResultModel));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */