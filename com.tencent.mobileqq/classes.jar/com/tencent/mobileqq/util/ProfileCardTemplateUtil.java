package com.tencent.mobileqq.util;

import android.content.Context;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class ProfileCardTemplateUtil
{
  public static ArrayList<ProfileCardTemplate> a = new ArrayList();
  public static String b = "";
  
  public static ProfileCardTemplate a(long paramLong, boolean paramBoolean)
  {
    long l = ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID;
    Object localObject = null;
    if (paramLong == l) {
      return null;
    }
    int j = 1;
    ArrayList localArrayList = a(true, paramBoolean);
    int k = localArrayList.size();
    ProfileCardTemplate localProfileCardTemplate = null;
    int i = 0;
    while (i < k)
    {
      localProfileCardTemplate = (ProfileCardTemplate)localArrayList.get(i);
      if ((localProfileCardTemplate != null) && (localProfileCardTemplate.styleId == paramLong))
      {
        i = j;
        break label86;
      }
      i += 1;
    }
    i = 0;
    label86:
    if (i != 0) {
      localObject = localProfileCardTemplate;
    }
    return localObject;
  }
  
  public static ProfileCardTemplate a(ProfileCardTemplate paramProfileCardTemplate)
  {
    if (paramProfileCardTemplate == null) {
      return null;
    }
    ProfileCardTemplate localProfileCardTemplate = new ProfileCardTemplate();
    localProfileCardTemplate.styleId = paramProfileCardTemplate.styleId;
    localProfileCardTemplate.name = paramProfileCardTemplate.name;
    localProfileCardTemplate.version = paramProfileCardTemplate.version;
    localProfileCardTemplate.auth = paramProfileCardTemplate.auth;
    localProfileCardTemplate.tag = paramProfileCardTemplate.tag;
    localProfileCardTemplate.tagBeginTime = paramProfileCardTemplate.tagBeginTime;
    localProfileCardTemplate.tagEndTime = paramProfileCardTemplate.tagEndTime;
    localProfileCardTemplate.imageBlack = paramProfileCardTemplate.imageBlack;
    localProfileCardTemplate.imageBlackMin = paramProfileCardTemplate.imageBlackMin;
    localProfileCardTemplate.imageBlackMax = paramProfileCardTemplate.imageBlackMax;
    localProfileCardTemplate.imageBlackSmall = paramProfileCardTemplate.imageBlackSmall;
    localProfileCardTemplate.imageWhite = paramProfileCardTemplate.imageWhite;
    localProfileCardTemplate.imageWhiteMin = paramProfileCardTemplate.imageWhiteMin;
    localProfileCardTemplate.imageWhiteMax = paramProfileCardTemplate.imageWhiteMax;
    localProfileCardTemplate.imageWhiteSmall = paramProfileCardTemplate.imageWhiteSmall;
    localProfileCardTemplate.animation = paramProfileCardTemplate.animation;
    localProfileCardTemplate.frameBlack = paramProfileCardTemplate.frameBlack;
    localProfileCardTemplate.frameBlackMin = paramProfileCardTemplate.frameBlackMin;
    localProfileCardTemplate.frameBlackMax = paramProfileCardTemplate.frameBlackMax;
    localProfileCardTemplate.frameBlackSmall = paramProfileCardTemplate.frameBlackSmall;
    localProfileCardTemplate.frameWhite = paramProfileCardTemplate.frameWhite;
    localProfileCardTemplate.frameWhiteMax = paramProfileCardTemplate.frameWhiteMax;
    localProfileCardTemplate.frameWhiteMin = paramProfileCardTemplate.frameWhiteMin;
    localProfileCardTemplate.frameWhiteSmall = paramProfileCardTemplate.frameWhiteSmall;
    localProfileCardTemplate.imageSize = paramProfileCardTemplate.imageSize;
    localProfileCardTemplate.downloadUrl = paramProfileCardTemplate.downloadUrl;
    localProfileCardTemplate.size = paramProfileCardTemplate.size;
    localProfileCardTemplate.templateBeginTime = paramProfileCardTemplate.templateBeginTime;
    localProfileCardTemplate.templateEndTime = paramProfileCardTemplate.templateEndTime;
    localProfileCardTemplate.limitefreeType = paramProfileCardTemplate.limitefreeType;
    localProfileCardTemplate.limitefreeBtime = paramProfileCardTemplate.limitefreeBtime;
    localProfileCardTemplate.limitefreeEtime = paramProfileCardTemplate.limitefreeEtime;
    localProfileCardTemplate.customBackgroundAuth = paramProfileCardTemplate.customBackgroundAuth;
    localProfileCardTemplate.isHide = paramProfileCardTemplate.isHide;
    return localProfileCardTemplate;
  }
  
  public static String a(long paramLong)
  {
    String str = BaseApplication.getContext().getDir(".profilecard", 0).getAbsolutePath();
    StringBuilder localStringBuilder;
    if (paramLong == -1L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("common_");
      localStringBuilder.append("583");
      return localStringBuilder.toString();
    }
    if ((paramLong != ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID) && (paramLong > 0L))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramLong);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getDir(".profilecard", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qvip_profile_label_config.json");
    localStringBuilder.append("8.8.17");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static ArrayList<ProfileCardTemplate> a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 209
    //   8: iconst_2
    //   9: ldc 211
    //   11: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: invokestatic 154	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   17: astore 5
    //   19: aload 5
    //   21: invokestatic 217	com/tencent/mobileqq/util/ProfileCardTemplateUtil:b	(Landroid/content/Context;)Ljava/lang/String;
    //   24: astore 8
    //   26: new 162	java/io/File
    //   29: dup
    //   30: aload 8
    //   32: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 6
    //   37: aload 6
    //   39: invokevirtual 223	java/io/File:exists	()Z
    //   42: istore 4
    //   44: iload 4
    //   46: ifne +7 -> 53
    //   49: ldc 225
    //   51: astore 8
    //   53: getstatic 22	com/tencent/mobileqq/util/ProfileCardTemplateUtil:b	Ljava/lang/String;
    //   56: aload 8
    //   58: invokestatic 231	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   61: ifeq +20 -> 81
    //   64: getstatic 18	com/tencent/mobileqq/util/ProfileCardTemplateUtil:a	Ljava/util/ArrayList;
    //   67: invokevirtual 234	java/util/ArrayList:isEmpty	()Z
    //   70: ifne +11 -> 81
    //   73: iload_0
    //   74: ifne +7 -> 81
    //   77: getstatic 18	com/tencent/mobileqq/util/ProfileCardTemplateUtil:a	Ljava/util/ArrayList;
    //   80: areturn
    //   81: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +11 -> 95
    //   87: ldc 209
    //   89: iconst_2
    //   90: ldc 236
    //   92: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: new 13	java/util/ArrayList
    //   98: dup
    //   99: invokespecial 16	java/util/ArrayList:<init>	()V
    //   102: astore 10
    //   104: aconst_null
    //   105: astore 7
    //   107: iload 4
    //   109: ifeq +17 -> 126
    //   112: new 238	java/io/FileInputStream
    //   115: dup
    //   116: aload 6
    //   118: invokespecial 241	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   121: astore 5
    //   123: goto +15 -> 138
    //   126: aload 5
    //   128: invokevirtual 245	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   131: ldc 247
    //   133: invokevirtual 253	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   136: astore 5
    //   138: new 255	java/io/ByteArrayOutputStream
    //   141: dup
    //   142: invokespecial 256	java/io/ByteArrayOutputStream:<init>	()V
    //   145: astore 6
    //   147: sipush 4096
    //   150: newarray byte
    //   152: astore 7
    //   154: aload 5
    //   156: aload 7
    //   158: iconst_0
    //   159: sipush 4096
    //   162: invokevirtual 262	java/io/InputStream:read	([BII)I
    //   165: istore_1
    //   166: iload_1
    //   167: iconst_m1
    //   168: if_icmpeq +15 -> 183
    //   171: aload 6
    //   173: aload 7
    //   175: iconst_0
    //   176: iload_1
    //   177: invokevirtual 266	java/io/ByteArrayOutputStream:write	([BII)V
    //   180: goto -26 -> 154
    //   183: new 268	java/lang/String
    //   186: dup
    //   187: aload 6
    //   189: invokevirtual 272	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   192: ldc_w 274
    //   195: invokespecial 277	java/lang/String:<init>	([BLjava/lang/String;)V
    //   198: astore 7
    //   200: aload 7
    //   202: invokevirtual 280	java/lang/String:length	()I
    //   205: ifle +628 -> 833
    //   208: new 282	org/json/JSONObject
    //   211: dup
    //   212: aload 7
    //   214: invokespecial 283	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   217: astore 7
    //   219: aload 7
    //   221: ldc_w 285
    //   224: invokevirtual 289	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   227: ifeq +606 -> 833
    //   230: aload 7
    //   232: ldc_w 285
    //   235: invokevirtual 293	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   238: astore 7
    //   240: aload 7
    //   242: invokevirtual 296	org/json/JSONArray:length	()I
    //   245: istore_2
    //   246: iconst_0
    //   247: istore_1
    //   248: iconst_1
    //   249: istore_0
    //   250: iload_1
    //   251: iload_2
    //   252: if_icmpge +488 -> 740
    //   255: aload 7
    //   257: iload_1
    //   258: invokevirtual 300	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   261: astore 9
    //   263: new 27	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate
    //   266: dup
    //   267: invokespecial 47	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:<init>	()V
    //   270: astore 11
    //   272: aload 11
    //   274: aload 9
    //   276: ldc_w 302
    //   279: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   282: i2l
    //   283: putfield 45	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:styleId	J
    //   286: aload 11
    //   288: aload 9
    //   290: ldc_w 307
    //   293: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   296: putfield 50	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:name	Ljava/lang/String;
    //   299: aload 11
    //   301: aload 9
    //   303: ldc_w 312
    //   306: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   309: putfield 53	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:version	Ljava/lang/String;
    //   312: aload 11
    //   314: aload 9
    //   316: ldc_w 313
    //   319: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   322: putfield 56	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:auth	Ljava/lang/String;
    //   325: aload 11
    //   327: aload 9
    //   329: ldc_w 314
    //   332: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   335: putfield 60	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:tag	I
    //   338: aload 11
    //   340: aload 9
    //   342: ldc_w 316
    //   345: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   348: putfield 63	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:tagBeginTime	I
    //   351: aload 11
    //   353: aload 9
    //   355: ldc_w 318
    //   358: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   361: putfield 66	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:tagEndTime	I
    //   364: aload 11
    //   366: aload 9
    //   368: ldc_w 320
    //   371: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   374: putfield 69	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageBlack	Ljava/lang/String;
    //   377: aload 11
    //   379: aload 9
    //   381: ldc_w 322
    //   384: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   387: putfield 72	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageBlackMin	Ljava/lang/String;
    //   390: aload 11
    //   392: aload 9
    //   394: ldc_w 324
    //   397: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   400: putfield 75	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageBlackMax	Ljava/lang/String;
    //   403: aload 11
    //   405: aload 9
    //   407: ldc_w 326
    //   410: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   413: putfield 78	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageBlackSmall	Ljava/lang/String;
    //   416: aload 11
    //   418: aload 9
    //   420: ldc_w 328
    //   423: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   426: putfield 81	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageWhite	Ljava/lang/String;
    //   429: aload 11
    //   431: aload 9
    //   433: ldc_w 330
    //   436: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   439: putfield 84	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageWhiteMin	Ljava/lang/String;
    //   442: aload 11
    //   444: aload 9
    //   446: ldc_w 332
    //   449: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   452: putfield 87	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageWhiteMax	Ljava/lang/String;
    //   455: aload 11
    //   457: aload 9
    //   459: ldc_w 334
    //   462: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   465: putfield 90	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageWhiteSmall	Ljava/lang/String;
    //   468: aload 11
    //   470: aload 9
    //   472: ldc_w 335
    //   475: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   478: putfield 93	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:animation	I
    //   481: aload 11
    //   483: aload 9
    //   485: ldc_w 337
    //   488: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   491: putfield 96	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameBlack	Ljava/lang/String;
    //   494: aload 11
    //   496: aload 9
    //   498: ldc_w 339
    //   501: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   504: putfield 99	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameBlackMin	Ljava/lang/String;
    //   507: aload 11
    //   509: aload 9
    //   511: ldc_w 341
    //   514: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   517: putfield 102	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameBlackMax	Ljava/lang/String;
    //   520: aload 11
    //   522: aload 9
    //   524: ldc_w 343
    //   527: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   530: putfield 105	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameBlackSmall	Ljava/lang/String;
    //   533: aload 11
    //   535: aload 9
    //   537: ldc_w 345
    //   540: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   543: putfield 108	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameWhite	Ljava/lang/String;
    //   546: aload 11
    //   548: aload 9
    //   550: ldc_w 347
    //   553: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   556: putfield 111	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameWhiteMax	Ljava/lang/String;
    //   559: aload 11
    //   561: aload 9
    //   563: ldc_w 349
    //   566: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   569: putfield 114	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameWhiteMin	Ljava/lang/String;
    //   572: aload 11
    //   574: aload 9
    //   576: ldc_w 351
    //   579: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   582: putfield 117	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameWhiteSmall	Ljava/lang/String;
    //   585: aload 11
    //   587: aload 9
    //   589: ldc_w 352
    //   592: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   595: putfield 120	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageSize	I
    //   598: aload 11
    //   600: aload 9
    //   602: ldc_w 354
    //   605: invokevirtual 311	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   608: putfield 123	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:downloadUrl	Ljava/lang/String;
    //   611: aload 11
    //   613: aload 9
    //   615: ldc_w 356
    //   618: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   621: putfield 125	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:size	I
    //   624: aload 11
    //   626: aload 9
    //   628: ldc_w 358
    //   631: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   634: putfield 128	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:templateBeginTime	I
    //   637: aload 11
    //   639: aload 9
    //   641: ldc_w 360
    //   644: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   647: putfield 131	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:templateEndTime	I
    //   650: aload 11
    //   652: aload 9
    //   654: ldc_w 362
    //   657: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   660: putfield 134	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:limitefreeType	I
    //   663: aload 11
    //   665: aload 9
    //   667: ldc_w 364
    //   670: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   673: putfield 137	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:limitefreeBtime	I
    //   676: aload 11
    //   678: aload 9
    //   680: ldc_w 366
    //   683: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   686: putfield 140	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:limitefreeEtime	I
    //   689: aload 9
    //   691: ldc_w 368
    //   694: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   697: istore_3
    //   698: aload 11
    //   700: aload 9
    //   702: ldc_w 370
    //   705: invokevirtual 306	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   708: putfield 143	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:customBackgroundAuth	I
    //   711: iload_3
    //   712: iconst_1
    //   713: if_icmpne +304 -> 1017
    //   716: goto +3 -> 719
    //   719: aload 11
    //   721: iload_0
    //   722: putfield 147	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:isHide	Z
    //   725: aload 10
    //   727: aload 11
    //   729: invokevirtual 374	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   732: pop
    //   733: iload_1
    //   734: iconst_1
    //   735: iadd
    //   736: istore_1
    //   737: goto -489 -> 248
    //   740: new 27	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate
    //   743: dup
    //   744: invokespecial 47	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:<init>	()V
    //   747: astore 7
    //   749: aload 7
    //   751: ldc2_w 375
    //   754: putfield 45	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:styleId	J
    //   757: aload 7
    //   759: iconst_1
    //   760: putfield 147	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:isHide	Z
    //   763: aload 10
    //   765: aload 7
    //   767: invokevirtual 374	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   770: pop
    //   771: new 27	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate
    //   774: dup
    //   775: invokespecial 47	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:<init>	()V
    //   778: astore 7
    //   780: aload 7
    //   782: ldc2_w 377
    //   785: putfield 45	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:styleId	J
    //   788: aload 7
    //   790: iconst_1
    //   791: putfield 147	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:isHide	Z
    //   794: aload 10
    //   796: aload 7
    //   798: invokevirtual 374	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   801: pop
    //   802: new 27	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate
    //   805: dup
    //   806: invokespecial 47	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:<init>	()V
    //   809: astore 7
    //   811: aload 7
    //   813: ldc2_w 379
    //   816: putfield 45	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:styleId	J
    //   819: aload 7
    //   821: iconst_1
    //   822: putfield 147	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:isHide	Z
    //   825: aload 10
    //   827: aload 7
    //   829: invokevirtual 374	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   832: pop
    //   833: aload 5
    //   835: ifnull +11 -> 846
    //   838: aload 5
    //   840: invokevirtual 383	java/io/InputStream:close	()V
    //   843: goto +3 -> 846
    //   846: aload 6
    //   848: invokevirtual 384	java/io/ByteArrayOutputStream:close	()V
    //   851: goto +111 -> 962
    //   854: aload 5
    //   856: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   859: goto +103 -> 962
    //   862: astore 8
    //   864: aload 5
    //   866: astore 7
    //   868: aload 6
    //   870: astore 5
    //   872: aload 8
    //   874: astore 6
    //   876: goto +101 -> 977
    //   879: astore 7
    //   881: goto +24 -> 905
    //   884: astore 6
    //   886: aconst_null
    //   887: astore 8
    //   889: aload 5
    //   891: astore 7
    //   893: aload 8
    //   895: astore 5
    //   897: goto +80 -> 977
    //   900: astore 7
    //   902: aconst_null
    //   903: astore 6
    //   905: aload 7
    //   907: astore 9
    //   909: aload 5
    //   911: astore 7
    //   913: aload 6
    //   915: astore 5
    //   917: goto +20 -> 937
    //   920: astore 6
    //   922: aconst_null
    //   923: astore 7
    //   925: aload 7
    //   927: astore 5
    //   929: goto +48 -> 977
    //   932: astore 9
    //   934: aconst_null
    //   935: astore 5
    //   937: aload 9
    //   939: invokevirtual 388	java/lang/Throwable:printStackTrace	()V
    //   942: aload 7
    //   944: ifnull +8 -> 952
    //   947: aload 7
    //   949: invokevirtual 383	java/io/InputStream:close	()V
    //   952: aload 5
    //   954: ifnull +8 -> 962
    //   957: aload 5
    //   959: invokevirtual 384	java/io/ByteArrayOutputStream:close	()V
    //   962: aload 8
    //   964: putstatic 22	com/tencent/mobileqq/util/ProfileCardTemplateUtil:b	Ljava/lang/String;
    //   967: aload 10
    //   969: putstatic 18	com/tencent/mobileqq/util/ProfileCardTemplateUtil:a	Ljava/util/ArrayList;
    //   972: aload 10
    //   974: areturn
    //   975: astore 6
    //   977: aload 7
    //   979: ifnull +11 -> 990
    //   982: aload 7
    //   984: invokevirtual 383	java/io/InputStream:close	()V
    //   987: goto +3 -> 990
    //   990: aload 5
    //   992: ifnull +16 -> 1008
    //   995: aload 5
    //   997: invokevirtual 384	java/io/ByteArrayOutputStream:close	()V
    //   1000: goto +8 -> 1008
    //   1003: aload 5
    //   1005: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   1008: goto +6 -> 1014
    //   1011: aload 6
    //   1013: athrow
    //   1014: goto -3 -> 1011
    //   1017: iconst_0
    //   1018: istore_0
    //   1019: goto -300 -> 719
    //   1022: astore 5
    //   1024: goto -170 -> 854
    //   1027: astore 5
    //   1029: goto -26 -> 1003
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1032	0	paramBoolean	boolean
    //   165	572	1	i	int
    //   245	8	2	j	int
    //   697	17	3	k	int
    //   42	66	4	bool	boolean
    //   17	987	5	localObject1	Object
    //   1022	1	5	localIOException1	java.io.IOException
    //   1027	1	5	localIOException2	java.io.IOException
    //   35	840	6	localObject2	Object
    //   884	1	6	localObject3	Object
    //   903	11	6	localObject4	Object
    //   920	1	6	localObject5	Object
    //   975	37	6	localObject6	Object
    //   105	762	7	localObject7	Object
    //   879	1	7	localThrowable1	java.lang.Throwable
    //   891	1	7	localObject8	Object
    //   900	6	7	localThrowable2	java.lang.Throwable
    //   911	72	7	localObject9	Object
    //   24	33	8	str	String
    //   862	11	8	localObject10	Object
    //   887	76	8	localObject11	Object
    //   261	647	9	localObject12	Object
    //   932	6	9	localThrowable3	java.lang.Throwable
    //   102	871	10	localArrayList	ArrayList
    //   270	458	11	localProfileCardTemplate	ProfileCardTemplate
    // Exception table:
    //   from	to	target	type
    //   147	154	862	finally
    //   154	166	862	finally
    //   171	180	862	finally
    //   183	246	862	finally
    //   255	711	862	finally
    //   719	733	862	finally
    //   740	833	862	finally
    //   147	154	879	java/lang/Throwable
    //   154	166	879	java/lang/Throwable
    //   171	180	879	java/lang/Throwable
    //   183	246	879	java/lang/Throwable
    //   255	711	879	java/lang/Throwable
    //   719	733	879	java/lang/Throwable
    //   740	833	879	java/lang/Throwable
    //   138	147	884	finally
    //   138	147	900	java/lang/Throwable
    //   112	123	920	finally
    //   126	138	920	finally
    //   112	123	932	java/lang/Throwable
    //   126	138	932	java/lang/Throwable
    //   937	942	975	finally
    //   838	843	1022	java/io/IOException
    //   846	851	1022	java/io/IOException
    //   947	952	1022	java/io/IOException
    //   957	962	1022	java/io/IOException
    //   982	987	1027	java/io/IOException
    //   995	1000	1027	java/io/IOException
  }
  
  public static ArrayList<ProfileCardTemplate> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getProfileTemplateList isReturnHidden=");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(",returnExpire=");
      ((StringBuilder)localObject1).append(paramBoolean2);
      QLog.d("Q.profilecard.FrdProfileCard", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = a(false);
    if (!((ArrayList)localObject2).isEmpty())
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ProfileCardTemplate localProfileCardTemplate = (ProfileCardTemplate)((Iterator)localObject2).next();
        if ((paramBoolean1) || (!localProfileCardTemplate.isHide)) {
          if (paramBoolean2) {
            ((ArrayList)localObject1).add(localProfileCardTemplate);
          } else if (b(localProfileCardTemplate)) {
            ((ArrayList)localObject1).add(localProfileCardTemplate);
          }
        }
      }
    }
    return localObject1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new ProfileCardTemplateUtil.1(paramQQAppInterface), 5, null, false);
  }
  
  public static boolean a()
  {
    Object localObject = a(-1L);
    boolean bool2 = false;
    if (localObject != null)
    {
      File localFile = new File((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("config_black.json");
      localObject = new File(localStringBuilder.toString());
      boolean bool1 = bool2;
      if (localFile.isDirectory())
      {
        bool1 = bool2;
        if (((File)localObject).exists()) {
          bool1 = true;
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isExistsTemplateDir common dir exists=");
        localStringBuilder.append(localFile.isDirectory());
        localStringBuilder.append(" templateConfig exists= ");
        localStringBuilder.append(((File)localObject).exists());
        QLog.d("Q.profilecard.FrdProfileCard", 2, localStringBuilder.toString());
      }
      return bool1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistsTemplateDir common path is null");
    }
    return false;
  }
  
  public static String b()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    try
    {
      if (Utils.b()) {
        return AppConstants.PROFILE_CARD_BACKGROUND_DIR;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localBaseApplication.getDir(".profilecard", 0).getAbsoluteFile());
      ((StringBuilder)localObject).append(File.separator);
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("getBGDir error, e = ");
      localStringBuilder2.append(localException);
      QLog.e("Q.profilecard.FrdProfileCard", 1, localStringBuilder2.toString());
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(localBaseApplication.getDir(".profilecard", 0).getAbsoluteFile());
      localStringBuilder1.append(File.separator);
      return localStringBuilder1.toString();
    }
  }
  
  public static String b(Context paramContext)
  {
    paramContext = paramContext.getDir(".profilecard", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qvip_profile_template.json");
    localStringBuilder.append("8.8.17");
    return localStringBuilder.toString();
  }
  
  private static boolean b(ProfileCardTemplate paramProfileCardTemplate)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (((paramProfileCardTemplate.templateBeginTime > 100) && (l < paramProfileCardTemplate.templateBeginTime)) || ((paramProfileCardTemplate.templateEndTime > 100) && (l > paramProfileCardTemplate.templateEndTime)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("filterTemplate->sytle:");
        localStringBuilder.append(paramProfileCardTemplate.styleId);
        localStringBuilder.append(",beginTime:");
        localStringBuilder.append(paramProfileCardTemplate.templateBeginTime);
        localStringBuilder.append(",endTime:");
        localStringBuilder.append(paramProfileCardTemplate.templateEndTime);
        QLog.w("ProfileCardUtil", 2, localStringBuilder.toString());
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardTemplateUtil
 * JD-Core Version:    0.7.0.1
 */