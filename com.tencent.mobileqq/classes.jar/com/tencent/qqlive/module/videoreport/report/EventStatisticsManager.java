package com.tencent.qqlive.module.videoreport.report;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.utils.ProcessUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.SPUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EventStatisticsManager
{
  private static final String KEY_SEQ_TIME_BASE_KEY = "key_seqtime_base_key";
  private static final long MAX_COUNT_VALUE = 300000L;
  private static final int MSG_SAVE_DATA = 1;
  private static final String SP_NAME = "SP_seq_";
  private static final String TAG = "EventStatisticsManager";
  private static volatile EventStatisticsManager sInstance;
  private static final Object sLockEventGroupCount = new Object();
  private Map<String, Long> mEventCountMap = new HashMap();
  private Handler mHandler = new EventStatisticsManager.1(this, Looper.getMainLooper());
  private String mSeqTimeKey = "";
  private String mSpName = "";
  
  private EventStatisticsManager()
  {
    init();
  }
  
  private static String getEventKey(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  public static EventStatisticsManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new EventStatisticsManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private long getMaxCountValue()
  {
    return 300000L;
  }
  
  private long getSeqTime(String paramString)
  {
    Context localContext = ReportUtils.getContext();
    String str = this.mSpName;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mSeqTimeKey);
    localStringBuilder.append(paramString);
    long l2 = ((Long)SPUtils.get(localContext, str, localStringBuilder.toString(), Long.valueOf(0L))).longValue();
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = System.currentTimeMillis();
      localContext = ReportUtils.getContext();
      str = this.mSpName;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mSeqTimeKey);
      localStringBuilder.append(paramString);
      SPUtils.put(localContext, str, localStringBuilder.toString(), Long.valueOf(l1));
    }
    return l1;
  }
  
  private String getSeqTimeKey()
  {
    String str2 = (String)SPUtils.get(ReportUtils.getContext(), this.mSpName, "key_seqtime_base_key", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = resetSeqTimeKey();
    }
    return str1;
  }
  
  private void init()
  {
    String str = ProcessUtils.getProcessName(ReportUtils.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SP_seq_");
    localStringBuilder.append(str);
    this.mSpName = localStringBuilder.toString();
    this.mSeqTimeKey = getSeqTimeKey();
  }
  
  private String resetSeqTimeKey()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    SPUtils.put(ReportUtils.getContext(), this.mSpName, "key_seqtime_base_key", localObject);
    return localObject;
  }
  
  private void saveData()
  {
    synchronized (sLockEventGroupCount)
    {
      SharedPreferences.Editor localEditor = SPUtils.getEdit(ReportUtils.getContext(), this.mSpName);
      Iterator localIterator = this.mEventCountMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localEditor.putString(str, String.valueOf(this.mEventCountMap.get(str)));
      }
      localEditor.apply();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  /* Error */
  public void addStatisticsInnerParam(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: astore 12
    //   8: aload_1
    //   9: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +7 -> 19
    //   15: ldc 42
    //   17: astore 12
    //   19: getstatic 39	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:sLockEventGroupCount	Ljava/lang/Object;
    //   22: astore 13
    //   24: aload 13
    //   26: monitorenter
    //   27: lconst_1
    //   28: lstore 4
    //   30: lconst_0
    //   31: lstore 10
    //   33: aload_0
    //   34: aload 12
    //   36: invokespecial 196	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:getSeqTime	(Ljava/lang/String;)J
    //   39: lstore 8
    //   41: lload 10
    //   43: lstore 6
    //   45: aload 12
    //   47: aload_0
    //   48: getfield 46	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:mSeqTimeKey	Ljava/lang/String;
    //   51: lload 8
    //   53: aload_2
    //   54: invokestatic 198	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:getEventKey	(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)Ljava/lang/String;
    //   57: astore_1
    //   58: lload 10
    //   60: lstore 6
    //   62: aload_0
    //   63: getfield 51	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:mEventCountMap	Ljava/util/Map;
    //   66: aload_1
    //   67: invokeinterface 202 2 0
    //   72: ifeq +32 -> 104
    //   75: lload 10
    //   77: lstore 6
    //   79: aload_0
    //   80: getfield 51	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:mEventCountMap	Ljava/util/Map;
    //   83: aload_1
    //   84: invokeinterface 178 2 0
    //   89: checkcast 107	java/lang/Long
    //   92: invokevirtual 120	java/lang/Long:longValue	()J
    //   95: lstore 10
    //   97: lload 10
    //   99: lstore 6
    //   101: goto +34 -> 135
    //   104: lload 10
    //   106: lstore 6
    //   108: invokestatic 105	com/tencent/qqlive/module/videoreport/utils/ReportUtils:getContext	()Landroid/content/Context;
    //   111: aload_0
    //   112: getfield 44	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:mSpName	Ljava/lang/String;
    //   115: aload_1
    //   116: lconst_0
    //   117: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: invokestatic 117	com/tencent/qqlive/module/videoreport/utils/SPUtils:get	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   123: checkcast 107	java/lang/Long
    //   126: invokevirtual 120	java/lang/Long:longValue	()J
    //   129: lstore 10
    //   131: lload 10
    //   133: lstore 6
    //   135: lload 6
    //   137: lconst_1
    //   138: ladd
    //   139: lstore 10
    //   141: lload 10
    //   143: lstore 6
    //   145: aload_0
    //   146: getfield 51	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:mEventCountMap	Ljava/util/Map;
    //   149: aload_1
    //   150: lload 10
    //   152: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   155: invokeinterface 205 3 0
    //   160: pop
    //   161: lload 10
    //   163: lstore 6
    //   165: lload 10
    //   167: aload_0
    //   168: invokespecial 207	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:getMaxCountValue	()J
    //   171: lcmp
    //   172: ifle +62 -> 234
    //   175: lload 10
    //   177: lstore 6
    //   179: aload_0
    //   180: aload_0
    //   181: invokespecial 141	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:resetSeqTimeKey	()Ljava/lang/String;
    //   184: putfield 46	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:mSeqTimeKey	Ljava/lang/String;
    //   187: aload_0
    //   188: aload 12
    //   190: invokespecial 196	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:getSeqTime	(Ljava/lang/String;)J
    //   193: lstore 6
    //   195: aload 12
    //   197: aload_0
    //   198: getfield 46	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:mSeqTimeKey	Ljava/lang/String;
    //   201: lload 6
    //   203: aload_2
    //   204: invokestatic 198	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:getEventKey	(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)Ljava/lang/String;
    //   207: astore_1
    //   208: aload_0
    //   209: getfield 51	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:mEventCountMap	Ljava/util/Map;
    //   212: aload_1
    //   213: lconst_1
    //   214: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   217: invokeinterface 205 3 0
    //   222: pop
    //   223: goto +76 -> 299
    //   226: astore_1
    //   227: goto +42 -> 269
    //   230: astore_1
    //   231: goto +19 -> 250
    //   234: lload 10
    //   236: lstore 4
    //   238: lload 8
    //   240: lstore 6
    //   242: goto +57 -> 299
    //   245: astore_1
    //   246: lload 6
    //   248: lstore 4
    //   250: lload 8
    //   252: lstore 6
    //   254: goto +15 -> 269
    //   257: astore_1
    //   258: goto +93 -> 351
    //   261: astore_1
    //   262: lconst_0
    //   263: lstore 4
    //   265: lload 10
    //   267: lstore 6
    //   269: new 76	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   276: astore_2
    //   277: aload_2
    //   278: ldc 209
    //   280: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_2
    //   285: aload_1
    //   286: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: ldc 21
    //   292: aload_2
    //   293: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 218	com/tencent/qqlive/module/videoreport/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload 13
    //   301: monitorexit
    //   302: aload_0
    //   303: getfield 64	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:mHandler	Landroid/os/Handler;
    //   306: iconst_1
    //   307: invokevirtual 224	android/os/Handler:removeMessages	(I)V
    //   310: aload_0
    //   311: getfield 64	com/tencent/qqlive/module/videoreport/report/EventStatisticsManager:mHandler	Landroid/os/Handler;
    //   314: iconst_1
    //   315: ldc2_w 225
    //   318: invokevirtual 230	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   321: pop
    //   322: aload_3
    //   323: ldc 232
    //   325: lload 4
    //   327: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   330: invokeinterface 205 3 0
    //   335: pop
    //   336: aload_3
    //   337: ldc 234
    //   339: lload 6
    //   341: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   344: invokeinterface 205 3 0
    //   349: pop
    //   350: return
    //   351: aload 13
    //   353: monitorexit
    //   354: aload_1
    //   355: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	this	EventStatisticsManager
    //   0	356	1	paramString1	String
    //   0	356	2	paramString2	String
    //   0	356	3	paramMap	Map<String, Object>
    //   28	298	4	l1	long
    //   43	297	6	l2	long
    //   39	212	8	l3	long
    //   31	235	10	l4	long
    //   6	190	12	str	String
    //   22	330	13	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   195	223	226	java/lang/Exception
    //   187	195	230	java/lang/Exception
    //   45	58	245	java/lang/Exception
    //   62	75	245	java/lang/Exception
    //   79	97	245	java/lang/Exception
    //   108	131	245	java/lang/Exception
    //   145	161	245	java/lang/Exception
    //   165	175	245	java/lang/Exception
    //   179	187	245	java/lang/Exception
    //   33	41	257	finally
    //   45	58	257	finally
    //   62	75	257	finally
    //   79	97	257	finally
    //   108	131	257	finally
    //   145	161	257	finally
    //   165	175	257	finally
    //   179	187	257	finally
    //   187	195	257	finally
    //   195	223	257	finally
    //   269	299	257	finally
    //   299	302	257	finally
    //   351	354	257	finally
    //   33	41	261	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.EventStatisticsManager
 * JD-Core Version:    0.7.0.1
 */