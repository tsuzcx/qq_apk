import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.channel.NetworkRequest.IProtocolListener;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;

class nae
  extends Job
{
  nae(nad paramnad, QQStoryCmdHandler.IllegalUinException paramIllegalUinException) {}
  
  protected Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    SLog.d("Q.qqstory.net:QQStoryCmdHandler", "uin convert error");
    this.jdField_a_of_type_Nad.a.a().a(880002, this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler$IllegalUinException.getMessage(), null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nae
 * JD-Core Version:    0.7.0.1
 */