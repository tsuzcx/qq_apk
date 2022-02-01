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
  public static void a(Context paramContext, String paramString)
  {
    paramString = b(paramString);
    Intent localIntent = new Intent(paramContext, FunctionSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private static String b(String paramString)
  {
    String str = paramString;
    if (QFileAssistantUtils.b()) {
      if ((!paramString.equals(HardCodeUtil.a(2131896187))) && (!paramString.equalsIgnoreCase(HardCodeUtil.a(2131896186))))
      {
        str = paramString;
        if (!paramString.equalsIgnoreCase(HardCodeUtil.a(2131896185))) {}
      }
      else
      {
        str = HardCodeUtil.a(2131896189);
      }
    }
    return str;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = b(this.d.getText().toString());
    if (TextUtils.isEmpty(paramEditable)) {
      this.f.setVisibility(8);
    } else {
      this.f.setVisibility(0);
    }
    paramEditable = paramEditable.trim();
    if (!paramEditable.equals(this.c)) {
      com.tencent.mobileqq.search.util.SearchUtils.e = 0L;
    }
    a(paramEditable);
  }
  
  protected BaseSearchFragment c()
  {
    return FunctionSearchFragment.f();
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
    this.k = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.FunctionSearchActivity
 * JD-Core Version:    0.7.0.1
 */