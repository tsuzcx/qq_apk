package com.tencent.qqmini.sdk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.AndroidOUIWrapperUtil;

public class MiniFragmentActivity
  extends FragmentActivity
{
  private MiniBaseFragment a;
  
  private MiniBaseFragment b()
  {
    Object localObject = getIntent().getStringExtra("public_fragment_class");
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniFragmentActivity", "creating fragment " + (String)localObject);
    }
    try
    {
      localObject = (MiniBaseFragment)Class.forName((String)localObject).newInstance();
      ((MiniBaseFragment)localObject).setArguments(getIntent().getExtras());
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.e("MiniFragmentActivity", "create fragment error", localException);
    }
    return null;
  }
  
  public MiniBaseFragment a()
  {
    return this.a;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.a = b();
    setContentView(2131559345);
    if (this.a == null)
    {
      finish();
      return false;
    }
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131366780, this.a);
    paramBundle.commit();
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    MiniBaseFragment localMiniBaseFragment = a();
    if (localMiniBaseFragment != null) {
      localMiniBaseFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
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
      QMLog.w("MiniFragmentActivity", "Failed to request window feature", paramIntent);
    }
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if (!AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
      super.setRequestedOrientation(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniFragmentActivity
 * JD-Core Version:    0.7.0.1
 */