package com.tencent.mobileqq.intervideo.now;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import asyy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class NowQQConnectFragment
  extends PublicBaseFragment
{
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = getActivity();
    if (paramViewGroup == null)
    {
      QLog.e("NowQQConnectFragment", 1, "activity is null");
      return paramLayoutInflater;
    }
    paramBundle = getArguments();
    if (paramBundle == null)
    {
      QLog.e("NowQQConnectFragment", 1, "argsBundle is null");
      return paramLayoutInflater;
    }
    ((asyy)asyy.a().getManager(306)).a(paramViewGroup, paramBundle);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowQQConnectFragment
 * JD-Core Version:    0.7.0.1
 */