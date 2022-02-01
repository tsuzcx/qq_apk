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
  private static ForegroundColorSpan r = new ForegroundColorSpan(SearchUtils.a());
  public long a;
  public long b;
  public long c;
  public String d;
  public String e;
  public String f;
  public int g;
  public int h;
  public int i;
  public String j;
  public int k;
  public byte[] l;
  public int m;
  public int n;
  public boolean o;
  public int p;
  public int q;
  private CharSequence s;
  
  public FavoriteSearchResultModel()
  {
    f(15);
  }
  
  public CharSequence a()
  {
    SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder();
    SpannableStringBuilder localSpannableStringBuilder1 = localSpannableStringBuilder2;
    if (this.f != null)
    {
      if (this.g == 1)
      {
        localSpannableStringBuilder2.append("来自: ").append(this.f).setSpan(r, this.h + 4, this.i + 4, 33);
        return localSpannableStringBuilder2;
      }
      localSpannableStringBuilder1 = localSpannableStringBuilder2.append("来自: ").append(SearchUtils.b(this.f, this.d, 30));
    }
    return localSpannableStringBuilder1;
  }
  
  public void a(View paramView)
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)paramView.getContext();
    QfavHelper.a(localQBaseActivity, localQBaseActivity.getAppRuntime().getAccount(), this.a);
    SearchUtils.a(this.d, 60, 0, paramView);
    if ((localQBaseActivity instanceof UniteSearchActivity))
    {
      paramView = new StringBuilder();
      paramView.append("");
      paramView.append(this.d);
      SearchUtils.a("all_result", "clk_collect", new String[] { paramView.toString() });
    }
  }
  
  public int b()
  {
    int i2 = this.m;
    int i1 = 1;
    if (i2 != 1)
    {
      if (i2 != 2)
      {
        if (i2 != 3) {
          return 0;
        }
        return 101;
      }
      i1 = 4;
    }
    return i1;
  }
  
  public String c()
  {
    if (this.c == 0L) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
  
  public CharSequence d()
  {
    if (this.s == null)
    {
      Object localObject = this.e;
      if (localObject != null)
      {
        localObject = new QQText((CharSequence)localObject, 3, 20);
        if (this.g == 0)
        {
          int i1 = this.i;
          int i2 = this.h;
          if (i1 > i2) {
            ((QQText)localObject).setSpan(r, i2, i1, 33);
          }
        }
        this.s = ((CharSequence)localObject);
      }
    }
    return this.s;
  }
  
  public CharSequence e()
  {
    return null;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.d;
  }
  
  public boolean h()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchResultModel
 * JD-Core Version:    0.7.0.1
 */