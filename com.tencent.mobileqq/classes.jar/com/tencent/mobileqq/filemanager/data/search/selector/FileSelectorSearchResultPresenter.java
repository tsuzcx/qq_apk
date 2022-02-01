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
    FileSelectorSearchResultModel localFileSelectorSearchResultModel = (FileSelectorSearchResultModel)paramISearchResultModel;
    View localView = paramISearchResultView.h();
    paramISearchResultView = (AsyncImageView)paramISearchResultView.g();
    String str = localFileSelectorSearchResultModel.j();
    int i = localFileSelectorSearchResultModel.l();
    if (!TextUtils.isEmpty(str)) {
      FileManagerUtil.a(paramISearchResultView, str, i);
    } else {
      paramISearchResultView.setDefaultImage(FileManagerUtil.c(i));
    }
    paramISearchResultView.setOnClickListener(new FileSelectorSearchResultPresenter.1(this, paramISearchResultModel));
    paramISearchResultView = (CheckBox)localView.findViewById(2131433116);
    if (localFileSelectorSearchResultModel.i() > 1) {
      paramISearchResultView.setVisibility(8);
    } else {
      paramISearchResultView.setVisibility(0);
    }
    paramISearchResultView.setChecked(localFileSelectorSearchResultModel.m());
    localView.setOnClickListener(new FileSelectorSearchResultPresenter.2(this, paramISearchResultModel));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */