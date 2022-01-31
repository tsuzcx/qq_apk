package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;

public class ContactSearchActivity
  extends BaseSearchActivity
{
  private boolean c;
  private int d;
  private int e;
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, ContactSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt1);
    localIntent.putExtra("contactSearchSource", paramInt2);
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
    return ContactSearchFragment.a(this.e, this.d, this.c);
  }
  
  protected String a()
  {
    switch (this.d)
    {
    default: 
      return "搜索";
    }
    return "搜索联系人";
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1300) && (-1 == paramInt2) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("roomId");
      if (paramIntent != null)
      {
        TroopUtils.a(this, paramIntent);
        ReportController.b(this.app, "CliOper", "", "", "0X8006360", "0X8006360", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.a = true;
    this.e = getIntent().getIntExtra("fromType", -1);
    this.d = getIntent().getIntExtra("contactSearchSource", 197437);
    this.c = getIntent().getBooleanExtra("isApproximate", false);
    super.doOnCreate(paramBundle);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ContactSearchActivity
 * JD-Core Version:    0.7.0.1
 */