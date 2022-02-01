package com.tencent.qqmini.sdk.launcher.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

public class MiniTranslucentFragmentActivity
  extends MiniFragmentActivity
{
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    getWindow().addFlags(67108864);
    DisplayUtil.setActivityTransparent(this);
    setRequestedOrientation(1);
    super.onCreate(paramBundle);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ui.MiniTranslucentFragmentActivity
 * JD-Core Version:    0.7.0.1
 */