package com.tencent.mobileqq.intervideo.groupvideo;

import adtz;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.huayang.HuayangDowanloadHelper;
import com.tencent.mobileqq.intervideo.huayang.HuayangJsPlugin;
import com.tencent.mobileqq.intervideo.huayang.HuayangOpenHelper;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class IVPluginLoader
{
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap();
  public static int[] a;
  private long jdField_a_of_type_Long;
  public BroadcastReceiver a;
  private Context jdField_a_of_type_AndroidContentContext;
  private HuayangDowanloadHelper jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString = "GroupVideoManager.IVPluginLoader";
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 3, 7, 9, 5, 10 };
  }
  
  private IVPluginLoader(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new adtz(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static IVPluginLoader a(Context paramContext, String paramString)
  {
    IVPluginLoader localIVPluginLoader2 = (IVPluginLoader)jdField_a_of_type_JavaUtilMap.get(paramString);
    IVPluginLoader localIVPluginLoader1 = localIVPluginLoader2;
    if (localIVPluginLoader2 == null)
    {
      localIVPluginLoader1 = new IVPluginLoader(paramContext, paramString);
      jdField_a_of_type_JavaUtilMap.put(paramString, localIVPluginLoader1);
    }
    return localIVPluginLoader1;
  }
  
  private void a(int paramInt)
  {
    StoryReportor.a("group_video", "loadPuginState", paramInt, (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long), new String[] { "", "", "", "7.6.3" });
    switch (paramInt)
    {
    case 4: 
    case 8: 
    default: 
      return;
    case 2: 
      Monitor.b("2856626");
      return;
    case 3: 
      Monitor.b("2856627");
      return;
    case 5: 
      Monitor.b("2856629");
      return;
    case 6: 
      Monitor.b("2856630");
      return;
    case 7: 
      Monitor.b("2856631");
      return;
    }
    Monitor.b("2856647");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper.a();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, PluginLoadListener paramPluginLoadListener)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      IntentFilter localIntentFilter = new IntentFilter(HuayangJsPlugin.a(this.jdField_a_of_type_JavaLangString));
      localIntentFilter.addAction(HuayangJsPlugin.b(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_a_of_type_Boolean = true;
    }
    HuayangOpenHelper.a(this.jdField_a_of_type_AndroidContentContext, paramString2);
    this.jdField_b_of_type_Boolean = TextUtils.equals(paramString5, "slientDownload");
    this.c = TextUtils.equals(paramString5, "download");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPluginLoadListener);
    paramString2 = IVPluginInfo.a();
    paramPluginLoadListener = (IVPluginInfo)paramString2.get(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString3)) {}
    try
    {
      paramPluginLoadListener.jdField_a_of_type_Long = Long.parseLong(paramString3);
      if (!TextUtils.isEmpty(paramString6)) {
        paramPluginLoadListener.e = paramString6;
      }
      paramPluginLoadListener.h = paramString7;
      paramPluginLoadListener.c = paramInt;
      paramPluginLoadListener.i = paramString8;
      paramPluginLoadListener.j = paramString9;
      if (this.jdField_b_of_type_Boolean)
      {
        Monitor.b("2856624");
        this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper = HuayangDowanloadHelper.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, paramString1);
        this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper.a(paramString1, paramString4, null, paramString5, paramString2);
        return;
      }
    }
    catch (NumberFormatException paramString3)
    {
      for (;;)
      {
        paramString3.printStackTrace();
        continue;
        if (this.c)
        {
          Monitor.b("2856625");
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          StoryReportor.a("group_video", "startLoad", 0, 0, new String[] { "", "", "", "7.6.3" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.IVPluginLoader
 * JD-Core Version:    0.7.0.1
 */