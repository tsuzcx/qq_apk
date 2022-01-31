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
    jdField_a_of_type_JavaLangString = AppConstants.aJ + ".hiboom_font/";
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
            break label134;
          }
        }
      }
    }
    label134:
    for (this.jdField_a_of_type_Int = 1;; this.jdField_a_of_type_Int = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont", 2, "getHiBoomAbility isDebugVersion = false mHiBoomAbility = " + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Int != 1) {
        break;
      }
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
    //   2: invokestatic 172	com/etrump/mixlayout/FontSoLoader:b	()Z
    //   5: ifne +24 -> 29
    //   8: invokestatic 178	com/etrump/mixlayout/ETEngine:getInstanceForHiBoom	()Lcom/etrump/mixlayout/ETEngine;
    //   11: getfield 181	com/etrump/mixlayout/ETEngine:isEngineInited	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   14: iconst_0
    //   15: iconst_1
    //   16: invokevirtual 185	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   19: ifeq +7 -> 26
    //   22: invokestatic 188	com/etrump/mixlayout/FontSoLoader:c	()Z
    //   25: pop
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: invokestatic 178	com/etrump/mixlayout/ETEngine:getInstanceForHiBoom	()Lcom/etrump/mixlayout/ETEngine;
    //   33: putfield 190	com/tencent/mobileqq/hiboom/HiBoomFont:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   36: aload_0
    //   37: getfield 190	com/tencent/mobileqq/hiboom/HiBoomFont:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   40: bipush 10
    //   42: ldc 191
    //   44: invokevirtual 195	com/etrump/mixlayout/ETEngine:initEngine	(II)Z
    //   47: istore_1
    //   48: aload_0
    //   49: getfield 52	com/tencent/mobileqq/hiboom/HiBoomFont:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   52: iload_1
    //   53: invokevirtual 198	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   56: aload_0
    //   57: getfield 50	com/tencent/mobileqq/hiboom/HiBoomFont:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   60: iconst_1
    //   61: invokevirtual 198	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   64: goto -38 -> 26
    //   67: astore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    //   72: astore_2
    //   73: ldc 90
    //   75: iconst_1
    //   76: ldc 200
    //   78: aload_2
    //   79: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   82: goto -26 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	HiBoomFont
    //   47	6	1	bool	boolean
    //   67	4	2	localObject	Object
    //   72	7	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	26	67	finally
    //   29	36	67	finally
    //   36	56	67	finally
    //   56	64	67	finally
    //   73	82	67	finally
    //   36	56	72	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFont
 * JD-Core Version:    0.7.0.1
 */