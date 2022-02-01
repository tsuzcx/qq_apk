package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import com.tencent.qqlive.module.videoreport.IInnerReporter;
import com.tencent.qqlive.module.videoreport.IReporter;
import java.util.Map;
import java.util.TreeMap;

public class DTDebugChannel
  implements IInnerReporter, IReporter
{
  private static final String TAG = "DTDebugChannel";
  private Map<String, Long> mEventCount = new TreeMap();
  
  /* Error */
  private void addReport(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/tencent/qqlive/module/videoreport/dtreport/reportchannel/DTDebugChannel:mEventCount	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 33 2 0
    //   12: checkcast 35	java/lang/Long
    //   15: astore_2
    //   16: aload_2
    //   17: ifnonnull +33 -> 50
    //   20: aload_0
    //   21: getfield 24	com/tencent/qqlive/module/videoreport/dtreport/reportchannel/DTDebugChannel:mEventCount	Ljava/util/Map;
    //   24: aload_1
    //   25: lconst_1
    //   26: invokestatic 39	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   29: invokeinterface 43 3 0
    //   34: pop
    //   35: ldc 12
    //   37: aload_0
    //   38: getfield 24	com/tencent/qqlive/module/videoreport/dtreport/reportchannel/DTDebugChannel:mEventCount	Ljava/util/Map;
    //   41: invokevirtual 47	java/lang/Object:toString	()Ljava/lang/String;
    //   44: invokestatic 53	com/tencent/qqlive/module/videoreport/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield 24	com/tencent/qqlive/module/videoreport/dtreport/reportchannel/DTDebugChannel:mEventCount	Ljava/util/Map;
    //   54: aload_1
    //   55: aload_2
    //   56: invokevirtual 57	java/lang/Long:longValue	()J
    //   59: lconst_1
    //   60: ladd
    //   61: invokestatic 39	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   64: invokeinterface 43 3 0
    //   69: pop
    //   70: goto -35 -> 35
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	DTDebugChannel
    //   0	78	1	paramString	String
    //   15	41	2	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   2	16	73	finally
    //   20	35	73	finally
    //   35	47	73	finally
    //   50	70	73	finally
  }
  
  public void report(Object paramObject, String paramString, Map<String, Object> paramMap)
  {
    addReport(paramString);
  }
  
  public void report(Object paramObject, String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    addReport(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTDebugChannel
 * JD-Core Version:    0.7.0.1
 */