import NS_KING_INTERFACE.stPostFeedDingRsp;
import android.os.Handler;
import android.util.Log;

public class slw
  extends sly
  implements slk
{
  public static String a = "weishi";
  
  public static void a(String paramString, boolean paramBoolean, int paramInt, Handler paramHandler)
  {
    int i = 1;
    if (!paramBoolean)
    {
      i = 2;
      Log.e(a, "此次是取消点赞：---------------");
    }
    paramString = new slv(new smx(paramString, i), paramHandler, new slx(paramHandler, paramInt), 4300);
    slo.a().a(paramString);
  }
  
  public void a(slv paramslv)
  {
    if ((paramslv.a instanceof stPostFeedDingRsp))
    {
      paramslv = (stPostFeedDingRsp)paramslv.a;
      if (paramslv == null)
      {
        Log.e(a, "服务器失败！！！");
        return;
      }
      if (paramslv.is_ding == 0)
      {
        Log.e(a, "没有点赞~~~~~~~~~~~~~~~~");
        return;
      }
      Log.e(a, "已经点赞~~~~~~~~~~~~~~~~");
      return;
    }
    Log.e(a, "真无语！！！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     slw
 * JD-Core Version:    0.7.0.1
 */