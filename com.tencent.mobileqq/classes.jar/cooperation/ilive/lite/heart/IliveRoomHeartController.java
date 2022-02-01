package cooperation.ilive.lite.heart;

import com.tencent.falco.utils.ThreadCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.config.IliveManagerCfgBean;
import cooperation.ilive.config.IliveManagerConfProcessor;
import cooperation.ilive.lite.report.IliveLiteDataReport;

public class IliveRoomHeartController
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private Runnable jdField_a_of_type_JavaLangRunnable = new IliveRoomHeartController.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private long b;
  
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
    QLog.e("IliveRoomHeartController", 1, "handleReport currentRealTS = " + paramLong + " mCurrentRoomId = " + this.b + " intervalTime = " + a());
    IliveLiteDataReport.a().a(this.b, this.jdField_a_of_type_Int, paramLong, paramBoolean1, paramBoolean2);
  }
  
  private boolean a()
  {
    IliveManagerCfgBean localIliveManagerCfgBean = IliveManagerConfProcessor.a();
    if (localIliveManagerCfgBean != null) {
      return localIliveManagerCfgBean.a();
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
    QLog.e("IliveRoomHeartController", 1, "start reportHeartbeat roomId = " + paramLong + " mEnterPageTime = " + this.jdField_a_of_type_Long);
    if (!a())
    {
      QLog.e("IliveRoomHeartController", 1, " reportHeartbeat disable");
      return;
    }
    ThreadCenter.removeDefaultUITask(this.jdField_a_of_type_JavaLangRunnable);
    ThreadCenter.postDefaultUITask(this.jdField_a_of_type_JavaLangRunnable, a());
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    this.b = paramLong;
    if ((this.jdField_a_of_type_Long == 0L) || (!a()))
    {
      QLog.i("IliveRoomHeartController", 1, "reportFinalHeartbeat mEnterPageTime == 0 , roomId = " + paramLong + " enable = " + a());
      return;
    }
    ThreadCenter.removeDefaultUITask(this.jdField_a_of_type_JavaLangRunnable);
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.e("IliveRoomHeartController", 1, "reportFinalHeartbeat realTS = " + l + " roomId = " + paramLong);
    a(true, paramBoolean, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.heart.IliveRoomHeartController
 * JD-Core Version:    0.7.0.1
 */