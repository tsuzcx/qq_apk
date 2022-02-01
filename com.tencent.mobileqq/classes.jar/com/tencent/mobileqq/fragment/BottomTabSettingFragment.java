package com.tencent.mobileqq.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import auvp;
import bmhv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.chat.QCircleSharePreferenceUtil;
import java.util.HashMap;
import olh;

public class BottomTabSettingFragment
  extends IphoneTitleBarFragment
{
  private int jdField_a_of_type_Int;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private auvp jdField_a_of_type_Auvp;
  private final HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private static int a()
  {
    boolean bool1 = QzoneConfig.isShowQQCircleMainTabEntrance();
    boolean bool2 = bmhv.l();
    if (bool1) {
      return 2;
    }
    if (bool2) {
      return 1;
    }
    return 0;
  }
  
  public static String a(Resources paramResources)
  {
    if (paramResources == null) {
      return "";
    }
    switch (a())
    {
    default: 
      return paramResources.getString(2131690664);
    case 1: 
      return paramResources.getString(2131693417);
    }
    return paramResources.getString(2131697591);
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), getResources().getString(2131690664));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), getResources().getString(2131693417));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), getResources().getString(2131697591));
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Auvp != null) {
        this.jdField_a_of_type_Auvp.notifyDataSetChanged();
      }
      QQToast.a(getActivity(), 2, 2131694775, 2000).a();
      return;
      b(true);
      a(false);
      continue;
      b(false);
      a(false);
      continue;
      b(false);
      a(true);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      QCircleSharePreferenceUtil.updateQCircleSpValue("SP_KEY_QCIRCLE_MAIN_TAB", Integer.valueOf(i));
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i;
    QQAppInterface localQQAppInterface;
    String str1;
    if (paramBoolean)
    {
      i = 1;
      bmhv.d(i);
      bmhv.a(paramBoolean);
      bmhv.a(true);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (!paramBoolean) {
        break label76;
      }
      str1 = "0X8008236";
      label37:
      if (!paramBoolean) {
        break label82;
      }
    }
    label76:
    label82:
    for (String str2 = "0X8008236";; str2 = "0X8008235")
    {
      olh.a(localQQAppInterface, "CliOper", "", "", str1, str2, 0, 1, "", "", "", "", false);
      return;
      i = 0;
      break;
      str1 = "0X8008235";
      break label37;
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getResources().getText(2131690665));
    a();
    this.jdField_a_of_type_Int = a();
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.mContentView.findViewById(2131363745));
    this.jdField_a_of_type_Auvp = new auvp(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Auvp);
  }
  
  protected int getContentLayoutId()
  {
    return 2131560748;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.BottomTabSettingFragment
 * JD-Core Version:    0.7.0.1
 */