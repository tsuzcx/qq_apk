package com.tencent.open.agent;

import alhj;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.os.Process;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;

public class AgentActivity
  extends BaseActivity
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new alhj(this);
  private Intent jdField_a_of_type_AndroidContentIntent;
  protected Handler a;
  protected String a;
  protected boolean a;
  protected boolean b;
  
  public AgentActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    String str = "";
    Object localObject = str;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString1, 64).signatures;
      localObject = str;
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localObject = str;
      localMessageDigest.update(paramContext[0].toByteArray());
      localObject = str;
      paramContext = HexUtil.a(localMessageDigest.digest());
      if (paramContext == null) {
        return "";
      }
      localObject = str;
      paramContext = paramContext.toLowerCase();
      localObject = str;
      QLog.i("AgentActivity", 1, "-->getAppSignatureMD5, sign: " + paramContext);
      localObject = str;
      localMessageDigest.reset();
      localObject = str;
      localMessageDigest.update((paramString1 + "_" + paramContext + "_" + paramString2 + "").getBytes());
      localObject = str;
      paramContext = HexUtil.a(localMessageDigest.digest());
      localObject = paramContext;
      localMessageDigest.reset();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return localObject;
  }
  
  protected void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", "传入参数有误!");
    localIntent.putExtra("key_error_detail", "");
    localIntent.putExtra("key_response", "");
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  /* Error */
  public boolean doOnCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 151	com/tencent/mobileqq/app/BaseActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   5: pop
    //   6: aload_0
    //   7: invokespecial 155	com/tencent/mobileqq/app/BaseActivity:getIntent	()Landroid/content/Intent;
    //   10: ifnull +7 -> 17
    //   13: aload_1
    //   14: ifnull +70 -> 84
    //   17: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +40 -> 60
    //   23: ldc 88
    //   25: iconst_2
    //   26: new 90	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   33: ldc 161
    //   35: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: invokespecial 155	com/tencent/mobileqq/app/BaseActivity:getIntent	()Landroid/content/Intent;
    //   42: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   45: ldc 166
    //   47: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: invokestatic 174	com/tencent/open/business/viareport/OpenSdkStatic:a	()Lcom/tencent/open/business/viareport/OpenSdkStatic;
    //   63: iconst_1
    //   64: ldc 176
    //   66: aconst_null
    //   67: aconst_null
    //   68: aconst_null
    //   69: invokestatic 182	android/os/SystemClock:elapsedRealtime	()J
    //   72: invokestatic 188	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   75: iconst_0
    //   76: iconst_1
    //   77: ldc 190
    //   79: invokevirtual 193	com/tencent/open/business/viareport/OpenSdkStatic:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   82: iconst_1
    //   83: ireturn
    //   84: aload_0
    //   85: invokespecial 155	com/tencent/mobileqq/app/BaseActivity:getIntent	()Landroid/content/Intent;
    //   88: ldc 195
    //   90: invokevirtual 199	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 4
    //   95: aload_0
    //   96: aload 4
    //   98: putfield 201	com/tencent/open/agent/AgentActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   101: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +29 -> 133
    //   107: ldc 88
    //   109: iconst_2
    //   110: new 90	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   117: ldc 203
    //   119: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 4
    //   124: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_0
    //   134: invokespecial 155	com/tencent/mobileqq/app/BaseActivity:getIntent	()Landroid/content/Intent;
    //   137: ldc 205
    //   139: invokevirtual 209	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   142: astore 5
    //   144: aload 5
    //   146: ifnonnull +72 -> 218
    //   149: aload_0
    //   150: bipush 251
    //   152: invokevirtual 211	com/tencent/open/agent/AgentActivity:a	(I)V
    //   155: ldc 213
    //   157: aload 4
    //   159: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   162: ifeq +25 -> 187
    //   165: invokestatic 174	com/tencent/open/business/viareport/OpenSdkStatic:a	()Lcom/tencent/open/business/viareport/OpenSdkStatic;
    //   168: iconst_1
    //   169: ldc 176
    //   171: aconst_null
    //   172: aconst_null
    //   173: aconst_null
    //   174: invokestatic 182	android/os/SystemClock:elapsedRealtime	()J
    //   177: invokestatic 188	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   180: iconst_0
    //   181: iconst_1
    //   182: ldc 219
    //   184: invokevirtual 193	com/tencent/open/business/viareport/OpenSdkStatic:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   187: iconst_1
    //   188: ireturn
    //   189: astore_1
    //   190: ldc 36
    //   192: astore 4
    //   194: goto -99 -> 95
    //   197: astore_1
    //   198: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +11 -> 212
    //   204: ldc 88
    //   206: iconst_2
    //   207: ldc 221
    //   209: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aconst_null
    //   213: astore 5
    //   215: goto -71 -> 144
    //   218: aload 5
    //   220: ldc 223
    //   222: invokevirtual 228	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   225: astore 9
    //   227: ldc 213
    //   229: aload 4
    //   231: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   234: ifeq +679 -> 913
    //   237: new 120	android/content/Intent
    //   240: dup
    //   241: aload_0
    //   242: ldc 230
    //   244: invokespecial 233	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   247: astore 7
    //   249: aload 7
    //   251: ldc 195
    //   253: aload 4
    //   255: invokevirtual 134	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   258: pop
    //   259: ldc 36
    //   261: astore_1
    //   262: iconst_0
    //   263: istore_2
    //   264: aload_1
    //   265: astore_3
    //   266: iload_2
    //   267: iconst_3
    //   268: if_icmpge +67 -> 335
    //   271: aload_0
    //   272: invokespecial 236	com/tencent/mobileqq/app/BaseActivity:getCallingPackage	()Ljava/lang/String;
    //   275: astore_3
    //   276: aload_3
    //   277: astore_1
    //   278: aload_3
    //   279: invokestatic 242	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   282: ifeq +44 -> 326
    //   285: ldc 88
    //   287: iconst_1
    //   288: ldc 244
    //   290: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: aload_0
    //   294: invokespecial 248	com/tencent/mobileqq/app/BaseActivity:getCallingActivity	()Landroid/content/ComponentName;
    //   297: astore_1
    //   298: aload_1
    //   299: ifnull +536 -> 835
    //   302: aload_1
    //   303: invokevirtual 253	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   306: astore_3
    //   307: aload_3
    //   308: astore_1
    //   309: aload_3
    //   310: invokestatic 242	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   313: ifeq +13 -> 326
    //   316: ldc 88
    //   318: iconst_1
    //   319: ldc 255
    //   321: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload_3
    //   325: astore_1
    //   326: aload_1
    //   327: invokestatic 242	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   330: ifne +519 -> 849
    //   333: aload_1
    //   334: astore_3
    //   335: aload_3
    //   336: invokestatic 242	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   339: ifne +534 -> 873
    //   342: new 90	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   349: invokestatic 260	java/lang/System:currentTimeMillis	()J
    //   352: ldc2_w 261
    //   355: ldiv
    //   356: invokevirtual 265	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   359: ldc 36
    //   361: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: astore 10
    //   369: ldc 36
    //   371: astore 8
    //   373: aload_0
    //   374: invokevirtual 266	com/tencent/open/agent/AgentActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   377: astore_1
    //   378: aload_1
    //   379: aload_3
    //   380: bipush 64
    //   382: invokevirtual 48	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   385: getfield 54	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   388: astore_1
    //   389: ldc 56
    //   391: invokestatic 62	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   394: astore 6
    //   396: aload 6
    //   398: aload_1
    //   399: iconst_0
    //   400: aaload
    //   401: invokevirtual 68	android/content/pm/Signature:toByteArray	()[B
    //   404: invokevirtual 72	java/security/MessageDigest:update	([B)V
    //   407: aload 6
    //   409: invokevirtual 75	java/security/MessageDigest:digest	()[B
    //   412: invokestatic 80	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   415: invokevirtual 86	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   418: astore_1
    //   419: aload 6
    //   421: invokevirtual 109	java/security/MessageDigest:reset	()V
    //   424: aload 6
    //   426: new 90	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   433: aload_3
    //   434: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: ldc 111
    //   439: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_1
    //   443: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: ldc 111
    //   448: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload 10
    //   453: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: ldc 36
    //   458: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokevirtual 114	java/lang/String:getBytes	()[B
    //   467: invokevirtual 72	java/security/MessageDigest:update	([B)V
    //   470: aload 6
    //   472: invokevirtual 75	java/security/MessageDigest:digest	()[B
    //   475: invokestatic 80	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   478: astore 6
    //   480: ldc 88
    //   482: iconst_1
    //   483: new 90	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   490: ldc_w 268
    //   493: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload 9
    //   498: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: ldc_w 270
    //   504: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload_3
    //   508: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: ldc_w 272
    //   514: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload_1
    //   518: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   527: aload 5
    //   529: ldc_w 274
    //   532: aload_3
    //   533: invokevirtual 278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: aload 5
    //   538: ldc_w 280
    //   541: aload_1
    //   542: invokevirtual 278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   545: aload 5
    //   547: ldc_w 282
    //   550: aload 6
    //   552: invokevirtual 278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   555: aload 5
    //   557: ldc_w 284
    //   560: aload 10
    //   562: invokevirtual 278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   565: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   568: ifeq +30 -> 598
    //   571: ldc 88
    //   573: iconst_2
    //   574: new 90	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   581: ldc_w 286
    //   584: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 6
    //   589: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: invokestatic 174	com/tencent/open/business/viareport/OpenSdkStatic:a	()Lcom/tencent/open/business/viareport/OpenSdkStatic;
    //   601: iconst_0
    //   602: ldc 176
    //   604: aconst_null
    //   605: aload 9
    //   607: aconst_null
    //   608: invokestatic 182	android/os/SystemClock:elapsedRealtime	()J
    //   611: invokestatic 188	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   614: iconst_0
    //   615: iconst_1
    //   616: aconst_null
    //   617: invokevirtual 193	com/tencent/open/business/viareport/OpenSdkStatic:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   620: aload 7
    //   622: astore_3
    //   623: aload_3
    //   624: ifnull +623 -> 1247
    //   627: aload_3
    //   628: ldc 205
    //   630: aload 5
    //   632: invokevirtual 289	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   635: pop
    //   636: aload_0
    //   637: invokevirtual 293	com/tencent/open/agent/AgentActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   640: ifnull +601 -> 1241
    //   643: aload_0
    //   644: invokevirtual 293	com/tencent/open/agent/AgentActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   647: invokevirtual 298	com/tencent/common/app/AppInterface:isLogin	()Z
    //   650: ifne +591 -> 1241
    //   653: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   656: ifeq +12 -> 668
    //   659: ldc 88
    //   661: iconst_2
    //   662: ldc_w 300
    //   665: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: ldc 213
    //   670: aload 4
    //   672: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   675: ifne +25 -> 700
    //   678: ldc_w 302
    //   681: aload 4
    //   683: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   686: ifne +14 -> 700
    //   689: ldc_w 304
    //   692: aload 4
    //   694: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   697: ifeq +544 -> 1241
    //   700: aload_0
    //   701: aload_3
    //   702: putfield 31	com/tencent/open/agent/AgentActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   705: aload_0
    //   706: getfield 31	com/tencent/open/agent/AgentActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   709: ldc_w 306
    //   712: iconst_1
    //   713: invokevirtual 309	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   716: pop
    //   717: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   720: ifeq +12 -> 732
    //   723: ldc 88
    //   725: iconst_2
    //   726: ldc_w 311
    //   729: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   732: new 120	android/content/Intent
    //   735: dup
    //   736: aload_0
    //   737: ldc_w 313
    //   740: invokespecial 233	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   743: astore_1
    //   744: aload_1
    //   745: ldc_w 306
    //   748: iconst_1
    //   749: invokevirtual 309	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   752: pop
    //   753: ldc_w 304
    //   756: aload 4
    //   758: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   761: ifne +19 -> 780
    //   764: aload_1
    //   765: ldc_w 314
    //   768: invokevirtual 318	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   771: pop
    //   772: aload_1
    //   773: ldc_w 319
    //   776: invokevirtual 322	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   779: pop
    //   780: new 324	android/content/IntentFilter
    //   783: dup
    //   784: ldc_w 326
    //   787: invokespecial 329	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   790: astore_3
    //   791: aload_0
    //   792: aload_0
    //   793: getfield 27	com/tencent/open/agent/AgentActivity:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   796: aload_3
    //   797: invokevirtual 333	com/tencent/open/agent/AgentActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   800: pop
    //   801: aload_0
    //   802: aload_1
    //   803: invokevirtual 337	com/tencent/open/agent/AgentActivity:startActivity	(Landroid/content/Intent;)V
    //   806: invokestatic 342	com/tencent/open/agent/report/ReportCenter:a	()Lcom/tencent/open/agent/report/ReportCenter;
    //   809: aload_0
    //   810: invokevirtual 293	com/tencent/open/agent/AgentActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   813: invokevirtual 345	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   816: ldc 36
    //   818: aload 9
    //   820: ldc_w 347
    //   823: ldc_w 349
    //   826: ldc_w 351
    //   829: iconst_1
    //   830: invokevirtual 354	com/tencent/open/agent/report/ReportCenter:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   833: iconst_1
    //   834: ireturn
    //   835: ldc 88
    //   837: iconst_1
    //   838: ldc_w 356
    //   841: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   844: aload_3
    //   845: astore_1
    //   846: goto -520 -> 326
    //   849: iload_2
    //   850: iconst_1
    //   851: iadd
    //   852: istore_2
    //   853: goto -589 -> 264
    //   856: astore 6
    //   858: ldc 36
    //   860: astore_1
    //   861: aload 6
    //   863: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   866: aload 8
    //   868: astore 6
    //   870: goto -390 -> 480
    //   873: ldc 88
    //   875: iconst_1
    //   876: ldc_w 358
    //   879: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   882: invokestatic 174	com/tencent/open/business/viareport/OpenSdkStatic:a	()Lcom/tencent/open/business/viareport/OpenSdkStatic;
    //   885: iconst_1
    //   886: ldc 176
    //   888: aconst_null
    //   889: aload 9
    //   891: aconst_null
    //   892: invokestatic 182	android/os/SystemClock:elapsedRealtime	()J
    //   895: invokestatic 188	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   898: iconst_0
    //   899: iconst_1
    //   900: ldc_w 360
    //   903: invokevirtual 193	com/tencent/open/business/viareport/OpenSdkStatic:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   906: goto -286 -> 620
    //   909: astore_1
    //   910: goto -290 -> 620
    //   913: ldc_w 362
    //   916: aload 4
    //   918: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   921: ifeq +26 -> 947
    //   924: new 120	android/content/Intent
    //   927: dup
    //   928: aload_0
    //   929: ldc 230
    //   931: invokespecial 233	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   934: astore_3
    //   935: aload_3
    //   936: ldc 195
    //   938: aload 4
    //   940: invokevirtual 134	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   943: pop
    //   944: goto -321 -> 623
    //   947: ldc_w 302
    //   950: aload 4
    //   952: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   955: ifne +14 -> 969
    //   958: ldc_w 304
    //   961: aload 4
    //   963: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   966: ifeq +73 -> 1039
    //   969: aload_0
    //   970: invokespecial 236	com/tencent/mobileqq/app/BaseActivity:getCallingPackage	()Ljava/lang/String;
    //   973: astore_1
    //   974: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   977: ifeq +29 -> 1006
    //   980: ldc 88
    //   982: iconst_2
    //   983: new 90	java/lang/StringBuilder
    //   986: dup
    //   987: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   990: ldc_w 364
    //   993: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: aload_1
    //   997: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1003: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1006: new 120	android/content/Intent
    //   1009: dup
    //   1010: aload_0
    //   1011: ldc_w 366
    //   1014: invokespecial 233	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1017: astore_3
    //   1018: aload_3
    //   1019: ldc 195
    //   1021: aload 4
    //   1023: invokevirtual 134	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1026: pop
    //   1027: aload 5
    //   1029: ldc_w 274
    //   1032: aload_1
    //   1033: invokevirtual 278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1036: goto -413 -> 623
    //   1039: ldc_w 368
    //   1042: aload 4
    //   1044: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1047: ifne +36 -> 1083
    //   1050: ldc_w 370
    //   1053: aload 4
    //   1055: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1058: ifne +25 -> 1083
    //   1061: ldc_w 372
    //   1064: aload 4
    //   1066: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1069: ifne +14 -> 1083
    //   1072: ldc_w 374
    //   1075: aload 4
    //   1077: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1080: ifeq +67 -> 1147
    //   1083: new 120	android/content/Intent
    //   1086: dup
    //   1087: aload_0
    //   1088: ldc_w 376
    //   1091: invokespecial 233	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1094: astore_1
    //   1095: aload_1
    //   1096: astore_3
    //   1097: aload_1
    //   1098: ifnull -475 -> 623
    //   1101: aload_1
    //   1102: ldc 195
    //   1104: aload 4
    //   1106: invokevirtual 134	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1109: pop
    //   1110: aload 5
    //   1112: ldc_w 378
    //   1115: invokevirtual 228	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1118: astore_3
    //   1119: aload 5
    //   1121: ldc_w 380
    //   1124: aload_0
    //   1125: ldc_w 382
    //   1128: invokestatic 387	com/tencent/open/settings/OpensdkPreference:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   1131: aload_3
    //   1132: ldc 36
    //   1134: invokeinterface 392 3 0
    //   1139: invokevirtual 278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1142: aload_1
    //   1143: astore_3
    //   1144: goto -521 -> 623
    //   1147: ldc_w 394
    //   1150: aload 4
    //   1152: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1155: ifeq +18 -> 1173
    //   1158: new 120	android/content/Intent
    //   1161: dup
    //   1162: aload_0
    //   1163: ldc_w 396
    //   1166: invokespecial 233	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1169: astore_1
    //   1170: goto -75 -> 1095
    //   1173: ldc_w 398
    //   1176: aload 4
    //   1178: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1181: ifeq +18 -> 1199
    //   1184: new 120	android/content/Intent
    //   1187: dup
    //   1188: aload_0
    //   1189: ldc_w 400
    //   1192: invokespecial 233	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1195: astore_1
    //   1196: goto -101 -> 1095
    //   1199: ldc_w 402
    //   1202: aload 4
    //   1204: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1207: ifeq +18 -> 1225
    //   1210: new 120	android/content/Intent
    //   1213: dup
    //   1214: aload_0
    //   1215: ldc_w 404
    //   1218: invokespecial 233	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1221: astore_1
    //   1222: goto -127 -> 1095
    //   1225: aload_0
    //   1226: bipush 251
    //   1228: invokevirtual 211	com/tencent/open/agent/AgentActivity:a	(I)V
    //   1231: iconst_1
    //   1232: ireturn
    //   1233: astore_1
    //   1234: aload_1
    //   1235: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   1238: goto -405 -> 833
    //   1241: aload_0
    //   1242: aload_3
    //   1243: iconst_0
    //   1244: invokespecial 408	com/tencent/mobileqq/app/BaseActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   1247: iconst_1
    //   1248: ireturn
    //   1249: astore_1
    //   1250: aload_1
    //   1251: invokevirtual 409	android/content/ActivityNotFoundException:printStackTrace	()V
    //   1254: aload_0
    //   1255: bipush 250
    //   1257: invokevirtual 211	com/tencent/open/agent/AgentActivity:a	(I)V
    //   1260: aload_0
    //   1261: invokespecial 145	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   1264: goto -17 -> 1247
    //   1267: astore_1
    //   1268: goto -648 -> 620
    //   1271: astore 6
    //   1273: goto -412 -> 861
    //   1276: astore_1
    //   1277: goto -1090 -> 187
    //   1280: astore_1
    //   1281: goto -1199 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1284	0	this	AgentActivity
    //   0	1284	1	paramBundle	android.os.Bundle
    //   263	590	2	i	int
    //   265	978	3	localObject1	Object
    //   93	1110	4	str1	String
    //   142	978	5	localBundle	android.os.Bundle
    //   394	194	6	localObject2	Object
    //   856	6	6	localException1	Exception
    //   868	1	6	str2	String
    //   1271	1	6	localException2	Exception
    //   247	374	7	localIntent	Intent
    //   371	496	8	str3	String
    //   225	665	9	str4	String
    //   367	194	10	str5	String
    // Exception table:
    //   from	to	target	type
    //   84	95	189	java/lang/Exception
    //   133	144	197	java/lang/Exception
    //   378	419	856	java/lang/Exception
    //   882	906	909	java/lang/Exception
    //   806	833	1233	java/lang/Exception
    //   1241	1247	1249	android/content/ActivityNotFoundException
    //   598	620	1267	java/lang/Exception
    //   419	480	1271	java/lang/Exception
    //   165	187	1276	java/lang/Exception
    //   60	82	1280	java/lang/Exception
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((QLog.isColorLevel()) && (getAppInterface() != null)) {
      QLog.d("AgentActivity", 2, "-->onResume, app.isLogin(): " + getAppInterface().isLogin());
    }
    if (this.b)
    {
      setResult(0);
      finish();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.b = true;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AgentActivity", 2, "-->onActivityResult, action: " + this.jdField_a_of_type_JavaLangString + " | requestCode: " + paramInt1 + " | resultCode: " + paramInt2 + " | data: " + paramIntent);
    }
    super.setResult(paramInt2, paramIntent);
    super.finish();
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("AgentActivity", 2, "-->onDestroy, action: " + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      boolean bool = GesturePWDUtils.isAppOnForeground(this);
      if (!bool) {
        GesturePWDUtils.setAppForground(this, bool);
      }
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.agent.AgentActivity
 * JD-Core Version:    0.7.0.1
 */