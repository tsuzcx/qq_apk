package com.tencent.mobileqq.mediafocus;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class MediaFocusIpcClient
  extends QIPCModule
{
  public static boolean a = false;
  private boolean b = false;
  private String c;
  
  private MediaFocusIpcClient()
  {
    super("MediaFocusModuleClient");
    c();
  }
  
  public static MediaFocusIpcClient a()
  {
    return MediaFocusIpcClient.Holder.a();
  }
  
  public static void b()
  {
    MediaFocusIpcClient localMediaFocusIpcClient = a();
    if (!a)
    {
      QIPCClientHelper.getInstance().register(localMediaFocusIpcClient);
      a = true;
    }
  }
  
  private void c()
  {
    QIPCClientHelper.getInstance().getClient().connect(new MediaFocusIpcClient.1(this));
    QIPCClientHelper.getInstance().getClient().addListener(new MediaFocusIpcClient.2(this));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("action = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", params = ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("MediaFocusIpcClient", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    if ("actionCheckItemExist".equals(paramString))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      paramString = (MediaFocusStackItem)paramBundle.getParcelable("focusItem");
      boolean bool = false;
      if (paramString != null) {
        bool = MediaFocusManager.b().a(paramString.b(), paramString.c());
      }
      ((Bundle)localObject).putBoolean("isItemExist", bool);
      ((Bundle)localObject).putBoolean("isConnected", this.b);
      ((Bundle)localObject).putParcelable("focusItem", paramString);
    }
    return EIPCResult.createSuccessResult((Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusIpcClient
 * JD-Core Version:    0.7.0.1
 */