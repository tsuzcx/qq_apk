package com.tencent.mobileqq.search.activity;

import ajya;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import axqy;
import banb;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;

public class ContactSearchActivity
  extends BaseSearchActivity
{
  private boolean c;
  private int d;
  private int e;
  private int f;
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Intent localIntent = new Intent(paramContext, ContactSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt1);
    localIntent.putExtra("contactSearchSource", paramInt2);
    localIntent.putExtra("ContactCombineType", paramInt3);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ContactSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt1);
    localIntent.putExtra("contactSearchSource", paramInt2);
    localIntent.putExtra("isApproximate", paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    return ContactSearchFragment.a(this.e, this.d, this.c, this.f);
  }
  
  protected String a()
  {
    switch (this.d)
    {
    default: 
      return ajya.a(2131702563);
    }
    return ajya.a(2131702546);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1300) && (-1 == paramInt2) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("roomId");
      if (paramIntent != null)
      {
        banb.a(this, paramIntent, true);
        axqy.b(this.app, "CliOper", "", "", "0X8006360", "0X8006360", 0, 0, "", "", "", "");
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.a = true;
    this.e = getIntent().getIntExtra("fromType", -1);
    this.d = getIntent().getIntExtra("contactSearchSource", 197437);
    this.c = getIntent().getBooleanExtra("isApproximate", false);
    this.f = getIntent().getIntExtra("ContactCombineType", 0);
    super.doOnCreate(paramBundle);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ContactSearchActivity
 * JD-Core Version:    0.7.0.1
 */