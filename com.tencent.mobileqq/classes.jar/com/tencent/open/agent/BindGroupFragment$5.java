package com.tencent.open.agent;

import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

class BindGroupFragment$5
  extends TroopObserver
{
  BindGroupFragment$5(BindGroupFragment paramBindGroupFragment) {}
  
  protected void onBindTroopForThirdApp(boolean paramBoolean, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBindTroopForThirdApp, isSuccess: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" bindFlag: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("  troopUin: ");
    localStringBuilder.append(paramLong);
    QLog.i("TroopAbility.BindGroup.Fragment", 1, localStringBuilder.toString());
    BindGroupFragment.f(this.a);
    if (paramBoolean)
    {
      BindGroupFragment.c(this.a, HardCodeUtil.a(2131899343));
      BindGroupFragment.a(this.a, String.valueOf(paramLong), 1);
      BindGroupFragment.a(this.a).finish();
      return;
    }
    BindGroupFragment.b(this.a, HardCodeUtil.a(2131899349));
  }
  
  protected void onGetCreateTroopTokenForThirdApp(boolean paramBoolean, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetCreateTroopTokenForThirdApp isSuccess: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" url: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("TroopAbility.BindGroup.Fragment", 1, ((StringBuilder)localObject).toString());
    BindGroupFragment.f(this.a);
    if (paramBoolean)
    {
      localObject = new Intent(BindGroupFragment.a(this.a), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", URLUtil.a(paramString, "gname", BindGroupFragment.e(this.a)));
      this.a.startActivity((Intent)localObject);
      return;
    }
    BindGroupFragment.b(this.a, HardCodeUtil.a(2131899338));
  }
  
  protected void onGetOnePageTroopInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetOnePageTroopInfo, isSuccess: ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" isLastPage: ");
    localStringBuilder.append(paramBoolean2);
    QLog.i("TroopAbility.BindGroup.Fragment", 1, localStringBuilder.toString());
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        BindGroupFragment.f(this.a);
        if (BindGroupFragment.g(this.a) != null) {
          BindGroupFragment.g(this.a).notifyDataSetChanged();
        }
      }
      else
      {
        BindGroupFragment.h(this.a);
      }
    }
    else
    {
      BindGroupFragment.f(this.a);
      BindGroupFragment.b(this.a, HardCodeUtil.a(2131899352));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupFragment.5
 * JD-Core Version:    0.7.0.1
 */