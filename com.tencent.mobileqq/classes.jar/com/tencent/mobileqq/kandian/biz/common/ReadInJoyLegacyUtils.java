package com.tencent.mobileqq.kandian.biz.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import org.json.JSONObject;

public class ReadInJoyLegacyUtils
{
  static QQCustomDialog a;
  
  public static String a(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (paramReadInJoyUserInfo != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("accountType", Integer.valueOf(paramReadInJoyUserInfo.accountType));
        localJSONObject2.putOpt("uin", paramReadInJoyUserInfo.uin);
        localJSONObject1.putOpt("accountInfo", localJSONObject2);
        localJSONObject1.putOpt("nickName", paramReadInJoyUserInfo.nick);
        localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("faceType", Integer.valueOf(paramReadInJoyUserInfo.faceType));
        localJSONObject2.putOpt("timeStamp", Long.valueOf(paramReadInJoyUserInfo.timestamp));
        localJSONObject2.putOpt("faceFlag", Integer.valueOf(paramReadInJoyUserInfo.faceFlag));
        localJSONObject2.putOpt("url", ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo));
        localJSONObject2.putOpt("sysID", Integer.valueOf(paramReadInJoyUserInfo.systemID));
        localJSONObject1.putOpt("headerInfo", localJSONObject2);
        localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("ccLevel", Integer.valueOf(paramReadInJoyUserInfo.accountLevel));
        localJSONObject2.putOpt("iconUrlSmall", paramReadInJoyUserInfo.smallIconUrl);
        localJSONObject2.putOpt("iconUrlLarge", paramReadInJoyUserInfo.largeIconUrl);
        localJSONObject1.putOpt("accountLevelInfo", localJSONObject2);
        localJSONObject2 = new JSONObject();
        if (!paramReadInJoyUserInfo.isLiving()) {
          break label342;
        }
        i = 1;
        localJSONObject2.putOpt("isLiving", Integer.valueOf(i));
        localJSONObject2.putOpt("source", Integer.valueOf(paramReadInJoyUserInfo.getLiveSource()));
        localJSONObject2.putOpt("url", paramReadInJoyUserInfo.getLiveUrl());
        localJSONObject1.putOpt("liveStatusInfo", localJSONObject2);
        localJSONObject1.putOpt("retCode", Integer.valueOf(0));
        localJSONObject1.putOpt("retMsg", "");
        paramReadInJoyUserInfo = localJSONObject1.toString();
        return paramReadInJoyUserInfo;
      }
      catch (Exception paramReadInJoyUserInfo)
      {
        QLog.e("ReadInJoy", 1, paramReadInJoyUserInfo.getMessage());
        try
        {
          localJSONObject1.putOpt("retCode", Integer.valueOf(-1));
          localJSONObject1.putOpt("retMsg", paramReadInJoyUserInfo.getMessage());
        }
        catch (Exception paramReadInJoyUserInfo)
        {
          QLog.e("ReadInJoy", 1, paramReadInJoyUserInfo.getMessage());
        }
      }
      return localJSONObject1.toString();
      label342:
      int i = 0;
    }
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, ProfileParams paramProfileParams)
  {
    Object localObject = paramProfileParams.a();
    if ((TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).jdField_b_of_type_JavaLangString)))
    {
      d(paramActivity, paramAppInterface, paramProfileParams);
      return;
    }
    if (!TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).jdField_b_of_type_JavaLangString))
    {
      String str = paramAppInterface.getCurrentAccountUin();
      if (!((ProfileParams.CurLoginUsr)localObject).jdField_b_of_type_JavaLangString.equals(str))
      {
        e(paramActivity, paramAppInterface, paramProfileParams);
        return;
      }
      d(paramActivity, paramAppInterface, paramProfileParams);
      return;
    }
    localObject = new ReadInJoyLegacyUtils.2(paramActivity, paramAppInterface, paramProfileParams);
    localObject = QZoneShareManager.getOpenID(paramAppInterface, paramProfileParams.a(), (BusinessObserver)localObject);
    if ((localObject != null) && ((b(paramActivity, (OpenID)localObject, paramAppInterface, paramProfileParams) ^ true))) {
      d(paramActivity, paramAppInterface, paramProfileParams);
    }
  }
  
  private static void a(Context paramContext, AppInterface paramAppInterface, String paramString, int paramInt, Intent paramIntent)
  {
    paramInt = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(paramAppInterface, paramString, paramInt);
    if (paramInt != -7)
    {
      if (paramInt != -6) {
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).openPublicAccountProfile(paramIntent, paramContext, paramString);
      }
    }
    else {
      CrmUtils.a(paramContext, paramIntent, paramString, false, -1, true, -1);
    }
  }
  
  /* Error */
  public static void a(JSONObject paramJSONObject, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 207
    //   3: invokevirtual 211	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 11
    //   8: aload_0
    //   9: ldc 102
    //   11: iconst_3
    //   12: invokevirtual 215	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   15: istore_2
    //   16: aload_0
    //   17: ldc 217
    //   19: ldc 118
    //   21: invokevirtual 220	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 17
    //   26: aload_0
    //   27: ldc 222
    //   29: iconst_m1
    //   30: invokevirtual 215	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   33: istore_3
    //   34: aload_0
    //   35: ldc 224
    //   37: iconst_m1
    //   38: invokevirtual 215	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   41: istore 4
    //   43: aload_0
    //   44: ldc 226
    //   46: ldc 118
    //   48: invokevirtual 220	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 13
    //   53: aload_0
    //   54: ldc 228
    //   56: ldc 118
    //   58: invokevirtual 220	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   61: astore 18
    //   63: aload_0
    //   64: ldc 230
    //   66: ldc 118
    //   68: invokevirtual 220	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 12
    //   73: aload_0
    //   74: ldc 232
    //   76: ldc2_w 233
    //   79: invokevirtual 238	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   82: lstore 7
    //   84: aload_0
    //   85: ldc 240
    //   87: ldc 118
    //   89: invokevirtual 220	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 19
    //   94: aload_0
    //   95: ldc 242
    //   97: invokevirtual 211	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 15
    //   102: aload_0
    //   103: ldc 244
    //   105: invokevirtual 211	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore 16
    //   110: aload_0
    //   111: ldc 246
    //   113: invokevirtual 250	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   116: istore 9
    //   118: aload_0
    //   119: ldc 252
    //   121: invokevirtual 255	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   124: istore 5
    //   126: aload_0
    //   127: ldc_w 257
    //   130: iconst_0
    //   131: invokevirtual 215	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   134: istore 6
    //   136: aload_0
    //   137: ldc_w 259
    //   140: iconst_1
    //   141: invokevirtual 262	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   144: istore 10
    //   146: new 264	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   153: astore_0
    //   154: aload_0
    //   155: ldc_w 267
    //   158: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_0
    //   163: aload 11
    //   165: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_0
    //   170: ldc_w 273
    //   173: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_0
    //   178: iload_2
    //   179: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_0
    //   184: ldc_w 278
    //   187: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_0
    //   192: aload 17
    //   194: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_0
    //   199: ldc_w 280
    //   202: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_0
    //   207: iload_3
    //   208: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_0
    //   213: ldc_w 282
    //   216: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_0
    //   221: iload 4
    //   223: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload_0
    //   228: ldc_w 284
    //   231: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_0
    //   236: aload 13
    //   238: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_0
    //   243: ldc_w 286
    //   246: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_0
    //   251: aload 18
    //   253: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_0
    //   258: ldc_w 288
    //   261: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload_0
    //   266: aload 12
    //   268: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload_0
    //   273: ldc_w 290
    //   276: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload_0
    //   281: lload 7
    //   283: invokevirtual 293	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_0
    //   288: ldc_w 295
    //   291: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload_0
    //   296: aload 19
    //   298: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload_0
    //   303: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: astore_0
    //   307: ldc 123
    //   309: iconst_1
    //   310: aload_0
    //   311: invokestatic 298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: new 300	android/os/Bundle
    //   317: dup
    //   318: invokespecial 301	android/os/Bundle:<init>	()V
    //   321: astore 14
    //   323: aload 14
    //   325: ldc_w 303
    //   328: new 305	com/tencent/mobileqq/kandian/biz/comment/entity/CommonCommentData
    //   331: dup
    //   332: aload 19
    //   334: iload_3
    //   335: aload 17
    //   337: iload 4
    //   339: aload 13
    //   341: aload 18
    //   343: aload 12
    //   345: lload 7
    //   347: invokespecial 308	com/tencent/mobileqq/kandian/biz/comment/entity/CommonCommentData:<init>	(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   350: invokevirtual 312	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   353: aload 14
    //   355: ldc 102
    //   357: iload_2
    //   358: invokevirtual 316	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   361: aload 14
    //   363: ldc_w 318
    //   366: aload 15
    //   368: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload 14
    //   373: ldc_w 324
    //   376: aload 16
    //   378: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: aload 14
    //   383: ldc 246
    //   385: iload 9
    //   387: invokevirtual 328	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   390: aload 14
    //   392: ldc 252
    //   394: iload 5
    //   396: invokevirtual 316	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   399: aload 14
    //   401: ldc_w 330
    //   404: iload_1
    //   405: invokevirtual 316	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   408: aload 14
    //   410: ldc_w 259
    //   413: iload 10
    //   415: invokevirtual 328	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   418: new 332	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData
    //   421: dup
    //   422: invokespecial 333	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:<init>	()V
    //   425: astore 17
    //   427: aload 17
    //   429: aload 15
    //   431: putfield 334	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   434: aload 17
    //   436: aload 16
    //   438: putfield 335	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   441: aload 17
    //   443: iload 9
    //   445: putfield 338	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:jdField_a_of_type_Boolean	Z
    //   448: aload 17
    //   450: iconst_1
    //   451: putfield 340	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:jdField_b_of_type_Boolean	Z
    //   454: new 264	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   461: astore_0
    //   462: aload_0
    //   463: ldc_w 342
    //   466: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload_0
    //   471: aload 15
    //   473: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload_0
    //   478: ldc_w 344
    //   481: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload_0
    //   486: aload 16
    //   488: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload_0
    //   493: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: astore_0
    //   497: ldc 123
    //   499: iconst_1
    //   500: aload_0
    //   501: invokestatic 298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: getstatic 350	com/tencent/mobileqq/app/QBaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/QBaseActivity;
    //   507: astore 15
    //   509: aconst_null
    //   510: astore_0
    //   511: aload 13
    //   513: ifnull +73 -> 586
    //   516: new 161	java/lang/String
    //   519: dup
    //   520: aload 13
    //   522: iconst_0
    //   523: invokestatic 356	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   526: invokespecial 359	java/lang/String:<init>	([B)V
    //   529: astore_0
    //   530: goto +56 -> 586
    //   533: aload 15
    //   535: aload 11
    //   537: aload_0
    //   538: aconst_null
    //   539: aload 12
    //   541: aload 17
    //   543: iconst_0
    //   544: iload 9
    //   546: aload 14
    //   548: invokestatic 364	com/tencent/mobileqq/kandian/biz/atlas/ReadInJoyAtlasCommentFragment:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/kandian/biz/comment/entity/AnchorData;ZZLandroid/os/Bundle;)V
    //   551: return
    //   552: astore_0
    //   553: goto +16 -> 569
    //   556: astore_0
    //   557: goto +12 -> 569
    //   560: astore_0
    //   561: goto +8 -> 569
    //   564: astore_0
    //   565: goto +4 -> 569
    //   568: astore_0
    //   569: invokestatic 367	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   572: ifeq +13 -> 585
    //   575: ldc 123
    //   577: iconst_2
    //   578: aload_0
    //   579: invokestatic 371	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   582: invokestatic 298	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   585: return
    //   586: iload 6
    //   588: iconst_1
    //   589: if_icmpne +9 -> 598
    //   592: iconst_1
    //   593: istore 9
    //   595: goto -62 -> 533
    //   598: iconst_0
    //   599: istore 9
    //   601: goto -68 -> 533
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	604	0	paramJSONObject	JSONObject
    //   0	604	1	paramInt	int
    //   15	343	2	i	int
    //   33	302	3	j	int
    //   41	297	4	k	int
    //   124	271	5	m	int
    //   134	456	6	n	int
    //   82	264	7	l	long
    //   116	484	9	bool1	boolean
    //   144	270	10	bool2	boolean
    //   6	530	11	str1	String
    //   71	469	12	str2	String
    //   51	470	13	str3	String
    //   321	226	14	localBundle	Bundle
    //   100	434	15	localObject1	Object
    //   108	379	16	str4	String
    //   24	518	17	localObject2	Object
    //   61	281	18	str5	String
    //   92	241	19	str6	String
    // Exception table:
    //   from	to	target	type
    //   497	509	552	java/lang/Exception
    //   516	530	552	java/lang/Exception
    //   533	551	552	java/lang/Exception
    //   323	497	556	java/lang/Exception
    //   307	323	560	java/lang/Exception
    //   73	307	564	java/lang/Exception
    //   0	73	568	java/lang/Exception
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, CallCommentJs paramCallCommentJs)
  {
    TroopMemberApiClient localTroopMemberApiClient = TroopMemberApiClient.a();
    localTroopMemberApiClient.a();
    a(paramJSONObject, localTroopMemberApiClient.a(new ReadInJoyLegacyUtils.1(paramCallCommentJs, paramString)));
  }
  
  private static boolean a(Context paramContext, ProfileParams paramProfileParams)
  {
    return (paramContext == null) || (paramProfileParams == null) || (paramProfileParams.a() == null) || (TextUtils.isEmpty(paramProfileParams.a()));
  }
  
  private static boolean b(Activity paramActivity, OpenID paramOpenID, AppInterface paramAppInterface, ProfileParams paramProfileParams)
  {
    if ((paramOpenID != null) && (!TextUtils.isEmpty(paramOpenID.openID)) && ((paramOpenID.openID.equals(paramProfileParams.a().jdField_a_of_type_JavaLangString) ^ true)))
    {
      e(paramActivity, paramAppInterface, paramProfileParams);
      return true;
    }
    return false;
  }
  
  private static void d(Activity paramActivity, AppInterface paramAppInterface, ProfileParams paramProfileParams)
  {
    f(paramActivity, paramAppInterface, paramProfileParams);
    paramActivity.finish();
  }
  
  private static void e(Activity paramActivity, AppInterface paramAppInterface, ProfileParams paramProfileParams)
  {
    QQCustomDialog localQQCustomDialog = a;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      a = null;
    }
    paramAppInterface = new ReadInJoyLegacyUtils.3(paramActivity, paramProfileParams, paramAppInterface);
    paramProfileParams = new ReadInJoyLegacyUtils.4(paramActivity, paramProfileParams);
    a = DialogUtil.a(paramActivity, 230);
    a.setMessage(2131695206);
    a.setTitle(2131692113);
    a.setNegativeButton(2131690728, paramAppInterface);
    a.setPositiveButton(2131718876, paramAppInterface);
    a.setOnCancelListener(paramProfileParams);
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      a.show();
      return;
    }
    catch (Exception paramActivity) {}
    a.dismiss();
    a = null;
    return;
  }
  
  private static void f(Activity paramActivity, AppInterface paramAppInterface, ProfileParams paramProfileParams)
  {
    if (a(paramActivity, paramProfileParams)) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetailActivity.class));
    localIntent.addFlags(268435456);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("profile_params", paramProfileParams);
    localBundle.putString("pkg_name", paramActivity.getIntent().getStringExtra("pkg_name"));
    localIntent.putExtras(localBundle);
    a(paramActivity, paramAppInterface, paramProfileParams.b(), paramProfileParams.a(), localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyLegacyUtils
 * JD-Core Version:    0.7.0.1
 */