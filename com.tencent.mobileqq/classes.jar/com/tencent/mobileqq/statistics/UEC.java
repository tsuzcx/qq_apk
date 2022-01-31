package com.tencent.mobileqq.statistics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.IFragmentAttachCallback;
import android.support.v4.app.Fragment.IFragmentLifecycleCallback;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

@TargetApi(14)
public final class UEC
  implements Application.ActivityLifecycleCallbacks, Fragment.IFragmentAttachCallback, Fragment.IFragmentLifecycleCallback
{
  public static UEC a;
  private int jdField_a_of_type_Int;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(8);
  private final boolean jdField_a_of_type_Boolean;
  
  public UEC()
  {
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_ComTencentMobileqqStatisticsUEC = this;
      this.jdField_a_of_type_Int = 0;
      return;
      bool = false;
    }
  }
  
  private String a(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return "null";
    }
    String str = b(paramFragment.getActivity());
    paramFragment = paramFragment.getClass().getSimpleName();
    return str + "_fg_" + paramFragment;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains("."))
      {
        str = paramString;
        if (!paramString.endsWith(".")) {
          str = paramString.substring(paramString.lastIndexOf('.') + 1, paramString.length());
        }
      }
    }
    return str;
  }
  
  private String a(String paramString, Activity paramActivity)
  {
    paramActivity = b(paramActivity);
    return paramActivity + "_fm_" + paramString;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if (paramString2 != null)
    {
      str1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      str1 = "preActNull";
    }
    paramString2 = a(str1);
    if ((paramString1 == null) || (paramString1.equals(""))) {
      return paramString2 + "+" + paramInt + ":" + paramLong;
    }
    if (!paramString1.contains(paramString2)) {
      return paramString1 + "|" + paramString2 + "+" + paramInt + ":" + paramLong;
    }
    String str2 = paramString1.substring(paramString1.indexOf(paramString2));
    int k = str2.indexOf("+");
    int m = str2.indexOf(":");
    int j = str2.indexOf("|");
    int i = j;
    if (j == -1) {
      i = str2.length();
    }
    String str1 = str2.substring(k + 1, m);
    str2 = str2.substring(m + 1, i);
    i = Integer.valueOf(str1).intValue();
    long l = Long.valueOf(str2).longValue();
    paramLong = (i * l / (i + paramInt) + 0.5D + (paramInt * paramLong / (i + paramInt) + 0.5D));
    return paramString1.replace(paramString2 + "+" + i + ":" + l, paramString2 + "+" + (i + paramInt) + ":" + paramLong);
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(8);
    ArrayList localArrayList = new ArrayList(((LinkedHashMap)localObject).size());
    localObject = ((LinkedHashMap)localObject).values().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add((UEC.UECItem)((Iterator)localObject).next());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      a(localArrayList);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putParcelableArrayListExtra("UECData", localArrayList);
    ((Intent)localObject).setClass(BaseApplicationImpl.sApplication, UECReceiver.class);
    BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject);
  }
  
  private void a(Object paramObject, String paramString1, boolean paramBoolean, String paramString2)
  {
    int i = paramObject.hashCode();
    if (paramBoolean)
    {
      a(paramString1, i, paramString2);
      return;
    }
    a(paramString1, null, 0L, paramString2);
    b(paramString1, i, paramString2);
  }
  
  private String b(Activity paramActivity)
  {
    Object localObject;
    if (paramActivity == null) {
      localObject = "null";
    }
    String str;
    do
    {
      return localObject;
      str = paramActivity.getClass().getSimpleName();
      if ((paramActivity instanceof PluginProxyActivity))
      {
        paramActivity = a(((PluginProxyActivity)paramActivity).getPluginActivity());
        return str + "_" + paramActivity;
      }
      localObject = str;
    } while (!QQBrowserActivity.class.isInstance(paramActivity));
    paramActivity = b(a(paramActivity));
    return str + "_" + paramActivity;
  }
  
  private String b(String paramString)
  {
    String str;
    if (StringUtil.a(paramString)) {
      str = "null";
    }
    int i;
    do
    {
      return str;
      i = paramString.indexOf("?");
      str = paramString;
    } while (i <= 0);
    return paramString.substring(0, i);
  }
  
  private String c(Activity paramActivity)
  {
    Object localObject2;
    if (paramActivity == null) {
      localObject2 = "null";
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject2 = paramActivity.getClass().getSimpleName();
      localObject1 = localObject2;
      if ((paramActivity instanceof FragmentActivity)) {
        localObject1 = "fa_" + (String)localObject2;
      }
      localObject2 = localObject1;
    } while (!(paramActivity instanceof PluginProxyActivity));
    paramActivity = a(((PluginProxyActivity)paramActivity).getPluginActivity());
    return (String)localObject1 + "_" + paramActivity;
  }
  
  private String c(String paramString)
  {
    String str;
    if (StringUtil.a(paramString)) {
      str = "null";
    }
    int i;
    do
    {
      return str;
      i = paramString.indexOf("//");
      str = paramString;
      if (i >= 0)
      {
        str = paramString;
        if (paramString.length() > i + 2) {
          str = paramString.substring(i + 2);
        }
      }
      i = str.indexOf(":");
      paramString = str;
      if (i > 0) {
        paramString = str.substring(0, i);
      }
      i = paramString.indexOf("/");
      str = paramString;
    } while (i <= 0);
    return paramString.substring(0, i);
  }
  
  public UEC.UECItem a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    UEC.UECItem localUECItem = (UEC.UECItem)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString1);
    if (localUECItem == null)
    {
      localUECItem = new UEC.UECItem();
      localUECItem.jdField_a_of_type_JavaLangString = paramString1;
      localUECItem.jdField_a_of_type_Int = 1;
      if ((paramString1.startsWith(QQBrowserActivity.class.getSimpleName())) && (localUECItem.d == null))
      {
        int i = paramString1.indexOf("_");
        if ((i >= 0) && (paramString1.length() > i)) {
          localUECItem.d = c(paramString1.substring(paramString1.indexOf("_") + 1));
        }
      }
      localUECItem.f = paramString3;
      localUECItem.e = "7.6.3";
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString1, localUECItem);
    }
    for (paramString1 = localUECItem;; paramString1 = localUECItem)
    {
      paramString1.jdField_b_of_type_JavaLangString = a(paramString1.jdField_b_of_type_JavaLangString, paramString2, 1, paramLong);
      return paramString1;
      localUECItem.jdField_a_of_type_Int += 1;
    }
  }
  
  protected String a(Activity paramActivity)
  {
    Intent localIntent = paramActivity.getIntent();
    String str = localIntent.getStringExtra("url");
    paramActivity = str;
    if (str == null)
    {
      str = localIntent.getStringExtra("key_params_qq");
      paramActivity = str;
      if (str == null) {
        paramActivity = "null";
      }
    }
    return paramActivity;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    UEC.UECItem localUECItem2 = (UEC.UECItem)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString1);
    UEC.UECItem localUECItem1 = localUECItem2;
    if (localUECItem2 == null) {
      localUECItem1 = a(paramString1, null, 0L, paramString2);
    }
    if ((paramInt == localUECItem1.c) && (localUECItem1.jdField_b_of_type_Long > 0L))
    {
      localUECItem1.jdField_a_of_type_Long = (SystemClock.uptimeMillis() - localUECItem1.jdField_b_of_type_Long + localUECItem1.jdField_a_of_type_Long);
      localUECItem1.jdField_b_of_type_Long = 0L;
    }
  }
  
  public void a(String paramString, Activity paramActivity, boolean paramBoolean)
  {
    if (paramString != null)
    {
      paramActivity = a(paramString, paramActivity);
      a(paramString, paramActivity, paramBoolean, paramActivity);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (!BaseApplicationImpl.sApplication.isRuntimeReady());
        localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (localObject != null)
        {
          UEC.IReporter localIReporter = (UEC.IReporter)((QQAppInterface)localObject).getManager(133);
          if (localIReporter != null) {
            localIReporter.a(paramArrayList);
          }
        }
      } while (localObject == null);
      localObject = (UEC.IReporter)((QQAppInterface)localObject).getManager(157);
    } while (localObject == null);
    ((UEC.IReporter)localObject).a(paramArrayList);
  }
  
  public void b(String paramString1, int paramInt, String paramString2)
  {
    UEC.UECItem localUECItem2 = (UEC.UECItem)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString1);
    UEC.UECItem localUECItem1 = localUECItem2;
    if (localUECItem2 == null) {
      localUECItem1 = a(paramString1, null, 0L, paramString2);
    }
    localUECItem1.c = paramInt;
    localUECItem1.jdField_b_of_type_Int += 1;
    localUECItem1.jdField_b_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    localObject = null;
    l1 = 0L;
    try
    {
      if (paramActivity.getIntent() == null) {
        break label111;
      }
      paramBundle = paramActivity.getIntent().getExtras();
      if (paramBundle == null) {
        break label111;
      }
      String str = paramBundle.getString("preAct");
      long l2 = paramBundle.getLong("preAct_time", 0L);
      paramBundle = str;
      if (l2 != 0L)
      {
        l1 = System.currentTimeMillis();
        l1 -= l2;
        paramBundle = str;
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        l1 = 0L;
        paramBundle = localObject;
        continue;
        paramBundle = null;
      }
    }
    if ((paramActivity instanceof FragmentActivity)) {
      ((FragmentActivity)paramActivity).setFragmentAttachListener(this);
    }
    a(b(paramActivity), paramBundle, l1, c(paramActivity));
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    String str1 = b(paramActivity);
    String str2 = c(paramActivity);
    a(str1, paramActivity.hashCode(), str2);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    String str1 = b(paramActivity);
    String str2 = c(paramActivity);
    b(str1, paramActivity.hashCode(), str2);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    this.jdField_a_of_type_Int += 1;
    if (Build.VERSION.SDK_INT >= 26) {
      FontSettingManager.a(paramActivity, true, false);
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    this.jdField_a_of_type_Int -= 1;
    if (this.jdField_a_of_type_Int == 0) {
      a();
    }
  }
  
  public void onFragmentAttached(Fragment paramFragment)
  {
    if (paramFragment != null) {
      paramFragment.setFragmentLifecycleCallback(this);
    }
  }
  
  public void onFragmentHiddenChanged(Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment != null)
    {
      String str = a(paramFragment);
      a(paramFragment, str, paramBoolean, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.UEC
 * JD-Core Version:    0.7.0.1
 */