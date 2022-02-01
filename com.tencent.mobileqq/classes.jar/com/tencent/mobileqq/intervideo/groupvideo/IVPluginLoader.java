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
  public static int[] a = { 3, 7, 9, 5, 10 };
  private static Context c;
  private static Map<String, IVPluginLoader> e = new HashMap();
  private static boolean m;
  private static boolean n;
  protected BroadcastReceiver b = new IVPluginLoader.2(this);
  private String d;
  private WeakReference<PluginLoadListener> f;
  private boolean g;
  private final String h = "GroupVideoManager.IVPluginLoader";
  private boolean i;
  private boolean j;
  private long k;
  private IHuayangDowanloadHelper l;
  
  private IVPluginLoader(Context paramContext, String paramString)
  {
    c = paramContext.getApplicationContext();
    this.d = paramString;
  }
  
  public static IVPluginLoader a(Context paramContext, String paramString)
  {
    IVPluginLoader localIVPluginLoader2 = (IVPluginLoader)e.get(paramString);
    IVPluginLoader localIVPluginLoader1 = localIVPluginLoader2;
    if (localIVPluginLoader2 == null)
    {
      localIVPluginLoader1 = new IVPluginLoader(paramContext, paramString);
      e.put(paramString, localIVPluginLoader1);
    }
    return localIVPluginLoader1;
  }
  
  private void a(int paramInt)
  {
    StoryReportor.a("group_video", "loadPuginState", paramInt, (int)(SystemClock.elapsedRealtime() - this.k), new String[] { "", "", "", "8.8.17" });
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
  
  public static boolean b()
  {
    if (n) {
      return m;
    }
    Object localObject = null;
    try
    {
      File localFile = new File(c.getExternalFilesDir(null).getPath(), "versionchecker.test");
      localObject = localFile;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if (localObject != null)
    {
      m = localObject.exists();
      n = true;
    }
    return m;
  }
  
  public void a()
  {
    IHuayangDowanloadHelper localIHuayangDowanloadHelper = this.l;
    if (localIHuayangDowanloadHelper != null) {
      localIHuayangDowanloadHelper.canceLauncher();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, PluginLoadListener paramPluginLoadListener)
  {
    if (!this.g)
    {
      localObject = new IntentFilter(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction(this.d));
      ((IntentFilter)localObject).addAction(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getBackNotifyAction(this.d));
      c.registerReceiver(this.b, (IntentFilter)localObject);
      this.g = true;
    }
    this.i = TextUtils.equals(paramString5, "slientDownload");
    this.j = TextUtils.equals(paramString5, "download");
    this.f = new WeakReference(paramPluginLoadListener);
    paramPluginLoadListener = IVPluginInfo.a();
    Object localObject = (IVPluginInfo)paramPluginLoadListener.get(this.d);
    if (!TextUtils.isEmpty(paramString3)) {
      try
      {
        ((IVPluginInfo)localObject).d = Long.parseLong(paramString3);
      }
      catch (NumberFormatException paramString3)
      {
        paramString3.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty(paramString6)) {
      ((IVPluginInfo)localObject).f = paramString6;
    }
    ((IVPluginInfo)localObject).l = paramString7;
    ((IVPluginInfo)localObject).m = paramInt;
    ((IVPluginInfo)localObject).n = paramString8;
    ((IVPluginInfo)localObject).o = paramString9;
    if (this.i)
    {
      Monitor.b("2856624");
    }
    else if (this.j)
    {
      Monitor.b("2856625");
      this.k = SystemClock.elapsedRealtime();
      StoryReportor.a("group_video", "startLoad", 0, 0, new String[] { "", "", "", "8.8.17" });
    }
    this.l = HuayangDowanloadHelperUtil.a(c, this.d, paramString1);
    ThreadManagerV2.executeOnSubThread(new IVPluginLoader.1(this, paramString2, paramString1, paramString4, paramString5, paramPluginLoadListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.IVPluginLoader
 * JD-Core Version:    0.7.0.1
 */