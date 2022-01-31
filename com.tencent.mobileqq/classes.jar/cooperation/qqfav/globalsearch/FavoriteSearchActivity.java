package cooperation.qqfav.globalsearch;

import android.content.Context;
import android.content.Intent;
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
  
  protected BaseSearchFragment a()
  {
    return new FavoriteSearchFragment();
  }
  
  protected String a()
  {
    return "搜索收藏";
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((getIntent() != null) && (UniteSearchActivity.class.getSimpleName().equals(getIntent().getStringExtra("preAct")))) {
      overridePendingTransition(2131034132, 2131034133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchActivity
 * JD-Core Version:    0.7.0.1
 */