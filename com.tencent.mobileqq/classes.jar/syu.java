import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.UIThreadCallback.1;

public abstract class syu<Request extends syv, Respond extends syq>
  implements syt<Request, Respond>
{
  public static Handler a = new Handler(Looper.getMainLooper());
  
  public void a(@NonNull Request paramRequest, @Nullable Respond paramRespond, @NonNull ErrorMessage paramErrorMessage)
  {
    if (Thread.currentThread() == a.getLooper().getThread())
    {
      b(paramRequest, paramRespond, paramErrorMessage);
      return;
    }
    a.post(new CmdTaskManger.UIThreadCallback.1(this, paramRequest, paramRespond, paramErrorMessage));
  }
  
  public abstract void b(@NonNull Request paramRequest, @Nullable Respond paramRespond, @NonNull ErrorMessage paramErrorMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syu
 * JD-Core Version:    0.7.0.1
 */