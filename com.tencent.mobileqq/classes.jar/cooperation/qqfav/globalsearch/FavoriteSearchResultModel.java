package cooperation.qqfav.globalsearch;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.text.QQText;
import cooperation.qqfav.QfavHelper;
import mqq.app.AppRuntime;

public class FavoriteSearchResultModel
  extends ISearchResultPositionModel
{
  private static ForegroundColorSpan jdField_a_of_type_AndroidTextStyleForegroundColorSpan = new ForegroundColorSpan(SearchUtils.a());
  public int a;
  public long a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public String d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  public int a()
  {
    int j = this.e;
    int i = 1;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3) {
          return 0;
        }
        return 101;
      }
      i = 4;
    }
    return i;
  }
  
  public CharSequence a()
  {
    SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder();
    SpannableStringBuilder localSpannableStringBuilder1 = localSpannableStringBuilder2;
    if (this.jdField_c_of_type_JavaLangString != null)
    {
      if (this.jdField_a_of_type_Int == 1)
      {
        localSpannableStringBuilder2.append("来自: ").append(this.jdField_c_of_type_JavaLangString).setSpan(jdField_a_of_type_AndroidTextStyleForegroundColorSpan, this.jdField_b_of_type_Int + 4, this.jdField_c_of_type_Int + 4, 33);
        return localSpannableStringBuilder2;
      }
      localSpannableStringBuilder1 = localSpannableStringBuilder2.append("来自: ").append(SearchUtils.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 30));
    }
    return localSpannableStringBuilder1;
  }
  
  public String a()
  {
    if (this.jdField_c_of_type_Long == 0L) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    return localStringBuilder.toString();
  }
  
  public void a(View paramView)
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)paramView.getContext();
    QfavHelper.a(localQBaseActivity, localQBaseActivity.getAppRuntime().getAccount(), this.jdField_a_of_type_Long);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 60, 0, paramView);
    if ((localQBaseActivity instanceof UniteSearchActivity))
    {
      paramView = new StringBuilder();
      paramView.append("");
      paramView.append(this.jdField_a_of_type_JavaLangString);
      SearchUtils.a("all_result", "clk_collect", new String[] { paramView.toString() });
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null)
    {
      Object localObject = this.jdField_b_of_type_JavaLangString;
      if (localObject != null)
      {
        localObject = new QQText((CharSequence)localObject, 3, 20);
        if (this.jdField_a_of_type_Int == 0)
        {
          int i = this.jdField_c_of_type_Int;
          int j = this.jdField_b_of_type_Int;
          if (i > j) {
            ((QQText)localObject).setSpan(jdField_a_of_type_AndroidTextStyleForegroundColorSpan, j, i, 33);
          }
        }
        this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject);
      }
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    return null;
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchResultModel
 * JD-Core Version:    0.7.0.1
 */