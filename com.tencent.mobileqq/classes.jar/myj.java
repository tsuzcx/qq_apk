import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.base.VideoServerInfoManager.ServerInfo;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.RefreshVideoFileKeyRequest;
import com.tencent.biz.qqstory.network.response.RefreshVideoFileKeyResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class myj
  implements CmdTaskManger.CommandCallback
{
  public myj(VideoServerInfoManager paramVideoServerInfoManager) {}
  
  public void a(RefreshVideoFileKeyRequest arg1, RefreshVideoFileKeyResponse paramRefreshVideoFileKeyResponse, ErrorMessage paramErrorMessage)
  {
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess()) {}
    for (;;)
    {
      synchronized (this.a.jdField_b_of_type_JavaLangObject)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo = paramRefreshVideoFileKeyResponse.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo;
        this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo.a();
        SLog.b("Q.qqstory.publish:VideoServerInfoManager", "get server inf %s", this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo);
        this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        this.a.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
        paramRefreshVideoFileKeyResponse = finally;
        throw paramRefreshVideoFileKeyResponse;
        SLog.b("Q.qqstory.publish:VideoServerInfoManager", "get server info:%s", paramErrorMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myj
 * JD-Core Version:    0.7.0.1
 */