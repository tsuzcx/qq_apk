package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.util.URLUtil;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

public abstract class AbsStructMsgElement
  implements View.OnClickListener, StructMsgConstants
{
  public String A;
  public String B;
  public String C;
  public String D;
  public String E;
  public String F;
  public String G;
  public String H;
  public String I;
  public String J;
  public String K;
  public String L;
  public String M;
  public String N;
  public String O;
  public String P;
  public String Q;
  public String R;
  public String S;
  public String T;
  public String U;
  public String V;
  public String W;
  public String X;
  public String Y;
  public String Z = "";
  public int a;
  public long a;
  public AbsStructMsg a;
  public String a;
  public WeakReference<OnLongClickAndTouchListener> a;
  public String aa = null;
  public String ab;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = -1L;
  public String b;
  public int c;
  public String c = null;
  public int d;
  public String d = null;
  public int e;
  public String e = null;
  public int f;
  public String f = null;
  public int g;
  public String g = null;
  public int h;
  public String h = null;
  public int i;
  public String i = null;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n = -1;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  public AbsStructMsgElement()
  {
    this.jdField_a_of_type_Int = 18;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = null;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    Object localObject = paramString;
    if (!URLUtil.a(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    try
    {
      paramString = new URL((String)localObject).getHost();
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return "";
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public abstract View a(Context paramContext, View paramView, Bundle paramBundle);
  
  public abstract String a();
  
  public void a(int paramInt)
  {
    int i1 = this.jdField_b_of_type_Int;
    if ((i1 & paramInt) == 0) {
      this.jdField_b_of_type_Int = (paramInt | i1);
    }
  }
  
  public void a(AbsShareMsg paramAbsShareMsg) {}
  
  public void a(ObjectInput paramObjectInput)
  {
    this.jdField_a_of_type_Int = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.jdField_a_of_type_JavaLangString);
    paramObjectOutput.writeInt(this.jdField_a_of_type_Int);
  }
  
  public abstract void a(XmlSerializer paramXmlSerializer);
  
  public boolean a(int paramInt)
  {
    return (this.jdField_b_of_type_Int & paramInt) == paramInt;
  }
  
  public abstract boolean a(StructMsgNode paramStructMsgNode);
  
  /* Error */
  public void onClick(View paramView)
  {
    // Byte code:
    //   0: invokestatic 176	android/os/SystemClock:uptimeMillis	()J
    //   3: aload_0
    //   4: getfield 104	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_b_of_type_Long	J
    //   7: lsub
    //   8: ldc2_w 177
    //   11: lcmp
    //   12: ifge +6 -> 18
    //   15: goto +1853 -> 1868
    //   18: aload_0
    //   19: invokestatic 176	android/os/SystemClock:uptimeMillis	()J
    //   22: putfield 104	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_b_of_type_Long	J
    //   25: aload_1
    //   26: invokevirtual 184	android/view/View:getTag	()Ljava/lang/Object;
    //   29: astore 6
    //   31: aload_0
    //   32: invokevirtual 188	java/lang/Object:getClass	()Ljava/lang/Class;
    //   35: aload 6
    //   37: invokevirtual 194	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   40: ifne +6 -> 46
    //   43: goto +1825 -> 1868
    //   46: aload 6
    //   48: checkcast 2	com/tencent/mobileqq/structmsg/AbsStructMsgElement
    //   51: astore 9
    //   53: aload_1
    //   54: invokevirtual 198	android/view/View:getContext	()Landroid/content/Context;
    //   57: astore 10
    //   59: ldc 200
    //   61: aload 10
    //   63: invokevirtual 194	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   66: ifne +13 -> 79
    //   69: ldc 202
    //   71: aload 10
    //   73: invokevirtual 194	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   76: ifeq +1792 -> 1868
    //   79: aload 10
    //   81: checkcast 204	com/tencent/mobileqq/app/BaseActivity
    //   84: astore 11
    //   86: aload 11
    //   88: invokevirtual 208	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   91: ifnonnull +6 -> 97
    //   94: goto +1774 -> 1868
    //   97: aload 11
    //   99: invokevirtual 208	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   102: invokevirtual 213	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   105: astore 6
    //   107: aload 9
    //   109: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_Long	J
    //   112: lconst_0
    //   113: lcmp
    //   114: ifle +57 -> 171
    //   117: aload 9
    //   119: getfield 92	com/tencent/mobileqq/structmsg/AbsStructMsgElement:aa	Ljava/lang/String;
    //   122: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifne +46 -> 171
    //   128: aload 6
    //   130: ldc 221
    //   132: ldc 223
    //   134: aload 9
    //   136: getfield 225	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ab	Ljava/lang/String;
    //   139: ldc 227
    //   141: ldc 229
    //   143: aload_0
    //   144: getfield 92	com/tencent/mobileqq/structmsg/AbsStructMsgElement:aa	Ljava/lang/String;
    //   147: invokestatic 235	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   150: iconst_0
    //   151: ldc 88
    //   153: ldc 88
    //   155: aload 9
    //   157: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_Long	J
    //   160: invokestatic 240	java/lang/Long:toString	(J)Ljava/lang/String;
    //   163: ldc 88
    //   165: invokestatic 245	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   168: goto +3 -> 171
    //   171: ldc 247
    //   173: invokestatic 253	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   176: checkcast 247	com/tencent/mobileqq/kandian/biz/common/api/IReadInJoySPEventReport
    //   179: aload 9
    //   181: getfield 225	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ab	Ljava/lang/String;
    //   184: aload 9
    //   186: invokeinterface 257 3 0
    //   191: aload 11
    //   193: invokevirtual 208	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   196: invokevirtual 260	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   199: instanceof 262
    //   202: ifeq +195 -> 397
    //   205: aload 9
    //   207: getfield 92	com/tencent/mobileqq/structmsg/AbsStructMsgElement:aa	Ljava/lang/String;
    //   210: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   213: ifne +14 -> 227
    //   216: aload_0
    //   217: getfield 92	com/tencent/mobileqq/structmsg/AbsStructMsgElement:aa	Ljava/lang/String;
    //   220: invokestatic 235	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   223: istore_2
    //   224: goto +5 -> 229
    //   227: iconst_m1
    //   228: istore_2
    //   229: aload 9
    //   231: getfield 100	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   234: astore 7
    //   236: aload 7
    //   238: ifnull +47 -> 285
    //   241: aload 7
    //   243: getfield 268	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   246: ifnull +39 -> 285
    //   249: aload 9
    //   251: getfield 100	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   254: getfield 268	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   257: getfield 274	com/tencent/mobileqq/data/MessageRecord:mExJsonObject	Lorg/json/JSONObject;
    //   260: ifnull +25 -> 285
    //   263: aload 9
    //   265: getfield 100	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   268: getfield 268	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   271: getfield 274	com/tencent/mobileqq/data/MessageRecord:mExJsonObject	Lorg/json/JSONObject;
    //   274: ldc_w 276
    //   277: invokevirtual 281	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   280: astore 7
    //   282: goto +7 -> 289
    //   285: ldc 88
    //   287: astore 7
    //   289: aload 6
    //   291: aload 9
    //   293: getfield 225	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ab	Ljava/lang/String;
    //   296: iconst_0
    //   297: iconst_4
    //   298: aload 9
    //   300: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_Long	J
    //   303: iload_2
    //   304: i2l
    //   305: ladd
    //   306: aload 7
    //   308: invokestatic 286	com/tencent/mobileqq/applets/PublicAccountEventReport:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;IIJLjava/lang/String;)V
    //   311: getstatic 291	com/tencent/biz/officialaccount/OfficialAccountReporter:a	Lcom/tencent/biz/officialaccount/OfficialAccountReporter$Reporter;
    //   314: aload 9
    //   316: aload 7
    //   318: invokevirtual 296	com/tencent/biz/officialaccount/OfficialAccountReporter$Reporter:a	(Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;Ljava/lang/String;)V
    //   321: ldc_w 298
    //   324: aload 9
    //   326: getfield 225	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ab	Ljava/lang/String;
    //   329: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   332: ifeq +65 -> 397
    //   335: aload 6
    //   337: getstatic 308	com/tencent/mobileqq/app/BusinessHandlerFactory:APOLLO_EXTENSION_HANDLER	Ljava/lang/String;
    //   340: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   343: checkcast 316	com/tencent/mobileqq/apollo/handler/IApolloExtensionHandler
    //   346: astore 7
    //   348: new 115	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   355: astore 8
    //   357: aload 8
    //   359: aload 9
    //   361: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_Long	J
    //   364: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 8
    //   370: ldc 88
    //   372: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 7
    //   378: iconst_3
    //   379: aload 8
    //   381: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: aload 9
    //   386: getfield 321	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   389: invokeinterface 324 4 0
    //   394: goto +3 -> 397
    //   397: aload 6
    //   399: astore 8
    //   401: aload 9
    //   403: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_Long	J
    //   406: lconst_0
    //   407: lcmp
    //   408: ifle +23 -> 431
    //   411: invokestatic 330	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   414: new 332	com/tencent/mobileqq/structmsg/AbsStructMsgElement$1
    //   417: dup
    //   418: aload_0
    //   419: aload 9
    //   421: aload 8
    //   423: invokespecial 335	com/tencent/mobileqq/structmsg/AbsStructMsgElement$1:<init>	(Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   426: lconst_0
    //   427: invokevirtual 341	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   430: pop
    //   431: aconst_null
    //   432: astore 7
    //   434: aload_1
    //   435: invokestatic 346	com/tencent/mobileqq/activity/aio/AIOUtils:a	(Landroid/view/View;)Lcom/tencent/mobileqq/data/ChatMessage;
    //   438: astore 6
    //   440: aload 6
    //   442: astore 7
    //   444: aload 7
    //   446: ifnull +276 -> 722
    //   449: aload 9
    //   451: getfield 100	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   454: ifnull +268 -> 722
    //   457: ldc_w 348
    //   460: aload 7
    //   462: ldc_w 350
    //   465: invokevirtual 355	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   468: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   471: ifeq +251 -> 722
    //   474: new 278	org/json/JSONObject
    //   477: dup
    //   478: invokespecial 356	org/json/JSONObject:<init>	()V
    //   481: astore 13
    //   483: aload 13
    //   485: ldc_w 358
    //   488: aload 7
    //   490: getfield 361	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   493: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   496: pop
    //   497: aload 13
    //   499: ldc_w 367
    //   502: aload 9
    //   504: getfield 369	com/tencent/mobileqq/structmsg/AbsStructMsgElement:l	Ljava/lang/String;
    //   507: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   510: pop
    //   511: aload 13
    //   513: ldc_w 371
    //   516: aload 9
    //   518: getfield 373	com/tencent/mobileqq/structmsg/AbsStructMsgElement:j	Ljava/lang/String;
    //   521: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   524: pop
    //   525: aload 13
    //   527: ldc_w 375
    //   530: aload 9
    //   532: getfield 377	com/tencent/mobileqq/structmsg/AbsStructMsgElement:k	Ljava/lang/String;
    //   535: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   538: pop
    //   539: aload 13
    //   541: ldc_w 379
    //   544: invokestatic 384	com/tencent/biz/common/util/HttpUtil:getNetWorkType	()I
    //   547: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   550: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   553: pop
    //   554: aload 13
    //   556: ldc_w 390
    //   559: invokestatic 394	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()Ljava/lang/String;
    //   562: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   565: pop
    //   566: aload 13
    //   568: ldc_w 396
    //   571: ldc 88
    //   573: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   576: pop
    //   577: aload 13
    //   579: ldc_w 398
    //   582: aload 7
    //   584: ldc_w 400
    //   587: invokevirtual 355	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   590: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   593: pop
    //   594: aload 13
    //   596: ldc_w 402
    //   599: aload 7
    //   601: ldc_w 404
    //   604: invokevirtual 355	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   607: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   610: pop
    //   611: ldc_w 406
    //   614: invokestatic 253	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   617: checkcast 406	com/tencent/biz/pubaccount/util/api/IPAReportUtil
    //   620: astore 6
    //   622: aload 7
    //   624: getfield 409	com/tencent/mobileqq/data/ChatMessage:selfuin	Ljava/lang/String;
    //   627: astore 12
    //   629: aload 13
    //   631: invokevirtual 410	org/json/JSONObject:toString	()Ljava/lang/String;
    //   634: astore 13
    //   636: new 115	java/lang/StringBuilder
    //   639: dup
    //   640: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   643: astore 14
    //   645: aload 14
    //   647: ldc 88
    //   649: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: pop
    //   653: aload 9
    //   655: getfield 100	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   658: astore 15
    //   660: aload 14
    //   662: aload 15
    //   664: getfield 413	com/tencent/mobileqq/structmsg/AbsStructMsg:msgId	J
    //   667: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload 6
    //   673: aload 8
    //   675: aload 12
    //   677: aload 13
    //   679: aload 14
    //   681: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokeinterface 417 5 0
    //   689: goto +33 -> 722
    //   692: astore 6
    //   694: goto +20 -> 714
    //   697: astore 6
    //   699: goto +15 -> 714
    //   702: astore 6
    //   704: goto +10 -> 714
    //   707: astore 6
    //   709: goto +5 -> 714
    //   712: astore 6
    //   714: aload 6
    //   716: invokevirtual 420	org/json/JSONException:printStackTrace	()V
    //   719: goto +3 -> 722
    //   722: new 422	com/tencent/mobileqq/structmsg/StructMsgClickHandler
    //   725: dup
    //   726: aload 8
    //   728: aload_1
    //   729: aload 7
    //   731: invokespecial 425	com/tencent/mobileqq/structmsg/StructMsgClickHandler:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/view/View;Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   734: astore 6
    //   736: aload 11
    //   738: invokevirtual 208	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   741: astore 11
    //   743: aload 11
    //   745: ifnull +63 -> 808
    //   748: aload 11
    //   750: invokevirtual 260	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   753: astore 11
    //   755: aload 11
    //   757: instanceof 262
    //   760: ifeq +48 -> 808
    //   763: aload 11
    //   765: checkcast 262	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie
    //   768: astore 11
    //   770: aload 11
    //   772: aload 11
    //   774: getfield 426	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:n	I
    //   777: iconst_1
    //   778: iadd
    //   779: putfield 426	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:n	I
    //   782: ldc_w 428
    //   785: aload 9
    //   787: getfield 74	com/tencent/mobileqq/structmsg/AbsStructMsgElement:c	Ljava/lang/String;
    //   790: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   793: ifeq +15 -> 808
    //   796: aload 11
    //   798: aload 11
    //   800: getfield 430	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:p	I
    //   803: iconst_1
    //   804: iadd
    //   805: putfield 430	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:p	I
    //   808: aload 7
    //   810: ifnull +23 -> 833
    //   813: aload 9
    //   815: aload 7
    //   817: getfield 361	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   820: aload 9
    //   822: getfield 321	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   825: aload 8
    //   827: invokestatic 435	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   830: putfield 321	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   833: aload 8
    //   835: aload_0
    //   836: aload 10
    //   838: checkcast 437	android/app/Activity
    //   841: invokestatic 443	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl:enterGdtCanvasActivity	(Lcom/tencent/common/app/business/BaseQQAppInterface;Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;Landroid/app/Activity;)Z
    //   844: istore 5
    //   846: iload 5
    //   848: istore 4
    //   850: iload 5
    //   852: ifne +147 -> 999
    //   855: aload 9
    //   857: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_Long	J
    //   860: lconst_0
    //   861: lcmp
    //   862: ifle +110 -> 972
    //   865: aload 7
    //   867: ifnull +66 -> 933
    //   870: ldc_w 348
    //   873: aload 7
    //   875: ldc_w 350
    //   878: invokevirtual 355	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   881: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   884: ifeq +49 -> 933
    //   887: aload 6
    //   889: aload 9
    //   891: getfield 74	com/tencent/mobileqq/structmsg/AbsStructMsgElement:c	Ljava/lang/String;
    //   894: aload 9
    //   896: getfield 321	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   899: aload 9
    //   901: getfield 76	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   904: aload 9
    //   906: getfield 78	com/tencent/mobileqq/structmsg/AbsStructMsgElement:e	Ljava/lang/String;
    //   909: aload 9
    //   911: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_Long	J
    //   914: iconst_1
    //   915: anewarray 4	java/lang/Object
    //   918: dup
    //   919: iconst_0
    //   920: iconst_1
    //   921: invokestatic 448	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   924: aastore
    //   925: invokevirtual 451	com/tencent/mobileqq/structmsg/StructMsgClickHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J[Ljava/lang/Object;)Z
    //   928: istore 4
    //   930: goto +69 -> 999
    //   933: aload 6
    //   935: aload 9
    //   937: getfield 74	com/tencent/mobileqq/structmsg/AbsStructMsgElement:c	Ljava/lang/String;
    //   940: aload 9
    //   942: getfield 321	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   945: aload 9
    //   947: getfield 76	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   950: aload 9
    //   952: getfield 78	com/tencent/mobileqq/structmsg/AbsStructMsgElement:e	Ljava/lang/String;
    //   955: aload 9
    //   957: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_Long	J
    //   960: iconst_0
    //   961: anewarray 4	java/lang/Object
    //   964: invokevirtual 451	com/tencent/mobileqq/structmsg/StructMsgClickHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J[Ljava/lang/Object;)Z
    //   967: istore 4
    //   969: goto +30 -> 999
    //   972: aload 6
    //   974: aload 9
    //   976: getfield 74	com/tencent/mobileqq/structmsg/AbsStructMsgElement:c	Ljava/lang/String;
    //   979: aload 9
    //   981: getfield 321	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   984: aload 9
    //   986: getfield 76	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   989: aload 9
    //   991: getfield 78	com/tencent/mobileqq/structmsg/AbsStructMsgElement:e	Ljava/lang/String;
    //   994: invokevirtual 454	com/tencent/mobileqq/structmsg/StructMsgClickHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   997: istore 4
    //   999: aload 9
    //   1001: getfield 100	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1004: astore 6
    //   1006: aload 6
    //   1008: ifnull +229 -> 1237
    //   1011: aload 6
    //   1013: getfield 268	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1016: ifnull +221 -> 1237
    //   1019: aload 9
    //   1021: getfield 100	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1024: getfield 457	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1027: bipush 92
    //   1029: if_icmpne +208 -> 1237
    //   1032: aload 9
    //   1034: getfield 100	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1037: getfield 460	com/tencent/mobileqq/structmsg/AbsStructMsg:mQidianBulkTaskId	Ljava/lang/String;
    //   1040: invokestatic 235	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1043: istore_2
    //   1044: aload 9
    //   1046: getfield 321	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1049: astore 6
    //   1051: invokestatic 466	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1054: ifeq +847 -> 1901
    //   1057: ldc_w 468
    //   1060: iconst_2
    //   1061: ldc_w 470
    //   1064: iconst_2
    //   1065: anewarray 4	java/lang/Object
    //   1068: dup
    //   1069: iconst_0
    //   1070: iload_2
    //   1071: invokestatic 473	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1074: aastore
    //   1075: dup
    //   1076: iconst_1
    //   1077: aload 6
    //   1079: aastore
    //   1080: invokestatic 477	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1083: invokestatic 480	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1086: goto +3 -> 1089
    //   1089: iload_2
    //   1090: ifeq +147 -> 1237
    //   1093: new 278	org/json/JSONObject
    //   1096: dup
    //   1097: invokespecial 356	org/json/JSONObject:<init>	()V
    //   1100: astore 10
    //   1102: aload 10
    //   1104: ldc_w 482
    //   1107: ldc_w 484
    //   1110: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1113: pop
    //   1114: aload 10
    //   1116: ldc_w 486
    //   1119: aload 9
    //   1121: getfield 100	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1124: getfield 268	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1127: getfield 487	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1130: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1133: pop
    //   1134: aload 10
    //   1136: ldc_w 489
    //   1139: aload 8
    //   1141: invokevirtual 492	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1144: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1147: pop
    //   1148: aload 10
    //   1150: ldc_w 494
    //   1153: aload 9
    //   1155: getfield 100	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1158: getfield 460	com/tencent/mobileqq/structmsg/AbsStructMsg:mQidianBulkTaskId	Ljava/lang/String;
    //   1161: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1164: pop
    //   1165: aload 10
    //   1167: ldc_w 496
    //   1170: aload 6
    //   1172: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1175: pop
    //   1176: aload 10
    //   1178: ldc_w 498
    //   1181: invokestatic 503	java/lang/System:currentTimeMillis	()J
    //   1184: ldc2_w 177
    //   1187: ldiv
    //   1188: invokestatic 505	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1191: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1194: pop
    //   1195: aload 8
    //   1197: getstatic 508	com/tencent/mobileqq/app/BusinessHandlerFactory:QIDIAN_HANDLER	Ljava/lang/String;
    //   1200: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1203: checkcast 510	com/tencent/qidian/controller/QidianHandler
    //   1206: aload 10
    //   1208: invokevirtual 410	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1211: aload 9
    //   1213: getfield 100	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1216: getfield 268	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1219: getfield 487	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1222: ldc 88
    //   1224: sipush 10009
    //   1227: iconst_0
    //   1228: invokevirtual 513	com/tencent/qidian/controller/QidianHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V
    //   1231: goto +6 -> 1237
    //   1234: goto +3 -> 1237
    //   1237: aload 9
    //   1239: getfield 78	com/tencent/mobileqq/structmsg/AbsStructMsgElement:e	Ljava/lang/String;
    //   1242: aload 9
    //   1244: getfield 76	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   1247: aload 9
    //   1249: getfield 321	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1252: invokestatic 518	com/tencent/qidian/QidianManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   1255: ifeq +123 -> 1378
    //   1258: aload 8
    //   1260: getstatic 523	com/tencent/mobileqq/app/QQManagerFactory:QIDIAN_MANAGER	I
    //   1263: invokevirtual 527	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1266: checkcast 515	com/tencent/qidian/QidianManager
    //   1269: astore 10
    //   1271: aload 9
    //   1273: instanceof 529
    //   1276: ifeq +70 -> 1346
    //   1279: aload 9
    //   1281: checkcast 529	com/tencent/mobileqq/structmsg/StructMsgGroupItemElement
    //   1284: getfield 532	com/tencent/mobileqq/structmsg/StructMsgGroupItemElement:a	Ljava/util/List;
    //   1287: astore 6
    //   1289: aload 6
    //   1291: ifnull +55 -> 1346
    //   1294: aload 6
    //   1296: invokeinterface 538 1 0
    //   1301: astore 6
    //   1303: aload 6
    //   1305: invokeinterface 543 1 0
    //   1310: ifeq +36 -> 1346
    //   1313: aload 6
    //   1315: invokeinterface 546 1 0
    //   1320: checkcast 2	com/tencent/mobileqq/structmsg/AbsStructMsgElement
    //   1323: astore 11
    //   1325: aload 11
    //   1327: instanceof 548
    //   1330: ifeq -27 -> 1303
    //   1333: aload 11
    //   1335: checkcast 548	com/tencent/mobileqq/structmsg/view/StructMsgItemSummary
    //   1338: getfield 551	com/tencent/mobileqq/structmsg/view/StructMsgItemSummary:ai	Ljava/lang/String;
    //   1341: astore 6
    //   1343: goto +7 -> 1350
    //   1346: ldc 88
    //   1348: astore 6
    //   1350: aload 10
    //   1352: aload 9
    //   1354: getfield 74	com/tencent/mobileqq/structmsg/AbsStructMsgElement:c	Ljava/lang/String;
    //   1357: aload 9
    //   1359: getfield 78	com/tencent/mobileqq/structmsg/AbsStructMsgElement:e	Ljava/lang/String;
    //   1362: aload 9
    //   1364: getfield 76	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   1367: aload 9
    //   1369: getfield 321	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1372: iconst_2
    //   1373: aload 6
    //   1375: invokevirtual 554	com/tencent/qidian/QidianManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   1378: iload 4
    //   1380: ifeq +8 -> 1388
    //   1383: iconst_1
    //   1384: istore_2
    //   1385: goto +5 -> 1390
    //   1388: iconst_0
    //   1389: istore_2
    //   1390: aload 9
    //   1392: getfield 92	com/tencent/mobileqq/structmsg/AbsStructMsgElement:aa	Ljava/lang/String;
    //   1395: invokestatic 235	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1398: istore_3
    //   1399: goto +5 -> 1404
    //   1402: iconst_m1
    //   1403: istore_3
    //   1404: aload 9
    //   1406: getfield 225	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ab	Ljava/lang/String;
    //   1409: astore 6
    //   1411: new 115	java/lang/StringBuilder
    //   1414: dup
    //   1415: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1418: astore 10
    //   1420: aload 10
    //   1422: ldc 88
    //   1424: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: pop
    //   1428: aload 10
    //   1430: aload 9
    //   1432: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_Long	J
    //   1435: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1438: pop
    //   1439: aload 8
    //   1441: ldc 221
    //   1443: ldc 223
    //   1445: aload 6
    //   1447: ldc_w 556
    //   1450: ldc_w 556
    //   1453: iload_3
    //   1454: iload_2
    //   1455: aload 10
    //   1457: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1460: aload 9
    //   1462: getfield 90	com/tencent/mobileqq/structmsg/AbsStructMsgElement:Z	Ljava/lang/String;
    //   1465: ldc 88
    //   1467: aload 9
    //   1469: getfield 321	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1472: invokestatic 245	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1475: new 115	java/lang/StringBuilder
    //   1478: dup
    //   1479: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1482: astore 6
    //   1484: aload 6
    //   1486: ldc_w 558
    //   1489: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: pop
    //   1493: aload 6
    //   1495: aload 9
    //   1497: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_Long	J
    //   1500: invokestatic 240	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1503: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: pop
    //   1507: aload 6
    //   1509: ldc_w 560
    //   1512: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1515: pop
    //   1516: aload 6
    //   1518: aload 9
    //   1520: getfield 90	com/tencent/mobileqq/structmsg/AbsStructMsgElement:Z	Ljava/lang/String;
    //   1523: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: pop
    //   1527: aload 6
    //   1529: ldc_w 562
    //   1532: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: pop
    //   1536: aload 6
    //   1538: ldc 88
    //   1540: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: pop
    //   1544: aload 6
    //   1546: ldc_w 564
    //   1549: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1552: pop
    //   1553: aload 6
    //   1555: aload 9
    //   1557: getfield 321	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1560: invokestatic 566	com/tencent/mobileqq/structmsg/AbsStructMsgElement:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1563: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: pop
    //   1567: aload 8
    //   1569: ldc 221
    //   1571: ldc 223
    //   1573: aload 9
    //   1575: getfield 225	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ab	Ljava/lang/String;
    //   1578: ldc_w 568
    //   1581: ldc_w 568
    //   1584: iload_3
    //   1585: iload_2
    //   1586: aload 6
    //   1588: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1591: ldc 88
    //   1593: ldc 88
    //   1595: ldc 88
    //   1597: invokestatic 245	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1600: aload 7
    //   1602: ifnonnull +6 -> 1608
    //   1605: goto +263 -> 1868
    //   1608: aload 7
    //   1610: ldc_w 400
    //   1613: invokevirtual 355	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1616: astore 6
    //   1618: aload 6
    //   1620: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1623: ifne +177 -> 1800
    //   1626: new 278	org/json/JSONObject
    //   1629: dup
    //   1630: invokespecial 356	org/json/JSONObject:<init>	()V
    //   1633: astore 10
    //   1635: aload 9
    //   1637: getfield 225	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ab	Ljava/lang/String;
    //   1640: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1643: ifne +20 -> 1663
    //   1646: aload 10
    //   1648: ldc_w 358
    //   1651: aload 9
    //   1653: getfield 225	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ab	Ljava/lang/String;
    //   1656: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1659: pop
    //   1660: goto +17 -> 1677
    //   1663: aload 10
    //   1665: ldc_w 358
    //   1668: aload 7
    //   1670: getfield 361	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   1673: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1676: pop
    //   1677: aload 10
    //   1679: ldc_w 371
    //   1682: iload_3
    //   1683: i2l
    //   1684: invokestatic 240	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1687: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1690: pop
    //   1691: aload 10
    //   1693: ldc_w 398
    //   1696: aload 6
    //   1698: invokevirtual 365	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1701: pop
    //   1702: goto +10 -> 1712
    //   1705: astore 6
    //   1707: aload 6
    //   1709: invokevirtual 420	org/json/JSONException:printStackTrace	()V
    //   1712: new 570	java/util/ArrayList
    //   1715: dup
    //   1716: invokespecial 571	java/util/ArrayList:<init>	()V
    //   1719: aload 9
    //   1721: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_a_of_type_Long	J
    //   1724: invokestatic 505	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1727: invokeinterface 574 2 0
    //   1732: pop
    //   1733: aload 7
    //   1735: ldc_w 576
    //   1738: invokevirtual 355	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1741: astore 6
    //   1743: aload 7
    //   1745: ldc_w 578
    //   1748: invokevirtual 355	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1751: astore 10
    //   1753: aload 7
    //   1755: ldc_w 580
    //   1758: invokevirtual 355	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1761: astore 11
    //   1763: aload 6
    //   1765: ldc_w 348
    //   1768: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1771: ifeq +6 -> 1777
    //   1774: goto +26 -> 1800
    //   1777: aload 10
    //   1779: ldc_w 348
    //   1782: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1785: ifeq +6 -> 1791
    //   1788: goto +12 -> 1800
    //   1791: aload 11
    //   1793: ldc_w 348
    //   1796: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1799: pop
    //   1800: aload 8
    //   1802: getstatic 583	com/tencent/mobileqq/app/QQManagerFactory:EC_SHOP_ASSISTANT_MANAGER	I
    //   1805: invokevirtual 527	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1808: checkcast 432	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager
    //   1811: astore 6
    //   1813: aload 8
    //   1815: getstatic 586	com/tencent/mobileqq/app/BusinessHandlerFactory:EC_SHOP_REPORT_HANDLER	Ljava/lang/String;
    //   1818: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1821: checkcast 588	com/tencent/biz/pubaccount/ecshopassit/EcshopReportHandler
    //   1824: astore 8
    //   1826: aload 7
    //   1828: ifnull +40 -> 1868
    //   1831: aload 6
    //   1833: ifnull +35 -> 1868
    //   1836: aload 8
    //   1838: ifnull +30 -> 1868
    //   1841: aload 6
    //   1843: aload 7
    //   1845: getfield 591	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   1848: invokevirtual 592	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:a	(Ljava/lang/String;)Z
    //   1851: ifeq +17 -> 1868
    //   1854: aload 8
    //   1856: iconst_0
    //   1857: aload 7
    //   1859: iload_3
    //   1860: aload 9
    //   1862: getfield 321	com/tencent/mobileqq/structmsg/AbsStructMsgElement:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1865: invokevirtual 595	com/tencent/biz/pubaccount/ecshopassit/EcshopReportHandler:a	(ZLcom/tencent/mobileqq/data/MessageRecord;ILjava/lang/String;)V
    //   1868: invokestatic 601	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   1871: aload_1
    //   1872: invokevirtual 604	com/tencent/qqlive/module/videoreport/collect/EventCollector:onViewClicked	(Landroid/view/View;)V
    //   1875: return
    //   1876: astore 7
    //   1878: goto -1651 -> 227
    //   1881: astore 6
    //   1883: goto -1439 -> 444
    //   1886: astore 6
    //   1888: goto -651 -> 1237
    //   1891: astore 6
    //   1893: goto -659 -> 1234
    //   1896: astore 6
    //   1898: goto -496 -> 1402
    //   1901: goto -812 -> 1089
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1904	0	this	AbsStructMsgElement
    //   0	1904	1	paramView	View
    //   223	1363	2	i1	int
    //   1398	462	3	i2	int
    //   848	531	4	bool1	boolean
    //   844	7	5	bool2	boolean
    //   29	643	6	localObject1	Object
    //   692	1	6	localJSONException1	org.json.JSONException
    //   697	1	6	localJSONException2	org.json.JSONException
    //   702	1	6	localJSONException3	org.json.JSONException
    //   707	1	6	localJSONException4	org.json.JSONException
    //   712	3	6	localJSONException5	org.json.JSONException
    //   734	963	6	localObject2	Object
    //   1705	3	6	localJSONException6	org.json.JSONException
    //   1741	101	6	localObject3	Object
    //   1881	1	6	localClassCastException	java.lang.ClassCastException
    //   1886	1	6	localException1	java.lang.Exception
    //   1891	1	6	localException2	java.lang.Exception
    //   1896	1	6	localException3	java.lang.Exception
    //   234	1624	7	localObject4	Object
    //   1876	1	7	localNumberFormatException	java.lang.NumberFormatException
    //   355	1500	8	localObject5	Object
    //   51	1810	9	localAbsStructMsgElement	AbsStructMsgElement
    //   57	1721	10	localObject6	Object
    //   84	1708	11	localObject7	Object
    //   627	49	12	str	String
    //   481	197	13	localObject8	Object
    //   643	37	14	localStringBuilder	StringBuilder
    //   658	5	15	localAbsStructMsg	AbsStructMsg
    // Exception table:
    //   from	to	target	type
    //   660	689	692	org/json/JSONException
    //   653	660	697	org/json/JSONException
    //   636	653	702	org/json/JSONException
    //   497	636	707	org/json/JSONException
    //   474	497	712	org/json/JSONException
    //   1635	1660	1705	org/json/JSONException
    //   1663	1677	1705	org/json/JSONException
    //   1677	1702	1705	org/json/JSONException
    //   216	224	1876	java/lang/NumberFormatException
    //   434	440	1881	java/lang/ClassCastException
    //   1019	1057	1886	java/lang/Exception
    //   1057	1086	1891	java/lang/Exception
    //   1093	1231	1891	java/lang/Exception
    //   1390	1399	1896	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgElement
 * JD-Core Version:    0.7.0.1
 */