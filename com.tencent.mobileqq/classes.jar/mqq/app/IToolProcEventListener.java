package mqq.app;

import android.content.Intent;

public abstract interface IToolProcEventListener
{
  public abstract void onBeforeExitProc();
  
  public abstract boolean onReceiveAccountAction(String paramString, Intent paramIntent);
  
  public abstract boolean onReceiveLegalExitProcAction(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.IToolProcEventListener
 * JD-Core Version:    0.7.0.1
 */