import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.smallscreen.SmallScreenVideoController;
import com.tencent.qphone.base.util.QLog;

class jpk
  implements Runnable
{
  jpk(jpj paramjpj, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Jpj.a.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      AVLog.e("SmallScreenVideoController", "mVideoController is null");
      return;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_Jpj.a.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localSessionInfo != null)
    {
      QLog.d("SmallScreenVideoController", 1, "AsyncReadDoubleGlassConfig Timer lCurrent=" + this.jdField_a_of_type_Long + ", lLastTick=" + this.b + ", mCurrentVideoGlassWaitTime=" + localSessionInfo.Q + ", mCurrentDefaultTimeOutRule=" + localSessionInfo.R + ", mCurrentVideoGlassSwitch=" + this.jdField_a_of_type_Jpj.a.jdField_a_of_type_Int);
      this.jdField_a_of_type_Jpj.a.b(localSessionInfo.R);
      return;
    }
    AVLog.e("SmallScreenVideoController", "AsyncReadDoubleGlassConfig Timer lCurrent=" + this.jdField_a_of_type_Long + ", lLastTick=" + this.b + ", sessionInfo is null, mCurrentVideoGlassSwitch=" + this.jdField_a_of_type_Jpj.a.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jpk
 * JD-Core Version:    0.7.0.1
 */