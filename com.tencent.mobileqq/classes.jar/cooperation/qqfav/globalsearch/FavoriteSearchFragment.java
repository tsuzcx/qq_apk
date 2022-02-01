package cooperation.qqfav.globalsearch;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import bcbc;
import bcfj;
import bclw;
import bcmk;
import bcnt;
import bmaz;
import bmbc;
import bmbe;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;

public class FavoriteSearchFragment
  extends BaseSearchFragment<bmbc>
{
  private bcmk a;
  
  public int a()
  {
    return 60;
  }
  
  public bcbc<bcfj, bcnt> a()
  {
    return new bmaz(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
  }
  
  public bclw<bmbc> a()
  {
    return new FavoriteSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public String a()
  {
    return bmbe.b;
  }
  
  public void a(String paramString)
  {
    f_(false);
    if (!TextUtils.isEmpty(paramString)) {
      this.c = paramString;
    }
    while ((this.jdField_a_of_type_Bclw == null) || (this.jdField_a_of_type_ComTencentWidgetListView == null))
    {
      if ((this.jdField_a_of_type_Bclw != null) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
      {
        this.jdField_a_of_type_Bclw.b();
        FavoriteSearchEngine localFavoriteSearchEngine = (FavoriteSearchEngine)this.jdField_a_of_type_Bclw;
        this.jdField_a_of_type_Bcmk.a = paramString;
        localFavoriteSearchEngine.a(this.jdField_a_of_type_Bcmk, this);
        this.jdField_d_of_type_Int += 1;
      }
      return;
    }
    this.jdField_a_of_type_Bcbc.a(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.b.setVisibility(8);
    this.jdField_a_of_type_Bclw.b();
    g_(false);
    f_(false);
    a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("bMore", true);
    paramBundle.putBoolean("bSearchNet", true);
    paramBundle.putInt("iNumber", 12);
    this.jdField_a_of_type_Bcmk = new bcmk(this.c, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchFragment
 * JD-Core Version:    0.7.0.1
 */