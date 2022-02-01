package com.tencent.mobileqq.intervideo.now;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class NowQQConnectFragment
  extends PublicBaseFragment
{
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = getBaseActivity();
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
    ((IDynamicNowManager)((QQAppInterface)((IDynamicNowManagerApi)QRoute.api(IDynamicNowManagerApi.class)).getQQAppInterface()).getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a(paramViewGroup, paramBundle);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowQQConnectFragment
 * JD-Core Version:    0.7.0.1
 */