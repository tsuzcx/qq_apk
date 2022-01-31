package com.tencent.mobileqq.search.ftsentity;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;

public class FTSEntitySearchActivity
  extends BaseSearchActivity
{
  static String a;
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    jdField_a_of_type_JavaLangString = paramString;
    Intent localIntent = new Intent(paramContext, FTSEntitySearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("extra_key_fts_type", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    return FTSEntitySearchFragment.a(jdField_a_of_type_JavaLangString);
  }
  
  protected String a()
  {
    return FTSEntitySearchUtils.b(this, this.jdField_a_of_type_Int);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity
 * JD-Core Version:    0.7.0.1
 */