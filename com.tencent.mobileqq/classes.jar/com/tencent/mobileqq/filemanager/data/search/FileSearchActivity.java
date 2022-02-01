package com.tencent.mobileqq.filemanager.data.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.searchtype.QFileOfflineSearchTypeController;
import com.tencent.mobileqq.filemanager.data.search.searchtype.QFileTroopSearchTypeController;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment;
import com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchFragment;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSearchActivity
  extends BaseSearchActivity
{
  static List<ISearchResultModel> jdField_a_of_type_JavaUtilList;
  private int jdField_a_of_type_Int = -1;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private SearchTypeFragment jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment;
  private BaseSearchFragment jdField_b_of_type_ComTencentMobileqqSearchBaseFragmentBaseSearchFragment;
  List<ISearchResultModel> jdField_b_of_type_JavaUtilList;
  private boolean c = true;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private String e;
  
  public static void a(Activity paramActivity, String paramString1, List<ISearchResultModel> paramList, boolean paramBoolean, int paramInt, String paramString2, Bundle paramBundle)
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
  
  public static void a(Context paramContext, String paramString, List<ISearchResultModel> paramList, boolean paramBoolean, int paramInt)
  {
    a(paramContext, paramString, paramList, paramBoolean, paramInt, "", null);
  }
  
  public static void a(Context paramContext, String paramString1, List<ISearchResultModel> paramList, boolean paramBoolean, int paramInt, String paramString2, Bundle paramBundle)
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
  
  protected BaseSearchFragment a()
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject;
    if (i == 8)
    {
      localObject = new FileSearchFragment();
      ((FileSearchFragment)localObject).jdField_b_of_type_JavaUtilList = jdField_a_of_type_JavaUtilList;
      ((FileSearchFragment)localObject).jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      ((FileSearchFragment)localObject).c = this.jdField_a_of_type_Int;
      ((FileSearchFragment)localObject).b(this.c);
    }
    else if (i == 2)
    {
      localObject = new ChatFileSearchFragment();
      ((ChatFileSearchFragment)localObject).jdField_a_of_type_JavaLangString = this.e;
      ((ChatFileSearchFragment)localObject).jdField_b_of_type_JavaUtilList = jdField_a_of_type_JavaUtilList;
      ((ChatFileSearchFragment)localObject).jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      ((ChatFileSearchFragment)localObject).jdField_a_of_type_Int = 1;
      ((ChatFileSearchFragment)localObject).c = this.jdField_a_of_type_Int;
      ((ChatFileSearchFragment)localObject).b(false);
      this.jdField_b_of_type_ComTencentMobileqqSearchBaseFragmentBaseSearchFragment = ((BaseSearchFragment)localObject);
    }
    else if (i == 13)
    {
      localObject = new TroopFileSearchFragment();
      ((TroopFileSearchFragment)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      ((TroopFileSearchFragment)localObject).jdField_a_of_type_Long = Long.parseLong(this.e);
      this.jdField_b_of_type_ComTencentMobileqqSearchBaseFragmentBaseSearchFragment = ((BaseSearchFragment)localObject);
    }
    else if ((i != 15) && (i != 16) && (i != 17) && (i != 18) && (i != 19))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("newSearchFragment. can not handle type. type[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append("]");
      QLog.w("FileSearchActivity<QFile>", 1, ((StringBuilder)localObject).toString());
      localObject = new FileSearchFragment();
      ((FileSearchFragment)localObject).jdField_b_of_type_JavaUtilList = jdField_a_of_type_JavaUtilList;
      ((FileSearchFragment)localObject).jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      ((FileSearchFragment)localObject).c = this.jdField_a_of_type_Int;
      ((FileSearchFragment)localObject).b(this.c);
    }
    else
    {
      localObject = new FileSelectorSearchFragment();
      ((FileSelectorSearchFragment)localObject).a(this.jdField_a_of_type_Int);
      ((FileSelectorSearchFragment)localObject).a(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_b_of_type_ComTencentMobileqqSearchBaseFragmentBaseSearchFragment = ((BaseSearchFragment)localObject);
    }
    UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0X8009D58", 0, 0, null, null);
    return localObject;
  }
  
  protected String a()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusable(true);
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      new Handler().postDelayed(new FileSearchActivity.1(this), 200L);
    }
    String str = HardCodeUtil.a(2131704674);
    int i = this.jdField_a_of_type_Int;
    if (i == 16) {
      return getString(2131692327);
    }
    if (i == 17) {
      str = getString(2131692326);
    }
    return str;
  }
  
  protected void a()
  {
    c();
    super.a();
    b();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    int i = this.jdField_a_of_type_Int;
    if ((i != 2) && (i != 13)) {
      return;
    }
    paramEditable = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
    if (this.jdField_b_of_type_ComTencentMobileqqSearchBaseFragmentBaseSearchFragment != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment == null) {
        return;
      }
      if ((TextUtils.isEmpty(paramEditable)) && (!this.jdField_d_of_type_Boolean))
      {
        paramEditable = super.getSupportFragmentManager().beginTransaction();
        paramEditable.show(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment);
        paramEditable.hide(this.jdField_b_of_type_ComTencentMobileqqSearchBaseFragmentBaseSearchFragment);
        paramEditable.commit();
        this.jdField_d_of_type_Boolean = true;
        return;
      }
      if (!TextUtils.isEmpty(paramEditable))
      {
        paramEditable = super.getSupportFragmentManager().beginTransaction();
        paramEditable.show(this.jdField_b_of_type_ComTencentMobileqqSearchBaseFragmentBaseSearchFragment);
        paramEditable.hide(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment);
        paramEditable.commit();
        this.jdField_d_of_type_Boolean = false;
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Int == 2) && (Build.VERSION.SDK_INT >= 5)) {
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 9999)
    {
      if (paramIntent == null) {
        return;
      }
      if (paramIntent.getIntExtra("qfile_send_bottom_bar_finish_result_code", 0) == -1)
      {
        setResult(paramInt2, new Intent(paramIntent));
        finish();
      }
    }
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    b();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject2 = getIntent();
    this.jdField_d_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("keyword");
    Object localObject1 = Integer.valueOf(1);
    this.c = ((Intent)localObject2).getBooleanExtra("show_Header", true);
    this.jdField_a_of_type_Int = ((Intent)localObject2).getIntExtra("from_type", -1);
    this.e = ((Intent)localObject2).getStringExtra("qfile_search_param_uin");
    this.jdField_a_of_type_AndroidOsBundle = ((Intent)localObject2).getBundleExtra("qfile_search_param_ex_params");
    int i = this.jdField_a_of_type_Int;
    localObject2 = Integer.valueOf(0);
    Integer localInteger = Integer.valueOf(2);
    if (((i == 2) || (i == 13)) && (Build.VERSION.SDK_INT >= 5)) {
      overridePendingTransition(0, 0);
    }
    super.doOnCreate(paramBundle);
    i = this.jdField_a_of_type_Int;
    if (i == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment = new SearchTypeFragment();
      paramBundle = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(3), localInteger, localObject2, localObject1, Integer.valueOf(11) }));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment;
      ((SearchTypeFragment)localObject1).jdField_a_of_type_JavaUtilList = paramBundle;
      ((SearchTypeFragment)localObject1).jdField_a_of_type_Int = 4;
      ((SearchTypeFragment)localObject1).a(new QFileOfflineSearchTypeController((QQAppInterface)getAppRuntime(), this, this.e, paramBundle));
    }
    else if (i == 13)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment = new SearchTypeFragment();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment.jdField_a_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(13), Integer.valueOf(3), localInteger, localObject2, localObject1, Integer.valueOf(11) });
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment;
      paramBundle.jdField_a_of_type_Int = 4;
      paramBundle.a(new QFileTroopSearchTypeController((QQAppInterface)getAppRuntime(), this, this.e));
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment;
    if (paramBundle != null)
    {
      paramBundle.jdField_a_of_type_JavaLangString = this.e;
      paramBundle = super.getSupportFragmentManager().beginTransaction();
      paramBundle.add(2131377051, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchTypeFragment);
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
  }
  
  protected void doOnStop()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchActivity
 * JD-Core Version:    0.7.0.1
 */