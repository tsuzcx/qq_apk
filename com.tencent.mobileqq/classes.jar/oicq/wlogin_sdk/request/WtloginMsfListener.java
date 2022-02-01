package oicq.wlogin_sdk.request;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import oicq.wlogin_sdk.tools.util;

public class WtloginMsfListener
  implements Runnable
{
  public static String CLIENT_CLASSNAME = "com.tencent.mobileqq.msf.core.auth.WtProvider";
  static Object TicketMgr;
  private static final Object __SyncCB;
  private static final Object __SyncSeq = new Object();
  private static Map<Long, WtloginMsfListener> __cbs = new HashMap();
  private static long __seq;
  private byte[] data;
  private boolean flag;
  private int ret;
  private byte[] ret_data = null;
  private String ret_serviceCmd;
  private boolean ret_success = false;
  private String ret_uin;
  private final Semaphore semp = new Semaphore(1);
  private String serviceCmd;
  private int timeout;
  private String uin;
  private WUserSigInfo userSigInfo;
  
  static
  {
    __SyncCB = new Object();
    __seq = 0L;
  }
  
  public WtloginMsfListener(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, WUserSigInfo paramWUserSigInfo)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "0";
    }
    this.uin = str;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.serviceCmd = paramString1;
    paramString1 = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramString1 = new byte[0];
    }
    this.data = paramString1;
    if (paramInt <= 0) {
      paramInt = 5000;
    }
    this.timeout = paramInt;
    this.flag = paramBoolean;
    this.userSigInfo = paramWUserSigInfo;
  }
  
  private static long allocateSeq()
  {
    synchronized (__SyncSeq)
    {
      long l = __seq + 1L;
      __seq = l;
      return l % 2147483647L;
    }
  }
  
  public static void onAsyncReceive(String paramString1, String paramString2, long paramLong, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rpc receive ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" seq: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" data:");
    if (paramArrayOfByte == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(paramArrayOfByte.length);
    }
    localStringBuilder.append(localObject);
    util.LOGI(localStringBuilder.toString(), paramString1);
    Object localObject = pickSeq(paramLong);
    if (localObject != null) {
      ((WtloginMsfListener)localObject).onReceiveData(paramString1, paramString2, paramArrayOfByte);
    }
  }
  
  public static void onAsyncReceiveFail(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("rpc receive ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" seq: ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" fail:");
    ((StringBuilder)localObject).append(paramInt);
    util.LOGI(((StringBuilder)localObject).toString(), paramString1);
    localObject = pickSeq(paramLong);
    if (localObject != null) {
      ((WtloginMsfListener)localObject).onReceiveFail(paramString1, paramString2, paramInt);
    }
  }
  
  private static WtloginMsfListener pickSeq(long paramLong)
  {
    synchronized (__SyncCB)
    {
      WtloginMsfListener localWtloginMsfListener = (WtloginMsfListener)__cbs.get(Long.valueOf(paramLong));
      __cbs.remove(Long.valueOf(paramLong));
      return localWtloginMsfListener;
    }
  }
  
  private int sendRPCData(byte[] arg1, int paramInt)
  {
    long l = allocateSeq();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("sendRPCData seq: ");
    ((StringBuilder)localObject1).append(l);
    util.LOGI(((StringBuilder)localObject1).toString(), "");
    try
    {
      localObject1 = Class.forName("mqq.manager.TicketManager");
      if (TicketMgr == null)
      {
        Object localObject4 = Class.forName("com.tencent.common.app.BaseApplicationImpl");
        Object localObject5 = Class.forName("mqq.app.BaseActivity");
        Class localClass = Class.forName("mqq.app.AppRuntime");
        Object localObject3 = ((Class)localObject4).getMethod("getApplication", new Class[0]);
        Method localMethod = ((Class)localObject4).getMethod("waitAppRuntime", new Class[] { localObject5 });
        localObject4 = localClass.getMethod("getManager", new Class[] { Integer.TYPE });
        localObject5 = localClass.getField("TICKET_MANAGER");
        localObject3 = ((Method)localObject3).invoke(null, new Object[0]);
        if (localObject3 != null)
        {
          localObject3 = localMethod.invoke(localObject3, new Object[] { null });
          if (localObject3 != null) {
            TicketMgr = ((Method)localObject4).invoke(localObject3, new Object[] { ((Field)localObject5).get(localClass) });
          }
        }
      }
      int i = Integer.valueOf(((Class)localObject1).getMethod("sendRPCData", new Class[] { Long.TYPE, String.class, String.class, [B.class, Integer.TYPE }).invoke(TicketMgr, new Object[] { Long.valueOf(l), this.uin, this.serviceCmd, ???.clone(), Integer.valueOf(paramInt) }).toString()).intValue();
      paramInt = i;
      if (i == 0) {
        synchronized (__SyncCB)
        {
          __cbs.put(Long.valueOf(l), this);
          this.semp.acquire();
          return 99;
        }
      }
      return paramInt;
    }
    catch (Exception ???)
    {
      util.printException(???, this.uin);
      paramInt = -1000;
    }
  }
  
  public void Cancel()
  {
    try
    {
      Class localClass = Class.forName(CLIENT_CLASSNAME);
      localClass.getMethod("cancel", new Class[] { WUserSigInfo.class }).invoke(localClass, new Object[] { this.userSigInfo });
      return;
    }
    catch (Exception localException)
    {
      util.printException(localException, this.uin);
    }
  }
  
  public byte[] RecvData()
  {
    try
    {
      this.semp.acquire();
      if (!this.ret_success) {
        return null;
      }
      String str2 = this.ret_uin;
      String str1 = "null";
      if ((str2 != null) && (this.ret_uin.equals(this.uin)))
      {
        if ((this.ret_serviceCmd != null) && (this.ret_serviceCmd.equals(this.serviceCmd)))
        {
          this.semp.release();
          return this.ret_data;
        }
        this.ret = -1009;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ret_serviceCmd: ");
        if (this.ret_serviceCmd == null) {
          str2 = "null";
        } else {
          str2 = this.ret_serviceCmd;
        }
        localStringBuilder.append(str2);
        localStringBuilder.append(", serviceCmd:");
        if (this.serviceCmd != null) {
          str1 = this.serviceCmd;
        }
        localStringBuilder.append(str1);
        util.LOGI(localStringBuilder.toString(), "");
        return null;
      }
      this.ret = -1009;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ret_uin: ");
      if (this.ret_uin == null) {
        str2 = "null";
      } else {
        str2 = this.ret_uin;
      }
      localStringBuilder.append(str2);
      localStringBuilder.append(", uin: ");
      if (this.uin != null) {
        str1 = this.uin;
      }
      localStringBuilder.append(str1);
      util.LOGI(localStringBuilder.toString(), "");
      return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      util.printException(localInterruptedException, this.uin);
    }
    return null;
  }
  
  public int SendData(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject;
    if (!t.ax)
    {
      localObject = t.m();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mqq process: ");
      localStringBuilder.append((String)localObject);
      util.LOGI(localStringBuilder.toString(), "");
      if (!((String)localObject).endsWith(":MSF")) {
        return sendRPCData(paramArrayOfByte, paramInt);
      }
    }
    try
    {
      util.LOGI("msf sendData", "");
      localObject = Class.forName(CLIENT_CLASSNAME);
      int i = Integer.valueOf(((Class)localObject).getMethod("sendData", new Class[] { WUserSigInfo.class, String.class, String.class, [B.class, Integer.TYPE, Boolean.TYPE, WtloginMsfListener.class }).invoke(localObject, new Object[] { this.userSigInfo, this.uin, this.serviceCmd, paramArrayOfByte.clone(), Integer.valueOf(paramInt), Boolean.valueOf(this.flag), this }).toString()).intValue();
      paramInt = i;
      if (i > 0)
      {
        this.semp.acquire();
        return i;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      util.printException(paramArrayOfByte, this.uin);
      paramInt = -1000;
    }
    return paramInt;
  }
  
  public int getRet()
  {
    return this.ret;
  }
  
  public byte[] getRetData()
  {
    return this.ret_data;
  }
  
  public void onReceiveData(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.ret_success = true;
    this.ret_uin = paramString1;
    this.ret_serviceCmd = paramString2;
    this.ret = 0;
    this.ret_data = paramArrayOfByte;
    this.semp.release();
  }
  
  public void onReceiveFail(String paramString1, String paramString2, int paramInt)
  {
    this.ret_success = false;
    this.ret_uin = paramString1;
    this.ret_serviceCmd = paramString2;
    this.ret = paramInt;
    this.semp.release();
  }
  
  public void run()
  {
    try
    {
      this.ret = SendData(this.data, this.timeout);
      if (this.ret <= 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("msf request send data failed, ret=");
        localStringBuilder.append(this.ret);
        util.LOGI(localStringBuilder.toString(), "");
        return;
      }
      if (RecvData() == null) {
        this.ret_data = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginMsfListener
 * JD-Core Version:    0.7.0.1
 */