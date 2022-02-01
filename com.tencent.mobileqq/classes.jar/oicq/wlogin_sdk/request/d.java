package oicq.wlogin_sdk.request;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import oicq.wlogin_sdk.tools.ErrMsg;

public class d
  extends Thread
{
  Runnable a = new e(this);
  private Context b;
  private ErrMsg c;
  
  public d(Context paramContext, ErrMsg paramErrMsg)
  {
    this.b = paramContext;
    a(paramErrMsg);
  }
  
  public void a(ErrMsg paramErrMsg)
  {
    if (paramErrMsg != null) {
      try
      {
        this.c = ((ErrMsg)paramErrMsg.clone());
        return;
      }
      catch (CloneNotSupportedException paramErrMsg)
      {
        paramErrMsg.printStackTrace();
        this.c = null;
        return;
      }
    }
    this.c = null;
  }
  
  public void run()
  {
    new Handler(Looper.getMainLooper()).post(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.d
 * JD-Core Version:    0.7.0.1
 */