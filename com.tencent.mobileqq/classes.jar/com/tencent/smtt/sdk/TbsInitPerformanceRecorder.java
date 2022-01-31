package com.tencent.smtt.sdk;

import android.text.TextUtils;
import android.util.Log;
import java.util.Map;

class TbsInitPerformanceRecorder
{
  public static final String CAN_LOAD_X5 = "can_load_x5";
  private static final String CURRENT_URL = "current_url";
  public static final byte EVENT_TYPE_BEGIN = 1;
  public static final byte EVENT_TYPE_END = 2;
  public static final String FREE_RAM_BEGIN = "free_ram_begin";
  public static final String FREE_RAM_END = "free_ram_end";
  public static final String INIT_ALL = "init_all";
  public static final String INIT_TBS = "init_tbs";
  public static final String INIT_TYPE = "init_type";
  public static final String INIT_X5_CORE = "init_x5_core";
  public static final String INIT_X5_WEBVIEW = "init_x5_webview";
  public static final String IS_FIRST_INIT_TBS = "is_first_init_tbs";
  public static final String IS_FIRST_INIT_X5 = "is_first_init_x5";
  public static final String LOAD_TBS_DEX = "load_tbs_dex";
  public static final String LOAD_URL_GAP = "load_url_gap";
  public static final String READ_CORE_INFO = "read_core_info";
  public static final String SUFFIX_BEGIN = "_begin";
  public static final String SUFFIX_END = "_end";
  public static final String TBSLOG_INIT = "tbslog_init";
  public static final String TBS_RENAME_TASK = "tbs_rename_task";
  public static final String TIME_ONCREATE = "time_oncreate";
  public static final String TIME_WEBACCELERATOR = "time_webaccelerator";
  public static final String WEBACCELERATOR_INIT = "webaccelerator_init";
  public static final String WEBVIEW_TYPE = "webview_type";
  public static final String X5_CORE_ENGINE_INIT_SYNC = "x5_core_engine_init_sync";
  private static final String X5_WEBVIEW_ID = "x5_webview_id";
  public boolean mIsFirstInitTbs = false;
  public boolean mIsFirstInitX5 = false;
  private Map<String, String> mPerformanceMaps = null;
  
  private void displayTbsInitPerformanceData(Map<String, String> paramMap)
  {
    String[] arrayOfString = new String[13];
    arrayOfString[0] = "init_all";
    arrayOfString[1] = "tbslog_init";
    arrayOfString[2] = "mtt_trace";
    arrayOfString[3] = "x5_core_engine_init_sync";
    arrayOfString[4] = "tbs_rename_task";
    arrayOfString[5] = "can_load_x5";
    arrayOfString[6] = "read_core_info";
    arrayOfString[7] = "load_tbs_dex";
    arrayOfString[8] = "init_tbs";
    arrayOfString[9] = "init_x5_core";
    arrayOfString[10] = "init_x5_webview";
    arrayOfString[11] = "load_url_gap";
    arrayOfString[12] = "load_url";
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder1.append("----------------------------start------------------------------");
    localStringBuilder1.append("\n");
    localStringBuilder1.append("is_first_init_x5");
    localStringBuilder1.append(": ");
    localStringBuilder1.append((String)paramMap.get("is_first_init_x5"));
    localStringBuilder1.append("\n");
    localStringBuilder1.append("is_first_init_tbs");
    localStringBuilder1.append(": ");
    localStringBuilder1.append((String)paramMap.get("is_first_init_tbs"));
    localStringBuilder1.append("\n");
    localStringBuilder1.append("current_url");
    localStringBuilder1.append(": ");
    localStringBuilder1.append((String)paramMap.get("current_url"));
    localStringBuilder1.append("\n");
    localStringBuilder1.append("tbs_core_version");
    localStringBuilder1.append(": ");
    localStringBuilder1.append(QbSdk.getTbsCoreVersionString());
    localStringBuilder1.append("\n");
    long l1 = 0L;
    long l2 = 0L;
    int i = 0;
    while (i < arrayOfString.length)
    {
      String str1 = arrayOfString[i];
      String str2 = str1 + "_end";
      String str3 = str1 + "_begin";
      String str4 = (String)paramMap.get(str2);
      String str5 = (String)paramMap.get(str3);
      long l3 = l2;
      long l4 = l1;
      if (str4 != null)
      {
        l3 = l2;
        l4 = l1;
        if (str5 != null)
        {
          l3 = l2;
          l4 = l1;
          if (!str4.isEmpty())
          {
            if (!str5.isEmpty()) {
              break label440;
            }
            l4 = l1;
            l3 = l2;
          }
        }
      }
      i += 1;
      l2 = l3;
      l1 = l4;
      continue;
      label440:
      l3 = Long.parseLong(str4) - Long.parseLong(str5);
      localStringBuilder1.append(str1 + " duration:\t");
      localStringBuilder1.append(l3);
      localStringBuilder1.append("\n");
      switch (i)
      {
      }
      for (;;)
      {
        localStringBuilder2.append("(" + i + ") ");
        localStringBuilder2.append(str3);
        localStringBuilder2.append(" :\t" + (String)paramMap.get(str3));
        localStringBuilder2.append(";");
        localStringBuilder2.append("\n");
        localStringBuilder2.append("(" + i + ") ");
        localStringBuilder2.append(str2);
        localStringBuilder2.append(" :\t" + (String)paramMap.get(str2));
        localStringBuilder2.append(";");
        localStringBuilder2.append("\n");
        l3 = l2;
        l4 = l1;
        break;
        l1 = l3;
        continue;
        l2 = l3;
      }
    }
    localStringBuilder1.append("\n");
    localStringBuilder1.append("-----------------------start_cost: " + (l1 - l2) + "-------------------------");
    localStringBuilder1.append("\n");
    localStringBuilder1.append("-------------------------------------------------------------");
    localStringBuilder1.append("\n");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("----------------------------end------------------------------");
    localStringBuilder1.append("\n");
    Log.e("performance", "" + localStringBuilder1.toString());
  }
  
