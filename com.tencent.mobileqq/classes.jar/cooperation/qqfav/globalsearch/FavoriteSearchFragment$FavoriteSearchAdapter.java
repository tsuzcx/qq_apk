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
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.base.presenter.IPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.base.view.SearchResultView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
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
  
  protected IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    return new FavoriteSearchResultPresenter(FavoriteSearchFragment.a(this.a));
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new SearchResultView(paramViewGroup, 2131629238);
  }
  
  public int getCount()
  {
    int j = super.getCount();
    int i = j;
    if (j > 0)
    {
      FavoriteSearchResultModel localFavoriteSearchResultModel = (FavoriteSearchResultModel)super.c(j - 1);
      i = j;
      if (localFavoriteSearchResultModel != null)
      {
        i = j;
        if (localFavoriteSearchResultModel.a == -2L) {
          i = j - 1;
        }
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
    if (getItemViewType(paramInt) == 1)
    {
      if (paramView == null)
      {
        localObject1 = new TextView(paramViewGroup.getContext());
        ((TextView)localObject1).setTextSize(18.0F);
        ((TextView)localObject1).setTextColor(paramViewGroup.getResources().getColor(2131168007));
        ((TextView)localObject1).setGravity(1);
        ((TextView)localObject1).setClickable(true);
        ((TextView)localObject1).setOnClickListener(this);
        ((TextView)localObject1).setPadding(0, 16, 0, 16);
        paramView = (View)localObject1;
      }
      else
      {
        localObject1 = (TextView)paramView;
      }
      localObject2 = (FavoriteSearchResultModel)super.c(paramInt);
      if ((localObject2 != null) && (((FavoriteSearchResultModel)localObject2).a == -1L))
      {
        ((TextView)localObject1).performClick();
      }
      else
      {
        ((TextView)localObject1).setText(2131896001);
        localObject2 = (Animatable)localObject1.getCompoundDrawables()[1];
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if (localObject2 != null) {
          ((Animatable)localObject2).stop();
        }
      }
      localObject1 = paramView;
    }
    else
    {
      localObject2 = super.getView(paramInt, paramView, paramViewGroup);
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (TextView)paramView;
    ((TextView)localObject).setText(null);
    Animatable localAnimatable = (Animatable)BaseApplicationImpl.sApplication.getResources().getDrawable(2130839585);
    ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localAnimatable, null, null);
    localAnimatable.start();
    localObject = (FavoriteSearchEngine)this.a.o;
    FavoriteSearchFragment.b(this.a).a = this.a.q;
    ((FavoriteSearchEngine)localObject).a(FavoriteSearchFragment.b(this.a), this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchFragment.FavoriteSearchAdapter
 * JD-Core Version:    0.7.0.1
 */