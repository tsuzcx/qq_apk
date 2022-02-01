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
  public static boolean a;
  private String a;
  private boolean b = false;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  private MediaFocusIpcClient()
  {
    super("MediaFocusModuleClient");
    b();
  }
  
  public static MediaFocusIpcClient a()
  {
    return MediaFocusIpcClient.Holder.a();
  }
  
  public static void a()
  {
    MediaFocusIpcClient localMediaFocusIpcClient = a();
    if (!jdField_a_of_type_Boolean)
    {
      QIPCClientHelper.getInstance().register(localMediaFocusIpcClient);
      jdField_a_of_type_Boolean = true;
    }
  }
  
  private void b()
  {
    QIPCClientHelper.getInstance().getClient().connect(new MediaFocusIpcClient.1(this));
    QIPCClientHelper.getInstance().getClient().addListener(new MediaFocusIpcClient.2(this));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    Bundle localBundle = new Bundle();
    if ("actionCheckItemExist".equals(paramString))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      paramString = (MediaFocusStackItem)paramBundle.getParcelable("focusItem");
      boolean bool = false;
      if (paramString != null) {
        bool = MediaFocusManager.a().a(paramString.a(), paramString.b());
      }
      localBundle.putBoolean("isItemExist", bool);
      localBundle.putBoolean("isConnected", this.b);
      localBundle.putParcelable("focusItem", paramString);
    }
    return EIPCResult.createSuccessResult(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusIpcClient
 * JD-Core Version:    0.7.0.1
 */