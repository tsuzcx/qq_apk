package com.tencent.mobileqq.filemanager.data.search;

import Override;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ImageView;
import anvx;
import atqt;
import atqu;
import bcfj;
import bcjs;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment;
import com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchFragment;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSearchActivity
  extends BaseSearchActivity
{
  static List<bcfj> jdField_a_of_type_JavaUtilList;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private SearchTypeFragment jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment;
  private BaseSearchFragment jdField_b_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment;
  List<bcfj> jdField_b_of_type_JavaUtilList;
  private boolean c = true;
  private int jdField_d_of_type_Int = -1;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String e;
  
  public static void a(Activity paramActivity, String paramString1, List<bcfj> paramList, boolean paramBoolean, int paramInt, String paramString2, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity, FileSearchActivity.class);
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("show_Header", paramBoolean);
    localIntent.putExtra("from_type", paramInt);
    localIntent.putExtra("qfile_search_param_uin", paramString2);
    if (paramBundle != null) {
      localIntent.putExtra("qfile_search_param_ex_params", paramBundle);
    }
    jdField_a_of_type_JavaUtilList = paramList;
    if (jdField_a_of_type_JavaUtilList == null) {
      jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    paramActivity.startActivityForResult(localIntent, 9999);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    a(paramContext, null, null, false, paramInt, paramString, null);
  }
  
  public static void a(Context paramContext, String paramString, List<bcfj> paramList, boolean paramBoolean, int paramInt)
  {
    a(paramContext, paramString, paramList, paramBoolean, paramInt, "", null);
  }
  
  public static void a(Context paramContext, String paramString1, List<bcfj> paramList, boolean paramBoolean, int paramInt, String paramString2, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, FileSearchActivity.class);
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("show_Header", paramBoolean);
    localIntent.putExtra("from_type", paramInt);
    localIntent.putExtra("qfile_search_param_uin", paramString2);
    if (paramBundle != null) {
      localIntent.putExtra("qfile_search_param_ex_params", paramBundle);
    }
    jdField_a_of_type_JavaUtilList = paramList;
    if (jdField_a_of_type_JavaUtilList == null) {
      jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    paramContext.startActivity(localIntent);
  }
  
  public BaseSearchFragment a()
  {
    Object localObject;
    if (this.jdField_d_of_type_Int == 8)
    {
      localObject = new FileSearchFragment();
      ((FileSearchFragment)localObject).jdField_b_of_type_JavaUtilList = jdField_a_of_type_JavaUtilList;
      ((FileSearchFragment)localObject).jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      ((FileSearchFragment)localObject).c = this.jdField_d_of_type_Int;
      ((FileSearchFragment)localObject).b(this.c);
    }
    for (;;)
    {
      bcjs.a(null, 0, this.jdField_d_of_type_Int, "0X8009D58", 0, 0, null, null);
      return localObject;
      if (this.jdField_d_of_type_Int == 2)
      {
        localObject = new ChatFileSearchFragment();
        ((ChatFileSearchFragment)localObject).jdField_a_of_type_JavaLangString = this.e;
        ((ChatFileSearchFragment)localObject).jdField_b_of_type_JavaUtilList = jdField_a_of_type_JavaUtilList;
        ((ChatFileSearchFragment)localObject).jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
        ((ChatFileSearchFragment)localObject).jdField_a_of_type_Int = 1;
        ((ChatFileSearchFragment)localObject).c = this.jdField_d_of_type_Int;
        ((ChatFileSearchFragment)localObject).b(false);
        this.jdField_b_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment = ((BaseSearchFragment)localObject);
      }
      else if (this.jdField_d_of_type_Int == 13)
      {
        localObject = new TroopFileSearchFragment();
        ((TroopFileSearchFragment)localObject).jdField_a_of_type_Int = this.jdField_d_of_type_Int;
        ((TroopFileSearchFragment)localObject).jdField_a_of_type_Long = Long.parseLong(this.e);
        this.jdField_b_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment = ((BaseSearchFragment)localObject);
      }
      else if ((this.jdField_d_of_type_Int == 15) || (this.jdField_d_of_type_Int == 16) || (this.jdField_d_of_type_Int == 17) || (this.jdField_d_of_type_Int == 18) || (this.jdField_d_of_type_Int == 19))
      {
        localObject = new FileSelectorSearchFragment();
        ((FileSelectorSearchFragment)localObject).a(this.jdField_d_of_type_Int);
        ((FileSelectorSearchFragment)localObject).a(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_b_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment = ((BaseSearchFragment)localObject);
      }
      else
      {
        QLog.w("FileSearchActivity<QFile>", 1, "newSearchFragment. can not handle type. type[" + this.jdField_d_of_type_Int + "]");
        localObject = new FileSearchFragment();
        ((FileSearchFragment)localObject).jdField_b_of_type_JavaUtilList = jdField_a_of_type_JavaUtilList;
        ((FileSearchFragment)localObject).jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
        ((FileSearchFragment)localObject).c = this.jdField_d_of_type_Int;
        ((FileSearchFragment)localObject).b(this.c);
      }
    }
  }
  
  public String a()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusable(true);
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      new Handler().postDelayed(new FileSearchActivity.1(this), 200L);
    }
    String str = anvx.a(2131704046);
    if (this.jdField_d_of_type_Int == 16) {
      str = getString(2131692268);
    }
    while (this.jdField_d_of_type_Int != 17) {
      return str;
    }
    return getString(2131692267);
  }
  
  public void a()
  {
    c();
    super.a();
    b();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    if ((this.jdField_d_of_type_Int != 2) && (this.jdField_d_of_type_Int != 13)) {}
    do
    {
      do
      {
        return;
        paramEditable = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
      } while ((this.jdField_b_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment == null));
      if ((TextUtils.isEmpty(paramEditable)) && (!this.jdField_d_of_type_Boolean))
      {
        paramEditable = super.getSupportFragmentManager().beginTransaction();
        paramEditable.show(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment);
        paramEditable.hide(this.jdField_b_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment);
        paramEditable.commit();
        this.jdField_d_of_type_Boolean = true;
        return;
      }
    } while (TextUtils.isEmpty(paramEditable));
    paramEditable = super.getSupportFragmentManager().beginTransaction();
    paramEditable.show(this.jdField_b_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment);
    paramEditable.hide(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment);
    paramEditable.commit();
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void b()
  {
    if ((this.jdField_d_of_type_Int == 2) && (Build.VERSION.SDK_INT >= 5)) {
      overridePendingTransition(0, 0);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 != 9999) || (paramIntent == null)) {}
    while (paramIntent.getIntExtra("qfile_send_bottom_bar_finish_result_code", 0) != -1) {
      return;
    }
    setResult(paramInt2, new Intent(paramIntent));
    finish();
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    b();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("keyword");
    this.c = localIntent.getBooleanExtra("show_Header", true);
    this.jdField_d_of_type_Int = localIntent.getIntExtra("from_type", -1);
    this.e = localIntent.getStringExtra("qfile_search_param_uin");
    this.jdField_a_of_type_AndroidOsBundle = localIntent.getBundleExtra("qfile_search_param_ex_params");
    if (((this.jdField_d_of_type_Int == 2) || (this.jdField_d_of_type_Int == 13)) && (Build.VERSION.SDK_INT >= 5)) {
      overridePendingTransition(0, 0);
    }
    super.doOnCreate(paramBundle);
    if (this.jdField_d_of_type_Int == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment = new SearchTypeFragment();
      paramBundle = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(11) }));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment.jdField_a_of_type_JavaUtilList = paramBundle;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment.jdField_a_of_type_Int = 4;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment.a(new atqt(this.app, this, this.e, paramBundle));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment.jdField_a_of_type_JavaLangString = this.e;
        paramBundle = super.getSupportFragmentManager().beginTransaction();
        paramBundle.add(2131377188, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment);
        paramBundle.commit();
        this.jdField_d_of_type_Boolean = true;
      }
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      if (jdField_a_of_type_JavaUtilList == null) {
        jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_b_of_type_JavaUtilList.addAll(jdField_a_of_type_JavaUtilList);
      jdField_a_of_type_JavaUtilList = null;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return true;
      if (this.jdField_d_of_type_Int == 13)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment = new SearchTypeFragment();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment.jdField_a_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(13), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(11) });
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment.jdField_a_of_type_Int = 4;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment.a(new atqu(this.app, this, this.e));
      }
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchActivity
 * JD-Core Version:    0.7.0.1
 */