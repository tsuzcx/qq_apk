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
  public static String a;
  public static ArrayList<ProfileCardTemplate> a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaLangString = "";
  }
  
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
  
  public static String a()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    try
    {
      if (Utils.a()) {
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
    localStringBuilder.append("8.7.0");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static ArrayList<ProfileCardTemplate> a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 199
    //   8: iconst_2
    //   9: ldc 234
    //   11: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: invokestatic 155	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   17: astore 5
    //   19: aload 5
    //   21: invokestatic 240	com/tencent/mobileqq/util/ProfileCardTemplateUtil:b	(Landroid/content/Context;)Ljava/lang/String;
    //   24: astore 8
    //   26: new 178	java/io/File
    //   29: dup
    //   30: aload 8
    //   32: invokespecial 243	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 6
    //   37: aload 6
    //   39: invokevirtual 246	java/io/File:exists	()Z
    //   42: istore 4
    //   44: iload 4
    //   46: ifne +7 -> 53
    //   49: ldc 248
    //   51: astore 8
    //   53: getstatic 21	com/tencent/mobileqq/util/ProfileCardTemplateUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: aload 8
    //   58: invokestatic 254	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   61: ifeq +20 -> 81
    //   64: getstatic 17	com/tencent/mobileqq/util/ProfileCardTemplateUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   67: invokevirtual 257	java/util/ArrayList:isEmpty	()Z
    //   70: ifne +11 -> 81
    //   73: iload_0
    //   74: ifne +7 -> 81
    //   77: getstatic 17	com/tencent/mobileqq/util/ProfileCardTemplateUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   80: areturn
    //   81: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +12 -> 96
    //   87: ldc 199
    //   89: iconst_2
    //   90: ldc_w 259
    //   93: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: new 12	java/util/ArrayList
    //   99: dup
    //   100: invokespecial 15	java/util/ArrayList:<init>	()V
    //   103: astore 10
    //   105: aconst_null
    //   106: astore 7
    //   108: iload 4
    //   110: ifeq +17 -> 127
    //   113: new 261	java/io/FileInputStream
    //   116: dup
    //   117: aload 6
    //   119: invokespecial 264	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   122: astore 5
    //   124: goto +16 -> 140
    //   127: aload 5
    //   129: invokevirtual 268	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   132: ldc_w 270
    //   135: invokevirtual 276	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   138: astore 5
    //   140: new 278	java/io/ByteArrayOutputStream
    //   143: dup
    //   144: invokespecial 279	java/io/ByteArrayOutputStream:<init>	()V
    //   147: astore 6
    //   149: sipush 4096
    //   152: newarray byte
    //   154: astore 7
    //   156: aload 5
    //   158: aload 7
    //   160: iconst_0
    //   161: sipush 4096
    //   164: invokevirtual 285	java/io/InputStream:read	([BII)I
    //   167: istore_1
    //   168: iload_1
    //   169: iconst_m1
    //   170: if_icmpeq +15 -> 185
    //   173: aload 6
    //   175: aload 7
    //   177: iconst_0
    //   178: iload_1
    //   179: invokevirtual 289	java/io/ByteArrayOutputStream:write	([BII)V
    //   182: goto -26 -> 156
    //   185: new 291	java/lang/String
    //   188: dup
    //   189: aload 6
    //   191: invokevirtual 295	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   194: ldc_w 297
    //   197: invokespecial 300	java/lang/String:<init>	([BLjava/lang/String;)V
    //   200: astore 7
    //   202: aload 7
    //   204: invokevirtual 303	java/lang/String:length	()I
    //   207: ifle +628 -> 835
    //   210: new 305	org/json/JSONObject
    //   213: dup
    //   214: aload 7
    //   216: invokespecial 306	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   219: astore 7
    //   221: aload 7
    //   223: ldc_w 308
    //   226: invokevirtual 312	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   229: ifeq +606 -> 835
    //   232: aload 7
    //   234: ldc_w 308
    //   237: invokevirtual 316	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   240: astore 7
    //   242: aload 7
    //   244: invokevirtual 319	org/json/JSONArray:length	()I
    //   247: istore_2
    //   248: iconst_0
    //   249: istore_1
    //   250: iconst_1
    //   251: istore_0
    //   252: iload_1
    //   253: iload_2
    //   254: if_icmpge +488 -> 742
    //   257: aload 7
    //   259: iload_1
    //   260: invokevirtual 323	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   263: astore 9
    //   265: new 26	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate
    //   268: dup
    //   269: invokespecial 46	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:<init>	()V
    //   272: astore 11
    //   274: aload 11
    //   276: aload 9
    //   278: ldc_w 325
    //   281: invokevirtual 329	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   284: i2l
    //   285: putfield 44	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:styleId	J
    //   288: aload 11
    //   290: aload 9
    //   292: ldc_w 330
    //   295: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   298: putfield 49	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:name	Ljava/lang/String;
    //   301: aload 11
    //   303: aload 9
    //   305: ldc_w 335
    //   308: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   311: putfield 52	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:version	Ljava/lang/String;
    //   314: aload 11
    //   316: aload 9
    //   318: ldc_w 336
    //   321: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   324: putfield 55	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:auth	Ljava/lang/String;
    //   327: aload 11
    //   329: aload 9
    //   331: ldc_w 337
    //   334: invokevirtual 329	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   337: putfield 59	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:tag	I
    //   340: aload 11
    //   342: aload 9
    //   344: ldc_w 339
    //   347: invokevirtual 329	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   350: putfield 62	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:tagBeginTime	I
    //   353: aload 11
    //   355: aload 9
    //   357: ldc_w 341
    //   360: invokevirtual 329	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   363: putfield 65	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:tagEndTime	I
    //   366: aload 11
    //   368: aload 9
    //   370: ldc_w 343
    //   373: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   376: putfield 68	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageBlack	Ljava/lang/String;
    //   379: aload 11
    //   381: aload 9
    //   383: ldc_w 345
    //   386: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   389: putfield 71	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageBlackMin	Ljava/lang/String;
    //   392: aload 11
    //   394: aload 9
    //   396: ldc_w 347
    //   399: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   402: putfield 74	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageBlackMax	Ljava/lang/String;
    //   405: aload 11
    //   407: aload 9
    //   409: ldc_w 349
    //   412: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   415: putfield 77	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageBlackSmall	Ljava/lang/String;
    //   418: aload 11
    //   420: aload 9
    //   422: ldc_w 351
    //   425: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   428: putfield 80	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageWhite	Ljava/lang/String;
    //   431: aload 11
    //   433: aload 9
    //   435: ldc_w 353
    //   438: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   441: putfield 83	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageWhiteMin	Ljava/lang/String;
    //   444: aload 11
    //   446: aload 9
    //   448: ldc_w 355
    //   451: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   454: putfield 86	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageWhiteMax	Ljava/lang/String;
    //   457: aload 11
    //   459: aload 9
    //   461: ldc_w 357
    //   464: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   467: putfield 89	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageWhiteSmall	Ljava/lang/String;
    //   470: aload 11
    //   472: aload 9
    //   474: ldc_w 358
    //   477: invokevirtual 329	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   480: putfield 92	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:animation	I
    //   483: aload 11
    //   485: aload 9
    //   487: ldc_w 360
    //   490: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   493: putfield 95	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameBlack	Ljava/lang/String;
    //   496: aload 11
    //   498: aload 9
    //   500: ldc_w 362
    //   503: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   506: putfield 98	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameBlackMin	Ljava/lang/String;
    //   509: aload 11
    //   511: aload 9
    //   513: ldc_w 364
    //   516: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   519: putfield 101	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameBlackMax	Ljava/lang/String;
    //   522: aload 11
    //   524: aload 9
    //   526: ldc_w 366
    //   529: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   532: putfield 104	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameBlackSmall	Ljava/lang/String;
    //   535: aload 11
    //   537: aload 9
    //   539: ldc_w 368
    //   542: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   545: putfield 107	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameWhite	Ljava/lang/String;
    //   548: aload 11
    //   550: aload 9
    //   552: ldc_w 370
    //   555: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   558: putfield 110	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameWhiteMax	Ljava/lang/String;
    //   561: aload 11
    //   563: aload 9
    //   565: ldc_w 372
    //   568: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   571: putfield 113	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameWhiteMin	Ljava/lang/String;
    //   574: aload 11
    //   576: aload 9
    //   578: ldc_w 374
    //   581: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   584: putfield 116	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:frameWhiteSmall	Ljava/lang/String;
    //   587: aload 11
    //   589: aload 9
    //   591: ldc_w 375
    //   594: invokevirtual 329	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   597: putfield 119	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:imageSize	I
    //   600: aload 11
    //   602: aload 9
    //   604: ldc_w 377
    //   607: invokevirtual 334	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   610: putfield 122	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:downloadUrl	Ljava/lang/String;
    //   613: aload 11
    //   615: aload 9
    //   617: ldc_w 379
    //   620: invokevirtual 329	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   623: putfield 124	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:size	I
    //   626: aload 11
    //   628: aload 9
    //   630: ldc_w 381
    //   633: invokevirtual 329	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   636: putfield 127	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:templateBeginTime	I
    //   639: aload 11
    //   641: aload 9
    //   643: ldc_w 383
    //   646: invokevirtual 329	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   649: putfield 130	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:templateEndTime	I
    //   652: aload 11
    //   654: aload 9
    //   656: ldc_w 385
    //   659: invokevirtual 329	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   662: putfield 133	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:limitefreeType	I
    //   665: aload 11
    //   667: aload 9
    //   669: ldc_w 387
    //   672: invokevirtual 329	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   675: putfield 136	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:limitefreeBtime	I
    //   678: aload 11
    //   680: aload 9
    //   682: ldc_w 389
    //   685: invokevirtual 329	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   688: putfield 139	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:limitefreeEtime	I
    //   691: aload 9
    //   693: ldc_w 391
    //   696: invokevirtual 329	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   699: istore_3
    //   700: aload 11
    //   702: aload 9
    //   704: ldc_w 393
    //   707: invokevirtual 329	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   710: putfield 142	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:customBackgroundAuth	I
    //   713: iload_3
    //   714: iconst_1
    //   715: if_icmpne +304 -> 1019
    //   718: goto +3 -> 721
    //   721: aload 11
    //   723: iload_0
    //   724: putfield 146	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:isHide	Z
    //   727: aload 10
    //   729: aload 11
    //   731: invokevirtual 397	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   734: pop
    //   735: iload_1
    //   736: iconst_1
    //   737: iadd
    //   738: istore_1
    //   739: goto -489 -> 250
    //   742: new 26	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate
    //   745: dup
    //   746: invokespecial 46	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:<init>	()V
    //   749: astore 7
    //   751: aload 7
    //   753: ldc2_w 398
    //   756: putfield 44	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:styleId	J
    //   759: aload 7
    //   761: iconst_1
    //   762: putfield 146	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:isHide	Z
    //   765: aload 10
    //   767: aload 7
    //   769: invokevirtual 397	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   772: pop
    //   773: new 26	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate
    //   776: dup
    //   777: invokespecial 46	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:<init>	()V
    //   780: astore 7
    //   782: aload 7
    //   784: ldc2_w 400
    //   787: putfield 44	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:styleId	J
    //   790: aload 7
    //   792: iconst_1
    //   793: putfield 146	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:isHide	Z
    //   796: aload 10
    //   798: aload 7
    //   800: invokevirtual 397	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   803: pop
    //   804: new 26	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate
    //   807: dup
    //   808: invokespecial 46	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:<init>	()V
    //   811: astore 7
    //   813: aload 7
    //   815: ldc2_w 402
    //   818: putfield 44	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:styleId	J
    //   821: aload 7
    //   823: iconst_1
    //   824: putfield 146	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:isHide	Z
    //   827: aload 10
    //   829: aload 7
    //   831: invokevirtual 397	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   834: pop
    //   835: aload 5
    //   837: ifnull +11 -> 848
    //   840: aload 5
    //   842: invokevirtual 406	java/io/InputStream:close	()V
    //   845: goto +3 -> 848
    //   848: aload 6
    //   850: invokevirtual 407	java/io/ByteArrayOutputStream:close	()V
    //   853: goto +111 -> 964
    //   856: aload 5
    //   858: invokevirtual 410	java/io/IOException:printStackTrace	()V
    //   861: goto +103 -> 964
    //   864: astore 8
    //   866: aload 5
    //   868: astore 7
    //   870: aload 6
    //   872: astore 5
    //   874: aload 8
    //   876: astore 6
    //   878: goto +101 -> 979
    //   881: astore 7
    //   883: goto +24 -> 907
    //   886: astore 6
    //   888: aconst_null
    //   889: astore 8
    //   891: aload 5
    //   893: astore 7
    //   895: aload 8
    //   897: astore 5
    //   899: goto +80 -> 979
    //   902: astore 7
    //   904: aconst_null
    //   905: astore 6
    //   907: aload 7
    //   909: astore 9
    //   911: aload 5
    //   913: astore 7
    //   915: aload 6
    //   917: astore 5
    //   919: goto +20 -> 939
    //   922: astore 6
    //   924: aconst_null
    //   925: astore 7
    //   927: aload 7
    //   929: astore 5
    //   931: goto +48 -> 979
    //   934: astore 9
    //   936: aconst_null
    //   937: astore 5
    //   939: aload 9
    //   941: invokevirtual 411	java/lang/Throwable:printStackTrace	()V
    //   944: aload 7
    //   946: ifnull +8 -> 954
    //   949: aload 7
    //   951: invokevirtual 406	java/io/InputStream:close	()V
    //   954: aload 5
    //   956: ifnull +8 -> 964
    //   959: aload 5
    //   961: invokevirtual 407	java/io/ByteArrayOutputStream:close	()V
    //   964: aload 8
    //   966: putstatic 21	com/tencent/mobileqq/util/ProfileCardTemplateUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   969: aload 10
    //   971: putstatic 17	com/tencent/mobileqq/util/ProfileCardTemplateUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   974: aload 10
    //   976: areturn
    //   977: astore 6
    //   979: aload 7
    //   981: ifnull +11 -> 992
    //   984: aload 7
    //   986: invokevirtual 406	java/io/InputStream:close	()V
    //   989: goto +3 -> 992
    //   992: aload 5
    //   994: ifnull +16 -> 1010
    //   997: aload 5
    //   999: invokevirtual 407	java/io/ByteArrayOutputStream:close	()V
    //   1002: goto +8 -> 1010
    //   1005: aload 5
    //   1007: invokevirtual 410	java/io/IOException:printStackTrace	()V
    //   1010: goto +6 -> 1016
    //   1013: aload 6
    //   1015: athrow
    //   1016: goto -3 -> 1013
    //   1019: iconst_0
    //   1020: istore_0
    //   1021: goto -300 -> 721
    //   1024: astore 5
    //   1026: goto -170 -> 856
    //   1029: astore 5
    //   1031: goto -26 -> 1005
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1034	0	paramBoolean	boolean
    //   167	572	1	i	int
    //   247	8	2	j	int
    //   699	17	3	k	int
    //   42	67	4	bool	boolean
    //   17	989	5	localObject1	Object
    //   1024	1	5	localIOException1	java.io.IOException
    //   1029	1	5	localIOException2	java.io.IOException
    //   35	842	6	localObject2	Object
    //   886	1	6	localObject3	Object
    //   905	11	6	localObject4	Object
    //   922	1	6	localObject5	Object
    //   977	37	6	localObject6	Object
    //   106	763	7	localObject7	Object
    //   881	1	7	localThrowable1	java.lang.Throwable
    //   893	1	7	localObject8	Object
    //   902	6	7	localThrowable2	java.lang.Throwable
    //   913	72	7	localObject9	Object
    //   24	33	8	str	String
    //   864	11	8	localObject10	Object
    //   889	76	8	localObject11	Object
    //   263	647	9	localObject12	Object
    //   934	6	9	localThrowable3	java.lang.Throwable
    //   103	872	10	localArrayList	ArrayList
    //   272	458	11	localProfileCardTemplate	ProfileCardTemplate
    // Exception table:
    //   from	to	target	type
    //   149	156	864	finally
    //   156	168	864	finally
    //   173	182	864	finally
    //   185	248	864	finally
    //   257	713	864	finally
    //   721	735	864	finally
    //   742	835	864	finally
    //   149	156	881	java/lang/Throwable
    //   156	168	881	java/lang/Throwable
    //   173	182	881	java/lang/Throwable
    //   185	248	881	java/lang/Throwable
    //   257	713	881	java/lang/Throwable
    //   721	735	881	java/lang/Throwable
    //   742	835	881	java/lang/Throwable
    //   140	149	886	finally
    //   140	149	902	java/lang/Throwable
    //   113	124	922	finally
    //   127	140	922	finally
    //   113	124	934	java/lang/Throwable
    //   127	140	934	java/lang/Throwable
    //   939	944	977	finally
    //   840	845	1024	java/io/IOException
    //   848	853	1024	java/io/IOException
    //   949	954	1024	java/io/IOException
    //   959	964	1024	java/io/IOException
    //   984	989	1029	java/io/IOException
    //   997	1002	1029	java/io/IOException
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
          } else if (a(localProfileCardTemplate)) {
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
  
  private static boolean a(ProfileCardTemplate paramProfileCardTemplate)
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
  
  public static String b(Context paramContext)
  {
    paramContext = paramContext.getDir(".profilecard", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qvip_profile_template.json");
    localStringBuilder.append("8.7.0");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardTemplateUtil
 * JD-Core Version:    0.7.0.1
 */