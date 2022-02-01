package com.tencent.rmonitor.natmem;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.DefaultPluginConfig;
import com.tencent.rmonitor.base.config.data.NatMemPluginConfig;
import com.tencent.rmonitor.base.config.data.RPluginConfig;
import com.tencent.rmonitor.base.plugin.listener.IBaseListener;
import com.tencent.rmonitor.base.plugin.listener.ListenerManager;
import com.tencent.rmonitor.base.plugin.listener.MonitorListenerMng;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AppInfo;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.memory.common.DelayIntervalDetector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NatMemHandler
  extends Handler
{
  private final DelayIntervalDetector a = new DelayIntervalDetector(10000L, 10000L, 30000L);
  private long b = 4294967296L;
  private long c = 1073741824L;
  private String d;
  private boolean e = true;
  
  public NatMemHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a()
  {
    NatMemMonitor.getInstance().nativeInit();
    NatMemMonitor.getInstance().nativeInitSysHookParameter(NatMemMonitor.getInstance().e().c(), NatMemMonitor.getInstance().e().d(), NatMemMonitor.getInstance().e().e());
    NatMemMonitor.getInstance().nativeInitAppHookParameter(NatMemMonitor.getInstance().e().f());
    this.c = NatMemMonitor.getInstance().e().l();
    this.b = NatMemMonitor.getInstance().e().m();
    this.d = NatMemMonitor.getInstance().e().n();
    this.e = nativeIs64Bit();
    this.a.a();
  }
  
  private void a(String paramString)
  {
    if (NatMemMonitor.a) {
      NatMemMonitor.getInstance().nativeDumpNatMemLeakInfo(paramString);
    }
  }
  
  private void b()
  {
    Iterator localIterator = NatMemMonitor.getInstance().e().g().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      NatMemMonitor.getInstance().nativeRegisterAppLib((String)localObject);
    }
    if (!NatMemMonitor.getInstance().e().k()) {
      NatMemMonitor.getInstance().e().i().add(".*/libc.so$");
    }
    localIterator = NatMemMonitor.getInstance().e().i().iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      NatMemMonitor.getInstance().nativeIgnoreLib((String)localObject);
    }
    if (NatMemMonitor.getInstance().e().j())
    {
      localIterator = NatMemMonitor.getInstance().e().h().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        NatMemMonitor.getInstance().nativeRegisterSysLib((String)localObject);
      }
    }
    NatMemMonitor.getInstance().nativeStartHook();
    localIterator = ListenerManager.k.a().iterator();
    while (localIterator.hasNext())
    {
      localObject = (IBaseListener)localIterator.next();
      if ((localObject instanceof INatMemListener)) {
        ((INatMemListener)localObject).a();
      }
    }
    NatMemAttaReporter.a();
    sendEmptyMessageDelayed(5, this.a.c());
  }
  
  private void b(String paramString)
  {
    if (NatMemMonitor.a) {
      NatMemMonitor.getInstance().nativeDumpNatMemUsageInfo(paramString);
    }
  }
  
  private boolean c()
  {
    return (float)(AppInfo.e() / this.c) > 0.85F;
  }
  
  /* Error */
  private boolean d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: new 189	java/io/BufferedReader
    //   8: dup
    //   9: new 191	java/io/FileReader
    //   12: dup
    //   13: ldc 193
    //   15: invokespecial 195	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 198	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore_3
    //   22: aload_3
    //   23: invokevirtual 201	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull +55 -> 83
    //   31: aload_2
    //   32: ldc 203
    //   34: invokevirtual 207	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   37: ifeq +38 -> 75
    //   40: aload_2
    //   41: ldc 209
    //   43: ldc 211
    //   45: invokevirtual 215	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   48: pop
    //   49: aload_2
    //   50: ldc 217
    //   52: invokevirtual 221	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   55: arraylength
    //   56: iconst_2
    //   57: if_icmplt +26 -> 83
    //   60: aload_2
    //   61: ldc 217
    //   63: invokevirtual 221	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   66: iconst_1
    //   67: aaload
    //   68: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   71: istore_1
    //   72: goto +13 -> 85
    //   75: aload_3
    //   76: invokevirtual 201	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   79: astore_2
    //   80: goto -53 -> 27
    //   83: iconst_0
    //   84: istore_1
    //   85: aload_3
    //   86: invokevirtual 229	java/io/BufferedReader:close	()V
    //   89: goto +62 -> 151
    //   92: astore_2
    //   93: aload_2
    //   94: invokevirtual 232	java/lang/Throwable:printStackTrace	()V
    //   97: goto +54 -> 151
    //   100: astore_2
    //   101: goto +72 -> 173
    //   104: astore 4
    //   106: goto +20 -> 126
    //   109: astore 4
    //   111: aload_2
    //   112: astore_3
    //   113: aload 4
    //   115: astore_2
    //   116: goto +57 -> 173
    //   119: astore_2
    //   120: aload 4
    //   122: astore_3
    //   123: aload_2
    //   124: astore 4
    //   126: aload_3
    //   127: astore_2
    //   128: aload 4
    //   130: invokevirtual 232	java/lang/Throwable:printStackTrace	()V
    //   133: aload_3
    //   134: ifnull +15 -> 149
    //   137: aload_3
    //   138: invokevirtual 229	java/io/BufferedReader:close	()V
    //   141: goto +8 -> 149
    //   144: astore_2
    //   145: aload_2
    //   146: invokevirtual 232	java/lang/Throwable:printStackTrace	()V
    //   149: iconst_0
    //   150: istore_1
    //   151: iload_1
    //   152: sipush 1024
    //   155: imul
    //   156: i2f
    //   157: aload_0
    //   158: getfield 32	com/tencent/rmonitor/natmem/NatMemHandler:b	J
    //   161: l2f
    //   162: fdiv
    //   163: ldc 185
    //   165: fcmpl
    //   166: ifle +5 -> 171
    //   169: iconst_1
    //   170: ireturn
    //   171: iconst_0
    //   172: ireturn
    //   173: aload_3
    //   174: ifnull +15 -> 189
    //   177: aload_3
    //   178: invokevirtual 229	java/io/BufferedReader:close	()V
    //   181: goto +8 -> 189
    //   184: astore_3
    //   185: aload_3
    //   186: invokevirtual 232	java/lang/Throwable:printStackTrace	()V
    //   189: goto +5 -> 194
    //   192: aload_2
    //   193: athrow
    //   194: goto -2 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	NatMemHandler
    //   71	85	1	i	int
    //   4	76	2	str	String
    //   92	2	2	localThrowable1	java.lang.Throwable
    //   100	12	2	localObject1	Object
    //   115	1	2	localObject2	Object
    //   119	5	2	localThrowable2	java.lang.Throwable
    //   127	1	2	localObject3	Object
    //   144	49	2	localThrowable3	java.lang.Throwable
    //   21	157	3	localObject4	Object
    //   184	2	3	localThrowable4	java.lang.Throwable
    //   1	1	4	localObject5	Object
    //   104	1	4	localThrowable5	java.lang.Throwable
    //   109	12	4	localObject6	Object
    //   124	5	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   85	89	92	java/lang/Throwable
    //   22	27	100	finally
    //   31	72	100	finally
    //   75	80	100	finally
    //   22	27	104	java/lang/Throwable
    //   31	72	104	java/lang/Throwable
    //   75	80	104	java/lang/Throwable
    //   5	22	109	finally
    //   128	133	109	finally
    //   5	22	119	java/lang/Throwable
    //   137	141	144	java/lang/Throwable
    //   177	181	184	java/lang/Throwable
  }
  
  private void e()
  {
    boolean bool2 = c();
    boolean bool1;
    if (!this.e) {
      bool1 = d();
    } else {
      bool1 = false;
    }
    if ((!bool1) && (!bool2))
    {
      sendEmptyMessageDelayed(5, this.a.c());
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.d);
    ((StringBuilder)localObject1).append("usage_");
    ((StringBuilder)localObject1).append(l);
    ((StringBuilder)localObject1).append(".json");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.d);
    ((StringBuilder)localObject2).append("leak_");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append(".json");
    localObject2 = ((StringBuilder)localObject2).toString();
    b((String)localObject1);
    if (bool1)
    {
      NatMemReporter.a(1);
      NatMemReporter.a((String)localObject1, (String)localObject2, 1);
    }
    else if (bool2)
    {
      NatMemReporter.a(2);
      NatMemReporter.a((String)localObject1, (String)localObject2, 2);
    }
    if (localObject1 != null) {
      FileUtil.a(new File((String)localObject1));
    }
    if (localObject2 != null) {
      FileUtil.a(new File((String)localObject2));
    }
    if (!PluginController.b.b(154))
    {
      int i = ConfigProxy.INSTANCE.getConfig().b(154).f.g;
      Logger.b.d(new String[] { "NatMem", "native memory celling report count above, remove MEMORY_CHECK_MSG msg,", " max report num: ", String.valueOf(i) });
      removeMessages(5);
      return;
    }
    sendEmptyMessageDelayed(5, this.a.c());
  }
  
  private native boolean nativeIs64Bit();
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            e();
            return;
          }
          l = System.currentTimeMillis();
          paramMessage = new StringBuilder();
          paramMessage.append(this.d);
          paramMessage.append("usage_");
          paramMessage.append(l);
          paramMessage.append(".json");
          paramMessage = paramMessage.toString();
          b(paramMessage);
          NatMemReporter.a(1);
          NatMemReporter.a(paramMessage, null, 1);
          return;
        }
        long l = System.currentTimeMillis();
        paramMessage = new StringBuilder();
        paramMessage.append(this.d);
        paramMessage.append("leak_");
        paramMessage.append(l);
        paramMessage.append(".json");
        paramMessage = paramMessage.toString();
        a(paramMessage);
        NatMemReporter.a(2);
        NatMemReporter.a(null, paramMessage, 2);
        return;
      }
      b();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.natmem.NatMemHandler
 * JD-Core Version:    0.7.0.1
 */