package com.tencent.mobileqq.hiboom;

import android.os.Handler.Callback;
import android.os.Message;
import com.Vas.ColorFont.FastColorFontHelper;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontSoLoader;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class HiBoomFont
  implements Handler.Callback
{
  public static final String e;
  public static final String f;
  public static final String g;
  public static final String h;
  public static FilenameFilter i = new HiBoomFont.1();
  private static ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, HiBoomFontDrawer>> j;
  private static HiBoomFont k;
  ETEngine a;
  ETEngine b;
  public AtomicBoolean c = new AtomicBoolean(false);
  public AtomicBoolean d = new AtomicBoolean(false);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".hiboom_font/");
    e = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append("font/");
    f = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append("config/");
    g = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append("tags/");
    h = localStringBuilder.toString();
    j = new ConcurrentHashMap();
  }
  
  public static HiBoomFont a()
  {
    if (k == null) {
      k = new HiBoomFont();
    }
    return k;
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(f);
    ((StringBuilder)localObject).append(paramInt);
    localObject = new File(((StringBuilder)localObject).toString());
    boolean bool3 = ((File)localObject).exists();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (((File)localObject).isDirectory())
      {
        localObject = ((File)localObject).list(i);
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (localObject.length > 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private HiBoomFontDrawer b(int paramInt1, int paramInt2, HiBoomFont.HiBoomFontDownloader paramHiBoomFontDownloader)
  {
    paramHiBoomFontDownloader = new HiBoomFontDrawer(paramInt1, paramHiBoomFontDownloader);
    ((ConcurrentHashMap)j.get(Integer.valueOf(paramInt2))).put(Integer.valueOf(paramInt1), paramHiBoomFontDownloader);
    return paramHiBoomFontDownloader;
  }
  
  public HiBoomFontDrawer a(int paramInt1, int paramInt2, HiBoomFont.HiBoomFontDownloader paramHiBoomFontDownloader)
  {
    try
    {
      if ((ConcurrentHashMap)j.get(Integer.valueOf(paramInt2)) == null) {
        j.put(Integer.valueOf(paramInt2), new ConcurrentHashMap());
      }
      HiBoomFontDrawer localHiBoomFontDrawer = (HiBoomFontDrawer)((ConcurrentHashMap)j.get(Integer.valueOf(paramInt2))).get(Integer.valueOf(paramInt1));
      if (localHiBoomFontDrawer == null)
      {
        paramHiBoomFontDownloader = b(paramInt1, paramInt2, paramHiBoomFontDownloader);
        return paramHiBoomFontDownloader;
      }
      return localHiBoomFontDrawer;
    }
    finally {}
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont", 2, "onEngineReady");
    }
    Iterator localIterator1 = j.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ConcurrentHashMap)((Map.Entry)localIterator1.next()).getValue()).entrySet().iterator();
      while (localIterator2.hasNext()) {
        ((HiBoomFontDrawer)((Map.Entry)localIterator2.next()).getValue()).a(false);
      }
    }
  }
  
  void c()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont", 2, "initHYEngine");
        }
        boolean bool1 = FontSoLoader.b();
        boolean bool4 = false;
        if ((!bool1) && (ETEngine.getInstanceForAnimation().isEngineInited.compareAndSet(false, true)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont", 2, "initHYEngine load so");
          }
          FontSoLoader.c();
        }
        if (FontSoLoader.b())
        {
          this.a = ETEngine.getInstance();
          this.b = ETEngine.getInstanceForAnimation();
          try
          {
            localObject1 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (localObject1 == null) {
              break label327;
            }
            m = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getChatTextSize((AppRuntime)localObject1);
            m = m * m * 240 * 18 * 2;
          }
          catch (Exception localException)
          {
            Object localObject1;
            boolean bool2;
            boolean bool3;
            QLog.e("HiBoomFont", 1, "initEngine error", localException);
          }
          bool2 = this.a.isEngineReady.get();
          bool1 = bool2;
          if (!bool2)
          {
            bool1 = this.a.initEngine(18, m);
            this.a.isEngineReady.set(bool1);
          }
          bool3 = this.b.isEngineReady.get();
          bool2 = bool3;
          if (!bool3)
          {
            bool2 = this.b.initEngine(10, 3145728);
            this.b.isEngineReady.set(bool2);
          }
          localObject1 = this.d;
          bool3 = bool4;
          if (bool1)
          {
            bool3 = bool4;
            if (bool2) {
              bool3 = true;
            }
          }
          ((AtomicBoolean)localObject1).set(bool3);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("initHYEngine ret = ");
            ((StringBuilder)localObject1).append(bool1);
            ((StringBuilder)localObject1).append(" ret2=");
            ((StringBuilder)localObject1).append(bool2);
            QLog.d("HiBoomFont", 2, ((StringBuilder)localObject1).toString());
          }
          this.c.set(true);
        }
        else
        {
          return;
        }
      }
      finally {}
      label327:
      int m = 0;
      if (m <= 1048576) {
        m = 1048576;
      }
    }
  }
  
  void d()
  {
    int m;
    try
    {
      boolean bool = FastColorFontHelper.a().b.get();
      if (bool) {
        return;
      }
      FastColorFontHelper.a().b.set(true);
      m = VasSoUtils.a(VasSoUtils.a(), "libFounderColorFont_818.so");
      if (!QLog.isColorLevel()) {
        break label139;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("tryInitFZEngine: loadSoRes=");
      ((StringBuilder)localObject1).append(m);
      QLog.d("HiBoomFont", 2, ((StringBuilder)localObject1).toString());
    }
    finally {}
    Object localObject1 = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localObject1 != null)
    {
      ((IVasQuickUpdateService)((AppRuntime)localObject1).getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "libColorFont_818", "HiBoomFont_initFZEngine");
      break label131;
      label121:
      FastColorFontHelper.a().c.set(true);
    }
    for (;;)
    {
      label131:
      return;
      label139:
      if (m == 0) {
        break label121;
      }
      if (m == 1) {
        break;
      }
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont", 2, "clearCache");
    }
    MobileQQ.sMobileQQ.peekAppRuntime();
    if (this.d.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont", 2, "clearCache clearHY Engine");
      }
      this.a.native_resetEngine();
      this.b.native_resetEngine();
    }
    j.clear();
    HiBoomTextView.h();
    FastColorFontHelper.a().c();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 257) && ((paramMessage.obj instanceof HiBoomTextView))) {
      ((HiBoomTextView)paramMessage.obj).invalidate();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFont
 * JD-Core Version:    0.7.0.1
 */