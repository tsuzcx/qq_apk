package com.tencent.mobileqq.filemanager.data.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.b = a;
    super.setContentView(2130968794);
    super.setTitle(((FileManagerEntity)this.b.a.get(0)).fileName);
    Object localObject = getSupportFragmentManager();
    paramBundle = FileSearchDetailFragment.a(getIntent().getStringExtra("keyword"), this.b);
    localObject = ((FragmentManager)localObject).beginTransaction();
    ((FragmentTransaction)localObject).replace(2131362369, paramBundle);
    ((FragmentTransaction)localObject).commit();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchDetailActivity
 * JD-Core Version:    0.7.0.1
 */