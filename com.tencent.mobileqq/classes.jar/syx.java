import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;

class syx
  extends Job<Object, Object, Object>
{
  syx(syw paramsyw, String paramString, QQStoryCmdHandler.IllegalUinException paramIllegalUinException)
  {
    super(paramString);
  }
  
  public Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    ved.d("Q.qqstory.net:QQStoryCmdHandler", "uin convert error");
    this.jdField_a_of_type_Syw.a.a().a(880002, this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler$IllegalUinException.getMessage(), null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syx
 * JD-Core Version:    0.7.0.1
 */