package cooperation.qqfav.globalsearch;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import ayjn;
import aynu;
import ayug;
import ayuu;
import aywd;
import bivw;
import bivz;
import biwb;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;

public class FavoriteSearchFragment
  extends BaseSearchFragment<bivz>
{
  private ayuu a;
  
  public int a()
  {
    return 60;
  }
  
  public ayjn<aynu, aywd> a()
  {
    return new bivw(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Bdbb);
  }
  
  public ayug<bivz> a()
  {
    return new FavoriteSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public String a()
  {
    return biwb.b;
  }
  
  public void a(String paramString)
  {
    g_(false);
    if (!TextUtils.isEmpty(paramString)) {
      this.c = paramString;
    }
    while ((this.jdField_a_of_type_Ayug == null) || (this.jdField_a_of_type_ComTencentWidgetListView == null))
    {
      if ((this.jdField_a_of_type_Ayug != null) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
      {
        this.jdField_a_of_type_Ayug.b();
        FavoriteSearchEngine localFavoriteSearchEngine = (FavoriteSearchEngine)this.jdField_a_of_type_Ayug;
        this.jdField_a_of_type_Ayuu.a = paramString;
        localFavoriteSearchEngine.a(this.jdField_a_of_type_Ayuu, this);
        this.jdField_d_of_type_Int += 1;
      }
      return;
    }
    this.jdField_a_of_type_Ayjn.a(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.b.setVisibility(8);
    this.jdField_a_of_type_Ayug.b();
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
    this.jdField_a_of_type_Ayuu = new ayuu(this.c, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchFragment
 * JD-Core Version:    0.7.0.1
 */