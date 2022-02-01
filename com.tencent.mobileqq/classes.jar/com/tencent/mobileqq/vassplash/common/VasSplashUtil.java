package com.tencent.mobileqq.vassplash.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vassplash.model.SplashItem;
import com.tencent.mobileqq.vfs.VFSSourcePathConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VasSplashUtil
{
  public static final String a = VFSSourcePathConfig.d;
  public static final String b;
  public static boolean c = false;
  public static boolean d = false;
  public static HashMap<String, SplashItem> e = new HashMap();
  public static SplashItem f;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("qbdownres");
    b = localStringBuilder.toString();
  }
  
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vas_splash_ad_pref_");
    localStringBuilder.append(paramString);
    return paramContext.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static String a(String paramString)
  {
    return a(BaseApplicationImpl.getContext(), paramString).getString("vas_union_banner_current_", "");
  }
  
  public static String a(String paramString, long paramLong, boolean paramBoolean)
  {
    String str = "";
    try
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
      localEditor = ((SharedPreferences)localObject1).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("vas_splash_ad_ids_with_showdate_with_priority_");
      ((StringBuilder)localObject2).append(paramLong);
      localObject1 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
      localObject3 = new StringBuffer();
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(paramString))) {
        break label457;
      }
      arrayOfString = ((String)localObject1).split(",");
      localObject1 = "";
      j = 0;
      i = 0;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        SharedPreferences.Editor localEditor;
        Object localObject3;
        String[] arrayOfString;
        int j;
        int k;
        continue;
        j += 3;
        continue;
        Object localObject2 = "";
        continue;
        Object localObject1 = "";
        int i = 0;
      }
    }
    k = j + 2;
    if (k < arrayOfString.length)
    {
      localObject2 = arrayOfString[j];
      if ((i == 0) && (paramString.equals(localObject2)))
      {
        localObject1 = localObject2;
        i = 1;
      }
      else
      {
        ((StringBuffer)localObject3).append(arrayOfString[j]);
        ((StringBuffer)localObject3).append(",");
        ((StringBuffer)localObject3).append(arrayOfString[(j + 1)]);
        ((StringBuffer)localObject3).append(",");
        ((StringBuffer)localObject3).append(arrayOfString[k]);
        ((StringBuffer)localObject3).append(",");
      }
    }
    else
    {
      if (((StringBuffer)localObject3).length() == 0) {
        break label450;
      }
      localObject2 = ((StringBuffer)localObject3).substring(0, ((StringBuffer)localObject3).length() - 1);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("removeHasShowAdIDs result=");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("removeid = ");
      ((StringBuilder)localObject3).append(paramString);
      QLog.i("QSplash@VasSplashUtil", 1, ((StringBuilder)localObject3).toString());
      paramString = new StringBuilder();
      paramString.append("vas_splash_ad_ids_with_showdate_with_priority_");
      paramString.append(paramLong);
      localEditor.putString(paramString.toString(), (String)localObject2);
      localEditor.apply();
      paramString = str;
      if (paramBoolean)
      {
        paramString = str;
        if (i != 0)
        {
          paramString = BaseApplicationImpl.getContext();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append("");
          paramString = a(paramString, ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("vas_splash_info_report_");
          ((StringBuilder)localObject2).append((String)localObject1);
          paramString = paramString.getString(((StringBuilder)localObject2).toString(), "");
        }
      }
      return paramString;
      QLog.i("QSplash@VasSplashUtil", 1, "removeHasShowAdIDs exception");
      return null;
    }
  }
  
  public static String a(Set<String> paramSet)
  {
    if ((paramSet != null) && (paramSet.size() > 0))
    {
      localObject = new StringBuffer();
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        ((StringBuffer)localObject).append((String)paramSet.next());
        ((StringBuffer)localObject).append(",");
      }
      paramSet = ((StringBuffer)localObject).substring(0, ((StringBuffer)localObject).length() - 1);
    }
    else
    {
      paramSet = "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getLocalAdIds  adids =");
    ((StringBuilder)localObject).append(paramSet);
    QLog.i("QSplash@VasSplashUtil", 1, ((StringBuilder)localObject).toString());
    return paramSet;
  }
  
  /* Error */
  public static HashMap<String, SplashItem> a(String paramString, Set<String> paramSet)
  {
    // Byte code:
    //   0: ldc 140
    //   2: astore 13
    //   4: invokestatic 72	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: astore 10
    //   9: new 25	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   16: astore 11
    //   18: aload 11
    //   20: aload_0
    //   21: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 11
    //   27: ldc 78
    //   29: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 10
    //   35: aload 11
    //   37: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 74	com/tencent/mobileqq/vassplash/common/VasSplashUtil:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   43: astore 11
    //   45: aload 11
    //   47: ifnonnull +7 -> 54
    //   50: getstatic 54	com/tencent/mobileqq/vassplash/common/VasSplashUtil:e	Ljava/util/HashMap;
    //   53: areturn
    //   54: aload 13
    //   56: astore 10
    //   58: aload_1
    //   59: invokeinterface 169 1 0
    //   64: astore 12
    //   66: aload 13
    //   68: astore_1
    //   69: aload_1
    //   70: astore 10
    //   72: aload 12
    //   74: invokeinterface 175 1 0
    //   79: ifeq +1177 -> 1256
    //   82: aload_1
    //   83: astore 10
    //   85: aload 12
    //   87: invokeinterface 179 1 0
    //   92: checkcast 115	java/lang/String
    //   95: astore 13
    //   97: aload_1
    //   98: astore 10
    //   100: new 25	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   107: astore 14
    //   109: aload_1
    //   110: astore 10
    //   112: aload 14
    //   114: ldc 186
    //   116: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_1
    //   121: astore 10
    //   123: aload 14
    //   125: aload 13
    //   127: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_1
    //   132: astore 10
    //   134: aload 11
    //   136: aload 14
    //   138: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: ldc 78
    //   143: invokeinterface 84 3 0
    //   148: astore 14
    //   150: aload_1
    //   151: astore 10
    //   153: new 25	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   160: astore 15
    //   162: aload_1
    //   163: astore 10
    //   165: aload 15
    //   167: ldc 188
    //   169: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_1
    //   174: astore 10
    //   176: aload 15
    //   178: aload 13
    //   180: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_1
    //   185: astore 10
    //   187: aload 11
    //   189: aload 15
    //   191: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: ldc 78
    //   196: invokeinterface 84 3 0
    //   201: astore 15
    //   203: aload_1
    //   204: astore 10
    //   206: new 25	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   213: astore 16
    //   215: aload_1
    //   216: astore 10
    //   218: aload 16
    //   220: ldc 190
    //   222: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_1
    //   227: astore 10
    //   229: aload 16
    //   231: aload 13
    //   233: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_1
    //   238: astore 10
    //   240: aload 11
    //   242: aload 16
    //   244: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: iconst_m1
    //   248: invokeinterface 194 3 0
    //   253: istore_2
    //   254: aload_1
    //   255: astore 10
    //   257: new 25	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   264: astore 16
    //   266: aload_1
    //   267: astore 10
    //   269: aload 16
    //   271: ldc 196
    //   273: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_1
    //   278: astore 10
    //   280: aload 16
    //   282: aload 13
    //   284: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload_1
    //   289: astore 10
    //   291: aload 11
    //   293: aload 16
    //   295: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: ldc 78
    //   300: invokeinterface 84 3 0
    //   305: astore 16
    //   307: aload_1
    //   308: astore 10
    //   310: new 25	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   317: astore 17
    //   319: aload_1
    //   320: astore 10
    //   322: aload 17
    //   324: ldc 198
    //   326: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_1
    //   331: astore 10
    //   333: aload 17
    //   335: aload 13
    //   337: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_1
    //   342: astore 10
    //   344: aload 11
    //   346: aload 17
    //   348: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: iconst_m1
    //   352: invokeinterface 194 3 0
    //   357: istore_3
    //   358: aload_1
    //   359: astore 10
    //   361: new 25	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   368: astore 17
    //   370: aload_1
    //   371: astore 10
    //   373: aload 17
    //   375: ldc 200
    //   377: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload_1
    //   382: astore 10
    //   384: aload 17
    //   386: aload 13
    //   388: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload_1
    //   393: astore 10
    //   395: aload 11
    //   397: aload 17
    //   399: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: ldc 78
    //   404: invokeinterface 84 3 0
    //   409: astore 17
    //   411: aload_1
    //   412: astore 10
    //   414: new 25	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   421: astore 18
    //   423: aload_1
    //   424: astore 10
    //   426: aload 18
    //   428: ldc 202
    //   430: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload_1
    //   435: astore 10
    //   437: aload 18
    //   439: aload 13
    //   441: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_1
    //   446: astore 10
    //   448: aload 11
    //   450: aload 18
    //   452: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: iconst_0
    //   456: invokeinterface 194 3 0
    //   461: istore 4
    //   463: aload_1
    //   464: astore 10
    //   466: new 25	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   473: astore 18
    //   475: aload_1
    //   476: astore 10
    //   478: aload 18
    //   480: ldc 204
    //   482: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload_1
    //   487: astore 10
    //   489: aload 18
    //   491: aload 13
    //   493: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload_1
    //   498: astore 10
    //   500: aload 11
    //   502: aload 18
    //   504: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: ldc 78
    //   509: invokeinterface 84 3 0
    //   514: astore 18
    //   516: aload_1
    //   517: astore 10
    //   519: new 25	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   526: astore 19
    //   528: aload_1
    //   529: astore 10
    //   531: aload 19
    //   533: ldc 206
    //   535: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload_1
    //   540: astore 10
    //   542: aload 19
    //   544: aload 13
    //   546: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload_1
    //   551: astore 10
    //   553: aload 11
    //   555: aload 19
    //   557: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: iconst_0
    //   561: invokeinterface 210 3 0
    //   566: istore 8
    //   568: aload_1
    //   569: astore 10
    //   571: new 25	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   578: astore 19
    //   580: aload_1
    //   581: astore 10
    //   583: aload 19
    //   585: ldc 212
    //   587: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload_1
    //   592: astore 10
    //   594: aload 19
    //   596: aload 13
    //   598: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload_1
    //   603: astore 10
    //   605: aload 11
    //   607: aload 19
    //   609: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: iconst_0
    //   613: invokeinterface 210 3 0
    //   618: istore 9
    //   620: aload_1
    //   621: astore 10
    //   623: new 25	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   630: astore 19
    //   632: aload 19
    //   634: ldc 214
    //   636: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 19
    //   642: aload 13
    //   644: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload 11
    //   650: aload 19
    //   652: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: iconst_0
    //   656: invokeinterface 194 3 0
    //   661: istore 5
    //   663: new 25	java/lang/StringBuilder
    //   666: dup
    //   667: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   670: astore 10
    //   672: aload 10
    //   674: ldc 157
    //   676: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload 10
    //   682: aload 13
    //   684: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: aload 11
    //   690: aload 10
    //   692: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: ldc 78
    //   697: invokeinterface 84 3 0
    //   702: astore 10
    //   704: new 25	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   711: astore 19
    //   713: aload 19
    //   715: ldc 216
    //   717: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: aload 19
    //   723: aload 13
    //   725: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload 11
    //   731: aload 19
    //   733: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: ldc 78
    //   738: invokeinterface 84 3 0
    //   743: astore 19
    //   745: new 25	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   752: astore 20
    //   754: aload 20
    //   756: ldc 218
    //   758: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: aload 20
    //   764: aload 13
    //   766: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: pop
    //   770: aload 11
    //   772: aload 20
    //   774: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   777: ldc 220
    //   779: invokeinterface 84 3 0
    //   784: astore 20
    //   786: new 25	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   793: astore 21
    //   795: aload 21
    //   797: ldc 222
    //   799: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload 21
    //   805: aload 13
    //   807: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: aload 11
    //   813: aload 21
    //   815: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: iconst_0
    //   819: invokeinterface 194 3 0
    //   824: istore 6
    //   826: new 25	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   833: astore 21
    //   835: aload 21
    //   837: ldc 224
    //   839: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload 21
    //   845: aload 13
    //   847: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: pop
    //   851: aload 11
    //   853: aload 21
    //   855: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   858: ldc 78
    //   860: invokeinterface 84 3 0
    //   865: astore 21
    //   867: new 25	java/lang/StringBuilder
    //   870: dup
    //   871: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   874: astore 22
    //   876: aload 22
    //   878: ldc 226
    //   880: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: pop
    //   884: aload 22
    //   886: aload 13
    //   888: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: aload 11
    //   894: aload 22
    //   896: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   899: ldc 78
    //   901: invokeinterface 84 3 0
    //   906: astore 22
    //   908: new 25	java/lang/StringBuilder
    //   911: dup
    //   912: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   915: astore 23
    //   917: aload 23
    //   919: ldc 228
    //   921: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: pop
    //   925: aload 23
    //   927: aload 13
    //   929: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: pop
    //   933: aload 11
    //   935: aload 23
    //   937: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   940: ldc 78
    //   942: invokeinterface 84 3 0
    //   947: astore 24
    //   949: new 25	java/lang/StringBuilder
    //   952: dup
    //   953: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   956: astore 23
    //   958: aload 23
    //   960: ldc 230
    //   962: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: pop
    //   966: aload 23
    //   968: aload 13
    //   970: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: pop
    //   974: aload 11
    //   976: aload 23
    //   978: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   981: iconst_0
    //   982: invokeinterface 194 3 0
    //   987: istore 7
    //   989: new 25	java/lang/StringBuilder
    //   992: dup
    //   993: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   996: astore 23
    //   998: aload 23
    //   1000: ldc 232
    //   1002: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: aload 23
    //   1008: aload 13
    //   1010: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: pop
    //   1014: aload 11
    //   1016: aload 23
    //   1018: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1021: ldc 78
    //   1023: invokeinterface 84 3 0
    //   1028: astore 25
    //   1030: new 234	com/tencent/mobileqq/vassplash/model/SplashItem$Builder
    //   1033: dup
    //   1034: invokespecial 235	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:<init>	()V
    //   1037: astore 23
    //   1039: aload 23
    //   1041: aload_0
    //   1042: invokevirtual 239	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:h	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1045: aload 13
    //   1047: invokevirtual 241	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1050: aload 14
    //   1052: invokevirtual 243	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1055: aload 15
    //   1057: invokevirtual 245	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1060: iload_2
    //   1061: invokevirtual 248	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:c	(I)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1064: aload 16
    //   1066: invokevirtual 250	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:e	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1069: iload 4
    //   1071: invokevirtual 252	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:e	(I)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1074: aload 18
    //   1076: invokevirtual 255	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:g	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1079: aload 17
    //   1081: invokevirtual 257	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:f	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1084: iload_3
    //   1085: invokevirtual 259	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:d	(I)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1088: iload 8
    //   1090: invokevirtual 262	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:b	(Z)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1093: iload 9
    //   1095: invokevirtual 264	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:a	(Z)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1098: iload 5
    //   1100: invokevirtual 266	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:b	(I)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1103: aload 10
    //   1105: invokevirtual 268	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:i	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1108: aload 19
    //   1110: invokevirtual 271	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:j	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1113: iload 6
    //   1115: invokevirtual 273	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:a	(I)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1118: aload 20
    //   1120: invokevirtual 275	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1123: aload 21
    //   1125: invokevirtual 278	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:k	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1128: aload 22
    //   1130: invokevirtual 281	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:l	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1133: aload 24
    //   1135: invokevirtual 284	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:m	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1138: iload 7
    //   1140: invokevirtual 286	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:f	(I)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1143: aload 25
    //   1145: invokevirtual 289	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:n	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1148: pop
    //   1149: new 25	java/lang/StringBuilder
    //   1152: dup
    //   1153: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   1156: astore 10
    //   1158: aload 10
    //   1160: ldc_w 291
    //   1163: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: pop
    //   1167: aload 10
    //   1169: aload 13
    //   1171: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1174: pop
    //   1175: aload 10
    //   1177: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1180: astore 10
    //   1182: aload_1
    //   1183: iconst_1
    //   1184: aload 10
    //   1186: invokestatic 146	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1189: getstatic 54	com/tencent/mobileqq/vassplash/common/VasSplashUtil:e	Ljava/util/HashMap;
    //   1192: aload 13
    //   1194: aload 23
    //   1196: invokevirtual 294	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:a	()Lcom/tencent/mobileqq/vassplash/model/SplashItem;
    //   1199: invokevirtual 298	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1202: pop
    //   1203: goto -1134 -> 69
    //   1206: astore_0
    //   1207: goto +11 -> 1218
    //   1210: astore_0
    //   1211: goto +7 -> 1218
    //   1214: astore_0
    //   1215: aload 10
    //   1217: astore_1
    //   1218: new 25	java/lang/StringBuilder
    //   1221: dup
    //   1222: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   1225: astore 10
    //   1227: aload 10
    //   1229: ldc_w 300
    //   1232: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: pop
    //   1236: aload 10
    //   1238: aload_0
    //   1239: invokevirtual 301	java/lang/Exception:toString	()Ljava/lang/String;
    //   1242: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: pop
    //   1246: aload_1
    //   1247: iconst_1
    //   1248: aload 10
    //   1250: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1253: invokestatic 303	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1256: getstatic 54	com/tencent/mobileqq/vassplash/common/VasSplashUtil:e	Ljava/util/HashMap;
    //   1259: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1260	0	paramString	String
    //   0	1260	1	paramSet	Set<String>
    //   253	808	2	i	int
    //   357	728	3	j	int
    //   461	609	4	k	int
    //   661	438	5	m	int
    //   824	290	6	n	int
    //   987	152	7	i1	int
    //   566	523	8	bool1	boolean
    //   618	476	9	bool2	boolean
    //   7	1242	10	localObject1	Object
    //   16	999	11	localObject2	Object
    //   64	22	12	localIterator	Iterator
    //   2	1191	13	str1	String
    //   107	944	14	localObject3	Object
    //   160	896	15	localObject4	Object
    //   213	852	16	localObject5	Object
    //   317	763	17	localObject6	Object
    //   421	654	18	localObject7	Object
    //   526	583	19	localObject8	Object
    //   752	367	20	localObject9	Object
    //   793	331	21	localObject10	Object
    //   874	255	22	localObject11	Object
    //   915	280	23	localObject12	Object
    //   947	187	24	str2	String
    //   1028	116	25	str3	String
    // Exception table:
    //   from	to	target	type
    //   1182	1203	1206	java/lang/Exception
    //   632	1182	1210	java/lang/Exception
    //   58	66	1214	java/lang/Exception
    //   72	82	1214	java/lang/Exception
    //   85	97	1214	java/lang/Exception
    //   100	109	1214	java/lang/Exception
    //   112	120	1214	java/lang/Exception
    //   123	131	1214	java/lang/Exception
    //   134	150	1214	java/lang/Exception
    //   153	162	1214	java/lang/Exception
    //   165	173	1214	java/lang/Exception
    //   176	184	1214	java/lang/Exception
    //   187	203	1214	java/lang/Exception
    //   206	215	1214	java/lang/Exception
    //   218	226	1214	java/lang/Exception
    //   229	237	1214	java/lang/Exception
    //   240	254	1214	java/lang/Exception
    //   257	266	1214	java/lang/Exception
    //   269	277	1214	java/lang/Exception
    //   280	288	1214	java/lang/Exception
    //   291	307	1214	java/lang/Exception
    //   310	319	1214	java/lang/Exception
    //   322	330	1214	java/lang/Exception
    //   333	341	1214	java/lang/Exception
    //   344	358	1214	java/lang/Exception
    //   361	370	1214	java/lang/Exception
    //   373	381	1214	java/lang/Exception
    //   384	392	1214	java/lang/Exception
    //   395	411	1214	java/lang/Exception
    //   414	423	1214	java/lang/Exception
    //   426	434	1214	java/lang/Exception
    //   437	445	1214	java/lang/Exception
    //   448	463	1214	java/lang/Exception
    //   466	475	1214	java/lang/Exception
    //   478	486	1214	java/lang/Exception
    //   489	497	1214	java/lang/Exception
    //   500	516	1214	java/lang/Exception
    //   519	528	1214	java/lang/Exception
    //   531	539	1214	java/lang/Exception
    //   542	550	1214	java/lang/Exception
    //   553	568	1214	java/lang/Exception
    //   571	580	1214	java/lang/Exception
    //   583	591	1214	java/lang/Exception
    //   594	602	1214	java/lang/Exception
    //   605	620	1214	java/lang/Exception
    //   623	632	1214	java/lang/Exception
  }
  
  /* Error */
  public static List<String> a(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 93	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   4: astore_0
    //   5: new 25	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   12: astore 5
    //   14: aload 5
    //   16: ldc 99
    //   18: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload 5
    //   24: lload_1
    //   25: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_0
    //   30: aload 5
    //   32: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: ldc 78
    //   37: invokeinterface 84 3 0
    //   42: astore 5
    //   44: new 25	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   51: astore_0
    //   52: aload_0
    //   53: ldc_w 307
    //   56: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_0
    //   61: aload 5
    //   63: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: ldc 140
    //   69: iconst_1
    //   70: aload_0
    //   71: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 146	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload 5
    //   79: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   82: ifne +119 -> 201
    //   85: new 309	java/util/ArrayList
    //   88: dup
    //   89: invokespecial 310	java/util/ArrayList:<init>	()V
    //   92: astore_0
    //   93: aload 5
    //   95: ldc 113
    //   97: invokevirtual 119	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   100: astore 6
    //   102: iconst_0
    //   103: istore_3
    //   104: iload_3
    //   105: iconst_2
    //   106: iadd
    //   107: istore 4
    //   109: aload_0
    //   110: astore 5
    //   112: iload 4
    //   114: aload 6
    //   116: arraylength
    //   117: if_icmpge +133 -> 250
    //   120: aload 6
    //   122: iload_3
    //   123: aaload
    //   124: astore 5
    //   126: aload 6
    //   128: iload_3
    //   129: iconst_1
    //   130: iadd
    //   131: aaload
    //   132: aload 6
    //   134: iload 4
    //   136: aaload
    //   137: invokestatic 313	com/tencent/mobileqq/vassplash/common/VasSplashUtil:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   140: ifeq +49 -> 189
    //   143: aload_0
    //   144: aload 5
    //   146: invokeinterface 318 2 0
    //   151: pop
    //   152: new 25	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   159: astore 7
    //   161: aload 7
    //   163: ldc_w 320
    //   166: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 7
    //   172: aload 5
    //   174: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: ldc 140
    //   180: iconst_1
    //   181: aload 7
    //   183: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 146	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: iload_3
    //   190: iconst_3
    //   191: iadd
    //   192: istore_3
    //   193: goto -89 -> 104
    //   196: astore 5
    //   198: goto +9 -> 207
    //   201: aconst_null
    //   202: areturn
    //   203: astore 5
    //   205: aconst_null
    //   206: astore_0
    //   207: new 25	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   214: astore 6
    //   216: aload 6
    //   218: ldc_w 322
    //   221: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 6
    //   227: aload 5
    //   229: invokevirtual 301	java/lang/Exception:toString	()Ljava/lang/String;
    //   232: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: ldc 140
    //   238: iconst_1
    //   239: aload 6
    //   241: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 303	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_0
    //   248: astore 5
    //   250: aload 5
    //   252: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramContext	Context
    //   0	253	1	paramLong	long
    //   103	90	3	i	int
    //   107	28	4	j	int
    //   12	161	5	localObject1	Object
    //   196	1	5	localException1	Exception
    //   203	25	5	localException2	Exception
    //   248	3	5	localContext	Context
    //   100	140	6	localObject2	Object
    //   159	23	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   93	102	196	java/lang/Exception
    //   112	120	196	java/lang/Exception
    //   126	189	196	java/lang/Exception
    //   5	93	203	java/lang/Exception
  }
  
  public static void a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("vas_splash_ad_ids_with_showdate_with_priority_");
      localStringBuilder.append(paramLong);
      paramContext.remove(localStringBuilder.toString());
      paramContext.remove("vas_splash_ad_ids_with_showdate_with_priority_0");
      paramContext.apply();
      QLog.i("QSplash@VasSplashUtil", 1, "cleanAllConfig ");
      return;
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cleanAllConfig exception");
      localStringBuilder.append(paramContext.toString());
      QLog.e("QSplash@VasSplashUtil", 1, localStringBuilder.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    paramString2 = a(BaseApplicationImpl.getContext(), paramString2).edit();
    paramString2.putString("vas_union_banner_current_", paramString1);
    paramString2.apply();
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (1 == paramInt1)
    {
      long l = DeviceInfoUtil.a();
      if ((paramInt3 == 0) || (Build.VERSION.SDK_INT > paramInt3))
      {
        bool1 = bool2;
        if (l != 0L)
        {
          bool1 = bool2;
          if (paramInt2 != 0)
          {
            bool1 = bool2;
            if (l > paramInt2 * 1024 * 1024) {}
          }
        }
      }
      else
      {
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder("openDisabledLowerDevice ");
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(" sdk_int:");
        localStringBuilder2.append(paramInt3);
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(" mem:");
        localStringBuilder2.append(paramInt2);
        localStringBuilder1.append(localStringBuilder2.toString());
        QLog.d("QSplash@VasSplashUtil", 2, localStringBuilder1.toString());
        return bool1;
      }
    }
    else
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("QSplash@VasSplashUtil", 2, "isDisabledLowerDevice false");
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public static boolean a(long paramLong)
  {
    boolean bool = false;
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject3 = a(BaseApplicationImpl.getContext(), paramLong);
        if (localObject3 != null)
        {
          int i = ((List)localObject3).size();
          if (i > 0) {
            try
            {
              Object localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("hasSplashADNeedShow uinStr =");
              ((StringBuilder)localObject1).append(paramLong % 10000L);
              QLog.i("QSplash@VasSplashUtil", 1, ((StringBuilder)localObject1).toString());
              localObject1 = BaseApplicationImpl.getContext();
              Object localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(paramLong);
              ((StringBuilder)localObject4).append("");
              localObject1 = b((Context)localObject1, ((StringBuilder)localObject4).toString());
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(paramLong);
              ((StringBuilder)localObject4).append("");
              localObject4 = a(((StringBuilder)localObject4).toString(), (Set)localObject1);
              localObject1 = null;
              Iterator localIterator = ((List)localObject3).iterator();
              if (localIterator.hasNext())
              {
                localObject3 = (String)localIterator.next();
                if (!((HashMap)localObject4).containsKey(localObject3)) {
                  continue;
                }
                localObject3 = (SplashItem)((HashMap)localObject4).get(localObject3);
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("show Splash AD,");
                localStringBuilder.append(((SplashItem)localObject3).toString());
                QLog.i("QSplash@VasSplashUtil", 1, localStringBuilder.toString());
                if (!((SplashItem)localObject3).a()) {
                  continue;
                }
                if (localObject1 == null) {
                  break label333;
                }
                if (((SplashItem)localObject3).m <= ((SplashItem)localObject1).m) {
                  continue;
                }
                break label333;
              }
              f = (SplashItem)localObject1;
              return true;
            }
            catch (Exception localException1)
            {
              bool = true;
            }
          }
        }
        return false;
      }
      catch (Exception localException2)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("hasSplashADNeedShow exception");
        ((StringBuilder)localObject3).append(localException2.toString());
        QLog.e("QSplash@VasSplashUtil", 1, ((StringBuilder)localObject3).toString());
        return bool;
      }
      label333:
      Object localObject2 = localObject3;
    }
  }
  
  public static Set<String> b(Context paramContext, String paramString)
  {
    paramString = a(paramContext, paramString).getString("splash_ad_ids", "");
    paramContext = new HashSet();
    if (!TextUtils.isEmpty(paramString)) {
      paramContext.addAll(Arrays.asList(paramString.split(",")));
    }
    paramString = new StringBuilder();
    paramString.append("getLocalAdIds frosm sp  adids =");
    paramString.append(paramContext);
    QLog.i("QSplash@VasSplashUtil", 1, paramString.toString());
    return paramContext;
  }
  
  public static void b(String paramString)
  {
    paramString = a(BaseApplicationImpl.getContext(), paramString).edit();
    paramString.remove("vas_union_banner_current_");
    paramString.apply();
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    long l1 = e(paramString2);
    long l2 = e(paramString1);
    long l3 = NetConnInfoCenter.getServerTime();
    return (l2 < l3) && (l3 < l1);
  }
  
  public static boolean c(String paramString)
  {
    long l = e(paramString);
    return NetConnInfoCenter.getServerTime() > l;
  }
  
  public static int d(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StringToInt exception");
      localStringBuilder.append(paramString.toString());
      QLog.e("QSplash@VasSplashUtil", 1, localStringBuilder.toString());
    }
    return 0;
  }
  
  public static long e(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        long l = Long.parseLong(paramString);
        return l;
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StringToLong exception");
      localStringBuilder.append(paramString.toString());
      QLog.e("QSplash@VasSplashUtil", 1, localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static void f(String paramString)
  {
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cleanOldSplashResDir sub");
      localStringBuilder.append(paramString);
      QLog.i("QSplash@VasSplashUtil", 1, localStringBuilder.toString());
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isFile()))
      {
        paramString.delete();
        return;
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cleanOldSplashResDir exception");
      localStringBuilder.append(paramString.toString());
      QLog.e("QSplash@VasSplashUtil", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vassplash.common.VasSplashUtil
 * JD-Core Version:    0.7.0.1
 */