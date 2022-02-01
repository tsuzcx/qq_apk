package okhttp3;

import java.io.IOException;

public abstract interface Callback
{
  public abstract void onFailure(Call paramCall, IOException paramIOException);
  
  public abstract void onResponse(Call paramCall, Response paramResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.Callback
 * JD-Core Version:    0.7.0.1
 */