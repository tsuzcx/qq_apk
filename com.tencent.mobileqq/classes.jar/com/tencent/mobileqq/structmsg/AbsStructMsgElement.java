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
  public int F;
  public String G;
  public String H;
  public String I;
  public String J;
  public String K;
  public String L;
  public String M;
  public String N;
  public String O;
  public int P;
  public String Q;
  public String R;
  public String S;
  public String T;
  public String U;
  public int V;
  public int W;
  public String X;
  public String Y;
  public String Z;
  public int a = 18;
  public int aa;
  public int ab;
  public int ac;
  public int ad;
  public String ae;
  public String af;
  public String ag;
  public String ah;
  public String ai;
  public String aj;
  public String ak;
  public int al;
  public String am = "";
  public String an = null;
  public long ao = 0L;
  public String ap;
  public int aq = -1;
  public WeakReference<OnLongClickAndTouchListener> ar = null;
  public AbsStructMsg as = null;
  long at = -1L;
  public String b;
  int c;
  public String d;
  public String e = null;
  public String f = null;
  public String g = null;
  public String h = null;
  public String i = null;
  public String j = null;
  public String k = null;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public int t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public int z;
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    Object localObject = paramString;
    if (!URLUtil.e(paramString))
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
    return this.c;
  }
  
  public abstract View a(Context paramContext, View paramView, Bundle paramBundle);
  
  public void a(AbsShareMsg paramAbsShareMsg) {}
  
  public void a(ObjectInput paramObjectInput)
  {
    this.a = paramObjectInput.readInt();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.b);
    paramObjectOutput.writeInt(this.a);
  }
  
  public abstract void a(XmlSerializer paramXmlSerializer);
  
  public boolean a(int paramInt)
  {
    return (this.c & paramInt) == paramInt;
  }
  
  public abstract boolean a(StructMsgNode paramStructMsgNode);
  
  public abstract String b();
  
  public void b(int paramInt)
  {
    int i1 = this.c;
    if ((i1 & paramInt) == 0) {
      this.c = (paramInt | i1);
    }
  }
  
  /* Error */
  public void onClick(View paramView)
  {
    // Byte code:
    //   0: invokestatic 194	android/os/SystemClock:uptimeMillis	()J
    //   3: aload_0
    //   4: getfield 122	com/tencent/mobileqq/structmsg/AbsStructMsgElement:at	J
    //   7: lsub
    //   8: ldc2_w 195
    //   11: lcmp
    //   12: ifge +6 -> 18
    //   15: goto +1854 -> 1869
    //   18: aload_0
    //   19: invokestatic 194	android/os/SystemClock:uptimeMillis	()J
    //   22: putfield 122	com/tencent/mobileqq/structmsg/AbsStructMsgElement:at	J
    //   25: aload_1
    //   26: invokevirtual 202	android/view/View:getTag	()Ljava/lang/Object;
    //   29: astore 6
    //   31: aload_0
    //   32: invokevirtual 206	java/lang/Object:getClass	()Ljava/lang/Class;
    //   35: aload 6
    //   37: invokevirtual 212	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   40: ifne +6 -> 46
    //   43: goto +1826 -> 1869
    //   46: aload 6
    //   48: checkcast 2	com/tencent/mobileqq/structmsg/AbsStructMsgElement
    //   51: astore 9
    //   53: aload_1
    //   54: invokevirtual 216	android/view/View:getContext	()Landroid/content/Context;
    //   57: astore 10
    //   59: ldc 218
    //   61: aload 10
    //   63: invokevirtual 212	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   66: ifne +13 -> 79
    //   69: ldc 220
    //   71: aload 10
    //   73: invokevirtual 212	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   76: ifeq +1793 -> 1869
    //   79: aload 10
    //   81: checkcast 222	com/tencent/mobileqq/app/BaseActivity
    //   84: astore 11
    //   86: aload 11
    //   88: invokevirtual 226	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   91: ifnonnull +6 -> 97
    //   94: goto +1775 -> 1869
    //   97: aload 11
    //   99: invokevirtual 226	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   102: invokevirtual 231	com/tencent/mobileqq/activity/ChatFragment:j	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   105: astore 6
    //   107: aload 9
    //   109: getfield 112	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ao	J
    //   112: lconst_0
    //   113: lcmp
    //   114: ifle +57 -> 171
    //   117: aload 9
    //   119: getfield 110	com/tencent/mobileqq/structmsg/AbsStructMsgElement:an	Ljava/lang/String;
    //   122: invokestatic 237	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifne +46 -> 171
    //   128: aload 6
    //   130: ldc 239
    //   132: ldc 241
    //   134: aload 9
    //   136: getfield 243	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ap	Ljava/lang/String;
    //   139: ldc 245
    //   141: ldc 247
    //   143: aload_0
    //   144: getfield 110	com/tencent/mobileqq/structmsg/AbsStructMsgElement:an	Ljava/lang/String;
    //   147: invokestatic 253	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   150: iconst_0
    //   151: ldc 106
    //   153: ldc 106
    //   155: aload 9
    //   157: getfield 112	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ao	J
    //   160: invokestatic 258	java/lang/Long:toString	(J)Ljava/lang/String;
    //   163: ldc 106
    //   165: invokestatic 263	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   168: goto +3 -> 171
    //   171: ldc_w 265
    //   174: invokestatic 271	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   177: checkcast 265	com/tencent/mobileqq/kandian/biz/common/api/IReadInJoySPEventReport
    //   180: aload 9
    //   182: getfield 243	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ap	Ljava/lang/String;
    //   185: aload 9
    //   187: invokeinterface 275 3 0
    //   192: aload 11
    //   194: invokevirtual 226	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   197: invokevirtual 278	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   200: instanceof 280
    //   203: ifeq +195 -> 398
    //   206: aload 9
    //   208: getfield 110	com/tencent/mobileqq/structmsg/AbsStructMsgElement:an	Ljava/lang/String;
    //   211: invokestatic 237	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   214: ifne +14 -> 228
    //   217: aload_0
    //   218: getfield 110	com/tencent/mobileqq/structmsg/AbsStructMsgElement:an	Ljava/lang/String;
    //   221: invokestatic 253	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   224: istore_2
    //   225: goto +5 -> 230
    //   228: iconst_m1
    //   229: istore_2
    //   230: aload 9
    //   232: getfield 118	com/tencent/mobileqq/structmsg/AbsStructMsgElement:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   235: astore 7
    //   237: aload 7
    //   239: ifnull +47 -> 286
    //   242: aload 7
    //   244: getfield 286	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   247: ifnull +39 -> 286
    //   250: aload 9
    //   252: getfield 118	com/tencent/mobileqq/structmsg/AbsStructMsgElement:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   255: getfield 286	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   258: getfield 292	com/tencent/mobileqq/data/MessageRecord:mExJsonObject	Lorg/json/JSONObject;
    //   261: ifnull +25 -> 286
    //   264: aload 9
    //   266: getfield 118	com/tencent/mobileqq/structmsg/AbsStructMsgElement:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   269: getfield 286	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   272: getfield 292	com/tencent/mobileqq/data/MessageRecord:mExJsonObject	Lorg/json/JSONObject;
    //   275: ldc_w 294
    //   278: invokevirtual 299	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   281: astore 7
    //   283: goto +7 -> 290
    //   286: ldc 106
    //   288: astore 7
    //   290: aload 6
    //   292: aload 9
    //   294: getfield 243	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ap	Ljava/lang/String;
    //   297: iconst_0
    //   298: iconst_4
    //   299: aload 9
    //   301: getfield 112	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ao	J
    //   304: iload_2
    //   305: i2l
    //   306: ladd
    //   307: aload 7
    //   309: invokestatic 304	com/tencent/mobileqq/applets/PublicAccountEventReport:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;IIJLjava/lang/String;)V
    //   312: getstatic 309	com/tencent/biz/officialaccount/OfficialAccountReporter:a	Lcom/tencent/biz/officialaccount/OfficialAccountReporter$Reporter;
    //   315: aload 9
    //   317: aload 7
    //   319: invokevirtual 314	com/tencent/biz/officialaccount/OfficialAccountReporter$Reporter:a	(Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;Ljava/lang/String;)V
    //   322: ldc_w 316
    //   325: aload 9
    //   327: getfield 243	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ap	Ljava/lang/String;
    //   330: invokevirtual 321	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   333: ifeq +65 -> 398
    //   336: aload 6
    //   338: getstatic 326	com/tencent/mobileqq/app/BusinessHandlerFactory:APOLLO_EXTENSION_HANDLER	Ljava/lang/String;
    //   341: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   344: checkcast 334	com/tencent/mobileqq/apollo/handler/IApolloExtensionHandler
    //   347: astore 7
    //   349: new 133	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   356: astore 8
    //   358: aload 8
    //   360: aload 9
    //   362: getfield 112	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ao	J
    //   365: invokevirtual 337	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 8
    //   371: ldc 106
    //   373: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload 7
    //   379: iconst_3
    //   380: aload 8
    //   382: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: aload 9
    //   387: getfield 339	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   390: invokeinterface 342 4 0
    //   395: goto +3 -> 398
    //   398: aload 6
    //   400: astore 8
    //   402: aload 9
    //   404: getfield 112	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ao	J
    //   407: lconst_0
    //   408: lcmp
    //   409: ifle +23 -> 432
    //   412: invokestatic 348	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   415: new 350	com/tencent/mobileqq/structmsg/AbsStructMsgElement$1
    //   418: dup
    //   419: aload_0
    //   420: aload 9
    //   422: aload 8
    //   424: invokespecial 353	com/tencent/mobileqq/structmsg/AbsStructMsgElement$1:<init>	(Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   427: lconst_0
    //   428: invokevirtual 359	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   431: pop
    //   432: aconst_null
    //   433: astore 7
    //   435: aload_1
    //   436: invokestatic 364	com/tencent/mobileqq/activity/aio/AIOUtils:a	(Landroid/view/View;)Lcom/tencent/mobileqq/data/ChatMessage;
    //   439: astore 6
    //   441: aload 6
    //   443: astore 7
    //   445: aload 7
    //   447: ifnull +276 -> 723
    //   450: aload 9
    //   452: getfield 118	com/tencent/mobileqq/structmsg/AbsStructMsgElement:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   455: ifnull +268 -> 723
    //   458: ldc_w 366
    //   461: aload 7
    //   463: ldc_w 368
    //   466: invokevirtual 373	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   469: invokevirtual 321	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   472: ifeq +251 -> 723
    //   475: new 296	org/json/JSONObject
    //   478: dup
    //   479: invokespecial 374	org/json/JSONObject:<init>	()V
    //   482: astore 13
    //   484: aload 13
    //   486: ldc_w 376
    //   489: aload 7
    //   491: getfield 379	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   494: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   497: pop
    //   498: aload 13
    //   500: ldc_w 385
    //   503: aload 9
    //   505: getfield 387	com/tencent/mobileqq/structmsg/AbsStructMsgElement:n	Ljava/lang/String;
    //   508: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   511: pop
    //   512: aload 13
    //   514: ldc_w 389
    //   517: aload 9
    //   519: getfield 391	com/tencent/mobileqq/structmsg/AbsStructMsgElement:l	Ljava/lang/String;
    //   522: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   525: pop
    //   526: aload 13
    //   528: ldc_w 393
    //   531: aload 9
    //   533: getfield 395	com/tencent/mobileqq/structmsg/AbsStructMsgElement:m	Ljava/lang/String;
    //   536: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   539: pop
    //   540: aload 13
    //   542: ldc_w 397
    //   545: invokestatic 402	com/tencent/biz/common/util/HttpUtil:getNetWorkType	()I
    //   548: invokestatic 406	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   551: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   554: pop
    //   555: aload 13
    //   557: ldc_w 408
    //   560: invokestatic 412	com/tencent/mobileqq/utils/DeviceInfoUtil:b	()Ljava/lang/String;
    //   563: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   566: pop
    //   567: aload 13
    //   569: ldc_w 414
    //   572: ldc 106
    //   574: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   577: pop
    //   578: aload 13
    //   580: ldc_w 416
    //   583: aload 7
    //   585: ldc_w 418
    //   588: invokevirtual 373	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   591: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   594: pop
    //   595: aload 13
    //   597: ldc_w 420
    //   600: aload 7
    //   602: ldc_w 422
    //   605: invokevirtual 373	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   608: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   611: pop
    //   612: ldc_w 424
    //   615: invokestatic 271	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   618: checkcast 424	com/tencent/biz/pubaccount/util/api/IPAReportUtil
    //   621: astore 6
    //   623: aload 7
    //   625: getfield 427	com/tencent/mobileqq/data/ChatMessage:selfuin	Ljava/lang/String;
    //   628: astore 12
    //   630: aload 13
    //   632: invokevirtual 428	org/json/JSONObject:toString	()Ljava/lang/String;
    //   635: astore 13
    //   637: new 133	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   644: astore 14
    //   646: aload 14
    //   648: ldc 106
    //   650: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: aload 9
    //   656: getfield 118	com/tencent/mobileqq/structmsg/AbsStructMsgElement:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   659: astore 15
    //   661: aload 14
    //   663: aload 15
    //   665: getfield 431	com/tencent/mobileqq/structmsg/AbsStructMsg:msgId	J
    //   668: invokevirtual 337	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload 6
    //   674: aload 8
    //   676: aload 12
    //   678: aload 13
    //   680: aload 14
    //   682: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: invokeinterface 435 5 0
    //   690: goto +33 -> 723
    //   693: astore 6
    //   695: goto +20 -> 715
    //   698: astore 6
    //   700: goto +15 -> 715
    //   703: astore 6
    //   705: goto +10 -> 715
    //   708: astore 6
    //   710: goto +5 -> 715
    //   713: astore 6
    //   715: aload 6
    //   717: invokevirtual 438	org/json/JSONException:printStackTrace	()V
    //   720: goto +3 -> 723
    //   723: new 440	com/tencent/mobileqq/structmsg/StructMsgClickHandler
    //   726: dup
    //   727: aload 8
    //   729: aload_1
    //   730: aload 7
    //   732: invokespecial 443	com/tencent/mobileqq/structmsg/StructMsgClickHandler:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/view/View;Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   735: astore 6
    //   737: aload 11
    //   739: invokevirtual 226	com/tencent/mobileqq/app/BaseActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   742: astore 11
    //   744: aload 11
    //   746: ifnull +63 -> 809
    //   749: aload 11
    //   751: invokevirtual 278	com/tencent/mobileqq/activity/ChatFragment:k	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   754: astore 11
    //   756: aload 11
    //   758: instanceof 280
    //   761: ifeq +48 -> 809
    //   764: aload 11
    //   766: checkcast 280	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie
    //   769: astore 11
    //   771: aload 11
    //   773: aload 11
    //   775: getfield 446	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:ca	I
    //   778: iconst_1
    //   779: iadd
    //   780: putfield 446	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:ca	I
    //   783: ldc_w 448
    //   786: aload 9
    //   788: getfield 92	com/tencent/mobileqq/structmsg/AbsStructMsgElement:e	Ljava/lang/String;
    //   791: invokevirtual 321	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   794: ifeq +15 -> 809
    //   797: aload 11
    //   799: aload 11
    //   801: getfield 451	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:cc	I
    //   804: iconst_1
    //   805: iadd
    //   806: putfield 451	com/tencent/mobileqq/activity/aio/rebuild/PublicAccountChatPie:cc	I
    //   809: aload 7
    //   811: ifnull +23 -> 834
    //   814: aload 9
    //   816: aload 7
    //   818: getfield 379	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   821: aload 9
    //   823: getfield 339	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   826: aload 8
    //   828: invokestatic 456	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   831: putfield 339	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   834: aload 8
    //   836: aload_0
    //   837: aload 10
    //   839: checkcast 458	android/app/Activity
    //   842: invokestatic 464	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl:enterGdtCanvasActivity	(Lcom/tencent/common/app/business/BaseQQAppInterface;Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;Landroid/app/Activity;)Z
    //   845: istore 5
    //   847: iload 5
    //   849: istore 4
    //   851: iload 5
    //   853: ifne +147 -> 1000
    //   856: aload 9
    //   858: getfield 112	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ao	J
    //   861: lconst_0
    //   862: lcmp
    //   863: ifle +110 -> 973
    //   866: aload 7
    //   868: ifnull +66 -> 934
    //   871: ldc_w 366
    //   874: aload 7
    //   876: ldc_w 368
    //   879: invokevirtual 373	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   882: invokevirtual 321	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   885: ifeq +49 -> 934
    //   888: aload 6
    //   890: aload 9
    //   892: getfield 92	com/tencent/mobileqq/structmsg/AbsStructMsgElement:e	Ljava/lang/String;
    //   895: aload 9
    //   897: getfield 339	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   900: aload 9
    //   902: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:f	Ljava/lang/String;
    //   905: aload 9
    //   907: getfield 96	com/tencent/mobileqq/structmsg/AbsStructMsgElement:g	Ljava/lang/String;
    //   910: aload 9
    //   912: getfield 112	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ao	J
    //   915: iconst_1
    //   916: anewarray 4	java/lang/Object
    //   919: dup
    //   920: iconst_0
    //   921: iconst_1
    //   922: invokestatic 469	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   925: aastore
    //   926: invokevirtual 472	com/tencent/mobileqq/structmsg/StructMsgClickHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J[Ljava/lang/Object;)Z
    //   929: istore 4
    //   931: goto +69 -> 1000
    //   934: aload 6
    //   936: aload 9
    //   938: getfield 92	com/tencent/mobileqq/structmsg/AbsStructMsgElement:e	Ljava/lang/String;
    //   941: aload 9
    //   943: getfield 339	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   946: aload 9
    //   948: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:f	Ljava/lang/String;
    //   951: aload 9
    //   953: getfield 96	com/tencent/mobileqq/structmsg/AbsStructMsgElement:g	Ljava/lang/String;
    //   956: aload 9
    //   958: getfield 112	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ao	J
    //   961: iconst_0
    //   962: anewarray 4	java/lang/Object
    //   965: invokevirtual 472	com/tencent/mobileqq/structmsg/StructMsgClickHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J[Ljava/lang/Object;)Z
    //   968: istore 4
    //   970: goto +30 -> 1000
    //   973: aload 6
    //   975: aload 9
    //   977: getfield 92	com/tencent/mobileqq/structmsg/AbsStructMsgElement:e	Ljava/lang/String;
    //   980: aload 9
    //   982: getfield 339	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   985: aload 9
    //   987: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:f	Ljava/lang/String;
    //   990: aload 9
    //   992: getfield 96	com/tencent/mobileqq/structmsg/AbsStructMsgElement:g	Ljava/lang/String;
    //   995: invokevirtual 475	com/tencent/mobileqq/structmsg/StructMsgClickHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   998: istore 4
    //   1000: aload 9
    //   1002: getfield 118	com/tencent/mobileqq/structmsg/AbsStructMsgElement:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1005: astore 6
    //   1007: aload 6
    //   1009: ifnull +229 -> 1238
    //   1012: aload 6
    //   1014: getfield 286	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1017: ifnull +221 -> 1238
    //   1020: aload 9
    //   1022: getfield 118	com/tencent/mobileqq/structmsg/AbsStructMsgElement:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1025: getfield 478	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1028: bipush 92
    //   1030: if_icmpne +208 -> 1238
    //   1033: aload 9
    //   1035: getfield 118	com/tencent/mobileqq/structmsg/AbsStructMsgElement:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1038: getfield 481	com/tencent/mobileqq/structmsg/AbsStructMsg:mQidianBulkTaskId	Ljava/lang/String;
    //   1041: invokestatic 253	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1044: istore_2
    //   1045: aload 9
    //   1047: getfield 339	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   1050: astore 6
    //   1052: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1055: ifeq +847 -> 1902
    //   1058: ldc_w 489
    //   1061: iconst_2
    //   1062: ldc_w 491
    //   1065: iconst_2
    //   1066: anewarray 4	java/lang/Object
    //   1069: dup
    //   1070: iconst_0
    //   1071: iload_2
    //   1072: invokestatic 494	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1075: aastore
    //   1076: dup
    //   1077: iconst_1
    //   1078: aload 6
    //   1080: aastore
    //   1081: invokestatic 498	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1084: invokestatic 501	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1087: goto +3 -> 1090
    //   1090: iload_2
    //   1091: ifeq +147 -> 1238
    //   1094: new 296	org/json/JSONObject
    //   1097: dup
    //   1098: invokespecial 374	org/json/JSONObject:<init>	()V
    //   1101: astore 10
    //   1103: aload 10
    //   1105: ldc_w 503
    //   1108: ldc_w 505
    //   1111: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1114: pop
    //   1115: aload 10
    //   1117: ldc_w 507
    //   1120: aload 9
    //   1122: getfield 118	com/tencent/mobileqq/structmsg/AbsStructMsgElement:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1125: getfield 286	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1128: getfield 508	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1131: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1134: pop
    //   1135: aload 10
    //   1137: ldc_w 510
    //   1140: aload 8
    //   1142: invokevirtual 513	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1145: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1148: pop
    //   1149: aload 10
    //   1151: ldc_w 515
    //   1154: aload 9
    //   1156: getfield 118	com/tencent/mobileqq/structmsg/AbsStructMsgElement:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1159: getfield 481	com/tencent/mobileqq/structmsg/AbsStructMsg:mQidianBulkTaskId	Ljava/lang/String;
    //   1162: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1165: pop
    //   1166: aload 10
    //   1168: ldc_w 517
    //   1171: aload 6
    //   1173: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1176: pop
    //   1177: aload 10
    //   1179: ldc_w 519
    //   1182: invokestatic 524	java/lang/System:currentTimeMillis	()J
    //   1185: ldc2_w 195
    //   1188: ldiv
    //   1189: invokestatic 526	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1192: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1195: pop
    //   1196: aload 8
    //   1198: getstatic 529	com/tencent/mobileqq/app/BusinessHandlerFactory:QIDIAN_HANDLER	Ljava/lang/String;
    //   1201: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1204: checkcast 531	com/tencent/qidian/controller/QidianHandler
    //   1207: aload 10
    //   1209: invokevirtual 428	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1212: aload 9
    //   1214: getfield 118	com/tencent/mobileqq/structmsg/AbsStructMsgElement:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1217: getfield 286	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1220: getfield 508	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1223: ldc 106
    //   1225: sipush 10009
    //   1228: iconst_0
    //   1229: invokevirtual 534	com/tencent/qidian/controller/QidianHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V
    //   1232: goto +6 -> 1238
    //   1235: goto +3 -> 1238
    //   1238: aload 9
    //   1240: getfield 96	com/tencent/mobileqq/structmsg/AbsStructMsgElement:g	Ljava/lang/String;
    //   1243: aload 9
    //   1245: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:f	Ljava/lang/String;
    //   1248: aload 9
    //   1250: getfield 339	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   1253: invokestatic 539	com/tencent/qidian/QidianManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   1256: ifeq +123 -> 1379
    //   1259: aload 8
    //   1261: getstatic 544	com/tencent/mobileqq/app/QQManagerFactory:QIDIAN_MANAGER	I
    //   1264: invokevirtual 548	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1267: checkcast 536	com/tencent/qidian/QidianManager
    //   1270: astore 10
    //   1272: aload 9
    //   1274: instanceof 550
    //   1277: ifeq +70 -> 1347
    //   1280: aload 9
    //   1282: checkcast 550	com/tencent/mobileqq/structmsg/StructMsgGroupItemElement
    //   1285: getfield 554	com/tencent/mobileqq/structmsg/StructMsgGroupItemElement:au	Ljava/util/List;
    //   1288: astore 6
    //   1290: aload 6
    //   1292: ifnull +55 -> 1347
    //   1295: aload 6
    //   1297: invokeinterface 560 1 0
    //   1302: astore 6
    //   1304: aload 6
    //   1306: invokeinterface 565 1 0
    //   1311: ifeq +36 -> 1347
    //   1314: aload 6
    //   1316: invokeinterface 568 1 0
    //   1321: checkcast 2	com/tencent/mobileqq/structmsg/AbsStructMsgElement
    //   1324: astore 11
    //   1326: aload 11
    //   1328: instanceof 570
    //   1331: ifeq -27 -> 1304
    //   1334: aload 11
    //   1336: checkcast 570	com/tencent/mobileqq/structmsg/view/StructMsgItemSummary
    //   1339: getfield 573	com/tencent/mobileqq/structmsg/view/StructMsgItemSummary:aA	Ljava/lang/String;
    //   1342: astore 6
    //   1344: goto +7 -> 1351
    //   1347: ldc 106
    //   1349: astore 6
    //   1351: aload 10
    //   1353: aload 9
    //   1355: getfield 92	com/tencent/mobileqq/structmsg/AbsStructMsgElement:e	Ljava/lang/String;
    //   1358: aload 9
    //   1360: getfield 96	com/tencent/mobileqq/structmsg/AbsStructMsgElement:g	Ljava/lang/String;
    //   1363: aload 9
    //   1365: getfield 94	com/tencent/mobileqq/structmsg/AbsStructMsgElement:f	Ljava/lang/String;
    //   1368: aload 9
    //   1370: getfield 339	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   1373: iconst_2
    //   1374: aload 6
    //   1376: invokevirtual 576	com/tencent/qidian/QidianManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   1379: iload 4
    //   1381: ifeq +8 -> 1389
    //   1384: iconst_1
    //   1385: istore_2
    //   1386: goto +5 -> 1391
    //   1389: iconst_0
    //   1390: istore_2
    //   1391: aload 9
    //   1393: getfield 110	com/tencent/mobileqq/structmsg/AbsStructMsgElement:an	Ljava/lang/String;
    //   1396: invokestatic 253	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1399: istore_3
    //   1400: goto +5 -> 1405
    //   1403: iconst_m1
    //   1404: istore_3
    //   1405: aload 9
    //   1407: getfield 243	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ap	Ljava/lang/String;
    //   1410: astore 6
    //   1412: new 133	java/lang/StringBuilder
    //   1415: dup
    //   1416: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1419: astore 10
    //   1421: aload 10
    //   1423: ldc 106
    //   1425: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: pop
    //   1429: aload 10
    //   1431: aload 9
    //   1433: getfield 112	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ao	J
    //   1436: invokevirtual 337	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1439: pop
    //   1440: aload 8
    //   1442: ldc 239
    //   1444: ldc 241
    //   1446: aload 6
    //   1448: ldc_w 578
    //   1451: ldc_w 578
    //   1454: iload_3
    //   1455: iload_2
    //   1456: aload 10
    //   1458: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1461: aload 9
    //   1463: getfield 108	com/tencent/mobileqq/structmsg/AbsStructMsgElement:am	Ljava/lang/String;
    //   1466: ldc 106
    //   1468: aload 9
    //   1470: getfield 339	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   1473: invokestatic 263	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1476: new 133	java/lang/StringBuilder
    //   1479: dup
    //   1480: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1483: astore 6
    //   1485: aload 6
    //   1487: ldc_w 580
    //   1490: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1493: pop
    //   1494: aload 6
    //   1496: aload 9
    //   1498: getfield 112	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ao	J
    //   1501: invokestatic 258	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1504: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1507: pop
    //   1508: aload 6
    //   1510: ldc_w 582
    //   1513: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: pop
    //   1517: aload 6
    //   1519: aload 9
    //   1521: getfield 108	com/tencent/mobileqq/structmsg/AbsStructMsgElement:am	Ljava/lang/String;
    //   1524: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1527: pop
    //   1528: aload 6
    //   1530: ldc_w 584
    //   1533: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: pop
    //   1537: aload 6
    //   1539: ldc 106
    //   1541: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1544: pop
    //   1545: aload 6
    //   1547: ldc_w 586
    //   1550: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: pop
    //   1554: aload 6
    //   1556: aload 9
    //   1558: getfield 339	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   1561: invokestatic 588	com/tencent/mobileqq/structmsg/AbsStructMsgElement:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1564: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: pop
    //   1568: aload 8
    //   1570: ldc 239
    //   1572: ldc 241
    //   1574: aload 9
    //   1576: getfield 243	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ap	Ljava/lang/String;
    //   1579: ldc_w 590
    //   1582: ldc_w 590
    //   1585: iload_3
    //   1586: iload_2
    //   1587: aload 6
    //   1589: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1592: ldc 106
    //   1594: ldc 106
    //   1596: ldc 106
    //   1598: invokestatic 263	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1601: aload 7
    //   1603: ifnonnull +6 -> 1609
    //   1606: goto +263 -> 1869
    //   1609: aload 7
    //   1611: ldc_w 418
    //   1614: invokevirtual 373	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1617: astore 6
    //   1619: aload 6
    //   1621: invokestatic 237	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1624: ifne +177 -> 1801
    //   1627: new 296	org/json/JSONObject
    //   1630: dup
    //   1631: invokespecial 374	org/json/JSONObject:<init>	()V
    //   1634: astore 10
    //   1636: aload 9
    //   1638: getfield 243	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ap	Ljava/lang/String;
    //   1641: invokestatic 237	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1644: ifne +20 -> 1664
    //   1647: aload 10
    //   1649: ldc_w 376
    //   1652: aload 9
    //   1654: getfield 243	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ap	Ljava/lang/String;
    //   1657: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1660: pop
    //   1661: goto +17 -> 1678
    //   1664: aload 10
    //   1666: ldc_w 376
    //   1669: aload 7
    //   1671: getfield 379	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   1674: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1677: pop
    //   1678: aload 10
    //   1680: ldc_w 389
    //   1683: iload_3
    //   1684: i2l
    //   1685: invokestatic 258	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1688: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1691: pop
    //   1692: aload 10
    //   1694: ldc_w 416
    //   1697: aload 6
    //   1699: invokevirtual 383	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1702: pop
    //   1703: goto +10 -> 1713
    //   1706: astore 6
    //   1708: aload 6
    //   1710: invokevirtual 438	org/json/JSONException:printStackTrace	()V
    //   1713: new 592	java/util/ArrayList
    //   1716: dup
    //   1717: invokespecial 593	java/util/ArrayList:<init>	()V
    //   1720: aload 9
    //   1722: getfield 112	com/tencent/mobileqq/structmsg/AbsStructMsgElement:ao	J
    //   1725: invokestatic 526	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1728: invokeinterface 596 2 0
    //   1733: pop
    //   1734: aload 7
    //   1736: ldc_w 598
    //   1739: invokevirtual 373	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1742: astore 6
    //   1744: aload 7
    //   1746: ldc_w 600
    //   1749: invokevirtual 373	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1752: astore 10
    //   1754: aload 7
    //   1756: ldc_w 602
    //   1759: invokevirtual 373	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1762: astore 11
    //   1764: aload 6
    //   1766: ldc_w 366
    //   1769: invokevirtual 321	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1772: ifeq +6 -> 1778
    //   1775: goto +26 -> 1801
    //   1778: aload 10
    //   1780: ldc_w 366
    //   1783: invokevirtual 321	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1786: ifeq +6 -> 1792
    //   1789: goto +12 -> 1801
    //   1792: aload 11
    //   1794: ldc_w 366
    //   1797: invokevirtual 321	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1800: pop
    //   1801: aload 8
    //   1803: getstatic 605	com/tencent/mobileqq/app/QQManagerFactory:EC_SHOP_ASSISTANT_MANAGER	I
    //   1806: invokevirtual 548	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1809: checkcast 453	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager
    //   1812: astore 6
    //   1814: aload 8
    //   1816: getstatic 608	com/tencent/mobileqq/app/BusinessHandlerFactory:EC_SHOP_REPORT_HANDLER	Ljava/lang/String;
    //   1819: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1822: checkcast 610	com/tencent/biz/pubaccount/ecshopassit/EcshopReportHandler
    //   1825: astore 8
    //   1827: aload 7
    //   1829: ifnull +40 -> 1869
    //   1832: aload 6
    //   1834: ifnull +35 -> 1869
    //   1837: aload 8
    //   1839: ifnull +30 -> 1869
    //   1842: aload 6
    //   1844: aload 7
    //   1846: getfield 613	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   1849: invokevirtual 615	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:d	(Ljava/lang/String;)Z
    //   1852: ifeq +17 -> 1869
    //   1855: aload 8
    //   1857: iconst_0
    //   1858: aload 7
    //   1860: iload_3
    //   1861: aload 9
    //   1863: getfield 339	com/tencent/mobileqq/structmsg/AbsStructMsgElement:d	Ljava/lang/String;
    //   1866: invokevirtual 618	com/tencent/biz/pubaccount/ecshopassit/EcshopReportHandler:a	(ZLcom/tencent/mobileqq/data/MessageRecord;ILjava/lang/String;)V
    //   1869: invokestatic 624	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   1872: aload_1
    //   1873: invokevirtual 627	com/tencent/qqlive/module/videoreport/collect/EventCollector:onViewClicked	(Landroid/view/View;)V
    //   1876: return
    //   1877: astore 7
    //   1879: goto -1651 -> 228
    //   1882: astore 6
    //   1884: goto -1439 -> 445
    //   1887: astore 6
    //   1889: goto -651 -> 1238
    //   1892: astore 6
    //   1894: goto -659 -> 1235
    //   1897: astore 6
    //   1899: goto -496 -> 1403
    //   1902: goto -812 -> 1090
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1905	0	this	AbsStructMsgElement
    //   0	1905	1	paramView	View
    //   224	1363	2	i1	int
    //   1399	462	3	i2	int
    //   849	531	4	bool1	boolean
    //   845	7	5	bool2	boolean
    //   29	644	6	localObject1	Object
    //   693	1	6	localJSONException1	org.json.JSONException
    //   698	1	6	localJSONException2	org.json.JSONException
    //   703	1	6	localJSONException3	org.json.JSONException
    //   708	1	6	localJSONException4	org.json.JSONException
    //   713	3	6	localJSONException5	org.json.JSONException
    //   735	963	6	localObject2	Object
    //   1706	3	6	localJSONException6	org.json.JSONException
    //   1742	101	6	localObject3	Object
    //   1882	1	6	localClassCastException	java.lang.ClassCastException
    //   1887	1	6	localException1	java.lang.Exception
    //   1892	1	6	localException2	java.lang.Exception
    //   1897	1	6	localException3	java.lang.Exception
    //   235	1624	7	localObject4	Object
    //   1877	1	7	localNumberFormatException	java.lang.NumberFormatException
    //   356	1500	8	localObject5	Object
    //   51	1811	9	localAbsStructMsgElement	AbsStructMsgElement
    //   57	1722	10	localObject6	Object
    //   84	1709	11	localObject7	Object
    //   628	49	12	str	String
    //   482	197	13	localObject8	Object
    //   644	37	14	localStringBuilder	StringBuilder
    //   659	5	15	localAbsStructMsg	AbsStructMsg
    // Exception table:
    //   from	to	target	type
    //   661	690	693	org/json/JSONException
    //   654	661	698	org/json/JSONException
    //   637	654	703	org/json/JSONException
    //   498	637	708	org/json/JSONException
    //   475	498	713	org/json/JSONException
    //   1636	1661	1706	org/json/JSONException
    //   1664	1678	1706	org/json/JSONException
    //   1678	1703	1706	org/json/JSONException
    //   217	225	1877	java/lang/NumberFormatException
    //   435	441	1882	java/lang/ClassCastException
    //   1020	1058	1887	java/lang/Exception
    //   1058	1087	1892	java/lang/Exception
    //   1094	1232	1892	java/lang/Exception
    //   1391	1400	1897	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgElement
 * JD-Core Version:    0.7.0.1
 */