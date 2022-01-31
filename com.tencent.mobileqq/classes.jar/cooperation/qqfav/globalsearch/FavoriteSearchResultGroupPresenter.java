package cooperation.qqfav.globalsearch;

import amwu;
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

public class FavoriteSearchResultGroupPresenter
  implements IPresenter
{
  public void a(ISearchResultGroupModel paramISearchResultGroupModel, ISearchResultView paramISearchResultView)
  {
    GroupSearchModelFavorite localGroupSearchModelFavorite;
    int i;
    if (((paramISearchResultGroupModel instanceof GroupSearchModelFavorite)) && ((paramISearchResultView instanceof SearchResultView)))
    {
      localGroupSearchModelFavorite = (GroupSearchModelFavorite)paramISearchResultGroupModel;
      paramISearchResultView = (SearchResultView)paramISearchResultView;
      paramISearchResultGroupModel = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", URLDrawable.URLDrawableOptions.obtain());
      if ((paramISearchResultGroupModel != null) && (paramISearchResultGroupModel.getStatus() == 2)) {
        paramISearchResultGroupModel.restartDownload();
      }
      paramISearchResultView.a().setImageDrawable(paramISearchResultGroupModel);
      paramISearchResultView.e().setText("我的收藏");
      if (localGroupSearchModelFavorite.a() != null) {
        break label180;
      }
      i = 0;
      if (i > 10) {
        break label194;
      }
    }
    label180:
    label194:
    for (paramISearchResultGroupModel = String.valueOf(i);; paramISearchResultGroupModel = "10+")
    {
      ((TextView)paramISearchResultView.a().findViewById(2131366403)).setText(String.format("%s条与\"", new Object[] { paramISearchResultGroupModel }));
      ((TextView)paramISearchResultView.a().findViewById(2131366404)).setText(localGroupSearchModelFavorite.b());
      ((TextView)paramISearchResultView.a().findViewById(2131366405)).setText("\"相关收藏");
      paramISearchResultView.b().setVisibility(8);
      paramISearchResultView.a().setOnClickListener(new amwu(this, localGroupSearchModelFavorite));
      return;
      i = localGroupSearchModelFavorite.a().size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */