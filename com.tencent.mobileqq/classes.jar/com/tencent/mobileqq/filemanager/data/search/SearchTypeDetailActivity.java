package com.tencent.mobileqq.filemanager.data.search;

import Override;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.view.MotionEvent;
import anni;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class SearchTypeDetailActivity
  extends IphoneTitleBarActivity
{
  private int jdField_a_of_type_Int;
  private SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private String jdField_a_of_type_JavaLangString;
  private List<Integer> jdField_a_of_type_JavaUtilList;
  
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = super.getIntent().getIntExtra("qfile_search_param_type", -1);
    this.jdField_a_of_type_JavaLangString = super.getIntent().getStringExtra("qfile_search_param_uin");
    this.jdField_a_of_type_JavaUtilList = super.getIntent().getBundleExtra("qfile_search_param_others").getIntegerArrayList("qfile_search_param_others");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(3, anni.a(2131712438));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, anni.a(2131712442));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(0, anni.a(2131712441));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, anni.a(2131712440));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(11, anni.a(2131712439));
    super.setContentView(2131558929);
    super.setTitle((CharSequence)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int));
    paramBundle = getSupportFragmentManager().beginTransaction();
    ChatFileSearchFragment localChatFileSearchFragment = new ChatFileSearchFragment();
    localChatFileSearchFragment.c = 2;
    localChatFileSearchFragment.jdField_a_of_type_Int = 2;
    localChatFileSearchFragment.b = this.jdField_a_of_type_Int;
    localChatFileSearchFragment.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    localChatFileSearchFragment.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramBundle.replace(2131365013, localChatFileSearchFragment);
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