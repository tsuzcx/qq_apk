import android.content.Context;
import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.translate.TranslateClient;
import java.util.List;
import org.apache.http.Header;

public abstract class jcg
  extends TranslateClient
{
  public static void a(Context paramContext, Header[] paramArrayOfHeader, List paramList, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    a().a(paramContext, "https://www.googleapis.com/language/translate/v2", paramArrayOfHeader, paramList, paramAsyncHttpResponseHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     jcg
 * JD-Core Version:    0.7.0.1
 */