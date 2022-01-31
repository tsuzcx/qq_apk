package cooperation.qqfav.globalsearch;

import amwt;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;

public class FavoriteSearchFragment
  extends BaseSearchFragment
{
  private SearchRequest a;
  
  protected int a()
  {
    return 60;
  }
  
  protected BaseMvpAdapter a()
  {
    return new amwt(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
  }
  
  protected ISearchEngine a()
  {
    return new FavoriteSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected String a()
  {
    return "我的收藏";
  }
  
  public void a(String paramString)
  {
    b(false);
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_b_of_type_JavaLangString = paramString;
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine == null) || (this.jdField_a_of_type_ComTencentWidgetListView == null))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine != null) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.b();
        FavoriteSearchEngine localFavoriteSearchEngine = (FavoriteSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine;
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.a = paramString;
        localFavoriteSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest, this);
        this.jdField_a_of_type_Int += 1;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.b();
    c(false);
    b(false);
    a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("bMore", true);
    paramBundle.putBoolean("bSearchNet", true);
    paramBundle.putInt("iNumber", 12);
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = new SearchRequest(this.jdField_b_of_type_JavaLangString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchFragment
 * JD-Core Version:    0.7.0.1
 */