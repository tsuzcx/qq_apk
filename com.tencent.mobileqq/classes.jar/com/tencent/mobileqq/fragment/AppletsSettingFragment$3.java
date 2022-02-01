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
  
  public void onGetAppletsSettingSwitch(boolean paramBoolean, List<AppletsSetting> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletsSettingFragment", 2, "onGetAppletsSettingSwitch:  isSuccess: " + paramBoolean);
    }
    if (paramBoolean)
    {
      HashSet localHashSet = new HashSet();
      if ((paramList != null) && (paramBoolean) && (paramList.size() > 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject1 = (AppletsSetting)paramList.next();
          Object localObject2;
          if ((((AppletsSetting)localObject1).jdField_a_of_type_JavaUtilList != null) && (((AppletsSetting)localObject1).jdField_a_of_type_JavaUtilList.size() > 0) && (((AppletsSetting)localObject1).jdField_a_of_type_JavaUtilList.get(0) != null) && (((AppletItem)((AppletsSetting)localObject1).jdField_a_of_type_JavaUtilList.get(0)).a() == 1L))
          {
            AppletsSettingFragment.a(this.a, (AppletItem)((AppletsSetting)localObject1).jdField_a_of_type_JavaUtilList.get(0));
            if (!TextUtils.isEmpty(AppletsSettingFragment.a(this.a).a()))
            {
              AppletsSettingFragment.a(this.a).setText(AppletsSettingFragment.a(this.a).a());
              this.a.a.e(AppletsSettingFragment.a(this.a).a());
            }
            localObject2 = this.a;
            if (AppletsSettingFragment.a(this.a).b() == 1)
            {
              paramBoolean = true;
              label244:
              AppletsSettingFragment.a((AppletsSettingFragment)localObject2, paramBoolean);
              localObject2 = AppletsSettingFragment.a(this.a);
              if (AppletsSettingFragment.a(this.a).b() != 1) {
                break label362;
              }
              paramBoolean = true;
              label276:
              ((Switch)localObject2).setChecked(paramBoolean);
              localObject2 = this.a.a;
              if (AppletsSettingFragment.a(this.a).b() != 1) {
                break label367;
              }
            }
            label362:
            label367:
            for (paramBoolean = true;; paramBoolean = false)
            {
              ((AppletsFolderManager)localObject2).a(paramBoolean);
              if (TextUtils.isEmpty(((AppletsSetting)localObject1).jdField_a_of_type_JavaLangString)) {
                break;
              }
              AppletsSettingFragment.b(this.a).setText(((AppletsSetting)localObject1).jdField_a_of_type_JavaLangString);
              this.a.a.a(((AppletsSetting)localObject1).jdField_a_of_type_JavaLangString);
              break;
              paramBoolean = false;
              break label244;
              paramBoolean = false;
              break label276;
            }
          }
          if (!TextUtils.isEmpty(((AppletsSetting)localObject1).jdField_a_of_type_JavaLangString))
          {
            AppletsSettingFragment.c(this.a).setText(((AppletsSetting)localObject1).jdField_a_of_type_JavaLangString);
            this.a.a.b(((AppletsSetting)localObject1).jdField_a_of_type_JavaLangString);
          }
          if ((((AppletsSetting)localObject1).jdField_a_of_type_JavaUtilList != null) && (((AppletsSetting)localObject1).jdField_a_of_type_JavaUtilList.size() > 0))
          {
            AppletsSettingFragment.a(this.a).clear();
            localObject1 = ((AppletsSetting)localObject1).jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (AppletItem)((Iterator)localObject1).next();
              AppletsSettingFragment.a(this.a).put(AppletsSettingFragment.a(this.a, (AppletItem)localObject2), localObject2);
              if ((((AppletItem)localObject2).a() != 1L) && (((AppletItem)localObject2).b() != 1)) {
                localHashSet.add(String.valueOf(((AppletItem)localObject2).a()));
              }
            }
            AppletsSettingFragment.a(this.a, new ArrayList(AppletsSettingFragment.a(this.a).values()));
          }
        }
      }
      this.a.a.a(localHashSet);
      return;
    }
    this.a.a(2131690187);
  }
  
  public void onSetAppletsSettingSwitch(boolean paramBoolean, List<AppletItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletsSettingFragment", 2, "onSetAppletsSettingSwitch:  isSuccess: " + paramBoolean);
    }
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (AppletItem)paramList.next();
        this.a.a(false);
        if (!paramBoolean) {
          this.a.a(2131690188);
        }
        Object localObject2;
        int i;
        if (((AppletItem)localObject1).a() == 1L)
        {
          localObject2 = AppletsSettingFragment.a(this.a);
          if (paramBoolean)
          {
            i = ((AppletItem)localObject1).b();
            label112:
            ((AppletItem)localObject2).a(i);
            localObject1 = this.a;
            if (AppletsSettingFragment.a(this.a).b() != 1) {
              break label247;
            }
            bool = true;
            label141:
            AppletsSettingFragment.a((AppletsSettingFragment)localObject1, bool);
            localObject1 = AppletsSettingFragment.a(this.a);
            if (AppletsSettingFragment.a(this.a).b() != 1) {
              break label253;
            }
            bool = true;
            label175:
            ((Switch)localObject1).setChecked(bool);
            if (this.a.a == null) {
              continue;
            }
            localObject1 = this.a.a;
            if (AppletsSettingFragment.a(this.a).b() != 1) {
              break label259;
            }
          }
          label259:
          for (boolean bool = true;; bool = false)
          {
            ((AppletsFolderManager)localObject1).a(bool);
            break;
            if (((AppletItem)localObject1).b() == 1)
            {
              i = 0;
              break label112;
            }
            i = 1;
            break label112;
            label247:
            bool = false;
            break label141;
            label253:
            bool = false;
            break label175;
          }
        }
        else
        {
          localObject2 = AppletsSettingFragment.a(this.a, (AppletItem)localObject1);
          localObject2 = (AppletItem)AppletsSettingFragment.a(this.a).get(localObject2);
          if (localObject2 != null)
          {
            if (!paramBoolean) {
              break label389;
            }
            i = ((AppletItem)localObject1).b();
          }
          for (;;)
          {
            ((AppletItem)localObject2).a(i);
            AppletsSettingFragment.a(this.a);
            AppletsSettingFragment.a(this.a, new ArrayList(AppletsSettingFragment.a(this.a).values()));
            if ((this.a.a == null) || (localObject2 == null)) {
              break;
            }
            if (((AppletItem)localObject2).b() != 0) {
              break label408;
            }
            this.a.a.c(String.valueOf(((AppletItem)localObject2).a()));
            break;
            label389:
            if (((AppletItem)localObject1).b() == 1) {
              i = 0;
            } else {
              i = 1;
            }
          }
          label408:
          this.a.a.d(String.valueOf(((AppletItem)localObject2).a()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.AppletsSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */