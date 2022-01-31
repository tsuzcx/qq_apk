package cooperation.qqfav.globalsearch;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import awke;
import awoi;
import awuu;
import awvi;
import awwr;
import bgqq;
import bgqt;
import bgqv;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;

public class FavoriteSearchFragment
  extends BaseSearchFragment<bgqt>
{
  private awvi a;
  
  public int a()
  {
    return 60;
  }
  
  public awke<awoi, awwr> a()
  {
    return new bgqq(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Baxy);
  }
  
  public awuu<bgqt> a()
  {
    return new FavoriteSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public String a()
  {
    return bgqv.b;
  }
  
  public void a(String paramString)
  {
    g_(false);
    if (!TextUtils.isEmpty(paramString)) {
      this.c = paramString;
    }
    while ((this.jdField_a_of_type_Awuu == null) || (this.jdField_a_of_type_ComTencentWidgetListView == null))
    {
      if ((this.jdField_a_of_type_Awuu != null) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
      {
        this.jdField_a_of_type_Awuu.b();
        FavoriteSearchEngine localFavoriteSearchEngine = (FavoriteSearchEngine)this.jdField_a_of_type_Awuu;
        this.jdField_a_of_type_Awvi.a = paramString;
        localFavoriteSearchEngine.a(this.jdField_a_of_type_Awvi, this);
        this.jdField_d_of_type_Int += 1;
      }
      return;
    }
    this.jdField_a_of_type_Awke.a(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.b.setVisibility(8);
    this.jdField_a_of_type_Awuu.b();
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
    this.jdField_a_of_type_Awvi = new awvi(this.c, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchFragment
 * JD-Core Version:    0.7.0.1
 */