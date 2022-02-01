package com.tencent.mobileqq.troop.util.api.impl;

import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import mqq.app.AppRuntime;

public class TroopDBUtilsApiImpl
  implements ITroopDBUtilsApi
{
  public TroopMemberCardInfo getTroopMemberCardInfo(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramAppRuntime = paramAppRuntime.getEntityManagerFactory().createEntityManager();
    try
    {
      paramString1 = (TroopMemberCardInfo)paramAppRuntime.find(TroopMemberCardInfo.class, new String[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    finally
    {
      paramAppRuntime.close();
    }
  }
  
  public TroopMemberInfo getTroopMemberInfo(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramAppRuntime = paramAppRuntime.getEntityManagerFactory().createEntityManager();
    try
    {
      paramString1 = (TroopMemberInfo)paramAppRuntime.find(TroopMemberInfo.class, new String[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    finally
    {
      paramAppRuntime.close();
    }
  }
  
  /* Error */
  public java.util.ArrayList<TroopMemberCardInfo> modifyTroopMemberCardInfo(AppRuntime paramAppRuntime, String paramString, java.util.ArrayList<friendlist.stUinInfo> paramArrayList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +14 -> 15
    //   4: aload_3
    //   5: ifnull +10 -> 15
    //   8: aload_3
    //   9: invokevirtual 55	java/util/ArrayList:size	()I
    //   12: ifne +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: new 51	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 56	java/util/ArrayList:<init>	()V
    //   24: astore 8
    //   26: aload_1
    //   27: invokevirtual 21	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   30: invokevirtual 27	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   33: astore 6
    //   35: aload 6
    //   37: invokevirtual 60	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: astore 7
    //   42: aload 7
    //   44: invokevirtual 65	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   47: iconst_0
    //   48: istore 4
    //   50: iload 4
    //   52: aload_3
    //   53: invokevirtual 55	java/util/ArrayList:size	()I
    //   56: if_icmpge +249 -> 305
    //   59: aload_3
    //   60: iload 4
    //   62: invokevirtual 69	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   65: checkcast 71	friendlist/stUinInfo
    //   68: astore 9
    //   70: aload 6
    //   72: ldc 29
    //   74: iconst_2
    //   75: anewarray 31	java/lang/String
    //   78: dup
    //   79: iconst_0
    //   80: aload_2
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: aload 9
    //   86: getfield 75	friendlist/stUinInfo:dwuin	J
    //   89: invokestatic 79	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   92: aastore
    //   93: invokevirtual 37	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   96: checkcast 29	com/tencent/mobileqq/data/troop/TroopMemberCardInfo
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +164 -> 265
    //   104: iconst_1
    //   105: istore 5
    //   107: aload_1
    //   108: aload 9
    //   110: getfield 75	friendlist/stUinInfo:dwuin	J
    //   113: invokestatic 79	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   116: putfield 83	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:memberuin	Ljava/lang/String;
    //   119: aload_1
    //   120: aload_2
    //   121: putfield 86	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:troopuin	Ljava/lang/String;
    //   124: aload 9
    //   126: getfield 89	friendlist/stUinInfo:dwFlag	J
    //   129: lconst_1
    //   130: land
    //   131: lconst_0
    //   132: lcmp
    //   133: ifeq +12 -> 145
    //   136: aload_1
    //   137: aload 9
    //   139: getfield 92	friendlist/stUinInfo:sName	Ljava/lang/String;
    //   142: putfield 95	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:name	Ljava/lang/String;
    //   145: aload 9
    //   147: getfield 89	friendlist/stUinInfo:dwFlag	J
    //   150: ldc2_w 96
    //   153: land
    //   154: lconst_0
    //   155: lcmp
    //   156: ifeq +12 -> 168
    //   159: aload_1
    //   160: aload 9
    //   162: getfield 101	friendlist/stUinInfo:cGender	B
    //   165: putfield 104	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:sex	B
    //   168: aload 9
    //   170: getfield 89	friendlist/stUinInfo:dwFlag	J
    //   173: ldc2_w 105
    //   176: land
    //   177: lconst_0
    //   178: lcmp
    //   179: ifeq +12 -> 191
    //   182: aload_1
    //   183: aload 9
    //   185: getfield 109	friendlist/stUinInfo:sPhone	Ljava/lang/String;
    //   188: putfield 112	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:tel	Ljava/lang/String;
    //   191: aload 9
    //   193: getfield 89	friendlist/stUinInfo:dwFlag	J
    //   196: ldc2_w 113
    //   199: land
    //   200: lconst_0
    //   201: lcmp
    //   202: ifeq +12 -> 214
    //   205: aload_1
    //   206: aload 9
    //   208: getfield 117	friendlist/stUinInfo:sEmail	Ljava/lang/String;
    //   211: putfield 120	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:email	Ljava/lang/String;
    //   214: aload 9
    //   216: getfield 89	friendlist/stUinInfo:dwFlag	J
    //   219: ldc2_w 121
    //   222: land
    //   223: lconst_0
    //   224: lcmp
    //   225: ifeq +12 -> 237
    //   228: aload_1
    //   229: aload 9
    //   231: getfield 125	friendlist/stUinInfo:sRemark	Ljava/lang/String;
    //   234: putfield 128	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:memo	Ljava/lang/String;
    //   237: iload 5
    //   239: ifeq +40 -> 279
    //   242: aload 6
    //   244: aload_1
    //   245: invokevirtual 132	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   248: pop
    //   249: aload 8
    //   251: aload_1
    //   252: invokevirtual 136	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   255: pop
    //   256: iload 4
    //   258: iconst_1
    //   259: iadd
    //   260: istore 4
    //   262: goto -212 -> 50
    //   265: new 29	com/tencent/mobileqq/data/troop/TroopMemberCardInfo
    //   268: dup
    //   269: invokespecial 137	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:<init>	()V
    //   272: astore_1
    //   273: iconst_0
    //   274: istore 5
    //   276: goto -169 -> 107
    //   279: aload 6
    //   281: aload_1
    //   282: invokevirtual 141	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   285: goto -36 -> 249
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 43	java/lang/Exception:printStackTrace	()V
    //   293: aload 7
    //   295: invokevirtual 144	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   298: aload 6
    //   300: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   303: aconst_null
    //   304: areturn
    //   305: aload 7
    //   307: invokevirtual 147	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   310: aload 7
    //   312: invokevirtual 144	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   315: aload 6
    //   317: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   320: aload 8
    //   322: areturn
    //   323: astore_1
    //   324: aload 7
    //   326: invokevirtual 144	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   329: aload 6
    //   331: invokevirtual 40	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   334: aload_1
    //   335: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	TroopDBUtilsApiImpl
    //   0	336	1	paramAppRuntime	AppRuntime
    //   0	336	2	paramString	String
    //   0	336	3	paramArrayList	java.util.ArrayList<friendlist.stUinInfo>
    //   48	213	4	i	int
    //   105	170	5	j	int
    //   33	297	6	localEntityManager	EntityManager
    //   40	285	7	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   24	297	8	localArrayList	java.util.ArrayList
    //   68	162	9	localstUinInfo	friendlist.stUinInfo
    // Exception table:
    //   from	to	target	type
    //   42	47	288	java/lang/Exception
    //   50	100	288	java/lang/Exception
    //   107	145	288	java/lang/Exception
    //   145	168	288	java/lang/Exception
    //   168	191	288	java/lang/Exception
    //   191	214	288	java/lang/Exception
    //   214	237	288	java/lang/Exception
    //   242	249	288	java/lang/Exception
    //   249	256	288	java/lang/Exception
    //   265	273	288	java/lang/Exception
    //   279	285	288	java/lang/Exception
    //   305	310	288	java/lang/Exception
    //   42	47	323	finally
    //   50	100	323	finally
    //   107	145	323	finally
    //   145	168	323	finally
    //   168	191	323	finally
    //   191	214	323	finally
    //   214	237	323	finally
    //   242	249	323	finally
    //   249	256	323	finally
    //   265	273	323	finally
    //   279	285	323	finally
    //   289	293	323	finally
    //   305	310	323	finally
  }
  
  public boolean saveTroopMemberCardInfo(AppRuntime paramAppRuntime, TroopMemberCardInfo paramTroopMemberCardInfo)
  {
    boolean bool = false;
    paramAppRuntime = paramAppRuntime.getEntityManagerFactory().createEntityManager();
    if (paramTroopMemberCardInfo.getStatus() == 1000)
    {
      paramAppRuntime.persistOrReplace(paramTroopMemberCardInfo);
      if (paramTroopMemberCardInfo.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramTroopMemberCardInfo.getStatus() != 1001) && (paramTroopMemberCardInfo.getStatus() != 1002)) {
      return bool;
    }
    return paramAppRuntime.update(paramTroopMemberCardInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.util.api.impl.TroopDBUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */