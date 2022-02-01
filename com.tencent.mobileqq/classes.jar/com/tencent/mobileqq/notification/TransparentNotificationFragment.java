package com.tencent.mobileqq.notification;

import amru;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class TransparentNotificationFragment
  extends PublicBaseFragment
{
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(3);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131559307, null);
    Object localObject = getActivity().app;
    Intent localIntent = getActivity().getIntent();
    amru localamru = amru.a((QQAppInterface)localObject);
    boolean bool2 = localamru.a();
    boolean bool1;
    int i;
    int j;
    if ((((QQAppInterface)localObject).isBackgroundStop) && (bool2))
    {
      bool1 = true;
      paramViewGroup = localIntent.getStringExtra("uin");
      i = localIntent.getIntExtra("uintype", 0);
      paramBundle = localIntent.getStringExtra("uinname");
      j = localIntent.getIntExtra("key_mini_msgtab_businame", 0);
      if (QLog.isColorLevel()) {
        QLog.d("TransparentNotificationFragment", 2, new Object[] { "onCreateView: invoked. ", " appBackground: ", Boolean.valueOf(bool1), " app.isBackgroundStop: ", Boolean.valueOf(((QQAppInterface)localObject).isBackgroundStop), " subProcessBackgroundStop: ", Boolean.valueOf(bool2), " uin: ", paramViewGroup, " uinName: ", paramBundle });
      }
      if (!bool1) {
        break label284;
      }
      localObject = new Intent(((QQAppInterface)localObject).getApp(), SplashActivity.class);
      ((Intent)localObject).putExtra("uin", paramViewGroup);
      ((Intent)localObject).putExtra("uintype", i);
      ((Intent)localObject).putExtra("uinname", paramBundle);
      paramViewGroup = AIOUtils.setOpenAIOIntent((Intent)localObject, new int[] { 2 });
      paramViewGroup.setAction("com.tencent.mobileqq.action.CHAT");
      getActivity().startActivity(paramViewGroup);
      getActivity().finish();
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      bool1 = false;
      break;
      label284:
      paramViewGroup = localamru.a(i, paramViewGroup, paramBundle, j);
      getActivity().overridePendingTransition(2130771994, 2130771995);
      getActivity().startActivity(paramViewGroup);
      getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.notification.TransparentNotificationFragment
 * JD-Core Version:    0.7.0.1
 */