package com.tencent.mobileqq.troop.redpoint;

import android.text.TextUtils;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class DrawRedPointUIComponent
{
  private View jdField_a_of_type_AndroidViewView;
  public QQAppInterface a;
  private RedPointListener jdField_a_of_type_ComTencentMobileqqTroopRedpointRedPointListener = new DrawRedPointUIComponent.1(this);
  private String jdField_a_of_type_JavaLangString;
  private List<Integer> jdField_a_of_type_JavaUtilList;
  private String b;
  
  public DrawRedPointUIComponent(RedPointUIData paramRedPointUIData)
  {
    if (paramRedPointUIData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramRedPointUIData.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    if ((paramRedPointInfo == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    RedPointItem localRedPointItem;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localRedPointItem = paramRedPointInfo.a(((Integer)localIterator.next()).intValue());
    } while ((localRedPointItem == null) || (localRedPointItem.unReadNum == 0));
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DrawRedPointUIComponent", 0, "updateRedPointUI mUin = " + this.jdField_a_of_type_JavaLangString + ",mUinType = " + this.b + ", isShowRedPoint = " + bool);
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
  }
  
  private void a(RedPointInfo paramRedPointInfo, HashSet<Integer> paramHashSet)
  {
    if ((paramRedPointInfo == null) || (a() == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    paramHashSet = a().iterator();
    RedPointItem localRedPointItem;
    do
    {
      if (!paramHashSet.hasNext()) {
        break;
      }
      localRedPointItem = paramRedPointInfo.a(((Integer)paramHashSet.next()).intValue());
    } while ((localRedPointItem == null) || (localRedPointItem.unReadNum == 0));
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DrawRedPointUIComponent", 0, "UpdateUI: isShowRedPoint = " + bool + ",mUin = " + this.jdField_a_of_type_JavaLangString + ", mUinType = " + this.b);
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
  }
  
  private boolean a(String paramString1, String paramString2, RedPointInfo paramRedPointInfo, HashSet<Integer> paramHashSet)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b)) || (!this.jdField_a_of_type_JavaLangString.equals(paramString1)) || (!this.b.equals(paramString2))) {}
    do
    {
      return false;
      paramString1 = a();
    } while ((paramRedPointInfo == null) || (paramHashSet == null) || (paramString1 == null));
    paramString1 = paramString1.iterator();
    do
    {
      if (!paramString1.hasNext()) {
        break;
      }
    } while (!paramHashSet.contains((Integer)paramString1.next()));
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DrawRedPointUIComponent", 0, "mUin = " + this.jdField_a_of_type_JavaLangString + ", mUinType = " + this.b + ", needUpdate = " + bool);
      }
      return bool;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((RedPointInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RED_POINT_INFO_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopRedpointRedPointListener);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((RedPointInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RED_POINT_INFO_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqTroopRedpointRedPointListener);
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b)) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DrawRedPointUIComponent", 0, "initRedPointUI mUin = " + this.jdField_a_of_type_JavaLangString + ",mUinType = " + this.b);
    }
    a(((RedPointInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RED_POINT_INFO_MANAGER)).a(this.jdField_a_of_type_JavaLangString, this.b));
  }
  
  public List<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    c();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.DrawRedPointUIComponent
 * JD-Core Version:    0.7.0.1
 */