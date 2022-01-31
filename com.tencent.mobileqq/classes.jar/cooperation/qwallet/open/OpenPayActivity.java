package cooperation.qwallet.open;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.security.MessageDigest;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class OpenPayActivity
  extends BaseActivity
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
    switch (this.b)
    {
    default: 
      return;
    }
    b(paramBundle);
  }
  
  private void b(Bundle paramBundle)
  {
    String str9 = paramBundle.getString("appId");
    String str11 = paramBundle.getString("nonce");
    long l = paramBundle.getLong("timeStamp");
    String str12 = paramBundle.getString("sig");
    String str13 = paramBundle.getString("sigType");
    String str4 = paramBundle.getString("tokenId");
    String str14 = paramBundle.getString("pubAcc");
    String str10 = paramBundle.getString("bargainorId");
    Object localObject3 = paramBundle.getString("qVersion");
    String str5 = paramBundle.getString("packageName");
    String str6 = paramBundle.getString("callbackScheme");
    String str7 = this.app.getCurrentAccountUin();
    String str8 = this.app.getCurrentNickname();
    if ((TextUtils.isEmpty(str11)) || (TextUtils.isEmpty(str12)) || (TextUtils.isEmpty(str13)) || (TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str9)) || (TextUtils.isEmpty(str10)))
    {
      paramBundle = "ai:" + str9 + " bi:" + str10 + " ti:" + str4 + " ne:" + str11 + " sg:" + str12 + " st:" + str13;
      a(-1007, "Parameters error.", null);
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.doCheckOpenPay Parameters error:" + paramBundle);
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Int != 2) || ((!TextUtils.isEmpty(str5)) && ((this.jdField_c_of_type_Int != 1) || (!TextUtils.isEmpty(str6))))) {
        break;
      }
      a(-1009, "Parameters error.", null);
    } while (!QLog.isColorLevel());
    QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.doCheckOpenPay -1009");
    return;
    try
    {
      localObject1 = getPackageManager().getPackageInfo(str5, 64);
      str1 = ((PackageInfo)localObject1).versionName;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        JSONObject localJSONObject;
        label558:
        String str1 = "";
        localException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.doCheckOpenPay Exception");
        }
        String str2 = "";
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((PackageInfo)localObject1).signatures;
        localObject2 = MessageDigest.getInstance("SHA1");
        ((MessageDigest)localObject2).reset();
        ((MessageDigest)localObject2).update(localObject1[0].toByteArray());
        localObject1 = a(((MessageDigest)localObject2).digest());
      }
      catch (Exception localException2)
      {
        break label982;
        String str3 = "";
        break;
      }
      try
      {
        localObject2 = (TicketManager)this.app.getManager(2);
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((TicketManager)localObject2).getSkey(str7);
        localJSONObject = new JSONObject();
        localJSONObject.put("appId", str9);
        localJSONObject.put("nonce", str11);
        localJSONObject.put("timeStamp", l);
        localJSONObject.put("bargainorId", str10);
        localJSONObject.put("pubAcc", str14);
        localJSONObject.put("sigType", str13);
        localJSONObject.put("sig", str12);
        localJSONObject.put("uin", str7);
        localJSONObject.put("qqVer", localObject3);
        localJSONObject.put("sKey", localObject2);
        localJSONObject.put("pkgName", str5);
        localJSONObject.put("appVer", str1);
        localJSONObject.put("pkgSha1Sig", localObject1);
        localObject2 = localJSONObject.toString();
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
        str3 = "";
        break label558;
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("ai=").append(str9);
    ((StringBuilder)localObject3).append("&ue=").append(str11);
    ((StringBuilder)localObject3).append("&ts=").append(l);
    ((StringBuilder)localObject3).append("&sg=").append(str12);
    ((StringBuilder)localObject3).append("&st=").append(str13);
    ((StringBuilder)localObject3).append("&ti=").append(str4);
    ((StringBuilder)localObject3).append("&pa=").append(str14);
    ((StringBuilder)localObject3).append("&bi=").append(str10);
    ((StringBuilder)localObject3).append("&pn=").append(str5);
    ((StringBuilder)localObject3).append("&afp=").append((String)localObject1);
    ((StringBuilder)localObject3).append("&av=").append(str1);
    VACDReportUtil.a(this.jdField_a_of_type_Long, null, "loadPluginStart", ((StringBuilder)localObject3).toString(), 0, null);
    if (QLog.isDevelopLevel()) {
      QLog.i("QWalletLoadPlugin", 4, "loadPluginStart time=" + SystemClock.elapsedRealtime());
    }
    paramBundle = paramBundle.getString("callbackSn");
    str1 = "appid#" + str9 + "|bargainor_id#" + str10 + "|channel#thirdpartapp";
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("callbackSn", paramBundle);
    ((Bundle)localObject1).putString("tokenId", str4);
    ((Bundle)localObject1).putString("userId", str7);
    ((Bundle)localObject1).putString("userName", str8);
    ((Bundle)localObject1).putInt("comeForm", 4);
    ((Bundle)localObject1).putString("appInfo", str1);
    ((Bundle)localObject1).putInt("sdkChannel", 1);
    ((Bundle)localObject1).putString("sdkData", (String)localObject2);
    ((Bundle)localObject1).putString("packageName", str5);
    ((Bundle)localObject1).putString("callbackScheme", str6);
    ((Bundle)localObject1).putInt("appPayType", this.jdField_c_of_type_Int);
    ((Bundle)localObject1).putInt("PayInvokerId", 9);
    ((Bundle)localObject1).putInt("payparmas_paytype", 4);
    ((Bundle)localObject1).putLong("vacreport_key_seq", this.jdField_a_of_type_Long);
    QWalletPayBridge.launchForeground(this, this.app, (Bundle)localObject1);
    finish();
  }
  
  /* Error */
  private void c(Bundle paramBundle)
  {
    // Byte code:
    //   0: new 345	bgwq
    //   3: dup
    //   4: invokespecial 346	bgwq:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: iconst_1
    //   12: putfield 347	bgwq:jdField_d_of_type_Int	I
    //   15: aload 5
    //   17: ldc_w 349
    //   20: putfield 351	bgwq:b	Ljava/lang/String;
    //   23: aload 5
    //   25: aload_1
    //   26: ldc_w 290
    //   29: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: putfield 353	bgwq:i	Ljava/lang/String;
    //   35: aload 5
    //   37: aload_1
    //   38: ldc_w 355
    //   41: invokevirtual 359	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   44: putfield 360	bgwq:jdField_c_of_type_Int	I
    //   47: aload 5
    //   49: aload_1
    //   50: ldc_w 362
    //   53: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: putfield 364	bgwq:a	Ljava/lang/String;
    //   59: aload 5
    //   61: ldc 64
    //   63: putfield 367	bgwq:j	Ljava/lang/String;
    //   66: aload 5
    //   68: invokevirtual 369	bgwq:a	()Z
    //   71: ifeq +75 -> 146
    //   74: aload 5
    //   76: aload_1
    //   77: ldc_w 371
    //   80: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: putfield 373	bgwq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   86: aload 5
    //   88: aload_1
    //   89: ldc_w 375
    //   92: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   95: putfield 377	bgwq:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   98: aload 5
    //   100: aload_1
    //   101: ldc_w 379
    //   104: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: putfield 381	bgwq:e	Ljava/lang/String;
    //   110: aload 5
    //   112: aload_1
    //   113: ldc_w 383
    //   116: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: putfield 386	bgwq:f	Ljava/lang/String;
    //   122: aload 5
    //   124: aload_1
    //   125: ldc_w 388
    //   128: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: putfield 391	bgwq:g	Ljava/lang/String;
    //   134: aload 5
    //   136: aload_1
    //   137: ldc_w 393
    //   140: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield 396	bgwq:h	Ljava/lang/String;
    //   146: aload_0
    //   147: getfield 398	cooperation/qwallet/open/OpenPayActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   150: ldc 99
    //   152: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: astore_2
    //   156: aload_0
    //   157: getfield 398	cooperation/qwallet/open/OpenPayActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   160: ldc 101
    //   162: invokevirtual 77	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: astore_3
    //   166: aload_2
    //   167: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifne +10 -> 180
    //   173: aload_3
    //   174: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifeq +24 -> 201
    //   180: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +13 -> 196
    //   186: ldc_w 400
    //   189: iconst_2
    //   190: ldc_w 402
    //   193: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_0
    //   197: invokespecial 403	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   200: return
    //   201: new 405	android/content/Intent
    //   204: dup
    //   205: invokespecial 406	android/content/Intent:<init>	()V
    //   208: astore 4
    //   210: aload_0
    //   211: getfield 44	cooperation/qwallet/open/OpenPayActivity:jdField_c_of_type_Int	I
    //   214: iconst_2
    //   215: if_icmpne +124 -> 339
    //   218: aload 5
    //   220: invokevirtual 408	bgwq:a	()Ljava/lang/String;
    //   223: astore_1
    //   224: aload_1
    //   225: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifne +105 -> 333
    //   231: new 410	java/lang/String
    //   234: dup
    //   235: aload_1
    //   236: invokevirtual 413	java/lang/String:getBytes	()[B
    //   239: iconst_0
    //   240: invokestatic 419	bbca:encode	([BI)[B
    //   243: invokespecial 421	java/lang/String:<init>	([B)V
    //   246: astore_1
    //   247: aload 4
    //   249: ldc_w 423
    //   252: invokevirtual 427	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   255: pop
    //   256: aload 4
    //   258: new 47	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   265: aload_3
    //   266: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc_w 429
    //   272: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 435	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   285: invokevirtual 439	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   288: pop
    //   289: aload 4
    //   291: aload_2
    //   292: invokevirtual 442	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   295: pop
    //   296: aload 4
    //   298: ldc_w 443
    //   301: invokevirtual 447	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   304: pop
    //   305: aload 4
    //   307: ldc_w 449
    //   310: ldc_w 451
    //   313: invokevirtual 455	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   316: pop
    //   317: aload_0
    //   318: aload 4
    //   320: invokespecial 459	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   323: aload_0
    //   324: invokespecial 403	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   327: return
    //   328: astore_1
    //   329: aload_1
    //   330: invokevirtual 341	java/lang/Exception:printStackTrace	()V
    //   333: ldc 64
    //   335: astore_1
    //   336: goto -89 -> 247
    //   339: new 73	android/os/Bundle
    //   342: dup
    //   343: invokespecial 297	android/os/Bundle:<init>	()V
    //   346: astore_1
    //   347: aload 5
    //   349: aload_1
    //   350: invokevirtual 461	bgwq:a	(Landroid/os/Bundle;)V
    //   353: aload 4
    //   355: ldc_w 423
    //   358: invokevirtual 427	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   361: pop
    //   362: aload 4
    //   364: new 47	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   371: aload_3
    //   372: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc_w 463
    //   378: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 435	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   387: invokevirtual 439	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   390: pop
    //   391: aload 4
    //   393: aload_2
    //   394: invokevirtual 442	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   397: pop
    //   398: aload 4
    //   400: ldc_w 443
    //   403: invokevirtual 447	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   406: pop
    //   407: aload 4
    //   409: aload_1
    //   410: invokevirtual 467	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   413: pop
    //   414: aload 4
    //   416: ldc_w 449
    //   419: ldc_w 451
    //   422: invokevirtual 455	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   425: pop
    //   426: goto -109 -> 317
    //   429: astore_1
    //   430: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq +36 -> 469
    //   436: ldc_w 400
    //   439: iconst_2
    //   440: new 47	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   447: ldc_w 469
    //   450: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload_1
    //   454: invokevirtual 472	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   457: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: goto -143 -> 323
    //   469: invokestatic 275	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   472: ifeq -149 -> 323
    //   475: aload_1
    //   476: invokevirtual 341	java/lang/Exception:printStackTrace	()V
    //   479: goto -156 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	this	OpenPayActivity
    //   0	482	1	paramBundle	Bundle
    //   155	239	2	str1	String
    //   165	207	3	str2	String
    //   208	207	4	localIntent	Intent
    //   7	341	5	localbgwq	bgwq
    // Exception table:
    //   from	to	target	type
    //   231	247	328	java/lang/Exception
    //   317	323	429	java/lang/Exception
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
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      super.finish();
      return;
    }
    c(paramString2);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " OpenPayActivity.doOnCreate");
    }
    paramBundle = super.getIntent().getExtras();
    if ((this.app == null) || (paramBundle == null))
    {
      a(-1001, "Parameters error.", null);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay", 2, "OpenPayActivity.doOnCreate app == null || bundle == null");
      }
      return true;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_d_of_type_Int = paramBundle.getInt("extra.key.pay.type");
    this.jdField_a_of_type_Int = paramBundle.getInt("extra.key.pay.from", -1);
    this.b = paramBundle.getInt("extra.key.pay.platform", -1);
    this.jdField_c_of_type_Int = paramBundle.getInt("extra.key.app.type", -1);
    this.jdField_a_of_type_Long = paramBundle.getLong("vacreport_key_seq", 0L);
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      a(-1002, "Parameters error.", null);
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.doOnCreate mPayType error");
      }
      break;
    }
    while (BaseApplicationImpl.appStartTime > 0L)
    {
      Log.d("AutoMonitor", "actStartPay, cost=" + (SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime));
      return true;
      a(paramBundle);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qwallet.open.OpenPayActivity
 * JD-Core Version:    0.7.0.1
 */