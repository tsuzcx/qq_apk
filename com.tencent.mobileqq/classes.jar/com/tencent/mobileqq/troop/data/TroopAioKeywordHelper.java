package com.tencent.mobileqq.troop.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeyword;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeywordInfo;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeywordRuleInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopAioKeywordHelper
{
  public static TroopAioKeywordTipInfo a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (TroopAioKeywordTipInfo)paramQQAppInterface.find(TroopAioKeywordTipInfo.class, paramString);
    paramQQAppInterface.close();
    if (QLog.isColorLevel())
    {
      if (paramString == null)
      {
        QLog.i("TroopAioKeywordHelper", 2, "getLocalTipInfo, tipInfo = null");
        return paramString;
      }
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getLocalTipInfo, tipInfo = ");
      paramQQAppInterface.append(paramString.toString());
      QLog.i("TroopAioKeywordHelper", 2, paramQQAppInterface.toString());
    }
    return paramString;
  }
  
  public static oidb_0x496.AioKeyword a()
  {
    byte[] arrayOfByte = FileUtils.fileToBytes(BaseApplication.getContext().getFileStreamPath("0x496_aio_keyword"));
    oidb_0x496.AioKeyword localAioKeyword = new oidb_0x496.AioKeyword();
    if (arrayOfByte == null) {
      return localAioKeyword;
    }
    try
    {
      localAioKeyword.mergeFrom(arrayOfByte);
      return localAioKeyword;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get0x496AioKeyword,");
        localStringBuilder.append(localInvalidProtocolBufferMicroException.toString());
        QLog.i("TroopAioKeywordHelper", 2, localStringBuilder.toString());
      }
    }
    return localAioKeyword;
  }
  
  public static List<String> a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = paramQQAppInterface.query(TroopAioKeyBlackRule.class);
    ArrayList localArrayList = new ArrayList();
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((TroopAioKeyBlackRule)((Iterator)localObject).next()).mBlackUinKeywordRuleId);
    }
    paramQQAppInterface.close();
    return localArrayList;
  }
  
  public static List<TroopAioKeywordTipInfo> a(QQAppInterface paramQQAppInterface, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList(15);
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return localArrayList;
      }
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        TroopAioKeywordTipInfo localTroopAioKeywordTipInfo = (TroopAioKeywordTipInfo)paramQQAppInterface.find(TroopAioKeywordTipInfo.class, paramArrayOfString[i]);
        if (localTroopAioKeywordTipInfo != null) {
          localArrayList.add(localTroopAioKeywordTipInfo);
        }
        i += 1;
      }
      paramQQAppInterface.close();
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("getLocalTipInfo, tipInfos=");
        paramQQAppInterface.append(localArrayList.toString());
        QLog.i("TroopAioKeywordHelper", 2, paramQQAppInterface.toString());
      }
    }
    return localArrayList;
  }
  
  public static List<TroopAioKeywordInfo> a(oidb_0x496.AioKeyword paramAioKeyword)
  {
    if ((paramAioKeyword != null) && (paramAioKeyword.has()) && (paramAioKeyword.keywords.has()))
    {
      ArrayList localArrayList = new ArrayList();
      paramAioKeyword = paramAioKeyword.keywords.get().iterator();
      while (paramAioKeyword.hasNext())
      {
        oidb_0x496.AioKeywordInfo localAioKeywordInfo = (oidb_0x496.AioKeywordInfo)paramAioKeyword.next();
        TroopAioKeywordInfo localTroopAioKeywordInfo = new TroopAioKeywordInfo();
        localTroopAioKeywordInfo.jdField_a_of_type_JavaLangString = localAioKeywordInfo.word.get();
        localTroopAioKeywordInfo.jdField_a_of_type_JavaUtilList = localAioKeywordInfo.rule_id.get();
        localArrayList.add(localTroopAioKeywordInfo);
      }
      return localArrayList;
    }
    return null;
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, oidb_0x496.AioKeyword paramAioKeyword)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 77	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: ldc 79
    //   9: iconst_0
    //   10: invokevirtual 190	com/tencent/qphone/base/util/BaseApplication:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   13: astore 4
    //   15: aload 4
    //   17: astore_2
    //   18: aload 4
    //   20: astore_3
    //   21: aload 4
    //   23: aload_1
    //   24: invokevirtual 194	com/tencent/mobileqq/troop/org/pb/oidb_0x496$AioKeyword:toByteArray	()[B
    //   27: invokevirtual 200	java/io/FileOutputStream:write	([B)V
    //   30: aload 4
    //   32: astore_2
    //   33: aload 4
    //   35: astore_3
    //   36: aload 4
    //   38: invokevirtual 203	java/io/FileOutputStream:flush	()V
    //   41: aload 4
    //   43: astore_2
    //   44: aload 4
    //   46: astore_3
    //   47: aload 4
    //   49: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   52: aload 4
    //   54: astore_2
    //   55: aload 4
    //   57: astore_3
    //   58: ldc 206
    //   60: invokestatic 212	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   63: checkcast 206	com/tencent/mobileqq/troop/utils/api/ITroopSPUtilApi
    //   66: invokestatic 218	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   69: aload_0
    //   70: invokevirtual 221	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   73: aload_1
    //   74: getfield 225	com/tencent/mobileqq/troop/org/pb/oidb_0x496$AioKeyword:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   77: invokevirtual 230	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   80: invokeinterface 234 4 0
    //   85: aload 4
    //   87: ifnull +133 -> 220
    //   90: aload 4
    //   92: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   95: return
    //   96: astore_0
    //   97: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +120 -> 220
    //   103: new 56	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   110: astore_1
    //   111: aload_1
    //   112: ldc 236
    //   114: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_1
    //   119: aload_0
    //   120: invokevirtual 237	java/io/IOException:toString	()Ljava/lang/String;
    //   123: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: ldc 48
    //   129: iconst_2
    //   130: aload_1
    //   131: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 240	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: return
    //   138: astore_0
    //   139: goto +82 -> 221
    //   142: astore_0
    //   143: aload_3
    //   144: astore_2
    //   145: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +45 -> 193
    //   151: aload_3
    //   152: astore_2
    //   153: new 56	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   160: astore_1
    //   161: aload_3
    //   162: astore_2
    //   163: aload_1
    //   164: ldc 236
    //   166: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_3
    //   171: astore_2
    //   172: aload_1
    //   173: aload_0
    //   174: invokevirtual 237	java/io/IOException:toString	()Ljava/lang/String;
    //   177: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_3
    //   182: astore_2
    //   183: ldc 48
    //   185: iconst_2
    //   186: aload_1
    //   187: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 240	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload_3
    //   194: ifnull +26 -> 220
    //   197: aload_3
    //   198: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   201: return
    //   202: astore_0
    //   203: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +14 -> 220
    //   209: new 56	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   216: astore_1
    //   217: goto -106 -> 111
    //   220: return
    //   221: aload_2
    //   222: ifnull +51 -> 273
    //   225: aload_2
    //   226: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   229: goto +44 -> 273
    //   232: astore_1
    //   233: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq +37 -> 273
    //   239: new 56	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   246: astore_2
    //   247: aload_2
    //   248: ldc 236
    //   250: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_2
    //   255: aload_1
    //   256: invokevirtual 237	java/io/IOException:toString	()Ljava/lang/String;
    //   259: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: ldc 48
    //   265: iconst_2
    //   266: aload_2
    //   267: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 240	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: goto +5 -> 278
    //   276: aload_0
    //   277: athrow
    //   278: goto -2 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	paramQQAppInterface	QQAppInterface
    //   0	281	1	paramAioKeyword	oidb_0x496.AioKeyword
    //   3	264	2	localObject1	Object
    //   1	197	3	localObject2	Object
    //   13	78	4	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   90	95	96	java/io/IOException
    //   4	15	138	finally
    //   21	30	138	finally
    //   36	41	138	finally
    //   47	52	138	finally
    //   58	85	138	finally
    //   145	151	138	finally
    //   153	161	138	finally
    //   163	170	138	finally
    //   172	181	138	finally
    //   183	193	138	finally
    //   4	15	142	java/io/IOException
    //   21	30	142	java/io/IOException
    //   36	41	142	java/io/IOException
    //   47	52	142	java/io/IOException
    //   58	85	142	java/io/IOException
    //   197	201	202	java/io/IOException
    //   225	229	232	java/io/IOException
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    TroopAioKeyBlackRule localTroopAioKeyBlackRule = new TroopAioKeyBlackRule();
    localTroopAioKeyBlackRule.mBlackUinKeywordRuleId = paramString;
    paramQQAppInterface.persistOrReplace(localTroopAioKeyBlackRule);
    paramQQAppInterface.close();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<TroopAioKeywordTipInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramQQAppInterface.persistOrReplace((TroopAioKeywordTipInfo)paramList.next());
      }
      paramQQAppInterface.close();
    }
  }
  
  public static List<TroopAioKeywordRuleInfo> b(oidb_0x496.AioKeyword paramAioKeyword)
  {
    if ((paramAioKeyword != null) && (paramAioKeyword.has()) && (paramAioKeyword.rules.has()))
    {
      ArrayList localArrayList = new ArrayList();
      paramAioKeyword = paramAioKeyword.rules.get().iterator();
      while (paramAioKeyword.hasNext())
      {
        oidb_0x496.AioKeywordRuleInfo localAioKeywordRuleInfo = (oidb_0x496.AioKeywordRuleInfo)paramAioKeyword.next();
        TroopAioKeywordRuleInfo localTroopAioKeywordRuleInfo = new TroopAioKeywordRuleInfo();
        localTroopAioKeywordRuleInfo.jdField_a_of_type_Int = localAioKeywordRuleInfo.rule_id.get();
        localTroopAioKeywordRuleInfo.b = localAioKeywordRuleInfo.start_time.get();
        localTroopAioKeywordRuleInfo.c = localAioKeywordRuleInfo.end_time.get();
        localTroopAioKeywordRuleInfo.d = localAioKeywordRuleInfo.postion_flag.get();
        localTroopAioKeywordRuleInfo.jdField_a_of_type_JavaUtilList = localAioKeywordRuleInfo.match_group_class.get();
        localTroopAioKeywordRuleInfo.e = localAioKeywordRuleInfo.version.get();
        localArrayList.add(localTroopAioKeywordRuleInfo);
      }
      return localArrayList;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordHelper
 * JD-Core Version:    0.7.0.1
 */