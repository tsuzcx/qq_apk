package cooperation.qqfav.globalsearch;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.SearchResultView;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class FavoriteSearchResultGroupPresenter
  implements IPresenter<ISearchResultGroupModel, ISearchResultView>
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
      paramISearchResultView.b().setImageDrawable(paramISearchResultGroupModel);
      paramISearchResultView.a().setText(GroupSearchModelFavorite.b);
      if (localGroupSearchModelFavorite.a() != null) {
        break label204;
      }
      i = 0;
      if (i > 10) {
        break label218;
      }
    }
    label204:
    label218:
    for (paramISearchResultGroupModel = String.valueOf(i);; paramISearchResultGroupModel = "10+")
    {
      ((TextView)paramISearchResultView.a().findViewById(2131365693)).setText(String.format("%s条与\"", new Object[] { paramISearchResultGroupModel }));
      paramISearchResultGroupModel = (TextView)paramISearchResultView.a().findViewById(2131365687);
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        paramISearchResultGroupModel.setTextColor(Color.parseColor("#004080"));
      }
      paramISearchResultGroupModel.setText(localGroupSearchModelFavorite.b());
      ((TextView)paramISearchResultView.a().findViewById(2131365694)).setText("\"相关收藏");
      paramISearchResultView.a().setVisibility(8);
      paramISearchResultView.a().setOnClickListener(new FavoriteSearchResultGroupPresenter.1(this, localGroupSearchModelFavorite));
      return;
      i = localGroupSearchModelFavorite.a().size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */