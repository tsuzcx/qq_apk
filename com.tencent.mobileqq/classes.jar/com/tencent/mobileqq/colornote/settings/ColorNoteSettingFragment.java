package com.tencent.mobileqq.colornote.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.api.impl.ColorNoteControllerImpl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfBean;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class ColorNoteSettingFragment
  extends QIphoneTitleBarFragment
{
  private Activity a;
  private SettingSectionContainer b;
  private FormSwitchItem c;
  private TextView d;
  
  public static void a(Context paramContext, Class<? extends ColorNoteSettingFragment> paramClass, Bundle paramBundle)
  {
    if ((paramContext != null) && (paramClass != null))
    {
      ReportController.b(null, "dc00898", "", "", "0X800AA7E", "0X800AA7E", paramBundle.getInt("start_from", 1), 0, "", "", "", "");
      paramBundle = new Intent();
      paramBundle.addFlags(268435456);
      paramBundle.addFlags(536870912);
      paramBundle.addFlags(67108864);
      QPublicFragmentActivity.Launcher.a(paramContext, paramBundle, QPublicFragmentActivity.class, paramClass);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("start fragment: ");
        paramContext.append(paramClass.getName());
        QLog.d("ColorNoteSettingFragment", 2, paramContext.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramBundle = "";
      if (paramContext == null) {
        paramContext = "context ";
      } else {
        paramContext = "";
      }
      localStringBuilder.append(paramContext);
      paramContext = paramBundle;
      if (paramClass == null) {
        paramContext = "fragment ";
      }
      localStringBuilder.append(paramContext);
      localStringBuilder.append("is null");
      QLog.d("ColorNoteSettingFragment", 2, localStringBuilder.toString());
    }
  }
  
  private void b()
  {
    if (!isAdded())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSettingFragment", 2, "[loadContentView] fragment is not attached");
      }
      return;
    }
    this.b = ((SettingSectionContainer)this.t.findViewById(2131430975));
    this.b.removeAllViews();
    SparseArray localSparseArray = c();
    Iterator localIterator = ColorNoteHistoryManager.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (IOnHeaderClickHandler)localIterator.next();
      if ((localObject1 != null) && (!TextUtils.isEmpty(((IOnHeaderClickHandler)localObject1).a())))
      {
        int i = ((IOnHeaderClickHandler)localObject1).b();
        Object localObject2 = ColorNoteHistoryManager.a((List)localSparseArray.get(i));
        ColorNoteSettingBaseSection localColorNoteSettingBaseSection = new ColorNoteSettingBaseSection(this.a);
        BaseSectionAdapter localBaseSectionAdapter = new BaseSectionAdapter(getQBaseActivity().getAppRuntime());
        localColorNoteSettingBaseSection.setAdapter(localBaseSectionAdapter);
        if (localObject2 != null)
        {
          if (((List)localObject2).size() > 0) {
            localColorNoteSettingBaseSection.setBgType(1);
          } else {
            localColorNoteSettingBaseSection.setBgType(0);
          }
          localBaseSectionAdapter.a((List)localObject2, i);
        }
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = this.t.getContext().getResources().getDimensionPixelSize(2131299685);
        localColorNoteSettingBaseSection.setHeaderOnClickListener(new ColorNoteSettingFragment.2(this, (IOnHeaderClickHandler)localObject1, i));
        localObject1 = ((IOnHeaderClickHandler)localObject1).a();
        localColorNoteSettingBaseSection.setHeaderTitle((CharSequence)localObject1);
        localColorNoteSettingBaseSection.setContentDescription((CharSequence)localObject1);
        this.b.addView(localColorNoteSettingBaseSection, (ViewGroup.LayoutParams)localObject2);
        ColorNoteHistoryManager.d(getQBaseActivity().getAppRuntime(), i);
      }
    }
    a(getString(2131887859));
  }
  
  private SparseArray<List<ColorNote>> c()
  {
    Object localObject1 = ColorNoteHistoryManager.a;
    SparseArray localSparseArray = new SparseArray(localObject1.length);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      int k = localObject1[i];
      localSparseArray.put(k, ColorNoteHistoryManager.a(getQBaseActivity().getAppRuntime(), k));
      i += 1;
    }
    List localList = (List)localSparseArray.get(17039360);
    localObject1 = new ArrayList();
    Object localObject2 = localList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ColorNote)((Iterator)localObject2).next();
      if (ColorNoteSmallScreenUtil.a(((ColorNote)localObject3).getSubType()) == 4) {
        ((List)localObject1).add(localObject3);
      }
    }
    localList.removeAll((Collection)localObject1);
    localList = ColorNoteHistoryManager.a(getQBaseActivity().getAppRuntime(), 16908288);
    localObject2 = ColorNoteHistoryManager.a(getQBaseActivity().getAppRuntime(), 16908290);
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
    Collections.sort((List)localObject3, new ColorNoteSettingFragment.3(this));
    return localSparseArray;
  }
  
  private void d()
  {
    AppRuntime localAppRuntime = getQBaseActivity().getAppRuntime();
    ColorNoteRecentConfBean localColorNoteRecentConfBean = ColorNoteRecentConfigProcessor.a();
    boolean bool = true;
    int i;
    if ((localColorNoteRecentConfBean != null) && (localColorNoteRecentConfBean.a())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!ColorNoteControllerImpl.isRecentlyViewedSwitchOn(localAppRuntime)) || (i == 0)) {
      bool = false;
    }
    this.c = ((FormSwitchItem)this.t.findViewById(2131430971));
    this.d = ((TextView)this.t.findViewById(2131430972));
    if (i != 0)
    {
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      this.c.setChecked(bool);
      this.c.setOnCheckedChangeListener(new ColorNoteSettingFragment.4(this, localAppRuntime));
    }
  }
  
  protected int a()
  {
    return 2131624512;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    d();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.a = paramActivity;
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