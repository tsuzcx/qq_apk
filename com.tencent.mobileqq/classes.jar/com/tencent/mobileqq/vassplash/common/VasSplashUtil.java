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
  public static SplashItem a;
  public static final String a;
  public static HashMap<String, SplashItem> a;
  public static boolean a;
  public static final String b;
  public static boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = VFSSourcePathConfig.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("qbdownres");
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(String paramString)
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
  
  public static long a(String paramString)
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
    //   0: ldc 70
    //   2: astore 12
    //   4: invokestatic 100	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: astore 9
    //   9: new 21	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   16: astore 10
    //   18: aload 10
    //   20: aload_0
    //   21: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 10
    //   27: ldc 106
    //   29: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 9
    //   35: aload 10
    //   37: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 102	com/tencent/mobileqq/vassplash/common/VasSplashUtil:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   43: astore 10
    //   45: aload 10
    //   47: ifnonnull +7 -> 54
    //   50: getstatic 49	com/tencent/mobileqq/vassplash/common/VasSplashUtil:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   53: areturn
    //   54: aload 12
    //   56: astore 9
    //   58: aload_1
    //   59: invokeinterface 184 1 0
    //   64: astore 11
    //   66: aload 12
    //   68: astore_1
    //   69: aload_1
    //   70: astore 9
    //   72: aload 11
    //   74: invokeinterface 190 1 0
    //   79: ifeq +1086 -> 1165
    //   82: aload_1
    //   83: astore 9
    //   85: aload 11
    //   87: invokeinterface 194 1 0
    //   92: checkcast 135	java/lang/String
    //   95: astore 12
    //   97: aload_1
    //   98: astore 9
    //   100: new 21	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   107: astore 13
    //   109: aload_1
    //   110: astore 9
    //   112: aload 13
    //   114: ldc 201
    //   116: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_1
    //   121: astore 9
    //   123: aload 13
    //   125: aload 12
    //   127: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_1
    //   132: astore 9
    //   134: aload 10
    //   136: aload 13
    //   138: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: ldc 106
    //   143: invokeinterface 112 3 0
    //   148: astore 13
    //   150: aload_1
    //   151: astore 9
    //   153: new 21	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   160: astore 14
    //   162: aload_1
    //   163: astore 9
    //   165: aload 14
    //   167: ldc 203
    //   169: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_1
    //   174: astore 9
    //   176: aload 14
    //   178: aload 12
    //   180: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_1
    //   185: astore 9
    //   187: aload 10
    //   189: aload 14
    //   191: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: ldc 106
    //   196: invokeinterface 112 3 0
    //   201: astore 14
    //   203: aload_1
    //   204: astore 9
    //   206: new 21	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   213: astore 15
    //   215: aload_1
    //   216: astore 9
    //   218: aload 15
    //   220: ldc 205
    //   222: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_1
    //   227: astore 9
    //   229: aload 15
    //   231: aload 12
    //   233: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_1
    //   238: astore 9
    //   240: aload 10
    //   242: aload 15
    //   244: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: iconst_m1
    //   248: invokeinterface 209 3 0
    //   253: istore_2
    //   254: aload_1
    //   255: astore 9
    //   257: new 21	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   264: astore 15
    //   266: aload_1
    //   267: astore 9
    //   269: aload 15
    //   271: ldc 211
    //   273: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_1
    //   278: astore 9
    //   280: aload 15
    //   282: aload 12
    //   284: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload_1
    //   289: astore 9
    //   291: aload 10
    //   293: aload 15
    //   295: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: ldc 106
    //   300: invokeinterface 112 3 0
    //   305: astore 15
    //   307: aload_1
    //   308: astore 9
    //   310: new 21	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   317: astore 16
    //   319: aload_1
    //   320: astore 9
    //   322: aload 16
    //   324: ldc 213
    //   326: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_1
    //   331: astore 9
    //   333: aload 16
    //   335: aload 12
    //   337: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_1
    //   342: astore 9
    //   344: aload 10
    //   346: aload 16
    //   348: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: iconst_m1
    //   352: invokeinterface 209 3 0
    //   357: istore_3
    //   358: aload_1
    //   359: astore 9
    //   361: new 21	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   368: astore 16
    //   370: aload_1
    //   371: astore 9
    //   373: aload 16
    //   375: ldc 215
    //   377: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload_1
    //   382: astore 9
    //   384: aload 16
    //   386: aload 12
    //   388: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload_1
    //   393: astore 9
    //   395: aload 10
    //   397: aload 16
    //   399: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: ldc 106
    //   404: invokeinterface 112 3 0
    //   409: astore 16
    //   411: aload_1
    //   412: astore 9
    //   414: new 21	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   421: astore 17
    //   423: aload_1
    //   424: astore 9
    //   426: aload 17
    //   428: ldc 217
    //   430: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload_1
    //   435: astore 9
    //   437: aload 17
    //   439: aload 12
    //   441: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_1
    //   446: astore 9
    //   448: aload 10
    //   450: aload 17
    //   452: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: iconst_0
    //   456: invokeinterface 209 3 0
    //   461: istore 4
    //   463: aload_1
    //   464: astore 9
    //   466: new 21	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   473: astore 17
    //   475: aload_1
    //   476: astore 9
    //   478: aload 17
    //   480: ldc 219
    //   482: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload_1
    //   487: astore 9
    //   489: aload 17
    //   491: aload 12
    //   493: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload_1
    //   498: astore 9
    //   500: aload 10
    //   502: aload 17
    //   504: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: ldc 106
    //   509: invokeinterface 112 3 0
    //   514: astore 17
    //   516: aload_1
    //   517: astore 9
    //   519: new 21	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   526: astore 18
    //   528: aload_1
    //   529: astore 9
    //   531: aload 18
    //   533: ldc 221
    //   535: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload_1
    //   540: astore 9
    //   542: aload 18
    //   544: aload 12
    //   546: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload_1
    //   551: astore 9
    //   553: aload 10
    //   555: aload 18
    //   557: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: iconst_0
    //   561: invokeinterface 225 3 0
    //   566: istore 7
    //   568: aload_1
    //   569: astore 9
    //   571: new 21	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   578: astore 18
    //   580: aload_1
    //   581: astore 9
    //   583: aload 18
    //   585: ldc 227
    //   587: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload_1
    //   592: astore 9
    //   594: aload 18
    //   596: aload 12
    //   598: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload_1
    //   603: astore 9
    //   605: aload 10
    //   607: aload 18
    //   609: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: iconst_0
    //   613: invokeinterface 225 3 0
    //   618: istore 8
    //   620: aload_1
    //   621: astore 9
    //   623: new 21	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   630: astore 18
    //   632: aload 18
    //   634: ldc 229
    //   636: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 18
    //   642: aload 12
    //   644: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload 10
    //   650: aload 18
    //   652: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: iconst_0
    //   656: invokeinterface 209 3 0
    //   661: istore 5
    //   663: new 21	java/lang/StringBuilder
    //   666: dup
    //   667: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   670: astore 9
    //   672: aload 9
    //   674: ldc 172
    //   676: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload 9
    //   682: aload 12
    //   684: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: aload 10
    //   690: aload 9
    //   692: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: ldc 106
    //   697: invokeinterface 112 3 0
    //   702: astore 9
    //   704: new 21	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   711: astore 18
    //   713: aload 18
    //   715: ldc 231
    //   717: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: aload 18
    //   723: aload 12
    //   725: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload 10
    //   731: aload 18
    //   733: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: ldc 106
    //   738: invokeinterface 112 3 0
    //   743: astore 18
    //   745: new 21	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   752: astore 19
    //   754: aload 19
    //   756: ldc 233
    //   758: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: aload 19
    //   764: aload 12
    //   766: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: pop
    //   770: aload 10
    //   772: aload 19
    //   774: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   777: ldc 235
    //   779: invokeinterface 112 3 0
    //   784: astore 19
    //   786: new 21	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   793: astore 20
    //   795: aload 20
    //   797: ldc 237
    //   799: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload 20
    //   805: aload 12
    //   807: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: aload 10
    //   813: aload 20
    //   815: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: iconst_0
    //   819: invokeinterface 209 3 0
    //   824: istore 6
    //   826: new 21	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   833: astore 20
    //   835: aload 20
    //   837: ldc 239
    //   839: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload 20
    //   845: aload 12
    //   847: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: pop
    //   851: aload 10
    //   853: aload 20
    //   855: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   858: ldc 106
    //   860: invokeinterface 112 3 0
    //   865: astore 21
    //   867: new 21	java/lang/StringBuilder
    //   870: dup
    //   871: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   874: astore 20
    //   876: aload 20
    //   878: ldc 241
    //   880: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: pop
    //   884: aload 20
    //   886: aload 12
    //   888: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: aload 10
    //   894: aload 20
    //   896: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   899: ldc 106
    //   901: invokeinterface 112 3 0
    //   906: astore 22
    //   908: new 21	java/lang/StringBuilder
    //   911: dup
    //   912: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   915: astore 20
    //   917: aload 20
    //   919: ldc 243
    //   921: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: pop
    //   925: aload 20
    //   927: aload 12
    //   929: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: pop
    //   933: aload 10
    //   935: aload 20
    //   937: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   940: ldc 106
    //   942: invokeinterface 112 3 0
    //   947: astore 23
    //   949: new 245	com/tencent/mobileqq/vassplash/model/SplashItem$Builder
    //   952: dup
    //   953: invokespecial 246	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:<init>	()V
    //   956: astore 20
    //   958: aload 20
    //   960: aload_0
    //   961: invokevirtual 250	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:h	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   964: aload 12
    //   966: invokevirtual 252	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   969: aload 13
    //   971: invokevirtual 255	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   974: aload 14
    //   976: invokevirtual 258	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   979: iload_2
    //   980: invokevirtual 261	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:c	(I)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   983: aload 15
    //   985: invokevirtual 263	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:e	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   988: iload 4
    //   990: invokevirtual 265	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:e	(I)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   993: aload 17
    //   995: invokevirtual 268	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:g	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   998: aload 16
    //   1000: invokevirtual 271	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:f	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1003: iload_3
    //   1004: invokevirtual 273	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:d	(I)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1007: iload 7
    //   1009: invokevirtual 276	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:b	(Z)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1012: iload 8
    //   1014: invokevirtual 278	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:a	(Z)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1017: iload 5
    //   1019: invokevirtual 280	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:b	(I)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1022: aload 9
    //   1024: invokevirtual 282	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:i	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1027: aload 18
    //   1029: invokevirtual 285	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:j	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1032: iload 6
    //   1034: invokevirtual 287	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:a	(I)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1037: aload 19
    //   1039: invokevirtual 289	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1042: aload 21
    //   1044: invokevirtual 292	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:k	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1047: aload 22
    //   1049: invokevirtual 295	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:l	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1052: aload 23
    //   1054: invokevirtual 298	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:m	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashItem$Builder;
    //   1057: pop
    //   1058: new 21	java/lang/StringBuilder
    //   1061: dup
    //   1062: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   1065: astore 9
    //   1067: aload 9
    //   1069: ldc_w 300
    //   1072: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: aload 9
    //   1078: aload 12
    //   1080: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: pop
    //   1084: aload 9
    //   1086: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1089: astore 9
    //   1091: aload_1
    //   1092: iconst_1
    //   1093: aload 9
    //   1095: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1098: getstatic 49	com/tencent/mobileqq/vassplash/common/VasSplashUtil:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1101: aload 12
    //   1103: aload 20
    //   1105: invokevirtual 303	com/tencent/mobileqq/vassplash/model/SplashItem$Builder:a	()Lcom/tencent/mobileqq/vassplash/model/SplashItem;
    //   1108: invokevirtual 307	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1111: pop
    //   1112: goto -1043 -> 69
    //   1115: astore_0
    //   1116: goto +11 -> 1127
    //   1119: astore_0
    //   1120: goto +7 -> 1127
    //   1123: astore_0
    //   1124: aload 9
    //   1126: astore_1
    //   1127: new 21	java/lang/StringBuilder
    //   1130: dup
    //   1131: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   1134: astore 9
    //   1136: aload 9
    //   1138: ldc_w 309
    //   1141: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: pop
    //   1145: aload 9
    //   1147: aload_0
    //   1148: invokevirtual 68	java/lang/Exception:toString	()Ljava/lang/String;
    //   1151: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: pop
    //   1155: aload_1
    //   1156: iconst_1
    //   1157: aload 9
    //   1159: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1162: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1165: getstatic 49	com/tencent/mobileqq/vassplash/common/VasSplashUtil:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1168: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1169	0	paramString	String
    //   0	1169	1	paramSet	Set<String>
    //   253	727	2	i	int
    //   357	647	3	j	int
    //   461	528	4	k	int
    //   661	357	5	m	int
    //   824	209	6	n	int
    //   566	442	7	bool1	boolean
    //   618	395	8	bool2	boolean
    //   7	1151	9	localObject1	Object
    //   16	918	10	localObject2	Object
    //   64	22	11	localIterator	Iterator
    //   2	1100	12	str1	String
    //   107	863	13	localObject3	Object
    //   160	815	14	localObject4	Object
    //   213	771	15	localObject5	Object
    //   317	682	16	localObject6	Object
    //   421	573	17	localObject7	Object
    //   526	502	18	localObject8	Object
    //   752	286	19	localObject9	Object
    //   793	311	20	localObject10	Object
    //   865	178	21	str2	String
    //   906	142	22	str3	String
    //   947	106	23	str4	String
    // Exception table:
    //   from	to	target	type
    //   1091	1112	1115	java/lang/Exception
    //   632	1091	1119	java/lang/Exception
    //   58	66	1123	java/lang/Exception
    //   72	82	1123	java/lang/Exception
    //   85	97	1123	java/lang/Exception
    //   100	109	1123	java/lang/Exception
    //   112	120	1123	java/lang/Exception
    //   123	131	1123	java/lang/Exception
    //   134	150	1123	java/lang/Exception
    //   153	162	1123	java/lang/Exception
    //   165	173	1123	java/lang/Exception
    //   176	184	1123	java/lang/Exception
    //   187	203	1123	java/lang/Exception
    //   206	215	1123	java/lang/Exception
    //   218	226	1123	java/lang/Exception
    //   229	237	1123	java/lang/Exception
    //   240	254	1123	java/lang/Exception
    //   257	266	1123	java/lang/Exception
    //   269	277	1123	java/lang/Exception
    //   280	288	1123	java/lang/Exception
    //   291	307	1123	java/lang/Exception
    //   310	319	1123	java/lang/Exception
    //   322	330	1123	java/lang/Exception
    //   333	341	1123	java/lang/Exception
    //   344	358	1123	java/lang/Exception
    //   361	370	1123	java/lang/Exception
    //   373	381	1123	java/lang/Exception
    //   384	392	1123	java/lang/Exception
    //   395	411	1123	java/lang/Exception
    //   414	423	1123	java/lang/Exception
    //   426	434	1123	java/lang/Exception
    //   437	445	1123	java/lang/Exception
    //   448	463	1123	java/lang/Exception
    //   466	475	1123	java/lang/Exception
    //   478	486	1123	java/lang/Exception
    //   489	497	1123	java/lang/Exception
    //   500	516	1123	java/lang/Exception
    //   519	528	1123	java/lang/Exception
    //   531	539	1123	java/lang/Exception
    //   542	550	1123	java/lang/Exception
    //   553	568	1123	java/lang/Exception
    //   571	580	1123	java/lang/Exception
    //   583	591	1123	java/lang/Exception
    //   594	602	1123	java/lang/Exception
    //   605	620	1123	java/lang/Exception
    //   623	632	1123	java/lang/Exception
  }
  
  /* Error */
  public static List<String> a(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 119	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   4: astore_0
    //   5: new 21	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   12: astore 5
    //   14: aload 5
    //   16: ldc 125
    //   18: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload 5
    //   24: lload_1
    //   25: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_0
    //   30: aload 5
    //   32: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: ldc 106
    //   37: invokeinterface 112 3 0
    //   42: astore 5
    //   44: new 21	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   51: astore_0
    //   52: aload_0
    //   53: ldc_w 313
    //   56: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_0
    //   61: aload 5
    //   63: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: ldc 70
    //   69: iconst_1
    //   70: aload_0
    //   71: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload 5
    //   79: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   82: ifne +119 -> 201
    //   85: new 315	java/util/ArrayList
    //   88: dup
    //   89: invokespecial 316	java/util/ArrayList:<init>	()V
    //   92: astore_0
    //   93: aload 5
    //   95: ldc 133
    //   97: invokevirtual 139	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   137: invokestatic 319	com/tencent/mobileqq/vassplash/common/VasSplashUtil:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   140: ifeq +49 -> 189
    //   143: aload_0
    //   144: aload 5
    //   146: invokeinterface 324 2 0
    //   151: pop
    //   152: new 21	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   159: astore 7
    //   161: aload 7
    //   163: ldc_w 326
    //   166: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 7
    //   172: aload 5
    //   174: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: ldc 70
    //   180: iconst_1
    //   181: aload 7
    //   183: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   207: new 21	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   214: astore 6
    //   216: aload 6
    //   218: ldc_w 328
    //   221: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 6
    //   227: aload 5
    //   229: invokevirtual 68	java/lang/Exception:toString	()Ljava/lang/String;
    //   232: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: ldc 70
    //   238: iconst_1
    //   239: aload 6
    //   241: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  public static Set<String> a(Context paramContext, String paramString)
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
  
  public static void a(String paramString)
  {
    paramString = a(BaseApplicationImpl.getContext(), paramString).edit();
    paramString.remove("vas_union_banner_current_");
    paramString.apply();
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
              localObject1 = a((Context)localObject1, ((StringBuilder)localObject4).toString());
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
                if (((SplashItem)localObject3).d <= ((SplashItem)localObject1).d) {
                  continue;
                }
                break label333;
              }
              jdField_a_of_type_ComTencentMobileqqVassplashModelSplashItem = (SplashItem)localObject1;
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
  
  public static boolean a(String paramString)
  {
    long l = a(paramString);
    return NetConnInfoCenter.getServerTime() > l;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    long l1 = a(paramString2);
    long l2 = a(paramString1);
    long l3 = NetConnInfoCenter.getServerTime();
    return (l2 < l3) && (l3 < l1);
  }
  
  public static void b(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vassplash.common.VasSplashUtil
 * JD-Core Version:    0.7.0.1
 */