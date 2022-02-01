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
  private static HiBoomFont jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont;
  public static FilenameFilter a;
  public static final String a;
  private static ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, HiBoomFontDrawer>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public static final String b;
  public static final String c;
  public static final String d;
  ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine;
  public AtomicBoolean a;
  ETEngine b;
  public AtomicBoolean b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".hiboom_font/");
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("font/");
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("config/");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("tags/");
    d = localStringBuilder.toString();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaIoFilenameFilter = new HiBoomFont.1();
  }
  
  private HiBoomFont()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static HiBoomFont a()
  {
    if (jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont == null) {
      jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont = new HiBoomFont();
    }
    return jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont;
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(jdField_b_of_type_JavaLangString);
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
        localObject = ((File)localObject).list(jdField_a_of_type_JavaIoFilenameFilter);
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
    ((ConcurrentHashMap)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2))).put(Integer.valueOf(paramInt1), paramHiBoomFontDownloader);
    return paramHiBoomFontDownloader;
  }
  
  public HiBoomFontDrawer a(int paramInt1, int paramInt2, HiBoomFont.HiBoomFontDownloader paramHiBoomFontDownloader)
  {
    try
    {
      if ((ConcurrentHashMap)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2)) == null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt2), new ConcurrentHashMap());
      }
      HiBoomFontDrawer localHiBoomFontDrawer = (HiBoomFontDrawer)((ConcurrentHashMap)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2))).get(Integer.valueOf(paramInt1));
      if (localHiBoomFontDrawer == null)
      {
        paramHiBoomFontDownloader = b(paramInt1, paramInt2, paramHiBoomFontDownloader);
        return paramHiBoomFontDownloader;
      }
      return localHiBoomFontDrawer;
    }
    finally {}
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont", 2, "onEngineReady");
    }
    Iterator localIterator1 = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ConcurrentHashMap)((Map.Entry)localIterator1.next()).getValue()).entrySet().iterator();
      while (localIterator2.hasNext()) {
        ((HiBoomFontDrawer)((Map.Entry)localIterator2.next()).getValue()).a(false);
      }
    }
  }
  
  void b()
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
          this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstance();
          this.jdField_b_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstanceForAnimation();
          try
          {
            localObject1 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (localObject1 == null) {
              break label327;
            }
            i = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getChatTextSize((AppRuntime)localObject1);
            i = i * i * 240 * 18 * 2;
          }
          catch (Exception localException)
          {
            Object localObject1;
            boolean bool2;
            boolean bool3;
            QLog.e("HiBoomFont", 1, "initEngine error", localException);
          }
          bool2 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.get();
          bool1 = bool2;
          if (!bool2)
          {
            bool1 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.initEngine(18, i);
            this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.set(bool1);
          }
          bool3 = this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.get();
          bool2 = bool3;
          if (!bool3)
          {
            bool2 = this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.initEngine(10, 3145728);
            this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.set(bool2);
          }
          localObject1 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
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
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
        else
        {
          return;
        }
      }
      finally {}
      label327:
      int i = 0;
      if (i <= 1048576) {
        i = 1048576;
      }
    }
  }
  
  void c()
  {
    int i;
    try
    {
      boolean bool = FastColorFontHelper.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      if (bool) {
        return;
      }
      FastColorFontHelper.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      i = VasSoUtils.a(VasSoUtils.a(), "libFounderColorFont_818.so");
      if (!QLog.isColorLevel()) {
        break label139;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("tryInitFZEngine: loadSoRes=");
      ((StringBuilder)localObject1).append(i);
      QLog.d("HiBoomFont", 2, ((StringBuilder)localObject1).toString());
    }
    finally {}
    Object localObject1 = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localObject1 != null)
    {
      ((IVasQuickUpdateService)((AppRuntime)localObject1).getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "libColorFont_818", "HiBoomFont_initFZEngine");
      break label131;
      label121:
      FastColorFontHelper.a().jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    for (;;)
    {
      label131:
      return;
      label139:
      if (i == 0) {
        break label121;
      }
      if (i == 1) {
        break;
      }
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont", 2, "clearCache");
    }
    MobileQQ.sMobileQQ.peekAppRuntime();
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont", 2, "clearCache clearHY Engine");
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_resetEngine();
      this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.native_resetEngine();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    HiBoomTextView.e();
    FastColorFontHelper.a().a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 257) && ((paramMessage.obj instanceof HiBoomTextView))) {
      ((HiBoomTextView)paramMessage.obj).invalidate();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFont
 * JD-Core Version:    0.7.0.1
 */