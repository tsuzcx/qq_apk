package com.tencent.mobileqq.colornote.settings;

import adpn;
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
import aobw;
import aocp;
import aocq;
import aoea;
import aoee;
import aoeh;
import aoei;
import aoej;
import aoeq;
import arsx;
import azqs;
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
    Object localObject1 = aoee.a;
    SparseArray localSparseArray = new SparseArray(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      int k = localObject1[i];
      localSparseArray.put(k, aoee.a(k));
      i += 1;
    }
    List localList = (List)localSparseArray.get(17039360);
    localObject1 = new ArrayList();
    Object localObject2 = localList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ColorNote)((Iterator)localObject2).next();
      if (arsx.a(((ColorNote)localObject3).getSubType()) == 4) {
        ((List)localObject1).add(localObject3);
      }
    }
    localList.removeAll((Collection)localObject1);
    localList = aoee.a(16908288);
    localObject2 = aoee.a(16908290);
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
    Collections.sort((List)localObject3, new aoei(this));
    return localSparseArray;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsSettingSectionContainer = ((SettingSectionContainer)this.mContentView.findViewById(2131364472));
    this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsSettingSectionContainer.removeAllViews();
    SparseArray localSparseArray = a();
    int[] arrayOfInt = aoee.a;
    int j = arrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject1 = aoee.a(k);
      if ((localObject1 == null) || (TextUtils.isEmpty(((aoeq)localObject1).a()))) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject2 = aoee.a((List)localSparseArray.get(k));
        ColorNoteSettingBaseSection localColorNoteSettingBaseSection = new ColorNoteSettingBaseSection(this.jdField_a_of_type_AndroidAppActivity);
        aoea localaoea = new aoea();
        localColorNoteSettingBaseSection.setAdapter(localaoea);
        localaoea.a((List)localObject2, k);
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = this.mContentView.getContext().getResources().getDimensionPixelSize(2131298702);
        localColorNoteSettingBaseSection.setHeaderOnClickListener(new aoeh(this, (aoeq)localObject1, k));
        localObject1 = ((aoeq)localObject1).a();
        localColorNoteSettingBaseSection.setHeaderTitle((CharSequence)localObject1);
        localColorNoteSettingBaseSection.setContentDescription((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsSettingSectionContainer.addView(localColorNoteSettingBaseSection, (ViewGroup.LayoutParams)localObject2);
        aoee.a(k);
      }
    }
    setTitle(getString(2131690932));
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
      azqs.b(null, "dc00898", "", "", "0X800AA7E", "0X800AA7E", paramBundle.getInt("start_from", 1), 0, "", "", "", "");
      paramBundle = new Intent();
      paramBundle.addFlags(268435456);
      paramBundle.addFlags(536870912);
      paramBundle.addFlags(67108864);
      adpn.a(paramContext, paramBundle, PublicFragmentActivity.class, paramClass);
    } while (!QLog.isColorLevel());
    QLog.d("ColorNoteSettingFragment", 0, "start fragment: " + paramClass.getName());
  }
  
  private void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    aocp localaocp = aocq.a();
    if ((localaocp != null) && (localaocp.a())) {}
    for (int i = 1;; i = 0)
    {
      if ((aobw.a(localQQAppInterface)) && (i != 0)) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131364468));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131364469));
        if (i != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aoej(this, localQQAppInterface));
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
    return 2131558848;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment
 * JD-Core Version:    0.7.0.1
 */