import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class syz
  extends SimpleJob<Void>
{
  public syz(QQStoryCmdHandler paramQQStoryCmdHandler, String paramString, sys paramsys)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler.a(this.jdField_a_of_type_Sys);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syz
 * JD-Core Version:    0.7.0.1
 */