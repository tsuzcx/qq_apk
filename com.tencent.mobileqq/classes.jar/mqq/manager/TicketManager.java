package mqq.manager;

import android.content.Context;
import android.os.Bundle;
import java.util.HashMap;
import mqq.app.TicketManagerListener;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;

public abstract interface TicketManager
  extends Manager
{
  public abstract String getA2(String paramString);
  
  public abstract byte[] getDA2(String paramString);
  
  public abstract Ticket getLocalTicket(String paramString, int paramInt);
  
  public abstract String getOpenSdkKey(String paramString, int paramInt);
  
  public abstract String getPskey(String paramString1, String paramString2);
  
  public abstract Ticket getPskey(String paramString, long paramLong, String[] paramArrayOfString, WtTicketPromise paramWtTicketPromise);
  
  public abstract String getPt4Token(String paramString1, String paramString2);
  
  public abstract String getSkey(String paramString);
  
  public abstract Ticket getSkey(String paramString, long paramLong, WtTicketPromise paramWtTicketPromise);
  
  public abstract byte[] getSt(String paramString, int paramInt);
  
  public abstract byte[] getStkey(String paramString, int paramInt);
  
  public abstract String getStweb(String paramString);
  
  public abstract String getSuperkey(String paramString);
  
  public abstract Ticket getTicket(String paramString, long paramLong, int paramInt, WtTicketPromise paramWtTicketPromise, Bundle paramBundle);
  
  public abstract String getVkey(String paramString);
  
  public abstract void registTicketManagerListener(TicketManagerListener paramTicketManagerListener);
  
  public abstract void reloadCache(Context paramContext);
  
  public abstract int sendRPCData(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt);
  
  public abstract void setAlterTicket(HashMap<String, String> paramHashMap);
  
  public abstract void unregistTicketManagerListener(TicketManagerListener paramTicketManagerListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.manager.TicketManager
 * JD-Core Version:    0.7.0.1
 */