package cooperation.qwallet.open;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.open.openpay.PayResponse;

public class OpenPayActivity
  extends QBaseActivity
{
  private static final char[] g = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public int a = -1;
  public int b = -1;
  public int c = -1;
  public long d;
  protected Bundle e;
  private int f = -1;
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(g[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(g[(paramArrayOfByte[i] & 0xF)]);
      localStringBuilder.append(':');
      i += 1;
    }
    if (localStringBuilder.length() > 0) {
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    }
    return "";
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.b != 1) {
      return;
    }
    b(paramBundle);
  }
  
  /* Error */
  private void b(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 74
    //   3: invokevirtual 80	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 12
    //   8: aload_1
    //   9: ldc 82
    //   11: invokevirtual 80	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore 14
    //   16: aload_1
    //   17: ldc 84
    //   19: invokevirtual 88	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   22: lstore_2
    //   23: aload_1
    //   24: ldc 90
    //   26: invokevirtual 80	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 15
    //   31: aload_1
    //   32: ldc 92
    //   34: invokevirtual 80	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 16
    //   39: aload_1
    //   40: ldc 94
    //   42: invokevirtual 80	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 7
    //   47: aload_1
    //   48: ldc 96
    //   50: invokevirtual 80	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 17
    //   55: aload_1
    //   56: ldc 98
    //   58: invokevirtual 80	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: astore 13
    //   63: aload_1
    //   64: ldc 100
    //   66: invokevirtual 80	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 18
    //   71: aload_1
    //   72: ldc 102
    //   74: invokevirtual 80	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 8
    //   79: aload_1
    //   80: ldc 104
    //   82: invokevirtual 80	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 9
    //   87: aload_0
    //   88: invokevirtual 108	cooperation/qwallet/open/OpenPayActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   91: invokevirtual 114	mqq/app/AppRuntime:getCurrentAccountUin	()Ljava/lang/String;
    //   94: astore 10
    //   96: aload_0
    //   97: invokevirtual 108	cooperation/qwallet/open/OpenPayActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   100: invokestatic 119	cooperation/qwallet/QwalletBlUtils:a	(Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   103: astore 11
    //   105: aload 14
    //   107: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +891 -> 1001
    //   113: aload 15
    //   115: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifne +883 -> 1001
    //   121: aload 16
    //   123: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   126: ifne +875 -> 1001
    //   129: aload 7
    //   131: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifne +867 -> 1001
    //   137: aload 12
    //   139: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifne +859 -> 1001
    //   145: aload 13
    //   147: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifeq +6 -> 156
    //   153: goto +848 -> 1001
    //   156: aload_0
    //   157: getfield 43	cooperation/qwallet/open/OpenPayActivity:a	I
    //   160: iconst_2
    //   161: if_icmpne +52 -> 213
    //   164: aload 8
    //   166: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   169: ifne +19 -> 188
    //   172: aload_0
    //   173: getfield 47	cooperation/qwallet/open/OpenPayActivity:c	I
    //   176: iconst_1
    //   177: if_icmpne +36 -> 213
    //   180: aload 9
    //   182: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifeq +28 -> 213
    //   188: aload_0
    //   189: sipush -1009
    //   192: ldc 127
    //   194: aconst_null
    //   195: invokevirtual 130	cooperation/qwallet/open/OpenPayActivity:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   198: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +11 -> 212
    //   204: ldc 138
    //   206: iconst_2
    //   207: ldc 140
    //   209: invokestatic 143	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: return
    //   213: aload_0
    //   214: invokevirtual 147	cooperation/qwallet/open/OpenPayActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   217: aload 8
    //   219: bipush 64
    //   221: invokevirtual 153	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   224: astore 5
    //   226: aload 5
    //   228: getfield 159	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   231: astore 4
    //   233: aload 5
    //   235: getfield 163	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   238: astore 5
    //   240: ldc 165
    //   242: invokestatic 171	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   245: astore 6
    //   247: aload 6
    //   249: invokevirtual 174	java/security/MessageDigest:reset	()V
    //   252: aload 6
    //   254: aload 5
    //   256: iconst_0
    //   257: aaload
    //   258: invokevirtual 180	android/content/pm/Signature:toByteArray	()[B
    //   261: invokevirtual 184	java/security/MessageDigest:update	([B)V
    //   264: aload 6
    //   266: invokevirtual 187	java/security/MessageDigest:digest	()[B
    //   269: invokestatic 189	cooperation/qwallet/open/OpenPayActivity:a	([B)Ljava/lang/String;
    //   272: astore 6
    //   274: aload 4
    //   276: astore 5
    //   278: goto +44 -> 322
    //   281: astore 5
    //   283: goto +9 -> 292
    //   286: astore 5
    //   288: ldc 67
    //   290: astore 4
    //   292: aload 5
    //   294: invokevirtual 192	java/lang/Exception:printStackTrace	()V
    //   297: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +14 -> 314
    //   303: ldc 138
    //   305: iconst_2
    //   306: ldc 194
    //   308: invokestatic 143	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: goto +3 -> 314
    //   314: ldc 67
    //   316: astore 6
    //   318: aload 4
    //   320: astore 5
    //   322: aload_0
    //   323: invokevirtual 108	cooperation/qwallet/open/OpenPayActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   326: iconst_2
    //   327: invokevirtual 198	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   330: checkcast 200	mqq/manager/TicketManager
    //   333: astore 4
    //   335: aload 4
    //   337: ifnull +820 -> 1157
    //   340: aload 4
    //   342: aload 10
    //   344: invokeinterface 203 2 0
    //   349: astore 4
    //   351: goto +3 -> 354
    //   354: new 205	org/json/JSONObject
    //   357: dup
    //   358: invokespecial 206	org/json/JSONObject:<init>	()V
    //   361: astore 19
    //   363: aload 19
    //   365: ldc 74
    //   367: aload 12
    //   369: invokevirtual 210	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   372: pop
    //   373: aload 19
    //   375: ldc 82
    //   377: aload 14
    //   379: invokevirtual 210	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   382: pop
    //   383: aload 19
    //   385: ldc 84
    //   387: lload_2
    //   388: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   391: pop
    //   392: aload 19
    //   394: ldc 98
    //   396: aload 13
    //   398: invokevirtual 210	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   401: pop
    //   402: aload 19
    //   404: ldc 96
    //   406: aload 17
    //   408: invokevirtual 210	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   411: pop
    //   412: aload 19
    //   414: ldc 92
    //   416: aload 16
    //   418: invokevirtual 210	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   421: pop
    //   422: aload 19
    //   424: ldc 90
    //   426: aload 15
    //   428: invokevirtual 210	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   431: pop
    //   432: aload 19
    //   434: ldc 215
    //   436: aload 10
    //   438: invokevirtual 210	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   441: pop
    //   442: aload 19
    //   444: ldc 217
    //   446: aload 18
    //   448: invokevirtual 210	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   451: pop
    //   452: aload 19
    //   454: ldc 219
    //   456: aload 4
    //   458: invokevirtual 210	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   461: pop
    //   462: aload 19
    //   464: ldc 221
    //   466: aload 8
    //   468: invokevirtual 210	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   471: pop
    //   472: aload 19
    //   474: ldc 223
    //   476: aload 5
    //   478: invokevirtual 210	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   481: pop
    //   482: aload 19
    //   484: ldc 225
    //   486: aload 6
    //   488: invokevirtual 210	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   491: pop
    //   492: aload 19
    //   494: invokevirtual 228	org/json/JSONObject:toString	()Ljava/lang/String;
    //   497: astore 4
    //   499: goto +29 -> 528
    //   502: astore 4
    //   504: goto +15 -> 519
    //   507: astore 4
    //   509: goto +10 -> 519
    //   512: astore 4
    //   514: goto +5 -> 519
    //   517: astore 4
    //   519: aload 4
    //   521: invokevirtual 192	java/lang/Exception:printStackTrace	()V
    //   524: ldc 67
    //   526: astore 4
    //   528: new 50	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   535: astore 18
    //   537: aload 18
    //   539: ldc 231
    //   541: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 18
    //   547: aload 12
    //   549: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload 18
    //   555: ldc 236
    //   557: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 18
    //   563: aload 14
    //   565: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload 18
    //   571: ldc 238
    //   573: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 18
    //   579: lload_2
    //   580: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload 18
    //   586: ldc 243
    //   588: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload 18
    //   594: aload 15
    //   596: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 18
    //   602: ldc 245
    //   604: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload 18
    //   610: aload 16
    //   612: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload 18
    //   618: ldc 247
    //   620: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload 18
    //   626: aload 7
    //   628: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload 18
    //   634: ldc 249
    //   636: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 18
    //   642: aload 17
    //   644: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload 18
    //   650: ldc 251
    //   652: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: pop
    //   656: aload 18
    //   658: aload 13
    //   660: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: pop
    //   664: aload 18
    //   666: ldc 253
    //   668: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload 18
    //   674: aload 8
    //   676: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload 18
    //   682: ldc 255
    //   684: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: aload 18
    //   690: aload 6
    //   692: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: aload 18
    //   698: ldc_w 257
    //   701: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload 18
    //   707: aload 5
    //   709: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: pop
    //   713: aload_0
    //   714: getfield 259	cooperation/qwallet/open/OpenPayActivity:d	J
    //   717: aconst_null
    //   718: ldc_w 261
    //   721: aload 18
    //   723: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: iconst_0
    //   727: aconst_null
    //   728: invokestatic 267	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   731: invokestatic 270	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   734: ifeq +42 -> 776
    //   737: new 50	java/lang/StringBuilder
    //   740: dup
    //   741: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   744: astore 5
    //   746: aload 5
    //   748: ldc_w 272
    //   751: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: aload 5
    //   757: invokestatic 278	android/os/SystemClock:elapsedRealtime	()J
    //   760: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   763: pop
    //   764: ldc_w 280
    //   767: iconst_4
    //   768: aload 5
    //   770: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: invokestatic 283	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   776: aload_1
    //   777: ldc_w 285
    //   780: invokevirtual 80	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   783: astore_1
    //   784: new 50	java/lang/StringBuilder
    //   787: dup
    //   788: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   791: astore 5
    //   793: aload 5
    //   795: ldc_w 287
    //   798: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: aload 5
    //   804: aload 12
    //   806: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: aload 5
    //   812: ldc_w 289
    //   815: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: aload 5
    //   821: aload 13
    //   823: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: pop
    //   827: aload 5
    //   829: ldc_w 291
    //   832: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: pop
    //   836: aload 5
    //   838: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   841: astore 5
    //   843: new 76	android/os/Bundle
    //   846: dup
    //   847: invokespecial 292	android/os/Bundle:<init>	()V
    //   850: astore 6
    //   852: aload 6
    //   854: ldc_w 285
    //   857: aload_1
    //   858: invokevirtual 296	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   861: aload 6
    //   863: ldc 94
    //   865: aload 7
    //   867: invokevirtual 296	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   870: aload 6
    //   872: ldc_w 298
    //   875: aload 10
    //   877: invokevirtual 296	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   880: aload 6
    //   882: ldc_w 300
    //   885: aload 11
    //   887: invokevirtual 296	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   890: aload 6
    //   892: ldc_w 302
    //   895: iconst_4
    //   896: invokevirtual 306	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   899: aload 6
    //   901: ldc_w 308
    //   904: aload 5
    //   906: invokevirtual 296	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   909: aload 6
    //   911: ldc_w 310
    //   914: iconst_1
    //   915: invokevirtual 306	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   918: aload 6
    //   920: ldc_w 312
    //   923: aload 4
    //   925: invokevirtual 296	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   928: aload 6
    //   930: ldc 102
    //   932: aload 8
    //   934: invokevirtual 296	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   937: aload 6
    //   939: ldc 104
    //   941: aload 9
    //   943: invokevirtual 296	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   946: aload 6
    //   948: ldc_w 314
    //   951: aload_0
    //   952: getfield 47	cooperation/qwallet/open/OpenPayActivity:c	I
    //   955: invokevirtual 306	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   958: aload 6
    //   960: ldc_w 316
    //   963: bipush 9
    //   965: invokevirtual 306	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   968: aload 6
    //   970: ldc_w 318
    //   973: iconst_4
    //   974: invokevirtual 306	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   977: aload 6
    //   979: ldc_w 320
    //   982: aload_0
    //   983: getfield 259	cooperation/qwallet/open/OpenPayActivity:d	J
    //   986: invokevirtual 324	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   989: aload_0
    //   990: aload 6
    //   992: invokestatic 330	cooperation/qwallet/plugin/QWalletPayBridge:launchForeground	(Landroid/app/Activity;Landroid/os/Bundle;)Z
    //   995: pop
    //   996: aload_0
    //   997: invokevirtual 333	cooperation/qwallet/open/OpenPayActivity:finish	()V
    //   1000: return
    //   1001: new 50	java/lang/StringBuilder
    //   1004: dup
    //   1005: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1008: astore_1
    //   1009: aload_1
    //   1010: ldc_w 335
    //   1013: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: pop
    //   1017: aload_1
    //   1018: aload 12
    //   1020: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: pop
    //   1024: aload_1
    //   1025: ldc_w 337
    //   1028: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: pop
    //   1032: aload_1
    //   1033: aload 13
    //   1035: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: pop
    //   1039: aload_1
    //   1040: ldc_w 339
    //   1043: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: pop
    //   1047: aload_1
    //   1048: aload 7
    //   1050: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: pop
    //   1054: aload_1
    //   1055: ldc_w 341
    //   1058: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: pop
    //   1062: aload_1
    //   1063: aload 14
    //   1065: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: pop
    //   1069: aload_1
    //   1070: ldc_w 343
    //   1073: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: pop
    //   1077: aload_1
    //   1078: aload 15
    //   1080: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: pop
    //   1084: aload_1
    //   1085: ldc_w 345
    //   1088: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: pop
    //   1092: aload_1
    //   1093: aload 16
    //   1095: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: pop
    //   1099: aload_1
    //   1100: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1103: astore_1
    //   1104: aload_0
    //   1105: sipush -1007
    //   1108: ldc 127
    //   1110: aconst_null
    //   1111: invokevirtual 130	cooperation/qwallet/open/OpenPayActivity:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   1114: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1117: ifeq +39 -> 1156
    //   1120: new 50	java/lang/StringBuilder
    //   1123: dup
    //   1124: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1127: astore 4
    //   1129: aload 4
    //   1131: ldc_w 347
    //   1134: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: pop
    //   1138: aload 4
    //   1140: aload_1
    //   1141: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: pop
    //   1145: ldc 138
    //   1147: iconst_2
    //   1148: aload 4
    //   1150: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: invokestatic 143	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1156: return
    //   1157: ldc 67
    //   1159: astore 4
    //   1161: goto -807 -> 354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1164	0	this	OpenPayActivity
    //   0	1164	1	paramBundle	Bundle
    //   22	558	2	l	long
    //   231	267	4	localObject1	Object
    //   502	1	4	localException1	Exception
    //   507	1	4	localException2	Exception
    //   512	1	4	localException3	Exception
    //   517	3	4	localException4	Exception
    //   526	634	4	localObject2	Object
    //   224	53	5	localObject3	Object
    //   281	1	5	localException5	Exception
    //   286	7	5	localException6	Exception
    //   320	585	5	localObject4	Object
    //   245	746	6	localObject5	Object
    //   45	1004	7	str1	String
    //   77	856	8	str2	String
    //   85	857	9	str3	String
    //   94	782	10	str4	String
    //   103	783	11	str5	String
    //   6	1013	12	str6	String
    //   61	973	13	str7	String
    //   14	1050	14	str8	String
    //   29	1050	15	str9	String
    //   37	1057	16	str10	String
    //   53	590	17	str11	String
    //   69	653	18	localObject6	Object
    //   361	132	19	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   233	274	281	java/lang/Exception
    //   213	233	286	java/lang/Exception
    //   442	499	502	java/lang/Exception
    //   402	442	507	java/lang/Exception
    //   383	402	512	java/lang/Exception
    //   322	335	517	java/lang/Exception
    //   340	351	517	java/lang/Exception
    //   354	383	517	java/lang/Exception
  }
  
  private void c(Bundle paramBundle)
  {
    Object localObject2 = new PayResponse();
    ((PayResponse)localObject2).f = 1;
    ((PayResponse)localObject2).e = "pay";
    ((PayResponse)localObject2).m = paramBundle.getString("callbackSn");
    ((PayResponse)localObject2).c = paramBundle.getInt("retCode");
    ((PayResponse)localObject2).d = paramBundle.getString("retMsg");
    Object localObject1 = "";
    ((PayResponse)localObject2).n = "";
    if (((PayResponse)localObject2).a())
    {
      ((PayResponse)localObject2).g = paramBundle.getString("payChannelType");
      ((PayResponse)localObject2).h = paramBundle.getString("transactionId");
      ((PayResponse)localObject2).i = paramBundle.getString("payTime");
      ((PayResponse)localObject2).j = paramBundle.getString("totalFee");
      ((PayResponse)localObject2).k = paramBundle.getString("callbackUrl");
      ((PayResponse)localObject2).l = paramBundle.getString("spData");
    }
    String str1 = this.e.getString("packageName");
    String str2 = this.e.getString("callbackScheme");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      Intent localIntent = new Intent();
      if (this.c == 2)
      {
        localObject2 = ((PayResponse)localObject2).b();
        paramBundle = (Bundle)localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          try
          {
            paramBundle = new String(Base64Util.encode(((String)localObject2).getBytes(), 0));
          }
          catch (Exception paramBundle)
          {
            paramBundle.printStackTrace();
            paramBundle = (Bundle)localObject1;
          }
        }
        localIntent.setAction("android.intent.action.VIEW");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append("://");
        ((StringBuilder)localObject1).append(paramBundle);
        localIntent.setData(Uri.parse(((StringBuilder)localObject1).toString()));
        localIntent.setPackage(str1);
        localIntent.addFlags(268435456);
        localIntent.putExtra("com_tencent_mobileqq_open_pay", "com.tencent.mobileqq.open.pay");
      }
      else
      {
        paramBundle = new Bundle();
        ((PayResponse)localObject2).a(paramBundle);
        localIntent.setAction("android.intent.action.VIEW");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append("://open_pay/pay");
        localIntent.setData(Uri.parse(((StringBuilder)localObject1).toString()));
        localIntent.setPackage(str1);
        localIntent.addFlags(268435456);
        localIntent.putExtras(paramBundle);
        localIntent.putExtra("com_tencent_mobileqq_open_pay", "com.tencent.mobileqq.open.pay");
      }
      try
      {
        super.startActivity(localIntent);
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("doAppCashPayResult error:");
          ((StringBuilder)localObject1).append(paramBundle.getMessage());
          QLog.e("Q.qwallet.open.OpenPayActivity", 2, ((StringBuilder)localObject1).toString());
        }
        else if (QLog.isDevelopLevel())
        {
          paramBundle.printStackTrace();
        }
      }
      super.finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.qwallet.open.OpenPayActivity", 2, "OpenPayActivity.doOpenAppCashPayResult packageName&callbackScheme empty");
    }
    super.finish();
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = this.e.getString("callbackSn");
    }
    paramString2 = new Bundle();
    paramString2.putInt("retCode", paramInt);
    paramString2.putString("retMsg", paramString1);
    paramString2.putString("callbackSn", str);
    if (this.a != 2)
    {
      super.finish();
      return;
    }
    c(paramString2);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("");
      paramBundle.append(System.currentTimeMillis());
      paramBundle.append(" OpenPayActivity.doOnCreate");
      QLog.i("Q.qwallet.pay", 2, paramBundle.toString());
    }
    paramBundle = super.getIntent().getExtras();
    if ((getAppRuntime() != null) && (paramBundle != null))
    {
      this.e = paramBundle;
      this.f = paramBundle.getInt("extra.key.pay.type");
      this.a = paramBundle.getInt("extra.key.pay.from", -1);
      this.b = paramBundle.getInt("extra.key.pay.platform", -1);
      this.c = paramBundle.getInt("extra.key.app.type", -1);
      this.d = paramBundle.getLong("vacreport_key_seq", 0L);
      if (this.f != 1)
      {
        a(-1002, "Parameters error.", null);
        if (QLog.isColorLevel())
        {
          QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.doOnCreate mPayType error");
          return true;
        }
      }
      else
      {
        a(paramBundle);
      }
      return true;
    }
    a(-1001, "Parameters error.", null);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "OpenPayActivity.doOnCreate app == null || bundle == null");
    }
    return true;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qwallet.open.OpenPayActivity
 * JD-Core Version:    0.7.0.1
 */