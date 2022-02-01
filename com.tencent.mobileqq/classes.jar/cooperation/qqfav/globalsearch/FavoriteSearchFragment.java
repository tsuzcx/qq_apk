package cooperation.qqfav.globalsearch;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.search.view.ISearchResultView;

public class FavoriteSearchFragment
  extends BaseSearchFragment<FavoriteSearchResultModel>
{
  private SearchRequest a;
  
  public int a()
  {
    return 60;
  }
  
  public BaseMvpAdapter<ISearchResultModel, ISearchResultView> a()
  {
    return new FavoriteSearchFragment.FavoriteSearchAdapter(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
  }
  
  public ISearchEngine<FavoriteSearchResultModel> a()
  {
    return new FavoriteSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public String a()
  {
    return GroupSearchModelFavorite.b;
  }
  
  public void a(String paramString)
  {
    g_(false);
    if (!TextUtils.isEmpty(paramString)) {
      this.c = paramString;
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine == null) || (this.jdField_a_of_type_ComTencentWidgetListView == null))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine != null) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.b();
        FavoriteSearchEngine localFavoriteSearchEngine = (FavoriteSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine;
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.a = paramString;
        localFavoriteSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest, this);
        this.jdField_d_of_type_Int += 1;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.b.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.b();
    h_(false);
    g_(false);
    a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("bMore", true);
    paramBundle.putBoolean("bSearchNet", true);
    paramBundle.putInt("iNumber", 12);
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = new SearchRequest(this.c, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchFragment
 * JD-Core Version:    0.7.0.1
 */