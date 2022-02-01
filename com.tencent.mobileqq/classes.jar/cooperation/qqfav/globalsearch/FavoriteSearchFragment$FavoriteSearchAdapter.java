package cooperation.qqfav.globalsearch;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.SearchResultView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;

class FavoriteSearchFragment$FavoriteSearchAdapter
  extends BaseMvpFaceAdapter<ISearchResultModel, ISearchResultView>
  implements View.OnClickListener
{
  public FavoriteSearchFragment$FavoriteSearchAdapter(FavoriteSearchFragment paramFavoriteSearchFragment, ListView paramListView, IFaceDecoder paramIFaceDecoder)
  {
    super(paramListView, paramIFaceDecoder);
  }
  
  public IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    return new FavoriteSearchResultPresenter(FavoriteSearchFragment.a(this.a));
  }
  
  public IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new SearchResultView(paramViewGroup, 2131562974);
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if (i > 0)
    {
      FavoriteSearchResultModel localFavoriteSearchResultModel = (FavoriteSearchResultModel)super.a(i - 1);
      if ((localFavoriteSearchResultModel != null) && (localFavoriteSearchResultModel.a == -2L)) {
        return i - 1;
      }
    }
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == super.getCount() - 1) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (getItemViewType(paramInt) == 1) {
      if (paramView == null)
      {
        paramView = new TextView(paramViewGroup.getContext());
        paramView.setTextSize(18.0F);
        paramView.setTextColor(paramViewGroup.getResources().getColor(2131167044));
        paramView.setGravity(1);
        paramView.setClickable(true);
        paramView.setOnClickListener(this);
        paramView.setPadding(0, 16, 0, 16);
        localObject1 = paramView;
        localObject2 = (FavoriteSearchResultModel)super.a(paramInt);
        if ((localObject2 == null) || (((FavoriteSearchResultModel)localObject2).a != -1L)) {
          break label134;
        }
        ((TextView)localObject1).performClick();
        label105:
        localObject1 = paramView;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = (TextView)paramView;
      break;
      label134:
      ((TextView)localObject1).setText(2131698093);
      localObject2 = (Animatable)localObject1.getCompoundDrawables()[1];
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      if (localObject2 == null) {
        break label105;
      }
      ((Animatable)localObject2).stop();
      break label105;
      localObject2 = super.getView(paramInt, paramView, paramViewGroup);
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (TextView)paramView;
    ((TextView)localObject).setText(null);
    Animatable localAnimatable = (Animatable)BaseApplicationImpl.sApplication.getResources().getDrawable(2130839545);
    ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localAnimatable, null, null);
    localAnimatable.start();
    localObject = (FavoriteSearchEngine)this.a.a;
    FavoriteSearchFragment.a(this.a).a = this.a.c;
    ((FavoriteSearchEngine)localObject).a(FavoriteSearchFragment.a(this.a), this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchFragment.FavoriteSearchAdapter
 * JD-Core Version:    0.7.0.1
 */