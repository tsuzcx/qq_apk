package cooperation.ilive.lite.module;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.EnterRoomConfig;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebJsParams;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.room.RoomManager;
import com.tencent.mobileqq.litelivesdk.utils.UriUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.ilive.lite.report.IliveLiteDataReport;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class IliveWebBizModule
  extends CustomWebModule
{
  private long a;
  private long b;
  private boolean n;
  private boolean o;
  
  private String a()
  {
    if ((this.f != null) && (!TextUtils.isEmpty(this.f.getUrl())))
    {
      Object localObject2 = RoomManager.a(this.f.getUrl());
      Object localObject1 = (String)((Map)localObject2).get("roomid");
      localObject2 = (String)((Map)localObject2).get("vid");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("IliveVid switch current Url id = ");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(" ， getRoomId = ");
        localStringBuilder.append(m());
        localStringBuilder.append(" vid = ");
        localStringBuilder.append((String)localObject2);
        QLog.i("IliveWebBizModule", 2, localStringBuilder.toString());
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      return localObject1;
    }
    return IliveLiteDataReport.a().b();
  }
  
  private String c(String paramString)
  {
    long l1 = m();
    String str = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
    long l2 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(l1);
    localStringBuilder.append("_");
    localStringBuilder.append(l2);
    str = localStringBuilder.toString();
    paramString = UriUtil.b(paramString, "vid", str);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("IliveVid report serVid id = ");
      localStringBuilder.append(m());
      localStringBuilder.append(" vid = ");
      localStringBuilder.append(str);
      localStringBuilder.append(" currentItemShown = ");
      localStringBuilder.append(b());
      QLog.i("IliveWebBizModule", 2, localStringBuilder.toString());
    }
    if (b()) {
      IliveLiteDataReport.a().a(str);
    }
    return paramString;
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public static WebJsParams d(String paramString)
  {
    // Byte code:
    //   0: new 56	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_0
    //   12: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload 4
    //   18: ldc 144
    //   20: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 4
    //   26: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: ldc 146
    //   31: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   34: astore 5
    //   36: aload 5
    //   38: arraylength
    //   39: iconst_5
    //   40: if_icmpge +40 -> 80
    //   43: new 56	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   50: astore 4
    //   52: aload 4
    //   54: ldc 152
    //   56: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 4
    //   62: aload_0
    //   63: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: ldc 76
    //   69: iconst_1
    //   70: aload 4
    //   72: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 155	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aconst_null
    //   79: areturn
    //   80: aload 5
    //   82: iconst_2
    //   83: aaload
    //   84: astore 6
    //   86: aload 5
    //   88: arraylength
    //   89: istore_2
    //   90: iconst_0
    //   91: istore_1
    //   92: iload_2
    //   93: iconst_5
    //   94: if_icmpne +299 -> 393
    //   97: aload 5
    //   99: iconst_3
    //   100: aaload
    //   101: ldc 157
    //   103: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   106: astore 4
    //   108: aload 4
    //   110: arraylength
    //   111: istore_1
    //   112: iload_1
    //   113: iconst_1
    //   114: if_icmple +70 -> 184
    //   117: aload 4
    //   119: iconst_1
    //   120: aaload
    //   121: invokestatic 163	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   124: pop
    //   125: goto +59 -> 184
    //   128: astore 4
    //   130: new 56	java/lang/StringBuilder
    //   133: dup
    //   134: ldc 165
    //   136: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: astore 5
    //   141: aload 5
    //   143: aload_0
    //   144: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 5
    //   150: ldc 169
    //   152: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 5
    //   158: aload 4
    //   160: invokevirtual 170	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   163: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: ldc 76
    //   169: iconst_1
    //   170: iconst_1
    //   171: anewarray 172	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: aload 5
    //   178: aastore
    //   179: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   182: aconst_null
    //   183: areturn
    //   184: aload 4
    //   186: iconst_0
    //   187: aaload
    //   188: ldc 177
    //   190: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   193: astore 4
    //   195: aload 4
    //   197: iconst_0
    //   198: aaload
    //   199: astore 5
    //   201: aload 4
    //   203: arraylength
    //   204: iconst_1
    //   205: if_icmple +181 -> 386
    //   208: aload 4
    //   210: iconst_1
    //   211: aaload
    //   212: ldc 179
    //   214: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   217: astore 7
    //   219: aload 5
    //   221: astore 4
    //   223: aload 7
    //   225: arraylength
    //   226: ifle +231 -> 457
    //   229: new 181	java/util/ArrayList
    //   232: dup
    //   233: invokespecial 182	java/util/ArrayList:<init>	()V
    //   236: astore 4
    //   238: aload 7
    //   240: arraylength
    //   241: istore_2
    //   242: iconst_0
    //   243: istore_1
    //   244: iload_1
    //   245: iload_2
    //   246: if_icmpge +111 -> 357
    //   249: aload 7
    //   251: iload_1
    //   252: aaload
    //   253: bipush 61
    //   255: invokevirtual 186	java/lang/String:indexOf	(I)I
    //   258: istore_3
    //   259: iload_3
    //   260: iconst_m1
    //   261: if_icmpeq +83 -> 344
    //   264: ldc 188
    //   266: aload 7
    //   268: iload_1
    //   269: aaload
    //   270: iconst_0
    //   271: iload_3
    //   272: invokevirtual 192	java/lang/String:substring	(II)Ljava/lang/String;
    //   275: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: ifne +355 -> 633
    //   281: new 56	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   288: astore 8
    //   290: aload 8
    //   292: aload 6
    //   294: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 8
    //   300: ldc 198
    //   302: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 8
    //   308: aload 5
    //   310: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 8
    //   316: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: pop
    //   320: aload 4
    //   322: aload 7
    //   324: iload_1
    //   325: aaload
    //   326: iload_3
    //   327: iconst_1
    //   328: iadd
    //   329: invokevirtual 201	java/lang/String:substring	(I)Ljava/lang/String;
    //   332: invokestatic 206	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   335: invokeinterface 211 2 0
    //   340: pop
    //   341: goto +292 -> 633
    //   344: aload 4
    //   346: ldc 85
    //   348: invokeinterface 211 2 0
    //   353: pop
    //   354: goto +279 -> 633
    //   357: aload 4
    //   359: aload 4
    //   361: invokeinterface 215 1 0
    //   366: anewarray 46	java/lang/String
    //   369: invokeinterface 219 2 0
    //   374: checkcast 221	[Ljava/lang/String;
    //   377: astore 4
    //   379: aload 5
    //   381: astore 4
    //   383: goto +74 -> 457
    //   386: aload 5
    //   388: astore 4
    //   390: goto +67 -> 457
    //   393: aload 5
    //   395: iconst_3
    //   396: aaload
    //   397: astore 4
    //   399: aload 5
    //   401: iconst_4
    //   402: aaload
    //   403: invokestatic 227	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   406: pop2
    //   407: aload 5
    //   409: arraylength
    //   410: bipush 6
    //   412: isub
    //   413: istore_2
    //   414: iload_2
    //   415: anewarray 46	java/lang/String
    //   418: astore 7
    //   420: aload 5
    //   422: iconst_5
    //   423: aload 7
    //   425: iconst_0
    //   426: iload_2
    //   427: invokestatic 231	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   430: aload 7
    //   432: arraylength
    //   433: istore_2
    //   434: iload_1
    //   435: iload_2
    //   436: if_icmpge +204 -> 640
    //   439: aload 7
    //   441: iload_1
    //   442: aload 7
    //   444: iload_1
    //   445: aaload
    //   446: invokestatic 206	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   449: aastore
    //   450: iload_1
    //   451: iconst_1
    //   452: iadd
    //   453: istore_1
    //   454: goto -20 -> 434
    //   457: aload_0
    //   458: invokestatic 237	com/tencent/mobileqq/webview/swift/WebViewPlugin:getJsonFromJSBridge	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   461: astore 5
    //   463: new 239	java/util/HashMap
    //   466: dup
    //   467: invokespecial 240	java/util/HashMap:<init>	()V
    //   470: astore_0
    //   471: aload 5
    //   473: invokestatic 245	cooperation/vip/JsonUtil:a	(Lorg/json/JSONObject;)Ljava/util/Map;
    //   476: checkcast 239	java/util/HashMap
    //   479: astore 5
    //   481: aload 5
    //   483: ifnull +74 -> 557
    //   486: aload 5
    //   488: invokevirtual 249	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   491: invokeinterface 255 1 0
    //   496: astore 5
    //   498: aload 5
    //   500: invokeinterface 260 1 0
    //   505: ifeq +52 -> 557
    //   508: aload 5
    //   510: invokeinterface 264 1 0
    //   515: checkcast 266	java/util/Map$Entry
    //   518: astore 7
    //   520: aload 7
    //   522: ifnull -24 -> 498
    //   525: aload_0
    //   526: aload 7
    //   528: invokeinterface 269 1 0
    //   533: aload 7
    //   535: invokeinterface 272 1 0
    //   540: invokevirtual 273	java/lang/Object:toString	()Ljava/lang/String;
    //   543: invokevirtual 277	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   546: pop
    //   547: goto -49 -> 498
    //   550: astore 5
    //   552: aload 5
    //   554: invokevirtual 280	org/json/JSONException:printStackTrace	()V
    //   557: new 282	com/tencent/mobileqq/litelivesdk/commoncustomized/roombizmodules/webmodule/webview/WebJsParams
    //   560: dup
    //   561: aload 6
    //   563: aload 4
    //   565: aload_0
    //   566: invokespecial 285	com/tencent/mobileqq/litelivesdk/commoncustomized/roombizmodules/webmodule/webview/WebJsParams:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    //   569: areturn
    //   570: astore 4
    //   572: new 56	java/lang/StringBuilder
    //   575: dup
    //   576: ldc 165
    //   578: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   581: astore 5
    //   583: aload 5
    //   585: aload_0
    //   586: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload 5
    //   592: ldc 169
    //   594: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload 5
    //   600: aload 4
    //   602: invokevirtual 286	java/lang/Exception:toString	()Ljava/lang/String;
    //   605: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: ldc 76
    //   611: iconst_1
    //   612: iconst_1
    //   613: anewarray 172	java/lang/Object
    //   616: dup
    //   617: iconst_0
    //   618: aload 5
    //   620: aastore
    //   621: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   624: aconst_null
    //   625: areturn
    //   626: astore_0
    //   627: aload_0
    //   628: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   631: aconst_null
    //   632: areturn
    //   633: iload_1
    //   634: iconst_1
    //   635: iadd
    //   636: istore_1
    //   637: goto -393 -> 244
    //   640: goto -183 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	643	0	paramString	String
    //   91	546	1	i	int
    //   89	348	2	j	int
    //   258	71	3	k	int
    //   7	111	4	localObject1	Object
    //   128	57	4	localNumberFormatException	java.lang.NumberFormatException
    //   193	371	4	localObject2	Object
    //   570	31	4	localException	java.lang.Exception
    //   34	475	5	localObject3	Object
    //   550	3	5	localJSONException	org.json.JSONException
    //   581	38	5	localStringBuilder1	StringBuilder
    //   84	478	6	str	String
    //   217	317	7	localObject4	Object
    //   288	27	8	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   117	125	128	java/lang/NumberFormatException
    //   471	481	550	org/json/JSONException
    //   486	498	550	org/json/JSONException
    //   498	520	550	org/json/JSONException
    //   525	547	550	org/json/JSONException
    //   399	407	570	java/lang/Exception
    //   86	90	626	java/lang/Exception
    //   97	112	626	java/lang/Exception
    //   117	125	626	java/lang/Exception
    //   130	182	626	java/lang/Exception
    //   184	195	626	java/lang/Exception
    //   201	219	626	java/lang/Exception
    //   223	242	626	java/lang/Exception
    //   249	259	626	java/lang/Exception
    //   264	341	626	java/lang/Exception
    //   344	354	626	java/lang/Exception
    //   357	379	626	java/lang/Exception
    //   407	434	626	java/lang/Exception
    //   439	450	626	java/lang/Exception
    //   457	471	626	java/lang/Exception
    //   471	481	626	java/lang/Exception
    //   486	498	626	java/lang/Exception
    //   498	520	626	java/lang/Exception
    //   525	547	626	java/lang/Exception
    //   552	557	626	java/lang/Exception
    //   557	570	626	java/lang/Exception
    //   572	624	626	java/lang/Exception
  }
  
  private void t()
  {
    if ((this.b != 0L) && (this.n) && (!this.o))
    {
      this.o = true;
      IliveLiteDataReport.a().a(this.b);
    }
  }
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  protected void a(RoomExtInfo paramRoomExtInfo)
  {
    super.a(paramRoomExtInfo);
    IliveLiteDataReport.a().a(paramRoomExtInfo);
  }
  
  protected boolean b()
  {
    int j = c();
    IAudienceRoomPager localIAudienceRoomPager = getAudienceRoomPager();
    boolean bool = false;
    int i;
    if ((localIAudienceRoomPager != null) && (getAudienceRoomPager() != null)) {
      i = getAudienceRoomPager().getCurrentIndex();
    } else {
      i = 0;
    }
    if (j == i) {
      bool = true;
    }
    return bool;
  }
  
  protected int c()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    }
    return 0;
  }
  
  public String d()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "ilive_enter_room", "https://h5.qzone.qq.com/v2/vip/live/room?inplayer=1");
    EnterRoomConfig localEnterRoomConfig = BusinessManager.a.c();
    Object localObject1 = str;
    if (localEnterRoomConfig != null)
    {
      localObject1 = str;
      if (localEnterRoomConfig.extData != null)
      {
        localObject2 = (String)RoomManager.a(localEnterRoomConfig.extData.getString("mqqschema")).get("closeJump");
        str = UriUtil.b(str, "closetop", String.valueOf(UIUtil.getStatusBarHeight(this.context) + UIUtil.dp2px(this.context, 9.0F)));
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "";
        }
        localObject1 = UriUtil.b(UriUtil.b(str, "closejump", String.valueOf(localObject1)), "trace_info", String.valueOf(localEnterRoomConfig.extData.getString("trace_info", "")));
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append("");
    return c(UriUtil.b((String)localObject1, "clicktime", ((StringBuilder)localObject2).toString()));
  }
  
  public String e()
  {
    return "https://h5.qzone.qq.com/v2/vip/live/room?inplayer=1";
  }
  
  public String f()
  {
    return "https://ilive.qq.com/1014/h5/lite_record.html";
  }
  
  public String g()
  {
    return "https://fastest.ilive.qq.com/1014/h5/lite_record.html";
  }
  
  public String h()
  {
    return "https://ilive.qq.com/1014/h5/lite_temporary.html";
  }
  
  public String i()
  {
    return "https://fastest.ilive.qq.com/1014/h5/lite_temporary.html";
  }
  
  protected long m()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().roomId;
    }
    return 0L;
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityResume(paramLifecycleOwner);
    this.a = System.currentTimeMillis();
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    if (b()) {
      this.n = true;
    }
    t();
  }
  
  public WebJsParams onJsParamsParse(String paramString)
  {
    return d(paramString);
  }
  
  public void onPageFinished()
  {
    super.onPageFinished();
    if (this.a > 0L)
    {
      this.b = (System.currentTimeMillis() - this.a);
      t();
    }
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    if (b()) {
      IliveLiteDataReport.a().a(a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveWebBizModule
 * JD-Core Version:    0.7.0.1
 */