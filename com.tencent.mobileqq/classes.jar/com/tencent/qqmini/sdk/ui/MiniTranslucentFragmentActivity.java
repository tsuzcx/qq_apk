package com.tencent.qqmini.sdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import bdye;
import bdyn;

public class MiniTranslucentFragmentActivity
  extends MiniFragmentActivity
{
  public static void a(Activity paramActivity, Intent paramIntent, Class<? extends MiniBaseFragment> paramClass, int paramInt)
  {
    bdye.a(paramActivity, paramIntent, MiniTranslucentFragmentActivity.class, paramClass, paramInt);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    getWindow().addFlags(67108864);
    bdyn.b(this);
    super.onCreate(paramBundle);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniTranslucentFragmentActivity
 * JD-Core Version:    0.7.0.1
 */