package com.tencent.mobileqq.intervideo.groupvideo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.huayang.HuayangDowanloadHelperUtil;
import com.tencent.mobileqq.intervideo.huayang.IHuayangDowanloadHelper;
import com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class IVPluginLoader
{
  private static Context jdField_a_of_type_AndroidContentContext;
  private static Map<String, IVPluginLoader> jdField_a_of_type_JavaUtilMap = new HashMap();
  public static int[] a;
  private static boolean d;
  private static boolean e;
  private long jdField_a_of_type_Long;
  protected BroadcastReceiver a;
  private IHuayangDowanloadHelper jdField_a_of_type_ComTencentMobileqqIntervideoHuayangIHuayangDowanloadHelper;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<PluginLoadListener> jdField_a_of_type_JavaLangRefWeakReference;
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
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new IVPluginLoader.2(this);
    jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
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
    StoryReportor.a("group_video", "loadPuginState", paramInt, (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long), new String[] { "", "", "", "8.7.0" });
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6)
          {
            if (paramInt != 7)
            {
              if (paramInt != 9) {
                return;
              }
              Monitor.b("2856647");
              return;
            }
            Monitor.b("2856631");
            return;
          }
          Monitor.b("2856630");
          return;
        }
        Monitor.b("2856629");
        return;
      }
      Monitor.b("2856627");
      return;
    }
    Monitor.b("2856626");
  }
  
  public static boolean a()
  {
    if (e) {
      return d;
    }
    Object localObject = null;
    try
    {
      File localFile = new File(jdField_a_of_type_AndroidContentContext.getExternalFilesDir(null).getPath(), "versionchecker.test");
      localObject = localFile;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if (localObject != null)
    {
      d = localObject.exists();
      e = true;
    }
    return d;
  }
  
  public void a()
  {
    IHuayangDowanloadHelper localIHuayangDowanloadHelper = this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangIHuayangDowanloadHelper;
    if (localIHuayangDowanloadHelper != null) {
      localIHuayangDowanloadHelper.canceLauncher();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, PluginLoadListener paramPluginLoadListener)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = new IntentFilter(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction(this.jdField_a_of_type_JavaLangString));
      ((IntentFilter)localObject).addAction(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getBackNotifyAction(this.jdField_a_of_type_JavaLangString));
      jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_b_of_type_Boolean = TextUtils.equals(paramString5, "slientDownload");
    this.c = TextUtils.equals(paramString5, "download");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPluginLoadListener);
    paramPluginLoadListener = IVPluginInfo.a();
    Object localObject = (IVPluginInfo)paramPluginLoadListener.get(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString3)) {
      try
      {
        ((IVPluginInfo)localObject).jdField_a_of_type_Long = Long.parseLong(paramString3);
      }
      catch (NumberFormatException paramString3)
      {
        paramString3.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty(paramString6)) {
      ((IVPluginInfo)localObject).e = paramString6;
    }
    ((IVPluginInfo)localObject).h = paramString7;
    ((IVPluginInfo)localObject).c = paramInt;
    ((IVPluginInfo)localObject).i = paramString8;
    ((IVPluginInfo)localObject).j = paramString9;
    if (this.jdField_b_of_type_Boolean)
    {
      Monitor.b("2856624");
    }
    else if (this.c)
    {
      Monitor.b("2856625");
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      StoryReportor.a("group_video", "startLoad", 0, 0, new String[] { "", "", "", "8.7.0" });
    }
    this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangIHuayangDowanloadHelper = HuayangDowanloadHelperUtil.a(jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, paramString1);
    ThreadManagerV2.executeOnSubThread(new IVPluginLoader.1(this, paramString2, paramString1, paramString4, paramString5, paramPluginLoadListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.IVPluginLoader
 * JD-Core Version:    0.7.0.1
 */