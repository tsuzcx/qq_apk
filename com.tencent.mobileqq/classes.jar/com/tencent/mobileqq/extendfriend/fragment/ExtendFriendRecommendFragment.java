package com.tencent.mobileqq.extendfriend.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class ExtendFriendRecommendFragment
  extends ExtendFriendTabFragment
{
  private FragmentActivity a;
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onCreate: ");
    super.onCreate(paramBundle);
    this.a = getActivity();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = new StringBuilder().append("onCreateView: ");
    if (paramLayoutInflater.getFactory() == null) {
      paramViewGroup = "null";
    }
    for (;;)
    {
      QLog.i("ExtendFriendCampusFragment", 4, paramViewGroup);
      try
      {
        paramLayoutInflater = paramLayoutInflater.inflate(2131561234, null);
        V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
        return paramLayoutInflater;
        paramViewGroup = paramLayoutInflater.getFactory().getClass().getName();
      }
      catch (Throwable paramLayoutInflater)
      {
        for (;;)
        {
          QLog.w("ExtendFriendCampusFragment", 4, "onCreateView: failed create view");
          paramLayoutInflater = null;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onDestroy");
    super.onDestroy();
  }
  
  public void onPause()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onPause");
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onResume");
    super.onResume();
  }
  
  public void onStart()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onStart");
    super.onStart();
  }
  
  public void onStop()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onStop");
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendRecommendFragment
 * JD-Core Version:    0.7.0.1
 */