package com.tencent.mobileqq.hiboom;

import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nonnull;

public class HiBoomFont
{
  private static HiBoomFont jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont;
  public static final String a;
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_a_of_type_Int = -1;
  public ETEngine a;
  public AtomicBoolean a;
  public AtomicBoolean b = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aK + ".hiboom_font/";
  }
  
  private HiBoomFont()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static HiBoomFont a()
  {
    if (jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont == null) {
      jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont = new HiBoomFont();
    }
    return jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont;
  }
  
  private HiBoomFontDrawer b(int paramInt1, int paramInt2, HiBoomFont.HiBoomFontDownloader paramHiBoomFontDownloader)
  {
    paramHiBoomFontDownloader = new HiBoomFontDrawer(paramInt1, paramHiBoomFontDownloader);
    ((ConcurrentHashMap)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2))).put(Integer.valueOf(paramInt1), paramHiBoomFontDownloader);
    return paramHiBoomFontDownloader;
  }
  
  public HiBoomFontDrawer a(int paramInt1, int paramInt2, @Nonnull HiBoomFont.HiBoomFontDownloader paramHiBoomFontDownloader)
  {
    try
    {
      if ((ConcurrentHashMap)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2)) == null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt2), new ConcurrentHashMap());
      }
      HiBoomFontDrawer localHiBoomFontDrawer2 = (HiBoomFontDrawer)((ConcurrentHashMap)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2))).get(Integer.valueOf(paramInt1));
      HiBoomFontDrawer localHiBoomFontDrawer1 = localHiBoomFontDrawer2;
      if (localHiBoomFontDrawer2 == null) {
        localHiBoomFontDrawer1 = b(paramInt1, paramInt2, paramHiBoomFontDownloader);
      }
      return localHiBoomFontDrawer1;
    }
    finally {}
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont", 2, "onHYEngineReady");
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
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.vip_individuation.name());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 3)
        {
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont", 2, "DPC value = " + localObject[2]);
          }
          if ("0".equals(localObject[2])) {
            break label100;
          }
        }
      }
    }
    label100:
    for (this.jdField_a_of_type_Int = 1; this.jdField_a_of_type_Int == 1; this.jdField_a_of_type_Int = 0) {
      return true;
    }
    return false;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +11 -> 16
    //   8: ldc 90
    //   10: iconst_2
    //   11: ldc 165
    //   13: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: invokestatic 169	com/etrump/mixlayout/FontSoLoader:b	()Z
    //   19: ifne +35 -> 54
    //   22: invokestatic 175	com/etrump/mixlayout/ETEngine:getInstanceForHiBoom	()Lcom/etrump/mixlayout/ETEngine;
    //   25: getfield 178	com/etrump/mixlayout/ETEngine:isEngineInited	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   28: iconst_0
    //   29: iconst_1
    //   30: invokevirtual 182	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   33: ifeq +21 -> 54
    //   36: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +11 -> 50
    //   42: ldc 90
    //   44: iconst_2
    //   45: ldc 184
    //   47: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: invokestatic 187	com/etrump/mixlayout/FontSoLoader:c	()Z
    //   53: pop
    //   54: invokestatic 169	com/etrump/mixlayout/FontSoLoader:b	()Z
    //   57: ifeq +69 -> 126
    //   60: aload_0
    //   61: invokestatic 175	com/etrump/mixlayout/ETEngine:getInstanceForHiBoom	()Lcom/etrump/mixlayout/ETEngine;
    //   64: putfield 189	com/tencent/mobileqq/hiboom/HiBoomFont:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   67: aload_0
    //   68: getfield 189	com/tencent/mobileqq/hiboom/HiBoomFont:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   71: bipush 10
    //   73: ldc 190
    //   75: invokevirtual 194	com/etrump/mixlayout/ETEngine:initEngine	(II)Z
    //   78: istore_1
    //   79: aload_0
    //   80: getfield 52	com/tencent/mobileqq/hiboom/HiBoomFont:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   83: iload_1
    //   84: invokevirtual 197	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   87: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +28 -> 118
    //   93: ldc 90
    //   95: iconst_2
    //   96: new 16	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   103: ldc 199
    //   105: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: iload_1
    //   109: invokevirtual 202	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   112: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload_0
    //   119: getfield 50	com/tencent/mobileqq/hiboom/HiBoomFont:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   122: iconst_1
    //   123: invokevirtual 197	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   126: aload_0
    //   127: monitorexit
    //   128: return
    //   129: astore_2
    //   130: ldc 90
    //   132: iconst_1
    //   133: ldc 204
    //   135: aload_2
    //   136: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   139: goto -21 -> 118
    //   142: astore_2
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_2
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	HiBoomFont
    //   78	31	1	bool	boolean
    //   129	7	2	localException	java.lang.Exception
    //   142	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   67	118	129	java/lang/Exception
    //   2	16	142	finally
    //   16	50	142	finally
    //   50	54	142	finally
    //   54	67	142	finally
    //   67	118	142	finally
    //   118	126	142	finally
    //   130	139	142	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFont
 * JD-Core Version:    0.7.0.1
 */