package com.tencent.mobileqq.intervideo.lite_now_biz.now_live;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class NowWebBizModule$SharePreferenceUtil
{
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  
  public NowWebBizModule$SharePreferenceUtil(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences(paramString, 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
  }
  
  public SharedPreferences.Editor a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  }
  
  public SharedPreferences a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.NowWebBizModule.SharePreferenceUtil
 * JD-Core Version:    0.7.0.1
 */