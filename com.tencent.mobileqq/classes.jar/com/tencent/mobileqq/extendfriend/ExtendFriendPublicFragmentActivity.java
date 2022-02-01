package com.tencent.mobileqq.extendfriend;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendNewFragment;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzonePluginProxyActivity;

public class ExtendFriendPublicFragmentActivity
  extends PublicFragmentActivity
{
  private static volatile long jdField_a_of_type_Long;
  private ClassLoader jdField_a_of_type_JavaLangClassLoader = null;
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return paramInt + "";
    case 1: 
      return "1";
    case 2: 
      return "2";
    case 3: 
      return "3";
    case 5: 
      return "6";
    case 6: 
      return "5";
    }
    return "7";
  }
  
  private static void a(int paramInt)
  {
    Object localObject2 = "";
    Object localObject1 = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
    if ((localObject1 != null) && (((SosoLbsInfo)localObject1).mLocation != null))
    {
      localObject2 = ((SosoLbsInfo)localObject1).mLocation;
      if (!TextUtils.isEmpty(((SosoLocation)localObject2).city))
      {
        localObject1 = ((SosoLocation)localObject2).city;
        localObject2 = String.format("%s;%s", new Object[] { Double.valueOf(((SosoLocation)localObject2).mLat02), Double.valueOf(((SosoLocation)localObject2).mLon02) });
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800AD99", "0X800AD99", paramInt, 0, "", "", (String)localObject1, (String)localObject2);
      return;
      localObject1 = "";
      break;
      localObject1 = "";
    }
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, 0, true);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, true);
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    QLog.d("ExtendFriendPublicFragmentActivity", 2, String.format("launchExtendFriendFragment context=%s source=%s freqCtrl=%s", new Object[] { paramContext, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
    long l = System.currentTimeMillis();
    if ((paramBoolean) && (l - jdField_a_of_type_Long < 1000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendPublicFragmentActivity", 2, "launchExtendFriendFragment launch too often.");
      }
      return;
    }
    jdField_a_of_type_Long = l;
    Intent localIntent = new Intent();
    localIntent.putExtra("extend_frient_from", paramInt);
    localIntent.putExtra("startTime", l);
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, ExtendFriendPublicFragmentActivity.class, ExtendFriendFragment.class);
    a(paramInt);
    ExpandReportUtils.a(a(paramInt));
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean, String paramString)
  {
    QLog.d("ExtendFriendPublicFragmentActivity", 2, String.format("launchExtendFriendNewFragment context=%s source=%s freqCtrl=%s", new Object[] { paramContext, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
    long l = System.currentTimeMillis();
    if ((paramBoolean) && (l - jdField_a_of_type_Long < 1000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendPublicFragmentActivity", 2, "launchExtendFriendNewFragment launch too often.");
      }
      return;
    }
    jdField_a_of_type_Long = l;
    paramContext = new Intent();
    paramContext.putExtra("extend_frient_from", paramInt);
    paramContext.putExtra("extend_frient_type_url", paramString);
    PublicFragmentActivity.Launcher.a(paramContext, ExtendFriendPublicFragmentActivity.class, ExtendFriendNewFragment.class);
    a(paramInt);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public ClassLoader getClassLoader()
  {
    ClassLoader localClassLoader3 = super.getClassLoader();
    ClassLoader localClassLoader2 = this.jdField_a_of_type_JavaLangClassLoader;
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
    }
    if (localClassLoader1 != null)
    {
      this.jdField_a_of_type_JavaLangClassLoader = localClassLoader1;
      return localClassLoader1;
    }
    return localClassLoader3;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity
 * JD-Core Version:    0.7.0.1
 */