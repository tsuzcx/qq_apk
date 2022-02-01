package com.tencent.mobileqq.gamecenter.message;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.Nullable;

public class TinyIdCache
  extends FullCache
{
  private long jdField_a_of_type_Long = 0L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, Pair<String, String>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TinyIdCache(QQAppInterface paramQQAppInterface, DBDelayManager paramDBDelayManager)
  {
    super(paramQQAppInterface, paramDBDelayManager, UinToTinyId.class);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    c();
  }
  
  private UinToTinyId a(String paramString)
  {
    return (UinToTinyId)findCache(paramString);
  }
  
  @Nullable
  private String a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {
      return null;
    }
    UinToTinyId localUinToTinyId = a(paramString3);
    if (localUinToTinyId != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.tiny_msg.TinyIdCache", 2, "findUinWithTinyId UIN = " + localUinToTinyId.friendUin + ",  fromTinyId = " + paramString1 + ", toTinyId = " + paramString2);
      }
      return localUinToTinyId.friendUin;
    }
    localUinToTinyId = new UinToTinyId();
    long l = this.jdField_a_of_type_Long - 1L;
    this.jdField_a_of_type_Long = l;
    localUinToTinyId.friendUin = String.valueOf(l);
    localUinToTinyId.tinyId = paramString3;
    localUinToTinyId.fromTinyId = paramString1;
    localUinToTinyId.toTinyId = paramString2;
    addCache(localUinToTinyId);
    d();
    if (QLog.isColorLevel()) {
      QLog.d("Q.tiny_msg.TinyIdCache", 2, "findUinWithTinyId NULL UIN = " + localUinToTinyId.friendUin + ",  fromTinyId = " + paramString1 + ", toTinyId = " + paramString2 + ", time = " + NetConnInfoCenter.getServerTime());
    }
    return localUinToTinyId.friendUin;
  }
  
  private void c()
  {
    do
    {
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        this.cacheMap.clear();
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        localObject2 = ((EntityManager)localObject1).query(UinToTinyId.class);
        ((EntityManager)localObject1).close();
        if (localObject2 != null)
        {
          b();
          localObject1 = ((List)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (UinToTinyId)((Iterator)localObject1).next();
            this.cacheMap.put(((UinToTinyId)localObject2).tinyId, localObject2);
          }
        }
        localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_name_tinyid_uin_mapping", 0);
      }
      catch (Exception localException)
      {
        QLog.d("Q.tiny_msg.TinyIdCache", 1, "doInit occur error", localException);
        return;
      }
      SharedPreferences localSharedPreferences;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_Long = localSharedPreferences.getLong("key_last_uin_consume_" + (String)localObject2, 9223372036854775807L);
    } while (!QLog.isColorLevel());
    QLog.d("Q.tiny_msg.TinyIdCache", 2, "doInit size = " + this.cacheMap.size() + ", lastUinConsume = " + this.jdField_a_of_type_Long);
  }
  
  private void d()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_name_tinyid_uin_mapping", 0);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localSharedPreferences.edit().putLong("key_last_uin_consume_" + str, this.jdField_a_of_type_Long).apply();
    if (QLog.isColorLevel()) {
      QLog.d("Q.tiny_msg.TinyIdCache", 2, "persistLastConsumeId lastUinConsume = " + this.jdField_a_of_type_Long);
    }
  }
  
  public Pair<String, String> a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      localObject1 = (Pair)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (localObject1 != null)) {
        QLog.d("Q.tiny_msg.TinyIdCache", 2, "findTinyId  from cache fromTinyId = " + (String)((Pair)localObject1).first + ", toTinyId = " + (String)((Pair)localObject1).second);
      }
      return localObject1;
      Iterator localIterator = this.cacheMap.values().iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (UinToTinyId)localIterator.next();
      } while (!TextUtils.equals(((UinToTinyId)localObject1).friendUin, paramString));
      localObject1 = new Pair(((UinToTinyId)localObject1).fromTinyId, ((UinToTinyId)localObject1).toTinyId);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
    }
  }
  
  public String a(String paramString)
  {
    String str = "";
    Pair localPair = a(paramString);
    paramString = str;
    if (localPair != null) {
      paramString = (String)localPair.first;
    }
    return paramString;
  }
  
  /* Error */
  public String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +12 -> 18
    //   9: aload_2
    //   10: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +9 -> 24
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: aload_0
    //   25: aload_1
    //   26: aload_2
    //   27: new 56	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   34: aload_1
    //   35: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 268	com/tencent/mobileqq/gamecenter/message/TinyIdCache:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_1
    //   49: goto -29 -> 20
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	TinyIdCache
    //   0	57	1	paramString1	String
    //   0	57	2	paramString2	String
    //   13	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	52	finally
    //   24	49	52	finally
  }
  
  public void a()
  {
    destroy();
  }
  
  public void b()
  {
    this.cacheMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void destroy()
  {
    b();
  }
  
  public String getKey(Entity paramEntity)
  {
    return ((UinToTinyId)paramEntity).tinyId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.TinyIdCache
 * JD-Core Version:    0.7.0.1
 */