import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.util.DisplayUtil;

public class pnk
{
  public static int a = 7;
  
  public static int a(Context paramContext)
  {
    if (pqt.j()) {
      return DisplayUtil.dip2px(paramContext, 8.0F);
    }
    return DisplayUtil.dip2px(paramContext, 3.0F);
  }
  
  public static void a(float paramFloat, Resources paramResources)
  {
    if ((paramFloat == 0.0F) || (paramResources == null)) {
      return;
    }
    a = (int)(paramFloat / paramResources.getDimensionPixelSize(2131298799) + 0.5F);
  }
  
  public static int[] a(Activity paramActivity)
  {
    Object localObject = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    int j;
    int i;
    if (Build.VERSION.SDK_INT >= 17)
    {
      ((Display)localObject).getRealSize(localPoint);
      j = localPoint.x;
      i = localPoint.y;
    }
    for (;;)
    {
      return new int[] { j, i };
      if (Build.VERSION.SDK_INT >= 15)
      {
        ((Display)localObject).getSize(localPoint);
        j = localPoint.x;
        i = localPoint.y;
      }
      else
      {
        localObject = new DisplayMetrics();
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        j = ((DisplayMetrics)localObject).widthPixels;
        i = ((DisplayMetrics)localObject).heightPixels;
      }
    }
  }
  
  public static int b(Context paramContext)
  {
    if (pqt.j()) {
      return DisplayUtil.dip2px(paramContext, 14.0F);
    }
    return DisplayUtil.dip2px(paramContext, 6.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnk
 * JD-Core Version:    0.7.0.1
 */