import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public abstract class mao
{
  public static void a(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    QLog.w("NewTipsManager", 1, "hideAllTips, seq[" + paramLong + "]");
    ((ljf)paramVideoAppInterface.a(11)).b();
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    ((ljf)paramVideoAppInterface.a(11)).c();
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    ((ljf)paramVideoAppInterface.a(11)).a(paramInt);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, boolean paramBoolean) {}
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((ljf)paramVideoAppInterface.a(11)).a(paramInt);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return a(paramVideoAppInterface, paramInt1, paramVideoAppInterface.getApp().getString(paramInt2));
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, long paramLong)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((ljf)paramVideoAppInterface.a(11)).a(paramInt, paramLong);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, String paramString)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((ljf)paramVideoAppInterface.a(11)).a(paramInt, paramString);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((ljf)paramVideoAppInterface.a(11)).a(paramInt1, paramString, paramDrawable, paramInt2, paramOnClickListener);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((ljf)paramVideoAppInterface.a(11)).a(paramInt, paramString, null, -1, paramOnClickListener);
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    ((ljf)paramVideoAppInterface.a(11)).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mao
 * JD-Core Version:    0.7.0.1
 */