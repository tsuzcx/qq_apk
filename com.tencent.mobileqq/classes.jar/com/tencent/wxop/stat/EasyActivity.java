package com.tencent.wxop.stat;

import android.app.Activity;

public class EasyActivity
  extends Activity
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
 * Qualified Name:     com.tencent.wxop.stat.EasyActivity
 * JD-Core Version:    0.7.0.1
 */