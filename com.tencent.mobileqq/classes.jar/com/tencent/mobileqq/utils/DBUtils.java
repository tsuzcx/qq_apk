package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class DBUtils
{
  public static DBUtils a()
  {
    return DBUtils.DBUtilsHolder.a;
  }
  
  public int a(Context paramContext)
  {
    int i = paramContext.getSharedPreferences("subaccount_sp", 0).getInt("subaccount_sp_version", 0);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getSubAccountVersion() ver=");
      paramContext.append(i);
      QLog.d("SUB_ACCOUNT", 2, paramContext.toString());
    }
    return i;
  }
  
  public void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("subaccount_show_in_recentlist_first");
    paramString = localStringBuilder.toString();
    paramContext.getSharedPreferences("subaccount_sp", 0).edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      Object localObject = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
      if (localObject == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stick2top_");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      paramInt += 1;
      ((SharedPreferences)localObject).edit().putInt(paramString, paramInt).commit();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("set ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("=");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("DBUtils", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    if (localObject == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("bindQQAgain");
    paramString = localStringBuilder.toString();
    ((SharedPreferences)localObject).edit().putBoolean(paramString, paramBoolean).commit();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setShownAgainBindDialog() ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("DBUtils", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    if (localObject == null) {
      return;
    }
    ((SharedPreferences)localObject).edit().putBoolean("hasShowBindDialog", paramBoolean).commit();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setHasShowBindDialog:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    boolean bool1 = false;
    if (paramString == null) {
      return false;
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(paramString, 0);
    paramContext = paramContext.getSharedPreferences("subaccount_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("subaccount_show_in_recentlist_first");
    paramString = localStringBuilder.toString();
    if (localSharedPreferences.getBoolean(paramString, false))
    {
      localSharedPreferences.edit().remove(paramString).commit();
      paramContext.edit().putBoolean(paramString, true).commit();
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() update showedBefore:=true");
      }
    }
    if (localSharedPreferences.getBoolean("subaccount_is_top_in_recentlist", false))
    {
      boolean bool2 = localSharedPreferences.getBoolean("subaccount_is_top_in_recentlist", false);
      localSharedPreferences.edit().remove("subaccount_is_top_in_recentlist").commit();
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("subAccountOldVersionUpdate() remove isTopRU=");
        paramContext.append(bool2);
        QLog.d("SUB_ACCOUNT", 2, paramContext.toString());
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("subAccountOldVersionUpdate() isTop=");
      paramContext.append(bool1);
      QLog.d("SUB_ACCOUNT", 2, paramContext.toString());
    }
    return bool1;
  }
  
  public boolean a(String paramString)
  {
    if (((paramString == null) || (paramString.length() < 5)) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shownBindQQAgain() return.FALSE: mainUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    if (localObject == null) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("bindQQAgain");
    paramString = localStringBuilder.toString();
    boolean bool = ((SharedPreferences)localObject).getBoolean(paramString, false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shownBindQQAgain() ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(bool);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  /* Error */
  public Object[] a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, String paramString, java.util.ArrayList<friendlist.stTroopRemarkInfo> paramArrayList)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 4	java/lang/Object
    //   4: astore 8
    //   6: iconst_0
    //   7: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   10: astore 6
    //   12: aload 8
    //   14: iconst_0
    //   15: aconst_null
    //   16: aastore
    //   17: aload 8
    //   19: iconst_1
    //   20: aload 6
    //   22: aastore
    //   23: aload_3
    //   24: ifnonnull +6 -> 30
    //   27: aload 8
    //   29: areturn
    //   30: aload_1
    //   31: invokevirtual 157	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   34: invokevirtual 163	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   37: astore 9
    //   39: aload 9
    //   41: invokevirtual 169	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   44: astore 10
    //   46: aload 10
    //   48: invokevirtual 174	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   51: new 176	java/util/ArrayList
    //   54: dup
    //   55: invokespecial 177	java/util/ArrayList:<init>	()V
    //   58: astore 11
    //   60: aload 8
    //   62: iconst_0
    //   63: aload 11
    //   65: aastore
    //   66: iconst_0
    //   67: istore 4
    //   69: iload 4
    //   71: aload_3
    //   72: invokevirtual 180	java/util/ArrayList:size	()I
    //   75: if_icmpge +538 -> 613
    //   78: aload_3
    //   79: iload 4
    //   81: invokevirtual 184	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   84: checkcast 186	friendlist/stTroopRemarkInfo
    //   87: astore 12
    //   89: aload 9
    //   91: ldc 188
    //   93: iconst_2
    //   94: anewarray 82	java/lang/String
    //   97: dup
    //   98: iconst_0
    //   99: aload_2
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: aload 12
    //   105: getfield 192	friendlist/stTroopRemarkInfo:MemberUin	J
    //   108: invokestatic 195	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   111: aastore
    //   112: invokevirtual 199	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   115: checkcast 188	com/tencent/mobileqq/data/troop/TroopMemberCardInfo
    //   118: astore 7
    //   120: aload 7
    //   122: ifnull +9 -> 131
    //   125: iconst_1
    //   126: istore 5
    //   128: goto +15 -> 143
    //   131: new 188	com/tencent/mobileqq/data/troop/TroopMemberCardInfo
    //   134: dup
    //   135: invokespecial 200	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:<init>	()V
    //   138: astore 7
    //   140: iconst_0
    //   141: istore 5
    //   143: aload 7
    //   145: aload 12
    //   147: getfield 204	friendlist/stTroopRemarkInfo:sEmail	Ljava/lang/String;
    //   150: putfield 207	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:email	Ljava/lang/String;
    //   153: aload 7
    //   155: aload 12
    //   157: getfield 192	friendlist/stTroopRemarkInfo:MemberUin	J
    //   160: invokestatic 195	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   163: putfield 210	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:memberuin	Ljava/lang/String;
    //   166: aload 7
    //   168: aload 12
    //   170: getfield 213	friendlist/stTroopRemarkInfo:sMemo	Ljava/lang/String;
    //   173: putfield 216	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:memo	Ljava/lang/String;
    //   176: aload 7
    //   178: aload 12
    //   180: getfield 219	friendlist/stTroopRemarkInfo:sName	Ljava/lang/String;
    //   183: invokevirtual 223	java/lang/String:getBytes	()[B
    //   186: invokestatic 229	com/tencent/mobileqq/vas/ColorNickManager:b	([B)Ljava/lang/String;
    //   189: putfield 232	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:colorNick	Ljava/lang/String;
    //   192: aload 7
    //   194: getfield 232	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:colorNick	Ljava/lang/String;
    //   197: ifnonnull +13 -> 210
    //   200: aload 7
    //   202: aload 12
    //   204: getfield 219	friendlist/stTroopRemarkInfo:sName	Ljava/lang/String;
    //   207: putfield 232	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:colorNick	Ljava/lang/String;
    //   210: aload 7
    //   212: aload 7
    //   214: getfield 232	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:colorNick	Ljava/lang/String;
    //   217: invokestatic 235	com/tencent/mobileqq/vas/ColorNickManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   220: putfield 238	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:name	Ljava/lang/String;
    //   223: aload 7
    //   225: aload 12
    //   227: getfield 241	friendlist/stTroopRemarkInfo:strNick	Ljava/lang/String;
    //   230: putfield 244	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:nick	Ljava/lang/String;
    //   233: aload 7
    //   235: aload 12
    //   237: getfield 248	friendlist/stTroopRemarkInfo:cGender	B
    //   240: putfield 251	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:sex	B
    //   243: aload 7
    //   245: aload 12
    //   247: getfield 254	friendlist/stTroopRemarkInfo:sPhone	Ljava/lang/String;
    //   250: putfield 257	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:tel	Ljava/lang/String;
    //   253: aload 7
    //   255: aload_2
    //   256: putfield 260	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:troopuin	Ljava/lang/String;
    //   259: aload 7
    //   261: aload 12
    //   263: getfield 263	friendlist/stTroopRemarkInfo:strRank	Ljava/lang/String;
    //   266: putfield 266	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:level	Ljava/lang/String;
    //   269: aload 7
    //   271: aload 12
    //   273: getfield 269	friendlist/stTroopRemarkInfo:bytes_job	Ljava/lang/String;
    //   276: putfield 272	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:job	Ljava/lang/String;
    //   279: aload 7
    //   281: aload 12
    //   283: getfield 275	friendlist/stTroopRemarkInfo:GlamourLevel	J
    //   286: l2i
    //   287: putfield 279	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:charm	I
    //   290: aload 7
    //   292: aload 12
    //   294: getfield 282	friendlist/stTroopRemarkInfo:TorchbearerFlag	J
    //   297: l2i
    //   298: putfield 285	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:torchFlag	I
    //   301: iload 5
    //   303: ifeq +14 -> 317
    //   306: aload 9
    //   308: aload 7
    //   310: invokevirtual 289	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   313: pop
    //   314: goto +10 -> 324
    //   317: aload 9
    //   319: aload 7
    //   321: invokevirtual 293	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   324: aload 11
    //   326: aload 7
    //   328: invokevirtual 297	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   331: pop
    //   332: aload 12
    //   334: getfield 301	friendlist/stTroopRemarkInfo:vecGroupHonor	[B
    //   337: invokestatic 306	com/tencent/mobileqq/troop/troopMemberLevel/TroopMemberLevelUtils:a	([B)I
    //   340: istore 5
    //   342: aload 9
    //   344: ldc_w 308
    //   347: iconst_2
    //   348: anewarray 82	java/lang/String
    //   351: dup
    //   352: iconst_0
    //   353: aload_2
    //   354: aastore
    //   355: dup
    //   356: iconst_1
    //   357: aload 12
    //   359: getfield 192	friendlist/stTroopRemarkInfo:MemberUin	J
    //   362: invokestatic 195	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   365: aastore
    //   366: invokevirtual 199	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   369: checkcast 308	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   372: astore 13
    //   374: aload 13
    //   376: ifnull +367 -> 743
    //   379: aload 13
    //   381: aload 7
    //   383: getfield 232	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:colorNick	Ljava/lang/String;
    //   386: putfield 311	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopColorNick	Ljava/lang/String;
    //   389: aload 13
    //   391: aload 7
    //   393: getfield 238	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:name	Ljava/lang/String;
    //   396: putfield 314	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   399: aload 13
    //   401: aload 12
    //   403: getfield 241	friendlist/stTroopRemarkInfo:strNick	Ljava/lang/String;
    //   406: putfield 317	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   409: aload 13
    //   411: aload 12
    //   413: getfield 192	friendlist/stTroopRemarkInfo:MemberUin	J
    //   416: invokestatic 195	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   419: putfield 318	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   422: aload 13
    //   424: aload 12
    //   426: getfield 248	friendlist/stTroopRemarkInfo:cGender	B
    //   429: putfield 319	com/tencent/mobileqq/data/troop/TroopMemberInfo:sex	B
    //   432: aload 13
    //   434: aload_2
    //   435: putfield 320	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopuin	Ljava/lang/String;
    //   438: aload 13
    //   440: aload 12
    //   442: getfield 275	friendlist/stTroopRemarkInfo:GlamourLevel	J
    //   445: l2i
    //   446: putfield 323	com/tencent/mobileqq/data/troop/TroopMemberInfo:mGlamourLevel	I
    //   449: aload 13
    //   451: aload 7
    //   453: getfield 326	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:mVipType	I
    //   456: putfield 327	com/tencent/mobileqq/data/troop/TroopMemberInfo:mVipType	I
    //   459: aload 13
    //   461: aload 7
    //   463: getfield 330	com/tencent/mobileqq/data/troop/TroopMemberCardInfo:mVipLevel	I
    //   466: putfield 331	com/tencent/mobileqq/data/troop/TroopMemberInfo:mVipLevel	I
    //   469: aload 13
    //   471: iload 5
    //   473: putfield 334	com/tencent/mobileqq/data/troop/TroopMemberInfo:newRealLevel	I
    //   476: aload 12
    //   478: getfield 263	friendlist/stTroopRemarkInfo:strRank	Ljava/lang/String;
    //   481: ifnull +259 -> 740
    //   484: aload 12
    //   486: getfield 263	friendlist/stTroopRemarkInfo:strRank	Ljava/lang/String;
    //   489: invokevirtual 86	java/lang/String:length	()I
    //   492: ifle +248 -> 740
    //   495: aload_1
    //   496: getstatic 339	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   499: invokevirtual 343	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   502: checkcast 345	com/tencent/mobileqq/app/TroopManager
    //   505: astore 7
    //   507: aload 7
    //   509: ifnull +93 -> 602
    //   512: aload 7
    //   514: aload_2
    //   515: invokevirtual 349	com/tencent/mobileqq/app/TroopManager:f	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   518: astore 7
    //   520: aload 7
    //   522: ifnull +80 -> 602
    //   525: aload 7
    //   527: invokevirtual 355	com/tencent/mobileqq/data/troop/TroopInfo:getTroopLevelMap	()Ljava/util/concurrent/ConcurrentHashMap;
    //   530: astore 7
    //   532: aload 7
    //   534: ifnull +68 -> 602
    //   537: aload 7
    //   539: invokevirtual 361	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   542: invokeinterface 367 1 0
    //   547: astore 14
    //   549: aload 14
    //   551: invokeinterface 372 1 0
    //   556: ifeq +46 -> 602
    //   559: aload 14
    //   561: invokeinterface 376 1 0
    //   566: checkcast 378	java/lang/Integer
    //   569: astore 15
    //   571: aload 12
    //   573: getfield 263	friendlist/stTroopRemarkInfo:strRank	Ljava/lang/String;
    //   576: aload 7
    //   578: aload 15
    //   580: invokevirtual 381	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   583: invokevirtual 384	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   586: ifeq +151 -> 737
    //   589: aload 13
    //   591: aload 15
    //   593: invokevirtual 387	java/lang/Integer:intValue	()I
    //   596: putfield 390	com/tencent/mobileqq/data/troop/TroopMemberInfo:realLevel	I
    //   599: goto +3 -> 602
    //   602: aload 9
    //   604: aload 13
    //   606: invokevirtual 289	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   609: pop
    //   610: goto +133 -> 743
    //   613: aload 8
    //   615: iconst_1
    //   616: iconst_1
    //   617: invokestatic 151	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   620: aastore
    //   621: aload 10
    //   623: invokevirtual 392	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   626: aload 10
    //   628: invokevirtual 395	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   631: aload 9
    //   633: invokevirtual 398	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   636: goto +38 -> 674
    //   639: astore_1
    //   640: goto +8 -> 648
    //   643: astore_1
    //   644: goto +75 -> 719
    //   647: astore_1
    //   648: aload 8
    //   650: iconst_1
    //   651: aload 6
    //   653: aastore
    //   654: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   657: ifeq -31 -> 626
    //   660: ldc_w 400
    //   663: iconst_2
    //   664: aload_1
    //   665: invokevirtual 401	java/lang/Exception:toString	()Ljava/lang/String;
    //   668: invokestatic 404	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   671: goto -45 -> 626
    //   674: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   677: ifeq +39 -> 716
    //   680: new 43	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   687: astore_1
    //   688: aload_1
    //   689: ldc_w 406
    //   692: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: aload_1
    //   697: aload 8
    //   699: iconst_1
    //   700: aaload
    //   701: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: ldc_w 411
    //   708: iconst_2
    //   709: aload_1
    //   710: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   713: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   716: aload 8
    //   718: areturn
    //   719: aload 10
    //   721: invokevirtual 395	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   724: aload 9
    //   726: invokevirtual 398	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   729: goto +5 -> 734
    //   732: aload_1
    //   733: athrow
    //   734: goto -2 -> 732
    //   737: goto -188 -> 549
    //   740: goto -138 -> 602
    //   743: iload 4
    //   745: iconst_1
    //   746: iadd
    //   747: istore 4
    //   749: goto -680 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	752	0	this	DBUtils
    //   0	752	1	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	752	2	paramString	String
    //   0	752	3	paramArrayList	java.util.ArrayList<friendlist.stTroopRemarkInfo>
    //   67	681	4	i	int
    //   126	346	5	j	int
    //   10	642	6	localBoolean	java.lang.Boolean
    //   118	459	7	localObject	Object
    //   4	713	8	arrayOfObject	Object[]
    //   37	688	9	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   44	676	10	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   58	267	11	localArrayList	java.util.ArrayList
    //   87	485	12	localstTroopRemarkInfo	friendlist.stTroopRemarkInfo
    //   372	233	13	localTroopMemberInfo	com.tencent.mobileqq.data.troop.TroopMemberInfo
    //   547	13	14	localIterator	java.util.Iterator
    //   569	23	15	localInteger	java.lang.Integer
    // Exception table:
    //   from	to	target	type
    //   342	374	639	java/lang/Exception
    //   379	507	639	java/lang/Exception
    //   512	520	639	java/lang/Exception
    //   525	532	639	java/lang/Exception
    //   537	549	639	java/lang/Exception
    //   549	599	639	java/lang/Exception
    //   602	610	639	java/lang/Exception
    //   613	626	639	java/lang/Exception
    //   69	120	643	finally
    //   131	140	643	finally
    //   143	210	643	finally
    //   210	301	643	finally
    //   306	314	643	finally
    //   317	324	643	finally
    //   324	342	643	finally
    //   342	374	643	finally
    //   379	507	643	finally
    //   512	520	643	finally
    //   525	532	643	finally
    //   537	549	643	finally
    //   549	599	643	finally
    //   602	610	643	finally
    //   613	626	643	finally
    //   654	671	643	finally
    //   69	120	647	java/lang/Exception
    //   131	140	647	java/lang/Exception
    //   143	210	647	java/lang/Exception
    //   210	301	647	java/lang/Exception
    //   306	314	647	java/lang/Exception
    //   317	324	647	java/lang/Exception
    //   324	342	647	java/lang/Exception
  }
  
  public int b(String paramString)
  {
    int i = 0;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return 0;
      }
      Object localObject = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
      if (localObject == null) {
        return 0;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stick2top_");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      int j = ((SharedPreferences)localObject).getInt(paramString, 0);
      i = j;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(j);
        QLog.d("DBUtils", 2, ((StringBuilder)localObject).toString());
        i = j;
      }
    }
    return i;
  }
  
  public boolean b()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    if (localObject == null) {
      return true;
    }
    boolean bool = ((SharedPreferences)localObject).getBoolean("hasShowBindDialog", false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hasShowBindDialog:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean b(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("subaccount_show_in_recentlist_first");
    paramString = localStringBuilder.toString();
    return paramContext.getSharedPreferences("subaccount_sp", 0).getBoolean(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DBUtils
 * JD-Core Version:    0.7.0.1
 */