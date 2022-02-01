package com.tencent.qqmini.sdk.launcher.ui;

import android.view.KeyEvent;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;

public class MiniBaseFragment
  extends ReportV4Fragment
{
  public void onBackPressed() {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment
 * JD-Core Version:    0.7.0.1
 */