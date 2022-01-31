import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qphone.base.util.QLog;

class jsw
  implements Runnable
{
  jsw(jsv paramjsv, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Jsv.a.a != null) && (this.jdField_a_of_type_Jsv.a.a.a() != null))
    {
      QLog.d(this.jdField_a_of_type_Jsv.a.c, 1, "AsyncReadDoubleGlassConfig Timer lCurrent=" + this.jdField_a_of_type_Long + ", lLastTick=" + this.b + ", mCurrentVideoGlassWaitTime=" + this.jdField_a_of_type_Jsv.a.a.a().Q + ", mCurrentDefaultTimeOutRule=" + this.jdField_a_of_type_Jsv.a.a.a().R + ", mCurrentVideoGlassSwitch=" + this.jdField_a_of_type_Jsv.a.a.a().P);
      this.jdField_a_of_type_Jsv.a.k(this.jdField_a_of_type_Jsv.a.a.a().R);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jsw
 * JD-Core Version:    0.7.0.1
 */