package cooperation.qqfav.globalsearch;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFavorite;
import com.tencent.mobileqq.search.model.ISearchResultModel;

public class FavoriteSearchFragment
  extends BaseSearchFragment<FavoriteSearchResultModel>
{
  private SearchRequest a;
  
  public void a(String paramString)
  {
    h_(false);
    if (!TextUtils.isEmpty(paramString))
    {
      this.q = paramString;
    }
    else if ((this.o != null) && (this.l != null))
    {
      this.m.a(null);
      this.x.setVisibility(8);
      this.C.setVisibility(8);
      this.w.setVisibility(8);
      this.o.b();
      o_(false);
      h_(false);
      g();
      return;
    }
    if ((this.o != null) && (this.l != null))
    {
      this.o.b();
      FavoriteSearchEngine localFavoriteSearchEngine = (FavoriteSearchEngine)this.o;
      SearchRequest localSearchRequest = this.a;
      localSearchRequest.a = paramString;
      localFavoriteSearchEngine.a(localSearchRequest, this);
      this.D += 1;
    }
  }
  
  protected BaseMvpAdapter<ISearchResultModel, ISearchResultView> b()
  {
    return new FavoriteSearchFragment.FavoriteSearchAdapter(this, this.l, this.n);
  }
  
  protected ISearchEngine<FavoriteSearchResultModel> c()
  {
    return new FavoriteSearchEngine((QQAppInterface)this.p);
  }
  
  protected String d()
  {
    return GroupSearchModelFavorite.b;
  }
  
  protected String e()
  {
    return HardCodeUtil.a(2131899286);
  }
  
  protected int l()
  {
    return 60;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("bMore", true);
    paramBundle.putBoolean("bSearchNet", true);
    paramBundle.putInt("iNumber", 12);
    this.a = new SearchRequest(this.q, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchFragment
 * JD-Core Version:    0.7.0.1
 */