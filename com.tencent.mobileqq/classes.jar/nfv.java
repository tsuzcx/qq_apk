import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class nfv
  implements Cloneable
{
  public volatile int a;
  public volatile long a;
  @NotNull
  private RoomInfo jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo = new RoomInfo();
  public volatile SurvivalPkResultInfo a;
  public String a;
  public List<nfh> a;
  @NotNull
  public CopyOnWriteArrayList<nga> a;
  @NotNull
  private nfw jdField_a_of_type_Nfw = new nfw();
  public volatile boolean a;
  public volatile int b;
  public String b;
  public volatile List<Long> b;
  @NotNull
  private CopyOnWriteArrayList<ngb> b;
  public volatile int c;
  public volatile List<Long> c;
  public volatile int d;
  public volatile List<Long> d;
  public volatile int e;
  public volatile int f;
  public volatile int g;
  public volatile int h;
  
  public nfv()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo = new SurvivalPkResultInfo();
    a();
  }
  
  private void e()
  {
    a(this.jdField_a_of_type_Nfw.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
    a(this.jdField_a_of_type_Nfw.b);
    a(this.jdField_a_of_type_Nfw.c);
    a(this.jdField_a_of_type_Nfw.d);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Nfw.c();
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_Nfw.a(paramString);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.id;
  }
  
  public GameRecordInfo a()
  {
    try
    {
      if (this.jdField_a_of_type_Nfw.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.gameType == 0) {
        this.jdField_a_of_type_Nfw.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.gameType = c();
      }
      GameRecordInfo localGameRecordInfo = this.jdField_a_of_type_Nfw.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo;
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
        this.jdField_a_of_type_Nfw.a();
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      paramRoomInfo = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo;
      return paramRoomInfo;
    }
    finally {}
  }
  
  public SurvivalPkResultInfo a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo;
  }
  
  public String a()
  {
    if (c() == 3) {
      return BaseApplicationImpl.getApplication().getApplicationContext().getString(2131690484);
    }
    int i = d();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      nga localnga = (nga)localIterator.next();
      if ((localnga != null) && (localnga.jdField_a_of_type_Int == i)) {
        return localnga.jdField_a_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  public List<nfh> a()
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
  
  public nfh a()
  {
    try
    {
      nfh localnfh = this.jdField_a_of_type_Nfw.a();
      return localnfh;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public nfv a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 2	nfv
    //   5: dup
    //   6: invokespecial 180	nfv:<init>	()V
    //   9: astore_1
    //   10: aload_1
    //   11: getfield 60	nfv:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   14: aload_0
    //   15: getfield 60	nfv:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   18: invokevirtual 128	com/tencent/avgame/gamelogic/data/RoomInfo:copyFrom	(Lcom/tencent/avgame/gamelogic/data/RoomInfo;)V
    //   21: aload_1
    //   22: getfield 65	nfv:jdField_a_of_type_Nfw	Lnfw;
    //   25: aload_0
    //   26: getfield 65	nfv:jdField_a_of_type_Nfw	Lnfw;
    //   29: invokevirtual 183	nfw:a	(Lnfw;)V
    //   32: aload_1
    //   33: getfield 37	nfv:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   36: aload_0
    //   37: getfield 37	nfv:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   40: invokevirtual 187	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   43: pop
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 188	nfv:jdField_a_of_type_Int	I
    //   49: putfield 188	nfv:jdField_a_of_type_Int	I
    //   52: aload_1
    //   53: getfield 42	nfv:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   56: aload_0
    //   57: getfield 42	nfv:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   60: invokeinterface 189 2 0
    //   65: pop
    //   66: aload_1
    //   67: getfield 44	nfv:jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   70: aload_0
    //   71: getfield 44	nfv:jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   74: invokevirtual 187	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   77: pop
    //   78: aload_1
    //   79: aload_0
    //   80: getfield 190	nfv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   83: putfield 190	nfv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: aload_1
    //   87: aload_0
    //   88: getfield 192	nfv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   91: putfield 192	nfv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   94: aload_1
    //   95: aload_0
    //   96: getfield 194	nfv:jdField_a_of_type_Boolean	Z
    //   99: putfield 194	nfv:jdField_a_of_type_Boolean	Z
    //   102: aload_1
    //   103: aload_0
    //   104: getfield 196	nfv:jdField_b_of_type_Int	I
    //   107: putfield 196	nfv:jdField_b_of_type_Int	I
    //   110: aload_1
    //   111: aload_0
    //   112: getfield 198	nfv:jdField_c_of_type_Int	I
    //   115: putfield 198	nfv:jdField_c_of_type_Int	I
    //   118: aload_1
    //   119: aload_0
    //   120: getfield 200	nfv:e	I
    //   123: putfield 200	nfv:e	I
    //   126: aload_1
    //   127: aload_0
    //   128: getfield 202	nfv:f	I
    //   131: putfield 202	nfv:f	I
    //   134: aload_1
    //   135: aload_0
    //   136: getfield 204	nfv:jdField_a_of_type_Long	J
    //   139: putfield 204	nfv:jdField_a_of_type_Long	J
    //   142: aload_1
    //   143: aload_0
    //   144: getfield 206	nfv:h	I
    //   147: putfield 206	nfv:h	I
    //   150: aload_1
    //   151: aload_0
    //   152: getfield 208	nfv:g	I
    //   155: putfield 208	nfv:g	I
    //   158: aload_1
    //   159: getfield 46	nfv:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   162: aload_0
    //   163: getfield 46	nfv:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   166: invokeinterface 189 2 0
    //   171: pop
    //   172: aload_1
    //   173: getfield 48	nfv:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   176: aload_0
    //   177: getfield 48	nfv:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   180: invokeinterface 189 2 0
    //   185: pop
    //   186: aload_1
    //   187: getfield 50	nfv:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   190: aload_0
    //   191: getfield 50	nfv:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   194: invokeinterface 189 2 0
    //   199: pop
    //   200: aload_1
    //   201: getfield 55	nfv:jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo	Lcom/tencent/avgame/gamelogic/data/SurvivalPkResultInfo;
    //   204: aload_0
    //   205: getfield 55	nfv:jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo	Lcom/tencent/avgame/gamelogic/data/SurvivalPkResultInfo;
    //   208: invokevirtual 211	com/tencent/avgame/gamelogic/data/SurvivalPkResultInfo:copyFrom	(Lcom/tencent/avgame/gamelogic/data/SurvivalPkResultInfo;)V
    //   211: aload_0
    //   212: monitorexit
    //   213: aload_1
    //   214: areturn
    //   215: astore_1
    //   216: aload_0
    //   217: monitorexit
    //   218: aload_1
    //   219: athrow
    //   220: astore_2
    //   221: goto -10 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	nfv
    //   9	205	1	localnfv	nfv
    //   215	4	1	localObject	Object
    //   220	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	10	215	finally
    //   10	211	215	finally
    //   10	211	220	java/lang/Exception
  }
  
  @NotNull
  public nfw a()
  {
    return this.jdField_a_of_type_Nfw;
  }
  
  public nfw a(nfw paramnfw)
  {
    try
    {
      this.jdField_a_of_type_Nfw.b(paramnfw);
      paramnfw = this.jdField_a_of_type_Nfw;
      return paramnfw;
    }
    finally
    {
      paramnfw = finally;
      throw paramnfw;
    }
  }
  
  public nga a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > this.jdField_a_of_type_Int)) {
      return (nga)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(this.jdField_a_of_type_Int);
    }
    return null;
  }
  
  public ngb a(int paramInt)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (localIterator.hasNext())
        {
          ngb localngb = (ngb)localIterator.next();
          int i = localngb.jdField_a_of_type_Int;
          if (i != paramInt) {
            continue;
          }
          return localngb;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.reset();
    this.jdField_a_of_type_Nfw.a();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
    this.e = 0;
    this.f = 0;
    this.jdField_a_of_type_Long = 0L;
    this.h = 0;
    this.g = 0;
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo = new SurvivalPkResultInfo();
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
          if (paramInt == ((nga)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).jdField_a_of_type_Int)
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
  
  public void a(SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo.copyFrom(paramSurvivalPkResultInfo);
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Nfw.a(paramString);
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
      this.jdField_a_of_type_Nfw.a(paramString1, paramString2, paramLong);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(List<Long> paramList)
  {
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    Iterator localIterator1 = this.jdField_d_of_type_JavaUtilList.iterator();
    Long localLong;
    if (localIterator1.hasNext())
    {
      localLong = (Long)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
      } while (!localLong.equals((Long)localIterator2.next()));
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_c_of_type_JavaUtilList.add(localLong);
        break;
      }
      this.jdField_b_of_type_JavaUtilList.remove(localLong);
      break;
      this.jdField_d_of_type_JavaUtilList.clear();
      this.jdField_d_of_type_JavaUtilList.addAll(paramList);
      return;
    }
  }
  
  public void a(List<nga> paramList, int paramInt)
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
          nga localnga = (nga)paramList.next();
          if (!nff.d(nff.a(localnga.jdField_a_of_type_Int))) {
            continue;
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localnga);
          continue;
        }
        d();
      }
      finally {}
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void a(List<ngb> paramList, String paramString1, String paramString2)
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
          ngb localngb = (ngb)paramList.next();
          this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localngb);
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
    e();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.id != 0L) && (!TextUtils.isEmpty(this.jdField_a_of_type_Nfw.a()));
  }
  
  public boolean a(Player paramPlayer)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Nfw.a(paramPlayer);
      if (bool) {
        a(this.jdField_a_of_type_Nfw.c);
      }
      return bool;
    }
    finally {}
  }
  
  public boolean a(Player paramPlayer, nfh paramnfh)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Nfw.a(paramPlayer, paramnfh);
      if (bool) {
        a(this.jdField_a_of_type_Nfw.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
      }
      return bool;
    }
    finally {}
  }
  
  public boolean a(String paramString)
  {
    if ((!c()) || (TextUtils.isEmpty(paramString))) {}
    while ((this.jdField_a_of_type_Nfw.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null) || (!paramString.equalsIgnoreCase(this.jdField_a_of_type_Nfw.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin))) {
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
    //   5: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   22: invokestatic 107	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   25: invokevirtual 111	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   28: invokevirtual 117	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   31: invokevirtual 320	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   34: ifeq +15 -> 49
    //   37: iload_2
    //   38: iconst_1
    //   39: if_icmpne +10 -> 49
    //   42: aload_0
    //   43: getfield 65	nfv:jdField_a_of_type_Nfw	Lnfw;
    //   46: invokevirtual 323	nfw:c	()V
    //   49: aload_0
    //   50: getfield 60	nfv:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   53: aload_1
    //   54: iload_2
    //   55: invokevirtual 327	com/tencent/avgame/gamelogic/data/RoomInfo:onChangeUserStatus	(Ljava/lang/String;I)V
    //   58: goto -41 -> 17
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	nfv
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
      boolean bool = this.jdField_a_of_type_Nfw.a(paramList);
      return bool;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public boolean a(nfh paramnfh)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Nfw.a(paramnfh);
      return bool;
    }
    finally
    {
      paramnfh = finally;
      throw paramnfh;
    }
  }
  
  public boolean a(nfh paramnfh, int paramInt1, Player paramPlayer, long paramLong, int paramInt2)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Nfw.a(paramnfh, paramInt1, paramPlayer, paramLong, paramInt2);
      if (bool) {
        a(this.jdField_a_of_type_Nfw.d);
      }
      return bool;
    }
    finally {}
  }
  
  /* Error */
  public boolean a(nfw paramnfw)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	nfv:jdField_a_of_type_Nfw	Lnfw;
    //   6: aload_1
    //   7: invokevirtual 183	nfw:a	(Lnfw;)V
    //   10: aload_0
    //   11: getfield 65	nfv:jdField_a_of_type_Nfw	Lnfw;
    //   14: invokevirtual 340	nfw:b	()V
    //   17: aload_0
    //   18: getfield 60	nfv:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   21: invokevirtual 343	com/tencent/avgame/gamelogic/data/RoomInfo:onGameStart	()V
    //   24: aload_0
    //   25: getfield 42	nfv:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   28: invokeinterface 134 1 0
    //   33: aload_0
    //   34: invokespecial 304	nfv:e	()V
    //   37: aload_0
    //   38: getfield 194	nfv:jdField_a_of_type_Boolean	Z
    //   41: ifeq +61 -> 102
    //   44: aload_0
    //   45: iconst_3
    //   46: invokevirtual 345	nfv:f	(I)V
    //   49: aload_1
    //   50: ifnull +52 -> 102
    //   53: aload_0
    //   54: getfield 37	nfv:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   57: ifnull +45 -> 102
    //   60: iconst_0
    //   61: istore_2
    //   62: iload_2
    //   63: aload_0
    //   64: getfield 37	nfv:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   67: invokevirtual 219	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   70: if_icmpge +32 -> 102
    //   73: aload_0
    //   74: getfield 37	nfv:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   77: iload_2
    //   78: invokevirtual 223	java/util/concurrent/CopyOnWriteArrayList:get	(I)Ljava/lang/Object;
    //   81: checkcast 164	nga
    //   84: getfield 166	nga:jdField_a_of_type_Int	I
    //   87: aload_1
    //   88: getfield 348	nfw:jdField_a_of_type_Nfz	Lnfz;
    //   91: getfield 351	nfz:jdField_a_of_type_Int	I
    //   94: if_icmpne +12 -> 106
    //   97: aload_0
    //   98: iload_2
    //   99: putfield 188	nfv:jdField_a_of_type_Int	I
    //   102: aload_0
    //   103: monitorexit
    //   104: iconst_1
    //   105: ireturn
    //   106: iload_2
    //   107: iconst_1
    //   108: iadd
    //   109: istore_2
    //   110: goto -48 -> 62
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	nfv
    //   0	118	1	paramnfw	nfw
    //   61	49	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	49	113	finally
    //   53	60	113	finally
    //   62	102	113	finally
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
    //   9: getfield 60	nfv:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   12: ifnull +37 -> 49
    //   15: iload_1
    //   16: ifeq +37 -> 53
    //   19: iload 4
    //   21: istore_3
    //   22: aload_0
    //   23: getfield 60	nfv:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   26: invokevirtual 355	com/tencent/avgame/gamelogic/data/RoomInfo:isRoomMatching	()Z
    //   29: ifeq +20 -> 49
    //   32: aload_0
    //   33: getfield 60	nfv:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   36: getfield 358	com/tencent/avgame/gamelogic/data/RoomInfo:matchShareId	I
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
    //   54: getfield 60	nfv:jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   57: invokevirtual 355	com/tencent/avgame/gamelogic/data/RoomInfo:isRoomMatching	()Z
    //   60: istore_3
    //   61: goto -12 -> 49
    //   64: astore 5
    //   66: aload_0
    //   67: monitorexit
    //   68: aload 5
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	nfv
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
        nga localnga = (nga)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
        l2 = l1;
        if (!nff.b((nga)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i))) {
          break label85;
        }
        l2 = localnga.jdField_b_of_type_Long - NetConnInfoCenter.getServerTime();
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
      Player localPlayer = this.jdField_a_of_type_Nfw.a();
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
    return this.jdField_a_of_type_Nfw.a();
  }
  
  public List<nfh> b()
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
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.reset();
    this.jdField_a_of_type_Nfw.a();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void b(int paramInt)
  {
    QLog.d("EngineData", 2, "updateSurvivalPoolId " + paramInt);
    this.jdField_b_of_type_Int = paramInt;
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
  
  public void b(List<Long> paramList, int paramInt)
  {
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    if (paramInt == 1) {
      this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    }
    while (paramInt != 2) {
      return;
    }
    this.jdField_c_of_type_JavaUtilList.addAll(paramList);
  }
  
  public boolean b()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Nfw.b();
      if (bool) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.onGameOver();
      }
      return bool;
    }
    finally {}
  }
  
  public boolean b(String paramString)
  {
    if ((this.jdField_a_of_type_Nfw.c() == 0) || (this.jdField_a_of_type_Nfw.c() == 10)) {
      return false;
    }
    return a(paramString);
  }
  
  public boolean b(nfh paramnfh)
  {
    boolean bool;
    if (paramnfh == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        paramnfh = paramnfh.a();
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramnfh);
        bool = true;
      }
      finally {}
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Nfw.a();
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
        nga localnga = (nga)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
        l2 = l1;
        if (!nff.a((nga)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i))) {
          break label85;
        }
        l2 = localnga.c - NetConnInfoCenter.getServerTime();
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
    String str = this.jdField_a_of_type_Nfw.jdField_a_of_type_Nfz.jdField_a_of_type_JavaLangString;
    Object localObject;
    if (str != null)
    {
      localObject = str;
      if (str.length() != 0) {}
    }
    else
    {
      localObject = a(this.jdField_a_of_type_Nfw.b());
      if ((localObject == null) || (((ngb)localObject).jdField_a_of_type_JavaUtilArrayList == null) || (((ngb)localObject).jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label78;
      }
    }
    label78:
    for (int i = 1; i != 0; i = 0)
    {
      localObject = BaseApplicationImpl.getApplication().getApplicationContext().getString(2131690418);
      return localObject;
    }
    return null;
  }
  
  public List<Long> c()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.reset();
    this.jdField_a_of_type_Nfw.a();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.e = 0;
    this.f = 0;
    this.jdField_a_of_type_Long = 0L;
    this.g = 0;
    this.h = 0;
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo = new SurvivalPkResultInfo();
  }
  
  public void c(int paramInt)
  {
    this.h = paramInt;
  }
  
  public boolean c()
  {
    return nff.a(c());
  }
  
  public boolean c(String paramString)
  {
    if ((this.jdField_a_of_type_Nfw.c() == 0) || (this.jdField_a_of_type_Nfw.c() == 10)) {}
    String str;
    do
    {
      return false;
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    } while ((c() != 3) || (!TextUtils.equals(paramString, str)));
    return true;
  }
  
  public boolean c(nfh paramnfh)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Nfw.b(paramnfh);
      return bool;
    }
    finally
    {
      paramnfh = finally;
      throw paramnfh;
    }
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Nfw.b();
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
    Object localObject = a(this.jdField_a_of_type_Nfw.b());
    if (localObject != null)
    {
      Iterator localIterator = ((ngb)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (ngc)localIterator.next();
      } while ((((ngc)localObject).jdField_a_of_type_JavaLangString == null) || (!((ngc)localObject).jdField_a_of_type_JavaLangString.equals(str)));
    }
    for (;;)
    {
      if (localObject != null) {
        return ((ngc)localObject).c;
      }
      return null;
      localObject = null;
    }
  }
  
  public List<Long> d()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        nga localnga = (nga)localIterator.next();
        if (nff.a(localnga))
        {
          if ((localnga.jdField_b_of_type_Int == 1) && (localnga.jdField_b_of_type_Long <= NetConnInfoCenter.getServerTime())) {
            localnga.jdField_b_of_type_Int = 2;
          }
          if (localnga.c <= NetConnInfoCenter.getServerTime())
          {
            int i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.indexOf(localnga);
            if (this.jdField_a_of_type_Int == i) {
              this.jdField_a_of_type_Int = 0;
            }
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localnga);
          }
        }
      }
    }
  }
  
  public void d(int paramInt)
  {
    QLog.d("EngineData", 2, "updateSurvivalPkState " + paramInt);
    this.f = paramInt;
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
  
  public boolean d(nfh paramnfh)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Nfw.c(paramnfh);
      return bool;
    }
    finally
    {
      paramnfh = finally;
      throw paramnfh;
    }
  }
  
  public int e()
  {
    nfh localnfh = a();
    if ((localnfh instanceof nfi)) {
      return ((nfi)localnfh).e_();
    }
    return 0;
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean e(String paramString)
  {
    return Long.toString(this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.owner).equalsIgnoreCase(paramString);
  }
  
  public int f()
  {
    return a().jdField_a_of_type_Nfz.h;
  }
  
  public void f(int paramInt)
  {
    QLog.d("EngineData", 2, "updateSurvivalGameStatus " + paramInt);
    this.e = paramInt;
  }
  
  public int g()
  {
    int i = a().jdField_a_of_type_Nfz.g;
    if (i == 0)
    {
      i = a().jdField_a_of_type_Nfz.jdField_c_of_type_Int;
      int j = a().jdField_a_of_type_Nfz.e + a().jdField_a_of_type_Nfz.f;
      if (j > 0) {
        return i / j;
      }
    }
    else if (i == 1)
    {
      return a().jdField_a_of_type_Nfz.h;
    }
    return 0;
  }
  
  public void g(int paramInt)
  {
    QLog.d("EngineData", 2, "updateSurvivalCurRound " + paramInt);
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public int h()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo.getUins().size();
  }
  
  public void h(int paramInt)
  {
    this.g = paramInt;
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
  
  public int j()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int k()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int l()
  {
    return this.h;
  }
  
  public int m()
  {
    return this.f;
  }
  
  public int n()
  {
    return this.e;
  }
  
  public int o()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public int p()
  {
    return this.g;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n").append("roomInfo").append("=").append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo);
    localStringBuilder.append("\n").append("game").append("=").append(this.jdField_a_of_type_Nfw);
    localStringBuilder.append("\n").append("curGameIndex").append("=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n").append("gameListSize").append("=").append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    localStringBuilder.append("\n").append("topicCount").append("=").append(this.jdField_a_of_type_JavaUtilList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfv
 * JD-Core Version:    0.7.0.1
 */