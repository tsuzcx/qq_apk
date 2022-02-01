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
  
  protected int a()
  {
    return 60;
  }
  
  protected BaseMvpAdapter<ISearchResultModel, ISearchResultView> a()
  {
    return new FavoriteSearchFragment.FavoriteSearchAdapter(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
  }
  
  protected ISearchEngine<FavoriteSearchResultModel> a()
  {
    return new FavoriteSearchEngine((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  protected String a()
  {
    return GroupSearchModelFavorite.b;
  }
  
  public void a(String paramString)
  {
    c_(false);
    if (!TextUtils.isEmpty(paramString))
    {
      this.c = paramString;
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine != null) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter.a(null);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.b.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.b();
      j_(false);
      c_(false);
      a();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine != null) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.b();
      FavoriteSearchEngine localFavoriteSearchEngine = (FavoriteSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine;
      SearchRequest localSearchRequest = this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest;
      localSearchRequest.a = paramString;
      localFavoriteSearchEngine.a(localSearchRequest, this);
      this.jdField_d_of_type_Int += 1;
    }
  }
  
  protected String b()
  {
    return HardCodeUtil.a(2131701276);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("bMore", true);
    paramBundle.putBoolean("bSearchNet", true);
    paramBundle.putInt("iNumber", 12);
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest = new SearchRequest(this.c, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchFragment
 * JD-Core Version:    0.7.0.1
 */