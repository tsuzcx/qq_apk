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
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  private String a()
  {
    if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl())))
    {
      Object localObject2 = RoomManager.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl());
      Object localObject1 = (String)((Map)localObject2).get("roomid");
      localObject2 = (String)((Map)localObject2).get("vid");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("IliveVid switch current Url id = ");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(" ， getRoomId = ");
        localStringBuilder.append(a());
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
    return IliveLiteDataReport.a().a();
  }
  
  private String b(String paramString)
  {
    long l1 = a();
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
      localStringBuilder.append(a());
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
  
  private void c()
  {
    if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_b_of_type_Boolean) && (!this.c))
    {
      this.c = true;
      IliveLiteDataReport.a().a(this.jdField_b_of_type_Long);
    }
  }
  
  protected int a()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    }
    return 0;
  }
  
  protected long a()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().roomId;
    }
    return 0L;
  }
  
  /* Error */
  public com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebJsParams a(String paramString)
  {
    // Byte code:
    //   0: new 54	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: aload_1
    //   12: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload 5
    //   18: ldc 167
    //   20: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 5
    //   26: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: ldc 169
    //   31: invokevirtual 173	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   34: astore 6
    //   36: aload 6
    //   38: arraylength
    //   39: iconst_5
    //   40: if_icmpge +40 -> 80
    //   43: new 54	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   50: astore 5
    //   52: aload 5
    //   54: ldc 175
    //   56: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 5
    //   62: aload_1
    //   63: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: ldc 73
    //   69: iconst_1
    //   70: aload 5
    //   72: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aconst_null
    //   79: areturn
    //   80: aload 6
    //   82: iconst_2
    //   83: aaload
    //   84: astore 7
    //   86: aload 6
    //   88: arraylength
    //   89: istore_3
    //   90: iconst_0
    //   91: istore_2
    //   92: iload_3
    //   93: iconst_5
    //   94: if_icmpne +303 -> 397
    //   97: aload 6
    //   99: iconst_3
    //   100: aaload
    //   101: ldc 180
    //   103: invokevirtual 173	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   106: astore 5
    //   108: aload 5
    //   110: arraylength
    //   111: istore_2
    //   112: iload_2
    //   113: iconst_1
    //   114: if_icmple +70 -> 184
    //   117: aload 5
    //   119: iconst_1
    //   120: aaload
    //   121: invokestatic 186	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   124: pop
    //   125: goto +59 -> 184
    //   128: astore 5
    //   130: new 54	java/lang/StringBuilder
    //   133: dup
    //   134: ldc 188
    //   136: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: astore 6
    //   141: aload 6
    //   143: aload_1
    //   144: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 6
    //   150: ldc 192
    //   152: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 6
    //   158: aload 5
    //   160: invokevirtual 193	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   163: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: ldc 73
    //   169: iconst_1
    //   170: iconst_1
    //   171: anewarray 195	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: aload 6
    //   178: aastore
    //   179: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   182: aconst_null
    //   183: areturn
    //   184: aload 5
    //   186: iconst_0
    //   187: aaload
    //   188: ldc 200
    //   190: invokevirtual 173	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   193: astore 5
    //   195: aload 5
    //   197: iconst_0
    //   198: aaload
    //   199: astore 6
    //   201: aload 5
    //   203: arraylength
    //   204: iconst_1
    //   205: if_icmple +185 -> 390
    //   208: aload 5
    //   210: iconst_1
    //   211: aaload
    //   212: ldc 202
    //   214: invokevirtual 173	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   217: astore 8
    //   219: aload 6
    //   221: astore 5
    //   223: aload 8
    //   225: arraylength
    //   226: ifle +235 -> 461
    //   229: new 204	java/util/ArrayList
    //   232: dup
    //   233: invokespecial 205	java/util/ArrayList:<init>	()V
    //   236: astore 5
    //   238: aload 8
    //   240: arraylength
    //   241: istore_3
    //   242: iconst_0
    //   243: istore_2
    //   244: iload_2
    //   245: iload_3
    //   246: if_icmpge +115 -> 361
    //   249: aload 8
    //   251: iload_2
    //   252: aaload
    //   253: bipush 61
    //   255: invokevirtual 209	java/lang/String:indexOf	(I)I
    //   258: istore 4
    //   260: iload 4
    //   262: iconst_m1
    //   263: if_icmpeq +85 -> 348
    //   266: ldc 211
    //   268: aload 8
    //   270: iload_2
    //   271: aaload
    //   272: iconst_0
    //   273: iload 4
    //   275: invokevirtual 215	java/lang/String:substring	(II)Ljava/lang/String;
    //   278: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   281: ifne +356 -> 637
    //   284: new 54	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   291: astore 9
    //   293: aload 9
    //   295: aload 7
    //   297: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 9
    //   303: ldc 221
    //   305: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 9
    //   311: aload 6
    //   313: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 9
    //   319: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: pop
    //   323: aload 5
    //   325: aload 8
    //   327: iload_2
    //   328: aaload
    //   329: iload 4
    //   331: iconst_1
    //   332: iadd
    //   333: invokevirtual 224	java/lang/String:substring	(I)Ljava/lang/String;
    //   336: invokestatic 229	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   339: invokeinterface 234 2 0
    //   344: pop
    //   345: goto +292 -> 637
    //   348: aload 5
    //   350: ldc 82
    //   352: invokeinterface 234 2 0
    //   357: pop
    //   358: goto +279 -> 637
    //   361: aload 5
    //   363: aload 5
    //   365: invokeinterface 237 1 0
    //   370: anewarray 44	java/lang/String
    //   373: invokeinterface 241 2 0
    //   378: checkcast 243	[Ljava/lang/String;
    //   381: astore 5
    //   383: aload 6
    //   385: astore 5
    //   387: goto +74 -> 461
    //   390: aload 6
    //   392: astore 5
    //   394: goto +67 -> 461
    //   397: aload 6
    //   399: iconst_3
    //   400: aaload
    //   401: astore 5
    //   403: aload 6
    //   405: iconst_4
    //   406: aaload
    //   407: invokestatic 249	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   410: pop2
    //   411: aload 6
    //   413: arraylength
    //   414: bipush 6
    //   416: isub
    //   417: istore_3
    //   418: iload_3
    //   419: anewarray 44	java/lang/String
    //   422: astore 8
    //   424: aload 6
    //   426: iconst_5
    //   427: aload 8
    //   429: iconst_0
    //   430: iload_3
    //   431: invokestatic 253	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   434: aload 8
    //   436: arraylength
    //   437: istore_3
    //   438: iload_2
    //   439: iload_3
    //   440: if_icmpge +204 -> 644
    //   443: aload 8
    //   445: iload_2
    //   446: aload 8
    //   448: iload_2
    //   449: aaload
    //   450: invokestatic 229	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   453: aastore
    //   454: iload_2
    //   455: iconst_1
    //   456: iadd
    //   457: istore_2
    //   458: goto -20 -> 438
    //   461: aload_1
    //   462: invokestatic 259	com/tencent/mobileqq/webview/swift/WebViewPlugin:getJsonFromJSBridge	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   465: astore 6
    //   467: new 261	java/util/HashMap
    //   470: dup
    //   471: invokespecial 262	java/util/HashMap:<init>	()V
    //   474: astore_1
    //   475: aload 6
    //   477: invokestatic 267	cooperation/vip/JsonUtil:a	(Lorg/json/JSONObject;)Ljava/util/Map;
    //   480: checkcast 261	java/util/HashMap
    //   483: astore 6
    //   485: aload 6
    //   487: ifnull +74 -> 561
    //   490: aload 6
    //   492: invokevirtual 271	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   495: invokeinterface 277 1 0
    //   500: astore 6
    //   502: aload 6
    //   504: invokeinterface 282 1 0
    //   509: ifeq +52 -> 561
    //   512: aload 6
    //   514: invokeinterface 286 1 0
    //   519: checkcast 288	java/util/Map$Entry
    //   522: astore 8
    //   524: aload 8
    //   526: ifnull -24 -> 502
    //   529: aload_1
    //   530: aload 8
    //   532: invokeinterface 291 1 0
    //   537: aload 8
    //   539: invokeinterface 294 1 0
    //   544: invokevirtual 295	java/lang/Object:toString	()Ljava/lang/String;
    //   547: invokevirtual 299	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   550: pop
    //   551: goto -49 -> 502
    //   554: astore 6
    //   556: aload 6
    //   558: invokevirtual 302	org/json/JSONException:printStackTrace	()V
    //   561: new 304	com/tencent/mobileqq/litelivesdk/commoncustomized/roombizmodules/webmodule/webview/WebJsParams
    //   564: dup
    //   565: aload 7
    //   567: aload 5
    //   569: aload_1
    //   570: invokespecial 307	com/tencent/mobileqq/litelivesdk/commoncustomized/roombizmodules/webmodule/webview/WebJsParams:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    //   573: areturn
    //   574: astore 5
    //   576: new 54	java/lang/StringBuilder
    //   579: dup
    //   580: ldc 188
    //   582: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   585: astore 6
    //   587: aload 6
    //   589: aload_1
    //   590: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload 6
    //   596: ldc 192
    //   598: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload 6
    //   604: aload 5
    //   606: invokevirtual 308	java/lang/Exception:toString	()Ljava/lang/String;
    //   609: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: ldc 73
    //   615: iconst_1
    //   616: iconst_1
    //   617: anewarray 195	java/lang/Object
    //   620: dup
    //   621: iconst_0
    //   622: aload 6
    //   624: aastore
    //   625: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   628: aconst_null
    //   629: areturn
    //   630: astore_1
    //   631: aload_1
    //   632: invokevirtual 309	java/lang/Exception:printStackTrace	()V
    //   635: aconst_null
    //   636: areturn
    //   637: iload_2
    //   638: iconst_1
    //   639: iadd
    //   640: istore_2
    //   641: goto -397 -> 244
    //   644: goto -183 -> 461
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	647	0	this	IliveWebBizModule
    //   0	647	1	paramString	String
    //   91	550	2	i	int
    //   89	352	3	j	int
    //   258	75	4	k	int
    //   7	111	5	localObject1	Object
    //   128	57	5	localNumberFormatException	java.lang.NumberFormatException
    //   193	375	5	localObject2	Object
    //   574	31	5	localException	java.lang.Exception
    //   34	479	6	localObject3	Object
    //   554	3	6	localJSONException	org.json.JSONException
    //   585	38	6	localStringBuilder1	StringBuilder
    //   84	482	7	str	String
    //   217	321	8	localObject4	Object
    //   291	27	9	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   117	125	128	java/lang/NumberFormatException
    //   475	485	554	org/json/JSONException
    //   490	502	554	org/json/JSONException
    //   502	524	554	org/json/JSONException
    //   529	551	554	org/json/JSONException
    //   403	411	574	java/lang/Exception
    //   86	90	630	java/lang/Exception
    //   97	112	630	java/lang/Exception
    //   117	125	630	java/lang/Exception
    //   130	182	630	java/lang/Exception
    //   184	195	630	java/lang/Exception
    //   201	219	630	java/lang/Exception
    //   223	242	630	java/lang/Exception
    //   249	260	630	java/lang/Exception
    //   266	345	630	java/lang/Exception
    //   348	358	630	java/lang/Exception
    //   361	383	630	java/lang/Exception
    //   411	438	630	java/lang/Exception
    //   443	454	630	java/lang/Exception
    //   461	475	630	java/lang/Exception
    //   475	485	630	java/lang/Exception
    //   490	502	630	java/lang/Exception
    //   502	524	630	java/lang/Exception
    //   529	551	630	java/lang/Exception
    //   556	561	630	java/lang/Exception
    //   561	574	630	java/lang/Exception
    //   576	628	630	java/lang/Exception
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
  
  public String b()
  {
    String str = QzoneConfig.getInstance().getConfig("H5Url", "ilive_enter_room", "https://h5.qzone.qq.com/v2/vip/live/room?inplayer=1");
    EnterRoomConfig localEnterRoomConfig = BusinessManager.a.a();
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
    return b(UriUtil.b((String)localObject1, "clicktime", ((StringBuilder)localObject2).toString()));
  }
  
  protected boolean b()
  {
    int j = a();
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
  
  public String c()
  {
    return "https://h5.qzone.qq.com/v2/vip/live/room?inplayer=1&closejump=mqqapi%3A%2F%2Fvaslive%2Fmyshopping%3Fversion%3D1";
  }
  
  public String d()
  {
    return "https://ilive.qq.com/1014/h5/lite_record.html";
  }
  
  public String e()
  {
    return "https://fastest.ilive.qq.com/1014/h5/lite_record.html";
  }
  
  public String f()
  {
    return "https://ilive.qq.com/1014/h5/lite_temporary.html";
  }
  
  public String g()
  {
    return "https://fastest.ilive.qq.com/1014/h5/lite_temporary.html";
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityResume(paramLifecycleOwner);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    if (b()) {
      this.jdField_b_of_type_Boolean = true;
    }
    c();
  }
  
  public void onPageFinished()
  {
    super.onPageFinished();
    if (this.jdField_a_of_type_Long > 0L)
    {
      this.jdField_b_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
      c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveWebBizModule
 * JD-Core Version:    0.7.0.1
 */