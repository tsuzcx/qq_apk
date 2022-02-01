package com.tencent.xweb.xwalk.updater;

import android.os.Build.VERSION;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWebCoreInfo;

public class d
{
  static a.c a(a.f paramf, String paramString)
  {
    if (paramf.i != null)
    {
      a.c[] arrayOfc = paramf.i;
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        paramf = arrayOfc[i];
        if (paramf.a == XWalkEnvironment.getInstalledNewstVersion(paramString))
        {
          paramString = new StringBuilder();
          paramString.append("got matched patch to upgrade ");
          paramString.append(paramf.a);
          XWalkInitializer.addXWalkInitializeLog(paramString.toString());
          return paramf;
        }
        i += 1;
      }
    }
    XWalkInitializer.addXWalkInitializeLog("no matched patch");
    return null;
  }
  
  static a.f a(a.b paramb)
  {
    if ((paramb != null) && (paramb.d != null))
    {
      if (paramb.d.length == 0) {
        return null;
      }
      int i = Build.VERSION.SDK_INT;
      paramb = paramb.d;
      int j = paramb.length;
      i = 0;
      while (i < j)
      {
        StringBuilder localStringBuilder = paramb[i];
        if (localStringBuilder == null)
        {
          XWalkInitializer.addXWalkInitializeLog("no matched version  version == null");
        }
        else
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("try match version = ");
          ((StringBuilder)localObject).append(localStringBuilder.a);
          ((StringBuilder)localObject).append(" version runtime abi is ");
          ((StringBuilder)localObject).append(localStringBuilder.c.C);
          Log.i("VersionMatcher", ((StringBuilder)localObject).toString());
          if (localStringBuilder.a < 49)
          {
            Log.i("VersionMatcher", " apk is not support, below 49");
          }
          else
          {
            int k = XWalkEnvironment.getInstalledNewstVersion(localStringBuilder.c.C);
            if (localStringBuilder.a <= k)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(" apk is too old, now installed version ");
              localStringBuilder.append(k);
              Log.i("VersionMatcher", localStringBuilder.toString());
            }
            else if (!localStringBuilder.c.b())
            {
              Log.i("VersionMatcher", " apk filter out ");
            }
            else
            {
              localObject = localStringBuilder.c.C;
              XWalkUpdater.getLastTryInstallVer((String)localObject);
              if (!"arm64-v8a".equalsIgnoreCase((String)localObject)) {
                "armeabi-v7a".equalsIgnoreCase((String)localObject);
              }
              if ((!com.tencent.xweb.internal.a.c.e()) || (localStringBuilder.t)) {
                break label313;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(" version.supportPredown is false, apkver = ");
              ((StringBuilder)localObject).append(localStringBuilder.a);
              Log.i("VersionMatcher", ((StringBuilder)localObject).toString());
            }
          }
        }
        i += 1;
        continue;
        label313:
        return localStringBuilder;
      }
      XWalkInitializer.addXWalkInitializeLog("no matched version");
    }
    return null;
  }
  
  public static c a(a.b paramb, String paramString)
  {
    c localc = new c();
    com.tencent.xweb.internal.a.c.b(paramString);
    a.f localf = a(paramb);
    com.tencent.xweb.internal.a.c.b(null);
    if ((localf != null) && (localf.a > XWebCoreInfo.getBackupCoreInfo(paramString).ver))
    {
      XWalkInitializer.addXWalkInitializeLog("got matched version");
      localc.e = paramb.c;
      localc.d = localf.k;
      localc.z = localf.o;
      localc.A = localf.p;
      localc.B = localf.q;
      localc.l = localf.a;
      localc.n = localf.r.a;
      localc.q = localf.l;
      localc.r = localf.m;
      localc.s = localf.s;
      paramb = a(localf, paramString);
      localc.j = localf.d;
      localc.t = localf.c.C;
      localc.u = localf.b;
      localc.v = localf.e;
      localc.w = localf.f;
      if (paramb != null)
      {
        localc.f = true;
        localc.g = paramb.a;
        localc.h = paramb.b;
        localc.m = paramb.c;
        localc.q = paramb.d;
        localc.r = paramb.e;
      }
      else
      {
        localc.f = false;
        localc.h = localf.d;
      }
      localc.k = Scheduler.a(localf, "XWebCore");
      return localc;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.d
 * JD-Core Version:    0.7.0.1
 */