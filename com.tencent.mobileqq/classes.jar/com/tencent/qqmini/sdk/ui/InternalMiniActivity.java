package com.tencent.qqmini.sdk.ui;

import android.view.KeyEvent;

public class InternalMiniActivity
  extends MiniActivity
{
  public void onBackPressed()
  {
    finish();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.InternalMiniActivity
 * JD-Core Version:    0.7.0.1
 */