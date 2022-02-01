package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.EnterItem;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.OnItemClickListener;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class NearbyHybridFragment$13
  implements NearbyFragmentEnterAdapter.OnItemClickListener
{
  NearbyHybridFragment$13(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void a(View paramView, int paramInt, long paramLong)
  {
    paramView = (NearbyFragmentEnterAdapter.EnterItem)this.a.s.a(paramInt);
    paramInt = paramView.d;
    boolean bool = true;
    Object localObject;
    if (paramInt == 1)
    {
      localObject = this.a;
      ((NearbyHybridFragment)localObject).a(((NearbyHybridFragment)localObject).s.a());
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onItemClick:");
        ((StringBuilder)localObject).append(paramView.c);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramView.a);
        QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramView.f == 1) && (!TextUtils.isEmpty(paramView.h)) && (this.a.getBaseActivity() != null) && (PackageUtil.a(this.a.getBaseActivity(), paramView.h)) && (this.a.k != null)) {
        if (!TextUtils.isEmpty(paramView.g))
        {
          try
          {
            localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramView.g));
            ((Intent)localObject).setFlags(268435456);
            BaseApplicationImpl.getContext().startActivity((Intent)localObject);
          }
          catch (Exception localException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("jump to app with scheme Excepyion e = ");
            localStringBuilder.append(localException.getMessage());
            QLog.d("nearby.NearbyHybridFragment", 2, localStringBuilder.toString());
            break label289;
          }
        }
        else
        {
          bool = PackageUtil.a(this.a.getBaseActivity(), paramView.h, this.a.k.getCurrentAccountUin());
          break label292;
        }
      }
      label289:
      bool = false;
      label292:
      if (!bool) {
        this.a.a(paramView);
      }
    }
    INearbyProcManager localINearbyProcManager = this.a.k.getNearbyProcManager();
    switch (paramView.d)
    {
    default: 
      break;
    case 6: 
      localINearbyProcManager.b(41);
      break;
    case 5: 
      if (this.a.s != null) {
        this.a.s.a(this.a.k);
      }
      break;
    case 4: 
      localINearbyProcManager.b(40);
      break;
    case 3: 
      localINearbyProcManager.b(23);
      localINearbyProcManager.b(26);
      break;
    case 2: 
      localINearbyProcManager.b(25);
      break;
    case 1: 
      localINearbyProcManager.b(39);
    }
    NearbyUtils.b((AppInterface)this.a.k, "click_op_button", paramView.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.13
 * JD-Core Version:    0.7.0.1
 */