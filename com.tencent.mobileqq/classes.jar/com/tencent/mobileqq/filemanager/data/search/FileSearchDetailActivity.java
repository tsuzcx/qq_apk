package com.tencent.mobileqq.filemanager.data.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import aooj;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FileSearchDetailActivity
  extends IphoneTitleBarActivity
{
  static aooj a;
  aooj b;
  
  public static void a(Context paramContext, String paramString, aooj paramaooj)
  {
    a = paramaooj;
    paramaooj = new Intent(paramContext, FileSearchDetailActivity.class);
    paramaooj.putExtra("keyword", paramString);
    paramContext.startActivity(paramaooj);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.b = a;
    if ((this.b == null) || (this.b.a == null) || (this.b.a.size() == 0))
    {
      if (this.b == null) {
        QLog.e("IphoneTitleBarActivity", 1, "FileSearchDetailActivity onCreate, searchResult is null");
      }
      for (;;)
      {
        finish();
        return false;
        if (this.b.a == null) {
          QLog.e("IphoneTitleBarActivity", 1, "FileSearchDetailActivity onCreate, searchResult.lstentity is null ");
        } else if (this.b.a.size() == 0) {
          QLog.e("IphoneTitleBarActivity", 1, "FileSearchDetailActivity onCreate, searchResult.lstentity.size() is 0 ");
        }
      }
    }
    super.setContentView(2131493264);
    super.setTitle(((FileManagerEntity)this.b.a.get(0)).fileName);
    Object localObject = getSupportFragmentManager();
    paramBundle = FileSearchDetailFragment.a(getIntent().getStringExtra("keyword"), this.b);
    localObject = ((FragmentManager)localObject).beginTransaction();
    ((FragmentTransaction)localObject).replace(2131299146, paramBundle);
    ((FragmentTransaction)localObject).commit();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchDetailActivity
 * JD-Core Version:    0.7.0.1
 */