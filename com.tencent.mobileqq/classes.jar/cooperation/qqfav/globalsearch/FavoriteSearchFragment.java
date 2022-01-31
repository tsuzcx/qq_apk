package cooperation.qqfav.globalsearch;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import avkj;
import avon;
import avuz;
import avvn;
import avww;
import bfih;
import bfik;
import bfim;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;

public class FavoriteSearchFragment
  extends BaseSearchFragment<bfik>
{
  private avvn a;
  
  public int a()
  {
    return 60;
  }
  
  public avkj<avon, avww> a()
  {
    return new bfih(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Azwg);
  }
  
  public avuz<bfik> a()
  {
    return new FavoriteSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public String a()
  {
    return bfim.b;
  }
  
  public void a(String paramString)
  {
    h_(false);
    if (!TextUtils.isEmpty(paramString)) {
      this.c = paramString;
    }
    while ((this.jdField_a_of_type_Avuz == null) || (this.jdField_a_of_type_ComTencentWidgetListView == null))
    {
      if ((this.jdField_a_of_type_Avuz != null) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
      {
        this.jdField_a_of_type_Avuz.b();
        FavoriteSearchEngine localFavoriteSearchEngine = (FavoriteSearchEngine)this.jdField_a_of_type_Avuz;
        this.jdField_a_of_type_Avvn.a = paramString;
        localFavoriteSearchEngine.a(this.jdField_a_of_type_Avvn, this);
        this.jdField_d_of_type_Int += 1;
      }
      return;
    }
    this.jdField_a_of_type_Avkj.a(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.b.setVisibility(8);
    this.jdField_a_of_type_Avuz.b();
    i_(false);
    h_(false);
    a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("bMore", true);
    paramBundle.putBoolean("bSearchNet", true);
    paramBundle.putInt("iNumber", 12);
    this.jdField_a_of_type_Avvn = new avvn(this.c, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchFragment
 * JD-Core Version:    0.7.0.1
 */