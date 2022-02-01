package cooperation.ilive.lite.heart;

import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent.PlayerState;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.config.IliveManagerCfgBean;
import cooperation.ilive.config.IliveManagerConfProcessor;
import cooperation.ilive.lite.report.IliveLiteDataReport;

public class IliveRoomHeartController
{
  private int jdField_a_of_type_Int = 1001;
  private long jdField_a_of_type_Long;
  private PlayerStateEvent.PlayerState jdField_a_of_type_ComTencentIliveAudiencepagesRoomEventsPlayerStateEvent$PlayerState;
  private Runnable jdField_a_of_type_JavaLangRunnable = new IliveRoomHeartController.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private long b;
  
  private int a()
  {
    if (this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomEventsPlayerStateEvent$PlayerState == null) {
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getReportPlayerState = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomEventsPlayerStateEvent$PlayerState.toString());
    QLog.e("IliveRoomHeartController", 1, localStringBuilder.toString());
    if ((this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomEventsPlayerStateEvent$PlayerState != PlayerStateEvent.PlayerState.PLAY_ERROR) && (this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomEventsPlayerStateEvent$PlayerState != PlayerStateEvent.PlayerState.PLAY_COMPLETED)) {
      return 1;
    }
    return 3;
  }
  
  private long a()
  {
    IliveManagerCfgBean localIliveManagerCfgBean = IliveManagerConfProcessor.a();
    if ((localIliveManagerCfgBean != null) && (localIliveManagerCfgBean.a() > 0L)) {
      return localIliveManagerCfgBean.a();
    }
    return 5000L;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleReport currentRealTS = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" mCurrentRoomId = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" intervalTime = ");
    localStringBuilder.append(a());
    QLog.e("IliveRoomHeartController", 1, localStringBuilder.toString());
    IliveLiteDataReport.a().a(this.b, this.jdField_a_of_type_Int, a(), paramLong, paramBoolean1, paramBoolean2);
  }
  
  private boolean a()
  {
    IliveManagerCfgBean localIliveManagerCfgBean = IliveManagerConfProcessor.a();
    if (localIliveManagerCfgBean != null) {
      return localIliveManagerCfgBean.c();
    }
    return true;
  }
  
  public void a()
  {
    QLog.i("IliveRoomHeartController", 1, "stopReportHeartBeat");
    ThreadCenter.removeDefaultUITask(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start reportHeartbeat roomId = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" mEnterPageTime = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    QLog.e("IliveRoomHeartController", 1, localStringBuilder.toString());
    if (!a())
    {
      QLog.e("IliveRoomHeartController", 1, " reportHeartbeat disable");
      return;
    }
    ThreadCenter.removeDefaultUITask(this.jdField_a_of_type_JavaLangRunnable);
    ThreadCenter.postDefaultUITask(this.jdField_a_of_type_JavaLangRunnable, a());
  }
  
  public void a(PlayerStateEvent.PlayerState paramPlayerState)
  {
    this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomEventsPlayerStateEvent$PlayerState = paramPlayerState;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomEventsPlayerStateEvent$PlayerState;
    if ((localObject != null) && ((localObject == PlayerStateEvent.PlayerState.PLAY_COMPLETED) || (this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomEventsPlayerStateEvent$PlayerState == PlayerStateEvent.PlayerState.PLAY_ERROR)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportFinalHeartbeat cancel , current player state = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomEventsPlayerStateEvent$PlayerState);
      QLog.i("IliveRoomHeartController", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.b = paramLong;
    if ((this.jdField_a_of_type_Long != 0L) && (a()))
    {
      ThreadCenter.removeDefaultUITask(this.jdField_a_of_type_JavaLangRunnable);
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
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
    ((StringBuilder)localObject).append(a());
    QLog.i("IliveRoomHeartController", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.heart.IliveRoomHeartController
 * JD-Core Version:    0.7.0.1
 */