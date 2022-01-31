import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class kzc
{
  public static kyy a(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, String paramString)
  {
    VideoAppInterface localVideoAppInterface = null;
    if (AudioHelper.e()) {
      QLog.w("ARZimuTaskFactory", 1, "create, id[" + paramString + "], seq[" + paramLong + "]");
    }
    if ("spit".equals(paramString))
    {
      paramVideoAppInterface = new kzh(paramLong, paramVideoAppInterface);
      localVideoAppInterface = paramVideoAppInterface;
      if ((paramContext instanceof kzi))
      {
        ((kzh)paramVideoAppInterface).a((kzi)paramContext);
        localVideoAppInterface = paramVideoAppInterface;
      }
    }
    return localVideoAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kzc
 * JD-Core Version:    0.7.0.1
 */