package mqq.observer;

import android.os.Bundle;
import mqq.app.Constants.Action;

public abstract class TicketObserver
  implements Constants.Action, BusinessObserver
{
  public void onChangeTicket(String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    onChangeTicket(paramBundle.getString("uin"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.observer.TicketObserver
 * JD-Core Version:    0.7.0.1
 */