import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class rzl
{
  private static rzl jdField_a_of_type_Rzl;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new rzm(this, "Module_VideoFeedsIPCServer");
  private List<rzn> jdField_a_of_type_JavaUtilList = new Vector();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  private rzl()
  {
    QIPCClientHelper.getInstance().register(this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule);
    a();
  }
  
  public static rzl a()
  {
    if (jdField_a_of_type_Rzl == null) {}
    try
    {
      jdField_a_of_type_Rzl = new rzl();
      return jdField_a_of_type_Rzl;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilSet.add("CMD_SHORTVIDEO_REQUEST_MANUAL_DOWNLOAD");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_SHORTVIDEO_REQUEST_CLEAR");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_SHORTVIDEO_UPDATE_MSG_BY_UNISEQ");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_HANDLE_FORWARD_DATA");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_INIT_READINJOY_MANAGER");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_FOLLOW_PUB_ACCOUNT");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS_SET");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_COMFIRM_VIDEO_PLAY_NEED_ALERT_IN_XG");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_NETWORK_CHANGE");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_IGNORE_VOLUME_CHANGE");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_CANCEL_IGNORE_VOLUME_CHANGE");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_CAMERA_CAPTURE_SO_DOWNLOAD");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_GET_NICK_NAME_BY_UIN_CANCLE");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_REPORT_START_TIME");
    this.jdField_a_of_type_JavaUtilSet.add("CMD_SET_VIDEO_LATEST_BRIGHTNESS");
  }
  
  public Bundle a(String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {
      QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", paramString, paramBundle, null);
    }
    do
    {
      return null;
      paramString = QIPCClientHelper.getInstance().getClient().callServer("Module_VideoFeedsIPCServer", paramString, paramBundle);
    } while ((paramString == null) || (!paramString.isSuccess()));
    return paramString.data;
  }
  
  public void a(rzn paramrzn)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramrzn);
      return;
    }
  }
  
  public void b(rzn paramrzn)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramrzn);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzl
 * JD-Core Version:    0.7.0.1
 */