import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class ljs
{
  public static ljo a(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, String paramString)
  {
    VideoAppInterface localVideoAppInterface = null;
    if (AudioHelper.e()) {
      QLog.w("ARZimuTaskFactory", 1, "create, id[" + paramString + "], seq[" + paramLong + "]");
    }
    if ("spit".equals(paramString))
    {
      paramVideoAppInterface = new ljx(paramLong, paramVideoAppInterface);
      localVideoAppInterface = paramVideoAppInterface;
      if ((paramContext instanceof ljy))
      {
        ((ljx)paramVideoAppInterface).a((ljy)paramContext);
        localVideoAppInterface = paramVideoAppInterface;
      }
    }
    return localVideoAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljs
 * JD-Core Version:    0.7.0.1
 */