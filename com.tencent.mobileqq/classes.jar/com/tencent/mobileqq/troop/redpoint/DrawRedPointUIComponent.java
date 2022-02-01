package com.tencent.mobileqq.troop.redpoint;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class DrawRedPointUIComponent
{
  private View jdField_a_of_type_AndroidViewView;
  private RedPointListener jdField_a_of_type_ComTencentMobileqqTroopRedpointRedPointListener = new DrawRedPointUIComponent.1(this);
  private String jdField_a_of_type_JavaLangString;
  private List<Integer> jdField_a_of_type_JavaUtilList;
  public AppRuntime a;
  private String b;
  
  public DrawRedPointUIComponent(RedPointUIData paramRedPointUIData)
  {
    if (paramRedPointUIData != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime = paramRedPointUIData.jdField_a_of_type_MqqAppAppRuntime;
      this.jdField_a_of_type_JavaLangString = paramRedPointUIData.jdField_a_of_type_JavaLangString;
      this.b = paramRedPointUIData.b;
      this.jdField_a_of_type_JavaUtilList = paramRedPointUIData.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_AndroidViewView = paramRedPointUIData.jdField_a_of_type_AndroidViewView;
    }
    b();
    d();
  }
  
  private void a(RedPointInfo paramRedPointInfo)
  {
    if (paramRedPointInfo != null)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null)
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          RedPointItem localRedPointItem = paramRedPointInfo.a(((Integer)((Iterator)localObject).next()).intValue());
          if ((localRedPointItem != null) && (localRedPointItem.unReadNum != 0))
          {
            bool = true;
            break label75;
          }
        }
        boolean bool = false;
        label75:
        if (QLog.isColorLevel())
        {
          paramRedPointInfo = new StringBuilder();
          paramRedPointInfo.append("updateRedPointUI mUin = ");
          paramRedPointInfo.append(this.jdField_a_of_type_JavaLangString);
          paramRedPointInfo.append(",mUinType = ");
          paramRedPointInfo.append(this.b);
          paramRedPointInfo.append(", isShowRedPoint = ");
          paramRedPointInfo.append(bool);
          QLog.d("DrawRedPointUIComponent", 2, paramRedPointInfo.toString());
        }
        if (bool)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  private void a(RedPointInfo paramRedPointInfo, HashSet<Integer> paramHashSet)
  {
    if ((paramRedPointInfo != null) && (a() != null))
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      paramHashSet = a().iterator();
      while (paramHashSet.hasNext())
      {
        RedPointItem localRedPointItem = paramRedPointInfo.a(((Integer)paramHashSet.next()).intValue());
        if ((localRedPointItem != null) && (localRedPointItem.unReadNum != 0))
        {
          bool = true;
          break label76;
        }
      }
      boolean bool = false;
      label76:
      if (QLog.isColorLevel())
      {
        paramRedPointInfo = new StringBuilder();
        paramRedPointInfo.append("UpdateUI: isShowRedPoint = ");
        paramRedPointInfo.append(bool);
        paramRedPointInfo.append(",mUin = ");
        paramRedPointInfo.append(this.jdField_a_of_type_JavaLangString);
        paramRedPointInfo.append(", mUinType = ");
        paramRedPointInfo.append(this.b);
        QLog.d("DrawRedPointUIComponent", 2, paramRedPointInfo.toString());
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private boolean a(String paramString1, String paramString2, RedPointInfo paramRedPointInfo, HashSet<Integer> paramHashSet)
  {
    boolean bool4 = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool1;
    if (!bool4)
    {
      bool2 = bool1;
      if (!TextUtils.isEmpty(this.b))
      {
        bool2 = bool1;
        if (this.jdField_a_of_type_JavaLangString.equals(paramString1))
        {
          if (!this.b.equals(paramString2)) {
            return false;
          }
          paramString1 = a();
          bool2 = bool1;
          if (paramRedPointInfo != null)
          {
            bool2 = bool1;
            if (paramHashSet != null)
            {
              if (paramString1 == null) {
                return false;
              }
              paramString1 = paramString1.iterator();
              do
              {
                bool1 = bool3;
                if (!paramString1.hasNext()) {
                  break;
                }
              } while (!paramHashSet.contains((Integer)paramString1.next()));
              bool1 = true;
              bool2 = bool1;
              if (QLog.isColorLevel())
              {
                paramString1 = new StringBuilder();
                paramString1.append("mUin = ");
                paramString1.append(this.jdField_a_of_type_JavaLangString);
                paramString1.append(", mUinType = ");
                paramString1.append(this.b);
                paramString1.append(", needUpdate = ");
                paramString1.append(bool1);
                QLog.d("DrawRedPointUIComponent", 2, paramString1.toString());
                bool2 = bool1;
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  private void b()
  {
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localAppRuntime != null) {
      ((IRedPointInfoService)localAppRuntime.getRuntimeService(IRedPointInfoService.class, "")).addRedPointListener(this.jdField_a_of_type_ComTencentMobileqqTroopRedpointRedPointListener);
    }
  }
  
  private void c()
  {
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localAppRuntime != null) {
      ((IRedPointInfoService)localAppRuntime.getRuntimeService(IRedPointInfoService.class, "")).removeRedPointListener(this.jdField_a_of_type_ComTencentMobileqqTroopRedpointRedPointListener);
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b)))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initRedPointUI mUin = ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(",mUinType = ");
          ((StringBuilder)localObject).append(this.b);
          QLog.d("DrawRedPointUIComponent", 2, ((StringBuilder)localObject).toString());
        }
        a(((IRedPointInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedPointInfoService.class, "")).getRedPointInfo(this.jdField_a_of_type_JavaLangString, this.b));
      }
    }
  }
  
  public List<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    c();
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.DrawRedPointUIComponent
 * JD-Core Version:    0.7.0.1
 */