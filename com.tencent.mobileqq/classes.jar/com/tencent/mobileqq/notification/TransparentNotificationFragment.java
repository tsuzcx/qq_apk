package com.tencent.mobileqq.notification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ForegroundNotifyManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

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
    paramLayoutInflater = paramLayoutInflater.inflate(2131559298, null);
    Object localObject = getBaseActivity().app;
    Intent localIntent = getBaseActivity().getIntent();
    ForegroundNotifyManager localForegroundNotifyManager = ForegroundNotifyManager.a((QQAppInterface)localObject);
    boolean bool2 = localForegroundNotifyManager.a();
    boolean bool1;
    if ((((QQAppInterface)localObject).isBackgroundStop) && (bool2)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramViewGroup = localIntent.getStringExtra("uin");
    int i = localIntent.getIntExtra("uintype", 0);
    paramBundle = localIntent.getStringExtra("uinname");
    int j = localIntent.getIntExtra("key_mini_msgtab_businame", 0);
    if (QLog.isColorLevel()) {
      QLog.d("TransparentNotificationFragment", 2, new Object[] { "onCreateView: invoked. ", " appBackground: ", Boolean.valueOf(bool1), " app.isBackgroundStop: ", Boolean.valueOf(((QQAppInterface)localObject).isBackgroundStop), " subProcessBackgroundStop: ", Boolean.valueOf(bool2), " uin: ", paramViewGroup, " uinName: ", paramBundle });
    }
    if (bool1)
    {
      localObject = new Intent(((QQAppInterface)localObject).getApp(), SplashActivity.class);
      ((Intent)localObject).putExtra("uin", paramViewGroup);
      ((Intent)localObject).putExtra("uintype", i);
      ((Intent)localObject).putExtra("uinname", paramBundle);
      paramViewGroup = AIOUtils.a((Intent)localObject, new int[] { 2 });
      paramViewGroup.setAction("com.tencent.mobileqq.action.CHAT");
      getBaseActivity().startActivity(paramViewGroup);
      getBaseActivity().finish();
    }
    else
    {
      paramViewGroup = localForegroundNotifyManager.a(i, paramViewGroup, paramBundle, j);
      getBaseActivity().overridePendingTransition(2130772008, 2130772009);
      getBaseActivity().startActivity(paramViewGroup);
      getBaseActivity().finish();
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.notification.TransparentNotificationFragment
 * JD-Core Version:    0.7.0.1
 */