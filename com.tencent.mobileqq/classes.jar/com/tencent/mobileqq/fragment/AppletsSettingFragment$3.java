package com.tencent.mobileqq.fragment;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.applets.AppletsObserver;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.applets.data.AppletsSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class AppletsSettingFragment$3
  extends AppletsObserver
{
  AppletsSettingFragment$3(AppletsSettingFragment paramAppletsSettingFragment) {}
  
  protected void onGetAppletsSettingSwitch(boolean paramBoolean, List<AppletsSetting> paramList)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGetAppletsSettingSwitch:  isSuccess: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("AppletsSettingFragment", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean)
    {
      localObject1 = new HashSet();
      if ((paramList != null) && (paramBoolean) && (paramList.size() > 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject2 = (AppletsSetting)paramList.next();
          Object localObject3 = ((AppletsSetting)localObject2).b;
          boolean bool = true;
          if ((localObject3 != null) && (((AppletsSetting)localObject2).b.size() > 0) && (((AppletsSetting)localObject2).b.get(0) != null) && (((AppletItem)((AppletsSetting)localObject2).b.get(0)).a() == 1L))
          {
            AppletsSettingFragment.a(this.a, (AppletItem)((AppletsSetting)localObject2).b.get(0));
            if (!TextUtils.isEmpty(AppletsSettingFragment.b(this.a).b()))
            {
              AppletsSettingFragment.c(this.a).setText(AppletsSettingFragment.b(this.a).b());
              this.a.a.g(AppletsSettingFragment.b(this.a).b());
            }
            localObject3 = this.a;
            if (AppletsSettingFragment.b((AppletsSettingFragment)localObject3).e() == 1) {
              paramBoolean = true;
            } else {
              paramBoolean = false;
            }
            AppletsSettingFragment.a((AppletsSettingFragment)localObject3, paramBoolean);
            localObject3 = AppletsSettingFragment.d(this.a);
            if (AppletsSettingFragment.b(this.a).e() == 1) {
              paramBoolean = true;
            } else {
              paramBoolean = false;
            }
            ((Switch)localObject3).setChecked(paramBoolean);
            localObject3 = this.a.a;
            if (AppletsSettingFragment.b(this.a).e() == 1) {
              paramBoolean = bool;
            } else {
              paramBoolean = false;
            }
            ((AppletsFolderManager)localObject3).b(paramBoolean);
            if (!TextUtils.isEmpty(((AppletsSetting)localObject2).a))
            {
              AppletsSettingFragment.e(this.a).setText(((AppletsSetting)localObject2).a);
              this.a.a.c(((AppletsSetting)localObject2).a);
            }
          }
          else
          {
            if (!TextUtils.isEmpty(((AppletsSetting)localObject2).a))
            {
              AppletsSettingFragment.f(this.a).setText(((AppletsSetting)localObject2).a);
              this.a.a.d(((AppletsSetting)localObject2).a);
            }
            if ((((AppletsSetting)localObject2).b != null) && (((AppletsSetting)localObject2).b.size() > 0))
            {
              AppletsSettingFragment.g(this.a).clear();
              localObject2 = ((AppletsSetting)localObject2).b.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (AppletItem)((Iterator)localObject2).next();
                AppletsSettingFragment.g(this.a).put(AppletsSettingFragment.b(this.a, (AppletItem)localObject3), localObject3);
                if ((((AppletItem)localObject3).a() != 1L) && (((AppletItem)localObject3).e() != 1)) {
                  ((Set)localObject1).add(String.valueOf(((AppletItem)localObject3).a()));
                }
              }
              localObject2 = this.a;
              AppletsSettingFragment.a((AppletsSettingFragment)localObject2, new ArrayList(AppletsSettingFragment.g((AppletsSettingFragment)localObject2).values()));
            }
          }
        }
      }
      this.a.a.a((Set)localObject1);
      return;
    }
    this.a.a(2131886999);
  }
  
  protected void onSetAppletsSettingSwitch(boolean paramBoolean, List<AppletItem> paramList)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onSetAppletsSettingSwitch:  isSuccess: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("AppletsSettingFragment", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (AppletItem)paramList.next();
        Object localObject2 = this.a;
        int i = 0;
        ((AppletsSettingFragment)localObject2).a(false);
        if (!paramBoolean) {
          this.a.a(2131887000);
        }
        long l = ((AppletItem)localObject1).a();
        boolean bool2 = true;
        if (l == 1L)
        {
          localObject2 = AppletsSettingFragment.b(this.a);
          if (paramBoolean) {
            i = ((AppletItem)localObject1).e();
          } else if (((AppletItem)localObject1).e() == 1) {
            i = 0;
          } else {
            i = 1;
          }
          ((AppletItem)localObject2).a(i);
          localObject1 = this.a;
          boolean bool1;
          if (AppletsSettingFragment.b((AppletsSettingFragment)localObject1).e() == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          AppletsSettingFragment.a((AppletsSettingFragment)localObject1, bool1);
          localObject1 = AppletsSettingFragment.d(this.a);
          if (AppletsSettingFragment.b(this.a).e() == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          ((Switch)localObject1).setChecked(bool1);
          if (this.a.a != null)
          {
            localObject1 = this.a.a;
            if (AppletsSettingFragment.b(this.a).e() == 1) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
            ((AppletsFolderManager)localObject1).b(bool1);
          }
        }
        else
        {
          localObject2 = AppletsSettingFragment.b(this.a, (AppletItem)localObject1);
          localObject2 = (AppletItem)AppletsSettingFragment.g(this.a).get(localObject2);
          if (localObject2 != null)
          {
            if (paramBoolean) {
              i = ((AppletItem)localObject1).e();
            } else if (((AppletItem)localObject1).e() != 1) {
              i = 1;
            }
            ((AppletItem)localObject2).a(i);
          }
          AppletsSettingFragment.h(this.a);
          localObject1 = this.a;
          AppletsSettingFragment.a((AppletsSettingFragment)localObject1, new ArrayList(AppletsSettingFragment.g((AppletsSettingFragment)localObject1).values()));
          if ((this.a.a != null) && (localObject2 != null)) {
            if (((AppletItem)localObject2).e() == 0) {
              this.a.a.e(String.valueOf(((AppletItem)localObject2).a()));
            } else {
              this.a.a.f(String.valueOf(((AppletItem)localObject2).a()));
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.AppletsSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */