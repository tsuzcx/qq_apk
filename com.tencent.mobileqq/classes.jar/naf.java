import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class naf
  implements Cloneable
{
  public volatile int a;
  @NotNull
  private RoomInfo jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo = new RoomInfo();
  public String a;
  public List<mzq> a;
  @NotNull
  public CopyOnWriteArrayList<nak> a;
  @NotNull
  private nag jdField_a_of_type_Nag = new nag();
  public String b;
  @NotNull
  private CopyOnWriteArrayList<nal> b;
  
  public naf()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    a();
  }
  
  private void c()
  {
    a(this.jdField_a_of_type_Nag.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
    a(this.jdField_a_of_type_Nag.b);
    a(this.jdField_a_of_type_Nag.c);
    a(this.jdField_a_of_type_Nag.d);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Nag.c();
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_Nag.a(paramString);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.id;
  }
  
  public GameRecordInfo a()
  {
    try
    {
      if (this.jdField_a_of_type_Nag.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.gameType == 0) {
        this.jdField_a_of_type_Nag.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.gameType = c();
      }
      GameRecordInfo localGameRecordInfo = this.jdField_a_of_type_Nag.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo;
      return localGameRecordInfo;
    }
    finally {}
  }
  
  public Player a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.getPlayer(str);
  }
  
  @NotNull
  public RoomInfo a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo;
  }
  
  public RoomInfo a(RoomInfo paramRoomInfo, boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.copyFrom(paramRoomInfo);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Nag.a();
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      paramRoomInfo = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo;
      return paramRoomInfo;
    }
    finally {}
  }
  
  public String a()
  {
    if (c() == 3) {
      return BaseApplicationImpl.getApplication().getApplicationContext().getString(2131690412);
    }
    int i = d();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      nak localnak = (nak)localIterator.next();
      if ((localnak != null) && (localnak.jdField_a_of_type_Int == i)) {
        return localnak.jdField_a_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  public List<mzq> a()
  {
    try
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public mzq a()
  {
    try
    {
      mzq localmzq = this.jdField_a_of_type_Nag.a();
      return localmzq;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public naf a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 2	naf
    //   5: dup
    //   6: invokespecial 161	naf:<init>	()V
    //   9: astore_1
    //   10: aload_1
    //   11: getfield 39	naf:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   14: aload_0
    //   15: getfield 39	naf:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   18: invokevirtual 110	com/tencent/avgame/gamelogic/data/RoomInfo:copyFrom	(Lcom/tencent/avgame/gamelogic/data/RoomInfo;)V
    //   21: aload_1
    //   22: getfield 44	naf:jdField_a_of_type_Nag	Lnag;
    //   25: aload_0
    //   26: getfield 44	naf:jdField_a_of_type_Nag	Lnag;
    //   29: invokevirtual 164	nag:a	(Lnag;)V
    //   32: aload_1
    //   33: getfield 27	naf:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   36: aload_0
    //   37: getfield 27	naf:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   40: invokevirtual 168	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   43: pop
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 169	naf:jdField_a_of_type_Int	I
    //   49: putfield 169	naf:jdField_a_of_type_Int	I
    //   52: aload_1
    //   53: getfield 32	naf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   56: aload_0
    //   57: getfield 32	naf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   60: invokeinterface 170 2 0
    //   65: pop
    //   66: aload_1
    //   67: getfield 34	naf:jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   70: aload_0
    //   71: getfield 34	naf:jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   74: invokevirtual 168	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   77: pop
    //   78: aload_1
    //   79: aload_0
    //   80: getfield 171	naf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   83: putfield 171	naf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: aload_1
    //   87: aload_0
    //   88: getfield 173	naf:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   91: putfield 173	naf:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: areturn
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    //   103: astore_2
    //   104: goto -10 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	naf
    //   9	88	1	localnaf	naf
    //   98	4	1	localObject	Object
    //   103	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	10	98	finally
    //   10	94	98	finally
    //   10	94	103	java/lang/Exception
  }
  
  @NotNull
  public nag a()
  {
    return this.jdField_a_of_type_Nag;
  }
  
  public nag a(nag paramnag)
  {
    try
    {
      this.jdField_a_of_type_Nag.b(paramnag);
      paramnag = this.jdField_a_of_type_Nag;
      return paramnag;
    }
    finally
    {
      paramnag = finally;
      throw paramnag;
    }
  }
  
  public nak a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > this.jdField_a_of_type_Int)) {
      return (nak)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(this.jdField_a_of_type_Int);
    }
    return null;
  }
  
  public nal a(int paramInt)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (localIterator.hasNext())
        {
          nal localnal = (nal)localIterator.next();
          int i = localnal.jdField_a_of_type_Int;
          if (i != paramInt) {
            continue;
          }
          return localnal;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.reset();
    this.jdField_a_of_type_Nag.a();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        int j = this.jdField_a_of_type_Int;
        int i = 0;
        if (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
        {
          if (paramInt == ((nak)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).jdField_a_of_type_Int)
          {
            this.jdField_a_of_type_Int = i;
            return;
          }
          i += 1;
        }
        else
        {
          i = j;
        }
      }
      finally {}
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.id == paramLong)) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.matchStatus = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(Player paramPlayer)
  {
    if ((paramPlayer == null) || (TextUtils.isEmpty(paramPlayer.uin))) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.players.iterator();
      while (localIterator.hasNext())
      {
        Player localPlayer = (Player)localIterator.next();
        if (paramPlayer.isSame(localPlayer)) {
          paramPlayer.nick = localPlayer.nick;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Nag.a(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      this.jdField_a_of_type_Nag.a(paramString1, paramString2, paramLong);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(List<nak> paramList, int paramInt)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        if (paramList == null) {
          return;
        }
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          nak localnak = (nak)paramList.next();
          if (!mzo.d(mzo.a(localnak.jdField_a_of_type_Int))) {
            continue;
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localnak);
          continue;
        }
        b();
      }
      finally {}
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void a(List<nal> paramList, String paramString1, String paramString2)
  {
    if ((paramList == null) || (paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      return;
      try
      {
        this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          nal localnal = (nal)paramList.next();
          this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localnal);
        }
        this.jdField_a_of_type_JavaLangString = paramString1;
      }
      finally {}
      this.jdField_b_of_type_JavaLangString = paramString2;
    }
  }
  
  public void a(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() <= 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.updateNicks(paramMap);
    c();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.id != 0L) && (!TextUtils.isEmpty(this.jdField_a_of_type_Nag.a()));
  }
  
  public boolean a(Player paramPlayer)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Nag.a(paramPlayer);
      if (bool) {
        a(this.jdField_a_of_type_Nag.c);
      }
      return bool;
    }
    finally {}
  }
  
  public boolean a(Player paramPlayer, mzq parammzq)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Nag.a(paramPlayer, parammzq);
      if (bool) {
        a(this.jdField_a_of_type_Nag.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
      }
      return bool;
    }
    finally {}
  }
  
  public boolean a(String paramString)
  {
    if ((!c()) || (TextUtils.isEmpty(paramString))) {}
    while ((this.jdField_a_of_type_Nag.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null) || (!paramString.equalsIgnoreCase(this.jdField_a_of_type_Nag.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin))) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public boolean a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: istore 4
    //   10: iload 4
    //   12: ifeq +9 -> 21
    //   15: iconst_0
    //   16: istore_3
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_3
    //   20: ireturn
    //   21: aload_1
    //   22: invokestatic 89	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   25: invokevirtual 93	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   28: invokevirtual 99	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   31: invokevirtual 269	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   34: ifeq +15 -> 49
    //   37: iload_2
    //   38: iconst_1
    //   39: if_icmpne +10 -> 49
    //   42: aload_0
    //   43: getfield 44	naf:jdField_a_of_type_Nag	Lnag;
    //   46: invokevirtual 271	nag:c	()V
    //   49: aload_0
    //   50: getfield 39	naf:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   53: aload_1
    //   54: iload_2
    //   55: invokevirtual 275	com/tencent/avgame/gamelogic/data/RoomInfo:onChangeUserStatus	(Ljava/lang/String;I)V
    //   58: goto -41 -> 17
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	naf
    //   0	66	1	paramString	String
    //   0	66	2	paramInt	int
    //   1	19	3	bool1	boolean
    //   8	3	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	10	61	finally
    //   21	37	61	finally
    //   42	49	61	finally
    //   49	58	61	finally
  }
  
  public boolean a(List<UserScore> paramList)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Nag.a(paramList);
      return bool;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public boolean a(mzq parammzq)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Nag.a(parammzq);
      return bool;
    }
    finally
    {
      parammzq = finally;
      throw parammzq;
    }
  }
  
  public boolean a(mzq parammzq, int paramInt1, Player paramPlayer, long paramLong, int paramInt2)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Nag.a(parammzq, paramInt1, paramPlayer, paramLong, paramInt2);
      if (bool) {
        a(this.jdField_a_of_type_Nag.d);
      }
      return bool;
    }
    finally {}
  }
  
  public boolean a(nag paramnag)
  {
    try
    {
      this.jdField_a_of_type_Nag.a(paramnag);
      this.jdField_a_of_type_Nag.b();
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.onGameStart();
      this.jdField_a_of_type_JavaUtilList.clear();
      c();
      return true;
    }
    finally
    {
      paramnag = finally;
      throw paramnag;
    }
  }
  
  /* Error */
  public boolean a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: iload 4
    //   7: istore_3
    //   8: aload_0
    //   9: getfield 39	naf:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   12: ifnull +37 -> 49
    //   15: iload_1
    //   16: ifeq +37 -> 53
    //   19: iload 4
    //   21: istore_3
    //   22: aload_0
    //   23: getfield 39	naf:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   26: invokevirtual 294	com/tencent/avgame/gamelogic/data/RoomInfo:isRoomMatching	()Z
    //   29: ifeq +20 -> 49
    //   32: aload_0
    //   33: getfield 39	naf:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   36: getfield 297	com/tencent/avgame/gamelogic/data/RoomInfo:matchShareId	I
    //   39: istore_2
    //   40: iload 4
    //   42: istore_3
    //   43: iload_2
    //   44: ifle +5 -> 49
    //   47: iconst_1
    //   48: istore_3
    //   49: aload_0
    //   50: monitorexit
    //   51: iload_3
    //   52: ireturn
    //   53: aload_0
    //   54: getfield 39	naf:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   57: invokevirtual 294	com/tencent/avgame/gamelogic/data/RoomInfo:isRoomMatching	()Z
    //   60: istore_3
    //   61: goto -12 -> 49
    //   64: astore 5
    //   66: aload_0
    //   67: monitorexit
    //   68: aload 5
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	naf
    //   0	71	1	paramBoolean	boolean
    //   39	5	2	i	int
    //   7	54	3	bool1	boolean
    //   1	40	4	bool2	boolean
    //   64	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	15	64	finally
    //   22	40	64	finally
    //   53	61	64	finally
  }
  
  public int b()
  {
    Player localPlayer = a();
    if (localPlayer != null) {
      return localPlayer.status;
    }
    return 1;
  }
  
  public long b()
  {
    long l1 = 9223372036854775807L;
    int i = 0;
    for (;;)
    {
      long l2 = l1;
      if (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
      {
        nak localnak = (nak)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
        l2 = l1;
        if (!mzo.b((nak)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i))) {
          break label85;
        }
        l2 = localnak.jdField_b_of_type_Long - NetConnInfoCenter.getServerTime();
        if (l2 < 0L) {
          l2 = 0L;
        }
      }
      else
      {
        return l2;
      }
      l2 = Math.min(l1, l2);
      label85:
      i += 1;
      l1 = l2;
    }
  }
  
  public Player b()
  {
    try
    {
      Player localPlayer = this.jdField_a_of_type_Nag.a();
      return localPlayer;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String b()
  {
    return this.jdField_a_of_type_Nag.a();
  }
  
  public List<mzq> b()
  {
    a();
    int i = e();
    ArrayList localArrayList = new ArrayList();
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        nak localnak = (nak)localIterator.next();
        if (mzo.a(localnak))
        {
          if ((localnak.jdField_b_of_type_Int == 1) && (localnak.jdField_b_of_type_Long <= NetConnInfoCenter.getServerTime())) {
            localnak.jdField_b_of_type_Int = 2;
          }
          if (localnak.c <= NetConnInfoCenter.getServerTime())
          {
            int i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.indexOf(localnak);
            if (this.jdField_a_of_type_Int == i) {
              this.jdField_a_of_type_Int = 0;
            }
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localnak);
          }
        }
      }
    }
  }
  
  public void b(long paramLong, int paramInt)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.id == paramLong)) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.matchShareId = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean b()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Nag.b();
      if (bool) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.onGameOver();
      }
      return bool;
    }
    finally {}
  }
  
  public boolean b(String paramString)
  {
    if ((this.jdField_a_of_type_Nag.c() == 0) || (this.jdField_a_of_type_Nag.c() == 10)) {
      return false;
    }
    return a(paramString);
  }
  
  public boolean b(mzq parammzq)
  {
    boolean bool;
    if (parammzq == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        parammzq = parammzq.a();
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(parammzq);
        bool = true;
      }
      finally {}
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Nag.a();
  }
  
  public long c()
  {
    long l1 = 9223372036854775807L;
    int i = 0;
    for (;;)
    {
      long l2 = l1;
      if (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
      {
        nak localnak = (nak)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
        l2 = l1;
        if (!mzo.a((nak)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i))) {
          break label85;
        }
        l2 = localnak.c - NetConnInfoCenter.getServerTime();
        if (l2 < 0L) {
          l2 = 0L;
        }
      }
      else
      {
        return l2;
      }
      l2 = Math.min(l1, l2);
      label85:
      i += 1;
      l1 = l2;
    }
  }
  
  public String c()
  {
    String str = this.jdField_a_of_type_Nag.jdField_a_of_type_Naj.jdField_a_of_type_JavaLangString;
    Object localObject;
    if (str != null)
    {
      localObject = str;
      if (str.length() != 0) {}
    }
    else
    {
      localObject = a(this.jdField_a_of_type_Nag.b());
      if ((localObject == null) || (((nal)localObject).jdField_a_of_type_JavaUtilArrayList == null) || (((nal)localObject).jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label78;
      }
    }
    label78:
    for (int i = 1; i != 0; i = 0)
    {
      localObject = BaseApplicationImpl.getApplication().getApplicationContext().getString(2131690366);
      return localObject;
    }
    return null;
  }
  
  public boolean c()
  {
    return mzo.a(c());
  }
  
  public boolean c(String paramString)
  {
    if ((this.jdField_a_of_type_Nag.c() == 0) || (this.jdField_a_of_type_Nag.c() == 10)) {}
    String str;
    do
    {
      return false;
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    } while ((c() != 3) || (!TextUtils.equals(paramString, str)));
    return true;
  }
  
  public boolean c(mzq parammzq)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Nag.b(parammzq);
      return bool;
    }
    finally
    {
      parammzq = finally;
      throw parammzq;
    }
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Nag.b();
  }
  
  public long d()
  {
    return Math.min(b(), c());
  }
  
  public String d()
  {
    String str = c();
    if ((str == null) || (str.length() == 0)) {
      return null;
    }
    Object localObject = a(this.jdField_a_of_type_Nag.b());
    if (localObject != null)
    {
      Iterator localIterator = ((nal)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (nam)localIterator.next();
      } while ((((nam)localObject).jdField_a_of_type_JavaLangString == null) || (!((nam)localObject).jdField_a_of_type_JavaLangString.equals(str)));
    }
    for (;;)
    {
      if (localObject != null) {
        return ((nam)localObject).c;
      }
      return null;
      localObject = null;
    }
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo != null)
      {
        int i = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.getPlayers().size();
        bool1 = bool2;
        if (i >= 8) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean d(String paramString)
  {
    return a(paramString);
  }
  
  public boolean d(mzq parammzq)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Nag.c(parammzq);
      return bool;
    }
    finally
    {
      parammzq = finally;
      throw parammzq;
    }
  }
  
  public int e()
  {
    mzq localmzq = a();
    if ((localmzq instanceof mzr)) {
      return ((mzr)localmzq).f_();
    }
    return 0;
  }
  
  public boolean e(String paramString)
  {
    return Long.toString(this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.owner).equalsIgnoreCase(paramString);
  }
  
  public int f()
  {
    return a().jdField_a_of_type_Naj.h;
  }
  
  public int g()
  {
    int i = a().jdField_a_of_type_Naj.g;
    if (i == 0)
    {
      i = a().jdField_a_of_type_Naj.c;
      int j = a().jdField_a_of_type_Naj.e + a().jdField_a_of_type_Naj.f;
      if (j > 0) {
        return i / j;
      }
    }
    else if (i == 1)
    {
      return a().jdField_a_of_type_Naj.h;
    }
    return 0;
  }
  
  public int h()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.getUins().size();
  }
  
  public int i()
  {
    int i = 0;
    try
    {
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo != null) {
        i = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.matchShareId;
      }
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n").append("roomInfo").append("=").append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo);
    localStringBuilder.append("\n").append("game").append("=").append(this.jdField_a_of_type_Nag);
    localStringBuilder.append("\n").append("curGameIndex").append("=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n").append("gameListSize").append("=").append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    localStringBuilder.append("\n").append("topicCount").append("=").append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     naf
 * JD-Core Version:    0.7.0.1
 */