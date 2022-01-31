package com.tencent.mobileqq.miniapp.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class MiniAppLoadingFragment
  extends MiniAppBaseFragment
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558452, paramViewGroup, false);
    paramLayoutInflater.findViewById(2131363500).setOnClickListener(this);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.ui.MiniAppLoadingFragment
 * JD-Core Version:    0.7.0.1
 */