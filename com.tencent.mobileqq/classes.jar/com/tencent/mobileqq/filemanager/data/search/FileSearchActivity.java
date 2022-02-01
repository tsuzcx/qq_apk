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
  static List<ISearchResultModel> a;
  List<ISearchResultModel> b;
  private String q;
  private boolean r = true;
  private int s = -1;
  private String t;
  private Bundle u;
  private BaseSearchFragment v;
  private SearchTypeFragment w;
  private boolean x = false;
  
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
    a = paramList;
    if (a == null) {
      a = new ArrayList();
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
    a = paramList;
    if (a == null) {
      a = new ArrayList();
    }
    paramContext.startActivity(localIntent);
  }
  
  protected void a()
  {
    f();
    super.a();
    b();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    int i = this.s;
    if ((i != 2) && (i != 13)) {
      return;
    }
    paramEditable = this.d.getText().toString();
    if (this.v != null)
    {
      if (this.w == null) {
        return;
      }
      if ((TextUtils.isEmpty(paramEditable)) && (!this.x))
      {
        paramEditable = super.getSupportFragmentManager().beginTransaction();
        paramEditable.show(this.w);
        paramEditable.hide(this.v);
        paramEditable.commit();
        this.x = true;
        return;
      }
      if (!TextUtils.isEmpty(paramEditable))
      {
        paramEditable = super.getSupportFragmentManager().beginTransaction();
        paramEditable.show(this.v);
        paramEditable.hide(this.w);
        paramEditable.commit();
        this.x = false;
      }
    }
  }
  
  public void b()
  {
    if ((this.s == 2) && (Build.VERSION.SDK_INT >= 5)) {
      overridePendingTransition(0, 0);
    }
  }
  
  protected BaseSearchFragment c()
  {
    int i = this.s;
    Object localObject;
    if (i == 8)
    {
      localObject = new FileSearchFragment();
      ((FileSearchFragment)localObject).f = a;
      ((FileSearchFragment)localObject).g = this.q;
      ((FileSearchFragment)localObject).i = this.s;
      ((FileSearchFragment)localObject).b(this.r);
    }
    else if (i == 2)
    {
      localObject = new ChatFileSearchFragment();
      ((ChatFileSearchFragment)localObject).a = this.t;
      ((ChatFileSearchFragment)localObject).f = a;
      ((ChatFileSearchFragment)localObject).g = this.q;
      ((ChatFileSearchFragment)localObject).b = 1;
      ((ChatFileSearchFragment)localObject).i = this.s;
      ((ChatFileSearchFragment)localObject).b(false);
      this.v = ((BaseSearchFragment)localObject);
    }
    else if (i == 13)
    {
      localObject = new TroopFileSearchFragment();
      ((TroopFileSearchFragment)localObject).a = this.s;
      ((TroopFileSearchFragment)localObject).b = Long.parseLong(this.t);
      this.v = ((BaseSearchFragment)localObject);
    }
    else if ((i != 15) && (i != 16) && (i != 17) && (i != 18) && (i != 19))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("newSearchFragment. can not handle type. type[");
      ((StringBuilder)localObject).append(this.s);
      ((StringBuilder)localObject).append("]");
      QLog.w("FileSearchActivity<QFile>", 1, ((StringBuilder)localObject).toString());
      localObject = new FileSearchFragment();
      ((FileSearchFragment)localObject).f = a;
      ((FileSearchFragment)localObject).g = this.q;
      ((FileSearchFragment)localObject).i = this.s;
      ((FileSearchFragment)localObject).b(this.r);
    }
    else
    {
      localObject = new FileSelectorSearchFragment();
      ((FileSelectorSearchFragment)localObject).a(this.s);
      ((FileSelectorSearchFragment)localObject).a(this.u);
      this.v = ((BaseSearchFragment)localObject);
    }
    UniteSearchReportController.a(null, 0, this.s, "0X8009D58", 0, 0, null, null);
    return localObject;
  }
  
  protected String d()
  {
    this.d.setFocusable(true);
    if (TextUtils.isEmpty(this.q)) {
      new Handler().postDelayed(new FileSearchActivity.1(this), 200L);
    }
    String str = HardCodeUtil.a(2131902578);
    int i = this.s;
    if (i == 16) {
      return getString(2131889315);
    }
    if (i == 17) {
      str = getString(2131889314);
    }
    return str;
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
    this.q = ((Intent)localObject2).getStringExtra("keyword");
    Object localObject1 = Integer.valueOf(1);
    this.r = ((Intent)localObject2).getBooleanExtra("show_Header", true);
    this.s = ((Intent)localObject2).getIntExtra("from_type", -1);
    this.t = ((Intent)localObject2).getStringExtra("qfile_search_param_uin");
    this.u = ((Intent)localObject2).getBundleExtra("qfile_search_param_ex_params");
    int i = this.s;
    localObject2 = Integer.valueOf(0);
    Integer localInteger = Integer.valueOf(2);
    if (((i == 2) || (i == 13)) && (Build.VERSION.SDK_INT >= 5)) {
      overridePendingTransition(0, 0);
    }
    super.doOnCreate(paramBundle);
    i = this.s;
    if (i == 2)
    {
      this.w = new SearchTypeFragment();
      paramBundle = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(3), localInteger, localObject2, localObject1, Integer.valueOf(11) }));
      localObject1 = this.w;
      ((SearchTypeFragment)localObject1).a = paramBundle;
      ((SearchTypeFragment)localObject1).b = 4;
      ((SearchTypeFragment)localObject1).a(new QFileOfflineSearchTypeController((QQAppInterface)getAppRuntime(), this, this.t, paramBundle));
    }
    else if (i == 13)
    {
      this.w = new SearchTypeFragment();
      this.w.a = Arrays.asList(new Integer[] { Integer.valueOf(13), Integer.valueOf(3), localInteger, localObject2, localObject1, Integer.valueOf(11) });
      paramBundle = this.w;
      paramBundle.b = 4;
      paramBundle.a(new QFileTroopSearchTypeController((QQAppInterface)getAppRuntime(), this, this.t));
    }
    paramBundle = this.w;
    if (paramBundle != null)
    {
      paramBundle.c = this.t;
      paramBundle = super.getSupportFragmentManager().beginTransaction();
      paramBundle.add(2131445417, this.w);
      paramBundle.commit();
      this.x = true;
    }
    this.b = new ArrayList();
    if (a == null) {
      a = new ArrayList();
    }
    this.b.addAll(a);
    a = null;
    this.g.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchActivity
 * JD-Core Version:    0.7.0.1
 */