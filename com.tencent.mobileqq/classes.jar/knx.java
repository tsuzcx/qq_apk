import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.now.CgiHelper;
import com.tencent.biz.now.CgiHelper.cigHelperCallback;

public class knx
  extends Handler
{
  public knx(CgiHelper paramCgiHelper) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1001) && (CgiHelper.a(this.a) != null))
    {
      paramMessage = CgiHelper.a(this.a);
      if (TextUtils.isEmpty(CgiHelper.a(this.a))) {
        break label58;
      }
    }
    label58:
    for (boolean bool = true;; bool = false)
    {
      paramMessage.a(bool, CgiHelper.b(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     knx
 * JD-Core Version:    0.7.0.1
 */