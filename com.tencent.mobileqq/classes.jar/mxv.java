import android.os.Handler;
import android.os.SystemClock;
import com.tencent.TMG.utils.QLog;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.common.app.BaseApplicationImpl;

public class mxv
  extends mzj
  implements mzf
{
  public static int a;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new mxw(this);
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private mzg<myc> jdField_a_of_type_Mzg;
  private mzh jdField_a_of_type_Mzh;
  private volatile boolean jdField_a_of_type_Boolean;
  private long b;
  private long c;
  
  static
  {
    jdField_a_of_type_Int = 2000;
  }
  
  public mxv(AVGameAppInterface paramAVGameAppInterface, mzh parammzh, mzd parammzd, mzg<myc> parammzg)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Mzh = parammzh;
    this.jdField_a_of_type_Mzg = parammzg;
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.addObserver(this, false);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Long == ((myc)this.jdField_a_of_type_Mzg.a()).a();
  }
  
  private void b()
  {
    if (bgnt.a()) {}
    for (int i = 2131690264;; i = 2131690307)
    {
      QLog.d("HeartBeatController", 1, "stopHeartBeatByLocalTimeOut() then do exitRoom() isNetworkAvailable =" + bgnt.a());
      mxl.a().a(5, BaseApplicationImpl.getApplication().getString(i), mxl.a().a());
      return;
    }
  }
  
  private void b(long paramLong, String paramString)
  {
    ((mza)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(1)).a(paramLong, paramString);
    mxt.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 35000L);
  }
  
  private void d()
  {
    QLog.d("HeartBeatController", 1, String.format("maintainHeartBeat() [isStop]=[%b]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, jdField_a_of_type_Int);
    }
  }
  
  public long a()
  {
    return this.b;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.removeObserver(this);
    }
    a(1);
  }
  
  public void a(int paramInt)
  {
    mxt.jdField_a_of_type_Long = 0L;
    QLog.d("HeartBeatController", 1, String.format("stopHeartBeat() [roomId,fromType]=[%d,%d]", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(paramInt) }));
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_Boolean) || (!a()))
    {
      QLog.d("HeartBeatController", 1, String.format("onRespHeartBeatSuccess() isStop or validRoomId just return  [roomId,data.getRoomId()]=[%d,%d]", new Object[] { Long.valueOf(paramLong2), Long.valueOf(((myc)this.jdField_a_of_type_Mzg.a()).a()) }));
      return;
    }
    if (paramInt2 == 303)
    {
      QLog.d("HeartBeatController", 1, String.format("onRespHeartBeatSuccess() EC_HEARTBEAT_USER_NOT_IN_ROOM exitRoom() [roomId]=[%d]", new Object[] { Long.valueOf(paramLong2) }));
      mwu.a().a(mzj.class, 7, true, new Object[] { Long.valueOf(paramLong2), Integer.valueOf(4) });
      return;
    }
    this.b = paramLong1;
    this.c = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_Mzh.a(paramLong1, paramLong2, jdField_a_of_type_Int, paramInt2);
    jdField_a_of_type_Int = Math.max(paramInt1, jdField_a_of_type_Int);
    c();
  }
  
  public void a(long paramLong, String paramString)
  {
    QLog.d("HeartBeatController", 1, String.format("startHeartBeat() [roomId,userUin]=[%d,%s]", new Object[] { Long.valueOf(paramLong), paramString }));
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
    b(paramLong, paramString);
    d();
    c();
  }
  
  public long b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxv
 * JD-Core Version:    0.7.0.1
 */