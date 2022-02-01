package cooperation.qqcircle.utils;

import android.content.Context;
import com.tencent.mobileqq.widget.QQToast;

public class ToastUtil
{
  private static final long CODE_IN_BLACK = 10023L;
  private static final long CODE_NO_UPDATE = 10022L;
  
  public static void determineShowByCode(long paramLong, Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramLong != 10022L) && (paramLong != 10023L)) {
      QQToast.a(paramContext, paramInt1, paramString, paramInt2).a();
    }
  }
  
  public static void determineShowByCode(long paramLong, Context paramContext, String paramString, int paramInt)
  {
    determineShowByCode(paramLong, paramContext, 0, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.utils.ToastUtil
 * JD-Core Version:    0.7.0.1
 */