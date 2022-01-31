import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.Map;

public class nbq
  extends SimpleJob
{
  public nbq(QQStoryCmdHandler paramQQStoryCmdHandler, Bundle paramBundle, byte[] paramArrayOfByte) {}
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("storySeq");
    paramJobContext = (NetworkRequest)QQStoryCmdHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler).remove(Integer.valueOf(i));
    if (paramJobContext == null)
    {
      SLog.d("Q.qqstory.net:QQStoryCmdHandler", "can't find request");
      return null;
    }
    QQStoryCmdHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler, paramJobContext, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_AndroidOsBundle);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbq
 * JD-Core Version:    0.7.0.1
 */