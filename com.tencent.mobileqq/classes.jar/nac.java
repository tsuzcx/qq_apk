import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.channel.NetworkRequest.IProtocolListener;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;

public class nac
  extends Job
{
  public nac(QQStoryCmdHandler paramQQStoryCmdHandler, NetworkRequest paramNetworkRequest) {}
  
  protected Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a().a(880001, "no network", null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nac
 * JD-Core Version:    0.7.0.1
 */