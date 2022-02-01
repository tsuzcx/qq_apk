package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import mqq.manager.Manager;

public class SchoolTroopKeywordManager
  implements Manager
{
  public static final String a;
  private static final String[] e = { "", HardCodeUtil.a(2131911040), HardCodeUtil.a(2131911041) };
  private static final String[] f = { "", HardCodeUtil.a(2131911042), HardCodeUtil.a(2131911039) };
  protected final QQAppInterface b;
  protected SparseArray<String[]> c = new SparseArray();
  protected LinkedHashMap<String, SchoolTroopKeywordManager.KeywordResult> d = new LinkedHashMap();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(".troop.school_troop.");
    localStringBuilder.append(SchoolTroopKeywordManager.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public SchoolTroopKeywordManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    c();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return "";
    }
    if (paramString1.length() <= 0) {
      return "";
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramString2 = new StringBuilder();
    int k = paramString1.length();
    int i = 0;
    while (i < k)
    {
      int m = paramString1.codePointAt(i);
      if (EmotcationConstants.EMOJI_MAP.get(m, -1) != -1)
      {
        int j = i;
        if (m > 65535) {
          j = i + 1;
        }
        paramString2.append(str);
        i = j;
      }
      else if (m == 20)
      {
        i += 1;
        paramString2.append(str);
      }
      else
      {
        paramString2.append(paramString1.charAt(i));
      }
      i += 1;
    }
    return paramString2.toString();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.a != 1) {
      return false;
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramSessionInfo.b);
    if (paramQQAppInterface == null) {
      return false;
    }
    return paramQQAppInterface.dwGroupClassExt == 32L;
  }
  
  private void c()
  {
    long l = System.currentTimeMillis();
    Object localObject = this.b.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("homework_troop_config");
    localStringBuilder.append(this.b.getCurrentUin());
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString("troop_school_keyword_config", "");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.w(a, 2, "The configString is empty, new user or no config");
      }
      return;
    }
    a((String)localObject);
    localObject = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadConfig cost time: ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
  }
  
  public int a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.a != 1) {
      return -1;
    }
    if (this.c.size() == 0) {
      return -4;
    }
    String str = this.b.getCurrentAccountUin();
    Object localObject = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramSessionInfo.b);
    if (localObject == null)
    {
      str = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("it must be wrong. The troopUin '");
      ((StringBuilder)localObject).append(paramSessionInfo.b);
      ((StringBuilder)localObject).append("' has not troopInfo");
      QLog.w(str, 2, ((StringBuilder)localObject).toString());
      return -2;
    }
    if (((TroopInfo)localObject).dwGroupClassExt != 32L)
    {
      if (QLog.isDevelopLevel())
      {
        str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Not school troop. The troopUin '");
        localStringBuilder.append(paramSessionInfo.b);
        localStringBuilder.append("', dwGroupClassExt = ");
        localStringBuilder.append(((TroopInfo)localObject).dwGroupClassExt);
        QLog.i(str, 2, localStringBuilder.toString());
      }
      return -3;
    }
    int i = 0;
    if (((TroopInfo)localObject).isTroopOwner(str)) {
      i = 1;
    } else if (((TroopInfo)localObject).isTroopAdmin(str)) {
      i = 2;
    }
    if (QLog.isDevelopLevel())
    {
      paramSessionInfo = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("detect role. The currentUin '");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("', role = ");
      ((StringBuilder)localObject).append(i);
      QLog.i(paramSessionInfo, 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public SchoolTroopKeywordManager.KeywordResult a(SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    long l1 = System.currentTimeMillis();
    if (paramMessageRecord != null)
    {
      if (TextUtils.isEmpty(paramMessageRecord.msg)) {
        return null;
      }
      int i = a(paramSessionInfo);
      if (QLog.isColorLevel())
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("detectKeyword.detectRole time cost: ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l1);
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      if (i <= 0) {
        return null;
      }
      if (((i & 0x2) != 2) && ((i & 0x1) != 1)) {
        return null;
      }
      if (this.c.size() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(a, 2, "Keywords is empty, the config is error?");
        }
        return null;
      }
      long l2 = paramMessageRecord.uniseq;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(i);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = (SchoolTroopKeywordManager.KeywordResult)this.d.get(localObject1);
      if (localObject2 != null)
      {
        if (QLog.isColorLevel())
        {
          paramSessionInfo = a;
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("detectKeyword.useCache time cost: ");
          paramMessageRecord.append(System.currentTimeMillis() - l1);
          QLog.i(paramSessionInfo, 2, paramMessageRecord.toString());
        }
        return localObject2;
      }
      localObject2 = paramMessageRecord.msg;
      paramMessageRecord = new SchoolTroopKeywordManager.KeywordResult();
      paramMessageRecord.a = l2;
      paramMessageRecord.c = i;
      paramMessageRecord.b = paramSessionInfo.b;
      paramMessageRecord.a((String)localObject2);
      int k = this.c.size();
      i = 0;
      while (i < k)
      {
        int m = this.c.keyAt(i);
        paramSessionInfo = (String[])this.c.get(m);
        int n = paramSessionInfo.length;
        int j = 0;
        while (j < n)
        {
          String str = paramSessionInfo[j];
          int i1 = ((String)localObject2).indexOf(str);
          if (i1 != -1)
          {
            paramMessageRecord.d = m;
            paramMessageRecord.e = str;
            paramMessageRecord.f = i1;
            paramMessageRecord.g = (i1 + str.length());
            this.d.put(localObject1, paramMessageRecord);
            return paramMessageRecord;
          }
          j += 1;
        }
        i += 1;
      }
      paramMessageRecord.d = -1;
      this.d.put(localObject1, paramMessageRecord);
      if (QLog.isColorLevel())
      {
        paramSessionInfo = a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("detectKeyword time cost: ");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
        ((StringBuilder)localObject1).append(", result = ");
        ((StringBuilder)localObject1).append(paramMessageRecord.d);
        QLog.i(paramSessionInfo, 2, ((StringBuilder)localObject1).toString());
      }
      return paramMessageRecord;
    }
    return null;
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +44 -> 52
    //   11: getstatic 43	com/tencent/mobileqq/troop/utils/SchoolTroopKeywordManager:a	Ljava/lang/String;
    //   14: astore 9
    //   16: new 23	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   23: astore 10
    //   25: aload 10
    //   27: ldc_w 291
    //   30: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 10
    //   36: aload_1
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 9
    //   43: iconst_2
    //   44: aload 10
    //   46: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 197	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: new 293	org/json/JSONArray
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 295	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   60: astore 9
    //   62: aload 9
    //   64: invokevirtual 296	org/json/JSONArray:length	()I
    //   67: istore 4
    //   69: iconst_0
    //   70: istore_2
    //   71: iload_2
    //   72: iload 4
    //   74: if_icmpge +111 -> 185
    //   77: aload 9
    //   79: iload_2
    //   80: invokevirtual 300	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   83: astore 11
    //   85: aload 11
    //   87: ldc_w 302
    //   90: invokevirtual 307	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   93: istore 5
    //   95: iload 5
    //   97: getstatic 56	com/tencent/mobileqq/troop/utils/SchoolTroopKeywordManager:e	[Ljava/lang/String;
    //   100: arraylength
    //   101: if_icmplt +6 -> 107
    //   104: goto +253 -> 357
    //   107: new 309	java/util/ArrayList
    //   110: dup
    //   111: invokespecial 310	java/util/ArrayList:<init>	()V
    //   114: astore 10
    //   116: aload 11
    //   118: ldc_w 312
    //   121: invokevirtual 316	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   124: astore 11
    //   126: aload 11
    //   128: invokevirtual 296	org/json/JSONArray:length	()I
    //   131: istore 6
    //   133: iconst_0
    //   134: istore_3
    //   135: iload_3
    //   136: iload 6
    //   138: if_icmpge +22 -> 160
    //   141: aload 10
    //   143: aload 11
    //   145: iload_3
    //   146: invokevirtual 318	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   149: invokevirtual 322	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   152: pop
    //   153: iload_3
    //   154: iconst_1
    //   155: iadd
    //   156: istore_3
    //   157: goto -22 -> 135
    //   160: aload_0
    //   161: getfield 68	com/tencent/mobileqq/troop/utils/SchoolTroopKeywordManager:c	Landroid/util/SparseArray;
    //   164: iload 5
    //   166: aload 10
    //   168: aload 10
    //   170: invokevirtual 323	java/util/ArrayList:size	()I
    //   173: anewarray 45	java/lang/String
    //   176: invokevirtual 327	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   179: invokevirtual 330	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   182: goto +175 -> 357
    //   185: aload_0
    //   186: getfield 73	com/tencent/mobileqq/troop/utils/SchoolTroopKeywordManager:d	Ljava/util/LinkedHashMap;
    //   189: invokevirtual 333	java/util/LinkedHashMap:clear	()V
    //   192: getstatic 43	com/tencent/mobileqq/troop/utils/SchoolTroopKeywordManager:a	Ljava/lang/String;
    //   195: astore_1
    //   196: new 23	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   203: astore 9
    //   205: aload 9
    //   207: ldc_w 335
    //   210: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 9
    //   216: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   219: lload 7
    //   221: lsub
    //   222: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_1
    //   227: iconst_1
    //   228: aload 9
    //   230: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 197	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: return
    //   237: astore_1
    //   238: goto +60 -> 298
    //   241: getstatic 43	com/tencent/mobileqq/troop/utils/SchoolTroopKeywordManager:a	Ljava/lang/String;
    //   244: astore 9
    //   246: new 23	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   253: astore 10
    //   255: aload 10
    //   257: ldc_w 337
    //   260: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 10
    //   266: aload_1
    //   267: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 9
    //   273: iconst_2
    //   274: aload 10
    //   276: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 186	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: getstatic 43	com/tencent/mobileqq/troop/utils/SchoolTroopKeywordManager:a	Ljava/lang/String;
    //   285: astore_1
    //   286: new 23	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   293: astore 9
    //   295: goto -90 -> 205
    //   298: getstatic 43	com/tencent/mobileqq/troop/utils/SchoolTroopKeywordManager:a	Ljava/lang/String;
    //   301: astore 9
    //   303: new 23	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   310: astore 10
    //   312: aload 10
    //   314: ldc_w 335
    //   317: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 10
    //   323: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   326: lload 7
    //   328: lsub
    //   329: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload 9
    //   335: iconst_1
    //   336: aload 10
    //   338: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 197	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: goto +5 -> 349
    //   347: aload_1
    //   348: athrow
    //   349: goto -2 -> 347
    //   352: astore 9
    //   354: goto -113 -> 241
    //   357: iload_2
    //   358: iconst_1
    //   359: iadd
    //   360: istore_2
    //   361: goto -290 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	this	SchoolTroopKeywordManager
    //   0	364	1	paramString	String
    //   70	291	2	i	int
    //   134	23	3	j	int
    //   67	8	4	k	int
    //   93	72	5	m	int
    //   131	8	6	n	int
    //   3	324	7	l	long
    //   14	320	9	localObject1	Object
    //   352	1	9	localJSONException	org.json.JSONException
    //   23	314	10	localObject2	Object
    //   83	61	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   52	69	237	finally
    //   77	104	237	finally
    //   107	133	237	finally
    //   141	153	237	finally
    //   160	182	237	finally
    //   185	192	237	finally
    //   241	282	237	finally
    //   52	69	352	org/json/JSONException
    //   77	104	352	org/json/JSONException
    //   107	133	352	org/json/JSONException
    //   141	153	352	org/json/JSONException
    //   160	182	352	org/json/JSONException
    //   185	192	352	org/json/JSONException
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager
 * JD-Core Version:    0.7.0.1
 */