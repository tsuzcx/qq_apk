package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketImplFactory;
import java.util.HashSet;

public class MonitorSocketImplFactory
  implements SocketImplFactory
{
  private static HashSet mServerSocketSet = new HashSet();
  public static final String tag = "MSF.D.MonitorSocket";
  Context context;
  Class socketClass = null;
  SocketImpl socketImpl;
  
  public static void addServerSocket(String paramString)
  {
    mServerSocketSet.add(paramString);
  }
  
  public static boolean isNetworkTypeMobile(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 5);
  }
  
  public static boolean isServerSocket(String paramString)
  {
    return mServerSocketSet.contains(paramString);
  }
  
  public static void removeServerSocket(String paramString)
  {
    mServerSocketSet.remove(paramString);
  }
  
  public SocketImpl createSocketImpl()
  {
    return new c(this.socketClass, this.context);
  }
  
  public boolean getMsfSocketImpl(Context paramContext)
  {
    try
    {
      this.context = paramContext;
      paramContext = new Socket();
      localObject = Socket.class.getDeclaredField("impl");
      ((Field)localObject).setAccessible(true);
      this.socketImpl = ((SocketImpl)((Field)localObject).get(paramContext));
      this.socketClass = this.socketImpl.getClass();
      paramContext = new StringBuilder();
      paramContext.append("Socket imple class: ");
      paramContext.append(this.socketClass.getName());
      QLog.i("MSF.D.MonitorSocket", 1, paramContext.toString());
      return true;
    }
    catch (Exception paramContext)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get SocketImpl failed ");
        ((StringBuilder)localObject).append(paramContext.getMessage());
        QLog.d("MSF.D.MonitorSocket", 2, ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketImplFactory
 * JD-Core Version:    0.7.0.1
 */