import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.channel.NetworkRequest.IProtocolListener;
import com.tencent.biz.qqstory.support.logging.SLog;

public class mzz
  implements NetworkRequest.IProtocolListener
{
  protected final long a;
  public CmdTaskManger.CommandCallback a;
  public NetworkRequest a;
  
  public mzz(NetworkRequest paramNetworkRequest)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest = paramNetworkRequest;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void b(int paramInt, String paramString, BaseResponse paramBaseResponse)
  {
    CmdTaskManger.CommandCallback localCommandCallback = this.jdField_a_of_type_ComTencentBizQqstoryChannelCmdTaskManger$CommandCallback;
    if (localCommandCallback != null)
    {
      localCommandCallback.a(this.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest, paramBaseResponse, new ErrorMessage(paramInt, paramString));
      return;
    }
    SLog.d("Q.qqstory.net:CmdTaskManager", "cmd callback is null");
  }
  
  public void a(int paramInt, String paramString, BaseResponse paramBaseResponse)
  {
    b(paramInt, paramString, paramBaseResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzz
 * JD-Core Version:    0.7.0.1
 */