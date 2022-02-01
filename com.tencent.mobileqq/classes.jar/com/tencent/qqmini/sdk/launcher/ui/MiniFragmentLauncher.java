package com.tencent.qqmini.sdk.launcher.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;

public class MiniFragmentLauncher
{
  private static final Class FRAGMENT_ACTIVITY = findClass("MiniFragmentActivity");
  private static final Class FRAGMENT_ACTIVITY_TRANSLUCENT = findClass("MiniTranslucentFragmentActivity");
  private static final String PACKAGE_NAME = "com.tencent.qqmini.sdk.ui.";
  
  private static Class findClass(String paramString)
  {
    return AppLoaderFactory.g().findClass("com.tencent.qqmini.sdk.ui." + paramString);
  }
  
  public static void start(Context paramContext, Intent paramIntent, MiniFragmentLauncher.FragmentType paramFragmentType)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, FRAGMENT_ACTIVITY);
    localIntent.putExtra("public_fragment_class", MiniFragmentLauncher.FragmentType.access$100(paramFragmentType));
    paramContext.startActivity(localIntent);
  }
  
  public static void startForResult(Activity paramActivity, Intent paramIntent, int paramInt, MiniFragmentLauncher.FragmentType paramFragmentType)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramActivity, FRAGMENT_ACTIVITY);
    localIntent.putExtra("public_fragment_class", MiniFragmentLauncher.FragmentType.access$100(paramFragmentType));
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void startTranslucent(Context paramContext, Intent paramIntent, MiniFragmentLauncher.FragmentType paramFragmentType)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, FRAGMENT_ACTIVITY_TRANSLUCENT);
    localIntent.putExtra("public_fragment_class", MiniFragmentLauncher.FragmentType.access$100(paramFragmentType));
    paramContext.startActivity(localIntent);
  }
  
  public static void startTranslucentForResult(Activity paramActivity, Intent paramIntent, int paramInt, MiniFragmentLauncher.FragmentType paramFragmentType)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramActivity, FRAGMENT_ACTIVITY_TRANSLUCENT);
    localIntent.putExtra("public_fragment_class", MiniFragmentLauncher.FragmentType.access$100(paramFragmentType));
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher
 * JD-Core Version:    0.7.0.1
 */