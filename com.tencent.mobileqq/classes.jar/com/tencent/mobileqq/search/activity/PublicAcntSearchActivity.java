package com.tencent.mobileqq.search.activity;

import ajjy;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment;
import rsp;

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
      return ajjy.a(2131642955) + rsp.a(this.app, getApplicationContext());
    }
    return ajjy.a(2131643013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.PublicAcntSearchActivity
 * JD-Core Version:    0.7.0.1
 */