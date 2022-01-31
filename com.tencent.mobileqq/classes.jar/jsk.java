import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.qphone.base.util.QLog;

public class jsk
  implements Runnable
{
  public jsk(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.a.c, 1, "CheckRemoteCameraRunnable, 5s has past, 对方视频数据没来, mRecvVideoData[" + this.a.g + "], SessionType[" + localSessionInfo.d + "], shutCameraAnswer[" + localSessionInfo.i + "], cameraPermission[" + localSessionInfo.j + "]");
    if ((!this.a.g) && (localSessionInfo.d == 2))
    {
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(14, true);
      this.a.jdField_a_of_type_ComTencentAvVideoController.l(localSessionInfo.c);
      if ((localSessionInfo.i) || (!localSessionInfo.j))
      {
        localSessionInfo.d = 1;
        this.a.a("CheckRemoteCameraRunnable", 1);
      }
      this.a.ad();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jsk
 * JD-Core Version:    0.7.0.1
 */