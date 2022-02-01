package com.tencent.mobileqq.search.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ImageButton;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.FunctionSearchFragment;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FunctionSearchActivity
  extends BaseSearchActivity
{
  private static String a(String paramString)
  {
    String str = paramString;
    if (QFileAssistantUtils.a()) {
      if ((!paramString.equals(HardCodeUtil.a(2131698286))) && (!paramString.equalsIgnoreCase(HardCodeUtil.a(2131698285))))
      {
        str = paramString;
        if (!paramString.equalsIgnoreCase(HardCodeUtil.a(2131698284))) {}
      }
      else
      {
        str = HardCodeUtil.a(2131698288);
      }
    }
    return str;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramString = a(paramString);
    Intent localIntent = new Intent(paramContext, FunctionSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    return FunctionSearchFragment.a();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = a(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString());
    if (TextUtils.isEmpty(paramEditable)) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    paramEditable = paramEditable.trim();
    if (!paramEditable.equals(this.jdField_a_of_type_JavaLangString)) {
      com.tencent.mobileqq.search.util.SearchUtils.c = 0L;
    }
    a(paramEditable);
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
    this.jdField_a_of_type_Boolean = true;
    super.doOnCreate(paramBundle);
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.FunctionSearchActivity
 * JD-Core Version:    0.7.0.1
 */