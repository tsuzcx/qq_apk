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

public class myd
  implements mxp
{
  public int a;
  private long jdField_a_of_type_Long;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  @NotNull
  public GameRecordInfo a;
  @Nullable
  public Player a;
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  public CopyOnWriteArrayList<UserScore> a;
  @Nullable
  public mxq a;
  @NotNull
  public myf a;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  @Nullable
  public Player b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  @Nullable
  public Player c;
  private int d;
  @Nullable
  public Player d;
  
  public myd()
  {
    this.jdField_a_of_type_Myf = new myf();
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
    //   7: invokespecial 49	myd:d	()V
    //   10: aload_0
    //   11: getfield 51	myd:jdField_b_of_type_Long	J
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
    //   29: invokestatic 57	android/os/SystemClock:elapsedRealtime	()J
    //   32: aload_0
    //   33: getfield 51	myd:jdField_b_of_type_Long	J
    //   36: lsub
    //   37: l2i
    //   38: istore_2
    //   39: aload_0
    //   40: getfield 59	myd:jdField_c_of_type_Int	I
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
    //   0	58	0	this	myd
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
  public static myd a(long paramLong, String paramString, myf parammyf, Player paramPlayer, mxq parammxq)
  {
    myd localmyd = new myd();
    localmyd.jdField_a_of_type_JavaLangString = paramString;
    localmyd.jdField_a_of_type_Long = paramLong;
    localmyd.jdField_a_of_type_Mxq = parammxq;
    localmyd.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = paramPlayer;
    localmyd.jdField_a_of_type_Myf.a(parammyf);
    return localmyd;
  }
  
  private void a(int paramInt)
  {
    QLog.d("avgame_logic_Game", 1, new Object[] { "onCountdownFinish left=", Integer.valueOf(paramInt) });
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_c_of_type_Int = (-paramInt);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      this.jdField_a_of_type_AndroidOsCountDownTimer = null;
    }
    int i;
    if (this.jdField_b_of_type_Int == 1)
    {
      i = a(false);
      i = this.jdField_a_of_type_Myf.jdField_d_of_type_Int * 1000 - i;
      if (i <= 0) {
        a(i);
      }
    }
    else
    {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_AndroidOsCountDownTimer = new mye(this, i, i + 1, l, i);
    this.jdField_a_of_type_AndroidOsCountDownTimer.start();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Myf.jdField_b_of_type_Int;
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
  
  public mxq a()
  {
    return this.jdField_a_of_type_Mxq;
  }
  
  protected myd a()
  {
    myd localmyd = new myd();
    localmyd.a(this);
    return localmyd;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Mxq = null;
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    this.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    this.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_Myf.a();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Int = 0;
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
  
  public void a(myd parammyd)
  {
    Object localObject2 = null;
    if (parammyd == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = parammyd.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Long = parammyd.jdField_a_of_type_Long;
    this.jdField_b_of_type_Int = parammyd.jdField_b_of_type_Int;
    if (parammyd.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)
    {
      localObject1 = null;
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
      if (parammyd.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
        break label194;
      }
      localObject1 = null;
      label54:
      this.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
      if (parammyd.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
        break label205;
      }
      localObject1 = null;
      label68:
      this.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
      if (parammyd.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
        break label216;
      }
      localObject1 = null;
      label82:
      this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
      if (parammyd.jdField_a_of_type_Mxq != null) {
        break label227;
      }
    }
    label194:
    label205:
    label216:
    label227:
    for (Object localObject1 = localObject2;; localObject1 = parammyd.jdField_a_of_type_Mxq.a())
    {
      this.jdField_a_of_type_Mxq = ((mxq)localObject1);
      this.jdField_c_of_type_Int = parammyd.jdField_c_of_type_Int;
      this.jdField_d_of_type_Int = parammyd.jdField_d_of_type_Int;
      this.jdField_b_of_type_Long = parammyd.jdField_b_of_type_Long;
      this.jdField_c_of_type_Long = parammyd.jdField_c_of_type_Long;
      this.jdField_a_of_type_Myf.a(parammyd.jdField_a_of_type_Myf);
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(parammyd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
      this.jdField_a_of_type_Int = parammyd.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.copyFrom(parammyd.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo);
      return;
      localObject1 = parammyd.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.clone();
      break;
      localObject1 = parammyd.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer.clone();
      break label54;
      localObject1 = parammyd.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer.clone();
      break label68;
      localObject1 = parammyd.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer.clone();
      break label82;
    }
  }
  
  public void a(AvGameCommon.GameStatusInfo paramGameStatusInfo)
  {
    if (paramGameStatusInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramGameStatusInfo.play_game_id.get();
    this.jdField_b_of_type_Int = paramGameStatusInfo.game_status.get();
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
      this.jdField_a_of_type_Mxq = mxo.b((AvGameCommon.GameQuestionInfo)paramGameStatusInfo.question_info.get(), false);
    }
    if ((paramGameStatusInfo.game_info.has()) && (paramGameStatusInfo.game_info.get() != null))
    {
      this.jdField_a_of_type_Myf.a();
      this.jdField_a_of_type_Myf.a((AvGameCommon.GameInfo)paramGameStatusInfo.game_info.get());
    }
    this.jdField_c_of_type_Int = paramGameStatusInfo.status_past_time.get();
    this.jdField_d_of_type_Int = paramGameStatusInfo.game_past_time.get();
    this.jdField_a_of_type_Int = paramGameStatusInfo.score.get();
    long l = SystemClock.elapsedRealtime();
    this.jdField_b_of_type_Long = l;
    this.jdField_c_of_type_Long = l;
  }
  
  public boolean a()
  {
    int k = 1;
    int m = 1;
    int i;
    int j;
    switch (this.jdField_b_of_type_Int)
    {
    case 0: 
    default: 
      return true;
    case 1: 
    case 2: 
    case 4: 
      if (this.jdField_a_of_type_Mxq != null)
      {
        i = 1;
        j = m;
        if (mxo.a(a())) {
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
    if (this.jdField_a_of_type_Mxq != null)
    {
      j = 1;
      if (!mxo.a(a())) {
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
  
  public boolean a(Player paramPlayer, mxq parammxq)
  {
    boolean bool = true;
    if ((paramPlayer == null) || (parammxq == null)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.jdField_b_of_type_Int = 1;
        this.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer = this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = paramPlayer;
        this.jdField_a_of_type_Mxq = parammxq;
        this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = null;
        if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
          this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.status = 2;
        }
        this.jdField_c_of_type_Int = 0;
        this.jdField_d_of_type_Int = 0;
        long l = SystemClock.elapsedRealtime();
        this.jdField_b_of_type_Long = l;
        this.jdField_c_of_type_Long = l;
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
  
  public boolean a(mxq parammxq)
  {
    boolean bool = false;
    if (parammxq != null) {}
    try
    {
      this.jdField_b_of_type_Int = 2;
      this.jdField_a_of_type_Mxq = parammxq;
      this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = null;
      this.jdField_c_of_type_Int = 0;
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      d();
      bool = true;
      return bool;
    }
    finally
    {
      parammxq = finally;
      throw parammxq;
    }
  }
  
  public boolean a(mxq parammxq, int paramInt, Player paramPlayer)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.jdField_a_of_type_Mxq != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Mxq.a(parammxq))
        {
          bool1 = bool2;
          if (paramPlayer != null)
          {
            this.jdField_b_of_type_Int = 3;
            this.jdField_a_of_type_Mxq = parammxq;
            this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = paramPlayer;
            this.jdField_a_of_type_Int = paramInt;
            a(paramPlayer.uin, paramInt);
            this.jdField_c_of_type_Int = 0;
            this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
            d();
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Myf.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Int = 1;
    long l = SystemClock.elapsedRealtime();
    this.jdField_b_of_type_Long = l;
    this.jdField_c_of_type_Long = l;
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.status = 2;
    }
    d();
  }
  
  public void b(myd parammyd)
  {
    try
    {
      a(parammyd);
      d();
      return;
    }
    finally
    {
      parammyd = finally;
      throw parammyd;
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_b_of_type_Int != 10)
    {
      this.jdField_b_of_type_Int = 10;
      this.jdField_c_of_type_Int = 0;
      this.jdField_d_of_type_Int = 0;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.status = 0;
      }
      d();
      bool = true;
    }
    return bool;
  }
  
  public boolean b(mxq parammxq)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.jdField_a_of_type_Mxq != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Mxq.a(parammxq))
        {
          this.jdField_b_of_type_Int = 4;
          this.jdField_a_of_type_Mxq = parammxq;
          this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = null;
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
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
    return this.jdField_b_of_type_Int;
  }
  
  public void c()
  {
    try
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_d_of_type_Int = 0;
      this.jdField_c_of_type_Long = 0L;
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
  public boolean c(mxq parammxq)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	myd:jdField_a_of_type_Mxq	Lmxq;
    //   6: ifnull +32 -> 38
    //   9: aload_0
    //   10: getfield 67	myd:jdField_a_of_type_Mxq	Lmxq;
    //   13: aload_1
    //   14: invokeinterface 325 2 0
    //   19: ifeq +19 -> 38
    //   22: aload_0
    //   23: aload_1
    //   24: putfield 67	myd:jdField_a_of_type_Mxq	Lmxq;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 173	myd:jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer	Lcom/tencent/avgame/gamelogic/data/Player;
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
    //   0	48	0	this	myd
    //   0	48	1	parammxq	mxq
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
    //   5: invokespecial 49	myd:d	()V
    //   8: iload_2
    //   9: istore_1
    //   10: aload_0
    //   11: getfield 28	myd:jdField_b_of_type_Int	I
    //   14: ifeq +15 -> 29
    //   17: aload_0
    //   18: getfield 28	myd:jdField_b_of_type_Int	I
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
    //   36: getfield 176	myd:jdField_c_of_type_Long	J
    //   39: lconst_0
    //   40: lcmp
    //   41: ifle -12 -> 29
    //   44: invokestatic 57	android/os/SystemClock:elapsedRealtime	()J
    //   47: aload_0
    //   48: getfield 176	myd:jdField_c_of_type_Long	J
    //   51: lsub
    //   52: l2i
    //   53: istore_1
    //   54: aload_0
    //   55: getfield 174	myd:jdField_d_of_type_Int	I
    //   58: istore_2
    //   59: aload_0
    //   60: getfield 33	myd:jdField_a_of_type_Myf	Lmyf;
    //   63: getfield 103	myf:jdField_d_of_type_Int	I
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
    //   0	87	0	this	myd
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
    //   3: invokevirtual 216	myd:a	()I
    //   6: invokestatic 336	mxo:c	(I)Z
    //   9: ifeq +29 -> 38
    //   12: aload_0
    //   13: invokevirtual 337	myd:a	()Lmxq;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +20 -> 38
    //   21: aload_2
    //   22: invokeinterface 339 1 0
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
    //   39: getfield 33	myd:jdField_a_of_type_Myf	Lmyf;
    //   42: getfield 341	myf:e	I
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
    //   0	60	0	this	myd
    //   27	25	1	i	int
    //   16	6	2	localmxq	mxq
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
    localStringBuilder.append("\n").append("status=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n").append("statusPastTimeSvr=").append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n").append("gamePastTimeSvr=").append(this.jdField_d_of_type_Int);
    localStringBuilder.append("\n").append("statusPastTime=").append(d());
    localStringBuilder.append("\n").append("gamePastTime=").append(e());
    localStringBuilder.append("\n").append("gameInfo=").append("[").append(this.jdField_a_of_type_Myf).append("]");
    localStringBuilder.append("\n").append("topic=").append("[").append(this.jdField_a_of_type_Mxq).append("]");
    localStringBuilder.append("\n").append("player=").append("[").append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer).append("]");
    localStringBuilder.append("\n").append("score=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n").append("rightPlayer=").append("[").append(this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myd
 * JD-Core Version:    0.7.0.1
 */