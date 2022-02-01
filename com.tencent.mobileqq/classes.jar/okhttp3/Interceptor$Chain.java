package okhttp3;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public abstract interface Interceptor$Chain
{
  public abstract Call call();
  
  public abstract int connectTimeoutMillis();
  
  @Nullable
  public abstract Connection connection();
  
  public abstract Response proceed(Request paramRequest);
  
  public abstract int readTimeoutMillis();
  
  public abstract Request request();
  
  public abstract Chain withConnectTimeout(int paramInt, TimeUnit paramTimeUnit);
  
  public abstract Chain withReadTimeout(int paramInt, TimeUnit paramTimeUnit);
  
  public abstract Chain withWriteTimeout(int paramInt, TimeUnit paramTimeUnit);
  
  public abstract int writeTimeoutMillis();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.Interceptor.Chain
 * JD-Core Version:    0.7.0.1
 */