  /* Error */
  public boolean endRecord(int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 194	com/tencent/smtt/sdk/X5CoreEngine:getInstance	()Lcom/tencent/smtt/sdk/X5CoreEngine;
    //   7: astore 4
    //   9: aload 4
    //   11: invokevirtual 197	com/tencent/smtt/sdk/X5CoreEngine:isX5Core	()Z
    //   14: ifeq +202 -> 216
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 96	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:mIsFirstInitTbs	Z
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 94	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:mIsFirstInitX5	Z
    //   27: aload_0
    //   28: getfield 98	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:mPerformanceMaps	Ljava/util/Map;
    //   31: ldc 40
    //   33: aload_0
    //   34: getfield 96	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:mIsFirstInitTbs	Z
    //   37: invokestatic 201	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   40: invokeinterface 205 3 0
    //   45: pop
    //   46: aload_0
    //   47: getfield 98	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:mPerformanceMaps	Ljava/util/Map;
    //   50: ldc 43
    //   52: aload_0
    //   53: getfield 94	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:mIsFirstInitX5	Z
    //   56: invokestatic 201	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   59: invokeinterface 205 3 0
    //   64: pop
    //   65: aload_0
    //   66: getfield 98	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:mPerformanceMaps	Ljava/util/Map;
    //   69: ldc 82
    //   71: iload_1
    //   72: invokestatic 210	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   75: invokeinterface 205 3 0
    //   80: pop
    //   81: aload_0
    //   82: getfield 98	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:mPerformanceMaps	Ljava/util/Map;
    //   85: ldc 11
    //   87: aload_2
    //   88: invokeinterface 205 3 0
    //   93: pop
    //   94: getstatic 213	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   97: ifnull +56 -> 153
    //   100: getstatic 213	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   103: ldc 215
    //   105: invokeinterface 219 2 0
    //   110: ifeq +43 -> 153
    //   113: aload_0
    //   114: getfield 98	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:mPerformanceMaps	Ljava/util/Map;
    //   117: ldc 215
    //   119: new 112	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   126: ldc 178
    //   128: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: getstatic 213	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   134: ldc 215
    //   136: invokeinterface 129 2 0
    //   141: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokeinterface 205 3 0
    //   152: pop
    //   153: aload 4
    //   155: invokevirtual 226	com/tencent/smtt/sdk/X5CoreEngine:wizard	()Lcom/tencent/smtt/sdk/X5CoreWizard;
    //   158: invokevirtual 232	com/tencent/smtt/sdk/X5CoreWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   161: astore_2
    //   162: getstatic 236	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   165: astore 4
    //   167: aload_0
    //   168: getfield 98	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:mPerformanceMaps	Ljava/util/Map;
    //   171: astore 5
    //   173: aload_2
    //   174: ldc 238
    //   176: ldc 240
    //   178: iconst_2
    //   179: anewarray 242	java/lang/Class
    //   182: dup
    //   183: iconst_0
    //   184: aload 4
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: ldc 125
    //   191: aastore
    //   192: iconst_2
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: iload_1
    //   199: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: aload 5
    //   207: aastore
    //   208: invokevirtual 251	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   211: pop
    //   212: aload_0
    //   213: monitorexit
    //   214: iload_3
    //   215: ireturn
    //   216: iconst_0
    //   217: istore_3
    //   218: goto -6 -> 212
    //   221: astore_2
    //   222: aload_0
    //   223: monitorexit
    //   224: aload_2
    //   225: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	TbsInitPerformanceRecorder
    //   0	226	1	paramInt	int
    //   0	226	2	paramString	String
    //   1	217	3	bool	boolean
    //   7	178	4	localObject	Object
    //   171	35	5	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   4	153	221	finally
    //   153	212	221	finally
  }
  
  public void recordPerformanceEvent(String paramString, byte paramByte)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        str = "";
        if (paramByte == 1)
        {
          str = "_begin";
          this.mPerformanceMaps.put(paramString + str, String.valueOf(System.currentTimeMillis()));
          continue;
        }
        if (paramByte != 2) {
          continue;
        }
      }
      finally {}
      String str = "_end";
    }
  }
  
  /* Error */
  public void recordPerformanceEvent(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 258	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 98	com/tencent/smtt/sdk/TbsInitPerformanceRecorder:mPerformanceMaps	Ljava/util/Map;
    //   20: aload_1
    //   21: lload_2
    //   22: invokestatic 267	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   25: invokeinterface 205 3 0
    //   30: pop
    //   31: goto -18 -> 13
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	TbsInitPerformanceRecorder
    //   0	39	1	paramString	String
    //   0	39	2	paramLong	long
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	34	finally
    //   16	31	34	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsInitPerformanceRecorder
 * JD-Core Version:    0.7.0.1
 */