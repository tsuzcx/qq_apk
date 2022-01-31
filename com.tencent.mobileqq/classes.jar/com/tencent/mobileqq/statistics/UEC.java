package com.tencent.mobileqq.statistics;

import alsf;
import alvw;
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
import azrw;
import bdnn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import zhv;

@TargetApi(14)
public final class UEC
  implements Application.ActivityLifecycleCallbacks, Fragment.IFragmentAttachCallback, Fragment.IFragmentLifecycleCallback
{
  public static UEC a;
  private int jdField_a_of_type_Int;
  private LinkedHashMap<String, UEC.UECItem> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(8);
  private final List<Application.ActivityLifecycleCallbacks> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final boolean jdField_a_of_type_Boolean;
  
  private UEC()
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
  
  public static UEC a()
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsUEC == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStatisticsUEC == null) {
        jdField_a_of_type_ComTencentMobileqqStatisticsUEC = new UEC();
      }
      return jdField_a_of_type_ComTencentMobileqqStatisticsUEC;
    }
    finally {}
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
  
  private void a(Object paramObject1, String paramString1, boolean paramBoolean, String paramString2, Object paramObject2)
  {
    int i = paramObject1.hashCode();
    if (paramBoolean)
    {
      a(paramString1, i, paramString2, paramObject2);
      return;
    }
    a(paramString1, null, 0L, paramString2, paramObject2);
    b(paramString1, i, paramString2, paramObject2);
  }
  
  public static boolean a(Object paramObject)
  {
    if ((FragmentActivity.class.isInstance(paramObject)) || (MainFragment.class.isInstance(paramObject))) {}
    do
    {
      return false;
      if (!Fragment.class.isInstance(paramObject)) {
        break;
      }
      paramObject = (Fragment)paramObject;
    } while ((SplashActivity.class.isInstance(paramObject.getActivity())) && (!ChatFragment.class.isInstance(paramObject)));
    return true;
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
    if (bdnn.a(paramString)) {
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
    if (bdnn.a(paramString)) {
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
  
  public UEC.UECItem a(String paramString1, String paramString2, long paramLong, String paramString3, Object paramObject)
  {
    paramObject = (UEC.UECItem)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString1);
    if (paramObject == null)
    {
      paramObject = new UEC.UECItem();
      paramObject.jdField_a_of_type_JavaLangString = paramString1;
      paramObject.jdField_a_of_type_Int = 1;
      if ((paramString1.startsWith(QQBrowserActivity.class.getSimpleName())) && (paramObject.d == null))
      {
        int i = paramString1.indexOf("_");
        if ((i >= 0) && (paramString1.length() > i)) {
          paramObject.d = c(paramString1.substring(paramString1.indexOf("_") + 1));
        }
      }
      paramObject.f = paramString3;
      paramObject.e = "8.3.5";
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString1, paramObject);
    }
    for (paramString1 = paramObject;; paramString1 = paramObject)
    {
      paramString1.jdField_b_of_type_JavaLangString = a(paramString1.jdField_b_of_type_JavaLangString, paramString2, 1, paramLong);
      return paramString1;
      paramObject.jdField_a_of_type_Int += 1;
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
  
  public void a(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    if (paramActivityLifecycleCallbacks == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(paramActivityLifecycleCallbacks)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramActivityLifecycleCallbacks);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Object paramObject)
  {
    UEC.UECItem localUECItem2 = (UEC.UECItem)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString1);
    UEC.UECItem localUECItem1 = localUECItem2;
    if (localUECItem2 == null) {
      localUECItem1 = a(paramString1, null, 0L, paramString2, paramObject);
    }
    if ((paramInt == localUECItem1.c) && (localUECItem1.jdField_b_of_type_Long > 0L))
    {
      localUECItem1.jdField_a_of_type_Long = (SystemClock.uptimeMillis() - localUECItem1.jdField_b_of_type_Long + localUECItem1.jdField_a_of_type_Long);
      localUECItem1.jdField_b_of_type_Long = 0L;
      if (a(paramObject)) {
        MagnifierSDK.b(paramString2);
      }
    }
  }
  
  public void a(String paramString, Activity paramActivity, boolean paramBoolean, Object paramObject)
  {
    if (paramString != null)
    {
      paramActivity = a(paramString, paramActivity);
      a(paramString, paramActivity, paramBoolean, paramActivity, paramObject);
    }
  }
  
  public void a(ArrayList<UEC.UECItem> paramArrayList)
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
          azrw localazrw = (azrw)((QQAppInterface)localObject).getManager(134);
          if (localazrw != null) {
            localazrw.a(paramArrayList);
          }
        }
      } while (localObject == null);
      localObject = (azrw)((QQAppInterface)localObject).getManager(158);
    } while (localObject == null);
    ((azrw)localObject).a(paramArrayList);
  }
  
  public void b(String paramString1, int paramInt, String paramString2, Object paramObject)
  {
    UEC.UECItem localUECItem2 = (UEC.UECItem)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString1);
    UEC.UECItem localUECItem1 = localUECItem2;
    if (localUECItem2 == null) {
      localUECItem1 = a(paramString1, null, 0L, paramString2, paramObject);
    }
    localUECItem1.c = paramInt;
    localUECItem1.jdField_b_of_type_Int += 1;
    localUECItem1.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    if (a(paramObject)) {
      MagnifierSDK.a(paramString2);
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Application.ActivityLifecycleCallbacks)((Iterator)localObject).next()).onActivityCreated(paramActivity, paramBundle);
    }
    try
    {
      if (paramActivity.getIntent() == null) {
        break label148;
      }
      localObject = paramActivity.getIntent().getExtras();
      if (localObject == null) {
        break label148;
      }
      paramBundle = ((Bundle)localObject).getString("preAct");
      l1 = ((Bundle)localObject).getLong("preAct_time", 0L);
      if (l1 == 0L) {
        break label143;
      }
      long l2 = System.currentTimeMillis();
      l1 = l2 - l1;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        long l1 = 0L;
        paramBundle = null;
        continue;
        l1 = 0L;
        continue;
        paramBundle = null;
        l1 = 0L;
      }
    }
    if ((paramActivity instanceof FragmentActivity)) {
      ((FragmentActivity)paramActivity).setFragmentAttachListener(this);
    }
    a(b(paramActivity), paramBundle, l1, c(paramActivity), paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((Application.ActivityLifecycleCallbacks)localIterator.next()).onActivityDestroyed(paramActivity);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Application.ActivityLifecycleCallbacks)((Iterator)localObject).next()).onActivityPaused(paramActivity);
    }
    localObject = b(paramActivity);
    String str = c(paramActivity);
    a((String)localObject, paramActivity.hashCode(), str, paramActivity);
    if (Build.VERSION.SDK_INT >= 23) {
      zhv.b(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Application.ActivityLifecycleCallbacks)((Iterator)localObject).next()).onActivityResumed(paramActivity);
    }
    localObject = b(paramActivity);
    String str = c(paramActivity);
    b((String)localObject, paramActivity.hashCode(), str, paramActivity);
    if (Build.VERSION.SDK_INT >= 23) {
      zhv.a(paramActivity);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((Application.ActivityLifecycleCallbacks)localIterator.next()).onActivityStarted(paramActivity);
    }
    this.jdField_a_of_type_Int += 1;
    alvw.b(paramActivity);
    if (Build.VERSION.SDK_INT >= 26) {
      alsf.a(paramActivity, true, false);
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((Application.ActivityLifecycleCallbacks)localIterator.next()).onActivityStopped(paramActivity);
    }
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
      a(paramFragment, str, paramBoolean, str, paramFragment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.UEC
 * JD-Core Version:    0.7.0.1
 */