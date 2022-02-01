import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.GameStatusInfo;
import trpc.qq_vgame.common.AvGameCommon.RoomUserInfo;

public class nag
  implements mzp
{
  public int a;
  public long a;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  @NotNull
  public GameRecordInfo a;
  @Nullable
  public Player a;
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  public CopyOnWriteArrayList<UserScore> a;
  @Nullable
  public mzq a;
  @NotNull
  public naj a;
  public int b;
  private long b;
  @Nullable
  public Player b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  @Nullable
  public Player c;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  @Nullable
  public Player d;
  private int e;
  
  public nag()
  {
    this.jdField_a_of_type_Naj = new naj();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo = new GameRecordInfo();
    a();
  }
  
  /* Error */
  private int a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq +7 -> 10
    //   6: aload_0
    //   7: invokespecial 50	nag:d	()V
    //   10: aload_0
    //   11: getfield 52	nag:jdField_c_of_type_Long	J
    //   14: lstore 4
    //   16: lload 4
    //   18: lconst_0
    //   19: lcmp
    //   20: ifgt +9 -> 29
    //   23: iconst_0
    //   24: istore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_2
    //   28: ireturn
    //   29: invokestatic 58	android/os/SystemClock:elapsedRealtime	()J
    //   32: aload_0
    //   33: getfield 52	nag:jdField_c_of_type_Long	J
    //   36: lsub
    //   37: l2i
    //   38: istore_2
    //   39: aload_0
    //   40: getfield 60	nag:jdField_d_of_type_Int	I
    //   43: istore_3
    //   44: iload_2
    //   45: iload_3
    //   46: iadd
    //   47: istore_2
    //   48: goto -23 -> 25
    //   51: astore 6
    //   53: aload_0
    //   54: monitorexit
    //   55: aload 6
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	nag
    //   0	58	1	paramBoolean	boolean
    //   24	24	2	i	int
    //   43	4	3	j	int
    //   14	3	4	l	long
    //   51	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	10	51	finally
    //   10	16	51	finally
    //   29	44	51	finally
  }
  
  @NotNull
  public static nag a(long paramLong, String paramString, naj paramnaj, Player paramPlayer, mzq parammzq)
  {
    nag localnag = new nag();
    localnag.jdField_a_of_type_JavaLangString = paramString;
    localnag.jdField_b_of_type_Long = paramLong;
    localnag.jdField_a_of_type_Mzq = parammzq;
    localnag.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = paramPlayer;
    localnag.jdField_a_of_type_Naj.a(paramnaj);
    return localnag;
  }
  
  private void a(int paramInt)
  {
    QLog.d("avgame_logic_Game", 1, new Object[] { "onCountdownFinish left=", Integer.valueOf(paramInt) });
    this.jdField_c_of_type_Int = 2;
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_d_of_type_Int = (-paramInt);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      this.jdField_a_of_type_AndroidOsCountDownTimer = null;
    }
    int i;
    if (this.jdField_c_of_type_Int == 1)
    {
      i = a(false);
      i = this.jdField_a_of_type_Naj.jdField_d_of_type_Int * 1000 - i;
      if (i <= 0) {
        a(i);
      }
    }
    else
    {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_AndroidOsCountDownTimer = new nah(this, i, i + 1, l, i);
    this.jdField_a_of_type_AndroidOsCountDownTimer.start();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Naj.jdField_b_of_type_Int;
  }
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      UserScore localUserScore = (UserScore)localIterator.next();
      if (paramString.equalsIgnoreCase(Long.toString(localUserScore.uin))) {
        return localUserScore.score;
      }
    }
    return 0;
  }
  
  public Player a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CopyOnWriteArrayList<UserScore> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public mzq a()
  {
    return this.jdField_a_of_type_Mzq;
  }
  
  protected nag a()
  {
    nag localnag = new nag();
    localnag.a(this);
    return localnag;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Mzq = null;
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    this.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    this.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    this.jdField_d_of_type_Int = 0;
    this.e = 0;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Naj.a();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.reset();
    d();
  }
  
  public void a(GameRecordInfo paramGameRecordInfo)
  {
    if (paramGameRecordInfo != null) {}
    try
    {
      a(paramGameRecordInfo.videoFilePath, paramGameRecordInfo.photoFilePath, paramGameRecordInfo.startGameTimeMills);
      a(paramGameRecordInfo.extraJsonData);
      return;
    }
    finally
    {
      paramGameRecordInfo = finally;
      throw paramGameRecordInfo;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.extraJsonData = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        UserScore localUserScore = (UserScore)((Iterator)localObject).next();
        if ((localUserScore != null) && (paramString.equalsIgnoreCase(Long.toString(localUserScore.uin)))) {
          localUserScore.score += paramInt;
        }
      }
      for (int i = 1; i == 0; i = 0)
      {
        localObject = new UserScore();
        ((UserScore)localObject).score = paramInt;
        ((UserScore)localObject).uin = Long.parseLong(paramString);
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
        return;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.gameType = a();
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.videoFilePath = paramString1;
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.photoFilePath = paramString2;
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.startGameTimeMills = paramLong;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(nag paramnag)
  {
    Object localObject2 = null;
    if (paramnag == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramnag.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Long = paramnag.jdField_b_of_type_Long;
    this.jdField_c_of_type_Int = paramnag.jdField_c_of_type_Int;
    if (paramnag.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)
    {
      localObject1 = null;
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
      if (paramnag.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
        break label202;
      }
      localObject1 = null;
      label54:
      this.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
      if (paramnag.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
        break label213;
      }
      localObject1 = null;
      label68:
      this.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
      if (paramnag.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
        break label224;
      }
      localObject1 = null;
      label82:
      this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
      if (paramnag.jdField_a_of_type_Mzq != null) {
        break label235;
      }
    }
    label202:
    label213:
    label224:
    label235:
    for (Object localObject1 = localObject2;; localObject1 = paramnag.jdField_a_of_type_Mzq.a())
    {
      this.jdField_a_of_type_Mzq = ((mzq)localObject1);
      this.jdField_d_of_type_Int = paramnag.jdField_d_of_type_Int;
      this.e = paramnag.e;
      this.jdField_c_of_type_Long = paramnag.jdField_c_of_type_Long;
      this.jdField_d_of_type_Long = paramnag.jdField_d_of_type_Long;
      this.jdField_a_of_type_Naj.a(paramnag.jdField_a_of_type_Naj);
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(paramnag.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
      this.jdField_a_of_type_Int = paramnag.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramnag.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.copyFrom(paramnag.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo);
      return;
      localObject1 = paramnag.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.clone();
      break;
      localObject1 = paramnag.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer.clone();
      break label54;
      localObject1 = paramnag.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer.clone();
      break label68;
      localObject1 = paramnag.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer.clone();
      break label82;
    }
  }
  
  public void a(AvGameCommon.GameStatusInfo paramGameStatusInfo)
  {
    if (paramGameStatusInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramGameStatusInfo.play_game_id.get();
    this.jdField_c_of_type_Int = paramGameStatusInfo.game_status.get();
    Player localPlayer;
    if ((paramGameStatusInfo.actor_info.has()) && (paramGameStatusInfo.actor_info.get() != null))
    {
      localPlayer = new Player();
      localPlayer.parseFrom((AvGameCommon.RoomUserInfo)paramGameStatusInfo.actor_info.get());
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = localPlayer;
    }
    if ((paramGameStatusInfo.right_actor_info.has()) && (paramGameStatusInfo.right_actor_info.get() != null))
    {
      localPlayer = new Player();
      localPlayer.parseFrom((AvGameCommon.RoomUserInfo)paramGameStatusInfo.right_actor_info.get());
      this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = localPlayer;
    }
    if ((paramGameStatusInfo.question_info.has()) && (paramGameStatusInfo.question_info.get() != null)) {
      this.jdField_a_of_type_Mzq = mzo.b((AvGameCommon.GameQuestionInfo)paramGameStatusInfo.question_info.get(), false);
    }
    if ((paramGameStatusInfo.game_info.has()) && (paramGameStatusInfo.game_info.get() != null))
    {
      this.jdField_a_of_type_Naj.a();
      this.jdField_a_of_type_Naj.a((AvGameCommon.GameInfo)paramGameStatusInfo.game_info.get());
    }
    this.jdField_d_of_type_Int = paramGameStatusInfo.status_past_time.get();
    this.e = paramGameStatusInfo.game_past_time.get();
    this.jdField_a_of_type_Int = paramGameStatusInfo.score.get();
    long l = SystemClock.elapsedRealtime();
    this.jdField_c_of_type_Long = l;
    this.jdField_d_of_type_Long = l;
  }
  
  public boolean a()
  {
    int k = 1;
    int m = 1;
    int i;
    int j;
    switch (this.jdField_c_of_type_Int)
    {
    case 0: 
    default: 
      return true;
    case 1: 
    case 2: 
    case 4: 
      if (this.jdField_a_of_type_Mzq != null)
      {
        i = 1;
        j = m;
        if (mzo.a(a())) {
          if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null) {
            break label89;
          }
        }
      }
      label89:
      for (j = m;; j = 0)
      {
        return j & i & 0x1;
        i = 0;
        break;
      }
    }
    if (this.jdField_a_of_type_Mzq != null)
    {
      j = 1;
      if (!mzo.a(a())) {
        break label147;
      }
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null) {
        break label142;
      }
      i = 1;
      label122:
      if (this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer == null) {
        break label152;
      }
    }
    for (;;)
    {
      return k & i & 0x1 & j;
      j = 0;
      break;
      label142:
      i = 0;
      break label122;
      label147:
      i = 1;
      break label122;
      label152:
      k = 0;
    }
  }
  
  public boolean a(Player paramPlayer)
  {
    if (paramPlayer != null) {}
    for (;;)
    {
      try
      {
        this.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer = paramPlayer;
        bool = true;
        return bool;
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public boolean a(Player paramPlayer, mzq parammzq)
  {
    boolean bool = true;
    if ((paramPlayer == null) || (parammzq == null)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.jdField_c_of_type_Int = 1;
        this.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer = this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = paramPlayer;
        this.jdField_a_of_type_Mzq = parammzq;
        this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = null;
        if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
          this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.status = 2;
        }
        this.jdField_d_of_type_Int = 0;
        this.e = 0;
        long l = SystemClock.elapsedRealtime();
        this.jdField_c_of_type_Long = l;
        this.jdField_d_of_type_Long = l;
        d();
      }
      finally {}
    }
  }
  
  public boolean a(List<UserScore> paramList)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(paramList);
      return true;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public boolean a(mzq parammzq)
  {
    boolean bool = false;
    if (parammzq != null) {}
    try
    {
      this.jdField_c_of_type_Int = 2;
      this.jdField_a_of_type_Mzq = parammzq;
      this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = null;
      this.jdField_d_of_type_Int = 0;
      this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
      d();
      bool = true;
      return bool;
    }
    finally
    {
      parammzq = finally;
      throw parammzq;
    }
  }
  
  /* Error */
  public boolean a(mzq parammzq, int paramInt1, Player paramPlayer, long paramLong, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 68	nag:jdField_a_of_type_Mzq	Lmzq;
    //   9: ifnull +112 -> 121
    //   12: aload_0
    //   13: getfield 68	nag:jdField_a_of_type_Mzq	Lmzq;
    //   16: aload_1
    //   17: invokeinterface 328 2 0
    //   22: ifeq +99 -> 121
    //   25: aload_3
    //   26: ifnull +95 -> 121
    //   29: aload_0
    //   30: iconst_3
    //   31: putfield 29	nag:jdField_c_of_type_Int	I
    //   34: aload_0
    //   35: aload_1
    //   36: putfield 68	nag:jdField_a_of_type_Mzq	Lmzq;
    //   39: aload_0
    //   40: aload_3
    //   41: putfield 174	nag:jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer	Lcom/tencent/avgame/gamelogic/data/Player;
    //   44: aload_0
    //   45: iload_2
    //   46: putfield 184	nag:jdField_a_of_type_Int	I
    //   49: aload_0
    //   50: lload 4
    //   52: putfield 330	nag:jdField_a_of_type_Long	J
    //   55: aload_0
    //   56: aload_3
    //   57: getfield 332	com/tencent/avgame/gamelogic/data/Player:uin	Ljava/lang/String;
    //   60: iload_2
    //   61: invokevirtual 334	nag:a	(Ljava/lang/String;I)V
    //   64: aload_1
    //   65: invokeinterface 336 1 0
    //   70: iconst_1
    //   71: if_icmpne +29 -> 100
    //   74: aload_0
    //   75: getfield 70	nag:jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer	Lcom/tencent/avgame/gamelogic/data/Player;
    //   78: ifnull +22 -> 100
    //   81: aload_0
    //   82: iload 6
    //   84: putfield 185	nag:jdField_b_of_type_Int	I
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 70	nag:jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer	Lcom/tencent/avgame/gamelogic/data/Player;
    //   92: getfield 332	com/tencent/avgame/gamelogic/data/Player:uin	Ljava/lang/String;
    //   95: iload 6
    //   97: invokevirtual 334	nag:a	(Ljava/lang/String;I)V
    //   100: aload_0
    //   101: iconst_0
    //   102: putfield 60	nag:jdField_d_of_type_Int	I
    //   105: aload_0
    //   106: invokestatic 58	android/os/SystemClock:elapsedRealtime	()J
    //   109: putfield 52	nag:jdField_c_of_type_Long	J
    //   112: aload_0
    //   113: invokespecial 50	nag:d	()V
    //   116: aload_0
    //   117: monitorexit
    //   118: iload 7
    //   120: ireturn
    //   121: iconst_0
    //   122: istore 7
    //   124: goto -8 -> 116
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	nag
    //   0	132	1	parammzq	mzq
    //   0	132	2	paramInt1	int
    //   0	132	3	paramPlayer	Player
    //   0	132	4	paramLong	long
    //   0	132	6	paramInt2	int
    //   1	122	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	25	127	finally
    //   29	100	127	finally
    //   100	116	127	finally
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Naj.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Int = 1;
    long l = SystemClock.elapsedRealtime();
    this.jdField_c_of_type_Long = l;
    this.jdField_d_of_type_Long = l;
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.status = 2;
    }
    d();
  }
  
  public void b(nag paramnag)
  {
    try
    {
      a(paramnag);
      d();
      return;
    }
    finally
    {
      paramnag = finally;
      throw paramnag;
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_c_of_type_Int != 10)
    {
      this.jdField_c_of_type_Int = 10;
      this.jdField_d_of_type_Int = 0;
      this.e = 0;
      this.jdField_c_of_type_Long = 0L;
      this.jdField_d_of_type_Long = 0L;
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.status = 0;
      }
      d();
      bool = true;
    }
    return bool;
  }
  
  public boolean b(mzq parammzq)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.jdField_a_of_type_Mzq != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Mzq.a(parammzq))
        {
          this.jdField_c_of_type_Int = 4;
          this.jdField_a_of_type_Mzq = parammzq;
          this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = null;
          this.jdField_d_of_type_Int = 0;
          this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
          d();
          bool1 = true;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public int c()
  {
    d();
    return this.jdField_c_of_type_Int;
  }
  
  public void c()
  {
    try
    {
      this.jdField_c_of_type_Int = 0;
      this.jdField_d_of_type_Int = 0;
      this.jdField_c_of_type_Long = 0L;
      this.e = 0;
      this.jdField_d_of_type_Long = 0L;
      d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean c(mzq parammzq)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 68	nag:jdField_a_of_type_Mzq	Lmzq;
    //   6: ifnull +32 -> 38
    //   9: aload_0
    //   10: getfield 68	nag:jdField_a_of_type_Mzq	Lmzq;
    //   13: aload_1
    //   14: invokeinterface 328 2 0
    //   19: ifeq +19 -> 38
    //   22: aload_0
    //   23: aload_1
    //   24: putfield 68	nag:jdField_a_of_type_Mzq	Lmzq;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 174	nag:jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer	Lcom/tencent/avgame/gamelogic/data/Player;
    //   32: iconst_1
    //   33: istore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_2
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_2
    //   40: goto -6 -> 34
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	nag
    //   0	48	1	parammzq	mzq
    //   33	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	32	43	finally
  }
  
  public int d()
  {
    try
    {
      int i = a(true);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int e()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokespecial 50	nag:d	()V
    //   8: iload_2
    //   9: istore_1
    //   10: aload_0
    //   11: getfield 29	nag:jdField_c_of_type_Int	I
    //   14: ifeq +15 -> 29
    //   17: aload_0
    //   18: getfield 29	nag:jdField_c_of_type_Int	I
    //   21: istore_1
    //   22: iload_1
    //   23: iconst_1
    //   24: if_icmpne +9 -> 33
    //   27: iload_2
    //   28: istore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_1
    //   32: ireturn
    //   33: iload_2
    //   34: istore_1
    //   35: aload_0
    //   36: getfield 178	nag:jdField_d_of_type_Long	J
    //   39: lconst_0
    //   40: lcmp
    //   41: ifle -12 -> 29
    //   44: invokestatic 58	android/os/SystemClock:elapsedRealtime	()J
    //   47: aload_0
    //   48: getfield 178	nag:jdField_d_of_type_Long	J
    //   51: lsub
    //   52: l2i
    //   53: istore_1
    //   54: aload_0
    //   55: getfield 176	nag:e	I
    //   58: istore_2
    //   59: aload_0
    //   60: getfield 34	nag:jdField_a_of_type_Naj	Lnaj;
    //   63: getfield 103	naj:jdField_d_of_type_Int	I
    //   66: istore_3
    //   67: iload_1
    //   68: iload_2
    //   69: iadd
    //   70: iload_3
    //   71: sipush 1000
    //   74: imul
    //   75: isub
    //   76: istore_1
    //   77: goto -48 -> 29
    //   80: astore 4
    //   82: aload_0
    //   83: monitorexit
    //   84: aload 4
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	nag
    //   9	68	1	i	int
    //   1	69	2	j	int
    //   66	9	3	k	int
    //   80	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	8	80	finally
    //   10	22	80	finally
    //   35	67	80	finally
  }
  
  /* Error */
  public int f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 219	nag:a	()I
    //   6: invokestatic 342	mzo:c	(I)Z
    //   9: ifeq +29 -> 38
    //   12: aload_0
    //   13: invokevirtual 343	nag:a	()Lmzq;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +20 -> 38
    //   21: aload_2
    //   22: invokeinterface 345 1 0
    //   27: istore_1
    //   28: iload_1
    //   29: sipush 1000
    //   32: imul
    //   33: istore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_1
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 34	nag:jdField_a_of_type_Naj	Lnaj;
    //   42: getfield 346	naj:e	I
    //   45: istore_1
    //   46: iload_1
    //   47: sipush 1000
    //   50: imul
    //   51: istore_1
    //   52: goto -18 -> 34
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	nag
    //   27	25	1	i	int
    //   16	6	2	localmzq	mzq
    //   55	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	55	finally
    //   21	28	55	finally
    //   38	46	55	finally
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gameId=").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n").append("status=").append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n").append("statusPastTimeSvr=").append(this.jdField_d_of_type_Int);
    localStringBuilder.append("\n").append("gamePastTimeSvr=").append(this.e);
    localStringBuilder.append("\n").append("statusPastTime=").append(d());
    localStringBuilder.append("\n").append("gamePastTime=").append(e());
    localStringBuilder.append("\n").append("gameInfo=").append("[").append(this.jdField_a_of_type_Naj).append("]");
    localStringBuilder.append("\n").append("topic=").append("[").append(this.jdField_a_of_type_Mzq).append("]");
    localStringBuilder.append("\n").append("player=").append("[").append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer).append("]");
    localStringBuilder.append("\n").append("score=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n").append("actorScore").append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n").append("rightPlayer=").append("[").append(this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nag
 * JD-Core Version:    0.7.0.1
 */