package cooperation.qqfav.globalsearch;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFavorite;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FavoriteSearchResultGroupPresenter$1
  implements View.OnClickListener
{
  FavoriteSearchResultGroupPresenter$1(FavoriteSearchResultGroupPresenter paramFavoriteSearchResultGroupPresenter, GroupSearchModelFavorite paramGroupSearchModelFavorite) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessGroupModelGroupSearchModelFavorite.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchResultGroupPresenter.1
 * JD-Core Version:    0.7.0.1
 */