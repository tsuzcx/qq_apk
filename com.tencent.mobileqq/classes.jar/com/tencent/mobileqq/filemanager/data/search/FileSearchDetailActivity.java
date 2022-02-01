package com.tencent.mobileqq.filemanager.data.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class FileSearchDetailActivity
  extends IphoneTitleBarActivity
{
  static FileEntitySearchResultModel a;
  FileEntitySearchResultModel b;
  
  public static void a(Context paramContext, String paramString, FileEntitySearchResultModel paramFileEntitySearchResultModel)
  {
    a = paramFileEntitySearchResultModel;
    paramFileEntitySearchResultModel = new Intent(paramContext, FileSearchDetailActivity.class);
    paramFileEntitySearchResultModel.putExtra("keyword", paramString);
    paramContext.startActivity(paramFileEntitySearchResultModel);
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
    this.b = a;
    paramBundle = this.b;
    if ((paramBundle != null) && (paramBundle.a != null) && (this.b.a.size() != 0))
    {
      super.setContentView(2131558898);
      super.setTitle(((FileManagerEntity)this.b.a.get(0)).fileName);
      Object localObject = getSupportFragmentManager();
      paramBundle = FileSearchDetailFragment.a(getIntent().getStringExtra("keyword"), this.b);
      localObject = ((FragmentManager)localObject).beginTransaction();
      ((FragmentTransaction)localObject).replace(2131365183, paramBundle);
      ((FragmentTransaction)localObject).commit();
      return true;
    }
    paramBundle = this.b;
    if (paramBundle == null) {
      QLog.e("IphoneTitleBarActivity", 1, "FileSearchDetailActivity onCreate, searchResult is null");
    } else if (paramBundle.a == null) {
      QLog.e("IphoneTitleBarActivity", 1, "FileSearchDetailActivity onCreate, searchResult.lstentity is null ");
    } else if (this.b.a.size() == 0) {
      QLog.e("IphoneTitleBarActivity", 1, "FileSearchDetailActivity onCreate, searchResult.lstentity.size() is 0 ");
    }
    finish();
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchDetailActivity
 * JD-Core Version:    0.7.0.1
 */