package com.tencent.mobileqq.filemanager.data.search.selector;

import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;

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
    FileSelectorSearchResultModel localFileSelectorSearchResultModel = (FileSelectorSearchResultModel)paramISearchResultModel;
    View localView = paramISearchResultView.a();
    paramISearchResultView = (AsyncImageView)paramISearchResultView.b();
    String str = localFileSelectorSearchResultModel.c();
    int i = localFileSelectorSearchResultModel.e();
    if (!TextUtils.isEmpty(str))
    {
      FileManagerUtil.a(paramISearchResultView, str, i);
      paramISearchResultView.setOnClickListener(new FileSelectorSearchResultPresenter.1(this, paramISearchResultModel));
      paramISearchResultView = (CheckBox)localView.findViewById(2131366932);
      if (localFileSelectorSearchResultModel.d() <= 1) {
        break label336;
      }
      paramISearchResultView.setVisibility(8);
    }
    for (;;)
    {
      paramISearchResultView.setChecked(localFileSelectorSearchResultModel.b());
      localView.setOnClickListener(new FileSelectorSearchResultPresenter.2(this, paramISearchResultModel));
      return;
      paramISearchResultView.setDefaultImage(FileManagerUtil.a(i));
      break;
      label336:
      paramISearchResultView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */