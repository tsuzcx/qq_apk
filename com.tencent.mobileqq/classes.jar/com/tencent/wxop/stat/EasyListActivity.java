package com.tencent.wxop.stat;

import android.app.ListActivity;

public class EasyListActivity
  extends ListActivity
{
  protected void onPause()
  {
    super.onPause();
    StatService.onPause(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    StatService.onResume(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.EasyListActivity
 * JD-Core Version:    0.7.0.1
 */