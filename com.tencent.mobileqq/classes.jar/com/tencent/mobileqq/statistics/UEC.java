package com.tencent.mobileqq.statistics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.IScreenShotShareHandler;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QBaseFragment.IFragmentAttachCallback;
import com.tencent.mobileqq.app.QBaseFragment.IFragmentLifecycleCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vastrash.uec.UECPageStayTimeReport;
import com.tencent.qqperf.MagnifierSDK;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

@TargetApi(14)
public final class UEC
  implements Application.ActivityLifecycleCallbacks, QBaseFragment.IFragmentAttachCallback, QBaseFragment.IFragmentLifecycleCallback
{
  public static UEC a;
  private int jdField_a_of_type_Int;
  private LinkedHashMap<String, UEC.UECItem> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(8);
  private List<IPageLifecycleCallback> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final boolean jdField_a_of_type_Boolean;
  
  private UEC()
  {
    int i = BaseApplicationImpl.sProcessId;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    jdField_a_of_type_ComTencentMobileqqStatisticsUEC = this;
    this.jdField_a_of_type_Int = 0;
    a();
  }
  
  public static UEC a()
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsUEC == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqStatisticsUEC == null) {
          jdField_a_of_type_ComTencentMobileqqStatisticsUEC = new UEC();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqStatisticsUEC;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramActivity);
    localStringBuilder.append("_fm_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    Object localObject1;
    if (paramString2 != null)
    {
      localObject1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      localObject1 = "preActNull";
    }
    paramString2 = a((String)localObject1);
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      if (!paramString1.contains(paramString2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append("+");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append(paramLong);
        return ((StringBuilder)localObject1).toString();
      }
      Object localObject2 = paramString1.substring(paramString1.indexOf(paramString2));
      int k = ((String)localObject2).indexOf("+");
      int m = ((String)localObject2).indexOf(":");
      int j = ((String)localObject2).indexOf("|");
      int i = j;
      if (j == -1) {
        i = ((String)localObject2).length();
      }
      localObject1 = ((String)localObject2).substring(k + 1, m);
      localObject2 = ((String)localObject2).substring(m + 1, i);
      i = Integer.valueOf((String)localObject1).intValue();
      long l1 = Long.valueOf((String)localObject2).longValue();
      long l2 = i;
      j = i + paramInt;
      long l3 = j;
      double d1 = l2 * l1 / l3;
      Double.isNaN(d1);
      double d2 = paramLong * paramInt / l3;
      Double.isNaN(d2);
      paramLong = (d1 + 0.5D + (d2 + 0.5D));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append("+");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(l1);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append("+");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(paramLong);
      return paramString1.replace((CharSequence)localObject1, ((StringBuilder)localObject2).toString());
    }
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append("+");
    paramString1.append(paramInt);
    paramString1.append(":");
    paramString1.append(paramLong);
    return paramString1.toString();
  }
  
  private void a()
  {
    a(new UECPageStayTimeReport());
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
    if (MainFragment.class.isInstance(paramObject)) {
      return false;
    }
    if (BaseFragment.class.isInstance(paramObject))
    {
      paramObject = (QBaseFragment)paramObject;
      if ((SplashActivity.class.isInstance(paramObject.getActivity())) && (!ChatFragment.class.isInstance(paramObject))) {
        return false;
      }
    }
    return true;
  }
  
  private String b(Activity paramActivity)
  {
    if (paramActivity == null) {
      return "null";
    }
    String str = paramActivity.getClass().getSimpleName();
    if ((paramActivity instanceof PluginProxyActivity))
    {
      paramActivity = a(((PluginProxyActivity)paramActivity).getPluginActivity());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramActivity);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = str;
    if (QQBrowserActivity.class.isInstance(paramActivity))
    {
      paramActivity = b(a(paramActivity));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramActivity);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private String b(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return "null";
    }
    int i = paramString.indexOf("?");
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  private void b()
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
  
  private String c(Activity paramActivity)
  {
    if (paramActivity == null) {
      return "null";
    }
    Object localObject2 = paramActivity.getClass().getSimpleName();
    Object localObject1 = localObject2;
    if ((paramActivity instanceof QBaseActivity))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fa_");
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if ((paramActivity instanceof PluginProxyActivity))
    {
      paramActivity = a(((PluginProxyActivity)paramActivity).getPluginActivity());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramActivity);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
  
  private String c(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return "null";
    }
    int j = paramString.indexOf("//");
    String str = paramString;
    if (j >= 0)
    {
      i = paramString.length();
      j += 2;
      str = paramString;
      if (i > j) {
        str = paramString.substring(j);
      }
    }
    int i = str.indexOf(":");
    paramString = str;
    if (i > 0) {
      paramString = str.substring(0, i);
    }
    i = paramString.indexOf("/");
    str = paramString;
    if (i > 0) {
      str = paramString.substring(0, i);
    }
    return str;
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
      paramObject.e = "8.7.0";
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString1, paramObject);
      paramString1 = paramObject;
    }
    else
    {
      paramObject.jdField_a_of_type_Int += 1;
      paramString1 = paramObject;
    }
    paramString1.jdField_b_of_type_JavaLangString = a(paramString1.jdField_b_of_type_JavaLangString, paramString2, 1, paramLong);
    return paramString1;
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
  
  public void a(IPageLifecycleCallback paramIPageLifecycleCallback)
  {
    if (paramIPageLifecycleCallback == null) {
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramIPageLifecycleCallback)) {
      this.jdField_a_of_type_JavaUtilList.add(paramIPageLifecycleCallback);
    }
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
      long l1 = SystemClock.uptimeMillis();
      long l2 = localUECItem1.jdField_b_of_type_Long;
      localUECItem1.jdField_a_of_type_Long += l1 - l2;
      localUECItem1.jdField_b_of_type_Long = 0L;
      if (a(paramObject)) {
        MagnifierSDK.a().b(paramString2);
      }
    }
  }
  
  public void a(String paramString, Activity paramActivity, boolean paramBoolean, Object paramObject)
  {
    if (paramString != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((IPageLifecycleCallback)localIterator.next()).a(paramString, paramActivity, paramBoolean, paramObject);
      }
      paramActivity = a(paramString, paramActivity);
      a(paramString, paramActivity, paramBoolean, paramActivity, paramObject);
    }
  }
  
  public void a(ArrayList<UEC.UECItem> paramArrayList)
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {
      return;
    }
    if (!BaseApplicationImpl.sApplication.isRuntimeReady()) {
      return;
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null)
    {
      UEC.IReporter localIReporter = (UEC.IReporter)((QQAppInterface)localObject).getManager(QQManagerFactory.ACT_DAU_REPORT_MANAGER);
      if (localIReporter != null) {
        localIReporter.a(paramArrayList);
      }
    }
    if (localObject != null)
    {
      localObject = (UEC.IReporter)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_ACT_DAU_REPORT_MANAGER);
      if (localObject != null) {
        ((UEC.IReporter)localObject).a(paramArrayList);
      }
    }
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
      MagnifierSDK.a().a(paramString2);
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IPageLifecycleCallback)localIterator.next()).onActivityCreated(paramActivity, paramBundle);
    }
    localIterator = null;
    long l2 = 0L;
    long l1 = l2;
    paramBundle = localIterator;
    try
    {
      if (paramActivity.getIntent() != null)
      {
        Bundle localBundle = paramActivity.getIntent().getExtras();
        l1 = l2;
        paramBundle = localIterator;
        if (localBundle != null)
        {
          paramBundle = localBundle.getString("preAct");
          long l3 = localBundle.getLong("preAct_time", 0L);
          l1 = l2;
          if (l3 != 0L)
          {
            l1 = System.currentTimeMillis();
            l1 -= l3;
          }
        }
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
      paramBundle = localIterator;
      l1 = l2;
    }
    if ((paramActivity instanceof BaseActivity)) {
      ((BaseActivity)paramActivity).setFragmentAttachListener(this);
    }
    a(b(paramActivity), paramBundle, l1, c(paramActivity), paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IPageLifecycleCallback)((Iterator)localObject).next()).onActivityPaused(paramActivity);
    }
    localObject = b(paramActivity);
    String str = c(paramActivity);
    a((String)localObject, paramActivity.hashCode(), str, paramActivity);
    if (Build.VERSION.SDK_INT >= 23) {
      IScreenShotShareHandler.b(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IPageLifecycleCallback)((Iterator)localObject).next()).onActivityResumed(paramActivity);
    }
    localObject = b(paramActivity);
    String str = c(paramActivity);
    b((String)localObject, paramActivity.hashCode(), str, paramActivity);
    if (Build.VERSION.SDK_INT >= 23) {
      IScreenShotShareHandler.a(paramActivity);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IPageLifecycleCallback)localIterator.next()).onActivityStarted(paramActivity);
    }
    this.jdField_a_of_type_Int += 1;
    LocaleManager.b(paramActivity);
    if (Build.VERSION.SDK_INT >= 26) {
      FontSettingManager.resetFontIfNeeded(paramActivity, true, false);
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IPageLifecycleCallback)localIterator.next()).onActivityStopped(paramActivity);
    }
    this.jdField_a_of_type_Int -= 1;
    if (this.jdField_a_of_type_Int == 0) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.UEC
 * JD-Core Version:    0.7.0.1
 */