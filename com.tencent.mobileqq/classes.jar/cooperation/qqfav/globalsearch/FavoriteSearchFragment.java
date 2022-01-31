package cooperation.qqfav.globalsearch;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import ayfe;
import ayjl;
import aypx;
import ayql;
import ayru;
import birp;
import birs;
import biru;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;

public class FavoriteSearchFragment
  extends BaseSearchFragment<birs>
{
  private ayql a;
  
  public int a()
  {
    return 60;
  }
  
  public ayfe<ayjl, ayru> a()
  {
    return new birp(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Bcws);
  }
  
  public aypx<birs> a()
  {
    return new FavoriteSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public String a()
  {
    return biru.b;
  }
  
  public void a(String paramString)
  {
    g_(false);
    if (!TextUtils.isEmpty(paramString)) {
      this.c = paramString;
    }
    while ((this.jdField_a_of_type_Aypx == null) || (this.jdField_a_of_type_ComTencentWidgetListView == null))
    {
      if ((this.jdField_a_of_type_Aypx != null) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
      {
        this.jdField_a_of_type_Aypx.b();
        FavoriteSearchEngine localFavoriteSearchEngine = (FavoriteSearchEngine)this.jdField_a_of_type_Aypx;
        this.jdField_a_of_type_Ayql.a = paramString;
        localFavoriteSearchEngine.a(this.jdField_a_of_type_Ayql, this);
        this.jdField_d_of_type_Int += 1;
      }
      return;
    }
    this.jdField_a_of_type_Ayfe.a(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.b.setVisibility(8);
    this.jdField_a_of_type_Aypx.b();
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
    this.jdField_a_of_type_Ayql = new ayql(this.c, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchFragment
 * JD-Core Version:    0.7.0.1
 */