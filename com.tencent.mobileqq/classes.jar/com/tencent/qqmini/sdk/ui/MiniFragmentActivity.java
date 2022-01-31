package com.tencent.qqmini.sdk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import betc;

public class MiniFragmentActivity
  extends FragmentActivity
{
  private MiniBaseFragment a;
  
  private MiniBaseFragment a()
  {
    Object localObject = getIntent().getStringExtra("public_fragment_class");
    if (betc.a()) {
      betc.a("MiniFragmentActivity", "creating fragment " + (String)localObject);
    }
    try
    {
      localObject = (MiniBaseFragment)Class.forName((String)localObject).newInstance();
      ((MiniBaseFragment)localObject).setArguments(getIntent().getExtras());
      return localObject;
    }
    catch (Exception localException)
    {
      betc.d("MiniFragmentActivity", "create fragment error", localException);
    }
    return null;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.a = a();
    setContentView(2131559297);
    if (this.a == null)
    {
      finish();
      return false;
    }
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131366662, this.a);
    paramBundle.commit();
    return true;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    requestWindowFeature(getIntent());
    super.onCreate(paramBundle);
    doOnCreate(paramBundle);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    try
    {
      if (paramIntent.hasExtra("public_fragment_window_feature")) {
        requestWindowFeature(paramIntent.getIntExtra("public_fragment_window_feature", 0));
      }
      return;
    }
    catch (Exception paramIntent)
    {
      betc.c("MiniFragmentActivity", "Failed to request window feature", paramIntent);
    }
  }
  
  public String toString()
  {
    String str2 = super.toString();
    String str1;
    if (this.a != null) {
      str1 = str2 + "#" + this.a.getClass().getName() + "@" + Integer.toHexString(this.a.hashCode());
    }
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (getIntent() == null);
      str1 = str2;
    } while (getIntent().getStringExtra("public_fragment_class") == null);
    return str2 + "#" + getIntent().getStringExtra("public_fragment_class");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniFragmentActivity
 * JD-Core Version:    0.7.0.1
 */