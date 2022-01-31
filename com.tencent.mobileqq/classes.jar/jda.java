import com.rookery.asyncHttpClient.JsonHttpResponseHandler;
import com.rookery.translate.microsoft.MicrosoftTranslator;
import org.apache.http.Header;
import org.json.JSONObject;

public class jda
  extends JsonHttpResponseHandler
{
  public jda(MicrosoftTranslator paramMicrosoftTranslator, JsonHttpResponseHandler paramJsonHttpResponseHandler) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComRookeryAsyncHttpClientJsonHttpResponseHandler.a(paramInt, paramArrayOfHeader, paramJSONObject);
  }
  
  public void a(Throwable paramThrowable, String paramString)
  {
    this.jdField_a_of_type_ComRookeryAsyncHttpClientJsonHttpResponseHandler.a(paramThrowable, paramString);
    super.a(paramThrowable, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     jda
 * JD-Core Version:    0.7.0.1
 */