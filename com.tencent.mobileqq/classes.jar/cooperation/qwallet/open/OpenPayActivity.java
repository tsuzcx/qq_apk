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
  private static final char[] a;
  public int a;
  public long a;
  protected Bundle a;
  public int b = -1;
  public int c;
  private int d;
  
  static
  {
    jdField_a_of_type_ArrayOfChar = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  }
  
  public OpenPayActivity()
  {
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[(paramArrayOfByte[i] & 0xF)]);
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
    //   1: ldc 71
    //   3: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 12
    //   8: aload_1
    //   9: ldc 79
    //   11: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore 14
    //   16: aload_1
    //   17: ldc 81
    //   19: invokevirtual 85	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   22: lstore_2
    //   23: aload_1
    //   24: ldc 87
    //   26: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 15
    //   31: aload_1
    //   32: ldc 89
    //   34: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 16
    //   39: aload_1
    //   40: ldc 91
    //   42: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 7
    //   47: aload_1
    //   48: ldc 93
    //   50: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 17
    //   55: aload_1
    //   56: ldc 95
    //   58: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: astore 13
    //   63: aload_1
    //   64: ldc 97
    //   66: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 18
    //   71: aload_1
    //   72: ldc 99
    //   74: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 8
    //   79: aload_1
    //   80: ldc 101
    //   82: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 9
    //   87: aload_0
    //   88: invokevirtual 105	cooperation/qwallet/open/OpenPayActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   91: invokevirtual 111	mqq/app/AppRuntime:getCurrentAccountUin	()Ljava/lang/String;
    //   94: astore 10
    //   96: aload_0
    //   97: invokevirtual 105	cooperation/qwallet/open/OpenPayActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   100: invokestatic 116	cooperation/qwallet/QwalletBlUtils:a	(Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   103: astore 11
    //   105: aload 14
    //   107: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +890 -> 1000
    //   113: aload 15
    //   115: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifne +882 -> 1000
    //   121: aload 16
    //   123: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   126: ifne +874 -> 1000
    //   129: aload 7
    //   131: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifne +866 -> 1000
    //   137: aload 12
    //   139: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifne +858 -> 1000
    //   145: aload 13
    //   147: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifeq +6 -> 156
    //   153: goto +847 -> 1000
    //   156: aload_0
    //   157: getfield 40	cooperation/qwallet/open/OpenPayActivity:jdField_a_of_type_Int	I
    //   160: iconst_2
    //   161: if_icmpne +52 -> 213
    //   164: aload 8
    //   166: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   169: ifne +19 -> 188
    //   172: aload_0
    //   173: getfield 44	cooperation/qwallet/open/OpenPayActivity:jdField_c_of_type_Int	I
    //   176: iconst_1
    //   177: if_icmpne +36 -> 213
    //   180: aload 9
    //   182: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifeq +28 -> 213
    //   188: aload_0
    //   189: sipush -1009
    //   192: ldc 124
    //   194: aconst_null
    //   195: invokevirtual 127	cooperation/qwallet/open/OpenPayActivity:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   198: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +11 -> 212
    //   204: ldc 135
    //   206: iconst_2
    //   207: ldc 137
    //   209: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: return
    //   213: aload_0
    //   214: invokevirtual 145	cooperation/qwallet/open/OpenPayActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   217: aload 8
    //   219: bipush 64
    //   221: invokevirtual 151	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   224: astore 5
    //   226: aload 5
    //   228: getfield 157	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   231: astore 4
    //   233: aload 5
    //   235: getfield 161	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   238: astore 5
    //   240: ldc 163
    //   242: invokestatic 169	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   245: astore 6
    //   247: aload 6
    //   249: invokevirtual 172	java/security/MessageDigest:reset	()V
    //   252: aload 6
    //   254: aload 5
    //   256: iconst_0
    //   257: aaload
    //   258: invokevirtual 178	android/content/pm/Signature:toByteArray	()[B
    //   261: invokevirtual 182	java/security/MessageDigest:update	([B)V
    //   264: aload 6
    //   266: invokevirtual 185	java/security/MessageDigest:digest	()[B
    //   269: invokestatic 187	cooperation/qwallet/open/OpenPayActivity:a	([B)Ljava/lang/String;
    //   272: astore 6
    //   274: aload 4
    //   276: astore 5
    //   278: goto +44 -> 322
    //   281: astore 5
    //   283: goto +9 -> 292
    //   286: astore 5
    //   288: ldc 64
    //   290: astore 4
    //   292: aload 5
    //   294: invokevirtual 190	java/lang/Exception:printStackTrace	()V
    //   297: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +14 -> 314
    //   303: ldc 135
    //   305: iconst_2
    //   306: ldc 192
    //   308: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: goto +3 -> 314
    //   314: ldc 64
    //   316: astore 6
    //   318: aload 4
    //   320: astore 5
    //   322: aload_0
    //   323: invokevirtual 105	cooperation/qwallet/open/OpenPayActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   326: iconst_2
    //   327: invokevirtual 196	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   330: checkcast 198	mqq/manager/TicketManager
    //   333: astore 4
    //   335: aload 4
    //   337: ifnull +819 -> 1156
    //   340: aload 4
    //   342: aload 10
    //   344: invokeinterface 201 2 0
    //   349: astore 4
    //   351: goto +3 -> 354
    //   354: new 203	org/json/JSONObject
    //   357: dup
    //   358: invokespecial 204	org/json/JSONObject:<init>	()V
    //   361: astore 19
    //   363: aload 19
    //   365: ldc 71
    //   367: aload 12
    //   369: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   372: pop
    //   373: aload 19
    //   375: ldc 79
    //   377: aload 14
    //   379: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   382: pop
    //   383: aload 19
    //   385: ldc 81
    //   387: lload_2
    //   388: invokevirtual 211	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   391: pop
    //   392: aload 19
    //   394: ldc 95
    //   396: aload 13
    //   398: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   401: pop
    //   402: aload 19
    //   404: ldc 93
    //   406: aload 17
    //   408: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   411: pop
    //   412: aload 19
    //   414: ldc 89
    //   416: aload 16
    //   418: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   421: pop
    //   422: aload 19
    //   424: ldc 87
    //   426: aload 15
    //   428: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   431: pop
    //   432: aload 19
    //   434: ldc 213
    //   436: aload 10
    //   438: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   441: pop
    //   442: aload 19
    //   444: ldc 215
    //   446: aload 18
    //   448: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   451: pop
    //   452: aload 19
    //   454: ldc 217
    //   456: aload 4
    //   458: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   461: pop
    //   462: aload 19
    //   464: ldc 219
    //   466: aload 8
    //   468: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   471: pop
    //   472: aload 19
    //   474: ldc 221
    //   476: aload 5
    //   478: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   481: pop
    //   482: aload 19
    //   484: ldc 223
    //   486: aload 6
    //   488: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   491: pop
    //   492: aload 19
    //   494: invokevirtual 226	org/json/JSONObject:toString	()Ljava/lang/String;
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
    //   521: invokevirtual 190	java/lang/Exception:printStackTrace	()V
    //   524: ldc 64
    //   526: astore 4
    //   528: new 47	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   535: astore 18
    //   537: aload 18
    //   539: ldc 229
    //   541: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 18
    //   547: aload 12
    //   549: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload 18
    //   555: ldc 234
    //   557: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 18
    //   563: aload 14
    //   565: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload 18
    //   571: ldc 236
    //   573: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 18
    //   579: lload_2
    //   580: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload 18
    //   586: ldc 241
    //   588: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload 18
    //   594: aload 15
    //   596: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 18
    //   602: ldc 243
    //   604: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload 18
    //   610: aload 16
    //   612: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload 18
    //   618: ldc 245
    //   620: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload 18
    //   626: aload 7
    //   628: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload 18
    //   634: ldc 247
    //   636: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 18
    //   642: aload 17
    //   644: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload 18
    //   650: ldc 249
    //   652: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: pop
    //   656: aload 18
    //   658: aload 13
    //   660: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: pop
    //   664: aload 18
    //   666: ldc 251
    //   668: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload 18
    //   674: aload 8
    //   676: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload 18
    //   682: ldc 253
    //   684: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: aload 18
    //   690: aload 6
    //   692: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: aload 18
    //   698: ldc 255
    //   700: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: pop
    //   704: aload 18
    //   706: aload 5
    //   708: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: aload_0
    //   713: getfield 257	cooperation/qwallet/open/OpenPayActivity:jdField_a_of_type_Long	J
    //   716: aconst_null
    //   717: ldc_w 259
    //   720: aload 18
    //   722: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: iconst_0
    //   726: aconst_null
    //   727: invokestatic 265	com/tencent/mobileqq/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   730: invokestatic 268	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   733: ifeq +42 -> 775
    //   736: new 47	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   743: astore 5
    //   745: aload 5
    //   747: ldc_w 270
    //   750: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload 5
    //   756: invokestatic 276	android/os/SystemClock:elapsedRealtime	()J
    //   759: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: ldc_w 278
    //   766: iconst_4
    //   767: aload 5
    //   769: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 281	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: aload_1
    //   776: ldc_w 283
    //   779: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   782: astore_1
    //   783: new 47	java/lang/StringBuilder
    //   786: dup
    //   787: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   790: astore 5
    //   792: aload 5
    //   794: ldc_w 285
    //   797: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: pop
    //   801: aload 5
    //   803: aload 12
    //   805: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: pop
    //   809: aload 5
    //   811: ldc_w 287
    //   814: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: pop
    //   818: aload 5
    //   820: aload 13
    //   822: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: aload 5
    //   828: ldc_w 289
    //   831: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: pop
    //   835: aload 5
    //   837: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   840: astore 5
    //   842: new 73	android/os/Bundle
    //   845: dup
    //   846: invokespecial 290	android/os/Bundle:<init>	()V
    //   849: astore 6
    //   851: aload 6
    //   853: ldc_w 283
    //   856: aload_1
    //   857: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   860: aload 6
    //   862: ldc 91
    //   864: aload 7
    //   866: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   869: aload 6
    //   871: ldc_w 296
    //   874: aload 10
    //   876: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   879: aload 6
    //   881: ldc_w 298
    //   884: aload 11
    //   886: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   889: aload 6
    //   891: ldc_w 300
    //   894: iconst_4
    //   895: invokevirtual 304	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   898: aload 6
    //   900: ldc_w 306
    //   903: aload 5
    //   905: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   908: aload 6
    //   910: ldc_w 308
    //   913: iconst_1
    //   914: invokevirtual 304	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   917: aload 6
    //   919: ldc_w 310
    //   922: aload 4
    //   924: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   927: aload 6
    //   929: ldc 99
    //   931: aload 8
    //   933: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   936: aload 6
    //   938: ldc 101
    //   940: aload 9
    //   942: invokevirtual 294	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   945: aload 6
    //   947: ldc_w 312
    //   950: aload_0
    //   951: getfield 44	cooperation/qwallet/open/OpenPayActivity:jdField_c_of_type_Int	I
    //   954: invokevirtual 304	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   957: aload 6
    //   959: ldc_w 314
    //   962: bipush 9
    //   964: invokevirtual 304	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   967: aload 6
    //   969: ldc_w 316
    //   972: iconst_4
    //   973: invokevirtual 304	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   976: aload 6
    //   978: ldc_w 318
    //   981: aload_0
    //   982: getfield 257	cooperation/qwallet/open/OpenPayActivity:jdField_a_of_type_Long	J
    //   985: invokevirtual 322	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   988: aload_0
    //   989: aload 6
    //   991: invokestatic 328	cooperation/qwallet/plugin/QWalletPayBridge:launchForeground	(Landroid/app/Activity;Landroid/os/Bundle;)Z
    //   994: pop
    //   995: aload_0
    //   996: invokevirtual 331	cooperation/qwallet/open/OpenPayActivity:finish	()V
    //   999: return
    //   1000: new 47	java/lang/StringBuilder
    //   1003: dup
    //   1004: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   1007: astore_1
    //   1008: aload_1
    //   1009: ldc_w 333
    //   1012: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: pop
    //   1016: aload_1
    //   1017: aload 12
    //   1019: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: pop
    //   1023: aload_1
    //   1024: ldc_w 335
    //   1027: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: pop
    //   1031: aload_1
    //   1032: aload 13
    //   1034: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: pop
    //   1038: aload_1
    //   1039: ldc_w 337
    //   1042: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: pop
    //   1046: aload_1
    //   1047: aload 7
    //   1049: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: pop
    //   1053: aload_1
    //   1054: ldc_w 339
    //   1057: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: pop
    //   1061: aload_1
    //   1062: aload 14
    //   1064: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: pop
    //   1068: aload_1
    //   1069: ldc_w 341
    //   1072: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: aload_1
    //   1077: aload 15
    //   1079: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: pop
    //   1083: aload_1
    //   1084: ldc_w 343
    //   1087: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: pop
    //   1091: aload_1
    //   1092: aload 16
    //   1094: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: pop
    //   1098: aload_1
    //   1099: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: astore_1
    //   1103: aload_0
    //   1104: sipush -1007
    //   1107: ldc 124
    //   1109: aconst_null
    //   1110: invokevirtual 127	cooperation/qwallet/open/OpenPayActivity:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   1113: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1116: ifeq +39 -> 1155
    //   1119: new 47	java/lang/StringBuilder
    //   1122: dup
    //   1123: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   1126: astore 4
    //   1128: aload 4
    //   1130: ldc_w 345
    //   1133: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: pop
    //   1137: aload 4
    //   1139: aload_1
    //   1140: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: pop
    //   1144: ldc 135
    //   1146: iconst_2
    //   1147: aload 4
    //   1149: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1152: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1155: return
    //   1156: ldc 64
    //   1158: astore 4
    //   1160: goto -806 -> 354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1163	0	this	OpenPayActivity
    //   0	1163	1	paramBundle	Bundle
    //   22	558	2	l	long
    //   231	267	4	localObject1	Object
    //   502	1	4	localException1	Exception
    //   507	1	4	localException2	Exception
    //   512	1	4	localException3	Exception
    //   517	3	4	localException4	Exception
    //   526	633	4	localObject2	Object
    //   224	53	5	localObject3	Object
    //   281	1	5	localException5	Exception
    //   286	7	5	localException6	Exception
    //   320	584	5	localObject4	Object
    //   245	745	6	localObject5	Object
    //   45	1003	7	str1	String
    //   77	855	8	str2	String
    //   85	856	9	str3	String
    //   94	781	10	str4	String
    //   103	782	11	str5	String
    //   6	1012	12	str6	String
    //   61	972	13	str7	String
    //   14	1049	14	str8	String
    //   29	1049	15	str9	String
    //   37	1056	16	str10	String
    //   53	590	17	str11	String
    //   69	652	18	localObject6	Object
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
    ((PayResponse)localObject2).jdField_d_of_type_Int = 1;
    ((PayResponse)localObject2).b = "pay";
    ((PayResponse)localObject2).i = paramBundle.getString("callbackSn");
    ((PayResponse)localObject2).jdField_c_of_type_Int = paramBundle.getInt("retCode");
    ((PayResponse)localObject2).a = paramBundle.getString("retMsg");
    Object localObject1 = "";
    ((PayResponse)localObject2).j = "";
    if (((PayResponse)localObject2).a())
    {
      ((PayResponse)localObject2).jdField_c_of_type_JavaLangString = paramBundle.getString("payChannelType");
      ((PayResponse)localObject2).jdField_d_of_type_JavaLangString = paramBundle.getString("transactionId");
      ((PayResponse)localObject2).e = paramBundle.getString("payTime");
      ((PayResponse)localObject2).f = paramBundle.getString("totalFee");
      ((PayResponse)localObject2).g = paramBundle.getString("callbackUrl");
      ((PayResponse)localObject2).h = paramBundle.getString("spData");
    }
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("packageName");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("callbackScheme");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      Intent localIntent = new Intent();
      if (this.jdField_c_of_type_Int == 2)
      {
        localObject2 = ((PayResponse)localObject2).a();
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
      str = this.jdField_a_of_type_AndroidOsBundle.getString("callbackSn");
    }
    paramString2 = new Bundle();
    paramString2.putInt("retCode", paramInt);
    paramString2.putString("retMsg", paramString1);
    paramString2.putString("callbackSn", str);
    if (this.jdField_a_of_type_Int != 2)
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
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      this.jdField_d_of_type_Int = paramBundle.getInt("extra.key.pay.type");
      this.jdField_a_of_type_Int = paramBundle.getInt("extra.key.pay.from", -1);
      this.b = paramBundle.getInt("extra.key.pay.platform", -1);
      this.jdField_c_of_type_Int = paramBundle.getInt("extra.key.app.type", -1);
      this.jdField_a_of_type_Long = paramBundle.getLong("vacreport_key_seq", 0L);
      if (this.jdField_d_of_type_Int != 1)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qwallet.open.OpenPayActivity
 * JD-Core Version:    0.7.0.1
 */