import android.support.annotation.Nullable;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocketCall;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.VWebSocketAdapter;
import com.tencent.viola.adapter.VWebSocketAdapter.EventListener;
import com.tencent.viola.adapter.WebSocketCloseCodes;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class rjy
  implements VWebSocketAdapter
{
  public static String a;
  private WebSocket jdField_a_of_type_ComSquareupOkhttpWsWebSocket;
  private VWebSocketAdapter.EventListener jdField_a_of_type_ComTencentViolaAdapterVWebSocketAdapter$EventListener;
  
  static
  {
    jdField_a_of_type_JavaLangString = "viola.SimpleWebSocketAdapter";
  }
  
  public void close(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComSquareupOkhttpWsWebSocket != null) {}
    try
    {
      this.jdField_a_of_type_ComSquareupOkhttpWsWebSocket.close(paramInt, paramString);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "close Exception:" + paramString.getMessage());
    }
  }
  
  public void connect(String paramString1, @Nullable String paramString2, VWebSocketAdapter.EventListener paramEventListener)
  {
    this.jdField_a_of_type_ComTencentViolaAdapterVWebSocketAdapter$EventListener = paramEventListener;
    paramEventListener = new OkHttpClient();
    paramEventListener.setConnectTimeout(3600L, TimeUnit.SECONDS);
    paramEventListener.setReadTimeout(3600L, TimeUnit.SECONDS);
    paramEventListener.setWriteTimeout(3600L, TimeUnit.SECONDS);
    Object localObject = new Request.Builder();
    if (paramString2 != null) {
      ((Request.Builder)localObject).addHeader("Sec-WebSocket-Protocol", paramString2);
    }
    ((Request.Builder)localObject).url(paramString1);
    paramString1 = WebSocketCall.create(paramEventListener, ((Request.Builder)localObject).build());
    try
    {
      paramString2 = WebSocketCall.class.getDeclaredField("request");
      paramString2.setAccessible(true);
      paramString2 = ((Request)paramString2.get(paramString1)).headers();
      paramEventListener = new HashMap();
      localObject = paramString2.names().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        paramEventListener.put(str, paramString2.values(str).toString());
      }
      return;
    }
    catch (Exception paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "connect Exception:" + paramString2.getMessage());
      }
      paramString2.printStackTrace();
      paramString1.enqueue(new rjz(this));
    }
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_ComSquareupOkhttpWsWebSocket != null) {}
    try
    {
      this.jdField_a_of_type_ComSquareupOkhttpWsWebSocket.close(WebSocketCloseCodes.CLOSE_GOING_AWAY.getCode(), WebSocketCloseCodes.CLOSE_GOING_AWAY.name());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "destroy Exception" + localException.getMessage());
    }
  }
  
  public void disconnect() {}
  
  public void send(String paramString)
  {
    if (this.jdField_a_of_type_ComSquareupOkhttpWsWebSocket != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        MediaType localMediaType = MediaType.parse("application/vnd.okhttp.websocket+text; charset=utf-8");
        MediaType.parse("application/vnd.okhttp.websocket+binary");
        this.jdField_a_of_type_ComSquareupOkhttpWsWebSocket.sendMessage(RequestBody.create(localMediaType, paramString));
        if (QLog.isDebugVersion()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "send data:" + paramString);
        }
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "send Exception:" + paramString.getMessage());
        }
        paramString.printStackTrace();
        return;
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "send ws is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rjy
 * JD-Core Version:    0.7.0.1
 */