package com.tencent.mobileqq.filemanager.data.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import java.util.ArrayList;
import java.util.List;

public class FileSearchActivity
  extends BaseSearchActivity
{
  static List jdField_a_of_type_JavaUtilList;
  String jdField_a_of_type_JavaLangString;
  List b;
  
  public static void a(Context paramContext, String paramString, List paramList)
  {
    Intent localIntent = new Intent(paramContext, FileSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    jdField_a_of_type_JavaUtilList = paramList;
    if (jdField_a_of_type_JavaUtilList == null) {
      jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    FileSearchFragment localFileSearchFragment = new FileSearchFragment();
    localFileSearchFragment.jdField_a_of_type_JavaUtilList = jdField_a_of_type_JavaUtilList;
    localFileSearchFragment.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    return localFileSearchFragment;
  }
  
  protected String a()
  {
    return "搜索文件";
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("keyword");
    this.b = new ArrayList();
    if (jdField_a_of_type_JavaUtilList == null) {
      jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.b.addAll(jdField_a_of_type_JavaUtilList);
    jdField_a_of_type_JavaUtilList = null;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchActivity
 * JD-Core Version:    0.7.0.1
 */