package com.tencent.mobileqq.fts.utils;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.v1.utils.FTSMessageCodec;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FTSUtils
{
  private static int a = -1;
  private static int b = -1;
  
  public static int a(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("support_fts4_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), -1);
  }
  
  public static int a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_upgrade_tables");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = localStringBuilder.toString();
    paramInt2 += paramInt1;
    localEditor.putInt(paramAppRuntime, paramInt2);
    if (localEditor.commit()) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static long a(AppRuntime paramAppRuntime, long paramLong1, long paramLong2)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_upgrade_cost");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = localStringBuilder.toString();
    paramLong2 += paramLong1;
    localEditor.putLong(paramAppRuntime, paramLong2);
    if (localEditor.commit()) {
      return paramLong2;
    }
    return paramLong1;
  }
  
  public static FTSMessage a(ContentValues paramContentValues, MessageRecord paramMessageRecord)
  {
    try
    {
      if (paramContentValues.containsKey("msgData"))
      {
        byte[] arrayOfByte = paramContentValues.getAsByteArray("msgData");
        if (arrayOfByte == null) {
          paramMessageRecord.msg = null;
        } else {
          paramMessageRecord.msg = new String(arrayOfByte, "UTF-8");
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      paramMessageRecord.msg = null;
    }
    if (paramContentValues.containsKey("time")) {
      paramMessageRecord.time = paramContentValues.getAsLong("time").longValue();
    }
    if (paramContentValues.containsKey("shmsgseq")) {
      paramMessageRecord.shmsgseq = paramContentValues.getAsLong("shmsgseq").longValue();
    }
    return FTSMessageCodec.a(paramMessageRecord);
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 31	java/lang/StringBuilder
    //   3: dup
    //   4: bipush 64
    //   6: invokespecial 138	java/lang/StringBuilder:<init>	(I)V
    //   9: astore_2
    //   10: new 140	com/tencent/mobileqq/fts/v2/tokenizer/cjk/CJKTokenizer
    //   13: dup
    //   14: new 142	java/io/StringReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 145	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: invokevirtual 149	java/lang/String:length	()I
    //   26: invokespecial 152	com/tencent/mobileqq/fts/v2/tokenizer/cjk/CJKTokenizer:<init>	(Ljava/io/Reader;I)V
    //   29: astore_3
    //   30: aconst_null
    //   31: astore_0
    //   32: aload_3
    //   33: invokevirtual 155	com/tencent/mobileqq/fts/v2/tokenizer/cjk/CJKTokenizer:a	()Lcom/tencent/mobileqq/fts/v2/tokenizer/Token;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnonnull +60 -> 98
    //   41: aload_0
    //   42: ifnull +214 -> 256
    //   45: aload_0
    //   46: invokevirtual 160	com/tencent/mobileqq/fts/v2/tokenizer/Token:d	()Ljava/lang/String;
    //   49: ldc 162
    //   51: invokestatic 168	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   54: ifeq +202 -> 256
    //   57: aload_0
    //   58: invokevirtual 170	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   61: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +192 -> 256
    //   67: aload_2
    //   68: aload_0
    //   69: invokevirtual 170	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   72: aload_0
    //   73: invokevirtual 170	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   76: invokevirtual 149	java/lang/String:length	()I
    //   79: iconst_1
    //   80: isub
    //   81: invokevirtual 178	java/lang/String:charAt	(I)C
    //   84: invokevirtual 181	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_2
    //   89: ldc 183
    //   91: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: goto +161 -> 256
    //   98: aload_0
    //   99: ifnull +83 -> 182
    //   102: aload_0
    //   103: invokevirtual 160	com/tencent/mobileqq/fts/v2/tokenizer/Token:d	()Ljava/lang/String;
    //   106: ldc 162
    //   108: invokestatic 168	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   111: ifeq +71 -> 182
    //   114: aload_1
    //   115: invokevirtual 160	com/tencent/mobileqq/fts/v2/tokenizer/Token:d	()Ljava/lang/String;
    //   118: ldc 162
    //   120: invokestatic 168	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   123: ifeq +14 -> 137
    //   126: aload_0
    //   127: invokevirtual 186	com/tencent/mobileqq/fts/v2/tokenizer/Token:c	()I
    //   130: aload_1
    //   131: invokevirtual 188	com/tencent/mobileqq/fts/v2/tokenizer/Token:b	()I
    //   134: if_icmpge +48 -> 182
    //   137: aload_0
    //   138: invokevirtual 170	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   141: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +38 -> 182
    //   147: aload_2
    //   148: aload_0
    //   149: invokevirtual 170	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   152: aload_0
    //   153: invokevirtual 170	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   156: invokevirtual 149	java/lang/String:length	()I
    //   159: iconst_1
    //   160: isub
    //   161: invokevirtual 178	java/lang/String:charAt	(I)C
    //   164: invokevirtual 181	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_2
    //   169: ldc 183
    //   171: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_2
    //   176: bipush 32
    //   178: invokevirtual 181	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_1
    //   183: invokevirtual 170	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   186: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   189: ifne +42 -> 231
    //   192: aload_1
    //   193: invokevirtual 160	com/tencent/mobileqq/fts/v2/tokenizer/Token:d	()Ljava/lang/String;
    //   196: ldc 162
    //   198: invokestatic 168	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   201: ifeq +14 -> 215
    //   204: aload_1
    //   205: invokevirtual 170	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   208: invokevirtual 149	java/lang/String:length	()I
    //   211: iconst_1
    //   212: if_icmpeq +19 -> 231
    //   215: aload_2
    //   216: aload_1
    //   217: invokevirtual 170	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   220: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_2
    //   225: bipush 32
    //   227: invokevirtual 181	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_1
    //   232: astore_0
    //   233: goto -201 -> 32
    //   236: astore_0
    //   237: aload_0
    //   238: invokevirtual 189	java/io/IOException:printStackTrace	()V
    //   241: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +12 -> 256
    //   247: ldc 196
    //   249: iconst_2
    //   250: ldc 198
    //   252: aload_0
    //   253: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   256: aload_2
    //   257: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: astore_0
    //   261: aload_0
    //   262: areturn
    //   263: astore_0
    //   264: aload_0
    //   265: invokevirtual 203	java/lang/Throwable:printStackTrace	()V
    //   268: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +12 -> 283
    //   274: ldc 196
    //   276: iconst_2
    //   277: ldc 198
    //   279: aload_0
    //   280: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: aconst_null
    //   284: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramString	String
    //   36	196	1	localToken	com.tencent.mobileqq.fts.v2.tokenizer.Token
    //   9	248	2	localStringBuilder	StringBuilder
    //   29	4	3	localCJKTokenizer	com.tencent.mobileqq.fts.v2.tokenizer.cjk.CJKTokenizer
    // Exception table:
    //   from	to	target	type
    //   32	37	236	java/io/IOException
    //   45	95	236	java/io/IOException
    //   102	137	236	java/io/IOException
    //   137	182	236	java/io/IOException
    //   182	215	236	java/io/IOException
    //   215	231	236	java/io/IOException
    //   0	30	263	java/lang/Throwable
    //   32	37	263	java/lang/Throwable
    //   45	95	263	java/lang/Throwable
    //   102	137	263	java/lang/Throwable
    //   137	182	263	java/lang/Throwable
    //   182	215	263	java/lang/Throwable
    //   215	231	263	java/lang/Throwable
    //   237	256	263	java/lang/Throwable
    //   256	261	263	java/lang/Throwable
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("support_fts4_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.commit();
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0);
    paramAppRuntime = ((SharedPreferences)localObject).edit();
    localObject = ((SharedPreferences)localObject).getAll().keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (str.endsWith(paramString)) {
        paramAppRuntime.remove(str);
      }
    }
    paramAppRuntime.commit();
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_first_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean a(ContentValues paramContentValues)
  {
    if ((paramContentValues.containsKey("msgtype")) && (paramContentValues.getAsInteger("msgtype").intValue() == -2006)) {
      return true;
    }
    return (paramContentValues.containsKey("isValid")) && (!paramContentValues.getAsBoolean("isValid").booleanValue());
  }
  
  public static int b(AppRuntime paramAppRuntime)
  {
    int j = a(paramAppRuntime);
    int i = j;
    if (j == -1)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        a(paramAppRuntime, 1);
        return 1;
      }
      a(paramAppRuntime, 0);
      i = 0;
    }
    return i;
  }
  
  public static int b(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_upgrade_msgs");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = localStringBuilder.toString();
    paramInt2 += paramInt1;
    localEditor.putInt(paramAppRuntime, paramInt2);
    if (localEditor.commit()) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static void b(AppRuntime paramAppRuntime, int paramInt)
  {
    paramAppRuntime = MobileQQ.getMobileQQ().getSharedPreferences("fts_sp_file", 0).edit();
    paramAppRuntime.putInt("fts_crash_count_by_hook", paramInt);
    paramAppRuntime.commit();
  }
  
  public static void b(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hardware_support_fts_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean b(ContentValues paramContentValues)
  {
    if (paramContentValues.containsKey("msgData")) {
      return true;
    }
    if (paramContentValues.containsKey("time")) {
      return true;
    }
    return paramContentValues.containsKey("shmsgseq");
  }
  
  public static String[] b(String paramString)
  {
    Object localObject = c(paramString);
    if (localObject == null) {
      return null;
    }
    paramString = new ArrayList();
    int j = 0;
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      String str = a((String)((ArrayList)localObject).get(i));
      if (!TextUtils.isEmpty(str)) {
        paramString.add(str.trim());
      }
      i += 1;
    }
    if (paramString.size() == 0) {
      return null;
    }
    localObject = new String[paramString.size()];
    i = j;
    while (i < paramString.size())
    {
      localObject[i] = ((String)paramString.get(i));
      i += 1;
    }
    return localObject;
  }
  
  public static int c(AppRuntime paramAppRuntime)
  {
    return MobileQQ.getMobileQQ().getSharedPreferences("fts_sp_file", 0).getInt("fts_crash_count_by_hook", 0);
  }
  
  public static ArrayList<String> c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split("\\s");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length)
    {
      String str = paramString[i].trim();
      if ((str != null) && (!TextUtils.isEmpty(str))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void c(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_upgrade_log_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public static void d(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_upgrade_table_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.trim();
    int i = 0;
    while (i < paramString.length())
    {
      if ((paramString.charAt(i) < '0') && (paramString.charAt(i) > '9')) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean d(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hardware_support_fts_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.toLowerCase().trim();
    int i = 0;
    while (i < paramString.length())
    {
      if ((paramString.charAt(i) < 'a') && (paramString.charAt(i) > 'z')) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean e(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_first_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
  
  public static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.split(" ");
    return (paramString != null) && (paramString.length > 1);
  }
  
  public static boolean f(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_upgrade_log_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static long g(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_upgrade_cost");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static boolean h(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_upgrade_table_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static int i(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_upgrade_tables");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int j(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_upgrade_msgs");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean k(AppRuntime paramAppRuntime)
  {
    return (f(paramAppRuntime)) && (h(paramAppRuntime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.utils.FTSUtils
 * JD-Core Version:    0.7.0.1
 */