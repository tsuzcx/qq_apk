package oicq.wlogin_sdk.request;

import android.content.Context;
import oicq.wlogin_sdk.tools.util;

public class g
  extends Thread
{
  private Context a;
  
  public g(Context paramContext)
  {
    this.a = paramContext;
    setName("Wtlogin_CleanThread");
  }
  
  public void run()
  {
    util.deleteExpireLog(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.request.g
 * JD-Core Version:    0.7.0.1
 */