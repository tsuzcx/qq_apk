package com.tencent.mobileqq.search.activity;

import alpo;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment;
import swy;

public class PublicAcntSearchActivity
  extends BaseSearchActivity
{
  static int d = -1;
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    d = paramInt;
    Intent localIntent = new Intent(paramContext, PublicAcntSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    return PublicAcntSearchFragment.a(d);
  }
  
  protected String a()
  {
    if (d == 12) {
      return alpo.a(2131709123) + swy.a(this.app, getApplicationContext());
    }
    return alpo.a(2131709181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.PublicAcntSearchActivity
 * JD-Core Version:    0.7.0.1
 */