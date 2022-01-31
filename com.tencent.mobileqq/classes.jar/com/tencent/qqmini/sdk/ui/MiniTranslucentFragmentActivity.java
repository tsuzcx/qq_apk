package com.tencent.qqmini.sdk.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import bfff;
import bffu;

public class MiniTranslucentFragmentActivity
  extends MiniFragmentActivity
{
  public static void a(Activity paramActivity, Intent paramIntent, Class<? extends MiniBaseFragment> paramClass, int paramInt)
  {
    bfff.a(paramActivity, paramIntent, MiniTranslucentFragmentActivity.class, paramClass, paramInt);
  }
  
  public static void a(Context paramContext, Intent paramIntent, Class<? extends MiniBaseFragment> paramClass)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, MiniTranslucentFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", paramClass.getName());
    paramContext.startActivity(localIntent);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    getWindow().addFlags(67108864);
    bffu.b(this);
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