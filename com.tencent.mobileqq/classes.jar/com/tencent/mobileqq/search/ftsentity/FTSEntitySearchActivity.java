package com.tencent.mobileqq.search.ftsentity;

import android.content.Context;
import android.content.Intent;
import aylk;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;

public class FTSEntitySearchActivity
  extends BaseSearchActivity
{
  static String d;
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    d = paramString;
    Intent localIntent = new Intent(paramContext, FTSEntitySearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("extra_key_fts_type", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  public BaseSearchFragment a()
  {
    return FTSEntitySearchFragment.a(d);
  }
  
  public String a()
  {
    return aylk.b(this, this.a);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    bdps.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity
 * JD-Core Version:    0.7.0.1
 */