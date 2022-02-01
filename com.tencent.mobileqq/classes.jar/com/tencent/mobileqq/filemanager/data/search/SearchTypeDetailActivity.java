package com.tencent.mobileqq.filemanager.data.search;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class SearchTypeDetailActivity
  extends IphoneTitleBarActivity
{
  private int a;
  private String b;
  private SparseArray<String> c = new SparseArray();
  private List<Integer> d;
  
  public static void a(Context paramContext, int paramInt, String paramString, List<Integer> paramList)
  {
    Intent localIntent = new Intent(paramContext, SearchTypeDetailActivity.class);
    localIntent.putExtra("qfile_search_param_type", paramInt);
    localIntent.putExtra("qfile_search_param_uin", paramString);
    paramString = new Bundle();
    paramString.putIntegerArrayList("qfile_search_param_others", (ArrayList)paramList);
    localIntent.putExtra("qfile_search_param_others", paramString);
    paramContext.startActivity(localIntent);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = super.getIntent().getIntExtra("qfile_search_param_type", -1);
    this.b = super.getIntent().getStringExtra("qfile_search_param_uin");
    this.d = super.getIntent().getBundleExtra("qfile_search_param_others").getIntegerArrayList("qfile_search_param_others");
    this.c.put(3, HardCodeUtil.a(2131911134));
    this.c.put(2, HardCodeUtil.a(2131911138));
    this.c.put(0, HardCodeUtil.a(2131911137));
    this.c.put(1, HardCodeUtil.a(2131911136));
    this.c.put(11, HardCodeUtil.a(2131911135));
    super.setContentView(2131624520);
    super.setTitle((CharSequence)this.c.get(this.a));
    paramBundle = getSupportFragmentManager().beginTransaction();
    ChatFileSearchFragment localChatFileSearchFragment = new ChatFileSearchFragment();
    localChatFileSearchFragment.i = 2;
    localChatFileSearchFragment.b = 2;
    localChatFileSearchFragment.c = this.a;
    localChatFileSearchFragment.d = this.d;
    localChatFileSearchFragment.a = this.b;
    paramBundle.replace(2131431345, localChatFileSearchFragment);
    paramBundle.commit();
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.SearchTypeDetailActivity
 * JD-Core Version:    0.7.0.1
 */