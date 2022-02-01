package com.tencent.smtt.export.external;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.DexClassLoader;
import dalvik.system.VMStack;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;

public class DexLoader
{
  private static final String JAVACORE_PACKAGE_PREFIX = "org.chromium";
  private static final String TAF_PACKAGE_PREFIX = "com.taf";
  private static final String TAG = "DexLoader";
  private static final String TBS_FUSION_DEX = "tbs_jars_fusion_dex";
  private static final String TBS_WEBVIEW_DEX = "webview_dex";
  private static final String TENCENT_PACKAGE_PREFIX = "com.tencent";
  static boolean mCanUseDexLoaderProviderService = true;
  private static boolean mMttClassUseCorePrivate = false;
  private static boolean mUseSpeedyClassLoader = false;
  private static boolean mUseTbsCorePrivateClassLoader = false;
  private DexClassLoader mClassLoader;
  
  public DexLoader(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, new String[] { paramString1 }, paramString2);
  }
  
  public DexLoader(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    this(null, paramContext, paramArrayOfString, paramString);
  }
  
  public DexLoader(Context paramContext, String[] paramArrayOfString, String paramString, DexLoader paramDexLoader)
  {
    paramDexLoader = paramDexLoader.getClassLoader();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramDexLoader = createDexClassLoader(paramArrayOfString[i], paramString, paramContext.getApplicationInfo().nativeLibraryDir, paramDexLoader, paramContext);
      this.mClassLoader = paramDexLoader;
      i += 1;
    }
  }
  
  public DexLoader(Context paramContext, String[] paramArrayOfString, String paramString1, String paramString2)
  {
    ClassLoader localClassLoader = paramContext.getClassLoader();
    String str = paramContext.getApplicationInfo().nativeLibraryDir;
    Object localObject = str;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(File.pathSeparator);
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
    }
    int i = 0;
    paramString2 = localClassLoader;
    while (i < paramArrayOfString.length)
    {
      paramString2 = createDexClassLoader(paramArrayOfString[i], paramString1, (String)localObject, paramString2, paramContext);
      this.mClassLoader = paramString2;
      i += 1;
    }
  }
  
  public DexLoader(String paramString1, Context paramContext, String[] paramArrayOfString, String paramString2)
  {
    this(paramString1, paramContext, paramArrayOfString, paramString2, null);
  }
  
  public DexLoader(String paramString1, Context paramContext, String[] paramArrayOfString, String paramString2, Map<String, Object> paramMap)
  {
    initTbsSettings(paramMap);
    Object localObject = VMStack.getCallingClassLoader();
    paramMap = (Map<String, Object>)localObject;
    if (localObject == null) {
      paramMap = paramContext.getClassLoader();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Set base classLoader for DexClassLoader: ");
    ((StringBuilder)localObject).append(paramMap);
    Log.d("dexloader", ((StringBuilder)localObject).toString());
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramMap = createDexClassLoader(paramArrayOfString[i], paramString2, paramString1, paramMap, paramContext);
      this.mClassLoader = paramMap;
      i += 1;
    }
  }
  
  /* Error */
  private DexClassLoader createDexClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, Context paramContext)
  {
    // Byte code:
    //   0: getstatic 136	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 29
    //   5: if_icmplt +1062 -> 1067
    //   8: new 81	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   15: astore 8
    //   17: aload 8
    //   19: aload_1
    //   20: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 8
    //   26: ldc 138
    //   28: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 8
    //   34: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore 11
    //   39: new 81	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   46: astore 8
    //   48: aload 8
    //   50: aload_1
    //   51: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 8
    //   57: ldc 140
    //   59: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 8
    //   65: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore 12
    //   70: new 81	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   77: astore 8
    //   79: aload 8
    //   81: aload_1
    //   82: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 8
    //   88: ldc 142
    //   90: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 8
    //   96: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore 13
    //   101: aload 5
    //   103: ldc 144
    //   105: iconst_0
    //   106: invokevirtual 148	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   109: astore 14
    //   111: new 88	java/io/File
    //   114: dup
    //   115: aload_1
    //   116: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: astore 17
    //   121: new 88	java/io/File
    //   124: dup
    //   125: aload 5
    //   127: ldc 153
    //   129: iconst_0
    //   130: invokevirtual 157	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   133: ldc 159
    //   135: invokespecial 162	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   138: astore 8
    //   140: aload 14
    //   142: aload 11
    //   144: iconst_m1
    //   145: invokeinterface 168 3 0
    //   150: istore 7
    //   152: aload 14
    //   154: aload 12
    //   156: ldc 170
    //   158: invokeinterface 174 3 0
    //   163: astore 9
    //   165: aload 14
    //   167: aload 13
    //   169: ldc 170
    //   171: invokeinterface 174 3 0
    //   176: astore 10
    //   178: aload 5
    //   180: invokevirtual 177	android/content/Context:getPackageName	()Ljava/lang/String;
    //   183: astore 15
    //   185: aload 5
    //   187: invokevirtual 181	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   190: aload 15
    //   192: iconst_0
    //   193: invokevirtual 187	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   196: astore 15
    //   198: aload 15
    //   200: getfield 192	android/content/pm/PackageInfo:versionCode	I
    //   203: istore 6
    //   205: aload 15
    //   207: getfield 195	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   210: astore 15
    //   212: getstatic 200	android/os/Build:DISPLAY	Ljava/lang/String;
    //   215: astore 16
    //   217: new 81	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   224: astore 18
    //   226: aload 18
    //   228: ldc 202
    //   230: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 18
    //   236: aload 9
    //   238: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 18
    //   244: ldc 204
    //   246: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 18
    //   252: iload 6
    //   254: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 18
    //   260: ldc 209
    //   262: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 18
    //   268: aload 9
    //   270: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 18
    //   276: ldc 211
    //   278: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 18
    //   284: aload 15
    //   286: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 18
    //   292: ldc 213
    //   294: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 18
    //   300: aload 10
    //   302: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 18
    //   308: ldc 215
    //   310: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 18
    //   316: aload 16
    //   318: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: ldc 14
    //   324: aload 18
    //   326: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 218	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   332: pop
    //   333: iload 6
    //   335: iload 7
    //   337: if_icmpne +26 -> 363
    //   340: aload 15
    //   342: aload 9
    //   344: invokevirtual 222	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   347: ifeq +16 -> 363
    //   350: aload 16
    //   352: aload 10
    //   354: invokevirtual 222	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   357: ifne +939 -> 1296
    //   360: goto +3 -> 363
    //   363: ldc 14
    //   365: ldc 224
    //   367: invokestatic 227	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   370: pop
    //   371: new 81	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   378: astore 9
    //   380: aload 9
    //   382: aload 17
    //   384: invokevirtual 230	java/io/File:getName	()Ljava/lang/String;
    //   387: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 9
    //   393: ldc 232
    //   395: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: new 234	com/tencent/smtt/utils/l
    //   402: dup
    //   403: aload 8
    //   405: aload 9
    //   407: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokespecial 235	com/tencent/smtt/utils/l:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   413: astore 8
    //   415: aload 8
    //   417: astore 9
    //   419: aload 8
    //   421: invokevirtual 238	com/tencent/smtt/utils/l:b	()V
    //   424: aload 8
    //   426: astore 9
    //   428: aload 14
    //   430: aload 11
    //   432: iconst_m1
    //   433: invokeinterface 168 3 0
    //   438: istore 7
    //   440: aload 8
    //   442: astore 9
    //   444: aload 14
    //   446: aload 12
    //   448: ldc 170
    //   450: invokeinterface 174 3 0
    //   455: astore 10
    //   457: aload 8
    //   459: astore 9
    //   461: aload 14
    //   463: aload 13
    //   465: ldc 170
    //   467: invokeinterface 174 3 0
    //   472: astore 18
    //   474: iload 6
    //   476: iload 7
    //   478: if_icmpne +35 -> 513
    //   481: aload 8
    //   483: astore 9
    //   485: aload 15
    //   487: aload 10
    //   489: invokevirtual 222	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   492: ifeq +21 -> 513
    //   495: aload 8
    //   497: astore 10
    //   499: aload 8
    //   501: astore 9
    //   503: aload 16
    //   505: aload 18
    //   507: invokevirtual 222	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   510: ifne +493 -> 1003
    //   513: aload 8
    //   515: astore 9
    //   517: new 88	java/io/File
    //   520: dup
    //   521: aload 17
    //   523: invokevirtual 241	java/io/File:getParent	()Ljava/lang/String;
    //   526: ldc 243
    //   528: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   531: astore 19
    //   533: aload 8
    //   535: astore 9
    //   537: aload 17
    //   539: invokevirtual 230	java/io/File:getName	()Ljava/lang/String;
    //   542: invokestatic 250	com/tencent/smtt/export/external/DexLoader:getFileNameNoEx	(Ljava/lang/String;)Ljava/lang/String;
    //   545: astore 18
    //   547: aload 8
    //   549: astore 9
    //   551: new 81	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   558: astore 10
    //   560: aload 8
    //   562: astore 9
    //   564: aload 10
    //   566: aload 17
    //   568: invokevirtual 230	java/io/File:getName	()Ljava/lang/String;
    //   571: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload 8
    //   577: astore 9
    //   579: aload 10
    //   581: ldc 252
    //   583: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload 8
    //   589: astore 9
    //   591: new 88	java/io/File
    //   594: dup
    //   595: aload 19
    //   597: aload 10
    //   599: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokespecial 162	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   605: astore 10
    //   607: aload 8
    //   609: astore 9
    //   611: new 81	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   618: astore 20
    //   620: aload 8
    //   622: astore 9
    //   624: aload 20
    //   626: aload 17
    //   628: invokevirtual 230	java/io/File:getName	()Ljava/lang/String;
    //   631: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload 8
    //   637: astore 9
    //   639: aload 20
    //   641: ldc 254
    //   643: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: pop
    //   647: aload 8
    //   649: astore 9
    //   651: new 88	java/io/File
    //   654: dup
    //   655: aload 19
    //   657: aload 20
    //   659: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokespecial 162	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   665: astore 17
    //   667: aload 8
    //   669: astore 9
    //   671: new 88	java/io/File
    //   674: dup
    //   675: aload 19
    //   677: ldc_w 256
    //   680: invokespecial 162	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   683: astore 20
    //   685: aload 8
    //   687: astore 9
    //   689: new 81	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   696: astore 19
    //   698: aload 8
    //   700: astore 9
    //   702: aload 19
    //   704: aload 18
    //   706: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload 8
    //   712: astore 9
    //   714: aload 19
    //   716: ldc_w 258
    //   719: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload 8
    //   725: astore 9
    //   727: new 88	java/io/File
    //   730: dup
    //   731: aload 20
    //   733: aload 19
    //   735: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokespecial 162	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   741: astore 19
    //   743: aload 8
    //   745: astore 9
    //   747: new 81	java/lang/StringBuilder
    //   750: dup
    //   751: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   754: astore 21
    //   756: aload 8
    //   758: astore 9
    //   760: aload 21
    //   762: aload 18
    //   764: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload 8
    //   770: astore 9
    //   772: aload 21
    //   774: ldc_w 260
    //   777: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: aload 8
    //   783: astore 9
    //   785: new 88	java/io/File
    //   788: dup
    //   789: aload 20
    //   791: aload 21
    //   793: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   796: invokespecial 162	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   799: astore 18
    //   801: aload 8
    //   803: astore 9
    //   805: aload 10
    //   807: invokestatic 264	com/tencent/smtt/export/external/DexLoader:delete	(Ljava/io/File;)V
    //   810: aload 8
    //   812: astore 9
    //   814: aload 17
    //   816: invokestatic 264	com/tencent/smtt/export/external/DexLoader:delete	(Ljava/io/File;)V
    //   819: aload 8
    //   821: astore 9
    //   823: aload 19
    //   825: invokestatic 264	com/tencent/smtt/export/external/DexLoader:delete	(Ljava/io/File;)V
    //   828: aload 8
    //   830: astore 9
    //   832: aload 18
    //   834: invokestatic 264	com/tencent/smtt/export/external/DexLoader:delete	(Ljava/io/File;)V
    //   837: aload 8
    //   839: astore 9
    //   841: new 81	java/lang/StringBuilder
    //   844: dup
    //   845: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   848: astore 20
    //   850: aload 8
    //   852: astore 9
    //   854: aload 20
    //   856: ldc_w 266
    //   859: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: pop
    //   863: aload 8
    //   865: astore 9
    //   867: aload 20
    //   869: aload 10
    //   871: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   874: pop
    //   875: aload 8
    //   877: astore 9
    //   879: aload 20
    //   881: aload 17
    //   883: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   886: pop
    //   887: aload 8
    //   889: astore 9
    //   891: aload 20
    //   893: aload 19
    //   895: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   898: pop
    //   899: aload 8
    //   901: astore 9
    //   903: aload 20
    //   905: aload 18
    //   907: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   910: pop
    //   911: aload 8
    //   913: astore 9
    //   915: ldc 14
    //   917: aload 20
    //   919: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   922: invokestatic 218	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   925: pop
    //   926: aload 8
    //   928: astore 9
    //   930: aload 14
    //   932: invokeinterface 270 1 0
    //   937: astore 10
    //   939: aload 8
    //   941: astore 9
    //   943: aload 10
    //   945: aload 12
    //   947: aload 15
    //   949: invokeinterface 276 3 0
    //   954: pop
    //   955: aload 8
    //   957: astore 9
    //   959: aload 10
    //   961: aload 11
    //   963: iload 6
    //   965: invokeinterface 280 3 0
    //   970: pop
    //   971: aload 8
    //   973: astore 9
    //   975: aload 10
    //   977: aload 13
    //   979: aload 16
    //   981: invokeinterface 276 3 0
    //   986: pop
    //   987: aload 8
    //   989: astore 9
    //   991: aload 10
    //   993: invokeinterface 283 1 0
    //   998: pop
    //   999: aload 8
    //   1001: astore 10
    //   1003: aload 10
    //   1005: ifnull +62 -> 1067
    //   1008: aload 10
    //   1010: astore 8
    //   1012: goto +34 -> 1046
    //   1015: astore 10
    //   1017: goto +15 -> 1032
    //   1020: astore_1
    //   1021: aconst_null
    //   1022: astore 9
    //   1024: goto +31 -> 1055
    //   1027: astore 10
    //   1029: aconst_null
    //   1030: astore 8
    //   1032: aload 8
    //   1034: astore 9
    //   1036: aload 10
    //   1038: invokevirtual 286	java/lang/Exception:printStackTrace	()V
    //   1041: aload 8
    //   1043: ifnull +24 -> 1067
    //   1046: aload 8
    //   1048: invokevirtual 288	com/tencent/smtt/utils/l:e	()V
    //   1051: goto +16 -> 1067
    //   1054: astore_1
    //   1055: aload 9
    //   1057: ifnull +8 -> 1065
    //   1060: aload 9
    //   1062: invokevirtual 288	com/tencent/smtt/utils/l:e	()V
    //   1065: aload_1
    //   1066: athrow
    //   1067: new 81	java/lang/StringBuilder
    //   1070: dup
    //   1071: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   1074: astore 8
    //   1076: aload 8
    //   1078: ldc_w 290
    //   1081: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: pop
    //   1085: aload 8
    //   1087: aload_1
    //   1088: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: pop
    //   1092: ldc 114
    //   1094: aload 8
    //   1096: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1099: invokestatic 120	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1102: pop
    //   1103: aload_0
    //   1104: aload_1
    //   1105: invokespecial 294	com/tencent/smtt/export/external/DexLoader:shouldUseTbsCorePrivateClassLoader	(Ljava/lang/String;)Z
    //   1108: ifeq +19 -> 1127
    //   1111: new 296	com/tencent/smtt/export/external/DexLoader$TbsCorePrivateClassLoader
    //   1114: dup
    //   1115: aload_1
    //   1116: aload_2
    //   1117: aload_3
    //   1118: aload 4
    //   1120: invokespecial 299	com/tencent/smtt/export/external/DexLoader$TbsCorePrivateClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   1123: astore_1
    //   1124: goto +138 -> 1262
    //   1127: getstatic 136	android/os/Build$VERSION:SDK_INT	I
    //   1130: bipush 21
    //   1132: if_icmplt +108 -> 1240
    //   1135: getstatic 136	android/os/Build$VERSION:SDK_INT	I
    //   1138: bipush 25
    //   1140: if_icmpgt +100 -> 1240
    //   1143: getstatic 301	com/tencent/smtt/export/external/DexLoader:mUseSpeedyClassLoader	Z
    //   1146: ifeq +94 -> 1240
    //   1149: ldc 114
    //   1151: ldc_w 303
    //   1154: invokestatic 120	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1157: pop
    //   1158: aload_1
    //   1159: aload_2
    //   1160: aload_3
    //   1161: aload 4
    //   1163: aload 5
    //   1165: invokestatic 306	com/tencent/smtt/export/external/DexClassLoaderProvider:createDexClassLoader	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;Landroid/content/Context;)Ldalvik/system/DexClassLoader;
    //   1168: astore 5
    //   1170: aload 5
    //   1172: astore_1
    //   1173: goto +89 -> 1262
    //   1176: astore 5
    //   1178: new 81	java/lang/StringBuilder
    //   1181: dup
    //   1182: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   1185: astore 8
    //   1187: aload 8
    //   1189: ldc_w 308
    //   1192: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: pop
    //   1196: aload 8
    //   1198: aload 5
    //   1200: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1203: pop
    //   1204: ldc 114
    //   1206: aload 8
    //   1208: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1211: invokestatic 227	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1214: pop
    //   1215: ldc 114
    //   1217: ldc_w 310
    //   1220: invokestatic 120	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1223: pop
    //   1224: new 312	dalvik/system/DexClassLoader
    //   1227: dup
    //   1228: aload_1
    //   1229: aload_2
    //   1230: aload_3
    //   1231: aload 4
    //   1233: invokespecial 313	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   1236: astore_1
    //   1237: goto +25 -> 1262
    //   1240: ldc 114
    //   1242: ldc_w 315
    //   1245: invokestatic 120	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1248: pop
    //   1249: new 312	dalvik/system/DexClassLoader
    //   1252: dup
    //   1253: aload_1
    //   1254: aload_2
    //   1255: aload_3
    //   1256: aload 4
    //   1258: invokespecial 313	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   1261: astore_1
    //   1262: new 81	java/lang/StringBuilder
    //   1265: dup
    //   1266: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   1269: astore_2
    //   1270: aload_2
    //   1271: ldc_w 317
    //   1274: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: pop
    //   1278: aload_2
    //   1279: aload_1
    //   1280: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1283: pop
    //   1284: ldc 114
    //   1286: aload_2
    //   1287: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1290: invokestatic 120	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1293: pop
    //   1294: aload_1
    //   1295: areturn
    //   1296: aconst_null
    //   1297: astore 10
    //   1299: goto -296 -> 1003
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1302	0	this	DexLoader
    //   0	1302	1	paramString1	String
    //   0	1302	2	paramString2	String
    //   0	1302	3	paramString3	String
    //   0	1302	4	paramClassLoader	ClassLoader
    //   0	1302	5	paramContext	Context
    //   203	761	6	i	int
    //   150	329	7	j	int
    //   15	1192	8	localObject1	Object
    //   163	898	9	localObject2	Object
    //   176	833	10	localObject3	Object
    //   1015	1	10	localException1	java.lang.Exception
    //   1027	10	10	localException2	java.lang.Exception
    //   1297	1	10	localObject4	Object
    //   37	925	11	str1	String
    //   68	878	12	str2	String
    //   99	879	13	str3	String
    //   109	822	14	localSharedPreferences	android.content.SharedPreferences
    //   183	765	15	localObject5	Object
    //   215	765	16	str4	String
    //   119	763	17	localFile	File
    //   224	682	18	localObject6	Object
    //   531	363	19	localObject7	Object
    //   618	300	20	localObject8	Object
    //   754	38	21	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   419	424	1015	java/lang/Exception
    //   428	440	1015	java/lang/Exception
    //   444	457	1015	java/lang/Exception
    //   461	474	1015	java/lang/Exception
    //   485	495	1015	java/lang/Exception
    //   503	513	1015	java/lang/Exception
    //   517	533	1015	java/lang/Exception
    //   537	547	1015	java/lang/Exception
    //   551	560	1015	java/lang/Exception
    //   564	575	1015	java/lang/Exception
    //   579	587	1015	java/lang/Exception
    //   591	607	1015	java/lang/Exception
    //   611	620	1015	java/lang/Exception
    //   624	635	1015	java/lang/Exception
    //   639	647	1015	java/lang/Exception
    //   651	667	1015	java/lang/Exception
    //   671	685	1015	java/lang/Exception
    //   689	698	1015	java/lang/Exception
    //   702	710	1015	java/lang/Exception
    //   714	723	1015	java/lang/Exception
    //   727	743	1015	java/lang/Exception
    //   747	756	1015	java/lang/Exception
    //   760	768	1015	java/lang/Exception
    //   772	781	1015	java/lang/Exception
    //   785	801	1015	java/lang/Exception
    //   805	810	1015	java/lang/Exception
    //   814	819	1015	java/lang/Exception
    //   823	828	1015	java/lang/Exception
    //   832	837	1015	java/lang/Exception
    //   841	850	1015	java/lang/Exception
    //   854	863	1015	java/lang/Exception
    //   867	875	1015	java/lang/Exception
    //   879	887	1015	java/lang/Exception
    //   891	899	1015	java/lang/Exception
    //   903	911	1015	java/lang/Exception
    //   915	926	1015	java/lang/Exception
    //   930	939	1015	java/lang/Exception
    //   943	955	1015	java/lang/Exception
    //   959	971	1015	java/lang/Exception
    //   975	987	1015	java/lang/Exception
    //   991	999	1015	java/lang/Exception
    //   140	333	1020	finally
    //   340	360	1020	finally
    //   363	415	1020	finally
    //   140	333	1027	java/lang/Exception
    //   340	360	1027	java/lang/Exception
    //   363	415	1027	java/lang/Exception
    //   419	424	1054	finally
    //   428	440	1054	finally
    //   444	457	1054	finally
    //   461	474	1054	finally
    //   485	495	1054	finally
    //   503	513	1054	finally
    //   517	533	1054	finally
    //   537	547	1054	finally
    //   551	560	1054	finally
    //   564	575	1054	finally
    //   579	587	1054	finally
    //   591	607	1054	finally
    //   611	620	1054	finally
    //   624	635	1054	finally
    //   639	647	1054	finally
    //   651	667	1054	finally
    //   671	685	1054	finally
    //   689	698	1054	finally
    //   702	710	1054	finally
    //   714	723	1054	finally
    //   727	743	1054	finally
    //   747	756	1054	finally
    //   760	768	1054	finally
    //   772	781	1054	finally
    //   785	801	1054	finally
    //   805	810	1054	finally
    //   814	819	1054	finally
    //   823	828	1054	finally
    //   832	837	1054	finally
    //   841	850	1054	finally
    //   854	863	1054	finally
    //   867	875	1054	finally
    //   879	887	1054	finally
    //   891	899	1054	finally
    //   903	911	1054	finally
    //   915	926	1054	finally
    //   930	939	1054	finally
    //   943	955	1054	finally
    //   959	971	1054	finally
    //   975	987	1054	finally
    //   991	999	1054	finally
    //   1036	1041	1054	finally
    //   1158	1170	1176	java/lang/Throwable
  }
  
  public static void delete(File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return;
      }
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile == null) {
        return;
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        delete(arrayOfFile[i]);
        i += 1;
      }
      paramFile.delete();
    }
  }
  
  public static String getFileNameNoEx(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 0)
      {
        int i = paramString.lastIndexOf('.');
        str = paramString;
        if (i > -1)
        {
          str = paramString;
          if (i < paramString.length()) {
            str = paramString.substring(0, i);
          }
        }
      }
    }
    return str;
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initTbsSettings - ");
    ((StringBuilder)localObject).append(paramMap);
    Log.d("DexLoader", ((StringBuilder)localObject).toString());
    if (paramMap != null) {
      try
      {
        localObject = paramMap.get("use_private_classloader");
        if ((localObject instanceof Boolean)) {
          mUseTbsCorePrivateClassLoader = ((Boolean)localObject).booleanValue();
        }
        localObject = paramMap.get("use_speedy_classloader");
        if ((localObject instanceof Boolean)) {
          mUseSpeedyClassLoader = ((Boolean)localObject).booleanValue();
        }
        localObject = paramMap.get("use_dexloader_service");
        if ((localObject instanceof Boolean)) {
          mCanUseDexLoaderProviderService = ((Boolean)localObject).booleanValue();
        }
        paramMap = paramMap.get("use_mtt_classes");
        if ((paramMap instanceof Boolean))
        {
          mMttClassUseCorePrivate = ((Boolean)paramMap).booleanValue();
          return;
        }
      }
      catch (Throwable paramMap)
      {
        paramMap.printStackTrace();
      }
    }
  }
  
  private boolean shouldUseTbsCorePrivateClassLoader(String paramString)
  {
    if (!mUseTbsCorePrivateClassLoader) {
      return false;
    }
    return (paramString.contains("tbs_jars_fusion_dex")) || (paramString.contains("webview_dex"));
  }
  
  public DexClassLoader getClassLoader()
  {
    return this.mClassLoader;
  }
  
  public Object getStaticField(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = this.mClassLoader.loadClass(paramString1).getField(paramString2);
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      String str = getClass().getSimpleName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("'");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("' get field '");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("' failed");
      Log.e(str, localStringBuilder.toString(), localThrowable);
    }
    return null;
  }
  
  public Object invokeMethod(Object paramObject, String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramArrayOfClass = this.mClassLoader.loadClass(paramString1).getMethod(paramString2, paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramObject = paramArrayOfClass.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      paramArrayOfClass = getClass().getSimpleName();
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("'");
      paramVarArgs.append(paramString1);
      paramVarArgs.append("' invoke method '");
      paramVarArgs.append(paramString2);
      paramVarArgs.append("' failed");
      Log.e(paramArrayOfClass, paramVarArgs.toString(), paramObject);
    }
    return null;
  }
  
  public Object invokeStaticMethod(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramArrayOfClass = this.mClassLoader.loadClass(paramString1).getMethod(paramString2, paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramArrayOfClass = paramArrayOfClass.invoke(null, paramVarArgs);
      return paramArrayOfClass;
    }
    catch (Throwable paramArrayOfClass)
    {
      if ((paramString2 != null) && (paramString2.equalsIgnoreCase("initTesRuntimeEnvironment")))
      {
        paramVarArgs = getClass().getSimpleName();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("'");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("' invoke static method '");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("' failed");
        Log.e(paramVarArgs, localStringBuilder.toString(), paramArrayOfClass);
        return paramArrayOfClass;
      }
      paramVarArgs = getClass().getSimpleName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("'");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("' invoke static method '");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("' failed");
      Log.i(paramVarArgs, localStringBuilder.toString(), paramArrayOfClass);
    }
    return null;
  }
  
  public Class<?> loadClass(String paramString)
  {
    try
    {
      Class localClass = this.mClassLoader.loadClass(paramString);
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      String str = getClass().getSimpleName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadClass '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("' failed");
      Log.e(str, localStringBuilder.toString(), localThrowable);
    }
    return null;
  }
  
  public Object newInstance(String paramString)
  {
    try
    {
      Object localObject = this.mClassLoader.loadClass(paramString).newInstance();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      String str = getClass().getSimpleName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" instance failed");
      Log.e(str, localStringBuilder.toString(), localThrowable);
    }
    return null;
  }
  
  public Object newInstance(String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramArrayOfClass = this.mClassLoader.loadClass(paramString).getConstructor(paramArrayOfClass).newInstance(paramVarArgs);
      return paramArrayOfClass;
    }
    catch (Throwable paramArrayOfClass)
    {
      if ("com.tencent.smtt.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(paramString))
      {
        paramVarArgs = getClass().getSimpleName();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("'newInstance ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" failed");
        Log.e(paramVarArgs, localStringBuilder.toString(), paramArrayOfClass);
        return paramArrayOfClass;
      }
      paramVarArgs = getClass().getSimpleName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("' instance failed");
      Log.e(paramVarArgs, localStringBuilder.toString(), paramArrayOfClass);
    }
    return null;
  }
  
  public void setStaticField(String paramString1, String paramString2, Object paramObject)
  {
    try
    {
      localObject = this.mClassLoader.loadClass(paramString1).getField(paramString2);
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).set(null, paramObject);
      return;
    }
    catch (Throwable paramObject)
    {
      Object localObject = getClass().getSimpleName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("'");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("' set field '");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("' failed");
      Log.e((String)localObject, localStringBuilder.toString(), paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexLoader
 * JD-Core Version:    0.7.0.1
 */