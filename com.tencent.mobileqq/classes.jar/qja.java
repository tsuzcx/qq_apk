import com.tencent.gdtad.jsbridge.GdtJsCallHandler;

public class qja
  implements GdtJsCallHandler
{
  /* Error */
  public boolean a(com.tencent.gdtad.jsbridge.GdtAdWebPlugin paramGdtAdWebPlugin, java.lang.String paramString, java.lang.String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 23	com/tencent/gdtad/jsbridge/GdtAdWebPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8: ifnonnull +12 -> 20
    //   11: ldc 25
    //   13: ldc 27
    //   15: invokestatic 33	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: iconst_1
    //   19: ireturn
    //   20: new 35	org/json/JSONObject
    //   23: dup
    //   24: aload_3
    //   25: iconst_0
    //   26: aaload
    //   27: invokespecial 38	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   30: astore_3
    //   31: ldc 25
    //   33: aload_3
    //   34: invokevirtual 42	org/json/JSONObject:toString	()Ljava/lang/String;
    //   37: invokestatic 45	com/tencent/gdtad/log/GdtLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_3
    //   41: ldc 47
    //   43: invokevirtual 51	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 4
    //   48: aload_3
    //   49: ldc 53
    //   51: invokevirtual 51	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 5
    //   56: aload_3
    //   57: ldc 55
    //   59: invokevirtual 51	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore 6
    //   64: aload_3
    //   65: ldc 57
    //   67: invokevirtual 51	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 7
    //   72: aconst_null
    //   73: astore_2
    //   74: aload_3
    //   75: ldc 59
    //   77: invokevirtual 63	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   80: astore_3
    //   81: aload_3
    //   82: astore_2
    //   83: aload_2
    //   84: ifnull -73 -> 11
    //   87: aload_2
    //   88: getstatic 67	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   91: if_acmpeq -80 -> 11
    //   94: aload_2
    //   95: ldc 69
    //   97: invokevirtual 73	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   100: ifne +193 -> 293
    //   103: new 35	org/json/JSONObject
    //   106: dup
    //   107: invokespecial 74	org/json/JSONObject:<init>	()V
    //   110: astore_3
    //   111: aload_3
    //   112: ldc 69
    //   114: aload_2
    //   115: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   118: pop
    //   119: aload_3
    //   120: astore_2
    //   121: new 80	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo
    //   124: dup
    //   125: invokespecial 81	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:<init>	()V
    //   128: astore_3
    //   129: aload_3
    //   130: getfield 85	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:canvas_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   133: aload_2
    //   134: invokevirtual 42	org/json/JSONObject:toString	()Ljava/lang/String;
    //   137: invokevirtual 90	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   140: new 92	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo
    //   143: dup
    //   144: invokespecial 93	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:<init>	()V
    //   147: astore_2
    //   148: aload_2
    //   149: getfield 96	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:traceid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   152: aload 7
    //   154: invokevirtual 90	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   157: new 98	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo
    //   160: dup
    //   161: invokespecial 99	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:<init>	()V
    //   164: astore 7
    //   166: aload 7
    //   168: getfield 102	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:exposure_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   171: aload 4
    //   173: invokevirtual 90	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   176: aload 7
    //   178: getfield 105	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   181: aload 5
    //   183: invokevirtual 90	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   186: aload 7
    //   188: getfield 108	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:landing_page_report_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   191: aload 6
    //   193: invokevirtual 90	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   196: aload 7
    //   198: getfield 112	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   201: aload_2
    //   202: invokevirtual 115	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   205: new 117	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   208: dup
    //   209: invokespecial 118	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   212: astore_2
    //   213: aload_2
    //   214: getfield 122	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:dest_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo;
    //   217: aload_3
    //   218: invokevirtual 123	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   221: aload_2
    //   222: getfield 127	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   225: aload 7
    //   227: invokevirtual 128	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   230: new 130	com/tencent/gdtad/aditem/GdtAd
    //   233: dup
    //   234: aload_2
    //   235: invokespecial 133	com/tencent/gdtad/aditem/GdtAd:<init>	(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V
    //   238: invokestatic 138	com/tencent/gdtad/views/canvas/GdtCanvasDataBuilder:a	(Lcom/tencent/gdtad/aditem/GdtAd;)Lcom/tencent/gdtad/views/canvas/GdtCanvasData;
    //   241: astore_2
    //   242: aload_1
    //   243: getfield 23	com/tencent/gdtad/jsbridge/GdtAdWebPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   246: invokevirtual 143	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   249: ldc 145
    //   251: aload_2
    //   252: invokestatic 148	com/tencent/gdtad/jsbridge/GdtCanvasFragmentForJS:a	(Landroid/app/Activity;Ljava/lang/Class;Lcom/tencent/gdtad/views/canvas/GdtCanvasData;)V
    //   255: iconst_1
    //   256: ireturn
    //   257: astore_1
    //   258: ldc 25
    //   260: ldc 27
    //   262: aload_1
    //   263: invokestatic 151	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   266: goto -255 -> 11
    //   269: astore_3
    //   270: ldc 25
    //   272: ldc 27
    //   274: aload_3
    //   275: invokestatic 151	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   278: goto -195 -> 83
    //   281: astore_1
    //   282: ldc 25
    //   284: ldc 27
    //   286: aload_1
    //   287: invokestatic 151	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   290: goto -279 -> 11
    //   293: goto -172 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	qja
    //   0	296	1	paramGdtAdWebPlugin	com.tencent.gdtad.jsbridge.GdtAdWebPlugin
    //   0	296	2	paramString	java.lang.String
    //   0	296	3	paramVarArgs	java.lang.String[]
    //   46	126	4	str1	java.lang.String
    //   54	128	5	str2	java.lang.String
    //   62	130	6	str3	java.lang.String
    //   70	156	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	31	257	org/json/JSONException
    //   74	81	269	java/lang/Throwable
    //   111	119	281	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     qja
 * JD-Core Version:    0.7.0.1
 */