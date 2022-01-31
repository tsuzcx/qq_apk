package com.tencent.mobileqq.campuscircle;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class CampusCircleBaseActivity
  extends IphoneTitleBarActivity
{
  @TargetApi(11)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    setContentView(2130970285);
    switch (getIntent().getIntExtra("tag_busi_id", 0))
    {
    }
    for (paramBundle = null; paramBundle != null; paramBundle = new CampusCircleSelTopicFragment())
    {
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.add(2131364442, paramBundle);
      localFragmentTransaction.commit();
      return bool;
    }
    finish();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleBaseActivity
 * JD-Core Version:    0.7.0.1
 */