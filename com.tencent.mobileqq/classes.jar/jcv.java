import android.content.Context;
import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.translate.TranslateClient;
import java.util.List;
import org.apache.http.Header;

public abstract class jcv
  extends TranslateClient
{
  public static void a(Context paramContext, Header[] paramArrayOfHeader, List paramList, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    a().a(paramContext, "https://www.googleapis.com/language/translate/v2", paramArrayOfHeader, paramList, paramAsyncHttpResponseHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     jcv
 * JD-Core Version:    0.7.0.1
 */