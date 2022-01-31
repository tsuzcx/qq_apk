package com.tencent.mobileqq.filemanager.data.search;

import adjf;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.SearchResultView;
import java.util.List;

public class FileSearchResultGroupPresenter
  implements IPresenter
{
  public void a(ISearchResultGroupModel paramISearchResultGroupModel, ISearchResultView paramISearchResultView)
  {
    Object localObject;
    if (((paramISearchResultGroupModel instanceof GroupSearchModelFileEntity)) && ((paramISearchResultView instanceof SearchResultView)))
    {
      paramISearchResultGroupModel = (GroupSearchModelFileEntity)paramISearchResultGroupModel;
      paramISearchResultView = (SearchResultView)paramISearchResultView;
      localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170310/2490d524bbf84417929137e35d93b0c2.png", URLDrawable.URLDrawableOptions.obtain());
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 2)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramISearchResultView.a().setImageDrawable((Drawable)localObject);
      paramISearchResultView.e().setText("我的文件");
      localObject = (TextView)paramISearchResultView.a().findViewById(2131366403);
      if (paramISearchResultGroupModel.a() != null) {
        break label177;
      }
    }
    label177:
    for (int i = 0;; i = paramISearchResultGroupModel.a().size())
    {
      ((TextView)localObject).setText(String.format("%d条与\"", new Object[] { Integer.valueOf(i) }));
      ((TextView)paramISearchResultView.a().findViewById(2131366404)).setText(paramISearchResultGroupModel.b());
      ((TextView)paramISearchResultView.a().findViewById(2131366405)).setText("\"相关文件");
      paramISearchResultView.b().setVisibility(8);
      paramISearchResultView.a().setOnClickListener(new adjf(this, paramISearchResultGroupModel));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */