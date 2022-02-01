import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.funchat.zimu.ZimuView;
import com.tencent.av.ui.funchat.zimu.ZimuViewFilm;
import com.tencent.av.ui.funchat.zimu.ZimuViewPacMan;
import com.tencent.av.ui.funchat.zimu.ZimuViewRibon;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mof
{
  public static ZimuView a(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, String paramString)
  {
    if (AudioHelper.f()) {
      QLog.w("ZimuViewFactory", 1, "create, id[" + paramString + "], seq[" + paramLong + "]");
    }
    if ("ribbon".equals(paramString)) {
      paramVideoAppInterface = new ZimuViewRibon(paramLong, paramVideoAppInterface, paramContext, null);
    }
    for (;;)
    {
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.b();
      }
      return paramVideoAppInterface;
      if ("pacman".equals(paramString)) {
        paramVideoAppInterface = new ZimuViewPacMan(paramLong, paramVideoAppInterface, paramContext, null);
      } else if ("film".equals(paramString)) {
        paramVideoAppInterface = new ZimuViewFilm(paramLong, paramVideoAppInterface, paramContext, null);
      } else {
        paramVideoAppInterface = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mof
 * JD-Core Version:    0.7.0.1
 */