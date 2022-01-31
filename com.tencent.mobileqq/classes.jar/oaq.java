import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.MonitorValueRequest;

public final class oaq
  implements CmdTaskManger.CommandCallback
{
  public void a(@NonNull MonitorValueRequest paramMonitorValueRequest, @Nullable BaseResponse paramBaseResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail()) {
      SLog.b("Q.qqstory.MonitorReport", "send monitor fail %s", paramErrorMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oaq
 * JD-Core Version:    0.7.0.1
 */