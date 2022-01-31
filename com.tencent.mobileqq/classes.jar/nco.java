import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.bnr.BnrReport.BNRConfigMsg;
import com.tencent.mobileqq.bnr.BnrReport.BNReportConfig;
import com.tencent.mobileqq.bnr.BnrReport.BNReportConfigReq;
import com.tencent.mobileqq.bnr.BnrReport.BNReportConfigRsp;
import com.tencent.mobileqq.bnr.BnrReport.BNReportGroupInfo;
import com.tencent.mobileqq.bnr.BnrReport.ExtInfo;
import com.tencent.mobileqq.bnr.BnrReport.RetInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class nco
{
  protected static long a;
  protected static ArrayList<Integer> a;
  protected static boolean a;
  protected static boolean b;
  
  protected static int a(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      return -1;
    }
    int i = 0;
    int j = jdField_a_of_type_JavaUtilArrayList.size();
    while (i < j)
    {
      if (((Integer)jdField_a_of_type_JavaUtilArrayList.get(i)).intValue() == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  /* Error */
  protected static SparseIntArray a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 15	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 38	java/util/ArrayList:<init>	()V
    //   9: pop
    //   10: invokestatic 41	nco:a	()Lorg/json/JSONObject;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: new 43	android/util/SparseIntArray
    //   25: dup
    //   26: invokespecial 44	android/util/SparseIntArray:<init>	()V
    //   29: astore_3
    //   30: aload 4
    //   32: ldc 46
    //   34: invokevirtual 52	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   37: astore 4
    //   39: aload 4
    //   41: invokevirtual 57	org/json/JSONArray:length	()I
    //   44: istore_2
    //   45: iconst_0
    //   46: istore_0
    //   47: iload_0
    //   48: iload_2
    //   49: if_icmpge +43 -> 92
    //   52: aload_3
    //   53: aload 4
    //   55: iload_0
    //   56: invokevirtual 61	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   59: ldc 63
    //   61: invokevirtual 67	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   64: iconst_0
    //   65: invokevirtual 71	android/util/SparseIntArray:put	(II)V
    //   68: iload_0
    //   69: iconst_1
    //   70: iadd
    //   71: istore_0
    //   72: goto -25 -> 47
    //   75: astore_3
    //   76: aload_3
    //   77: invokevirtual 74	org/json/JSONException:printStackTrace	()V
    //   80: aconst_null
    //   81: areturn
    //   82: astore 5
    //   84: aload 5
    //   86: invokevirtual 74	org/json/JSONException:printStackTrace	()V
    //   89: goto -21 -> 68
    //   92: invokestatic 80	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   95: ldc 82
    //   97: iconst_0
    //   98: invokevirtual 86	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   101: ldc 88
    //   103: ldc 90
    //   105: invokeinterface 96 3 0
    //   110: astore 4
    //   112: invokestatic 102	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   115: ifeq +29 -> 144
    //   118: ldc 104
    //   120: iconst_4
    //   121: new 106	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   128: ldc 109
    //   130: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 4
    //   135: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload 4
    //   146: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +75 -> 224
    //   152: aload 4
    //   154: ldc 129
    //   156: invokevirtual 135	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   159: astore 4
    //   161: aload 4
    //   163: arraylength
    //   164: istore_2
    //   165: iload_1
    //   166: istore_0
    //   167: iload_0
    //   168: iload_2
    //   169: if_icmpge +55 -> 224
    //   172: aload 4
    //   174: iload_0
    //   175: aaload
    //   176: ldc 137
    //   178: invokevirtual 135	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   181: astore 5
    //   183: aload_3
    //   184: aload 5
    //   186: iconst_0
    //   187: aaload
    //   188: invokestatic 141	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   191: invokevirtual 28	java/lang/Integer:intValue	()I
    //   194: aload 5
    //   196: iconst_1
    //   197: aaload
    //   198: invokestatic 141	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   201: invokevirtual 28	java/lang/Integer:intValue	()I
    //   204: invokevirtual 71	android/util/SparseIntArray:put	(II)V
    //   207: iload_0
    //   208: iconst_1
    //   209: iadd
    //   210: istore_0
    //   211: goto -44 -> 167
    //   214: astore 5
    //   216: aload 5
    //   218: invokevirtual 142	java/lang/NumberFormatException:printStackTrace	()V
    //   221: goto -14 -> 207
    //   224: aload_3
    //   225: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   46	165	0	i	int
    //   1	165	1	j	int
    //   44	126	2	k	int
    //   29	24	3	localSparseIntArray	SparseIntArray
    //   75	150	3	localJSONException1	JSONException
    //   13	160	4	localObject	Object
    //   82	3	5	localJSONException2	JSONException
    //   181	14	5	arrayOfString	String[]
    //   214	3	5	localNumberFormatException	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   30	39	75	org/json/JSONException
    //   52	68	82	org/json/JSONException
    //   172	207	214	java/lang/NumberFormatException
  }
  
  protected static BnrReport.BNRConfigMsg a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    long l;
    try
    {
      l = Long.valueOf(paramString).longValue();
      paramString = "";
    }
    catch (NumberFormatException paramString)
    {
      Object localObject1;
      label48:
      Object localObject3;
      String str;
      int j;
      int i;
      paramString.printStackTrace();
      return null;
    }
    try
    {
      localObject1 = BaseApplication.getContext();
      localObject1 = ((Context)localObject1).getPackageManager().getPackageInfo(((Context)localObject1).getPackageName(), 0).versionName;
      paramString = (String)localObject1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      break label48;
      localObject2 = new BnrReport.BNRConfigMsg();
      ((BnrReport.BNRConfigMsg)localObject2).uin.set(l);
      ((BnrReport.BNRConfigMsg)localObject2).cmd.set(0);
      ((BnrReport.BNRConfigMsg)localObject2).seq.set(0);
      ((BnrReport.BNRConfigMsg)localObject2).ext_info.set(localNameNotFoundException);
      ((BnrReport.BNRConfigMsg)localObject2).msg_req_body.set(paramString);
    }
    localObject1 = Build.BRAND;
    localObject3 = Build.MODEL;
    str = Build.VERSION.RELEASE;
    Object localObject2 = new StringBuffer("android");
    ((StringBuffer)localObject2).append(" ").append(Build.VERSION.SDK_INT);
    ((StringBuffer)localObject2).append(" ").append(str);
    ((StringBuffer)localObject2).append(" ").append((String)localObject1);
    ((StringBuffer)localObject2).append(" ").append((String)localObject3);
    localObject1 = new BnrReport.ExtInfo();
    ((BnrReport.ExtInfo)localObject1).app_ver.set(paramString);
    ((BnrReport.ExtInfo)localObject1).sys_ver.set(((StringBuffer)localObject2).toString());
    paramString = new BnrReport.BNReportConfigReq();
    localObject2 = a();
    if (localObject2 != null)
    {
      j = ((SparseIntArray)localObject2).size();
      i = 0;
      while (i < j)
      {
        int k = ((SparseIntArray)localObject2).keyAt(i);
        int m = ((SparseIntArray)localObject2).get(k);
        localObject3 = new BnrReport.BNReportGroupInfo();
        ((BnrReport.BNReportGroupInfo)localObject3).id.set(k);
        ((BnrReport.BNReportGroupInfo)localObject3).seqno.set(m);
        paramString.group_info.add((MessageMicro)localObject3);
        i += 1;
      }
    }
    return localObject2;
  }
  
  protected static JSONObject a()
  {
    try
    {
      InputStream localInputStream = BaseApplication.getContext().getAssets().open("qb_report_config.json");
      Object localObject = ndq.a(localInputStream);
      try
      {
        localInputStream.close();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return null;
        }
      }
      catch (IOException localIOException2)
      {
        do
        {
          for (;;)
          {
            localIOException2.printStackTrace();
          }
          try
          {
            localObject = new JSONObject((String)localObject);
            return localObject;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        } while (!QLog.isColorLevel());
        QLog.i("BnrReport", 2, "error : loadAllConfig");
        return null;
      }
      return null;
    }
    catch (IOException localIOException1) {}
  }
  
  public static void a()
  {
    
    if (QLog.isColorLevel()) {
      QLog.d("BnrReport", 2, "BnrReport init");
    }
    b = true;
  }
  
  protected static void a(SparseIntArray paramSparseIntArray)
  {
    if (paramSparseIntArray == null) {}
    StringBuffer localStringBuffer;
    do
    {
      return;
      localStringBuffer = new StringBuffer("");
      int j = paramSparseIntArray.size();
      int i = 0;
      while (i < j)
      {
        if (i > 0) {
          localStringBuffer.append("|");
        }
        int k = paramSparseIntArray.keyAt(i);
        localStringBuffer.append(k).append("-").append(paramSparseIntArray.get(k));
        i += 1;
      }
      paramSparseIntArray = BaseApplication.getContext().getSharedPreferences("pref_bnr_report", 0).edit();
      paramSparseIntArray.putString("bnr_group_update_ver", localStringBuffer.toString());
      paramSparseIntArray.commit();
    } while (!QLog.isDevelopLevel());
    QLog.d("BnrReport", 4, "server ver:" + localStringBuffer.toString());
  }
  
  protected static void a(AppInterface paramAppInterface) {}
  
  public static void a(AppInterface paramAppInterface, int paramInt)
  {
    a(paramAppInterface, paramInt, "", 0, 0, "", "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (a(paramInt1))
    {
      azmj.b(null, "P_CliOper", "AppBernoulliReport", "", paramInt1 + "", paramString1, paramInt2, paramInt3, paramString2, paramString3, paramString3, paramString4);
      if (!QLog.isDevelopLevel()) {}
    }
    if (paramAppInterface != null) {
      a(paramAppInterface);
    }
  }
  
  protected static void a(BnrReport.BNReportConfigRsp paramBNReportConfigRsp)
  {
    if ((paramBNReportConfigRsp == null) || (((BnrReport.RetInfo)((BnrReport.RetInfo)paramBNReportConfigRsp.ret_info.get()).get()).ret_code.get() != 0L)) {}
    List localList;
    JSONObject localJSONObject;
    do
    {
      do
      {
        return;
        localList = paramBNReportConfigRsp.cfglist.get();
      } while (localList == null);
      localJSONObject = a();
    } while (localJSONObject == null);
    paramBNReportConfigRsp = a();
    if (paramBNReportConfigRsp == null) {
      paramBNReportConfigRsp = new SparseIntArray();
    }
    for (;;)
    {
      SparseIntArray localSparseIntArray = new SparseIntArray();
      int j = localList.size();
      int i = 0;
      if (i < j)
      {
        BnrReport.BNReportConfig localBNReportConfig = (BnrReport.BNReportConfig)((BnrReport.BNReportConfig)localList.get(i)).get();
        int k = localBNReportConfig.id.get();
        int m = localBNReportConfig.seqno.get();
        localSparseIntArray.put(k, m);
        if ((paramBNReportConfigRsp.get(k) > 0) && (paramBNReportConfigRsp.get(k) == m)) {}
        for (;;)
        {
          i += 1;
          break;
          a(localJSONObject, k, false);
          a(localJSONObject, localBNReportConfig.idList.get(), false);
        }
      }
      a(localSparseIntArray);
      d();
      b();
      return;
    }
  }
  
  /* Error */
  protected static void a(JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +23 -> 24
    //   4: iload_1
    //   5: iconst_1
    //   6: if_icmplt +18 -> 24
    //   9: getstatic 13	nco:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   12: ifnull +12 -> 24
    //   15: getstatic 13	nco:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   18: invokevirtual 19	java/util/ArrayList:size	()I
    //   21: ifne +4 -> 25
    //   24: return
    //   25: aload_0
    //   26: ldc 63
    //   28: invokevirtual 67	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   31: istore_3
    //   32: iload_3
    //   33: invokestatic 426	nco:a	(I)I
    //   36: iconst_m1
    //   37: if_icmple +14 -> 51
    //   40: getstatic 13	nco:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   43: iload_3
    //   44: invokestatic 426	nco:a	(I)I
    //   47: invokevirtual 429	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   50: pop
    //   51: aload_0
    //   52: ldc 46
    //   54: invokevirtual 52	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   57: astore_0
    //   58: aload_0
    //   59: ifnull -35 -> 24
    //   62: aload_0
    //   63: invokevirtual 57	org/json/JSONArray:length	()I
    //   66: istore 4
    //   68: iconst_0
    //   69: istore_3
    //   70: iload_3
    //   71: iload 4
    //   73: if_icmpge -49 -> 24
    //   76: aload_0
    //   77: iload_3
    //   78: invokevirtual 61	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   81: astore 5
    //   83: aload 5
    //   85: ldc 63
    //   87: invokevirtual 67	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   90: iload_1
    //   91: if_icmpeq +7 -> 98
    //   94: iload_2
    //   95: ifeq +10 -> 105
    //   98: aload 5
    //   100: iload_1
    //   101: iconst_1
    //   102: invokestatic 408	nco:a	(Lorg/json/JSONObject;IZ)V
    //   105: iload_3
    //   106: iconst_1
    //   107: iadd
    //   108: istore_3
    //   109: goto -39 -> 70
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 74	org/json/JSONException:printStackTrace	()V
    //   117: return
    //   118: astore_0
    //   119: aload_0
    //   120: invokevirtual 74	org/json/JSONException:printStackTrace	()V
    //   123: aconst_null
    //   124: astore_0
    //   125: goto -67 -> 58
    //   128: astore 5
    //   130: aload 5
    //   132: invokevirtual 74	org/json/JSONException:printStackTrace	()V
    //   135: goto -30 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramJSONObject	JSONObject
    //   0	138	1	paramInt	int
    //   0	138	2	paramBoolean	boolean
    //   31	78	3	i	int
    //   66	8	4	j	int
    //   81	18	5	localJSONObject	JSONObject
    //   128	3	5	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   25	32	112	org/json/JSONException
    //   51	58	118	org/json/JSONException
    //   76	94	128	org/json/JSONException
    //   98	105	128	org/json/JSONException
  }
  
  /* Error */
  protected static void a(JSONObject paramJSONObject, List<Integer> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +16 -> 17
    //   4: aload_1
    //   5: ifnull +12 -> 17
    //   8: aload_1
    //   9: invokeinterface 397 1 0
    //   14: ifne +4 -> 18
    //   17: return
    //   18: getstatic 13	nco:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   21: ifnonnull +13 -> 34
    //   24: new 15	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 38	java/util/ArrayList:<init>	()V
    //   31: putstatic 13	nco:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   34: aload_0
    //   35: ldc 63
    //   37: invokevirtual 67	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   40: istore_3
    //   41: aload_1
    //   42: iload_3
    //   43: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: invokeinterface 436 2 0
    //   51: iconst_m1
    //   52: if_icmpgt +7 -> 59
    //   55: iload_2
    //   56: ifeq +100 -> 156
    //   59: iconst_1
    //   60: istore_2
    //   61: aconst_null
    //   62: astore 5
    //   64: aload_0
    //   65: ldc 46
    //   67: invokevirtual 52	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull +61 -> 133
    //   75: aload_0
    //   76: invokevirtual 57	org/json/JSONArray:length	()I
    //   79: istore 4
    //   81: iconst_0
    //   82: istore_3
    //   83: iload_3
    //   84: iload 4
    //   86: if_icmpge -69 -> 17
    //   89: aload_0
    //   90: iload_3
    //   91: invokevirtual 61	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   94: aload_1
    //   95: iload_2
    //   96: invokestatic 418	nco:a	(Lorg/json/JSONObject;Ljava/util/List;Z)V
    //   99: iload_3
    //   100: iconst_1
    //   101: iadd
    //   102: istore_3
    //   103: goto -20 -> 83
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 74	org/json/JSONException:printStackTrace	()V
    //   111: return
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 74	org/json/JSONException:printStackTrace	()V
    //   117: aload 5
    //   119: astore_0
    //   120: goto -49 -> 71
    //   123: astore 5
    //   125: aload 5
    //   127: invokevirtual 74	org/json/JSONException:printStackTrace	()V
    //   130: goto -31 -> 99
    //   133: iload_2
    //   134: ifeq -117 -> 17
    //   137: iload_3
    //   138: invokestatic 357	nco:a	(I)Z
    //   141: ifne -124 -> 17
    //   144: getstatic 13	nco:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   147: iload_3
    //   148: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: invokevirtual 439	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   154: pop
    //   155: return
    //   156: iconst_0
    //   157: istore_2
    //   158: goto -97 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramJSONObject	JSONObject
    //   0	161	1	paramList	List<Integer>
    //   0	161	2	paramBoolean	boolean
    //   40	108	3	i	int
    //   79	8	4	j	int
    //   62	56	5	localObject	Object
    //   123	3	5	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   34	41	106	org/json/JSONException
    //   64	71	112	org/json/JSONException
    //   89	99	123	org/json/JSONException
  }
  
  public static boolean a(int paramInt)
  {
    return true;
  }
  
  protected static void b()
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("pref_bnr_report", 0).edit();
    jdField_a_of_type_Long = System.currentTimeMillis();
    localEditor.putLong("bnr_last_up_time", jdField_a_of_type_Long);
    localEditor.commit();
  }
  
  protected static void c()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("pref_bnr_report", 0).getString("bnr_open_report_id", "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = ((String)localObject).split("\\|");
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    int j = localObject.length;
    int i = 0;
    while (i < j) {
      try
      {
        int k = Integer.valueOf(localObject[i]).intValue();
        jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(k));
        i += 1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          localNumberFormatException.printStackTrace();
        }
      }
    }
  }
  
  protected static void d()
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    int j = jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append(jdField_a_of_type_JavaUtilArrayList.get(i));
      i += 1;
    }
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("pref_bnr_report", 0).edit();
    localEditor.putString("bnr_open_report_id", localStringBuffer.toString());
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nco
 * JD-Core Version:    0.7.0.1
 */