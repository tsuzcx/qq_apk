import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.6.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public final class tgc
  implements slx<szj, tbh>
{
  tgc(tgj paramtgj) {}
  
  public void a(@NonNull szj paramszj, @Nullable tbh paramtbh, @NonNull ErrorMessage paramErrorMessage)
  {
    ThreadManager.getUIHandler().post(new PlayModeUtils.6.1(this, paramtbh, paramErrorMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tgc
 * JD-Core Version:    0.7.0.1
 */