import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

public class kzg
{
  private Handler a;
  
  public kzg()
  {
    if (Looper.myLooper() != null) {
      this.a = new kzh(this);
    }
  }
  
  protected Message a(int paramInt, Object paramObject)
  {
    if (this.a != null) {
      return this.a.obtainMessage(paramInt, paramObject);
    }
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    localMessage.obj = paramObject;
    return localMessage;
  }
  
  public void a() {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, String paramString) {}
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      paramMessage = (Object[])paramMessage.obj;
      c(((Integer)paramMessage[0]).intValue(), (Header[])paramMessage[1], (String)paramMessage[2]);
      return;
    case 1: 
      paramMessage = (Object[])paramMessage.obj;
      c((Throwable)paramMessage[0], (String)paramMessage[1]);
      return;
    case 2: 
      a();
      return;
    }
    b();
  }
  
  public void a(Throwable paramThrowable, String paramString) {}
  
  public void a(Throwable paramThrowable, byte[] paramArrayOfByte)
  {
    b(a(1, new Object[] { paramThrowable, paramArrayOfByte }));
  }
  
  public void a(HttpResponse paramHttpResponse)
  {
    Object localObject3 = null;
    StatusLine localStatusLine = paramHttpResponse.getStatusLine();
    try
    {
      HttpEntity localHttpEntity = paramHttpResponse.getEntity();
      localObject1 = localObject3;
      if (localHttpEntity != null) {
        localObject1 = EntityUtils.toString(new BufferedHttpEntity(localHttpEntity), "UTF-8");
      }
    }
    catch (IOException localIOException)
    {
      Object localObject2;
      for (;;)
      {
        Object localObject1;
        b(localIOException, (String)null);
        localObject2 = localObject3;
      }
      b(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), localObject2);
    }
    if (localStatusLine.getStatusCode() >= 300)
    {
      b(new HttpResponseException(localStatusLine.getStatusCode(), localStatusLine.getReasonPhrase()), (String)localObject1);
      return;
    }
  }
  
  public void b() {}
  
  protected void b(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    b(a(0, new Object[] { new Integer(paramInt), paramArrayOfHeader, paramString }));
  }
  
  protected void b(Message paramMessage)
  {
    if (this.a != null)
    {
      this.a.sendMessage(paramMessage);
      return;
    }
    a(paramMessage);
  }
  
  public void b(Throwable paramThrowable, String paramString)
  {
    b(a(1, new Object[] { paramThrowable, paramString }));
  }
  
  public void c()
  {
    b(a(2, null));
  }
  
  protected void c(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    a(paramInt, paramArrayOfHeader, paramString);
  }
  
  protected void c(Throwable paramThrowable, String paramString)
  {
    a(paramThrowable, paramString);
  }
  
  public void d()
  {
    b(a(3, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kzg
 * JD-Core Version:    0.7.0.1
 */