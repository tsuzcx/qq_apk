import NS_KING_INTERFACE.stPostFeedDingRsp;
import android.os.Handler;
import android.util.Log;

public class slt
  extends slv
  implements slh
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
    paramString = new sls(new smu(paramString, i), paramHandler, new slu(paramHandler, paramInt), 4300);
    sll.a().a(paramString);
  }
  
  public void a(sls paramsls)
  {
    if ((paramsls.a instanceof stPostFeedDingRsp))
    {
      paramsls = (stPostFeedDingRsp)paramsls.a;
      if (paramsls == null)
      {
        Log.e(a, "服务器失败！！！");
        return;
      }
      if (paramsls.is_ding == 0)
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
 * Qualified Name:     slt
 * JD-Core Version:    0.7.0.1
 */