package cooperation.qqfav.globalsearch;

import alpo;
import android.content.Context;
import android.content.Intent;
import birs;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;

public class FavoriteSearchActivity
  extends BaseSearchActivity
{
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, FavoriteSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public BaseSearchFragment<birs> a()
  {
    return new FavoriteSearchFragment();
  }
  
  public String a()
  {
    return alpo.a(2131704764);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((getIntent() != null) && (UniteSearchActivity.class.getSimpleName().equals(getIntent().getStringExtra("preAct")))) {
      overridePendingTransition(2130771992, 2130771993);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchActivity
 * JD-Core Version:    0.7.0.1
 */