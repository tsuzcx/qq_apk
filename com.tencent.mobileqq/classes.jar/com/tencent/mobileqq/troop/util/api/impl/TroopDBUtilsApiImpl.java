package com.tencent.mobileqq.troop.util.api.impl;

import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import mqq.app.AppRuntime;

public class TroopDBUtilsApiImpl
  implements ITroopDBUtilsApi
{
  /* Error */
  public TroopMemberCardInfo getTroopMemberCardInfo(AppRuntime paramAppRuntime, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +66 -> 67
    //   4: aload_3
    //   5: ifnonnull +5 -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: aload_1
    //   11: invokevirtual 21	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   14: invokevirtual 27	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   17: astore_1
    //   18: aload_1
    //   19: ldc 29
    //   21: iconst_2
    //   22: anewarray 31	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: aload_2
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: aload_3
    //   32: aastore
    //   33: invokevirtual 37	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   36: checkcast 29	com/tencent/mobileqq/data/troop/TroopMemberCardInfo
    //   39: astore_2
    //   40: aload_1
    //   41: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   44: aload_2
    //   45: areturn
    //   46: astore_2
    //   47: goto +14 -> 61
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 43	java/lang/Exception:printStackTrace	()V
    //   55: aload_1
    //   56: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   59: aconst_null
    //   60: areturn
    //   61: aload_1
    //   62: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   65: aload_2
    //   66: athrow
    //   67: aconst_null
    //   68: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	TroopDBUtilsApiImpl
    //   0	69	1	paramAppRuntime	AppRuntime
    //   0	69	2	paramString1	java.lang.String
    //   0	69	3	paramString2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   18	40	46	finally
    //   51	55	46	finally
    //   18	40	50	java/lang/Exception
  }
  
  /* Error */
  public com.tencent.mobileqq.data.troop.TroopMemberInfo getTroopMemberInfo(AppRuntime paramAppRuntime, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +66 -> 67
    //   4: aload_3
    //   5: ifnonnull +5 -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: aload_1
    //   11: invokevirtual 21	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   14: invokevirtual 27	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   17: astore_1
    //   18: aload_1
    //   19: ldc 47
    //   21: iconst_2
    //   22: anewarray 31	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: aload_2
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: aload_3
    //   32: aastore
    //   33: invokevirtual 37	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   36: checkcast 47	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   39: astore_2
    //   40: aload_1
    //   41: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   44: aload_2
    //   45: areturn
    //   46: astore_2
    //   47: goto +14 -> 61
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 43	java/lang/Exception:printStackTrace	()V
    //   55: aload_1
    //   56: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   59: aconst_null
    //   60: areturn
    //   61: aload_1
    //   62: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   65: aload_2
    //   66: athrow
    //   67: aconst_null
    //   68: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	TroopDBUtilsApiImpl
    //   0	69	1	paramAppRuntime	AppRuntime
    //   0	69	2	paramString1	java.lang.String
    //   0	69	3	paramString2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   18	40	46	finally
    //   51	55	46	finally
    //   18	40	50	java/lang/Exception
  }
  
  /* Error */
  public java.util.ArrayList<TroopMemberCardInfo> modifyTroopMemberCardInfo(AppRuntime paramAppRuntime, java.lang.String paramString, java.util.ArrayList<friendlist.stUinInfo> paramArrayList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +342 -> 343
    //   4: aload_3
    //   5: ifnull +338 -> 343
    //   8: aload_3
    //   9: invokevirtual 55	java/util/ArrayList:size	()I
    //   12: ifne +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: new 51	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 56	java/util/ArrayList:<init>	()V
    //   24: astore 10
    //   26: aload_1
    //   27: invokevirtual 21	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   30: invokevirtual 27	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   33: astore 8
    //   35: aload 8
    //   37: invokevirtual 60	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: astore 9
    //   42: aload 9
    //   44: invokevirtual 65	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   47: iconst_0
    //   48: istore 4
    //   50: iload 4
    //   52: aload_3
    //   53: invokevirtual 55	java/util/ArrayList:size	()I
    //   56: if_icmpge +236 -> 292
    //   59: aload_3
    //   60: iload 4
    //   62: invokevirtual 69	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   65: checkcast 71	friendlist/stUinInfo
    //   68: astore 11
    //   70: aload 11
    //   72: getfield 75	friendlist/stUinInfo:dwuin	J
    //   75: lstore 6
    //   77: iconst_1
    //   78: istore 5
    //   80: aload 8
    //   82: ldc 29
    //   84: iconst_2
    //   85: anewarray 31	java/lang/String
    //   88: dup
    //   89: iconst_0
    //   90: aload_2
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: lload 6
    //   96: invokestatic 79	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   99: aastore
    //   100: invokevirtual 37	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   103: checkcast 29	com/tencent/mobileqq/data/troop/TroopMemberCardInfo
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +6 -> 114
    //   111: goto +14 -> 125
    //   114: new 29	com/tencent/mobileqq/data/troop/TroopMemberCardInfo
    //   117: dup
    //   118: invokespecial 80	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:<init>	()V
    //   121: astore_1
    //   122: iconst_0
    //   123: istore 5
    //   125: aload_1
    //   126: aload 11
    //   128: getfield 75	friendlist/stUinInfo:dwuin	J
    //   131: invokestatic 79	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   134: putfield 84	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:memberuin	Ljava/lang/String;
    //   137: aload_1
    //   138: aload_2
    //   139: putfield 87	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:troopuin	Ljava/lang/String;
    //   142: aload 11
    //   144: getfield 90	friendlist/stUinInfo:dwFlag	J
    //   147: lconst_1
    //   148: land
    //   149: lconst_0
    //   150: lcmp
    //   151: ifeq +12 -> 163
    //   154: aload_1
    //   155: aload 11
    //   157: getfield 93	friendlist/stUinInfo:sName	Ljava/lang/String;
    //   160: putfield 96	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:name	Ljava/lang/String;
    //   163: aload 11
    //   165: getfield 90	friendlist/stUinInfo:dwFlag	J
    //   168: ldc2_w 97
    //   171: land
    //   172: lconst_0
    //   173: lcmp
    //   174: ifeq +12 -> 186
    //   177: aload_1
    //   178: aload 11
    //   180: getfield 102	friendlist/stUinInfo:cGender	B
    //   183: putfield 105	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:sex	B
    //   186: aload 11
    //   188: getfield 90	friendlist/stUinInfo:dwFlag	J
    //   191: ldc2_w 106
    //   194: land
    //   195: lconst_0
    //   196: lcmp
    //   197: ifeq +12 -> 209
    //   200: aload_1
    //   201: aload 11
    //   203: getfield 110	friendlist/stUinInfo:sPhone	Ljava/lang/String;
    //   206: putfield 113	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:tel	Ljava/lang/String;
    //   209: aload 11
    //   211: getfield 90	friendlist/stUinInfo:dwFlag	J
    //   214: ldc2_w 114
    //   217: land
    //   218: lconst_0
    //   219: lcmp
    //   220: ifeq +12 -> 232
    //   223: aload_1
    //   224: aload 11
    //   226: getfield 118	friendlist/stUinInfo:sEmail	Ljava/lang/String;
    //   229: putfield 121	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:email	Ljava/lang/String;
    //   232: aload 11
    //   234: getfield 90	friendlist/stUinInfo:dwFlag	J
    //   237: ldc2_w 122
    //   240: land
    //   241: lconst_0
    //   242: lcmp
    //   243: ifeq +12 -> 255
    //   246: aload_1
    //   247: aload 11
    //   249: getfield 126	friendlist/stUinInfo:sRemark	Ljava/lang/String;
    //   252: putfield 129	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:memo	Ljava/lang/String;
    //   255: iload 5
    //   257: ifeq +13 -> 270
    //   260: aload 8
    //   262: aload_1
    //   263: invokevirtual 133	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   266: pop
    //   267: goto +9 -> 276
    //   270: aload 8
    //   272: aload_1
    //   273: invokevirtual 137	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   276: aload 10
    //   278: aload_1
    //   279: invokevirtual 141	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   282: pop
    //   283: iload 4
    //   285: iconst_1
    //   286: iadd
    //   287: istore 4
    //   289: goto -239 -> 50
    //   292: aload 9
    //   294: invokevirtual 144	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   297: aload 9
    //   299: invokevirtual 147	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   302: aload 8
    //   304: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   307: aload 10
    //   309: areturn
    //   310: astore_1
    //   311: goto +20 -> 331
    //   314: astore_1
    //   315: aload_1
    //   316: invokevirtual 43	java/lang/Exception:printStackTrace	()V
    //   319: aload 9
    //   321: invokevirtual 147	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   324: aload 8
    //   326: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   329: aconst_null
    //   330: areturn
    //   331: aload 9
    //   333: invokevirtual 147	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   336: aload 8
    //   338: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   341: aload_1
    //   342: athrow
    //   343: aconst_null
    //   344: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	TroopDBUtilsApiImpl
    //   0	345	1	paramAppRuntime	AppRuntime
    //   0	345	2	paramString	java.lang.String
    //   0	345	3	paramArrayList	java.util.ArrayList<friendlist.stUinInfo>
    //   48	240	4	i	int
    //   78	178	5	j	int
    //   75	20	6	l	long
    //   33	304	8	localEntityManager	EntityManager
    //   40	292	9	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   24	284	10	localArrayList	java.util.ArrayList
    //   68	180	11	localstUinInfo	friendlist.stUinInfo
    // Exception table:
    //   from	to	target	type
    //   42	47	310	finally
    //   50	77	310	finally
    //   80	107	310	finally
    //   114	122	310	finally
    //   125	163	310	finally
    //   163	186	310	finally
    //   186	209	310	finally
    //   209	232	310	finally
    //   232	255	310	finally
    //   260	267	310	finally
    //   270	276	310	finally
    //   276	283	310	finally
    //   292	297	310	finally
    //   315	319	310	finally
    //   42	47	314	java/lang/Exception
    //   50	77	314	java/lang/Exception
    //   80	107	314	java/lang/Exception
    //   114	122	314	java/lang/Exception
    //   125	163	314	java/lang/Exception
    //   163	186	314	java/lang/Exception
    //   186	209	314	java/lang/Exception
    //   209	232	314	java/lang/Exception
    //   232	255	314	java/lang/Exception
    //   260	267	314	java/lang/Exception
    //   270	276	314	java/lang/Exception
    //   276	283	314	java/lang/Exception
    //   292	297	314	java/lang/Exception
  }
  
  public boolean saveTroopMemberCardInfo(AppRuntime paramAppRuntime, TroopMemberCardInfo paramTroopMemberCardInfo)
  {
    paramAppRuntime = paramAppRuntime.getEntityManagerFactory().createEntityManager();
    int i = paramTroopMemberCardInfo.getStatus();
    boolean bool = false;
    if (i == 1000)
    {
      paramAppRuntime.persistOrReplace(paramTroopMemberCardInfo);
      if (paramTroopMemberCardInfo.getStatus() == 1001) {
        bool = true;
      }
      return bool;
    }
    if ((paramTroopMemberCardInfo.getStatus() != 1001) && (paramTroopMemberCardInfo.getStatus() != 1002)) {
      return false;
    }
    return paramAppRuntime.update(paramTroopMemberCardInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.util.api.impl.TroopDBUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */