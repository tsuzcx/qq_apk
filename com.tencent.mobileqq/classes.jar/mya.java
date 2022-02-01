import android.os.SystemClock;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.QLog;

public class mya
  implements mzh
{
  long jdField_a_of_type_Long = 0L;
  AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  long b = 0L;
  long c = 0L;
  
  public mya(AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
  }
  
  private boolean a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt)
  {
    boolean bool1 = false;
    long l = this.jdField_a_of_type_Long;
    boolean bool3 = false;
    boolean bool2;
    if (paramBoolean)
    {
      bool2 = bool3;
      if (paramLong1 > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = paramLong1;
        bool1 = true;
        bool2 = bool3;
      }
    }
    for (;;)
    {
      QLog.d("avgame_logic.SyncController", 1, String.format("onGetNewSeq [%d-->%d] result=%b needSync=%b fromSync=%b", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean) }));
      if (bool2) {
        a(paramLong2, paramInt);
      }
      return bool1;
      if (paramLong1 <= this.jdField_a_of_type_Long)
      {
        bool1 = false;
        bool2 = bool3;
      }
      else if ((paramLong1 - this.jdField_a_of_type_Long == 1L) || (this.jdField_a_of_type_Long <= 0L))
      {
        this.jdField_a_of_type_Long = paramLong1;
        bool1 = true;
        bool2 = bool3;
      }
      else
      {
        bool1 = false;
        bool2 = true;
      }
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public long a(long paramLong, int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    QLog.d("avgame_logic.SyncController", 1, new Object[] { "reqPullSnapshot curSeq=", Long.valueOf(this.jdField_a_of_type_Long), " roomId=", Long.valueOf(paramLong), " uin=", str });
    long l = System.currentTimeMillis();
    ((mza)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(1)).a(paramLong, str, true, paramInt);
    return l;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    long l;
    if (paramLong1 > this.jdField_a_of_type_Long)
    {
      l = SystemClock.elapsedRealtime();
      if ((this.b != paramLong1) || (l - this.c >= paramInt1)) {
        break label41;
      }
    }
    label41:
    do
    {
      return;
      this.b = paramLong1;
      this.c = l;
      a(paramLong2, 2);
    } while (!QLog.isColorLevel());
    paramLong2 = this.jdField_a_of_type_Long;
    if (paramLong1 > this.jdField_a_of_type_Long) {
      bool = true;
    }
    QLog.d("avgame_logic.SyncController", 1, String.format("onGetNewSeqByHeartBeat [%d-->%d] needSync=%b", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), Boolean.valueOf(bool) }));
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.SyncController", 2, String.format("onGetNewSeqByPush [%d], roomId=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    return a(paramLong1, paramLong2, false, 4);
  }
  
  public boolean a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.SyncController", 2, String.format("onGetNewSeqByPullResp [%d], roomId=%d fromSync=%b", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) }));
    }
    return a(paramLong1, paramLong2, paramBoolean, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mya
 * JD-Core Version:    0.7.0.1
 */