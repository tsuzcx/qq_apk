package com.tencent.mobileqq.filemanager.data.search;

import ajya;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = super.getIntent().getIntExtra("qfile_search_param_type", -1);
    this.jdField_a_of_type_JavaLangString = super.getIntent().getStringExtra("qfile_search_param_uin");
    this.jdField_a_of_type_JavaUtilList = super.getIntent().getBundleExtra("qfile_search_param_others").getIntegerArrayList("qfile_search_param_others");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(3, ajya.a(2131713675));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, ajya.a(2131713679));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(0, ajya.a(2131713678));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, ajya.a(2131713677));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(11, ajya.a(2131713676));
    super.setContentView(2131558822);
    super.setTitle((CharSequence)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int));
    paramBundle = getSupportFragmentManager().beginTransaction();
    ChatFileSearchFragment localChatFileSearchFragment = new ChatFileSearchFragment();
    localChatFileSearchFragment.c = 2;
    localChatFileSearchFragment.jdField_a_of_type_Int = 2;
    localChatFileSearchFragment.b = this.jdField_a_of_type_Int;
    localChatFileSearchFragment.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    localChatFileSearchFragment.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramBundle.replace(2131364705, localChatFileSearchFragment);
    paramBundle.commit();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.SearchTypeDetailActivity
 * JD-Core Version:    0.7.0.1
 */