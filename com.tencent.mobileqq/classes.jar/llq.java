import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class llq
{
  public static llm a(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, String paramString)
  {
    VideoAppInterface localVideoAppInterface = null;
    if (AudioHelper.e()) {
      QLog.w("ARZimuTaskFactory", 1, "create, id[" + paramString + "], seq[" + paramLong + "]");
    }
    if ("spit".equals(paramString))
    {
      paramVideoAppInterface = new llv(paramLong, paramVideoAppInterface);
      localVideoAppInterface = paramVideoAppInterface;
      if ((paramContext instanceof llw))
      {
        ((llv)paramVideoAppInterface).a((llw)paramContext);
        localVideoAppInterface = paramVideoAppInterface;
      }
    }
    return localVideoAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     llq
 * JD-Core Version:    0.7.0.1
 */