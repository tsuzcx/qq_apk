package cooperation.ilive.lite.heart;

import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent.PlayerState;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.config.IliveManagerCfgBean;
import cooperation.ilive.config.IliveManagerConfProcessor;
import cooperation.ilive.lite.report.IliveLiteDataReport;

public class IliveRoomHeartController
{
  private boolean a = false;
  private long b;
  private long c;
  private int d = 1001;
  private PlayerStateEvent.PlayerState e;
  private Runnable f = new IliveRoomHeartController.1(this);
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleReport currentRealTS = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" mCurrentRoomId = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" intervalTime = ");
    localStringBuilder.append(b());
    QLog.e("IliveRoomHeartController", 1, localStringBuilder.toString());
    IliveLiteDataReport.a().a(this.c, this.d, d(), paramLong, paramBoolean1, paramBoolean2);
  }
  
  private long b()
  {
    IliveManagerCfgBean localIliveManagerCfgBean = IliveManagerConfProcessor.a();
    if ((localIliveManagerCfgBean != null) && (localIliveManagerCfgBean.b() > 0L)) {
      return localIliveManagerCfgBean.b();
    }
    return 5000L;
  }
  
  private boolean c()
  {
    IliveManagerCfgBean localIliveManagerCfgBean = IliveManagerConfProcessor.a();
    if (localIliveManagerCfgBean != null) {
      return localIliveManagerCfgBean.c();
    }
    return true;
  }
  
  private int d()
  {
    if (this.e == null) {
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getReportPlayerState = ");
    localStringBuilder.append(this.e.toString());
    QLog.e("IliveRoomHeartController", 1, localStringBuilder.toString());
    if ((this.e != PlayerStateEvent.PlayerState.PLAY_ERROR) && (this.e != PlayerStateEvent.PlayerState.PLAY_COMPLETED)) {
      return 1;
    }
    return 3;
  }
  
  public void a()
  {
    QLog.i("IliveRoomHeartController", 1, "stopReportHeartBeat");
    ThreadCenter.removeDefaultUITask(this.f);
    this.b = 0L;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
    this.b = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start reportHeartbeat roomId = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" mEnterPageTime = ");
    localStringBuilder.append(this.b);
    QLog.e("IliveRoomHeartController", 1, localStringBuilder.toString());
    if (!c())
    {
      QLog.e("IliveRoomHeartController", 1, " reportHeartbeat disable");
      return;
    }
    ThreadCenter.removeDefaultUITask(this.f);
    ThreadCenter.postDefaultUITask(this.f, b());
  }
  
  public void a(PlayerStateEvent.PlayerState paramPlayerState)
  {
    this.e = paramPlayerState;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    Object localObject = this.e;
    if ((localObject != null) && ((localObject == PlayerStateEvent.PlayerState.PLAY_COMPLETED) || (this.e == PlayerStateEvent.PlayerState.PLAY_ERROR)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportFinalHeartbeat cancel , current player state = ");
      ((StringBuilder)localObject).append(this.e);
      QLog.i("IliveRoomHeartController", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.c = paramLong;
    if ((this.b != 0L) && (c()))
    {
      ThreadCenter.removeDefaultUITask(this.f);
      long l = System.currentTimeMillis() - this.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportFinalHeartbeat realTS = ");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(" roomId = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.e("IliveRoomHeartController", 1, ((StringBuilder)localObject).toString());
      a(true, paramBoolean, l);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportFinalHeartbeat mEnterPageTime == 0 , roomId = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" enable = ");
    ((StringBuilder)localObject).append(c());
    QLog.i("IliveRoomHeartController", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.heart.IliveRoomHeartController
 * JD-Core Version:    0.7.0.1
 */