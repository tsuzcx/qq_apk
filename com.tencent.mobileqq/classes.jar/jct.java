import android.content.Context;
import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.translate.TranslateClient;

public class jct
  extends TranslateClient
{
  public static void a(Context paramContext, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    a().a(paramContext, "http://passport.imqq.com/App/MobileQQ/ChangeTrans.html", null, null, new jcu(paramAsyncHttpResponseHandler));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     jct
 * JD-Core Version:    0.7.0.1
 */