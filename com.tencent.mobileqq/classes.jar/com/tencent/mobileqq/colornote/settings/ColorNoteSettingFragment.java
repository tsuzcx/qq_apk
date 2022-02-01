package com.tencent.mobileqq.colornote.settings;

import adxr;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import apkn;
import aplk;
import apll;
import apmx;
import apnb;
import apne;
import apnf;
import apng;
import apnn;
import ataw;
import bcef;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ColorNoteSettingFragment
  extends IphoneTitleBarFragment
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SettingSectionContainer jdField_a_of_type_ComTencentMobileqqColornoteSettingsSettingSectionContainer;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  
  private SparseArray<List<ColorNote>> a()
  {
    Object localObject1 = apnb.a;
    SparseArray localSparseArray = new SparseArray(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      int k = localObject1[i];
      localSparseArray.put(k, apnb.a(k));
      i += 1;
    }
    List localList = (List)localSparseArray.get(17039360);
    localObject1 = new ArrayList();
    Object localObject2 = localList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ColorNote)((Iterator)localObject2).next();
      if (ataw.a(((ColorNote)localObject3).getSubType()) == 4) {
        ((List)localObject1).add(localObject3);
      }
    }
    localList.removeAll((Collection)localObject1);
    localList = apnb.a(16908288);
    localObject2 = apnb.a(16908290);
    Object localObject3 = (List)localSparseArray.get(17104896);
    if ((localList != null) && (localList.size() > 0)) {
      ((List)localObject3).addAll(localList);
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
      ((List)localObject3).addAll((Collection)localObject2);
    }
    if (((List)localObject1).size() > 0) {
      ((List)localObject3).addAll((Collection)localObject1);
    }
    Collections.sort((List)localObject3, new apnf(this));
    return localSparseArray;
  }
  
  private void a()
  {
    int i = 0;
    if (!isAdded())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSettingFragment", 0, "[loadContentView] fragment is not attached");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsSettingSectionContainer = ((SettingSectionContainer)this.mContentView.findViewById(2131364755));
    this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsSettingSectionContainer.removeAllViews();
    SparseArray localSparseArray = a();
    int[] arrayOfInt = apnb.a;
    int j = arrayOfInt.length;
    if (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject1 = apnb.a(k);
      if ((localObject1 == null) || (TextUtils.isEmpty(((apnn)localObject1).a()))) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject2 = apnb.a((List)localSparseArray.get(k));
        ColorNoteSettingBaseSection localColorNoteSettingBaseSection = new ColorNoteSettingBaseSection(this.jdField_a_of_type_AndroidAppActivity);
        apmx localapmx = new apmx();
        localColorNoteSettingBaseSection.setAdapter(localapmx);
        localapmx.a((List)localObject2, k);
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = this.mContentView.getContext().getResources().getDimensionPixelSize(2131298863);
        localColorNoteSettingBaseSection.setHeaderOnClickListener(new apne(this, (apnn)localObject1, k));
        localObject1 = ((apnn)localObject1).a();
        localColorNoteSettingBaseSection.setHeaderTitle((CharSequence)localObject1);
        localColorNoteSettingBaseSection.setContentDescription((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsSettingSectionContainer.addView(localColorNoteSettingBaseSection, (ViewGroup.LayoutParams)localObject2);
        apnb.a(k);
      }
    }
    setTitle(getString(2131690814));
  }
  
  public static void a(Context paramContext, Class<? extends ColorNoteSettingFragment> paramClass, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramClass == null)) {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        if (paramContext != null) {
          break label62;
        }
        paramContext = "context ";
        paramBundle = paramBundle.append(paramContext);
        if (paramClass != null) {
          break label68;
        }
        paramContext = "fragment ";
        label42:
        QLog.d("ColorNoteSettingFragment", 0, paramContext + "is null");
      }
    }
    label62:
    label68:
    do
    {
      return;
      paramContext = "";
      break;
      paramContext = "";
      break label42;
      bcef.b(null, "dc00898", "", "", "0X800AA7E", "0X800AA7E", paramBundle.getInt("start_from", 1), 0, "", "", "", "");
      paramBundle = new Intent();
      paramBundle.addFlags(268435456);
      paramBundle.addFlags(536870912);
      paramBundle.addFlags(67108864);
      adxr.a(paramContext, paramBundle, PublicFragmentActivity.class, paramClass);
    } while (!QLog.isColorLevel());
    QLog.d("ColorNoteSettingFragment", 0, "start fragment: " + paramClass.getName());
  }
  
  private void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    aplk localaplk = apll.a();
    if ((localaplk != null) && (localaplk.a())) {}
    for (int i = 1;; i = 0)
    {
      if ((apkn.a(localQQAppInterface)) && (i != 0)) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131364751));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131364752));
        if (i != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new apng(this, localQQAppInterface));
        }
        return;
      }
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
    b();
  }
  
  public int getContentLayoutId()
  {
    return 2131558927;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ColorNoteSettingFragment.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment
 * JD-Core Version:    0.7.0.1
 */