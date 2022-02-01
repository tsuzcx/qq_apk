import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class ljb
{
  public static lix a(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, String paramString)
  {
    VideoAppInterface localVideoAppInterface = null;
    if (AudioHelper.f()) {
      QLog.w("ARZimuTaskFactory", 1, "create, id[" + paramString + "], seq[" + paramLong + "]");
    }
    if ("spit".equals(paramString))
    {
      paramVideoAppInterface = new ljg(paramLong, paramVideoAppInterface);
      localVideoAppInterface = paramVideoAppInterface;
      if ((paramContext instanceof ljh))
      {
        ((ljg)paramVideoAppInterface).a((ljh)paramContext);
        localVideoAppInterface = paramVideoAppInterface;
      }
    }
    return localVideoAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljb
 * JD-Core Version:    0.7.0.1
 */